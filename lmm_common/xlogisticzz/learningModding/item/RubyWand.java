package xlogisticzz.learningModding.item;

import java.util.List;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import xlogisticzz.learningModding.creativeTab.CreativeTab;
import xlogisticzz.learningModding.lib.Constants;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class RubyWand extends Item {

    @SideOnly(Side.CLIENT)
    private Icon chargedIcon;

    public RubyWand(int id) {
        super(id);
        setCreativeTab(CreativeTab.tabLearningModding);
        setMaxStackSize(1);
        setUnlocalizedName(Constants.UnLocalisedNames.RUBY_WAND);
    }

    @Override
    public boolean func_111207_a(ItemStack itemstack, EntityPlayer player, EntityLivingBase target) {
        if (!target.worldObj.isRemote) {
            target.motionY = 2;
            if (isCharged(itemstack.getItemDamage())) {
                target.motionX = (target.posX - player.posX) * 2;
                target.motionZ = (target.posZ - player.posZ) * 2;
                itemstack.setItemDamage(0);
            } else {
                itemstack.setItemDamage(itemstack.getItemDamage() + 1);
            }
        }

        return false;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister register) {
        itemIcon = register.registerIcon(Constants.Mod.MODID + ":" + Constants.Icons.WAND);
        chargedIcon = register.registerIcon(Constants.Mod.MODID + ":" + Constants.Icons.WAND_CHARGED);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack itemstack, EntityPlayer player, List info, boolean useExtraInfo) {
        info.add("This fun thing has been used " + itemstack.getItemDamage() + " times");
        if (isCharged(itemstack.getItemDamage())) {
            info.add("This item is charged");
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public Icon getIconFromDamage(int dmg) {
        if (isCharged(dmg)) {
            return chargedIcon;
        } else {
            return itemIcon;
        }
    }

    private boolean isCharged(int dmg) {
        return dmg >= 10;
    }
}
