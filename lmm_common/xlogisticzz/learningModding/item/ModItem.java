package xlogisticzz.learningModding.item;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import xlogisticzz.learningModding.lib.Constants;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ModItem extends net.minecraft.item.Item {

    public String name;

    public ModItem(int par1, CreativeTabs par2, int par3, String par4,
            String par5) {
        super(par1);

        this.setCreativeTab(par2);
        this.setMaxStackSize(par3);
        this.setUnlocalizedName(par4);
        name = par5;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister reg) {

        itemIcon = reg.registerIcon(Constants.MOD.MODID + ":" + name);
        System.out.println(name);

    }
}
