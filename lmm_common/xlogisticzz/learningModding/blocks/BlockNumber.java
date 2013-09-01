package xlogisticzz.learningModding.Blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import xlogisticzz.learningModding.LearningModdingCreativeTab;
import xlogisticzz.learningModding.Lib.Constants;
import xlogisticzz.learningModding.TileEntites.TileEntityNumbers;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockNumber extends BlockContainer { 
    
    /* Icons */
    @SideOnly(Side.CLIENT)
    private Icon[] icons;
    
    /* Main Constructor */
    protected BlockNumber(int id) {
        super(id, Material.rock);
        setCreativeTab(LearningModdingCreativeTab.tabLearningModding);
        setHardness(1F);
        setStepSound(Block.soundStoneFootstep);
        setUnlocalizedName(Constants.UnLocalisedNames.NUMBER);
    }
    
    /* Create Tile Entity when block is placed */
    @Override
    public TileEntity createNewTileEntity(World world) {
        return new TileEntityNumbers();
    }

    /* Register Icons */
    @SideOnly(Side.CLIENT)
    @Override
    public void registerIcons(IconRegister register) {
        icons = new Icon[Constants.Misc.NUMBER_COUNT];
        for (int i = 0; i < icons.length; i++) {
            icons[i] = register.registerIcon(Constants.Mod.MODID + ":numbers/" + Constants.Icons.NUMBERS[i]);
        }
    }

    /* Get block texture based on number variable in the tile entity */
    @Override
    @SideOnly(Side.CLIENT)
    public Icon getBlockTexture(IBlockAccess world, int x, int y, int z, int side) {
        TileEntityNumbers tile = (TileEntityNumbers) world.getBlockTileEntity(x, y, z);
        return icons[tile.getNumber()];
    }

    /* Default Icon */
    @Override
    @SideOnly(Side.CLIENT)
    public Icon getIcon(int side, int meta) {
        return icons[0];
    }
}
