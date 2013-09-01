package xlogisticzz.learningModding.Entities;

import xlogisticzz.learningModding.Network.PacketHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteArrayDataOutput;

import cpw.mods.fml.common.registry.IEntityAdditionalSpawnData;

public class EntitySpaceship extends Entity implements IEntityAdditionalSpawnData{

    /* Is the spaceship charged or not */
    private boolean charged;
    
    /* Main constructor */
    public EntitySpaceship(World world) {
        super(world);
        this.setSize(1.5F, 0.6F);
    }
    
    /* Entity Init */
    /* Add info to data watcher */
    @Override
    protected void entityInit() {
        dataWatcher.addObject(15, (byte)10);
    }
    
    /* Get the Entities ammo from the data watcher */
    public int getAmmunitionAmount(){
        return dataWatcher.getWatchableObjectByte(15);
        
    }
    
    /* Set the Amount of ammo in the data watcher */
    public void setAmmunitionAmount(int ammo){
        dataWatcher.updateObject(15, ammo);
    }
    
    /* Return true if it is charged */
    public boolean isCharged(){
        return charged;
    }
    
    /* Set the entity to be charged */
    public void setCharged(boolean charge){
        charged = charge;
    }
    
    /* Get the bounding box */
    @Override
    public AxisAlignedBB getBoundingBox() {
        return boundingBox;
    }

    /* Get the collision box */
    @Override
    public AxisAlignedBB getCollisionBox(Entity entity) {
        if (entity != riddenByEntity) {
            return entity.getBoundingBox();
        } else {
            return null;
        }
    }

    /* The entity can be collided with if it is not dead */
    @Override
    public boolean canBeCollidedWith() {
        return !isDead;
    }

    /* When the entity is clicked on by the player make it ride the ship if noone else is in it */
    @Override
    public boolean func_130002_c(EntityPlayer player) {
        if (!worldObj.isRemote && riddenByEntity == null) {
            player.mountEntity(this);

        }
        return true;
    }

    /* Set the mountedYOffset to make the entity look like it is in the ship */
    @Override
    public double getMountedYOffset() {
        return -0.15;
    }

    
    /* When the entity is updated */
    @Override
    public void onUpdate() {
        super.onUpdate();
        
        if(!worldObj.isRemote){
            if(riddenByEntity != null){
                motionY = 0.2;
            }else if(worldObj.isAirBlock((int)posX, (int)posY - 1,(int) posZ)){
                motionY = -0.2;
            }else{
                motionY = 0;
            }
            
        }else{
            sendInfo();
        }

        this.setPosition(posX + motionX, posY + motionY, posZ + motionZ);

    }
    /* Weather the button was pressed before or not, to ensure that 10 bombs are not dropped when the button is pressed */
    private boolean lastPressedState;

    private void sendInfo() {
        boolean state = Minecraft.getMinecraft().gameSettings.keyBindJump.pressed;
        if(state && !lastPressedState && charged && riddenByEntity == Minecraft.getMinecraft().thePlayer){
            if(getAmmunitionAmount() == 0){
                Minecraft.getMinecraft().thePlayer.addChatMessage("You don't have enough ammo left");
            }else{
                PacketHandler.sendShipBombPacket(this);
            }
        }

        lastPressedState = state;
    }
    
    
    /* Read data from NBT */
    @Override
    protected void readEntityFromNBT(NBTTagCompound compound) {
        charged = compound.getBoolean("charged");
        setAmmunitionAmount(compound.getByte("ammo"));
    }

    /* Write data to NBT */
    @Override
    protected void writeEntityToNBT(NBTTagCompound compound) {
        compound.setBoolean("charged", charged);
        compound.setByte("ammo", (byte) getAmmunitionAmount());
    }
    
    /* Spawn Data write */ 
    @Override
    public void writeSpawnData(ByteArrayDataOutput data) {
        data.writeBoolean(charged);
    }

    /* Spawn data read */
    @Override
    public void readSpawnData(ByteArrayDataInput data) {
        charged = data.readBoolean();
    }
    
    /* Spawn Bomb entity */
    public void dropBomb() {
        if(getAmmunitionAmount() > 0){


            EntityBomb bomb = new EntityBomb(worldObj);

            bomb.posX = posX;
            bomb.posY = posY;
            bomb.posZ = posZ;

            worldObj.spawnEntityInWorld(bomb);
            setAmmunitionAmount(getAmmunitionAmount() - 1);
        }
    }
 }
