package com.xlogisticzz.learningModding.items;

import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

import com.xlogisticzz.learningModding.lib.Constants;

/**
 * Learning Modding Mod
 * 
 * @author xLoGisTicZz. Some code may be from tutorials.
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */

public class ItemMarker extends ItemBlock {
    
    public ItemMarker(int par1) {
    
        super(par1);
        this.setHasSubtypes(true);
    }
    
    @Override
    public int getMetadata(int dammage) {
    
        return dammage;
    }
    
    @Override
    public String getItemDisplayName(ItemStack par1ItemStack) {
    
        return Constants.BlockNames.MARKERS_NAME[par1ItemStack.getItemDamage()];
    }
}
