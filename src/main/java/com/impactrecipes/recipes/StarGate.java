package com.impactrecipes.recipes;

import com.impact.common.item.Core_Items;
import com.impact.common.item.Core_Items2;
import gregtech.api.enums.GT_Values;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.util.GT_ModHandler;
import gregtech.api.util.GT_OreDictUnificator;
import net.minecraft.item.ItemStack;

import static gregtech.api.enums.GT_Values.RA;
import static gregtech.api.util.GT_ModHandler.removeRecipeByOutput;

public class StarGate implements Runnable {

    final Core_Items2 CoreItems2 = Core_Items2.getInstance();
    final Core_Items CoreItems = Core_Items.getInstance();

    @Override
    public void run() {
        removeSG();
        printer3d();
        assembler();
        autoclave();
    }

    private void removeSG() {
        removeRecipeByOutput(GT_ModHandler.getModItem("SGCraft", "sgChevronUpgrade", 1L, 0));
        removeRecipeByOutput(GT_ModHandler.getModItem("SGCraft", "stargateRing", 1L, 1));
        removeRecipeByOutput(GT_ModHandler.getModItem("SGCraft", "stargateRing", 1L, 0));
        removeRecipeByOutput(GT_ModHandler.getModItem("SGCraft", "stargateBase", 1L, 0));
        removeRecipeByOutput(GT_ModHandler.getModItem("SGCraft", "stargateController", 1L, 0));
        removeRecipeByOutput(GT_ModHandler.getModItem("SGCraft", "ic2PowerUnit", 1L, 0));
        removeRecipeByOutput(GT_ModHandler.getModItem("SGCraft", "sgIrisUpgrade", 1L, 0));
        removeRecipeByOutput(GT_ModHandler.getModItem("SGCraft", "sgIrisBlade", 1L, 0));
        removeRecipeByOutput(GT_ModHandler.getModItem("SGCraft", "ocInterface", 1L, 0));
        removeRecipeByOutput(GT_ModHandler.getModItem("SGCraft", "ic2Capacitor", 1L, 0));
    }

