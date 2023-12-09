package com.impactrecipes.recipes;

import com.impact.common.item.Core_Items;
import com.impact.common.item.Core_Items2;
import com.impact.impact;
import com.impact.mods.gregtech.GT_ItemList;
import com.impactrecipes.util.RecipeUtils;
import gregtech.api.enums.*;
import gregtech.api.interfaces.IOreRecipeRegistrator;
import gregtech.api.util.GT_ModHandler;
import gregtech.api.util.GT_OreDictUnificator;
import gregtech.api.util.GT_Utility;
import net.minecraft.item.ItemStack;

import static gregtech.api.enums.GT_Values.RA;
import static gregtech.api.util.GT_ModHandler.*;

public class AE implements Runnable {
//715
    private static final long tBitMask = GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE;
    final Core_Items CoreItems = Core_Items.getInstance();
    final Core_Items2 CoreItems2 = Core_Items2.getInstance();
    
    private static final String AE2 = "appliedenergistics2";
    
    @Override
    public void run() {
        removeAE();
        handRecipe();
        alloySmelterRecipe();
        assemblerRecipe();
        autoclaveRecipe();
        centrifugeRecipe();
        chemicalBathRecipe();
        chemicalReactorRecipe();
        compressorRecipe();
        cuttingSawRecipe();
        printerRecipe();
        pulveriserRecipe();
        wireAssemblerRecipe();
        unboxingRecipe();
        mixerRecipe();
        latheRecipe();
        fluidSolidifierRecipe();
        meSystemProvider();
    }

