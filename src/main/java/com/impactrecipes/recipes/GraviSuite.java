package com.impactrecipes.recipes;

import com.impact.common.item.Core_Items2;
import com.impact.mods.gregtech.GT_ItemList;
import gregtech.api.enums.GT_Values;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.util.GT_ModHandler;
import gregtech.api.util.GT_OreDictUnificator;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;

import static gregtech.api.enums.GT_Values.RA;
import static gregtech.api.util.GT_ModHandler.removeRecipeByOutput;

public class GraviSuite implements Runnable {

    private static final long tBitMask = GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE;

    final Core_Items2 CoreItems2 = Core_Items2.getInstance();

    @Override
    public void run() {
        removeGraviSuite();
        hand();
        printer3d();
        assemblyLine();
    }

    private void removeGraviSuite() {
        /*removeRecipeByOutput(GT_ModHandler.getModItem("GraviSuite", "itemSimpleItem", 3, 1));
        removeRecipeByOutput(GT_ModHandler.getModItem("GraviSuite", "itemSimpleItem", 3, 0));
        removeRecipeByOutput(GT_ModHandler.getModItem("GraviSuite", "advJetpack", 1));
        removeRecipeByOutput(GT_ModHandler.getModItem("GraviSuite", "advLappack", 1));
        removeRecipeByOutput(GT_ModHandler.getModItem("GraviSuite", "advNanoChestPlate", 1));
        removeRecipeByOutput(GT_ModHandler.getModItem("GraviSuite", "ultimateLappack", 1));
        removeRecipeByOutput(GT_ModHandler.getModItem("GraviSuite", "relocator", 1));
        removeRecipeByOutput(GT_ModHandler.getModItem("GraviSuite", "vajra", 1));
        removeRecipeByOutput(GT_ModHandler.getModItem("GraviSuite", "graviTool", 1));
        removeRecipeByOutput(GT_ModHandler.getModItem("GraviSuite", "advChainsaw", 1));
        removeRecipeByOutput(GT_ModHandler.getModItem("GraviSuite", "advDDrill", 1));
        removeRecipeByOutput(GT_ModHandler.getModItem("GraviSuite", "itemSimpleItem", 1L, 4));
        removeRecipeByOutput(GT_ModHandler.getModItem("GraviSuite", "itemSimpleItem", 1L, 5));
        removeRecipeByOutput(GT_ModHandler.getModItem("GraviSuite", "itemSimpleItem", 1L, 7));
        removeRecipeByOutput(GT_ModHandler.getModItem("GraviSuite", "itemSimpleItem", 1L, 2));
        removeRecipeByOutput(GT_ModHandler.getModItem("GraviSuite", "itemSimpleItem", 1L, 6));
        removeRecipeByOutput(GT_ModHandler.getModItem("GraviSuite", "itemSimpleItem", 1L, 3));
        removeRecipeByOutput(GT_ModHandler.getModItem("GraviSuite", "graviChestPlate", 1L));
        removeRecipeByOutput(GT_ModHandler.getModItem("GraviSuite", "kpChestPlate", 1L));
        */
    }

