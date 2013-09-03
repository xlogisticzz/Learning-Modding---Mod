package xlogisticzz.learningModding.Proxies;

import xlogisticzz.learningModding.Client.RenderSpaceship;
import xlogisticzz.learningModding.Entities.EntitySpaceship;
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
    
        // init all the sounds
    }
    
    @Override
    public void initRenderers() {
    
        RenderingRegistry.registerEntityRenderingHandler(EntitySpaceship.class, new RenderSpaceship());
    }
    
}
