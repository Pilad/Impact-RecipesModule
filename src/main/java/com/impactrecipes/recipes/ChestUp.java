package com.impactrecipes.recipes;

import gregtech.api.enums.GT_Values;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.util.GT_ModHandler;
import gregtech.api.util.GT_OreDictUnificator;
import gregtech.api.util.GT_Utility;
import net.minecraft.item.ItemStack;

import static gregtech.api.enums.GT_Values.RA;

public class ChestUp implements Runnable {

    private static final long tBitMask = GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE;

    @Override
    public void run() {
        hand();
        assembler();
    }

    private void hand() {
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("chestup", "Blockchestup", 1L, 0), tBitMask, new Object[]{"SPS", "PCP", "dPh", 'S', OrePrefixes.screw.get(Materials.WroughtIron), 'P', OrePrefixes.plateDouble.get(Materials.WroughtIron), 'C', GT_ModHandler.getModItem("minecraft", "chest", 1L, 0)});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("chestup", "Blockchestup", 1L, 1), tBitMask, new Object[]{"SPS", "PCP", "dPh", 'S', OrePrefixes.screw.get(Materials.Steel), 'P', OrePrefixes.plateDouble.get(Materials.Steel), 'C', GT_ModHandler.getModItem("chestup", "Blockchestup", 1L, 0)});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("chestup", "Blockchestup", 1L, 2), tBitMask, new Object[]{"SPS", "PCP", "dPh", 'S', OrePrefixes.screw.get(Materials.Aluminium), 'P', OrePrefixes.plateDouble.get(Materials.Aluminium), 'C', GT_ModHandler.getModItem("chestup", "Blockchestup", 1L, 1)});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("chestup", "Blockchestup", 1L, 3), tBitMask, new Object[]{"SPS", "PCP", "dPh", 'S', OrePrefixes.screw.get(Materials.HSLA), 'P', OrePrefixes.plateDouble.get(Materials.HSLA), 'C', GT_ModHandler.getModItem("chestup", "Blockchestup", 1L, 2)});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("chestup", "Blockchestup", 1L, 4), tBitMask, new Object[]{"SPS", "PCP", "dPh", 'S', OrePrefixes.screw.get(Materials.Titanium), 'P', OrePrefixes.plateDouble.get(Materials.Titanium), 'C', GT_ModHandler.getModItem("chestup", "Blockchestup", 1L, 3)});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("chestup", "Blockchestup", 1L, 5), tBitMask, new Object[]{"SPS", "PCP", "dPh", 'S', OrePrefixes.screw.get(Materials.TungstenSteel), 'P', OrePrefixes.plateDouble.get(Materials.TungstenSteel), 'C', GT_ModHandler.getModItem("chestup", "Blockchestup", 1L, 4)});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("chestup", "Blockchestup", 1L, 6), tBitMask, new Object[]{"SPS", "PCP", "dPh", 'S', OrePrefixes.screw.get(Materials.Chrome), 'P', OrePrefixes.plateDouble.get(Materials.Chrome), 'C', GT_ModHandler.getModItem("chestup", "Blockchestup", 1L, 5)});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("chestup", "Blockchestup", 1L, 7), tBitMask, new Object[]{"SPS", "PCP", "dPh", 'S', OrePrefixes.screw.get(Materials.Iridium), 'P', OrePrefixes.plateDouble.get(Materials.Iridium), 'C', GT_ModHandler.getModItem("chestup", "Blockchestup", 1L, 6)});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("chestup", "Blockchestup", 1L, 8), tBitMask, new Object[]{"SPS", "PCP", "dPh", 'S', OrePrefixes.screw.get(Materials.Osmium), 'P', OrePrefixes.plateDouble.get(Materials.Osmium), 'C', GT_ModHandler.getModItem("chestup", "Blockchestup", 1L, 7)});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("chestup", "Blockchestup", 1L, 9), tBitMask, new Object[]{"SPS", "PCP", "dPh", 'S', OrePrefixes.screw.get(Materials.Neutronium), 'P', OrePrefixes.plateDouble.get(Materials.Neutronium), 'C', GT_ModHandler.getModItem("chestup", "Blockchestup", 1L, 8)});

        //GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("chestup", "WOODWRIRONUpgrade", 1L, 0), tBitMask, new Object[]{"SPS", "PCP", "dPh", 'S', OrePrefixes.screw.get(Materials.WroughtIron), 'P', OrePrefixes.plateDouble.get(Materials.WroughtIron), 'C', OrePrefixes.plate.get(Materials.Wood)});
        //GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("chestup", "WRIRONSTEELUpgrade", 1L, 0), tBitMask, new Object[]{"SPS", "PCP", "dPh", 'S', OrePrefixes.screw.get(Materials.Steel), 'P', OrePrefixes.plateDouble.get(Materials.Steel), 'C', OrePrefixes.plate.get(Materials.WroughtIron)});
        //GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("chestup", "STEELALUMINIUMUpgrade", 1L, 0), tBitMask, new Object[]{"SPS", "PCP", "dPh", 'S', OrePrefixes.screw.get(Materials.Aluminium), 'P', OrePrefixes.plateDouble.get(Materials.Aluminium), 'C', OrePrefixes.plate.get(Materials.Steel)});
        //GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("chestup", "ALUMINIUMHSLAUpgrade", 1L, 0), tBitMask, new Object[]{"SPS", "PCP", "dPh", 'S', OrePrefixes.screw.get(Materials.HSLA), 'P', OrePrefixes.plateDouble.get(Materials.HSLA), 'C', OrePrefixes.plate.get(Materials.Aluminium)});
        //GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("chestup", "HSLATITANIUMUpgrade", 1L, 0), tBitMask, new Object[]{"SPS", "PCP", "dPh", 'S', OrePrefixes.screw.get(Materials.Titanium), 'P', OrePrefixes.plateDouble.get(Materials.Titanium), 'C', OrePrefixes.plate.get(Materials.HSLA)});
        //GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("chestup", "TITANIUMWOLFRAMUpgrade", 1L, 0), tBitMask, new Object[]{"SPS", "PCP", "dPh", 'S', OrePrefixes.screw.get(Materials.TungstenSteel), 'P', OrePrefixes.plateDouble.get(Materials.TungstenSteel), 'C', OrePrefixes.plate.get(Materials.Titanium)});
        //GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("chestup", "WOLFRAMCHROMEUpgrade", 1L, 0), tBitMask, new Object[]{"SPS", "PCP", "dPh", 'S', OrePrefixes.screw.get(Materials.Chrome), 'P', OrePrefixes.plateDouble.get(Materials.Chrome), 'C', OrePrefixes.plate.get(Materials.TungstenSteel)});
        //GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("chestup", "CHROMEIRIDIUMUpgrade", 1L, 0), tBitMask, new Object[]{"SPS", "PCP", "dPh", 'S', OrePrefixes.screw.get(Materials.Iridium), 'P', OrePrefixes.plateDouble.get(Materials.Iridium), 'C', OrePrefixes.plate.get(Materials.Chrome)});
        //GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("chestup", "IRIDIUMOSMIUMUpgrade", 1L, 0), tBitMask, new Object[]{"SPS", "PCP", "dPh", 'S', OrePrefixes.screw.get(Materials.Osmium), 'P', OrePrefixes.plateDouble.get(Materials.Osmium), 'C', OrePrefixes.plate.get(Materials.Iridium)});
        //GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("chestup", "OSMIUMNEUTRONIUMUpgrade", 1L, 0), tBitMask, new Object[]{"SPS", "PCP", "dPh", 'S', OrePrefixes.screw.get(Materials.Neutronium), 'P', OrePrefixes.plateDouble.get(Materials.Neutronium), 'C', OrePrefixes.plate.get(Materials.Osmium)});

    }

    private void assembler() {
        RA.addAssemblerRecipe(
                new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.plate, Materials.WroughtIron, 8),
                        GT_ModHandler.getModItem("minecraft", "chest", 1L),
                        GT_Utility.getIntegratedCircuit(10)}, null,
                GT_ModHandler.getModItem("chestup", "Blockchestup", 1L, 0), 80, 8);
        RA.addAssemblerRecipe(
                new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Steel, 8),
                        GT_ModHandler.getModItem("chestup", "Blockchestup", 1L, 0),
                        GT_Utility.getIntegratedCircuit(10)}, null,
                GT_ModHandler.getModItem("chestup", "Blockchestup", 1L, 1), 90, 16);
        RA.addAssemblerRecipe(
                new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Aluminium, 8),
                        GT_ModHandler.getModItem("chestup", "Blockchestup", 1L, 1),
                        GT_Utility.getIntegratedCircuit(10)}, null,
                GT_ModHandler.getModItem("chestup", "Blockchestup", 1L, 2), 100, 64);
        RA.addAssemblerRecipe(
                new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.plate, Materials.HSLA, 8),
                        GT_ModHandler.getModItem("chestup", "Blockchestup", 1L, 2),
                        GT_Utility.getIntegratedCircuit(10)}, null,
                GT_ModHandler.getModItem("chestup", "Blockchestup", 1L, 3), 110, 256);
        RA.addAssemblerRecipe(
                new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Titanium, 8),
                        GT_ModHandler.getModItem("chestup", "Blockchestup", 1L, 3),
                        GT_Utility.getIntegratedCircuit(10)}, null,
                GT_ModHandler.getModItem("chestup", "Blockchestup", 1L, 4), 120, 1024);
        RA.addAssemblerRecipe(
                new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.plate, Materials.TungstenSteel, 8),
                        GT_ModHandler.getModItem("chestup", "Blockchestup", 1L, 4),
                        GT_Utility.getIntegratedCircuit(10)}, null,
                GT_ModHandler.getModItem("chestup", "Blockchestup", 1L, 5), 130, 4096);
        RA.addAssemblerRecipe(
                new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Chrome, 8),
                        GT_ModHandler.getModItem("chestup", "Blockchestup", 1L, 5),
                        GT_Utility.getIntegratedCircuit(10)}, null,
                GT_ModHandler.getModItem("chestup", "Blockchestup", 1L, 6), 140, 16384);
        RA.addAssemblerRecipe(
                new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Iridium, 8),
                        GT_ModHandler.getModItem("chestup", "Blockchestup", 1L, 6),
                        GT_Utility.getIntegratedCircuit(10)}, null,
                GT_ModHandler.getModItem("chestup", "Blockchestup", 1L, 7), 150, 65536);
        RA.addAssemblerRecipe(
                new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Osmium, 8),
                        GT_ModHandler.getModItem("chestup", "Blockchestup", 1L, 7),
                        GT_Utility.getIntegratedCircuit(10)}, null,
                GT_ModHandler.getModItem("chestup", "Blockchestup", 1L, 8), 160, 262144);
        RA.addAssemblerRecipe(
                new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Neutronium, 8),
                        GT_ModHandler.getModItem("chestup", "Blockchestup", 1L, 8),
                        GT_Utility.getIntegratedCircuit(10)}, null,
                GT_ModHandler.getModItem("chestup", "Blockchestup", 1L, 9), 170, 1048576);

    }
}
