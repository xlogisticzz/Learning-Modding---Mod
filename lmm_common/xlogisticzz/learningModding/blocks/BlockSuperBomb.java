package xlogisticzz.learningModding.Blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import xlogisticzz.learningModding.LearningModdingCreativeTab;
import xlogisticzz.learningModding.Lib.Constants;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class BlockSuperBomb extends Block {

    public BlockSuperBomb(int par1) {
        super(par1, Material.tnt);
        this.setCreativeTab(LearningModdingCreativeTab.tabLearningModding);
        this.setHardness(2.4F);
        this.setStepSound(Block.soundPowderFootstep);
        this.setUnlocalizedName(Constants.UnLocalisedNames.SUPER_BOMB);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister register) {
        blockIcon = register.registerIcon(Constants.Mod.MODID + ":" + Constants.Icons.SUPER_BOMB);

    }
    
    

    @Override
    public void onNeighborBlockChange(World world, int x, int y, int z, int id) {
        if (!world.isRemote && world.isBlockIndirectlyGettingPowered(x, y, z)){
            world.createExplosion(null, x + 0.5, y + 0.5, z + 0.5, 30, true);
        }
    }
    
    @Override
    public boolean onBlockActivated(World par1World, int x, int y, int z, EntityPlayer par5EntityPlayer, int side, float offsetX, float offsetY, float offsetZ) {
        if (!par1World.isRemote) {

            par1World.createExplosion(null, x + 0.5, y + 0.5, z + 0.5, 30, true);
            
        }
        return true;
    }
}
