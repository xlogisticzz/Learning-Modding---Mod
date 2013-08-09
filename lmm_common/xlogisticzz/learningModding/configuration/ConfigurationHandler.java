package xlogisticzz.learningModding.configuration;

import java.io.File;

import xlogisticzz.learningModding.lib.Ids;

import net.minecraftforge.common.Configuration;

public class ConfigurationHandler {
	
	public static Configuration configuration;
	
	public static void init(File configFile){
	
	configuration = new Configuration(configFile);
		
	configuration.load();
	
	//Block IDs
	Ids.TITANIUMORE = configuration.get(Configuration.CATEGORY_BLOCK, "Titanium Ore ID", Ids.TITANIUMORE_DEFAULT).getInt();
	Ids.RUBYORE = configuration.get(Configuration.CATEGORY_BLOCK, "Ruby Ore ID", Ids.RUBYORE_DEFAULT).getInt();
	Ids.RUBYBLOCK = configuration.get(Configuration.CATEGORY_BLOCK, "Ruby Block ID", Ids.RUBYBLOCK_DEFAULT).getInt();
	Ids.TITANIUMBLOCK = configuration.get(Configuration.CATEGORY_BLOCK, "Titanium ID", Ids.TITANIUMBLOCK_DEFAULT).getInt();

	
	
	//Item IDs
	Ids.TITANIUMINGOT = configuration.get(Configuration.CATEGORY_ITEM, "Titanium Ingot ID", Ids.TITANIUMINGOT_DEFAULT).getInt();
	Ids.RUBY = configuration.get(Configuration.CATEGORY_ITEM, "Ruby ID", Ids.RUBY_DEFAULT).getInt();

	configuration.save();
	
	
	}
}
