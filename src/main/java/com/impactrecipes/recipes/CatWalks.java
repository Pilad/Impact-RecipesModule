package com.impactrecipes.recipes;

import gregtech.api.enums.*;
import gregtech.api.util.GT_ModHandler;
import gregtech.api.util.GT_OreDictUnificator;
import gregtech.api.util.GT_Utility;
import net.minecraft.item.ItemStack;

import static gregtech.api.enums.GT_Values.RA;
import static gregtech.api.util.GT_ModHandler.removeRecipeByOutput;

public class CatWalks implements Runnable {

    private static final long tBitMask = GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE;

    @Override
    public void run() {
        removeCatWalks();
        hand();
        assembler();
        laser();
    }

    private void removeCatWalks() {
        removeRecipeByOutput(GT_ModHandler.getModItem("catwalks", "support_column", 1L), true, false,
                false);
        removeRecipeByOutput(GT_ModHandler.getModItem("catwalks", "sturdy_rail_powered", 1L), true, false,
                false);
        removeRecipeByOutput(GT_ModHandler.getModItem("catwalks", "cagedLadder_north_unlit", 1L), true, false,
                false);
        removeRecipeByOutput(GT_ModHandler.getModItem("catwalks", "scaffold", 1L), true, false,
                false);
        removeRecipeByOutput(GT_ModHandler.getModItem("catwalks", "sturdy_rail_detector", 1L), true, false,
                false);
        removeRecipeByOutput(GT_ModHandler.getModItem("catwalks", "catwalk_unlit", 1L), true, false,
                false);
        removeRecipeByOutput(GT_ModHandler.getModItem("catwalks", "sturdy_rail", 1L), true, false,
                false);
        removeRecipeByOutput(GT_ModHandler.getModItem("catwalks", "sturdy_rail_activator", 1L), true, false,
                false);
        removeRecipeByOutput(GT_ModHandler.getModItem("catwalks", "ropeLight", 1L), true, false,
                false);
        removeRecipeByOutput(GT_ModHandler.getModItem("catwalks", "steelgrate", 1L), true, false,
                false);
        removeRecipeByOutput(GT_ModHandler.getModItem("catwalks", "blowtorch", 1L), true, false,
                false);
    }

