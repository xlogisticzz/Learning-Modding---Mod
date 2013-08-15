package xlogisticzz.learningModding.blocks;

import java.util.Random;

import net.minecraft.block.BlockOre;
import net.minecraft.block.StepSound;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import xlogisticzz.learningModding.item.ModItems;
import xlogisticzz.learningModding.lib.Constants;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class rubyOreBlock extends BlockOre {

    public String name;

    public rubyOreBlock(int par1, float par2, StepSound par3, String par4, CreativeTabs par5, String par6) {
        super(par1);
        this.setHardness(par2);
        this.setStepSound(par3);
        this.setUnlocalizedName(par4);
        this.setCreativeTab(par5);
        name = par6;

    }

    @Override
    public int idDropped(int par1, Random par2Random, int par3) {

        return ModItems.ruby.itemID;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister reg) {

        blockIcon = reg.registerIcon(Constants.Mod.MODID + ":" + name);

    }

}
