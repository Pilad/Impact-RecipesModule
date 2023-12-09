package com.impactrecipes.recipes;

import com.impact.common.item.Core_Items2;
import com.impact.mods.gregtech.GT_ItemList;
import gregtech.api.enums.GT_Values;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.util.GT_ModHandler;
import gregtech.api.util.GT_OreDictUnificator;
import gregtech.api.util.GT_Utility;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;

import static gregtech.api.enums.GT_Values.RA;
import static gregtech.api.util.GT_ModHandler.removeFurnaceSmelting;
import static gregtech.api.util.GT_ModHandler.removeRecipeByOutput;

public class GalactiCraft implements Runnable {

    private static final long tBitMask = GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE;

    final Core_Items2 CoreItems2 = Core_Items2.getInstance();

    @Override
    public void run() {
        removeGalactiCraft();
        hand();
        pulverizer();
        printer3d();
        fluidCanner();
        extruder();
        extractor();
        canner();
        arcFurnace();
        assembler();
        cuttingSaw();
    }

    private void removeGalactiCraft() {

        removeFurnaceSmelting(
                GT_ModHandler.getModItem("GalacticraftMars", "tile.asteroidsBlock", 1L, 4));
        removeFurnaceSmelting(
                GT_ModHandler.getModItem("GalacticraftMars", "item.itemBasicAsteroids", 1L, 4));
        removeFurnaceSmelting(GT_ModHandler.getModItem("GalacticraftMars", "tile.mars", 1L, 2));
        removeFurnaceSmelting(GT_ModHandler.getModItem("GalacticraftMars", "item.null", 1L));

        removeFurnaceSmelting(GT_ModHandler.getModItem("Backpack", "boundLeather", 1L));
        removeRecipeByOutput(GT_ModHandler.getModItem("GalacticraftCore", "tile.arclamp", 1L, 0), true,
                false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("GalacticraftCore", "tile.oxygenPipe", 1L, 0),
                true, false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("GalacticraftCore", "item.oxygenMask", 1L, 0),
                true, false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("GalacticraftCore", "item.steelPole", 1L, 0),
                true, false, true);
        removeRecipeByOutput(
                GT_ModHandler.getModItem("GalacticraftMars", "item.itemBasicAsteroids", 1L, 7), true, false,
                true);
        removeRecipeByOutput(GT_ModHandler.getModItem("GalacticraftCore", "tile.glowstoneTorch", 1L),
                true, false, true);
        removeRecipeByOutput(
                GT_ModHandler.getModItem("GalacticraftCore", "item.oilCanisterPartial", 1L, 1001), true,
                false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("GalacticraftMars", "tile.hydrogenPipe", 1L),
                true, false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("GalacticraftMars", "item.thermalPadding", 1L),
                true, false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("GalacticraftMars", "item.thermalPadding", 1L, 1),
                true, false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("GalacticraftMars", "item.thermalPadding", 1L, 2),
                true, false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("GalacticraftMars", "item.thermalPadding", 1L, 3),
                true, false, true);
        removeRecipeByOutput(
                GT_ModHandler.getModItem("GalacticraftCore", "item.oxygenTankLightFull", 1L, 1800), true,
                false, true);
        removeRecipeByOutput(
                GT_ModHandler.getModItem("GalacticraftCore", "item.oxygenTankMedFull", 1L, 3600), true,
                false, true);
        removeRecipeByOutput(
                GT_ModHandler.getModItem("GalacticraftCore", "item.oxygenTankHeavyFull", 1L, 5400), true,
                false, true);
        removeRecipeByOutput(
                GT_ModHandler.getModItem("GalacticraftMars", "item.methaneCanisterPartial", 1L, 1), true,
                false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("GalacticraftCore", "tile.landingPad", 1L, 0),
                true, false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("GalacticraftCore", "tile.landingPad", 1L, 1),
                true, false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("GalacticraftCore", "item.sensorGlasses", 1L, 0),
                true, false, true);
        removeRecipeByOutput(
                GT_ModHandler.getModItem("GalacticraftCore", "tile.oxygenCollector", 1L, 0), true, false,
                true);
        removeRecipeByOutput(
                GT_ModHandler.getModItem("GalacticraftCore", "tile.oxygenCompressor", 1L, 0), true, false,
                true);
        removeRecipeByOutput(
                GT_ModHandler.getModItem("GalacticraftCore", "tile.oxygenCompressor", 1L, 4), true, false,
                true);
        removeRecipeByOutput(GT_ModHandler.getModItem("GalacticraftCore", "tile.machine2", 1L, 8), true,
                false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("GalacticraftCore", "tile.distributor", 1L, 0),
                true, false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("GalacticraftCore", "tile.sealer", 1L, 0), true,
                false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("GalacticraftCore", "tile.oxygenDetector", 1L, 0),
                true, false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("GalacticraftCore", "tile.refinery", 1L, 0), true,
                false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("GalacticraftCore", "tile.fuelLoader", 1L, 0),
                true, false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("GalacticraftCore", "tile.cargo", 1L, 0), true,
                false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("GalacticraftCore", "tile.cargo", 1L, 4), true,
                false, true);
        removeRecipeByOutput(
                GT_ModHandler.getModItem("GalacticraftCore", "tile.rocketWorkbench", 1L, 0), true, false,
                true);
        removeRecipeByOutput(GT_ModHandler.getModItem("GalacticraftCore", "tile.gcBlockCore", 1L, 3),
                true, false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("GalacticraftCore", "tile.gcBlockCore", 1L, 4),
                true, false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("GalacticraftCore", "tile.gcBlockCore", 1L, 9),
                true, false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("GalacticraftCore", "tile.gcBlockCore", 1L, 10),
                true, false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("GalacticraftCore", "tile.gcBlockCore", 1L, 11),
                true, false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("GalacticraftCore", "tile.gcBlockCore", 1L, 12),
                true, false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("GalacticraftCore", "tile.airLockFrame", 1L, 0),
                true, false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("GalacticraftCore", "tile.airLockFrame", 1L, 1),
                true, false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("GalacticraftCore", "tile.solar", 1L, 0), true,
                false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("GalacticraftCore", "tile.solar", 1L, 4), true,
                false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("GalacticraftCore", "item.basicItem", 1L, 12),
                true, false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("GalacticraftCore", "item.basicItem", 1L, 0),
                true, false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("GalacticraftCore", "item.basicItem", 1L, 1),
                true, false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("GalacticraftCore", "tile.machine", 1L, 0), true,
                false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("GalacticraftCore", "tile.machine", 1L, 12), true,
                false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("GalacticraftCore", "tile.machine2", 1L, 0), true,
                false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("GalacticraftCore", "tile.machine2", 1L, 4), true,
                false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("GalacticraftCore", "tile.machineTiered", 1L, 0),
                true, false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("GalacticraftCore", "tile.machineTiered", 1L, 4),
                true, false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("GalacticraftCore", "tile.machineTiered", 1L, 8),
                true, false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("GalacticraftCore", "tile.machineTiered", 1L, 12),
                true, false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("GalacticraftCore", "tile.spinThruster", 1L, 0),
                true, false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("GalacticraftCore", "tile.viewScreen", 1L, 0),
                true, false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("GalacticraftCore", "tile.telemetry", 1L, 0),
                true, false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("GalacticraftCore", "item.oxygenGear", 1L, 0),
                true, false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("GalacticraftCore", "item.canister", 1L, 0), true,
                false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("GalacticraftCore", "item.canister", 1L, 1), true,
                false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("GalacticraftCore", "item.airFan", 1L, 0), true,
                false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("GalacticraftCore", "item.airVent", 1L, 0), true,
                false, true);
        removeRecipeByOutput(
                GT_ModHandler.getModItem("GalacticraftCore", "item.oxygenConcentrator", 1L, 0), true, false,
                true);
        removeRecipeByOutput(GT_ModHandler.getModItem("GalacticraftCore", "item.engine", 1L, 0), true,
                false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("GalacticraftCore", "item.engine", 1L, 1), true,
                false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("GalacticraftCore", "item.noseCone", 1L, 0), true,
                false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("GalacticraftCore", "item.oilExtractor", 1L, 0),
                true, false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("GalacticraftCore", "item.buggymat", 1L, 0), true,
                false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("GalacticraftCore", "item.buggymat", 1L, 1), true,
                false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("GalacticraftCore", "item.buggymat", 1L, 2), true,
                false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("GalacticraftCore", "item.standardWrench", 1L, 0),
                true, false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("GalacticraftCore", "item.basicItem", 1L, 15),
                true, false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("GalacticraftCore", "item.basicItem", 1L, 16),
                true, false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("GalacticraftCore", "item.basicItem", 1L, 17),
                true, false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("GalacticraftCore", "item.basicItem", 1L, 18),
                true, false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("GalacticraftCore", "item.basicItem", 1L, 19),
                true, false, true);
        removeRecipeByOutput(
                GT_ModHandler.getModItem("GalacticraftMars", "item.titanium_pickaxe", 1L, 0), true, false,
                true);
        removeRecipeByOutput(GT_ModHandler.getModItem("GalacticraftMars", "item.titanium_axe", 1L, 0),
                true, false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("GalacticraftMars", "item.titanium_hoe", 1L, 0),
                true, false, true);
        removeRecipeByOutput(
                GT_ModHandler.getModItem("GalacticraftMars", "item.titanium_shovel", 1L, 0), true, false,
                true);
        removeRecipeByOutput(GT_ModHandler.getModItem("GalacticraftMars", "item.titanium_sword", 1L, 0),
                true, false, true);
        removeRecipeByOutput(
                GT_ModHandler.getModItem("GalacticraftMars", "item.titanium_helmet", 1L, 0), true, false,
                true);
        removeRecipeByOutput(
                GT_ModHandler.getModItem("GalacticraftMars", "item.titanium_chestplate", 1L, 0), true,
                false, true);
        removeRecipeByOutput(
                GT_ModHandler.getModItem("GalacticraftMars", "item.titanium_leggings", 1L, 0), true, false,
                true);
        removeRecipeByOutput(GT_ModHandler.getModItem("GalacticraftMars", "item.titanium_boots", 1L, 0),
                true, false, true);

        removeRecipeByOutput(GT_ModHandler.getModItem("GalacticraftCore", "item.steel_pickaxe", 1L, 0),
                true, false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("GalacticraftCore", "item.steel_axe", 1L, 0),
                true, false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("GalacticraftCore", "item.steel_hoe", 1L, 0),
                true, false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("GalacticraftCore", "item.steel_shovel", 1L, 0),
                true, false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("GalacticraftCore", "item.steel_sword", 1L, 0),
                true, false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("GalacticraftCore", "item.steel_helmet", 1L, 0),
                true, false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("GalacticraftCore", "item.steel_chestplate", 1L, 0),
                true, false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("GalacticraftCore", "item.steel_leggings", 1L, 0),
                true, false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("GalacticraftCore", "item.steel_boots", 1L, 0),
                true, false, true);

        removeRecipeByOutput(GT_ModHandler.getModItem("GalacticraftMars", "tile.mars", 1L, 8), true,
                false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("GalacticraftMars", "item.null", 1L, 1), true,
                false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("GalacticraftMars", "tile.marsMachineT2", 1L, 4),
                true, false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("GalacticraftMars", "tile.marsMachineT2", 1L, 8),
                true, false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("GalacticraftMars", "tile.walkway", 1L, 0), true,
                false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("GalacticraftMars", "tile.walkwayWire", 1L, 0),
                true, false, true);
        removeRecipeByOutput(
                GT_ModHandler.getModItem("GalacticraftMars", "tile.walkwayOxygenPipe", 1L, 0), true, false,
                true);
        removeRecipeByOutput(
                GT_ModHandler.getModItem("GalacticraftMars", "item.atmosphericValve", 1L, 0), true, false,
                true);
        removeRecipeByOutput(
                GT_ModHandler.getModItem("GalacticraftMars", "item.itemBasicAsteroids", 1L, 2), true, false,
                true);
        removeRecipeByOutput(
                GT_ModHandler.getModItem("GalacticraftMars", "item.itemBasicAsteroids", 1L, 1), true, false,
                true);
        removeRecipeByOutput(GT_ModHandler.getModItem("GalacticraftMars", "item.heavyNoseCone", 1L, 0),
                true, false, true);
        removeRecipeByOutput(
                GT_ModHandler.getModItem("GalacticraftMars", "item.itemBasicAsteroids", 1L, 8), true, false,
                true);
        removeRecipeByOutput(GT_ModHandler.getModItem("GalacticraftMars", "tile.beamReflector", 1L, 0),
                true, false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("GalacticraftMars", "tile.beamReceiver", 1L, 0),
                true, false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("GalacticraftMars", "tile.telepadShort", 1L, 0),
                true, false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("GalacticraftMars", "tile.marsMachine", 1L, 0),
                true, false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("GalacticraftMars", "tile.marsMachine", 1L, 4),
                true, false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("GalacticraftMars", "tile.marsMachine", 1L, 8),
                true, false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("GalacticraftMars", "item.grapple", 1L, 0), true,
                false, true);
        removeRecipeByOutput(
                GT_ModHandler.getModItem("GalacticraftMars", "item.carbonFragments", 1L, 0), true, false,
                true);
        removeRecipeByOutput(GT_ModHandler.getModItem("GalacticraftMars", "item.deshPick", 1L, 0), true,
                false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("GalacticraftMars", "item.deshAxe", 1L, 0), true,
                false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("GalacticraftMars", "item.deshHoe", 1L, 0), true,
                false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("GalacticraftMars", "item.deshSpade", 1L, 0),
                true, false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("GalacticraftMars", "item.deshSword", 1L, 0),
                true, false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("GalacticraftCore", "item.rocketFins", 1L, 0),
                true, false, true);
        removeRecipeByOutput(
                GT_ModHandler.getModItem("GalacticraftMars", "item.itemBasicAsteroids", 1L, 2), true, false,
                true);
        removeRecipeByOutput(GT_ModHandler.getModItem("GalacticraftCore", "item.canvas", 1L, 0), true,
                false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("GalacticraftCore", "item.parachute", 1L, 0),
                true, false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("GalacticraftMars", "item.deshHelmet", 1L, 0),
                true, false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("GalacticraftMars", "item.deshChestplate", 1L, 0),
                true, false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("GalacticraftMars", "item.deshLeggings", 1L, 0),
                true, false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("GalacticraftMars", "item.deshBoots", 1L, 0),
                true, false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("GalacticraftMars", "item.orionDrive", 1L, 0),
                true, false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("GalacticraftCore", "tile.enclosed", 1L, 2), true,
                false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("GalacticraftCore", "tile.enclosed", 1L, 3), true,
                false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("GalacticraftCore", "tile.enclosed", 1L, 4), true,
                false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("GalacticraftCore", "tile.enclosed", 1L, 5), true,
                false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("GalacticraftCore", "tile.enclosed", 1L, 6), true,
                false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("GalacticraftCore", "tile.aluminumWire", 1L, 0),
                true, false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("GalacticraftCore", "tile.aluminumWire", 1L, 1),
                true, false, true);
        removeRecipeByOutput(
                GT_ModHandler.getModItem("GalacticraftCore", "item.battery", 1L, GT_Values.W), true, false,
                true);
        removeRecipeByOutput(GT_ModHandler.getModItem("GalacticraftCore", "slabGCHalf", 1L, 0), true,
                false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("GalacticraftCore", "slabGCHalf", 1L, 1), true,
                false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("GalacticraftCore", "slabGCHalf", 1L, 2), true,
                false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("GalacticraftCore", "slabGCHalf", 1L, 3), true,
                false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("GalacticraftCore", "slabGCHalf", 1L, 4), true,
                false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("GalacticraftCore", "slabGCHalf", 1L, 5), true,
                false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("GalacticraftCore", "item.basicItem", 1L, 20));
    }

