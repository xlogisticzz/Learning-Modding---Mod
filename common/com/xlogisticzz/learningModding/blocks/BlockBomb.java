package com.xlogisticzz.learningModding.blocks;

import java.util.Random;

import com.xlogisticzz.learningModding.LearningModdingCreativeTab;
import com.xlogisticzz.learningModding.lib.Constants;
import com.xlogisticzz.learningModding.tileEntites.TileEntityBomb;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
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

public class BlockBomb extends BlockContainer {
    
    @SideOnly(Side.CLIENT)
    private Icon idleIcon;
    
    public BlockBomb(int par1) {
    
        super(par1, Material.tnt);
        this.setCreativeTab(LearningModdingCreativeTab.tabLearningModding);
        this.setHardness(2.4F);
        this.setStepSound(Block.soundPowderFootstep);
        this.setUnlocalizedName(Constants.UnLocalisedNames.BOMB);
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister register) {
    
        blockIcon = register.registerIcon(Constants.Mod.MODID + ":" + Constants.Icons.BOMB);
        idleIcon = register.registerIcon(Constants.Mod.MODID + ":" + Constants.Icons.BOMB_IDLE);
        
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public Icon getIcon(int side, int metadata) {
    
        if (metadata < 3){
            return blockIcon;
        }else{
            return idleIcon;
        }
    }
    
    @Override
    public int idDropped(int meta, Random random, int fortune) {
    
        if (meta == 0){
            return blockID;
        }else if (meta == 1){
            return blockID;
        }else{
            return -1;
        }
    }
    
    @Override
    public TileEntity createNewTileEntity(World world) {
    
        return new TileEntityBomb();
    }
    
}