package com.xlogisticzz.learningModding.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

import com.xlogisticzz.learningModding.LearningModdingCreativeTab;
import com.xlogisticzz.learningModding.client.particles.Particles;
import com.xlogisticzz.learningModding.lib.Constants;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**
 * Learning Modding Mod
 * 
 * @author xLoGisTicZz. Some code may be from tutorials.
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class BlockPoison extends Block {
    
    public BlockPoison(int par1) {
    
        super(par1, Material.rock);
        
        this.setCreativeTab(LearningModdingCreativeTab.tabLearningModding);
        this.setHardness(1F);
        this.setStepSound(soundStoneFootstep);
        this.setUnlocalizedName(Constants.UnLocalisedNames.POISON);
        
    }
    
    @SideOnly(Side.CLIENT)
    public Icon ParticleIcon;
    
    /*
     * (non-Javadoc)
     * @see net.minecraft.block.Block#registerIcons(net.minecraft.client.renderer.texture.IconRegister)
     */
    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1IconRegister) {
    
        this.blockIcon = par1IconRegister.registerIcon(Constants.Mod.MODID + ":" + Constants.Icons.POISON);
        this.ParticleIcon = par1IconRegister.registerIcon(Constants.Mod.MODID + ":particles/" + Constants.Particles.POISON_TEXTURE);
    }
    
    /*
     * (non-Javadoc)
     * @see net.minecraft.block.Block#randomDisplayTick(net.minecraft.world.World, int, int, int, java.util.Random)
     */
    @Override
    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(World world, int x, int y, int z, Random rand) {
    
        for (int i = 0; i < 4; i++){
            
            float particleX = x + rand.nextFloat();
            float particleY = y + rand.nextFloat();
            float particleZ = z + rand.nextFloat();
            
            float particleMotionX = -0.5F + rand.nextFloat();
            float particleMotionY = -0.5F + rand.nextFloat();
            float particleMotionZ = -0.5F + rand.nextFloat();
            
            Particles.POISON.spawnParticle(world, particleX, particleY, particleZ, particleMotionX, particleMotionY, particleMotionZ);
            
        }
    }
    
    /*
     * (non-Javadoc)
     * @see net.minecraft.block.Block#onBlockClicked(net.minecraft.world.World, int, int, int, net.minecraft.entity.player.EntityPlayer)
     */
    @Override
    public void onBlockClicked(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer) {
    
        if (!par1World.isRemote){
            par5EntityPlayer.addPotionEffect(new PotionEffect(Potion.poison.id, 40, 1));
        }
    }
}
