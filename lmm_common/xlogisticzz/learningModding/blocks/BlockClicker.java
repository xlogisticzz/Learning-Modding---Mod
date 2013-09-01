package xlogisticzz.learningModding.Blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import xlogisticzz.learningModding.LearningModdingCreativeTab;
import xlogisticzz.learningModding.Lib.Constants;
import xlogisticzz.learningModding.TileEntites.TileEntityClicker;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockClicker extends BlockContainer {

    /* Default Icon */
    @SideOnly(Side.CLIENT)
    public Icon clicker;

    /* Linked Icon */
    @SideOnly(Side.CLIENT)
    public Icon clickerLinked;

    /* Main Constructor */
    public BlockClicker(int par1) {
        super(par1, Material.iron);

        this.setCreativeTab(LearningModdingCreativeTab.tabLearningModding);
        this.setHardness(2.5F);
        this.setStepSound(Block.soundMetalFootstep);
        this.setUnlocalizedName(Constants.UnLocalisedNames.CLICKER);
    }

    /* When the block is attacked */
    @Override
    public void onBlockClicked(World world, int x, int y, int z, EntityPlayer player) {
        TileEntityClicker tile = (TileEntityClicker) world.getBlockTileEntity(x, y, z);

        tile.attackButton(true);

    }

    /* Can the block provide power */
    @Override
    public boolean canProvidePower() {
        return true;
    }

    /* Is the block providing power based upon the metadata*/
    @Override
    public int isProvidingWeakPower(IBlockAccess par1IBlockAccess, int x, int y, int z, int side) {
        return par1IBlockAccess.getBlockMetadata(x, y, z);
    }

    /* When the block is left clicked */
    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
        if (player.isSneaking()) {
            return false;
        } else {
            TileEntityClicker tile = (TileEntityClicker) world.getBlockTileEntity(x, y, z);
            tile.attackButton(false);
            return true;
        }
    }

    /* Registering the Icons */
    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister register) {
        clicker = register.registerIcon(Constants.Mod.MODID + ":" + Constants.Icons.CLICKER);
        clickerLinked = register.registerIcon(Constants.Mod.MODID + ":" + Constants.Icons.CLICKER_LINKED);

    }

    /* Get the icon based upon the icon */
    @Override
    @SideOnly(Side.CLIENT)
    public Icon getIcon(int side, int metadata) {
        return metadata == 7 ? clickerLinked : clicker;
    }

    /* Register Tile Entities */
    @Override
    public TileEntity createNewTileEntity(World world) {
        return new TileEntityClicker();
    }

}
