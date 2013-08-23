package xlogisticzz.learningModding.TileEntites;

import xlogisticzz.learningModding.Blocks.ModBlocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class TileEntityBomb extends TileEntity {
    
    private static final int SPREAD_TIME = 7;
    private static final int SPREAD_LEVELS = 30;
    
    private int timer;
    private int spreadLevel;

    public TileEntityBomb() {
        timer = SPREAD_TIME;
        spreadLevel = 0;
    }
    
    public boolean isBlockIdle() {
        return timer < 0;
    }
    
    @Override
    public void updateEntity() {
        
        if (!worldObj.isRemote) {
        
            if (timer == 0 && spreadLevel < SPREAD_LEVELS) {
                spread(xCoord + 1, yCoord, zCoord);
                spread(xCoord - 1, yCoord, zCoord);
                spread(xCoord, yCoord, zCoord + 1);
                spread(xCoord, yCoord, zCoord - 1);
                worldObj.setBlockMetadataWithNotify(xCoord, yCoord, zCoord, 1, 3);
            }else if (timer == SPREAD_TIME * (spreadLevel - SPREAD_LEVELS)) {
                worldObj.createExplosion(null, xCoord + 0.5, yCoord + 0.5, zCoord + 0.5, 4, true);
            }
            
            timer--;
        
        }
    }
    
    private void spread(int x, int y, int z) {
        if (worldObj.isAirBlock(x, y, z)) {
            worldObj.setBlock(x, y, z, ModBlocks.bomb.blockID);
            
            TileEntityBomb bomb = (TileEntityBomb)worldObj.getBlockTileEntity(x, y, z);
            bomb.spreadLevel = spreadLevel + 1;
        }
    }
    
    public void writeToNBT(NBTTagCompound NBTTagCompound){
        super.writeToNBT(NBTTagCompound);
        
        NBTTagCompound.setShort("Timer", (short)timer);
        NBTTagCompound.setByte("Level", (byte)spreadLevel);
    }
    
    
    public void readFromNBT(NBTTagCompound NBTTagCompound){
        super.readFromNBT(NBTTagCompound);
        
        timer = NBTTagCompound.getShort("Timer");
        spreadLevel = NBTTagCompound.getByte("Level");
    }

}