    private void  printer3d() {
        //Stargate Base
        RA.addBasicLineRecipe(new ItemStack[]{
                GT_OreDictUnificator.get(OrePrefixes.block, Materials.NaquadahAlloy, 6),
                GT_ModHandler.getModItem("SGCraft", "stargateRing", 4L, 0),
                GT_ModHandler.getModItem("SGCraft", "stargateRing", 1L, 1), ItemList.Emitter_UV.get(1L),
                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Quantum, 1),
                GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Quantum, 32)
        }, GT_ModHandler.getModItem("SGCraft", "stargateBase", 1L, 0), null, 100 * 20, 500000);

        //Stargate Ring Block
        RA.addBasicLineRecipe(new ItemStack[]{
                GT_OreDictUnificator.get(OrePrefixes.block, Materials.NaquadahAlloy, 8),
                CoreItems2.getRecipe(147, 8), CoreItems2.getRecipe(148, 6), CoreItems2.getRecipe(149, 3),
                ItemList.Field_Generator_UV.get(1L),
                GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Quantum, 16)
        }, GT_ModHandler.getModItem("SGCraft", "stargateRing", 1L, 0), null, 50 * 20, 500000);

        //Stargate Chevron Block
        RA.addBasicLineRecipe(new ItemStack[]{
                GT_OreDictUnificator.get(OrePrefixes.block, Materials.NaquadahAlloy, 8),
                ItemList.Sensor_UV.get(4L),
                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Nano, 4),
                GT_ModHandler.getModItem("SGCraft", "sgChevronUpgrade", 1L),
                GT_ModHandler.getModItem("SGCraft", "stargateRing", 1L),
                GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Quantum, 16)
        }, GT_ModHandler.getModItem("SGCraft", "stargateRing", 1L, 1), null, 50 * 20, 500000);

        //IC2 Stargate Power Unit
        RA.addBasicLineRecipe(new ItemStack[]{
                GT_OreDictUnificator.get(OrePrefixes.block, Materials.NaquadahAlloy, 12),
                ItemList.Casing_Coil_Superconductor.get(10L),
                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Nano, 4),
                GT_ModHandler.getModItem("SGCraft", "ic2Capacitor", 4L),
                GT_ModHandler.getModItem("SGCraft", "stargateRing", 1L, 0),
                GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Quantum, 32)
        }, GT_ModHandler.getModItem("SGCraft", "ic2PowerUnit", 1L, 0), null, 100 * 20, 500000);

        //OC Stargate Interface
        RA.addBasicLineRecipe(new ItemStack[]{
                GT_OreDictUnificator.get(OrePrefixes.block, Materials.NaquadahAlloy, 12),
                ItemList.Casing_Coil_Superconductor.get(10L),
                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Nano, 4),
                GT_ModHandler.getModItem("OpenComputers", "item", 16L, 102),
                GT_ModHandler.getModItem("OpenComputers", "case3", 1L),
                GT_ModHandler.getModItem("SGCraft", "stargateRing", 1L, 0),
                GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Quantum, 32)
        }, GT_ModHandler.getModItem("SGCraft", "ocInterface", 1L, 0), null, 100 * 20, 500000);

    }

    private void assembler() {
        // --- Stargate Controller
        RA.addAssemblerRecipe(
                new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.block, Materials.NaquadahAlloy, 24L),
                        ItemList.Sensor_UV.get(4L),
                        GT_ModHandler.getModItem("EnderIO", "blockDarkSteelPressurePlate", 12L),
                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Piko, 1),
                        GT_ModHandler.getModItem("SGCraft", "sgControllerCrystal", 1L, 0)}, null,
                GT_ModHandler.getModItem("SGCraft", "stargateController", 1L, 0), 1000, 500000);
        // --- Stargate Shevron Upgrade
        RA.addAssemblerRecipe(
                new ItemStack[]{CoreItems2.getRecipe(147, 8), CoreItems2.getRecipe(149, 3),
                        ItemList.Electric_Piston_UV.get(6L), ItemList.Field_Generator_UV.get(4L),
                        ItemList.Sensor_UV.get(1L)}, null,
                GT_ModHandler.getModItem("SGCraft", "sgChevronUpgrade", 1L, 0), 1000, 500000);
        // --- Stargate Iris Upgrade
        RA.addAssemblerRecipe(GT_ModHandler.getModItem("SGCraft", "sgIrisBlade", 20L, 0),
                ItemList.Casing_Coil_Superconductor.get(4L),
                GT_ModHandler.getModItem("SGCraft", "sgIrisUpgrade", 1L, 0), 1000, 500000);
        // --- Stargate Iris Blade
        RA.addAssemblerRecipe(
                new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.block, Materials.Titanium, 32L),
                        ItemList.Electric_Piston_UV.get(1L), ItemList.Casing_Coil_Superconductor.get(1L)}, null,
                GT_ModHandler.getModItem("SGCraft", "sgIrisBlade", 1L, 0), 1000, 500000);
        // --- Ridiculously Large Capacitor
        RA.addAssemblerRecipe(
                new ItemStack[]{CoreItems2.getRecipe(148, 12), ItemList.Field_Generator_UV.get(5L),
                        ItemList.ZPM2.get(1L)}, null,
                GT_ModHandler.getModItem("SGCraft", "ic2Capacitor", 1L, 0), 1000, 500000);

    }

    private void autoclave() {
        GT_Values.RA
                .addAutoclaveSpaceRecipe(CoreItems.getRecipe(36, 64), Materials.Silver.getPlasma(8000L),
                        GT_ModHandler.getModItem("SGCraft", "sgCoreCrystal", 1L), 10000, 3600, 131000, true);
        RA.addAutoclaveSpaceRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.DraconiumAwakened, 64L),
                Materials.Silver.getPlasma(8000L),
                GT_ModHandler.getModItem("SGCraft", "sgControllerCrystal", 1L), 10000, 3600, 131000, true);

    }
}
