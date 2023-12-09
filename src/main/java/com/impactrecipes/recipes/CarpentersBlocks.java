package com.impactrecipes.recipes;

import gregtech.api.enums.*;
import gregtech.api.util.GT_ModHandler;
import gregtech.api.util.GT_OreDictUnificator;

import static gregtech.api.enums.GT_Values.RA;
import static gregtech.api.util.GT_ModHandler.removeRecipeByOutput;

public class CarpentersBlocks implements Runnable {

    private static final long tBitMask = GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE;

    @Override
    public void run() {
        removeCarpentersBlocks();
        hand();
        assembler();
        cuttingSaw();
    }

    private void removeCarpentersBlocks() {
        removeRecipeByOutput(GT_ModHandler.getModItem("CarpentersBlocks", "blockCarpentersBlock", 1, 0),
                true, false, true);
        removeRecipeByOutput(
                GT_ModHandler.getModItem("CarpentersBlocks", "blockCarpentersCollapsibleBlock", 1, 0), true,
                false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("CarpentersBlocks", "itemCarpentersChisel", 1, 0),
                true, false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("CarpentersBlocks", "itemCarpentersHammer", 1, 0),
                true, false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("CarpentersBlocks", "blockCarpentersSafe", 1, 0),
                true, false, true);
        removeRecipeByOutput(
                GT_ModHandler.getModItem("CarpentersBlocks", "blockCarpentersDaylightSensor", 1, 0), true,
                false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("CarpentersBlocks", "itemCarpentersBed", 1, 0),
                true, false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("CarpentersBlocks", "blockCarpentersTorch", 1, 0),
                true, false, true);
        removeRecipeByOutput(
                GT_ModHandler.getModItem("CarpentersBlocks", "blockCarpentersGarageDoor", 1, 0), true,
                false, true);
        removeRecipeByOutput(
                GT_ModHandler.getModItem("CarpentersBlocks", "blockCarpentersLadder", 1, 0), true, false,
                true);
        removeRecipeByOutput(
                GT_ModHandler.getModItem("CarpentersBlocks", "blockCarpentersBarrier", 1, 0), true, false,
                true);
        removeRecipeByOutput(
                GT_ModHandler.getModItem("CarpentersBlocks", "blockCarpentersPressurePlate", 1, 0), true,
                false, true);
        removeRecipeByOutput(
                GT_ModHandler.getModItem("CarpentersBlocks", "blockCarpentersButton", 1, 0), true, false,
                true);
        removeRecipeByOutput(
                GT_ModHandler.getModItem("CarpentersBlocks", "blockCarpentersFlowerPot", 1, 0), true, false,
                true);
        removeRecipeByOutput(GT_ModHandler.getModItem("CarpentersBlocks", "blockCarpentersGate", 1, 0),
                true, false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("CarpentersBlocks", "blockCarpentersHatch", 1, 0),
                true, false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("CarpentersBlocks", "blockCarpentersLever", 1, 0),
                true, false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("CarpentersBlocks", "blockCarpentersSlope", 1, 0),
                true, false, true);
        removeRecipeByOutput(
                GT_ModHandler.getModItem("CarpentersBlocks", "blockCarpentersStairs", 1, 0), true, false,
                true);
        removeRecipeByOutput(GT_ModHandler.getModItem("CarpentersBlocks", "itemCarpentersTile", 1, 0),
                true, false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("CarpentersBlocks", "itemCarpentersDoor", 1, 0),
                true, false, true);
    }

