package com.impactrecipes.recipes;

import com.impact.common.item.Core_Items;
import com.impact.common.item.Core_Items2;
import cpw.mods.fml.common.Loader;
import gregtech.api.GregTech_API;
import gregtech.api.enums.*;
import gregtech.api.util.GT_ModHandler;
import gregtech.api.util.GT_OreDictUnificator;
import gregtech.api.util.GT_Utility;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;

import static gregtech.api.enums.GT_Values.RA;
import static gregtech.api.util.GT_ModHandler.removeRecipeByOutput;

public class Forestry implements Runnable {

    private static final long tBitMask = GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE;

    final Core_Items2 CoreItems2 = Core_Items2.getInstance();

    @Override
    public void run() {
        removeForestry();
        hand();
        alloySmelter();
        assembler();
        ciruit();
        press();
        fluidSolidifier();
    }

    private void removeForestry() {
        removeRecipeByOutput(GT_ModHandler.getModItem("Forestry", "apiaristBag", 1L, 0), true, false,
                true);
        removeRecipeByOutput(GT_ModHandler.getModItem("Forestry", "lepidopteristBag", 1L, 0), true,
                false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("Forestry", "minerBag", 1L, 0), true, false,
                true);
        removeRecipeByOutput(GT_ModHandler.getModItem("Forestry", "diggerBag", 1L, 0), true, false,
                true);
        removeRecipeByOutput(GT_ModHandler.getModItem("Forestry", "foresterBag", 1L, 0), true, false,
                true);
        removeRecipeByOutput(GT_ModHandler.getModItem("Forestry", "hunterBag", 1L, 0), true, false,
                true);
        removeRecipeByOutput(GT_ModHandler.getModItem("Forestry", "adventurerBag", 1L, 0), true, false,
                true);
        removeRecipeByOutput(GT_ModHandler.getModItem("Forestry", "builderBag", 1L, 0), true, false,
                true);
        removeRecipeByOutput(GT_ModHandler.getModItem("Forestry", "bronzePickaxe", 1L, 0), true, false,
                true);
        removeRecipeByOutput(GT_ModHandler.getModItem("Forestry", "bronzeShovel", 1L, 0), true, false,
                true);
        removeRecipeByOutput(GT_ModHandler.getModItem("Forestry", "wrench", 1L, 0), true, false,
                true);
    }

