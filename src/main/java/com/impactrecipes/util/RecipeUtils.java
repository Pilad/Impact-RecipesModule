package com.impactrecipes.util;

import cpw.mods.fml.common.registry.GameRegistry;
import gregtech.api.GregTech_API;
import gregtech.api.commands.RecipesReload;
import gregtech.api.enums.GT_Values;
import gregtech.api.util.GT_Utility;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;

import java.util.ArrayList;

import static gregtech.api.util.GT_ModHandler.*;

/**
 * Как ни странно, класс для каких-либо утилит
 */
public class RecipeUtils {

    /**
     * @param loader - класс с рецептами
     */
    public static void registerRecipeClass(Class cl) {
        String clasStr = cl.getName();
        clasStr = clasStr.replaceAll("class", "");
        String[] text = clasStr.split("\\.");
        RecipesReload.classMap.put(text[text.length - 1], cl);
    }

    /**
     * @param oredict - ордикт
     * @param amount - количество
     * @return ItemStack
     */
    public static ItemStack ordictItemStack(String oredict, int amount) {
        return GregTech_API.getStackofAmountFromOreDict(oredict, amount);
    }

    /**
     * @param oredict - ордикт
     * @return ItemStack
     * По умолчанию выдает количество = 1
     */
    public static ItemStack ordictItemStack(String oredict) {
        return GregTech_API.getStackofAmountFromOreDict(oredict, 1);
    }

    /**
     * @param modid - ID / название мода
     * @param nameItem - наименование предмета
     * @param amount - количество
     * @param meta - метадата предмета
     * @return ItemStack
     */
    public static ItemStack getItemStack(String modid, String nameItem, int amount, int meta) {
        return new ItemStack(GameRegistry.findItem(modid, nameItem), amount, meta);
    }

    /**
     * @param modid - ID / название мода
     * @param nameItem - наименование предмета
     * @param amount - количество
     * @return ItemStack
     */
    public static ItemStack getItemStack(String modid, String nameItem, int amount) {
       return getItemStack(modid, nameItem, amount, 0);
    }

    /**
     * @param modid - ID / название мода
     * @param nameItem - наименование предмета
     * @return ItemStack
     */
    public static ItemStack getItemStack(String modid, String nameItem) {
        return getItemStack(modid, nameItem, 1);
    }

    /**
     * @param modid - ID / название мода
     * @param nameItem - наименование предмета
     * @param amount - количество
     * @return ItemStack
     */
    public static ItemStack getChargeItemStack(String modid, String nameItem, int amount) {
        return getModItem(modid, nameItem, amount, GT_Values.W);
    }

    /**
     * @param modid - ID / название мода
     * @param nameItem - наименование предмета
     * @return ItemStack
     */
    public static ItemStack getChargeItemStack(String modid, String nameItem) {
        return getModItem(modid, nameItem, 1, GT_Values.W);
    }

    /**
     * @param is - ItemStack Output Recipe
     */
    @SuppressWarnings("unchecked")
    public static void removeRecipeByOutput(ItemStack is) {
        ArrayList<IRecipe> tList = (ArrayList<IRecipe>) CraftingManager.getInstance().getRecipeList();
        tList.removeIf(next -> GT_Utility.areStacksEqual(is, next.getRecipeOutput(), true));
    }
}
