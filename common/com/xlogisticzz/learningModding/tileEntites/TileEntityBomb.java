package com.xlogisticzz.learningModding.tileEntites;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

import com.xlogisticzz.learningModding.blocks.ModBlocks;
import com.xlogisticzz.learningModding.client.sounds.Sounds;

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

public class TileEntityBomb extends TileEntity {
    
    private static final int SPREAD_TIME = 7;
    private static final int SPREAD_LEVELS = 30;
    
    private int timer;
    private int spreadLevel;
    private boolean activated = false;
    private boolean spreaded = false;
    
    public TileEntityBomb() {
    
        timer = SPREAD_TIME;
        spreadLevel = 0;
    }
    
    public boolean isBlockIdle() {
    
        return timer < 0;
    }
    
    public void setActive() {
    
        activated = true;
    }
    
    @Override
    public void updateEntity() {
    
        if (!worldObj.isRemote){
            
            if (worldObj.isBlockIndirectlyGettingPowered(xCoord, yCoord, zCoord)){
                activated = true;
            }
            if (activated && spreaded == false){
                worldObj.setBlockMetadataWithNotify(xCoord, yCoord, zCoord, 2, 3);
                if (spreadLevel == 0){
                    worldObj.setBlockMetadataWithNotify(xCoord, yCoord, zCoord, 1, 3);
                }
            }
            if (timer == 0 && spreadLevel < SPREAD_LEVELS){
                spreaded = true;
                spread(xCoord + 1, yCoord, zCoord);
                spread(xCoord - 1, yCoord, zCoord);
                spread(xCoord, yCoord, zCoord + 1);
                spread(xCoord, yCoord, zCoord - 1);
                worldObj.setBlockMetadataWithNotify(xCoord, yCoord, zCoord, 3, 3);
                Sounds.BOMB_SPREAD.play(xCoord, yCoord, zCoord, 1, 0);
            }else if (timer == SPREAD_TIME * (spreadLevel - SPREAD_LEVELS)){
                worldObj.setBlockMetadataWithNotify(xCoord, yCoord, zCoord, 3, 3);
                worldObj.createExplosion(null, xCoord + 0.5, yCoord + 0.5, zCoord + 0.5, 4, true);
            }
            
            if (activated){
                timer--;
            }
        }
    }
    
    private void spread(int x, int y, int z) {
    
        if (worldObj.isAirBlock(x, y, z)){
            worldObj.setBlock(x, y, z, ModBlocks.bomb.blockID);
            
            TileEntityBomb bomb = (TileEntityBomb) worldObj.getBlockTileEntity(x, y, z);
            bomb.spreadLevel = spreadLevel + 1;
            bomb.activated = true;
        }
    }
    
    @Override
    public void writeToNBT(NBTTagCompound NBTTagCompound) {
    
        super.writeToNBT(NBTTagCompound);
        
        NBTTagCompound.setShort("Timer", (short) timer);
        NBTTagCompound.setByte("Level", (byte) spreadLevel);
        NBTTagCompound.setBoolean("Activated", activated);
        NBTTagCompound.setBoolean("Spreaded", spreaded);
    }
    
    @Override
    public void readFromNBT(NBTTagCompound NBTTagCompound) {
    
        super.readFromNBT(NBTTagCompound);
        
        timer = NBTTagCompound.getShort("Timer");
        spreadLevel = NBTTagCompound.getByte("Level");
        activated = NBTTagCompound.getBoolean("Activated");
        spreaded = NBTTagCompound.getBoolean("Spreaded");
    }
    
}
