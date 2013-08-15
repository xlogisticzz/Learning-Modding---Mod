package xlogisticzz.learningModding.creativeTab;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import xlogisticzz.learningModding.item.ModItems;

public class CreativeTab {

    public static CreativeTabs tabLearningModding = new CreativeTabs("tabLearningModding") {
        @Override
        public ItemStack getIconItemStack() {
            return new ItemStack(ModItems.ruby, 1, 0);
        }
    };

}
