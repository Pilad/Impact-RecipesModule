package com.impactrecipes.recipes.laser;

import com.impact.common.item.Core_Items;
import com.impact.common.item.Core_Items2;
import com.impact.mods.gregtech.GT_ItemList;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.interfaces.IOreRecipeRegistrator;
import gregtech.api.util.GT_ModHandler;
import gregtech.api.util.GT_OreDictUnificator;
import gregtech.api.util.GT_Utility;
import net.minecraft.item.ItemStack;

import static gregtech.api.enums.GT_Values.RA;

public class LaserEngraver implements IOreRecipeRegistrator {

    public static final Core_Items CoreItems = Core_Items.getInstance();
    public static final Core_Items2 CoreItems2 = Core_Items2.getInstance();

    public LaserEngraver() {
        OrePrefixes.crafting.add(this);
    }

    public void registerOre(OrePrefixes aPrefix, Materials aMaterial, String aOreDictName, String aModName, ItemStack aStack) {
        switch (aOreDictName) {
            case "craftingLensRed":
                RA.addLaserEngraverRecipe(GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Redstone, 1L), GT_Utility.copyAmount(0L, aStack), GT_ItemList.RedstoneRedChipset.get(1L), 50, 120, false);
                RA.addLaserEngraverRecipe(ItemList.EnergyCrystal.get(1L), GT_Utility.copyAmount(0L, aStack), GT_ItemList.EngravedEnergyChip.get(1L), 600, 4096, true);
                RA.addLaserEngraverRecipe(CoreItems2.getRecipe(154, 1), GT_Utility.copyAmount(0L, aStack), GT_ModHandler.getModItem("OpenComputers", "item", 16L, 24), 600, 120, false);
                RA.addLaserEngraverRecipe(GT_ModHandler.getModItem("ProjRed|Core", "projectred.core.part", 1L, 5), GT_Utility.copyAmount(0L, aStack), GT_ModHandler.getModItem("ProjRed|Core", "projectred.core.part", 1L, 6), 500, 30, false);

                break;
            case "craftingLensGreen":
                RA.addLaserEngraverRecipe(ItemList.LapotronCrystal.get(1L), GT_Utility.copyAmount(0L, aStack), CoreItems2.getRecipe(46, 1), 600, 480, true);
                RA.addLaserEngraverRecipe(ItemList.EnergyCrystal.get(1L), GT_Utility.copyAmount(0L, aStack), CoreItems2.getRecipe(100, 1), 300, 120, false);
                RA.addLaserEngraverRecipe(CoreItems2.getRecipe(155, 1), GT_Utility.copyAmount(0L, aStack), GT_ModHandler.getModItem("OpenComputers", "item", 9L, 25), 600, 256, false);
                RA.addLaserEngraverRecipe(GT_OreDictUnificator.get(OrePrefixes.plateDense, Materials.Steel, 1L), GT_Utility.copyAmount(0L, aStack), GT_ModHandler.getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1L, 15), 6000, 480, false);

                break;
            case "craftingLensWhite":
                RA.addLaserEngraverRecipe(GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Diamond, 4L), GT_Utility.copyAmount(0L, aStack), GT_ItemList.EngravedDiamondCrystalChip.get(1L), 400, 1920, true);
                RA.addLaserEngraverRecipe(GT_OreDictUnificator.get(OrePrefixes.plateDense, Materials.Steel, 1L), GT_Utility.copyAmount(0L, aStack), GT_ModHandler.getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1L, 19), 6000, 480, false);

                break;
            case "craftingLensYellow":
                RA.addLaserEngraverRecipe(GT_OreDictUnificator.get(OrePrefixes.gemExquisite, Materials.GarnetYellow, 1L), GT_Utility.copyAmount(0L, aStack), GT_ItemList.EngravedQuantumChip.get(1L), 1200, 30720, true);
                RA.addLaserEngraverRecipe(GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Gold, 4L), GT_Utility.copyAmount(0L, aStack), GT_ItemList.EngravedGoldChip.get(1L), 300, 480, false);
                RA.addLaserEngraverRecipe(CoreItems2.getRecipe(156, 1), GT_Utility.copyAmount(0L, aStack), GT_ModHandler.getModItem("OpenComputers", "item", 6L, 26), 600, 480, true);
                RA.addLaserEngraverRecipe(GT_OreDictUnificator.get(OrePrefixes.plateDense, Materials.Steel, 1L), GT_Utility.copyAmount(0L, aStack), GT_ModHandler.getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1L, 14), 6000, 480, false);
                break;
            case "craftingLensBlue":
                RA.addLaserEngraverRecipe(GT_OreDictUnificator.get(OrePrefixes.plateDense, Materials.Steel, 1L), GT_Utility.copyAmount(0L, aStack), GT_ModHandler.getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1L, 13), 6000, 480, false);
                break;
            case "craftingLensPurple":
                RA.addLaserEngraverRecipe(CoreItems2.getRecipe(195, 3), GT_Utility.copyAmount(0L, aStack), CoreItems2.getRecipe(196, 1), 1200, 480, false);
                break;
        }
    }
}
