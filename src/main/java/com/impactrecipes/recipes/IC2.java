package com.impactrecipes.recipes;

import com.impact.common.item.Core_Items;
import com.impact.common.item.Core_Items2;
import cpw.mods.fml.common.Loader;
import gregtech.api.enums.*;
import gregtech.api.util.GT_ModHandler;
import gregtech.api.util.GT_OreDictUnificator;
import gregtech.api.util.GT_Utility;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;

import static com.impact.common.item.Core_List_Items.NeutronReflectorParts;
import static com.impact.common.item.Core_List_Items.NeutronReflectorSmallParts;
import static com.impact.util.Utilits.Itemstack;
import static gregtech.api.enums.GT_Values.RA;
import static gregtech.api.util.GT_ModHandler.removeRecipeByOutput;

public class IC2 implements Runnable {

    private static final long tBitMask = GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE;

    final Core_Items2 CoreItems2 = Core_Items2.getInstance();
    final Core_Items CoreItems = Core_Items.getInstance();

    @Override
    public void run() {
        removeIC2();
        removeCompactGen();
        hand();
        compactGens(); //компакт гены
        thermalCentrifuge();
        printer3d();
        packager();
        formingPress();
        fluidCanner();
        extruder();
        assembler();
        disassembler();
        bender();
        mixer();
        alloySmelter();
    }

    private void removeIC2() {
        removeRecipeByOutput(GT_ModHandler.getModItem("IC2", "blockGenerator", 1L, GT_Values.W), true, false,
                false);
        removeRecipeByOutput(GT_ModHandler.getIC2Item("nanoHelmet", 1, GT_Values.W));
        removeRecipeByOutput(GT_ModHandler.getIC2Item("nanoBodyarmor", 1, GT_Values.W));
        removeRecipeByOutput(GT_ModHandler.getIC2Item("nanoLeggings", 1, GT_Values.W));
        removeRecipeByOutput(GT_ModHandler.getIC2Item("nanoBoots", 1, GT_Values.W));
        removeRecipeByOutput(GT_ModHandler.getIC2Item("quantumHelmet", 1, GT_Values.W));
        removeRecipeByOutput(GT_ModHandler.getIC2Item("quantumBodyarmor", 1, GT_Values.W));
        removeRecipeByOutput(GT_ModHandler.getIC2Item("quantumLeggings", 1, GT_Values.W));
        removeRecipeByOutput(GT_ModHandler.getIC2Item("quantumBoots", 1, GT_Values.W));
        removeRecipeByOutput(GT_ModHandler.getModItem("IC2", "itemBatChargeRE", 1L, GT_Values.W));
        removeRecipeByOutput(GT_ModHandler.getModItem("IC2", "itemBatChargeAdv", 1L, GT_Values.W));
        removeRecipeByOutput(GT_ModHandler.getModItem("IC2", "itemBatChargeCrystal", 1L, GT_Values.W));
        removeRecipeByOutput(
                GT_ModHandler.getModItem("IC2", "itemBatChargeLamaCrystal", 1L, GT_Values.W));
        removeRecipeByOutput(GT_ModHandler.getModItem("IC2", "reactorReflectorThick", 1L, 1), true,
                false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("IC2", "reactorPlating", 1L, 0), true, false,
                true);
        removeRecipeByOutput(GT_ModHandler.getModItem("IC2", "reactorPlatingHeat", 1L, 0), true, false,
                true);
        removeRecipeByOutput(GT_ModHandler.getModItem("IC2", "reactorPlatingExplosive", 1L, 0), true,
                false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("IC2", "reactorVent", 1L, 1), true, false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("IC2", "reactorVentCore", 1L, 1), true, false,
                true);
        removeRecipeByOutput(GT_ModHandler.getModItem("IC2", "reactorVentGold", 1L, 1), true, false,
                true);
        removeRecipeByOutput(GT_ModHandler.getModItem("IC2", "reactorVentSpread", 1L), true, false,
                true);
        removeRecipeByOutput(GT_ModHandler.getModItem("IC2", "reactorVentDiamond", 1L, 1), true, false,
                true);
        removeRecipeByOutput(GT_ModHandler.getModItem("IC2", "reactorHeatSwitch", 1L, 1), true, false,
                true);
        removeRecipeByOutput(GT_ModHandler.getModItem("IC2", "reactorHeatSwitchCore", 1L, 1), true,
                false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("IC2", "reactorHeatSwitchSpread", 1L, 1), true,
                false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("IC2", "reactorHeatSwitchDiamond", 1L, 1), true,
                false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("IC2", "reactorCoolantSimple", 1L, 1), true,
                false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("IC2", "reactorCoolantTriple", 1L, 1), true,
                false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("IC2", "reactorCoolantSix", 1L, 1), true, false,
                true);
        removeRecipeByOutput(GT_ModHandler.getModItem("IC2", "itemTreetapElectric", 1, GT_Values.W), true, false,
                true);
        removeRecipeByOutput(GT_ModHandler.getModItem("IC2", "itemToolHoe", 1, GT_Values.W), true, false,
                true);
        removeRecipeByOutput(GT_ModHandler.getModItem("IC2", "itemRecipePart", 1, 3), true, false,
                true);
        removeRecipeByOutput(GT_ModHandler.getModItem("IC2", "blockChargepad", 1L, GT_Values.W), true, false,
                true);
        removeRecipeByOutput(GT_ModHandler.getModItem("IC2", "itemMOX", 1L), true, false,
                true);
        removeRecipeByOutput(GT_ModHandler.getModItem("IC2", "itemUran", 1L), true, false,
                true);
        removeRecipeByOutput(GT_ModHandler.getModItem("IC2", "reactorUraniumSimple", 1L), true, false,
                true);
        removeRecipeByOutput(GT_ModHandler.getModItem("IC2", "reactorMOXSimple", 1L), true, false,
                true);
        removeRecipeByOutput(GT_ModHandler.getModItem("IC2", "itemToolBronzePickaxe", 1L), true, false,
                true);
        removeRecipeByOutput(GT_ModHandler.getModItem("IC2", "itemToolBronzeAxe", 1L), true, false,
                true);
        removeRecipeByOutput(GT_ModHandler.getModItem("IC2", "itemToolBronzeSpade", 1L), true, false,
                true);
        removeRecipeByOutput(GT_ModHandler.getModItem("IC2", "itemToolBronzeHoe", 1L), true, false,
                true);
        removeRecipeByOutput(GT_ModHandler.getModItem("IC2", "itemToolBronzeSword", 1L), true, false,
                true);
        removeRecipeByOutput(GT_ModHandler.getModItem("IC2", "blockScaffold", 1L), true, false,
                true);
        removeRecipeByOutput(GT_ModHandler.getModItem("IC2", "blockIronScaffold", 1L), true, false,
                true);
        removeRecipeByOutput(GT_ModHandler.getModItem("IC2", "blockKineticGenerator", 1L, GT_Values.W), true, false,
                false);
        removeRecipeByOutput(GT_ModHandler.getModItem("IC2", "blockHeatGenerator", 1L, GT_Values.W), true, false,
                false);
        removeRecipeByOutput(GT_ModHandler.getModItem("IC2", "blockMachine", 1L, GT_Values.W), true, false,
                false);
        removeRecipeByOutput(GT_ModHandler.getModItem("IC2", "blockMachine2", 1L, GT_Values.W), true, false,
                false);
        removeRecipeByOutput(GT_ModHandler.getModItem("IC2", "blockMachine3", 1L, GT_Values.W), true, false,
                false);
        removeRecipeByOutput(GT_ModHandler.getModItem("IC2", "blockPersonal", 1L, GT_Values.W), true, false,
                false);
        removeRecipeByOutput(GT_ModHandler.getModItem("IC2", "blockElectric", 1L, GT_Values.W), true, false,
                false);
        removeRecipeByOutput(GT_ModHandler.getModItem("IC2", "itemRecipePart", 1L, GT_Values.W), true, false,
                false);
        removeRecipeByOutput(GT_ModHandler.getModItem("IC2", "itemWeedingTrowel", 1L), true, false,
                false);
        removeRecipeByOutput(GT_ModHandler.getModItem("IC2", "itemArmorHazmatHelmet", 1L), true, false,
                false);
        removeRecipeByOutput(GT_ModHandler.getModItem("IC2", "itemArmorHazmatChestplate", 1L), true, false,
                false);
        removeRecipeByOutput(GT_ModHandler.getModItem("IC2", "itemArmorHazmatLeggings", 1L), true, false,
                false);
        removeRecipeByOutput(GT_ModHandler.getModItem("IC2", "itemArmorRubBoots", 1L), true, false,
                false);
        removeRecipeByOutput(GT_ModHandler.getModItem("IC2", "windmeter", 1L), true, false,
                false);
        removeRecipeByOutput(GT_ModHandler.getModItem("IC2", "obscurator", 1L), true, false,
                false);
        removeRecipeByOutput(GT_ModHandler.getModItem("IC2", "itemArmorCFPack", 1L), true, false,
                false);
        removeRecipeByOutput(GT_ModHandler.getModItem("IC2", "itemFoamSprayer", 1L), true, false,
                false);
        removeRecipeByOutput(GT_ModHandler.getModItem("IC2", "itemToolPainter", 1L), true, false,
                false);
        removeRecipeByOutput(GT_ModHandler.getModItem("IC2", "itemDoorAlloy", 1L), true, false,
                false);
        removeRecipeByOutput(GT_ModHandler.getModItem("IC2", "itemBoat", 1L, 1), true, false,
                false);
        removeRecipeByOutput(GT_ModHandler.getModItem("IC2", "itemBarrel", 1L), true, false,
                false);
        removeRecipeByOutput(GT_ModHandler.getModItem("IC2", "itemScrapbox", 1L), true, false,
                false);
        removeRecipeByOutput(GT_ModHandler.getModItem("IC2", "itemPartCarbonMesh", 1L), true, false,
                false);
        removeRecipeByOutput(GT_ModHandler.getModItem("IC2", "itemFuelPlantBall", 1L), true, false,
                false);
        removeRecipeByOutput(GT_ModHandler.getModItem("IC2", "itemFluidCell", 1L), true, false,
                false);
        removeRecipeByOutput(GT_ModHandler.getModItem("IC2", "itemToolWrench", 1L), true, false,
                false);
        removeRecipeByOutput(GT_ModHandler.getModItem("IC2", "blockReactorChamber", 1L), true, false,
                false);
        removeRecipeByOutput(GT_ModHandler.getModItem("IC2", "blockNuke", 1L), true, false,
                false);
        removeRecipeByOutput(GT_ModHandler.getModItem("IC2", "itemToolbox", 1L), true, false,
                false);
        removeRecipeByOutput(GT_ModHandler.getModItem("IC2", "upgradeModule", 1L, 4), true, false,
                false);
        removeRecipeByOutput(GT_ModHandler.getModItem("IC2", "blockReactorFluidPort", 1L), true, false,
                false);
        removeRecipeByOutput(GT_ModHandler.getModItem("IC2", "blockReactorAccessHatch", 1L), true, false,
                false);
        removeRecipeByOutput(GT_ModHandler.getModItem("IC2", "blockReactorRedstonePort", 1L), true, false,
                false);
        removeRecipeByOutput(GT_ModHandler.getModItem("IC2", "blockreactorvessel", 1L), true, false,
                false);
        removeRecipeByOutput(GT_ModHandler.getModItem("IC2", "itemPartCFPowder", 1L), true, false,
                false);
        removeRecipeByOutput(GT_ModHandler.getModItem("IC2", "itemDynamiteSticky", 1L), true, false,
                false);
        removeRecipeByOutput(GT_ModHandler.getModItem("IC2", "itemMugEmpty", 1L), true, false,
                false);
        removeRecipeByOutput(GT_ModHandler.getModItem("IC2", "itemTreetap", 1L), true, false,
                false);
        removeRecipeByOutput(GT_ModHandler.getModItem("IC2", "upgradeModule", 1L, 5), true, false,
                false);
        removeRecipeByOutput(GT_ModHandler.getModItem("IC2", "blockCrop", 1L, 5), true, false,
                false);
        removeRecipeByOutput(GT_ModHandler.getModItem("IC2", "itemUran235", 1L, 0), true, false,
                false);
        removeRecipeByOutput(GT_ModHandler.getModItem("IC2", "itemUran235small", 1L, 0), true, false,
                false);
    }

