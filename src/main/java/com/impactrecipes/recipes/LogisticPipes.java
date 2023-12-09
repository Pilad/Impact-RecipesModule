package com.impactrecipes.recipes;

import com.impact.common.item.Core_Items2;
import com.impact.mods.gregtech.GT_ItemList;
import gregtech.api.GregTech_API;
import gregtech.api.enums.*;
import gregtech.api.util.GT_ModHandler;
import gregtech.api.util.GT_OreDictUnificator;
import gregtech.api.util.GT_Utility;
import net.minecraft.item.ItemStack;

import static gregtech.api.enums.GT_Values.RA;
import static gregtech.api.util.GT_ModHandler.removeRecipeByOutput;

public class LogisticPipes implements Runnable {

    public static final Core_Items2 CoreItems2 = Core_Items2.getInstance();
    private static final long tBitMask = GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE;

    private static final String LP = "LogisticsPipes";

    @Override
    public void run() {
        removeLP();
        hand();
        assembler();
        ciruit();
        chemicalBathRecipe();
    }

    private void removeLP() {
        removeRecipeByOutput(GT_ModHandler.getModItem(LP, "logisticsSolidBlock", 1L, 15),
                true, false, false);
        removeRecipeByOutput(GT_ModHandler.getModItem(LP, "logisticsSolidBlock", 1L, 0),
                true, false, false);
        removeRecipeByOutput(GT_ModHandler.getModItem(LP, "logisticsSolidBlock", 1L, 1),
                true, false, false);
        removeRecipeByOutput(GT_ModHandler.getModItem(LP, "logisticsSolidBlock", 1L, 2),
                true, false, false);
        removeRecipeByOutput(GT_ModHandler.getModItem(LP, "logisticsSolidBlock", 1L, 3),
                true, false, false);
        removeRecipeByOutput(GT_ModHandler.getModItem(LP, "logisticsSolidBlock", 1L, 4),
                true, false, false);
        removeRecipeByOutput(GT_ModHandler.getModItem(LP, "logisticsSolidBlock", 1L, 5),
                true, false, false);
        removeRecipeByOutput(GT_ModHandler.getModItem(LP, "logisticsSolidBlock", 1L, 11),
                true, false, false);
        removeRecipeByOutput(GT_ModHandler.getModItem(LP, "logisticsSolidBlock", 1L, 12),
                true, false, false);
        removeRecipeByOutput(
                GT_ModHandler.getModItem(LP, "item.PipeItemsBasicTransport", 1L, 0), true,
                false, false);
        removeRecipeByOutput(
                GT_ModHandler.getModItem(LP, "item.PipeItemsBasicLogistics", 1L, 0), true,
                false, false);
        removeRecipeByOutput(GT_ModHandler.getModItem(LP, "item.PipeFluidBasic", 1L, 0),
                true, false, false);
        removeRecipeByOutput(
                GT_ModHandler.getModItem(LP, "item.PipeBlockRequestTable", 1L, 0), true,
                false, false);
        for (int i = 0; i < 17; i++) {
            removeRecipeByOutput(GT_ModHandler.getModItem(LP, "item.remoteOrdererItem", 1L, i),
                    true, false, false);
        }
        removeRecipeByOutput(GT_ModHandler.getModItem(LP, "item.itemModule", 1L, GT_Values.W),
                true, false, false);
        removeRecipeByOutput(GT_ModHandler.getModItem(LP, "item.itemUpgrade", 1L, GT_Values.W),
                true, false, false);
        removeRecipeByOutput(GT_ModHandler.getModItem(LP, "item.pipeController", 1L, 0),
                true, false, false);
        removeRecipeByOutput(GT_ModHandler.getModItem(LP, "item.PipeItemsRequestLogistics", 1L, 0),
                true, false, false);
        removeRecipeByOutput(GT_ModHandler.getModItem(LP, "item.PipeItemsProviderLogistics", 1L, 0),
                true, false, false);
        removeRecipeByOutput(GT_ModHandler.getModItem(LP, "item.PipeItemsCraftingLogistics", 1L, 0),
                true, false, false);
        removeRecipeByOutput(GT_ModHandler.getModItem(LP, "item.PipeItemsSatelliteLogistics", 1L, 0),
                true, false, false);
        removeRecipeByOutput(GT_ModHandler.getModItem(LP, "item.PipeItemsSupplierLogistics", 1L, 0),
                true, false, false);
        removeRecipeByOutput(GT_ModHandler.getModItem(LP, "item.PipeLogisticsChassiMk1", 1L, 0),
                true, false, false);
        removeRecipeByOutput(GT_ModHandler.getModItem(LP, "item.PipeLogisticsChassiMk2", 1L, 0),
                true, false, false);
        removeRecipeByOutput(GT_ModHandler.getModItem(LP, "item.PipeLogisticsChassiMk3", 1L, 0),
                true, false, false);
        removeRecipeByOutput(GT_ModHandler.getModItem(LP, "item.PipeLogisticsChassiMk4", 1L, 0),
                true, false, false);
        removeRecipeByOutput(GT_ModHandler.getModItem(LP, "item.PipeLogisticsChassiMk5", 1L, 0),
                true, false, false);
        removeRecipeByOutput(GT_ModHandler.getModItem(LP, "item.PipeItemsCraftingLogisticsMk2", 1L, 0),
                true, false, false);
        removeRecipeByOutput(GT_ModHandler.getModItem(LP, "item.PipeItemsRequestLogisticsMk2", 1L, 0),
                true, false, false);
        removeRecipeByOutput(GT_ModHandler.getModItem(LP, "item.PipeItemsRemoteOrdererLogistics", 1L, 0),
                true, false, false);
        removeRecipeByOutput(GT_ModHandler.getModItem(LP, "item.PipeItemsProviderLogisticsMk2", 1L, 0),
                true, false, false);
        removeRecipeByOutput(GT_ModHandler.getModItem(LP, "item.PipeItemsApiaristAnalyser", 1L, 0),
                true, false, false);
        removeRecipeByOutput(GT_ModHandler.getModItem(LP, "item.PipeItemsApiaristSink", 1L, 0),
                true, false, false);
        removeRecipeByOutput(GT_ModHandler.getModItem(LP, "item.PipeItemsInvSysConnector", 1L, 0),
                true, false, false);
        removeRecipeByOutput(GT_ModHandler.getModItem(LP, "item.PipeItemsSystemEntranceLogistics", 1L, 0),
                true, false, false);
        removeRecipeByOutput(GT_ModHandler.getModItem(LP, "item.PipeItemsSystemDestinationLogistics", 1L, 0),
                true, false, false);
        removeRecipeByOutput(GT_ModHandler.getModItem(LP, "item.PipeItemsCraftingLogisticsMk3", 1L, 0),
                true, false, false);
        removeRecipeByOutput(GT_ModHandler.getModItem(LP, "item.PipeItemsFirewall", 1L, 0),
                true, false, false);
        removeRecipeByOutput(GT_ModHandler.getModItem(LP, "item.PipeItemsFluidSupplier", 1L, 0),
                true, false, false);
        removeRecipeByOutput(GT_ModHandler.getModItem(LP, "item.PipeFluidBasic", 1L, 0),
                true, false, false);
        removeRecipeByOutput(GT_ModHandler.getModItem(LP, "item.PipeFluidInsertion", 1L, 0),
                true, false, false);
        removeRecipeByOutput(GT_ModHandler.getModItem(LP, "item.PipeFluidProvider", 1L, 0),
                true, false, false);
        removeRecipeByOutput(GT_ModHandler.getModItem(LP, "item.PipeFluidRequestLogistics", 1L, 0),
                true, false, false);
        removeRecipeByOutput(GT_ModHandler.getModItem(LP, "item.PipeFluidExtractor", 1L, 0),
                true, false, false);
        removeRecipeByOutput(GT_ModHandler.getModItem(LP, "item.PipeFluidSatellite", 1L, 0),
                true, false, false);
        removeRecipeByOutput(GT_ModHandler.getModItem(LP, "item.PipeFluidSupplierMk2", 1L, 0),
                true, false, false);
        removeRecipeByOutput(GT_ModHandler.getModItem(LP, "item.ItemPipeSignCreator", 1L, 0),
                true, false, false);
        removeRecipeByOutput(GT_ModHandler.getModItem(LP, "item.itemDisk", 1L, 0),
                true, false, false);

    }

