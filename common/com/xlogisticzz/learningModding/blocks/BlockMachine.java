package com.xlogisticzz.learningModding.blocks;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

import com.xlogisticzz.learningModding.LearningModdingCreativeTab;
import com.xlogisticzz.learningModding.lib.Constants;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**
 * Learning Modding Mod
 * 
 * @author xLoGisTicZz. Some code may be from tutorials.
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */

public class BlockMachine extends Block {
    
    @SideOnly(Side.CLIENT)
    private Icon topIcon;
    @SideOnly(Side.CLIENT)
    private Icon bottomIcon;
    @SideOnly(Side.CLIENT)
    private Icon[] sideIcons;
    @SideOnly(Side.CLIENT)
    private Icon disableIcon;
    
    public BlockMachine(int par1) {
    
        super(par1, Material.iron);
        this.setCreativeTab(LearningModdingCreativeTab.tabLearningModding);
        this.setHardness(2.5F);
        this.setUnlocalizedName(Constants.UnLocalisedNames.MACHINE_BLOCK);
    }
    
    /*
     * (non-Javadoc)
     * @see net.minecraft.block.Block#registerIcons(net.minecraft.client.renderer.texture.IconRegister)
     */
    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister IconRegister) {
    
        this.topIcon = IconRegister.registerIcon(Constants.Mod.MODID + ":" + Constants.Icons.MACHINE_TOP);
        this.bottomIcon = IconRegister.registerIcon(Constants.Mod.MODID + ":" + Constants.Icons.MACHINE_BOTTOM);
        this.disableIcon = IconRegister.registerIcon(Constants.Mod.MODID + ":" + Constants.Icons.MACHINE_DISABLED);
        
        this.sideIcons = new Icon[Constants.Icons.MACHINE_SIDES.length];
        for (int i = 0; i < Constants.Icons.MACHINE_SIDES.length; i++){
            this.sideIcons[i] = IconRegister.registerIcon(Constants.Mod.MODID + ":" + Constants.Icons.MACHINE_SIDES[i]);
        }
        
    }
    
    private void spawnGravel(World world, int x, int y, int z) {
    
        if (world.isAirBlock(x, y, z)){
            world.setBlock(x, y, z, Block.gravel.blockID);
        }
    }
    
    /*
     * (non-Javadoc)
     * @see net.minecraft.block.Block#onEntityWalking(net.minecraft.world.World, int, int, int, net.minecraft.entity.Entity)
     */
    @Override
    public void onEntityWalking(World par1World, int x, int y, int z, Entity par5Entity) {
    
        if (!par1World.isRemote && par1World.getBlockMetadata(x, y, z) % 2 == 0){
            spawnGravel(par1World, x, y + 20, z);
            spawnGravel(par1World, x, y + 21, z);
        }
    }
    
    /*
     * (non-Javadoc)
     * @see net.minecraft.block.Block#onNeighborBlockChange(net.minecraft.world.World, int, int, int, int)
     */
    @Override
    public void onNeighborBlockChange(World world, int x, int y, int z, int id) {
    
        int meta = world.getBlockMetadata(x, y, z);
        if (!world.isRemote && world.isBlockIndirectlyGettingPowered(x, y, z) && meta % 2 == 0){
            switch (meta / 2) {
                case 1 :
                    for (int i = 0; i < 5; i++){
                        spawnGravel(world, x, y + 20 + i, z);
                    }
                    break;
                case 2 :
                    for (int i = -1; i <= 1; i++){
                        spawnGravel(world, x + i, y + 20, z - 2);
                        spawnGravel(world, x + i, y + 20, z + 2);
                        spawnGravel(world, x - 2, y + 20, z + i);
                        spawnGravel(world, x + 2, y + 20, z + i);
                    }
                    break;
                case 3 :
                    for (int i = 1; i <= 3; i++){
                        spawnGravel(world, x + i, y + 20, z);
                        spawnGravel(world, x - i, y + 20, z);
                        spawnGravel(world, x, y + 20, z + i);
                        spawnGravel(world, x, y + 20, z - i);
                    }
                    break;
            }
        }
        
    }
    
    /*
     * (non-Javadoc)
     * @see net.minecraft.block.Block#getIcon(int, int)
     */
    @Override
    @SideOnly(Side.CLIENT)
    public Icon getIcon(int side, int metadata) {
    
        switch (side) {
        
            case 0 :
                return this.bottomIcon;
                
            case 1 :
                return metadata % 2 == 1 ? this.disableIcon : this.topIcon;
                
            default :
                return this.sideIcons[metadata / 2];
                
        }
        
    }
    
    /*
     * (non-Javadoc)
     * @see net.minecraft.block.Block#onBlockActivated(net.minecraft.world.World, int, int, int, net.minecraft.entity.player.EntityPlayer, int, float, float, float)
     */
    @Override
    public boolean onBlockActivated(World par1World, int x, int y, int z, EntityPlayer par5EntityPlayer, int side, float offsetX, float offsetY, float offsetZ) {
    
        if (!par1World.isRemote){
            int metadata = par1World.getBlockMetadata(x, y, z);
            
            int selectedType = metadata / 2;
            
            int isDisabled = metadata % 2 == 1 ? 0 : 1;
            
            int newMetadata = selectedType * 2 + isDisabled;
            
            par1World.setBlockMetadataWithNotify(x, y, z, newMetadata, 3);
        }
        return true;
    }
    
    /*
     * (non-Javadoc)
     * @see net.minecraft.block.Block#damageDropped(int)
     */
    @Override
    public int damageDropped(int metadata) {
    
        return metadata;
    }
    
    /*
     * (non-Javadoc)
     * @see net.minecraft.block.Block#getSubBlocks(int, net.minecraft.creativetab.CreativeTabs, java.util.List)
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    public void getSubBlocks(int id, CreativeTabs par2CreativeTabs, List par3List) {
    
        for (int i = 0; i < Constants.Icons.MACHINE_SIDES.length; i++){
            par3List.add(new ItemStack(id, 1, i * 2));
        }
    }
    
}
