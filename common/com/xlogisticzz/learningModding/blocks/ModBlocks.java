package com.xlogisticzz.learningModding.blocks;

import net.minecraft.block.Block;
import net.minecraftforge.common.MinecraftForge;

import com.xlogisticzz.learningModding.LearningModdingCreativeTab;
import com.xlogisticzz.learningModding.items.ItemMachine;
import com.xlogisticzz.learningModding.items.ItemMarker;
import com.xlogisticzz.learningModding.lib.Constants;
import com.xlogisticzz.learningModding.lib.Ids;
import com.xlogisticzz.learningModding.tileEntites.TileEntityBomb;
import com.xlogisticzz.learningModding.tileEntites.TileEntityClicker;
import com.xlogisticzz.learningModding.tileEntites.TileEntityNoteSequencer;
import com.xlogisticzz.learningModding.tileEntites.TileEntityNumbers;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

/**
 * Learning Modding Mod
 * 
 * @author xLoGisTicZz. Some code may be from tutorials.
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */

public class ModBlocks {
    
    public static BlockModOre titaniumore;
    public static BlockRubyOre rubyore;
    public static BlockModOreStorage titaniumblock;
    public static BlockModOreStorage rubyblock;
    public static BlockMachine machineblock;
    public static BlockGlassConnected glassConnected;
    public static BlockTest testIconBlock;
    public static BlockMarker markerBlock;
    public static BlockBomb bomb;
    public static BlockSuperBomb superBomb;
    public static BlockNumber numbers;
    public static BlockClicker clicker;
    public static BlockPoison poisonBlock;
    public static BlockHeightParticle particleBlock;
    public static BlockNoteSequencer noteSequencer;
    
    public static void init() {
    
        titaniumore = new BlockModOre(Ids.TITANIUMORE, 3, Block.soundStoneFootstep, Constants.UnLocalisedNames.TITANIUM_ORE, LearningModdingCreativeTab.tabLearningModding, Constants.Icons.TITANIUM_ORE);
        rubyore = new BlockRubyOre(Ids.RUBYORE, 1, Block.soundLadderFootstep, Constants.UnLocalisedNames.RUBY_ORE, LearningModdingCreativeTab.tabLearningModding, Constants.Icons.RUBY_ORE);
        titaniumblock = new BlockModOreStorage(Ids.TITANIUMBLOCK, Block.soundMetalFootstep, LearningModdingCreativeTab.tabLearningModding, 6.0F, 12.0F, Constants.UnLocalisedNames.TITANIUM_BLOCK, Constants.Icons.TITANIUM_BLOCK);
        rubyblock = new BlockModOreStorage(Ids.RUBYBLOCK, Block.soundMetalFootstep, LearningModdingCreativeTab.tabLearningModding, 5.0F, 10.0F, Constants.UnLocalisedNames.RUBY_BLOCK, Constants.Icons.RUBY_BLOCK);
        machineblock = new BlockMachine(Ids.MACHINEBLOCK);
        glassConnected = new BlockGlassConnected(Ids.GLASS_CONNECTED, false);
        testIconBlock = new BlockTest(Ids.TESTBLOCK);
        markerBlock = new BlockMarker(Ids.MARKERS);
        bomb = new BlockBomb(Ids.BOMB);
        superBomb = new BlockSuperBomb(Ids.SUPERBOMB);
        numbers = new BlockNumber(Ids.NUMBER);
        clicker = new BlockClicker(Ids.CLICKER);
        poisonBlock = new BlockPoison(Ids.POISON);
        particleBlock = new BlockHeightParticle(Ids.HEIGHTPARTICLE);
        noteSequencer = new BlockNoteSequencer(Ids.NOTE_SEQUENCER);
        
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
        
        // Machine Block Details
        MinecraftForge.setBlockHarvestLevel(machineblock, "pickaxe", 2);
        GameRegistry.registerBlock(machineblock, ItemMachine.class, Constants.UnLocalisedNames.MACHINE_BLOCK);
        
        // Glass Block Details
        LanguageRegistry.addName(glassConnected, Constants.BlockNames.GLASS_CONNECTED);
        GameRegistry.registerBlock(glassConnected, Constants.UnLocalisedNames.GLASS_CONNECTED);
        
        // Test Block Details
        LanguageRegistry.addName(testIconBlock, Constants.BlockNames.TEST_BLOCK);
        GameRegistry.registerBlock(testIconBlock, Constants.UnLocalisedNames.TEST_BLOCK);
        
        // Markers
        GameRegistry.registerBlock(markerBlock, ItemMarker.class, Constants.UnLocalisedNames.MARKERS);
        
        // Bomb
        LanguageRegistry.addName(bomb, Constants.BlockNames.BOMB_NAME);
        MinecraftForge.setBlockHarvestLevel(bomb, "pickaxe", 2);
        GameRegistry.registerBlock(bomb, Constants.UnLocalisedNames.BOMB);
        GameRegistry.registerTileEntity(TileEntityBomb.class, Constants.UnLocalisedNames.BOMB + "TileEntity");
        
        // Super Bomb
        LanguageRegistry.addName(superBomb, Constants.BlockNames.SUPER_BOMB_NAME);
        GameRegistry.registerBlock(superBomb, Constants.UnLocalisedNames.SUPER_BOMB);
        
        // Numbers
        LanguageRegistry.addName(numbers, Constants.BlockNames.NUMBER_NAME);
        GameRegistry.registerBlock(numbers, Constants.UnLocalisedNames.NUMBER);
        GameRegistry.registerTileEntity(TileEntityNumbers.class, Constants.UnLocalisedNames.NUMBER + "TileEntity");
        
        // Numbers
        LanguageRegistry.addName(clicker, Constants.BlockNames.CLICKER_NAME);
        GameRegistry.registerBlock(clicker, Constants.UnLocalisedNames.CLICKER);
        GameRegistry.registerTileEntity(TileEntityClicker.class, Constants.UnLocalisedNames.CLICKER + "TileEntity");
        
        // Poison
        LanguageRegistry.addName(poisonBlock, Constants.BlockNames.POISON_NAME);
        GameRegistry.registerBlock(poisonBlock, Constants.UnLocalisedNames.POISON);
        
        // Height Particle
        LanguageRegistry.addName(particleBlock, Constants.BlockNames.HEIGHT_PARTICLE_NAME);
        GameRegistry.registerBlock(particleBlock, Constants.UnLocalisedNames.HEIGHT_PARTICLE);
        
        // Note Sequencer
        LanguageRegistry.addName(noteSequencer, Constants.BlockNames.NOTE_SEQUENCER_NAME);
        MinecraftForge.setBlockHarvestLevel(noteSequencer, "pickaxe", 2);
        GameRegistry.registerBlock(noteSequencer, Constants.UnLocalisedNames.NOTE_SEQUENCER);
        GameRegistry.registerTileEntity(TileEntityNoteSequencer.class, Constants.UnLocalisedNames.NOTE_SEQUENCER + "TileEntity");
        
    }
    
}
