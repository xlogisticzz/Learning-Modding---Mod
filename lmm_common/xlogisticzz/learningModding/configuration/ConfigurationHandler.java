package xlogisticzz.learningModding.configuration;

import java.io.File;

import net.minecraftforge.common.Configuration;
import xlogisticzz.learningModding.lib.Ids;

public class ConfigurationHandler {

    public static Configuration configuration;

    public static void init(File configFile) {

        configuration = new Configuration(configFile);

        configuration.load();

        // Block IDs
        Ids.TITANIUMORE = configuration.get(Configuration.CATEGORY_BLOCK,
                "Titanium Ore ID", Ids.TITANIUMORE_DEFAULT).getInt();
        Ids.RUBYORE = configuration.get(Configuration.CATEGORY_BLOCK,
                "Ruby Ore ID", Ids.RUBYORE_DEFAULT).getInt();
        Ids.RUBYBLOCK = configuration.get(Configuration.CATEGORY_BLOCK,
                "Ruby Block ID", Ids.RUBYBLOCK_DEFAULT).getInt();
        Ids.TITANIUMBLOCK = configuration.get(Configuration.CATEGORY_BLOCK,
                "Titanium ID", Ids.TITANIUMBLOCK_DEFAULT).getInt();

        // Item IDs
        Ids.TITANIUMINGOT = configuration.get(Configuration.CATEGORY_ITEM,
                "Titanium Ingot ID", Ids.TITANIUMINGOT_DEFAULT).getInt();
        Ids.RUBY = configuration.get(Configuration.CATEGORY_ITEM, "Ruby ID",
                Ids.RUBY_DEFAULT).getInt();
        Ids.RUBY_SWORD = configuration.get(Configuration.CATEGORY_ITEM,
                "Ruby Sword ID", Ids.RUBY_SWORD_DEFAULT).getInt();
        Ids.RUBY_PICKAXE = configuration.get(Configuration.CATEGORY_ITEM,
                "Ruby Pickaxe ID", Ids.RUBY_PICKAXE_DEFAULT).getInt();
        Ids.RUBY_SPADE = configuration.get(Configuration.CATEGORY_ITEM,
                "Ruby Shovel ID", Ids.RUBY_SPADE_DEFAULT).getInt();
        Ids.RUBY_AXE = configuration.get(Configuration.CATEGORY_ITEM,
                "Ruby Axe ID", Ids.RUBY_AXE_DEFAULT).getInt();
        Ids.RUBY_HOE = configuration.get(Configuration.CATEGORY_ITEM,
                "Ruby Hoe ID", Ids.RUBY_HOE_DEFAULT).getInt();
        Ids.RUBY_HELMET = configuration.get(Configuration.CATEGORY_ITEM,
                "Ruby Helmet ID", Ids.RUBY_HELMET_DEFAULT).getInt();
        Ids.RUBY_CHESTPLATE = configuration.get(Configuration.CATEGORY_ITEM,
                "Ruby Chestplate ID", Ids.RUBY_CHESTPLATE_DEFAULT).getInt();
        Ids.RUBY_LEGGINGS = configuration.get(Configuration.CATEGORY_ITEM,
                "Ruby Leggings ID", Ids.RUBY_LEGGINGS_DEFAULT).getInt();
        Ids.RUBY_BOOTS = configuration.get(Configuration.CATEGORY_ITEM,
                "Ruby Boots ID", Ids.RUBY_BOOTS_DEFAULT).getInt();

        configuration.save();

    }
}
