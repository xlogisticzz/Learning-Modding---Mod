package xlogisticzz.learningModding.item;

import cpw.mods.fml.common.registry.LanguageRegistry;
import xlogisticzz.learningModding.lib.Ids;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ModItems {
	//Mod Items
		public static Item titanitumIngot;
		public static Item ruby;

		
		 public static void init() {
		
			 titanitumIngot = new Items(Ids.TITANIUMINGOT, CreativeTabs.tabMaterials, 64, "titanitum_ingot", "titanitumIngot");
			 ruby = new Items(Ids.RUBY, CreativeTabs.tabMaterials, 64, "ruby", "ruby");

			 
			 
			 
			 
			 LanguageRegistry.addName(ruby, "Ruby");
			 LanguageRegistry.addName(titanitumIngot, "Titanium Ingot");
		 }
}