    private void hand() {
        // --- Apiarist's Backpack
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("Forestry", "apiaristBag", 1L, 0), tBitMask, new Object[]{"WRW", "WBW", "WCW", 'R', OrePrefixes.ring.get(Materials.Iron), 'B', GT_ModHandler.getModItem("Backpack", "backpack", 1L, 0), 'C', GT_ModHandler.getModItem("Forestry", "apicultureChest", 1L, 0), 'W', "blockWool"});
        // --- Lepidopterist's Backpack
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("Forestry", "lepidopteristBag", 1L, 0), tBitMask, new Object[]{"WRW", "WBW", "WCW", 'R', OrePrefixes.ring.get(Materials.Iron), 'B', GT_ModHandler.getModItem("Backpack", "backpack", 1L, 0), 'C', GT_ModHandler.getModItem("Forestry", "lepidopterology", 1L, 0), 'W', "blockWool"});
        // --- Miner's Backpack
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("Forestry", "minerBag", 1L, 0), tBitMask, new Object[]{"WRW", "WBW", "WCW", 'R', OrePrefixes.ring.get(Materials.Iron), 'B', GT_ModHandler.getModItem("Backpack", "backpack", 1L, 0), 'C', OrePrefixes.plate.get(Materials.Iron), 'W', "blockWool"});
        // --- Digger's Backpack
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("Forestry", "diggerBag", 1L, 0), tBitMask, new Object[]{"WRW", "WBW", "WCW", 'R', OrePrefixes.ring.get(Materials.Iron), 'B', GT_ModHandler.getModItem("Backpack", "backpack", 1L, 0), 'C', "stone", 'W', "blockWool"});
        // --- Forester's Backpack
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("Forestry", "foresterBag", 1L, 0), tBitMask, new Object[]{"WRW", "WBW", "WCW", 'R', OrePrefixes.ring.get(Materials.Iron), 'B', GT_ModHandler.getModItem("Backpack", "backpack", 1L, 0), 'C', "logWood", 'W', "blockWool"});
        // --- Hunter's Backpack
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("Forestry", "hunterBag", 1L, 0), tBitMask, new Object[]{"WRW", "WBW", "WCW", 'R', OrePrefixes.ring.get(Materials.Iron), 'B', GT_ModHandler.getModItem("Backpack", "backpack", 1L, 0), 'C', GT_ModHandler.getModItem("minecraft", "feather", 1L, 0), 'W', "blockWool"});
        // --- Builder's Backpack
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("Forestry", "builderBag", 1L, 0), tBitMask, new Object[]{"WRW", "WBW", "WCW", 'R', OrePrefixes.ring.get(Materials.Iron), 'B', GT_ModHandler.getModItem("Backpack", "backpack", 1L, 0), 'C', GT_ModHandler.getModItem("minecraft", "fence", 1L, 0), 'W', "blockWool"});

        // --- Miner's Woven Backpack
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("Forestry", "minerBagT2", 1L, 0), tBitMask, new Object[]{"WRW", "WBW", "WCW", 'R', OrePrefixes.ring.get(Materials.Steel), 'B', GT_ModHandler.getModItem("Forestry", "minerBag", 1L, 0), 'C', GT_ModHandler.getModItem("Backpack", "backpack", 1L, 100), 'W', GT_ModHandler.getModItem("Backpack", "tannedLeather", 1L, 0)});
        // --- Digger's Woven Backpack
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("Forestry", "diggerBagT2", 1L, 0), tBitMask, new Object[]{"WRW", "WBW", "WCW", 'R', OrePrefixes.ring.get(Materials.Steel), 'B', GT_ModHandler.getModItem("Forestry", "diggerBag", 1L, 0), 'C', GT_ModHandler.getModItem("Backpack", "backpack", 1L, 100), 'W', GT_ModHandler.getModItem("Backpack", "tannedLeather", 1L, 0)});
        // --- Forester's Woven Backpack
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("Forestry", "foresterBagT2", 1L, 0), tBitMask, new Object[]{"WRW", "WBW", "WCW", 'R', OrePrefixes.ring.get(Materials.Steel), 'B', GT_ModHandler.getModItem("Forestry", "foresterBag", 1L, 0), 'C', GT_ModHandler.getModItem("Backpack", "backpack", 1L, 100), 'W', GT_ModHandler.getModItem("Backpack", "tannedLeather", 1L, 0)});
        // --- Hunter's Woven Backpack
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("Forestry", "hunterBagT2", 1L, 0), tBitMask, new Object[]{"WRW", "WBW", "WCW", 'R', OrePrefixes.ring.get(Materials.Steel), 'B', GT_ModHandler.getModItem("Forestry", "hunterBag", 1L, 0), 'C', GT_ModHandler.getModItem("Backpack", "backpack", 1L, 100), 'W', GT_ModHandler.getModItem("Backpack", "tannedLeather", 1L, 0)});
        // --- Builder's Woven Backpack
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("Forestry", "builderBagT2", 1L, 0), tBitMask, new Object[]{"WRW", "WBW", "WCW", 'R', OrePrefixes.ring.get(Materials.Steel), 'B', GT_ModHandler.getModItem("Forestry", "builderBag", 1L, 0), 'C', GT_ModHandler.getModItem("Backpack", "backpack", 1L, 100), 'W', GT_ModHandler.getModItem("Backpack", "tannedLeather", 1L, 0)});

        // --- Fence & Stairs
        for (int i = 0; i < 29; i++) {
            GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("Forestry", "fences", 1L, i), tBitMask, new Object[]{"SPS", "SPS", "SPS", 'S', OrePrefixes.stick.get(Materials.Wood), 'P', GT_ModHandler.getModItem("Forestry", "planks", 1L, i)});
            GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("Forestry", "fences", 1L, i), tBitMask, new Object[]{"WdW", "SPS", "SPS", 'W', OrePrefixes.screw.get(Materials.Wood), 'S', OrePrefixes.stick.get(Materials.Wood), 'P', GT_ModHandler.getModItem("Forestry", "planks", 1L, i)});
            GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("Forestry", "fences", 2L, i), tBitMask, new Object[]{"WdW", "SPS", "SPS", 'W', OrePrefixes.screw.get(Materials.Iron), 'S', OrePrefixes.stick.get(Materials.Wood), 'P', GT_ModHandler.getModItem("Forestry", "planks", 1L, i)});
            GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("Forestry", "fences", 4L, i), tBitMask, new Object[]{"WdW", "SPS", "SPS", 'W', OrePrefixes.screw.get(Materials.Steel), 'S', OrePrefixes.stick.get(Materials.Wood), 'P', GT_ModHandler.getModItem("Forestry", "planks", 1L, i)});

            GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("Forestry", "fencesFireproof", 1L, i), tBitMask, new Object[]{"SPS", "SPS", "SPS", 'S', OrePrefixes.stick.get(Materials.Wood), 'P', GT_ModHandler.getModItem("Forestry", "planksFireproof", 1L, i)});
            GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("Forestry", "fencesFireproof", 1L, i), tBitMask, new Object[]{"WdW", "SPS", "SPS", 'W', OrePrefixes.screw.get(Materials.Wood), 'S', OrePrefixes.stick.get(Materials.Wood), 'P', GT_ModHandler.getModItem("Forestry", "planksFireproof", 1L, i)});
            GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("Forestry", "fencesFireproof", 2L, i), tBitMask, new Object[]{"WdW", "SPS", "SPS", 'W', OrePrefixes.screw.get(Materials.Iron), 'S', OrePrefixes.stick.get(Materials.Wood), 'P', GT_ModHandler.getModItem("Forestry", "planksFireproof", 1L, i)});
            GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("Forestry", "fencesFireproof", 4L, i), tBitMask, new Object[]{"WdW", "SPS", "SPS", 'W', OrePrefixes.screw.get(Materials.Steel), 'S', OrePrefixes.stick.get(Materials.Wood), 'P', GT_ModHandler.getModItem("Forestry", "planksFireproof", 1L, i)});

            GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("Forestry", "stairs", 2L, i), tBitMask, new Object[]{"sP", "PP", 'P', GT_ModHandler.getModItem("Forestry", "slabs", 1L, i)});
            GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("Forestry", "stairs", 4L, i), tBitMask, new Object[]{"sP", "PP", 'P', GT_ModHandler.getModItem("Forestry", "planks", 1L, i)});

            GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("Forestry", "stairsFireproof", 2L, i), tBitMask, new Object[]{"sP", "PP", 'P', GT_ModHandler.getModItem("Forestry", "slabsFireproof", 1L, i)});
            GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("Forestry", "stairsFireproof", 4L, i), tBitMask, new Object[]{"sP", "PP", 'P', GT_ModHandler.getModItem("Forestry", "planksFireproof", 1L, i)});
        }

        // --- Spectacles
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("Forestry", "naturalistHelmet", 1L),
                tBitMask, new Object[]{"SRS", "L L", 'S', OrePrefixes.screw.get(Materials.Iron),
                        'R', OrePrefixes.ring.get(Materials.Iron), 'L', OrePrefixes.lens.get(Materials.Glass)});
        // --- Proven Grafter
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("Forestry", "grafterProven", 1L, 0),
                tBitMask, new Object[]{" I ", "fI ", "PNh", 'I', OrePrefixes.stick.get(Materials.Wood),
                        'P', OrePrefixes.plate.get(Materials.Steel), 'N', OrePrefixes.ingot.get(Materials.Steel)});

    }

    private void alloySmelter() {
        RA.addAlloySmelterRecipe(GT_ModHandler.getModItem("Forestry", "beeswax", 9L),
                ItemList.Shape_Mold_Block.get(0), GT_ModHandler.getModItem("Forestry", "waxCast", 1L),
                200, 16);
        RA.addAlloySmelterRecipe(GT_ModHandler.getModItem("Forestry", "refractoryWax", 9L),
                ItemList.Shape_Mold_Block.get(0), GT_ModHandler.getModItem("Forestry", "waxCast", 1L),
                200, 16);
    }

    private void assembler() {
        if (Loader.isModLoaded("Natura")) {
            RA.addAssemblerRecipe(
                    new ItemStack[]{GT_ModHandler.getModItem("Natura", "Natura.fence", 1L),
                            ItemList.Plank_Oak.get(1L)}, Materials.Redstone.getMolten(72L),
                    CoreItems2.getRecipe(53, 1), 100, 30, false);
        }

        RA.addAssemblerRecipe(
                new ItemStack[]{GT_ModHandler.getModItem("Forestry", "fences", 1L),
                        ItemList.Plank_Oak.get(1L)}, Materials.Redstone.getMolten(72L),
                CoreItems2.getRecipe(53, 1), 100, 30, false);
        RA.addAssemblerRecipe(
                new ItemStack[]{GT_ModHandler.getModItem("Forestry", "fencesFireproof", 1L),
                        ItemList.Plank_Oak.get(1L)}, Materials.Redstone.getMolten(72L),
                CoreItems2.getRecipe(53, 1), 100, 30, false);

        // --- Fences & Stairs
        for (int i = 0; i < 29; i++) {
            RA.addAssemblerRecipe(
                    new ItemStack[]{GT_ModHandler.getModItem("Forestry", "planks", 2L, i),
                            GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 2L),
                            GT_Utility.getIntegratedCircuit(10)}, null,
                    GT_ModHandler.getModItem("Forestry", "fences", 1L, i), 300, 8);
            RA.addAssemblerRecipe(
                    new ItemStack[]{GT_ModHandler.getModItem("Forestry", "planks", 2L, i),
                            GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 2L),
                            GT_Utility.getIntegratedCircuit(11)}, Materials.Iron.getMolten(16),
                    GT_ModHandler.getModItem("Forestry", "fences", 2L, i), 300, 8);
            RA.addAssemblerRecipe(
                    new ItemStack[]{GT_ModHandler.getModItem("Forestry", "planks", 2L, i),
                            GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 2L),
                            GT_Utility.getIntegratedCircuit(11)}, Materials.Steel.getMolten(16),
                    GT_ModHandler.getModItem("Forestry", "fences", 4L, i), 300, 8);

            RA.addAssemblerRecipe(
                    new ItemStack[]{GT_ModHandler.getModItem("Forestry", "planksFireproof", 2L, i),
                            GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 2L),
                            GT_Utility.getIntegratedCircuit(10)}, null,
                    GT_ModHandler.getModItem("Forestry", "fencesFireproof", 1L, i), 300, 8);
            RA.addAssemblerRecipe(
                    new ItemStack[]{GT_ModHandler.getModItem("Forestry", "planksFireproof", 2L, i),
                            GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 2L),
                            GT_Utility.getIntegratedCircuit(11)}, Materials.Iron.getMolten(16),
                    GT_ModHandler.getModItem("Forestry", "fencesFireproof", 2L, i), 300, 8);
            RA.addAssemblerRecipe(
                    new ItemStack[]{GT_ModHandler.getModItem("Forestry", "planksFireproof", 2L, i),
                            GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 2L),
                            GT_Utility.getIntegratedCircuit(11)}, Materials.Steel.getMolten(16),
                    GT_ModHandler.getModItem("Forestry", "fencesFireproof", 4L, i), 300, 8);

            RA.addAssemblerRecipe(
                    new ItemStack[]{GT_ModHandler.getModItem("Forestry", "slabs", 3L, i),
                            GT_Utility.getIntegratedCircuit(7)}, null,
                    GT_ModHandler.getModItem("Forestry", "stairs", 2L, i), 300, 8);
            RA.addAssemblerRecipe(
                    new ItemStack[]{GT_ModHandler.getModItem("Forestry", "planks", 3L, i),
                            GT_Utility.getIntegratedCircuit(7)}, null,
                    GT_ModHandler.getModItem("Forestry", "stairs", 4L, i), 300, 8);

            RA.addAssemblerRecipe(
                    new ItemStack[]{GT_ModHandler.getModItem("Forestry", "slabsFireproof", 3L, i),
                            GT_Utility.getIntegratedCircuit(7)}, null,
                    GT_ModHandler.getModItem("Forestry", "stairsFireproof", 2L, i), 300, 8);
            RA.addAssemblerRecipe(
                    new ItemStack[]{GT_ModHandler.getModItem("Forestry", "planksFireproof", 3L, i),
                            GT_Utility.getIntegratedCircuit(7)}, null,
                    GT_ModHandler.getModItem("Forestry", "stairsFireproof", 4L, i), 300, 8);
        }
    }

    private void ciruit() {
                //ALL Circuits
                //Forestry Chipsets
                RA.addCircuitAssemblerRecipe(
                        new ItemStack[]{ItemList.Circuit_Board_Coated_Basic.get(1L),
                                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Primitive, 2),
                                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Tin, 2),
                                GT_OreDictUnificator.get(OrePrefixes.screw, Materials.Tin, 4),
                                GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Tin, 1),
                                GT_Utility.getIntegratedCircuit(1)}, Materials.SolderingAlloy.getMolten(576L),
                        GT_ModHandler.getModItem("Forestry", "chipsets", 1L, 0), 200, 30);
                RA.addCircuitAssemblerRecipe(
                        new ItemStack[]{ItemList.Circuit_Board_Coated_Basic.get(1L),
                                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Basic, 2),
                                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Bronze, 2),
                                GT_OreDictUnificator.get(OrePrefixes.screw, Materials.Bronze, 4),
                                GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Bronze, 1),
                                GT_Utility.getIntegratedCircuit(1)}, Materials.SolderingAlloy.getMolten(576L),
                        GT_ModHandler.getModItem("Forestry", "chipsets", 1L, 1), 200, 30);
                RA.addCircuitAssemblerRecipe(
                        new ItemStack[]{ItemList.Circuit_Board_Phenolic_Good.get(1L),
                                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Good, 2),
                                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Steel, 2),
                                GT_OreDictUnificator.get(OrePrefixes.screw, Materials.Steel, 4),
                                GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Steel, 1),
                                GT_Utility.getIntegratedCircuit(1)}, Materials.SolderingAlloy.getMolten(576L),
                        GT_ModHandler.getModItem("Forestry", "chipsets", 1L, 2), 200, 30);
                RA.addCircuitAssemblerRecipe(
                        new ItemStack[]{ItemList.Circuit_Board_Phenolic_Good.get(1L),
                                ItemList.Circuit_Integrated_Good.get(2L),
                                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Electrum, 2),
                                GT_OreDictUnificator.get(OrePrefixes.screw, Materials.Electrum, 4),
                                GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Electrum, 1),
                                GT_Utility.getIntegratedCircuit(1)}, Materials.SolderingAlloy.getMolten(576L),
                        GT_ModHandler.getModItem("Forestry", "chipsets", 1L, 3), 200, 30);
    }

    private void press() {
        // --- Wax Cast
        GT_Values.RA
                .addFormingPressRecipe(GT_ModHandler.getModItem("Forestry", "beeswax", 9L),
                        ItemList.Shape_Mold_Block.get(0), GT_ModHandler.getModItem("Forestry", "waxCast", 1L), 100, 30);
        GT_Values.RA
                .addFormingPressRecipe(GT_ModHandler.getModItem("Forestry", "refractoryWax", 9L),
                        ItemList.Shape_Mold_Block.get(0), GT_ModHandler.getModItem("Forestry", "waxCast", 1L), 100, 30);

    }

    private void fluidSolidifier() {
        GT_Values.RA
                .addFluidSolidifierRecipe(ItemList.Shape_Mold_Nugget.get(1), new FluidStack(FluidRegistry.getFluid("for.honey"), 200),
                        GT_ModHandler.getModItem("Forestry", "honeyDrop", 1L), 400, 8);
    }
}
