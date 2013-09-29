package com.xlogisticzz.learningModding.tileEntites;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

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

public class TileEntityClicker extends TileEntity {
    
    private int clickOffset = 0;
    
    public void attackButton(boolean isAttackButton) {
    
        if (isAttackButton){
            clickOffset = clickOffset - 1;
        }else{
            clickOffset = clickOffset + 1;
        }
        if (clickOffset >= 15){
            worldObj.setBlockMetadataWithNotify(xCoord, yCoord, zCoord, 15, 3);
        }else if (clickOffset <= -7){
            worldObj.setBlockMetadataWithNotify(xCoord, yCoord, zCoord, 0, 3);
        }
        
        switch (clickOffset) {
            case -7 :
                worldObj.setBlockMetadataWithNotify(xCoord, yCoord, zCoord, 0, 3);
                break;
            case -6 :
                worldObj.setBlockMetadataWithNotify(xCoord, yCoord, zCoord, 1, 3);
                break;
            case -5 :
                worldObj.setBlockMetadataWithNotify(xCoord, yCoord, zCoord, 2, 3);
                break;
            case -4 :
                worldObj.setBlockMetadataWithNotify(xCoord, yCoord, zCoord, 3, 3);
                break;
            case -3 :
                worldObj.setBlockMetadataWithNotify(xCoord, yCoord, zCoord, 4, 3);
                break;
            case -2 :
                worldObj.setBlockMetadataWithNotify(xCoord, yCoord, zCoord, 5, 3);
                break;
            case -1 :
                worldObj.setBlockMetadataWithNotify(xCoord, yCoord, zCoord, 6, 3);
                break;
            case 0 :
                worldObj.setBlockMetadataWithNotify(xCoord, yCoord, zCoord, 7, 3);
                break;
            case 1 :
                worldObj.setBlockMetadataWithNotify(xCoord, yCoord, zCoord, 8, 3);
                break;
            case 2 :
                worldObj.setBlockMetadataWithNotify(xCoord, yCoord, zCoord, 9, 3);
                break;
            case 3 :
                worldObj.setBlockMetadataWithNotify(xCoord, yCoord, zCoord, 10, 3);
                break;
            case 4 :
                worldObj.setBlockMetadataWithNotify(xCoord, yCoord, zCoord, 11, 3);
                break;
            case 5 :
                worldObj.setBlockMetadataWithNotify(xCoord, yCoord, zCoord, 12, 3);
                break;
            case 6 :
                worldObj.setBlockMetadataWithNotify(xCoord, yCoord, zCoord, 13, 3);
                break;
            case 7 :
                worldObj.setBlockMetadataWithNotify(xCoord, yCoord, zCoord, 14, 3);
                break;
            case 8 :
                worldObj.setBlockMetadataWithNotify(xCoord, yCoord, zCoord, 15, 3);
                break;
        
        }
        
    }
    
    @Override
    public void writeToNBT(NBTTagCompound compound) {
    
        super.writeToNBT(compound);
        
        compound.setInteger("ClickOffset", clickOffset);
    }
    
    @Override
    public void readFromNBT(NBTTagCompound compound) {
    
        super.readFromNBT(compound);
        
        clickOffset = compound.getInteger("ClickOffset");
        
    }
    
}
