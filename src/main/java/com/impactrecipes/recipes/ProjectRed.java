package com.impactrecipes.recipes;

import gregtech.api.GregTech_API;
import gregtech.api.enums.*;
import gregtech.api.interfaces.IOreRecipeRegistrator;
import gregtech.api.util.GT_ModHandler;
import gregtech.api.util.GT_OreDictUnificator;
import gregtech.api.util.GT_Utility;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

import static gregtech.api.enums.GT_Values.RA;
import static gregtech.api.util.GT_ModHandler.*;

public class ProjectRed implements Runnable {

    private static final long tBitMask = GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE;

    @Override
    public void run() {
        removeProjectRed();
        handRecipe();
        wiremillRecipe();
        formingPressRecipe();
        mixerRecipe();
        alloySmelterRecipe();
        assemblerRecipe();
        circuitAssemblerRecipe();
        chemicalBathRecipe();
        chemical();
    }

    private void removeProjectRed() {
        removeFurnaceSmelting(GT_ModHandler.getModItem("ProjRed|Core", "projectred.core.part", 1L, 42));
        removeFurnaceSmelting(GT_ModHandler.getModItem("ProjRed|Core", "projectred.core.part", 1L, 43));
        removeRecipeByOutput(GT_ModHandler.getModItem("ProjRed|Fabrication", "projectred.fabrication.icchip", 1L, 0), true, false, false);
        removeRecipeByOutput(GT_ModHandler.getModItem("ProjRed|Fabrication", "projectred.integration.icblock", 1L, 0), true, false, false);
        removeRecipeByOutput(GT_ModHandler.getModItem("ProjRed|Fabrication", "projectred.integration.icblock", 1L, 1), true, false, false);
        removeRecipeByOutput(GT_ModHandler.getModItem("ProjRed|Core", "projectred.core.screwdriver", 1L, 0), true, false, false);
        removeRecipeByOutput(GT_ModHandler.getModItem("ProjRed|Core", "projectred.core.part", 1L, 42), true, false, false);
        removeRecipeByOutput(GT_ModHandler.getModItem("ProjRed|Core", "projectred.core.part", 1L, 43), true, false, false);
        removeRecipeByOutput(GT_ModHandler.getModItem("ProjRed|Core", "projectred.core.wiredebugger", 1L, 0), true, false, false);

        for (int i = 0; i < 16; i++) {
            removeRecipeByOutput(GT_ModHandler.getModItem("ProjRed|Core", "projectred.core.part", 1L, 19 + i), true, false, false);
            removeRecipeByOutput(GT_ModHandler.getModItem("ProjRed|Transmission", "projectred.transmission.wire", 1L, i), true, false, false);
        }
        for (int i = 1; i < 10; i++) {
            removeRecipeByOutput(GT_ModHandler.getModItem("ProjRed|Core", "projectred.core.part", 1L, i), true, false, false);
        }
        removeRecipeByOutput(GT_ModHandler.getModItem("WR-CBE|Core", "obsidianStick", 1L, 0), true,
                false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("WR-CBE|Core", "stoneBowl", 1L, 0), true, false,
                true);
        removeRecipeByOutput(GT_ModHandler.getModItem("WR-CBE|Core", "retherPearl", 1L, 0), true, false,
                true);
        removeRecipeByOutput(GT_ModHandler.getModItem("WR-CBE|Core", "wirelessTransceiver", 1L, 0),
                true, false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("WR-CBE|Core", "blazeTransceiver", 1L, 0), true,
                false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("WR-CBE|Core", "recieverDish", 1L, 0), true,
                false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("WR-CBE|Core", "blazeRecieverDish", 1L, 0), true,
                false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("WR-CBE|Logic", "wirelessLogic", 1L, 0), true,
                false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("WR-CBE|Logic", "wirelessLogic", 1L, 1), true,
                false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("WR-CBE|Logic", "wirelessLogic", 1L, 2), true,
                false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("WR-CBE|Addons", "triangulator", 1L, 0), true,
                false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("WR-CBE|Addons", "remote", 1L, 0), true, false,
                true);
        removeRecipeByOutput(GT_ModHandler.getModItem("WR-CBE|Addons", "sniffer", 1L, 0), true, false,
                true);
        removeRecipeByOutput(GT_ModHandler.getModItem("WR-CBE|Addons", "map", 1L, 0), true, false,
                true);
        removeRecipeByOutput(GT_ModHandler.getModItem("WR-CBE|Addons", "tracker", 1L, 0), true, false,
                true);
        removeRecipeByOutput(GT_ModHandler.getModItem("WR-CBE|Addons", "rep", 1L, 0), true, false,
                true);
        removeRecipeByOutput(GT_ModHandler.getModItem("WR-CBE|Addons", "psniffer", 1L, 0), true, false,
                true);
    }

