package xlogisticzz.learningModding.item;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemSpade;
import xlogisticzz.learningModding.lib.Constants;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ModSpade extends ItemSpade {

    public String name;

    public ModSpade(int par1, EnumToolMaterial par2EnumToolMaterial,
            CreativeTabs par2, int par3, String par4, String par5) {
        super(par1, par2EnumToolMaterial);
        this.setCreativeTab(par2);
        this.setMaxDamage(par3);
        this.setMaxStackSize(1);
        this.setUnlocalizedName(par4);
        name = par5;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister reg) {

        itemIcon = reg.registerIcon(Constants.MOD.MODID + ":" + name);

    }
}
