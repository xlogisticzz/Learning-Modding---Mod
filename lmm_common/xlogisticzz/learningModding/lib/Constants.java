package xlogisticzz.learningModding.lib;

public class Constants {

    public class Mod {

        public static final String MODID = "learningmodding";
        public static final String NAME = "Learning Modding";
        public static final String VERSION = "0.162.1.1"; // major version, mc
                                                          // version, sub
                                                          // version, build
        public static final String CHANNEL_NAME = MODID;
    }

    public class Proxies {

        public static final String CLIENT = "xlogisticzz.learningModding.proxy.ClientProxy";
        public static final String COMMON = "xlogisticzz.learningModding.proxy.CommonProxy";

    }

    public class BlockNames {

        public static final String TITANIUM_ORE_NAME = "Titanium Ore";
        public static final String RUBY_ORE_NAME = "Ruby Ore";
        public static final String TITANIUM_BLOCK_NAME = "Titanium Block";
        public static final String RUBY_BLOCK_NAME = "Ruby Block";
    }

    public static class ItemNames {

        public static final String RUBY_NAME = "Ruby";
        public static final String TITANIUM_INGOT_NAME = "Titanium Ingot";
        public static final String RUBY_PICKAXE_NAME = "Ruby Pickaxe";
        public static final String RUBY_SPADE_NAME = "Ruby Shovel";
        public static final String RUBY_SWORD_NAME = "Ruby Sword";
        public static final String RUBY_AXE_NAME = "Ruby Axe";
        public static final String RUBY_HOE_NAME = "Ruby Hoe";
        public static final String RUBY_HELMET_NAME = "Ruby Helmet";
        public static final String RUBY_CHESTPLATE_NAME = "Ruby Chestplate";
        public static final String RUBY_LEGGINGS_NAME = "Ruby Leggings";
        public static final String RUBY_BOOTS_NAME = "Ruby Boots";
        public static final String RUBY_WAND_NAME = "Ruby Wand";
        public static final String[] CARD_NAMES = { "Arrow Card", "Border Card", "Cross Card" };
        public static final String[] DEATHSTONES_NAMES = { "Deathstone Creeper", "Deathstone Enderman", "Deathstone Pig", "Deathstone Player", "Deathstone Skeleton" };
        public static final String WAND_NAME = "Wand";

    }

    public static class Icons {

        // Items
        public static final String RUBY_WAND = "uncharged_wand";
        public static final String RUBY_WAND_CHARGED = "charged_wand";
        public static final String RUBY = "ruby";
        public static final String TITANIUM_INGOT = "titanium_ingot";
        public static final String RUBY_PICKAXE = "ruby_pickaxe";
        public static final String RUBY_SWORD = "ruby_sword";
        public static final String RUBY_SPADE = "ruby_spade";
        public static final String RUBY_AXE = "ruby_axe";
        public static final String RUBY_HOE = "ruby_hoe";
        public static final String[] CARD_ICONS = { "card_arrow", "card_box", "card_cross" };
        public static final String[] DEATHSTONES_ICONS = { "deathstone_creeper", "deathstone_enderman", "deathstone_pig", "deathstone_player", "deathstone_skeleton" };
        public static final String WAND = "wand";
        // Blocks
        public static final String RUBY_ORE = "ruby_ore";
        public static final String RUBY_BLOCK = "ruby_block";
        public static final String TITANIUM_ORE = "titanium_ore";
        public static final String TITANIUM_BLOCK = "titanium_block";

    }

    public class UnLocalisedNames {

        // Items
        public static final String RUBY = "ruby";
        public static final String TITANIUM_INGOT = "titaniumIngot";
        public static final String RUBY_PICKAXE = "rubyPickaxe";
        public static final String RUBY_SWORD = "rubySword";
        public static final String RUBY_SPADE = "rubySpade";
        public static final String RUBY_AXE = "rubyAxe";
        public static final String RUBY_HOE = "rubyHoe";
        public static final String RUBY_HELMET = "rubyHelmet";
        public static final String RUBY_CHESTPLATE = "rubyChestplate";
        public static final String RUBY_LEGGINGS = "rubyLeggings";
        public static final String RUBY_BOOTS = "rubyBoots";
        public static final String RUBY_WAND = "rubyWand";
        public static final String CARD = "card";
        public static final String DEATHSTONE = "deathstone";
        public static final String WAND = "wand";

        // Blocks
        public static final String RUBY_ORE = "rubyOre";
        public static final String RUBY_BLOCK = "rubyBlock";
        public static final String TITANIUM_ORE = "titaniumOre";
        public static final String TITANIUM_BLOCK = "titaniumBlock";

    }

    public static class Misc {

        public static final int RUBY_DURABILITY = 1000;

    }

    public static class Armor {

        public static int RUBY_HELMET_REDUCTION;
        public static final int RUBY_HELMET_REDUCTION_DEFAULT = 4;
        public static int RUBY_BOOTS_REDUCTION;
        public static final int RUBY_BOOTS_REDUCTION_DEFAULT = 4;
        public static int RUBY_CHESTPLATE_REDUCTION;
        public static final int RUBY_CHESTPLATE_REDUCTION_DEFAULT = 10;
        public static int RUBY_LEGGINGS_REDUCTION;
        public static final int RUBY_LEGGINGS_REDUCTION_DEFAULT = 8;

    }
}
