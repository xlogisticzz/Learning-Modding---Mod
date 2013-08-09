package xlogisticzz.learningModding.Crafting;

import net.minecraft.item.ItemStack;
import xlogisticzz.learningModding.blocks.ModBlocks;
import xlogisticzz.learningModding.item.ModItems;
import cpw.mods.fml.common.registry.GameRegistry;

public class Vanilla {

    public static void init() {

        GameRegistry.addSmelting(ModBlocks.titaniumore.blockID, new ItemStack(
                ModItems.titanitumIngot), 10);
        GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.rubyblock),
                new Object[] { "XXX", "XXX", "XXX", 'X', ModItems.ruby });
        GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.titaniumblock),
                new Object[] { "XXX", "XXX", "XXX", 'X',
                        ModItems.titanitumIngot });
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.ruby, 9),
                ModBlocks.rubyblock);
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.titanitumIngot,
                9), ModBlocks.titaniumblock);
    }

}
