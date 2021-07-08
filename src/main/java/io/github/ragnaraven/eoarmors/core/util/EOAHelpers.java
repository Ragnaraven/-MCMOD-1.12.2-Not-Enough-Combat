package io.github.ragnaraven.eoarmors.core.util;

import io.github.ragnaraven.eoarmors.common.items.EOAItems;
import io.github.ragnaraven.eoarmors.common.items.armor.ArmorEnderObsidian;
import io.github.ragnaraven.eoarmors.common.items.armor.ArmorObsidian;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class EOAHelpers {

    //Armor level
    //Pick level
    //Block level
    public static final int LEVEL_OBSIDIAN = 0;
    public static final int LEVEL_ENDER_OBSIDIAN = 1;

    /**Check for NULL before calling**/
    public static int checkArmor (PlayerEntity player)
    {
        int initArmor = -1;
        int armor = -1; //0 is obsidian, 1 is enderObsidian

        for (int i = 0; i < 4; i++)
        {
            if(initArmor != armor)
                return -1;
            else if (player.inventory.armor.get(i) == ItemStack.EMPTY)
                return -1;
            else if (player.inventory.armor.get(i).getItem() instanceof ArmorObsidian)
                armor = LEVEL_OBSIDIAN;
            else if (player.inventory.armor.get(i).getItem() instanceof ArmorEnderObsidian)
                armor = LEVEL_ENDER_OBSIDIAN;
            else
                return -1;

            if(initArmor == -1) //Only is allowed to be set once. If it changes, the armor is not the same as the other, therefore not a full set.
                initArmor = armor;
        }

        return armor;
    }

    public static int checkPick (PlayerEntity player)
    {
        int pick = -1; //0 is obsidian, 1 is enderObsidian

        if(player.getMainHandItem() != ItemStack.EMPTY)
            if(player.getMainHandItem().getItem() == EOAItems.OBSIDIAN_PICKAXE.get())
                pick = LEVEL_OBSIDIAN;
            else if(player.getMainHandItem().getItem() == EOAItems.ENDER_OBSIDIAN_PICKAXE.get())
                pick = LEVEL_ENDER_OBSIDIAN;

        return pick;
    }

    /**BE SURE TO CHECK FOR NULL CURRENTITEM*/
    public static boolean checkPickAgainstArmorSet (int armor, PlayerEntity player)
    {
        if (armor == LEVEL_OBSIDIAN)
            return player.getMainHandItem().getItem() == EOAItems.OBSIDIAN_PICKAXE.get();
        else if (armor == LEVEL_ENDER_OBSIDIAN)
            return player.getMainHandItem().getItem() == EOAItems.ENDER_OBSIDIAN_PICKAXE.get();

        return false;
    }

    /**BE SURE TO CHECK FOR NULL CURRENTITEM*/
    public static boolean checkArmorSetAgainstHeldTool (int armor, PlayerEntity player)
    {
        if (armor == 0)
            return player.getMainHandItem().getItem() == EOAItems.OBSIDIAN_AXE.get()
                    || (player.getMainHandItem().getItem() == EOAItems.OBSIDIAN_PICKAXE.get())
                    || (player.getMainHandItem().getItem() == EOAItems.OBSIDIAN_SHOVEL.get());

        else if (armor == 1)
            return player.getMainHandItem().getItem() == EOAItems.ENDER_OBSIDIAN_AXE.get()
                    || (player.getMainHandItem().getItem() == EOAItems.ENDER_OBSIDIAN_PICKAXE.get())
                    || (player.getMainHandItem().getItem() == EOAItems.ENDER_OBSIDIAN_SHOVEL.get());

        return false;

    }
}
