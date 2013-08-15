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
        Ids.TITANIUMORE = configuration.get(Configuration.CATEGORY_BLOCK, "Titanium Ore ID", Ids.TITANIUMORE_DEFAULT).getInt();
        Ids.RUBYORE = configuration.get(Configuration.CATEGORY_BLOCK, "Ruby Ore ID", Ids.RUBYORE_DEFAULT).getInt();
        Ids.RUBYBLOCK = configuration.get(Configuration.CATEGORY_BLOCK, "Ruby Block ID", Ids.RUBYBLOCK_DEFAULT).getInt();
        Ids.TITANIUMBLOCK = configuration.get(Configuration.CATEGORY_BLOCK, "Titanium ID", Ids.TITANIUMBLOCK_DEFAULT).getInt();

        // Item IDs
        Ids.TITANIUMINGOT = configuration.get(Configuration.CATEGORY_ITEM, "Titanium Ingot ID", Ids.TITANIUMINGOT_DEFAULT).getInt() - 256;
        Ids.RUBY = configuration.get(Configuration.CATEGORY_ITEM, "Ruby ID", Ids.RUBY_DEFAULT).getInt() - 256;
        Ids.RUBY_SWORD = configuration.get(Configuration.CATEGORY_ITEM, "Ruby Sword ID", Ids.RUBY_SWORD_DEFAULT).getInt() - 256;
        Ids.RUBY_PICKAXE = configuration.get(Configuration.CATEGORY_ITEM, "Ruby Pickaxe ID", Ids.RUBY_PICKAXE_DEFAULT).getInt() - 256;
        Ids.RUBY_SPADE = configuration.get(Configuration.CATEGORY_ITEM, "Ruby Shovel ID", Ids.RUBY_SPADE_DEFAULT).getInt() - 256;
        Ids.RUBY_AXE = configuration.get(Configuration.CATEGORY_ITEM, "Ruby Axe ID", Ids.RUBY_AXE_DEFAULT).getInt() - 256;
        Ids.RUBY_HOE = configuration.get(Configuration.CATEGORY_ITEM, "Ruby Hoe ID", Ids.RUBY_HOE_DEFAULT).getInt() - 256;
        Ids.RUBY_WAND = configuration.get(Configuration.CATEGORY_ITEM, "Ruby Wand ID", Ids.RUBY_WAND_DEFAULT).getInt() - 256;

        // Ruby Armor
        Ids.RUBY_HELMET = configuration.get("Armor", "Ruby Helmet ID", Ids.RUBY_HELMET_DEFAULT).getInt() - 256;
        Ids.RUBY_CHESTPLATE = configuration.get("Armor", "Ruby Chestplate ID", Ids.RUBY_CHESTPLATE_DEFAULT).getInt() - 256;
        Ids.RUBY_LEGGINGS = configuration.get("Armor", "Ruby Leggings ID", Ids.RUBY_LEGGINGS_DEFAULT).getInt() - 256;
        Ids.RUBY_BOOTS = configuration.get("Armor", "Ruby Boots ID", Ids.RUBY_BOOTS_DEFAULT).getInt() - 256;

        Constants.Armor.RUBY_HELMET_REDUCTION = configuration.get("Armor", "Ruby Helmet Damage Reduction", Constants.Armor.RUBY_HELMET_REDUCTION_DEFAULT).getInt();
        Constants.Armor.RUBY_CHESTPLATE_REDUCTION = configuration.get("Armor", "Ruby Chestplate Damage Reduction", Constants.Armor.RUBY_CHESTPLATE_REDUCTION_DEFAULT).getInt();
        Constants.Armor.RUBY_LEGGINGS_REDUCTION = configuration.get("Armor", "Ruby Leggings Damage Reduction", Constants.Armor.RUBY_LEGGINGS_REDUCTION_DEFAULT).getInt();
        Constants.Armor.RUBY_BOOTS_REDUCTION = configuration.get("Armor", "Ruby Boots Damage Reduction", Constants.Armor.RUBY_BOOTS_REDUCTION_DEFAULT).getInt();

        configuration.save();

    }
}
