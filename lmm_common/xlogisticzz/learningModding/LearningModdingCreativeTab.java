package xlogisticzz.learningModding;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import xlogisticzz.learningModding.Items.ModItems;

public class LearningModdingCreativeTab {

    /* Custom Creative tab */
    public static CreativeTabs tabLearningModding = new CreativeTabs("tabLearningModding") {
        
        /* Tab Icon */
        @Override
        public ItemStack getIconItemStack() {
            return new ItemStack(ModItems.ruby, 1, 0);
        }
    };

}
