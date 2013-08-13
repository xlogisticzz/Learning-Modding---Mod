package xlogisticzz.learningModding.Crafting;

import net.minecraft.item.Item;
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

        GameRegistry.addShapedRecipe(new ItemStack(ModItems.rubySword),
                new Object[] { " X ", " X ", " S ", 'X', ModItems.ruby, 'S',
                        Item.stick });
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.rubyPickaxe),
                new Object[] { "XXX", " S ", " S ", 'X', ModItems.ruby, 'S',
                        Item.stick });
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.rubySpade),
                new Object[] { " X ", " S ", " S ", 'X', ModItems.ruby, 'S',
                        Item.stick });
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.rubyAxe),
                new Object[] { " XX", " SX", " S ", 'X', ModItems.ruby, 'S',
                        Item.stick });
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.rubyAxe),
                new Object[] { "XX ", "XS ", " S ", 'X', ModItems.ruby, 'S',
                        Item.stick });
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.rubyHoe),
                new Object[] { " XX", " S ", " S ", 'X', ModItems.ruby, 'S',
                        Item.stick });
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.rubyHoe),
                new Object[] { "XX ", " S ", " S ", 'X', ModItems.ruby, 'S',
                        Item.stick });
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.rubyHelmet),
                new Object[] { "XXX", "X X", "   ", 'X', ModItems.ruby });
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.rubyHelmet),
                new Object[] { "   ", "XXX", "X X", 'X', ModItems.ruby });
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.rubyChestplate),
                new Object[] { "X X", "XXX", "XXX", 'X', ModItems.ruby });
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.rubyLeggings),
                new Object[] { "XXX", "X X", "X X", 'X', ModItems.ruby });
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.rubyBoots),
                new Object[] { "   ", "X X", "X X", 'X', ModItems.ruby });
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.rubyBoots),
                new Object[] { "X X", "X X", "   ", 'X', ModItems.ruby });

    }

}