    private void removeAE() {
        removeRecipeByOutput(GT_ModHandler.getModItem("extracells", "part.base", 1L, 0), true, false,
                false);
        removeRecipeByOutput(GT_ModHandler.getModItem("extracells", "part.base", 1L, 1), true, false,
                false);
        removeRecipeByOutput(GT_ModHandler.getModItem("extracells", "part.base", 1L, 2), true, false,
                false);
        for (int i = 0; i < 18; i++) {
            removeRecipeByOutput(GT_ModHandler.getModItem("extracells", "storage.component", 1L, i), true,
                    false, false);
        }
        for (int i = 0; i < 7; i++) {
            removeRecipeByOutput(GT_ModHandler.getModItem("extracells", "storage.gas", 1L, i), true,
                    false, false);
        }
        for (int i = 0; i < 3; i++) {
            removeRecipeByOutput(GT_ModHandler.getModItem("extracells", "storage.casing", 1L, i), true, false,
                    false);
        }
        for (int i = 0; i < 7; i++) {
            removeRecipeByOutput(GT_ModHandler.getModItem("extracells", "storage.fluid", 1L, i), true, false,
                    false);
        }
        for (int i = 0; i < 5; i++) {
            removeRecipeByOutput(GT_ModHandler.getModItem("extracells", "storage.physical", 1L, i), true,
                    false, false);
        }
        removeRecipeByOutput(GT_ModHandler.getModItem("extracells", "certustank", 1L), true,
                false, false);
        removeRecipeByOutput(GT_ModHandler.getModItem("extracells", "pattern.fluid", 1L), true,
                false, false);
        removeRecipeByOutput(GT_ModHandler.getModItem("extracells", "pattern.base", 1L), true,
                false, false);
        for (int i = 0; i < 10; i++) {
            removeRecipeByOutput(GT_ModHandler.getModItem("extracells", "part.base", 1L, i), true,
                    false, false);
        }
        for (int i = 0; i < 4; i++) {
            removeRecipeByOutput(GT_ModHandler.getModItem("extracells", "craftingstorage", 1L, i), true,
                    false, false);
        }
        removeRecipeByOutput(GT_ModHandler.getModItem("extracells", "terminal.fluid.wireless", 1L, 0), true,
                false, false);
        removeRecipeByOutput(GT_ModHandler.getModItem("extracells", "ecbaseblock", 1L, 0), true,
                false, false);
        removeRecipeByOutput(GT_ModHandler.getModItem("extracells", "ecbaseblock", 1L, 1), true,
                false, false);
        removeRecipeByOutput(GT_ModHandler.getModItem("extracells", "storage.fluid.portable", 1L, 0), true,
                false, false);
        removeRecipeByOutput(GT_ModHandler.getModItem("extracells", "vibrantchamberfluid", 1L, 0), true,
                false, false);

        removeRecipeByOutput(GT_ModHandler.getModItem("ae2stuff", "Wireless", 1L, 0), true, false,
                true);
        removeRecipeByOutput(GT_ModHandler.getModItem("ae2stuff", "WirelessKit", 1L, 0), true, false,
                true
        );
        removeRecipeByOutput(GT_ModHandler.getModItem("ae2stuff", "Visualiser", 1L, 0), true, false,
                true
        );
        removeRecipeByOutput(GT_ModHandler.getModItem("ae2stuff", "Encoder", 1L, 0), true, false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("ae2stuff", "Grower", 1L, 0), true, false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("ae2stuff", "Inscriber", 1L, 0), true, false,
                true
        );
        removeRecipeByOutput(GT_ModHandler.getModItem("ae2wct", "wirelessCraftingTerminal", 1L, 0),
                true, false, true
        );
        removeRecipeByOutput(GT_ModHandler.getModItem("ae2wct", "magnetCard", 1L, 0), true, false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem(AE2, "tile.BlockFluix", 1L, 0));
        removeRecipeByOutput(GT_ModHandler.getModItem(AE2, "tile.BlockQuartz", 1L, 0));
        removeRecipeByOutput(GT_ModHandler.getModItem(AE2, "tile.BlockQuartzChiseled", 1L, 0));
        removeRecipeByOutput(GT_ModHandler.getModItem(AE2, "tile.BlockQuartzGrowthAccelerator", 1L, 0));
        removeRecipeByOutput(GT_ModHandler.getModItem(AE2, "tile.BlockCharger", 1L, 0));
        removeRecipeByOutput(GT_ModHandler.getModItem(AE2, "tile.BlockCellWorkbench", 1L, 0));
        removeRecipeByOutput(GT_ModHandler.getModItem(AE2, "tile.BlockIOPort", 1L, 0));
        removeRecipeByOutput(GT_ModHandler.getModItem(AE2, "tile.BlockCondenser", 1L, 0));
        removeRecipeByOutput(GT_ModHandler.getModItem(AE2, "tile.BlockSecurity", 1L, 0));
        removeRecipeByOutput(GT_ModHandler.getModItem(AE2, "tile.BlockSkyCompass", 1L, 0));
        removeRecipeByOutput(GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 1L, GT_Values.W));
        removeRecipeByOutput(GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, GT_Values.W));
        removeRecipeByOutput(GT_ModHandler.getModItem(AE2, "tile.BlockQuartzGlass", 1L, 0));
        removeRecipeByOutput(GT_ModHandler.getModItem(AE2, "tile.BlockQuartzLamp", 1L, 0));
        removeRecipeByOutput(GT_ModHandler.getModItem(AE2, "tile.BlockQuartzTorch", 1L, 0));
        removeRecipeByOutput(GT_ModHandler.getModItem(AE2, "tile.BlockLightDetector", 1L, 0));
        removeRecipeByOutput(GT_ModHandler.getModItem(AE2, "tile.BlockTinyTNT", 1L, 0));
        removeRecipeByOutput(GT_ModHandler.getModItem(AE2, "item.ToolMassCannon", 1L, 0));
        removeRecipeByOutput(GT_ModHandler.getModItem(AE2, "item.ToolMemoryCard", 1L, 0));
        removeRecipeByOutput(GT_ModHandler.getModItem(AE2, "item.ToolChargedStaff", 1L, 0));
        removeRecipeByOutput(GT_ModHandler.getModItem(AE2, "item.ToolEntropyManipulator", 1L, 0));
        removeRecipeByOutput(GT_ModHandler.getModItem(AE2, "item.ToolColorApplicator", 1L, 0));
        removeRecipeByOutput(GT_ModHandler.getModItem(AE2, "item.ToolBiometricCard", 1L, 0));
        removeRecipeByOutput(GT_ModHandler.getModItem(AE2, "item.ItemCrystalSeed", 1L, GT_Values.W));
        removeRecipeByOutput(GT_ModHandler.getModItem(AE2, "item.ToolPortableCell", 1L, 0));
        removeRecipeByOutput(GT_ModHandler.getModItem(AE2, "tile.BlockInscriber", 1L, 0));
        removeRecipeByOutput(GT_ModHandler.getModItem(AE2, "tile.BlockGrinder", 1L, 0));
        removeRecipeByOutput(GT_ModHandler.getModItem(AE2, "tile.BlockCrank", 1L, 0));
        removeRecipeByOutput(GT_ModHandler.getModItem(AE2, "tile.ChiseledQuartzSlabBlock", 1L, 0));
        removeRecipeByOutput(GT_ModHandler.getModItem(AE2, "tile.QuartzPillarSlabBlock", 1L, 0));
        removeRecipeByOutput(GT_ModHandler.getModItem(AE2, "tile.QuartzSlabBlock", 1L, 0));
        removeRecipeByOutput(GT_ModHandler.getModItem("minecraft", "quartz_block", 1L, 0));
        removeRecipeByOutput(GT_ModHandler.getModItem(AE2, "tile.BlockController", 1L, 0), true, false, false);
        removeRecipeByOutput(GT_ModHandler.getModItem(AE2, "tile.BlockChest", 1L, 0), true, false, false);
        removeRecipeByOutput(GT_ModHandler.getModItem(AE2, "tile.BlockDrive", 1L, 0), true, false, false);
        removeRecipeByOutput(GT_ModHandler.getModItem(AE2, "tile.BlockCraftingUnit", 1L, 0), true, false, false);
        removeRecipeByOutput(GT_ModHandler.getModItem(AE2, "tile.BlockMolecularAssembler", 1L, 0), true, false, false);
        removeRecipeByOutput(GT_ModHandler.getModItem(AE2, "tile.BlockQuantumRing", 1L, 0), true, false, false);
        removeRecipeByOutput(GT_ModHandler.getModItem(AE2, "tile.BlockQuantumLinkChamber", 1L, 0), true, false, false);
        removeRecipeByOutput(GT_ModHandler.getModItem(AE2, "tile.BlockSpatialPylon", 1L, 0), true, false, false);
        removeRecipeByOutput(GT_ModHandler.getModItem(AE2, "tile.BlockSpatialIOPort", 1L, 0), true, false, false);
        removeRecipeByOutput(GT_ModHandler.getModItem(AE2, "tile.BlockInterface", 1L, 0), true, false, false);
        removeRecipeByOutput(GT_ModHandler.getModItem(AE2, "tile.BlockEnergyAcceptor", 1L, 0), true, false, false);
        removeRecipeByOutput(GT_ModHandler.getModItem(AE2, "item.ItemBasicStorageCell.1k", 1L), true, false, false);
        removeRecipeByOutput(GT_ModHandler.getModItem(AE2, "item.ItemBasicStorageCell.4k", 1L), true, false, false);
        removeRecipeByOutput(GT_ModHandler.getModItem(AE2, "item.ItemBasicStorageCell.16k", 1L), true, false, false);
        removeRecipeByOutput(GT_ModHandler.getModItem(AE2, "item.ItemBasicStorageCell.64k", 1L), true, false, false);
        removeRecipeByOutput(GT_ModHandler.getModItem(AE2, "item.ItemAdvancedStorageCell.256k", 1L), true, false, false);
        removeRecipeByOutput(GT_ModHandler.getModItem(AE2, "item.ItemAdvancedStorageCell.1024k", 1L), true, false, false);
        removeRecipeByOutput(GT_ModHandler.getModItem(AE2, "item.ItemAdvancedStorageCell.4096k", 1L), true, false, false);
        removeRecipeByOutput(GT_ModHandler.getModItem(AE2, "item.ItemAdvancedStorageCell.16384k", 1L), true, false, false);
        removeRecipeByOutput(GT_ModHandler.getModItem(AE2, "item.ItemSpatialStorageCell.2Cubed", 1L), true, false, false);
        removeRecipeByOutput(GT_ModHandler.getModItem(AE2, "item.ItemSpatialStorageCell.16Cubed", 1L), true, false, false);
        removeRecipeByOutput(GT_ModHandler.getModItem(AE2, "item.ItemSpatialStorageCell.128Cubed", 1L), true, false, false);
        removeRecipeByOutput(GT_ModHandler.getModItem(AE2, "item.ItemViewCell", 1L), true, false, false);
        removeRecipeByOutput(GT_ModHandler.getModItem(AE2, "tile.BlockEnergyCell", 1L, 0), true, false, false);
        removeRecipeByOutput(GT_ModHandler.getModItem(AE2, "tile.BlockDenseEnergyCell", 1L, 0), true, false, false);
        removeRecipeByOutput(GT_ModHandler.getModItem(AE2, "tile.BlockCraftingUnit", 1L, 1), true, false, false);
		removeRecipeByOutput(GT_ModHandler.getModItem(AE2, "tile.BlockCraftingUnit", 1L, 2), true, false, false);
		removeRecipeByOutput(GT_ModHandler.getModItem(AE2, "tile.BlockCraftingUnit", 1L, 3), true, false, false);
        removeRecipeByOutput(GT_ModHandler.getModItem(AE2, "tile.BlockCraftingUnit", 1L, 0), true, false, false);
        removeRecipeByOutput(GT_ModHandler.getModItem(AE2, "tile.BlockAdvancedCraftingUnit", 1L, 0), true, false, false);
        removeRecipeByOutput(GT_ModHandler.getModItem(AE2, "tile.BlockAdvancedCraftingUnit", 1L, 1), true, false, false);
        removeRecipeByOutput(GT_ModHandler.getModItem(AE2, "tile.BlockAdvancedCraftingUnit", 1L, 2), true, false, false);
        removeRecipeByOutput(GT_ModHandler.getModItem(AE2, "tile.BlockAdvancedCraftingUnit", 1L, 3), true, false, false);
        removeRecipeByOutput(GT_ModHandler.getModItem(AE2, "tile.BlockCraftingStorage", 1L, 0), true, false, false);
        removeRecipeByOutput(GT_ModHandler.getModItem(AE2, "tile.BlockCraftingStorage", 1L, 1), true, false, false);
        removeRecipeByOutput(GT_ModHandler.getModItem(AE2, "tile.BlockCraftingStorage", 1L, 2), true, false, false);
        removeRecipeByOutput(GT_ModHandler.getModItem(AE2, "tile.BlockCraftingStorage", 1L, 3), true, false, false);
        removeRecipeByOutput(GT_ModHandler.getModItem(AE2, "tile.BlockWireless", 1L, 0), true, false, false);
        removeRecipeByOutput(GT_ModHandler.getModItem(AE2, "tile.SkyStoneSlabBlock", 1L, 0), true, false, false);
        removeRecipeByOutput(GT_ModHandler.getModItem(AE2, "tile.SkyStoneBlockSlabBlock", 1L, 0), true, false, false);
        removeRecipeByOutput(GT_ModHandler.getModItem(AE2, "tile.SkyStoneBrickSlabBlock", 1L, 0), true, false, false);
        removeRecipeByOutput(GT_ModHandler.getModItem(AE2, "tile.FluixSlabBlock", 1L, 0), true, false, false);
        removeRecipeByOutput(GT_ModHandler.getModItem(AE2, "tile.SkyStoneSmallBrickSlabBlock", 1L, 0), true, false, false);
    
        removeRecipeByOutput(GT_ModHandler.getModItem(AE2, "item.ToolCertusQuartzAxe", 1L, 0), true, false, false);
        removeRecipeByOutput(GT_ModHandler.getModItem(AE2, "item.ToolCertusQuartzHoe", 1L, 0), true, false, false);
        removeRecipeByOutput(GT_ModHandler.getModItem(AE2, "item.ToolCertusQuartzSpade", 1L, 0), true, false, false);
        removeRecipeByOutput(GT_ModHandler.getModItem(AE2, "item.ToolCertusQuartzPickaxe", 1L, 0), true, false, false);
        removeRecipeByOutput(GT_ModHandler.getModItem(AE2, "item.ToolCertusQuartzSword", 1L, 0), true, false, false);
        removeRecipeByOutput(GT_ModHandler.getModItem(AE2, "item.ToolCertusQuartzCuttingKnife", 1L, 0), true, false, false);
        removeRecipeByOutput(GT_ModHandler.getModItem(AE2, "item.ToolCertusQuartzWrench", 1L, 0), true, false, false);
        removeRecipeByOutput(GT_ModHandler.getModItem(AE2, "item.ToolNetherQuartzAxe", 1L, 0), true, false, false);
        removeRecipeByOutput(GT_ModHandler.getModItem(AE2, "item.ToolNetherQuartzHoe", 1L, 0), true, false, false);
        removeRecipeByOutput(GT_ModHandler.getModItem(AE2, "item.ToolNetherQuartzSpade", 1L, 0), true, false, false);
        removeRecipeByOutput(GT_ModHandler.getModItem(AE2, "item.ToolNetherQuartzPickaxe", 1L, 0), true, false, false);
        removeRecipeByOutput(GT_ModHandler.getModItem(AE2, "item.ToolNetherQuartzSword", 1L, 0), true, false, false);
        removeRecipeByOutput(GT_ModHandler.getModItem(AE2, "item.ToolNetherQuartzCuttingKnife", 1L, 0), true, false, false);
        removeRecipeByOutput(GT_ModHandler.getModItem(AE2, "item.ToolNetherQuartzWrench", 1L, 0), true, false, false);
        removeRecipeByOutput(GT_ModHandler.getModItem(AE2, "tile.BlockAdvancedCraftingStorage", 1L, 0), true, false, false);
        removeRecipeByOutput(GT_ModHandler.getModItem(AE2, "tile.BlockAdvancedCraftingStorage", 1L, 1), true, false, false);
        removeRecipeByOutput(GT_ModHandler.getModItem(AE2, "tile.BlockAdvancedCraftingStorage", 1L, 2), true, false, false);
        removeRecipeByOutput(GT_ModHandler.getModItem(AE2, "tile.BlockAdvancedCraftingStorage", 1L, 3), true, false, false);

        removeRecipeByOutput(GT_ModHandler.getModItem(AE2, "item.ToolCertusQuartzAxe", 1L, 0), true, false, false);

        removeRecipeByOutput(GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 57));
        removeRecipeByOutput(GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 58));
        removeRecipeByOutput(GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 59));
        removeRecipeByOutput(GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 60));

        removeRecipeByOutput(GT_ModHandler.getModItem(AE2, "item.ItemExtremeStorageCell.Quantum", 1L));
        removeRecipeByOutput(GT_ModHandler.getModItem(AE2, "item.ItemVoidStorageCell", 1L));
        removeRecipeByOutput(GT_ModHandler.getModItem(AE2, "item.ItemExtremeStorageCell.Singularity", 1L));
        removeRecipeByOutput(GT_ModHandler.getModItem(AE2, "item.ItemExtremeStorageCell.Container", 1L));

        removeRecipeByOutput(GT_ModHandler.getModItem("ae2fc", "fluid_discretizer", 1L));
        removeRecipeByOutput(GT_ModHandler.getModItem("ae2fc", "fluid_pattern_encoder", 1L));
        removeRecipeByOutput(GT_ModHandler.getModItem("ae2fc", "fluid_packet_decoder", 1L));
        removeRecipeByOutput(GT_ModHandler.getModItem("ae2fc", "fluid_interface", 1L));
        removeRecipeByOutput(GT_ModHandler.getModItem("ae2fc", "ingredient_buffer", 1L));
        removeRecipeByOutput(GT_ModHandler.getModItem("ae2fc", "large_ingredient_buffer", 1L));
        removeRecipeByOutput(GT_ModHandler.getModItem("ae2fc", "fluid_buffer", 1L));
        removeRecipeByOutput(GT_ModHandler.getModItem("ae2fc", "oc_pattern_editor", 1L));
		removeRecipeByOutput(GT_ModHandler.getModItem("ae2fc", "level_maintainer", 1L));
    
        removeRecipeByOutput(GT_ModHandler.getModItem("ae2fc", "part_fluid_pattern_terminal", 1L));
        removeRecipeByOutput(GT_ModHandler.getModItem("ae2fc", "part_fluid_pattern_terminal_ex", 1L));
        removeRecipeByOutput(GT_ModHandler.getModItem("ae2fc", "part_fluid_conversion_monitor", 1L));

        removeRecipeByOutput(GT_ModHandler.getModItem("ae2fc", "part_fluid_import", 1L));
        removeRecipeByOutput(GT_ModHandler.getModItem("ae2fc", "part_fluid_export", 1L));
        removeRecipeByOutput(GT_ModHandler.getModItem("ae2fc", "part_fluid_storage_bus", 1L));

        removeRecipeByOutput(GT_ModHandler.getModItem("ae2fc", "fluid_storage1", 1L));
        removeRecipeByOutput(GT_ModHandler.getModItem("ae2fc", "fluid_storage4", 1L));
        removeRecipeByOutput(GT_ModHandler.getModItem("ae2fc", "fluid_storage16", 1L));
        removeRecipeByOutput(GT_ModHandler.getModItem("ae2fc", "fluid_storage64", 1L));
        removeRecipeByOutput(GT_ModHandler.getModItem("ae2fc", "fluid_storage256", 1L));
        removeRecipeByOutput(GT_ModHandler.getModItem("ae2fc", "fluid_storage1024", 1L));
        removeRecipeByOutput(GT_ModHandler.getModItem("ae2fc", "fluid_storage4096", 1L));
        removeRecipeByOutput(GT_ModHandler.getModItem("ae2fc", "fluid_storage16384", 1L));

        removeRecipeByOutput(GT_ModHandler.getModItem("ae2fc", "multi_fluid_storage1", 1L));
        removeRecipeByOutput(GT_ModHandler.getModItem("ae2fc", "multi_fluid_storage4", 1L));
        removeRecipeByOutput(GT_ModHandler.getModItem("ae2fc", "multi_fluid_storage16", 1L));
        removeRecipeByOutput(GT_ModHandler.getModItem("ae2fc", "multi_fluid_storage64", 1L));
        removeRecipeByOutput(GT_ModHandler.getModItem("ae2fc", "multi_fluid_storage256", 1L));
        removeRecipeByOutput(GT_ModHandler.getModItem("ae2fc", "multi_fluid_storage1024", 1L));
        removeRecipeByOutput(GT_ModHandler.getModItem("ae2fc", "multi_fluid_storage4096", 1L));
        removeRecipeByOutput(GT_ModHandler.getModItem("ae2fc", "multi_fluid_storage16384", 1L));

        removeRecipeByOutput(GT_ModHandler.getModItem("ae2fc", "fluid_part", 1L));
        removeRecipeByOutput(GT_ModHandler.getModItem("ae2fc", "fluid_part", 1L, 1));
        removeRecipeByOutput(GT_ModHandler.getModItem("ae2fc", "fluid_part", 1L, 2));
        removeRecipeByOutput(GT_ModHandler.getModItem("ae2fc", "fluid_part", 1L, 3));
        removeRecipeByOutput(GT_ModHandler.getModItem("ae2fc", "fluid_part", 1L, 4));
        removeRecipeByOutput(GT_ModHandler.getModItem("ae2fc", "fluid_part", 1L, 5));
        removeRecipeByOutput(GT_ModHandler.getModItem("ae2fc", "fluid_part", 1L, 6));
        removeRecipeByOutput(GT_ModHandler.getModItem("ae2fc", "fluid_part", 1L, 7));

        removeRecipeByOutput(GT_ModHandler.getModItem("ae2fc", "portable_fluid_cell", 1L));

        removeRecipeByOutput(GT_ModHandler.getModItem("ae2fc", "certus_quartz_tank", 1L));
        removeRecipeByOutput(GT_ModHandler.getModItem("ae2fc", "fluid_auto_filler", 1L));
        removeRecipeByOutput(GT_ModHandler.getModItem("ae2fc", "part_fluid_terminal", 1L));

        removeRecipeByOutput(GT_ModHandler.getModItem("ae2fc", "fluid_storage_housing", 1L));
        removeRecipeByOutput(GT_ModHandler.getModItem("ae2fc", "fluid_storage_housing", 1L, 1));
        removeRecipeByOutput(GT_ModHandler.getModItem("ae2fc", "fluid_storage_housing", 1L, 2));
        removeRecipeByOutput(GT_ModHandler.getModItem("ae2fc", "fluid_storage_housing", 1L, 3));

        removeRecipeByOutput(GT_ModHandler.getModItem("ae2fc", "part_fluid_terminal", 1L));
        removeRecipeByOutput(GT_ModHandler.getModItem("ae2fc", "part_fluid_level_emitter", 1L));

        removeRecipeByOutput(GT_ModHandler.getModItem("ae2fc", "fluid_storage.quantum", 1L));
        removeRecipeByOutput(GT_ModHandler.getModItem("ae2fc", "fluid_storage.singularity", 1L));

        removeRecipeByOutput(GT_ModHandler.getModItem("ae2fc", "wireless_fluid_pattern_terminal", 1L));
        removeRecipeByOutput(GT_ModHandler.getModItem("ae2fc", "wireless_interface_terminal", 1L));
        removeRecipeByOutput(GT_ModHandler.getModItem("ae2fc", "wireless_fluid_terminal", 1L));

    }

    private void handRecipe() {
        // --- Terminal
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("ae2wct", "wirelessCraftingTerminal", 1L, 0), tBitMask, new Object[]{"SAE", "PTP", "PBP", 'P', OrePrefixes.plate.get(Materials.HastelloyN), 'E', ItemList.Emitter_IV, 'B', ItemList.BatteryHull_IV_Full, 'S', ItemList.Sensor_IV, 'T', GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 1L, 360), 'A', GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 41)});
        // --- Wireless Setup Kit
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("ae2stuff", "WirelessKit", 1L, 0), tBitMask, new Object[]{"SWS", "PAP", "dIw", 'S', OrePrefixes.screw.get(Materials.Titanium), 'P', OrePrefixes.plate.get(Materials.Birmabright), 'I', OrePrefixes.stick.get(Materials.Birmabright), 'W', GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 41), 'A', GT_ModHandler.getModItem(AE2, "item.ToolNetworkTool", 1L, 0)});
        // --- Network Visualisation Tool
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("ae2stuff", "Visualiser", 1L, 0), tBitMask, new Object[]{"E S", "PMP", "PCP", 'P', OrePrefixes.plate.get(Materials.Birmabright), 'C', OrePrefixes.circuit.get(Materials.Data), 'E', ItemList.Emitter_EV, 'S', ItemList.Sensor_EV, 'M', GT_ModHandler.getModItem("OpenComputers", "hologram2", 1L)});
        // --- Pattern Encoder
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("ae2stuff", "Encoder", 1L, 0), tBitMask, new Object[]{"POP", "ACA", "PEP", 'P', OrePrefixes.plate.get(Materials.VanadiumSteel), 'O', GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 1L, 340), 'A', GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 23), 'C', GT_ModHandler.getModItem(AE2, "tile.BlockCraftingUnit", 1L, 0), 'E', GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 1L, 16)});
        // --- Advanced Storage Housing
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 61), tBitMask, new Object[]{"hGS", "TOT", "SVd", 'O', GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 39), 'T', OrePrefixes.plate.get(Materials.Iridium), 'V', OrePrefixes.plate.get(Materials.HastelloyC276), 'S', OrePrefixes.screw.get(Materials.CertusQuartz), 'G', OrePrefixes.plate.get(Materials.ReinforcedGlass)});
        // --- Fluid Storage Housing
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("ae2fc", "fluid_storage_housing", 1L), tBitMask, new Object[]{"hQS", "TGT", "SVd", 'Q', OrePrefixes.plate.get(Materials.CertusQuartz), 'T', OrePrefixes.plate.get(Materials.RedSteel), 'V', OrePrefixes.plate.get(Materials.StainlessSteel), 'S', OrePrefixes.screw.get(Materials.NetherQuartz), 'G', "paneGlass"});
        // --- Advanced Fluid Storage Housing
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("ae2fc", "fluid_storage_housing", 1L, 1), tBitMask, new Object[]{"hGS", "TOT", "SVd", 'O', GT_ModHandler.getModItem("ae2fc", "fluid_storage_housing", 1L), 'T', OrePrefixes.plate.get(Materials.Stellite), 'V', OrePrefixes.plate.get(Materials.HastelloyC276), 'S', OrePrefixes.screw.get(Materials.CertusQuartz), 'G', OrePrefixes.plate.get(Materials.ReinforcedGlass)});
        // --- Multi-Fluid Storage Housing
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("ae2fc", "fluid_storage_housing", 1L, 2), tBitMask, new Object[]{"hQS", "TGT", "SVd", 'Q', OrePrefixes.plate.get(Materials.CertusQuartz), 'T', OrePrefixes.plate.get(Materials.Birmabright), 'V', OrePrefixes.plate.get(Materials.StainlessSteel), 'S', OrePrefixes.screw.get(Materials.NetherQuartz), 'G', "paneGlass"});
        // --- Advanced Multi-Fluid Storage Housing
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("ae2fc", "fluid_storage_housing", 1L, 3), tBitMask, new Object[]{"hGS", "TOT", "SVd", 'O', GT_ModHandler.getModItem("ae2fc", "fluid_storage_housing", 1L, 2), 'T', OrePrefixes.plate.get(Materials.Grisium), 'V', OrePrefixes.plate.get(Materials.HastelloyC276), 'S', OrePrefixes.screw.get(Materials.CertusQuartz), 'G', OrePrefixes.plate.get(Materials.ReinforcedGlass)});

        // --- Quartz Cutting Knife
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem(AE2, "item.ToolCertusQuartzCuttingKnife", 1L), tBitMask, new Object[]{"  S", " S ", "Gf ", 'G', OrePrefixes.gem.get(Materials.CertusQuartz), 'S', OrePrefixes.stick.get(Materials.Wood)});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem(AE2, "item.ToolNetherQuartzCuttingKnife", 1L), tBitMask, new Object[]{"  S", " S ", "Gf ", 'G', OrePrefixes.gem.get(Materials.NetherQuartz), 'S', OrePrefixes.stick.get(Materials.Wood)});
    
        // --- Charger
        addCraftingRecipe(GT_ModHandler.getModItem(AE2, "tile.BlockCharger", 1L), tBitMask, new Object[]{"PEP", "Cw ", "PEP", 'P', OrePrefixes.plateDouble.get(Materials.Vanadium), 'E', ItemList.Emitter_EV, 'C', GT_ModHandler.getModItem("OpenComputers", "charger", 1L, 0)});
        // --- ME Storage Housing
        addCraftingRecipe(GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 39), tBitMask, new Object[]{"hQS", "TGT", "SVd", 'Q', OrePrefixes.plate.get(Materials.CertusQuartz), 'T', OrePrefixes.plate.get(Materials.StainlessSteel), 'V', OrePrefixes.plate.get(Materials.VanadiumSteel), 'S', OrePrefixes.screw.get(Materials.Quartzite), 'G', "paneGlass"});
        // --- ME Interface
        addShapelessCraftingRecipe(GT_ModHandler.getModItem(AE2, "tile.BlockInterface", 1L, 0), tBitMask, new Object[]{GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 1L, 440)});
        addShapelessCraftingRecipe(GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 1L, 440), tBitMask, new Object[]{GT_ModHandler.getModItem(AE2, "tile.BlockInterface", 1L, 0)});
        // --- ME Conversion Monitor
        addCraftingRecipe(GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 1L, 420), tBitMask, new Object[]{"dAh", "SDS", "PEP", 'P', OrePrefixes.plate.get(Materials.NetherQuartz), 'S', OrePrefixes.screw.get(Materials.CertusQuartz), 'A', GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 1L, 400), 'D', GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 43), 'E', GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 44)});
        // --- Cell Workbench
        addCraftingRecipe(GT_ModHandler.getModItem(AE2, "tile.BlockCellWorkbench", 1L, 0), tBitMask, new Object[]{"CMC", "PEP", 'P', OrePrefixes.plate.get(Materials.Vanadium), 'C', OrePrefixes.circuit.get(Materials.Advanced), 'E', GT_ModHandler.getModItem(AE2, "tile.BlockChest", 1L, 0), 'M', ItemList.Cover_Screen});
        // --- ME IO Port
        addCraftingRecipe(GT_ModHandler.getModItem(AE2, "tile.BlockIOPort", 1L, 0), tBitMask, new Object[]{"CMC", "ADA", "PEP", 'P', OrePrefixes.plate.get(Materials.Vanadium), 'C', GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 23), 'M', GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 1L, 480), 'A', GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 37), 'D', GT_ModHandler.getModItem(AE2, "tile.BlockDrive", 1L, 0), 'E', GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 1L, 76)});
        // --- Matter Condenser
        addCraftingRecipe(GT_ModHandler.getModItem(AE2, "tile.BlockCondenser", 1L, 0), tBitMask, new Object[]{"FCF", "CMC", "FCF", 'F', OrePrefixes.foil.get(Materials.VanadiumSteel), 'C', GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 44), 'M', GT_ModHandler.getModItem(AE2, "tile.BlockMolecularAssembler", 1L, 0)});
        // --- ME Security Terminal
        addCraftingRecipe(GT_ModHandler.getModItem(AE2, "tile.BlockSecurity", 1L, 0), tBitMask, new Object[]{"PMP", "ACA", "POP", 'P', OrePrefixes.plate.get(Materials.VanadiumSteel), 'C', GT_ModHandler.getModItem(AE2, "tile.BlockChest", 1L, 0), 'A', GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 1L, 16), 'O', GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 37), 'M', GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 1L, 480)});
        // --- Meteorite Compass
        addCraftingRecipe(GT_ModHandler.getModItem(AE2, "tile.BlockSkyCompass", 1L, 0), tBitMask, new Object[]{"dGS", "PRP", "SPh", 'P', OrePrefixes.plate.get(Materials.Steel), 'S', OrePrefixes.screw.get(Materials.CertusQuartz), 'R', OrePrefixes.stick.get(Materials.SteelMagnetic), 'G', OrePrefixes.plate.get(Materials.Glass)});
        addCraftingRecipe(GT_ModHandler.getModItem(AE2, "tile.BlockSkyCompass", 1L, 0), tBitMask, new Object[]{"hGS", "PRP", "SPd", 'P', OrePrefixes.plate.get(Materials.Steel), 'S', OrePrefixes.screw.get(Materials.CertusQuartz), 'R', OrePrefixes.stick.get(Materials.SteelMagnetic), 'G', OrePrefixes.plate.get(Materials.Glass)});
        // --- Network Tool
        addCraftingRecipe(GT_ModHandler.getModItem(AE2, "item.ToolNetworkTool", 1L, 0), tBitMask, new Object[]{"WPC", "O  ", 'W', GT_ModHandler.getModItem("EnderIO", "itemYetaWrench", 1L, 0), 'P', "itemIlluminatedPanel", 'C', GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 23), 'O', GT_ModHandler.getModItem("minecraft", "chest", 1L, 0)});
        // --- Fluix Pearl
        addCraftingRecipe(GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 9), tBitMask, new Object[]{"QPQ", "POP", "QPQ", 'P', OrePrefixes.plate.get(Materials.Grisium), 'Q', GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 12), 'O', OrePrefixes.lens.get(Materials.EnderPearl)});
        addCraftingRecipe(GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 9), tBitMask, new Object[]{"QPQ", "POP", "QPQ", 'P', OrePrefixes.plate.get(Materials.Grisium), 'Q', GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 7), 'O', OrePrefixes.lens.get(Materials.EnderPearl)});
        // --- Terminal
        addCraftingRecipe(GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 1L, 380), tBitMask, new Object[]{"RSR", "ICP", "RdR", 'R', OrePrefixes.stick.get(Materials.NetherQuartz), 'S', OrePrefixes.screw.get(Materials.Quartzite), 'I', "itemIlluminatedPanel", 'C', OrePrefixes.circuit.get(Materials.Good), 'P', OrePrefixes.plate.get(Materials.CertusQuartz)});
        addCraftingRecipe(GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 1L, 380), tBitMask, new Object[]{"RdR", "ICP", "RSR", 'R', OrePrefixes.stick.get(Materials.NetherQuartz), 'S', OrePrefixes.screw.get(Materials.Quartzite), 'I', "itemIlluminatedPanel", 'C', OrePrefixes.circuit.get(Materials.Good), 'P', OrePrefixes.plate.get(Materials.CertusQuartz)});
        // --- Crafting Terminal
        addCraftingRecipe(GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 1L, 360), tBitMask, new Object[]{"dTh", "SOS", "PCP", 'S', OrePrefixes.screw.get(Materials.CertusQuartz), 'P', OrePrefixes.plate.get(Materials.NetherQuartz), 'T', GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 1L, 380), 'O', ItemList.Cover_Crafting, 'C', GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 24)});
        // --- Interface Terminal
        addCraftingRecipe(GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 1L, 480), tBitMask, new Object[]{"dTh", "SOS", "PCP", 'S', OrePrefixes.screw.get(Materials.CertusQuartz), 'P', OrePrefixes.plate.get(Materials.NetherQuartz), 'T', GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 1L, 380), 'O', GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 1L, 440), 'C', GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 24)});
        // --- Pattern Terminal
        addCraftingRecipe(GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 1L, 340), tBitMask, new Object[]{"dTh", "SOS", "PCP", 'S', OrePrefixes.screw.get(Materials.CertusQuartz), 'P', OrePrefixes.plate.get(Materials.NetherQuartz), 'T', GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 1L, 380), 'O', GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 52), 'C', GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 24)});
        // --- Storage Monitor
        addCraftingRecipe(GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 1L, 400), tBitMask, new Object[]{"dTh", "SOS", "PPP", 'S', OrePrefixes.screw.get(Materials.CertusQuartz), 'P', OrePrefixes.plate.get(Materials.NetherQuartz), 'T', "itemIlluminatedPanel", 'O', GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 1L, 280)});
        // --- Wireless Terminal
        addCraftingRecipe(GT_ModHandler.getModItem(AE2, "item.ToolWirelessTerminal", 1L, 0), tBitMask, new Object[]{"WTW", "PCP", "PEP", 'P', OrePrefixes.plate.get(Materials.VanadiumSteel), 'T', GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 1L, 380), 'W', GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 41), 'C', GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 24), 'E', GT_ModHandler.getModItem(AE2, "tile.BlockDenseEnergyCell", 1L, 0)});
        // --- Vibrant Quartz Glass
        addCraftingRecipe(GT_ModHandler.getModItem(AE2, "tile.BlockQuartzLamp", 1L, 0), tBitMask, new Object[]{"DPD", "PGP", "DPD", 'D', OrePrefixes.dust.get(Materials.Glowstone), 'P', OrePrefixes.plate.get(Materials.Glowstone), 'G', GT_ModHandler.getModItem(AE2, "tile.BlockQuartzGlass", 1L, 0)});
        // --- Charged Quartz Fixture
        addShapelessCraftingRecipe(GT_ModHandler.getModItem(AE2, "tile.BlockQuartzTorch", 1L, 0), tBitMask, new Object[]{OrePrefixes.gem.get(Materials.CertusQuartz), OrePrefixes.stick.get(Materials.Aluminium)});
        // --- Light Detecting Fixture
        addShapelessCraftingRecipe(GT_ModHandler.getModItem(AE2, "tile.BlockLightDetector", 1L, 0), tBitMask, new Object[]{GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 1), OrePrefixes.stick.get(Materials.Iron)});
        // --- Advanced Card
        addCraftingRecipe(GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 28), tBitMask, new Object[]{"PVS", "RCV", "PVS", 'P', OrePrefixes.plate.get(Materials.Platinum), 'V', OrePrefixes.plate.get(Materials.VanadiumSteel), 'R', OrePrefixes.plate.get(Materials.RedAlloy), 'S', OrePrefixes.screw.get(Materials.Titanium), 'C', GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 23)});
        // --- Basic Card
        addCraftingRecipe(GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 25), tBitMask, new Object[]{"PVS", "RCV", "PVS", 'P', OrePrefixes.plate.get(Materials.Gold), 'V', OrePrefixes.plate.get(Materials.VanadiumSteel), 'R', OrePrefixes.plate.get(Materials.RedAlloy), 'S', OrePrefixes.screw.get(Materials.StainlessSteel), 'C', GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 23)});
        // --- Capacity Card
        addShapelessCraftingRecipe(GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 27), tBitMask, new Object[]{GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 25), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 23), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 23), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 1)});
        // --- Card Upgrade
        addShapelessCraftingRecipe(GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 54), tBitMask, new Object[]{GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 28), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 23), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 23), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 1)});
        // --- Crafting Card
        addShapelessCraftingRecipe(GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 53), tBitMask, new Object[]{GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 25), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 23), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 23), "craftingWorkBench"});
        // --- Redstone Card
        addShapelessCraftingRecipe(GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 26), tBitMask, new Object[]{GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 25), "craftingRedstoneTorch", "craftingRedstoneTorch", GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 23)});
        // --- Fuzzy Card
        addShapelessCraftingRecipe(GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 29), tBitMask, new Object[]{GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 28), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 24), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 22), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 23)});
        // --- Inverter Card
        addShapelessCraftingRecipe(GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 31), tBitMask, new Object[]{GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 28), GT_ModHandler.getModItem("IC2", "upgradeModule", 1L, 5), GT_ModHandler.getModItem("IC2", "upgradeModule", 1L, 5), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 23)});
        // --- Acceleration Card
        addShapelessCraftingRecipe(GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 30), tBitMask, new Object[]{GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 28), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 24), OrePrefixes.circuit.get(Materials.Advanced), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 7)});
        // --- Hyper Acceleration Card
        addShapelessCraftingRecipe(GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 56), tBitMask, new Object[]{GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 28), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 24), OrePrefixes.circuit.get(Materials.Elite), CoreItems2.getRecipe(196, 1)});
        // --- Wireless Booster
        addCraftingRecipe(GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 42), tBitMask, new Object[]{"DGE", "PPP", 'P', OrePrefixes.plate.get(Materials.VanadiumSteel), 'E', OrePrefixes.plate.get(Materials.EnderPearl), 'G', OrePrefixes.gem.get(Materials.CertusQuartz), 'D', GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 8)});
        // --- OreDict Filter Card
        addShapelessCraftingRecipe(GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 55), tBitMask, new Object[]{GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 28), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 23), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 23), GT_ModHandler.getModItem("EnderIO", "itemBasicFilterUpgrade", 1L, 1)});
        // --- ME Annihilation Plane
        addCraftingRecipe(GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 1L, 300), tBitMask, new Object[]{"DDD", "PAP", 'P', OrePrefixes.plate.get(Materials.VanadiumSteel), 'D', GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 8), 'A', GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 44)});
        // --- ME Formation Plane
        addCraftingRecipe(GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 1L, 320), tBitMask, new Object[]{"DDD", "PAP", 'P', OrePrefixes.plate.get(Materials.VanadiumSteel), 'D', GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 8), 'A', GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 43)});
        // --- ME Toggle Bus
        addCraftingRecipe(GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 1L, 80), tBitMask, new Object[]{" P ", "CLC", " P ", 'P', OrePrefixes.plate.get(Materials.RedAlloy), 'C', GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 1L, 16), 'L', GT_ModHandler.getModItem("minecraft", "lever", 1L, 0)});
        addShapelessCraftingRecipe(GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 1L, 80), tBitMask, new Object[]{GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 1L, 100)});
        addShapelessCraftingRecipe(GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 1L, 100), tBitMask, new Object[]{GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 1L, 80)});
        // --- Cable Anchor
        addShapelessCraftingRecipe(GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 2L, 120), tBitMask, new Object[]{ToolDictNames.craftingToolKnife, OrePrefixes.ingot.get(Materials.Iron)});
        addShapelessCraftingRecipe(GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 2L, 120), tBitMask, new Object[]{ToolDictNames.craftingToolKnife, OrePrefixes.ingot.get(Materials.Copper)});
        addShapelessCraftingRecipe(GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 3L, 120), tBitMask, new Object[]{ToolDictNames.craftingToolKnife, OrePrefixes.ingot.get(Materials.Bronze)});
        addShapelessCraftingRecipe(GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 2L, 120), tBitMask, new Object[]{ToolDictNames.craftingToolKnife, OrePrefixes.ingot.get(Materials.Tin)});
        addShapelessCraftingRecipe(GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 4L, 120), tBitMask, new Object[]{ToolDictNames.craftingToolKnife, OrePrefixes.ingot.get(Materials.Steel)});
        addShapelessCraftingRecipe(GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 4L, 120), tBitMask, new Object[]{ToolDictNames.craftingToolKnife, OrePrefixes.ingot.get(Materials.Aluminium)});
        addShapelessCraftingRecipe(GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 2L, 120), tBitMask, new Object[]{ToolDictNames.craftingToolKnife, OrePrefixes.ingot.get(Materials.Lead)});
        addShapelessCraftingRecipe(GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 2L, 120), tBitMask, new Object[]{ToolDictNames.craftingToolKnife, OrePrefixes.ingot.get(Materials.Nickel)});
        addShapelessCraftingRecipe(GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 2L, 120), tBitMask, new Object[]{ToolDictNames.craftingToolKnife, OrePrefixes.ingot.get(Materials.Silver)});
        addShapelessCraftingRecipe(GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 3L, 120), tBitMask, new Object[]{ToolDictNames.craftingToolKnife, OrePrefixes.ingot.get(Materials.Brass)});
        addShapelessCraftingRecipe(GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 3L, 120), tBitMask, new Object[]{ToolDictNames.craftingToolKnife, OrePrefixes.ingot.get(Materials.Invar)});
        // --- Matter Cannon
        addCraftingRecipe(GT_ModHandler.getModItem(AE2, "item.ToolMassCannon", 1L, 0), tBitMask, new Object[]{"PPA", "BE ", "P  ", 'P', OrePrefixes.plate.get(Materials.VanadiumSteel), 'B', GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 38), 'A', GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 43), 'E', GT_ModHandler.getModItem(AE2, "tile.BlockDenseEnergyCell", 1L, 0)});
        // --- Memory Card
        addCraftingRecipe(GT_ModHandler.getModItem(AE2, "item.ToolMemoryCard", 1L, 0), tBitMask, new Object[]{"CPP", "GAG", 'P', OrePrefixes.plate.get(Materials.VanadiumSteel), 'G', OrePrefixes.plate.get(Materials.Gold), 'A', OrePrefixes.plate.get(Materials.RedAlloy), 'C', GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 23)});
        // --- Color Applicator
        addCraftingRecipe(GT_ModHandler.getModItem(AE2, "item.ToolColorApplicator", 1L, 0), tBitMask, new Object[]{"WAW", "TES", " I ", 'W', OrePrefixes.wireGt01.get(Materials.Aluminium), 'I', OrePrefixes.stick.get(Materials.Aluminium), 'S', GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 23), 'T', GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 35), 'A', GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 43), 'E', GT_ModHandler.getModItem(AE2, "tile.BlockEnergyCell", 1L, 0)});
        // --- Biometric Card
        addCraftingRecipe(GT_ModHandler.getModItem(AE2, "item.ToolBiometricCard", 1L, 0), tBitMask, new Object[]{"CPP", "GAG", 'P', OrePrefixes.plate.get(Materials.VanadiumSteel), 'G', OrePrefixes.plate.get(Materials.Gold), 'A', OrePrefixes.plate.get(Materials.RedAlloy), 'C', GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 24)});
        // --- Portable Cell
        addShapelessCraftingRecipe(GT_ModHandler.getModItem(AE2, "item.ToolPortableCell", 1L, 0), tBitMask, new Object[]{GT_ModHandler.getModItem(AE2, "tile.BlockChest", 1L, 0), GT_ModHandler.getModItem(AE2, "item.ItemBasicStorageCell.1k", 1L, 0), GT_ModHandler.getModItem(AE2, "tile.BlockDenseEnergyCell", 1L, 0)});
        // --- Slabs
        addCraftingRecipe(GT_ModHandler.getModItem(AE2, "tile.SkyStoneSlabBlock", 2L, 0), tBitMask, new Object[]{"sB", 'B', GT_ModHandler.getModItem(AE2, "tile.BlockSkyStone", 1L, 0)});
        addCraftingRecipe(GT_ModHandler.getModItem(AE2, "tile.SkyStoneBlockSlabBlock", 2L, 0), tBitMask, new Object[]{"sB", 'B', GT_ModHandler.getModItem(AE2, "tile.BlockSkyStone", 1L, 1)});
        addCraftingRecipe(GT_ModHandler.getModItem(AE2, "tile.SkyStoneBrickSlabBlock", 2L, 0), tBitMask, new Object[]{"sB", 'B', GT_ModHandler.getModItem(AE2, "tile.BlockSkyStone", 1L, 2)});
        addCraftingRecipe(GT_ModHandler.getModItem(AE2, "tile.SkyStoneSmallBrickSlabBlock", 2L, 0), tBitMask, new Object[]{"sB", 'B', GT_ModHandler.getModItem(AE2, "tile.BlockSkyStone", 1L, 3)});
        addCraftingRecipe(GT_ModHandler.getModItem(AE2, "tile.FluixSlabBlock", 2L, 0), tBitMask, new Object[]{"sB", 'B', GT_ModHandler.getModItem(AE2, "tile.BlockFluix", 1L, 0)});
        addCraftingRecipe(GT_ModHandler.getModItem(AE2, "tile.ChiseledQuartzSlabBlock", 2L, 0), tBitMask, new Object[]{"sB", 'B', GT_ModHandler.getModItem(AE2, "tile.BlockQuartzChiseled", 1L, 0)});
        addCraftingRecipe(GT_ModHandler.getModItem(AE2, "tile.QuartzPillarSlabBlock", 2L, 0), tBitMask, new Object[]{"sB", 'B', GT_ModHandler.getModItem(AE2, "tile.BlockQuartzPillar", 1L, 0)});
        addCraftingRecipe(GT_ModHandler.getModItem(AE2, "tile.QuartzSlabBlock", 2L, 0), tBitMask, new Object[]{"sB", 'B', GT_ModHandler.getModItem(AE2, "tile.BlockQuartz", 1L, 0)});
        // --- Spatial storage fix
        addShapelessCraftingRecipe(GT_ModHandler.getModItem(AE2, "item.ItemSpatialStorageCell.2Cubed", 1L, 0), tBitMask, new Object[]{GT_ModHandler.getModItem(AE2, "item.ItemSpatialStorageCell.2Cubed", 1L, 0)});
        addShapelessCraftingRecipe(GT_ModHandler.getModItem(AE2, "item.ItemSpatialStorageCell.16Cubed", 1L, 0), tBitMask, new Object[]{GT_ModHandler.getModItem(AE2, "item.ItemSpatialStorageCell.16Cubed", 1L, 0)});
        addShapelessCraftingRecipe(GT_ModHandler.getModItem(AE2, "item.ItemSpatialStorageCell.128Cubed", 1L, 0), tBitMask, new Object[]{GT_ModHandler.getModItem(AE2, "item.ItemSpatialStorageCell.128Cubed", 1L, 0)});
        // --- Illuminated Panel
        addCraftingRecipe(GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 1L, 180), tBitMask, new Object[]{"hVd", "SGS", "DPD", 'P', OrePrefixes.plate.get(Materials.Glowstone), 'V', OrePrefixes.plate.get(Materials.VanadiumSteel), 'S', OrePrefixes.screw.get(Materials.CertusQuartz), 'G', GT_ModHandler.getModItem(AE2, "tile.BlockQuartzGlass", 1L), 'D', "dustFluix"});
        addShapelessCraftingRecipe(GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 1L, 180), tBitMask, new Object[]{GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 1L, 160)});
        addShapelessCraftingRecipe(GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 1L, 180), tBitMask, new Object[]{GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 1L, 200)});
        // --- Blank Pattern
        addCraftingRecipe(GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 52), tBitMask, new Object[]{"WWW", "PCP", "PQP", 'P', OrePrefixes.plate.get(Materials.Plastic), 'W', OrePrefixes.wireFine.get(Materials.Tin), 'Q', OrePrefixes.gem.get(Materials.CertusQuartz), 'C', OrePrefixes.circuit.get(Materials.Basic)});
        addCraftingRecipe(GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 4L, 52), tBitMask, new Object[]{"WWW", "PCP", "PQP", 'P', OrePrefixes.plate.get(Materials.Plastic), 'W', OrePrefixes.wireFine.get(Materials.Electrum), 'Q', OrePrefixes.gem.get(Materials.CertusQuartz), 'C', OrePrefixes.circuit.get(Materials.Good)});
        addCraftingRecipe(GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 16L, 52), tBitMask, new Object[]{"WWW", "PCP", "PQP", 'P', OrePrefixes.plate.get(Materials.Plastic), 'W', OrePrefixes.wireFine.get(Materials.Platinum), 'Q', OrePrefixes.gem.get(Materials.CertusQuartz), 'C', OrePrefixes.circuit.get(Materials.Advanced)});
        // --- Energy Cell
        addCraftingRecipe(GT_ModHandler.getModItem(AE2, "tile.BlockEnergyCell", 1L, 0), tBitMask, new Object[]{"BPB", "PLP", "BPB", 'P', OrePrefixes.plate.get(Materials.VanadiumSteel), 'B', GT_ModHandler.getModItem(AE2, "tile.BlockFluix", 1L, 0), 'L', ItemList.Circuit_Parts_Crystal_Chip_Master});
        // --- Dense Energy Cell
        addCraftingRecipe(GT_ModHandler.getModItem(AE2, "tile.BlockDenseEnergyCell", 1L, 0), tBitMask, new Object[]{"BPB", "PLP", "BPB", 'P', OrePrefixes.plate.get(Materials.VanadiumGallium), 'B', GT_ModHandler.getModItem(AE2, "tile.BlockEnergyCell", 1L, 0), 'L', OrePrefixes.circuit.get(Materials.Elite)});
        // --- Annihilation Core
        addCraftingRecipe(GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 44), tBitMask, new Object[]{"SFh", "PCG", "SFd", 'P', OrePrefixes.plate.get(Materials.NetherQuartz), 'F', OrePrefixes.foil.get(Materials.VanadiumSteel), 'S', OrePrefixes.screw.get(Materials.Quartzite), 'C', GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 7), 'G', GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 22)});
        // --- Formation Core
        addCraftingRecipe(GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 43), tBitMask, new Object[]{"SFh", "PCG", "SFd", 'P', OrePrefixes.plate.get(Materials.CertusQuartz), 'F', OrePrefixes.foil.get(Materials.VanadiumSteel), 'S', OrePrefixes.screw.get(Materials.Quartzite), 'C', GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 7), 'G', GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 22)});
        // --- Wireless Access Point
        addCraftingRecipe(GT_ModHandler.getModItem(AE2, "tile.BlockWireless", 1L, 0), tBitMask, new Object[]{"SIS", "PCP", "dAw", 'P', OrePrefixes.plate.get(Materials.Vanadium), 'S', OrePrefixes.screw.get(Materials.Titanium), 'I', GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 41), 'C', GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 23), 'A', GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 1L, 16)});
        // --- Wireless Receiver
        addCraftingRecipe(GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 41), tBitMask, new Object[]{"EOE", "PIP", "PCP", 'P', OrePrefixes.plate.get(Materials.VanadiumSteel), 'I', OrePrefixes.stick.get(Materials.Grisium), 'C', OrePrefixes.circuit.get(Materials.Advanced), 'E', GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 1L, 140), 'O', GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 9)});
    
        // --- ME Fluid Terminal
        addCraftingRecipe(GT_ModHandler.getModItem("ae2fc", "part_fluid_terminal", 1L), tBitMask, new Object[]{"PAP", "FTY", "PAP", 'P', OrePrefixes.plate.get(Materials.Lapis), 'A', GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 1L, 16), 'F', GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 43), 'Y', GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 44), 'T', GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 1L, 380)});
        // --- Wireless Fluid Terminal
        addCraftingRecipe(GT_ModHandler.getModItem("ae2fc", "wireless_fluid_terminal", 1L), tBitMask,
                new Object[]{"FEF", "PMP", "PAP", 'P', OrePrefixes.plate.get(Materials.HastelloyN), 'A', GT_ModHandler.getModItem(AE2, "tile.BlockDenseEnergyCell", 1L), 'F', GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 41), 'M', GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 24), 'E', GT_ModHandler.getModItem("ae2fc", "part_fluid_terminal", 1)}
        );
        // --- ME Fluid Interface
        addShapelessCraftingRecipe(GT_ModHandler.getModItem("extracells", "part.base", 1L, 9), tBitMask, new Object[]{GT_ModHandler.getModItem("extracells", "ecbaseblock", 1L)});
        addShapelessCraftingRecipe(GT_ModHandler.getModItem("extracells", "ecbaseblock", 1L), tBitMask,
                new Object[]{GT_ModHandler.getModItem("extracells", "part.base", 1L, 9)}
        );
        // --- ME Block Container
        addCraftingRecipe(GT_ModHandler.getModItem(AE2, "item.ItemExtremeStorageCell.Container", 1L), tBitMask, new Object[]{" A ", "SBS", "dIw", 'S', OrePrefixes.screw.get(Materials.VanadiumSteel), 'A', GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 35), 'B', GT_ModHandler.getModItem(AE2, "tile.BlockChest", 1L), 'I', GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 39)});
        // --- ME Portable Fluid Storage
        addCraftingRecipe(GT_ModHandler.getModItem("ae2fc", "portable_fluid_cell", 1L), tBitMask, new Object[]{" A ", "SBS", "dIw", 'S', OrePrefixes.screw.get(Materials.VanadiumSteel), 'A', GT_ModHandler.getModItem("ae2fc", "fluid_part", 1L, 0), 'B', GT_ModHandler.getModItem(AE2, "tile.BlockChest", 1L), 'I', GT_ModHandler.getModItem(AE2, "tile.BlockEnergyCell", 1L)});

        // --- Certus Quartz Wrench
        addCraftingRecipe(GT_ModHandler.getModItem(AE2, "item.ToolCertusQuartzWrench", 1L, 0), tBitMask, new Object[]{"QwQ", "QQQ", " Q ", 'Q', "gemCertusQuartz"});
        // --- Nether Quartz Wrench
        addCraftingRecipe(GT_ModHandler.getModItem(AE2, "item.ToolNetherQuartzWrench", 1L, 0), tBitMask, new Object[]{"QwQ", "QQQ", " Q ", 'Q', "gemNetherQuartz"});
    
        // --- P2P Tunnels
        addCraftingRecipe(GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 1L, 470), tBitMask, new Object[]{"d  ", " O ", "   ", 'O', GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 1L, 460)});
        addCraftingRecipe(GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 1L, 462), tBitMask, new Object[]{" d ", " O ", "   ", 'O', GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 1L, 460)});
        addCraftingRecipe(GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 1L, 467), tBitMask, new Object[]{"  d", " O ", "   ", 'O', GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 1L, 460)});
        addCraftingRecipe(GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 1L, 463), tBitMask, new Object[]{"   ", " Od", "   ", 'O', GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 1L, 460)});
        addCraftingRecipe(GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 1L, 461), tBitMask, new Object[]{"   ", " O ", "  d", 'O', GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 1L, 460)});
        addCraftingRecipe(GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 1L, 468), tBitMask, new Object[]{"   ", " O ", " d ", 'O', GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 1L, 460)});

        // --- ME Fluid Auto Filler
        addCraftingRecipe(GT_ModHandler.getModItem("ae2fc", "fluid_auto_filler", 1L), tBitMask, new Object[]{"PMP", "CIC", "PRP", 'P', "plateLapis", 'M', GT_ModHandler.getModItem("ae2fc", "part_fluid_terminal", 1L), 'C', GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 1L, 16), 'R', GT_ModHandler.getModItem("ae2fc", "part_fluid_level_emitter", 1L), 'I', GT_ModHandler.getModItem("ae2fc", "fluid_interface", 1L)});

        //EC2 Part Fluid Import
        addShapelessCraftingRecipe(GT_ModHandler.getModItem("ae2fc", "part_fluid_import", 1),
                0, new Object[]{GT_ModHandler.getModItem("extracells", "part.base", 1, 1)}
        );
    
        //EC2 Part Fluid Export
        addShapelessCraftingRecipe(GT_ModHandler.getModItem("ae2fc", "part_fluid_export", 1),
                0, new Object[]{GT_ModHandler.getModItem("extracells", "part.base", 1, 0)}
        );
    
        //AE2FR Fluid Interface
        addShapelessCraftingRecipe(GT_ModHandler.getModItem("ae2fc", "part_fluid_interface", 1),
                0, new Object[]{GT_ModHandler.getModItem("ae2fc", "fluid_interface", 1)}
        );
        addShapelessCraftingRecipe(GT_ModHandler.getModItem("ae2fc", "part_fluid_interface", 1),
                0, new Object[]{GT_ModHandler.getModItem("extracells", "part.base", 1, 9)}
        );
    
        //AE2FR Fluid Interface
        addShapelessCraftingRecipe(GT_ModHandler.getModItem("ae2fc", "fluid_interface", 1),
                0, new Object[]{GT_ModHandler.getModItem("ae2fc", "part_fluid_interface", 1)}
        );
        addShapelessCraftingRecipe(GT_ModHandler.getModItem("ae2fc", "fluid_interface", 1),
                0, new Object[]{GT_ModHandler.getModItem("extracells", "ecbaseblock", 1)}
        );
		
		//Cell Components
		addShapelessCraftingRecipe(GT_ModHandler.getModItem("ae2fc", "fluid_part", 1, 0),
                0, new Object[]{GT_ModHandler.getModItem("extracells", "storage.component", 1, 4)}
        );
		addShapelessCraftingRecipe(GT_ModHandler.getModItem("ae2fc", "fluid_part", 1, 1),
                0, new Object[]{GT_ModHandler.getModItem("extracells", "storage.component", 1, 5)}
        );
		addShapelessCraftingRecipe(GT_ModHandler.getModItem("ae2fc", "fluid_part", 1, 2),
                0, new Object[]{GT_ModHandler.getModItem("extracells", "storage.component", 1, 6)}
        );
		addShapelessCraftingRecipe(GT_ModHandler.getModItem("ae2fc", "fluid_part", 1, 3),
                0, new Object[]{GT_ModHandler.getModItem("extracells", "storage.component", 1, 7)}
        );
		addShapelessCraftingRecipe(GT_ModHandler.getModItem("ae2fc", "fluid_part", 1, 4),
                0, new Object[]{GT_ModHandler.getModItem("extracells", "storage.component", 1, 8)}
        );
		addShapelessCraftingRecipe(GT_ModHandler.getModItem("ae2fc", "fluid_part", 1, 5),
                0, new Object[]{GT_ModHandler.getModItem("extracells", "storage.component", 1, 9)}
        );
		addShapelessCraftingRecipe(GT_ModHandler.getModItem("ae2fc", "fluid_part", 1, 6),
                0, new Object[]{GT_ModHandler.getModItem("extracells", "storage.component", 1, 10)}
        );

    }

    private void alloySmelterRecipe() {
        // --- Quartz Glass
        RA.addAlloySmelterRecipe(GT_ModHandler.getModItem("minecraft", "glass", 1L, 0), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.CertusQuartz, 1L), GT_ModHandler.getModItem(AE2, "tile.BlockQuartzGlass", 1L, 0), 100, 16);
        RA.addAlloySmelterRecipe(GT_ModHandler.getModItem("minecraft", "glass", 1L, 0), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.NetherQuartz, 1L), GT_ModHandler.getModItem(AE2, "tile.BlockQuartzGlass", 1L, 0), 100, 16);
        RA.addAlloySmelterRecipe(GT_ModHandler.getModItem("minecraft", "glass", 1L, 0), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Quartzite, 1L), GT_ModHandler.getModItem(AE2, "tile.BlockQuartzGlass", 1L, 0), 100, 16);
    
        // --- Quartz Tank
        RA.addAlloySmelterRecipe(GT_ModHandler.getModItem(AE2, "tile.BlockQuartzGlass", 8L), ItemList.Shape_Mold_Block.get(0), GT_ModHandler.getModItem("ae2fc", "certus_quartz_tank", 1L), 800, 30);
    
    }

    private void assemblerRecipe() {
        // --- Dark Illuminated Panel
        RA.addAssemblerRecipe(GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 1L, 180), GT_Utility.getIntegratedCircuit(2), GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 1L, 200), 100, 4);
        // --- Level Emitter
        RA.addAssemblerRecipe(GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 23), GT_ModHandler.getModItem("minecraft", "redstone_torch", 1L, 0), GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 1L, 280), 200, 30);
        // --- Dark Illuminated Panel
        RA.addAssemblerRecipe(GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 1L, 180), GT_Utility.getIntegratedCircuit(3), GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 1L, 160), 100, 4);
        // --- Fluix Glass Cable
        RA.addAssemblerRecipe(GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 2L, 140), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 3L, 8), GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 2L, 16), 200, 96);
        // --- Storage Cell Component - 1K
        RA.addAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Chip_Ram.get(4), CoreItems.getRecipe(38, 4), GT_ItemList.LogicProcessorItemGoldCore.get(1L), GT_Utility.getIntegratedCircuit(1)}, null, GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 35), 120, 480);
        RA.addAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Chip_NAND.get(3), CoreItems.getRecipe(38, 4), GT_ItemList.GoldCoreChip.get(1L), GT_Utility.getIntegratedCircuit(1)}, null, GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 35), 160, 1920);
        // --- Storage Cell Component - 4K
        RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Basic, 4), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 4L, 35), ItemList.Circuit_Chip_Ram.get(4), GT_ItemList.LogicProcessorItemGoldCore.get(1L), GT_Utility.getIntegratedCircuit(1)}, null, GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 36), 160, 480);
        RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Basic, 3), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 4L, 35), ItemList.Circuit_Chip_NAND.get(3), GT_ItemList.GoldCoreChip.get(1L), GT_Utility.getIntegratedCircuit(1)}, null, GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 36), 240, 1920);
        // --- Storage Cell Component - 16K
        RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Good, 4), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 4L, 36), ItemList.Circuit_Chip_Ram.get(4), GT_ItemList.EngineeringProcessorItemDiamondCore.get(1L), GT_Utility.getIntegratedCircuit(1)}, null, GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 37), 180, 1920);
        RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Good, 3), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 4L, 36), ItemList.Circuit_Chip_NAND.get(3), GT_ItemList.DiamondCoreChip.get(1L), GT_Utility.getIntegratedCircuit(1)}, null, GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 37), 260, 7680);
        RA.addAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Chip_Ram.get(32), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 32L, 8), ItemList.Circuit_Chip_SoC.get(1), GT_ItemList.DiamondCoreChip.get(1L), GT_Utility.getIntegratedCircuit(2)}, Materials.Europium.getMolten(36), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 37), 30, 30720);
        RA.addAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Chip_NAND.get(16), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 16L, 8), ItemList.Circuit_Chip_SoC2.get(1), GT_ItemList.EngravedDiamondCrystalChip.get(1L), GT_Utility.getIntegratedCircuit(2)}, Materials.Americium.getMolten(36), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 37), 30, 122880);
        // --- Storage Cell Component - 64K
        RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Advanced, 4), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 4L, 37), ItemList.Circuit_Chip_Ram.get(4), GT_ItemList.EngineeringProcessorItemDiamondCore.get(1L), GT_Utility.getIntegratedCircuit(1)}, null, GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 38), 200, 1920);
        RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Advanced, 3), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 4L, 37), ItemList.Circuit_Chip_NAND.get(3), GT_ItemList.DiamondCoreChip.get(1L), GT_Utility.getIntegratedCircuit(1)}, null, GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 38), 280, 7680);
        RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Advanced, 3), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 3L, 37), ItemList.Circuit_Chip_SoC.get(1), GT_ItemList.DiamondCoreChip.get(1L), GT_Utility.getIntegratedCircuit(2)}, Materials.Europium.getMolten(36), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 38), 30, 30720);
        RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Data, 1), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 2L, 37), ItemList.Circuit_Chip_SoC2.get(1), GT_ItemList.EngravedDiamondCrystalChip.get(1L), GT_Utility.getIntegratedCircuit(2)}, Materials.Americium.getMolten(36), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 38), 30, 122880);
        // --- 2 Spatial Component
        RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Niobium, 4), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 4L, 9), GT_ItemList.EngineeringProcessorSpatialPulsatingCore.get(1L), GT_Utility.getIntegratedCircuit(1)}, null, GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 32), 160, 1920);
        RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Niobium, 3), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 4L, 9), GT_ItemList.PulsatingSpatialCoreChip.get(1L), GT_Utility.getIntegratedCircuit(1)}, null, GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 32), 200, 7680);
        // --- 16 Spatial Component
        RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Data, 4), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 4L, 32), GT_ItemList.EngineeringProcessorSpatialPulsatingCore.get(1L), GT_Utility.getIntegratedCircuit(1)}, null, GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 33), 160, 1920);
        RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Data, 3), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 4L, 32), GT_ItemList.PulsatingSpatialCoreChip.get(1L), GT_Utility.getIntegratedCircuit(1)}, null, GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 33), 200, 7680);
        RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Data, 3), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 3L, 32), ItemList.Circuit_Chip_SoC.get(1), ItemList.Circuit_Parts_Crystal_Chip_Master.get(1L), GT_Utility.getIntegratedCircuit(2)}, Materials.Europium.getMolten(36), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 33), 30, 30720);
        // --- 128 Spatial Component
        RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Elite, 4), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 4L, 33), GT_ItemList.EngineeringProcessorSpatialPulsatingCore.get(1L), GT_Utility.getIntegratedCircuit(1)}, null, GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 34), 200, 7680);
        RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Elite, 3), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 4L, 33), GT_ItemList.PulsatingSpatialCoreChip.get(1L), GT_Utility.getIntegratedCircuit(1)}, null, GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 34), 240, 30720);
        RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Elite, 3), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 3L, 33), ItemList.Circuit_Chip_SoC.get(1), ItemList.Circuit_Parts_Crystal_Chip_Master.get(1L), GT_Utility.getIntegratedCircuit(2)}, Materials.Americium.getMolten(36), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 34), 30, 122880);
        // --- Storage Cells
        RA.addAssemblerRecipe(GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 39), GT_OreDictUnificator.get(OrePrefixes.gem, Materials.CertusQuartz, 1), GT_ModHandler.getModItem(AE2, "item.ItemViewCell", 1L), 100, 120);
    
		RA.addAssemblerRecipe(GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 39), GT_ModHandler.getModItem("ExtraUtilities", "trashcan", 1L), GT_ModHandler.getModItem(AE2, "item.ItemVoidStorageCell", 1L), 100, 120);
        RA.addAssemblerRecipe(GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 39), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 35), GT_ModHandler.getModItem(AE2, "item.ItemBasicStorageCell.1k", 1L), 100, 120);
        RA.addAssemblerRecipe(GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 39), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 36), GT_ModHandler.getModItem(AE2, "item.ItemBasicStorageCell.4k", 1L), 100, 256);
        RA.addAssemblerRecipe(GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 39), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 37), GT_ModHandler.getModItem(AE2, "item.ItemBasicStorageCell.16k", 1L), 100, 480);
        RA.addAssemblerRecipe(GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 39), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 38), GT_ModHandler.getModItem(AE2, "item.ItemBasicStorageCell.64k", 1L), 100, 1024);
    
        RA.addAssemblerRecipe(GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 39), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 32), GT_ModHandler.getModItem(AE2, "item.ItemSpatialStorageCell.2Cubed", 1L), 200, 4092);
        RA.addAssemblerRecipe(GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 39), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 33), GT_ModHandler.getModItem(AE2, "item.ItemSpatialStorageCell.16Cubed", 1L), 300, 7680);
        RA.addAssemblerRecipe(GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 39), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 34), GT_ModHandler.getModItem(AE2, "item.ItemSpatialStorageCell.128Cubed", 1L), 400, 16324);
        // --- CoCraftingUnit
        RA.addAssemblerRecipe(GT_ModHandler.getModItem(AE2, "tile.BlockCraftingUnit", 1L, 0), CoreItems2.getRecipe(203, 1), Materials.SolderingAlloy.getMolten(576), GT_ModHandler.getModItem(AE2, "tile.BlockCraftingUnit", 1L, 1), 800, 1020);
		RA.addAssemblerRecipe(GT_ModHandler.getModItem(AE2, "tile.BlockCraftingUnit", 1L, 0), CoreItems2.getRecipe(204, 1), Materials.SolderingAlloy.getMolten(1152), GT_ModHandler.getModItem(AE2, "tile.BlockCraftingUnit", 1L, 2), 1000, 4090);
		RA.addAssemblerRecipe(GT_ModHandler.getModItem(AE2, "tile.BlockCraftingUnit", 1L, 0), CoreItems2.getRecipe(205, 1), Materials.SolderingAlloy.getMolten(2304), GT_ModHandler.getModItem(AE2, "tile.BlockCraftingUnit", 1L, 3), 1200, 16350);
        RA.addAssemblerRecipe(GT_ModHandler.getModItem(AE2, "tile.BlockCraftingUnit", 1L, 0), CoreItems2.getRecipe(206, 1), Materials.SolderingAlloy.getMolten(4608), GT_ModHandler.getModItem(AE2, "tile.BlockAdvancedCraftingUnit", 1L, 0), 1400, 60570);
        RA.addAssemblerRecipe(GT_ModHandler.getModItem(AE2, "tile.BlockCraftingUnit", 1L, 0), CoreItems2.getRecipe(207, 1), Materials.SolderingAlloy.getMolten(9216), GT_ModHandler.getModItem(AE2, "tile.BlockAdvancedCraftingUnit", 1L, 1), 1600, 240630);
        RA.addAssemblerRecipe(GT_ModHandler.getModItem(AE2, "tile.BlockCraftingUnit", 1L, 0), CoreItems2.getRecipe(208, 1), Materials.SolderingAlloy.getMolten(18432), GT_ModHandler.getModItem(AE2, "tile.BlockAdvancedCraftingUnit", 1L, 2), 1800, 1034200);
        RA.addAssemblerRecipe(GT_ModHandler.getModItem(AE2, "tile.BlockCraftingUnit", 1L, 0), CoreItems2.getRecipe(209, 1), Materials.SolderingAlloy.getMolten(36864), GT_ModHandler.getModItem(AE2, "tile.BlockAdvancedCraftingUnit", 1L, 3), 2000, 4156390);

        // --- Crafting Monitor
        RA.addAssemblerRecipe(GT_ModHandler.getModItem(AE2, "tile.BlockCraftingUnit", 1L, 0), GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 1L, 400), Materials.SolderingAlloy.getMolten(576), GT_ModHandler.getModItem(AE2, "tile.BlockCraftingMonitor", 1L, 0), 200, 480);
        // --- CraftingStorages
        RA.addAssemblerRecipe(GT_ModHandler.getModItem(AE2, "tile.BlockCraftingUnit", 1L, 0), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 35), Materials.SolderingAlloy.getMolten(144), GT_ModHandler.getModItem(AE2, "tile.BlockCraftingStorage", 1L, 0), 1200, 64);
        RA.addAssemblerRecipe(GT_ModHandler.getModItem(AE2, "tile.BlockCraftingUnit", 1L, 0), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 36), Materials.SolderingAlloy.getMolten(576), GT_ModHandler.getModItem(AE2, "tile.BlockCraftingStorage", 1L, 1), 1200, 256);
        RA.addAssemblerRecipe(GT_ModHandler.getModItem(AE2, "tile.BlockCraftingUnit", 1L, 0), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 37), Materials.SolderingAlloy.getMolten(2304), GT_ModHandler.getModItem(AE2, "tile.BlockCraftingStorage", 1L, 2), 1200, 1024);
        RA.addAssemblerRecipe(GT_ModHandler.getModItem(AE2, "tile.BlockCraftingUnit", 1L, 0), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 38), Materials.SolderingAlloy.getMolten(9216), GT_ModHandler.getModItem(AE2, "tile.BlockCraftingStorage", 1L, 3), 1200, 4096);
        RA.addAssemblerRecipe(GT_ModHandler.getModItem(AE2, "tile.BlockCraftingUnit", 1L, 0), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 57), Materials.SolderingAlloy.getMolten(9216), GT_ModHandler.getModItem(AE2, "tile.BlockAdvancedCraftingStorage", 1L), 1200, 16384);
        RA.addAssemblerRecipe(GT_ModHandler.getModItem(AE2, "tile.BlockCraftingUnit", 1L, 0), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 58), Materials.SolderingAlloy.getMolten(18432), GT_ModHandler.getModItem(AE2, "tile.BlockAdvancedCraftingStorage", 1L, 1), 1200, 65536);
        RA.addAssemblerRecipe(GT_ModHandler.getModItem(AE2, "tile.BlockCraftingUnit", 1L, 0), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 59), Materials.SolderingAlloy.getMolten(36864), GT_ModHandler.getModItem(AE2, "tile.BlockAdvancedCraftingStorage", 1L, 2), 1200, 262144);
        RA.addAssemblerRecipe(GT_ModHandler.getModItem(AE2, "tile.BlockCraftingUnit", 1L, 0), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 60), Materials.SolderingAlloy.getMolten(36864), GT_ModHandler.getModItem(AE2, "tile.BlockAdvancedCraftingStorage", 1L, 3), 1200, 1048576);
    
        // --- Annihilation Core
        RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.plate, Materials.NetherQuartz, 1), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 12), GT_OreDictUnificator.get(OrePrefixes.foil, Materials.VanadiumSteel, 2), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 22), GT_Utility.getIntegratedCircuit(1)}, null, GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 44), 200, 7680);
        RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.stick, Materials.NetherQuartz, 1), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 12), GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Iridium, 1), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 22), GT_Utility.getIntegratedCircuit(2)}, null, GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 2L, 44), 100, 30720);
        RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.NetherQuartz, 1), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 12), GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Duranium, 1), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 22), GT_Utility.getIntegratedCircuit(3)}, null, GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 4L, 44), 50, 122880);
        RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.NetherQuartz, 1), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 12), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Neutronium, 1), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 22), GT_Utility.getIntegratedCircuit(4)}, null, GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 16L, 44), 20, 500000);
        // --- Formation Core
        RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.plate, Materials.CertusQuartz, 1), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 12), GT_OreDictUnificator.get(OrePrefixes.foil, Materials.VanadiumSteel, 2), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 22), GT_Utility.getIntegratedCircuit(1)}, null, GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 43), 200, 7680);
        RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.stick, Materials.CertusQuartz, 1), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 12), GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Iridium, 1), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 22), GT_Utility.getIntegratedCircuit(2)}, null, GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 2L, 43), 100, 30720);
        RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.CertusQuartz, 1), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 12), GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Duranium, 1), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 22), GT_Utility.getIntegratedCircuit(3)}, null, GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 4L, 43), 50, 122880);
        RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.CertusQuartz, 1), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 12), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Neutronium, 1), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 22), GT_Utility.getIntegratedCircuit(4)}, null, GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 16L, 43), 20, 500000);
        RA.addAssemblerRecipe(GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 22), GT_ItemList.GoldCoreChip.get(1L), GT_ItemList.LogicProcessorItemGoldCore.get(1L), 100, 480);
        RA.addAssemblerRecipe(GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 24), GT_ItemList.DiamondCoreChip.get(1L), GT_ItemList.EngineeringProcessorItemDiamondCore.get(1L), 100, 1920);
        RA.addAssemblerRecipe(GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 24), GT_ItemList.EmeraldAdvancedCoreChip.get(1L), GT_ItemList.EngineeringProcessorItemEmeraldCore.get(1L), 100, 4092);
        RA.addAssemblerRecipe(GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 24), GT_ItemList.EmeraldHighAdvancedCoreChip.get(1L), GT_ItemList.EngineeringProcessorItemAdvEmeraldCore.get(1L), 100, 30720);
    
        RA.addAssemblerRecipe(GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 24), GT_ItemList.GoldFluidCoreChip.get(1L), GT_ItemList.EngineeringProcessorFluidGoldCore.get(1L), 100, 480);
        RA.addAssemblerRecipe(GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 24), GT_ItemList.DiamondFluidCoreChip.get(1L), GT_ItemList.EngineeringProcessorFluidDiamondCore.get(1L), 100, 1920);
        RA.addAssemblerRecipe(GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 24), GT_ItemList.EmeraldAdvancedFluidCoreChip.get(1L), GT_ItemList.EngineeringProcessorFluidEmeraldCore.get(1L), 100, 4092);
    
        RA.addAssemblerRecipe(GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 24), GT_ItemList.PulsatingSpatialCoreChip.get(1L), GT_ItemList.EngineeringProcessorSpatialPulsatingCore.get(1L), 100, 4092);
    
        // --- Storage Cell Component - 256K
        RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Data, 4), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 4L, 38), ItemList.Circuit_Chip_NAND.get(4), GT_ItemList.EngineeringProcessorItemEmeraldCore.get(1L), GT_Utility.getIntegratedCircuit(1)}, null, GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 57), 200, 7680);
        RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Data, 3), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 4L, 38), ItemList.Circuit_Chip_NOR.get(3), GT_ItemList.EmeraldAdvancedCoreChip.get(1L), GT_Utility.getIntegratedCircuit(1)}, null, GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 57), 280, 30720);
    
        RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Data, 3), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 3L, 38), ItemList.Circuit_Chip_SoC2.get(1), GT_ItemList.EmeraldAdvancedCoreChip.get(1L), GT_Utility.getIntegratedCircuit(2)}, Materials.Americium.getMolten(36), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 57), 30, 122880);
        RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Elite, 1), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 2L, 38), ItemList.Circuit_Chip_SoC3.get(1), GT_ItemList.EngravedEnergyChip.get(1L), GT_Utility.getIntegratedCircuit(2)}, Materials.Neutronium.getMolten(36), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 57), 30, 500000);
    
        // --- Storage Cell Component - 1024K
        RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Elite, 4), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 4L, 57), ItemList.Circuit_Chip_NAND.get(4), GT_ItemList.EngineeringProcessorItemEmeraldCore.get(1L), GT_Utility.getIntegratedCircuit(1)}, null, GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 58), 220, 7680);
        RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Elite, 3), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 4L, 57), ItemList.Circuit_Chip_NOR.get(3), GT_ItemList.EmeraldAdvancedCoreChip.get(1L), GT_Utility.getIntegratedCircuit(1)}, null, GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 58), 300, 30720);
    
        RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Elite, 3), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 3L, 57), ItemList.Circuit_Chip_SoC2.get(1), GT_ItemList.EmeraldAdvancedCoreChip.get(1L), GT_Utility.getIntegratedCircuit(2)}, Materials.Americium.getMolten(36), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 58), 30, 122880);
        RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Master, 1), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 2L, 57), ItemList.Circuit_Chip_SoC3.get(1), GT_ItemList.EngravedEnergyChip.get(1L), GT_Utility.getIntegratedCircuit(2)}, Materials.Neutronium.getMolten(36), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 58), 30, 500000);
    
        // --- Storage Cell Component - 4096K
        RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Master, 4), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 4L, 58), ItemList.Circuit_Chip_NAND.get(4), GT_ItemList.EngineeringProcessorItemAdvEmeraldCore.get(1L), GT_Utility.getIntegratedCircuit(1)}, null, GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 59), 240, 30720);
        RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Master, 3), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 4L, 58), ItemList.Circuit_Chip_NOR.get(3), GT_ItemList.EmeraldHighAdvancedCoreChip.get(1L), GT_Utility.getIntegratedCircuit(1)}, null, GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 59), 320, 122880);

        RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Master, 3), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 3L, 58), ItemList.Circuit_Chip_SoC3.get(1), GT_ItemList.EmeraldHighAdvancedCoreChip.get(1L), GT_Utility.getIntegratedCircuit(2)}, Materials.Neutronium.getMolten(36), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 59), 30, 500000);
        RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Ultimate, 1), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 2L, 58), ItemList.Circuit_Chip_SoC4.get(1), GT_ItemList.EngravedQuantumChip.get(1L), GT_Utility.getIntegratedCircuit(2)}, Materials.Phoenixite.getMolten(36), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 59), 30, 2000000);

        // --- Storage Cell Component - 16384K
        RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Ultimate, 4), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 4L, 59), ItemList.Circuit_Chip_NAND.get(4), GT_ItemList.EngineeringProcessorItemAdvEmeraldCore.get(1L), GT_Utility.getIntegratedCircuit(1)}, null, GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 60), 260, 30720);
        RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Ultimate, 3), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 4L, 59), ItemList.Circuit_Chip_NOR.get(3), GT_ItemList.EmeraldHighAdvancedCoreChip.get(1L), GT_Utility.getIntegratedCircuit(1)}, null, GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 60), 340, 122880);

        RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Ultimate, 3), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 3L, 59), ItemList.Circuit_Chip_SoC3.get(1), GT_ItemList.EmeraldHighAdvancedCoreChip.get(1L), GT_Utility.getIntegratedCircuit(2)}, Materials.Neutronium.getMolten(36), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 60), 30, 500000);
        RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Superconductor, 1), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 2L, 59), ItemList.Circuit_Chip_SoC4.get(1), GT_ItemList.EngravedQuantumChip.get(1L), GT_Utility.getIntegratedCircuit(2)}, Materials.Phoenixite.getMolten(36), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 60), 30, 2000000);

        // --- Fluid Storage Cell Component - 1K
        RA.addAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Chip_Ram.get(4), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Lapis, 4), GT_ItemList.EngineeringProcessorFluidGoldCore.get(1L), GT_Utility.getIntegratedCircuit(1)}, null, GT_ModHandler.getModItem("ae2fc", "fluid_part", 1L), 120, 480);
        RA.addAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Chip_NAND.get(3), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Lapis, 4), GT_ItemList.GoldFluidCoreChip.get(1L), GT_Utility.getIntegratedCircuit(1)}, null, GT_ModHandler.getModItem("ae2fc", "fluid_part", 1L), 160, 1920);

        // --- Fluid Storage Cell Component - 4K
        RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Basic, 4), GT_ModHandler.getModItem("ae2fc", "fluid_part", 4L), ItemList.Circuit_Chip_Ram.get(4), GT_ItemList.EngineeringProcessorFluidGoldCore.get(1L), GT_Utility.getIntegratedCircuit(1)}, null, GT_ModHandler.getModItem("ae2fc", "fluid_part", 1L, 1), 160, 480);
        RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Basic, 3), GT_ModHandler.getModItem("ae2fc", "fluid_part", 4L), ItemList.Circuit_Chip_NAND.get(3), GT_ItemList.GoldFluidCoreChip.get(1L), GT_Utility.getIntegratedCircuit(1)}, null, GT_ModHandler.getModItem("ae2fc", "fluid_part", 1L, 1), 240, 1920);

        // --- Fluid Storage Cell Component - 16K
        RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Good, 4), GT_ModHandler.getModItem("ae2fc", "fluid_part", 4L, 1), ItemList.Circuit_Chip_Ram.get(4), GT_ItemList.EngineeringProcessorFluidDiamondCore.get(1L), GT_Utility.getIntegratedCircuit(1)}, null, GT_ModHandler.getModItem("ae2fc", "fluid_part", 1L, 2), 180, 1920);
        RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Good, 3), GT_ModHandler.getModItem("ae2fc", "fluid_part", 4L, 1), ItemList.Circuit_Chip_NAND.get(3), GT_ItemList.DiamondFluidCoreChip.get(1L), GT_Utility.getIntegratedCircuit(1)}, null, GT_ModHandler.getModItem("ae2fc", "fluid_part", 1L, 2), 260, 7680);

        RA.addAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Chip_Ram.get(32), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Lapis, 32), ItemList.Circuit_Chip_SoC.get(1), GT_ItemList.DiamondFluidCoreChip.get(1L), GT_Utility.getIntegratedCircuit(2)}, Materials.Europium.getMolten(36), GT_ModHandler.getModItem("ae2fc", "fluid_part", 1L, 2), 30, 30720);
        RA.addAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Chip_NAND.get(16), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Lapis, 16), ItemList.Circuit_Chip_SoC2.get(1), ItemList.Circuit_Parts_Crystal_Chip_Master.get(1L), GT_Utility.getIntegratedCircuit(2)}, Materials.Americium.getMolten(36), GT_ModHandler.getModItem("ae2fc", "fluid_part", 1L, 2), 30, 122880);

        // --- Fluid Storage Cell Component - 64K
        RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Advanced, 4), GT_ModHandler.getModItem("ae2fc", "fluid_part", 4L, 2), ItemList.Circuit_Chip_Ram.get(4), GT_ItemList.EngineeringProcessorFluidDiamondCore.get(1L), GT_Utility.getIntegratedCircuit(1)}, null, GT_ModHandler.getModItem("ae2fc", "fluid_part", 1L, 3), 200, 1920);
        RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Advanced, 3), GT_ModHandler.getModItem("ae2fc", "fluid_part", 4L, 2), ItemList.Circuit_Chip_NAND.get(3), GT_ItemList.DiamondFluidCoreChip.get(1L), GT_Utility.getIntegratedCircuit(1)}, null, GT_ModHandler.getModItem("ae2fc", "fluid_part", 1L, 3), 280, 7680);

        RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Advanced, 3), GT_ModHandler.getModItem("ae2fc", "fluid_part", 3L, 2), ItemList.Circuit_Chip_SoC.get(1), GT_ItemList.DiamondFluidCoreChip.get(1L), GT_Utility.getIntegratedCircuit(2)}, Materials.Europium.getMolten(36), GT_ModHandler.getModItem("ae2fc", "fluid_part", 1L, 3), 30, 30720);
        RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Data, 1), GT_ModHandler.getModItem("ae2fc", "fluid_part", 2L, 2), ItemList.Circuit_Chip_SoC2.get(1), ItemList.Circuit_Parts_Crystal_Chip_Master.get(1L), GT_Utility.getIntegratedCircuit(2)}, Materials.Americium.getMolten(36), GT_ModHandler.getModItem("ae2fc", "fluid_part", 1L, 3), 30, 122880);

        // --- Fluid Storage Cell Component - 256K
        RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Data, 4), GT_ModHandler.getModItem("ae2fc", "fluid_part", 4L, 3), ItemList.Circuit_Chip_NAND.get(4), GT_ItemList.EngineeringProcessorFluidEmeraldCore.get(1L), GT_Utility.getIntegratedCircuit(1)}, null, GT_ModHandler.getModItem("ae2fc", "fluid_part", 1L, 4), 200, 7680);
        RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Data, 3), GT_ModHandler.getModItem("ae2fc", "fluid_part", 4L, 3), ItemList.Circuit_Chip_NOR.get(3), GT_ItemList.EmeraldAdvancedFluidCoreChip.get(1L), GT_Utility.getIntegratedCircuit(1)}, null, GT_ModHandler.getModItem("ae2fc", "fluid_part", 1L, 4), 280, 30720);

        RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Data, 3), GT_ModHandler.getModItem("ae2fc", "fluid_part", 3L, 3), ItemList.Circuit_Chip_SoC2.get(1), GT_ItemList.EmeraldAdvancedFluidCoreChip.get(1L), GT_Utility.getIntegratedCircuit(2)}, Materials.Americium.getMolten(36), GT_ModHandler.getModItem("ae2fc", "fluid_part", 1L, 4), 30, 122880);
        RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Elite, 1), GT_ModHandler.getModItem("ae2fc", "fluid_part", 2L, 3), ItemList.Circuit_Chip_SoC3.get(1), ItemList.Circuit_Parts_Crystal_Chip_Master.get(1L), GT_Utility.getIntegratedCircuit(2)}, Materials.Neutronium.getMolten(36), GT_ModHandler.getModItem("ae2fc", "fluid_part", 1L, 4), 30, 500000);

        // --- Fluid Storage Cell Component - 1024K
        RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Elite, 4), GT_ModHandler.getModItem("ae2fc", "fluid_part", 4L, 4), ItemList.Circuit_Chip_NAND.get(4), GT_ItemList.EngineeringProcessorFluidEmeraldCore.get(1L), GT_Utility.getIntegratedCircuit(1)}, null, GT_ModHandler.getModItem("ae2fc", "fluid_part", 1L, 5), 220, 7680);
        RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Elite, 3), GT_ModHandler.getModItem("ae2fc", "fluid_part", 4L, 4), ItemList.Circuit_Chip_NOR.get(3), GT_ItemList.EmeraldAdvancedFluidCoreChip.get(1L), GT_Utility.getIntegratedCircuit(1)}, null, GT_ModHandler.getModItem("ae2fc", "fluid_part", 1L, 5), 300, 30720);

        RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Elite, 3), GT_ModHandler.getModItem("ae2fc", "fluid_part", 3L, 4), ItemList.Circuit_Chip_SoC2.get(1), GT_ItemList.EmeraldAdvancedFluidCoreChip.get(1L), GT_Utility.getIntegratedCircuit(2)}, Materials.Americium.getMolten(36), GT_ModHandler.getModItem("ae2fc", "fluid_part", 1L, 5), 30, 122880);
        RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Master, 1), GT_ModHandler.getModItem("ae2fc", "fluid_part", 2L, 4), ItemList.Circuit_Chip_SoC3.get(1), ItemList.Circuit_Parts_Crystal_Chip_Master.get(1L), GT_Utility.getIntegratedCircuit(2)}, Materials.Neutronium.getMolten(36), GT_ModHandler.getModItem("ae2fc", "fluid_part", 1L, 5), 30, 500000);

        // --- Fluid Storage Cell Component - 4096K
        RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Master, 4), GT_ModHandler.getModItem("ae2fc", "fluid_part", 4L, 5), ItemList.Circuit_Chip_NAND.get(4), GT_ItemList.EngineeringProcessorFluidEmeraldCore.get(1L), GT_Utility.getIntegratedCircuit(1)}, null, GT_ModHandler.getModItem("ae2fc", "fluid_part", 1L, 6), 240, 30720);
        RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Master, 3), GT_ModHandler.getModItem("ae2fc", "fluid_part", 4L, 5), ItemList.Circuit_Chip_NOR.get(3), GT_ItemList.EmeraldAdvancedFluidCoreChip.get(1L), GT_Utility.getIntegratedCircuit(1)}, null, GT_ModHandler.getModItem("ae2fc", "fluid_part", 1L, 6), 320, 122880);

        RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Master, 3), GT_ModHandler.getModItem("ae2fc", "fluid_part", 3L, 5), ItemList.Circuit_Chip_SoC3.get(1), GT_ItemList.EmeraldAdvancedFluidCoreChip.get(1L), GT_Utility.getIntegratedCircuit(2)}, Materials.Neutronium.getMolten(36), GT_ModHandler.getModItem("ae2fc", "fluid_part", 1L, 6), 30, 500000);
        RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Ultimate, 1), GT_ModHandler.getModItem("ae2fc", "fluid_part", 2L, 5), ItemList.Circuit_Chip_SoC4.get(1), ItemList.Circuit_Parts_Crystal_Chip_Master.get(1L), GT_Utility.getIntegratedCircuit(2)}, Materials.Phoenixite.getMolten(36), GT_ModHandler.getModItem("ae2fc", "fluid_part", 1L, 6), 30, 2000000);

        // --- Fluid Storage Cell Component - 16384K
        RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Ultimate, 4), GT_ModHandler.getModItem("ae2fc", "fluid_part", 4L, 6), ItemList.Circuit_Chip_NAND.get(4), GT_ItemList.EngineeringProcessorFluidEmeraldCore.get(1L), GT_Utility.getIntegratedCircuit(1)}, null, GT_ModHandler.getModItem("ae2fc", "fluid_part", 1L, 7), 240, 30720);
        RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Ultimate, 3), GT_ModHandler.getModItem("ae2fc", "fluid_part", 4L, 6), ItemList.Circuit_Chip_NOR.get(3), GT_ItemList.EmeraldAdvancedFluidCoreChip.get(1L), GT_Utility.getIntegratedCircuit(1)}, null, GT_ModHandler.getModItem("ae2fc", "fluid_part", 1L, 7), 320, 122880);

        RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Ultimate, 3), GT_ModHandler.getModItem("ae2fc", "fluid_part", 3L, 6), ItemList.Circuit_Chip_SoC3.get(1), GT_ItemList.EmeraldAdvancedFluidCoreChip.get(1L), GT_Utility.getIntegratedCircuit(2)}, Materials.Neutronium.getMolten(36), GT_ModHandler.getModItem("ae2fc", "fluid_part", 1L, 7), 30, 500000);
        RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Superconductor, 1), GT_ModHandler.getModItem("ae2fc", "fluid_part", 2L, 6), ItemList.Circuit_Chip_SoC4.get(1), ItemList.Circuit_Parts_Crystal_Chip_Master.get(1L), GT_Utility.getIntegratedCircuit(2)}, Materials.Phoenixite.getMolten(36), GT_ModHandler.getModItem("ae2fc", "fluid_part", 1L, 7), 30, 2000000);

        RA.addAssemblerRecipe(GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 61), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 57), GT_ModHandler.getModItem(AE2,"item.ItemAdvancedStorageCell.256k" , 1L), 100, 7680);
        RA.addAssemblerRecipe(GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 61), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 58), GT_ModHandler.getModItem(AE2, "item.ItemAdvancedStorageCell.1024k", 1L), 100, 16324);
        RA.addAssemblerRecipe(GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 61), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 59), GT_ModHandler.getModItem(AE2, "item.ItemAdvancedStorageCell.4096k", 1L), 100, 30720);
        RA.addAssemblerRecipe(GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 61), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 60), GT_ModHandler.getModItem(AE2, "item.ItemAdvancedStorageCell.16384k", 1L), 100, 65524);

        RA.addAssemblerRecipe(GT_ModHandler.getModItem("ae2fc", "fluid_storage_housing", 1L), GT_ModHandler.getModItem("ae2fc", "fluid_part", 1L), GT_ModHandler.getModItem("ae2fc", "fluid_storage1", 1L), 100, 120);
        RA.addAssemblerRecipe(GT_ModHandler.getModItem("ae2fc", "fluid_storage_housing", 1L), GT_ModHandler.getModItem("ae2fc", "fluid_part", 1L, 1), GT_ModHandler.getModItem("ae2fc", "fluid_storage4", 1L), 100, 250);
        RA.addAssemblerRecipe(GT_ModHandler.getModItem("ae2fc", "fluid_storage_housing", 1L), GT_ModHandler.getModItem("ae2fc", "fluid_part", 1L, 2), GT_ModHandler.getModItem("ae2fc", "fluid_storage16", 1L), 100, 480);
        RA.addAssemblerRecipe(GT_ModHandler.getModItem("ae2fc", "fluid_storage_housing", 1L), GT_ModHandler.getModItem("ae2fc", "fluid_part", 1L, 3), GT_ModHandler.getModItem("ae2fc", "fluid_storage64", 1L), 100, 1020);
        RA.addAssemblerRecipe(GT_ModHandler.getModItem("ae2fc", "fluid_storage_housing", 1L, 1), GT_ModHandler.getModItem("ae2fc", "fluid_part", 1L, 4), GT_ModHandler.getModItem("ae2fc", "fluid_storage256", 1L), 100, 7680);
        RA.addAssemblerRecipe(GT_ModHandler.getModItem("ae2fc", "fluid_storage_housing", 1L, 1), GT_ModHandler.getModItem("ae2fc", "fluid_part", 1L, 5), GT_ModHandler.getModItem("ae2fc", "fluid_storage1024", 1L), 100, 16324);
        RA.addAssemblerRecipe(GT_ModHandler.getModItem("ae2fc", "fluid_storage_housing", 1L, 1), GT_ModHandler.getModItem("ae2fc", "fluid_part", 1L, 6), GT_ModHandler.getModItem("ae2fc", "fluid_storage4096", 1L), 100, 30720);
        RA.addAssemblerRecipe(GT_ModHandler.getModItem("ae2fc", "fluid_storage_housing", 1L, 1), GT_ModHandler.getModItem("ae2fc", "fluid_part", 1L, 7), GT_ModHandler.getModItem("ae2fc", "fluid_storage16384", 1L), 100, 65524);

        RA.addAssemblerRecipe(GT_ModHandler.getModItem("ae2fc", "fluid_storage_housing", 1L, 2), GT_ModHandler.getModItem("ae2fc", "fluid_part", 1L), GT_ModHandler.getModItem("ae2fc", "multi_fluid_storage1", 1L), 100, 120);
        RA.addAssemblerRecipe(GT_ModHandler.getModItem("ae2fc", "fluid_storage_housing", 1L, 2), GT_ModHandler.getModItem("ae2fc", "fluid_part", 1L, 1), GT_ModHandler.getModItem("ae2fc", "multi_fluid_storage4", 1L), 100, 250);
        RA.addAssemblerRecipe(GT_ModHandler.getModItem("ae2fc", "fluid_storage_housing", 1L, 2), GT_ModHandler.getModItem("ae2fc", "fluid_part", 1L, 2), GT_ModHandler.getModItem("ae2fc", "multi_fluid_storage16", 1L), 100, 480);
        RA.addAssemblerRecipe(GT_ModHandler.getModItem("ae2fc", "fluid_storage_housing", 1L, 2), GT_ModHandler.getModItem("ae2fc", "fluid_part", 1L, 3), GT_ModHandler.getModItem("ae2fc", "multi_fluid_storage64", 1L), 100, 1020);
        RA.addAssemblerRecipe(GT_ModHandler.getModItem("ae2fc", "fluid_storage_housing", 1L, 3), GT_ModHandler.getModItem("ae2fc", "fluid_part", 1L, 4), GT_ModHandler.getModItem("ae2fc", "multi_fluid_storage256", 1L), 100, 7680);
        RA.addAssemblerRecipe(GT_ModHandler.getModItem("ae2fc", "fluid_storage_housing", 1L, 3), GT_ModHandler.getModItem("ae2fc", "fluid_part", 1L, 5), GT_ModHandler.getModItem("ae2fc", "multi_fluid_storage1024", 1L), 100, 16324);
        RA.addAssemblerRecipe(GT_ModHandler.getModItem("ae2fc", "fluid_storage_housing", 1L, 3), GT_ModHandler.getModItem("ae2fc", "fluid_part", 1L, 6), GT_ModHandler.getModItem("ae2fc", "multi_fluid_storage4096", 1L), 100, 30720);
        RA.addAssemblerRecipe(GT_ModHandler.getModItem("ae2fc", "fluid_storage_housing", 1L, 3), GT_ModHandler.getModItem("ae2fc", "fluid_part", 1L, 7), GT_ModHandler.getModItem("ae2fc", "multi_fluid_storage16384", 1L), 100, 65524);

        // --- Magnet
        RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.block, Materials.NeodymiumMagnetic, 2L), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 28), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 24), GT_OreDictUnificator.get(OrePrefixes.stickLong, Materials.HastelloyN, 8), GT_OreDictUnificator.get(OrePrefixes.screw, Materials.Inconel792, 24)}, null,
                GT_ModHandler.getModItem("ae2wct", "magnetCard", 1L, 0), 1000, 1920
        );
        // --- Booster
        RA.addAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 64L, 42), ItemList.Field_Generator_UV.get(1L), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.CinobiteA243, 16), GT_OreDictUnificator.get(OrePrefixes.stickLong, Materials.Quantium, 24), GT_OreDictUnificator.get(OrePrefixes.screw, Materials.Osmium, 64)}, null,
                GT_ModHandler.getModItem("ae2wct", "infinityBoosterCard", 1L, 0), 4000, 122880
        );

        // --- ME Fluid Pattern
        RA.addAssemblerRecipe(CoreItems2.getRecipe(201, 1),
                GT_ModHandler.getModItem("minecraft", "bucket", 1L),
                GT_ModHandler.getModItem("extracells", "pattern.fluid", 1L), 100, 120);
        // --- ME Fluid Level Emitter
        RA.addAssemblerRecipe(GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 1L, 280), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Lapis, 1), GT_ModHandler.getModItem("ae2fc", "part_fluid_level_emitter", 1L), 100, 120);
        // --- ME Fluid Annihilation Plane
        RA.addAssemblerRecipe(GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 1L, 300), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Lapis, 3), GT_ModHandler.getModItem("extracells", "part.base", 1L, 5), 300, 120);
        // --- ME Fluid Formation Plane
        RA.addAssemblerRecipe(GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 1L, 320), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Lapis, 3), GT_ModHandler.getModItem("extracells", "part.base", 1L, 6), 300, 120);
        // --- ME Drive Fixture
        RA.addAssemblerRecipe(GT_ModHandler.getModItem(AE2, "tile.BlockDrive", 1L), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.StainlessSteel, 1), GT_ModHandler.getModItem("extracells", "part.base", 1L, 7), 300, 120);
        // --- ME Energy Cell Fixture
        RA.addAssemblerRecipe(GT_ModHandler.getModItem(AE2, "tile.BlockEnergyCell", 1L), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.StainlessSteel, 1), GT_ModHandler.getModItem("extracells", "part.base", 1L, 8), 300, 120);

        // --- ME Storage Housing
        RA.addAssemblerRecipe(new ItemStack[]{
                GT_ModHandler.getModItem("minecraft", "glass_pane", 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.CertusQuartz, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.VanadiumSteel, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.StainlessSteel, 2),
                GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Quartzite, 2),
                GT_Utility.getIntegratedCircuit(10)}, null,
                GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 39), 200, 96);
        // --- Advanced Storage Housing
        RA.addAssemblerRecipe(
                new ItemStack[]{GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 39),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.ReinforcedGlass, 1),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.HastelloyC276, 1),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Iridium, 2),
                        GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.CertusQuartz, 2),
                        GT_Utility.getIntegratedCircuit(10)}, null,
                GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 61), 200, 96);
        // --- Fluid Storage Housing
        RA.addAssemblerRecipe(new ItemStack[]{
                        GT_ModHandler.getModItem("minecraft", "glass_pane", 1),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.CertusQuartz, 1),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.StainlessSteel, 1),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.RedSteel, 2),
                        GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.NetherQuartz, 2),
                        GT_Utility.getIntegratedCircuit(10)}, null,
                GT_ModHandler.getModItem("ae2fc", "fluid_storage_housing", 1L), 200, 96);
        // --- Advanced Fluid Storage Housing
        RA.addAssemblerRecipe(
                new ItemStack[]{GT_ModHandler.getModItem("ae2fc", "fluid_storage_housing", 1L),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.ReinforcedGlass, 1),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.HastelloyC276, 1),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Stellite, 2),
                        GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.CertusQuartz, 2),
                        GT_Utility.getIntegratedCircuit(10)}, null,
                GT_ModHandler.getModItem("ae2fc", "fluid_storage_housing", 1L, 1), 200, 96);
        // --- Multi-Fluid Storage Housing
        RA.addAssemblerRecipe(new ItemStack[]{
                        GT_ModHandler.getModItem("minecraft", "glass_pane", 1),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.CertusQuartz, 1),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.StainlessSteel, 1),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Birmabright, 2),
                        GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.NetherQuartz, 2),
                        GT_Utility.getIntegratedCircuit(10)}, null,
                GT_ModHandler.getModItem("ae2fc", "fluid_storage_housing", 1L, 2), 200, 96);
        // --- Advanced Multi-Fluid Storage Housing
        RA.addAssemblerRecipe(
                new ItemStack[]{GT_ModHandler.getModItem("ae2fc", "fluid_storage_housing", 1L, 2),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.ReinforcedGlass, 1),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.HastelloyC276, 1),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Grisium, 2),
                        GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.CertusQuartz, 2),
                        GT_Utility.getIntegratedCircuit(10)}, null,
                GT_ModHandler.getModItem("ae2fc", "fluid_storage_housing", 1L, 3), 200, 96);

        // --- ME Conversion Monitor
        RA.addAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 1L, 400), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 43), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 44), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.NetherQuartz, 2), GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.CertusQuartz, 2), GT_Utility.getIntegratedCircuit(10)}, null, GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 1L, 420), 200, 96);
        // --- ME Crafting Terminal
        RA.addAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 1L, 380), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 24), ItemList.Cover_Crafting.get(1), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.NetherQuartz, 2), GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.CertusQuartz, 2), GT_Utility.getIntegratedCircuit(10)}, null, GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 1L, 360), 200, 96);
        // --- ME Interface Terminal
        RA.addAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 1L, 380), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 24), GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 1L, 440), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.NetherQuartz, 2), GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.CertusQuartz, 2), GT_Utility.getIntegratedCircuit(10)}, null, GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 1L, 480), 200, 96);
        // --- ME Pattern Terminal
        RA.addAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 1L, 380), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 24), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 52), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.NetherQuartz, 2), GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.CertusQuartz, 2), GT_Utility.getIntegratedCircuit(10)}, null, GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 1L, 340), 200, 96);
        // --- ME Storage Monitor
        RA.addAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 1L, 180), GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 1L, 280), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.NetherQuartz, 3), GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.CertusQuartz, 2), GT_Utility.getIntegratedCircuit(10)}, null, GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 1L, 400), 200, 96);
        // --- ME Terminal
        RA.addAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 1L, 180), GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Good, 1), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.CertusQuartz, 1), GT_OreDictUnificator.get(OrePrefixes.stick, Materials.NetherQuartz, 4), GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Quartzite, 1), GT_Utility.getIntegratedCircuit(10)}, null, GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 1L, 380), 200, 96);
        // --- Illuminated Panel
        RA.addAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Glowstone, 1), GT_ModHandler.getModItem(AE2, "tile.BlockQuartzGlass", 1L), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.VanadiumSteel, 1), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 2L, 8), GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.CertusQuartz, 2), GT_Utility.getIntegratedCircuit(10)}, null, GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 1L, 180), 200, 96);

        // --- Wireless Fluid Pattern Terminal
        RA.addAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem(AE2, "item.ToolWirelessTerminal", 1L), GT_ModHandler.getModItem("ae2fc", "part_fluid_pattern_terminal", 1)}, null, GT_ModHandler.getModItem("ae2fc", "wireless_fluid_pattern_terminal", 1), 600, 120);
        // --- Wireless Interface Terminal
        RA.addAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem(AE2, "item.ToolWirelessTerminal", 1L), GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 1, 480)}, null, GT_ModHandler.getModItem("ae2fc", "wireless_interface_terminal", 1), 600, 120);

        // --- ME Fluid Conversion Monitor
        RA.addAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 1L, 420), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Lapis, 3)}, null, GT_ModHandler.getModItem("ae2fc", "part_fluid_conversion_monitor", 1), 300, 120);

    }

    private void autoclaveRecipe() {
        RA.addAutoclaveRecipe(CoreItems.getRecipe(38, 1), Materials.Water.getFluid(200L), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 1), 7000, 2000, 24);
        RA.addAutoclaveRecipe(CoreItems.getRecipe(38, 1), GT_ModHandler.getDistilledWater(1000), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 1), 9000, 1500, 24);
    }

    private void centrifugeRecipe() {
        // --- Tiny TNT
        RA.addCentrifugeRecipe(GT_ModHandler.getModItem("IC2", "blockITNT", 1L), GT_Values.NI, GT_Values.NF, GT_Values.NF, GT_ModHandler.getModItem(AE2, "tile.BlockTinyTNT", 1L), GT_ModHandler.getModItem(AE2, "tile.BlockTinyTNT", 1L), GT_Values.NI, GT_Values.NI, GT_Values.NI, GT_Values.NI, new int[]{10000, 10000}, 100, 16);
    }

    private void chemicalBathRecipe() {
        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < Dyes.VALUES[i].getSizeOfFluidList(); j++) {
                RA.addChemicalBathRecipe(GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 1L, 16), Dyes.VALUES[i].getFluidDye(j, 36L), GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 1L, 15 - i), GT_Values.NI, GT_Values.NI, null, 20, 2);
                RA.addChemicalBathRecipe(GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 1L, 36), Dyes.VALUES[i].getFluidDye(j, 36L), GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 1L, 35 - i), GT_Values.NI, GT_Values.NI, null, 20, 2);
                RA.addChemicalBathRecipe(GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 1L, 56), Dyes.VALUES[i].getFluidDye(j, 36L), GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 1L, 55 - i), GT_Values.NI, GT_Values.NI, null, 20, 2);
                RA.addChemicalBathRecipe(GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 1L, 76), Dyes.VALUES[i].getFluidDye(j, 36L), GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 1L, 75 - i), GT_Values.NI, GT_Values.NI, null, 20, 2);
				RA.addChemicalBathRecipe(GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 1L, 576), Dyes.VALUES[i].getFluidDye(j, 36L), GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 1L, 575 - i), GT_Values.NI, GT_Values.NI, null, 20, 2);
                RA.addChemicalBathRecipe(GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 6), Dyes.VALUES[i].getFluidDye(j, 36L), GT_ModHandler.getModItem(AE2, "item.ItemPaintBall", 1L, 15 - i), GT_Values.NI, GT_Values.NI, null, 20, 2);
                RA.addChemicalBathRecipe(GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 1L, 536), Dyes.VALUES[i].getFluidDye(j, 36L), GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 1L, 535 - i), GT_Values.NI, GT_Values.NI, null, 20, 2);
				RA.addChemicalBathRecipe(GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 1L, 556), Dyes.VALUES[i].getFluidDye(j, 36L), GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 1L, 555 - i), GT_Values.NI, GT_Values.NI, null, 20, 2);
            }
            RA.addChemicalBathRecipe(GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 1L, 15 - i), Materials.Chlorine.getGas(50L), GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 1L, 16), GT_Values.NI, GT_Values.NI, null, 20, 2);
            RA.addChemicalBathRecipe(GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 1L, 35 - i), Materials.Chlorine.getGas(50L), GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 1L, 36), GT_Values.NI, GT_Values.NI, null, 20, 2);
            RA.addChemicalBathRecipe(GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 1L, 55 - i), Materials.Chlorine.getGas(50L), GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 1L, 56), GT_Values.NI, GT_Values.NI, null, 20, 2);
            RA.addChemicalBathRecipe(GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 1L, 75 - i), Materials.Chlorine.getGas(50L), GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 1L, 76), GT_Values.NI, GT_Values.NI, null, 20, 2);
			RA.addChemicalBathRecipe(GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 1L, 575 - i), Materials.Chlorine.getGas(50L), GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 1L, 576), GT_Values.NI, GT_Values.NI, null, 20, 2);
            RA.addChemicalBathRecipe(GT_ModHandler.getModItem(AE2, "item.ItemPaintBall", 1L, 15 - i), Materials.Chlorine.getGas(50L), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 6), GT_Values.NI, GT_Values.NI, null, 20, 2);
			RA.addChemicalBathRecipe(GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 1L, 535 - i), Materials.Chlorine.getGas(50L), GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 1L, 536), GT_Values.NI, GT_Values.NI, null, 20, 2);
			RA.addChemicalBathRecipe(GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 1L, 555 - i), Materials.Chlorine.getGas(50L), GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 1L, 556), GT_Values.NI, GT_Values.NI, null, 20, 2);
        }
    }

    private void chemicalReactorRecipe() {
        // --- Seeds
        RA.addChemicalRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.CertusQuartz, 1L), GT_ModHandler.getModItem("minecraft", "sand", 1L, 0), null, null, GT_ModHandler.getModItem(AE2, "item.ItemCrystalSeed", 2L, 0), 100);
        RA.addChemicalRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.CertusQuartz, 1L), GT_ModHandler.getModItem("minecraft", "sand", 1L, 1), null, null, GT_ModHandler.getModItem(AE2, "item.ItemCrystalSeed", 2L, 0), 100);
        RA.addChemicalRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.NetherQuartz, 1L), GT_ModHandler.getModItem("minecraft", "sand", 1L, 0), null, null, GT_ModHandler.getModItem(AE2, "item.ItemCrystalSeed", 2L, 600), 100);
        RA.addChemicalRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.NetherQuartz, 1L), GT_ModHandler.getModItem("minecraft", "sand", 1L, 1), null, null, GT_ModHandler.getModItem(AE2, "item.ItemCrystalSeed", 2L, 600), 100);
        RA.addChemicalRecipe(GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 8), GT_ModHandler.getModItem("minecraft", "sand", 1L, 0), null, null, GT_ModHandler.getModItem(AE2, "item.ItemCrystalSeed", 2L, 1200), 100);
        RA.addChemicalRecipe(GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 8), GT_ModHandler.getModItem("minecraft", "sand", 1L, 1), null, null, GT_ModHandler.getModItem(AE2, "item.ItemCrystalSeed", 2L, 1200), 100);
        RA.addChemicalRecipe(CoreItems.getRecipe(38, 3), Materials.Sodium.getDust(1), Materials.Water.getFluid(1000L), null, GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 3L, 1), 500);
    
    }

    private void compressorRecipe() {
        RA.addCompressorRecipe(GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 4L, 7), GT_ModHandler.getModItem(AE2, "tile.BlockFluix", 1L), 200, 8);
    }

    private void cuttingSawRecipe() {
        RA.addCutterRecipe(GT_ModHandler.getModItem(AE2, "tile.BlockSkyStone", 1L, 0), GT_ModHandler.getModItem(AE2, "tile.SkyStoneSlabBlock", 2L, 0), GT_Values.NI, 50, 30);
        RA.addCutterRecipe(GT_ModHandler.getModItem(AE2, "tile.BlockSkyStone", 1L, 1), GT_ModHandler.getModItem(AE2, "tile.SkyStoneBlockSlabBlock", 2L, 0), GT_Values.NI, 50, 30);
        RA.addCutterRecipe(GT_ModHandler.getModItem(AE2, "tile.BlockSkyStone", 1L, 2), GT_ModHandler.getModItem(AE2, "tile.SkyStoneBrickSlabBlock", 2L, 0), GT_Values.NI, 50, 30);
        RA.addCutterRecipe(GT_ModHandler.getModItem(AE2, "tile.BlockSkyStone", 1L, 3), GT_ModHandler.getModItem(AE2, "tile.SkyStoneSmallBrickSlabBlock", 2L, 0), GT_Values.NI, 50, 30);
        RA.addCutterRecipe(GT_ModHandler.getModItem(AE2, "tile.BlockFluix", 1L, 0), GT_ModHandler.getModItem(AE2, "tile.FluixSlabBlock", 2L, 0), GT_Values.NI, 50, 30);
        RA.addCutterRecipe(GT_ModHandler.getModItem(AE2, "tile.BlockQuartzChiseled", 1L, 0), GT_ModHandler.getModItem(AE2, "tile.ChiseledQuartzSlabBlock", 2L, 0), GT_Values.NI, 50, 30);
        RA.addCutterRecipe(GT_ModHandler.getModItem(AE2, "tile.BlockQuartzPillar", 1L, 0), GT_ModHandler.getModItem(AE2, "tile.QuartzPillarSlabBlock", 2L, 0), GT_Values.NI, 50, 30);
        RA.addCutterRecipe(GT_ModHandler.getModItem(AE2, "tile.BlockQuartz", 1L, 0), GT_ModHandler.getModItem(AE2, "tile.QuartzSlabBlock", 2L, 0), GT_Values.NI, 50, 30);
    
        RA.addCutterRecipe(GT_ModHandler.getModItem("minecraft", "stone_slab", 1L, 7), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.NetherQuartz, 2L), GT_Values.NI, 200, 30);
        RA.addCutterRecipe(GT_ModHandler.getModItem(AE2, "tile.QuartzSlabBlock", 1L, 0), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.CertusQuartz, 2L), GT_Values.NI, 200, 30);
    
        RA.addCutterRecipe(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Iron, 1L), GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 4L, 120), GT_Values.NI, 80, 8);
        RA.addCutterRecipe(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Copper, 1L), GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 4L, 120), GT_Values.NI, 80, 8);
        RA.addCutterRecipe(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Bronze, 1L), GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 6L, 120), GT_Values.NI, 80, 8);
        RA.addCutterRecipe(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Tin, 1L), GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 4L, 120), GT_Values.NI, 80, 8);
        RA.addCutterRecipe(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Steel, 1L), GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 8L, 120), GT_Values.NI, 80, 8);
        RA.addCutterRecipe(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Aluminium, 1L), GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 8L, 120), GT_Values.NI, 80, 8);
        RA.addCutterRecipe(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Lead, 1L), GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 4L, 120), GT_Values.NI, 80, 8);
        RA.addCutterRecipe(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Nickel, 1L), GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 4L, 120), GT_Values.NI, 80, 8);
        RA.addCutterRecipe(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Silver, 1L), GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 4L, 120), GT_Values.NI, 80, 8);
        RA.addCutterRecipe(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Brass, 1L), GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 6L, 120), GT_Values.NI, 80, 8);
        RA.addCutterRecipe(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Invar, 1L), GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 6L, 120), GT_Values.NI, 80, 8);
    }

    private void printerRecipe() {
        //CraftingUnit
        RA.addPrimitiveLineRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.VanadiumSteel, 1),
                /*GT_ModHandler.getModItem("OpenComputers", "item", 1, 29), */
                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Data, 1), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 4, 23)
