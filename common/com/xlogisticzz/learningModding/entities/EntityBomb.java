package com.xlogisticzz.learningModding.entities;

import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

import com.xlogisticzz.learningModding.blocks.ModBlocks;
import com.xlogisticzz.learningModding.tileEntites.TileEntityBomb;

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

public class EntityBomb extends Entity {
    
    public EntityBomb(World world) {
    
        super(world);
        
        motionY = -0.6;
    }
    
    @Override
    protected void entityInit() {
    
    }
    
    @Override
    protected void readEntityFromNBT(NBTTagCompound nbttagcompound) {
    
    }
    
    @Override
    protected void writeEntityToNBT(NBTTagCompound nbttagcompound) {
    
    }
    
    @Override
    public void onUpdate() {
    
        super.onUpdate();
        
        if (!worldObj.isRemote){
            if (worldObj.isAirBlock((int) posX, (int) posY, (int) posZ) && !worldObj.isAirBlock((int) posX, (int) posY - 1, (int) posZ)){
                worldObj.setBlock((int) posX, (int) posY, (int) posZ, ModBlocks.bomb.blockID);
                TileEntityBomb tile = (TileEntityBomb) worldObj.getBlockTileEntity((int) posX, (int) posY, (int) posZ);
                tile.setActive();
                this.setDead();
                
            }
        }
        
        this.setPosition(posX + motionX, posY + motionY, posZ + motionZ);
    }
}
