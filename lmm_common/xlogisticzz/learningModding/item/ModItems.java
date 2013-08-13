package xlogisticzz.learningModding.item;

import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.EnumToolMaterial;
import net.minecraftforge.common.EnumHelper;
import xlogisticzz.learningModding.creativeTab.CreativeTab;
import xlogisticzz.learningModding.lib.Ids;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class ModItems {
    // Mod Items
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

    public static EnumToolMaterial materialRuby = EnumHelper.addToolMaterial(
            "ruby", 3, 1000, 4.1F, 3.0F, 40);
    public static EnumArmorMaterial materialArmorRuby = EnumHelper
            .addArmorMaterial("ruby", 1000, new int[] { 4, 10, 8, 4 }, 40);

    public static void init() {

        titanitumIngot = new ModItem(Ids.TITANIUMINGOT,
                CreativeTab.tabLearningModding, 64, "titanitumIngot",
                "titanitum_ingot");
        ruby = new ModItem(Ids.RUBY, CreativeTab.tabLearningModding, 64,
                "ruby", "ruby");
        rubyPickaxe = new ModPickaxe(Ids.RUBY_PICKAXE, materialRuby, 5.0F,
                10.0F, CreativeTab.tabLearningModding, "rubyPickaxe",
                "ruby_pickaxe");
        rubySpade = new ModSpade(Ids.RUBY_SPADE, materialRuby,
                CreativeTab.tabLearningModding, 1000, "rubySpade", "ruby_spade");
        rubySword = new ModSword(Ids.RUBY_SWORD, materialRuby,
                CreativeTab.tabLearningModding, 1000, "rubySword", "ruby_sword");
        rubyAxe = new ModAxe(Ids.RUBY_AXE, materialRuby,
                CreativeTab.tabLearningModding, 1000, "rubyAxe", "ruby_axe");
        rubyHoe = new ModHoe(Ids.RUBY_HOE, materialRuby,
                CreativeTab.tabLearningModding, 1000, "rubyHoe", "ruby_hoe");

        rubyHelmet = new ModArmor(Ids.RUBY_HELMET, materialArmorRuby, 0, 0,
                "ruby", CreativeTab.tabLearningModding);
        rubyChestplate = new ModArmor(Ids.RUBY_CHESTPLATE, materialArmorRuby,
                0, 1, "ruby", CreativeTab.tabLearningModding);
        rubyLeggings = new ModArmor(Ids.RUBY_LEGGINGS, materialArmorRuby, 0, 2,
                "ruby", CreativeTab.tabLearningModding);
        rubyBoots = new ModArmor(Ids.RUBY_BOOTS, materialArmorRuby, 0, 3,
                "ruby", CreativeTab.tabLearningModding);

        LanguageRegistry.addName(ruby, "Ruby");
        LanguageRegistry.addName(titanitumIngot, "Titanium Ingot");

        LanguageRegistry.addName(rubyPickaxe, "Ruby Pickaxe");
        LanguageRegistry.addName(rubySpade, "Ruby Shovel");
        LanguageRegistry.addName(rubySword, "Ruby Sword");
        LanguageRegistry.addName(rubyAxe, "Ruby Axe");
        LanguageRegistry.addName(rubyHoe, "Ruby Hoe");

        LanguageRegistry.addName(rubyHelmet, "Ruby Helmet");
        LanguageRegistry.addName(rubyChestplate, "Ruby Chestplate");
        LanguageRegistry.addName(rubyLeggings, "Ruby Leggings");
        LanguageRegistry.addName(rubyBoots, "Ruby Boots");
    }
}