    private void removeCompactGen() {
        removeRecipeByOutput(GT_ModHandler.getModItem("compactkineticgenerators", "BlockCkg", 1L, 0),
                true, false, false);
        removeRecipeByOutput(GT_ModHandler.getModItem("compactkineticgenerators", "BlockCkg", 1L, 1),
                true, false, false);
        removeRecipeByOutput(GT_ModHandler.getModItem("compactkineticgenerators", "BlockCkg", 1L, 2),
                true, false, false);
        removeRecipeByOutput(GT_ModHandler.getModItem("compactkineticgenerators", "BlockCkg", 1L, 3),
                true, false, false);
        removeRecipeByOutput(GT_ModHandler.getModItem("compactkineticgenerators", "BlockCkg", 1L, 4),
                true, false, false);
        removeRecipeByOutput(GT_ModHandler.getModItem("compactkineticgenerators", "BlockCkg", 1L, 5),
                true, false, false);
        removeRecipeByOutput(GT_ModHandler.getModItem("compactkineticgenerators", "BlockCkg", 1L, 6),
                true, false, false);
        removeRecipeByOutput(GT_ModHandler.getModItem("compactkineticgenerators", "BlockCkg", 1L, 7),
                true, false, false);
        removeRecipeByOutput(GT_ModHandler.getModItem("compactkineticgenerators", "BlockCkg", 1L, 8),
                true, false, false);
        removeRecipeByOutput(GT_ModHandler.getModItem("compactkineticgenerators", "BlockCkg", 1L, 9),
                true, false, false);
        removeRecipeByOutput(GT_ModHandler.getModItem("compactkineticgenerators", "BlockCkg", 1L, 10),
                true, false, false);
        removeRecipeByOutput(GT_ModHandler.getModItem("compactkineticgenerators", "BlockCkg", 1L, 11),
                true, false, false);
        removeRecipeByOutput(GT_ModHandler.getModItem("compactkineticgenerators", "IridiumRotor", 1L, 0),
                true, false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("compactkineticgenerators", "IridiumBlade", 1L, 0),
                true, false, true);
    }