    private void hand() {
        // --- Arc Lamp
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("GalacticraftCore", "tile.arclamp", 1L, 0), tBitMask, new Object[]{"PRP", "CEL", "PRP", 'P', OrePrefixes.plate.get(Materials.BlackSteel), 'R', OrePrefixes.ring.get(Materials.BlackSteel), 'C', OrePrefixes.circuit.get(Materials.Good), 'L', OrePrefixes.lens.get(Materials.Glass), 'E', ItemList.Emitter_MV});
        // --- Light Oxygen Tank
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("GalacticraftCore", "item.oxygenTankLightFull", 1L, 1800), tBitMask, new Object[]{"PTP", "PCP", "PPP", 'P', GT_ModHandler.getModItem("GalacticraftCore", "item.basicItem", 1L, 8), 'C', ItemList.Large_Fluid_Cell_Steel.get(1), 'T', GT_ModHandler.getModItem("GalacticraftCore", "tile.oxygenPipe", 1L)});
        // --- Medium Oxygen Tank
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("GalacticraftCore", "item.oxygenTankMedFull", 1L, 3600), tBitMask, new Object[]{"PTP", "PCP", "PPP", 'P', GT_ModHandler.getModItem("GalacticraftCore", "item.meteoricIronIngot", 1L, 1), 'C', ItemList.Large_Fluid_Cell_Aluminium.get(1), 'T', GT_ModHandler.getModItem("GalacticraftCore", "tile.oxygenPipe", 1L)});
        // --- Heavy Oxygen Tank
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("GalacticraftCore", "item.oxygenTankHeavyFull", 1L, 5400), tBitMask, new Object[]{"PTP", "PCP", "PPP", 'P', GT_ModHandler.getModItem("GalacticraftMars", "item.null", 1L, 5), 'C', ItemList.Large_Fluid_Cell_StainlessSteel.get(1), 'T', GT_ModHandler.getModItem("GalacticraftCore", "tile.oxygenPipe", 1L)});
        // --- T4 Oxygen Tank
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("GalacticraftCore", "item.oxygenTankt4", 1L, 7200), tBitMask, new Object[]{"PTP", "PCP", "PPP", 'P', CoreItems2.getRecipe(84, 1), 'C', ItemList.Large_Fluid_Cell_Titanium.get(1), 'T', GT_ModHandler.getModItem("GalacticraftCore", "tile.oxygenPipe", 1L)});
        // --- T5 Oxygen Tank
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("GalacticraftCore", "item.oxygenTankt5", 1L, 9000), tBitMask, new Object[]{"PTP", "PCP", "PPP", 'P', OrePrefixes.plateTriple.get(Materials.Trinium), 'C', ItemList.Large_Fluid_Cell_TungstenSteel.get(1), 'T', GT_ModHandler.getModItem("GalacticraftCore", "tile.oxygenPipe", 1L)});
        // --- Fins 1
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("GalacticraftCore", "item.rocketFins", 1L), tBitMask, new Object[]{"SPS", "HPH", "HCH", 'S', OrePrefixes.screw.get(Materials.StainlessSteel), 'P', GT_ModHandler.getModItem("GalacticraftCore", "item.basicItem", 1L, 9), 'H', GT_ModHandler.getModItem("GalacticraftCore", "item.heavyPlating", 1L), 'C', GT_ModHandler.getModItem("GalaxySpace", "item.CompressedPlates", 1L, 4)});
        // --- Fins 2
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("GalacticraftMars", "item.itemBasicAsteroids", 1L, 2), tBitMask, new Object[]{"SPS", "HPH", "HPH", 'S', OrePrefixes.screw.get(Materials.TungstenSteel), 'P', GT_ModHandler.getModItem("GalacticraftMars", "item.null", 1L, 3), 'H', GT_ModHandler.getModItem("GalacticraftMars", "item.itemBasicAsteroids", 1L)});
        // --- Rocket Launch Pad
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("GalacticraftCore", "tile.landingPad", 3L), tBitMask, new Object[]{"III", "PPP", "BBB", 'B', OrePrefixes.frameGt.get(Materials.StainlessSteel), 'P', GT_ModHandler.getModItem("GalacticraftCore", "item.basicItem", 1L, 9), 'I', GT_ModHandler.getModItem("IC2", "itemPartAlloy", 1L)});
        // --- Buggy Fueling Pad
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("GalacticraftCore", "tile.landingPad", 3L, 1), tBitMask, new Object[]{"III", "PPP", "BBB", 'B', OrePrefixes.block.get(Materials.Steel), 'P', GT_ModHandler.getModItem("GalacticraftCore", "item.basicItem", 1L, 9), 'I', GT_ModHandler.getModItem("IC2", "itemPartAlloy", 1L)});
        // --- Oxygen Collector
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("GalacticraftCore", "tile.oxygenCollector", 1L), tBitMask, new Object[]{"ACA", "VFM", "SWS", 'W', OrePrefixes.cableGt02.get(Materials.Aluminium), 'A', GT_ModHandler.getModItem("GalacticraftCore", "item.basicItem", 1L, 8), 'S', GT_ModHandler.getModItem("GalacticraftCore", "item.basicItem", 1L, 9), 'C', GT_ModHandler.getModItem("GalacticraftCore", "item.oxygenConcentrator", 1L), 'V', GT_ModHandler.getModItem("GalacticraftCore", "item.airVent", 1L), 'F', GT_ModHandler.getModItem("GalacticraftCore", "item.airFan", 1L), 'M', ItemList.Electric_Motor_HV});
        // --- Oxygen Compressor
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("GalacticraftCore", "tile.oxygenCompressor", 1L), tBitMask, new Object[]{"ACA", "PEM", "SBS", 'A', GT_ModHandler.getModItem("GalacticraftCore", "item.basicItem", 1L, 8), 'B', GT_ModHandler.getModItem("GalacticraftCore", "item.basicItem", 1L, 10), 'S', GT_ModHandler.getModItem("GalacticraftCore", "item.basicItem", 1L, 9), 'C', GT_ModHandler.getModItem("GalacticraftCore", "item.oxygenConcentrator", 1L), 'E', GT_ModHandler.getModItem("GalacticraftCore", "item.oilCanisterPartial", 1L, GT_Values.W), 'M', ItemList.Electric_Motor_HV, 'P', ItemList.Electric_Piston_HV});
        // --- Oxygen Decompressor
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("GalacticraftCore", "tile.oxygenCompressor", 1L, 4), tBitMask, new Object[]{"ACA", "MEF", "SBS", 'A', GT_ModHandler.getModItem("GalacticraftCore", "item.basicItem", 1L, 8), 'B', GT_ModHandler.getModItem("GalacticraftCore", "item.basicItem", 1L, 10), 'S', GT_ModHandler.getModItem("GalacticraftCore", "item.basicItem", 1L, 9), 'C', GT_ModHandler.getModItem("GalacticraftCore", "item.oxygenConcentrator", 1L), 'E', GT_ModHandler.getModItem("GalacticraftCore", "item.oilCanisterPartial", 1L, GT_Values.W), 'M', ItemList.Electric_Motor_HV, 'F', GT_ModHandler.getModItem("GalacticraftCore", "item.airFan", 1L)});
        // --- Oxygen Storage Module
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("GalacticraftCore", "tile.machine2", 1L, 8), tBitMask, new Object[]{"STS", "TCT", "STS", 'S', GT_ModHandler.getModItem("GalacticraftCore", "item.basicItem", 1L, 9), 'T', GT_ModHandler.getModItem("GalacticraftCore", "item.oxygenTankHeavyFull", 1L, GT_Values.W), 'C', ItemList.Casing_SolidSteel});
        // --- Oxygen Bubble Distributor
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("GalacticraftCore", "tile.distributor", 1L), tBitMask, new Object[]{"AFA", "VMV", "SFS", 'A', GT_ModHandler.getModItem("GalacticraftCore", "item.basicItem", 1L, 8), 'S', GT_ModHandler.getModItem("GalacticraftCore", "item.basicItem", 1L, 9), 'V', GT_ModHandler.getModItem("GalacticraftCore", "item.airVent", 1L), 'F', GT_ModHandler.getModItem("GalacticraftCore", "item.airFan", 1L), 'M', ItemList.Electric_Motor_HV});
        // --- Oxygen Sealer
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("GalacticraftCore", "tile.sealer", 1L), tBitMask, new Object[]{"AVA", "VBV", "SDS", 'A', GT_ModHandler.getModItem("GalacticraftCore", "item.basicItem", 1L, 8), 'S', GT_ModHandler.getModItem("GalacticraftCore", "item.basicItem", 1L, 9), 'V', GT_ModHandler.getModItem("GalacticraftCore", "item.airVent", 1L), 'B', GT_ModHandler.getModItem("GalacticraftCore", "tile.distributor", 1L), 'D', GT_ModHandler.getModItem("GalacticraftCore", "tile.oxygenDetector", 1L)});
        // --- Oxygen Detector
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("GalacticraftCore", "tile.oxygenDetector", 1L), tBitMask, new Object[]{"SSS", "VEV", "AWA", 'W', OrePrefixes.wireGt01.get(Materials.RedAlloy), 'A', GT_ModHandler.getModItem("GalacticraftCore", "item.basicItem", 1L, 8), 'S', GT_ModHandler.getModItem("GalacticraftCore", "item.basicItem", 1L, 9), 'V', GT_ModHandler.getModItem("GalacticraftCore", "item.airVent", 1L), 'E', ItemList.Sensor_HV});
        // --- Fuel Loader
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("GalacticraftCore", "tile.fuelLoader", 1L), tBitMask, new Object[]{"SWS", "PTM", "AIA", 'I', OrePrefixes.pipeMedium.get(Materials.Steel), 'A', GT_ModHandler.getModItem("GalacticraftCore", "item.basicItem", 1L, 8), 'S', GT_ModHandler.getModItem("GalacticraftCore", "item.basicItem", 1L, 9), 'W', OrePrefixes.circuit.get(Materials.Advanced), 'M', ItemList.Electric_Motor_HV, 'P', ItemList.Electric_Pump_HV, 'T', ItemList.Large_Fluid_Cell_Steel});
        // --- Cargo Loader
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("GalacticraftCore", "tile.cargo", 1L), tBitMask, new Object[]{"AHA", "CBC", "SPS", 'P', OrePrefixes.pipeMedium.get(Materials.Brass), 'A', GT_ModHandler.getModItem("GalacticraftCore", "item.basicItem", 1L, 8), 'S', GT_ModHandler.getModItem("GalacticraftCore", "item.basicItem", 1L, 9), 'H', GT_ModHandler.getModItem("minecraft", "hopper", 1L), 'C', ItemList.Conveyor_Module_HV, 'B', ItemList.Automation_ChestBuffer_HV});
        // --- Cargo Unloader
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("GalacticraftCore", "tile.cargo", 1L, 4), tBitMask, new Object[]{"APA", "CBC", "SHS", 'P', OrePrefixes.pipeMedium.get(Materials.Brass), 'A', GT_ModHandler.getModItem("GalacticraftCore", "item.basicItem", 1L, 8), 'S', GT_ModHandler.getModItem("GalacticraftCore", "item.basicItem", 1L, 9), 'H', GT_ModHandler.getModItem("minecraft", "hopper", 1L), 'C', ItemList.Conveyor_Module_HV, 'B', ItemList.Automation_ChestBuffer_HV});
        // --- Decorate Tin
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("GalacticraftCore", "tile.gcBlockCore", 5L, 4), tBitMask, new Object[]{"hP ", "PSP", " Pw", 'P', GT_ModHandler.getModItem("GalacticraftCore", "item.basicItem", 1L, 7), 'S', "stone"});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("GalacticraftCore", "tile.gcBlockCore", 5L, 3), tBitMask, new Object[]{" Ph", "PSP", "wP ", 'P', GT_ModHandler.getModItem("GalacticraftCore", "item.basicItem", 1L, 7), 'S', "stone"});
        // --- Air Lock Frame
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("GalacticraftCore", "tile.airLockFrame", 2L), tBitMask, new Object[]{"DSD", "VdV", "ASA", 'S', OrePrefixes.screw.get(Materials.StainlessSteel), 'A', GT_ModHandler.getModItem("GalacticraftCore", "item.basicItem", 1L, 8), 'D', GT_ModHandler.getModItem("GalacticraftCore", "item.meteoricIronIngot", 1L, 1), 'V', GT_ModHandler.getModItem("GalacticraftCore", "item.airVent", 1L)});
        // --- Air Lock Controller
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("GalacticraftCore", "tile.airLockFrame", 1L, 1), tBitMask, new Object[]{"PPP", "VAV", "WRW", 'P', OrePrefixes.plate.get(Materials.MeteoricSteel), 'R', OrePrefixes.wireGt01.get(Materials.RedAlloy), 'W', OrePrefixes.circuit.get(Materials.Advanced), 'A', GT_ModHandler.getModItem("GalacticraftCore", "tile.airLockFrame", 1L), 'V', GT_ModHandler.getModItem("GalacticraftCore", "item.airVent", 1L)});
        // --- Aluminium Wire
        GT_ModHandler.addShapelessCraftingRecipe(GT_ModHandler.getModItem("GalacticraftCore", "tile.aluminumWire", 1L), tBitMask, new Object[]{OrePrefixes.cableGt01.get(Materials.Aluminium)});
        // --- Heavy Aluminium Wire
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("GalacticraftCore", "tile.aluminumWire", 3L, 1), tBitMask, new Object[]{"AAA", "WWW", "AAA", 'A', GT_ModHandler.getModItem("GalacticraftCore", "item.basicItem", 1L, 8), 'W', GT_ModHandler.getModItem("GalacticraftCore", "tile.aluminumWire", 1L)});
        // --- Spin Truster
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("GalacticraftCore", "tile.spinThruster", 1L), tBitMask, new Object[]{"TTT", "CWC", "EPE", 'T', GT_ModHandler.getModItem("GalacticraftCore", "item.basicItem", 1L, 6), 'W', OrePrefixes.circuit.get(Materials.Advanced), 'P', GT_ModHandler.getModItem("GalacticraftCore", "item.heavyPlating", 1L), 'E', GT_ModHandler.getModItem("GalacticraftCore", "item.engine", 1L), 'C', GT_ModHandler.getModItem("GalacticraftCore", "item.fuelCanisterPartial", 1L, 1)});
        // --- Telemetry Unit
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("GalacticraftCore", "tile.telemetry", 1L), tBitMask, new Object[]{"MPE", "WPW", "PCP", 'P', GT_ModHandler.getModItem("GalacticraftCore", "item.basicItem", 1L, 7), 'W', OrePrefixes.circuit.get(Materials.Advanced), 'C', GT_ModHandler.getModItem("GalacticraftCore", "item.basicItem", 1L, 6), 'M', GT_ModHandler.getModItem("GalacticraftCore", "item.basicItem", 1L, 19), 'E', ItemList.Emitter_HV});
        // --- Canvas
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("GalacticraftCore", "item.canvas", 1L), tBitMask, new Object[]{"LWS", "WSW", "SWL", 'S', OrePrefixes.stick.get(Materials.Plastic), 'W', "blockWool", 'P', GT_ModHandler.getModItem("Backpack", "tannedLeather", 1L)});
        // --- Oxygen Gear
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("GalacticraftCore", "item.oxygenGear", 1L), tBitMask, new Object[]{"PPP", "ECE", "PIP", 'P', GT_ModHandler.getModItem("GalacticraftCore", "tile.oxygenPipe", 1L), 'C', GT_ModHandler.getModItem("GalacticraftCore", "item.oxygenConcentrator", 1L), 'E', ItemList.Electric_Pump_HV, 'I', ItemList.Electric_Piston_HV});
        // --- Sensor Glasses
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("GalacticraftCore", "item.sensorGlasses", 1L), tBitMask, new Object[]{"CSC", "RBR", "LdL", 'L', GT_ModHandler.getModItem("GalacticraftCore", "item.sensorLens", 1L), 'C', OrePrefixes.circuit.get(Materials.Data), 'S', OrePrefixes.screw.get(Materials.MeteoricIron), 'R', OrePrefixes.ring.get(Materials.Desh), 'B', OrePrefixes.bolt.get(Materials.Desh)});
        // --- Oxygen Vent
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("GalacticraftCore", "item.airVent", 1L), tBitMask, new Object[]{"BPB", "PSP", "BPB", 'P', GT_ModHandler.getModItem("GalacticraftCore", "item.basicItem", 1L, 7), 'S', GT_ModHandler.getModItem("GalacticraftCore", "item.basicItem", 1L, 9), 'B', CoreItems2.getRecipe(51, 1)});
        // --- Oxygen Fan
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("GalacticraftCore", "item.airFan", 1L), tBitMask, new Object[]{"SdS", "RIR", "SwS", 'S', OrePrefixes.screw.get(Materials.Steel), 'R', OrePrefixes.rotor.get(Materials.Steel), 'I', OrePrefixes.stickLong.get(Materials.StainlessSteel)});
        // --- Oxygen Concentrator
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("GalacticraftCore", "item.oxygenConcentrator", 1L), tBitMask, new Object[]{"SVS", "SFS", "CPC", 'S', GT_ModHandler.getModItem("GalacticraftCore", "item.basicItem", 1L, 9), 'V', GT_ModHandler.getModItem("GalacticraftCore", "item.airVent", 1L), 'F', GT_ModHandler.getModItem("GalacticraftCore", "item.airFan", 1L), 'C', GT_ModHandler.getModItem("GalacticraftCore", "item.canister", 1L), 'P', ItemList.Electric_Pump_HV});
        // --- Tier 1 Rocket Engine
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("GalacticraftCore", "item.engine", 1L), tBitMask, new Object[]{"PEI", "SFS", "SRS", 'S', GT_ModHandler.getModItem("GalacticraftCore", "item.heavyPlating", 1L), 'F', GT_ModHandler.getModItem("GalacticraftCore", "item.airVent", 1L), 'F', ItemList.Casing_Firebox_Steel, 'E', ItemList.Electric_Piston_HV, 'I', OrePrefixes.pipeTiny.get(Materials.StainlessSteel), 'P', OrePrefixes.plate.get(Materials.StainlessSteel), 'R', OrePrefixes.ring.get(Materials.StainlessSteel)});
        // --- Tier 1 Booster
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("GalacticraftCore", "item.engine", 1L, 1), tBitMask, new Object[]{"PPP", "HCH", "HVH", 'P', GT_ModHandler.getModItem("GalacticraftCore", "item.meteoricIronIngot", 1L, 1), 'H', GT_ModHandler.getModItem("GalacticraftCore", "item.heavyPlating", 1L), 'V', GT_ModHandler.getModItem("GalacticraftCore", "item.airVent", 1L), 'C', ItemList.Large_Fluid_Cell_Steel});
        // --- Nose Cone
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("GalacticraftCore", "item.noseCone", 1L), tBitMask, new Object[]{"dPh", "SES", "PCP", 'P', GT_ModHandler.getModItem("GalacticraftCore", "item.heavyPlating", 1L), 'E', ItemList.Sensor_HV, 'C', OrePrefixes.circuit.get(Materials.Advanced), 'S', OrePrefixes.screw.get(Materials.StainlessSteel)});
        // --- Oil Extractor
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("GalacticraftCore", "item.oilExtractor", 1L), tBitMask, new Object[]{"IdS", "SCP", "BPP", 'P', GT_ModHandler.getModItem("GalacticraftCore", "item.basicItem", 1L, 10), 'C', GT_ModHandler.getModItem("GalacticraftCore", "item.oilCanisterPartial", 1L, 1001), 'B', GT_ModHandler.getModItem("minecraft", "stone_button", 1L), 'S', OrePrefixes.screw.get(Materials.StainlessSteel), 'I', OrePrefixes.pipeTiny.get(Materials.Steel)});
        // --- Buggy Wheel
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("GalacticraftCore", "item.buggymat", 1L), tBitMask, new Object[]{"PRP", "RTR", "PRP", 'P', GT_ModHandler.getModItem("GalacticraftCore", "item.basicItem", 1L, 9), 'T', GT_ModHandler.getModItem("GalacticraftMars", "item.itemBasicAsteroids", 1L, 6), 'R', OrePrefixes.plate.get(Materials.Rubber)});
        // --- Buggy Seat
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("GalacticraftCore", "item.buggymat", 1L, 1), tBitMask, new Object[]{" RP", "RRP", "PPP", 'P', GT_ModHandler.getModItem("GalacticraftCore", "item.basicItem", 1L, 9), 'R', OrePrefixes.plate.get(Materials.Rubber)});
        // --- Buggy Storage Box
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("GalacticraftCore", "item.buggymat", 1L, 2), tBitMask, new Object[]{"PRP", "PCP", "PPP", 'P', GT_ModHandler.getModItem("GalacticraftCore", "item.basicItem", 1L, 9), 'R', GT_ModHandler.getModItem("IC2", "blockRubber", 1L), 'C', GT_ModHandler.getModItem("chestup", "Blockchestup", 1L, 1)});
        // --- Frequency Module
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("GalacticraftCore", "item.basicItem", 1L, 19), tBitMask, new Object[]{"AEA", "WMW", "TBT", 'A', GT_ModHandler.getModItem("GalacticraftCore", "item.basicItem", 1L, 8), 'T', GT_ModHandler.getModItem("GalacticraftCore", "item.basicItem", 1L, 7), 'W', OrePrefixes.circuit.get(Materials.Advanced), 'M', CoreItems2.getRecipe(182, 1), 'E', ItemList.Sensor_HV, 'B', ItemList.Battery_RE_HV_Lithium});
        // --- Walk away
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("GalacticraftMars", "tile.walkway", 1L), tBitMask, new Object[]{"PhP", " B ", "PwP", 'P', OrePrefixes.plate.get(Materials.Desh), 'B', OrePrefixes.frameGt.get(Materials.Desh)});
        // --- Walk away Aluminum
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("GalacticraftMars", "tile.walkwayWire", 1L), tBitMask, new Object[]{"PhP", "WBW", "PwP", 'W', GT_ModHandler.getModItem("GalacticraftCore", "tile.aluminumWire", 1L, 1), 'P', OrePrefixes.plate.get(Materials.Desh), 'B', OrePrefixes.frameGt.get(Materials.Desh)});
        // --- Walk away Oxygen
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("GalacticraftMars", "tile.walkwayOxygenPipe", 1L), tBitMask, new Object[]{"PhP", "WBW", "PwP", 'W', GT_ModHandler.getModItem("GalacticraftCore", "tile.oxygenPipe", 1L), 'P', OrePrefixes.plate.get(Materials.Desh), 'B', OrePrefixes.frameGt.get(Materials.Desh)});
        // --- Standard Wrench
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("GalacticraftCore", "item.standardWrench", 1L), tBitMask, new Object[]{"PsP", "SIS", "dIf", 'P', OrePrefixes.plate.get(Materials.Steel), 'S', OrePrefixes.screw.get(Materials.Steel), 'I', OrePrefixes.stick.get(Materials.Steel)});
        // --- Heavy Rocket Engine (Tier 2)
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("GalacticraftMars", "item.itemBasicAsteroids", 1L, 1), tBitMask, new Object[]{"PIP", "PEP", "BOB", 'P', GT_ModHandler.getModItem("GalacticraftMars", "item.itemBasicAsteroids", 1L), 'B', GT_ModHandler.getModItem("GalacticraftCore", "item.engine", 1L, 1), 'O', GT_ModHandler.getModItem("GalacticraftCore", "item.engine", 1L), 'E', ItemList.Electric_Piston_IV, 'I', OrePrefixes.pipeTiny.get(Materials.TungstenSteel)});
        // --- Heavy Nose Cone
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("GalacticraftMars", "item.heavyNoseCone", 1L), tBitMask, new Object[]{"dNh", "SDS", "DPD", 'D', GT_ModHandler.getModItem("GalacticraftMars", "item.null", 1L, 5), 'P', GT_ModHandler.getModItem("GalacticraftMars", "item.itemBasicAsteroids", 1L), 'N', GT_ModHandler.getModItem("GalacticraftCore", "item.noseCone", 1L), 'S', OrePrefixes.screw.get(Materials.Titanium)});
        // --- Beam Core
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("GalacticraftMars", "item.itemBasicAsteroids", 1L, 8), tBitMask, new Object[]{"RPR", "PLP", "RPR", 'P', GT_ModHandler.getModItem("GalacticraftCore", "item.basicItem", 1L, 11), 'R', OrePrefixes.ring.get(Materials.RedAlloy), 'L', OrePrefixes.lens.get(Materials.Diamond)});
        // --- Energy Beam Reflector
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("GalacticraftMars", "tile.beamReflector", 1L), tBitMask, new Object[]{"RBR", " S ", "PLP", 'B', GT_ModHandler.getModItem("GalacticraftMars", "item.itemBasicAsteroids", 1L, 8), 'R', OrePrefixes.ring.get(Materials.Desh), 'S', OrePrefixes.stick.get(Materials.Desh), 'P', OrePrefixes.plate.get(Materials.Desh), 'L', OrePrefixes.block.get(Materials.Desh)});
        // --- Energy Beam Receiver
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("GalacticraftMars", "tile.beamReceiver", 1L), tBitMask, new Object[]{"RPR", "PBP", "RPR", 'R', GT_ModHandler.getModItem("GalacticraftCore", "item.basicItem", 1L, 7), 'P', OrePrefixes.ring.get(Materials.Desh), 'B', GT_ModHandler.getModItem("GalacticraftMars", "item.itemBasicAsteroids", 1L, 8)});
        // --- Cryogenic Chamber
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("GalacticraftMars", "tile.marsMachine", 1L, 4), tBitMask, new Object[]{"RCR", "PBP", "ROR", 'P', GT_ModHandler.getModItem("GalacticraftMars", "item.null", 1L, 3), 'R', GT_ModHandler.getModItem("GalacticraftMars", "item.itemBasicAsteroids", 1L), 'C', GT_ModHandler.getModItem("GraviSuite", "itemSimpleItem", 1L, 2), 'B', GT_ModHandler.getModItem("CarpentersBlocks", "itemCarpentersBed", 1L), 'O', GT_ModHandler.getModItem("minecraft", "clock", 1L)});
        // --- Terraformer
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("GalacticraftMars", "tile.marsMachine", 1L), tBitMask, new Object[]{"COC", "PGP", "MTI", 'C', GT_ModHandler.getModItem("GalacticraftMars", "item.itemBasicAsteroids", 1L, 6), 'O', GT_ModHandler.getModItem("GalacticraftCore", "item.oxygenConcentrator", 1L), 'T', GT_ItemList.Portable_Tank_HV.get(1L), 'G', ItemList.Casing_Gearbox_Titanium, 'M', ItemList.Electric_Motor_HV, 'I', ItemList.Electric_Pump_HV, 'P', OrePrefixes.plate.get(Materials.Desh)});
        // --- Launch Controller
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("GalacticraftMars", "tile.marsMachine", 1L, 8), tBitMask, new Object[]{"SME", "PHP", "CWC", 'S', ItemList.Sensor_HV, 'E', ItemList.Emitter_HV, 'W', OrePrefixes.circuit.get(Materials.Advanced), 'M', GT_ModHandler.getModItem("GalacticraftCore", "item.basicItem", 1L, 19), 'H', ItemList.Hull_HV, 'P', GT_ModHandler.getModItem("GalacticraftCore", "item.basicItem", 1L, 9), 'C', OrePrefixes.cableGt02.get(Materials.Aluminium)});
        // --- Grapple
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("GalacticraftMars", "item.grapple", 1L), tBitMask, new Object[]{"  B", "WWW", "R  ", 'R', OrePrefixes.ring.get(Materials.MeteoricSteel), 'W', OrePrefixes.wireFine.get(Materials.MeteoricIron), 'B', OrePrefixes.bolt.get(Materials.MeteoricSteel)});
        // --- Parachute
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("GalacticraftCore", "item.parachute", 1L), tBitMask, new Object[]{"CCC", "W W", "WWW", 'C', GT_ModHandler.getModItem("GalacticraftCore", "item.canvas", 1L), 'W', OrePrefixes.wireFine.get(Materials.Steel)});
        // --- Slabs
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("GalacticraftCore", "slabGCHalf", 2L), tBitMask, new Object[]{"sB", 'B', GT_ModHandler.getModItem("GalacticraftCore", "tile.gcBlockCore", 1L, 4)});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("GalacticraftCore", "slabGCHalf", 2L, 1), tBitMask, new Object[]{"sB", 'B', GT_ModHandler.getModItem("GalacticraftCore", "tile.gcBlockCore", 1L, 3)});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("GalacticraftCore", "slabGCHalf", 2L, 2), tBitMask, new Object[]{"sB", 'B', GT_ModHandler.getModItem("GalacticraftCore", "tile.moonBlock", 1L, 4)});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("GalacticraftCore", "slabGCHalf", 2L, 3), tBitMask, new Object[]{"sB", 'B', GT_ModHandler.getModItem("GalacticraftCore", "tile.moonBlock", 1L, 14)});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("GalacticraftCore", "slabGCHalf", 2L, 4), tBitMask, new Object[]{"sB", 'B', GT_ModHandler.getModItem("GalacticraftMars", "tile.mars", 1L, 4)});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("GalacticraftCore", "slabGCHalf", 2L, 5), tBitMask, new Object[]{"sB", 'B', GT_ModHandler.getModItem("GalacticraftMars", "tile.mars", 1L, 7)});
        // --- Battery
        GT_ModHandler.addShapelessCraftingRecipe(GT_ModHandler.getModItem("GalacticraftCore", "item.battery", 1L, 100), tBitMask, new Object[]{ItemList.Battery_Hull_LV});
        // --- Ambient Thermal Controller
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("GalacticraftCore", "item.basicItem", 1L, 20), tBitMask,
                new Object[]{"CVC", "BSB", "AOA", 'B', GT_ModHandler.getModItem("GalacticraftCore", "item.basicItem", 1L, 10),
                        'A', GT_ModHandler.getModItem("GalacticraftCore", "item.basicItem", 1L, 8),
                        'S', GT_ModHandler.getModItem("GalacticraftCore", "item.basicItem", 1L, 9),
                        'V', GT_ModHandler.getModItem("GalacticraftCore", "item.airVent", 1L),
                        'O', GT_ModHandler.getModItem("IC2","itemRecipePart",1, 6),
                        'C', OrePrefixes.circuit.get(Materials.Advanced)});
    }

    private void pulverizer() {
        GT_Values.RA
                .addPulveriserRecipe(GT_ModHandler.getModItem("GalacticraftCore", "tile.fallenMeteor", 1L),
                        new ItemStack[]{
                                GT_ModHandler.getModItem("GalacticraftCore", "item.meteoricIronRaw", 2L)},
                        new int[]{10000}, 300, 2);
    }

    private void printer3d() {
        RA.addPrimitiveLineRecipe(new ItemStack[]{
                CoreItems2.getRecipe(0, 0),
                GT_ModHandler.getModItem("GalacticraftCore", "item.noseCone", 1L, 0),
                GT_ModHandler.getModItem("GalaxySpace", "item.CompressedPlates", 3L, 4),
                GT_ModHandler.getModItem("GalacticraftCore", "item.heavyPlating", 8L, 0),
                GT_ModHandler.getModItem("GalacticraftCore", "item.rocketFins", 4L, 0),
                GT_ModHandler.getModItem("GalaxySpace", "item.Modules", 1L, 3),
                GT_ModHandler.getModItem("GalacticraftCore", "item.engine", 1L, 0)
        }, GT_ModHandler.getModItem("GalacticraftCore", "item.spaceship", 1L, 0), null, 100 * 20, 480);

        RA.addPrimitiveLineRecipe(new ItemStack[]{
                        CoreItems2.getRecipe(1, 0),
                        GT_ModHandler.getModItem("GalacticraftCore", "item.noseCone", 1L, 0),
                        GT_ModHandler.getModItem("GalacticraftCore", "item.heavyPlating", 3L, 0),
                        GT_ModHandler.getModItem("GalacticraftMars", "item.null", 10L, 3),
                        GT_ModHandler.getModItem("GalacticraftCore", "item.rocketFins", 4L, 0),
                        GT_ModHandler.getModItem("GalacticraftCore", "item.engine", 2L, 1),
                        GT_ModHandler.getModItem("GalaxySpace", "item.Modules", 1L, 3),
                        GT_ModHandler.getModItem("GalacticraftCore", "item.engine", 2L, 0)
                }, GT_ModHandler.getModItem("GalacticraftMars", "item.spaceshipTier2", 1L, 0), null, 120 * 20,
                1920);

        RA.addBasicLineRecipe(new ItemStack[]{
                        CoreItems2.getRecipe(2, 0),
                        GT_ModHandler.getModItem("GalacticraftMars", "item.heavyNoseCone", 1L, 0),
                        GT_ModHandler.getModItem("GalacticraftMars", "item.null", 4L, 3),
                        GT_ModHandler.getModItem("GalacticraftMars", "item.itemBasicAsteroids", 12L, 0),
                        GT_ModHandler.getModItem("GalacticraftMars", "item.itemBasicAsteroids", 4L, 2),
                        GT_ModHandler.getModItem("GalacticraftCore", "item.engine", 4L, 1),
                        CoreItems2.getRecipe(133, 2),
                        GT_ModHandler.getModItem("GalacticraftMars", "item.itemBasicAsteroids", 1L, 1)
                }, GT_ModHandler.getModItem("GalacticraftMars", "item.itemTier3Rocket", 1L, 0), null, 140 * 20,
                7680);
    }

    private void fluidCanner() {
        RA.addFluidCannerRecipe(
                GT_ModHandler.getModItem("GalacticraftCore", "item.oxygenTankLightFull", 1L, 1800),
                GT_ModHandler.getModItem("GalacticraftCore", "item.oxygenTankLightFull", 1L, 0),
                Materials.Oxygen.getGas(1800L), GT_Values.NF);
        RA.addFluidCannerRecipe(
                GT_ModHandler.getModItem("GalacticraftCore", "item.oxygenTankMedFull", 1L, 3600),
                GT_ModHandler.getModItem("GalacticraftCore", "item.oxygenTankMedFull", 1L, 0),
                Materials.Oxygen.getGas(3600L), GT_Values.NF);
        RA.addFluidCannerRecipe(
                GT_ModHandler.getModItem("GalacticraftCore", "item.oxygenTankHeavyFull", 1L, 5400),
                GT_ModHandler.getModItem("GalacticraftCore", "item.oxygenTankHeavyFull", 1L, 0),
                Materials.Oxygen.getGas(5400L), GT_Values.NF);
        RA.addFluidCannerRecipe(
                GT_ModHandler.getModItem("GalacticraftCore", "item.oxygenTankt4", 1L, 7200),
                GT_ModHandler.getModItem("GalacticraftCore", "item.oxygenTankt4", 1L, 0),
                Materials.Oxygen.getGas(7200L), GT_Values.NF);
        RA.addFluidCannerRecipe(
                GT_ModHandler.getModItem("GalacticraftCore", "item.oxygenTankt5", 1L, 9000),
                GT_ModHandler.getModItem("GalacticraftCore", "item.oxygenTankt5", 1L, 0),
                Materials.Oxygen.getGas(9000L), GT_Values.NF);
        RA.addFluidCannerRecipe(
                GT_ModHandler.getModItem("GalacticraftCore", "item.fuelCanisterPartial", 1L, 1001),
                GT_ModHandler.getModItem("GalacticraftCore", "item.fuelCanisterPartial", 1L, 1),
                new FluidStack(ItemList.sRocketFuel, 1000), GT_Values.NF);
    }

    private void extruder() {
        RA.addExtruderRecipe(GT_ModHandler.getModItem("IC2", "blockAlloyGlass", 1L, 0),
                ItemList.Shape_Extruder_Pipe_Small.get(0L),
                GT_ModHandler.getModItem("GalacticraftCore", "tile.oxygenPipe", 2L, 0), 200, 120);
        GT_Values.RA
                .addExtruderRecipe(GT_ModHandler.getModItem("GalacticraftCore", "item.basicItem", 2L, 7),
                        ItemList.Shape_Extruder_Cell.get(0L),
                        GT_ModHandler.getModItem("GalacticraftCore", "item.canister", 1L, 0), 600, 30);
        GT_Values.RA
                .addExtruderRecipe(GT_ModHandler.getModItem("GalacticraftCore", "item.basicItem", 2L, 6),
                        ItemList.Shape_Extruder_Cell.get(0L),
                        GT_ModHandler.getModItem("GalacticraftCore", "item.canister", 1L, 1), 600, 30);
        GT_Values.RA
                .addExtruderRecipe(GT_ModHandler.getModItem("GalacticraftCore", "item.basicItem", 2L, 9),
                        ItemList.Shape_Extruder_Bolt.get(0L),
                        GT_ModHandler.getModItem("GalacticraftCore", "item.steelPole", 1L, 0), 600, 30);

    }

    private void extractor() {
        GT_Values.RA
                .addExtractorRecipe(GT_ModHandler.getModItem("GalacticraftMars", "item.thermalPadding", 1L),
                        GT_ModHandler.getModItem("GalacticraftMars", "item.itemBasicAsteroids", 5L, 7), 300, 2);
        RA.addExtractorRecipe(
                GT_ModHandler.getModItem("GalacticraftMars", "item.thermalPadding", 1L, 1),
                GT_ModHandler.getModItem("GalacticraftMars", "item.itemBasicAsteroids", 8L, 7), 300, 2);
        RA.addExtractorRecipe(
                GT_ModHandler.getModItem("GalacticraftMars", "item.thermalPadding", 1L, 2),
                GT_ModHandler.getModItem("GalacticraftMars", "item.itemBasicAsteroids", 7L, 7), 300, 2);
        RA.addExtractorRecipe(
                GT_ModHandler.getModItem("GalacticraftMars", "item.thermalPadding", 1L, 3),
                GT_ModHandler.getModItem("GalacticraftMars", "item.itemBasicAsteroids", 4L, 7), 300, 2);

    }

    private void canner() {
        GT_Values.RA
                .addCannerRecipe(GT_ModHandler.getModItem("GalacticraftCore", "item.canister", 1L, 0),
                        GT_ModHandler.getModItem("minecraft", "apple", 6L, 0),
                        GT_ModHandler.getModItem("GalacticraftCore", "item.basicItem", 1L, 15), null, 800, 1);
        GT_Values.RA
                .addCannerRecipe(GT_ModHandler.getModItem("GalacticraftCore", "item.canister", 1L, 0),
                        GT_ModHandler.getModItem("minecraft", "carrot", 8L, 0),
                        GT_ModHandler.getModItem("GalacticraftCore", "item.basicItem", 1L, 16), null, 800, 1);
        GT_Values.RA
                .addCannerRecipe(GT_ModHandler.getModItem("GalacticraftCore", "item.canister", 1L, 0),
                        GT_ModHandler.getModItem("minecraft", "melon", 8L, 0),
                        GT_ModHandler.getModItem("GalacticraftCore", "item.basicItem", 1L, 17), null, 800, 1);
        GT_Values.RA
                .addCannerRecipe(GT_ModHandler.getModItem("GalacticraftCore", "item.canister", 1L, 0),
                        GT_ModHandler.getModItem("minecraft", "potato", 16L, 0),
                        GT_ModHandler.getModItem("GalacticraftCore", "item.basicItem", 1L, 18), null, 800, 1);

    }

    private void arcFurnace() {
        GT_Values.RA
                .addArcFurnaceRecipe(GT_ModHandler.getModItem("GalacticraftCore", "item.spaceship", 1L, 0),
                        new ItemStack[]{ItemList.Ingot_Heavy1.get(21), CoreItems2.getRecipe(97, 3),
                                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Steel, 12)}, null, 1200, 384);
        RA.addArcFurnaceRecipe(
                GT_ModHandler.getModItem("GalacticraftMars", "item.spaceshipTier2", 1L, 0),
                new ItemStack[]{ItemList.Ingot_Heavy2.get(32), ItemList.Ingot_Heavy1.get(26),
                        GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Steel, 18)}, null, 1400, 1536);
        RA.addArcFurnaceRecipe(
                GT_ModHandler.getModItem("GalacticraftMars", "item.itemTier3Rocket", 1L, 0),
                new ItemStack[]{ItemList.Ingot_Heavy3.get(25), ItemList.Ingot_Heavy2.get(36),
                        GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Titanium, 12)}, null, 1600, 6144);
        // --- Canister
        GT_Values.RA
                .addArcFurnaceRecipe(GT_ModHandler.getModItem("GalacticraftCore", "item.oxygenTankLightFull", 1L, GT_Values.W),
                        new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Aluminium, 21),
                                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Steel, 9)}, null, 600, 64);
        GT_Values.RA
                .addArcFurnaceRecipe(GT_ModHandler.getModItem("GalacticraftCore", "item.oxygenTankMedFull", 1L, GT_Values.W),
                        new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.MeteoricIron, 21),
                                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Aluminium, 9)}, null, 600, 120);
        GT_Values.RA
                .addArcFurnaceRecipe(GT_ModHandler.getModItem("GalacticraftCore", "item.oxygenTankHeavyFull", 1L, GT_Values.W),
                        new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Desh, 21),
                                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.StainlessSteel, 9)}, null, 700, 256);
        GT_Values.RA
                .addArcFurnaceRecipe(GT_ModHandler.getModItem("GalacticraftCore", "item.oxygenTankt4", 1L, GT_Values.W),
                        new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Naquadah, 21),
                                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Titanium, 9)}, null, 800, 480);
        GT_Values.RA
                .addArcFurnaceRecipe(GT_ModHandler.getModItem("GalacticraftCore", "item.oxygenTankt5", 1L, GT_Values.W),
                        new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Trinium, 21),
                                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.TungstenSteel, 9)}, null, 900, 1024);

    }

    private void assembler() {
        GT_Values.RA
                .addAssemblerRecipe(GT_ModHandler.getModItem("GalacticraftCore", "item.spaceship", 1L),
                        GT_ModHandler.getModItem("chestup", "Blockchestup", 1L, 2),
                        GT_ModHandler.getModItem("GalacticraftCore", "item.spaceship", 1L, 3), 200, 64);
        // ---  T2 Rocket + chest
        GT_Values.RA
                .addAssemblerRecipe(GT_ModHandler.getModItem("GalacticraftMars", "item.spaceshipTier2", 1L),
                        GT_ModHandler.getModItem("chestup", "Blockchestup", 1L, 2),
                        GT_ModHandler.getModItem("GalacticraftMars", "item.spaceshipTier2", 1L, 3), 200, 64);
        // ---  T3 Rocket + chest
        RA.addAssemblerRecipe(
                GT_ModHandler.getModItem("GalacticraftMars", "item.itemTier3Rocket", 1L),
                GT_ModHandler.getModItem("chestup", "Blockchestup", 1L, 2),
                GT_ModHandler.getModItem("GalacticraftMars", "item.itemTier3Rocket", 1L, 3), 200, 64);

        // --- Oxygen Mask
        RA.addAssemblerRecipe(GT_ModHandler.getModItem("IC2", "itemArmorHazmatHelmet", 1L),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.ReinforcedGlass, 16),
                Materials.Rubber.getMolten(144),
                GT_ModHandler.getModItem("GalacticraftCore", "item.oxygenMask", 1L), 400, 120);
        // --- Thermal Cloth
        GT_Values.RA
                .addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Aluminium, 4),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Polycaprolactam, 1),
                        Materials.Polytetrafluoroethylene.getMolten(576),
                        GT_ModHandler.getModItem("GalacticraftMars", "item.itemBasicAsteroids", 1L, 7), 100,
                        1920);
        // --- Glowstone Torch
        RA.addAssemblerRecipe(GT_ModHandler.getModItem("minecraft", "redstone_torch", 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Glowstone, 1),
                GT_ModHandler.getModItem("GalacticraftCore", "tile.glowstoneTorch", 1L), 200, 16);
        // --- Canister
        RA.addAssemblerRecipe(
                new ItemStack[]{GT_ModHandler.getModItem("GalacticraftCore", "item.basicItem", 8L, 9),
                        GT_OreDictUnificator.get(OrePrefixes.ring, Materials.Steel, 4),
                        GT_Utility.getIntegratedCircuit(1)}, null,
                GT_ModHandler.getModItem("GalacticraftCore", "item.oilCanisterPartial", 1L, 1001), 200, 64);
        // --- Canister T2
        RA.addAssemblerRecipe(new ItemStack[]{
                        GT_ModHandler.getModItem("GalacticraftMars", "item.itemBasicAsteroids", 8L, 6),
                        GT_OreDictUnificator.get(OrePrefixes.ring, Materials.Titanium, 4),
                        GT_Utility.getIntegratedCircuit(1)}, null,
                GT_ModHandler.getModItem("GalacticraftMars", "item.LOX2", 1L, 8001), 300, 256);
        // --- Canister T3
        RA.addAssemblerRecipe(new ItemStack[]{
                        GT_OreDictUnificator.get(OrePrefixes.plateTriple, Materials.TungstenSteel, 8),
                        GT_OreDictUnificator.get(OrePrefixes.ring, Materials.TungstenSteel, 4),
                        GT_Utility.getIntegratedCircuit(1)}, null,
                GT_ModHandler.getModItem("GalacticraftMars", "item.LOX3", 1L, 32001), 400, 1024);
        // --- Hydrogen Pipe
        GT_Values.RA
                .addAssemblerRecipe(GT_ModHandler.getModItem("GalacticraftCore", "tile.oxygenPipe", 1L),
                        GT_OreDictUnificator.get(OrePrefixes.ring, Materials.Copper, 4),
                        GT_ModHandler.getModItem("GalacticraftMars", "tile.hydrogenPipe", 1L), 400, 16);
        // --- Thermal Padding Helm
        RA.addAssemblerRecipe(
                GT_ModHandler.getModItem("GalacticraftMars", "item.itemBasicAsteroids", 5L, 7),
                GT_Utility.getIntegratedCircuit(5),
                GT_ModHandler.getModItem("GalacticraftMars", "item.thermalPadding", 1L), 750, 1024);
        // --- Thermal Padding Chestpiece
        RA.addAssemblerRecipe(
                GT_ModHandler.getModItem("GalacticraftMars", "item.itemBasicAsteroids", 8L, 7),
                GT_Utility.getIntegratedCircuit(8),
                GT_ModHandler.getModItem("GalacticraftMars", "item.thermalPadding", 1L, 1), 1200, 1024);
        // --- Thermal Padding Leggings
        RA.addAssemblerRecipe(
                GT_ModHandler.getModItem("GalacticraftMars", "item.itemBasicAsteroids", 7L, 7),
                GT_Utility.getIntegratedCircuit(7),
                GT_ModHandler.getModItem("GalacticraftMars", "item.thermalPadding", 1L, 2), 1050, 1024);
        // --- Thermal Padding Boots
        RA.addAssemblerRecipe(
                GT_ModHandler.getModItem("GalacticraftMars", "item.itemBasicAsteroids", 4L, 7),
                GT_Utility.getIntegratedCircuit(4),
                GT_ModHandler.getModItem("GalacticraftMars", "item.thermalPadding", 1L, 3), 600, 1024);
        // --- Arc Lamp
        RA.addAssemblerRecipe(new ItemStack[]{
                        ItemList.Emitter_HV.get(1),
                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Advanced, 1),
                        GT_OreDictUnificator.get(OrePrefixes.lens, Materials.ReinforcedGlass, 1),
                        GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.DarkSteel, 4)}, null,
                GT_ModHandler.getModItem("GalacticraftCore", "tile.arclamp", 4L), 200, 64);
        RA.addAssemblerRecipe(new ItemStack[]{
                        ItemList.Emitter_EV.get(1),
                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Data, 1),
                        GT_OreDictUnificator.get(OrePrefixes.lens, Materials.Diamond, 1),
                        GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Vanadium, 8)}, null,
                GT_ModHandler.getModItem("GalacticraftCore", "tile.arclamp", 16L), 300, 256);
        RA.addAssemblerRecipe(new ItemStack[]{
                        ItemList.Emitter_IV.get(1),
                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Elite, 1),
                        GT_ModHandler.getModItem("GalacticraftCore", "item.sensorLens", 1L),
                        GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Desh, 16)}, null,
                GT_ModHandler.getModItem("GalacticraftCore", "tile.arclamp", 64L), 400, 1024);
    }

    private void cuttingSaw() {
        // --- Slabs
        GT_Values.RA
                .addCutterRecipe(GT_ModHandler.getModItem("GalacticraftCore", "tile.gcBlockCore", 1L, 4),
                        GT_ModHandler.getModItem("GalacticraftCore", "slabGCHalf", 2L, 0), GT_Values.NI, 50, 8);
        GT_Values.RA
                .addCutterRecipe(GT_ModHandler.getModItem("GalacticraftCore", "tile.gcBlockCore", 1L, 3),
                        GT_ModHandler.getModItem("GalacticraftCore", "slabGCHalf", 2L, 1), GT_Values.NI, 50, 8);
        GT_Values.RA
                .addCutterRecipe(GT_ModHandler.getModItem("GalacticraftCore", "tile.moonBlock", 1L, 4),
                        GT_ModHandler.getModItem("GalacticraftCore", "slabGCHalf", 2L, 2), GT_Values.NI, 50, 8);
        GT_Values.RA
                .addCutterRecipe(GT_ModHandler.getModItem("GalacticraftCore", "tile.moonBlock", 1L, 14),
                        GT_ModHandler.getModItem("GalacticraftCore", "slabGCHalf", 2L, 3), GT_Values.NI, 50, 8);
        RA.addCutterRecipe(GT_ModHandler.getModItem("GalacticraftMars", "tile.mars", 1L, 4),
                GT_ModHandler.getModItem("GalacticraftCore", "slabGCHalf", 2L, 4), GT_Values.NI, 50, 8);
        RA.addCutterRecipe(GT_ModHandler.getModItem("GalacticraftMars", "tile.mars", 1L, 7),
                GT_ModHandler.getModItem("GalacticraftCore", "slabGCHalf", 2L, 5), GT_Values.NI, 50, 8);

    }

}
