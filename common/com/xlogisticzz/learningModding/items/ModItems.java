package com.xlogisticzz.learningModding.items;

import com.xlogisticzz.learningModding.LearningModdingCreativeTab;
import com.xlogisticzz.learningModding.lib.Constants;
import com.xlogisticzz.learningModding.lib.Ids;

import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.EnumHelper;
import cpw.mods.fml.common.registry.LanguageRegistry;

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

public class ModItems {
    
    // Mod ItemNames
    public static ItemModItem titanitumIngot;
    public static ItemModItem ruby;
    public static ItemModPickaxe rubyPickaxe;
    public static ItemModSpade rubySpade;
    public static ItemModSword rubySword;
    public static ItemModAxe rubyAxe;
    public static ItemModHoe rubyHoe;
    public static ItemModArmor rubyHelmet;
    public static ItemModArmor rubyChestplate;
    public static ItemModArmor rubyLeggings;
    public static ItemModArmor rubyBoots;
    public static ItemRubyWand rubyWand;
    public static ItemCard card;
    public static ItemDeathstone deathstone;
    public static ItemWand wand;
    public static ItemSpawnSpaceship spawnSpaceship;
    public static ItemEntityLauncher entityLauncher;
    public static ItemPigConverter pigConverter;
    public static ItemEntityBlockTeleport entityBlockTeleporter;
    
    public static EnumToolMaterial materialRuby = EnumHelper.addToolMaterial("ruby", 3, Constants.Misc.RUBY_DURABILITY, 4.1F, 3.0F, 40);
    public static EnumArmorMaterial materialArmorRuby = EnumHelper.addArmorMaterial("ruby", Constants.Misc.RUBY_DURABILITY, new int[] { Constants.Armor.RUBY_HELMET_REDUCTION, Constants.Armor.RUBY_CHESTPLATE_REDUCTION, Constants.Armor.RUBY_LEGGINGS_REDUCTION, Constants.Armor.RUBY_BOOTS_REDUCTION }, 40);
    
    public static void init() {
    
        titanitumIngot = new ItemModItem(Ids.TITANIUMINGOT, LearningModdingCreativeTab.tabLearningModding, 64, Constants.UnLocalisedNames.TITANIUM_INGOT, Constants.Icons.TITANIUM_INGOT);
        ruby = new ItemModItem(Ids.RUBY, LearningModdingCreativeTab.tabLearningModding, 64, Constants.UnLocalisedNames.RUBY, Constants.Icons.RUBY);
        rubyPickaxe = new ItemModPickaxe(Ids.RUBY_PICKAXE, materialRuby, 5.0F, 10.0F, LearningModdingCreativeTab.tabLearningModding, Constants.UnLocalisedNames.RUBY_PICKAXE, Constants.Icons.RUBY_PICKAXE, Constants.Misc.RUBY_DURABILITY);
        rubySpade = new ItemModSpade(Ids.RUBY_SPADE, materialRuby, LearningModdingCreativeTab.tabLearningModding, Constants.Misc.RUBY_DURABILITY, Constants.UnLocalisedNames.RUBY_SPADE, Constants.Icons.RUBY_SPADE);
        rubySword = new ItemModSword(Ids.RUBY_SWORD, materialRuby, LearningModdingCreativeTab.tabLearningModding, Constants.Misc.RUBY_DURABILITY, Constants.UnLocalisedNames.RUBY_SWORD, Constants.Icons.RUBY_SWORD);
        rubyAxe = new ItemModAxe(Ids.RUBY_AXE, materialRuby, LearningModdingCreativeTab.tabLearningModding, Constants.Misc.RUBY_DURABILITY, Constants.UnLocalisedNames.RUBY_AXE, Constants.Icons.RUBY_AXE);
        rubyHoe = new ItemModHoe(Ids.RUBY_HOE, materialRuby, LearningModdingCreativeTab.tabLearningModding, Constants.Misc.RUBY_DURABILITY, Constants.UnLocalisedNames.RUBY_HOE, Constants.Icons.RUBY_HOE);
        rubyWand = new ItemRubyWand(Ids.RUBY_WAND);
        card = new ItemCard(Ids.CARD);
        deathstone = new ItemDeathstone(Ids.DEATHSTONES);
        wand = new ItemWand(Ids.WAND);
        spawnSpaceship = new ItemSpawnSpaceship(Ids.SPAWN_SPACESHIP);
        entityLauncher = new ItemEntityLauncher(Ids.ENTITY_LAUNCHER);
        pigConverter = new ItemPigConverter(Ids.PIG_CONVERTER);
        entityBlockTeleporter = new ItemEntityBlockTeleport(Ids.ENTITY_BLOCK_TELEPORTER);
        rubyHelmet = new ItemModArmor(Ids.RUBY_HELMET, materialArmorRuby, 0, 0, "ruby", LearningModdingCreativeTab.tabLearningModding);
        rubyChestplate = new ItemModArmor(Ids.RUBY_CHESTPLATE, materialArmorRuby, 0, 1, "ruby", LearningModdingCreativeTab.tabLearningModding);
        rubyLeggings = new ItemModArmor(Ids.RUBY_LEGGINGS, materialArmorRuby, 0, 2, "ruby", LearningModdingCreativeTab.tabLearningModding);
        rubyBoots = new ItemModArmor(Ids.RUBY_BOOTS, materialArmorRuby, 0, 3, "ruby", LearningModdingCreativeTab.tabLearningModding);
        
    }
    
