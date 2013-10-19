package com.xlogisticzz.learningModding.tileEntites;

import net.minecraft.client.Minecraft;
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
public class TileEntityNoteSequencer extends TileEntity {
    
    private int timer;
    private int noteNumber;
    public boolean active = false;

    
    private static String[] music = {
        "harp",
        "bd",
        "snare",
        "hat",
        "bassattack"
    };
    
    
    /* (non-Javadoc)
     * @see net.minecraft.tileentity.TileEntity#updateEntity()
     */
    @Override
    public void updateEntity() {
        if(!worldObj.isRemote && active){
            if(++timer == 5){
                int notePitch = noteNumber % 24;
                int instrument = noteNumber/24;
                
                String currentInst = "note." + music[instrument];
                float pitch = (float)Math.pow(2.0D,(notePitch - 12)/  12D);
                
                Minecraft.getMinecraft().sndManager.playSound(currentInst, xCoord + 0.5F, yCoord + 0.5F, zCoord + 0.5F, 1, pitch);
                
                noteNumber = (noteNumber + 1) % 120;
                timer = 0;


            }
        }
    }
    
    
    
    /* (non-Javadoc)
     * @see net.minecraft.tileentity.TileEntity#readFromNBT(net.minecraft.nbt.NBTTagCompound)
     */
    @Override
    public void readFromNBT(NBTTagCompound par1nbtTagCompound) {
    
        super.readFromNBT(par1nbtTagCompound);
        
        timer = par1nbtTagCompound.getByte("Timer");
        noteNumber = par1nbtTagCompound.getByte("Note");
        
    }
    
    
    /* (non-Javadoc)
     * @see net.minecraft.tileentity.TileEntity#writeToNBT(net.minecraft.nbt.NBTTagCompound)
     */
    @Override
    public void writeToNBT(NBTTagCompound par1nbtTagCompound) {
    
        super.writeToNBT(par1nbtTagCompound);
        
        par1nbtTagCompound.setByte("Timer", (byte)timer);
        par1nbtTagCompound.setByte("Note", (byte)noteNumber);
        
    }
    
    
    
}
