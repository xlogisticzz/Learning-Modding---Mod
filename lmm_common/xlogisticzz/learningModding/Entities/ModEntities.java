package xlogisticzz.learningModding.Entities;

import xlogisticzz.learningModding.LearningModding;
import cpw.mods.fml.common.registry.EntityRegistry;

public class ModEntities {

    /* Register Entities */
    public static void init() {
        EntityRegistry.registerModEntity(EntitySpaceship.class, "EntitySpaceship", 0, LearningModding.instance, 80, 3, true);
        EntityRegistry.registerModEntity(EntityBomb.class, "EntityBomb", 1, LearningModding.instance, 80, 3, false);

    }
    
    /* Register Entity Info */
    public static void initInfo() {
        
    }

}
