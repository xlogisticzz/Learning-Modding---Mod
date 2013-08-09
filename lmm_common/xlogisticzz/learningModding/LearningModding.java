package xlogisticzz.learningModding;

import java.io.File;


import xlogisticzz.learningModding.blocks.ModBlocks;
import xlogisticzz.learningModding.configuration.ConfigurationHandler;
import xlogisticzz.learningModding.item.ModItems;
import xlogisticzz.learningModding.lib.Constants;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.network.NetworkMod;



@Mod(modid = Constants.MOD.MODID , name = Constants.MOD.MODID , version = Constants.MOD.VERSION)
@NetworkMod(channels = Constants.MOD.CHANNEL_NAME , clientSideRequired = true , serverSideRequired = false)
public class LearningModding {

	
	
	// Says where the client and server 'proxy' code is loaded.
//    @SidedProxy(clientSide=Constants.PROXY.CLIENT, serverSide=Constants.PROXY.COMMON)
	
	
	@Instance
	public static LearningModding instance;
	
	
	@EventHandler
	public void PreInt(FMLPreInitializationEvent event){
		
		ConfigurationHandler.init(new File(event.getModConfigurationDirectory()
				.getAbsolutePath()
				+ File.separator
				+ Constants.MOD.CHANNEL_NAME
				+ File.separator + Constants.MOD.MODID + ".cfg"));
		
		
		ModItems.init();
		ModBlocks.init();
		
		//vanilla recipies
		
		xlogisticzz.learningModding.Crafting.Vanilla.init();
		
		
		
	}
	
	@EventHandler
	public void load(FMLInitializationEvent event){
		
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event){
		
	}
	
	@EventHandler
	public void serverStarting(FMLServerStartingEvent event){
		
	}
	
	
	
	
	
	
	
	
	
	
	
}