    private void hand() {
        // --- Logistics Power Junction
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem(LP, "logisticsSolidBlock", 1L, 1), tBitMask, new Object[]{"GMG", "ECE", "IWI", 'G', OrePrefixes.gearGt.get(Materials.Steel), 'I', OrePrefixes.circuit.get(Materials.Good), 'W', OrePrefixes.cableGt01.get(Materials.Copper), 'E', ItemList.Electric_Motor_MV, 'M', ItemList.Cover_Screen, 'C', ItemList.MACHINE_HULLS[2]});
        // --- Logistics Secгrity Junction
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem(LP, "logisticsSolidBlock", 1L, 2), tBitMask, new Object[]{"RMR", "ICI", "SGS", 'G', OrePrefixes.gearGt.get(Materials.Steel), 'I', OrePrefixes.circuit.get(Materials.Good), 'R', OrePrefixes.plate.get(Materials.RedAlloy), 'S', OrePrefixes.plate.get(Materials.Steel), 'M', ItemList.Cover_Screen, 'C', ItemList.MACHINE_HULLS[2]});
        // --- Logistics Crafting Table
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem(LP, "logisticsSolidBlock", 1L, 3), tBitMask, new Object[]{"RMR", "OCB", "IGI", 'G', OrePrefixes.gearGt.get(Materials.Steel), 'I', OrePrefixes.circuit.get(Materials.Good), 'R', OrePrefixes.plate.get(Materials.Steel), 'M', ItemList.Cover_Crafting, 'O', ItemList.Conveyor_Module_MV, 'B', ItemList.Robot_Arm_MV, 'C', ItemList.MACHINE_HULLS[2]});
        // --- Logistics Fuzzy Crafting Table
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem(LP, "logisticsSolidBlock", 1L, 4), tBitMask, new Object[]{"RMR", "OCB", "IGI", 'G', OrePrefixes.gearGt.get(Materials.Steel), 'I', OrePrefixes.circuit.get(Materials.Good), 'R', OrePrefixes.plate.get(Materials.Lapis), 'M', ItemList.Cover_Crafting, 'O', ItemList.Conveyor_Module_MV, 'B', ItemList.Robot_Arm_MV, 'C', ItemList.MACHINE_HULLS[2]});
        // --- Logistics Statistics Table
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem(LP, "logisticsSolidBlock", 1L, 5), tBitMask, new Object[]{"RMR", "SCE", "IGI", 'G', OrePrefixes.gearGt.get(Materials.Steel), 'I', OrePrefixes.circuit.get(Materials.Good), 'R', OrePrefixes.plate.get(Materials.Steel), 'M', ItemList.Cover_Screen, 'S', ItemList.Sensor_MV, 'E', ItemList.Emitter_MV, 'C', ItemList.MACHINE_HULLS[2]});
        // --- Logistics EU Power Provider
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem(LP, "logisticsSolidBlock", 1L, 12), tBitMask, new Object[]{"IMI", "LCL", "IBI", 'I', OrePrefixes.circuit.get(Materials.Good), 'M', ItemList.Cover_Screen, 'L', ItemList.MV_Coil, 'B', ItemList.Battery_RE_MV_Lithium, 'C', ItemList.MACHINE_HULLS[2]});
        // --- Unrouted Transport Pipe
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem(LP, "item.PipeItemsBasicTransport", 8L, 0), tBitMask, new Object[]{"SfS", "SGS", "SsS", 'S', OrePrefixes.stick.get(Materials.Birmabright), 'G', GT_ModHandler.getModItem("minecraft", "glass_pane", 1L)});
        // --- Logistics Request Table
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem(LP, "item.PipeBlockRequestTable", 1L, 0), tBitMask, new Object[]{"IMI", "RCR", "IOI", 'I', OrePrefixes.circuit.get(Materials.Good), 'M', GT_ModHandler.getModItem("EnderIO", "blockInventoryPanel", 1L), 'R', ItemList.Robot_Arm_MV, 'O', ItemList.Conveyor_Module_MV, 'C', GT_ModHandler.getModItem(LP, "logisticsSolidBlock", 1L, 3)});
        // --- Logistics HUD Glasses
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem(LP, "item.logisticsHUDGlasses", 1L, 0), tBitMask, new Object[]{"ISI", "RTR", "GdG", 'S', OrePrefixes.screw.get(Materials.Aluminium), 'R', OrePrefixes.ring.get(Materials.Aluminium), 'I', GT_ModHandler.getModItem(LP, "item.logisticsParts", 1L), 'T', GT_ModHandler.getModItem(LP, "item.logisticsParts", 1L, 2), 'G', GT_ModHandler.getModItem(LP, "item.logisticsParts", 1L, 1)});
        // --- Logistics HUD Glass
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem(LP, "item.logisticsParts", 1L, 1), tBitMask, new Object[]{"SRS", "dLh", 'S', OrePrefixes.screw.get(Materials.Aluminium), 'R', OrePrefixes.ring.get(Materials.Aluminium), 'L', GT_OreDictUnificator.get(OrePrefixes.lens, Materials.ReinforcedGlass, 1)});
        // --- Logistics HUD Bow
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem(LP, "item.logisticsParts", 2L, 0), tBitMask, new Object[]{"SSB", "  f", 'S', OrePrefixes.stick.get(Materials.Aluminium), 'B', OrePrefixes.bolt.get(Materials.Aluminium)});
        // --- Logistics HUD Nose Bridge
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem(LP, "item.logisticsParts", 1L, 2), tBitMask, new Object[]{" P ", "BhB", 'P', OrePrefixes.plate.get(Materials.Aluminium), 'B', OrePrefixes.bolt.get(Materials.Aluminium)});
        // --- Logistics Pipe Controller
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem(LP, "item.pipeController", 1L, 0), tBitMask, new Object[]{"  S", "CMC", "PWP", 'P', OrePrefixes.plate.get(Materials.Steel), 'C', OrePrefixes.circuit.get(Materials.Basic), 'W', OrePrefixes.cableGt01.get(Materials.Tin), 'S', ItemList.Sensor_LV, 'M', ItemList.Cover_Screen});
        // --- Remote Orderer
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem(LP, "item.remoteOrdererItem", 1L, 0), tBitMask, new Object[]{"  S", "CMC", "PWP", 'P', OrePrefixes.plate.get(Materials.Aluminium), 'C', OrePrefixes.circuit.get(Materials.Good), 'W', OrePrefixes.cableGt01.get(Materials.Copper), 'S', ItemList.Sensor_MV, 'M', GT_ModHandler.getModItem("EnderIO", "blockInventoryPanel", 1L)});
        // --- ItemSink Module
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem(LP, "item.itemModule", 1L, 1), tBitMask, new Object[]{" C ", "BMB", "FIF", 'C', GT_ItemList.RedstoneIronChipset, 'B', OrePrefixes.bolt.get(Materials.RedAlloy), 'F', OrePrefixes.foil.get(Materials.Copper), 'I', OrePrefixes.circuit.get(Materials.Basic), 'M', GT_ModHandler.getModItem(LP, "item.itemModule", 1L)});
        // --- Passive Supplier Module
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem(LP, "item.itemModule", 1L, 2), tBitMask, new Object[]{" C ", "BMB", "FIF", 'C', GT_ItemList.RedstoneIronChipset, 'B', OrePrefixes.bolt.get(Materials.RedAlloy), 'F', OrePrefixes.foil.get(Materials.Gold), 'I', OrePrefixes.circuit.get(Materials.Basic), 'M', GT_ModHandler.getModItem(LP, "item.itemModule", 1L)});
        // --- Extractor Module
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem(LP, "item.itemModule", 1L, 3), tBitMask, new Object[]{" C ", "BMB", "FIF", 'C', GT_ItemList.RedstoneIronChipset, 'B', OrePrefixes.bolt.get(Materials.RedAlloy), 'F', OrePrefixes.foil.get(Materials.Electrum), 'I', OrePrefixes.circuit.get(Materials.Basic), 'M', GT_ModHandler.getModItem(LP, "item.itemModule", 1L)});
        // --- Polymorphic ItemSink Module
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem(LP, "item.itemModule", 1L, 4), tBitMask, new Object[]{" C ", "BMB", "FIF", 'C', GT_ItemList.RedstoneRedChipset, 'B', OrePrefixes.bolt.get(Materials.Gold), 'F', OrePrefixes.foil.get(Materials.Copper), 'I', OrePrefixes.circuit.get(Materials.Basic), 'M', GT_ModHandler.getModItem(LP, "item.itemModule", 1L, 1)});
        // --- QuickSort Module
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem(LP, "item.itemModule", 1L, 5), tBitMask, new Object[]{" C ", "BMB", "FIF", 'C', GT_ItemList.RedstoneGoldChipset, 'B', OrePrefixes.bolt.get(Materials.Silver), 'F', OrePrefixes.foil.get(Materials.Gold), 'I', OrePrefixes.circuit.get(Materials.Basic), 'M', GT_ModHandler.getModItem(LP, "item.itemModule", 1L)});
        // --- Terminus Module
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem(LP, "item.itemModule", 1L, 6), tBitMask, new Object[]{" C ", "BMB", "FIF", 'C', GT_ItemList.RedstoneRedChipset, 'B', OrePrefixes.bolt.get(Materials.RedAlloy), 'F', OrePrefixes.foil.get(Materials.Iron), 'I', OrePrefixes.circuit.get(Materials.Basic), 'M', GT_ModHandler.getModItem(LP, "item.itemModule", 1L)});
        // --- Extractor Module MK2
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem(LP, "item.itemModule", 1L, 103), tBitMask, new Object[]{" C ", "BMB", "FIF", 'C', GT_ItemList.RedstoneGoldChipset, 'B', OrePrefixes.bolt.get(Materials.RedAlloy), 'F', OrePrefixes.foil.get(Materials.Electrum), 'I', OrePrefixes.circuit.get(Materials.Good), 'M', GT_ModHandler.getModItem(LP, "item.itemModule", 1L, 3)});
        // --- Extractor Module MK3
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem(LP, "item.itemModule", 1L, 203), tBitMask, new Object[]{" C ", "BMB", "FIF", 'C', GT_ItemList.RedstoneDiamondChipset, 'B', OrePrefixes.bolt.get(Materials.RedAlloy), 'F', OrePrefixes.foil.get(Materials.Birmabright), 'I', OrePrefixes.circuit.get(Materials.Advanced), 'M', GT_ModHandler.getModItem(LP, "item.itemModule", 1L, 103)});
        // --- Provider Module
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem(LP, "item.itemModule", 1L, 500), tBitMask, new Object[]{" C ", "BMB", "FIF", 'C', GT_ItemList.RedstoneGoldChipset, 'B', OrePrefixes.bolt.get(Materials.RedAlloy), 'F', OrePrefixes.foil.get(Materials.Silver), 'I', OrePrefixes.circuit.get(Materials.Basic), 'M', GT_ModHandler.getModItem(LP, "item.itemModule", 1L)});
        // --- Provider Module MK2
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem(LP, "item.itemModule", 1L, 501), tBitMask, new Object[]{" C ", "BMB", "FIF", 'C', GT_ItemList.RedstoneGoldChipset, 'B', OrePrefixes.bolt.get(Materials.RedAlloy), 'F', OrePrefixes.foil.get(Materials.Silver), 'I', OrePrefixes.circuit.get(Materials.Good), 'M', GT_ModHandler.getModItem(LP, "item.itemModule", 1L, 500)});
        // --- Electric Manager Module
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem(LP, "item.itemModule", 1L, 300), tBitMask, new Object[]{"WCA", "BMB", "FIF", 'C', GT_ItemList.RedstoneIronChipset, 'B', OrePrefixes.bolt.get(Materials.Electrum), 'F', OrePrefixes.foil.get(Materials.Silver), 'I', OrePrefixes.circuit.get(Materials.Good), 'M', GT_ModHandler.getModItem(LP, "item.itemModule", 1L), 'W', OrePrefixes.wireGt02.get(Materials.Copper), 'A', ItemList.Battery_RE_LV_Lithium});
        // --- Electric Buffer Module
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem(LP, "item.itemModule", 1L, 301), tBitMask, new Object[]{"ACA", "BMB", "FIF", 'C', GT_ItemList.RedstoneIronChipset, 'B', OrePrefixes.bolt.get(Materials.Electrum), 'F', OrePrefixes.foil.get(Materials.Silver), 'I', OrePrefixes.circuit.get(Materials.Good), 'M', GT_ModHandler.getModItem(LP, "item.itemModule", 1L), 'A', ItemList.Battery_RE_MV_Lithium});
        // --- Mod Based ItemSink Module
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem(LP, "item.itemModule", 1L, 12), tBitMask, new Object[]{" C ", "BMB", "FIF", 'C', GT_ItemList.RedstoneGoldChipset, 'B', OrePrefixes.bolt.get(Materials.Electrum), 'F', OrePrefixes.foil.get(Materials.Steel), 'I', OrePrefixes.circuit.get(Materials.Basic), 'M', GT_ModHandler.getModItem(LP, "item.itemModule", 1L, 1)});
        // --- OreDict ItemSink Module
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem(LP, "item.itemModule", 1L, 13), tBitMask, new Object[]{" C ", "BMB", "FIF", 'C', GT_ItemList.RedstoneGoldChipset, 'B', OrePrefixes.bolt.get(Materials.Gold), 'F', OrePrefixes.foil.get(Materials.AnnealedCopper), 'I', OrePrefixes.circuit.get(Materials.Basic), 'M', GT_ModHandler.getModItem(LP, "item.itemModule", 1L, 12)});
        // --- Crafting Module
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem(LP, "item.itemModule", 1L, 600), tBitMask, new Object[]{" C ", "BMB", "FIF", 'C', GT_ItemList.RedstoneIronChipset, 'B', OrePrefixes.bolt.get(Materials.Iron), 'F', OrePrefixes.foil.get(Materials.Gold), 'I', OrePrefixes.circuit.get(Materials.Basic), 'M', GT_ModHandler.getModItem(LP, "item.itemModule", 1L)});
        // --- Crafting Module MK2
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem(LP, "item.itemModule", 1L, 601), tBitMask, new Object[]{" C ", "BMB", "FIF", 'C', GT_ItemList.RedstoneGoldChipset, 'B', OrePrefixes.bolt.get(Materials.Steel), 'F', OrePrefixes.foil.get(Materials.Gold), 'I', OrePrefixes.circuit.get(Materials.Good), 'M', GT_ModHandler.getModItem(LP, "item.itemModule", 1L, 600)});
        // --- Crafting Module MK3
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem(LP, "item.itemModule", 1L, 602), tBitMask, new Object[]{" C ", "BMB", "FIF", 'C', GT_ItemList.RedstoneDiamondChipset, 'B', OrePrefixes.bolt.get(Materials.Aluminium), 'F', OrePrefixes.foil.get(Materials.Gold), 'I', OrePrefixes.circuit.get(Materials.Advanced), 'M', GT_ModHandler.getModItem(LP, "item.itemModule", 1L, 601)});
        // --- Active Supplier Module
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem(LP, "item.itemModule", 1L, 502), tBitMask, new Object[]{" C ", "BMB", "FIF", 'C', GT_ItemList.RedstoneRedChipset, 'B', OrePrefixes.bolt.get(Materials.RedAlloy), 'F', OrePrefixes.foil.get(Materials.Gold), 'I', OrePrefixes.circuit.get(Materials.Basic), 'M', GT_ModHandler.getModItem(LP, "item.itemModule", 1L)});
        // --- Logistics Item Card
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem(LP, "item.logisticsItemCard", 1L), tBitMask, new Object[]{" C ", "BMB", "FIF", 'C', GT_ModHandler.getModItem("ExtraUtilities", "chestMini", 1L), 'B', OrePrefixes.bolt.get(Materials.RedAlloy), 'F', OrePrefixes.foil.get(Materials.Gold), 'I', OrePrefixes.circuit.get(Materials.Basic), 'M', GT_ModHandler.getModItem(LP, "item.itemModule", 1L)});
        // --- Logistics Disc
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem(LP, "item.itemDisk", 1L), tBitMask, new Object[]{"PPP", "PDP", "PCP", 'P', OrePrefixes.plate.get(Materials.Carbon), 'C', OrePrefixes.circuit.get(Materials.Basic), 'D', GT_ModHandler.getModItem("OpenComputers", "item", 1L, 19)});

    }

    private void assembler() {
        // --- Unrouted Transport Pipe
        RA.addAssemblerRecipe(new ItemStack[]{
                GT_ModHandler.getModItem("minecraft", "glass_pane", 1L),
                GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Birmabright, 6L),
                GT_Utility.getIntegratedCircuit(8)}, null,
                GT_ModHandler.getModItem(LP, "item.PipeItemsBasicTransport", 8L, 0), 100, 30);
        RA.addAssemblerRecipe(new ItemStack[]{
                GT_ModHandler.getModItem("minecraft", "glass_pane", 1L),
                GT_OreDictUnificator.get(OrePrefixes.stick, Materials.StainlessSteel, 6L),
                GT_Utility.getIntegratedCircuit(8)}, null,
                GT_ModHandler.getModItem(LP, "item.PipeItemsBasicTransport", 16L, 0), 120, 48);
        // --- Basic Logistics Pipe
        RA.addAssemblerRecipe(new ItemStack[]{
                GT_ModHandler.getModItem(LP, "item.PipeItemsBasicTransport", 1L, 0),
                GT_OreDictUnificator.get(OrePrefixes.pipeMedium, Materials.Electrum, 1L),
                GT_Utility.getIntegratedCircuit(1)}, null,
                GT_ModHandler.getModItem(LP, "item.PipeItemsBasicLogistics", 1L, 0), 100, 120);
        RA.addAssemblerRecipe(new ItemStack[]{
                GT_ModHandler.getModItem(LP, "item.PipeItemsBasicTransport", 4L, 0),
                GT_OreDictUnificator.get(OrePrefixes.pipeMedium, Materials.Aluminium, 1L),
                GT_Utility.getIntegratedCircuit(1)}, null,
                GT_ModHandler.getModItem(LP, "item.PipeItemsBasicLogistics", 4L, 0), 120, 120);
        RA.addAssemblerRecipe(new ItemStack[]{
                GT_ModHandler.getModItem(LP, "item.PipeItemsBasicTransport", 16L, 0),
                GT_OreDictUnificator.get(OrePrefixes.pipeMedium, Materials.PolyvinylChloride, 1L),
                GT_Utility.getIntegratedCircuit(1)}, null,
                GT_ModHandler.getModItem(LP, "item.PipeItemsBasicLogistics", 16L, 0), 140, 120);
        RA.addAssemblerRecipe(new ItemStack[]{
                GT_ModHandler.getModItem(LP, "item.PipeItemsBasicTransport", 64L, 0),
                GT_OreDictUnificator.get(OrePrefixes.pipeMedium, Materials.Platinum, 1L),
                GT_Utility.getIntegratedCircuit(1)}, null,
                GT_ModHandler.getModItem(LP, "item.PipeItemsBasicLogistics", 64L, 0), 160, 120);
        // --- Logistics Chassis Mk1
        RA.addAssemblerRecipe(new ItemStack[]{
                        GT_ModHandler.getModItem(LP, "item.PipeItemsBasicLogistics", 4L, 0),
                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Basic, 1L),
                        GT_ModHandler.getModItem("minecraft", "chest", 1L, 0),
                        GT_Utility.getIntegratedCircuit(1)}, Materials.Redstone.getMolten(288),
                GT_ModHandler.getModItem(LP, "item.PipeLogisticsChassiMk1", 4L, 0), 200, 30);
        // --- Logistics Chassis Mk2
        RA.addAssemblerRecipe(new ItemStack[]{
                        GT_ModHandler.getModItem(LP, "item.PipeLogisticsChassiMk1", 4L, 0),
                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Basic, 2L),
                        GT_ModHandler.getModItem("ExtraUtilities", "chestFull", 1L, 0),
                        GT_Utility.getIntegratedCircuit(1)}, Materials.RedAlloy.getMolten(288),
                GT_ModHandler.getModItem(LP, "item.PipeLogisticsChassiMk2", 4L, 0), 200, 30);
        // --- Logistics Chassis Mk3
        RA.addAssemblerRecipe(new ItemStack[]{
                        GT_ModHandler.getModItem(LP, "item.PipeLogisticsChassiMk2", 4L, 0),
                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Good, 1L),
                        GT_ModHandler.getModItem("chestup", "Blockchestup", 1L, 0),
                        GT_Utility.getIntegratedCircuit(1)}, Materials.Electrum.getMolten(288),
                GT_ModHandler.getModItem(LP, "item.PipeLogisticsChassiMk3", 4L, 0), 200, 48);
        // --- Logistics Chassis Mk4
        RA.addAssemblerRecipe(new ItemStack[]{
                        GT_ModHandler.getModItem(LP, "item.PipeLogisticsChassiMk3", 4L, 0),
                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Good, 2L),
                        GT_ModHandler.getModItem("chestup", "Blockchestup", 1L, 1),
                        GT_Utility.getIntegratedCircuit(1)}, Materials.Electrum.getMolten(576),
                GT_ModHandler.getModItem(LP, "item.PipeLogisticsChassiMk4", 4L, 0), 200, 86);
        // --- Logistics Chassis Mk5
        RA.addAssemblerRecipe(new ItemStack[]{
                        GT_ModHandler.getModItem(LP, "item.PipeLogisticsChassiMk4", 4L, 0),
                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Advanced, 1L),
                        GT_ModHandler.getModItem("chestup", "Blockchestup", 1L, 2),
                        GT_Utility.getIntegratedCircuit(1)}, Materials.EnergeticAlloy.getMolten(576),
                GT_ModHandler.getModItem(LP, "item.PipeLogisticsChassiMk5", 4L, 0), 200, 120);
        // --- Crafting Logistics Pipe
        RA.addAssemblerRecipe(new ItemStack[]{
                        GT_ModHandler.getModItem(LP, "item.PipeLogisticsChassiMk1", 4L, 0),
                        ItemList.Cover_Crafting.get(1),
                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Basic, 1L),
                        GT_Utility.getIntegratedCircuit(1)}, null,
                GT_ModHandler.getModItem(LP, "item.PipeItemsCraftingLogistics", 4L, 0),
                100, 120);
        // --- Crafting Logistics Pipe Mk2
        RA.addAssemblerRecipe(new ItemStack[]{
                        GT_ModHandler.getModItem(LP, "item.PipeLogisticsChassiMk2", 4L, 0),
                        ItemList.Cover_Crafting.get(1),
                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Good, 1L),
                        GT_Utility.getIntegratedCircuit(1)}, null,
                GT_ModHandler.getModItem(LP, "item.PipeItemsCraftingLogisticsMk2", 4L, 0),
                120, 120);
        // --- Crafting Logistics Pipe Mk3
        RA.addAssemblerRecipe(new ItemStack[]{
                        GT_ModHandler.getModItem(LP, "item.PipeLogisticsChassiMk3", 4L, 0),
                        ItemList.Cover_Crafting.get(1),
                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Advanced, 1L),
                        GT_Utility.getIntegratedCircuit(1)}, null,
                GT_ModHandler.getModItem(LP, "item.PipeItemsCraftingLogisticsMk3", 4L, 0),
                140, 120);
        // --- Provider Logistics Pipe
        RA.addAssemblerRecipe(new ItemStack[]{
                        GT_ModHandler.getModItem(LP, "item.PipeLogisticsChassiMk1", 4L, 0),
                        ItemList.Conveyor_Module_LV.get(1), GT_Utility.getIntegratedCircuit(1)}, null,
                GT_ModHandler.getModItem(LP, "item.PipeItemsProviderLogistics", 4L, 0), 100,
                120);
        // --- Provider Logistics Pipe Mk2
        RA.addAssemblerRecipe(new ItemStack[]{
                        GT_ModHandler.getModItem(LP, "item.PipeLogisticsChassiMk2", 4L, 0),
                        ItemList.Conveyor_Module_MV.get(1), GT_Utility.getIntegratedCircuit(1)}, null,
                GT_ModHandler.getModItem(LP, "item.PipeItemsProviderLogisticsMk2", 4L, 0),
                120, 120);
        // --- Supplier Logistics Pipe
        RA.addAssemblerRecipe(new ItemStack[]{
                        GT_ModHandler.getModItem(LP, "item.PipeLogisticsChassiMk1", 4L, 0),
                        ItemList.Conveyor_Module_MV.get(1),
                        GT_OreDictUnificator.get(OrePrefixes.gearGtSmall, Materials.Electrum, 2L),
                        GT_Utility.getIntegratedCircuit(2)}, null,
                GT_ModHandler.getModItem(LP, "item.PipeItemsSupplierLogistics", 4L, 0), 100,
                120);
        // --- Request Logistics Pipe
        RA.addAssemblerRecipe(new ItemStack[]{
                        GT_ModHandler.getModItem(LP, "item.PipeLogisticsChassiMk1", 4L, 0),
                        ItemList.Robot_Arm_LV.get(1), ItemList.Cover_Screen.get(1),
                        GT_Utility.getIntegratedCircuit(1)}, null,
                GT_ModHandler.getModItem(LP, "item.PipeItemsRequestLogistics", 4L, 0), 100,
                120);
        // --- Request Logistics Pipe Mk2
        RA.addAssemblerRecipe(new ItemStack[]{
                        GT_ModHandler.getModItem(LP, "item.PipeLogisticsChassiMk2", 4L, 0),
                        ItemList.Robot_Arm_MV.get(1), ItemList.Cover_Screen.get(1),
                        GT_Utility.getIntegratedCircuit(1)}, null,
                GT_ModHandler.getModItem(LP, "item.PipeItemsRequestLogisticsMk2", 4L, 0), 100,
                120);
        // --- Logistics Inventory System Connector
        RA.addAssemblerRecipe(new ItemStack[]{
                        GT_ModHandler.getModItem(LP, "item.PipeLogisticsChassiMk1", 4L, 0),
                        ItemList.Electric_Motor_LV.get(1),
                        GT_OreDictUnificator.get(OrePrefixes.gear, Materials.Steel, 2L),
                        GT_Utility.getIntegratedCircuit(1)}, null,
                GT_ModHandler.getModItem(LP, "item.PipeItemsInvSysConnector", 4L, 0), 100,
                120);
        // --- Logistics Firewall Pipe
        RA.addAssemblerRecipe(new ItemStack[]{
                        GT_ModHandler.getModItem(LP, "item.PipeLogisticsChassiMk1", 4L, 0),
                        ItemList.Electric_Motor_MV.get(1),
                        GT_OreDictUnificator.get(OrePrefixes.gearGtSmall, Materials.Aluminium, 2L),
                        GT_Utility.getIntegratedCircuit(1)}, null,
                GT_ModHandler.getModItem(LP, "item.PipeItemsFirewall", 4L, 0), 120, 120);
        // --- Logistics System Entrance Pipe
        RA.addAssemblerRecipe(new ItemStack[]{
                        GT_ModHandler.getModItem(LP, "item.PipeLogisticsChassiMk2", 4L, 0),
                        ItemList.Electric_Piston_MV.get(1), GT_Utility.getIntegratedCircuit(1)},
                Materials.Electrum.getMolten(288),
                GT_ModHandler.getModItem(LP, "item.PipeItemsSystemEntranceLogistics", 4L, 0),
                120, 120);
        // --- Logistics System Destination Pipe
        RA.addAssemblerRecipe(new ItemStack[]{
                        GT_ModHandler.getModItem(LP, "item.PipeLogisticsChassiMk2", 4L, 0),
                        ItemList.Electric_Piston_MV.get(1), GT_Utility.getIntegratedCircuit(2)},
                Materials.RedAlloy.getMolten(288), GT_ModHandler
                        .getModItem(LP, "item.PipeItemsSystemDestinationLogistics", 4L, 0), 120,
                120);
        // --- Satellite Logistics Pipe
        RA.addAssemblerRecipe(new ItemStack[]{
                        GT_ModHandler.getModItem(LP, "item.PipeItemsCraftingLogistics", 4L, 0),
                        ItemList.Electric_Piston_MV.get(1), GT_Utility.getIntegratedCircuit(1)}, null,
                GT_ModHandler.getModItem(LP, "item.PipeItemsSatelliteLogistics", 4L, 0), 100,
                120);
        // --- Remote Ordered Logistics Pipe
        RA.addAssemblerRecipe(new ItemStack[]{
                        GT_ModHandler.getModItem(LP, "item.PipeItemsSystemEntranceLogistics", 4L, 0),
                        ItemList.Conveyor_Module_MV.get(1), GT_Utility.getIntegratedCircuit(1)}, null,
                GT_ModHandler.getModItem(LP, "item.PipeItemsRemoteOrdererLogistics", 4L, 0),
                120, 120);
        // --- Blank Module
        RA.addAssemblerRecipe(
                new ItemStack[]{ItemList.Circuit_Board_Coated.get(1),
                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Basic, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.Gold, 4L)}, null,
                GT_ModHandler.getModItem(LP, "item.itemModule", 4L, 0), 80, 10);
        RA.addAssemblerRecipe(
                new ItemStack[]{ItemList.Circuit_Board_Phenolic.get(1),
                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Good, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.Electrum, 4L)}, null,
                GT_ModHandler.getModItem(LP, "item.itemModule", 16L, 0), 100, 20);
        RA.addAssemblerRecipe(
                new ItemStack[]{ItemList.Circuit_Board_Plastic.get(1),
                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Advanced, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.EnergeticAlloy, 4L)}, null,
                GT_ModHandler.getModItem(LP, "item.itemModule", 64L, 0), 120, 30);
        // --- Advanced Extractor Module
        RA.addAssemblerRecipe(
                GT_ModHandler.getModItem(LP, "item.itemModule", 1L, 3),
                        GT_ItemList.RedstoneGoldChipset.get(1),
                        GT_ModHandler.getModItem(LP, "item.itemModule", 1L, 7), 140, 120);
        // --- Advanced Extractor Module MK2
        RA.addAssemblerRecipe(
                GT_ModHandler.getModItem(LP, "item.itemModule", 1L, 103),
                        GT_ItemList.RedstoneGoldChipset.get(1),
                        GT_ModHandler.getModItem(LP, "item.itemModule", 1L, 107), 160, 120);
        // --- Advanced Extractor Module MK3
        RA.addAssemblerRecipe(
                GT_ModHandler.getModItem(LP, "item.itemModule", 1L, 203),
                        GT_ItemList.RedstoneDiamondChipset.get(1),
                        GT_ModHandler.getModItem(LP, "item.itemModule", 1L, 207), 180, 256);
        // --- IC2 LV Power Supplier Upgrade
        RA.addAssemblerRecipe(
                GT_ModHandler.getModItem(LP, "item.itemUpgrade", 1L, 30),
                        GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.Tin, 2L),
                        GT_ModHandler.getModItem(LP, "item.itemUpgrade", 1L, 33), 100, 120);
        // --- IC2 MV Power Supplier Upgrade
        RA.addAssemblerRecipe(
                GT_ModHandler.getModItem(LP, "item.itemUpgrade", 1L, 30),
                        GT_OreDictUnificator.get(OrePrefixes.wireGt02, Materials.Copper, 2L),
                        GT_ModHandler.getModItem(LP, "item.itemUpgrade", 1L, 34), 120, 120);
        // --- IC2 HV Power Supplier Upgrade
        RA.addAssemblerRecipe(
                GT_ModHandler.getModItem(LP, "item.itemUpgrade", 1L, 30),
                        GT_OreDictUnificator.get(OrePrefixes.wireGt04, Materials.Electrum, 2L),
                        GT_ModHandler.getModItem(LP, "item.itemUpgrade", 1L, 35), 140, 120);
        // --- IC2 EV Power Supplier Upgrade
        RA.addAssemblerRecipe(
                GT_ModHandler.getModItem(LP, "item.itemUpgrade", 1L, 30),
                        GT_OreDictUnificator.get(OrePrefixes.wireGt08, Materials.Aluminium, 2L),
                        GT_ModHandler.getModItem(LP, "item.itemUpgrade", 1L, 36), 160, 120);
        // --- Crafting Sign Creator
        RA.addAssemblerRecipe(
                new ItemStack[]{
                        CoreItems2.getRecipe(182, 1),
                        GT_ModHandler.getModItem("OpenComputers", "keyboard", 1L),
                        GT_ModHandler.getModItem("minecraft", "sign", 16L)}, null,
                        GT_ModHandler.getModItem(LP, "item.ItemPipeSignCreator", 1L), 600, 120);

    }

    private void ciruit() {
                //LP Upgrades
                RA.addCircuitAssemblerRecipe(
                        new ItemStack[]{ItemList.Circuit_Board_Coated_Basic.get(1L),
                                ItemList.Circuit_Chip_Simple_SoC.get(1L),
                                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Tin, 1),
                                GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.RedAlloy, 2)},
                        Materials.SolderingAlloy.getMolten(72L),
                        GT_ModHandler.getModItem(LP, "item.itemUpgrade", 2L, 6), 120, 30);
                RA.addCircuitAssemblerRecipe(
                        new ItemStack[]{ItemList.Circuit_Board_Coated_Basic.get(1L),
                                ItemList.Circuit_Chip_Simple_SoC.get(1L),
                                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Iron, 1),
                                GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.RedAlloy, 2)},
                        Materials.SolderingAlloy.getMolten(72L),
                        GT_ModHandler.getModItem(LP, "item.itemUpgrade", 2L, 7), 120, 30);
                RA.addCircuitAssemblerRecipe(
                        new ItemStack[]{ItemList.Circuit_Board_Coated_Basic.get(1L),
                                ItemList.Circuit_Chip_Simple_SoC.get(1L),
                                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Electrum, 1),
                                GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.RedAlloy, 2)},
                        Materials.SolderingAlloy.getMolten(72L),
                        GT_ModHandler.getModItem(LP, "item.itemUpgrade", 2L, 20), 120, 30);
                RA.addCircuitAssemblerRecipe(
                        new ItemStack[]{ItemList.Circuit_Board_Coated_Basic.get(1L),
                                ItemList.Circuit_Chip_Simple_SoC.get(1L),
                                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Steel, 1),
                                GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.RedAlloy, 2)},
                        Materials.SolderingAlloy.getMolten(72L),
                        GT_ModHandler.getModItem(LP, "item.itemUpgrade", 2L, 16), 120, 30);
                RA.addCircuitAssemblerRecipe(
                        new ItemStack[]{ItemList.Circuit_Board_Coated_Basic.get(1L),
                                ItemList.Circuit_Chip_Simple_SoC.get(1L),
                                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Gold, 1),
                                GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.RedAlloy, 2)},
                        Materials.SolderingAlloy.getMolten(72L),
                        GT_ModHandler.getModItem(LP, "item.itemUpgrade", 2L, 21), 120, 30);
                RA.addCircuitAssemblerRecipe(
                        new ItemStack[]{ItemList.Circuit_Board_Coated_Basic.get(1L),
                                ItemList.Circuit_Chip_Simple_SoC.get(1L),
                                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.RedAlloy, 1),
                                GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Electrum, 2)},
                        Materials.SolderingAlloy.getMolten(72L),
                        GT_ModHandler.getModItem(LP, "item.itemUpgrade", 2L, 23), 120, 30);
                RA.addCircuitAssemblerRecipe(
                        new ItemStack[]{ItemList.Circuit_Board_Coated_Basic.get(1L),
                                ItemList.Circuit_Chip_Simple_SoC.get(1L),
                                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Gold, 1),
                                GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Electrum, 2)},
                        Materials.SolderingAlloy.getMolten(72L),
                        GT_ModHandler.getModItem(LP, "item.itemUpgrade", 2L, 24), 120, 30);
                RA.addCircuitAssemblerRecipe(
                        new ItemStack[]{ItemList.Circuit_Board_Coated_Basic.get(1L),
                                ItemList.Circuit_Chip_Simple_SoC.get(1L),
                                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Steel, 1),
                                GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Lapis, 2)},
                        Materials.SolderingAlloy.getMolten(72L),
                        GT_ModHandler.getModItem(LP, "item.itemUpgrade", 2L, 25), 120, 30);
                RA.addCircuitAssemblerRecipe(
                        new ItemStack[]{ItemList.Circuit_Board_Coated_Basic.get(1L),
                                ItemList.Circuit_Chip_Simple_SoC.get(1L),
                                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Steel, 1),
                                GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.AnnealedCopper, 2)},
                        Materials.SolderingAlloy.getMolten(72L),
                        GT_ModHandler.getModItem(LP, "item.itemUpgrade", 2L, 30), 120, 30);
                RA.addCircuitAssemblerRecipe(
                        new ItemStack[]{ItemList.Circuit_Board_Coated_Basic.get(1L),
                                ItemList.Circuit_Chip_Simple_SoC.get(1L),
                                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Bronze, 1),
                                GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.RedAlloy, 2)},
                        Materials.SolderingAlloy.getMolten(72L),
                        GT_ModHandler.getModItem(LP, "item.itemUpgrade", 2L, 41), 120, 30);
                RA.addCircuitAssemblerRecipe(
                        new ItemStack[]{ItemList.Circuit_Board_Coated_Basic.get(1L),
                                ItemList.Circuit_Chip_Simple_SoC.get(1L),
                                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Silver, 1),
                                GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.RedAlloy, 2)},
                        Materials.SolderingAlloy.getMolten(72L),
                        GT_ModHandler.getModItem(LP, "item.itemUpgrade", 2L, 42), 120, 30);
                RA.addCircuitAssemblerRecipe(
                        new ItemStack[]{ItemList.Circuit_Board_Coated_Basic.get(1L),
                                ItemList.Circuit_Chip_Simple_SoC.get(1L),
                                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.RedAlloy, 1),
                                GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Silver, 2)},
                        Materials.SolderingAlloy.getMolten(72L),
                        GT_ModHandler.getModItem(LP, "item.itemUpgrade", 2L, 26), 120, 30);
    }

    private void chemicalBathRecipe() {
        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < Dyes.VALUES[i].getSizeOfFluidList(); j++) {
                RA.addChemicalBathRecipe(GT_ModHandler.getModItem(LP, "item.remoteOrdererItem", 1L, 0), Dyes.VALUES[i].getFluidDye(j, 36L), GT_ModHandler.getModItem(LP, "item.remoteOrdererItem", 1L, 1 + i), GT_Values.NI, GT_Values.NI, null, 20, 2);
                }
            RA.addChemicalBathRecipe(GT_ModHandler.getModItem(LP, "item.remoteOrdererItem", 1L, 1 + i), Materials.Chlorine.getGas(50L), GT_ModHandler.getModItem(LP, "item.remoteOrdererItem", 1L, 0), GT_Values.NI, GT_Values.NI, null, 20, 2);
        }
    }
}
