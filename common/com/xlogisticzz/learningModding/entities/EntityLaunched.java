package com.xlogisticzz.learningModding.entities;

import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

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
public class EntityLaunched extends Entity {
    
    private int startPosY;
    private boolean goingUp;
    
    public EntityLaunched(World par1World) {
    
        super(par1World);
        
    }
    
    @Override
    protected void entityInit() {
    
    }
    
    @Override
    protected void readEntityFromNBT(NBTTagCompound compound) {
    
        startPosY = compound.getInteger("StartPosY");
        goingUp = compound.getBoolean("GoingUp");
    }
    
    @Override
    protected void writeEntityToNBT(NBTTagCompound compound) {
    
        compound.setInteger("StartPosY", startPosY);
        compound.setBoolean("GoingUp", goingUp);
    }
    
    public void setlaunchPos(double x, double y, double z) {
    
        startPosY = (int) y;
        goingUp = true;
        
        this.setPosition(x, y, z);
    }
    
    @Override
    public void onUpdate() {
    
        super.onUpdate();
        
        if (!worldObj.isRemote){
            if (goingUp){
                motionY = 0.4F;
                if (posY > startPosY + 30){
                    goingUp = false;
                }
            }else{
                motionY = -1.8F;
                if (posY < startPosY){
                    worldObj.createExplosion(this, posX, posY, posZ, 6, true);
                    this.setDead();
                }
            }
            
        }
        setPosition(posX + motionX, posY + motionY, posZ + motionZ);
    }
}
