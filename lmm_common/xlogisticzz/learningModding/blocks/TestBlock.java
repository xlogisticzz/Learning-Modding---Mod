package xlogisticzz.learningModding.blocks;

import xlogisticzz.learningModding.creativeTab.CreativeTab;
import xlogisticzz.learningModding.lib.Constants;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;

public class TestBlock extends Block {

    private Icon[] icons;
    public TestBlock(int par1) {
        super(par1, Material.iron);
        this.setCreativeTab(CreativeTab.tabLearningModding);
        this.setUnlocalizedName(Constants.UnLocalisedNames.TEST_BLOCK);

    }
    
    @Override
    public boolean renderAsNormalBlock () {
        return false;
    }

    @Override
    public int getRenderBlockPass () {
        return 0;
    }
    
    @Override
    public Icon getIcon(int par1 , int par2){
        return icons[0];
        
    }

    @Override
    public Icon getBlockTexture(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5) {
               
        switch(par5){
            
            //bottom
            case 0 :    
                return icons[0];
            //top
            case 1 :
                return icons[1];
            //?
            case 2 :
                return icons[2];
            //?
            case 3 :
                return icons[3];
            //?    
            case 4 :
                return icons[4];
            //?    
            case 5 :
                return icons[5];                
             default :
                 
                 return icons[0];
        }
    }
    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1IconRegister) {
        icons = new Icon[6];
        
        for(int i = 0 ; i< Constants.Icons.TEST.length; i++){
            icons[i] = par1IconRegister.registerIcon(Constants.Mod.MODID + ":glass/" + Constants.Icons.TEST[i]);
        }
    }
    
}
