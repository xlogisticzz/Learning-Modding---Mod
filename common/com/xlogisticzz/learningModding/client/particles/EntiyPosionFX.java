package com.xlogisticzz.learningModding.client.particles;

import net.minecraft.client.particle.EntityFX;
import net.minecraft.world.World;

import com.xlogisticzz.learningModding.blocks.ModBlocks;

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

public class EntiyPosionFX extends EntityFX {
    
    public EntiyPosionFX(World par1World, double par2, double par4, double par6, double par8, double par10, double par12) {
    
        super(par1World, par2, par4, par6, par8, par10, par12);
        
        this.setParticleIcon(ModBlocks.poisonBlock.ParticleIcon);
        
        particleScale = rand.nextFloat();
        particleAlpha = rand.nextFloat();
        particleBlue = rand.nextFloat() * 0.5F;
        particleRed = rand.nextFloat() * 0.5F;
        particleGreen = rand.nextFloat() * 0.5F + 0.5F;
        
    }
    
    @Override
    public void onUpdate() {
    
        super.onUpdate();
        
        particleScale = (1 - (float) particleAge / particleMaxAge) * 2;
        
    }
    
    @Override
    public int getFXLayer() {
    
        return 1;
    }
    
}
