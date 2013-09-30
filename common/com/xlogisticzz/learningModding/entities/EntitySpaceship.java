package com.xlogisticzz.learningModding.entities;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteArrayDataOutput;
import com.xlogisticzz.learningModding.client.sounds.Sounds;
import com.xlogisticzz.learningModding.network.PacketHandler;

import cpw.mods.fml.common.registry.IEntityAdditionalSpawnData;

/**
 * Learning Modding Mod
 * 
 * @author xLoGisTicZz.
 * 
 *         Some code may be from tutorials.
 * 
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */

public class EntitySpaceship extends Entity implements IEntityAdditionalSpawnData {
    
    private boolean charged;
    
    public EntitySpaceship(World world) {
        
        super(world);
        this.setSize(1.5F, 0.6F);
    }
    
    @Override
    protected void entityInit() {
        
        dataWatcher.addObject(15, 10);
    }
    
    public int getAmmunitionAmount() {
        
        return dataWatcher.getWatchableObjectInt(15);
        
    }
    
    public void setAmmunitionAmount(int ammo) {
        
        dataWatcher.updateObject(15, ammo);
    }
    
    public boolean isCharged() {
        
        return charged;
    }
    
    public void setCharged(boolean charge) {
        
        charged = charge;
    }
    
    @Override
    public AxisAlignedBB getBoundingBox() {
        
        return boundingBox;
    }
    
    @Override
    public AxisAlignedBB getCollisionBox(Entity entity) {
        
        if (entity != riddenByEntity){
            return entity.getBoundingBox();
        }else{
            return null;
        }
    }
    
    @Override
    public boolean canBePushed() {
        
        return true;
    }
    
    @Override
    public boolean canBeCollidedWith() {
        
        return !isDead;
    }
    
    @Override
    public boolean interactFirst(EntityPlayer player) {
        
        if (!worldObj.isRemote && riddenByEntity == null){
            player.mountEntity(this);
            
        }
        return true;
    }
    
    @Override
    public double getMountedYOffset() {
        
        return -0.15;
    }
    
    @Override
    public void onUpdate() {
        
        super.onUpdate();
        
        if (!worldObj.isRemote){
            if (riddenByEntity == null && worldObj.isAirBlock((int) posX, (int) posY - 1, (int) posZ)){
                motionY = -0.3F;
            }else{
                motionY = 0F;
            }
        }else{
            sendInfo();
        }
        
        motionX = motionX / 1.1;
        motionY = motionY / 1.1;
        motionZ = motionZ / 1.1;
        
        this.setPosition(posX + motionX, posY + motionY, posZ + motionZ);
        
    }
    
    private boolean lastPressedBombState;
    
    private void sendInfo() {
        
        boolean bombState = Minecraft.getMinecraft().gameSettings.keyBindAttack.pressed;
        if (bombState && !lastPressedBombState && charged && riddenByEntity == Minecraft.getMinecraft().thePlayer){
            if (getAmmunitionAmount() == 0){
                Minecraft.getMinecraft().thePlayer.addChatMessage("You don't have enough ammo left");
                Sounds.OUT_OF_AMMO.play(posX, posY, posZ, 1, 0);
            }else{
                PacketHandler.sendShipBombPacket(this);
            }
        }
        lastPressedBombState = bombState;
        
        boolean forwardState = Minecraft.getMinecraft().gameSettings.keyBindForward.pressed;
        if (forwardState && charged && riddenByEntity == Minecraft.getMinecraft().thePlayer){
            PacketHandler.sendShipForwardPacket(this);
        }
        
        boolean backwardState = Minecraft.getMinecraft().gameSettings.keyBindBack.pressed;
        if (backwardState && charged && riddenByEntity == Minecraft.getMinecraft().thePlayer){
            PacketHandler.sendShipBackwardPacket(this);
            
        }
        
        boolean UpState = Minecraft.getMinecraft().gameSettings.keyBindJump.pressed;
        if (UpState && charged && riddenByEntity == Minecraft.getMinecraft().thePlayer){
            PacketHandler.sendShipUpPacket(this);
        }
        
        boolean DownState = Minecraft.getMinecraft().gameSettings.keyBindDrop.pressed;
        if (DownState && charged && riddenByEntity == Minecraft.getMinecraft().thePlayer){
            PacketHandler.sendShipDownPacket(this);
        }
        
    }
    
