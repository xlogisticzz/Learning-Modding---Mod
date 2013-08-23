package xlogisticzz.learningModding.Items;

import java.util.List;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import xlogisticzz.learningModding.LearningModdingCreativeTab;
import xlogisticzz.learningModding.Lib.Constants;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemDeathstone extends Item {

    @SideOnly(Side.CLIENT)
    public Icon[] icons;

    public ItemDeathstone(int par1) {
        super(par1);
        this.setCreativeTab(LearningModdingCreativeTab.tabLearningModding);
        this.setHasSubtypes(true);
    }

    @Override
    public String getUnlocalizedName(ItemStack par1ItemStack) {
        return Constants.UnLocalisedNames.DEATHSTONE + par1ItemStack.getItemDamage();
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister register) {
        icons = new Icon[Constants.Icons.DEATHSTONES_ICONS.length];

        for (int i = 0; i < Constants.Icons.DEATHSTONES_ICONS.length; i++) {
            icons[i] = register.registerIcon(Constants.Mod.MODID + ":" + Constants.Icons.DEATHSTONES_ICONS[i]);
        }
    }

    @Override
    public Icon getIconFromDamage(int par1) {
        return icons[par1];
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override
    @SideOnly(Side.CLIENT)
    public void getSubItems(int par1, CreativeTabs par2CreativeTabs, List par3List) {
        for (int i = 0; i < Constants.ItemNames.DEATHSTONES_NAMES.length; i++) {
            par3List.add(new ItemStack(par1, 1, i));
        }
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {

        /* DAMAGE VALUES START AT 0 */
        if (par1ItemStack.getItemDamage() == Constants.ItemNames.DEATHSTONES_NAMES.length - 1) {

            par3List.add("Next Item crafted is " + Constants.ItemNames.DEATHSTONES_NAMES[0]);

        } else {
            par3List.add("Next Item crafted is " + Constants.ItemNames.DEATHSTONES_NAMES[par1ItemStack.getItemDamage() + 1]);

        }
    }

    @Override
    public boolean hitEntity(ItemStack par1ItemStack, EntityLivingBase par2EntityLivingBase, EntityLivingBase par3EntityLivingBase) {

        int id = par1ItemStack.getItemDamage();

        switch (id) {

            case 0:
                if (par2EntityLivingBase instanceof EntityCreeper) {
                    par2EntityLivingBase.setEntityHealth(0);
                    return true;
                } else {
                    return false;
                }
            case 1:
                if (par2EntityLivingBase instanceof EntityEnderman) {
                    par2EntityLivingBase.setEntityHealth(0);
                    return true;
                } else {
                    return false;
                }
            case 2:
                if (par2EntityLivingBase instanceof EntityPig) {
                    par2EntityLivingBase.setEntityHealth(0);
                    return true;
                } else {
                    return false;
                }
            case 3:
                if (par2EntityLivingBase instanceof EntityPlayer) {
                    par2EntityLivingBase.setEntityHealth(0);
                    return true;
                } else {
                    return false;
                }
            case 4:
                if (par2EntityLivingBase instanceof EntitySkeleton) {
                    par2EntityLivingBase.setEntityHealth(0);
                    return true;
                } else {
                    return false;
                }

            default:
                return false;
        }

    }
}
