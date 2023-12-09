package com.impactrecipes.recipes;

import com.impactrecipes.util.RecipeUtils;
import gregtech.api.enums.GT_Values;
import gregtech.api.enums.ItemList;
import gregtech.api.util.GT_ModHandler;

import static com.impactrecipes.util.RecipeUtils.getItemStack;

public class NuclearControl implements Runnable {

    private static final long tBitMask = GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE;

    @Override
    public void run() {
        RecipeUtils.removeRecipeByOutput(getItemStack("minecraft", "stone_button"));
        // --- Remote Sensor Kit
        GT_ModHandler.addShapelessCraftingRecipe(GT_ModHandler.getModItem("IC2NuclearControl", "ItemRemoteSensorKit", 1L, 0), tBitMask, new Object[]{GT_ModHandler.getModItem("IC2NuclearControl", "ItemSensorLocationCard", 1L, 0)});
        // --- Energy Sensor Kit
        GT_ModHandler.addShapelessCraftingRecipe(GT_ModHandler.getModItem("IC2NuclearControl", "ItemEnergySensorKit", 1L, 0), tBitMask, new Object[]{GT_ModHandler.getModItem("IC2NuclearControl", "ItemEnergySensorLocationCard", 1L, 0)});
        // --- Counter Sensor Kit
        GT_ModHandler.addShapelessCraftingRecipe(GT_ModHandler.getModItem("IC2NuclearControl", "ItemMultipleSensorKit", 1L, 0), tBitMask, new Object[]{GT_ModHandler.getModItem("IC2NuclearControl", "ItemMultipleSensorLocationCard", 1L, 0)});
        // --- Liquid Sensor Kit
        GT_ModHandler.addShapelessCraftingRecipe(GT_ModHandler.getModItem("IC2NuclearControl", "ItemMultipleSensorKit", 1L, 1), tBitMask, new Object[]{GT_ModHandler.getModItem("IC2NuclearControl", "ItemMultipleSensorLocationCard", 1L, 1)});
        // --- Generator Sensor Kit
        GT_ModHandler.addShapelessCraftingRecipe(GT_ModHandler.getModItem("IC2NuclearControl", "ItemMultipleSensorKit", 1L, 2), tBitMask, new Object[]{GT_ModHandler.getModItem("IC2NuclearControl", "ItemMultipleSensorLocationCard", 1L, 2)});
        // --- GregTech Sensor Kit
        GT_ModHandler.addShapelessCraftingRecipe(ItemList.NC_SensorKit.get(1), tBitMask, new Object[]{ItemList.NC_SensorCard});
        // --- AE Sensor Kit
        GT_ModHandler.addShapelessCraftingRecipe(GT_ModHandler.getModItem("IC2NuclearControl", "KitAppeng", 1L, 0), tBitMask, new Object[]{GT_ModHandler.getModItem("IC2NuclearControl", "CardAppeng", 1L, 0)});

    }
}