    @Override
    protected void readEntityFromNBT(NBTTagCompound compound) {
        
        charged = compound.getBoolean("charged");
        setAmmunitionAmount(compound.getByte("ammo"));
    }
    
    @Override
    protected void writeEntityToNBT(NBTTagCompound compound) {
        
        compound.setBoolean("charged", charged);
        compound.setByte("ammo", (byte) getAmmunitionAmount());
    }
    
    @Override
    public void writeSpawnData(ByteArrayDataOutput data) {
        
        data.writeBoolean(charged);
    }
    
    @Override
    public void readSpawnData(ByteArrayDataInput data) {
        
        charged = data.readBoolean();
    }
    
    public void dropBomb() {
        
        if (getAmmunitionAmount() > 0){
            
            EntityBomb bomb = new EntityBomb(worldObj);
            
            bomb.posX = posX;
            bomb.posY = posY;
            bomb.posZ = posZ;
            
            worldObj.spawnEntityInWorld(bomb);
            setAmmunitionAmount(getAmmunitionAmount() - 1);
            Sounds.BOMB_DROP.play(posX, posY, posZ, 1, 0);
        }
    }
    
    @Override
    public boolean attackEntityFrom(DamageSource par1DamageSource, float par2) {
        
        if (!worldObj.isRemote && !isDead){
            if (this.isEntityInvulnerable()){
                return false;
            }else{
                this.setBeenAttacked();
                
                this.setDead();
                
                return true;
            }
        }
        return false;
    }
    
    public void forward() {
        
        float yaw = riddenByEntity.rotationYaw;
        
        if (yaw - 90 > 180){
            int num = (int) (yaw - 90 - 180);
            
            int newnum = -180 + num;
            
            this.setRotation(newnum, rotationPitch);
            
        }else{
            this.setRotation(yaw - 90, rotationPitch);
        }
        
        if(yaw >= 315 && yaw <= 0){
            if (motionZ < 10){
                motionZ = motionZ + 0.1F;
            }
        }else if(yaw >= 0 && yaw <= 45){
            if (motionZ < 10){
                motionZ = motionZ + 0.1F;
            }
        }else if(yaw >= 45 && yaw <= 135){
            if (motionX > -10){
                motionX = motionX - 0.1F;
            }
        }else if(yaw >= 135 && yaw <= 225){
            if (motionZ > -10){
                motionZ = motionZ - 0.1F;
            }
        }else if(yaw >= 225 && yaw <= 315){
            if (motionX < 10){
                motionX = motionX + 0.1F;
            }
        }
    }
    
    public void backward() {
        
        float yaw = riddenByEntity.rotationYaw;
        
        if(yaw >= 315 && yaw <= 360){
            if (motionZ > -10){
                motionZ = motionZ - 0.1F;
            }
        }else if(yaw >= 0 && yaw <= 45){
            if (motionZ > -10){
                motionZ = motionZ - 0.1F;
            }
        }else if(yaw >= 45 && yaw <= 135){
            if (motionX < 10){
                motionX = motionX + 0.1F;
            }
        }else if(yaw >= 135 && yaw <= 225){
            if (motionZ < 10){
                motionZ = motionZ + 0.1F;
            }
        }else if(yaw >= 225 && yaw <= 315){
            if (motionX > -10){
                motionX = motionX - 0.1F;
            }
        }
    }
    
    public void up() {
        
        if (motionY < 10){
            motionY = motionY + 0.1F;
        }
    }
    
    public void down() {
        
        if (motionY > -10){
            motionY = motionY - 0.1F;
        }
    }
}
