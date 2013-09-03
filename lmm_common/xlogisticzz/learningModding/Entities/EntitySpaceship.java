package xlogisticzz.learningModding.Entities;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;
import xlogisticzz.learningModding.Network.PacketHandler;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteArrayDataOutput;

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
    public boolean canBeCollidedWith() {
    
        return !isDead;
    }
    
    @Override
    public boolean func_130002_c(EntityPlayer player) {
    
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
            if (riddenByEntity != null){
                motionY = 0.2;
            }else if (worldObj.isAirBlock((int) posX, (int) posY - 1, (int) posZ)){
                motionY = -0.2;
            }else{
                motionY = 0;
            }
            
        }else{
            sendInfo();
        }
        
        this.setPosition(posX + motionX, posY + motionY, posZ + motionZ);
        
    }
    
    private boolean lastPressedState;
    
    private void sendInfo() {
    
        boolean state = Minecraft.getMinecraft().gameSettings.keyBindJump.pressed;
        if (state && !lastPressedState && charged && riddenByEntity == Minecraft.getMinecraft().thePlayer){
            if (getAmmunitionAmount() == 0){
                Minecraft.getMinecraft().thePlayer.addChatMessage("You don't have enough ammo left");
            }else{
                PacketHandler.sendShipBombPacket(this);
            }
        }
        
        lastPressedState = state;
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
        }
    }
}