    private void hand() {
        // --- Carpenter's Block
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("CarpentersBlocks", "blockCarpentersBlock", 2L), tBitMask, new Object[]{"FSF", "SdS", "FSF", 'F', OrePrefixes.frameGt.get(Materials.Wood), 'S', OrePrefixes.screw.get(Materials.Wood)});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("CarpentersBlocks", "blockCarpentersBlock", 8L), tBitMask, new Object[]{"FSF", "FdF", "FSF", 'F', OrePrefixes.frameGt.get(Materials.Wood), 'S', OrePrefixes.screw.get(Materials.Iron)});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("CarpentersBlocks", "blockCarpentersBlock", 12L), tBitMask, new Object[]{"FSF", "FdF", "FSF", 'F', OrePrefixes.frameGt.get(Materials.Wood), 'S', OrePrefixes.screw.get(Materials.Steel)});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("CarpentersBlocks", "blockCarpentersBlock", 16L), tBitMask, new Object[]{"FSF", "FdF", "FSF", 'F', OrePrefixes.frameGt.get(Materials.Wood), 'S', OrePrefixes.screw.get(Materials.Aluminium)});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("CarpentersBlocks", "blockCarpentersBlock", 20L), tBitMask, new Object[]{"FSF", "FdF", "FSF", 'F', OrePrefixes.frameGt.get(Materials.Wood), 'S', OrePrefixes.screw.get(Materials.StainlessSteel)});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("CarpentersBlocks", "blockCarpentersBlock", 24L), tBitMask, new Object[]{"FSF", "FdF", "FSF", 'F', OrePrefixes.frameGt.get(Materials.Wood), 'S', OrePrefixes.screw.get(Materials.Titanium)});
        // --- Carpenter's Collapsible Block
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("CarpentersBlocks", "blockCarpentersCollapsibleBlock", 1L), tBitMask, new Object[]{"SdS", "WWW", "SBS", 'B', GT_ModHandler.getModItem("CarpentersBlocks", "blockCarpentersBlock", 1L, 0), 'W', ItemList.Plank_Oak, 'S', OrePrefixes.screw.get(Materials.Wood)});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("CarpentersBlocks", "blockCarpentersCollapsibleBlock", 1L), tBitMask, new Object[]{"SdS", "WWW", "SBS", 'B', GT_ModHandler.getModItem("CarpentersBlocks", "blockCarpentersBlock", 1L, 0), 'W', ItemList.Plank_Spruce, 'S', OrePrefixes.screw.get(Materials.Wood)});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("CarpentersBlocks", "blockCarpentersCollapsibleBlock", 1L), tBitMask, new Object[]{"SdS", "WWW", "SBS", 'B', GT_ModHandler.getModItem("CarpentersBlocks", "blockCarpentersBlock", 1L, 0), 'W', ItemList.Plank_Birch, 'S', OrePrefixes.screw.get(Materials.Wood)});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("CarpentersBlocks", "blockCarpentersCollapsibleBlock", 1L), tBitMask, new Object[]{"SdS", "WWW", "SBS", 'B', GT_ModHandler.getModItem("CarpentersBlocks", "blockCarpentersBlock", 1L, 0), 'W', ItemList.Plank_Jungle, 'S', OrePrefixes.screw.get(Materials.Wood)});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("CarpentersBlocks", "blockCarpentersCollapsibleBlock", 1L), tBitMask, new Object[]{"SdS", "WWW", "SBS", 'B', GT_ModHandler.getModItem("CarpentersBlocks", "blockCarpentersBlock", 1L, 0), 'W', ItemList.Plank_Acacia, 'S', OrePrefixes.screw.get(Materials.Wood)});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("CarpentersBlocks", "blockCarpentersCollapsibleBlock", 1L), tBitMask, new Object[]{"SdS", "WWW", "SBS", 'B', GT_ModHandler.getModItem("CarpentersBlocks", "blockCarpentersBlock", 1L, 0), 'W', ItemList.Plank_DarkOak, 'S', OrePrefixes.screw.get(Materials.Wood)});
        // --- Carpenter's Chisel
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("CarpentersBlocks", "itemCarpentersChisel", 1L, 0), tBitMask, new Object[]{"dTs", "SIS", "BIB", 'B', GT_ModHandler.getModItem("CarpentersBlocks", "blockCarpentersBlock", 1L, 0), 'T', "plateIron", 'S', OrePrefixes.screw.get(Materials.Iron), 'I', OrePrefixes.stick.get(Materials.Iron)});
        // --- Carpenter's Hammer
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("CarpentersBlocks", "itemCarpentersHammer", 1L, 0), tBitMask, new Object[]{"dTs", "SIS", "BIB", 'B', GT_ModHandler.getModItem("CarpentersBlocks", "blockCarpentersBlock", 1L, 0), 'T', OrePrefixes.toolHeadHammer.get(Materials.Iron), 'S', OrePrefixes.screw.get(Materials.Iron), 'I', OrePrefixes.stick.get(Materials.Iron)});
        // --- Carpenter's Safe
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("CarpentersBlocks", "blockCarpentersSafe", 1L, 0), tBitMask, new Object[]{"SBS", "BIB", "SdS", 'B', GT_ModHandler.getModItem("CarpentersBlocks", "blockCarpentersCollapsibleBlock", 1L, 0), 'S', OrePrefixes.screw.get(Materials.Iron), 'I', GT_ModHandler.getModItem("IC2", "blockPersonal", 1L, 0)});
        // --- Carpenter's Daylight Sensor
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("CarpentersBlocks", "blockCarpentersDaylightSensor", 1L, 0), tBitMask, new Object[]{"SdS", "BMB", "BRB", 'B', GT_ModHandler.getModItem("CarpentersBlocks", "blockCarpentersBlock", 1L, 0), 'S', OrePrefixes.screw.get(Materials.Iron), 'M', GT_ModHandler.getModItem("minecraft", "daylight_detector", 1L, 0), 'R', OrePrefixes.dust.get(Materials.Redstone)});
        // --- Carpenter's Bed
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("CarpentersBlocks", "itemCarpentersBed", 1L, 0), tBitMask, new Object[]{"MMM", "BBB", "BrB", 'B', GT_ModHandler.getModItem("CarpentersBlocks", "blockCarpentersBlock", 1L, 0), 'M', GT_ModHandler.getModItem("minecraft", "carpet", 1L, 0)});
        // --- Carpenter's Torch
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("CarpentersBlocks", "blockCarpentersTorch", 2L, 0), tBitMask, new Object[]{"TBT", 'B', GT_ModHandler.getModItem("CarpentersBlocks", "blockCarpentersBlock", 1L, 0), 'T', GT_ModHandler.getModItem("minecraft", "torch", 1L, 0)});
        // --- Carpenter's Garage Door
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("CarpentersBlocks", "blockCarpentersGarageDoor", 5L, 0), tBitMask, new Object[]{"BRB", "RBR", "BRB", 'B', GT_ModHandler.getModItem("CarpentersBlocks", "blockCarpentersBlock", 1L, 0), 'R', OrePrefixes.ring.get(Materials.Iron)});
        // --- Carpenter's Ladder
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("CarpentersBlocks", "blockCarpentersLadder", 1L, 0), tBitMask, new Object[]{"BLB", "SdS", 'B', GT_ModHandler.getModItem("CarpentersBlocks", "blockCarpentersBlock", 1L, 0), 'S', OrePrefixes.screw.get(Materials.Wood), 'L', GT_ModHandler.getModItem("minecraft", "ladder", 1L, 0)});
        // --- Carpenter's Barrier
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("CarpentersBlocks", "blockCarpentersBarrier", 1L, 0), tBitMask, new Object[]{"BLB", "SdS", 'B', GT_ModHandler.getModItem("CarpentersBlocks", "blockCarpentersBlock", 1L, 0), 'S', OrePrefixes.screw.get(Materials.Wood), 'L', GT_ModHandler.getModItem("minecraft", "fence", 1L, 0)});
        // --- Carpenter's Pressure Plate
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("CarpentersBlocks", "blockCarpentersPressurePlate", 2L, 0), tBitMask, new Object[]{"SrS", "BRB", "SdS", 'B', GT_ModHandler.getModItem("CarpentersBlocks", "blockCarpentersBlock", 1L, 0), 'S', OrePrefixes.screw.get(Materials.Wood), 'R', OrePrefixes.spring.get(Materials.Iron)});
        // --- Carpenter's Flower Pot
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("CarpentersBlocks", "blockCarpentersFlowerPot", 1L, 0), tBitMask, new Object[]{"BMB", " B ", 'B', GT_ModHandler.getModItem("CarpentersBlocks", "blockCarpentersBlock", 1L, 0), 'M', GT_ModHandler.getModItem("minecraft", "flower_pot", 1L, 0)});
        // --- Carpenter's Gate
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("CarpentersBlocks", "blockCarpentersGate", 1L, 0), tBitMask, new Object[]{"BLB", "SdS", 'B', GT_ModHandler.getModItem("CarpentersBlocks", "blockCarpentersBlock", 1L, 0), 'S', OrePrefixes.screw.get(Materials.Wood), 'L', GT_ModHandler.getModItem("minecraft", "fence_gate", 1L, 0)});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("CarpentersBlocks", "blockCarpentersGate", 1L, 0), tBitMask, new Object[]{"BLB", "SdS", 'B', GT_ModHandler.getModItem("CarpentersBlocks", "blockCarpentersBlock", 1L, 0), 'S', OrePrefixes.screw.get(Materials.Wood), 'L', GT_ModHandler.getModItem("malisisdoors", "acaciaFenceGate", 1L)});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("CarpentersBlocks", "blockCarpentersGate", 1L, 0), tBitMask, new Object[]{"BLB", "SdS", 'B', GT_ModHandler.getModItem("CarpentersBlocks", "blockCarpentersBlock", 1L, 0), 'S', OrePrefixes.screw.get(Materials.Wood), 'L', GT_ModHandler.getModItem("malisisdoors", "birchFenceGate", 1L)});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("CarpentersBlocks", "blockCarpentersGate", 1L, 0), tBitMask, new Object[]{"BLB", "SdS", 'B', GT_ModHandler.getModItem("CarpentersBlocks", "blockCarpentersBlock", 1L, 0), 'S', OrePrefixes.screw.get(Materials.Wood), 'L', GT_ModHandler.getModItem("malisisdoors", "darkOakFenceGate", 1L)});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("CarpentersBlocks", "blockCarpentersGate", 1L, 0), tBitMask, new Object[]{"BLB", "SdS", 'B', GT_ModHandler.getModItem("CarpentersBlocks", "blockCarpentersBlock", 1L, 0), 'S', OrePrefixes.screw.get(Materials.Wood), 'L', GT_ModHandler.getModItem("malisisdoors", "jungleFenceGate", 1L)});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("CarpentersBlocks", "blockCarpentersGate", 1L, 0), tBitMask, new Object[]{"BLB", "SdS", 'B', GT_ModHandler.getModItem("CarpentersBlocks", "blockCarpentersBlock", 1L, 0), 'S', OrePrefixes.screw.get(Materials.Wood), 'L', GT_ModHandler.getModItem("malisisdoors", "spruceFenceGate", 1L)});
        // --- Carpenter's Hatch
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("CarpentersBlocks", "blockCarpentersHatch", 1L, 0), tBitMask, new Object[]{"BLB", "SdS", 'B', GT_ModHandler.getModItem("CarpentersBlocks", "blockCarpentersBlock", 1L, 0), 'S', OrePrefixes.screw.get(Materials.Wood), 'L', GT_ModHandler.getModItem("minecraft", "trapdoor", 1L, 0)});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("CarpentersBlocks", "blockCarpentersHatch", 1L, 0), tBitMask, new Object[]{"BLB", "SdS", 'B', GT_ModHandler.getModItem("CarpentersBlocks", "blockCarpentersBlock", 1L, 0), 'S', OrePrefixes.screw.get(Materials.Wood), 'L', GT_ModHandler.getModItem("malisisdoors", "trapdoor_acacia", 1L)});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("CarpentersBlocks", "blockCarpentersHatch", 1L, 0), tBitMask, new Object[]{"BLB", "SdS", 'B', GT_ModHandler.getModItem("CarpentersBlocks", "blockCarpentersBlock", 1L, 0), 'S', OrePrefixes.screw.get(Materials.Wood), 'L', GT_ModHandler.getModItem("malisisdoors", "trapdoor_spruce", 1L)});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("CarpentersBlocks", "blockCarpentersHatch", 1L, 0), tBitMask, new Object[]{"BLB", "SdS", 'B', GT_ModHandler.getModItem("CarpentersBlocks", "blockCarpentersBlock", 1L, 0), 'S', OrePrefixes.screw.get(Materials.Wood), 'L', GT_ModHandler.getModItem("malisisdoors", "trapdoor_birch", 1L)});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("CarpentersBlocks", "blockCarpentersHatch", 1L, 0), tBitMask, new Object[]{"BLB", "SdS", 'B', GT_ModHandler.getModItem("CarpentersBlocks", "blockCarpentersBlock", 1L, 0), 'S', OrePrefixes.screw.get(Materials.Wood), 'L', GT_ModHandler.getModItem("malisisdoors", "trapdoor_jungle", 1L)});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("CarpentersBlocks", "blockCarpentersHatch", 1L, 0), tBitMask, new Object[]{"BLB", "SdS", 'B', GT_ModHandler.getModItem("CarpentersBlocks", "blockCarpentersBlock", 1L, 0), 'S', OrePrefixes.screw.get(Materials.Wood), 'L', GT_ModHandler.getModItem("malisisdoors", "trapdoor_dark_oak", 1L)});
        // --- Carpenter's Lever
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("CarpentersBlocks", "blockCarpentersLever", 1L, 0), tBitMask, new Object[]{"BLS", " d ", 'B', GT_ModHandler.getModItem("CarpentersBlocks", "blockCarpentersBlock", 1L, 0), 'S', OrePrefixes.screw.get(Materials.Wood), 'L', GT_ModHandler.getModItem("minecraft", "lever", 1L, 0)});
        // --- Carpenter's Door
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("CarpentersBlocks", "itemCarpentersDoor", 1L, 0), tBitMask, new Object[]{"BLB", "SdS", 'B', GT_ModHandler.getModItem("CarpentersBlocks", "blockCarpentersBlock", 1L, 0), 'S', OrePrefixes.screw.get(Materials.Wood), 'L', GT_ModHandler.getModItem("minecraft", "wooden_door", 1L, 0)});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("CarpentersBlocks", "itemCarpentersDoor", 1L, 0), tBitMask, new Object[]{"BLB", "SdS", 'B', GT_ModHandler.getModItem("CarpentersBlocks", "blockCarpentersBlock", 1L, 0), 'S', OrePrefixes.screw.get(Materials.Wood), 'L', GT_ModHandler.getModItem("malisisdoors", "item.door_acacia", 1L)});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("CarpentersBlocks", "itemCarpentersDoor", 1L, 0), tBitMask, new Object[]{"BLB", "SdS", 'B', GT_ModHandler.getModItem("CarpentersBlocks", "blockCarpentersBlock", 1L, 0), 'S', OrePrefixes.screw.get(Materials.Wood), 'L', GT_ModHandler.getModItem("malisisdoors", "item.door_birch", 1L)});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("CarpentersBlocks", "itemCarpentersDoor", 1L, 0), tBitMask, new Object[]{"BLB", "SdS", 'B', GT_ModHandler.getModItem("CarpentersBlocks", "blockCarpentersBlock", 1L, 0), 'S', OrePrefixes.screw.get(Materials.Wood), 'L', GT_ModHandler.getModItem("malisisdoors", "item.door_dark_oak", 1L)});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("CarpentersBlocks", "itemCarpentersDoor", 1L, 0), tBitMask, new Object[]{"BLB", "SdS", 'B', GT_ModHandler.getModItem("CarpentersBlocks", "blockCarpentersBlock", 1L, 0), 'S', OrePrefixes.screw.get(Materials.Wood), 'L', GT_ModHandler.getModItem("malisisdoors", "item.door_jungle", 1L)});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("CarpentersBlocks", "itemCarpentersDoor", 1L, 0), tBitMask, new Object[]{"BLB", "SdS", 'B', GT_ModHandler.getModItem("CarpentersBlocks", "blockCarpentersBlock", 1L, 0), 'S', OrePrefixes.screw.get(Materials.Wood), 'L', GT_ModHandler.getModItem("malisisdoors", "item.door_spruce", 1L)});
        // --- Carpenter's Button
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("CarpentersBlocks", "blockCarpentersButton", 1L, 0), tBitMask, new Object[]{"sC", 'C', GT_ModHandler.getModItem("CarpentersBlocks", "blockCarpentersPressurePlate", 1L, 0)});
        // --- Carpenter's Slope
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("CarpentersBlocks", "blockCarpentersSlope", 2L, 0), tBitMask, new Object[]{"Cs", 'C', GT_ModHandler.getModItem("CarpentersBlocks", "blockCarpentersBlock", 1L, 0)});
        // --- Carpenter's Stairs
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("CarpentersBlocks", "blockCarpentersStairs", 1L, 0), tBitMask, new Object[]{"sC", 'C', GT_ModHandler.getModItem("CarpentersBlocks", "blockCarpentersSlope", 1L, 0)});
        // --- Carpenter's Tile
        GT_ModHandler.addShapelessCraftingRecipe(GT_ModHandler.getModItem("CarpentersBlocks", "itemCarpentersTile", 1L, 0), tBitMask, new Object[]{GT_ModHandler.getModItem("CarpentersBlocks", "blockCarpentersPressurePlate", 1L, 0), ToolDictNames.craftingToolRollingPin, "itemClay"});

    }

    private void assembler() {
        GT_Values.RA
                .addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Wood, 2L),
                        GT_OreDictUnificator.get(OrePrefixes.screw, Materials.Wood, 2L), null,
                        GT_ModHandler.getModItem("CarpentersBlocks", "blockCarpentersBlock", 4L, 0), 100, 16);
        GT_Values.RA
                .addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Wood, 3L),
                        GT_OreDictUnificator.get(OrePrefixes.screw, Materials.Iron, 1L), null,
                        GT_ModHandler.getModItem("CarpentersBlocks", "blockCarpentersBlock", 8L, 0), 100, 30);
        GT_Values.RA
                .addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Wood, 3L),
                        GT_OreDictUnificator.get(OrePrefixes.screw, Materials.Steel, 1L), null,
                        GT_ModHandler.getModItem("CarpentersBlocks", "blockCarpentersBlock", 12L, 0), 100, 48);
        GT_Values.RA
                .addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Wood, 3L),
                        GT_OreDictUnificator.get(OrePrefixes.screw, Materials.Aluminium, 1L), null,
                        GT_ModHandler.getModItem("CarpentersBlocks", "blockCarpentersBlock", 16L, 0), 100, 64);
        GT_Values.RA
                .addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Wood, 3L),
                        GT_OreDictUnificator.get(OrePrefixes.screw, Materials.StainlessSteel, 1L), null,
                        GT_ModHandler.getModItem("CarpentersBlocks", "blockCarpentersBlock", 20L, 0), 100, 64);
        GT_Values.RA
                .addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Wood, 3L),
                        GT_OreDictUnificator.get(OrePrefixes.screw, Materials.Titanium, 1L), null,
                        GT_ModHandler.getModItem("CarpentersBlocks", "blockCarpentersBlock", 24L, 0), 100, 64);
        // --- Carpenter's Barrier
        RA.addAssemblerRecipe(
                GT_ModHandler.getModItem("CarpentersBlocks", "blockCarpentersBlock", 1L, 0),
                GT_ModHandler.getModItem("minecraft", "fence", 1L, 0), null,
                GT_ModHandler.getModItem("CarpentersBlocks", "blockCarpentersBarrier", 2L, 0), 200, 16);
        // --- Carpenter's Collapsible Block
        RA.addAssemblerRecipe(
                GT_ModHandler.getModItem("CarpentersBlocks", "blockCarpentersBlock", 1L, 0),
                ItemList.Plank_Oak.get(1L), null,
                GT_ModHandler.getModItem("CarpentersBlocks", "blockCarpentersCollapsibleBlock", 1L, 0), 100,
                16);
        RA.addAssemblerRecipe(
                GT_ModHandler.getModItem("CarpentersBlocks", "blockCarpentersBlock", 1L, 0),
                ItemList.Plank_Spruce.get(1L), null,
                GT_ModHandler.getModItem("CarpentersBlocks", "blockCarpentersCollapsibleBlock", 1L, 0), 100,
                16);
        RA.addAssemblerRecipe(
                GT_ModHandler.getModItem("CarpentersBlocks", "blockCarpentersBlock", 1L, 0),
                ItemList.Plank_Birch.get(1L), null,
                GT_ModHandler.getModItem("CarpentersBlocks", "blockCarpentersCollapsibleBlock", 1L, 0), 100,
                16);
        RA.addAssemblerRecipe(
                GT_ModHandler.getModItem("CarpentersBlocks", "blockCarpentersBlock", 1L, 0),
                ItemList.Plank_Jungle.get(1L), null,
                GT_ModHandler.getModItem("CarpentersBlocks", "blockCarpentersCollapsibleBlock", 1L, 0), 100,
                16);
        RA.addAssemblerRecipe(
                GT_ModHandler.getModItem("CarpentersBlocks", "blockCarpentersBlock", 1L, 0),
                ItemList.Plank_Acacia.get(1L), null,
                GT_ModHandler.getModItem("CarpentersBlocks", "blockCarpentersCollapsibleBlock", 1L, 0), 100,
                16);
        RA.addAssemblerRecipe(
                GT_ModHandler.getModItem("CarpentersBlocks", "blockCarpentersBlock", 1L, 0),
                ItemList.Plank_DarkOak.get(1L), null,
                GT_ModHandler.getModItem("CarpentersBlocks", "blockCarpentersCollapsibleBlock", 1L, 0), 100,
                16);
        // --- Carpenter's Flower Pot
        RA.addAssemblerRecipe(
                GT_ModHandler.getModItem("CarpentersBlocks", "blockCarpentersBlock", 1L, 0),
                GT_ModHandler.getModItem("minecraft", "flower_pot", 1L, 0), null,
                GT_ModHandler.getModItem("CarpentersBlocks", "blockCarpentersFlowerPot", 1L, 0), 100, 16);
        // --- Carpenter's Garage Door
        RA.addAssemblerRecipe(
                GT_ModHandler.getModItem("CarpentersBlocks", "blockCarpentersBlock", 1L, 0),
                GT_OreDictUnificator.get(OrePrefixes.ring, Materials.Iron, 1L), null,
                GT_ModHandler.getModItem("CarpentersBlocks", "blockCarpentersGarageDoor", 2L, 0), 150, 16);
        RA.addAssemblerRecipe(
                GT_ModHandler.getModItem("CarpentersBlocks", "blockCarpentersBlock", 1L, 0),
                GT_OreDictUnificator.get(OrePrefixes.ring, Materials.Steel, 1L), null,
                GT_ModHandler.getModItem("CarpentersBlocks", "blockCarpentersGarageDoor", 4L, 0), 300, 16);
        // --- Carpenter's Gate
        RA.addAssemblerRecipe(
                GT_ModHandler.getModItem("CarpentersBlocks", "blockCarpentersBlock", 1L, 0),
                GT_ModHandler.getModItem("minecraft", "fence_gate", 1L, 0), null,
                GT_ModHandler.getModItem("CarpentersBlocks", "blockCarpentersGate", 1L, 0), 100, 16);
        RA.addAssemblerRecipe(
                GT_ModHandler.getModItem("CarpentersBlocks", "blockCarpentersBlock", 1L, 0),
                GT_ModHandler.getModItem("malisisdoors", "acaciaFenceGate", 1L), null,
                GT_ModHandler.getModItem("CarpentersBlocks", "blockCarpentersGate", 1L, 0), 100, 16);
        RA.addAssemblerRecipe(
                GT_ModHandler.getModItem("CarpentersBlocks", "blockCarpentersBlock", 1L, 0),
                GT_ModHandler.getModItem("malisisdoors", "birchFenceGate", 1L), null,
                GT_ModHandler.getModItem("CarpentersBlocks", "blockCarpentersGate", 1L, 0), 100, 16);
        RA.addAssemblerRecipe(
                GT_ModHandler.getModItem("CarpentersBlocks", "blockCarpentersBlock", 1L, 0),
                GT_ModHandler.getModItem("malisisdoors", "darkOakFenceGate", 1L), null,
                GT_ModHandler.getModItem("CarpentersBlocks", "blockCarpentersGate", 1L, 0), 100, 16);
        RA.addAssemblerRecipe(
                GT_ModHandler.getModItem("CarpentersBlocks", "blockCarpentersBlock", 1L, 0),
                GT_ModHandler.getModItem("malisisdoors", "jungleFenceGate", 1L), null,
                GT_ModHandler.getModItem("CarpentersBlocks", "blockCarpentersGate", 1L, 0), 100, 16);
        RA.addAssemblerRecipe(
                GT_ModHandler.getModItem("CarpentersBlocks", "blockCarpentersBlock", 1L, 0),
                GT_ModHandler.getModItem("malisisdoors", "spruceFenceGate", 1L), null,
                GT_ModHandler.getModItem("CarpentersBlocks", "blockCarpentersGate", 1L, 0), 100, 16);
        // --- Carpenter's Hatch
        RA.addAssemblerRecipe(
                GT_ModHandler.getModItem("CarpentersBlocks", "blockCarpentersBlock", 1L, 0),
                GT_ModHandler.getModItem("minecraft", "trapdoor", 1L, 0), null,
                GT_ModHandler.getModItem("CarpentersBlocks", "blockCarpentersHatch", 1L, 0), 100, 16);
        RA.addAssemblerRecipe(
                GT_ModHandler.getModItem("CarpentersBlocks", "blockCarpentersBlock", 1L, 0),
                GT_ModHandler.getModItem("malisisdoors", "trapdoor_acacia", 1L), null,
                GT_ModHandler.getModItem("CarpentersBlocks", "blockCarpentersHatch", 1L, 0), 100, 16);
        RA.addAssemblerRecipe(
                GT_ModHandler.getModItem("CarpentersBlocks", "blockCarpentersBlock", 1L, 0),
                GT_ModHandler.getModItem("malisisdoors", "trapdoor_spruce", 1L), null,
                GT_ModHandler.getModItem("CarpentersBlocks", "blockCarpentersHatch", 1L, 0), 100, 16);
        RA.addAssemblerRecipe(
                GT_ModHandler.getModItem("CarpentersBlocks", "blockCarpentersBlock", 1L, 0),
                GT_ModHandler.getModItem("malisisdoors", "trapdoor_birch", 1L), null,
                GT_ModHandler.getModItem("CarpentersBlocks", "blockCarpentersHatch", 1L, 0), 100, 16);
        RA.addAssemblerRecipe(
                GT_ModHandler.getModItem("CarpentersBlocks", "blockCarpentersBlock", 1L, 0),
                GT_ModHandler.getModItem("malisisdoors", "trapdoor_jungle", 1L), null,
                GT_ModHandler.getModItem("CarpentersBlocks", "blockCarpentersHatch", 1L, 0), 100, 16);
        RA.addAssemblerRecipe(
                GT_ModHandler.getModItem("CarpentersBlocks", "blockCarpentersBlock", 1L, 0),
                GT_ModHandler.getModItem("malisisdoors", "trapdoor_dark_oak", 1L), null,
                GT_ModHandler.getModItem("CarpentersBlocks", "blockCarpentersHatch", 1L, 0), 100, 16);
        // --- Carpenter's Ladder
        RA.addAssemblerRecipe(
                GT_ModHandler.getModItem("CarpentersBlocks", "blockCarpentersBlock", 1L, 0),
                GT_ModHandler.getModItem("minecraft", "ladder", 1L, 0), null,
                GT_ModHandler.getModItem("CarpentersBlocks", "blockCarpentersLadder", 1L, 0), 100, 16);
        // --- Carpenter's Lever
        RA.addAssemblerRecipe(
                GT_ModHandler.getModItem("CarpentersBlocks", "blockCarpentersBlock", 1L, 0),
                GT_ModHandler.getModItem("minecraft", "lever", 1L, 0), null,
                GT_ModHandler.getModItem("CarpentersBlocks", "blockCarpentersLever", 1L, 0), 50, 16);
        // --- Carpenter's Safe
        RA.addAssemblerRecipe(
                GT_ModHandler.getModItem("CarpentersBlocks", "blockCarpentersCollapsibleBlock", 3L, 0),
                GT_ModHandler.getModItem("IC2", "blockPersonal", 1L, 0), null,
                GT_ModHandler.getModItem("CarpentersBlocks", "blockCarpentersSafe", 1L, 0), 300, 30);
        // --- Carpenter's Torch
        RA.addAssemblerRecipe(
                GT_ModHandler.getModItem("CarpentersBlocks", "blockCarpentersBlock", 1L, 0),
                GT_ModHandler.getModItem("minecraft", "torch", 10L, 0), null,
                GT_ModHandler.getModItem("CarpentersBlocks", "blockCarpentersTorch", 10L, 0), 100, 16);
        // --- Carpenter's Chisel
        RA.addAssemblerRecipe(
                GT_ModHandler.getModItem("CarpentersBlocks", "blockCarpentersBlock", 1L, 0),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Iron, 1L), null,
                GT_ModHandler.getModItem("CarpentersBlocks", "itemCarpentersChisel", 1L, 0), 200, 30);
        // --- Carpenter's Hammer
        RA.addAssemblerRecipe(
                GT_ModHandler.getModItem("CarpentersBlocks", "blockCarpentersBlock", 1L, 0),
                GT_OreDictUnificator.get(OrePrefixes.toolHeadHammer, Materials.Iron, 1L), null,
                GT_ModHandler.getModItem("CarpentersBlocks", "itemCarpentersHammer", 1L, 0), 200, 30);
        // --- Carpenter's Tile
        RA.addAssemblerRecipe(
                GT_ModHandler.getModItem("CarpentersBlocks", "blockCarpentersPressurePlate", 1L, 0),
                GT_ModHandler.getModItem("minecraft", "clay_ball", 1L, 0), null,
                GT_ModHandler.getModItem("CarpentersBlocks", "itemCarpentersTile", 2L, 0), 50, 16);
        // --- Carpenter's Door
        RA.addAssemblerRecipe(
                GT_ModHandler.getModItem("CarpentersBlocks", "blockCarpentersBlock", 1L, 0),
                GT_ModHandler.getModItem("minecraft", "wooden_door", 1L, 0), null,
                GT_ModHandler.getModItem("CarpentersBlocks", "itemCarpentersDoor", 1L, 0), 150, 16);
        RA.addAssemblerRecipe(
                GT_ModHandler.getModItem("CarpentersBlocks", "blockCarpentersBlock", 1L, 0),
                GT_ModHandler.getModItem("malisisdoors", "item.door_acacia", 1L), null,
                GT_ModHandler.getModItem("CarpentersBlocks", "itemCarpentersDoor", 1L, 0), 150, 16);
        RA.addAssemblerRecipe(
                GT_ModHandler.getModItem("CarpentersBlocks", "blockCarpentersBlock", 1L, 0),
                GT_ModHandler.getModItem("malisisdoors", "item.door_birch", 1L), null,
                GT_ModHandler.getModItem("CarpentersBlocks", "itemCarpentersDoor", 1L, 0), 150, 16);
        RA.addAssemblerRecipe(
                GT_ModHandler.getModItem("CarpentersBlocks", "blockCarpentersBlock", 1L, 0),
                GT_ModHandler.getModItem("malisisdoors", "item.door_dark_oak", 1L), null,
                GT_ModHandler.getModItem("CarpentersBlocks", "itemCarpentersDoor", 1L, 0), 150, 16);
        RA.addAssemblerRecipe(
                GT_ModHandler.getModItem("CarpentersBlocks", "blockCarpentersBlock", 1L, 0),
                GT_ModHandler.getModItem("malisisdoors", "item.door_jungle", 1L), null,
                GT_ModHandler.getModItem("CarpentersBlocks", "itemCarpentersDoor", 1L, 0), 150, 16);
        RA.addAssemblerRecipe(
                GT_ModHandler.getModItem("CarpentersBlocks", "blockCarpentersBlock", 1L, 0),
                GT_ModHandler.getModItem("malisisdoors", "item.door_spruce", 1L), null,
                GT_ModHandler.getModItem("CarpentersBlocks", "itemCarpentersDoor", 1L, 0), 150, 16);
        // --- Carpenter's Pressure Plate
        RA.addAssemblerRecipe(
                GT_ModHandler.getModItem("CarpentersBlocks", "blockCarpentersBlock", 2L, 0),
                GT_OreDictUnificator.get(OrePrefixes.spring, Materials.Iron, 1L), null,
                GT_ModHandler.getModItem("CarpentersBlocks", "blockCarpentersPressurePlate", 2L, 0), 100,
                8);
    }

    private void cuttingSaw() {
        // --- Carpenter's Button
        RA.addCutterRecipe(
                GT_ModHandler.getModItem("CarpentersBlocks", "blockCarpentersPressurePlate", 1L, 0),
                GT_ModHandler.getModItem("CarpentersBlocks", "blockCarpentersButton", 4L, 0), GT_Values.NI,
                100, 30);
        // --- Carpenter's Stairs
        RA.addCutterRecipe(
                GT_ModHandler.getModItem("CarpentersBlocks", "blockCarpentersSlope", 1L, 0),
                GT_ModHandler.getModItem("CarpentersBlocks", "blockCarpentersStairs", 1L, 0), GT_Values.NI,
                100, 30);
        // --- Carpenter's Slope
        RA.addCutterRecipe(
                GT_ModHandler.getModItem("CarpentersBlocks", "blockCarpentersBlock", 1L, 0),
                GT_ModHandler.getModItem("CarpentersBlocks", "blockCarpentersSlope", 4L, 0), GT_Values.NI,
                100, 30);
    }
}
