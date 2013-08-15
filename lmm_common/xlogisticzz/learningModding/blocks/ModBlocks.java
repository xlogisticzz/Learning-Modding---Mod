package xlogisticzz.learningModding.blocks;

import net.minecraft.block.Block;
import net.minecraftforge.common.MinecraftForge;
import xlogisticzz.learningModding.creativeTab.CreativeTab;
import xlogisticzz.learningModding.lib.Constants;
import xlogisticzz.learningModding.lib.Ids;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class ModBlocks {

    // Mod Blocks
    public static OreBlock titaniumore;
    public static rubyOreBlock rubyore;
    public static OreStorageBlock titaniumblock;
    public static OreStorageBlock rubyblock;

    public static void init() {
        titaniumore = new OreBlock(Ids.TITANIUMORE, 3, Block.soundStoneFootstep, Constants.UnLocalisedNames.TITANIUM_ORE, CreativeTab.tabLearningModding, Constants.Icons.TITANIUM_ORE);
        rubyore = new rubyOreBlock(Ids.RUBYORE, 1, Block.soundLadderFootstep, Constants.UnLocalisedNames.RUBY_ORE, CreativeTab.tabLearningModding, Constants.Icons.RUBY_ORE);
        titaniumblock = new OreStorageBlock(Ids.TITANIUMBLOCK, Block.soundMetalFootstep, CreativeTab.tabLearningModding, 6.0F, 12.0F, Constants.UnLocalisedNames.TITANIUM_BLOCK, Constants.Icons.TITANIUM_BLOCK);
        rubyblock = new OreStorageBlock(Ids.RUBYBLOCK, Block.soundMetalFootstep, CreativeTab.tabLearningModding, 5.0F, 10.0F, Constants.UnLocalisedNames.RUBY_BLOCK, Constants.Icons.RUBY_BLOCK);

    }

    public static void initInfo() {

        // Titanium Ore Details
        LanguageRegistry.addName(titaniumore, Constants.BlockNames.TITANIUM_ORE_NAME);
        MinecraftForge.setBlockHarvestLevel(titaniumore, "pickaxe", 3);
        GameRegistry.registerBlock(titaniumore, Constants.UnLocalisedNames.TITANIUM_ORE);

        // Ruby Ore Details
        LanguageRegistry.addName(rubyore, Constants.BlockNames.RUBY_ORE_NAME);
        MinecraftForge.setBlockHarvestLevel(rubyore, "pickaxe", 2);
        GameRegistry.registerBlock(rubyore, Constants.UnLocalisedNames.RUBY_ORE);

        // Titanium Block Details
        LanguageRegistry.addName(titaniumblock, Constants.BlockNames.TITANIUM_BLOCK_NAME);
        MinecraftForge.setBlockHarvestLevel(titaniumblock, "pickaxe", 3);
        GameRegistry.registerBlock(titaniumblock, Constants.UnLocalisedNames.TITANIUM_BLOCK);

        // Ruby Block Details
        LanguageRegistry.addName(rubyblock, Constants.BlockNames.RUBY_BLOCK_NAME);
        MinecraftForge.setBlockHarvestLevel(rubyblock, "pickaxe", 2);
        GameRegistry.registerBlock(rubyblock, Constants.UnLocalisedNames.RUBY_BLOCK);

    }

}
