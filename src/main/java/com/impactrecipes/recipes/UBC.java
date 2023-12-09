package com.impactrecipes.recipes;

import gregtech.api.enums.GT_Values;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.util.GT_ModHandler;
import gregtech.api.util.GT_OreDictUnificator;
import net.minecraft.item.ItemStack;

import static com.impactrecipes.util.RecipeUtils.getItemStack;
import static gregtech.api.enums.GT_Values.RA;
import static gregtech.api.util.GT_ModHandler.removeRecipeByOutput;

public class UBC implements Runnable {

    private static final long tBitMask = GT_ModHandler.RecipeBits.BUFFERED
            | GT_ModHandler.RecipeBits.NOT_REMOVABLE;

    @Override
    public void run() {
        remove();
        hand();
        cuttingSaw();
        pulverizer();
    }

    private void remove() {
        removeRecipeByOutput(getItemStack("UndergroundBiomes", "igneousStoneBrickHalfSlab", 1, GT_Values.W), true, false, false);
        removeRecipeByOutput(getItemStack("UndergroundBiomes", "metamorphicStoneBrickHalfSlab", 1, GT_Values.W), true, false, false);
        removeRecipeByOutput(getItemStack("UndergroundBiomes", "igneousStoneHalfSlab", 1, GT_Values.W), true, false, false);
        removeRecipeByOutput(getItemStack("UndergroundBiomes", "metamorphicStoneHalfSlab", 1, GT_Values.W), true, false, false);
        removeRecipeByOutput(getItemStack("UndergroundBiomes", "igneousCobblestoneHalfSlab", 1, GT_Values.W), true, false, false);
        removeRecipeByOutput(getItemStack("UndergroundBiomes", "metamorphicCobblestoneHalfSlab", 1, GT_Values.W), true, false, false);
        removeRecipeByOutput(getItemStack("UndergroundBiomes", "sedimentaryStoneHalfSlab", 1, GT_Values.W), true, false, false);
        removeRecipeByOutput(getItemStack("UndergroundBiomes", "button", 1, GT_Values.W), true, false, false);

    }

    private void hand() {
        // --- Cobblestone
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("minecraft", "cobblestone", 4L), tBitMask, new Object[]{"BB", "BB",
                'B', "cobblestone"});

