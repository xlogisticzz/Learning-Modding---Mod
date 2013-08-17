package xlogisticzz.learningModding.configuration;

import java.io.File;

import net.minecraftforge.common.Configuration;
import xlogisticzz.learningModding.lib.Constants;
import xlogisticzz.learningModding.lib.Ids;

public class ConfigurationHandler {

    public static Configuration configuration;

    public static void init(File configFile) {

        configuration = new Configuration(configFile);

        configuration.load();

        // Block IDs
        Ids.TITANIUMORE = configuration.getBlock(Configuration.CATEGORY_BLOCK, "Titanium Ore ID", Ids.TITANIUMORE_DEFAULT).getInt();
        Ids.RUBYORE = configuration.getBlock(Configuration.CATEGORY_BLOCK, "Ruby Ore ID", Ids.RUBYORE_DEFAULT).getInt();
        Ids.RUBYBLOCK = configuration.getBlock(Configuration.CATEGORY_BLOCK, "Ruby Block ID", Ids.RUBYBLOCK_DEFAULT).getInt();
        Ids.TITANIUMBLOCK = configuration.getBlock(Configuration.CATEGORY_BLOCK, "Titanium ID", Ids.TITANIUMBLOCK_DEFAULT).getInt();

        // Item IDs
        Ids.TITANIUMINGOT = configuration.getItem(Configuration.CATEGORY_ITEM, "Titanium Ingot ID", Ids.TITANIUMINGOT_DEFAULT).getInt() - 256;
        Ids.RUBY = configuration.getItem(Configuration.CATEGORY_ITEM, "Ruby ID", Ids.RUBY_DEFAULT).getInt() - 256;
        Ids.RUBY_SWORD = configuration.getItem(Configuration.CATEGORY_ITEM, "Ruby Sword ID", Ids.RUBY_SWORD_DEFAULT).getInt() - 256;
        Ids.RUBY_PICKAXE = configuration.getItem(Configuration.CATEGORY_ITEM, "Ruby Pickaxe ID", Ids.RUBY_PICKAXE_DEFAULT).getInt() - 256;
        Ids.RUBY_SPADE = configuration.getItem(Configuration.CATEGORY_ITEM, "Ruby Shovel ID", Ids.RUBY_SPADE_DEFAULT).getInt() - 256;
        Ids.RUBY_AXE = configuration.getItem(Configuration.CATEGORY_ITEM, "Ruby Axe ID", Ids.RUBY_AXE_DEFAULT).getInt() - 256;
        Ids.RUBY_HOE = configuration.getItem(Configuration.CATEGORY_ITEM, "Ruby Hoe ID", Ids.RUBY_HOE_DEFAULT).getInt() - 256;
        Ids.RUBY_WAND = configuration.getItem(Configuration.CATEGORY_ITEM, "Ruby Wand ID", Ids.RUBY_WAND_DEFAULT).getInt() - 256;
        Ids.CARD = configuration.getItem(Configuration.CATEGORY_ITEM, "Card Id", Ids.CARD_DEFAULT).getInt() - 256;
        Ids.DEATHSTONES = configuration.getItem(Configuration.CATEGORY_ITEM, "Deathstones ID", Ids.DEATHSTONES_DEFAULT).getInt() - 256;
        Ids.WAND = configuration.getItem(Configuration.CATEGORY_ITEM, "Wand ID", Ids.WAND_DEFAULT).getInt() - 256;

        // Ruby Armor
        Ids.RUBY_HELMET = configuration.getItem("Armor", "Ruby Helmet ID", Ids.RUBY_HELMET_DEFAULT).getInt() - 256;
        Ids.RUBY_CHESTPLATE = configuration.getItem("Armor", "Ruby Chestplate ID", Ids.RUBY_CHESTPLATE_DEFAULT).getInt() - 256;
        Ids.RUBY_LEGGINGS = configuration.getItem("Armor", "Ruby Leggings ID", Ids.RUBY_LEGGINGS_DEFAULT).getInt() - 256;
        Ids.RUBY_BOOTS = configuration.getItem("Armor", "Ruby Boots ID", Ids.RUBY_BOOTS_DEFAULT).getInt() - 256;

        Constants.Armor.RUBY_HELMET_REDUCTION = configuration.get("Armor", "Ruby Helmet Damage Reduction", Constants.Armor.RUBY_HELMET_REDUCTION_DEFAULT).getInt();
        Constants.Armor.RUBY_CHESTPLATE_REDUCTION = configuration.get("Armor", "Ruby Chestplate Damage Reduction", Constants.Armor.RUBY_CHESTPLATE_REDUCTION_DEFAULT).getInt();
        Constants.Armor.RUBY_LEGGINGS_REDUCTION = configuration.get("Armor", "Ruby Leggings Damage Reduction", Constants.Armor.RUBY_LEGGINGS_REDUCTION_DEFAULT).getInt();
        Constants.Armor.RUBY_BOOTS_REDUCTION = configuration.get("Armor", "Ruby Boots Damage Reduction", Constants.Armor.RUBY_BOOTS_REDUCTION_DEFAULT).getInt();

        configuration.save();

    }
}
