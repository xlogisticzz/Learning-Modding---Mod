package xlogisticzz.learningModding.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import xlogisticzz.learningModding.creativeTab.CreativeTab;
import xlogisticzz.learningModding.lib.Constants;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class GlassConnected extends Block {

    public int render;
    private Icon[] icons;

    public GlassConnected(int par1, boolean par2) {
        super(par1, Material.glass);
        this.setStepSound(soundGlassFootstep);
        this.setCreativeTab(CreativeTab.tabLearningModding);
        render = par2 ? 1 : 0;
        this.setUnlocalizedName(Constants.UnLocalisedNames.GLASS_CONNECTED);
        this.setHardness(0.4f);
    }

    @Override
    public boolean isOpaqueCube () {
        return false;
    }

    @Override
    public boolean renderAsNormalBlock () {
        return false;
    }

    @Override
    public int getRenderBlockPass () {
        return render;
    }
    
    @Override
    public boolean shouldSideBeRendered (IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5) {
        int id = par1IBlockAccess.getBlockId(par2, par3, par4);
        return id == this.blockID ? false : super.shouldSideBeRendered(par1IBlockAccess, par2, par3, par4, par5);
    }
     
     @Override
     public Icon getIcon(int par1 , int par2){
         return icons[0];
         
     }

     @Override
     @SideOnly(Side.CLIENT)
     public void registerIcons(IconRegister par1IconRegister) {
         icons = new Icon[Constants.Icons.GLASS_CONNECTED.length];
         
         for(int i = 0 ; i< Constants.Icons.GLASS_CONNECTED.length; i++){
             icons[i] = par1IconRegister.registerIcon(Constants.Mod.MODID + ":glass/png/" + Constants.Icons.GLASS_CONNECTED[i]);
         }
     }
    
    public boolean shouldConnect(int par1) {
       
        return par1 == this.blockID;
    }
    
    // Args: iBlockAccess, x, y, z, side(0 == bottom, 1 == top , 2 == north , 3 == south , 4 == west, 5 == east)
    @Override
    public Icon getBlockTexture(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5) {
        
        return getConnectedBlockTexture(par1IBlockAccess, par2, par3, par4, par5, icons);
    }
     
   public Icon getConnectedBlockTexture (IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5, Icon[] icons) {
        boolean isOpenUp = false, isOpenDown = false, isOpenLeft = false, isOpenRight = false;
        
        switch(par5){
            
            //bottom
            case 0 : 
                if (shouldConnect(par1IBlockAccess.getBlockId(par2, par3, par4 - 1))) {
                    isOpenUp = true;
                }
                if (shouldConnect(par1IBlockAccess.getBlockId(par2, par3, par4 + 1))) {
                    isOpenDown = true;
                }
                if (shouldConnect(par1IBlockAccess.getBlockId(par2 - 1, par3, par4))) {
                    isOpenLeft = true;
                }
                if (shouldConnect(par1IBlockAccess.getBlockId(par2 + 1, par3, par4))) {
                    isOpenRight = true;
                }
                if(isOpenDown && isOpenUp && isOpenLeft && isOpenRight){
                    return icons[15];
                }
                else if(isOpenUp && isOpenLeft && isOpenRight){
                    return icons[14];
                }
                else if(isOpenUp && isOpenDown && isOpenRight){
                    return icons[13];
                }
                else if(isOpenUp && isOpenDown && isOpenLeft){
                    return icons[12];
                }
                else if(isOpenDown && isOpenLeft && isOpenRight){
                    return icons[11];
                }
                else if(isOpenUp && isOpenRight){
                    return icons[10];
                }
                else if(isOpenUp && isOpenLeft){
                    return icons[9];
                }
                else if(isOpenUp && isOpenDown){
                    return icons[8];
                }
                else if(isOpenLeft && isOpenRight){
                    return icons[7];
                }
                else if(isOpenDown && isOpenRight){
                    return icons[6];
                }
                else if(isOpenDown && isOpenLeft){
                    return icons[5];
                }
                else if(isOpenUp){
                    return icons[4];
                }
                else if(isOpenRight){
                    return icons[3];
                }
                else if(isOpenLeft){
                    return icons[2];
                }
                else if(isOpenDown){
                    return icons[1];
                }
                break;
            //top
            case 1 :
                if (shouldConnect(par1IBlockAccess.getBlockId(par2, par3, par4 - 1))) {
                    isOpenUp = true;
                }
                if (shouldConnect(par1IBlockAccess.getBlockId(par2, par3, par4 + 1))) {
                    isOpenDown = true;
                }
                if (shouldConnect(par1IBlockAccess.getBlockId(par2 - 1, par3, par4))) {
                    isOpenLeft = true;
                }
                if (shouldConnect(par1IBlockAccess.getBlockId(par2 + 1, par3, par4))) {
                    isOpenRight = true;
                }
                if(isOpenDown && isOpenUp && isOpenLeft && isOpenRight){
                    return icons[15];
                }
                else if(isOpenUp && isOpenLeft && isOpenRight){
                    return icons[14];
                }
                else if(isOpenUp && isOpenDown && isOpenRight){
                    return icons[13];
                }
                else if(isOpenUp && isOpenDown && isOpenLeft){
                    return icons[12];
                }
                else if(isOpenDown && isOpenLeft && isOpenRight){
                    return icons[11];
                }
                else if(isOpenUp && isOpenRight){
                    return icons[10];
                }
                else if(isOpenUp && isOpenLeft){
                    return icons[9];
                }
                else if(isOpenUp && isOpenDown){
                    return icons[8];
                }
                else if(isOpenLeft && isOpenRight){
                    return icons[7];
                }
                else if(isOpenDown && isOpenRight){
                    return icons[6];
                }
                else if(isOpenDown && isOpenLeft){
                    return icons[5];
                }
                else if(isOpenUp){
                    return icons[4];
                }
                else if(isOpenRight){
                    return icons[3];
                }
                else if(isOpenLeft){
                    return icons[2];
                }
                else if(isOpenDown){
                    return icons[1];
                }
                break;
            //?
            case 2 :
                if (shouldConnect(par1IBlockAccess.getBlockId(par2, par3 + 1, par4))) {
                    isOpenUp = true;
                }
                if (shouldConnect(par1IBlockAccess.getBlockId(par2, par3 - 1, par4))) {
                    isOpenDown = true;
                }
                if (shouldConnect(par1IBlockAccess.getBlockId(par2 + 1, par3, par4))) {
                    isOpenLeft = true;
                }
                if (shouldConnect(par1IBlockAccess.getBlockId(par2 - 1, par3, par4))) {
                    isOpenRight = true;
                }
                if(isOpenDown && isOpenUp && isOpenLeft && isOpenRight){
                    return icons[15];
                }
                else if(isOpenUp && isOpenLeft && isOpenRight){
                    return icons[14];
                }
                else if(isOpenUp && isOpenDown && isOpenRight){
                    return icons[13];
                }
                else if(isOpenUp && isOpenDown && isOpenLeft){
                    return icons[12];
                }
                else if(isOpenDown && isOpenLeft && isOpenRight){
                    return icons[11];
                }
                else if(isOpenUp && isOpenRight){
                    return icons[10];
                }
                else if(isOpenUp && isOpenLeft){
                    return icons[9];
                }
                else if(isOpenUp && isOpenDown){
                    return icons[8];
                }
                else if(isOpenLeft && isOpenRight){
                    return icons[7];
                }
                else if(isOpenDown && isOpenRight){
                    return icons[6];
                }
                else if(isOpenDown && isOpenLeft){
                    return icons[5];
                }
                else if(isOpenUp){
                    return icons[4];
                }
                else if(isOpenRight){
                    return icons[3];
                }
                else if(isOpenLeft){
                    return icons[2];
                }
                else if(isOpenDown){
                    return icons[1];
                }
                break;
            //?
            case 3 :
                if (shouldConnect(par1IBlockAccess.getBlockId(par2, par3 + 1, par4))) {
                    isOpenUp = true;
                }
                if (shouldConnect(par1IBlockAccess.getBlockId(par2, par3 - 1, par4))) {
                    isOpenDown = true;
                }
                if (shouldConnect(par1IBlockAccess.getBlockId(par2 - 1, par3, par4))) {
                    isOpenLeft = true;
                }
                if (shouldConnect(par1IBlockAccess.getBlockId(par2 + 1, par3, par4))) {
                    isOpenRight = true;
                }
                if(isOpenDown && isOpenUp && isOpenLeft && isOpenRight){
                    return icons[15];
                }
                else if(isOpenUp && isOpenLeft && isOpenRight){
                    return icons[14];
                }
                else if(isOpenUp && isOpenDown && isOpenRight){
                    return icons[13];
                }
                else if(isOpenUp && isOpenDown && isOpenLeft){
                    return icons[12];
                }
                else if(isOpenDown && isOpenLeft && isOpenRight){
                    return icons[11];
                }
                else if(isOpenUp && isOpenRight){
                    return icons[10];
                }
                else if(isOpenUp && isOpenLeft){
                    return icons[9];
                }
                else if(isOpenUp && isOpenDown){
                    return icons[8];
                }
                else if(isOpenLeft && isOpenRight){
                    return icons[7];
                }
                else if(isOpenDown && isOpenRight){
                    return icons[6];
                }
                else if(isOpenDown && isOpenLeft){
                    return icons[5];
                }
                else if(isOpenUp){
                    return icons[4];
                }
                else if(isOpenRight){
                    return icons[3];
                }
                else if(isOpenLeft){
                    return icons[2];
                }
                else if(isOpenDown){
                    return icons[1];
                }
                break;
            //?    
            case 4 :
                if (shouldConnect(par1IBlockAccess.getBlockId(par2, par3 + 1, par4))) {
                    isOpenUp = true;
                }
                if (shouldConnect(par1IBlockAccess.getBlockId(par2, par3 - 1, par4))) {
                    isOpenDown = true;
                }
                if (shouldConnect(par1IBlockAccess.getBlockId(par2, par3, par4 - 1))) {
                    isOpenLeft = true;
                }
                if (shouldConnect(par1IBlockAccess.getBlockId(par2, par3, par4 + 1))) {
                    isOpenRight = true;
                }
                if(isOpenDown && isOpenUp && isOpenLeft && isOpenRight){
                    return icons[15];
                }
                else if(isOpenUp && isOpenLeft && isOpenRight){
                    return icons[14];
                }
                else if(isOpenUp && isOpenDown && isOpenRight){
                    return icons[13];
                }
                else if(isOpenUp && isOpenDown && isOpenLeft){
                    return icons[12];
                }
                else if(isOpenDown && isOpenLeft && isOpenRight){
                    return icons[11];
                }
                else if(isOpenUp && isOpenRight){
                    return icons[10];
                }
                else if(isOpenUp && isOpenLeft){
                    return icons[9];
                }
                else if(isOpenUp && isOpenDown){
                    return icons[8];
                }
                else if(isOpenLeft && isOpenRight){
                    return icons[7];
                }
                else if(isOpenDown && isOpenRight){
                    return icons[6];
                }
                else if(isOpenDown && isOpenLeft){
                    return icons[5];
                }
                else if(isOpenUp){
                    return icons[4];
                }
                else if(isOpenRight){
                    return icons[3];
                }
                else if(isOpenLeft){
                    return icons[2];
                }
                else if(isOpenDown){
                    return icons[1];
                }
                break;
            //?    
            case 5 :
                if (shouldConnect(par1IBlockAccess.getBlockId(par2, par3 + 1, par4))) {
                    isOpenUp = true;
                }
                if (shouldConnect(par1IBlockAccess.getBlockId(par2, par3 - 1, par4))) {
                    isOpenDown = true;
                }
                if (shouldConnect(par1IBlockAccess.getBlockId(par2, par3, par4 + 1))) {
                    isOpenLeft = true;
                }
                if (shouldConnect(par1IBlockAccess.getBlockId(par2, par3, par4 - 1))) {
                    isOpenRight = true;
                }
                if(isOpenDown && isOpenUp && isOpenLeft && isOpenRight){
                    return icons[15];
                }
                else if(isOpenUp && isOpenLeft && isOpenRight){
                    return icons[14];
                }
                else if(isOpenUp && isOpenDown && isOpenRight){
                    return icons[13];
                }
                else if(isOpenUp && isOpenDown && isOpenLeft){
                    return icons[12];
                }
                else if(isOpenDown && isOpenLeft && isOpenRight){
                    return icons[11];
                }
                else if(isOpenUp && isOpenRight){
                    return icons[10];
                }
                else if(isOpenUp && isOpenLeft){
                    return icons[9];
                }
                else if(isOpenUp && isOpenDown){
                    return icons[8];
                }
                else if(isOpenLeft && isOpenRight){
                    return icons[7];
                }
                else if(isOpenDown && isOpenRight){
                    return icons[6];
                }
                else if(isOpenDown && isOpenLeft){
                    return icons[5];
                }
                else if(isOpenUp){
                    return icons[4];
                }
                else if(isOpenRight){
                    return icons[3];
                }
                else if(isOpenLeft){
                    return icons[2];
                }
                else if(isOpenDown){
                    return icons[1];
                }
                break;                
                 
        }
        return icons[0];
    }

    
    
   
   
    }
    