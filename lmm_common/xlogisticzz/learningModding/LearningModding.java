package xlogisticzz.learningModding;

import java.io.File;

import net.minecraft.block.BlockDispenser;

import xlogisticzz.learningModding.Blocks.ModBlocks;
import xlogisticzz.learningModding.Configuration.ConfigurationHandler;
import xlogisticzz.learningModding.Crafting.Recipies;
import xlogisticzz.learningModding.Dispenser.DispenserBehaviourBlockEntityTeleport;
import xlogisticzz.learningModding.Entities.ModEntities;
import xlogisticzz.learningModding.Items.ModItems;
import xlogisticzz.learningModding.Lib.Constants;
import xlogisticzz.learningModding.Network.PacketHandler;
import xlogisticzz.learningModding.Proxies.CommonProxy;
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
@Mod(modid = Constants.Mod.MODID, name = Constants.Mod.MODID, version = Constants.Mod.VERSION)
@NetworkMod(channels = Constants.Mod.CHANNEL_NAME, clientSideRequired = true, serverSideRequired = false, packetHandler = PacketHandler.class)
public class LearningModding {
    
    /* Says where the client and server 'proxy' code is loaded. */
    @SidedProxy(clientSide = Constants.Proxies.CLIENT, serverSide = Constants.Proxies.COMMON)
    public static CommonProxy proxy;
    
    /* Mod instance */
    @Instance
    public static LearningModding instance;
    
    /* PreInitialization */
    @EventHandler
    public void PreInt(FMLPreInitializationEvent event) {
    
        ConfigurationHandler.init(new File(event.getModConfigurationDirectory().getAbsolutePath() + File.separator + Constants.Mod.CHANNEL_NAME + File.separator + Constants.Mod.MODID + ".cfg"));
        
        ModItems.init();
        ModBlocks.init();
        
        
        proxy.initSounds();
        proxy.initRenderers();
        
    }
    
    /* Initialisation */
    @EventHandler
    public void load(FMLInitializationEvent event) {
    
        ModEntities.init();
        ModItems.initLang();
        ModBlocks.initInfo();
        Recipies.initVanilla();
        ModEntities.initInfo();
        
        BlockDispenser.dispenseBehaviorRegistry.putObject(ModItems.entityBlockTeleporter, new DispenserBehaviourBlockEntityTeleport());

        LanguageRegistry.instance().addStringLocalization("itemGroup.tabLearningModding", "en_US", "Learning Modding");
        
    }
    
    /* PostInitialization */
    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
    
    }
    
    /* When the server starts */
    @EventHandler
    public void serverStarting(FMLServerStartingEvent event) {
    
    }
    
}
