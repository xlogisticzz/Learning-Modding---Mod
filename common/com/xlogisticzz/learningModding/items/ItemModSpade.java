package com.xlogisticzz.learningModding.items;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemSpade;

import com.xlogisticzz.learningModding.lib.Constants;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**
 * Learning Modding Mod
 * 
 * @author xLoGisTicZz.
 * 
 *         Some code may be from tutorials.
 * 
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */

public class ItemModSpade extends ItemSpade {
    
    public String name;
    
    public ItemModSpade(int par1, EnumToolMaterial par2EnumToolMaterial, CreativeTabs par2, int par3, String par4, String par5) {
    
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
    
        itemIcon = reg.registerIcon(Constants.Mod.MODID + ":" + name);
        
    }
}
