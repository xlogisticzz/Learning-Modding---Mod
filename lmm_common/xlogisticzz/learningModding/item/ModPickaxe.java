package xlogisticzz.learningModding.item;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemPickaxe;
import xlogisticzz.learningModding.lib.Constants;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ModPickaxe extends ItemPickaxe {

    public String name;

    public ModPickaxe(int par1, EnumToolMaterial par2EnumToolMaterial,
            float par3, float par4, CreativeTabs par5, String par6, String par7) {
        super(par1, par2EnumToolMaterial);
        damageVsEntity = par3;
        efficiencyOnProperMaterial = par4;
        this.setCreativeTab(par5);
        this.setMaxStackSize(1);
        this.setUnlocalizedName(par6);
        name = par7;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister reg) {

        itemIcon = reg.registerIcon(Constants.MOD.MODID + ":" + name);

    }

}
