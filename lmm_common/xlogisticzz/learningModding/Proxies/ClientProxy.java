package xlogisticzz.learningModding.Proxies;

import xlogisticzz.learningModding.Client.RenderSpaceship;
import xlogisticzz.learningModding.Entities.EntitySpaceship;
import cpw.mods.fml.client.registry.RenderingRegistry;

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
