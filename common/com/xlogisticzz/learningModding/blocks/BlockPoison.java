package com.xlogisticzz.learningModding.blocks;

import java.util.Random;

import com.xlogisticzz.learningModding.LearningModdingCreativeTab;
import com.xlogisticzz.learningModding.lib.Constants;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.world.World;


/**
 * Learning Modding Mod
 *
 * @author xLoGisTicZz.
 *
 * Some code may be from tutorials.
 *
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 *
 */
public class BlockPoison extends Block {
    
    public BlockPoison(int par1) {
        
        super(par1, Material.rock);
        
        this.setCreativeTab(LearningModdingCreativeTab.tabLearningModding);
        this.setHardness(1F);
        this.setStepSound(soundStoneFootstep);
        this.setUnlocalizedName(Constants.UnLocalisedNames.POISON);
        
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1IconRegister) {
        
        blockIcon = par1IconRegister.registerIcon(Constants.Mod.MODID + ":" + Constants.Icons.POISON);
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(World world , int x, int y, int z, Random rand) {
        
        for(int i = 0; i< 4; i++){
            
            float particleX = x + rand.nextFloat();
            float particleY = y + rand.nextFloat();
            float particleZ = z + rand.nextFloat();
            
            float particleMotionX = -0.5F + rand.nextFloat();
            float particleMotionY = -0.5F + rand.nextFloat();
            float particleMotionZ = -0.5F + rand.nextFloat();

            world.spawnParticle("portal", particleX, particleY, particleZ, particleMotionX, particleMotionY, particleMotionZ);
            
        }
    }
    
}
