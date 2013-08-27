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

    @SideOnly(Side.CLIENT)
    public Icon clicker;

    @SideOnly(Side.CLIENT)
    public Icon clickerLinked;

    public BlockClicker(int par1) {
        super(par1, Material.iron);

        this.setCreativeTab(LearningModdingCreativeTab.tabLearningModding);
        this.setHardness(2.5F);
        this.setStepSound(Block.soundMetalFootstep);
        this.setUnlocalizedName(Constants.UnLocalisedNames.CLICKER);
    }

    @Override
    public void onBlockClicked(World world, int x, int y, int z, EntityPlayer player) {
        TileEntityClicker tile = (TileEntityClicker) world.getBlockTileEntity(x, y, z);

        tile.attackButton(true);

    }

    @Override
    public boolean canProvidePower() {
        return true;
    }

    @Override
    public int isProvidingWeakPower(IBlockAccess par1IBlockAccess, int x, int y, int z, int side) {
        return par1IBlockAccess.getBlockMetadata(x, y, z);
    }

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

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister register) {
        clicker = register.registerIcon(Constants.Mod.MODID + ":" + Constants.Icons.CLICKER);
        clickerLinked = register.registerIcon(Constants.Mod.MODID + ":" + Constants.Icons.CLICKER_LINKED);

    }

    @Override
    @SideOnly(Side.CLIENT)
    public Icon getIcon(int side, int metadata) {
        return metadata == 7 ? clickerLinked : clicker;
    }

    @Override
    public TileEntity createNewTileEntity(World world) {
        return new TileEntityClicker();
    }

}