    private void hand() {
        // --- Super Conductor
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("GraviSuite", "itemSimpleItem", 1L, 1), tBitMask, new Object[]{"GGG", "SPS", "GGG", 'G', GT_ModHandler.getModItem("GraviSuite", "itemSimpleItem", 1L), 'S', OrePrefixes.wireGt02.get(Materials.SuperconductorLuV), 'P', OrePrefixes.plateTriple.get(Materials.Platinum)});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("GraviSuite", "itemSimpleItem", 3L, 1), tBitMask, new Object[]{"GGG", "SPS", "GGG", 'G', GT_ModHandler.getModItem("GraviSuite", "itemSimpleItem", 1L), 'S', OrePrefixes.wireGt04.get(Materials.SuperconductorZPM), 'P', OrePrefixes.plateQuadruple.get(Materials.YttriumBariumCuprate)});
        // --- Super Conductor Cover
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("GraviSuite", "itemSimpleItem", 2L), tBitMask, new Object[]{"PPP", "III", "PPP", 'I', GT_ModHandler.getModItem("IC2", "itemPartIridium", 1L), 'P', OrePrefixes.plate.get(Materials.NiobiumTitanium)});
        // --- Engine Booster
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("GraviSuite", "itemSimpleItem", 1L, 6), tBitMask, new Object[]{"PCP", "PMP", "SVS", 'V', GT_ModHandler.getModItem("IC2", "reactorVentDiamond", 1L, 1), 'M', GT_ModHandler.getModItem("IC2", "upgradeModule", 1L), 'P', OrePrefixes.plate.get(Materials.StainlessSteel), 'S', OrePrefixes.screw.get(Materials.StainlessSteel), 'C', OrePrefixes.circuit.get(Materials.Advanced)});
        // --- Gravitation Engine
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("GraviSuite", "itemSimpleItem", 1L, 3), tBitMask, new Object[]{"ESE", "COC", "ESE", 'S', GT_ModHandler.getModItem("GraviSuite", "itemSimpleItem", 1L, 1), 'C', GT_ModHandler.getModItem("GraviSuite", "itemSimpleItem", 1L, 2), 'E', ItemList.Emitter_IV, 'O', ItemList.Energy_LapotronicOrb});
        // --- Magnetron
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("GraviSuite", "itemSimpleItem", 1L, 4), tBitMask, new Object[]{"MCM", "PSP", "MCM", 'M', OrePrefixes.plateDense.get(Materials.NeodymiumMagnetic), 'P', OrePrefixes.plateDense.get(Materials.Copper), 'S', GT_ModHandler.getModItem("GraviSuite", "itemSimpleItem", 1L, 1), 'C', ItemList.IV_Coil});
        // --- Vajra Core
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("GraviSuite", "itemSimpleItem", 1L, 5), tBitMask, new Object[]{"SwS", "IMI", "STS", 'I', GT_ModHandler.getModItem("IC2", "itemPartIridium", 1L), 'M', GT_ModHandler.getModItem("GraviSuite", "itemSimpleItem", 1L, 4), 'S', GT_ModHandler.getModItem("GraviSuite", "itemSimpleItem", 1L, 1), 'T', ItemList.Transformer_LuV_IV});
        // --- Gravitational Engine 2
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("GraviSuite", "itemSimpleItem", 1L, 7), tBitMask, new Object[]{"ESE", "COC", "ESE", 'S', OrePrefixes.wireGt04.get(Materials.SuperconductorLuV), 'C', GT_ModHandler.getModItem("GraviSuite", "itemSimpleItem", 1L, 3), 'E', ItemList.Emitter_LuV, 'O', ItemList.Energy_LapotronicOrb2});
        // --- Cooling Core
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("GraviSuite", "itemSimpleItem", 1L, 2), tBitMask, new Object[]{"IHI", "RCR", "PHP", 'P', OrePrefixes.plateDouble.get(Materials.Inconel792), 'I', GT_ModHandler.getModItem("IC2", "itemPartIridium", 1L), 'H', GT_ModHandler.getModItem("IC2", "reactorHeatSwitchDiamond", 1L, 1), 'R', GT_ModHandler.getModItem("IC2", "reactorPlatingHeat", 1L), 'C', ItemList.Reactor_Coolant_He_6});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("GraviSuite", "itemSimpleItem", 1L, 2), tBitMask, new Object[]{"PHP", "RCR", "IHI", 'P', OrePrefixes.plateDouble.get(Materials.Inconel792), 'I', GT_ModHandler.getModItem("IC2", "itemPartIridium", 1L), 'H', GT_ModHandler.getModItem("IC2", "reactorHeatSwitchDiamond", 1L, 1), 'R', GT_ModHandler.getModItem("IC2", "reactorPlatingHeat", 1L), 'C', ItemList.Reactor_Coolant_He_6});
        // --- Epic Lappack
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("GraviSuite", "epicLappack", 1L, 27), tBitMask, new Object[]{"PCP", "PUP", "SOS", 'P', OrePrefixes.itemCasing.get(Materials.HSSG), 'C', OrePrefixes.circuit.get(Materials.Superconductor), 'S', OrePrefixes.wireGt12.get(Materials.SuperconductorZPM), 'U', GT_ModHandler.getModItem("GraviSuite", "ultimateLappack", 1L, GT_Values.W), 'O', ItemList.Energy_LapotronicOrb2});
        // --- Vajra
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("GraviSuite", "vajra", 1L, 27), tBitMask, new Object[]{"HVL", "CIC", "SOS", 'S', OrePrefixes.stick.get(Materials.Trinium), 'C', OrePrefixes.circuit.get(Materials.Elite), 'L', OrePrefixes.lens.get(Materials.ReinforcedGlass), 'V', GT_ModHandler.getModItem("GraviSuite", "itemSimpleItem", 1L, 4), 'I', GT_ModHandler.getModItem("GraviSuite", "itemSimpleItem", 1L, 5), 'H', GT_ItemList.EngravedEnergyChip, 'O', CoreItems2.getRecipe(46, 1)});
        // --- GraviTool
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("GraviSuite", "graviTool", 1L), tBitMask, new Object[]{"AHA", "RBR", "WCT", 'A', "plateAlloyCarbon", 'B', CoreItems2.getRecipe(100, 1), 'R', "plateAlloyAdvanced", 'C', OrePrefixes.circuit.get(Materials.Advanced), 'H', GT_ModHandler.getModItem("IC2", "itemToolHoe", 1L, GT_Values.W), 'W', GT_ModHandler.getModItem("IC2", "itemToolWrenchElectric", 1L, GT_Values.W), 'T', GT_ModHandler.getModItem("IC2", "itemTreetapElectric", 1L, GT_Values.W)});
        // --- Advanced Chainsaw
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("GraviSuite", "advChainsaw", 1L), tBitMask, new Object[]{"SBd", "GMG", "PIP", 'P', OrePrefixes.plate.get(Materials.HSSG), 'G', OrePrefixes.gearGtSmall.get(Materials.HSSG), 'D', OrePrefixes.toolHeadChainsaw.get(Materials.TungstenSteel), 'S', OrePrefixes.screw.get(Materials.HSSG), 'I', GT_ModHandler.getModItem("IC2", "itemBatChargeLamaCrystal", 1L, GT_Values.W), 'M', ItemList.Electric_Motor_EV});
        // --- Advanced Nanochestplate
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("GraviSuite", "advNanoChestPlate", 1L, 27), tBitMask, new Object[]{"AJA", "ANA", "WCW", 'A', "plateAlloyAdvanced", 'W', OrePrefixes.wireGt04.get(Materials.Platinum), 'C', OrePrefixes.circuit.get(Materials.Elite), 'J', GT_ModHandler.getModItem("GraviSuite", "advJetpack", 1L, GT_Values.W), 'N', GT_ModHandler.getModItem("IC2", "itemArmorNanoChestplate", 1L, GT_Values.W)});
        // --- Advanced Jetpack
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("GraviSuite", "advJetpack", 1L, 27), tBitMask, new Object[]{"AJA", "ELE", "WCW", 'A', "plateAlloyAdvanced", 'W', OrePrefixes.wireGt04.get(Materials.Platinum), 'C', OrePrefixes.circuit.get(Materials.Data), 'J', GT_ModHandler.getModItem("IC2", "itemArmorJetpackElectric", 1L, GT_Values.W), 'L', GT_ModHandler.getModItem("GraviSuite", "advLappack", 1L, GT_Values.W), 'E', GT_ModHandler.getModItem("GraviSuite", "itemSimpleItem", 1L, 6)});
        // --- Ultimate Lappack
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("GraviSuite", "ultimateLappack", 1L, 27), tBitMask, new Object[]{"PIP", "LAL", "CSC", 'P', OrePrefixes.itemCasing.get(Materials.TungstenSteel), 'C', OrePrefixes.circuit.get(Materials.Elite), 'I', GT_ModHandler.getModItem("IC2", "itemPartIridium", 1L), 'L', ItemList.LapotronCrystal.get(1), 'A', GT_ModHandler.getModItem("GraviSuite", "advLappack", 1L, GT_Values.W), 'S', GT_ModHandler.getModItem("GraviSuite", "itemSimpleItem", 1L, 1)});
        // --- Advanced Lappack
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("GraviSuite", "advLappack", 1, 27), new Object[]{"CEC", "EJE", "WPW", 'C', OrePrefixes.plateAlloy.get(Materials.Carbon), 'J', GT_ModHandler.getModItem("IC2","itemArmorEnergypack", 1L, GT_Values.W), 'E', ItemList.EnergyCrystal.get(1),  'W', OrePrefixes.wireGt04.get(Materials.Platinum), 'P', OrePrefixes.circuit.get(Materials.Data)});

    }

    private void printer3d() {
        RA.addBasicLineRecipe(new ItemStack[]{
                        GT_ModHandler.getIC2Item("quantumBodyarmor", 1L, GT_Values.W), ItemList.Transformer_ZPM_LuV.get(1L),
                        GT_ModHandler.getModItem("GraviSuite", "ultimateLappack", 1, GT_Values.W),
                        GT_ModHandler.getModItem("GraviSuite", "itemSimpleItem", 6, 1),
                        GT_ModHandler.getModItem("GraviSuite", "itemSimpleItem", 2, 2),
                        GT_ModHandler.getModItem("GraviSuite", "itemSimpleItem", 2, 3),
                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Master, 2),
                        GT_OreDictUnificator.get(OrePrefixes.plateDense, Materials.Duranium, 2),
                        ItemList.Energy_LapotronicOrb2.get(1L), ItemList.Field_Generator_IV.get(2L),
                        ItemList.Electric_Motor_ZPM.get(2L),
                        GT_OreDictUnificator.get(OrePrefixes.screw, Materials.Duranium, 4)
                }, GT_ModHandler.getModItem("GraviSuite", "graviChestPlate", 1, 27), null, 50 * 20,
                30720);

        //K2P4
        RA.addBasicLineRecipe(new ItemStack[]{
                        GT_ModHandler.getModItem("GraviSuite", "graviChestPlate", 1, GT_Values.W),
                        ItemList.Transformer_UV_ZPM.get(1L),
                        GT_ModHandler.getModItem("GraviSuite", "epicLappack", 1, GT_Values.W),
                        GT_ModHandler.getModItem("GraviSuite", "itemSimpleItem", 8, 1),
                        CoreItems2.getRecipe(98, 4), GT_ModHandler.getModItem("GraviSuite", "itemSimpleItem", 2, 7),
                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Ultimate, 2),
                        GT_OreDictUnificator.get(OrePrefixes.plateDense, Materials.Tritanium, 2),
                        ItemList.Energy_Module.get(1L), ItemList.Field_Generator_LuV.get(2L),
                        ItemList.Electric_Motor_UV.get(2L),
                        GT_OreDictUnificator.get(OrePrefixes.screw, Materials.Tritanium, 8)
                }, GT_ModHandler.getModItem("GraviSuite", "kpChestPlate", 1, 27), null, 60 * 20,
                122880);
    }

    private void assemblyLine() {
        // --- Relocator
        RA.addAssemblylineRecipe(ItemList.Casing_Coil_Superconductor.get(1L), 288000, new Object[]{
                ItemList.Casing_Coil_Superconductor.get(1L),
                GT_ModHandler.getModItem("appliedenergistics2", "tile.BlockSpatialIOPort", 1),
                ItemList.Field_Generator_IV.get(4L),
                ItemList.Sensor_LuV.get(8L),
                ItemList.Emitter_LuV.get(8L),
                GT_ModHandler.getModItem("appliedenergistics2", "tile.BlockSpatialPylon", 8),
                new Object[]{OrePrefixes.circuit.get(Materials.Master), 8L},
                ItemList.Circuit_Wafer_NPIC.get(32L),
                GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Europium, 64L),
                GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Europium, 64L),
                GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Europium, 64L),
                GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Europium, 64L)
        }, new FluidStack[]{
                Materials.NiobiumTitanium.getMolten(1440L),
                new FluidStack(FluidRegistry.getFluid("ic2coolant"), 2000),
                Materials.Enderium.getMolten(2880L)
        }, GT_ModHandler.getModItem("GraviSuite", "relocator", 1, 26), 8000, 28600);
    }
}