    private void hand() {
        // --- Frequency Transmitter
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("IC2", "itemFreq", 1L, 0), tBitMask, new Object[]{" S ", "PBP", " C ", 'C', OrePrefixes.circuit.get(Materials.Basic), 'P', OrePrefixes.itemCasing.get(Materials.Iron), 'B', GT_ModHandler.getModItem("minecraft", "stone_button", 1L, 0), 'S', ItemList.Sensor_LV});
        // --- Heat Vent
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("IC2", "reactorVent", 1L, 1), tBitMask, new Object[]{"PBP", "BwB", "PBP", 'P', OrePrefixes.plate.get(Materials.Aluminium), 'B', new ItemStack(Blocks.iron_bars)});
        // --- Reactor Heat Vent
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("IC2", "reactorVentCore", 1L, 1), tBitMask, new Object[]{"CSC", "SVS", "CSC", 'C', OrePrefixes.plateDouble.get(Materials.Copper), 'S', OrePrefixes.plate.get(Materials.Silver), 'V', GT_ModHandler.getModItem("IC2", "reactorVent", 1L, 1)});
        // --- Advanced Heat Vent
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("IC2", "reactorVentDiamond", 1L, 1), tBitMask, new Object[]{"BVB", "BDB", "BVB", 'D', OrePrefixes.gem.get(Materials.Diamond), 'V', GT_ModHandler.getModItem("IC2", "reactorVentCore", 1L, 1), 'B', CoreItems2.getRecipe(51, 1)});
        // --- Overclocked Heat Vent
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("IC2", "reactorVentGold", 1L, 1), tBitMask, new Object[]{"CSC", "SVS", "CSC", 'C', OrePrefixes.screw.get(Materials.StainlessSteel), 'S', OrePrefixes.plate.get(Materials.Gold), 'V', GT_ModHandler.getModItem("IC2", "reactorVentDiamond", 1L, 1)});
        // --- Component Heat Vent
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("IC2", "reactorVentSpread", 1L, 0), tBitMask, new Object[]{"CSC", "SVS", "CSC", 'C', CoreItems2.getRecipe(51, 1), 'S', OrePrefixes.plateDense.get(Materials.Tin), 'V', GT_ModHandler.getModItem("IC2", "reactorVent", 1L, 1)});
        // --- Heat Exchanger
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("IC2", "reactorHeatSwitch", 1L, 1), tBitMask, new Object[]{"COC", "SVS", "CSC", 'C', OrePrefixes.plate.get(Materials.Silver), 'S', OrePrefixes.plate.get(Materials.Aluminium), 'V', OrePrefixes.plate.get(Materials.Copper), 'O', OrePrefixes.circuit.get(Materials.Basic)});
        // --- Reactor Heat Exchanger
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("IC2", "reactorHeatSwitchCore", 1L, 1), tBitMask, new Object[]{"CSC", "SVS", "CSC", 'C', OrePrefixes.plateDouble.get(Materials.Copper), 'S', OrePrefixes.plate.get(Materials.Silver), 'V', GT_ModHandler.getModItem("IC2", "reactorHeatSwitch", 1L, 1)});
        // --- Component Heat Exchanger
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("IC2", "reactorHeatSwitchSpread", 1L, 1), tBitMask, new Object[]{"CSC", "SVS", "CSC", 'C', OrePrefixes.screw.get(Materials.StainlessSteel), 'S', OrePrefixes.plate.get(Materials.Gold), 'V', GT_ModHandler.getModItem("IC2", "reactorHeatSwitchCore", 1L, 1)});
        // --- Advanced Heat Exchanger
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("IC2", "reactorHeatSwitchDiamond", 1L, 1), tBitMask, new Object[]{"LCL", "VDV", "LCL", 'L', OrePrefixes.plate.get(Materials.Lapis), 'D', OrePrefixes.plate.get(Materials.Diamond), 'C', OrePrefixes.circuit.get(Materials.Advanced), 'V', GT_ModHandler.getModItem("IC2", "reactorHeatSwitchSpread", 1L, 1)});
        // --- Electric Wrench
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("IC2","itemToolWrenchElectric",1, 26),tBitMask,
                new Object[] {"dRD","RPB","ECS",'R', OrePrefixes.stick.get(Materials.Steel),'D', OrePrefixes.toolHeadWrench.get(Materials.Steel),
                        'P',ItemList.Electric_Motor_LV,'B', OrePrefixes.battery.get(Materials.Basic),
                        'E',GT_ModHandler.getModItem("IC2","itemRecipePart",1,3),'C', OrePrefixes.cableGt01.get(Materials.Tin),
                        'S', OrePrefixes.screw.get(Materials.Steel)});
        // --- Electric Treetap
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("IC2","itemTreetapElectric",1, 26),tBitMask,
                new Object[] {"dRD","RPB","ECS",'R', OrePrefixes.stickLong.get(Materials.Steel),'D', OrePrefixes.toolHeadDrill.get(Materials.Steel),
                        'P',ItemList.Electric_Pump_LV,'B', OrePrefixes.battery.get(Materials.Basic),
                        'E',GT_ModHandler.getModItem("IC2","itemRecipePart",1,3),'C', OrePrefixes.cableGt01.get(Materials.Tin),
                        'S', OrePrefixes.screw.get(Materials.Steel)});
        // --- Electric Hoe
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("IC2","itemToolHoe",1, 26),tBitMask,
                new Object[] {"dPH","PGB","ECS", 'S', OrePrefixes.screw.get(Materials.Steel),'H', OrePrefixes.toolHeadHoe.get(Materials.Steel),
                        'G', OrePrefixes.gearGtSmall.get(Materials.Steel),'B', OrePrefixes.battery.get(Materials.Basic),
                        'E',GT_ModHandler.getModItem("IC2","itemRecipePart",1,3), 'P', OrePrefixes.plate.get(Materials.Steel),
                        'C', OrePrefixes.cableGt01.get(Materials.Tin)});
        // --- Small Power Unit
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("IC2","itemRecipePart",1, 3),tBitMask,
                new Object[] {"WPW","PdP","CMC",'W', OrePrefixes.cableGt01.get(Materials.Copper),'P', OrePrefixes.itemCasing.get(Materials.Steel),
                        'M',ItemList.Electric_Motor_LV, 'C', OrePrefixes.circuit.get(Materials.Basic)});
        // --- Charge Pad Bat Box
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("IC2","blockChargepad",1, 0),tBitMask,
                new Object[] {"SHS","COC","PdP",'S', OrePrefixes.screw.get(Materials.Steel),'P', OrePrefixes.itemCasing.get(Materials.Steel),
                        'C', OrePrefixes.circuit.get(Materials.Basic), 'H', GT_ModHandler.getModItem("minecraft","wooden_pressure_plate",1,0),
                        'O', GT_ModHandler.getModItem("IC2","blockElectric",1,0)});
        // --- Charge Pad CESU
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("IC2","blockChargepad",1, 1),tBitMask,
                new Object[] {"SHS","COC","PdP",'S', OrePrefixes.screw.get(Materials.Aluminium),'P', OrePrefixes.itemCasing.get(Materials.Aluminium),
                        'C', OrePrefixes.circuit.get(Materials.Good), 'H', GT_ModHandler.getModItem("minecraft","stone_pressure_plate",1,0),
                        'O', GT_ModHandler.getModItem("IC2","blockElectric",1,7)});
        // --- Charge Pad MFE
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("IC2","blockChargepad",1, 2),tBitMask,
                new Object[] {"SHS","COC","PdP",'S', OrePrefixes.screw.get(Materials.StainlessSteel),'P', OrePrefixes.itemCasing.get(Materials.StainlessSteel),
                        'C', OrePrefixes.circuit.get(Materials.Advanced), 'H', GT_ModHandler.getModItem("minecraft","heavy_weighted_pressure_plate",1,0),
                        'O', GT_ModHandler.getModItem("IC2","blockElectric",1,1)});
        // --- Charge Pad MFSU
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("IC2","blockChargepad",1, 3),tBitMask,
                new Object[] {"SHS","COC","PdP",'S', OrePrefixes.screw.get(Materials.Titanium),'P', OrePrefixes.itemCasing.get(Materials.Titanium),
                        'C', OrePrefixes.circuit.get(Materials.Data), 'H', GT_ModHandler.getModItem("minecraft","light_weighted_pressure_plate",1,0),
                        'O', GT_ModHandler.getModItem("IC2","blockElectric",1,2)});
        // --- Wood Scaffold
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("IC2","blockScaffold",1), tBitMask,
                new Object[] {"SPS","IdI", 'S', OrePrefixes.screw.get(Materials.Wood),'P', OrePrefixes.plank.get(Materials.Wood),
                        'I', OrePrefixes.stick.get(Materials.Wood)});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("IC2","blockScaffold",2), tBitMask,
                new Object[] {"SPS","IdI", 'S', OrePrefixes.screw.get(Materials.WoodSealed),'P', OrePrefixes.plate.get(Materials.WoodSealed),
                        'I', OrePrefixes.stick.get(Materials.WoodSealed)});
        // --- Iron Scaffold
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("IC2","blockIronScaffold",1), tBitMask,
                new Object[] {"SPS","IdI", 'S', OrePrefixes.screw.get(Materials.Iron),'P', OrePrefixes.plate.get(Materials.Iron),
                        'I', OrePrefixes.stick.get(Materials.Iron)});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("IC2","blockIronScaffold",2), tBitMask,
                new Object[] {"SPS","IdI", 'S', OrePrefixes.screw.get(Materials.Steel),'P', OrePrefixes.plate.get(Materials.Steel),
                        'I', OrePrefixes.stick.get(Materials.Steel)});
        // --- Wood Rotor Blade
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("IC2","itemRecipePart",1, 7), tBitMask,
                new Object[] {"PPP","PRP","PPP",'P', OrePrefixes.plate.get(Materials.Wood), 'R', OrePrefixes.ring.get(Materials.Wood)});
        // --- Iron Rotor Blade
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("IC2","itemRecipePart",1, 8), tBitMask,
                new Object[] {"PPP","PRP","PPP",'P', OrePrefixes.plate.get(Materials.Iron), 'R', OrePrefixes.ring.get(Materials.Steel)});
        // --- Steel Rotor Blade
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("IC2","itemRecipePart",1, 10), tBitMask,
                new Object[] {"PPP","PRP","PPP",'P', OrePrefixes.plate.get(Materials.Steel), 'R', OrePrefixes.ring.get(Materials.TungstenSteel)});
        // --- Carbon Rotor Blade
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("IC2","itemRecipePart",1, 9), tBitMask,
                new Object[] {"PPP","PRP","PPP",'P', OrePrefixes.plateAlloy.get(Materials.Carbon), 'R', OrePrefixes.ring.get(Materials.Iridium)});
        // --- Weeding Trowel
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("IC2","itemWeedingTrowel",1), tBitMask,
                new Object[] {"SId","PII","IPS",'P', OrePrefixes.plate.get(Materials.Rubber), 'I', OrePrefixes.stick.get(Materials.Steel),
                        'S', OrePrefixes.screw.get(Materials.Steel)});
        // --- BatBox
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("IC2","blockElectric",1), tBitMask,
                new Object[]{"CPC", "BMB", "PBP", 'C', OrePrefixes.cableGt01.get(Materials.Tin), 'P', OrePrefixes.plate.get(Materials.Steel),
                        'B', OrePrefixes.battery.get(Materials.Basic), 'M', ItemList.Battery_Buffer_2by2_LV});
        // --- CESU
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("IC2","blockElectric",1, 7), tBitMask,
                new Object[]{"CPC", "BMB", "PBP", 'C', OrePrefixes.cableGt01.get(Materials.Copper), 'P', OrePrefixes.plate.get(Materials.Bronze),
                        'B', OrePrefixes.battery.get(Materials.Advanced), 'M', ItemList.Battery_Buffer_2by2_MV});
        // --- MFE
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("IC2","blockElectric",1, 1), tBitMask,
                new Object[]{"CPC", "BMB", "PBP", 'C', OrePrefixes.cableGt01.get(Materials.Gold), 'P', OrePrefixes.plate.get(Materials.StainlessSteel),
                        'B', ItemList.Battery_RE_HV_Lithium, 'M', ItemList.Battery_Buffer_2by2_HV});
        // --- MFSU
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("IC2","blockElectric",1, 2), tBitMask,
                new Object[]{"CPC", "BMB", "PAP", 'C', OrePrefixes.cableGt01.get(Materials.Aluminium), 'P', OrePrefixes.plate.get(Materials.Titanium),
                        'B', ItemList.LapotronCrystal, 'M', ItemList.Battery_Buffer_2by2_EV, 'A', OrePrefixes.circuit.get(Materials.Data)});
        // --- Rubber Sheet
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("IC2","blockRubber",1), tBitMask,
                new Object[] {"PPP","PPP",'P', OrePrefixes.plate.get(Materials.Rubber)});
        // --- Empty booze Barrel
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("IC2","itemBarrel",1), tBitMask,
                new Object[] {"PRP","PhP","PRP",'P', OrePrefixes.plate.get(Materials.Wood),
                        'R', OrePrefixes.ring.get(Materials.Iron)});
        // --- Coffee Powder
        GT_ModHandler.addShapelessCraftingRecipe(GT_ModHandler.getModItem("IC2","itemCofeePowder",1), tBitMask,
                new Object[]{ToolDictNames.craftingToolMortar, OrePrefixes.crop.get(Materials.Coffee)});
        // --- Electric Boat
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("IC2","itemBoat",1, 3), tBitMask,
                new Object[] {"PhP","PPP","RMR",'P', OrePrefixes.plate.get(Materials.Steel),
                        'R', OrePrefixes.rotor.get(Materials.Tin), 'M', ItemList.Electric_Motor_LV});
        // --- Rubber Boat
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("IC2","itemBoat",1, 1), tBitMask,
                new Object[] {"PHP","PsP","PPP",'P', OrePrefixes.plate.get(Materials.Rubber),
                        'H', ToolDictNames.craftingToolSoftHammer});
        // --- Rubber Boat repair
        GT_ModHandler.addShapelessCraftingRecipe(GT_ModHandler.getModItem("IC2","itemBoat",1, 1), tBitMask,
                new Object[]{GT_ModHandler.getModItem("IC2","itemBoat",1, 2), OrePrefixes.plate.get(Materials.Rubber),
                        OrePrefixes.plate.get(Materials.Rubber), ToolDictNames.craftingToolHardHammer});
        // --- Reinforced Door
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("IC2","itemDoorAlloy",1), tBitMask,
                new Object[] {"SPP","RPP","dPP",'P', OrePrefixes.plateAlloy.get(Materials.Advanced),
                        'S', OrePrefixes.screw.get(Materials.Lead), 'R', OrePrefixes.ring.get(Materials.Lead)});
        // --- Painter
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("IC2","itemToolPainter",1), tBitMask,
                new Object[] {"WWW"," S "," S ",'W', "blockWool",
                        'S', OrePrefixes.stick.get(Materials.Steel)});
        // --- Personal Safe
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("IC2","blockPersonal",1), tBitMask,
                new Object[] {"SCS","dHh","SCS",'C', OrePrefixes.circuit.get(Materials.Basic),
                        'S', OrePrefixes.screw.get(Materials.Iron), 'H', GT_ModHandler.getModItem("chestup", "Blockchestup", 1L, 1)});
        // --- CF Sprayer
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("IC2","itemFoamSprayer",1), tBitMask,
                new Object[] {"IdS","sIF","SBC",'C', OrePrefixes.circuit.get(Materials.Basic),
                        'S', OrePrefixes.screw.get(Materials.Iron), 'I', OrePrefixes.pipeSmall.get(Materials.Steel),
                        'B', GT_ModHandler.getModItem("minecraft", "stone_button", 1L),
                        'F', GT_ModHandler.getModItem("IC2", "itemFluidCell", 1L)});
        // --- CF Backpack
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("IC2","itemArmorCFPack",1, 26), tBitMask,
                new Object[] {"ChC","TST","CdC",'C', OrePrefixes.itemCasing.get(Materials.Steel),
                        'S', OrePrefixes.screw.get(Materials.Steel),
                        'T', GT_ModHandler.getModItem("extracells", "certustank", 1L)});
        // --- Obscurator
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("IC2","obscurator",1), tBitMask,
                new Object[] {"SdS","CDC","IBI",'I', OrePrefixes.itemCasing.get(Materials.Iron),
                        'S', OrePrefixes.screw.get(Materials.Steel), 'C', OrePrefixes.cableGt01.get(Materials.Gold),
                        'B', OrePrefixes.battery.get(Materials.Advanced), 'D', Itemstack(Core_Items2.getInstance(), 1, 182)});
        // --- OD Scanner
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("IC2","itemScanner",1), tBitMask,
                new Object[] {"IPI","ADA","CBC",'I', OrePrefixes.itemCasing.get(Materials.Gold), 'A', OrePrefixes.circuit.get(Materials.Advanced),
                        'P', OrePrefixes.plate.get(Materials.StainlessSteel), 'C', OrePrefixes.cableGt01.get(Materials.Gold),
                        'B', ItemList.EnergyCrystal.get(1), 'D', Itemstack(Core_Items2.getInstance(), 1, 182)});
        // --- OV Scanner
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("IC2","itemScannerAdv",1), tBitMask,
                new Object[] {"IPI","ADA","CBC",'I', OrePrefixes.itemCasing.get(Materials.Titanium), 'A', OrePrefixes.circuit.get(Materials.Data),
                        'P', GT_ModHandler.getModItem("IC2","itemScanner",1, GT_Values.W), 'C', OrePrefixes.cableGt01.get(Materials.Nichrome),
                        'B', ItemList.LapotronCrystal.get(1), 'D', Itemstack(Core_Items2.getInstance(), 1, 182)});
        // --- Trade O Mat
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("IC2","blockPersonal",1, 1), tBitMask,
                new Object[] {"SPS","COC","hPd",'C', OrePrefixes.circuit.get(Materials.Basic), 'P', OrePrefixes.plate.get(Materials.Steel),
                        'S', OrePrefixes.screw.get(Materials.Steel), 'O', ItemList.Hull_LV.get(1)});
        // --- Energy O Mat
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("IC2","blockPersonal",1, 2), tBitMask,
                new Object[] {"SPS","COC","hPd",'C', OrePrefixes.circuit.get(Materials.Basic), 'P', GT_ModHandler.getModItem("IC2","itemBatREDischarged",1),
                        'S', OrePrefixes.screw.get(Materials.Steel), 'O', ItemList.Hull_LV.get(1)});
        // --- Item Buffer
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("IC2","blockMachine3",1, 6), tBitMask,
                new Object[] {"PPP","CHC","PPP",'P', OrePrefixes.itemCasing.get(Materials.Iron), 'H', ItemList.Hull_LV.get(1),
                        'C', GT_ModHandler.getModItem("minecraft", "chest", 1L)});
        // --- Electric Sorting Machine
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("IC2","blockMachine3",1, 5), tBitMask,
                new Object[] {"PCP","MHM","PTP",'P', OrePrefixes.itemCasing.get(Materials.Iron), 'H', ItemList.Hull_LV.get(1),
                        'C', OrePrefixes.circuit.get(Materials.Basic), 'M', GT_ModHandler.getModItem("IC2", "upgradeModule", 1L, 3),
                        'T', GT_ModHandler.getModItem("minecraft", "chest", 1L)});
        // --- Fluid Distributer
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("IC2","blockMachine3",1, 4), tBitMask,
                new Object[] {"PCP","MHM","OTO",'P', OrePrefixes.itemCasing.get(Materials.Iron), 'H', ItemList.Hull_LV.get(1),
                        'C', OrePrefixes.circuit.get(Materials.Basic), 'M', GT_ModHandler.getModItem("IC2", "upgradeModule", 1L, 4),
                        'T', GT_ModHandler.getModItem("IC2", "itemFluidCell", 1L), 'O', OrePrefixes.pipeLarge.get(Materials.Steel)});
        // --- Fluid Regulator
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("IC2","blockMachine2",1, 14), tBitMask,
                new Object[] {"PPP","OHO","TCT",'P', OrePrefixes.itemCasing.get(Materials.Iron), 'H', ItemList.Electric_Pump_MV.get(1),
                        'C', OrePrefixes.circuit.get(Materials.Basic), 'T', GT_ModHandler.getModItem("extracells", "certustank", 1L),
                        'O', OrePrefixes.pipeMedium.get(Materials.Steel)});
        // --- Tesla Coil
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("IC2","blockMachine2",1, 1), tBitMask,
                new Object[] {"SCS","PEP","SWS",'S', OrePrefixes.spring.get(Materials.SteelMagnetic), 'C', OrePrefixes.circuit.get(Materials.Advanced),
                        'P', GT_ModHandler.getModItem("IC2", "itemRecipePart", 1L), 'E', ItemList.Transformer_HV_MV.get(1),
                        'W', OrePrefixes.cableGt04.get(Materials.Gold)});
        // --- Magnetizer
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("IC2","blockMachine",1, 9), tBitMask,
                new Object[] {"RPR","SHS","MCM",'S', OrePrefixes.spring.get(Materials.SteelMagnetic), 'C', OrePrefixes.circuit.get(Materials.Basic),
                        'R', OrePrefixes.plate.get(Materials.RedAlloy), 'P', OrePrefixes.itemCasing.get(Materials.Steel),
                        'H', ItemList.Hull_LV.get(1), 'M', ItemList.Electric_Motor_LV.get(1)});

        // --- Hazmat Helmet
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("IC2","itemArmorHazmatHelmet",1), tBitMask,
                new Object[] {" D ","PGP","PBP",'P', OrePrefixes.plate.get(Materials.Rubber), 'G', OrePrefixes.block.get(Materials.Glass),
                        'D', "dyeOrange", 'B', GT_ModHandler.getModItem("minecraft", "iron_bars", 1L)});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("IC2","itemArmorHazmatHelmet",1), tBitMask,
                new Object[] {"PGP","PBP",'P', OrePrefixes.plate.get(Materials.Rubber),
                        'G', GT_ModHandler.getModItem("IC2","itemArmorHazmatHelmet",1, GT_Values.W),
                        'B', ToolDictNames.craftingToolSoftHammer});
        // --- Hazmat Chestplate
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("IC2","itemArmorHazmatChestplate",1), tBitMask,
                new Object[] {"PDP","PPP","PPP",'P', OrePrefixes.plate.get(Materials.Rubber), 'D', "dyeOrange"});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("IC2","itemArmorHazmatChestplate",1), tBitMask,
                new Object[] {"PBP","PGP","P P",'P', OrePrefixes.plate.get(Materials.Rubber),
                        'G', GT_ModHandler.getModItem("IC2","itemArmorHazmatChestplate",1, GT_Values.W),
                        'B', ToolDictNames.craftingToolSoftHammer});
        // --- Hazmat Leggings
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("IC2","itemArmorHazmatLeggings",1), tBitMask,
                new Object[] {"PPP","PDP","P P",'P', OrePrefixes.plate.get(Materials.Rubber), 'D', "dyeOrange"});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("IC2","itemArmorHazmatLeggings",1), tBitMask,
                new Object[] {"PGP","PBP","P P",'P', OrePrefixes.plate.get(Materials.Rubber),
                        'G', GT_ModHandler.getModItem("IC2","itemArmorHazmatLeggings",1, GT_Values.W),
                        'B', ToolDictNames.craftingToolSoftHammer});
        // --- Hazmat Chestplate
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("IC2","itemArmorRubBoots",1), tBitMask,
                new Object[] {"P P","P P","PWP",'P', OrePrefixes.plate.get(Materials.Rubber), 'W', "blockWool"});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("IC2","itemArmorRubBoots",1), tBitMask,
                new Object[] {"PGP","PBP","P P",'P', OrePrefixes.plate.get(Materials.Rubber),
                        'G', GT_ModHandler.getModItem("IC2","itemArmorRubBoots",1, GT_Values.W),
                        'B', ToolDictNames.craftingToolSoftHammer});

        // --- Copper Boiler
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("IC2","itemRecipePart",1, 6), tBitMask,
                new Object[] {"CCC","SwS","CCC",'C', OrePrefixes.itemCasing.get(Materials.Copper),'S', OrePrefixes.screw.get(Materials.Copper)});

        // --- Windmeter
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("IC2","windmeter",1, 26), tBitMask,
                new Object[] {"SRd","GIG","PBP",'S', OrePrefixes.screw.get(Materials.StainlessSteel),'G', OrePrefixes.gearGtSmall.get(Materials.StainlessSteel),
                        'P', OrePrefixes.plate.get(Materials.StainlessSteel),'R', OrePrefixes.rotor.get(Materials.Aluminium),
                        'B', "batteryBasic", 'I', GT_ModHandler.getModItem("IC2", "itemRecipePart", 1L, 3)});

        // --- CF Powder
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("IC2","itemPartCFPowder",5), tBitMask,
                new Object[] {"CCS","YA ",'C', OrePrefixes.dust.get(Materials.Calcite),'S', OrePrefixes.dust.get(Materials.Stone),
                        'Y', OrePrefixes.dust.get(Materials.Clay),'A', "sand"});

        // --- Stone Mug
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("IC2","itemMugEmpty",1), tBitMask,
                new Object[] {"ShS"," S ",'S', "stone"});

        // --- Treetap
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("IC2","itemTreetap",1), tBitMask,
                new Object[] {" S ","PPP","P  ",'S', OrePrefixes.stick.get(Materials.Wood), 'P', OrePrefixes.plank.get(Materials.Wood)});

        // --- Crop Sticks
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("IC2","blockCrop",1), tBitMask,
                new Object[] {"S S","S S",'S', OrePrefixes.stick.get(Materials.Wood)});

        // --- EU Reader
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("IC2","itemToolMEter",1), tBitMask,
                new Object[] {"PMP","SCS",'S', OrePrefixes.stick.get(Materials.Iron),'C', OrePrefixes.springSmall.get(Materials.Copper),
                        'P', OrePrefixes.plate.get(Materials.Iron), 'M', ItemList.Cover_Screen});

        // --- Coal Ball
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("IC2","itemPartCoalBall",1), tBitMask,
                new Object[] {"CCC","CBC", "CCC", 'C', OrePrefixes.dust.get(Materials.Coal),'B', "itemFlint"});

        // --- Coal Chunk
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("IC2","itemPartCoalChunk",1), tBitMask,
                new Object[] {"CCC","CBC", "CCC", 'C', GT_ModHandler.getModItem("IC2","itemPartCoalBlock",1),'B', "blockIron"});

    }

    private void thermalCentrifuge() {
        // --- U Fuel
        RA.addThermalCentrifugeRecipe(GT_ModHandler.getModItem("IC2", "reactorUraniumSimpledepleted", 1L),
                new ItemStack[]{
                        GT_ModHandler.getModItem("IC2", "itemUran238", 4L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Zirconium, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Plutonium, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Uranium235, 1L)
                },
                new int[]{10000,10000,1000,1000},200,500);
        RA.addThermalCentrifugeRecipe(GT_ModHandler.getModItem("IC2", "reactorUraniumDualdepleted", 1L),
                new ItemStack[]{
                        GT_ModHandler.getModItem("IC2", "itemUran238", 8L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Zirconium, 3L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Plutonium, 2L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Uranium235, 2L)
                },
                new int[]{10000,10000,1000,1000},200,500);
        RA.addThermalCentrifugeRecipe(GT_ModHandler.getModItem("IC2", "reactorUraniumQuaddepleted", 1L),
                new ItemStack[]{
                        GT_ModHandler.getModItem("IC2", "itemUran238", 16L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Zirconium, 7L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Plutonium, 4L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Uranium235, 4L)
                },
                new int[]{10000,10000,1000,1000},200,500);

        // --- MOX Fuel
        RA.addThermalCentrifugeRecipe(GT_ModHandler.getModItem("IC2", "reactorMOXSimpledepleted", 1L),
                new ItemStack[]{
                        GT_ModHandler.getModItem("IC2", "itemPlutonium", 2L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Zirconium, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Plutonium, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Uranium235, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Californium, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Plutonium241, 1L)
                },
                new int[]{10000,10000,9500,2000,1000,1000,500},200,500);
        RA.addThermalCentrifugeRecipe(GT_ModHandler.getModItem("IC2", "reactorMOXDualdepleted", 1L),
                new ItemStack[]{
                        GT_ModHandler.getModItem("IC2", "itemPlutonium", 4L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Zirconium, 3L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Plutonium, 2L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Uranium235, 2L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Californium, 2L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Plutonium241, 2L)
                },
                new int[]{10000,10000,9500,2000,1000,1000,500},200,500);
        RA.addThermalCentrifugeRecipe(GT_ModHandler.getModItem("IC2", "reactorMOXQuaddepleted", 1L),
                new ItemStack[]{
                        GT_ModHandler.getModItem("IC2", "itemPlutonium", 8L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Zirconium, 7L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Plutonium, 4L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Uranium235, 4L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Californium, 4L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Plutonium241, 4L)
                },
                new int[]{10000,10000,9500,2000,1000,1000,500},200,500);

        // --- Nq Fuel
        RA.addThermalCentrifugeRecipe(ItemList.Depleted_Naquadah_1.get(1),
                new ItemStack[]{
                        Itemstack(Core_Items2.getInstance(), 4, 183),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.TungstenSteel, 9L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.NaquadahEnriched, 2L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Plutonium241, 1L)
                },
                new int[]{10000,10000,1000,1000},500,2000);
        RA.addThermalCentrifugeRecipe(ItemList.Depleted_Naquadah_2.get(1),
                new ItemStack[]{
                        Itemstack(Core_Items2.getInstance(), 8, 183),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.TungstenSteel, 20L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.NaquadahEnriched, 4L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Plutonium241, 2L)
                },
                new int[]{10000,10000,1000,1000},500,2000);
        RA.addThermalCentrifugeRecipe(ItemList.Depleted_Naquadah_4.get(1),
                new ItemStack[]{
                        Itemstack(Core_Items2.getInstance(), 16, 183),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.TungstenSteel, 42L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.NaquadahEnriched, 8L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Plutonium241, 4L)
                },
                new int[]{10000,10000,1000,1000},500,2000);

        // --- Nq+ Fuel
        RA.addThermalCentrifugeRecipe(ItemList.Depleted_MNq_1.get(1),
                new ItemStack[]{
                        Itemstack(Core_Items2.getInstance(), 2, 185),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.TungstenSteel, 9L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.NaquadahEnriched, 4L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Naquadah, 4L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Californium, 2L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Naquadria, 2L)
                },
                new int[]{10000,10000,9500,2000,1000,1000,500},500,2000);
        RA.addThermalCentrifugeRecipe(ItemList.Depleted_MNq_2.get(1),
                new ItemStack[]{
                        Itemstack(Core_Items2.getInstance(), 4, 185),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.TungstenSteel, 20L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.NaquadahEnriched, 8L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Naquadah, 8L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Californium, 4L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Naquadria, 4L)
                },
                new int[]{10000,10000,9500,2000,1000,1000,500},500,2000);
        RA.addThermalCentrifugeRecipe(ItemList.Depleted_MNq_4.get(1),
                new ItemStack[]{
                        Itemstack(Core_Items2.getInstance(), 8, 185),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.TungstenSteel, 42L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.NaquadahEnriched, 16L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Naquadah, 16L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Californium, 8L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Naquadria, 8L)
                },
                new int[]{10000,10000,9500,2000,1000,1000,500},500,2000);

        // --- Th Fuel
        RA.addThermalCentrifugeRecipe(ItemList.Depleted_Thorium_1.get(1),
                new ItemStack[]{
                        GT_ModHandler.getModItem("IC2", "itemUran238", 2L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Uranium, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Zirconium, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Thorium, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Uranium235, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Lutetium, 1L)
                },
                new int[]{10000,10000,10000,10000,5000,5000},200,500);
        RA.addThermalCentrifugeRecipe(ItemList.Depleted_Thorium_2.get(1),
                new ItemStack[]{
                        GT_ModHandler.getModItem("IC2", "itemUran238", 4L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Uranium, 2L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Zirconium, 3L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Thorium, 2L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Uranium235, 2L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Lutetium, 2L)
                },
                new int[]{10000,10000,10000,10000,5000,5000},200,500);
        RA.addThermalCentrifugeRecipe(ItemList.Depleted_Thorium_4.get(1),
                new ItemStack[]{
                        GT_ModHandler.getModItem("IC2", "itemUran238", 8L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Uranium, 4L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Zirconium, 7L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Thorium, 4L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Uranium235, 4L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Lutetium, 4L)
                },
                new int[]{10000,10000,10000,10000,5000,5000},200,500);

        // --- MOX Th Fuel
        RA.addThermalCentrifugeRecipe(ItemList.Depleted_MThCell_1.get(1),
                new ItemStack[]{
                        GT_ModHandler.getModItem("IC2", "itemPlutonium", 2L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Zirconium, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Plutonium, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Lutetium, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Plutonium, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Plutonium241, 1L)
                },
                new int[]{10000,10000,10000,8000,5000,100},200,500);
        RA.addThermalCentrifugeRecipe(ItemList.Depleted_MThCell_2.get(1),
                new ItemStack[]{
                        GT_ModHandler.getModItem("IC2", "itemPlutonium", 4L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Zirconium, 3L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Plutonium, 2L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Lutetium, 2L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Plutonium, 2L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Plutonium241, 2L)
                },
                new int[]{10000,10000,10000,8000,5000,100},200,500);
        RA.addThermalCentrifugeRecipe(ItemList.Depleted_MThCell_4.get(1),
                new ItemStack[]{
                        GT_ModHandler.getModItem("IC2", "itemPlutonium", 8L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Zirconium, 7L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Plutonium, 4L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Lutetium, 4L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Plutonium, 4L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Plutonium241, 4L)
                },
                new int[]{10000,10000,10000,8000,5000,100},200,500);

    }

    private void printer3d() {
        //Kinetic Generator
        RA.addPrimitiveLineRecipe(new ItemStack[]{
                ItemList.Hatch_Dynamo_HV.get(1L),
                GT_OreDictUnificator.get(OrePrefixes.cableGt02, Materials.Aluminium, 2),
                GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.Titanium, 2),
                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Data, 2),
                ItemList.Electric_Motor_HV.get(2L), ItemList.Casing_Motor.get(1L),
                GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.HSLA, 6)
        }, GT_ModHandler.getModItem("IC2", "blockGenerator", 1L, 9), null, 10 * 20, 480);

        //Kinetic Wind Generator
        RA.addPrimitiveLineRecipe(new ItemStack[]{
                ItemList.Casing_Gearbox_Steel.get(1L),
                GT_OreDictUnificator.get(OrePrefixes.cableGt02, Materials.Aluminium, 2),
                GT_OreDictUnificator.get(OrePrefixes.gearGtSmall, Materials.Titanium, 2),
                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Data, 2),
                ItemList.Electric_Motor_HV.get(2L),
                GT_ModHandler.getModItem("IC2", "itemRecipePart", 4, 12),
                GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.HSLA, 6)
        }, GT_ModHandler.getModItem("IC2", "blockKineticGenerator", 1L, 0), null, 10 * 20, 480);

        //Kinetic Water Generator
        RA.addPrimitiveLineRecipe(new ItemStack[]{
                ItemList.Casing_Gearbox_Steel.get(1L),
                GT_OreDictUnificator.get(OrePrefixes.cableGt02, Materials.Aluminium, 2),
                GT_OreDictUnificator.get(OrePrefixes.gearGtSmall, Materials.Titanium, 2),
                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Data, 2),
                ItemList.Electric_Pump_HV.get(2L), GT_ModHandler.getModItem("IC2", "itemRecipePart", 4, 12),
                GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.HSLA, 6)
        }, GT_ModHandler.getModItem("IC2", "blockKineticGenerator", 1L, 4), null, 10 * 20, 480);
    }

    private void packager() {
        RA.
                addBoxingRecipe(CoreItems.getRecipe(29, 4), ItemList.Schematic_Dust.get(0L),
                        GT_ModHandler.getModItem("IC2", "itemFertilizer", 1L), 100, 4);
        RA.
                addBoxingRecipe(CoreItems.getRecipe(30, 9), ItemList.Schematic_Dust.get(0L),
                        GT_ModHandler.getModItem("IC2", "itemFertilizer", 1L), 100, 4);

    }

    private void formingPress() {
        RA.addFormingPressRecipe(
                GT_OreDictUnificator.get(OrePrefixes.plateAlloy, Materials.Advanced, 4L),
                GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Lead, 1L),
                GT_ModHandler.getModItem("IC2", "reactorPlating", 1L, 0), 200, 256);
        RA.addFormingPressRecipe(
                GT_OreDictUnificator.get(OrePrefixes.plateDense, Materials.Copper, 1L),
                GT_ModHandler.getModItem("IC2", "reactorPlating", 1L, 0),
                GT_ModHandler.getModItem("IC2", "reactorPlatingHeat", 1L, 0), 220, 480);
        RA.addFormingPressRecipe(
                GT_OreDictUnificator.get(OrePrefixes.plateAlloy, Materials.Advanced, 8L),
                GT_ModHandler.getModItem("IC2", "reactorPlating", 1L, 0),
                GT_ModHandler.getModItem("IC2", "reactorPlatingExplosive", 1L, 0), 220, 480);

    }

    private void fluidCanner() {
        RA.addFluidCannerRecipe(CoreItems2.getRecipe(143, 1),
                GT_ModHandler.getModItem("IC2", "reactorCoolantSimple", 1L, 1),
                new FluidStack(FluidRegistry.getFluid("ic2coolant"), 1000), GT_Values.NF);
        RA.addFluidCannerRecipe(CoreItems2.getRecipe(144, 1),
                GT_ModHandler.getModItem("IC2", "reactorCoolantTriple", 1L, 1),
                new FluidStack(FluidRegistry.getFluid("ic2coolant"), 3000), GT_Values.NF);
        RA.addFluidCannerRecipe(CoreItems2.getRecipe(145, 1),
                GT_ModHandler.getModItem("IC2", "reactorCoolantSix", 1L, 1),
                new FluidStack(FluidRegistry.getFluid("ic2coolant"), 6000), GT_Values.NF);
    }

    private void extruder() {
        RA.addExtruderRecipe(GT_OreDictUnificator.get(OrePrefixes.block, Materials.Iron, 1),
                ItemList.Shape_Extruder_Shaft.get(0L),
                GT_ModHandler.getIC2Item("itemRecipePart", 1L, 11), 2000, 120);
        RA.addExtruderRecipe(GT_OreDictUnificator.get(OrePrefixes.block, Materials.Steel, 1),
                ItemList.Shape_Extruder_Shaft.get(0L),
                GT_ModHandler.getIC2Item("itemRecipePart", 1L, 12), 2000, 480);
        RA.addExtruderRecipe(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Zirconium, 1),
                ItemList.Shape_Extruder_Cell.get(0L),
                GT_ModHandler.getIC2Item("fuelRod", 1), 200, 120);
    }

    private void assembler() {
        //Quantum Armor Parts
        RA.addAssemblerRecipe(GT_ModHandler.getIC2Item("nanoBoots", 1L, GT_Values.W),
                CoreItems2.getRecipe(52, 4), CoreItems2.getRecipe(41, 1), 1200, 1920);
        RA.addAssemblerRecipe(Loader.isModLoaded("GraviSuite") ? GT_ModHandler
                        .getModItem("GraviSuite", "advNanoChestPlate", 1, GT_Values.W)
                        : GT_ModHandler.getIC2Item("nanoBodyarmor", 1L, GT_Values.W), CoreItems2.getRecipe(52, 8),
                CoreItems2.getRecipe(42, 1), 1200, 1920);
        RA.addAssemblerRecipe(GT_ModHandler.getIC2Item("nanoHelmet", 1L, GT_Values.W),
                CoreItems2.getRecipe(52, 5), CoreItems2.getRecipe(43, 1), 1200, 1920);
        RA.addAssemblerRecipe(CoreItems2.getRecipe(43, 1),
                GT_OreDictUnificator.get(OrePrefixes.lens, Materials.ReinforcedGlass, 8L),
                CoreItems2.getRecipe(44, 1), 1200, 1920);
        RA.addAssemblerRecipe(GT_ModHandler.getIC2Item("nanoLeggings", 1L, GT_Values.W),
                CoreItems2.getRecipe(52, 7), CoreItems2.getRecipe(45, 1), 1200, 1920);

        //Nano Armor
        RA.addAssemblerRecipe(CoreItems2.getRecipe(137, 1), CoreItems2.getRecipe(100, 1),
                GT_ModHandler.getIC2Item("nanoHelmet", 1L, 27), 400, 120);
        RA.addAssemblerRecipe(CoreItems2.getRecipe(138, 1), CoreItems2.getRecipe(100, 1),
                GT_ModHandler.getIC2Item("nanoBodyarmor", 1L, 27), 400, 120);
        RA.addAssemblerRecipe(CoreItems2.getRecipe(139, 1), CoreItems2.getRecipe(100, 1),
                GT_ModHandler.getIC2Item("nanoLeggings", 1L, 27), 400, 120);
        RA.addAssemblerRecipe(CoreItems2.getRecipe(140, 1), CoreItems2.getRecipe(100, 1),
                GT_ModHandler.getIC2Item("nanoBoots", 1L, 27), 400, 120);

        // --- Charging Lapotron Crystal
        RA.addAssemblerRecipe(
                new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Data, 1),
                        ItemList.Circuit_Parts_Crystal_Chip_Master.get(12),
                        GT_ModHandler.getModItem("IC2", "reactorHeatSwitchDiamond", 1L, 1)},
                Materials.SolderingAlloy.getMolten(1440L),
                GT_ModHandler.getModItem("IC2", "itemBatChargeLamaCrystal", 1L, 0), 200, 1920);
        RA.addAssemblerRecipe(
                new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Tin, 4),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Graphite, 4),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Steel, 1),
                        GT_Utility.getIntegratedCircuit(1)}, null,
                GT_ModHandler.getModItem("IC2", "reactorReflector", 1L, 1), 100, 16);
        RA.addAssemblerRecipe(
                new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.plate, Materials.TinAlloy, 6),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Graphite, 2),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Beryllium, 1),
                        GT_Utility.getIntegratedCircuit(1)}, null,
                GT_ModHandler.getModItem("IC2", "reactorReflector", 1L, 1), 100, 16);
        RA.addAssemblerRecipe(
                new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Tin, 16),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Graphite, 16),
                        GT_OreDictUnificator.get(OrePrefixes.plateAlloy, Materials.Carbon, 6),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Steel, 4),
                        GT_Utility.getIntegratedCircuit(2)}, null, CoreItems2.getRecipe(141, 1), 120, 256);
        RA.addAssemblerRecipe(
                new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.plate, Materials.TinAlloy, 24),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Graphite, 8),
                        GT_OreDictUnificator.get(OrePrefixes.plateAlloy, Materials.Carbon, 6),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Beryllium, 4),
                        GT_Utility.getIntegratedCircuit(2)}, null, CoreItems2.getRecipe(141, 1), 120, 256);
        RA.addAssemblerRecipe(
                new ItemStack[]{CoreItems2.getRecipe(NeutronReflectorSmallParts.getMetaID(), 1),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Beryllium, 2),
                        GT_Utility.getIntegratedCircuit(1)}, null,
                GT_ModHandler.getModItem("IC2", "reactorReflectorThick", 1L, 1), 600, 64);
        RA.addAssemblerRecipe(
                new ItemStack[]{CoreItems2.getRecipe(NeutronReflectorSmallParts.getMetaID(), 1),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.TungstenCarbide, 1),
                        GT_Utility.getIntegratedCircuit(1)}, null,
                GT_ModHandler.getModItem("IC2", "reactorReflectorThick", 1L, 1), 600, 64);
        RA.addAssemblerRecipe(
                new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.plateTriple, Materials.Californium, 1),
                        CoreItems2.getRecipe(NeutronReflectorSmallParts.getMetaID(), 8),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Beryllium, 16),
                        GT_Utility.getIntegratedCircuit(2)}, null,
                CoreItems2.getRecipe(NeutronReflectorParts.getMetaID(), 1), 400, 256);
        RA.addAssemblerRecipe(
                new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.plateTriple, Materials.Californium, 1),
                        CoreItems2.getRecipe(NeutronReflectorSmallParts.getMetaID(), 8),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.TungstenCarbide, 8),
                        GT_Utility.getIntegratedCircuit(2)}, null,
                CoreItems2.getRecipe(NeutronReflectorParts.getMetaID(), 1), 400, 256);
        RA.addAssemblerRecipe(
                new ItemStack[]{CoreItems2.getRecipe(NeutronReflectorParts.getMetaID(), 1),
                        GT_OreDictUnificator.get(OrePrefixes.plateAlloy, Materials.Iridium, 1)}, null,
                ItemList.Neutron_Reflector.get(1), 1200, 256);
        // --- Mox Nuclear Fuel
        RA.addAssemblerRecipe(
                GT_ModHandler.getModItem("IC2", "itemUran238", 6L),
                GT_ModHandler.getModItem("IC2", "itemPlutonium", 3L),
                new FluidStack(FluidRegistry.getFluid("ic2coolant"), 1000),
                GT_ModHandler.getModItem("IC2", "itemMOX", 1L), 400, 256);
        // --- Enriched Uranium Nuclear Fuel
        RA.addAssemblerRecipe(
                GT_ModHandler.getModItem("IC2", "itemUran238", 6L),
                GT_ModHandler.getModItem("IC2", "itemUran235small", 3L),
                new FluidStack(FluidRegistry.getFluid("ic2coolant"), 1000),
                GT_ModHandler.getModItem("IC2", "itemUran", 1L), 400, 120);
        // --- Wood Scaffold
        RA.addAssemblerRecipe(
                new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.plank, Materials.Wood, 1),
                        GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 2),
                        GT_Utility.getIntegratedCircuit(12)}, null,
                GT_ModHandler.getModItem("IC2", "blockScaffold", 1L), 20, 4);
        RA.addAssemblerRecipe(
                new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.plate, Materials.WoodSealed, 1),
                        GT_OreDictUnificator.get(OrePrefixes.stick, Materials.WoodSealed, 2),
                        GT_Utility.getIntegratedCircuit(12)}, null,
                GT_ModHandler.getModItem("IC2", "blockScaffold", 2L), 20, 4);
        // --- Iron Scaffold
        RA.addAssemblerRecipe(
                new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Iron, 1),
                        GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Iron, 2),
                        GT_Utility.getIntegratedCircuit(12)}, null,
                GT_ModHandler.getModItem("IC2", "blockIronScaffold", 1L), 20, 4);
        RA.addAssemblerRecipe(
                new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Steel, 1),
                        GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Steel, 2),
                        GT_Utility.getIntegratedCircuit(12)}, null,
                GT_ModHandler.getModItem("IC2", "blockIronScaffold", 2L), 20, 4);
        // --- Coil
        RA.addAssemblerRecipe(
                new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.stick, Materials.SteelMagnetic, 1),
                        GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.Copper, 16),
                        GT_Utility.getIntegratedCircuit(3)}, null,
                GT_ModHandler.getModItem("IC2", "itemRecipePart", 1L), 200, 30);
        // --- Rubber Boat
        RA.addAssemblerRecipe(
                GT_ModHandler.getModItem("IC2", "itemBoat", 1L, 2),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Rubber, 1),
                GT_ModHandler.getModItem("IC2", "itemBoat", 1L, 1), 20, 30);
        // --- Weeding Trowel
        RA.addAssemblerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Steel, 2),
                        GT_Utility.getIntegratedCircuit(5), Materials.Rubber.getMolten(144L),
                GT_ModHandler.getModItem("IC2", "itemWeedingTrowel", 1L), 400, 30);
        // --- Cropnalyzer
        RA.addAssemblerRecipe(
                ItemList.Cover_Screen.get(1), GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Good, 1),
                Materials.Redstone.getMolten(576L),
                GT_ModHandler.getModItem("IC2", "itemCropnalyzer", 1L, 1), 1200, 16);
        // --- Reinforced Door
        RA.addAssemblerRecipe(
                GT_ModHandler.getModItem("IC2", "itemPartAlloy", 6L),
                GT_Utility.getIntegratedCircuit(6), Materials.Lead.getMolten(16),
                GT_ModHandler.getModItem("IC2", "itemDoorAlloy", 1L), 600, 30);
        // --- Ejector Upgrade
        RA.addAssemblerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Basic, 1),
                ItemList.Electric_Piston_LV.get(1), Materials.Copper.getMolten(144),
                GT_ModHandler.getModItem("IC2", "upgradeModule", 1L, 3), 1200, 16);
        // --- Fluid Ejector Upgrade
        RA.addAssemblerRecipe(
                GT_ModHandler.getModItem("IC2", "upgradeModule", 1L, 3),
                ItemList.Electric_Pump_LV.get(1), Materials.Copper.getMolten(144),
                GT_ModHandler.getModItem("IC2", "upgradeModule", 1L, 4), 1200, 16);
        // --- Redstone Signal Inverter Upgrade
        RA.addAssemblerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Basic, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.RedAlloy, 1), Materials.Copper.getMolten(144),
                GT_ModHandler.getModItem("IC2", "upgradeModule", 1L, 5), 1200, 16);
        // --- Luminator
        RA.addAssemblerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.cell, Materials.Mercury, 1),
                GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.Copper, 8), Materials.Glass.getMolten(1152),
                GT_ModHandler.getModItem("IC2", "blockLuminatorDark", 8L), 600, 30);
        RA.addAssemblerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.cell, Materials.Helium, 1),
                GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.Copper, 16), Materials.Glass.getMolten(1152),
                GT_ModHandler.getModItem("IC2", "blockLuminatorDark", 16L), 400, 64);
        // --- Iron Furnace
        RA.addAssemblerRecipe(
                GT_ModHandler.getModItem("minecraft", "furnace", 1L),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Iron, 5),
                GT_ModHandler.getModItem("IC2", "blockMachine", 1L, 1), 400, 16);

        // --- Crop Sticks
        RA.addAssemblerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.stickLong, Materials.Wood, 8),
                GT_Utility.getIntegratedCircuit(2),
                GT_ModHandler.getModItem("IC2", "blockCrop", 16L), 150, 24);

    }

    private void compactGens() {
        // --- Kinetic Gearbox Rotor (Iridium)
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("compactkineticgenerators", "IridiumRotor", 1L, 0), tBitMask, new Object[]{"dBS", "BAB", "SBw", 'S', OrePrefixes.screw.get(Materials.Lafium), 'B', GT_ModHandler.getModItem("compactkineticgenerators", "IridiumBlade", 1L, 0), 'A', GT_ModHandler.getModItem("IC2", "itemRecipePart", 1L, 12)});
        // --- Iridium Rotor Blade
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("compactkineticgenerators", "IridiumBlade", 1L, 0), tBitMask, new Object[]{"PPP", "PRP", "PPP", 'R', OrePrefixes.ring.get(Materials.Lafium), 'P', GT_ModHandler.getModItem("IC2", "itemPartIridium", 1L, 0)});

        //Wind Generator
        RA.addPrimitiveLineRecipe(new ItemStack[]{
                        ItemList.Hull_EV.get(1L),
                        GT_OreDictUnificator.get(OrePrefixes.cableGt02, Materials.Tungsten, 2),
                        GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.Desh, 2),
                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Elite, 2),
                        ItemList.Electric_Motor_EV.get(2L),
                        GT_ModHandler.getModItem("IC2", "blockKineticGenerator", 2, 0),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.TungstenSteel, 6)
                }, GT_ModHandler.getModItem("compactkineticgenerators", "BlockCkg", 1L, 0), null, 20 * 20,
                1024);

        RA.addBasicLineRecipe(new ItemStack[]{
                        ItemList.Hull_IV.get(1L),
                        GT_OreDictUnificator.get(OrePrefixes.cableGt04, Materials.HSSG, 2),
                        GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.Trinium, 2),
                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Master, 2),
                        ItemList.Electric_Motor_IV.get(2L),
                        GT_ModHandler.getModItem("compactkineticgenerators", "BlockCkg", 2L, 0),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.HastelloyN, 8)
                }, GT_ModHandler.getModItem("compactkineticgenerators", "BlockCkg", 1L, 1), null, 30 * 20,
                4096);

        RA.addBasicLineRecipe(new ItemStack[]{
                        ItemList.Hull_LuV.get(1L),
                        GT_OreDictUnificator.get(OrePrefixes.cableGt08, Materials.VanadiumGallium, 2),
                        GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.Draconium, 2),
                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Ultimate, 2),
                        ItemList.Electric_Motor_LuV.get(2L),
                        GT_ModHandler.getModItem("compactkineticgenerators", "BlockCkg", 2L, 1),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Lafium, 10)
                }, GT_ModHandler.getModItem("compactkineticgenerators", "BlockCkg", 1L, 2), null, 40 * 20,
                16384);

        RA.addBasicLineRecipe(new ItemStack[]{
                        ItemList.Hull_ZPM.get(1L),
                        GT_OreDictUnificator.get(OrePrefixes.cableGt12, Materials.Duranium, 2),
                        GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.Oriharukon, 2),
                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Superconductor, 2),
                        ItemList.Electric_Motor_ZPM.get(2L),
                        GT_ModHandler.getModItem("compactkineticgenerators", "BlockCkg", 2L, 2),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.CinobiteA243, 12)
                }, GT_ModHandler.getModItem("compactkineticgenerators", "BlockCkg", 1L, 3), null, 50 * 20,
                65536);

        //Water Generator
        RA.addPrimitiveLineRecipe(new ItemStack[]{
                        ItemList.Hull_EV.get(1L),
                        GT_OreDictUnificator.get(OrePrefixes.cableGt02, Materials.Tungsten, 2),
                        GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.Desh, 2),
                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Elite, 2),
                        ItemList.Electric_Pump_EV.get(2L),
                        GT_ModHandler.getModItem("IC2", "blockKineticGenerator", 2, 4),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.TungstenSteel, 6)
                }, GT_ModHandler.getModItem("compactkineticgenerators", "BlockCkg", 1L, 4), null, 20 * 20,
                1024);

        RA.addBasicLineRecipe(new ItemStack[]{
                        ItemList.Hull_IV.get(1L),
                        GT_OreDictUnificator.get(OrePrefixes.cableGt04, Materials.HSSG, 2),
                        GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.Trinium, 2),
                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Master, 2),
                        ItemList.Electric_Pump_IV.get(2L),
                        GT_ModHandler.getModItem("compactkineticgenerators", "BlockCkg", 2L, 4),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.HastelloyN, 8)
                }, GT_ModHandler.getModItem("compactkineticgenerators", "BlockCkg", 1L, 5), null, 30 * 20,
                4096);

        RA.addBasicLineRecipe(new ItemStack[]{
                        ItemList.Hull_LuV.get(1L),
                        GT_OreDictUnificator.get(OrePrefixes.cableGt08, Materials.VanadiumGallium, 2),
                        GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.Draconium, 2),
                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Ultimate, 2),
                        ItemList.Electric_Pump_LuV.get(2L),
                        GT_ModHandler.getModItem("compactkineticgenerators", "BlockCkg", 2L, 5),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Lafium, 10)
                }, GT_ModHandler.getModItem("compactkineticgenerators", "BlockCkg", 1L, 6), null, 40 * 20,
                16384);

        RA.addBasicLineRecipe(new ItemStack[]{
                        ItemList.Hull_ZPM.get(1L),
                        GT_OreDictUnificator.get(OrePrefixes.cableGt12, Materials.Duranium, 2),
                        GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.Oriharukon, 2),
                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Superconductor, 2),
                        ItemList.Electric_Pump_ZPM.get(2L),
                        GT_ModHandler.getModItem("compactkineticgenerators", "BlockCkg", 2L, 6),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.CinobiteA243, 12)
                }, GT_ModHandler.getModItem("compactkineticgenerators", "BlockCkg", 1L, 7), null, 50 * 20,
                65536);

        //Kinetic Generator
        RA.addPrimitiveLineRecipe(new ItemStack[]{
                        ItemList.Hatch_Dynamo_EV.get(1L),
                        GT_OreDictUnificator.get(OrePrefixes.cableGt02, Materials.Tungsten, 2),
                        GT_OreDictUnificator.get(OrePrefixes.gearGtSmall, Materials.Desh, 2),
                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Elite, 2),
                        ItemList.Electric_Motor_EV.get(2L), GT_ModHandler.getModItem("IC2", "blockGenerator", 1, 9),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.TungstenSteel, 6)
                }, GT_ModHandler.getModItem("compactkineticgenerators", "BlockCkg", 1L, 8), null, 20 * 20,
                1024);

        RA.addBasicLineRecipe(new ItemStack[]{
                        ItemList.Hatch_Dynamo_IV.get(1L),
                        GT_OreDictUnificator.get(OrePrefixes.cableGt04, Materials.HSSG, 2),
                        GT_OreDictUnificator.get(OrePrefixes.gearGtSmall, Materials.Trinium, 2),
                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Master, 2),
                        ItemList.Electric_Motor_IV.get(2L),
                        GT_ModHandler.getModItem("compactkineticgenerators", "BlockCkg", 1L, 8),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.HastelloyN, 8)
                }, GT_ModHandler.getModItem("compactkineticgenerators", "BlockCkg", 1L, 9), null, 30 * 20,
                4096);

        RA.addBasicLineRecipe(new ItemStack[]{
                        ItemList.Hatch_Dynamo_LuV.get(1L),
                        GT_OreDictUnificator.get(OrePrefixes.cableGt08, Materials.VanadiumGallium, 2),
                        GT_OreDictUnificator.get(OrePrefixes.gearGtSmall, Materials.Draconium, 2),
                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Ultimate, 2),
                        ItemList.Electric_Motor_LuV.get(2L),
                        GT_ModHandler.getModItem("compactkineticgenerators", "BlockCkg", 1L, 9),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Lafium, 10)
                }, GT_ModHandler.getModItem("compactkineticgenerators", "BlockCkg", 1L, 10), null, 40 * 20,
                16384);

        RA.addBasicLineRecipe(new ItemStack[]{
                        ItemList.Hatch_Dynamo_ZPM.get(1L),
                        GT_OreDictUnificator.get(OrePrefixes.cableGt12, Materials.Duranium, 2),
                        GT_OreDictUnificator.get(OrePrefixes.gearGtSmall, Materials.Oriharukon, 2),
                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Superconductor, 2),
                        ItemList.Electric_Motor_ZPM.get(2L),
                        GT_ModHandler.getModItem("compactkineticgenerators", "BlockCkg", 1L, 10),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.CinobiteA243, 12)
                }, GT_ModHandler.getModItem("compactkineticgenerators", "BlockCkg", 1L, 11), null, 50 * 20,
                65536);
    }

    public void disassembler() {
        // --- Reactor Chamber
        RA.addDisassemblerRecipe(GT_ModHandler.getModItem("IC2", "blockReactorChamber", 1L, 0),
                new ItemStack[]{
                        ItemList.Hull_EV.get(1), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Lead, 4)
                }, 2000, 256);

        // --- Nuclear Reactor
        RA.addDisassemblerRecipe(GT_ModHandler.getModItem("IC2", "blockGenerator", 1L, 5),
                new ItemStack[]{
                        ItemList.Hull_IV.get(1L), ItemList.Robot_Arm_IV.get(2L),
                        GT_OreDictUnificator.get(OrePrefixes.plateDense, Materials.Titanium, 4),
                        ItemList.Circuit_Data.get(4),
                        GT_ModHandler.getModItem("IC2", "blockReactorChamber", 4L, 0), CoreItems2.getRecipe(141, 8),
                        GT_OreDictUnificator.get(OrePrefixes.plateTriple, Materials.Lead, 12)
                }, 400 * 20, 1920);

        // --- Kinetic Generator
        RA.addDisassemblerRecipe(GT_ModHandler.getModItem("IC2", "blockGenerator", 1L, 9),
                new ItemStack[]{
                        ItemList.Hatch_Dynamo_HV.get(1L),
                        GT_OreDictUnificator.get(OrePrefixes.cableGt02, Materials.Aluminium, 2),
                        GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.Titanium, 2),
                        ItemList.Circuit_Data.get(2),
                        ItemList.Electric_Motor_HV.get(2L),
                        ItemList.Casing_Motor.get(1L),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.HSLA, 6)
                }, 100 * 20, 480);

        // --- Kinetic Wind Generator
        RA.addDisassemblerRecipe(GT_ModHandler.getModItem("IC2", "blockKineticGenerator", 1L, 0),
                new ItemStack[]{
                        ItemList.Casing_Gearbox_Steel.get(1L),
                        GT_OreDictUnificator.get(OrePrefixes.cableGt02, Materials.Aluminium, 2),
                        GT_OreDictUnificator.get(OrePrefixes.gearGtSmall, Materials.Titanium, 2),
                        ItemList.Circuit_Data.get(2),
                        ItemList.Electric_Motor_HV.get(2L),
                        GT_ModHandler.getModItem("IC2", "itemRecipePart", 4, 12),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.HSLA, 6)
                }, 100 * 20, 480);

        // --- Kinetic Water Generator
        RA.addDisassemblerRecipe(GT_ModHandler.getModItem("IC2", "blockKineticGenerator", 1L, 4),
                new ItemStack[]{
                        ItemList.Casing_Gearbox_Steel.get(1L),
                        GT_OreDictUnificator.get(OrePrefixes.cableGt02, Materials.Aluminium, 2),
                        GT_OreDictUnificator.get(OrePrefixes.gearGtSmall, Materials.Titanium, 2),
                        ItemList.Circuit_Data.get(2),
                        ItemList.Electric_Pump_HV.get(2L),
                        GT_ModHandler.getModItem("IC2", "itemRecipePart", 4, 12),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.HSLA, 6)
                }, 100 * 20, 480);

        //Wind Generators
        RA.addDisassemblerRecipe(GT_ModHandler.getModItem("compactkineticgenerators", "BlockCkg", 1L, 0),
                new ItemStack[]{
                        ItemList.Hull_EV.get(1L),
                        GT_OreDictUnificator.get(OrePrefixes.cableGt02, Materials.Tungsten, 2),
                        GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.Desh, 2),
                        ItemList.Circuit_Elite.get(2),
                        ItemList.Electric_Motor_EV.get(2L),
                        GT_ModHandler.getModItem("IC2", "blockKineticGenerator", 2, 0),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.TungstenSteel, 6)
                }, 200 * 20, 1024);
        RA.addDisassemblerRecipe(GT_ModHandler.getModItem("compactkineticgenerators", "BlockCkg", 1L, 1),
                new ItemStack[]{
                        ItemList.Hull_IV.get(1L),
                        GT_OreDictUnificator.get(OrePrefixes.cableGt04, Materials.HSSG, 2),
                        GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.Trinium, 2),
                        ItemList.Circuit_Master.get(2),
                        ItemList.Electric_Motor_IV.get(2L),
                        GT_ModHandler.getModItem("compactkineticgenerators", "BlockCkg", 2L, 0),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.HastelloyN, 8)
                }, 300 * 20, 4096);
        RA.addDisassemblerRecipe(GT_ModHandler.getModItem("compactkineticgenerators", "BlockCkg", 1L, 2),
                new ItemStack[]{
                        ItemList.Hull_LuV.get(1L),
                        GT_OreDictUnificator.get(OrePrefixes.cableGt08, Materials.VanadiumGallium, 2),
                        GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.Draconium, 2),
                        ItemList.Circuit_Quantummainframe.get(2),
                        ItemList.Electric_Motor_LuV.get(2L),
                        GT_ModHandler.getModItem("compactkineticgenerators", "BlockCkg", 2L, 1),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Lafium, 10)
                }, 400 * 20, 16384);
        RA.addDisassemblerRecipe(GT_ModHandler.getModItem("compactkineticgenerators", "BlockCkg", 1L, 3),
                new ItemStack[]{
                        ItemList.Hull_ZPM.get(1L),
                        GT_OreDictUnificator.get(OrePrefixes.cableGt12, Materials.Duranium, 2),
                        GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.Oriharukon, 2),
                        ItemList.Circuit_Crystalmainframe.get(2),
                        ItemList.Electric_Motor_ZPM.get(2L),
                        GT_ModHandler.getModItem("compactkineticgenerators", "BlockCkg", 2L, 2),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.CinobiteA243, 12)
                }, 500 * 20, 65536);

        //Water Generators
        RA.addDisassemblerRecipe(GT_ModHandler.getModItem("compactkineticgenerators", "BlockCkg", 1L, 4),
                new ItemStack[]{
                        ItemList.Hull_EV.get(1L),
                        GT_OreDictUnificator.get(OrePrefixes.cableGt02, Materials.Tungsten, 2),
                        GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.Desh, 2),
                        ItemList.Circuit_Elite.get(2),
                        ItemList.Electric_Pump_EV.get(2L),
                        GT_ModHandler.getModItem("IC2", "blockKineticGenerator", 2, 4),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.TungstenSteel, 6)
                }, 200 * 20, 1024);
        RA.addDisassemblerRecipe(GT_ModHandler.getModItem("compactkineticgenerators", "BlockCkg", 1L, 5),
                new ItemStack[]{
                        ItemList.Hull_IV.get(1L),
                        GT_OreDictUnificator.get(OrePrefixes.cableGt04, Materials.HSSG, 2),
                        GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.Trinium, 2),
                        ItemList.Circuit_Master.get(2),
                        ItemList.Electric_Pump_IV.get(2L),
                        GT_ModHandler.getModItem("compactkineticgenerators", "BlockCkg", 2L, 4),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.HastelloyN, 8)
                }, 300 * 20, 4096);
        RA.addDisassemblerRecipe(GT_ModHandler.getModItem("compactkineticgenerators", "BlockCkg", 1L, 6),
                new ItemStack[]{
                        ItemList.Hull_LuV.get(1L),
                        GT_OreDictUnificator.get(OrePrefixes.cableGt08, Materials.VanadiumGallium, 2),
                        GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.Draconium, 2),
                        ItemList.Circuit_Quantummainframe.get(2),
                        ItemList.Electric_Pump_LuV.get(2L),
                        GT_ModHandler.getModItem("compactkineticgenerators", "BlockCkg", 2L, 5),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Lafium, 10)
                }, 400 * 20, 16384);
        RA.addDisassemblerRecipe(GT_ModHandler.getModItem("compactkineticgenerators", "BlockCkg", 1L, 7),
                new ItemStack[]{
                        ItemList.Hull_ZPM.get(1L),
                        GT_OreDictUnificator.get(OrePrefixes.cableGt12, Materials.Duranium, 2),
                        GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.Oriharukon, 2),
                        ItemList.Circuit_Crystalmainframe.get(2),
                        ItemList.Electric_Pump_ZPM.get(2L),
                        GT_ModHandler.getModItem("compactkineticgenerators", "BlockCkg", 2L, 6),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.CinobiteA243, 12)
                }, 500 * 20, 65536);

        //Kinetic Generators
        RA.addDisassemblerRecipe(GT_ModHandler.getModItem("compactkineticgenerators", "BlockCkg", 1L, 8),
                new ItemStack[]{
                        ItemList.Hatch_Dynamo_EV.get(1L),
                        GT_OreDictUnificator.get(OrePrefixes.cableGt02, Materials.Tungsten, 2),
                        GT_OreDictUnificator.get(OrePrefixes.gearGtSmall, Materials.Desh, 2),
                        ItemList.Circuit_Elite.get(2),
                        ItemList.Electric_Motor_EV.get(2L),
                        GT_ModHandler.getModItem("IC2", "blockGenerator", 1, 9),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.TungstenSteel, 6)
                }, 200 * 20, 1024);
        RA.addDisassemblerRecipe(GT_ModHandler.getModItem("compactkineticgenerators", "BlockCkg", 1L, 9),
                new ItemStack[]{
                        ItemList.Hatch_Dynamo_IV.get(1L),
                        GT_OreDictUnificator.get(OrePrefixes.cableGt04, Materials.HSSG, 2),
                        GT_OreDictUnificator.get(OrePrefixes.gearGtSmall, Materials.Trinium, 2),
                        ItemList.Circuit_Master.get(2),
                        ItemList.Electric_Motor_IV.get(2L),
                        GT_ModHandler.getModItem("compactkineticgenerators", "BlockCkg", 1L, 8),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.HastelloyN, 8)
                }, 300 * 20, 4096);
        RA.addDisassemblerRecipe(GT_ModHandler.getModItem("compactkineticgenerators", "BlockCkg", 1L, 10),
                new ItemStack[]{
                        ItemList.Hatch_Dynamo_LuV.get(1L),
                        GT_OreDictUnificator.get(OrePrefixes.cableGt08, Materials.VanadiumGallium, 2),
                        GT_OreDictUnificator.get(OrePrefixes.gearGtSmall, Materials.Draconium, 2),
                        ItemList.Circuit_Quantummainframe.get(2),
                        ItemList.Electric_Motor_LuV.get(2L),
                        GT_ModHandler.getModItem("compactkineticgenerators", "BlockCkg", 1L, 9),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Lafium, 10)
                }, 400 * 20, 16384);
        RA.addDisassemblerRecipe(GT_ModHandler.getModItem("compactkineticgenerators", "BlockCkg", 1L, 11),
                new ItemStack[]{
                        ItemList.Hatch_Dynamo_ZPM.get(1L),
                        GT_OreDictUnificator.get(OrePrefixes.cableGt12, Materials.Duranium, 2),
                        GT_OreDictUnificator.get(OrePrefixes.gearGtSmall, Materials.Oriharukon, 2),
                        ItemList.Circuit_Crystalmainframe.get(2),
                        ItemList.Electric_Motor_ZPM.get(2L),
                        GT_ModHandler.getModItem("compactkineticgenerators", "BlockCkg", 1L, 10),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.CinobiteA243, 12)
                }, 500 * 20, 65536);

        // --- Kinetic Gearbox Rotor (Iridium)
        RA.addDisassemblerRecipe(GT_ModHandler.getModItem("compactkineticgenerators", "IridiumRotor", 1L, 0),
                new ItemStack[]{
                        GT_ModHandler.getModItem("IC2", "itemRecipePart", 1L, 12),
                        GT_OreDictUnificator.get(OrePrefixes.screw, Materials.Lafium, 2),
                        GT_ModHandler.getModItem("compactkineticgenerators", "IridiumBlade", 4L, 0)
                }, 200 * 20, 1920);

        // --- Iridium Rotor Blade
        RA.addDisassemblerRecipe(GT_ModHandler.getModItem("compactkineticgenerators", "IridiumBlade", 1L, 0),
                new ItemStack[]{
                        GT_OreDictUnificator.get(OrePrefixes.ring, Materials.Lafium, 1),
                        GT_ModHandler.getModItem("IC2", "itemPartIridium", 8L, 0)
                }, 200 * 20, 1920);
    }

    public void bender() {
        // --- Dense Obsidian Plate
        RA.addBenderRecipe(GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Obsidian, 9L),
                GT_ModHandler.getModItem("IC2", "itemDensePlates", 1L, 7), 3600, 96);
        // --- Dense Lapis Lazuli Plate
        RA.addBenderRecipe(GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Lapis, 9L),
                GT_ModHandler.getModItem("IC2", "itemDensePlates", 1L, 8), 3600, 96);
    }

    public void mixer() {
        // --- Coal Ball
        RA.addMixerRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Coal, 8L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Flint, 1L),
                GT_Utility.getIntegratedCircuit(1), null, GT_Values.NF, GT_Values.NF,
                GT_ModHandler.getModItem("IC2", "itemPartCoalBall", 1L),
                100, 16);
    }

    public void alloySmelter() {
        // --- Uranium 235
        RA.addAlloySmelterRecipe(GT_ModHandler.getModItem("IC2", "itemUran235", 1L),
                ItemList.Shape_Mold_Nugget.get(0),
                GT_ModHandler.getModItem("IC2", "itemUran235small", 9L), 100, 120);
    }

}
