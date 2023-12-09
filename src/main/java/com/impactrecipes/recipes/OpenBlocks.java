package com.impactrecipes.recipes;

import gregtech.api.enums.*;
import gregtech.api.util.GT_ModHandler;
import gregtech.api.util.GT_OreDictUnificator;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

import static gregtech.api.enums.GT_Values.RA;
import static gregtech.api.util.GT_ModHandler.removeRecipeByOutput;

public class OpenBlocks implements Runnable {

    private static final long tBitMask = GT_ModHandler.RecipeBits.BUFFERED
            | GT_ModHandler.RecipeBits.NOT_REMOVABLE;

    @Override
    public void run() {
        removeOpenBlocks();
        handRecipe();
        assemblerRecipe();
        chemicalBathRecipe();
    }

    private void removeOpenBlocks() {
        removeRecipeByOutput(
                GT_ModHandler.getModItem("OpenBlocks", "elevator", 1L, 0));
        removeRecipeByOutput(
                GT_ModHandler.getModItem("OpenBlocks", "devnull", 1L, 0));
        removeRecipeByOutput(
                GT_ModHandler.getModItem("OpenBlocks", "builder_guide", 1L, 0));
        removeRecipeByOutput(
                GT_ModHandler.getModItem("OpenBlocks", "elevator_rotating", 1L, 0));
        removeRecipeByOutput(
                GT_ModHandler.getModItem("OpenBlocks", "guide", 1L, 0));
        removeRecipeByOutput(
                GT_ModHandler.getModItem("OpenBlocks", "hangglider", 1L, 0));
        removeRecipeByOutput(
                GT_ModHandler.getModItem("OpenBlocks", "generic", 1L, 0));
        removeRecipeByOutput(
                GT_ModHandler.getModItem("OpenBlocks", "generic", 1L, 0));
    }

    private void handRecipe() {
        // --- Elevator
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("OpenBlocks", "elevator", 1L),
                tBitMask, new Object[]{"w h", "PHP", "GBG", 'P', OrePrefixes.plate.get(Materials.Steel),
                        'G', OrePrefixes.gearGtSmall.get(Materials.Steel), 'B', OrePrefixes.frameGt.get(Materials.Steel),
                        'H', new ItemStack(Blocks.heavy_weighted_pressure_plate)});
        // --- DevNull
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("OpenBlocks", "devnull", 1L),
                tBitMask, new Object[]{"dCh", "SBS", 'S', OrePrefixes.screw.get(Materials.Iron),
                        'B', OrePrefixes.frameGt.get(Materials.Iron), 'C', GT_ModHandler.getModItem("ExtraUtilities", "trashcan", 1L)});
        // --- Rotating Elevator
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("OpenBlocks", "elevator_rotating", 1L, 0),
                tBitMask, new Object[]{" S ", "GEG", "dSf", 'S', OrePrefixes.stick.get(Materials.Steel),
                        'G', OrePrefixes.gearGtSmall.get(Materials.Steel), 'E', GT_ModHandler.getModItem("OpenBlocks", "elevator", 1L, 0)});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("OpenBlocks", "elevator_rotating", 1L, 0),
                tBitMask, new Object[]{"dSf", "GEG", " S ", 'S', OrePrefixes.stick.get(Materials.Steel),
                        'G', OrePrefixes.gearGtSmall.get(Materials.Steel), 'E', GT_ModHandler.getModItem("OpenBlocks", "elevator", 1L, 0)});
        // --- Building Guide
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("OpenBlocks", "guide", 1L, 0),
                tBitMask, new Object[]{"PLP", "LOL", "PLP", 'P', OrePrefixes.plate.get(Materials.Obsidian),
                        'L', OrePrefixes.lens.get(Materials.Diamond), 'E', GT_ModHandler.getModItem("IC2", "blockLuminatorDark", 1L, 0)});
        // --- Glider
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("OpenBlocks", "hangglider", 1L, 0),
                tBitMask, new Object[]{"SSS", "GPG", "wSd", 'P', OrePrefixes.plate.get(Materials.Steel),
                        'S', OrePrefixes.screw.get(Materials.Steel), 'G', GT_ModHandler.getModItem("OpenBlocks", "generic", 1L, 0)});
        // --- Glider Wing
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("OpenBlocks", "generic", 1L, 0),
                tBitMask, new Object[]{"hSL", "SBL", "LLL", 'S', OrePrefixes.stick.get(Materials.Steel),
                        'L', new ItemStack(Items.leather), 'B', GT_ModHandler.getModItem("Backpack", "tannedLeather", 1L, 0)});
    }

    private void assemblerRecipe() {
        // --- Enhanced Builder Guide
        RA.addAssemblerRecipe(GT_ModHandler.getModItem("OpenBlocks", "guide", 1L, 0),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.EnderEye, 1L), Materials.Redstone.getMolten(288),
                GT_ModHandler.getModItem("OpenBlocks", "builder_guide", 1L, 0), 300, 64);
    }

    private void chemicalBathRecipe() {
        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < Dyes.VALUES[i].getSizeOfFluidList(); j++) {
                RA.addChemicalBathRecipe(
                        GT_ModHandler.getModItem("OpenBlocks", "elevator", 1L, GT_Values.W),
                        Dyes.VALUES[i].getFluidDye(j, 144L),
                        GT_ModHandler.getModItem("OpenBlocks", "elevator", 1L, 15 - i),
                        GT_Values.NI, GT_Values.NI, null, 200, 2);
                RA.addChemicalBathRecipe(
                        GT_ModHandler.getModItem("OpenBlocks", "elevator_rotating", 1L, GT_Values.W),
                        Dyes.VALUES[i].getFluidDye(j, 144L),
                        GT_ModHandler.getModItem("OpenBlocks", "elevator_rotating", 1L, 15 - i),
                        GT_Values.NI, GT_Values.NI, null, 200, 2);
            }
        }
    }
}