/*Processor*/, GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Platinum, 4), GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 4, 56), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.VanadiumSteel, 12)}, GT_ModHandler.getModItem(AE2, "tile.BlockCraftingUnit", 1, 0), null, 30 * 20, 1920);
    
        //Energy Acceptor
        RA.addPrimitiveLineRecipe(new ItemStack[]{GT_ModHandler.getModItem(AE2, "tile.BlockEnergyCell", 1, 0), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.EnergeticAlloy, 2), GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Advanced, 2), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 4, 7)/*crystal*/, GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 4, 24), GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Vanadium, 4), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.VanadiumSteel, 8)}, GT_ModHandler.getModItem(AE2, "tile.BlockEnergyAcceptor", 1, 0), null, 200, 480);
    }

    private void pulveriserRecipe() {
        RA.addPulveriserRecipe(GT_ModHandler.getModItem(AE2, "tile.BlockFluix", 1L), new ItemStack[]{GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 4L, 7)}, new int[]{10000}, 300, 2);
        RA.addPulveriserRecipe(GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 1), new ItemStack[]{CoreItems.getRecipe(38, 1)}, new int[]{10000}, 300, 2);
    }

    private void wireAssemblerRecipe() {
        // --- Covered Smart Cable
        RA.addWireAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 1L, 16), GT_Utility.getIntegratedCircuit(24)}, Materials.Silicone.getMolten(72), GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 1L, 36), 100, 8, false);
        RA.addWireAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 1L, 16), GT_Utility.getIntegratedCircuit(24)}, Materials.StyreneButadieneRubber.getMolten(108), GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 1L, 36), 100, 8, false);
        RA.addWireAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 1L, 16), GT_Utility.getIntegratedCircuit(24)}, Materials.Rubber.getMolten(144), GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 1L, 36), 100, 8, false);
        RA.addWireAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 4L, 16), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Polydimethylsiloxane, 1L)}, Materials.StyreneButadieneRubber.getMolten(144), GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 4L, 36), 100, 8, false);
        RA.addWireAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 4L, 16), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.PolyvinylChloride, 1L)}, Materials.StyreneButadieneRubber.getMolten(144), GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 4L, 36), 100, 8, false);
        RA.addWireAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 4L, 16), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Polydimethylsiloxane, 1L)}, Materials.Silicone.getMolten(144), GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 4L, 36), 100, 8, false);
        RA.addWireAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 4L, 16), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.PolyvinylChloride, 1L)}, Materials.Silicone.getMolten(144), GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 4L, 36), 100, 8, false);
        // --- Dense Cable
        RA.addWireAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 4L, 56), GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Vanadium, 2L), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.EnergeticAlloy, 2L)}, null, GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 1L, 76), 200, 480, false);
        // --- Backbone Cable
        RA.addWireAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 4L, 76), GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Palladium, 2L), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.VibrantAlloy, 2L)}, null, GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 1L, 576), 300, 1920, false);
		// --- Smart Cable
        RA.addWireAssemblerRecipe(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Silicon, 2L), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.RedAlloy, 1L), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Electrum, 1L), GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 1L, 36)}, null, GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 1L, 56), 100, 120, false);
        // --- Covered Dense Cable
        RA.addWireAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 1L, 76), GT_OreDictUnificator.get(OrePrefixes.foil, Materials.PolyphenyleneSulfide, 2), GT_Utility.getIntegratedCircuit(24)}, Materials.Silicone.getMolten(144), GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 1L, 536), 100, 8, false);
        RA.addWireAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 2L, 76), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.PolyvinylChloride, 1), GT_OreDictUnificator.get(OrePrefixes.foil, Materials.PolyphenyleneSulfide, 4)}, Materials.StyreneButadieneRubber.getMolten(144), GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 2L, 536), 200, 8, false);
        RA.addWireAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 2L, 76), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.PolyvinylChloride, 1), GT_OreDictUnificator.get(OrePrefixes.foil, Materials.PolyphenyleneSulfide, 4)}, Materials.Silicone.getMolten(144), GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 2L, 536), 200, 8, false);
        RA.addWireAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 2L, 76), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Polydimethylsiloxane, 1), GT_OreDictUnificator.get(OrePrefixes.foil, Materials.PolyphenyleneSulfide, 4)}, Materials.StyreneButadieneRubber.getMolten(144), GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 2L, 536), 200, 8, false);
        RA.addWireAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 2L, 76), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Polydimethylsiloxane, 1), GT_OreDictUnificator.get(OrePrefixes.foil, Materials.PolyphenyleneSulfide, 4)}, Materials.Silicone.getMolten(144), GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 2L, 536), 200, 8, false);
		// --- Covered Backbone Cable
        RA.addWireAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 1L, 576), GT_OreDictUnificator.get(OrePrefixes.foil, Materials.PolyphenyleneSulfide, 2), GT_Utility.getIntegratedCircuit(24)}, Materials.Silicone.getMolten(144), GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 1L, 556), 100, 8, false);
        RA.addWireAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 2L, 576), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.PolyvinylChloride, 1), GT_OreDictUnificator.get(OrePrefixes.foil, Materials.PolyphenyleneSulfide, 4)}, Materials.StyreneButadieneRubber.getMolten(144), GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 2L, 556), 200, 8, false);
        RA.addWireAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 2L, 576), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.PolyvinylChloride, 1), GT_OreDictUnificator.get(OrePrefixes.foil, Materials.PolyphenyleneSulfide, 4)}, Materials.Silicone.getMolten(144), GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 2L, 556), 200, 8, false);
        RA.addWireAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 2L, 576), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Polydimethylsiloxane, 1), GT_OreDictUnificator.get(OrePrefixes.foil, Materials.PolyphenyleneSulfide, 4)}, Materials.StyreneButadieneRubber.getMolten(144), GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 2L, 556), 200, 8, false);
        RA.addWireAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 2L, 576), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Polydimethylsiloxane, 1), GT_OreDictUnificator.get(OrePrefixes.foil, Materials.PolyphenyleneSulfide, 4)}, Materials.Silicone.getMolten(144), GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 2L, 556), 200, 8, false);
    }

    private void unboxingRecipe() {
        RA.addUnboxingRecipe(GT_ModHandler.getModItem(AE2, "tile.BlockCraftingStorage", 1L, 0), GT_ModHandler.getModItem(AE2, "tile.BlockCraftingUnit", 1L, 0), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 35), 50, 15);
        RA.addUnboxingRecipe(GT_ModHandler.getModItem(AE2, "tile.BlockCraftingStorage", 1L, 1), GT_ModHandler.getModItem(AE2, "tile.BlockCraftingUnit", 1L, 0), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 36), 50, 30);
        RA.addUnboxingRecipe(GT_ModHandler.getModItem(AE2, "tile.BlockCraftingStorage", 1L, 2), GT_ModHandler.getModItem(AE2, "tile.BlockCraftingUnit", 1L, 0), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 37), 50, 48);
        RA.addUnboxingRecipe(GT_ModHandler.getModItem(AE2, "tile.BlockCraftingStorage", 1L, 3), GT_ModHandler.getModItem(AE2, "tile.BlockCraftingUnit", 1L, 0), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 38), 50, 60);
        RA.addUnboxingRecipe(GT_ModHandler.getModItem(AE2, "tile.BlockAdvancedCraftingStorage", 1L, 0), GT_ModHandler.getModItem(AE2, "tile.BlockCraftingUnit", 1L, 0), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 57), 50, 96);
        RA.addUnboxingRecipe(GT_ModHandler.getModItem(AE2, "tile.BlockAdvancedCraftingStorage", 1L, 1), GT_ModHandler.getModItem(AE2, "tile.BlockCraftingUnit", 1L, 0), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 58), 50, 120);
        RA.addUnboxingRecipe(GT_ModHandler.getModItem(AE2, "tile.BlockAdvancedCraftingStorage", 1L, 2), GT_ModHandler.getModItem(AE2, "tile.BlockCraftingUnit", 1L, 0), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 59), 50, 192);
        RA.addUnboxingRecipe(GT_ModHandler.getModItem(AE2, "tile.BlockAdvancedCraftingStorage", 1L, 3), GT_ModHandler.getModItem(AE2, "tile.BlockCraftingUnit", 1L, 0), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 60), 50, 250);

        RA.addUnboxingRecipe(GT_ModHandler.getModItem(AE2, "tile.BlockCraftingUnit", 1L, 1), GT_ModHandler.getModItem(AE2, "tile.BlockCraftingUnit", 1L, 0), CoreItems2.getRecipe(203, 1), 50, 15);
        RA.addUnboxingRecipe(GT_ModHandler.getModItem(AE2, "tile.BlockCraftingUnit", 1L, 2), GT_ModHandler.getModItem(AE2, "tile.BlockCraftingUnit", 1L, 0), CoreItems2.getRecipe(204, 1), 50, 30);
        RA.addUnboxingRecipe(GT_ModHandler.getModItem(AE2, "tile.BlockCraftingUnit", 1L, 3), GT_ModHandler.getModItem(AE2, "tile.BlockCraftingUnit", 1L, 0), CoreItems2.getRecipe(205, 1), 50, 48);
        RA.addUnboxingRecipe(GT_ModHandler.getModItem(AE2, "tile.BlockAdvancedCraftingUnit", 1L, 0), GT_ModHandler.getModItem(AE2, "tile.BlockCraftingUnit", 1L, 0), CoreItems2.getRecipe(206, 1), 50, 60);
        RA.addUnboxingRecipe(GT_ModHandler.getModItem(AE2, "tile.BlockAdvancedCraftingUnit", 1L, 1), GT_ModHandler.getModItem(AE2, "tile.BlockCraftingUnit", 1L, 0), CoreItems2.getRecipe(207, 1), 50, 96);
        RA.addUnboxingRecipe(GT_ModHandler.getModItem(AE2, "tile.BlockAdvancedCraftingUnit", 1L, 2), GT_ModHandler.getModItem(AE2, "tile.BlockCraftingUnit", 1L, 0), CoreItems2.getRecipe(208, 1), 50, 120);
        RA.addUnboxingRecipe(GT_ModHandler.getModItem(AE2, "tile.BlockAdvancedCraftingUnit", 1L, 3), GT_ModHandler.getModItem(AE2, "tile.BlockCraftingUnit", 1L, 0), CoreItems2.getRecipe(209, 1), 50, 192);

    }

    private void mixerRecipe() {
        RA.addMixerRecipe(CoreItems.getRecipe(38, 1), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Redstone, 1L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.NetherQuartz, 1L), GT_Values.NI, Materials.Water.getFluid(500L), GT_Values.NF, GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 2L, 8), 20, 16);
        RA.addMixerRecipe(CoreItems.getRecipe(38, 1), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Redstone, 1L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.NetherQuartz, 1L), GT_Values.NI, GT_ModHandler.getDistilledWater(500), GT_Values.NF, GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 2L, 8), 20, 16);
    }

    private void latheRecipe() {
        RA.addLatheRecipe(GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1L, 1), CoreItems2.getRecipe(153, 1), CoreItems.getRecipe(38, 1), new int[]{10000, 5000}, 480, 16);
    }

    private void fluidSolidifierRecipe() {
        // --- Quartz Fiber
        RA.addFluidSolidifierRecipe(GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Quartzite, 1L), Materials.BorosilicateGlass.getMolten(18L), GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 1L, 140), 60, 120);
        RA.addFluidSolidifierRecipe(GT_OreDictUnificator.get(OrePrefixes.stick, Materials.NetherQuartz, 1L), Materials.BorosilicateGlass.getMolten(36L), GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 2L, 140), 80, 120);
        RA.addFluidSolidifierRecipe(GT_OreDictUnificator.get(OrePrefixes.stick, Materials.CertusQuartz, 1L), Materials.BorosilicateGlass.getMolten(72L), GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 4L, 140), 100, 120);
        RA.addFluidSolidifierRecipe(CoreItems2.getRecipe(153, 1), Materials.BorosilicateGlass.getMolten(144L), GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 8L, 140), 120, 120);
    
    }

    private void meSystemProvider() {
        //Fluid Descretizer
        impact.I_RA.addMESPRecipes(new ItemStack[]{
                GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.VanadiumSteel, 1),
                ItemList.Electric_Pump_EV.get(1),
                GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 2, 220),
				GT_ItemList.EngineeringProcessorFluidDiamondCore.get(2),
				GT_OreDictUnificator.get(OrePrefixes.plate, Materials.MaragingSteel300, 4)
        }, GT_ModHandler.getModItem("ae2fc", "fluid_discretizer", 1L), 40 * 20, 7680, 1000);
    
        //Fluid Pattern Encoder
        impact.I_RA.addMESPRecipes(new ItemStack[]{
                GT_ModHandler.getModItem("ae2stuff", "Encoder", 1),
                ItemList.Machine_HV_Assembler.get(1),
                GT_ItemList.EngineeringProcessorFluidDiamondCore.get(2),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Lapis, 2),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.MaragingSteel300, 4)
        }, GT_ModHandler.getModItem("ae2fc", "fluid_pattern_encoder", 1L), 40 * 20, 7680, 2000);
    
        //ME Fluid Packet Decoder
        impact.I_RA.addMESPRecipes(new ItemStack[]{
                GT_ModHandler.getModItem(AE2, "tile.BlockCellWorkbench", 1),
                ItemList.Machine_HV_Disassembler.get(1),
                GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 2, 24) /*Diamond*/,
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Lapis, 2),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.MaragingSteel300, 4)
        }, GT_ModHandler.getModItem("ae2fc", "fluid_packet_decoder", 1L), 40 * 20, 7680, 1000);
    
        //ME Dual Interface
        impact.I_RA.addMESPRecipes(new ItemStack[]{ItemList.Electric_Pump_HV.get(1L), GT_ItemList.EngineeringProcessorFluidGoldCore.get(2), GT_ModHandler.getModItem(AE2, "tile.BlockInterface", 1), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.MaragingSteel300, 4)}, GT_ModHandler.getModItem("ae2fc", "fluid_interface", 1, 0), 100, 1920, 500);
        impact.I_RA.addMESPRecipes(new ItemStack[]{ItemList.Electric_Pump_EV.get(1L), GT_ItemList.EngineeringProcessorFluidDiamondCore.get(2), GT_ModHandler.getModItem(AE2, "tile.BlockInterface", 2), GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.MaragingSteel300, 4)}, GT_ModHandler.getModItem("ae2fc", "fluid_interface", 2, 0), 200, 7680, 1000);
        impact.I_RA.addMESPRecipes(new ItemStack[]{ItemList.Electric_Pump_IV.get(1L), GT_ItemList.EngineeringProcessorFluidEmeraldCore.get(2), GT_ModHandler.getModItem(AE2, "tile.BlockInterface", 4), GT_OreDictUnificator.get(OrePrefixes.plateTriple, Materials.MaragingSteel300, 4)}, GT_ModHandler.getModItem("ae2fc", "fluid_interface", 4, 0), 300, 30720, 2000);

        //Ingredient Buffer
        impact.I_RA.addMESPRecipes(new ItemStack[]{
                GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.VanadiumSteel, 1),
				GT_ModHandler.getModItem(AE2, "tile.BlockCellWorkbench", 1),
				ItemList.Electric_Pump_EV.get(2),
                GT_ItemList.EngineeringProcessorFluidDiamondCore.get(2),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.MaragingSteel300, 4)
        }, GT_ModHandler.getModItem("ae2fc", "ingredient_buffer", 1L), 30 * 20, 1920, 1000);
    
        //Large Ingredient Buffer
        impact.I_RA.addMESPRecipes(new ItemStack[]{
                GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.TungstenSteel, 1),
				GT_ModHandler.getModItem("ae2fc", "ingredient_buffer", 1L),
				ItemList.Electric_Pump_IV.get(2),
                GT_ItemList.EngineeringProcessorFluidEmeraldCore.get(2),
                GT_OreDictUnificator.get(OrePrefixes.plateDense, Materials.MaragingSteel300, 4)
        }, GT_ModHandler.getModItem("ae2fc", "large_ingredient_buffer", 1L), 60 * 20, 7680, 4000);

        //ME Fluid Buffer
        impact.I_RA.addMESPRecipes(new ItemStack[]{
                GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.MaragingSteel300, 1),
                GT_ModHandler.getModItem("ae2fc", "ingredient_buffer", 1L),
                GT_ItemList.EngineeringProcessorFluidDiamondCore.get(2)
        }, GT_ModHandler.getModItem("ae2fc", "fluid_buffer", 1L), 40 * 20, 3750, 2000);

        //OC Pattern Editor
        impact.I_RA.addMESPRecipes(new ItemStack[]{
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.MaragingSteel300, 4),
                GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1, 52),
                ItemList.Electric_Pump_EV.get(1),
                RecipeUtils.ordictItemStack("oc:circuitChip3"),
                RecipeUtils.ordictItemStack("oc:cable", 2),
                GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1, 23) /*Quartz*/,
        }, GT_ModHandler.getModItem("ae2fc", "oc_pattern_editor", 1L), 30 * 20, 1920, 8000);
    
        //ME Fluid Pattern Terminal
        impact.I_RA.addMESPRecipes(new ItemStack[]{
				GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 1, 340),
				GT_ItemList.EngineeringProcessorFluidDiamondCore.get(1),
				GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1, 23),
				ItemList.Electric_Pump_EV.get(2),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.MaragingSteel300, 4)
        }, GT_ModHandler.getModItem("ae2fc", "part_fluid_pattern_terminal", 1L), 20 * 20, 1920, 400);
    
        //ME Fluid Processing Pattern Terminal
        impact.I_RA.addMESPRecipes(new ItemStack[]{
                GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 1, 500),
				GT_ItemList.EngineeringProcessorFluidEmeraldCore.get(1),
				GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1, 23),
				ItemList.Electric_Pump_IV.get(2),
                GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.MaragingSteel300, 4)
        }, GT_ModHandler.getModItem("ae2fc", "part_fluid_pattern_terminal_ex", 1L), 40 * 20, 7680, 800);
		
		//ME Level Maintainer
        impact.I_RA.addMESPRecipes(new ItemStack[]{
                GT_ModHandler.getModItem(AE2, "tile.BlockCraftingUnit", 1, 1),
				GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1, 44),
                GT_ItemList.EngineeringProcessorFluidDiamondCore.get(1),
				GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 2, 53),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Vanadium, 4)
        }, GT_ModHandler.getModItem("ae2fc", "level_maintainer", 1L), 30 * 20, 1920, 800);
		
		//ME Quantum Storage
        impact.I_RA.addMESPRecipes(new ItemStack[]{
                GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1, 61),
                ItemList.Quantum_Chest_HV.get(4),
				GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Superconductor, 4),
                GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 8, 60),
                GT_OreDictUnificator.get(OrePrefixes.plateDense, Materials.Neutronium, 8)
        }, GT_ModHandler.getModItem(AE2, "item.ItemExtremeStorageCell.Quantum", 1L), 120 * 20, 500000, 20000);

		//ME Digital Singularity
        impact.I_RA.addMESPRecipes(new ItemStack[]{
                GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1, 61),
                ItemList.Quantum_Chest_IV.get(4),
				GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Nano, 4),
                GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 8, 60),
                GT_OreDictUnificator.get(OrePrefixes.plateDense, Materials.InfinityCatalyst, 8)
        }, GT_ModHandler.getModItem(AE2, "item.ItemExtremeStorageCell.Singularity", 1L), 360 * 20, 8000000, 80000);

        //ME Fluid Quantum Storage
        impact.I_RA.addMESPRecipes(new ItemStack[]{
                GT_ModHandler.getModItem("ae2fc", "fluid_storage_housing", 1, 1),
                ItemList.Quantum_Tank_HV.get(4),
                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Superconductor, 4),
                GT_ModHandler.getModItem("ae2fc", "fluid_part", 8, 7),
                GT_OreDictUnificator.get(OrePrefixes.plateDense, Materials.Neutronium, 8)
        }, GT_ModHandler.getModItem("ae2fc", "fluid_storage.quantum", 1L), 120 * 20, 500000, 20000);

        //ME Fluid Digital Singularity
        impact.I_RA.addMESPRecipes(new ItemStack[]{
                GT_ModHandler.getModItem("ae2fc", "fluid_storage_housing", 1, 1),
                ItemList.Quantum_Tank_IV.get(4),
                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Nano, 4),
                GT_ModHandler.getModItem("ae2fc", "fluid_part", 8, 7),
                GT_OreDictUnificator.get(OrePrefixes.plateDense, Materials.InfinityCatalyst, 8)
        }, GT_ModHandler.getModItem("ae2fc", "fluid_storage.singularity", 1L), 360 * 20, 8000000, 80000);


        //ME Controller
        impact.I_RA.addMESPRecipes(new ItemStack[]{GT_ModHandler.getModItem(AE2, "tile.BlockEnergyAcceptor", 1, 0), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 2, 24)/*Diamond*/, GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Data, 2), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Platinum, 4), GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 4, 76), GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.MaragingSteel300, 4), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Titanium, 8)}, GT_ModHandler.getModItem(AE2, "tile.BlockController", 1, 0), 30 * 20, 1920, 8000);
    
        //ME Chest
        impact.I_RA.addMESPRecipes(new ItemStack[]{GT_ModHandler.getModItem("chestup", "Blockchestup", 1L, 3), GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 1, 380), GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 1, 16), GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Advanced, 2), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.EnergeticAlloy, 2), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.VanadiumSteel, 2), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 4, 22)/*Gold*/, GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Vanadium, 12)}, GT_ModHandler.getModItem(AE2, "tile.BlockChest", 1, 0), 20 * 20, 480, 1000);
    
        //ME Drive
        impact.I_RA.addMESPRecipes(new ItemStack[]{GT_ModHandler.getModItem(AE2, "tile.BlockChest", 1, 0), GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Data, 2), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.VibrantAlloy, 2), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 4, 24)/*Diamond*/, GT_OreDictUnificator.get(OrePrefixes.plate, Materials.VanadiumSteel, 3), GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Titanium, 4), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Vanadium, 9)}, GT_ModHandler.getModItem(AE2, "tile.BlockDrive", 1, 0), 30 * 20, 1920, 1000);
    
        //Molecular Assembler
        impact.I_RA.addMESPRecipes(new ItemStack[]{ItemList.Machine_MV_Assembler.get(1L), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 2, 43)/*Form*/, GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 2, 44)/*Ani*/, GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 2, 23)/*Processor*/, GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Vanadium, 2), GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.VanadiumSteel, 4), GT_ModHandler.getModItem(AE2, "tile.BlockQuartzGlass", 12, 0)}, GT_ModHandler.getModItem(AE2, "tile.BlockMolecularAssembler", 1, 0), 30 * 20, 1920, 800);
        impact.I_RA.addMESPRecipes(new ItemStack[]{ItemList.Machine_HV_Assembler.get(1L), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 4, 43)/*Form*/, GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 4, 44)/*Ani*/, GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 4, 23)/*Processor*/, GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.HSSG, 2), GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.VanadiumSteel, 8), GT_ModHandler.getModItem(AE2, "tile.BlockQuartzGlass", 24, 0)}, GT_ModHandler.getModItem(AE2, "tile.BlockMolecularAssembler", 4, 0), 60 * 20, 7680, 3200);
        impact.I_RA.addMESPRecipes(new ItemStack[]{ItemList.Machine_EV_Assembler.get(1L), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 8, 43)/*Form*/, GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 8, 44)/*Ani*/, GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 8, 23)/*Processor*/, GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.YttriumBariumCuprate, 2), GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.VanadiumSteel, 16), GT_ModHandler.getModItem(AE2, "tile.BlockQuartzGlass", 36, 0)}, GT_ModHandler.getModItem(AE2, "tile.BlockMolecularAssembler", 16, 0), 120 * 20, 30720, 12800);
        impact.I_RA.addMESPRecipes(new ItemStack[]{ItemList.Machine_IV_Assembler.get(1L), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 16, 43)/*Form*/, GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 16, 44)/*Ani*/, GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 16, 23)/*Processor*/, GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Osmiridium, 2), GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.VanadiumSteel, 32), GT_ModHandler.getModItem(AE2, "tile.BlockQuartzGlass", 48, 0)}, GT_ModHandler.getModItem(AE2, "tile.BlockMolecularAssembler", 64, 0), 240 * 20, 122880, 57600);
    
        //ME Quantum Ring
        impact.I_RA.addMESPRecipes(new ItemStack[]{GT_ModHandler.getModItem(AE2, "tile.BlockEnergyCell", 1, 0), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 4, 24)/*Diamond*/, GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 4, 76), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Platinum, 4), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.MaragingSteel300, 4), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Vanadium, 8)}, GT_ModHandler.getModItem(AE2, "tile.BlockQuantumRing", 1, 0), 20 * 20, 7680, 2000);
    
        //ME Quantum Link Chamber
        impact.I_RA.addMESPRecipes(new ItemStack[]{ItemList.Field_Generator_EV.get(1L), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 4, 7), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 4, 9), GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.MaragingSteel300, 4), GT_ModHandler.getModItem(AE2, "tile.BlockQuartzGlass", 12, 0)}, GT_ModHandler.getModItem(AE2, "tile.BlockQuantumLinkChamber", 1, 0), 40 * 20, 7680, 8000);
    
        //Spatial Pylon
        impact.I_RA.addMESPRecipes(new ItemStack[]{GT_ModHandler.getModItem(AE2, "tile.BlockQuantumRing", 1, 0), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 4, 8), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 4, 7), GT_OreDictUnificator.get(OrePrefixes.spring, Materials.Platinum, 4), GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Vanadium, 4), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.NiobiumTitanium, 8), GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 8, 16), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Palladium, 16)}, GT_ModHandler.getModItem(AE2, "tile.BlockSpatialPylon", 2, 0), 30 * 20, 7680, 500);
    
        //Spatial IO Port
        impact.I_RA.addMESPRecipes(new ItemStack[]{GT_ModHandler.getModItem(AE2, "tile.BlockIOPort", 1, 0), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 4, 24)/*Diamond*/, GT_ModHandler.getModItem(AE2, "tile.BlockSpatialPylon", 4, 0), GT_ModHandler.getModItem(AE2, "tile.BlockQuantumLinkChamber", 4, 0), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 4, 7), GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Elite, 4), GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.NiobiumTitanium, 4), GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Platinum, 8), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Vanadium, 16)}, GT_ModHandler.getModItem(AE2, "tile.BlockSpatialIOPort", 1, 0), 40 * 20, 7680, 1000);
    
        //ME Interface
        impact.I_RA.addMESPRecipes(new ItemStack[]{ItemList.Robot_Arm_LV.get(1L), GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.VanadiumSteel, 1), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1, 43)/*Form*/, GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1, 44)/*Ani*/, GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Steel, 4)}, GT_ModHandler.getModItem(AE2, "tile.BlockInterface", 1, 0), 100, 120, 50);
        impact.I_RA.addMESPRecipes(new ItemStack[]{ItemList.Robot_Arm_MV.get(1L), GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.VanadiumSteel, 2), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 2, 43)/*Form*/, GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 2, 44)/*Ani*/, GT_OreDictUnificator.get(OrePrefixes.foil, Materials.BlueSteel, 4)}, GT_ModHandler.getModItem(AE2, "tile.BlockInterface", 2, 0), 200, 480, 100);
        impact.I_RA.addMESPRecipes(new ItemStack[]{ItemList.Robot_Arm_HV.get(1L), GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.VanadiumSteel, 3), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 3, 43)/*Form*/, GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 3, 44)/*Ani*/, GT_OreDictUnificator.get(OrePrefixes.foil, Materials.HSLA, 4)}, GT_ModHandler.getModItem(AE2, "tile.BlockInterface", 4, 0), 300, 1920, 200);
        impact.I_RA.addMESPRecipes(new ItemStack[]{ItemList.Robot_Arm_EV.get(1L), GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.VanadiumSteel, 4), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 4, 43)/*Form*/, GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 4, 44)/*Ani*/, GT_OreDictUnificator.get(OrePrefixes.foil, Materials.HSSG, 4)}, GT_ModHandler.getModItem(AE2, "tile.BlockInterface", 8, 0), 400, 7680, 400);
        impact.I_RA.addMESPRecipes(new ItemStack[]{ItemList.Robot_Arm_IV.get(1L), GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.VanadiumSteel, 5), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 5, 43)/*Form*/, GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 5, 44)/*Ani*/, GT_OreDictUnificator.get(OrePrefixes.foil, Materials.HastelloyC276, 4)}, GT_ModHandler.getModItem(AE2, "tile.BlockInterface", 12, 0), 500, 30720, 600);
        impact.I_RA.addMESPRecipes(new ItemStack[]{ItemList.Robot_Arm_LuV.get(1L), GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.VanadiumSteel, 6), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 6, 43)/*Form*/, GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 6, 44)/*Ani*/, GT_OreDictUnificator.get(OrePrefixes.foil, Materials.HastelloyN, 4)}, GT_ModHandler.getModItem(AE2, "tile.BlockInterface", 16, 0), 600, 122880, 800);
        impact.I_RA.addMESPRecipes(new ItemStack[]{ItemList.Robot_Arm_ZPM.get(1L), GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.VanadiumSteel, 7), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 7, 43)/*Form*/, GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 7, 44)/*Ani*/, GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Lafium, 4)}, GT_ModHandler.getModItem(AE2, "tile.BlockInterface", 24, 0), 700, 500000, 1200);
        impact.I_RA.addMESPRecipes(new ItemStack[]{ItemList.Robot_Arm_UV.get(1L), GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.VanadiumSteel, 8), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 8, 43)/*Form*/, GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 8, 44)/*Ani*/, GT_OreDictUnificator.get(OrePrefixes.foil, Materials.CinobiteA243, 4)}, GT_ModHandler.getModItem(AE2, "tile.BlockInterface", 32, 0), 800, 2000000, 1600);
    
        //New Pattern Terminal
        impact.I_RA.addMESPRecipes(new ItemStack[]{GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1, 52), GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 1, 340), GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Data, 1), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 4, 24)/*Diamond*/}, GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 1, 500), 400, 1920, 400);
    
        //ME Export Bus
        impact.I_RA.addMESPRecipes(new ItemStack[]{ItemList.Conveyor_Module_LV.get(1L), GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Steel, 4), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 2, 43), GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Vanadium, 2)}, GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 1, 260), 200, 120, 50);
        impact.I_RA.addMESPRecipes(new ItemStack[]{ItemList.Conveyor_Module_MV.get(1L), GT_OreDictUnificator.get(OrePrefixes.foil, Materials.BlueSteel, 4), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 4, 43), GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Vanadium, 4)}, GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 2, 260), 300, 480, 100);
        impact.I_RA.addMESPRecipes(new ItemStack[]{ItemList.Conveyor_Module_HV.get(1L), GT_OreDictUnificator.get(OrePrefixes.foil, Materials.HSLA, 4), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 6, 43), GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Vanadium, 6)}, GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 4, 260), 400, 1920, 200);
        impact.I_RA.addMESPRecipes(new ItemStack[]{ItemList.Conveyor_Module_EV.get(1L), GT_OreDictUnificator.get(OrePrefixes.foil, Materials.HSSG, 4), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 8, 43), GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Vanadium, 8)}, GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 8, 260), 500, 7680, 400);
        impact.I_RA.addMESPRecipes(new ItemStack[]{ItemList.Conveyor_Module_IV.get(1L), GT_OreDictUnificator.get(OrePrefixes.foil, Materials.HastelloyC276, 4), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 10, 43), GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Vanadium, 12)}, GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 12, 260), 600, 30720, 600);
        impact.I_RA.addMESPRecipes(new ItemStack[]{ItemList.Conveyor_Module_LuV.get(1L), GT_OreDictUnificator.get(OrePrefixes.foil, Materials.HastelloyN, 4), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 12, 43), GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Vanadium, 16)}, GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 16, 260), 700, 122880, 800);
        impact.I_RA.addMESPRecipes(new ItemStack[]{ItemList.Conveyor_Module_ZPM.get(1L), GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Lafium, 4), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 14, 43), GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Vanadium, 20)}, GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 24, 260), 800, 500000, 1200);
        impact.I_RA.addMESPRecipes(new ItemStack[]{ItemList.Conveyor_Module_UV.get(1L), GT_OreDictUnificator.get(OrePrefixes.foil, Materials.CinobiteA243, 4), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 16, 43), GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Vanadium, 24)}, GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 32, 260), 900, 2000000, 1600);
    
        //ME Import Bus
        impact.I_RA.addMESPRecipes(new ItemStack[]{ItemList.Conveyor_Module_LV.get(1L), GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Steel, 4), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 2, 44), GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Vanadium, 2)}, GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 1, 240), 200, 120, 50);
        impact.I_RA.addMESPRecipes(new ItemStack[]{ItemList.Conveyor_Module_MV.get(1L), GT_OreDictUnificator.get(OrePrefixes.foil, Materials.BlueSteel, 4), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 4, 44), GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Vanadium, 4)}, GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 2, 240), 300, 480, 100);
        impact.I_RA.addMESPRecipes(new ItemStack[]{ItemList.Conveyor_Module_HV.get(1L), GT_OreDictUnificator.get(OrePrefixes.foil, Materials.HSLA, 4), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 6, 44), GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Vanadium, 6)}, GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 4, 240), 400, 1920, 200);
        impact.I_RA.addMESPRecipes(new ItemStack[]{ItemList.Conveyor_Module_EV.get(1L), GT_OreDictUnificator.get(OrePrefixes.foil, Materials.HSSG, 4), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 8, 44), GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Vanadium, 8)}, GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 8, 240), 500, 7680, 400);
        impact.I_RA.addMESPRecipes(new ItemStack[]{ItemList.Conveyor_Module_IV.get(1L), GT_OreDictUnificator.get(OrePrefixes.foil, Materials.HastelloyC276, 4), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 10, 44), GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Vanadium, 12)}, GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 12, 240), 600, 30720, 600);
        impact.I_RA.addMESPRecipes(new ItemStack[]{ItemList.Conveyor_Module_LuV.get(1L), GT_OreDictUnificator.get(OrePrefixes.foil, Materials.HastelloyN, 4), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 12, 44), GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Vanadium, 16)}, GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 16, 240), 700, 122880, 800);
        impact.I_RA.addMESPRecipes(new ItemStack[]{ItemList.Conveyor_Module_ZPM.get(1L), GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Lafium, 4), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 14, 44), GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Vanadium, 20)}, GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 24, 240), 800, 500000, 1200);
        impact.I_RA.addMESPRecipes(new ItemStack[]{ItemList.Conveyor_Module_UV.get(1L), GT_OreDictUnificator.get(OrePrefixes.foil, Materials.CinobiteA243, 4), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 16, 44), GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Vanadium, 24)}, GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 32, 240), 900, 2000000, 1600);
    
        //Storage Bus
        impact.I_RA.addMESPRecipes(new ItemStack[]{ItemList.Hatch_Input_Bus_LV.get(1L), ItemList.Hatch_Output_Bus_LV.get(1L), GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Steel, 4), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1, 44), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1, 43), GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Vanadium, 2)}, GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 1, 220), 200, 120, 50);
        impact.I_RA.addMESPRecipes(new ItemStack[]{ItemList.Hatch_Input_Bus_MV.get(1L), ItemList.Hatch_Output_Bus_MV.get(1L), GT_OreDictUnificator.get(OrePrefixes.foil, Materials.BlueSteel, 4), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 2, 44), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 2, 43), GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Vanadium, 4)}, GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 2, 220), 300, 480, 100);
        impact.I_RA.addMESPRecipes(new ItemStack[]{ItemList.Hatch_Input_Bus_HV.get(1L), ItemList.Hatch_Output_Bus_HV.get(1L), GT_OreDictUnificator.get(OrePrefixes.foil, Materials.HSLA, 4), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 3, 44), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 3, 43), GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Vanadium, 6)}, GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 4, 220), 400, 1920, 200);
        impact.I_RA.addMESPRecipes(new ItemStack[]{ItemList.Hatch_Input_Bus_EV.get(1L), ItemList.Hatch_Output_Bus_EV.get(1L), GT_OreDictUnificator.get(OrePrefixes.foil, Materials.HSSG, 4), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 4, 44), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 4, 43), GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Vanadium, 8)}, GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 8, 220), 500, 7680, 400);
        impact.I_RA.addMESPRecipes(new ItemStack[]{ItemList.Hatch_Input_Bus_IV.get(1L), ItemList.Hatch_Output_Bus_IV.get(1L), GT_OreDictUnificator.get(OrePrefixes.foil, Materials.HastelloyC276, 4), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 5, 44), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 5, 43), GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Vanadium, 12)}, GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 12, 220), 600, 30720, 600);
        impact.I_RA.addMESPRecipes(new ItemStack[]{ItemList.Hatch_Input_Bus_LuV.get(1L), ItemList.Hatch_Output_Bus_LuV.get(1L), GT_OreDictUnificator.get(OrePrefixes.foil, Materials.HastelloyN, 4), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 6, 44), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 6, 43), GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Vanadium, 16)}, GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 16, 220), 700, 122880, 800);
        impact.I_RA.addMESPRecipes(new ItemStack[]{ItemList.Hatch_Input_Bus_ZPM.get(1L), ItemList.Hatch_Output_Bus_ZPM.get(1L), GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Lafium, 4), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 7, 44), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 7, 43), GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Vanadium, 20)}, GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 24, 220), 800, 500000, 1200);
        impact.I_RA.addMESPRecipes(new ItemStack[]{ItemList.Hatch_Input_Bus_UV.get(1L), ItemList.Hatch_Output_Bus_UV.get(1L), GT_OreDictUnificator.get(OrePrefixes.foil, Materials.CinobiteA243, 4), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 8, 44), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 8, 43), GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Vanadium, 24)}, GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 32, 220), 900, 2000000, 1600);
    
        //P2P Tunnel
        impact.I_RA.addMESPRecipes(new ItemStack[]{ItemList.Emitter_EV.get(1L), ItemList.Sensor_EV.get(1L), GT_OreDictUnificator.get(OrePrefixes.foil, Materials.HSSG, 8), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1, 44), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1, 43), GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Vanadium, 2)}, GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 2, 460), 500, 7680, 400);
        impact.I_RA.addMESPRecipes(new ItemStack[]{ItemList.Emitter_IV.get(1L), ItemList.Sensor_IV.get(1L), GT_OreDictUnificator.get(OrePrefixes.foil, Materials.HastelloyC276, 8), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 2, 44), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 2, 43), GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Vanadium, 6)}, GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 6, 460), 600, 30720, 1200);
        impact.I_RA.addMESPRecipes(new ItemStack[]{ItemList.Emitter_LuV.get(1L), ItemList.Sensor_LuV.get(1L), GT_OreDictUnificator.get(OrePrefixes.foil, Materials.HastelloyN, 8), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 3, 44), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 3, 43), GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Vanadium, 12)}, GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 18, 460), 700, 122880, 3600);
        impact.I_RA.addMESPRecipes(new ItemStack[]{ItemList.Emitter_ZPM.get(1L), ItemList.Sensor_ZPM.get(1L), GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Lafium, 8), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 4, 44), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 4, 43), GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Vanadium, 20)}, GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 32, 460), 800, 500000, 7200);
        impact.I_RA.addMESPRecipes(new ItemStack[]{ItemList.Emitter_UV.get(1L), ItemList.Sensor_UV.get(1L), GT_OreDictUnificator.get(OrePrefixes.foil, Materials.CinobiteA243, 8), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 5, 44), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 5, 43), GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Vanadium, 32)}, GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 64, 460), 900, 2000000, 14400);
    
        // --- Wireless Connector
        impact.I_RA.addMESPRecipes(new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Vanadium, 1), GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 1L, 56), GT_ModHandler.getModItem(AE2, "tile.BlockWireless", 1L, 0), GT_OreDictUnificator.get(OrePrefixes.foil, Materials.VanadiumSteel, 4)}, GT_ModHandler.getModItem("ae2stuff", "Wireless", 1L, 0), 40 * 20, 480, 1000);
        //ME Fluid Export Bus
        impact.I_RA.addMESPRecipes(new ItemStack[]{ItemList.Electric_Pump_LV.get(1L), GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Steel, 4), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 2, 43), GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Vanadium, 2)}, GT_ModHandler.getModItem("ae2fc", "part_fluid_export", 1, 0), 200, 120, 50);
        impact.I_RA.addMESPRecipes(new ItemStack[]{ItemList.Electric_Pump_MV.get(1L), GT_OreDictUnificator.get(OrePrefixes.foil, Materials.BlueSteel, 4), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 4, 43), GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Vanadium, 4)}, GT_ModHandler.getModItem("ae2fc", "part_fluid_export", 2, 0), 300, 480, 100);
        impact.I_RA.addMESPRecipes(new ItemStack[]{ItemList.Electric_Pump_HV.get(1L), GT_OreDictUnificator.get(OrePrefixes.foil, Materials.HSLA, 4), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 6, 43), GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Vanadium, 6)}, GT_ModHandler.getModItem("ae2fc", "part_fluid_export", 4, 0), 400, 1920, 200);
        impact.I_RA.addMESPRecipes(new ItemStack[]{ItemList.Electric_Pump_EV.get(1L), GT_OreDictUnificator.get(OrePrefixes.foil, Materials.HSSG, 4), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 8, 43), GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Vanadium, 8)}, GT_ModHandler.getModItem("ae2fc", "part_fluid_export", 8, 0), 500, 7680, 400);
        impact.I_RA.addMESPRecipes(new ItemStack[]{ItemList.Electric_Pump_IV.get(1L), GT_OreDictUnificator.get(OrePrefixes.foil, Materials.HastelloyC276, 4), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 10, 43), GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Vanadium, 12)}, GT_ModHandler.getModItem("ae2fc", "part_fluid_export", 12, 0), 600, 30720, 600);
        impact.I_RA.addMESPRecipes(new ItemStack[]{ItemList.Electric_Pump_LuV.get(1L), GT_OreDictUnificator.get(OrePrefixes.foil, Materials.HastelloyN, 4), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 12, 43), GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Vanadium, 16)}, GT_ModHandler.getModItem("ae2fc", "part_fluid_export", 16, 0), 700, 122880, 800);
        impact.I_RA.addMESPRecipes(new ItemStack[]{ItemList.Electric_Pump_ZPM.get(1L), GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Lafium, 4), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 14, 43), GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Vanadium, 20)}, GT_ModHandler.getModItem("ae2fc", "part_fluid_export", 24, 0), 800, 500000, 1200);
        impact.I_RA.addMESPRecipes(new ItemStack[]{ItemList.Electric_Pump_UV.get(1L), GT_OreDictUnificator.get(OrePrefixes.foil, Materials.CinobiteA243, 4), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 16, 43), GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Vanadium, 24)}, GT_ModHandler.getModItem("ae2fc", "part_fluid_export", 32, 0), 900, 2000000, 1600);
        //ME Fluid Import Bus
        impact.I_RA.addMESPRecipes(new ItemStack[]{ItemList.Electric_Pump_LV.get(1L), GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Steel, 4), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 2, 44), GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Vanadium, 2)}, GT_ModHandler.getModItem("ae2fc", "part_fluid_import", 1, 0), 200, 120, 50);
        impact.I_RA.addMESPRecipes(new ItemStack[]{ItemList.Electric_Pump_MV.get(1L), GT_OreDictUnificator.get(OrePrefixes.foil, Materials.BlueSteel, 4), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 4, 44), GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Vanadium, 4)}, GT_ModHandler.getModItem("ae2fc", "part_fluid_import", 2, 0), 300, 480, 100);
        impact.I_RA.addMESPRecipes(new ItemStack[]{ItemList.Electric_Pump_HV.get(1L), GT_OreDictUnificator.get(OrePrefixes.foil, Materials.HSLA, 4), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 6, 44), GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Vanadium, 6)}, GT_ModHandler.getModItem("ae2fc", "part_fluid_import", 4, 0), 400, 1920, 200);
        impact.I_RA.addMESPRecipes(new ItemStack[]{ItemList.Electric_Pump_EV.get(1L), GT_OreDictUnificator.get(OrePrefixes.foil, Materials.HSSG, 4), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 8, 44), GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Vanadium, 8)}, GT_ModHandler.getModItem("ae2fc", "part_fluid_import", 8, 0), 500, 7680, 400);
        impact.I_RA.addMESPRecipes(new ItemStack[]{ItemList.Electric_Pump_IV.get(1L), GT_OreDictUnificator.get(OrePrefixes.foil, Materials.HastelloyC276, 4), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 10, 44), GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Vanadium, 12)}, GT_ModHandler.getModItem("ae2fc", "part_fluid_import", 12, 0), 600, 30720, 600);
        impact.I_RA.addMESPRecipes(new ItemStack[]{ItemList.Electric_Pump_LuV.get(1L), GT_OreDictUnificator.get(OrePrefixes.foil, Materials.HastelloyN, 4), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 12, 44), GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Vanadium, 16)}, GT_ModHandler.getModItem("ae2fc", "part_fluid_import", 16, 0), 700, 122880, 800);
        impact.I_RA.addMESPRecipes(new ItemStack[]{ItemList.Electric_Pump_ZPM.get(1L), GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Lafium, 4), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 14, 44), GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Vanadium, 20)}, GT_ModHandler.getModItem("ae2fc", "part_fluid_import", 24, 0), 800, 500000, 1200);
        impact.I_RA.addMESPRecipes(new ItemStack[]{ItemList.Electric_Pump_UV.get(1L), GT_OreDictUnificator.get(OrePrefixes.foil, Materials.CinobiteA243, 4), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 16, 44), GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Vanadium, 24)}, GT_ModHandler.getModItem("ae2fc", "part_fluid_import", 32, 0), 900, 2000000, 1600);
        //ME Fluid Storage Bus
        impact.I_RA.addMESPRecipes(new ItemStack[]{ItemList.Hatch_Input_LV.get(1L), ItemList.Hatch_Output_LV.get(1L), GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Steel, 4), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1, 44), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 1, 43), GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Vanadium, 2)}, GT_ModHandler.getModItem("ae2fc", "part_fluid_storage_bus", 1), 200, 120, 50);
        impact.I_RA.addMESPRecipes(new ItemStack[]{ItemList.Hatch_Input_MV.get(1L), ItemList.Hatch_Output_MV.get(1L), GT_OreDictUnificator.get(OrePrefixes.foil, Materials.BlueSteel, 4), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 2, 44), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 2, 43), GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Vanadium, 4)}, GT_ModHandler.getModItem("ae2fc", "part_fluid_storage_bus", 2), 300, 480, 100);
        impact.I_RA.addMESPRecipes(new ItemStack[]{ItemList.Hatch_Input_HV.get(1L), ItemList.Hatch_Output_HV.get(1L), GT_OreDictUnificator.get(OrePrefixes.foil, Materials.HSLA, 4), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 3, 44), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 3, 43), GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Vanadium, 6)}, GT_ModHandler.getModItem("ae2fc", "part_fluid_storage_bus", 4), 400, 1920, 200);
        impact.I_RA.addMESPRecipes(new ItemStack[]{ItemList.Hatch_Input_EV.get(1L), ItemList.Hatch_Output_EV.get(1L), GT_OreDictUnificator.get(OrePrefixes.foil, Materials.HSSG, 4), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 4, 44), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 4, 43), GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Vanadium, 8)}, GT_ModHandler.getModItem("ae2fc", "part_fluid_storage_bus", 8), 500, 7680, 400);
        impact.I_RA.addMESPRecipes(new ItemStack[]{ItemList.Hatch_Input_IV.get(1L), ItemList.Hatch_Output_IV.get(1L), GT_OreDictUnificator.get(OrePrefixes.foil, Materials.HastelloyC276, 4), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 5, 44), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 5, 43), GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Vanadium, 12)}, GT_ModHandler.getModItem("ae2fc", "part_fluid_storage_bus", 12), 600, 30720, 600);
        impact.I_RA.addMESPRecipes(new ItemStack[]{ItemList.Hatch_Input_LuV.get(1L), ItemList.Hatch_Output_LuV.get(1L), GT_OreDictUnificator.get(OrePrefixes.foil, Materials.HastelloyN, 4), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 6, 44), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 6, 43), GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Vanadium, 16)}, GT_ModHandler.getModItem("ae2fc", "part_fluid_storage_bus", 16), 700, 122880, 800);
        impact.I_RA.addMESPRecipes(new ItemStack[]{ItemList.Hatch_Input_ZPM.get(1L), ItemList.Hatch_Output_ZPM.get(1L), GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Lafium, 4), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 7, 44), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 7, 43), GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Vanadium, 20)}, GT_ModHandler.getModItem("ae2fc", "part_fluid_storage_bus", 24), 800, 500000, 1200);
        impact.I_RA.addMESPRecipes(new ItemStack[]{ItemList.Hatch_Input_UV.get(1L), ItemList.Hatch_Output_UV.get(1L), GT_OreDictUnificator.get(OrePrefixes.foil, Materials.CinobiteA243, 4), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 8, 44), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 8, 43), GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Vanadium, 24)}, GT_ModHandler.getModItem("ae2fc", "part_fluid_storage_bus", 32), 900, 2000000, 1600);
    }
}
