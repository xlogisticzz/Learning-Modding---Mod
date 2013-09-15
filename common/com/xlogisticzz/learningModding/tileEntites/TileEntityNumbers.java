package com.xlogisticzz.learningModding.tileEntites;

import net.minecraft.tileentity.TileEntity;

import com.xlogisticzz.learningModding.lib.Constants;
import com.xlogisticzz.learningModding.lib.Ids;

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

public class TileEntityNumbers extends TileEntity {
    
    private int number;
    private int tick;
    
    @Override
    public void updateEntity() {
    
        if (!worldObj.isRemote && ++tick == 20){
            number = (number + 1) % Constants.Misc.NUMBER_COUNT;
            worldObj.addBlockEvent(xCoord, yCoord, zCoord, Ids.NUMBER, 1, number);
            tick = 0;
        }
    }
    
    @Override
    public boolean receiveClientEvent(int id, int value) {
    
        if (worldObj.isRemote && id == 1){
            number = value;
            worldObj.markBlockForRenderUpdate(xCoord, yCoord, zCoord);
        }
        return true;
    }
    
    public int getNumber() {
    
        return number;
    }
    
}