    public static void initLang() {
    
        LanguageRegistry.addName(ruby, Constants.ItemNames.RUBY_NAME);
        LanguageRegistry.addName(titanitumIngot, Constants.ItemNames.TITANIUM_INGOT_NAME);
        LanguageRegistry.addName(rubyWand, Constants.ItemNames.RUBY_WAND_NAME);
        LanguageRegistry.addName(wand, Constants.ItemNames.WAND_NAME);
        LanguageRegistry.addName(spawnSpaceship, Constants.ItemNames.SPAWN_SPACESHIP_NAME);
        LanguageRegistry.addName(entityLauncher, Constants.ItemNames.ENTITY_LAUNCHER_NAME);
        LanguageRegistry.addName(pigConverter, Constants.ItemNames.PIG_CONVERTER_NAME);
        LanguageRegistry.addName(entityBlockTeleporter, Constants.ItemNames.ENTITY_BLOCK_TELEPORTER_NAME);

        
        LanguageRegistry.addName(rubyPickaxe, Constants.ItemNames.RUBY_PICKAXE_NAME);
        LanguageRegistry.addName(rubySpade, Constants.ItemNames.RUBY_SPADE_NAME);
        LanguageRegistry.addName(rubySword, Constants.ItemNames.RUBY_SWORD_NAME);
        LanguageRegistry.addName(rubyAxe, Constants.ItemNames.RUBY_AXE_NAME);
        LanguageRegistry.addName(rubyHoe, Constants.ItemNames.RUBY_HOE_NAME);
        
        LanguageRegistry.addName(rubyHelmet, Constants.ItemNames.RUBY_HELMET_NAME);
        LanguageRegistry.addName(rubyChestplate, Constants.ItemNames.RUBY_CHESTPLATE_NAME);
        LanguageRegistry.addName(rubyLeggings, Constants.ItemNames.RUBY_LEGGINGS_NAME);
        LanguageRegistry.addName(rubyBoots, Constants.ItemNames.RUBY_BOOTS_NAME);
        
        for (int i = 0; i < Constants.ItemNames.CARD_NAMES.length; i++){
            LanguageRegistry.addName(new ItemStack(card, 1, i), Constants.ItemNames.CARD_NAMES[i]);
        }
        for (int i = 0; i < Constants.ItemNames.DEATHSTONES_NAMES.length; i++){
            LanguageRegistry.addName(new ItemStack(deathstone, 1, i), Constants.ItemNames.DEATHSTONES_NAMES[i]);
        }
    }
}
