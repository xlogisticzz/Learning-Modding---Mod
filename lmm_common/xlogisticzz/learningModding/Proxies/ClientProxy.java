package xlogisticzz.learningModding.Proxies;

import net.minecraft.client.renderer.entity.RenderSnowball;
import xlogisticzz.learningModding.Client.RenderSpaceship;
import xlogisticzz.learningModding.Entities.EntityBlockEntityTeleport;
import xlogisticzz.learningModding.Entities.EntityPigConverter;
import xlogisticzz.learningModding.Entities.EntitySpaceship;
import xlogisticzz.learningModding.Items.ModItems;
import cpw.mods.fml.client.registry.RenderingRegistry;

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

public class ClientProxy extends CommonProxy {
    
    @Override
    public void initSounds() {
    
    }
    
    @Override
    public void initRenderers() {
    
        RenderingRegistry.registerEntityRenderingHandler(EntitySpaceship.class, new RenderSpaceship());
        RenderingRegistry.registerEntityRenderingHandler(EntityPigConverter.class, new RenderSnowball(ModItems.pigConverter));
        RenderingRegistry.registerEntityRenderingHandler(EntityBlockEntityTeleport.class, new RenderSnowball(ModItems.entityBlockTeleporter));

    }
    
}
