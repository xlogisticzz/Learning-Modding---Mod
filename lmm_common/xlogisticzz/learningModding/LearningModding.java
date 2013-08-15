package xlogisticzz.learningModding;

import java.io.File;

import xlogisticzz.learningModding.Crafting.Vanilla;
import xlogisticzz.learningModding.blocks.ModBlocks;
import xlogisticzz.learningModding.configuration.ConfigurationHandler;
import xlogisticzz.learningModding.item.ModItems;
import xlogisticzz.learningModding.lib.Constants;
import xlogisticzz.learningModding.network.PacketHandler;
import xlogisticzz.learningModding.proxy.CommonProxy;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid = Constants.Mod.MODID, name = Constants.Mod.MODID, version = Constants.Mod.VERSION)
@NetworkMod(channels = Constants.Mod.CHANNEL_NAME, clientSideRequired = true, serverSideRequired = false, packetHandler = PacketHandler.class)
public class LearningModding {

    // Says where the client and server 'proxy' code is loaded.
    @SidedProxy(clientSide = Constants.Proxies.CLIENT, serverSide = Constants.Proxies.COMMON)
    public static CommonProxy proxy;

    @Instance
    public static LearningModding instance;

    @EventHandler
    public void PreInt(FMLPreInitializationEvent event) {

        ConfigurationHandler.init(new File(event.getModConfigurationDirectory().getAbsolutePath() + File.separator + Constants.Mod.CHANNEL_NAME + File.separator + Constants.Mod.MODID + ".cfg"));

        ModItems.init();
        ModBlocks.init();

        proxy.initSounds();
        proxy.initRenderers();

    }

    @EventHandler
    public void load(FMLInitializationEvent event) {
        ModItems.initLang();
        ModBlocks.initInfo();
        Vanilla.init();

        LanguageRegistry.instance().addStringLocalization("itemGroup.tabLearningModding", "en_US", "Learning Modding");

    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {

    }

    @EventHandler
    public void serverStarting(FMLServerStartingEvent event) {

    }

}
