package xlogisticzz.learningModding.blocks;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import xlogisticzz.learningModding.item.ModItems;
import xlogisticzz.learningModding.lib.Constants;
import xlogisticzz.learningModding.lib.Ids;
import net.minecraft.block.BlockOre;
import net.minecraft.block.StepSound;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;

public class OreBlock extends BlockOre {

	public String name;
	public int dropped;
	
	public OreBlock(int par1, float par2, StepSound par3, String par4, CreativeTabs par5, String par6) {
		super(par1);
		this.setHardness(par2);
		this.setStepSound(par3);
		this.setUnlocalizedName(par4);
		this.setCreativeTab(par5);
		name = par6;
		dropped = par1;
	}
	
	public int idDropped(int par1, Random random, int zero) {
       
		if (dropped == Ids.RUBYORE){
			return ModItems.ruby.itemID;
		}else{
			return dropped;
		}
}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister reg){
	
		this.blockIcon = reg.registerIcon(Constants.MOD.MODID + ":" + name);
		
	}
	
}
