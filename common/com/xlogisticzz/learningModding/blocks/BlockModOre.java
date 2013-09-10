package com.xlogisticzz.learningModding.blocks;

import com.xlogisticzz.learningModding.lib.Constants;

import net.minecraft.block.BlockOre;
import net.minecraft.block.StepSound;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
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

public class BlockModOre extends BlockOre {
    
    public String name;
    
    public BlockModOre(int par1, float par2, StepSound par3, String par4, CreativeTabs par5, String par6) {
    
        super(par1);
        this.setHardness(par2);
        this.setStepSound(par3);
        this.setUnlocalizedName(par4);
        this.setCreativeTab(par5);
        name = par6;
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister reg) {
    
        blockIcon = reg.registerIcon(Constants.Mod.MODID + ":" + name);
        
    }
    
}
