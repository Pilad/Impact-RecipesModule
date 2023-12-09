package com.impactrecipes.recipes;

import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.util.GT_ModHandler;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

import static gregtech.api.util.GT_ModHandler.removeRecipeByOutput;

public class ArchitectureCraft implements Runnable {

    private static final long tBitMask = GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE;

    @Override
    public void run() {
        removeArchitectureCraft();
        hand();
    }

    private void removeArchitectureCraft() {
        removeRecipeByOutput(GT_ModHandler.getModItem("ArchitectureCraft", "sawbench", 1, 0), true,
                false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("ArchitectureCraft", "sawblade", 1, 0), true,
                false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("ArchitectureCraft", "largePulley", 1, 0), true,
                false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("ArchitectureCraft", "hammer", 1, 0), true, false,
                true);
        removeRecipeByOutput(GT_ModHandler.getModItem("ArchitectureCraft", "chisel", 1, 0), true, false,
                true);
    }

    private void hand() {
        // --- Architecs Saw Bench
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("ArchitectureCraft", "sawbench", 1L), tBitMask, new Object[]{"SPS", "BAB", "sLh", 'S', OrePrefixes.screw.get(Materials.Steel), 'P', GT_ModHandler.getModItem("minecraft", "heavy_weighted_pressure_plate", 1L), 'B', new ItemStack(Blocks.fence), 'A', GT_ModHandler.getModItem("ArchitectureCraft", "sawblade", 1L), 'L', GT_ModHandler.getModItem("ArchitectureCraft", "largePulley", 1L)});
        // --- Large Pulley
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("ArchitectureCraft", "largePulley", 1L), tBitMask, new Object[]{"SdS", "GWG", "ShS", 'S', OrePrefixes.screw.get(Materials.Steel), 'G', OrePrefixes.gearGtSmall.get(Materials.Iron), 'W', OrePrefixes.gearGt.get(Materials.Wood)});
        // --- Architecs Hammer
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("ArchitectureCraft", "hammer", 1L), tBitMask, new Object[]{"PPI", "fSI", " Sh", 'S', OrePrefixes.stick.get(Materials.Wood), 'P', OrePrefixes.plate.get(Materials.Steel), 'I', OrePrefixes.ingot.get(Materials.Iron)});
        // --- Architecs Chisel
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("ArchitectureCraft", "chisel", 1L), tBitMask, new Object[]{"hIP", "SKI", "WSd", 'S', OrePrefixes.screw.get(Materials.Iron), 'P', OrePrefixes.plate.get(Materials.Steel), 'I', OrePrefixes.plate.get(Materials.Iron), 'K', OrePrefixes.stick.get(Materials.Iron), 'W', OrePrefixes.stick.get(Materials.Wood)});
        // --- Circular Saw
        GT_ModHandler.addShapelessCraftingRecipe(GT_ModHandler.getModItem("ArchitectureCraft", "sawblade", 1L, 0), tBitMask, new Object[]{OrePrefixes.toolHeadBuzzSaw.get(Materials.Iron)});

    }
}
