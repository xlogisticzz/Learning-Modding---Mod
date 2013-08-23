package xlogisticzz.learningModding.Items;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import xlogisticzz.learningModding.LearningModdingCreativeTab;
import xlogisticzz.learningModding.Lib.Constants;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemWand extends Item {

    public ItemWand(int par1) {
        super(par1);
        this.setCreativeTab(LearningModdingCreativeTab.tabLearningModding);
        this.setUnlocalizedName(Constants.UnLocalisedNames.WAND);
        this.setMaxDamage(1);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1IconRegister) {
        itemIcon = par1IconRegister.registerIcon(Constants.Mod.MODID + ":" + Constants.Icons.WAND);
    }

    @Override
    public boolean func_111207_a(ItemStack stack, EntityPlayer player, EntityLivingBase target) {

        if (target instanceof EntityCreeper) {
            ((EntityCreeper) target).setEntityHealth(0);
            player.addPotionEffect(new PotionEffect(Potion.confusion.id, 100, 5));
            player.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 50, 5));
            if (!player.worldObj.isRemote) {
                player.entityDropItem(new ItemStack(ModItems.deathstone, 1, 0), 1F);
            }
            if (!player.capabilities.isCreativeMode) {
                --stack.stackSize;
            }
            return true;
        } else if (target instanceof EntityEnderman) {
            ((EntityEnderman) target).setEntityHealth(0);
            player.addPotionEffect(new PotionEffect(Potion.confusion.id, 100, 5));
            player.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 50, 5));
            if (!player.worldObj.isRemote) {
                player.entityDropItem(new ItemStack(ModItems.deathstone, 1, 1), 1F);
            }
            if (!player.capabilities.isCreativeMode) {
                --stack.stackSize;
            }
            return true;
        } else if (target instanceof EntityPig) {
            ((EntityPig) target).setEntityHealth(0);
            player.addPotionEffect(new PotionEffect(Potion.confusion.id, 100, 5));
            player.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 50, 5));
            if (!player.worldObj.isRemote) {
                player.entityDropItem(new ItemStack(ModItems.deathstone, 1, 2), 1F);
            }
            if (!player.capabilities.isCreativeMode) {
                --stack.stackSize;
            }
            return true;
        } else if (target instanceof EntityPlayer) {
            ((EntityPlayer) target).setEntityHealth(0);
            player.addPotionEffect(new PotionEffect(Potion.confusion.id, 100, 5));
            player.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 50, 5));
            if (!player.worldObj.isRemote) {
                player.entityDropItem(new ItemStack(ModItems.deathstone, 1, 3), 1F);
            }
            if (!player.capabilities.isCreativeMode) {
                --stack.stackSize;
            }
            return true;
        } else if (target instanceof EntitySkeleton) {
            ((EntitySkeleton) target).setEntityHealth(0);
            player.addPotionEffect(new PotionEffect(Potion.confusion.id, 100, 5));
            player.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 50, 5));
            if (!player.worldObj.isRemote) {
                player.entityDropItem(new ItemStack(ModItems.deathstone, 1, 4), 1F);
            }
            if (!player.capabilities.isCreativeMode) {
                --stack.stackSize;
            }
            return true;
        } else {
            return false;
        }
    }

}
