package xlogisticzz.learningModding.item;

import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.EnumToolMaterial;
import net.minecraftforge.common.EnumHelper;
import xlogisticzz.learningModding.creativeTab.CreativeTab;
import xlogisticzz.learningModding.lib.Constants;
import xlogisticzz.learningModding.lib.Ids;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class ModItems {
    // Mod ItemNames
    public static ModItem titanitumIngot;
    public static ModItem ruby;
    public static ModPickaxe rubyPickaxe;
    public static ModSpade rubySpade;
    public static ModSword rubySword;
    public static ModAxe rubyAxe;
    public static ModHoe rubyHoe;
    public static ModArmor rubyHelmet;
    public static ModArmor rubyChestplate;
    public static ModArmor rubyLeggings;
    public static ModArmor rubyBoots;
    private static RubyWand rubyWand;

    public static EnumToolMaterial materialRuby = EnumHelper.addToolMaterial("ruby", 3, Constants.Misc.RUBY_DURABILITY, 4.1F, 3.0F, 40);
    public static EnumArmorMaterial materialArmorRuby = EnumHelper.addArmorMaterial("ruby", Constants.Misc.RUBY_DURABILITY, new int[] { Constants.Armor.RUBY_HELMET_REDUCTION, Constants.Armor.RUBY_CHESTPLATE_REDUCTION, Constants.Armor.RUBY_LEGGINGS_REDUCTION, Constants.Armor.RUBY_BOOTS_REDUCTION }, 40);

    public static void init() {

        titanitumIngot = new ModItem(Ids.TITANIUMINGOT, CreativeTab.tabLearningModding, 64, Constants.UnLocalisedNames.TITANIUM_INGOT, Constants.Icons.TITANIUM_INGOT);
        ruby = new ModItem(Ids.RUBY, CreativeTab.tabLearningModding, 64, Constants.UnLocalisedNames.RUBY, Constants.Icons.RUBY);
        rubyPickaxe = new ModPickaxe(Ids.RUBY_PICKAXE, materialRuby, 5.0F, 10.0F, CreativeTab.tabLearningModding, Constants.UnLocalisedNames.RUBY_PICKAXE, Constants.Icons.RUBY_PICKAXE, Constants.Misc.RUBY_DURABILITY);
        rubySpade = new ModSpade(Ids.RUBY_SPADE, materialRuby, CreativeTab.tabLearningModding, Constants.Misc.RUBY_DURABILITY, Constants.UnLocalisedNames.RUBY_SPADE, Constants.Icons.RUBY_SPADE);
        rubySword = new ModSword(Ids.RUBY_SWORD, materialRuby, CreativeTab.tabLearningModding, Constants.Misc.RUBY_DURABILITY, Constants.UnLocalisedNames.RUBY_SWORD, Constants.Icons.RUBY_SWORD);
        rubyAxe = new ModAxe(Ids.RUBY_AXE, materialRuby, CreativeTab.tabLearningModding, Constants.Misc.RUBY_DURABILITY, Constants.UnLocalisedNames.RUBY_AXE, Constants.Icons.RUBY_AXE);
        rubyHoe = new ModHoe(Ids.RUBY_HOE, materialRuby, CreativeTab.tabLearningModding, Constants.Misc.RUBY_DURABILITY, Constants.UnLocalisedNames.RUBY_HOE, Constants.Icons.RUBY_HOE);
        rubyWand = new RubyWand(Ids.RUBY_WAND);

        rubyHelmet = new ModArmor(Ids.RUBY_HELMET, materialArmorRuby, 0, 0, "ruby", CreativeTab.tabLearningModding);
        rubyChestplate = new ModArmor(Ids.RUBY_CHESTPLATE, materialArmorRuby, 0, 1, "ruby", CreativeTab.tabLearningModding);
        rubyLeggings = new ModArmor(Ids.RUBY_LEGGINGS, materialArmorRuby, 0, 2, "ruby", CreativeTab.tabLearningModding);
        rubyBoots = new ModArmor(Ids.RUBY_BOOTS, materialArmorRuby, 0, 3, "ruby", CreativeTab.tabLearningModding);

    }

    public static void initLang() {

        LanguageRegistry.addName(ruby, Constants.ItemNames.RUBY_NAME);
        LanguageRegistry.addName(titanitumIngot, Constants.ItemNames.TITANIUM_INGOT_NAME);
        LanguageRegistry.addName(rubyWand, Constants.ItemNames.RUBY_WAND_NAME);

        LanguageRegistry.addName(rubyPickaxe, Constants.ItemNames.RUBY_PICKAXE_NAME);
        LanguageRegistry.addName(rubySpade, Constants.ItemNames.RUBY_SPADE_NAME);
        LanguageRegistry.addName(rubySword, Constants.ItemNames.RUBY_SWORD_NAME);
        LanguageRegistry.addName(rubyAxe, Constants.ItemNames.RUBY_AXE_NAME);
        LanguageRegistry.addName(rubyHoe, Constants.ItemNames.RUBY_HOE_NAME);

        LanguageRegistry.addName(rubyHelmet, Constants.ItemNames.RUBY_HELMET_NAME);
        LanguageRegistry.addName(rubyChestplate, Constants.ItemNames.RUBY_CHESTPLATE_NAME);
        LanguageRegistry.addName(rubyLeggings, Constants.ItemNames.RUBY_LEGGINGS_NAME);
        LanguageRegistry.addName(rubyBoots, Constants.ItemNames.RUBY_BOOTS_NAME);
    }
}
