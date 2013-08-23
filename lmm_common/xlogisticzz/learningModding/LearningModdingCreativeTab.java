package xlogisticzz.learningModding;

import xlogisticzz.learningModding.Items.ModItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class LearningModdingCreativeTab {

    public static CreativeTabs tabLearningModding = new CreativeTabs("tabLearningModding") {
        @Override
        public ItemStack getIconItemStack() {
            return new ItemStack(ModItems.ruby, 1, 0);
        }
    };

}
