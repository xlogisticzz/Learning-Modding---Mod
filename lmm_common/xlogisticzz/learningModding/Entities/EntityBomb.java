package xlogisticzz.learningModding.Entities;

import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import xlogisticzz.learningModding.Blocks.ModBlocks;
import xlogisticzz.learningModding.TileEntites.TileEntityBomb;

public class EntityBomb extends Entity {

    /* Main Constructor */
    public EntityBomb(World world) {
        super(world);
        
        motionY = -0.6;
    }
    
    /* Entity init */
    @Override
    protected void entityInit() {

    }
    
    /* Data to read from NBT */
    @Override
    protected void readEntityFromNBT(NBTTagCompound nbttagcompound) {

    }

    /* Data to write to NBT */
    @Override
    protected void writeEntityToNBT(NBTTagCompound nbttagcompound) {

    }
    
    /* When the entity updates */
    @Override
    public void onUpdate(){
        super.onUpdate();
        
        if(!worldObj.isRemote){
            if(worldObj.isAirBlock((int)posX, (int)posY, (int)posZ) && !worldObj.isAirBlock((int)posX, (int)posY - 1, (int)posZ)){
                worldObj.setBlock((int)posX, (int)posY, (int)posZ, ModBlocks.bomb.blockID);
                TileEntityBomb tile = (TileEntityBomb) worldObj.getBlockTileEntity((int)posX, (int)posY, (int)posZ);
                tile.setActive();
                this.setDead();
                
            }
        }
        
        this.setPosition(posX + motionX, posY + motionY, posZ + motionZ);
    }
}