        for (int i = 0; i < 8; i++) {
            // --- Slabs
            GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("UndergroundBiomes", "igneousStoneBrickHalfSlab", 2L, i), tBitMask, new Object[]{"sB", 'B', GT_ModHandler.getModItem("UndergroundBiomes", "igneousStoneBrick", 1L, i)});
            GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("UndergroundBiomes", "metamorphicStoneBrickHalfSlab", 2L, i), tBitMask, new Object[]{"sB", 'B', GT_ModHandler.getModItem("UndergroundBiomes", "metamorphicStoneBrick", 1L, i)});
            GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("UndergroundBiomes", "igneousStoneHalfSlab", 2L, i), tBitMask, new Object[]{"sB", 'B', GT_ModHandler.getModItem("UndergroundBiomes", "igneousStone", 1L, i)});
            GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("UndergroundBiomes", "metamorphicStoneHalfSlab", 2L, i), tBitMask, new Object[]{"sB", 'B', GT_ModHandler.getModItem("UndergroundBiomes", "metamorphicStone", 1L, i)});
            GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("UndergroundBiomes", "igneousCobblestoneHalfSlab", 2L, i), tBitMask, new Object[]{"sB", 'B', GT_ModHandler.getModItem("UndergroundBiomes", "igneousCobblestone", 1L, i)});
            GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("UndergroundBiomes", "metamorphicCobblestoneHalfSlab", 2L, i), tBitMask, new Object[]{"sB", 'B', GT_ModHandler.getModItem("UndergroundBiomes", "metamorphicCobblestone", 1L, i)});
            GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("UndergroundBiomes", "sedimentaryStoneHalfSlab", 2L, i), tBitMask, new Object[]{"sB", 'B', GT_ModHandler.getModItem("UndergroundBiomes", "sedimentaryStone", 1L, i)});

            // --- Buttons
            for (int j = 0; j < 8; j++) {
                GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("UndergroundBiomes", "button", 8L, j), tBitMask, new Object[]{"sB", 'B', GT_ModHandler.getModItem("UndergroundBiomes", "metamorphicStoneHalfSlab", 1L, i)});
            }
            for (int j = 8; j < 16; j++) {
                GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("UndergroundBiomes", "button", 8L, j), tBitMask, new Object[]{"sB", 'B', GT_ModHandler.getModItem("UndergroundBiomes", "metamorphicCobblestoneHalfSlab", 1L, i)});
            }
            for (int j = 24; j < 32; j++) {
                GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("UndergroundBiomes", "button", 8L, j), tBitMask, new Object[]{"sB", 'B', GT_ModHandler.getModItem("UndergroundBiomes", "igneousStoneHalfSlab", 1L, i)});
            }
            for (int j = 32; j < 40; j++) {
                GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("UndergroundBiomes", "button", 8L, j), tBitMask, new Object[]{"sB", 'B', GT_ModHandler.getModItem("UndergroundBiomes", "igneousCobblestoneHalfSlab", 1L, i)});
            }
            for (int j = 48; j < 56; j++) {
                GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("UndergroundBiomes", "button", 8L, j), tBitMask, new Object[]{"sB", 'B', GT_ModHandler.getModItem("UndergroundBiomes", "sedimentaryStoneHalfSlab", 1L, i)});
            }

        }
    }

    private void cuttingSaw() {
        for (int i = 0; i < 8; i++) {
            // --- Slabs
            RA.addCutterRecipe(GT_ModHandler.getModItem("UndergroundBiomes", "igneousStoneBrick", 1L, i),
                    GT_ModHandler.getModItem("UndergroundBiomes", "igneousStoneBrickHalfSlab", 2L, i), GT_Values.NI, 25, 8);
            RA.addCutterRecipe(GT_ModHandler.getModItem("UndergroundBiomes", "metamorphicStoneBrick", 1L, i),
                    GT_ModHandler.getModItem("UndergroundBiomes", "metamorphicStoneBrickHalfSlab", 2L, i), GT_Values.NI, 25, 8);
            RA.addCutterRecipe(GT_ModHandler.getModItem("UndergroundBiomes", "igneousStone", 1L, i),
                    GT_ModHandler.getModItem("UndergroundBiomes", "igneousStoneHalfSlab", 2L, i), GT_Values.NI, 25, 8);
            RA.addCutterRecipe(GT_ModHandler.getModItem("UndergroundBiomes", "metamorphicStone", 1L, i),
                    GT_ModHandler.getModItem("UndergroundBiomes", "metamorphicStoneHalfSlab", 2L, i), GT_Values.NI, 25, 8);
            RA.addCutterRecipe(GT_ModHandler.getModItem("UndergroundBiomes", "igneousCobblestone", 1L, i),
                    GT_ModHandler.getModItem("UndergroundBiomes", "igneousCobblestoneHalfSlab", 2L, i), GT_Values.NI, 25, 8);
            RA.addCutterRecipe(GT_ModHandler.getModItem("UndergroundBiomes", "metamorphicCobblestone", 1L, i),
                    GT_ModHandler.getModItem("UndergroundBiomes", "metamorphicCobblestoneHalfSlab", 2L, i), GT_Values.NI, 25, 8);
            RA.addCutterRecipe(GT_ModHandler.getModItem("UndergroundBiomes", "sedimentaryStone", 1L, i),
                    GT_ModHandler.getModItem("UndergroundBiomes", "sedimentaryStoneHalfSlab", 2L, i), GT_Values.NI, 25, 8);

            // --- Buttons
            for (int j = 0; j < 8; j++) {
                RA.addCutterRecipe(GT_ModHandler.getModItem("UndergroundBiomes", "metamorphicStoneHalfSlab", 1L, i),
                        GT_ModHandler.getModItem("UndergroundBiomes", "button", 8L, j), GT_Values.NI, 12, 8);
            }
            for (int j = 8; j < 16; j++) {
                RA.addCutterRecipe(GT_ModHandler.getModItem("UndergroundBiomes", "metamorphicCobblestoneHalfSlab", 1L, i),
                        GT_ModHandler.getModItem("UndergroundBiomes", "button", 8L, j), GT_Values.NI, 12, 8);
            }
            for (int j = 24; j < 32; j++) {
                RA.addCutterRecipe(GT_ModHandler.getModItem("UndergroundBiomes", "igneousStoneHalfSlab", 1L, i),
                        GT_ModHandler.getModItem("UndergroundBiomes", "button", 8L, j), GT_Values.NI, 12, 8);
            }
            for (int j = 32; j < 40; j++) {
                RA.addCutterRecipe(GT_ModHandler.getModItem("UndergroundBiomes", "igneousCobblestoneHalfSlab", 1L, i),
                        GT_ModHandler.getModItem("UndergroundBiomes", "button", 8L, j), GT_Values.NI, 12, 8);
            }
            for (int j = 48; j < 56; j++) {
                RA.addCutterRecipe(GT_ModHandler.getModItem("UndergroundBiomes", "sedimentaryStoneHalfSlab", 1L, i),
                        GT_ModHandler.getModItem("UndergroundBiomes", "button", 8L, j), GT_Values.NI, 12, 8);
            }
        }
    }

    private void pulverizer() {
        // --- Limestone
        RA.addPulveriserRecipe(GT_ModHandler.getModItem("UndergroundBiomes", "sedimentaryStone", 1L, 0),
                new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.dustImpure, Materials.Calcite, 1),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Quartzite, 1)},
                new int[]{10000, 100}, 400, 2);
        // --- Chalk
        RA.addPulveriserRecipe(GT_ModHandler.getModItem("UndergroundBiomes", "sedimentaryStone", 1L, 1),
                new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.dustImpure, Materials.Calcite, 1),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Siltstone, 1)},
                new int[]{10000, 100}, 400, 2);
        // --- Shale
        RA.addPulveriserRecipe(GT_ModHandler.getModItem("UndergroundBiomes", "sedimentaryStone", 1L, 2),
                new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.dustImpure, Materials.Calcite, 1),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.VanadiumMagnetite, 1)},
                new int[]{10000, 100}, 400, 2);
        // --- Siltstone
        RA.addPulveriserRecipe(GT_ModHandler.getModItem("UndergroundBiomes", "sedimentaryStone", 1L, 3),
                new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Siltstone, 1),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Clay, 1)},
                new int[]{10000, 100}, 400, 2);
        // --- Dolomite
        RA.addPulveriserRecipe(GT_ModHandler.getModItem("UndergroundBiomes", "sedimentaryStone", 1L, 5),
                new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Dolomite, 1),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Pyrolusite, 1)},
                new int[]{10000, 100}, 400, 2);
        // --- Greywacke
        RA.addPulveriserRecipe(GT_ModHandler.getModItem("UndergroundBiomes", "sedimentaryStone", 1L, 6),
                new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Greywacke, 1),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Quartz, 1)},
                new int[]{10000, 100}, 400, 2);
        // --- Chert
        RA.addPulveriserRecipe(GT_ModHandler.getModItem("UndergroundBiomes", "sedimentaryStone", 1L, 7),
                new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SiliconDioxide, 1),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.DarkAsh, 1)},
                new int[]{5000, 100}, 400, 2);
        // --- Fossil
        for (int i = 0; i < 8; i++) {
            RA.addPulveriserRecipe(GT_ModHandler.getModItem("UndergroundBiomes", "fossilPiece", 1L, i),
                    new ItemStack[]{GT_ModHandler.getModItem("minecraft", "dye", 4L, 15)},
                    new int[]{10000}, 300, 2);
        }
    }
}