    private void handRecipe() {
        // --- Stone Bowl
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("WR-CBE|Core", "stoneBowl", 1L, 0), tBitMask, new Object[]{"P P", "PhP", "PPP", 'P', "stone"});
        // --- Remote
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("WR-CBE|Addons", "remote", 1L, 0), tBitMask, new Object[]{"dTf", "CMC", "PSP", 'P', OrePrefixes.itemCasing.get(Materials.Birmabright), 'S', OrePrefixes.screw.get(Materials.Birmabright), 'C', OrePrefixes.circuit.get(Materials.Good), 'T', GT_ModHandler.getModItem("WR-CBE|Core", "wirelessTransceiver", 1L, 0), 'M', ItemList.Cover_Screen});
        // --- Wireless Sniffer
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("WR-CBE|Addons", "sniffer", 1L, 0), tBitMask, new Object[]{"DTD", "PSP", "RRR", 'P', OrePrefixes.itemCasing.get(Materials.Birmabright), 'S', OrePrefixes.stick.get(Materials.Birmabright), 'D', GT_ModHandler.getModItem("WR-CBE|Core", "recieverDish", 1L, 0), 'T', GT_ModHandler.getModItem("WR-CBE|Core", "wirelessTransceiver", 1L, 0), 'R', GT_ModHandler.getModItem("ProjRed|Core", "projectred.core.part", 1L, 0)});
        // --- Private Sniffer
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("WR-CBE|Addons", "psniffer", 1L, 0), tBitMask, new Object[]{"DTD", "PSP", "RRR", 'P', OrePrefixes.itemCasing.get(Materials.Birmabright), 'S', OrePrefixes.stick.get(Materials.Birmabright), 'D', GT_ModHandler.getModItem("WR-CBE|Core", "blazeRecieverDish", 1L, 0), 'T', GT_ModHandler.getModItem("WR-CBE|Core", "blazeTransceiver", 1L, 0), 'R', GT_ModHandler.getModItem("ProjRed|Core", "projectred.core.part", 1L, 0)});
        // --- Wireless Transmitter
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("WR-CBE|Logic", "wirelessLogic", 1L, 0), tBitMask, new Object[]{"dTS", "WWI", "RRR", 'W', OrePrefixes.wireGt01.get(Materials.RedAlloy), 'S', OrePrefixes.screw.get(Materials.StainlessSteel), 'I', OrePrefixes.stick.get(Materials.Birmabright), 'T', GT_ModHandler.getModItem("WR-CBE|Core", "wirelessTransceiver", 1L, 0), 'R', GT_ModHandler.getModItem("ProjRed|Core", "projectred.core.part", 1L, 0)});
        // --- Wireless Receiver
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("WR-CBE|Logic", "wirelessLogic", 1L, 1), tBitMask, new Object[]{"dTS", "WWI", "RRR", 'W', OrePrefixes.wireGt01.get(Materials.RedAlloy), 'S', OrePrefixes.screw.get(Materials.StainlessSteel), 'I', OrePrefixes.stick.get(Materials.Birmabright), 'T', GT_ModHandler.getModItem("WR-CBE|Core", "recieverDish", 1L, 0), 'R', GT_ModHandler.getModItem("ProjRed|Core", "projectred.core.part", 1L, 0)});
        // --- Wireless Jammer
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("WR-CBE|Logic", "wirelessLogic", 1L, 2), tBitMask, new Object[]{"dTS", "WWI", "RRR", 'W', OrePrefixes.wireGt01.get(Materials.RedAlloy), 'S', OrePrefixes.screw.get(Materials.StainlessSteel), 'I', OrePrefixes.stick.get(Materials.Birmabright), 'T', GT_ModHandler.getModItem("WR-CBE|Core", "blazeTransceiver", 1L, 0), 'R', GT_ModHandler.getModItem("ProjRed|Core", "projectred.core.part", 1L, 0)});
        // --- Workbench
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("ProjRed|Fabrication", "projectred.integration.icblock", 1L), tBitMask, new Object[]{"PCP", "WFW", "WWW", 'P', OrePrefixes.plate.get(Materials.Iron), 'W', OrePrefixes.plate.get(Materials.Wood), 'F', GT_ModHandler.getModItem("Forestry", "factory2", 1L, 2), 'C', ItemList.Cover_Crafting});
        // --- Printer
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("ProjRed|Fabrication", "projectred.integration.icblock", 1L, 1), tBitMask, new Object[]{"EME", "LAL", "PFP", 'P', OrePrefixes.plate.get(Materials.Steel), 'L', "craftingLensRed", 'F', GT_ModHandler.getModItem("Forestry", "factory2", 1L, 2), 'M', ItemList.Cover_Screen, 'E', ItemList.Emitter_LV, 'A', ItemList.Machine_LV_Assembler});
        // --- Screwdriver
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("ProjRed|Core", "projectred.core.screwdriver", 1L, 0), tBitMask, new Object[]{" fI", "BIh", "RB ", 'I', OrePrefixes.stick.get(Materials.Iron), 'R', OrePrefixes.stick.get(Materials.Rubber), 'B', "dyeBlue"});
        // --- Multimeter
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("ProjRed|Core", "projectred.core.wiredebugger", 1L, 0), tBitMask, new Object[]{"WSW", "PGP", "RdR", 'S', OrePrefixes.stick.get(Materials.SteelMagnetic), 'W', OrePrefixes.wireGt01.get(Materials.RedAlloy), 'P', OrePrefixes.itemCasing.get(Materials.Steel), 'G', OrePrefixes.plate.get(Materials.Glowstone), 'R', OrePrefixes.screw.get(Materials.Steel)});
        // --- Circuit Plate
        GT_ModHandler.addShapelessCraftingRecipe(GT_ModHandler.getModItem("ProjRed|Core", "projectred.core.part", 1L, 0), tBitMask, new Object[]{OrePrefixes.plate.get(Materials.Concrete)});
        // --- Insulated Red Alloy Wires
        for (int i = 0; i < 16; i++) {
            GT_ModHandler.addShapelessCraftingRecipe(GT_ModHandler.getModItem("ProjRed|Transmission", "projectred.transmission.wire", 1L, 16 - i), tBitMask, new Object[]{GT_ModHandler.getModItem("ProjRed|Transmission", "projectred.transmission.wire", 1L, 0), GT_ModHandler.getModItem("ProjRed|Transmission", "projectred.transmission.wire", 1L, 0), OrePrefixes.plate.get(Materials.Rubber), Dyes.VALUES[i]});
        }
    }

    private void wiremillRecipe() {
        // --- RedAlloy Cable
        RA.addWiremillRecipe(GT_OreDictUnificator.get(OrePrefixes.wireGt02, Materials.RedAlloy, 1L), getModItem("ProjRed|Transmission", "projectred.transmission.wire", 4L, 0), 400, 2);
    }

    private void formingPressRecipe() {
        // --- Silicon Chip
        RA.addFormingPressRecipe(GT_ModHandler.getModItem("ProjRed|Core", "projectred.core.part", 1L, 0), GT_ModHandler.getModItem("ProjRed|Core", "projectred.core.part", 1L, 13), GT_ModHandler.getModItem("ProjRed|Core", "projectred.core.part", 1L, 7), 600, 30);
        RA.addFormingPressRecipe(GT_ModHandler.getModItem("ProjRed|Core", "projectred.core.part", 1L, 42), ItemList.Shape_Mold_Ball.get(0), GT_ModHandler.getModItem("ProjRed|Core", "projectred.core.part", 1L, 13), 600, 30);
        // --- Energized Chip
        RA.addFormingPressRecipe(GT_ModHandler.getModItem("ProjRed|Core", "projectred.core.part", 1L, 0), GT_ModHandler.getModItem("ProjRed|Core", "projectred.core.part", 1L, 14), GT_ModHandler.getModItem("ProjRed|Core", "projectred.core.part", 1L, 8), 600, 30);
        RA.addFormingPressRecipe(GT_ModHandler.getModItem("ProjRed|Core", "projectred.core.part", 1L, 43), ItemList.Shape_Mold_Ball.get(0), GT_ModHandler.getModItem("ProjRed|Core", "projectred.core.part", 1L, 14), 600, 30);
    }

    private void mixerRecipe() {
        for (int i = 0; i < 16; i++) {
            RA.addMixerRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Glowstone, 2L), ItemList.DYE_ONLY_ITEMS[15 - i].get(2), GT_Utility.getIntegratedCircuit(1), null, null, null, GT_ModHandler.getModItem("ProjRed|Core", "projectred.core.part", 1L, 19 + i), 50, 8);
        }
        RA.addMixerRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Electrum, 1L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Redstone, 1L), GT_Utility.getIntegratedCircuit(1), GT_Values.NI, GT_Values.NF, GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Electrotine, 1L), 200, 8);
    }

    private void alloySmelterRecipe() {
        // --- Infused Silicon Compound
        RA.addAlloySmelterRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Silicon, 1L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Redstone, 8L), GT_ModHandler.getModItem("ProjRed|Core", "projectred.core.part", 1L, 42), 400, 30);
        // --- Glowing Silicon Compound
        RA.addAlloySmelterRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Silicon, 1L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Glowstone, 8L), GT_ModHandler.getModItem("ProjRed|Core", "projectred.core.part", 1L, 43), 400, 30);
    }

    private void assemblerRecipe() {
        // --- Conductive Plate
        RA.addAssemblerRecipe(GT_ModHandler.getModItem("ProjRed|Core", "projectred.core.part", 1L, 0), GT_Utility.getIntegratedCircuit(1), Materials.Redstone.getMolten(144), GT_ModHandler.getModItem("ProjRed|Core", "projectred.core.part", 1L, 1), 200, 16);
        // --- Wired Plate
        RA.addAssemblerRecipe(GT_ModHandler.getModItem("ProjRed|Core", "projectred.core.part", 1L, 0), GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.RedAlloy, 1), GT_ModHandler.getModItem("ProjRed|Core", "projectred.core.part", 1L, 2), 300, 30);
        // --- Anode
        RA.addAssemblerRecipe(GT_ModHandler.getModItem("ProjRed|Core", "projectred.core.part", 1L, 0), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Redstone, 1), GT_ModHandler.getModItem("ProjRed|Core", "projectred.core.part", 1L, 4), 400, 30);
        // --- Cathode
        RA.addAssemblerRecipe(GT_ModHandler.getModItem("ProjRed|Core", "projectred.core.part", 1L, 0), new ItemStack(Blocks.redstone_torch, 1), GT_ModHandler.getModItem("ProjRed|Core", "projectred.core.part", 1L, 5), 400, 30);
        // --- Pointer
        RA.addAssemblerRecipe(GT_ModHandler.getModItem("ProjRed|Core", "projectred.core.part", 1L, 5), GT_OreDictUnificator.get(OrePrefixes.lens, Materials.Ruby, 1), GT_ModHandler.getModItem("ProjRed|Core", "projectred.core.part", 1L, 6), 500, 30);
        // --- Platformed Plate
        RA.addAssemblerRecipe(GT_ModHandler.getModItem("ProjRed|Core", "projectred.core.part", 4L, 2), GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Plastic, 4), GT_ModHandler.getModItem("ProjRed|Core", "projectred.core.part", 1L, 9), 300, 64);
        // --- Bundled Plate
        for (int i = 17; i < 34; i++) {
            RA.addAssemblerRecipe(GT_ModHandler.getModItem("ProjRed|Core", "projectred.core.part", 1L, 0), GT_ModHandler.getModItem("ProjRed|Transmission", "projectred.transmission.wire", 1L, i), GT_ModHandler.getModItem("ProjRed|Core", "projectred.core.part", 1L, 3), 400, 30);
        }
        // --- Lamp
        for (int i = 0; i < 16; i++) {
            RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Iron, 1), GT_ModHandler.getModItem("ProjRed|Core", "projectred.core.part", 2L, 19 + i), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Redstone, 1), GT_Utility.getIntegratedCircuit(1)}, Materials.Glass.getMolten(216), GT_ModHandler.getModItem("ProjRed|Illumination", "projectred.illumination.lamp", 4L, i), 100, 4, false);
            RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Iron, 1), GT_ModHandler.getModItem("ProjRed|Core", "projectred.core.part", 2L, 19 + i), new ItemStack(Blocks.redstone_torch, 1), GT_Utility.getIntegratedCircuit(1)}, Materials.Glass.getMolten(216), GT_ModHandler.getModItem("ProjRed|Illumination", "projectred.illumination.lamp", 4L, 16 + i), 100, 4, false);
            RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Steel, 1), GT_ModHandler.getModItem("ProjRed|Core", "projectred.core.part", 4L, 19 + i), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Redstone, 2), GT_Utility.getIntegratedCircuit(1)}, Materials.Glass.getMolten(432), GT_ModHandler.getModItem("ProjRed|Illumination", "projectred.illumination.lamp", 8L, i), 120, 6, false);
            RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Steel, 1), GT_ModHandler.getModItem("ProjRed|Core", "projectred.core.part", 4L, 19 + i), new ItemStack(Blocks.redstone_torch, 2), GT_Utility.getIntegratedCircuit(1)}, Materials.Glass.getMolten(432), GT_ModHandler.getModItem("ProjRed|Illumination", "projectred.illumination.lamp", 8L, 16 + i), 120, 6, false);
            RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Aluminium, 1), GT_ModHandler.getModItem("ProjRed|Core", "projectred.core.part", 6L, 19 + i), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Redstone, 3), GT_Utility.getIntegratedCircuit(1)}, Materials.Glass.getMolten(648), GT_ModHandler.getModItem("ProjRed|Illumination", "projectred.illumination.lamp", 16L, i), 140, 8, false);
            RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Aluminium, 1), GT_ModHandler.getModItem("ProjRed|Core", "projectred.core.part", 6L, 19 + i), new ItemStack(Blocks.redstone_torch, 3), GT_Utility.getIntegratedCircuit(1)}, Materials.Glass.getMolten(648), GT_ModHandler.getModItem("ProjRed|Illumination", "projectred.illumination.lamp", 16L, 16 + i), 140, 8, false);
            RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.StainlessSteel, 1), GT_ModHandler.getModItem("ProjRed|Core", "projectred.core.part", 8L, 19 + i), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Redstone, 4), GT_Utility.getIntegratedCircuit(1)}, Materials.Glass.getMolten(864), GT_ModHandler.getModItem("ProjRed|Illumination", "projectred.illumination.lamp", 32L, i), 160, 10, false);
            RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.StainlessSteel, 1), GT_ModHandler.getModItem("ProjRed|Core", "projectred.core.part", 8L, 19 + i), new ItemStack(Blocks.redstone_torch, 4), GT_Utility.getIntegratedCircuit(1)}, Materials.Glass.getMolten(864), GT_ModHandler.getModItem("ProjRed|Illumination", "projectred.illumination.lamp", 32L, 16 + i), 160, 10, false);
        }

        RA.addAssemblerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Birmabright, 1L),
                GT_ModHandler.getModItem("WR-CBE|Core", "retherPearl", 1L, 0),
                GT_ModHandler.getModItem("WR-CBE|Core", "wirelessTransceiver", 1L, 0), 600, 120);
        // --- Blaze Transceiver
        GT_Values.RA
                .addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Electrum, 1L),
                        GT_ModHandler.getModItem("WR-CBE|Core", "retherPearl", 1L, 0),
                        GT_ModHandler.getModItem("WR-CBE|Core", "blazeTransceiver", 1L, 0), 600, 120);
        // --- Receiver Dish
        RA.addAssemblerRecipe(GT_ModHandler.getModItem("WR-CBE|Core", "stoneBowl", 1L, 0),
                GT_ModHandler.getModItem("WR-CBE|Core", "wirelessTransceiver", 1L, 0),
                GT_ModHandler.getModItem("WR-CBE|Core", "recieverDish", 1L, 0), 600, 256);
        // --- Blaze Receiver Dish
        RA.addAssemblerRecipe(GT_ModHandler.getModItem("WR-CBE|Core", "stoneBowl", 1L, 0),
                GT_ModHandler.getModItem("WR-CBE|Core", "blazeTransceiver", 1L, 0),
                GT_ModHandler.getModItem("WR-CBE|Core", "blazeRecieverDish", 1L, 0), 600, 256);
        // --- Triangulatior
        RA.addAssemblerRecipe(GT_ModHandler.getModItem("minecraft", "compass", 1L, 0),
                GT_ModHandler.getModItem("WR-CBE|Core", "wirelessTransceiver", 1L, 0),
                Materials.Redstone.getMolten(144),
                GT_ModHandler.getModItem("WR-CBE|Addons", "triangulator", 1L, 0), 600, 120);
        // --- Wireless Map
        GT_Values.RA
                .addAssemblerRecipe(GT_ModHandler.getModItem("WR-CBE|Addons", "triangulator", 1L, 0),
                        GT_ModHandler.getModItem("minecraft", "paper", 8L, 0),
                        Materials.Redstone.getMolten(144),
                        GT_ModHandler.getModItem("WR-CBE|Addons", "map", 1L, 0), 300, 64);
        // --- Tracker
        GT_Values.RA
                .addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Obsidian, 3L),
                        GT_ModHandler.getModItem("WR-CBE|Core", "wirelessTransceiver", 1L, 0),
                        Materials.Redstone.getMolten(144),
                        GT_ModHandler.getModItem("WR-CBE|Addons", "tracker", 1L, 0), 600, 120);
        // --- REP
        GT_Values.RA
                .addAssemblerRecipe(GT_ModHandler.getModItem("WR-CBE|Core", "blazeTransceiver", 2L, 0),
                        GT_ModHandler.getModItem("WR-CBE|Core", "retherPearl", 2L, 0),
                        Materials.Obsidian.getMolten(1296),
                        GT_ModHandler.getModItem("WR-CBE|Addons", "rep", 1L, 0), 600, 120);

    }

    private void circuitAssemblerRecipe() {
                //ICChip
                RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Coated.get(1), GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Copper, 6)}, Materials.SolderingAlloy.getMolten(72L), GT_ModHandler.getModItem("ProjRed|Fabrication", "projectred.fabrication.icchip", 1L, 0), 200, 16);
                RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Phenolic.get(1), GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Gold, 6)}, Materials.SolderingAlloy.getMolten(72L), GT_ModHandler.getModItem("ProjRed|Fabrication", "projectred.fabrication.icchip", 2L, 0), 200, 30);
                RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Plastic.get(1), GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Electrum, 6)}, Materials.SolderingAlloy.getMolten(72L), GT_ModHandler.getModItem("ProjRed|Fabrication", "projectred.fabrication.icchip", 4L, 0), 200, 48);
    }

    private void chemicalBathRecipe() {
        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < Dyes.VALUES[i].getSizeOfFluidList(); j++) {
                RA.addChemicalBathRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Glowstone, 2L), Dyes.VALUES[i].getFluidDye(j, 36L), GT_ModHandler.getModItem("ProjRed|Core", "projectred.core.part", 1L, 34 - i), GT_Values.NI, GT_Values.NI, null, 64, 2);
            }
        }
    }

    private void chemical() {
        RA.addChemicalRecipe(GT_OreDictUnificator.get(OrePrefixes.gemFlawless, Materials.Diamond, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Glowstone, 1L),
                Materials.Redstone.getMolten(144), null,
                GT_ModHandler.getModItem("WR-CBE|Core", "retherPearl", 1L, 0), 1200);

    }

    private static class LaserEngraver implements IOreRecipeRegistrator {

        private LaserEngraver() {
            OrePrefixes.lens.add(this);
        }

        @Override
        public void registerOre(OrePrefixes aPrefix, Materials aMaterial, String aOreDictName, String aModName, ItemStack aStack) {
            if (aOreDictName.equals("craftingLensRed")) {
            }
        }
    }
}
