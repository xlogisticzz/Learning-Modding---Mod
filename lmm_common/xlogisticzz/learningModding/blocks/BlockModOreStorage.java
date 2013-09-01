package xlogisticzz.learningModding.Blocks;

import net.minecraft.block.BlockOreStorage;
import net.minecraft.block.StepSound;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import xlogisticzz.learningModding.Lib.Constants;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockModOreStorage extends BlockOreStorage {

    /* Texture Name */
    public String name;

    /* Main Constructor */
    public BlockModOreStorage(int par1, StepSound par2, CreativeTabs par3, float par4, float par5, String par6, String par7) {
        super(par1);
        this.setStepSound(par2);
        this.setCreativeTab(par3);
        this.setHardness(par4);
        this.setResistance(par5);
        this.setUnlocalizedName(par6);
        name = par7;
    }

    /* Register Icons */
    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister reg) {

        blockIcon = reg.registerIcon(Constants.Mod.MODID + ":" + name);

    }

}
