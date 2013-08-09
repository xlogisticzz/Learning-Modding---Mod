package xlogisticzz.learningModding.item;

import xlogisticzz.learningModding.lib.Constants;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;

public class Items extends net.minecraft.item.Item{

	public String name;
	
	public Items(int par1, CreativeTabs par2, int par3, String par4, String par5) {
		super(par1);

		this.setCreativeTab(par2);
		this.setMaxStackSize(par3);
		this.setUnlocalizedName(par5);
		name = par4;
	}
	
	

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister reg){
	
		this.itemIcon = reg.registerIcon(Constants.MOD.MODID + ":" + name);
		
	}
}