    private void hand() {
        // --- Catwalk
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("catwalks", "catwalk_unlit", 6L), tBitMask,
                new Object[]{"CIC", "SCS", "dIw", 'C', GT_ModHandler.getModItem("catwalks", "steelgrate", 1L),
                        'I', OrePrefixes.stick.get(Materials.Steel), 'S', OrePrefixes.screw.get(Materials.Steel)});
        // --- Caged Ladda
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("catwalks", "cagedLadder_north_unlit", 6L), tBitMask,
                new Object[]{"CLC", "SCS", "dIw", 'C', GT_ModHandler.getModItem("catwalks", "steelgrate", 1L),
                        'I', OrePrefixes.stick.get(Materials.Steel), 'S', OrePrefixes.screw.get(Materials.Steel),
                        'L', GT_ModHandler.getModItem("minecraft", "ladder", 1L)});
        // --- Scaffold
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("catwalks", "scaffold", 1L), tBitMask,
                new Object[]{"SCS", "IdI", 'C', GT_ModHandler.getModItem("catwalks", "steelgrate", 1L),
                        'I', OrePrefixes.stick.get(Materials.Steel), 'S', OrePrefixes.screw.get(Materials.Steel)});
        GT_ModHandler.addShapelessCraftingRecipe(GT_ModHandler.getModItem("catwalks", "scaffold", 1L), tBitMask,
                new Object[]{GT_ModHandler.getModItem("catwalks", "scaffold", 1L, 1)});
        // --- Support Column
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("catwalks", "support_column", 3L), tBitMask,
                new Object[]{"SCS", "SCS", "SCS", 'C', GT_ModHandler.getModItem("catwalks", "steelgrate", 1L),
                        'S', OrePrefixes.stick.get(Materials.Steel)});
        // --- Steel Grate
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("catwalks", "steelgrate", 5L), tBitMask,
                new Object[]{"ISI", "SIS", "IdI", 'I', OrePrefixes.stick.get(Materials.Steel), 'S', OrePrefixes.screw.get(Materials.Steel)});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("catwalks", "steelgrate", 10L), tBitMask,
                new Object[]{"ISI", "SIS", "IdI", 'I', OrePrefixes.stick.get(Materials.Birmabright), 'S', OrePrefixes.screw.get(Materials.Birmabright)});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("catwalks", "steelgrate", 20L), tBitMask,
                new Object[]{"ISI", "SIS", "IdI", 'I', OrePrefixes.stick.get(Materials.StainlessSteel), 'S', OrePrefixes.screw.get(Materials.StainlessSteel)});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("catwalks", "steelgrate", 40L), tBitMask,
                new Object[]{"ISI", "SIS", "IdI", 'I', OrePrefixes.stick.get(Materials.HSLA), 'S', OrePrefixes.screw.get(Materials.HSLA)});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("catwalks", "steelgrate", 60L), tBitMask,
                new Object[]{"ISI", "SIS", "IdI", 'I', OrePrefixes.stick.get(Materials.MaragingSteel300), 'S', OrePrefixes.screw.get(Materials.MaragingSteel300)});
        // --- Blow Torch
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("catwalks", "blowtorch", 1L), tBitMask,
                new Object[]{" SF", "dIS", "Iw ", 'F', GT_ModHandler.getModItem("minecraft", "flint_and_steel", 1L),
                        'I', OrePrefixes.stick.get(Materials.Steel), 'S', OrePrefixes.screw.get(Materials.Steel)});
    }

    private void assembler() {
        // --- Catwalk Column
        RA.addAssemblerRecipe(new ItemStack[]{
                GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Steel, 3),
                GT_ModHandler.getModItem("catwalks", "steelgrate", 2L),
                GT_Utility.getIntegratedCircuit(2)}, null,
                GT_ModHandler.getModItem("catwalks", "support_column", 2L), 150, 16);
        RA.addAssemblerRecipe(new ItemStack[]{
                        GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Birmabright, 3),
                        GT_ModHandler.getModItem("catwalks", "steelgrate", 4L),
                        GT_Utility.getIntegratedCircuit(2)}, null,
                GT_ModHandler.getModItem("catwalks", "support_column", 4L), 150, 30);
        RA.addAssemblerRecipe(new ItemStack[]{
                        GT_OreDictUnificator.get(OrePrefixes.stick, Materials.StainlessSteel, 3),
                        GT_ModHandler.getModItem("catwalks", "steelgrate", 8L),
                        GT_Utility.getIntegratedCircuit(2)}, null,
                GT_ModHandler.getModItem("catwalks", "support_column", 8L), 150, 48);
        RA.addAssemblerRecipe(new ItemStack[]{
                        GT_OreDictUnificator.get(OrePrefixes.stick, Materials.HSLA, 3),
                        GT_ModHandler.getModItem("catwalks", "steelgrate", 16L),
                        GT_Utility.getIntegratedCircuit(2)}, null,
                GT_ModHandler.getModItem("catwalks", "support_column", 16L), 150, 96);
        RA.addAssemblerRecipe(new ItemStack[]{
                        GT_OreDictUnificator.get(OrePrefixes.stick, Materials.MaragingSteel300, 3),
                        GT_ModHandler.getModItem("catwalks", "steelgrate", 32L),
                        GT_Utility.getIntegratedCircuit(2)}, null,
                GT_ModHandler.getModItem("catwalks", "support_column", 32L), 150, 120);
        // --- Scaffold
        RA.addAssemblerRecipe(new ItemStack[]{
                GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Steel, 2),
                GT_ModHandler.getModItem("catwalks", "steelgrate", 1L),
                GT_Utility.getIntegratedCircuit(1)}, null,
                GT_ModHandler.getModItem("catwalks", "scaffold", 2L), 100, 16);
        RA.addAssemblerRecipe(new ItemStack[]{
                        GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Birmabright, 2),
                        GT_ModHandler.getModItem("catwalks", "steelgrate", 2L),
                        GT_Utility.getIntegratedCircuit(1)}, null,
                GT_ModHandler.getModItem("catwalks", "scaffold", 4L), 120, 30);
        RA.addAssemblerRecipe(new ItemStack[]{
                        GT_OreDictUnificator.get(OrePrefixes.stick, Materials.StainlessSteel, 2),
                        GT_ModHandler.getModItem("catwalks", "steelgrate", 4L),
                        GT_Utility.getIntegratedCircuit(1)}, null,
                GT_ModHandler.getModItem("catwalks", "scaffold", 8L), 140, 48);
        RA.addAssemblerRecipe(new ItemStack[]{
                        GT_OreDictUnificator.get(OrePrefixes.stick, Materials.HSLA, 2),
                        GT_ModHandler.getModItem("catwalks", "steelgrate", 8L),
                        GT_Utility.getIntegratedCircuit(1)}, null,
                GT_ModHandler.getModItem("catwalks", "scaffold", 16L), 160, 96);
        RA.addAssemblerRecipe(new ItemStack[]{
                        GT_OreDictUnificator.get(OrePrefixes.stick, Materials.MaragingSteel300, 2),
                        GT_ModHandler.getModItem("catwalks", "steelgrate", 16L),
                        GT_Utility.getIntegratedCircuit(1)}, null,
                GT_ModHandler.getModItem("catwalks", "scaffold", 32L), 180, 120);
        // --- Caged Ladda
        RA.addAssemblerRecipe(new ItemStack[]{
                GT_ModHandler.getModItem("catwalks", "steelgrate", 4L),
                GT_ModHandler.getModItem("minecraft", "ladder", 1L),
                GT_Utility.getIntegratedCircuit(1)}, null,
                GT_ModHandler.getModItem("catwalks", "cagedLadder_north_unlit", 6L), 300, 30);
        // --- Rope Light
        RA.addAssemblerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Steel, 2),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Glowstone, 1),
                GT_ModHandler.getModItem("catwalks", "ropeLight", 8L), 100, 16);
    }

    private void laser() {
        RA.addLaserEngraverRecipe(GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Steel, 2),
                GT_Utility.copyAmount(0, GT_OreDictUnificator.get(OrePrefixes.lens, Materials.Glass, 1)),
                GT_ModHandler.getModItem("catwalks", "steelgrate", 5L), 80, 16, false);
        RA.addLaserEngraverRecipe(GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Birmabright, 2),
                GT_Utility.copyAmount(0, GT_OreDictUnificator.get(OrePrefixes.lens, Materials.Glass, 1)),
                GT_ModHandler.getModItem("catwalks", "steelgrate", 10L), 100, 24, false);
        RA.addLaserEngraverRecipe(GT_OreDictUnificator.get(OrePrefixes.stick, Materials.StainlessSteel, 2),
                GT_Utility.copyAmount(0, GT_OreDictUnificator.get(OrePrefixes.lens, Materials.Glass, 1)),
                GT_ModHandler.getModItem("catwalks", "steelgrate", 20L), 120, 48, false);
        RA.addLaserEngraverRecipe(GT_OreDictUnificator.get(OrePrefixes.stick, Materials.HSLA, 2),
                GT_Utility.copyAmount(0, GT_OreDictUnificator.get(OrePrefixes.lens, Materials.Glass, 1)),
                GT_ModHandler.getModItem("catwalks", "steelgrate", 40L), 140, 96, false);
        RA.addLaserEngraverRecipe(GT_OreDictUnificator.get(OrePrefixes.stick, Materials.MaragingSteel300, 2),
                GT_Utility.copyAmount(0, GT_OreDictUnificator.get(OrePrefixes.lens, Materials.Glass, 1)),
                GT_ModHandler.getModItem("catwalks", "steelgrate", 60L), 160, 120, false);
    }
}
