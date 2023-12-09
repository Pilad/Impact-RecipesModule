package com.impactrecipes.recipes;

import com.impact.common.item.Core_Items;
import com.impact.common.item.Core_Items2;
import com.impact.mods.gregtech.GT_ItemList;
import gregtech.GT_Mod;
import gregtech.api.GregTech_API;
import gregtech.api.enums.*;
import gregtech.api.util.GT_ModHandler;
import gregtech.api.util.GT_OreDictUnificator;
import gregtech.api.util.GT_Utility;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;

import static com.impact.common.item.Core_List_Items.*;
import static com.impact.loader.ItemRegistery.*;
import static com.impact.util.Utilits.Blockstack;
import static com.impact.util.Utilits.Itemstack;

import static gregtech.api.enums.GT_Values.RA;
import static gregtech.api.util.GT_ModHandler.RecipeBits.DELETE_ALL_OTHER_RECIPES;
import static gregtech.api.util.GT_ModHandler.removeRecipeByOutput;

/**
 * Runnable во всех классах обязателен!
 */
public class Gregtech implements Runnable {

    private static final long bits = GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE | GT_ModHandler.RecipeBits.DISMANTLEABLE | GT_ModHandler.RecipeBits.BUFFERED;
    private static final long bits2 = GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE | GT_ModHandler.RecipeBits.DISMANTLEABLE | GT_ModHandler.RecipeBits.BUFFERED | DELETE_ALL_OTHER_RECIPES;
    private static final long tBitMask = GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE/* | GT_ModHandler.RecipeBits.REVERSIBLE*/;
    private final static long bitsd = GT_ModHandler.RecipeBits.DISMANTLEABLE | bits;

    final Core_Items2 CoreItems2 = Core_Items2.getInstance();
    final Core_Items CoreItems = Core_Items.getInstance();

    @Override
    public void run() {
        removeGT_WTF_CHECK_GT_CODE();
        handRecipe();
        assemblerRecipe();
        wireAssemblerRecipe();
        vacuumFreezer();
        sifter();
        printer3d();
        mixer();
        fusion();
        freezSolidifier();
        fluidSolidifier();
        fluidCanner();
        electrolyzer();
        ebf();
        componentAssembler();
        brewery();
        arcFurnace();
        assembler();
        blastSmelter();
        cuttingSaw();
        bath();
        ciruit();
        assemblyLine();
        centrifuge();
        canner();
        distil();
		wormhole();
        implosionCompressor();
        fluidExtractor();
    }

    private void removeGT_WTF_CHECK_GT_CODE() {
        removeRecipeByOutput(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.CokeCoal, 1), true,
                false, false);
        removeRecipeByOutput(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Desh, 1), true,
                false, false);
        removeRecipeByOutput(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.MeteoricIron, 1),
                true, false, false);
    }

    private void handRecipe() {
        if (GT_Mod.gregtechproxy.mComponentAssembler) {
            GT_ModHandler.addCraftingRecipe(GT_ItemList.Machine_LV_ComponentAssembler.get(1L), bitsd, new Object[]{"PCP", "RHR", "WCW", 'P', GT_ItemList.ULVPiston, 'R', GT_ItemList.ULVRobotArm, 'H', ItemList.Hull_LV, 'C', OrePrefixes.circuit.get(Materials.Basic), 'W', OrePrefixes.cableGt01.get(Materials.Tin)});
            GT_ModHandler.addCraftingRecipe(GT_ItemList.Machine_MV_ComponentAssembler.get(1L), bitsd, new Object[]{"PCP", "RHR", "WCW", 'P', ItemList.Electric_Piston_LV, 'R', ItemList.Robot_Arm_LV, 'H', ItemList.Hull_MV, 'C', OrePrefixes.circuit.get(Materials.Good), 'W', OrePrefixes.cableGt01.get(Materials.Copper)});
            GT_ModHandler.addCraftingRecipe(GT_ItemList.Machine_HV_ComponentAssembler.get(1L), bitsd, new Object[]{"PCP", "RHR", "WCW", 'P', ItemList.Electric_Piston_MV, 'R', ItemList.Robot_Arm_MV, 'H', ItemList.Hull_HV, 'C', OrePrefixes.circuit.get(Materials.Advanced), 'W', OrePrefixes.cableGt02.get(Materials.Gold)});
            GT_ModHandler.addCraftingRecipe(GT_ItemList.Machine_EV_ComponentAssembler.get(1L), bitsd, new Object[]{"PCP", "RHR", "WCW", 'P', ItemList.Electric_Piston_HV, 'R', ItemList.Robot_Arm_HV, 'H', ItemList.Hull_EV, 'C', OrePrefixes.circuit.get(Materials.Data), 'W', OrePrefixes.cableGt02.get(Materials.Aluminium)});
            GT_ModHandler.addCraftingRecipe(GT_ItemList.Machine_IV_ComponentAssembler.get(1L), bitsd, new Object[]{"PCP", "RHR", "WCW", 'P', ItemList.Electric_Piston_EV, 'R', ItemList.Robot_Arm_EV, 'H', ItemList.Hull_IV, 'C', OrePrefixes.circuit.get(Materials.Elite), 'W', OrePrefixes.cableGt04.get(Materials.TungstenSteel)});
        } else {
            //===Motors===\\
            GT_ModHandler.addCraftingRecipe(ItemList.Electric_Motor_LV.get(1L), GT_ModHandler.RecipeBits.DISMANTLEABLE | GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE, new Object[]{"CWR", "WIW", "RWC", 'I', OrePrefixes.stick.get(Materials.IronMagnetic), 'R', OrePrefixes.stick.get(Materials.Iron), 'W', OrePrefixes.wireGt01.get(Materials.Copper), 'C', OrePrefixes.cableGt01.get(Materials.Tin)});
            GT_ModHandler.addCraftingRecipe(ItemList.Electric_Motor_LV.get(1L), GT_ModHandler.RecipeBits.DISMANTLEABLE | GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE, new Object[]{"CWR", "WIW", "RWC", 'I', OrePrefixes.stick.get(Materials.SteelMagnetic), 'R', OrePrefixes.stick.get(Materials.Steel), 'W', OrePrefixes.wireGt01.get(Materials.Copper), 'C', OrePrefixes.cableGt01.get(Materials.Tin)});
            GT_ModHandler.addCraftingRecipe(ItemList.Electric_Motor_MV.get(1L), GT_ModHandler.RecipeBits.DISMANTLEABLE | GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE, new Object[]{"CWR", "WIW", "RWC", 'I', OrePrefixes.stick.get(Materials.SteelMagnetic), 'R', OrePrefixes.stick.get(Materials.Aluminium), 'W', OrePrefixes.wireGt02.get(Materials.Cupronickel), 'C', OrePrefixes.cableGt01.get(Materials.Copper)});
            GT_ModHandler.addCraftingRecipe(ItemList.Electric_Motor_HV.get(1L), GT_ModHandler.RecipeBits.DISMANTLEABLE | GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE, new Object[]{"CWR", "WIW", "RWC", 'I', OrePrefixes.stick.get(Materials.SteelMagnetic), 'R', OrePrefixes.stick.get(Materials.StainlessSteel), 'W', OrePrefixes.wireGt02.get(Materials.Electrum), 'C', OrePrefixes.cableGt01.get(Materials.Silver)});
            GT_ModHandler.addCraftingRecipe(ItemList.Electric_Motor_EV.get(1L), GT_ModHandler.RecipeBits.DISMANTLEABLE | GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE, new Object[]{"CWR", "WIW", "RWC", 'I', OrePrefixes.stick.get(Materials.NeodymiumMagnetic), 'R', OrePrefixes.stick.get(Materials.Titanium), 'W', OrePrefixes.wireGt02.get(Materials.AnnealedCopper), 'C', OrePrefixes.cableGt01.get(Materials.Aluminium)});
            GT_ModHandler.addCraftingRecipe(ItemList.Electric_Motor_IV.get(1L), GT_ModHandler.RecipeBits.DISMANTLEABLE | GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE, new Object[]{"CWR", "WIW", "RWC", 'I', OrePrefixes.stick.get(Materials.NeodymiumMagnetic), 'R', OrePrefixes.stick.get(Materials.TungstenSteel), 'W', OrePrefixes.wireGt02.get(Materials.Graphene), 'C', OrePrefixes.cableGt01.get(Materials.Tungsten)});

            //===Pumps===\\
            GT_ModHandler.addCraftingRecipe(ItemList.Electric_Pump_LV.get(1L), GT_ModHandler.RecipeBits.DISMANTLEABLE | GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE, new Object[]{"SXO", "dPw", "OMW", 'M', ItemList.Electric_Motor_LV, 'O', OrePrefixes.ring.get(Materials.Paper), 'X', OrePrefixes.rotor.get(Materials.Tin), 'S', OrePrefixes.screw.get(Materials.Tin), 'W', OrePrefixes.cableGt01.get(Materials.Tin), 'P', OrePrefixes.pipeMedium.get(Materials.Bronze)});
            GT_ModHandler.addCraftingRecipe(ItemList.Electric_Pump_LV.get(1L), GT_ModHandler.RecipeBits.DISMANTLEABLE | GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE, new Object[]{"SXO", "dPw", "OMW", 'M', ItemList.Electric_Motor_LV, 'O', OrePrefixes.ring.get(Materials.Rubber), 'X', OrePrefixes.rotor.get(Materials.Tin), 'S', OrePrefixes.screw.get(Materials.Tin), 'W', OrePrefixes.cableGt01.get(Materials.Tin), 'P', OrePrefixes.pipeMedium.get(Materials.Bronze)});
            GT_ModHandler.addCraftingRecipe(ItemList.Electric_Pump_LV.get(1L), GT_ModHandler.RecipeBits.DISMANTLEABLE | GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE, new Object[]{"SXO", "dPw", "OMW", 'M', ItemList.Electric_Motor_LV, 'O', OrePrefixes.ring.get(Materials.StyreneButadieneRubber), 'X', OrePrefixes.rotor.get(Materials.Tin), 'S', OrePrefixes.screw.get(Materials.Tin), 'W', OrePrefixes.cableGt01.get(Materials.Tin), 'P', OrePrefixes.pipeMedium.get(Materials.Bronze)});
            GT_ModHandler.addCraftingRecipe(ItemList.Electric_Pump_LV.get(1L), GT_ModHandler.RecipeBits.DISMANTLEABLE | GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE, new Object[]{"SXO", "dPw", "OMW", 'M', ItemList.Electric_Motor_LV, 'O', OrePrefixes.ring.get(Materials.Silicone), 'X', OrePrefixes.rotor.get(Materials.Tin), 'S', OrePrefixes.screw.get(Materials.Tin), 'W', OrePrefixes.cableGt01.get(Materials.Tin), 'P', OrePrefixes.pipeMedium.get(Materials.Bronze)});
            GT_ModHandler.addCraftingRecipe(ItemList.Electric_Pump_MV.get(1L), GT_ModHandler.RecipeBits.DISMANTLEABLE | GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE, new Object[]{"SXO", "dPw", "OMW", 'M', ItemList.Electric_Motor_MV, 'O', OrePrefixes.ring.get(Materials.Rubber), 'X', OrePrefixes.rotor.get(Materials.Bronze), 'S', OrePrefixes.screw.get(Materials.Bronze), 'W', OrePrefixes.cableGt01.get(Materials.Copper), 'P', OrePrefixes.pipeMedium.get(Materials.Steel)});
            GT_ModHandler.addCraftingRecipe(ItemList.Electric_Pump_MV.get(1L), GT_ModHandler.RecipeBits.DISMANTLEABLE | GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE, new Object[]{"SXO", "dPw", "OMW", 'M', ItemList.Electric_Motor_MV, 'O', OrePrefixes.ring.get(Materials.StyreneButadieneRubber), 'X', OrePrefixes.rotor.get(Materials.Bronze), 'S', OrePrefixes.screw.get(Materials.Bronze), 'W', OrePrefixes.cableGt01.get(Materials.Copper), 'P', OrePrefixes.pipeMedium.get(Materials.Steel)});
            GT_ModHandler.addCraftingRecipe(ItemList.Electric_Pump_MV.get(1L), GT_ModHandler.RecipeBits.DISMANTLEABLE | GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE, new Object[]{"SXO", "dPw", "OMW", 'M', ItemList.Electric_Motor_MV, 'O', OrePrefixes.ring.get(Materials.Silicone), 'X', OrePrefixes.rotor.get(Materials.Bronze), 'S', OrePrefixes.screw.get(Materials.Bronze), 'W', OrePrefixes.cableGt01.get(Materials.Copper), 'P', OrePrefixes.pipeMedium.get(Materials.Steel)});
            GT_ModHandler.addCraftingRecipe(ItemList.Electric_Pump_HV.get(1L), GT_ModHandler.RecipeBits.DISMANTLEABLE | GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE, new Object[]{"SXO", "dPw", "OMW", 'M', ItemList.Electric_Motor_HV, 'O', OrePrefixes.ring.get(Materials.Rubber), 'X', OrePrefixes.rotor.get(Materials.Steel), 'S', OrePrefixes.screw.get(Materials.Steel), 'W', OrePrefixes.cableGt01.get(Materials.Gold), 'P', OrePrefixes.pipeMedium.get(Materials.StainlessSteel)});
            GT_ModHandler.addCraftingRecipe(ItemList.Electric_Pump_HV.get(1L), GT_ModHandler.RecipeBits.DISMANTLEABLE | GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE, new Object[]{"SXO", "dPw", "OMW", 'M', ItemList.Electric_Motor_HV, 'O', OrePrefixes.ring.get(Materials.StyreneButadieneRubber), 'X', OrePrefixes.rotor.get(Materials.Steel), 'S', OrePrefixes.screw.get(Materials.Steel), 'W', OrePrefixes.cableGt01.get(Materials.Gold), 'P', OrePrefixes.pipeMedium.get(Materials.StainlessSteel)});
            GT_ModHandler.addCraftingRecipe(ItemList.Electric_Pump_HV.get(1L), GT_ModHandler.RecipeBits.DISMANTLEABLE | GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE, new Object[]{"SXO", "dPw", "OMW", 'M', ItemList.Electric_Motor_HV, 'O', OrePrefixes.ring.get(Materials.Silicone), 'X', OrePrefixes.rotor.get(Materials.Steel), 'S', OrePrefixes.screw.get(Materials.Steel), 'W', OrePrefixes.cableGt01.get(Materials.Gold), 'P', OrePrefixes.pipeMedium.get(Materials.StainlessSteel)});
            GT_ModHandler.addCraftingRecipe(ItemList.Electric_Pump_EV.get(1L), GT_ModHandler.RecipeBits.DISMANTLEABLE | GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE, new Object[]{"SXO", "dPw", "OMW", 'M', ItemList.Electric_Motor_EV, 'O', OrePrefixes.ring.get(Materials.Rubber), 'X', OrePrefixes.rotor.get(Materials.StainlessSteel), 'S', OrePrefixes.screw.get(Materials.StainlessSteel), 'W', OrePrefixes.cableGt01.get(Materials.Aluminium), 'P', OrePrefixes.pipeMedium.get(Materials.Titanium)});
            GT_ModHandler.addCraftingRecipe(ItemList.Electric_Pump_EV.get(1L), GT_ModHandler.RecipeBits.DISMANTLEABLE | GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE, new Object[]{"SXO", "dPw", "OMW", 'M', ItemList.Electric_Motor_EV, 'O', OrePrefixes.ring.get(Materials.StyreneButadieneRubber), 'X', OrePrefixes.rotor.get(Materials.StainlessSteel), 'S', OrePrefixes.screw.get(Materials.StainlessSteel), 'W', OrePrefixes.cableGt01.get(Materials.Aluminium), 'P', OrePrefixes.pipeMedium.get(Materials.Titanium)});
            GT_ModHandler.addCraftingRecipe(ItemList.Electric_Pump_EV.get(1L), GT_ModHandler.RecipeBits.DISMANTLEABLE | GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE, new Object[]{"SXO", "dPw", "OMW", 'M', ItemList.Electric_Motor_EV, 'O', OrePrefixes.ring.get(Materials.Silicone), 'X', OrePrefixes.rotor.get(Materials.StainlessSteel), 'S', OrePrefixes.screw.get(Materials.StainlessSteel), 'W', OrePrefixes.cableGt01.get(Materials.Aluminium), 'P', OrePrefixes.pipeMedium.get(Materials.Titanium)});
            GT_ModHandler.addCraftingRecipe(ItemList.Electric_Pump_IV.get(1L), GT_ModHandler.RecipeBits.DISMANTLEABLE | GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE, new Object[]{"SXO", "dPw", "OMW", 'M', ItemList.Electric_Motor_IV, 'O', OrePrefixes.ring.get(Materials.StyreneButadieneRubber), 'X', OrePrefixes.rotor.get(Materials.TungstenSteel), 'S', OrePrefixes.screw.get(Materials.TungstenSteel), 'W', OrePrefixes.cableGt01.get(Materials.Tungsten), 'P', OrePrefixes.pipeMedium.get(Materials.TungstenSteel)});
            GT_ModHandler.addCraftingRecipe(ItemList.Electric_Pump_IV.get(1L), GT_ModHandler.RecipeBits.DISMANTLEABLE | GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE, new Object[]{"SXO", "dPw", "OMW", 'M', ItemList.Electric_Motor_IV, 'O', OrePrefixes.ring.get(Materials.Silicone), 'X', OrePrefixes.rotor.get(Materials.TungstenSteel), 'S', OrePrefixes.screw.get(Materials.TungstenSteel), 'W', OrePrefixes.cableGt01.get(Materials.Tungsten), 'P', OrePrefixes.pipeMedium.get(Materials.TungstenSteel)});

            //===Conveyors===\\
            GT_ModHandler.addCraftingRecipe(ItemList.Conveyor_Module_LV.get(1L), GT_ModHandler.RecipeBits.DISMANTLEABLE | GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE, new Object[]{"RRR", "MCM", "RRR", 'M', ItemList.Electric_Motor_LV, 'C', OrePrefixes.cableGt01.get(Materials.Tin), 'R', OrePrefixes.plate.get(Materials.Rubber)});
            GT_ModHandler.addCraftingRecipe(ItemList.Conveyor_Module_LV.get(1L), GT_ModHandler.RecipeBits.DISMANTLEABLE | GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE, new Object[]{"RRR", "MCM", "RRR", 'M', ItemList.Electric_Motor_LV, 'C', OrePrefixes.cableGt01.get(Materials.Tin), 'R', OrePrefixes.plate.get(Materials.StyreneButadieneRubber)});
            GT_ModHandler.addCraftingRecipe(ItemList.Conveyor_Module_LV.get(1L), GT_ModHandler.RecipeBits.DISMANTLEABLE | GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE, new Object[]{"RRR", "MCM", "RRR", 'M', ItemList.Electric_Motor_LV, 'C', OrePrefixes.cableGt01.get(Materials.Tin), 'R', OrePrefixes.plate.get(Materials.Silicone)});
            GT_ModHandler.addCraftingRecipe(ItemList.Conveyor_Module_MV.get(1L), GT_ModHandler.RecipeBits.DISMANTLEABLE | GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE, new Object[]{"RRR", "MCM", "RRR", 'M', ItemList.Electric_Motor_MV, 'C', OrePrefixes.cableGt01.get(Materials.Copper), 'R', OrePrefixes.plate.get(Materials.Rubber)});
            GT_ModHandler.addCraftingRecipe(ItemList.Conveyor_Module_MV.get(1L), GT_ModHandler.RecipeBits.DISMANTLEABLE | GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE, new Object[]{"RRR", "MCM", "RRR", 'M', ItemList.Electric_Motor_MV, 'C', OrePrefixes.cableGt01.get(Materials.Copper), 'R', OrePrefixes.plate.get(Materials.StyreneButadieneRubber)});
            GT_ModHandler.addCraftingRecipe(ItemList.Conveyor_Module_MV.get(1L), GT_ModHandler.RecipeBits.DISMANTLEABLE | GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE, new Object[]{"RRR", "MCM", "RRR", 'M', ItemList.Electric_Motor_MV, 'C', OrePrefixes.cableGt01.get(Materials.Copper), 'R', OrePrefixes.plate.get(Materials.Silicone)});
            GT_ModHandler.addCraftingRecipe(ItemList.Conveyor_Module_HV.get(1L), GT_ModHandler.RecipeBits.DISMANTLEABLE | GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE, new Object[]{"RRR", "MCM", "RRR", 'M', ItemList.Electric_Motor_HV, 'C', OrePrefixes.cableGt01.get(Materials.Gold), 'R', OrePrefixes.plate.get(Materials.Rubber)});
            GT_ModHandler.addCraftingRecipe(ItemList.Conveyor_Module_HV.get(1L), GT_ModHandler.RecipeBits.DISMANTLEABLE | GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE, new Object[]{"RRR", "MCM", "RRR", 'M', ItemList.Electric_Motor_HV, 'C', OrePrefixes.cableGt01.get(Materials.Gold), 'R', OrePrefixes.plate.get(Materials.StyreneButadieneRubber)});
            GT_ModHandler.addCraftingRecipe(ItemList.Conveyor_Module_HV.get(1L), GT_ModHandler.RecipeBits.DISMANTLEABLE | GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE, new Object[]{"RRR", "MCM", "RRR", 'M', ItemList.Electric_Motor_HV, 'C', OrePrefixes.cableGt01.get(Materials.Gold), 'R', OrePrefixes.plate.get(Materials.Silicone)});
            GT_ModHandler.addCraftingRecipe(ItemList.Conveyor_Module_EV.get(1L), GT_ModHandler.RecipeBits.DISMANTLEABLE | GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE, new Object[]{"RRR", "MCM", "RRR", 'M', ItemList.Electric_Motor_EV, 'C', OrePrefixes.cableGt01.get(Materials.Aluminium), 'R', OrePrefixes.plate.get(Materials.Rubber)});
            GT_ModHandler.addCraftingRecipe(ItemList.Conveyor_Module_EV.get(1L), GT_ModHandler.RecipeBits.DISMANTLEABLE | GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE, new Object[]{"RRR", "MCM", "RRR", 'M', ItemList.Electric_Motor_EV, 'C', OrePrefixes.cableGt01.get(Materials.Aluminium), 'R', OrePrefixes.plate.get(Materials.StyreneButadieneRubber)});
            GT_ModHandler.addCraftingRecipe(ItemList.Conveyor_Module_EV.get(1L), GT_ModHandler.RecipeBits.DISMANTLEABLE | GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE, new Object[]{"RRR", "MCM", "RRR", 'M', ItemList.Electric_Motor_EV, 'C', OrePrefixes.cableGt01.get(Materials.Aluminium), 'R', OrePrefixes.plate.get(Materials.Silicone)});
            GT_ModHandler.addCraftingRecipe(ItemList.Conveyor_Module_IV.get(1L), GT_ModHandler.RecipeBits.DISMANTLEABLE | GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE, new Object[]{"RRR", "MCM", "RRR", 'M', ItemList.Electric_Motor_IV, 'C', OrePrefixes.cableGt01.get(Materials.Tungsten), 'R', OrePrefixes.plate.get(Materials.StyreneButadieneRubber)});
            GT_ModHandler.addCraftingRecipe(ItemList.Conveyor_Module_IV.get(1L), GT_ModHandler.RecipeBits.DISMANTLEABLE | GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE, new Object[]{"RRR", "MCM", "RRR", 'M', ItemList.Electric_Motor_IV, 'C', OrePrefixes.cableGt01.get(Materials.Tungsten), 'R', OrePrefixes.plate.get(Materials.Silicone)});

            //===Pistons===\\
            GT_ModHandler.addCraftingRecipe(ItemList.Electric_Piston_LV.get(1L), GT_ModHandler.RecipeBits.DISMANTLEABLE | GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE, new Object[]{"PPP", "CSS", "CMG", 'P', OrePrefixes.plate.get(Materials.Steel), 'S', OrePrefixes.stick.get(Materials.Steel), 'G', OrePrefixes.gearGtSmall.get(Materials.Steel), 'M', ItemList.Electric_Motor_LV, 'C', OrePrefixes.cableGt01.get(Materials.Tin)});
            GT_ModHandler.addCraftingRecipe(ItemList.Electric_Piston_MV.get(1L), GT_ModHandler.RecipeBits.DISMANTLEABLE | GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE, new Object[]{"PPP", "CSS", "CMG", 'P', OrePrefixes.plate.get(Materials.Aluminium), 'S', OrePrefixes.stick.get(Materials.Aluminium), 'G', OrePrefixes.gearGtSmall.get(Materials.Aluminium), 'M', ItemList.Electric_Motor_MV, 'C', OrePrefixes.cableGt01.get(Materials.Copper)});
            GT_ModHandler.addCraftingRecipe(ItemList.Electric_Piston_HV.get(1L), GT_ModHandler.RecipeBits.DISMANTLEABLE | GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE, new Object[]{"PPP", "CSS", "CMG", 'P', OrePrefixes.plate.get(Materials.StainlessSteel), 'S', OrePrefixes.stick.get(Materials.StainlessSteel), 'G', OrePrefixes.gearGtSmall.get(Materials.StainlessSteel), 'M', ItemList.Electric_Motor_HV, 'C', OrePrefixes.cableGt01.get(Materials.Gold)});
            GT_ModHandler.addCraftingRecipe(ItemList.Electric_Piston_EV.get(1L), GT_ModHandler.RecipeBits.DISMANTLEABLE | GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE, new Object[]{"PPP", "CSS", "CMG", 'P', OrePrefixes.plate.get(Materials.Titanium), 'S', OrePrefixes.stick.get(Materials.Titanium), 'G', OrePrefixes.gearGtSmall.get(Materials.Titanium), 'M', ItemList.Electric_Motor_EV, 'C', OrePrefixes.cableGt01.get(Materials.Aluminium)});
            GT_ModHandler.addCraftingRecipe(ItemList.Electric_Piston_IV.get(1L), GT_ModHandler.RecipeBits.DISMANTLEABLE | GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE, new Object[]{"PPP", "CSS", "CMG", 'P', OrePrefixes.plate.get(Materials.TungstenSteel), 'S', OrePrefixes.stick.get(Materials.TungstenSteel), 'G', OrePrefixes.gearGtSmall.get(Materials.TungstenSteel), 'M', ItemList.Electric_Motor_IV, 'C', OrePrefixes.cableGt01.get(Materials.Tungsten)});

            //===RobotArms===\\
            GT_ModHandler.addCraftingRecipe(ItemList.Robot_Arm_LV.get(1L), GT_ModHandler.RecipeBits.DISMANTLEABLE | GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE, new Object[]{"CCC", "MSM", "PES", 'S', OrePrefixes.stick.get(Materials.Steel), 'M', ItemList.Electric_Motor_LV, 'P', ItemList.Electric_Piston_LV, 'E', OrePrefixes.circuit.get(Materials.Basic), 'C', OrePrefixes.cableGt01.get(Materials.Tin)});
            GT_ModHandler.addCraftingRecipe(ItemList.Robot_Arm_MV.get(1L), GT_ModHandler.RecipeBits.DISMANTLEABLE | GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE, new Object[]{"CCC", "MSM", "PES", 'S', OrePrefixes.stick.get(Materials.Aluminium), 'M', ItemList.Electric_Motor_MV, 'P', ItemList.Electric_Piston_MV, 'E', OrePrefixes.circuit.get(Materials.Good), 'C', OrePrefixes.cableGt01.get(Materials.Copper)});
            GT_ModHandler.addCraftingRecipe(ItemList.Robot_Arm_HV.get(1L), GT_ModHandler.RecipeBits.DISMANTLEABLE | GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE, new Object[]{"CCC", "MSM", "PES", 'S', OrePrefixes.stick.get(Materials.StainlessSteel), 'M', ItemList.Electric_Motor_HV, 'P', ItemList.Electric_Piston_HV, 'E', OrePrefixes.circuit.get(Materials.Advanced), 'C', OrePrefixes.cableGt01.get(Materials.Gold)});
            GT_ModHandler.addCraftingRecipe(ItemList.Robot_Arm_EV.get(1L), GT_ModHandler.RecipeBits.DISMANTLEABLE | GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE, new Object[]{"CCC", "MSM", "PES", 'S', OrePrefixes.stick.get(Materials.Titanium), 'M', ItemList.Electric_Motor_EV, 'P', ItemList.Electric_Piston_EV, 'E', OrePrefixes.circuit.get(Materials.Data), 'C', OrePrefixes.cableGt01.get(Materials.Aluminium)});
            GT_ModHandler.addCraftingRecipe(ItemList.Robot_Arm_IV.get(1L), GT_ModHandler.RecipeBits.DISMANTLEABLE | GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE, new Object[]{"CCC", "MSM", "PES", 'S', OrePrefixes.stick.get(Materials.TungstenSteel), 'M', ItemList.Electric_Motor_IV, 'P', ItemList.Electric_Piston_IV, 'E', OrePrefixes.circuit.get(Materials.Elite), 'C', OrePrefixes.cableGt01.get(Materials.Tungsten)});

            //===Emitters===\\
            GT_ModHandler.addCraftingRecipe(ItemList.Emitter_LV.get(1L), GT_ModHandler.RecipeBits.DISMANTLEABLE | GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE, new Object[]{"SSC", "WQS", "CWS", 'Q', OrePrefixes.gem.get(Materials.CertusQuartz), 'S', OrePrefixes.stick.get(Materials.Brass), 'C', OrePrefixes.circuit.get(Materials.Basic), 'W', OrePrefixes.cableGt01.get(Materials.Tin)});
            GT_ModHandler.addCraftingRecipe(ItemList.Emitter_LV.get(1L), GT_ModHandler.RecipeBits.DISMANTLEABLE | GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE, new Object[]{"SSC", "WQS", "CWS", 'Q', OrePrefixes.gem.get(Materials.Quartzite), 'S', OrePrefixes.stick.get(Materials.Brass), 'C', OrePrefixes.circuit.get(Materials.Basic), 'W', OrePrefixes.cableGt01.get(Materials.Tin)});
            GT_ModHandler.addCraftingRecipe(ItemList.Emitter_MV.get(1L), GT_ModHandler.RecipeBits.DISMANTLEABLE | GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE, new Object[]{"SSC", "WQS", "CWS", 'Q', OrePrefixes.gem.get(Materials.NetherQuartz), 'S', OrePrefixes.stick.get(Materials.Electrum), 'C', OrePrefixes.circuit.get(Materials.Good), 'W', OrePrefixes.cableGt01.get(Materials.Copper)});
            GT_ModHandler.addCraftingRecipe(ItemList.Emitter_HV.get(1L), GT_ModHandler.RecipeBits.DISMANTLEABLE | GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE, new Object[]{"SSC", "WQS", "CWS", 'Q', OrePrefixes.gemFlawed.get(Materials.Emerald), 'S', OrePrefixes.stick.get(Materials.Chrome), 'C', OrePrefixes.circuit.get(Materials.Advanced), 'W', OrePrefixes.cableGt01.get(Materials.Gold)});
            GT_ModHandler.addCraftingRecipe(ItemList.Emitter_EV.get(1L), GT_ModHandler.RecipeBits.DISMANTLEABLE | GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE, new Object[]{"SSC", "WQS", "CWS", 'Q', CoreItems2.getRecipe(ChargedGlassLense.getMetaID(), 1), 'S', OrePrefixes.stick.get(Materials.Platinum), 'C', OrePrefixes.circuit.get(Materials.Data), 'W', OrePrefixes.cableGt01.get(Materials.Aluminium)});
            GT_ModHandler.addCraftingRecipe(ItemList.Emitter_IV.get(1L), GT_ModHandler.RecipeBits.DISMANTLEABLE | GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE, new Object[]{"SSC", "WQS", "CWS", 'Q', CoreItems2.getRecipe(HugeChargedGlassLense.getMetaID(), 1), 'S', OrePrefixes.stick.get(Materials.Iridium), 'C', OrePrefixes.circuit.get(Materials.Elite), 'W', OrePrefixes.cableGt01.get(Materials.Tungsten)});

            //===Sensors===\\
            GT_ModHandler.addCraftingRecipe(ItemList.Sensor_LV.get(1L), GT_ModHandler.RecipeBits.DISMANTLEABLE | GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE, new Object[]{"P Q", "PS ", "CPP", 'Q', OrePrefixes.gem.get(Materials.CertusQuartz), 'S', OrePrefixes.stick.get(Materials.Brass), 'P', OrePrefixes.plate.get(Materials.Steel), 'C', OrePrefixes.circuit.get(Materials.Basic)});
            GT_ModHandler.addCraftingRecipe(ItemList.Sensor_LV.get(1L), GT_ModHandler.RecipeBits.DISMANTLEABLE | GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE, new Object[]{"P Q", "PS ", "CPP", 'Q', OrePrefixes.gem.get(Materials.Quartzite), 'S', OrePrefixes.stick.get(Materials.Brass), 'P', OrePrefixes.plate.get(Materials.Steel), 'C', OrePrefixes.circuit.get(Materials.Basic)});
            GT_ModHandler.addCraftingRecipe(ItemList.Sensor_MV.get(1L), GT_ModHandler.RecipeBits.DISMANTLEABLE | GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE, new Object[]{"P Q", "PS ", "CPP", 'Q', OrePrefixes.gem.get(Materials.NetherQuartz), 'S', OrePrefixes.stick.get(Materials.Electrum), 'P', OrePrefixes.plate.get(Materials.Aluminium), 'C', OrePrefixes.circuit.get(Materials.Good)});
            GT_ModHandler.addCraftingRecipe(ItemList.Sensor_HV.get(1L), GT_ModHandler.RecipeBits.DISMANTLEABLE | GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE, new Object[]{"P Q", "PS ", "CPP", 'Q', OrePrefixes.gemFlawed.get(Materials.Emerald), 'S', OrePrefixes.stick.get(Materials.Chrome), 'P', OrePrefixes.plate.get(Materials.StainlessSteel), 'C', OrePrefixes.circuit.get(Materials.Advanced)});
            GT_ModHandler.addCraftingRecipe(ItemList.Sensor_EV.get(1L), GT_ModHandler.RecipeBits.DISMANTLEABLE | GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE, new Object[]{"P Q", "PS ", "CPP", 'Q', CoreItems2.getRecipe(ChargedGlassLense.getMetaID(), 1), 'S', OrePrefixes.stick.get(Materials.Platinum), 'P', OrePrefixes.plate.get(Materials.Titanium), 'C', OrePrefixes.circuit.get(Materials.Data)});
            GT_ModHandler.addCraftingRecipe(ItemList.Sensor_IV.get(1L), GT_ModHandler.RecipeBits.DISMANTLEABLE | GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE, new Object[]{"P Q", "PS ", "CPP", 'Q', CoreItems2.getRecipe(HugeChargedGlassLense.getMetaID(), 1), 'S', OrePrefixes.stick.get(Materials.Iridium), 'P', OrePrefixes.plate.get(Materials.TungstenSteel), 'C', OrePrefixes.circuit.get(Materials.Elite)});

            //===FieldGenerators===\\
            GT_ModHandler.addCraftingRecipe(ItemList.Field_Generator_LV.get(1L), GT_ModHandler.RecipeBits.DISMANTLEABLE | GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE, new Object[]{"WCW", "CGC", "WCW", 'G', ItemList.Emitter_LV, 'C', OrePrefixes.circuit.get(Materials.Good), 'W', OrePrefixes.plate.get(Materials.RedSteel)});
            GT_ModHandler.addCraftingRecipe(ItemList.Field_Generator_MV.get(1L), GT_ModHandler.RecipeBits.DISMANTLEABLE | GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE, new Object[]{"WCW", "CGC", "WCW", 'G', ItemList.Emitter_MV, 'C', OrePrefixes.circuit.get(Materials.Advanced), 'W', OrePrefixes.plate.get(Materials.BT6)});
            GT_ModHandler.addCraftingRecipe(ItemList.Field_Generator_HV.get(1L), GT_ModHandler.RecipeBits.DISMANTLEABLE | GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE, new Object[]{"WCW", "CGC", "WCW", 'G', ItemList.Emitter_HV, 'C', OrePrefixes.circuit.get(Materials.Data), 'W', OrePrefixes.plateDouble.get(Materials.HSSG)});
            GT_ModHandler.addCraftingRecipe(ItemList.Field_Generator_EV.get(1L), GT_ModHandler.RecipeBits.DISMANTLEABLE | GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE, new Object[]{"WCW", "CGC", "WCW", 'G', ItemList.Emitter_EV, 'C', OrePrefixes.circuit.get(Materials.Elite), 'W', OrePrefixes.plateDouble.get(Materials.NiobiumTitanium)});
            GT_ModHandler.addCraftingRecipe(ItemList.Field_Generator_IV.get(1L), GT_ModHandler.RecipeBits.DISMANTLEABLE | GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE, new Object[]{"WCW", "CGC", "WCW", 'G', ItemList.Emitter_IV, 'C', OrePrefixes.circuit.get(Materials.Master), 'W', OrePrefixes.plateTriple.get(Materials.HSSS)});
        }

        //=== Super / Quant tanks ===//
        GT_ModHandler.addCraftingRecipe(ItemList.Super_Tank_ULV.get(1L), GT_ModHandler.RecipeBits.DISMANTLEABLE | GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE | GT_ModHandler.RecipeBits.BUFFERED, new Object[]{"DGD", "PMP", "DUD", 'U', GT_ItemList.ULVPump, 'M', ItemList.Casing_Tank_0, 'G', OrePrefixes.pipeMedium.get(Materials.Bronze), 'D', OrePrefixes.circuit.get(Materials.Primitive), 'P', OrePrefixes.plate.get(Materials.Steel)});
        GT_ModHandler.addCraftingRecipe(ItemList.Super_Tank_LV.get(1L), GT_ModHandler.RecipeBits.DISMANTLEABLE | GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE | GT_ModHandler.RecipeBits.BUFFERED, new Object[]{"DGD", "PMP", "DUD", 'U', ItemList.Electric_Pump_LV, 'M', ItemList.Casing_Tank_1, 'G', OrePrefixes.pipeLarge.get(Materials.Bronze), 'D', OrePrefixes.circuit.get(Materials.Basic), 'P', OrePrefixes.plate.get(Materials.Aluminium)});
        GT_ModHandler.addCraftingRecipe(ItemList.Super_Tank_MV.get(1L), GT_ModHandler.RecipeBits.DISMANTLEABLE | GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE | GT_ModHandler.RecipeBits.BUFFERED, new Object[]{"DGD", "PMP", "DUD", 'U', ItemList.Electric_Pump_MV, 'M', ItemList.Casing_Tank_2, 'G', OrePrefixes.pipeLarge.get(Materials.Steel), 'D', OrePrefixes.circuit.get(Materials.Good), 'P', OrePrefixes.plate.get(Materials.StainlessSteel)});
        GT_ModHandler.addCraftingRecipe(ItemList.Super_Tank_HV.get(1L), GT_ModHandler.RecipeBits.DISMANTLEABLE | GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE | GT_ModHandler.RecipeBits.BUFFERED, new Object[]{"DGD", "PMP", "DUD", 'U', ItemList.Electric_Pump_HV, 'M', ItemList.Casing_Tank_3, 'G', ItemList.Field_Generator_LV, 'D', OrePrefixes.circuit.get(Materials.Advanced), 'P', OrePrefixes.plate.get(Materials.StainlessSteel)});
        GT_ModHandler.addCraftingRecipe(ItemList.Super_Tank_EV.get(1L), GT_ModHandler.RecipeBits.DISMANTLEABLE | GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE | GT_ModHandler.RecipeBits.BUFFERED, new Object[]{"DGD", "PMP", "DUD", 'U', ItemList.Electric_Pump_EV, 'M', ItemList.Casing_Tank_4, 'G', ItemList.Field_Generator_MV, 'D', OrePrefixes.circuit.get(Materials.Data), 'P', OrePrefixes.plate.get(Materials.Titanium)});
        GT_ModHandler.addCraftingRecipe(ItemList.Super_Tank_IV.get(1L), GT_ModHandler.RecipeBits.DISMANTLEABLE | GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE | GT_ModHandler.RecipeBits.BUFFERED, new Object[]{"DGD", "PMP", "DUD", 'U', ItemList.Electric_Pump_IV, 'M', ItemList.Casing_Tank_5, 'G', ItemList.Field_Generator_HV, 'D', OrePrefixes.circuit.get(Materials.Elite), 'P', OrePrefixes.plate.get(Materials.Titanium)});
        GT_ModHandler.addCraftingRecipe(ItemList.Quantum_Tank_LV.get(1L), GT_ModHandler.RecipeBits.DISMANTLEABLE | GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE | GT_ModHandler.RecipeBits.BUFFERED, new Object[]{"DGD", "PMP", "DUD", 'U', ItemList.Electric_Pump_IV, 'M', ItemList.Casing_Tank_6, 'G', ItemList.Field_Generator_EV, 'D', OrePrefixes.circuit.get(Materials.Master), 'P', OrePrefixes.plate.get(Materials.TungstenSteel)});
        GT_ModHandler.addCraftingRecipe(ItemList.Quantum_Tank_MV.get(1L), GT_ModHandler.RecipeBits.DISMANTLEABLE | GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE | GT_ModHandler.RecipeBits.BUFFERED, new Object[]{"DGD", "PMP", "DUD", 'U', ItemList.Electric_Pump_IV, 'M', ItemList.Casing_Tank_7, 'G', ItemList.Field_Generator_IV, 'D', OrePrefixes.circuit.get(Materials.Ultimate), 'P', OrePrefixes.plate.get(Materials.HSSG)});
        GT_ModHandler.addCraftingRecipe(ItemList.Quantum_Tank_HV.get(1L), GT_ModHandler.RecipeBits.DISMANTLEABLE | GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE | GT_ModHandler.RecipeBits.BUFFERED, new Object[]{"DGD", "PMP", "DUD", 'U', ItemList.Electric_Pump_LuV, 'M', ItemList.Casing_Tank_8, 'G', ItemList.Field_Generator_LuV, 'D', OrePrefixes.circuit.get(Materials.Superconductor), 'P', OrePrefixes.plate.get(Materials.HSSS)});
        GT_ModHandler.addCraftingRecipe(ItemList.Quantum_Tank_EV.get(1L), GT_ModHandler.RecipeBits.DISMANTLEABLE | GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE | GT_ModHandler.RecipeBits.BUFFERED, new Object[]{"DGD", "PMP", "DUD", 'U', ItemList.Electric_Pump_ZPM, 'M', ItemList.Casing_Tank_9, 'G', ItemList.Field_Generator_ZPM, 'D', OrePrefixes.circuit.get(Materials.Infinite), 'P', OrePrefixes.plate.get(Materials.Europium)});
        GT_ModHandler.addCraftingRecipe(ItemList.Quantum_Tank_IV.get(1L), GT_ModHandler.RecipeBits.DISMANTLEABLE | GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE | GT_ModHandler.RecipeBits.BUFFERED, new Object[]{"DGD", "PMP", "DUD", 'U', ItemList.Electric_Pump_UV, 'M', ItemList.Casing_Tank_10, 'G', ItemList.Field_Generator_UV, 'D', OrePrefixes.circuit.get(Materials.Bio), 'P', OrePrefixes.plate.get(Materials.Americium)});

        //=== Super / Quant tanks casing ===//
        GT_ModHandler.addCraftingRecipe(ItemList.Casing_Tank_0.get(1L), new Object[]{"PPP", "PIP", "PPP", 'P', OrePrefixes.plate.get(Materials.WroughtIron), 'I', OrePrefixes.pipeLarge.get(Materials.Bronze)});
        GT_ModHandler.addCraftingRecipe(ItemList.Casing_Tank_1.get(1L), new Object[]{"PPP", "PIP", "PPP", 'P', OrePrefixes.plate.get(Materials.Steel), 'I', OrePrefixes.pipeLarge.get(Materials.Steel)});
        GT_ModHandler.addCraftingRecipe(ItemList.Casing_Tank_2.get(1L), new Object[]{"PPP", "PIP", "PPP", 'P', OrePrefixes.plate.get(Materials.Aluminium), 'I', OrePrefixes.pipeLarge.get(Materials.Plastic)});
        GT_ModHandler.addCraftingRecipe(ItemList.Casing_Tank_3.get(1L), new Object[]{"PPP", "PIP", "PPP", 'P', OrePrefixes.plate.get(Materials.StainlessSteel), 'I', OrePrefixes.pipeLarge.get(Materials.Polytetrafluoroethylene)});
        GT_ModHandler.addCraftingRecipe(ItemList.Casing_Tank_4.get(1L), new Object[]{"PPP", "PIP", "PPP", 'P', OrePrefixes.plate.get(Materials.Titanium), 'I', OrePrefixes.pipeLarge.get(Materials.StainlessSteel)});
        GT_ModHandler.addCraftingRecipe(ItemList.Casing_Tank_5.get(1L), new Object[]{"PPP", "PIP", "PPP", 'P', OrePrefixes.plate.get(Materials.TungstenSteel), 'I', OrePrefixes.pipeLarge.get(Materials.Titanium)});
        GT_ModHandler.addCraftingRecipe(ItemList.Casing_Tank_6.get(1L), new Object[]{"PPP", "PIP", "PPP", 'P', OrePrefixes.plate.get(Materials.Chrome), 'I', OrePrefixes.pipeLarge.get(Materials.TungstenSteel)});
        GT_ModHandler.addCraftingRecipe(ItemList.Casing_Tank_7.get(1L), new Object[]{"PPP", "PIP", "PPP", 'P', OrePrefixes.plate.get(Materials.Iridium), 'I', OrePrefixes.pipeLarge.get(Materials.NiobiumTitanium)});
        GT_ModHandler.addCraftingRecipe(ItemList.Casing_Tank_8.get(1L), new Object[]{"PPP", "PIP", "PPP", 'P', OrePrefixes.plate.get(Materials.Osmium), 'I', OrePrefixes.pipeLarge.get(Materials.Enderium)});
        GT_ModHandler.addCraftingRecipe(ItemList.Casing_Tank_9.get(1L), new Object[]{"PPP", "PIP", "PPP", 'P', OrePrefixes.plate.get(Materials.Tritanium), 'I', OrePrefixes.pipeLarge.get(Materials.Naquadah)});
        GT_ModHandler.addCraftingRecipe(ItemList.Casing_Tank_10.get(1L), new Object[]{"PPP", "PIP", "PPP", 'P', OrePrefixes.plate.get(Materials.Neutronium), 'I', OrePrefixes.pipeLarge.get(Materials.NetherStar)});

        //=== Super / Quant chests ===//
        GT_ModHandler.addCraftingRecipe(ItemList.Super_Chest_LV.get(1L), bitsd, new Object[]{"DMD", "PCP", "DGD", 'C', ItemList.Hull_LV, 'M', ItemList.Conveyor_Module_MV, 'G', OrePrefixes.pipeLarge.get(Materials.Brass), 'D', OrePrefixes.circuit.get(Materials.Basic), 'P', OrePrefixes.plateDense.get(Materials.Iron)});
        GT_ModHandler.addCraftingRecipe(ItemList.Super_Chest_MV.get(1L), bitsd, new Object[]{"DMD", "PCP", "DGD", 'C', ItemList.Hull_MV, 'M', ItemList.Conveyor_Module_HV, 'G', OrePrefixes.pipeLarge.get(Materials.Aluminium), 'D', OrePrefixes.circuit.get(Materials.Good), 'P', OrePrefixes.plateDense.get(Materials.Steel)});
        GT_ModHandler.addCraftingRecipe(ItemList.Super_Chest_HV.get(1L), bitsd, new Object[]{"DMD", "PCP", "DGD", 'C', ItemList.Hull_HV, 'M', ItemList.Conveyor_Module_HV, 'G', ItemList.Field_Generator_LV, 'D', OrePrefixes.circuit.get(Materials.Advanced), 'P', OrePrefixes.plateQuintuple.get(Materials.Aluminium)});
        GT_ModHandler.addCraftingRecipe(ItemList.Super_Chest_EV.get(1L), bitsd, new Object[]{"DMD", "PCP", "DGD", 'C', ItemList.Hull_EV, 'M', ItemList.Conveyor_Module_EV, 'G', ItemList.Field_Generator_MV, 'D', OrePrefixes.circuit.get(Materials.Data), 'P', OrePrefixes.plateQuintuple.get(Materials.StainlessSteel)});
        GT_ModHandler.addCraftingRecipe(ItemList.Super_Chest_IV.get(1L), bitsd, new Object[]{"DMD", "PCP", "DGD", 'C', ItemList.Hull_IV, 'M', ItemList.Conveyor_Module_EV, 'G', ItemList.Field_Generator_HV, 'D', OrePrefixes.circuit.get(Materials.Elite), 'P', OrePrefixes.plateQuadruple.get(Materials.Titanium)});
        GT_ModHandler.addCraftingRecipe(ItemList.Quantum_Chest_LV.get(1L), bitsd, new Object[]{"DMD", "PCP", "DGD", 'C', ItemList.Hull_LuV, 'M', ItemList.Conveyor_Module_IV, 'G', ItemList.Field_Generator_EV, 'D', OrePrefixes.circuit.get(Materials.Master), 'P', OrePrefixes.plateQuadruple.get(Materials.TungstenSteel)});
        GT_ModHandler.addCraftingRecipe(ItemList.Quantum_Chest_MV.get(1L), bitsd, new Object[]{"DMD", "PCP", "DGD", 'C', ItemList.Hull_ZPM, 'M', ItemList.Conveyor_Module_IV, 'G', ItemList.Field_Generator_IV, 'D', OrePrefixes.circuit.get(Materials.Ultimate), 'P', OrePrefixes.plateTriple.get(Materials.HSSG)});
        GT_ModHandler.addCraftingRecipe(ItemList.Quantum_Chest_HV.get(1L), bitsd, new Object[]{"DMD", "PCP", "DGD", 'C', ItemList.Hull_UV, 'M', ItemList.Conveyor_Module_LuV, 'G', ItemList.Field_Generator_LuV, 'D', OrePrefixes.circuit.get(Materials.Superconductor), 'P', OrePrefixes.plateTriple.get(Materials.HSSS)});
        GT_ModHandler.addCraftingRecipe(ItemList.Quantum_Chest_EV.get(1L), bitsd, new Object[]{"DMD", "PCP", "DGD", 'C', ItemList.Hull_MAX, 'M', ItemList.Conveyor_Module_ZPM, 'G', ItemList.Field_Generator_ZPM, 'D', OrePrefixes.circuit.get(Materials.Infinite), 'P', OrePrefixes.plateDouble.get(Materials.Europium)});
        GT_ModHandler.addCraftingRecipe(ItemList.Quantum_Chest_IV.get(1L), bitsd, new Object[]{"DMD", "PCP", "DGD", 'C', ItemList.Hull_UEV, 'M', ItemList.Conveyor_Module_UV, 'G', ItemList.Field_Generator_UV, 'D', OrePrefixes.circuit.get(Materials.Bio), 'P', OrePrefixes.plate.get(Materials.Americium)});

        //GT Wood Ring
        GT_ModHandler.addCraftingRecipe(
                GT_OreDictUnificator.get(OrePrefixes.ring, Materials.Wood, 4L),
                new Object[]{
                        "k ",
                        " S",
                        'S', GT_OreDictUnificator.get(OrePrefixes.plank, Materials.Wood, 1L)
                });
        //Stone Dust
        GT_ModHandler.addShapelessCraftingRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Stone, 1L),
                new Object[]{"stone", ToolDictNames.craftingToolMortar
                });

        //Brick Dust
        GT_ModHandler.addShapelessCraftingRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Brick, 1L),
                new Object[]{new ItemStack(Blocks.brick_block), ToolDictNames.craftingToolMortar
                });

        //Filter Casing
        GT_ModHandler.addCraftingRecipe(
                ItemList.Casing_Vent.get(6L), tBitMask, new Object[]{"PPP", "SFS", "MIV",
                        'P', CoreItems2.getRecipe(SteelBars.getMetaID(), 1),
                        'I', OrePrefixes.stick.get(Materials.StainlessSteel), 'F', OrePrefixes.frameGt.get(Materials.VanadiumSteel),
                        'M', ItemList.Electric_Motor_HV, 'V', OrePrefixes.rotor.get(Materials.BlackSteel), 'S', ItemList.Component_Filter});
        GT_ModHandler.addCraftingRecipe(
                ItemList.Casing_Vent.get(24L), tBitMask, new Object[]{"PSP", "GFR", "MIV",
                        'P', CoreItems2.getRecipe(SteelBars.getMetaID(), 1),
                        'G', OrePrefixes.gearGtSmall.get(Materials.Titanium), 'R', OrePrefixes.ring.get(Materials.Titanium),
                        'I', OrePrefixes.stickLong.get(Materials.Titanium), 'F', OrePrefixes.frameGt.get(Materials.Titanium),
                        'M', ItemList.Electric_Motor_EV, 'V', OrePrefixes.rotor.get(Materials.HSLA), 'S', ItemList.Component_Filter});
        GT_ModHandler.addCraftingRecipe(
                ItemList.Casing_Vent.get(64L), tBitMask, new Object[]{"PSP", "GFR", "MIV",
                        'P', GT_ModHandler.getModItem("EnderIO", "blockDarkIronBars", 1L),
                        'G', OrePrefixes.gearGtSmall.get(Materials.TungstenSteel), 'R', OrePrefixes.ring.get(Materials.TungstenSteel),
                        'I', OrePrefixes.stickLong.get(Materials.TungstenSteel), 'F', OrePrefixes.frameGt.get(Materials.MaragingSteel250),
                        'M', ItemList.Electric_Motor_IV, 'V', OrePrefixes.rotor.get(Materials.HastelloyC276), 'S', ItemList.Component_Filter});
        //Grate Machine Casing
        GT_ModHandler.addCraftingRecipe(
                ItemList.Casing_Grate.get(6L), tBitMask, new Object[]{"PVP", "PFP", "PMP",
                        'P', CoreItems2.getRecipe(SteelBars.getMetaID(), 1),
                        'F', OrePrefixes.frameGt.get(Materials.VanadiumSteel),
                        'M', ItemList.Electric_Motor_HV, 'V', OrePrefixes.rotor.get(Materials.BlackSteel)});
        GT_ModHandler.addCraftingRecipe(
                ItemList.Casing_Grate.get(24L), tBitMask, new Object[]{"PVP", "PFP", "PMP",
                        'P', CoreItems2.getRecipe(SteelBars.getMetaID(), 1),
                        'F', OrePrefixes.frameGt.get(Materials.Titanium),
                        'M', ItemList.Electric_Motor_EV, 'V', OrePrefixes.rotor.get(Materials.HSLA)});
        GT_ModHandler.addCraftingRecipe(
                ItemList.Casing_Grate.get(64L), tBitMask, new Object[]{"PVP", "PFP", "PMP",
                        'P', GT_ModHandler.getModItem("EnderIO", "blockDarkIronBars", 1L),
                        'F', OrePrefixes.frameGt.get(Materials.MaragingSteel250),
                        'M', ItemList.Electric_Motor_IV, 'V', OrePrefixes.rotor.get(Materials.HastelloyC276)});

        // --- Solar Panel
        GT_ModHandler.addCraftingRecipe(ItemList.Cover_SolarPanel.get(1L), tBitMask, new Object[]{"SGS", "CPC", "TRT", 'C', OrePrefixes.circuit.get(Materials.Basic), 'G', GT_ModHandler.getIC2Item("reinforcedGlass", 1L), 'P', OrePrefixes.plateAlloy.get(Materials.Carbon), 'S', ItemList.Circuit_Silicon_Wafer, 'T', OrePrefixes.wireGt01.get(Materials.RedAlloy), 'R', CoreItems2.getRecipe(101, 1)});
        GT_ModHandler.addCraftingRecipe(ItemList.Cover_SolarPanel_8V.get(1L), tBitMask, new Object[]{"GRG", "CAC", "GRG", 'C', OrePrefixes.circuit.get(Materials.Good), 'G', ItemList.Cover_SolarPanel, 'R', OrePrefixes.plate.get(Materials.GalliumArsenide), 'A', CoreItems2.getRecipe(109, 1)});
        GT_ModHandler.addCraftingRecipe(ItemList.Cover_SolarPanel_LV.get(1L), tBitMask, new Object[]{"GRG", "CAC", "GRG", 'C', OrePrefixes.circuit.get(Materials.Good), 'G', ItemList.Cover_SolarPanel_8V, 'R', OrePrefixes.plate.get(Materials.Plastic), 'A', OrePrefixes.plateDouble.get(Materials.HSLA)});
        GT_ModHandler.addCraftingRecipe(ItemList.Cover_SolarPanel_MV.get(1L), tBitMask, new Object[]{"GRG", "CAC", "GRG", 'C', OrePrefixes.circuit.get(Materials.Advanced), 'G', ItemList.Cover_SolarPanel_LV, 'R', OrePrefixes.plate.get(Materials.Polytetrafluoroethylene), 'A', CoreItems2.getRecipe(110, 1)});
        GT_ModHandler.addCraftingRecipe(ItemList.Cover_SolarPanel_HV.get(1L), tBitMask, new Object[]{"GRG", "CAC", "GRG", 'C', OrePrefixes.circuit.get(Materials.Data), 'G', ItemList.Cover_SolarPanel_MV, 'R', OrePrefixes.plate.get(Materials.EpoxidFiberReinforced), 'A', CoreItems2.getRecipe(111, 1)});

        // --- Air Filter
        GT_ModHandler.addCraftingRecipe(ItemList.Casing_AirFilter_Vent.get(2L), tBitMask, new Object[]{"PhP", "TFT", "PwP", 'T', CoreItems2.getRecipe(SteelBars.getMetaID(), 1), 'F', OrePrefixes.frameGt.get(Materials.Steel), 'P', OrePrefixes.plate.get(Materials.Steel)});
        GT_ModHandler.addCraftingRecipe(ItemList.Casing_AirFilter.get(1L), tBitMask, new Object[]{"SSS", "RVR", "MSM", 'V', ItemList.Casing_AirFilter_Vent, 'S',OrePrefixes.stickLong.get(Materials.StainlessSteel), 'R', OrePrefixes.rotor.get(Materials.StainlessSteel), 'M', ItemList.Electric_Motor_HV, 'R', OrePrefixes.screw.get(Materials.StainlessSteel)});
        GT_ModHandler.addCraftingRecipe(ItemList.Machine_Multi_AirFilter.get(1L), tBitMask, new Object[]{"RPR", "MBM", "CGC", 'B', ItemList.Hull_HV, 'R', OrePrefixes.rotor.get(Materials.StainlessSteel), 'P', ItemList.Electric_Pump_HV, 'M', ItemList.Electric_Motor_HV, 'C', OrePrefixes.cableGt01.get(Materials.Gold), 'G', ItemList.Casing_Turbine1});
    }

    private void assemblerRecipe() {
        // --- Air Filter
        RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.StainlessSteel, 16L), GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Titanium, 4L), ItemList.AdsorptionFilterCasing.get(1L), 200, 480);

        // --- Assembling Line Casing
        RA.addAssemblerRecipe(
                new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Steel, 4L),
                        ItemList.Robot_Arm_IV.get(2L),
                        GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.TungstenSteel, 1L),
                        GT_Utility.getIntegratedCircuit(3)}, null, ItemList.Casing_Gearbox_TungstenSteel.get(2L), 50, 16);
        // --- Processor Machine Casing
        RA.addAssemblerRecipe(
                new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.StainlessSteel, 4L),
                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Elite, 4L),
                        ItemList.Casing_SolidSteel.get(1L),
                        GT_Utility.getIntegratedCircuit(1)}, null, ItemList.Casing_Processor.get(1L), 50, 16);
        // --- Assembler Machine Casing
        RA.addAssemblerRecipe(
                new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Data, 6L),
                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Elite, 1L),
                        ItemList.Electric_Motor_IV.get(1L),
                        GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.TungstenSteel, 1L),
                        GT_Utility.getIntegratedCircuit(3)}, null, ItemList.Casing_Assembler.get(2L), 50, 16);
        // --- Pump Machine Casing
        RA.addAssemblerRecipe(
                new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.StainlessSteel, 4L),
                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Advanced, 2L),
                        ItemList.Electric_Pump_HV.get(2L),
                        ItemList.Casing_SolidSteel.get(1L),
                        GT_Utility.getIntegratedCircuit(1)}, null, ItemList.Casing_Pump.get(1L), 50, 16);
        // --- Bronze Pipe Casing
        RA.addAssemblerRecipe(
                new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Bronze, 4L),
                        GT_OreDictUnificator.get(OrePrefixes.pipeMedium, Materials.Bronze, 4L),
                        GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Bronze, 1L),
                        GT_Utility.getIntegratedCircuit(3)}, null, ItemList.Casing_Pipe_Bronze.get(2L), 50, 16);
        // --- Steel Pipe Casing
        RA.addAssemblerRecipe(
                new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Steel, 4L),
                        GT_OreDictUnificator.get(OrePrefixes.pipeMedium, Materials.Steel, 4L),
                        GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Steel, 1L),
                        GT_Utility.getIntegratedCircuit(3)}, null, ItemList.Casing_Pipe_Steel.get(2L), 50, 16);
        // --- Titanium Pipe Casing
        RA.addAssemblerRecipe(
                new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Titanium, 4L),
                        GT_OreDictUnificator.get(OrePrefixes.pipeMedium, Materials.Titanium, 4L),
                        GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Titanium, 1L),
                        GT_Utility.getIntegratedCircuit(3)}, null, ItemList.Casing_Pipe_Titanium.get(2L), 50, 16);
        // --- TungstenSteel Pipe Casing
        RA.addAssemblerRecipe(
                new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.plate, Materials.TungstenSteel, 4L),
                        GT_OreDictUnificator.get(OrePrefixes.pipeMedium, Materials.TungstenSteel, 4L),
                        GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.TungstenSteel, 1L),
                        GT_Utility.getIntegratedCircuit(3)}, null, ItemList.Casing_Pipe_TungstenSteel.get(2L), 50, 16);
        // --- PTFE Pipe Casing
        RA.addAssemblerRecipe(
                new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Polytetrafluoroethylene, 4L),
                        GT_OreDictUnificator.get(OrePrefixes.pipeMedium, Materials.Polytetrafluoroethylene, 4L),
                        GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Polytetrafluoroethylene, 1L),
                        GT_Utility.getIntegratedCircuit(3)}, null, ItemList.Casing_Pipe_Polytetrafluoroethylene.get(2L), 50, 16);
        // --- Motor Machine Casing
        RA.addAssemblerRecipe(
                new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.StainlessSteel, 4L),
                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Advanced, 2L),
                        ItemList.Electric_Motor_HV.get(2L),
                        ItemList.Casing_SolidSteel.get(1L),
                        GT_Utility.getIntegratedCircuit(1)}, null, ItemList.Casing_Motor.get(1L), 50, 16);
        // --- Grate Machine Casing
        RA.addAssemblerRecipe(
                new ItemStack[]{GT_ModHandler.getModItem("minecraft", "iron_bars", 6L),
                        GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.Steel, 1L),
                        ItemList.Electric_Motor_MV.get(1L),
                        GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Steel, 1L),
                        GT_Utility.getIntegratedCircuit(4)}, null, ItemList.Casing_Grate.get(2L), 50, 16);
        RA.addAssemblerRecipe(
                new ItemStack[]{CoreItems2.getRecipe(51, 6),
                        GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.BlackSteel, 1L),
                        ItemList.Electric_Motor_HV.get(1L),
                        GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.VanadiumSteel, 1L),
                        GT_Utility.getIntegratedCircuit(4)}, null, ItemList.Casing_Grate.get(6L), 50, 16);
        RA.addAssemblerRecipe(
                new ItemStack[]{CoreItems2.getRecipe(51, 6),
                        GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.HSLA, 1L),
                        ItemList.Electric_Motor_EV.get(1L),
                        GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Titanium, 1L),
                        GT_Utility.getIntegratedCircuit(4)}, null, ItemList.Casing_Grate.get(24L), 50, 16);
        RA.addAssemblerRecipe(
                new ItemStack[]{GT_ModHandler.getModItem("EnderIO", "blockDarkIronBars", 6L),
                        GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.HastelloyC276, 1L),
                        ItemList.Electric_Motor_IV.get(1L),
                        GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.MaragingSteel250, 1L),
                        GT_Utility.getIntegratedCircuit(4)}, null, ItemList.Casing_Grate.get(64L), 50, 16);
        // --- Filter Machine Casing
        RA.addAssemblerRecipe(
                new ItemStack[]{GT_ModHandler.getModItem("minecraft", "iron_bars", 3L),
                        ItemList.Component_Filter.get(3L),
                        GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.Steel, 1L),
                        ItemList.Electric_Motor_MV.get(1L),
                        GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Steel, 1L),
                        GT_Utility.getIntegratedCircuit(5)}, null, ItemList.Casing_Vent.get(2L), 50, 16);
        RA.addAssemblerRecipe(
                new ItemStack[]{CoreItems2.getRecipe(51, 3),
                        ItemList.Component_Filter.get(2L),
                        GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.BlackSteel, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.stick, Materials.StainlessSteel, 1L),
                        ItemList.Electric_Motor_HV.get(1L),
                        GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.VanadiumSteel, 1L),
                        GT_Utility.getIntegratedCircuit(5)}, null, ItemList.Casing_Vent.get(6L), 50, 16);
        RA.addAssemblerRecipe(
                new ItemStack[]{CoreItems2.getRecipe(51, 2),
                        ItemList.Component_Filter.get(1L),
                        GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.HSLA, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.stickLong, Materials.Titanium, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.ring, Materials.Titanium, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.gearGtSmall, Materials.Titanium, 1L),
                        ItemList.Electric_Motor_EV.get(1L),
                        GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Titanium, 1L),
                        GT_Utility.getIntegratedCircuit(5)}, null, ItemList.Casing_Vent.get(24L), 50, 16);
        RA.addAssemblerRecipe(
                new ItemStack[]{GT_ModHandler.getModItem("EnderIO", "blockDarkIronBars", 2L),
                        ItemList.Component_Filter.get(1L),
                        GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.HastelloyC276, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.stickLong, Materials.TungstenSteel, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.ring, Materials.TungstenSteel, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.gearGtSmall, Materials.TungstenSteel, 1L),
                        ItemList.Electric_Motor_IV.get(1L),
                        GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.MaragingSteel250, 1L),
                        GT_Utility.getIntegratedCircuit(5)}, null, ItemList.Casing_Vent.get(64L), 50, 16);
        // --- Bronze Firebox Casing
        RA.addAssemblerRecipe(
                new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Bronze, 4L),
                        GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Bronze, 4L),
                        GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Bronze, 1L),
                        GT_Utility.getIntegratedCircuit(10)}, null, ItemList.Casing_Firebox_Bronze.get(2L), 50, 16);
        // --- Steel Firebox Casing
        RA.addAssemblerRecipe(
                new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Steel, 4L),
                        GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Steel, 4L),
                        GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Steel, 1L),
                        GT_Utility.getIntegratedCircuit(10)}, null, ItemList.Casing_Firebox_Steel.get(2L), 50, 16);
        // --- Titanium Firebox Casing
        RA.addAssemblerRecipe(
                new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Titanium, 4L),
                        GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Titanium, 4L),
                        GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Titanium, 1L),
                        GT_Utility.getIntegratedCircuit(10)}, null, ItemList.Casing_Firebox_Titanium.get(2L), 50, 16);
        // --- TungstenSteel Firebox Casing
        RA.addAssemblerRecipe(
                new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.plate, Materials.TungstenSteel, 4L),
                        GT_OreDictUnificator.get(OrePrefixes.stick, Materials.TungstenSteel, 4L),
                        GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.TungstenSteel, 1L),
                        GT_Utility.getIntegratedCircuit(10)}, null, ItemList.Casing_Firebox_TungstenSteel.get(2L), 50, 16);
        // --- Engine Intake Casing
        RA.addAssemblerRecipe(
                new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.Titanium, 4L),
                        GT_OreDictUnificator.get(OrePrefixes.pipeMedium, Materials.Titanium, 2L),
                        ItemList.Casing_StableTitanium.get(1L),
                        GT_Utility.getIntegratedCircuit(1)}, null, ItemList.Casing_EngineIntake.get(2L), 50, 16);
        // --- Bronze Gear Box Casing
        RA.addAssemblerRecipe(
                new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Bronze, 4L),
                        GT_OreDictUnificator.get(OrePrefixes.gearGt, Materials.Bronze, 2L),
                        GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Bronze, 1L),
                        GT_Utility.getIntegratedCircuit(2)}, null, ItemList.Casing_Gearbox_Bronze.get(2L), 50, 16);
        // --- Steel Gear Box Casing
        RA.addAssemblerRecipe(
                new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Steel, 4L),
                        GT_OreDictUnificator.get(OrePrefixes.gearGt, Materials.Steel, 2L),
                        GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Steel, 1L),
                        GT_Utility.getIntegratedCircuit(2)}, null, ItemList.Casing_Gearbox_Steel.get(2L), 50, 16);

    }

    private void wireAssemblerRecipe() {
        RA.addWireAssemblerRecipe(new ItemStack[]{
                        GT_OreDictUnificator.get(OrePrefixes.wireGt02, Materials.SuperconductorIV, 64L),
                        GT_OreDictUnificator.get(OrePrefixes.foil, Materials.NiobiumTitanium, 64L)},
                Materials.Trinium.getMolten(5760L), ItemList.Casing_Coil_Superconductor.get(1L), 3000, 7680,
                true);
        RA.addWireAssemblerRecipe(new ItemStack[]{
                        GT_OreDictUnificator.get(OrePrefixes.wireGt02, Materials.SuperconductorLuV, 32L),
                        GT_OreDictUnificator.get(OrePrefixes.foil, Materials.NiobiumTitanium, 32L)},
                Materials.Trinium.getMolten(4320L), ItemList.Casing_Coil_Superconductor.get(1L), 2000,
                30720, true);
        RA.addWireAssemblerRecipe(new ItemStack[]{
                        GT_OreDictUnificator.get(OrePrefixes.wireGt02, Materials.SuperconductorZPM, 16L),
                        GT_OreDictUnificator.get(OrePrefixes.foil, Materials.NiobiumTitanium, 16L)},
                Materials.Trinium.getMolten(2880L), ItemList.Casing_Coil_Superconductor.get(1L), 1500,
                122880, true);
        RA.addWireAssemblerRecipe(new ItemStack[]{
                        GT_OreDictUnificator.get(OrePrefixes.wireGt02, Materials.SuperconductorUV, 8L),
                        GT_OreDictUnificator.get(OrePrefixes.foil, Materials.NiobiumTitanium, 8L)},
                Materials.Trinium.getMolten(1440L), ItemList.Casing_Coil_Superconductor.get(1L), 750,
                500000, true);
        RA.addWireAssemblerRecipe(new ItemStack[]{
                        GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.Superconductor, 8L),
                        GT_OreDictUnificator.get(OrePrefixes.foil, Materials.NiobiumTitanium, 4L)},
                Materials.Trinium.getMolten(720L), ItemList.Casing_Coil_Superconductor.get(1L), 375,
                2000000, true);
    }

    private void vacuumFreezer() {
        RA.addVacuumFreezerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Pentacadmiummagnesiumhexaoxid, 1L),
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Pentacadmiummagnesiumhexaoxid, 1L),
                400, 480);
        RA.addVacuumFreezerRecipe(GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Titaniumonabariumdecacoppereikosaoxid, 1L),
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Titaniumonabariumdecacoppereikosaoxid, 1L),
                500, 480);
        RA.addVacuumFreezerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Uraniumtriplatinid, 1L),
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Uraniumtriplatinid, 1L), 600, 480);
        RA.addVacuumFreezerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Vanadiumtriindinid, 1L),
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Vanadiumtriindinid, 1L), 600, 480);
        RA.addVacuumFreezerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Tetraindiumditindibariumtitaniumheptacoppertetrakaidekaoxid, 1L),
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Tetraindiumditindibariumtitaniumheptacoppertetrakaidekaoxid, 1L),
                600, 480);
        RA.addVacuumFreezerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Tetranaquadahdiindiumhexaplatiumosminid, 1L),
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Tetranaquadahdiindiumhexaplatiumosminid, 1L),
                720, 480);
        RA.addVacuumFreezerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Neutronium, 1L),
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Neutronium, 1L), 780, 30720);
        RA.addVacuumFreezerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Longasssuperconductornameforuvwire, 1L),
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Longasssuperconductornameforuvwire, 1L),
                500, 30720);
        RA.addVacuumFreezerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Longasssuperconductornameforuhvwire, 1L),
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Longasssuperconductornameforuhvwire, 1L),
                550, 122880);
        RA.addVacuumFreezerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Longasssuperconductornameforuevwire, 1L),
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Longasssuperconductornameforuevwire, 1L),
                600, 500000);
        RA.addVacuumFreezerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Diamericiumtitanium, 1L),
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Diamericiumtitanium, 1L), 480, 122880);
        RA.addVacuumFreezerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Naquadah, 1L),
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Naquadah, 1L), 420, 7860);
        RA.addVacuumFreezerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Europiumoxide, 1L),
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Europiumoxide, 1L), 420, 30720);
        RA.addVacuumFreezerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Tritanium, 1L),
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Tritanium, 1L), 736, 7860);
        RA.addVacuumFreezerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Americium, 1L),
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Americium, 1L), 592, 4092);
        RA.addVacuumFreezerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Platinum, 1L),
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Platinum, 1L), 466, 480);
        RA.addVacuumFreezerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Iridium, 1L),
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Iridium, 1L), 424, 1920);
        RA.addVacuumFreezerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Osmiridium, 1L),
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Osmiridium, 1L), 437, 1920);
        RA.addVacuumFreezerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Osmium, 1L),
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Osmium, 1L), 458, 1920);
        RA.addVacuumFreezerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Tungsten, 1L),
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Tungsten, 1L), 419, 1920);
        RA.addVacuumFreezerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Europium, 1L),
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Europium, 1L), 377, 1920);
        RA.addVacuumFreezerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.HSSS, 1L),
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.HSSS, 1L), 220, 1920);
        RA.addVacuumFreezerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Enderium, 1L),
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Enderium, 1L), 245, 480);
        RA.addVacuumFreezerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.TungstenSteel, 1L),
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.TungstenSteel, 1L), 231, 1920);
        RA.addVacuumFreezerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Palladium, 1L),
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Palladium, 1L), 216, 480);
        RA.addVacuumFreezerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.HSSG, 1L),
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.HSSG, 1L), 186, 480);
        RA.addVacuumFreezerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.NaquadahAlloy, 1L),
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.NaquadahAlloy, 1L), 220, 30720);
        RA.addVacuumFreezerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Naquadria, 1L),
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Naquadria, 1L), 197, 30720);
        RA.addVacuumFreezerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.NaquadahEnriched, 1L),
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.NaquadahEnriched, 1L), 188, 30720);
        RA.addVacuumFreezerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Adamantium, 1L),
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Adamantium, 1L), 173, 30720);
        RA.addVacuumFreezerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.ElectrumFlux, 1L),
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.ElectrumFlux, 1L), 168, 30720);
        RA.addVacuumFreezerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.TungstenCarbide, 1L),
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.TungstenCarbide, 1L), 215, 1920);
        RA.addVacuumFreezerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.HSSE, 1L),
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.HSSE, 1L), 194, 480);
        RA.addVacuumFreezerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.NiobiumTitanium, 1L),
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.NiobiumTitanium, 1L), 152, 4092);
        RA.addVacuumFreezerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Nichrome, 1L),
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Nichrome, 1L), 108, 480);
        RA.addVacuumFreezerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.VanadiumGallium, 1L),
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.VanadiumGallium, 1L), 109, 480);
        RA.addVacuumFreezerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.YttriumBariumCuprate, 1L),
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.YttriumBariumCuprate, 1L), 96, 1920);
        RA.addVacuumFreezerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Desh, 1L),
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Desh, 1L), 87, 1920);
        RA.addVacuumFreezerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Titanium, 1L),
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Titanium, 1L), 75, 480);
        RA.addVacuumFreezerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Draconium, 1L),
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Draconium, 1L), 213, 7860);
        RA.addVacuumFreezerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.DraconiumAwakened, 1L),
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.DraconiumAwakened, 1L), 224, 31440);
        RA.addVacuumFreezerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Infuscolium, 1L),
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Infuscolium, 1L), 398, 30720);
        RA.addVacuumFreezerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Quantium, 1L),
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Quantium, 1L), 280, 30720);
        RA.addVacuumFreezerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.BlackPlutonium, 1L),
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.BlackPlutonium, 1L), 300, 122880);
        RA.addVacuumFreezerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Adamantium, 1L),
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Adamantium, 1L), 490, 30720);
        RA.addVacuumFreezerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Trinium, 1L),
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Trinium, 1L), 294, 7860);
        RA.addVacuumFreezerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.BT6, 1L),
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.BT6, 1L), 164, 480);
        RA.addVacuumFreezerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.CosmicNeutronium, 1L),
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.CosmicNeutronium, 1L), 400, 122880);
        RA.addVacuumFreezerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.InfinityCatalyst, 1L),
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.InfinityCatalyst, 1L), 500, 500000);
        RA.addVacuumFreezerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Infinity, 1L),
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Infinity, 1L), 500, 2000000);
        RA.addVacuumFreezerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Oriharukon, 1L),
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Oriharukon, 1L), 386, 7680);
        RA.addVacuumFreezerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Mytryl, 1L),
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Mytryl, 1L), 324, 1920);

        RA.addVacuumFreezerRecipe(
                CoreItems2.getRecipe(70, 1),
                CoreItems2.getRecipe(69, 1), 300, 480);
        RA.addVacuumFreezerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Ledox, 1L),
                CoreItems2.getRecipe(71, 1), 300, 480);
        RA.addVacuumFreezerRecipe(
                CoreItems2.getRecipe(73, 1),
                CoreItems2.getRecipe(72, 1), 400, 1920);
        RA.addVacuumFreezerRecipe(
                new FluidStack(FluidRegistry.getFluid("ic2hotcoolant"), 1000),
                new FluidStack(FluidRegistry.getFluid("ic2coolant"), 1000), 300, 120);
    }

    private void sifter() {
        // --- Zircon
        RA.addSifterRecipe(
                GT_OreDictUnificator.get(OrePrefixes.crushedPurified, Materials.Cassiterite, 1L),
                new ItemStack[]{
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Cassiterite, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Cassiterite, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Cassiterite, 1L),
                        CoreItems.getRecipe(48, 1),
                        CoreItems.getRecipe(48, 1),
                        CoreItems.getRecipe(48, 1)},
                new int[]{6000, 3000, 1000, 5000, 3000, 1000}, 200, 16);

        RA.addSifterRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.RareEarth, 1L),
                        new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Neodymium, 1L),
                                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Yttrium, 1L),
                                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Lanthanum, 1L),
                                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Cerium, 1L),
                                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Cadmium, 1L),
                                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Caesium, 1L),
                                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Strontium, 1L),
                                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Samarium, 1L),
                                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Gadolinium, 1L)},
                        new int[]{600, 600, 600, 600, 600, 600, 400, 200, 100}, 600, 480);

    }

    private void printer3d() {
//Fusion Casing MK1
        RA.addBasicLineRecipe(new ItemStack[]{
                ItemList.Field_Generator_LuV.get(1L),
                GT_OreDictUnificator.get(OrePrefixes.pipeMedium, Materials.Superconductor, 4),
                GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.HastelloyN, 4),
                GT_ModHandler.getModItem("GraviSuite", "itemSimpleItem", 4, 1),
                CoreItems2.getRecipe(142, 4),
                GT_OreDictUnificator.get(OrePrefixes.plateQuadruple, Materials.TungstenSteel, 8),
                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Master, 8),
                ItemList.Casing_LuV.get(8L),
                GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Europium, 12),
                GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.HSSG, 16)
        }, ItemList.Casing_Fusion.get(8L), null, 50 * 20, 30720);
        RA.addBasicLineRecipe(new ItemStack[]{
                ItemList.Field_Generator_ZPM.get(1L),
                GT_OreDictUnificator.get(OrePrefixes.pipeMedium, Materials.Superconductor, 6),
                GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Lafium, 6),
                GT_ModHandler.getModItem("GraviSuite", "itemSimpleItem", 6, 1),
                CoreItems2.getRecipe(142, 6),
                GT_OreDictUnificator.get(OrePrefixes.plateQuadruple, Materials.HSSS, 8),
                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Ultimate, 8),
                ItemList.Casing_LuV.get(20L),
                GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Americium, 16),
                GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.HSSG, 32)
        }, ItemList.Casing_Fusion.get(20L), null, 100 * 20, 122880);
        RA.addBasicLineRecipe(new ItemStack[]{
                ItemList.Field_Generator_UV.get(1L),
                GT_OreDictUnificator.get(OrePrefixes.pipeMedium, Materials.Superconductor, 8),
                GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.CinobiteA243, 8),
                GT_ModHandler.getModItem("GraviSuite", "itemSimpleItem", 8, 1),
                CoreItems2.getRecipe(142, 8),
                GT_OreDictUnificator.get(OrePrefixes.plateQuadruple, Materials.Osmiridium, 8),
                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Superconductor, 8),
                ItemList.Casing_LuV.get(60L),
                GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Neutronium, 20),
                GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.HSSG, 64)
        }, ItemList.Casing_Fusion.get(60L), null, 200 * 20, 500000);

        //Fusion Casing MK2
        RA.addBasicLineRecipe(new ItemStack[]{
                ItemList.Field_Generator_ZPM.get(1L),
                GT_OreDictUnificator.get(OrePrefixes.pipeMedium, Materials.Superconductor, 4),
                GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Lafium, 4),
                GT_ModHandler.getModItem("GraviSuite", "itemSimpleItem", 4, 1),
                ItemList.Neutron_Reflector.get(4L),
                GT_OreDictUnificator.get(OrePrefixes.plateQuadruple, Materials.Osmiridium, 8),
                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Ultimate, 8),
                ItemList.Casing_Fusion.get(8L),
                GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Americium, 12),
                GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.HSSS, 16)
        }, ItemList.Casing_Fusion2.get(8L), null, 50 * 20, 122880);
        RA.addBasicLineRecipe(new ItemStack[]{
                ItemList.Field_Generator_UV.get(1L),
                GT_OreDictUnificator.get(OrePrefixes.pipeMedium, Materials.Superconductor, 6),
                GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.CinobiteA243, 6),
                GT_ModHandler.getModItem("GraviSuite", "itemSimpleItem", 6, 1),
                ItemList.Neutron_Reflector.get(6L),
                GT_OreDictUnificator.get(OrePrefixes.plateQuadruple, Materials.Duranium, 8),
                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Superconductor, 8),
                ItemList.Casing_Fusion.get(20L),
                GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Neutronium, 16),
                GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.HSSS, 32)
        }, ItemList.Casing_Fusion2.get(20L), null, 100 * 20, 500000);
        RA.addBasicLineRecipe(new ItemStack[]{
                ItemList.Field_Generator_UHV.get(1L),
                GT_OreDictUnificator.get(OrePrefixes.pipeMedium, Materials.Superconductor, 8),
                GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Pikyonium64B, 8),
                GT_ModHandler.getModItem("GraviSuite", "itemSimpleItem", 8, 1),
                ItemList.Neutron_Reflector.get(8L),
                GT_OreDictUnificator.get(OrePrefixes.plateQuadruple, Materials.ElectrumFlux, 8),
                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Infinite, 8),
                ItemList.Casing_Fusion.get(60L),
                GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Phoenixite, 20),
                GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.HSSS, 64)
        }, ItemList.Casing_Fusion2.get(60L), null, 200 * 20, 2000000);

        //Fusion Casing MK3
        RA.addBasicLineRecipe(new ItemStack[]{
                ItemList.Field_Generator_UV.get(1L),
                GT_OreDictUnificator.get(OrePrefixes.pipeMedium, Materials.Superconductor, 4),
                GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.CinobiteA243, 4),
                GT_ModHandler.getModItem("GraviSuite", "itemSimpleItem", 4, 1),
                ItemList.Neutron_Reflector.get(8L),
                GT_OreDictUnificator.get(OrePrefixes.plateQuadruple, Materials.Duranium, 8),
                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Superconductor, 8),
                ItemList.Casing_Fusion2.get(8L),
                GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Neutronium, 12),
                GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Adamantium, 16)
        }, ItemList.Casing_Fusion3.get(8L), null, 50 * 20, 500000);
        RA.addBasicLineRecipe(new ItemStack[]{
                ItemList.Field_Generator_UHV.get(1L),
                GT_OreDictUnificator.get(OrePrefixes.pipeMedium, Materials.Superconductor, 6),
                GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Pikyonium64B, 6),
                GT_ModHandler.getModItem("GraviSuite", "itemSimpleItem", 6, 1),
                ItemList.Neutron_Reflector.get(10L),
                GT_OreDictUnificator.get(OrePrefixes.plateQuadruple, Materials.ElectrumFlux, 8),
                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Infinite, 8),
                ItemList.Casing_Fusion2.get(20L),
                GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Phoenixite, 16),
                GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Adamantium, 32)
        }, ItemList.Casing_Fusion3.get(20L), null, 100 * 20, 2000000);
        RA.addBasicLineRecipe(new ItemStack[]{
                ItemList.Field_Generator_UEV.get(1L),
                GT_OreDictUnificator.get(OrePrefixes.pipeMedium, Materials.Superconductor, 8),
                GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Quantum, 8),
                GT_ModHandler.getModItem("GraviSuite", "itemSimpleItem", 8, 1),
                GT_OreDictUnificator.get(OrePrefixes.plateDense, Materials.Neutronium, 4),
                GT_OreDictUnificator.get(OrePrefixes.plateQuadruple, Materials.BlackPlutonium, 8),
                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Bio, 8),
                ItemList.Casing_Fusion2.get(60L),
                GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.CosmicNeutronium, 20),
                GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Adamantium, 64)
        }, ItemList.Casing_Fusion3.get(60L), null, 200 * 20, 8000000);

        //Fusion Casing MK4
        RA.addBasicLineRecipe(new ItemStack[]{
                ItemList.Field_Generator_UHV.get(1L),
                GT_OreDictUnificator.get(OrePrefixes.pipeMedium, Materials.Superconductor, 4),
                GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Pikyonium64B, 4),
                GT_ModHandler.getModItem("GraviSuite", "itemSimpleItem", 4, 1),
                GT_OreDictUnificator.get(OrePrefixes.plateDense, Materials.Neutronium, 4),
                GT_OreDictUnificator.get(OrePrefixes.plateQuadruple, Materials.Quantium, 8),
                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Infinite, 8),
                ItemList.Casing_Fusion3.get(8L),
                GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Phoenixite, 12),
                GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.DraconiumAwakened, 16)
        }, ItemList.Casing_Fusion4.get(8L), null, 50 * 20, 2000000);
        RA.addBasicLineRecipe(new ItemStack[]{
                ItemList.Field_Generator_UEV.get(1L),
                GT_OreDictUnificator.get(OrePrefixes.pipeMedium, Materials.Superconductor, 6),
                GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Quantum, 6),
                GT_ModHandler.getModItem("GraviSuite", "itemSimpleItem", 6, 1),
                GT_OreDictUnificator.get(OrePrefixes.plateDense, Materials.Neutronium, 6),
                GT_OreDictUnificator.get(OrePrefixes.plateQuadruple, Materials.BlackPlutonium, 8),
                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Bio, 8),
                ItemList.Casing_Fusion3.get(20L),
                GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.CosmicNeutronium, 16),
                GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.DraconiumAwakened, 32)
        }, ItemList.Casing_Fusion4.get(20L), null, 100 * 20, 8000000);

        //Steam Turbine
        RA.addPrimitiveLineRecipe(new ItemStack[]{
                ItemList.Hull_HV.get(1L),
                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Advanced, 2),
                GT_OreDictUnificator.get(OrePrefixes.pipeLarge, Materials.Steel, 2),
                GT_OreDictUnificator.get(OrePrefixes.gearGt, Materials.Steel, 4),
                GT_OreDictUnificator.get(OrePrefixes.ring, Materials.Steel, 4),
                GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Steel, 12)
        }, ItemList.LargeSteamTurbine.get(1L), null, 20 * 20, 120);

        //Gas Turbine
        RA.addPrimitiveLineRecipe(new ItemStack[]{
                ItemList.Hull_EV.get(1L), GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Data, 2),
                GT_OreDictUnificator.get(OrePrefixes.pipeLarge, Materials.StainlessSteel, 2),
                GT_OreDictUnificator.get(OrePrefixes.gearGt, Materials.StainlessSteel, 4),
                GT_OreDictUnificator.get(OrePrefixes.ring, Materials.StainlessSteel, 4),
                GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.StainlessSteel, 12)
        }, ItemList.LargeGasTurbine.get(1L), null, 40 * 20, 480);

        //HP Turbine
        RA.addPrimitiveLineRecipe(new ItemStack[]{
                ItemList.Hull_EV.get(1L), GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Data, 4),
                GT_OreDictUnificator.get(OrePrefixes.gearGt, Materials.Titanium, 4),
                GT_OreDictUnificator.get(OrePrefixes.ring, Materials.Titanium, 4),
                GT_OreDictUnificator.get(OrePrefixes.pipeLarge, Materials.Titanium, 4),
                GT_OreDictUnificator.get(OrePrefixes.stickLong, Materials.HSLA, 6),
                GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Titanium, 12)
        }, ItemList.LargeHPSteamTurbine.get(1L), null, 60 * 20, 1920);

        //Plasma Turbine
        RA.addBasicLineRecipe(new ItemStack[]{
                ItemList.Hull_UV.get(1L),
                ItemList.Casing_Coil_Superconductor.get(4L),
                ItemList.Electric_Pump_UV.get(4L),
                GT_OreDictUnificator.get(OrePrefixes.gearGt, Materials.NaquadahAlloy, 4),
                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Superconductor, 8),
                GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Draconium, 8),
                GT_OreDictUnificator.get(OrePrefixes.pipeHuge, Materials.Naquadah, 8),
                GT_OreDictUnificator.get(OrePrefixes.stickLong, Materials.NaquadahAlloy, 8),
                GT_OreDictUnificator.get(OrePrefixes.ring, Materials.Oriharukon, 8),
                GT_OreDictUnificator.get(OrePrefixes.round, Materials.NaquadahAlloy, 16),
                GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Americium, 16),
                GT_OreDictUnificator.get(OrePrefixes.plateTriple, Materials.Pikyonium64B, 16)
        }, ItemList.LargePlasmaTurbine.get(1L), null, 100 * 20, 500000);

        //Heat Exchanger
        RA.addPrimitiveLineRecipe(new ItemStack[]{
                ItemList.Hull_EV.get(1L), ItemList.Casing_Firebox_Titanium.get(1L),
                ItemList.Electric_Pump_EV.get(2L),
                GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Titanium, 2),
                GT_OreDictUnificator.get(OrePrefixes.pipeMedium, Materials.Titanium, 4),
                GT_OreDictUnificator.get(OrePrefixes.ring, Materials.Titanium, 4),
                GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Titanium, 8)
        }, ItemList.Machine_Multi_HeatExchanger.get(1L), null, 40 * 20, 480);

        //OilDrill2
        RA.addPrimitiveLineRecipe(new ItemStack[]{
                ItemList.Hull_HV.get(1L), ItemList.Electric_Motor_HV.get(2L),
                ItemList.Electric_Pump_HV.get(2L),
                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Advanced, 2),
                GT_OreDictUnificator.get(OrePrefixes.gearGt, Materials.Titanium, 2),
                GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Titanium, 4),
                GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Titanium, 10)
        }, ItemList.OilDrill2.get(1L), null, 40 * 20, 480);

        //OilDrill3
        RA.addBasicLineRecipe(new ItemStack[]{
                ItemList.Hull_EV.get(1L), ItemList.Electric_Motor_EV.get(2L),
                ItemList.Electric_Pump_EV.get(2L),
                GT_OreDictUnificator.get(OrePrefixes.gearGt, Materials.TungstenSteel, 4),
                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Data, 8),
                GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.TungstenSteel, 12),
                GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.TungstenSteel, 16)
        }, ItemList.OilDrill3.get(1L), null, 60 * 20, 1920);

        //Oil Cracker
        RA.addPrimitiveLineRecipe(new ItemStack[]{
                ItemList.Hull_HV.get(1L),
                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Advanced, 4),
                ItemList.Casing_Coil_Cupronickel.get(4L),
                ItemList.Electric_Pump_HV.get(4L),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.StainlessSteel, 8)
        }, ItemList.OilCracker.get(1L), null, 20 * 20, 120);

        //Assembly Line
        RA.addBasicLineRecipe(new ItemStack[]{
                ItemList.Machine_IV_Assembler.get(1L),
                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Elite, 4),
                ItemList.Casing_Gearbox_TungstenSteel.get(4L),
                GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Inconel792, 4),
                ItemList.Conveyor_Module_IV.get(4L), ItemList.Robot_Arm_IV.get(4L),
                GT_OreDictUnificator.get(OrePrefixes.stickLong, Materials.Inconel792, 8),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.TungstenSteel, 16),
                GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.HSSE, 16),
                GT_OreDictUnificator.get(OrePrefixes.screw, Materials.HSSE, 16)
        }, ItemList.Machine_Multi_Assemblyline.get(1L), null, 120 * 20, 7680);

        //DieselGen1
        RA.addPrimitiveLineRecipe(new ItemStack[]{
                ItemList.Hull_EV.get(1L), GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Data, 2),
                GT_OreDictUnificator.get(OrePrefixes.gearGt, Materials.Titanium, 2),
                ItemList.Electric_Piston_EV.get(2L), ItemList.Electric_Motor_EV.get(2L),
                GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Titanium, 4),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Titanium, 8)
        }, ItemList.Machine_Multi_DieselEngine.get(1L), null, 40 * 20, 1920);

        //DieselGen2
        RA.addPrimitiveLineRecipe(new ItemStack[]{
                ItemList.Hull_IV.get(1L), GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Elite, 2),
                GT_OreDictUnificator.get(OrePrefixes.gearGt, Materials.TungstenSteel, 2),
                ItemList.Electric_Piston_IV.get(2L), ItemList.Electric_Motor_IV.get(2L),
                GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.TungstenSteel, 4),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.TungstenSteel, 8)
        }, ItemList.Machine_Multi_DieselEngine2.get(1L), null, 80 * 20, 7680);

        //LCR
        RA.addPrimitiveLineRecipe(new ItemStack[]{
                ItemList.Hull_HV.get(1L), ItemList.Electric_Pump_HV.get(2L),
                ItemList.Electric_Motor_HV.get(2L),
                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Advanced, 2),
                GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.StainlessSteel, 2),
                GT_OreDictUnificator.get(OrePrefixes.pipeLarge, Materials.Polytetrafluoroethylene, 2),
                GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.StainlessSteel, 4),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.StainlessSteel, 6)
        }, ItemList.Machine_Multi_LargeChemicalReactor.get(1L), null, 20 * 20, 120);

        //Implosion Compressor
        RA.addPrimitiveLineRecipe(new ItemStack[]{
                ItemList.Hull_HV.get(1L), ItemList.Electric_Piston_HV.get(2L),
                GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Steel, 2),
                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Advanced, 4),
                GT_OreDictUnificator.get(OrePrefixes.plateDense, Materials.Steel, 8),
                ItemList.Casing_ExplosionHazard.get(1L)
        }, ItemList.Machine_Multi_ImplosionCompressor.get(1L), null, 30 * 20, 250);

        //Vacuum Freezer
        RA.addPrimitiveLineRecipe(new ItemStack[]{
                ItemList.Hull_HV.get(1L), ItemList.Electric_Pump_HV.get(2L),
                GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Aluminium, 2),
                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Data, 4),
                GT_OreDictUnificator.get(OrePrefixes.plateDense, Materials.Aluminium, 8),
                ItemList.Casing_FrostHazard.get(1L)
        }, ItemList.Machine_Multi_VacuumFreezer.get(1L), null, 30 * 20, 250);

        //Titanium
        RA.addPrimitiveLineRecipe(new ItemStack[]{
                ItemList.Hull_EV.get(1L), ItemList.Casing_Firebox_Titanium.get(1L),
                GT_OreDictUnificator.get(OrePrefixes.pipeLarge, Materials.Titanium, 3),
                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Data, 4),
                GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Titanium, 4),
                GT_OreDictUnificator.get(OrePrefixes.stickLong, Materials.Titanium, 12)
        }, ItemList.Machine_Multi_LargeBoiler_Titanium.get(1L), null, 40 * 20, 480);

        //TungstenSteel
        RA.addPrimitiveLineRecipe(new ItemStack[]{
                ItemList.Hull_IV.get(1L), ItemList.Casing_Firebox_TungstenSteel.get(1L),
                GT_OreDictUnificator.get(OrePrefixes.pipeLarge, Materials.TungstenSteel, 3),
                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Elite, 4),
                GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.TungstenSteel, 4),
                GT_OreDictUnificator.get(OrePrefixes.stickLong, Materials.TungstenSteel, 12)
        }, ItemList.Machine_Multi_LargeBoiler_TungstenSteel.get(1L), null, 60 * 20, 1920);

        //Distillation_Tower
        RA.addPrimitiveLineRecipe(new ItemStack[]{
                ItemList.Hull_EV.get(1L), ItemList.Electric_Pump_EV.get(4L),
                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Data, 4),
                GT_OreDictUnificator.get(OrePrefixes.pipeMedium, Materials.StainlessSteel, 8),
                GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.StainlessSteel, 12)
        }, ItemList.Distillation_Tower.get(1L), null, 40 * 20, 480);

        //Centrifuge
        RA.addPrimitiveLineRecipe(new ItemStack[]{
                ItemList.Machine_EV_Centrifuge.get(1L), ItemList.Electric_Motor_EV.get(4L),
                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Data, 4),
                GT_OreDictUnificator.get(OrePrefixes.gearGt, Materials.Titanium, 4),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Titanium, 8)
        }, ItemList.Machine_MultiblockCentrifuge.get(1L), null, 40 * 20, 480);

        //Electrolyzer
        RA.addPrimitiveLineRecipe(new ItemStack[]{
                ItemList.Machine_EV_Electrolyzer.get(1L),
                GT_OreDictUnificator.get(OrePrefixes.wireGt04, Materials.Aluminium, 4),
                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Data, 4),
                GT_OreDictUnificator.get(OrePrefixes.stickLong, Materials.Tungsten, 4),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Titanium, 8)
        }, ItemList.Machine_MultiblockElectrolyzer.get(1L), null, 40 * 20, 480);

        //Flotation Unit
        RA.addPrimitiveLineRecipe(new ItemStack[]{
                ItemList.Hull_EV.get(1L), ItemList.Electric_Pump_EV.get(4L),
                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Data, 6),
                GT_OreDictUnificator.get(OrePrefixes.pipeMedium, Materials.Titanium, 8),
                GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Titanium, 12)
        }, ItemList.Machine_FlotationUnit.get(1L), null, 40 * 20, 480);

        //Solar Panel LV 32 EU
        RA.addPrimitiveLineRecipe(new ItemStack[]{
                GT_OreDictUnificator.get(OrePrefixes.plateAlloy, Materials.Carbon, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Polytetrafluoroethylene, 2),
                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Good, 4),
                ItemList.Circuit_Silicon_Wafer2.get(4L), CoreItems2.getRecipe(117, 4),
                GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.SuperconductorMV, 4)
        }, ItemList.Cover_SolarPanel_LV.get(1L), null, 20 * 20, 120);

        //Solar Panel MV 128 EU
        RA.addPrimitiveLineRecipe(new ItemStack[]{
                ItemList.Cover_SolarPanel_LV.get(1L),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Epoxid, 2),
                ItemList.Circuit_Chip_ULPIC.get(2L),
                GT_OreDictUnificator.get(OrePrefixes.plateAlloy, Materials.Carbon, 2),
                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Advanced, 4),
                ItemList.Circuit_Silicon_Wafer2.get(4L),
                CoreItems2.getRecipe(118, 4),
                GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.SuperconductorHV, 4)
        }, ItemList.Cover_SolarPanel_MV.get(1L), null, 40 * 20, 480);

        //Solar Panel HV 512 EU
        RA.addPrimitiveLineRecipe(new ItemStack[]{
                ItemList.Cover_SolarPanel_MV.get(1L),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.IndiumGalliumPhosphide, 2),
                ItemList.Circuit_Chip_LPIC.get(2L),
                GT_OreDictUnificator.get(OrePrefixes.plateAlloy, Materials.Carbon, 4),
                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Data, 6),
                ItemList.Circuit_Silicon_Wafer2.get(4L),
                CoreItems2.getRecipe(119, 4),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Silicon, 4),
                GT_OreDictUnificator.get(OrePrefixes.wireGt02, Materials.SuperconductorEV, 6)
        }, ItemList.Cover_SolarPanel_HV.get(1L), null, 60 * 20, 1920);

        //Solar Panel EV 2048 EU
        RA.addBasicLineRecipe(new ItemStack[]{
                ItemList.Cover_SolarPanel_HV.get(1L),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Polybenzimidazole, 4),
                ItemList.Circuit_Chip_PIC.get(4L),
                GT_OreDictUnificator.get(OrePrefixes.plateAlloy, Materials.Carbon, 6),
                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Elite, 6),
                ItemList.Circuit_Silicon_Wafer4.get(4L), CoreItems2.getRecipe(120, 4),
                GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Silicon, 4),
                GT_OreDictUnificator.get(OrePrefixes.wireGt02, Materials.SuperconductorIV, 6)
        }, ItemList.Cover_SolarPanel_EV.get(1L), null, 80 * 20, 7680);
        RA.addPrimitiveLineRecipe(new ItemStack[]{
                ItemList.Cover_SolarPanel_HV.get(4L),
                GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.IndiumGalliumPhosphide, 4),
                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Elite, 4),
                CoreItems2.getRecipe(112, 2),
                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Silicon, 16)
        }, ItemList.Cover_SolarPanel_EV.get(1L), null, 10 * 20, 480);

        //Solar Panel IV 8192 EU
        RA.addBasicLineRecipe(new ItemStack[]{
                ItemList.Cover_SolarPanel_EV.get(1L),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Polybenzimidazole, 6),
                ItemList.Circuit_Chip_HPIC.get(4L),
                GT_OreDictUnificator.get(OrePrefixes.plateAlloy, Materials.Carbon, 8),
                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Master, 8),
                ItemList.Circuit_Silicon_Wafer3.get(6L), CoreItems2.getRecipe(121, 4),
                GT_OreDictUnificator.get(OrePrefixes.plateTriple, Materials.Silicon, 6),
                GT_OreDictUnificator.get(OrePrefixes.wireGt04, Materials.SuperconductorLuV, 8)
        }, ItemList.Cover_SolarPanel_IV.get(1L), null, 100 * 20, 30720);
        RA.addPrimitiveLineRecipe(new ItemStack[]{
                ItemList.Cover_SolarPanel_EV.get(4L),
                GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Polybenzimidazole, 4),
                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Master, 4),
                CoreItems2.getRecipe(113, 2),
                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Silicon, 24)
        }, ItemList.Cover_SolarPanel_IV.get(1L), null, 20 * 20, 1920);

        //Solar Panel LuV 32768 EU
        RA.addBasicLineRecipe(new ItemStack[]{
                ItemList.Cover_SolarPanel_IV.get(1L),
                GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Polybenzimidazole, 8),
                ItemList.Circuit_Chip_UHPIC.get(6L),
                GT_OreDictUnificator.get(OrePrefixes.plateAlloy, Materials.Carbon, 10),
                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Ultimate, 8),
                ItemList.Circuit_Silicon_Wafer7.get(8L), CoreItems2.getRecipe(122, 6),
                GT_OreDictUnificator.get(OrePrefixes.plateQuadruple, Materials.Silicon, 6),
                GT_OreDictUnificator.get(OrePrefixes.wireGt04, Materials.SuperconductorZPM, 8)
        }, ItemList.Cover_SolarPanel_LuV.get(1L), null, 120 * 20, 122880);
        RA.addPrimitiveLineRecipe(new ItemStack[]{
                ItemList.Cover_SolarPanel_IV.get(4L),
                GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.VanadiumGallium, 4),
                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Ultimate, 6),
                CoreItems2.getRecipe(114, 4),
                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Silicon, 32)
        }, ItemList.Cover_SolarPanel_LuV.get(1L), null, 30 * 20, 7680);

        //Solar Panel ZPM 131072 EU
        RA.addBasicLineRecipe(new ItemStack[]{
                ItemList.Cover_SolarPanel_LuV.get(1L),
                GT_OreDictUnificator.get(OrePrefixes.plateTriple, Materials.Polybenzimidazole, 10),
                ItemList.Circuit_Chip_QPIC.get(8L),
                GT_OreDictUnificator.get(OrePrefixes.plateAlloy, Materials.Carbon, 12),
                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Superconductor, 10),
                ItemList.Circuit_Silicon_Wafer8.get(10L), CoreItems2.getRecipe(123, 6),
                GT_OreDictUnificator.get(OrePrefixes.plateQuintuple, Materials.Silicon, 8),
                GT_OreDictUnificator.get(OrePrefixes.wireGt08, Materials.SuperconductorUV, 10)
        }, ItemList.Cover_SolarPanel_ZPM.get(1L), null, 140 * 20, 500000);
        RA.addPrimitiveLineRecipe(new ItemStack[]{
                ItemList.Cover_SolarPanel_LuV.get(4L),
                GT_OreDictUnificator.get(OrePrefixes.plateTriple, Materials.NaquadahAlloy, 4),
                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Superconductor, 6),
                CoreItems2.getRecipe(115, 4),
                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Silicon, 48)
        }, ItemList.Cover_SolarPanel_ZPM.get(1L), null, 40 * 20, 30720);

        //Solar Panel UV 524288 EU
        RA.addBasicLineRecipe(new ItemStack[]{
                ItemList.Cover_SolarPanel_ZPM.get(1L),
                GT_OreDictUnificator.get(OrePrefixes.plateQuadruple, Materials.Polybenzimidazole, 12),
                ItemList.Circuit_Chip_FPIC.get(10L),
                GT_OreDictUnificator.get(OrePrefixes.plateAlloy, Materials.Carbon, 14),
                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Infinite, 10),
                ItemList.Circuit_Silicon_Wafer10.get(12L), CoreItems2.getRecipe(124, 8),
                GT_OreDictUnificator.get(OrePrefixes.plateDense, Materials.Silicon, 8),
                GT_OreDictUnificator.get(OrePrefixes.wireGt12, Materials.Superconductor, 12)
        }, ItemList.Cover_SolarPanel_UV.get(1L), null, 160 * 20, 2000000);
        RA.addPrimitiveLineRecipe(new ItemStack[]{
                ItemList.Cover_SolarPanel_ZPM.get(4L),
                GT_OreDictUnificator.get(OrePrefixes.plateTriple, Materials.ElectrumFlux, 4),
                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Infinite, 8),
                CoreItems2.getRecipe(116, 4),
                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Silicon, 64)
        }, ItemList.Cover_SolarPanel_UV.get(1L), null, 50 * 20, 122880);
    }

    private void mixer() {
        RA.addMixerRecipe(CoreItems.getRecipe(2, 1), CoreItems.getRecipe(10, 1),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Ledox, 1L), GT_Values.NI,
                new FluidStack(FluidRegistry.getFluid("ic2coolant"), 3000),
                Materials.SuperCoolant.getFluid(3000),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Ice, 3L), 300, 480);
        RA.addMixerRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Sodium, 2L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Potassium, 3L),
                GT_Utility.getIntegratedCircuit(2), GT_Values.NI, GT_Values.NF,
                Materials.SodiumPotassium.getFluid(1000), GT_Values.NI, 400, 30);

        RA.addMixerRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Clay, 3L),
                CoreItems.getRecipe(37, 1), GT_Utility.getIntegratedCircuit(1), GT_Values.NI, GT_Values.NF,
                GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Fireclay, 4L), 200, 8);

        RA.addMixerRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Stone, 2L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Gypsum, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Calcite, 1L),
                GT_Utility.getIntegratedCircuit(2), Materials.Water.getFluid(1000L),
                Materials.Concrete.getMolten(1152L), GT_Values.NI, 40, 16);
        RA.addMixerRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Stone, 2L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Gypsum, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Marble, 1L),
                GT_Utility.getIntegratedCircuit(2), Materials.Water.getFluid(1000L),
                Materials.Concrete.getMolten(1152L), GT_Values.NI, 40, 16);
        RA.addMixerRecipe(CoreItems.getRecipe(37, 4), GT_Utility.getIntegratedCircuit(1),
                GT_Values.NI, GT_Values.NI, Materials.Water.getFluid(1000L),
                Materials.Concrete.getMolten(1152L), GT_Values.NI, 40, 16);

        RA.addMixerRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Naquadah, 2L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Osmiridium, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Trinium, 1L), GT_Values.NI,
                GT_Values.NI, GT_Utility.getIntegratedCircuit(2), GT_Values.NF, GT_Values.NF,
                GT_OreDictUnificator
                        .getDust(Materials.NaquadahAlloy, 4L * OrePrefixes.dust.mMaterialAmount),
                (int) (400L * OrePrefixes.dust.mMaterialAmount / 3628800L), 8000);

        RA.addMixerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.cell, Materials.NitricAcid, 1L), GT_Values.NI,
                GT_Values.NI, GT_Values.NI,
                Materials.SulfuricAcid.getFluid(1000L),
                Materials.NitrationMixture.getFluid(2000),
                GT_OreDictUnificator.get(OrePrefixes.cell, Materials.Empty, 1L),
                24 * 20, 2
        );
    }

    private void fusion() {
        RA.addFusionReactorRecipe(Materials.Tartarite.getFluid(16), Materials.Europium.getMolten(16),
                Materials.DraconiumPlasma.getFluid(16), 32, 30000, 300000000);
        RA.addFusionReactorRecipe(Materials.EnrichedTartarite.getFluid(16),
                Materials.Neutronium.getMolten(16), Materials.DraconiumAwakenedPlasma.getFluid(16), 64,
                250000, 1000000000);
        RA.addFusionReactorRecipe(Materials.InfinityCatalyst.getMolten(16),
                Materials.Phoenixite.getMolten(16), Materials.Neutronium.getPlasma(16), 64,
                500000, 2000000000);
    }

    private void freezSolidifier() {
        RA.addFreezerSolidifierRecipe(ItemList.Shape_Mold_Ingot.get(0L),
                FluidRegistry.getFluidStack("ic2coolant", 125), Materials.HastelloyC276.getMoltenHot(144L),
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.HastelloyC276, 1L), 10 * 20, 1920);
        RA.addFreezerSolidifierRecipe(ItemList.Shape_Mold_Ingot.get(0L),
                FluidRegistry.getFluidStack("ic2coolant", 125), Materials.GumMetal.getMoltenHot(144L),
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.GumMetal, 1L), 12 * 20, 1920);
        RA.addFreezerSolidifierRecipe(ItemList.Shape_Mold_Ingot.get(0L),
                FluidRegistry.getFluidStack("ic2coolant", 125), Materials.Titaniolum.getMoltenHot(144L),
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Titaniolum, 1L), 14 * 20, 1920);
        RA.addFreezerSolidifierRecipe(ItemList.Shape_Mold_Ingot.get(0L),
                FluidRegistry.getFluidStack("ic2coolant", 125), Materials.Zamak.getMoltenHot(144L),
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Zamak, 1L), 16 * 20, 1920);
        RA.addFreezerSolidifierRecipe(ItemList.Shape_Mold_Ingot.get(0L),
                FluidRegistry.getFluidStack("ic2coolant", 125), Materials.Duraluminium.getMoltenHot(144L),
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Duraluminium, 1L), 18 * 20, 1920);
        RA.addFreezerSolidifierRecipe(ItemList.Shape_Mold_Ingot.get(0L),
                FluidRegistry.getFluidStack("ic2coolant", 125), Materials.Inconel690.getMoltenHot(144L),
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Inconel690, 1L), 19 * 20, 1920);
        RA.addFreezerSolidifierRecipe(ItemList.Shape_Mold_Ingot.get(0L),
                FluidRegistry.getFluidStack("ic2coolant", 125), Materials.Nitinol.getMoltenHot(144L),
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Nitinol, 1L), 20 * 20, 1920);
        RA.addFreezerSolidifierRecipe(ItemList.Shape_Mold_Ingot.get(0L),
                FluidRegistry.getFluidStack("ic2coolant", 125), Materials.Inconel792.getMoltenHot(144L),
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Inconel792, 1L), 22 * 20, 1920);
        RA.addFreezerSolidifierRecipe(ItemList.Shape_Mold_Ingot.get(0L),
                FluidRegistry.getFluidStack("ic2coolant", 125), Materials.TiBetaC.getMoltenHot(144L),
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.TiBetaC, 1L), 24 * 20, 1920);
        RA.addFreezerSolidifierRecipe(ItemList.Shape_Mold_Ingot.get(0L),
                FluidRegistry.getFluidStack("ic2coolant", 125),
                Materials.MaragingSteel250.getMoltenHot(144L),
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.MaragingSteel250, 1L), 27 * 20, 1920);
        RA.addFreezerSolidifierRecipe(ItemList.Shape_Mold_Ingot.get(0L),
                FluidRegistry.getFluidStack("ic2coolant", 125), Materials.Talonite.getMoltenHot(144L),
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Talonite, 1L), 28 * 20, 1920);
        RA.addFreezerSolidifierRecipe(ItemList.Shape_Mold_Ingot.get(0L),
                FluidRegistry.getFluidStack("ic2coolant", 125), Materials.Grisium.getMoltenHot(144L),
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Grisium, 1L), 26 * 20, 1920);
        RA.addFreezerSolidifierRecipe(ItemList.Shape_Mold_Ingot.get(0L),
                FluidRegistry.getFluidStack("ic2coolant", 125), Materials.Nitinol60.getMoltenHot(144L),
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Nitinol60, 1L), 27 * 20, 1920);
        RA.addFreezerSolidifierRecipe(ItemList.Shape_Mold_Ingot.get(0L),
                FluidRegistry.getFluidStack("ic2coolant", 125), Materials.Kovar.getMoltenHot(144L),
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Kovar, 1L), 17 * 20, 1920);
        RA.addFreezerSolidifierRecipe(ItemList.Shape_Mold_Ingot.get(0L),
                FluidRegistry.getFluidStack("ic2coolant", 125), Materials.Mangalloy.getMoltenHot(144L),
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Mangalloy, 1L), 15 * 20, 1920);
        RA.addFreezerSolidifierRecipe(ItemList.Shape_Mold_Ingot.get(0L),
                FluidRegistry.getFluidStack("ic2coolant", 125),
                Materials.MaragingSteel300.getMoltenHot(144L),
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.MaragingSteel300, 1L), 24 * 20, 1920);
        RA.addFreezerSolidifierRecipe(ItemList.Shape_Mold_Ingot.get(0L),
                FluidRegistry.getFluidStack("ic2coolant", 125), Materials.Stellite.getMoltenHot(144L),
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Stellite, 1L), 10 * 20, 1920);
        RA.addFreezerSolidifierRecipe(ItemList.Shape_Mold_Ingot.get(0L),
                FluidRegistry.getFluidStack("ic2coolant", 125), Materials.Zeron100.getMoltenHot(144L),
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Zeron100, 1L), 20 * 20, 1920);
        RA.addFreezerSolidifierRecipe(ItemList.Shape_Mold_Ingot.get(0L),
                FluidRegistry.getFluidStack("ic2coolant", 125), Materials.CinobiteA243.getMoltenHot(144L),
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.CinobiteA243, 1L), 30 * 20, 30720);
        RA.addFreezerSolidifierRecipe(ItemList.Shape_Mold_Ingot.get(0L),
                FluidRegistry.getFluidStack("ic2coolant", 125), Materials.HastelloyN.getMoltenHot(144L),
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.HastelloyN, 1L), 26 * 20, 7680);
        RA.addFreezerSolidifierRecipe(ItemList.Shape_Mold_Ingot.get(0L),
                FluidRegistry.getFluidStack("ic2coolant", 125), Materials.Lafium.getMoltenHot(144L),
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Lafium, 1L), 26 * 20, 122880);
        RA.addFreezerSolidifierRecipe(ItemList.Shape_Mold_Ingot.get(0L),
                FluidRegistry.getFluidStack("ic2coolant", 125), Materials.BT6.getMoltenHot(144L),
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.BT6, 1L), 10 * 20, 1920);
        RA.addFreezerSolidifierRecipe(ItemList.Shape_Mold_Ingot.get(0L),
                FluidRegistry.getFluidStack("ic2coolant", 125), Materials.Pikyonium64B.getMoltenHot(144L),
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Pikyonium64B, 1L), 40 * 20, 500000);
        RA.addFreezerSolidifierRecipe(ItemList.Shape_Mold_Ingot.get(0L),
                FluidRegistry.getFluidStack("ic2coolant", 125), Materials.Quantum.getMoltenHot(144L),
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Quantum, 1L), 50 * 20, 2000000);

    }

    private void fluidSolidifier() {
        RA.addFluidSolidifierRecipe(ItemList.Shape_Mold_Ball.get(0L),
                Materials.Sunnarium.getMolten(144L), CoreItems2.getRecipe(125, 1), 200, 1920);
        RA.addFluidSolidifierRecipe(ItemList.Shape_Mold_Ingot.get(0L),
                Materials.DraconiumPlasma.getFluid(144L),
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Draconium, 1L), 200, 7680);
        RA.addFluidSolidifierRecipe(ItemList.Shape_Mold_Ingot.get(0L),
                Materials.DraconiumAwakenedPlasma.getFluid(144L),
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.DraconiumAwakened, 1L), 400,
                500000);
        RA.addFluidSolidifierRecipe(GT_ModHandler.getModItem("minecraft", "glass", 1L, 0),
                Materials.BorosilicateGlass.getMolten(144L), Blockstack(IGlassBlock, 1, 0), 200, 2);
    }

    private void fluidCanner() {
        RA.addFluidCannerRecipe(CoreItems2.getRecipe(Empty180SpCell.getMetaID(), 1),
                ItemList.Reactor_Coolant_Le_1.get(1L), Materials.SuperCoolant.getFluid(1000L),
                GT_Values.NF);
        RA.addFluidCannerRecipe(CoreItems2.getRecipe(Empty360SpCell.getMetaID(), 1),
                ItemList.Reactor_Coolant_Le_2.get(1L), Materials.SuperCoolant.getFluid(2000L),
                GT_Values.NF);
        RA.addFluidCannerRecipe(CoreItems2.getRecipe(Empty540SpCell.getMetaID(), 1),
                ItemList.Reactor_Coolant_Le_3.get(1L), Materials.SuperCoolant.getFluid(3000L),
                GT_Values.NF);
        RA.addFluidCannerRecipe(CoreItems2.getRecipe(Empty1080SpCell.getMetaID(), 1),
                ItemList.Reactor_Coolant_Le_6.get(1L), Materials.SuperCoolant.getFluid(6000L),
                GT_Values.NF);

        RA.addFluidCannerRecipe(CoreItems2.getRecipe(143, 1), ItemList.Reactor_Coolant_He_1.get(1L),
                Materials.Helium.getGas(1000L), GT_Values.NF);
        RA.addFluidCannerRecipe(CoreItems2.getRecipe(144, 1), ItemList.Reactor_Coolant_He_3.get(1L),
                Materials.Helium.getGas(3000L), GT_Values.NF);
        RA.addFluidCannerRecipe(CoreItems2.getRecipe(145, 1), ItemList.Reactor_Coolant_He_6.get(1L),
                Materials.Helium.getGas(6000L), GT_Values.NF);

        RA.addFluidCannerRecipe(CoreItems2.getRecipe(143, 1), ItemList.Reactor_Coolant_NaK_1.get(1L),
                Materials.SodiumPotassium.getFluid(1000L), GT_Values.NF);
        RA.addFluidCannerRecipe(CoreItems2.getRecipe(144, 1), ItemList.Reactor_Coolant_NaK_3.get(1L),
                Materials.SodiumPotassium.getFluid(3000L), GT_Values.NF);
        RA.addFluidCannerRecipe(CoreItems2.getRecipe(145, 1), ItemList.Reactor_Coolant_NaK_6.get(1L),
                Materials.SodiumPotassium.getFluid(6000L), GT_Values.NF);
    }

    private void electrolyzer() {
        RA.addElectrolyzerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Naqlatigon, 56),
                null, null, Materials.Radon.getGas(4000),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Naquadria, 1),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.NaquadahEnriched, 3),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Naquadah, 13),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Platinum, 16),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Titanium, 19), null, null, 1000,
                30720);
        RA.addElectrolyzerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Osmirinigon, 53), null, null,
                Materials.Argon.getGas(8000),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Osmium, 2),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Iridium, 2),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Niobium, 7),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Nickel, 13),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Aluminium, 17), null, null, 600, 1020);
        RA.addElectrolyzerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Mithril, 5),
                null, null, null, GT_OreDictUnificator.get(OrePrefixes.dust, Materials.CertusQuartz, 2),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Platinum, 2),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.MeteoricIron, 1), null, null, null,
                        null, 600, 480);
    }

    private void ebf() {
        RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Iron, 1L),
                GT_Utility.getIntegratedCircuit(11), Materials.Oxygen.getGas(1000L), GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Steel, 1L),
                null, 500, 120, 1000);
        RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.WroughtIron, 1L),
                GT_Utility.getIntegratedCircuit(11), Materials.Oxygen.getGas(1000L), GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Steel, 1L),
                null, 100, 120, 1000);
        RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Copper, 1L),
                GT_Utility.getIntegratedCircuit(11), Materials.Oxygen.getGas(1000L), GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.AnnealedCopper, 1L), GT_Values.NI,
                500, 120, 1200);
        RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Ruby, 1L),
                GT_Values.NI, GT_Values.NF, GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.nugget, Materials.Aluminium, 3L),
                null, 400, 100, 1200);
        RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.gem, Materials.Ruby, 1L), GT_Values.NI,
                GT_Values.NF, GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.nugget, Materials.Aluminium, 3L),
                null, 320, 100, 1200);
        RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.GreenSapphire, 1L),
                GT_Values.NI, GT_Values.NF, GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.nugget, Materials.Aluminium, 3L),
                null, 400, 100, 1200);
        RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.gem, Materials.GreenSapphire, 1L),
                GT_Values.NI, GT_Values.NF, GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.nugget, Materials.Aluminium, 3L),
                null, 320, 100, 1200);
        RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Sapphire, 1L),
                GT_Values.NI, GT_Values.NF, GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.nugget, Materials.Aluminium, 3L), GT_Values.NI, 400,
                100, 1200);
        RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.gem, Materials.Sapphire, 1L),
                GT_Values.NI, GT_Values.NF, GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.nugget, Materials.Aluminium, 3L), GT_Values.NI, 320,
                100, 1200);
        RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Ilmenite, 2L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Carbon, 2L), GT_Values.NF,
                GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.WroughtIron, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Rutile, 1L), 800, 480, 1700);
        RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Magnesium, 2L),
                GT_Utility.getIntegratedCircuit(11), Materials.Titaniumtetrachloride.getFluid(1000L),
                GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Titanium, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Magnesiumchloride, 2L), 800, 480,
                2140);
        RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Copper, 1L),
                GT_Utility.getIntegratedCircuit(11), Materials.Oxygen.getGas(1000L), GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.AnnealedCopper, 1L), GT_Values.NI,
                200, 120, 1200);
        RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.FerriteMixture, 1L),
                GT_Utility.getIntegratedCircuit(11), Materials.Oxygen.getGas(2000), GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.NickelZincFerrite, 1L), null, 400,
                120, Materials.NickelZincFerrite.mBlastFurnaceTemp);
        RA.addBlastRecipe(
                CoreItems.getRecipe(34, 1), GT_Utility.getIntegratedCircuit(11),
                Materials.Argon.getGas(1000L), GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Neutronium, 1L), GT_Values.NI,
                2000, 500000, 9000);
        RA.addBlastRecipe(
                CoreItems.getRecipe(34, 1), GT_Utility.getIntegratedCircuit(12),
                Materials.PerroxGas.getGas(20L), GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Neutronium, 1L), GT_Values.NI, 200,
                500000, 9000);
        RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Adamantium, 1L),
                GT_Utility.getIntegratedCircuit(11), Materials.Argon.getGas(1000L), GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Adamantium, 1L), GT_Values.NI,
                2000, 500000, 10800);
        RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Adamantium, 1L),
                GT_Utility.getIntegratedCircuit(1), GT_Values.NF, GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Adamantium, 1L), GT_Values.NI,
                2500, 500000, 10800);
        RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Adamantium, 1L),
                GT_Utility.getIntegratedCircuit(12), Materials.PerroxGas.getGas(20L), GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Adamantium, 1L), GT_Values.NI,
                200, 500000, 10800);
        RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.ElectrumFlux, 1L),
                GT_Utility.getIntegratedCircuit(11), Materials.Argon.getGas(1000L), GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.ElectrumFlux, 1L),
                GT_Values.NI, 1000, 62880, 9000);
        RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.ElectrumFlux, 1L),
                GT_Utility.getIntegratedCircuit(12), Materials.PerroxGas.getGas(20L), GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.ElectrumFlux, 1L),
                GT_Values.NI, 250, 62880, 9000);
        RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.HSSG, 1L),
                GT_Utility.getIntegratedCircuit(11), Materials.Nitrogen.getGas(1000L), GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.HSSG, 1L), GT_Values.NI, 800, 1920,
                4500);
        RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.HSSG, 1L),
                GT_Utility.getIntegratedCircuit(1), GT_Values.NF, GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.HSSG, 1L), GT_Values.NI, 1300,
                1920, 4500);
        RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.HSSE, 1L),
                GT_Utility.getIntegratedCircuit(11), Materials.Helium.getGas(1000L), GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.HSSE, 1L), GT_Values.NI, 900, 1920,
                5400);
        RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.HSSE, 1L),
                GT_Utility.getIntegratedCircuit(1), GT_Values.NF, GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.HSSE, 1L), GT_Values.NI, 1400,
                1920, 5400);
        RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.HSSS, 1L),
                GT_Utility.getIntegratedCircuit(11), Materials.Helium.getGas(1000L), GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.HSSS, 1L), GT_Values.NI, 1000,
                1920, 5400);
        RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.HSSS, 1L),
                GT_Utility.getIntegratedCircuit(1), GT_Values.NF, GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.HSSS, 1L), GT_Values.NI, 1500,
                1920, 5400);
        RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Naquadah, 1L),
                GT_Utility.getIntegratedCircuit(11), Materials.Argon.getGas(1000L), GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Naquadah, 1L), GT_Values.NI, 500,
                3840, 5000);
		RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Naquadah, 1L),
                GT_Utility.getIntegratedCircuit(10), Materials.Radon.getGas(4000L), GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Naquadah, 1L), GT_Values.NI, 2000,
                7680, 5000);
        RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.NaquadahAlloy, 1L),
                GT_Utility.getIntegratedCircuit(11), Materials.Argon.getGas(1000L), GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.NaquadahAlloy, 1L),
                GT_Values.NI, 400, 62880, 7200);
        RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.NaquadahEnriched, 1L),
                GT_Utility.getIntegratedCircuit(11), Materials.Argon.getGas(1000L), GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.NaquadahEnriched, 1L),
                GT_Values.NI, 500, 7680, 7000);
        RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Naquadria, 1L),
                GT_Utility.getIntegratedCircuit(11), Materials.Argon.getGas(1000L), GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Naquadria, 1L), GT_Values.NI, 500,
                122880, 9000);
        RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Osmiridium, 1L),
                GT_Utility.getIntegratedCircuit(11), Materials.Helium.getGas(1000), GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Osmiridium, 1L), GT_Values.NI,
                500, 30720, 4500);
        RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.TungstenSteel, 1L),
                GT_Utility.getIntegratedCircuit(1), GT_Values.NF, GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.TungstenSteel, 1L),
                GT_Values.NI, 1300, 480, 3000);
        RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.TungstenSteel, 1L),
                GT_Utility.getIntegratedCircuit(11), Materials.Nitrogen.getGas(1000L), GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.TungstenSteel, 1L),
                GT_Values.NI, 800, 480, 3000);
        RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Desh, 1L),
                GT_Utility.getIntegratedCircuit(1), GT_Values.NF, GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Desh, 1L), GT_Values.NI, 1200, 480,
                3000);
        RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Desh, 1L),
                GT_Utility.getIntegratedCircuit(11), Materials.Nitrogen.getGas(1000L), GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Desh, 1L), GT_Values.NI, 800, 480,
                3000);
        RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.TungstenCarbide, 1L),
                GT_Utility.getIntegratedCircuit(1), GT_Values.NF, GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.TungstenCarbide, 1L),
                GT_Values.NI, 1500, 480, 2460);
        RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.TungstenCarbide, 1L),
                GT_Utility.getIntegratedCircuit(11), Materials.Nitrogen.getGas(1000L), GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.TungstenCarbide, 1L),
                GT_Values.NI, 1000, 480, 2460);
        RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.StainlessSteel, 1L),
                GT_Utility.getIntegratedCircuit(1), GT_Values.NF, GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.StainlessSteel, 1L), GT_Values.NI,
                800, 480, 1700);
        RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.StainlessSteel, 1L),
                GT_Utility.getIntegratedCircuit(11), Materials.Nitrogen.getGas(1000L), GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.StainlessSteel, 1L), GT_Values.NI,
                400, 480, 1700);
        RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Aluminium, 1L),
                GT_Utility.getIntegratedCircuit(11), Materials.Nitrogen.getGas(1000L), GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Aluminium, 1L), GT_Values.NI, 400,
                120, 1700);
        RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.MeteoricSteel, 1L),
                GT_Utility.getIntegratedCircuit(1), GT_Values.NF, GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.MeteoricSteel, 1L),
                GT_Values.NI, 1500, 480, 2460);
        RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.MeteoricSteel, 1L),
                GT_Utility.getIntegratedCircuit(11), Materials.Oxygen.getGas(1000L), GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.MeteoricSteel, 1L),
                GT_Values.NI, 1000, 480, 2460);
        RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.NiobiumTitanium, 1L),
                GT_Utility.getIntegratedCircuit(1), GT_Values.NF, GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.NiobiumTitanium, 1L),
                GT_Values.NI, 1500, 480, 4500);
        RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.NiobiumTitanium, 1L),
                GT_Utility.getIntegratedCircuit(11), Materials.Helium.getGas(1000L), GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.NiobiumTitanium, 1L),
                GT_Values.NI, 1000, 480, 4500);
        RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Longasssuperconductornameforlvwire, 1L),
                GT_Utility.getIntegratedCircuit(1), GT_Values.NF, GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Longasssuperconductornameforlvwire, 1L),
                GT_Values.NI, 1200, 120, 1200);
        RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Longasssuperconductornameforlvwire, 1L),
                GT_Utility.getIntegratedCircuit(11), Materials.Nitrogen.getGas(1000L), GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Longasssuperconductornameforlvwire, 1L),
                GT_Values.NI, 800, 120, 1200);
        RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Pentacadmiummagnesiumhexaoxid, 1L),
                GT_Utility.getIntegratedCircuit(1), GT_Values.NF, GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Pentacadmiummagnesiumhexaoxid, 1L),
                GT_Values.NI, 1700, 480, 2500);
        RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Pentacadmiummagnesiumhexaoxid, 1L),
                GT_Utility.getIntegratedCircuit(11), Materials.Nitrogen.getGas(1000L), GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Pentacadmiummagnesiumhexaoxid, 1L),
                GT_Values.NI, 1200, 480, 2500);
        RA.addBlastRecipe(GT_OreDictUnificator
                        .get(OrePrefixes.dust, Materials.Titaniumonabariumdecacoppereikosaoxid, 1L),
                GT_Utility.getIntegratedCircuit(1), GT_Values.NF, GT_Values.NF, GT_OreDictUnificator
                        .get(OrePrefixes.ingotHot, Materials.Titaniumonabariumdecacoppereikosaoxid, 1L),
                GT_Values.NI, 1800, 480, 3300);
        RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Titaniumonabariumdecacoppereikosaoxid, 1L),
                GT_Utility.getIntegratedCircuit(11), Materials.Nitrogen.getGas(1000L), GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Titaniumonabariumdecacoppereikosaoxid, 1L),
                GT_Values.NI, 1300, 480, 3300);
        RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Uraniumtriplatinid, 1L),
                GT_Utility.getIntegratedCircuit(1), GT_Values.NF, GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Uraniumtriplatinid, 1L),
                GT_Values.NI, 1900, 1920, 4400);
        RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Uraniumtriplatinid, 1L),
                GT_Utility.getIntegratedCircuit(11), Materials.Helium.getGas(1000L), GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Uraniumtriplatinid, 1L),
                GT_Values.NI, 1400, 1920, 4400);
        RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Vanadiumtriindinid, 1L),
                GT_Utility.getIntegratedCircuit(1), GT_Values.NF, GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Vanadiumtriindinid, 1L),
                GT_Values.NI, 2000, 1920, 5200);
        RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Vanadiumtriindinid, 1L),
                GT_Utility.getIntegratedCircuit(11), Materials.Helium.getGas(1000L), GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Vanadiumtriindinid, 1L),
                GT_Values.NI, 1500, 1920, 5200);
        RA.addBlastRecipe(GT_OreDictUnificator.get(OrePrefixes.dust,
                Materials.Tetraindiumditindibariumtitaniumheptacoppertetrakaidekaoxid, 1L),
                GT_Utility.getIntegratedCircuit(1), GT_Values.NF, GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingotHot,
                        Materials.Tetraindiumditindibariumtitaniumheptacoppertetrakaidekaoxid, 1L),
                GT_Values.NI, 2100, 7680, 6000);
        RA.addBlastRecipe(GT_OreDictUnificator.get(OrePrefixes.dust,
                Materials.Tetraindiumditindibariumtitaniumheptacoppertetrakaidekaoxid, 1L),
                GT_Utility.getIntegratedCircuit(11), Materials.Argon.getGas(1000L), GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingotHot,
                        Materials.Tetraindiumditindibariumtitaniumheptacoppertetrakaidekaoxid, 1L),
                GT_Values.NI, 1600, 7680, 6000);
        RA.addBlastRecipe(GT_OreDictUnificator.get(OrePrefixes.dust,
                Materials.Tetraindiumditindibariumtitaniumheptacoppertetrakaidekaoxid, 1L),
                GT_Utility.getIntegratedCircuit(12), Materials.PerroxGas.getGas(20L), GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingotHot,
                        Materials.Tetraindiumditindibariumtitaniumheptacoppertetrakaidekaoxid, 1L),
                GT_Values.NI, 160, 7680, 6000);
        RA.addBlastRecipe(GT_OreDictUnificator
                        .get(OrePrefixes.dust, Materials.Tetranaquadahdiindiumhexaplatiumosminid, 1L),
                GT_Utility.getIntegratedCircuit(1), GT_Values.NF, GT_Values.NF, GT_OreDictUnificator
                        .get(OrePrefixes.ingotHot, Materials.Tetranaquadahdiindiumhexaplatiumosminid, 1L),
                GT_Values.NI, 2000, 7680, 9000);
        RA.addBlastRecipe(GT_OreDictUnificator
                        .get(OrePrefixes.dust, Materials.Tetranaquadahdiindiumhexaplatiumosminid, 1L),
                GT_Utility.getIntegratedCircuit(11), Materials.Argon.getGas(1000L), GT_Values.NF,
                GT_OreDictUnificator
                        .get(OrePrefixes.ingotHot, Materials.Tetranaquadahdiindiumhexaplatiumosminid, 1L),
                GT_Values.NI, 1500, 7680, 9000);
        RA.addBlastRecipe(GT_OreDictUnificator
                        .get(OrePrefixes.dust, Materials.Tetranaquadahdiindiumhexaplatiumosminid, 1L),
                GT_Utility.getIntegratedCircuit(12), Materials.PerroxGas.getGas(20L), GT_Values.NF,
                GT_OreDictUnificator
                        .get(OrePrefixes.ingotHot, Materials.Tetranaquadahdiindiumhexaplatiumosminid, 1L),
                GT_Values.NI, 150, 7680, 9000);
        RA.addBlastRecipe(GT_OreDictUnificator
                        .get(OrePrefixes.dust, Materials.Longasssuperconductornameforuvwire, 1L),
                GT_Utility.getIntegratedCircuit(1), GT_Values.NF, GT_Values.NF, GT_OreDictUnificator
                        .get(OrePrefixes.ingotHot, Materials.Longasssuperconductornameforuvwire, 1L),
                GT_Values.NI, 2100, 30720, 9000);
        RA.addBlastRecipe(GT_OreDictUnificator
                        .get(OrePrefixes.dust, Materials.Longasssuperconductornameforuvwire, 1L),
                GT_Utility.getIntegratedCircuit(11), Materials.Radon.getGas(1000L), GT_Values.NF,
                GT_OreDictUnificator
                        .get(OrePrefixes.ingotHot, Materials.Longasssuperconductornameforuvwire, 1L),
                GT_Values.NI, 1600, 30720, 9000);
        RA.addBlastRecipe(GT_OreDictUnificator
                        .get(OrePrefixes.dust, Materials.Longasssuperconductornameforuvwire, 1L),
                GT_Utility.getIntegratedCircuit(12), Materials.PerroxGas.getGas(20L), GT_Values.NF,
                GT_OreDictUnificator
                        .get(OrePrefixes.ingotHot, Materials.Longasssuperconductornameforuvwire, 1L),
                GT_Values.NI, 160, 30720, 9000);
        RA.addBlastRecipe(GT_OreDictUnificator
                        .get(OrePrefixes.dust, Materials.Longasssuperconductornameforuhvwire, 1L),
                GT_Utility.getIntegratedCircuit(1), GT_Values.NF, GT_Values.NF, GT_OreDictUnificator
                        .get(OrePrefixes.ingotHot, Materials.Longasssuperconductornameforuhvwire, 1L),
                GT_Values.NI, 2200, 122880, 10800);
        RA.addBlastRecipe(GT_OreDictUnificator
                        .get(OrePrefixes.dust, Materials.Longasssuperconductornameforuhvwire, 1L),
                GT_Utility.getIntegratedCircuit(11), Materials.Radon.getGas(1000L), GT_Values.NF,
                GT_OreDictUnificator
                        .get(OrePrefixes.ingotHot, Materials.Longasssuperconductornameforuhvwire, 1L),
                GT_Values.NI, 1700, 122880, 10800);
        RA.addBlastRecipe(GT_OreDictUnificator
                        .get(OrePrefixes.dust, Materials.Longasssuperconductornameforuhvwire, 1L),
                GT_Utility.getIntegratedCircuit(12), Materials.PerroxGas.getGas(20L), GT_Values.NF,
                GT_OreDictUnificator
                        .get(OrePrefixes.ingotHot, Materials.Longasssuperconductornameforuhvwire, 1L),
                GT_Values.NI, 170, 122880, 10800);
        RA.addBlastRecipe(GT_OreDictUnificator
                        .get(OrePrefixes.dust, Materials.Longasssuperconductornameforuevwire, 1L),
                GT_Utility.getIntegratedCircuit(1), GT_Values.NF, GT_Values.NF, GT_OreDictUnificator
                        .get(OrePrefixes.ingotHot, Materials.Longasssuperconductornameforuevwire, 1L),
                GT_Values.NI, 2300, 500000, 12600);
        RA.addBlastRecipe(GT_OreDictUnificator
                        .get(OrePrefixes.dust, Materials.Longasssuperconductornameforuevwire, 1L),
                GT_Utility.getIntegratedCircuit(11), Materials.Radon.getGas(1000L), GT_Values.NF,
                GT_OreDictUnificator
                        .get(OrePrefixes.ingotHot, Materials.Longasssuperconductornameforuevwire, 1L),
                GT_Values.NI, 1800, 500000, 12600);
        RA.addBlastRecipe(GT_OreDictUnificator
                        .get(OrePrefixes.dust, Materials.Longasssuperconductornameforuevwire, 1L),
                GT_Utility.getIntegratedCircuit(12), Materials.PerroxGas.getGas(20L), GT_Values.NF,
                GT_OreDictUnificator
                        .get(OrePrefixes.ingotHot, Materials.Longasssuperconductornameforuevwire, 1L),
                GT_Values.NI, 180, 500000, 12600);
        RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.RedstoneAlloy, 1L),
                GT_Utility.getIntegratedCircuit(11), Materials.Oxygen.getGas(1000L), GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.RedstoneAlloy, 1L), GT_Values.NI,
                500, 120, 1000);
        RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.RedstoneAlloy, 1L),
                GT_Utility.getIntegratedCircuit(1), GT_Values.NF, GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.RedstoneAlloy, 1L), GT_Values.NI,
                1000, 120, 1200);
        RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.ConductiveIron, 1L),
                GT_Utility.getIntegratedCircuit(11), Materials.Oxygen.getGas(1000L), GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.ConductiveIron, 1L), GT_Values.NI,
                700, 120, 1200);
        RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.ConductiveIron, 1L),
                GT_Utility.getIntegratedCircuit(1), GT_Values.NF, GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.ConductiveIron, 1L), GT_Values.NI,
                1200, 120, 1500);
        RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.EnergeticAlloy, 1L),
                GT_Utility.getIntegratedCircuit(11), Materials.Hydrogen.getGas(1000L), GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.EnergeticAlloy, 1L), GT_Values.NI,
                1000, 120, 2200);
        RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.EnergeticAlloy, 1L),
                GT_Utility.getIntegratedCircuit(1), GT_Values.NF, GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.EnergeticAlloy, 1L), GT_Values.NI,
                1500, 120, 2500);
        RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.VibrantAlloy, 1L),
                GT_Utility.getIntegratedCircuit(11), Materials.Hydrogen.getGas(1000L), GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.VibrantAlloy, 1L),
                GT_Values.NI, 1000, 480, 3000);
        RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.VibrantAlloy, 1L),
                GT_Utility.getIntegratedCircuit(1), GT_Values.NF, GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.VibrantAlloy, 1L),
                GT_Values.NI, 1500, 480, 3600);
        RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.ElectricalSteel, 1L),
                GT_Utility.getIntegratedCircuit(11), Materials.Oxygen.getGas(1000L), GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.ElectricalSteel, 1L),
                GT_Values.NI, 1000, 120, 1000);
        RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.ElectricalSteel, 1L),
                GT_Utility.getIntegratedCircuit(1), GT_Values.NF, GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.ElectricalSteel, 1L),
                GT_Values.NI, 1500, 120, 1200);
        RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.PulsatingIron, 1L),
                GT_Utility.getIntegratedCircuit(11), Materials.Oxygen.getGas(1000L), GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.PulsatingIron, 1L), GT_Values.NI,
                1000, 480, 1800);
        RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.PulsatingIron, 1L),
                GT_Utility.getIntegratedCircuit(1), GT_Values.NF, GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.PulsatingIron, 1L), GT_Values.NI,
                1500, 480, 2200);
        RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Soularium, 1L),
                GT_Utility.getIntegratedCircuit(11), Materials.Helium.getGas(1000L), GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Soularium, 1L), GT_Values.NI, 1000,
                120, 1000);
        RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Soularium, 1L),
                GT_Utility.getIntegratedCircuit(1), GT_Values.NF, GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Soularium, 1L), GT_Values.NI, 1500,
                120, 1200);
        RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.DarkSteel, 1L),
                GT_Utility.getIntegratedCircuit(11), Materials.Oxygen.getGas(1000L), GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.DarkSteel, 1L), GT_Values.NI, 1000,
                480, 1800);
        RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.DarkSteel, 1L),
                GT_Utility.getIntegratedCircuit(1), GT_Values.NF, GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.DarkSteel, 1L), GT_Values.NI, 1500,
                480, 2200);
        RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Draconium, 4L),
                GT_Utility.getIntegratedCircuit(12), Materials.Naquadah.getMolten(576L),
                Materials.Tartarite.getFluid(576L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Naquadah, 2L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Uranium, 1L), 800, 30720, 7200);
        RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.DraconiumAwakened, 4L),
                GT_Utility.getIntegratedCircuit(12), Materials.NaquadahEnriched.getMolten(576L),
                Materials.EnrichedTartarite.getFluid(576L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.NaquadahEnriched, 2L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Plutonium, 1L), 1600, 122880,
                10800);
        RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Europiumoxide, 1L),
                GT_Utility.getIntegratedCircuit(11), Materials.Helium.getGas(1000L), GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Europiumoxide, 1L),
                GT_Values.NI, 800, 30720, 7200);
        RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Europiumoxide, 1L),
                GT_Utility.getIntegratedCircuit(1), GT_Values.NF, GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Europiumoxide, 1L),
                GT_Values.NI, 1500, 30720, 7200);
        RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Diamericiumtitanium, 1L),
                GT_Utility.getIntegratedCircuit(11), Materials.Argon.getGas(1000L), GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Diamericiumtitanium, 1L),
                GT_Values.NI, 1200, 122880, 9000);
        RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Infuscolium, 1L),
                GT_Utility.getIntegratedCircuit(11), Materials.Argon.getGas(1000L), GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Infuscolium, 1L), GT_Values.NI,
                600, 30720, 9000);
        RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Infuscolium, 1L),
                GT_Utility.getIntegratedCircuit(1), GT_Values.NF, GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Infuscolium, 1L), GT_Values.NI,
                1200, 30720, 9000);
        RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Europium, 1L),
                GT_Utility.getIntegratedCircuit(1), GT_Values.NF, GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Europium, 1L), GT_Values.NI, 1500,
                7680, 6000);
        RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Europium, 1L),
                GT_Utility.getIntegratedCircuit(11), Materials.Argon.getGas(1000L), GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Europium, 1L), GT_Values.NI, 1000,
                7680, 6000);
        RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Quantium, 1L),
                GT_Utility.getIntegratedCircuit(12), Materials.PerroxGas.getGas(20L), GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Quantium, 1L), GT_Values.NI, 160,
                122880, 10800);
        RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Quantium, 1L),
                GT_Utility.getIntegratedCircuit(11), Materials.Argon.getGas(1000L), GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Quantium, 1L), GT_Values.NI, 1600,
                122880, 10800);
        RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Quantium, 1L),
                GT_Utility.getIntegratedCircuit(1), GT_Values.NF, GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Quantium, 1L), GT_Values.NI, 2100,
                122880, 9900);
        RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.CosmicNeutronium, 1L),
                GT_Utility.getIntegratedCircuit(12), Materials.PerroxGas.getGas(20L), GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.CosmicNeutronium, 1L),
                GT_Values.NI, 150, 500000, 12600);
        RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.CosmicNeutronium, 1L),
                GT_Utility.getIntegratedCircuit(11), Materials.Argon.getGas(1000L), GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.CosmicNeutronium, 1L),
                GT_Values.NI, 1500, 500000, 12600);
        RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.CosmicNeutronium, 1L),
                GT_Utility.getIntegratedCircuit(1), GT_Values.NF, GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.CosmicNeutronium, 1L),
                GT_Values.NI, 2000, 500000, 12600);
        RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.BlackPlutonium, 1L),
                GT_Utility.getIntegratedCircuit(12), Materials.PerroxGas.getGas(20L), GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.BlackPlutonium, 1L),
                GT_Values.NI, 150, 500000, 12600);
        RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.BlackPlutonium, 1L),
                GT_Utility.getIntegratedCircuit(11), Materials.Argon.getGas(1000L), GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.BlackPlutonium, 1L),
                GT_Values.NI, 1500, 500000, 12600);
        RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.BlackPlutonium, 1L),
                GT_Utility.getIntegratedCircuit(1), GT_Values.NF, GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.BlackPlutonium, 1L),
                GT_Values.NI, 2000, 500000, 12600);
        RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Enderium, 1L),
                GT_Utility.getIntegratedCircuit(11), Materials.Helium.getGas(1000L), GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Enderium, 1L), GT_Values.NI, 1000,
                480, 4500);
        RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Enderium, 1L),
                GT_Utility.getIntegratedCircuit(1), GT_Values.NF, GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Enderium, 1L), GT_Values.NI, 1500,
                480, 4500);
        RA.addBlastRecipe(
                ItemList.Circuit_Parts_RawCrystalChip.get(1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Emerald, 1),
                Materials.Helium.getGas(1000), null, ItemList.Circuit_Parts_Crystal_Chip_Elite.get(1), null,
                900, 480, 5000);
        RA.addBlastRecipe(
                ItemList.Circuit_Parts_RawCrystalChip.get(1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Olivine, 1),
                Materials.Helium.getGas(1000), null, ItemList.Circuit_Parts_Crystal_Chip_Elite.get(1), null,
                900, 480, 5000);
        RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Silicon, 64),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Gallium, 1), null, null,
                ItemList.Circuit_Silicon_Ingot.get(2), null, 6000, 120, 1784);
        RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Silicon, 64),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Glowstone, 8),
                Materials.Nitrogen.getGas(8000), null,
                ItemList.Circuit_Silicon_Ingot2.get(1), null, 9000, 480, 2484);
        RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.block, Materials.Silicon, 16),
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Naquadah, 1),
                Materials.Argon.getGas(8000), null, ItemList.Circuit_Silicon_Ingot3.get(1, new Object[0]),
                null, 1200, 1920, 5400);
        RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.block, Materials.Silicon, 8),
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Enderium, 6),
                Materials.Argon.getGas(4000), null, ItemList.Circuit_Silicon_Ingot4.get(1, new Object[0]),
                null, 11500, 1024, 3333);
        RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.block, Materials.Silicon, 24),
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Naquadria, 2),
                Materials.Argon.getGas(8000), null, ItemList.Circuit_Silicon_Ingot5.get(1, new Object[0]),
                null, 2100, 30720, 9000);
        RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.block, Materials.Silicon, 32),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.MysteriousCrystal, 4),
                Materials.Argon.getGas(16000), null, ItemList.Circuit_Silicon_Ingot6.get(1, new Object[0]),
                null, 2900, 500000, 9000);
        RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.block, Materials.Silicon, 32),
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Europium, 2),
                Materials.Radon.getGas(8000), null, ItemList.Circuit_Silicon_Ingot7.get(1, new Object[0]),
                null, 15000, 7680, 6484);
        RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.block, Materials.Silicon, 64),
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Americium, 4),
                Materials.Radon.getGas(16000), null, ItemList.Circuit_Silicon_Ingot8.get(1, new Object[0]),
                null, 18000, 30720, 9000);
        RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.block, Materials.Silicon, 8),
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.VibrantAlloy, 6),
                Materials.Argon.getGas(3000), null, ItemList.Circuit_Silicon_Ingot9.get(1, new Object[0]),
                null, 9000, 1024, 3333);
        RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.block, Materials.Silicon, 64),
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Neutronium, 4),
                Materials.Radon.getGas(24000), null, ItemList.Circuit_Silicon_Ingot10.get(1, new Object[0]),
                null, 24000, 500000, 12600);
        RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.block, Materials.Silicon, 64),
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Neutronium, 4),
                Materials.PerroxGas.getGas(480), null,
                ItemList.Circuit_Silicon_Ingot10.get(1), null, 6400, 500000, 12600);
        RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Trinium, 1L),
                GT_Utility.getIntegratedCircuit(1), GT_Values.NF, GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Trinium, 1L), GT_Values.NI, 1600,
                30720, 7200);
        RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Trinium, 1L),
                GT_Utility.getIntegratedCircuit(11), Materials.Argon.getGas(1000L), GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Trinium, 1L), GT_Values.NI, 800,
                30720, 7200);
        RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.HSLA, 1L),
                GT_Utility.getIntegratedCircuit(1), GT_Values.NF, GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.HSLA, 1L), GT_Values.NI, 1200, 480,
                1811);
        RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.HSLA, 1L),
                GT_Utility.getIntegratedCircuit(11), Materials.Oxygen.getGas(1000L), GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.HSLA, 1L), GT_Values.NI, 600, 480,
                1811);
        RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.BT6, 1L),
                GT_Utility.getIntegratedCircuit(1), GT_Values.NF, GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.BT6, 1L), GT_Values.NI, 1500, 480,
                3200);
        RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.BT6, 1L),
                GT_Utility.getIntegratedCircuit(11), Materials.Nitrogen.getGas(1000L), GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.BT6, 1L), GT_Values.NI, 800, 480,
                3200);
        RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Birmabright, 1L),
                GT_Utility.getIntegratedCircuit(11), Materials.Nitrogen.getGas(1000L), GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Birmabright, 1L), GT_Values.NI,
                400, 120, 1476);
        RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.InfinityCatalyst, 1L),
                GT_Utility.getIntegratedCircuit(12), Materials.PerroxGas.getGas(100L), GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.InfinityCatalyst, 1L),
                GT_Values.NI, 2000, 2000000, 12600);
        RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Infinity, 1L),
                GT_Utility.getIntegratedCircuit(12), Materials.PerroxGas.getGas(500L), GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Infinity, 1L), GT_Values.NI, 2000,
                2000000, 12600);
        RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Iridium, 1L),
                GT_Utility.getIntegratedCircuit(11), Materials.Nitrogen.getGas(1000L), GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Iridium, 1L), GT_Values.NI, 800,
                7680, 4500);
        RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Iridium, 1L),
                GT_Utility.getIntegratedCircuit(1), GT_Values.NF, GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Iridium, 1L), GT_Values.NI, 1600,
                7680, 4500);
        RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Osmium, 1L),
                GT_Utility.getIntegratedCircuit(11), Materials.Helium.getGas(1000L), GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Osmium, 1L), GT_Values.NI, 900,
                30720, 4500);
        RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Osmium, 1L),
                GT_Utility.getIntegratedCircuit(1), GT_Values.NF, GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Osmium, 1L), GT_Values.NI, 1800,
                30720, 4500);
        RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Oriharukon, 1L),
                GT_Utility.getIntegratedCircuit(11), Materials.Nitrogen.getGas(1000L), GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Oriharukon, 1L), GT_Values.NI,
                700, 30720, 5400);
        RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Oriharukon, 1L),
                GT_Utility.getIntegratedCircuit(1), GT_Values.NF, GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Oriharukon, 1L), GT_Values.NI,
                1400, 30720, 5400);
        RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.VanadiumGallium, 1L),
                GT_Utility.getIntegratedCircuit(1), GT_Values.NF, GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.VanadiumGallium, 1L),
                GT_Values.NI, 1200, 480, 4500);
        RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.VanadiumGallium, 1L),
                GT_Utility.getIntegratedCircuit(11), Materials.Helium.getGas(1000L), GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.VanadiumGallium, 1L),
                GT_Values.NI, 600, 480, 4500);
        RA.addBlastRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Titanium, 1L),
                GT_Utility.getIntegratedCircuit(1), GT_Values.NF, GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Titanium, 1L), GT_Values.NI, 1400,
                1920, 1940);
        RA.addBlastRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Titanium, 1L),
                GT_Utility.getIntegratedCircuit(11), Materials.Nitrogen.getGas(1000L), GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Titanium, 1L), GT_Values.NI, 700,
                1920, 1940);
        RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.YttriumBariumCuprate, 1L),
                GT_Utility.getIntegratedCircuit(1), GT_Values.NF, GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.YttriumBariumCuprate, 1L),
                GT_Values.NI, 1200, 480, 4500);
        RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.YttriumBariumCuprate, 1L),
                GT_Utility.getIntegratedCircuit(11), Materials.Nitrogen.getGas(1000L), GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.YttriumBariumCuprate, 1L),
                GT_Values.NI, 600, 480, 4500);
        RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Tungsten, 1L),
                GT_Utility.getIntegratedCircuit(1), GT_Values.NF, GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Tungsten, 1L), GT_Values.NI, 2400,
                1920, 3000);
        RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Tungsten, 1L),
                GT_Utility.getIntegratedCircuit(11), Materials.Nitrogen.getGas(1000L), GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Tungsten, 1L), GT_Values.NI, 1200,
                1920, 3000);
        RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Mytryl, 1L),
                GT_Utility.getIntegratedCircuit(1), GT_Values.NF, GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Mytryl, 1L), GT_Values.NI, 1700,
                1920, 3600);
        RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Mytryl, 1L),
                GT_Utility.getIntegratedCircuit(11), Materials.Nitrogen.getGas(1000L), GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Mytryl, 1L), GT_Values.NI, 1200,
                1920, 3600);
        RA.addBlastRecipe(
                GT_ModHandler.getModItem("GalacticraftMars", "item.itemBasicAsteroids", 2L, 4),
                GT_Utility.getIntegratedCircuit(1), GT_Values.NF, GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Titanium, 1L), GT_Values.NI, 1500,
                120, 1500);
    }

    private void componentAssembler() {
        if (GT_Mod.gregtechproxy.mComponentAssembler) {
            //Motors
            RA.addComponentAssemblerRecipe(
                    new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.IronMagnetic, 1L),
                            GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Iron, 2L),
                            GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Tin, 4L),
                            GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Lead, 2L)}, GT_Values.NF,
                    GT_ItemList.ULVMotor.get(1L), 40, 8);
            RA.addComponentAssemblerRecipe(
                    new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.stick, Materials.IronMagnetic, 1L),
                            GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Iron, 2L),
                            GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.Copper, 4L),
                            GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Tin, 2L)}, GT_Values.NF,
                    ItemList.Electric_Motor_LV.get(1L), 80, 30);
            RA.addComponentAssemblerRecipe(
                    new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.stick, Materials.SteelMagnetic, 1L),
                            GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Steel, 2L),
                            GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.Copper, 4L),
                            GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Tin, 2L)}, GT_Values.NF,
                    ItemList.Electric_Motor_LV.get(1L), 80, 30);
            RA.addComponentAssemblerRecipe(
                    new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.stick, Materials.SteelMagnetic, 1L),
                            GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Aluminium, 2L),
                            GT_OreDictUnificator.get(OrePrefixes.wireGt02, Materials.Cupronickel, 4L),
                            GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Copper, 2L)}, GT_Values.NF,
                    ItemList.Electric_Motor_MV.get(1L), 120, 120);
            RA.addComponentAssemblerRecipe(
                    new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.stick, Materials.SteelMagnetic, 1L),
                            GT_OreDictUnificator.get(OrePrefixes.stick, Materials.StainlessSteel, 2L),
                            GT_OreDictUnificator.get(OrePrefixes.wireGt02, Materials.Electrum, 4L),
                            GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Silver, 2L)}, GT_Values.NF,
                    ItemList.Electric_Motor_HV.get(1L), 160, 480);
            RA.addComponentAssemblerRecipe(new ItemStack[]{
                            GT_OreDictUnificator.get(OrePrefixes.stick, Materials.NeodymiumMagnetic, 1L),
                            GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Titanium, 2L),
                            GT_OreDictUnificator.get(OrePrefixes.wireGt02, Materials.AnnealedCopper, 4L),
                            GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Aluminium, 2L)}, GT_Values.NF,
                    ItemList.Electric_Motor_EV.get(1L), 180, 1920);
            RA.addComponentAssemblerRecipe(new ItemStack[]{
                            GT_OreDictUnificator.get(OrePrefixes.stick, Materials.NeodymiumMagnetic, 1L),
                            GT_OreDictUnificator.get(OrePrefixes.stick, Materials.TungstenSteel, 2L),
                            GT_OreDictUnificator.get(OrePrefixes.wireGt02, Materials.Graphene, 4L),
                            GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Tungsten, 2L)}, GT_Values.NF,
                    ItemList.Electric_Motor_IV.get(1L), 200, 7680);

            //Pumps
            RA.addComponentAssemblerRecipe(new ItemStack[]{GT_ItemList.ULVMotor.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.ring, Materials.Rubber, 2),
                            GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.Lead, 1),
                            GT_OreDictUnificator.get(OrePrefixes.screw, Materials.Lead, 2),
                            GT_OreDictUnificator.get(OrePrefixes.pipeMedium, Materials.Copper, 1)}, GT_Values.NF,
                    GT_ItemList.ULVPump.get(1L), 100, 8);
            RA.addComponentAssemblerRecipe(new ItemStack[]{ItemList.Electric_Motor_LV.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.ring, Materials.Rubber, 2),
                            GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.Tin, 1),
                            GT_OreDictUnificator.get(OrePrefixes.screw, Materials.Tin, 1),
                            GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Tin, 1),
                            GT_OreDictUnificator.get(OrePrefixes.pipeMedium, Materials.Bronze, 1)}, GT_Values.NF,
                    ItemList.Electric_Pump_LV.get(1L), 80, 30);
            RA.addComponentAssemblerRecipe(new ItemStack[]{ItemList.Electric_Motor_LV.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.ring, Materials.Silicone, 2),
                            GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.Tin, 1),
                            GT_OreDictUnificator.get(OrePrefixes.screw, Materials.Tin, 1),
                            GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Tin, 1),
                            GT_OreDictUnificator.get(OrePrefixes.pipeMedium, Materials.Bronze, 1)}, GT_Values.NF,
                    ItemList.Electric_Pump_LV.get(1L), 80, 30);
            RA.addComponentAssemblerRecipe(new ItemStack[]{ItemList.Electric_Motor_LV.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.ring, Materials.StyreneButadieneRubber, 2),
                            GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.Tin, 1),
                            GT_OreDictUnificator.get(OrePrefixes.screw, Materials.Tin, 1),
                            GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Tin, 1),
                            GT_OreDictUnificator.get(OrePrefixes.pipeMedium, Materials.Bronze, 1)}, GT_Values.NF,
                    ItemList.Electric_Pump_LV.get(1L), 80, 30);
            RA.addComponentAssemblerRecipe(new ItemStack[]{ItemList.Electric_Motor_MV.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.ring, Materials.Rubber, 2),
                            GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.Bronze, 1),
                            GT_OreDictUnificator.get(OrePrefixes.screw, Materials.Bronze, 1),
                            GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Copper, 1),
                            GT_OreDictUnificator.get(OrePrefixes.pipeMedium, Materials.Steel, 1)}, GT_Values.NF,
                    ItemList.Electric_Pump_MV.get(1L), 120, 120);
            RA.addComponentAssemblerRecipe(new ItemStack[]{ItemList.Electric_Motor_MV.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.ring, Materials.Silicone, 2),
                            GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.Bronze, 1),
                            GT_OreDictUnificator.get(OrePrefixes.screw, Materials.Bronze, 1),
                            GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Copper, 1),
                            GT_OreDictUnificator.get(OrePrefixes.pipeMedium, Materials.Steel, 1)}, GT_Values.NF,
                    ItemList.Electric_Pump_MV.get(1L), 120, 120);
            RA.addComponentAssemblerRecipe(new ItemStack[]{ItemList.Electric_Motor_MV.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.ring, Materials.StyreneButadieneRubber, 2),
                            GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.Bronze, 1),
                            GT_OreDictUnificator.get(OrePrefixes.screw, Materials.Bronze, 1),
                            GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Copper, 1),
                            GT_OreDictUnificator.get(OrePrefixes.pipeMedium, Materials.Steel, 1)}, GT_Values.NF,
                    ItemList.Electric_Pump_MV.get(1L), 120, 120);
            RA.addComponentAssemblerRecipe(new ItemStack[]{ItemList.Electric_Motor_HV.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.ring, Materials.Rubber, 2),
                            GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.Steel, 1),
                            GT_OreDictUnificator.get(OrePrefixes.screw, Materials.Steel, 1),
                            GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Gold, 1),
                            GT_OreDictUnificator.get(OrePrefixes.pipeMedium, Materials.StainlessSteel, 1)},
                    GT_Values.NF, ItemList.Electric_Pump_HV.get(1L), 160, 480);
            RA.addComponentAssemblerRecipe(new ItemStack[]{ItemList.Electric_Motor_HV.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.ring, Materials.Silicone, 2),
                            GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.Steel, 1),
                            GT_OreDictUnificator.get(OrePrefixes.screw, Materials.Steel, 1),
                            GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Gold, 1),
                            GT_OreDictUnificator.get(OrePrefixes.pipeMedium, Materials.StainlessSteel, 1)},
                    GT_Values.NF, ItemList.Electric_Pump_HV.get(1L), 160, 480);
            RA.addComponentAssemblerRecipe(new ItemStack[]{ItemList.Electric_Motor_HV.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.ring, Materials.StyreneButadieneRubber, 2),
                            GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.Steel, 1),
                            GT_OreDictUnificator.get(OrePrefixes.screw, Materials.Steel, 1),
                            GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Gold, 1),
                            GT_OreDictUnificator.get(OrePrefixes.pipeMedium, Materials.StainlessSteel, 1)},
                    GT_Values.NF, ItemList.Electric_Pump_HV.get(1L), 160, 480);
            RA.addComponentAssemblerRecipe(new ItemStack[]{ItemList.Electric_Motor_EV.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.ring, Materials.Rubber, 2),
                            GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.StainlessSteel, 1),
                            GT_OreDictUnificator.get(OrePrefixes.screw, Materials.StainlessSteel, 1),
                            GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Aluminium, 1),
                            GT_OreDictUnificator.get(OrePrefixes.pipeMedium, Materials.Titanium, 1)}, GT_Values.NF,
                    ItemList.Electric_Pump_EV.get(1L), 180, 1920);
            RA.addComponentAssemblerRecipe(new ItemStack[]{ItemList.Electric_Motor_EV.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.ring, Materials.Silicone, 2),
                            GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.StainlessSteel, 1),
                            GT_OreDictUnificator.get(OrePrefixes.screw, Materials.StainlessSteel, 1),
                            GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Aluminium, 1),
                            GT_OreDictUnificator.get(OrePrefixes.pipeMedium, Materials.Titanium, 1)}, GT_Values.NF,
                    ItemList.Electric_Pump_EV.get(1L), 180, 1920);
            RA.addComponentAssemblerRecipe(new ItemStack[]{ItemList.Electric_Motor_EV.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.ring, Materials.StyreneButadieneRubber, 2),
                            GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.StainlessSteel, 1),
                            GT_OreDictUnificator.get(OrePrefixes.screw, Materials.StainlessSteel, 1),
                            GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Aluminium, 1),
                            GT_OreDictUnificator.get(OrePrefixes.pipeMedium, Materials.Titanium, 1)}, GT_Values.NF,
                    ItemList.Electric_Pump_EV.get(1L), 180, 1920);
            RA.addComponentAssemblerRecipe(new ItemStack[]{ItemList.Electric_Motor_IV.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.ring, Materials.Silicone, 2),
                            GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.TungstenSteel, 1),
                            GT_OreDictUnificator.get(OrePrefixes.screw, Materials.TungstenSteel, 1),
                            GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Tungsten, 1),
                            GT_OreDictUnificator.get(OrePrefixes.pipeMedium, Materials.TungstenSteel, 1)},
                    GT_Values.NF, ItemList.Electric_Pump_IV.get(1L), 200, 7680);
            RA.addComponentAssemblerRecipe(new ItemStack[]{ItemList.Electric_Motor_IV.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.ring, Materials.StyreneButadieneRubber, 2),
                            GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.TungstenSteel, 1),
                            GT_OreDictUnificator.get(OrePrefixes.screw, Materials.TungstenSteel, 1),
                            GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Tungsten, 1),
                            GT_OreDictUnificator.get(OrePrefixes.pipeMedium, Materials.TungstenSteel, 1)},
                    GT_Values.NF, ItemList.Electric_Pump_IV.get(1L), 200, 7680);

            //Conveyors
            RA.addComponentAssemblerRecipe(new ItemStack[]{GT_ItemList.ULVMotor.get(2L),
                            GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Rubber, 6),
                            GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Lead, 1)}, GT_Values.NF,
                    GT_ItemList.ULVConveyorModule.get(1L), 40, 4);
            RA.addComponentAssemblerRecipe(new ItemStack[]{GT_ItemList.ULVMotor.get(2L),
                            GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Silicone, 6),
                            GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Lead, 1)}, GT_Values.NF,
                    GT_ItemList.ULVConveyorModule.get(1L), 40, 4);
            RA.addComponentAssemblerRecipe(new ItemStack[]{GT_ItemList.ULVMotor.get(2L),
                            GT_OreDictUnificator.get(OrePrefixes.plate, Materials.StyreneButadieneRubber, 6),
                            GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Lead, 1)}, GT_Values.NF,
                    GT_ItemList.ULVConveyorModule.get(1L), 40, 4);
            RA.addComponentAssemblerRecipe(new ItemStack[]{ItemList.Electric_Motor_LV.get(2L),
                            GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Rubber, 6),
                            GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Tin, 1)}, GT_Values.NF,
                    ItemList.Conveyor_Module_LV.get(1L), 80, 30);
            RA.addComponentAssemblerRecipe(new ItemStack[]{ItemList.Electric_Motor_LV.get(2L),
                            GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Silicone, 6),
                            GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Tin, 1)}, GT_Values.NF,
                    ItemList.Conveyor_Module_LV.get(1L), 80, 30);
            RA.addComponentAssemblerRecipe(new ItemStack[]{ItemList.Electric_Motor_LV.get(2L),
                            GT_OreDictUnificator.get(OrePrefixes.plate, Materials.StyreneButadieneRubber, 6),
                            GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Tin, 1)}, GT_Values.NF,
                    ItemList.Conveyor_Module_LV.get(1L), 80, 30);
            RA.addComponentAssemblerRecipe(new ItemStack[]{ItemList.Electric_Motor_MV.get(2L),
                            GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Rubber, 6),
                            GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Copper, 1)}, GT_Values.NF,
                    ItemList.Conveyor_Module_MV.get(1L), 120, 120);
            RA.addComponentAssemblerRecipe(new ItemStack[]{ItemList.Electric_Motor_MV.get(2L),
                            GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Silicone, 6),
                            GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Copper, 1)}, GT_Values.NF,
                    ItemList.Conveyor_Module_MV.get(1L), 120, 120);
            RA.addComponentAssemblerRecipe(new ItemStack[]{ItemList.Electric_Motor_MV.get(2L),
                            GT_OreDictUnificator.get(OrePrefixes.plate, Materials.StyreneButadieneRubber, 6),
                            GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Copper, 1)}, GT_Values.NF,
                    ItemList.Conveyor_Module_MV.get(1L), 120, 120);
            RA.addComponentAssemblerRecipe(new ItemStack[]{ItemList.Electric_Motor_HV.get(2L),
                            GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Rubber, 6),
                            GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Gold, 1)}, GT_Values.NF,
                    ItemList.Conveyor_Module_HV.get(1L), 160, 480);
            RA.addComponentAssemblerRecipe(new ItemStack[]{ItemList.Electric_Motor_HV.get(2L),
                            GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Silicone, 6),
                            GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Gold, 1)}, GT_Values.NF,
                    ItemList.Conveyor_Module_HV.get(1L), 160, 480);
            RA.addComponentAssemblerRecipe(new ItemStack[]{ItemList.Electric_Motor_HV.get(2L),
                            GT_OreDictUnificator.get(OrePrefixes.plate, Materials.StyreneButadieneRubber, 6),
                            GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Gold, 1)}, GT_Values.NF,
                    ItemList.Conveyor_Module_HV.get(1L), 160, 480);
            RA.addComponentAssemblerRecipe(new ItemStack[]{ItemList.Electric_Motor_EV.get(2L),
                            GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Silicone, 6),
                            GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Aluminium, 1)}, GT_Values.NF,
                    ItemList.Conveyor_Module_EV.get(1L), 180, 1920);
            RA.addComponentAssemblerRecipe(new ItemStack[]{ItemList.Electric_Motor_EV.get(2L),
                            GT_OreDictUnificator.get(OrePrefixes.plate, Materials.StyreneButadieneRubber, 6),
                            GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Aluminium, 1)}, GT_Values.NF,
                    ItemList.Conveyor_Module_EV.get(1L), 180, 1920);
            RA.addComponentAssemblerRecipe(new ItemStack[]{ItemList.Electric_Motor_IV.get(2L),
                            GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Silicone, 6),
                            GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Tungsten, 1)}, GT_Values.NF,
                    ItemList.Conveyor_Module_IV.get(1L), 200, 7680);
            RA.addComponentAssemblerRecipe(new ItemStack[]{ItemList.Electric_Motor_IV.get(2L),
                            GT_OreDictUnificator.get(OrePrefixes.plate, Materials.StyreneButadieneRubber, 6),
                            GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Tungsten, 1)}, GT_Values.NF,
                    ItemList.Conveyor_Module_IV.get(1L), 200, 7680);

            //Pistons
            RA.addComponentAssemblerRecipe(new ItemStack[]{GT_ItemList.ULVMotor.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.plate, Materials.WroughtIron, 2),
                            GT_OreDictUnificator.get(OrePrefixes.stick, Materials.WroughtIron, 2),
                            GT_OreDictUnificator.get(OrePrefixes.gearGtSmall, Materials.WroughtIron, 1)},
                    GT_Values.NF, GT_ItemList.ULVPiston.get(1L), 40, 8);
            RA.addComponentAssemblerRecipe(new ItemStack[]{ItemList.Electric_Motor_LV.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Steel, 3),
                            GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Steel, 2),
                            GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Tin, 2),
                            GT_OreDictUnificator.get(OrePrefixes.gearGtSmall, Materials.Steel, 1)}, GT_Values.NF,
                    ItemList.Electric_Piston_LV.get(1L), 80, 30);
            RA.addComponentAssemblerRecipe(new ItemStack[]{ItemList.Electric_Motor_MV.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Aluminium, 3),
                            GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Aluminium, 2),
                            GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Copper, 2),
                            GT_OreDictUnificator.get(OrePrefixes.gearGtSmall, Materials.Aluminium, 1)}, GT_Values.NF,
                    ItemList.Electric_Piston_MV.get(1L), 120, 120);
            RA.addComponentAssemblerRecipe(new ItemStack[]{ItemList.Electric_Motor_HV.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.plate, Materials.StainlessSteel, 3),
                            GT_OreDictUnificator.get(OrePrefixes.stick, Materials.StainlessSteel, 2),
                            GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Gold, 2),
                            GT_OreDictUnificator.get(OrePrefixes.gearGtSmall, Materials.StainlessSteel, 1)},
                    GT_Values.NF, ItemList.Electric_Piston_HV.get(1L), 160, 480);
            RA.addComponentAssemblerRecipe(new ItemStack[]{ItemList.Electric_Motor_EV.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Titanium, 3),
                            GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Titanium, 2),
                            GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Aluminium, 2),
                            GT_OreDictUnificator.get(OrePrefixes.gearGtSmall, Materials.Titanium, 1)}, GT_Values.NF,
                    ItemList.Electric_Piston_EV.get(1L), 180, 1920);
            RA.addComponentAssemblerRecipe(new ItemStack[]{ItemList.Electric_Motor_IV.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.plate, Materials.TungstenSteel, 3),
                            GT_OreDictUnificator.get(OrePrefixes.stick, Materials.TungstenSteel, 2),
                            GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Tungsten, 2),
                            GT_OreDictUnificator.get(OrePrefixes.gearGtSmall, Materials.TungstenSteel, 1)},
                    GT_Values.NF, ItemList.Electric_Piston_IV.get(1L), 200, 7680);

            //Robot Arms
            RA.addComponentAssemblerRecipe(
                    new ItemStack[]{GT_ItemList.ULVMotor.get(2L), GT_ItemList.ULVPiston.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.stick, Materials.WroughtIron, 2),
                            GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Primitive, 1L),
                            GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Lead, 3)}, GT_Values.NF,
                    GT_ItemList.ULVRobotArm.get(1L), 40, 8);
            RA.addComponentAssemblerRecipe(
                    new ItemStack[]{ItemList.Electric_Motor_LV.get(2L), ItemList.Electric_Piston_LV.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Steel, 2),
                            GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Basic, 1L),
                            GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Tin, 3)}, GT_Values.NF,
                    ItemList.Robot_Arm_LV.get(1L), 80, 30);
            RA.addComponentAssemblerRecipe(
                    new ItemStack[]{ItemList.Electric_Motor_MV.get(2L), ItemList.Electric_Piston_MV.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Aluminium, 2),
                            GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Good, 1L),
                            GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Copper, 3)}, GT_Values.NF,
                    ItemList.Robot_Arm_MV.get(1L), 120, 120);
            RA.addComponentAssemblerRecipe(
                    new ItemStack[]{ItemList.Electric_Motor_HV.get(2L), ItemList.Electric_Piston_HV.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.stick, Materials.StainlessSteel, 2),
                            GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Advanced, 1L),
                            GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Gold, 3)}, GT_Values.NF,
                    ItemList.Robot_Arm_HV.get(1L), 160, 480);
            RA.addComponentAssemblerRecipe(
                    new ItemStack[]{ItemList.Electric_Motor_EV.get(2L), ItemList.Electric_Piston_EV.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Titanium, 2),
                            GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Data, 1L),
                            GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Aluminium, 3)},
                    GT_Values.NF, ItemList.Robot_Arm_EV.get(1L), 180, 1920);
            RA.addComponentAssemblerRecipe(
                    new ItemStack[]{ItemList.Electric_Motor_IV.get(2L), ItemList.Electric_Piston_IV.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.stick, Materials.TungstenSteel, 2),
                            GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Elite, 1L),
                            GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Tungsten, 3)}, GT_Values.NF,
                    ItemList.Robot_Arm_IV.get(1L), 200, 7680);

            //Emitter
            RA.addComponentAssemblerRecipe(
                    new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.gem, Materials.CertusQuartz, 1),
                            GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Brass, 4),
                            GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Basic, 2L),
                            GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Tin, 2)}, GT_Values.NF,
                    ItemList.Emitter_LV.get(1L), 80, 30);
            RA.addComponentAssemblerRecipe(
                    new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.gem, Materials.Quartzite, 1),
                            GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Brass, 4),
                            GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Basic, 2L),
                            GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Tin, 2)}, GT_Values.NF,
                    ItemList.Emitter_LV.get(1L), 80, 30);
            RA.addComponentAssemblerRecipe(
                    new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.gem, Materials.NetherQuartz, 1),
                            GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Electrum, 4),
                            GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Good, 2L),
                            GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Copper, 2)}, GT_Values.NF,
                    ItemList.Emitter_MV.get(1L), 120, 120);
            RA.addComponentAssemblerRecipe(
                    new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.gemFlawed, Materials.Emerald, 1),
                            GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Chrome, 4),
                            GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Advanced, 2L),
                            GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Gold, 2)}, GT_Values.NF,
                    ItemList.Emitter_HV.get(1L), 160, 480);
            RA.addComponentAssemblerRecipe(
                    new ItemStack[]{CoreItems2.getRecipe(ChargedGlassLense.getMetaID(), 1),
                            GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Platinum, 4),
                            GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Data, 2L),
                            GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Aluminium, 2)},
                    GT_Values.NF, ItemList.Emitter_EV.get(1L), 180, 1920);
            RA.addComponentAssemblerRecipe(
                    new ItemStack[]{CoreItems2.getRecipe(HugeChargedGlassLense.getMetaID(), 1),
                            GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Iridium, 4),
                            GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Elite, 2L),
                            GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Tungsten, 2)}, GT_Values.NF,
                    ItemList.Emitter_IV.get(1L), 200, 7680);

            //Sensor
            RA.addComponentAssemblerRecipe(
                    new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.gem, Materials.CertusQuartz, 1),
                            GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Steel, 4),
                            GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Brass, 1),
                            GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Basic, 1L),}, GT_Values.NF,
                    ItemList.Sensor_LV.get(1L), 80, 30);
            RA.addComponentAssemblerRecipe(
                    new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.gem, Materials.Quartzite, 1),
                            GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Steel, 4),
                            GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Brass, 1),
                            GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Basic, 1L),}, GT_Values.NF,
                    ItemList.Sensor_LV.get(1L), 80, 30);
            RA.addComponentAssemblerRecipe(
                    new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.gem, Materials.NetherQuartz, 1),
                            GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Aluminium, 4),
                            GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Electrum, 1),
                            GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Good, 1L),}, GT_Values.NF,
                    ItemList.Sensor_MV.get(1L), 120, 120);
            RA.addComponentAssemblerRecipe(
                    new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.gemFlawed, Materials.Emerald, 1),
                            GT_OreDictUnificator.get(OrePrefixes.plate, Materials.StainlessSteel, 4),
                            GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Chrome, 1),
                            GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Advanced, 1L),}, GT_Values.NF,
                    ItemList.Sensor_HV.get(1L), 160, 480);
            RA.addComponentAssemblerRecipe(
                    new ItemStack[]{CoreItems2.getRecipe(ChargedGlassLense.getMetaID(), 1),
                            GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Titanium, 4),
                            GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Platinum, 1),
                            GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Data, 1L),}, GT_Values.NF,
                    ItemList.Sensor_EV.get(1L), 180, 1920);
            RA.addComponentAssemblerRecipe(
                    new ItemStack[]{CoreItems2.getRecipe(HugeChargedGlassLense.getMetaID(), 1),
                            GT_OreDictUnificator.get(OrePrefixes.plate, Materials.TungstenSteel, 4),
                            GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Iridium, 1),
                            GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Elite, 1L),}, GT_Values.NF,
                    ItemList.Sensor_IV.get(1L), 200, 7680);

            //FieldGenerators
            RA.addComponentAssemblerRecipe(new ItemStack[]{ItemList.Emitter_LV.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Good, 4),
                            GT_OreDictUnificator.get(OrePrefixes.plate, Materials.RedSteel, 4)}, null,
                    ItemList.Field_Generator_LV.get(1), 80, 30);
            RA.addComponentAssemblerRecipe(new ItemStack[]{ItemList.Emitter_MV.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Advanced, 4),
                            GT_OreDictUnificator.get(OrePrefixes.plate, Materials.BT6, 4)}, null,
                    ItemList.Field_Generator_MV.get(1), 120, 120);
            RA.addComponentAssemblerRecipe(new ItemStack[]{ItemList.Emitter_HV.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Data, 4),
                            GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.HSSG, 4)}, null,
                    ItemList.Field_Generator_HV.get(1), 160, 480);
            RA.addComponentAssemblerRecipe(new ItemStack[]{ItemList.Emitter_EV.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Elite, 4),
                            GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.NiobiumTitanium, 4)}, null,
                    ItemList.Field_Generator_EV.get(1), 160, 1920);
            RA.addComponentAssemblerRecipe(new ItemStack[]{ItemList.Emitter_IV.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Master, 4),
                            GT_OreDictUnificator.get(OrePrefixes.plateTriple, Materials.HSSS, 4)}, null,
                    ItemList.Field_Generator_IV.get(1L), 200, 7680);

        }
    }

    private void brewery() {
        RA.addBrewingRecipeCustom(CoreItems2.getRecipe(152, 1),
                Materials.GrowthMediumRaw.getFluid(2000), Materials.Bacteria.getFluid(2000), 600, 1920,
                false);

        RA.addBrewingRecipeCustom(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.AlienOrganic, 1),
                Materials.Bacteria.getFluid(1000), Materials.AlienBiomass.getFluid(1000), 200, 122880,
                false);
    }

    private void arcFurnace() {
        RA.addArcFurnaceRecipe(ItemList.Casing_BronzePlatedBricks.get(1),
                new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Bronze, 4),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Stone, 1)}, null, 160, 96);

    }

    private void assembler() {
        if (!(GT_Mod.gregtechproxy.mComponentAssembler)) {

            //Motors
            RA.addAssemblerRecipe(
                    new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.IronMagnetic, 1L),
                            GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Iron, 2L),
                            GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Tin, 4L),
                            GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Lead, 2L)}, GT_Values.NF,
                    GT_ItemList.ULVMotor.get(1L), 100, 8);
            RA.addAssemblerRecipe(
                    new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.stick, Materials.IronMagnetic, 1L),
                            GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Iron, 2L),
                            GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.Copper, 4L),
                            GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Tin, 2L)}, GT_Values.NF,
                    ItemList.Electric_Motor_LV.get(1L), 200, 30);
            RA.addAssemblerRecipe(
                    new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.stick, Materials.SteelMagnetic, 1L),
                            GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Steel, 2L),
                            GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.Copper, 4L),
                            GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Tin, 2L)}, GT_Values.NF,
                    ItemList.Electric_Motor_LV.get(1L), 200, 30);
            RA.addAssemblerRecipe(
                    new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.stick, Materials.SteelMagnetic, 1L),
                            GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Aluminium, 2L),
                            GT_OreDictUnificator.get(OrePrefixes.wireGt02, Materials.Cupronickel, 4L),
                            GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Copper, 2L)}, GT_Values.NF,
                    ItemList.Electric_Motor_MV.get(1L), 200, 30);
            RA.addAssemblerRecipe(
                    new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.stick, Materials.SteelMagnetic, 1L),
                            GT_OreDictUnificator.get(OrePrefixes.stick, Materials.StainlessSteel, 2L),
                            GT_OreDictUnificator.get(OrePrefixes.wireGt02, Materials.Electrum, 4L),
                            GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Silver, 2L)}, GT_Values.NF,
                    ItemList.Electric_Motor_HV.get(1L), 200, 30);
            RA.addAssemblerRecipe(new ItemStack[]{
                            GT_OreDictUnificator.get(OrePrefixes.stick, Materials.NeodymiumMagnetic, 1L),
                            GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Titanium, 2L),
                            GT_OreDictUnificator.get(OrePrefixes.wireGt02, Materials.AnnealedCopper, 4L),
                            GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Aluminium, 2L)}, GT_Values.NF,
                    ItemList.Electric_Motor_EV.get(1L), 200, 30);
            RA.addAssemblerRecipe(new ItemStack[]{
                            GT_OreDictUnificator.get(OrePrefixes.stick, Materials.NeodymiumMagnetic, 1L),
                            GT_OreDictUnificator.get(OrePrefixes.stick, Materials.TungstenSteel, 2L),
                            GT_OreDictUnificator.get(OrePrefixes.wireGt02, Materials.Graphene, 4L),
                            GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Tungsten, 2L)}, GT_Values.NF,
                    ItemList.Electric_Motor_IV.get(1L), 200, 30);

            //Pumps
            RA.addAssemblerRecipe(new ItemStack[]{GT_ItemList.ULVMotor.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.ring, Materials.Rubber, 2),
                            GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.Lead, 1),
                            GT_OreDictUnificator.get(OrePrefixes.screw, Materials.Lead, 2),
                            GT_OreDictUnificator.get(OrePrefixes.pipeMedium, Materials.Copper, 1)}, GT_Values.NF,
                    GT_ItemList.ULVPump.get(1L), 100, 8);
            RA.addAssemblerRecipe(new ItemStack[]{ItemList.Electric_Motor_LV.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.ring, Materials.Rubber, 2),
                            GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.Tin, 1),
                            GT_OreDictUnificator.get(OrePrefixes.screw, Materials.Tin, 1),
                            GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Tin, 1),
                            GT_OreDictUnificator.get(OrePrefixes.pipeMedium, Materials.Bronze, 1)}, GT_Values.NF,
                    ItemList.Electric_Pump_LV.get(1L), 200, 30);
            RA.addAssemblerRecipe(new ItemStack[]{ItemList.Electric_Motor_LV.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.ring, Materials.Silicone, 2),
                            GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.Tin, 1),
                            GT_OreDictUnificator.get(OrePrefixes.screw, Materials.Tin, 1),
                            GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Tin, 1),
                            GT_OreDictUnificator.get(OrePrefixes.pipeMedium, Materials.Bronze, 1)}, GT_Values.NF,
                    ItemList.Electric_Pump_LV.get(1L), 200, 30);
            RA.addAssemblerRecipe(new ItemStack[]{ItemList.Electric_Motor_LV.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.ring, Materials.StyreneButadieneRubber, 2),
                            GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.Tin, 1),
                            GT_OreDictUnificator.get(OrePrefixes.screw, Materials.Tin, 1),
                            GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Tin, 1),
                            GT_OreDictUnificator.get(OrePrefixes.pipeMedium, Materials.Bronze, 1)}, GT_Values.NF,
                    ItemList.Electric_Pump_LV.get(1L), 200, 30);
            RA.addAssemblerRecipe(new ItemStack[]{ItemList.Electric_Motor_MV.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.ring, Materials.Rubber, 2),
                            GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.Bronze, 1),
                            GT_OreDictUnificator.get(OrePrefixes.screw, Materials.Bronze, 1),
                            GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Copper, 1),
                            GT_OreDictUnificator.get(OrePrefixes.pipeMedium, Materials.Steel, 1)}, GT_Values.NF,
                    ItemList.Electric_Pump_MV.get(1L), 200, 60);
            RA.addAssemblerRecipe(new ItemStack[]{ItemList.Electric_Motor_MV.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.ring, Materials.Silicone, 2),
                            GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.Bronze, 1),
                            GT_OreDictUnificator.get(OrePrefixes.screw, Materials.Bronze, 1),
                            GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Copper, 1),
                            GT_OreDictUnificator.get(OrePrefixes.pipeMedium, Materials.Steel, 1)}, GT_Values.NF,
                    ItemList.Electric_Pump_MV.get(1L), 200, 60);
            RA.addAssemblerRecipe(new ItemStack[]{ItemList.Electric_Motor_MV.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.ring, Materials.StyreneButadieneRubber, 2),
                            GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.Bronze, 1),
                            GT_OreDictUnificator.get(OrePrefixes.screw, Materials.Bronze, 1),
                            GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Copper, 1),
                            GT_OreDictUnificator.get(OrePrefixes.pipeMedium, Materials.Steel, 1)}, GT_Values.NF,
                    ItemList.Electric_Pump_MV.get(1L), 200, 60);
            RA.addAssemblerRecipe(new ItemStack[]{ItemList.Electric_Motor_HV.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.ring, Materials.Rubber, 2),
                            GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.Steel, 1),
                            GT_OreDictUnificator.get(OrePrefixes.screw, Materials.Steel, 1),
                            GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Gold, 1),
                            GT_OreDictUnificator.get(OrePrefixes.pipeMedium, Materials.StainlessSteel, 1)},
                    GT_Values.NF, ItemList.Electric_Pump_HV.get(1L), 200, 120);
            RA.addAssemblerRecipe(new ItemStack[]{ItemList.Electric_Motor_HV.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.ring, Materials.Silicone, 2),
                            GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.Steel, 1),
                            GT_OreDictUnificator.get(OrePrefixes.screw, Materials.Steel, 1),
                            GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Gold, 1),
                            GT_OreDictUnificator.get(OrePrefixes.pipeMedium, Materials.StainlessSteel, 1)},
                    GT_Values.NF, ItemList.Electric_Pump_HV.get(1L), 200, 120);
            RA.addAssemblerRecipe(new ItemStack[]{ItemList.Electric_Motor_HV.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.ring, Materials.StyreneButadieneRubber, 2),
                            GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.Steel, 1),
                            GT_OreDictUnificator.get(OrePrefixes.screw, Materials.Steel, 1),
                            GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Gold, 1),
                            GT_OreDictUnificator.get(OrePrefixes.pipeMedium, Materials.StainlessSteel, 1)},
                    GT_Values.NF, ItemList.Electric_Pump_HV.get(1L), 200, 120);
            RA.addAssemblerRecipe(new ItemStack[]{ItemList.Electric_Motor_EV.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.ring, Materials.Rubber, 2),
                            GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.StainlessSteel, 1),
                            GT_OreDictUnificator.get(OrePrefixes.screw, Materials.StainlessSteel, 1),
                            GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Aluminium, 1),
                            GT_OreDictUnificator.get(OrePrefixes.pipeMedium, Materials.HSLA, 1)}, GT_Values.NF,
                    ItemList.Electric_Pump_EV.get(1L), 200, 240);
            RA.addAssemblerRecipe(new ItemStack[]{ItemList.Electric_Motor_EV.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.ring, Materials.Silicone, 2),
                            GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.StainlessSteel, 1),
                            GT_OreDictUnificator.get(OrePrefixes.screw, Materials.StainlessSteel, 1),
                            GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Aluminium, 1),
                            GT_OreDictUnificator.get(OrePrefixes.pipeMedium, Materials.HSLA, 1)}, GT_Values.NF,
                    ItemList.Electric_Pump_EV.get(1L), 200, 240);
            RA.addAssemblerRecipe(new ItemStack[]{ItemList.Electric_Motor_EV.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.ring, Materials.StyreneButadieneRubber, 2),
                            GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.StainlessSteel, 1),
                            GT_OreDictUnificator.get(OrePrefixes.screw, Materials.StainlessSteel, 1),
                            GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Aluminium, 1),
                            GT_OreDictUnificator.get(OrePrefixes.pipeMedium, Materials.HSLA, 1)}, GT_Values.NF,
                    ItemList.Electric_Pump_EV.get(1L), 200, 240);
            RA.addAssemblerRecipe(new ItemStack[]{ItemList.Electric_Motor_IV.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.ring, Materials.Silicone, 2),
                            GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.TungstenSteel, 1),
                            GT_OreDictUnificator.get(OrePrefixes.screw, Materials.TungstenSteel, 1),
                            GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Tungsten, 1),
                            GT_OreDictUnificator.get(OrePrefixes.pipeMedium, Materials.TungstenSteel, 1)},
                    GT_Values.NF, ItemList.Electric_Pump_IV.get(1L), 200, 480);
            RA.addAssemblerRecipe(new ItemStack[]{ItemList.Electric_Motor_IV.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.ring, Materials.StyreneButadieneRubber, 2),
                            GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.TungstenSteel, 1),
                            GT_OreDictUnificator.get(OrePrefixes.screw, Materials.TungstenSteel, 1),
                            GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Tungsten, 1),
                            GT_OreDictUnificator.get(OrePrefixes.pipeMedium, Materials.TungstenSteel, 1)},
                    GT_Values.NF, ItemList.Electric_Pump_IV.get(1L), 200, 480);

            //Conveyors
            RA.addAssemblerRecipe(new ItemStack[]{GT_ItemList.ULVMotor.get(2L),
                            GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Rubber, 6),
                            GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Lead, 1)}, GT_Values.NF,
                    GT_ItemList.ULVConveyorModule.get(1L), 40, 4);
            RA.addAssemblerRecipe(new ItemStack[]{ItemList.Electric_Motor_LV.get(2L),
                            GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Rubber, 6),
                            GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Tin, 1)}, GT_Values.NF,
                    ItemList.Conveyor_Module_LV.get(1L), 200, 30);
            RA.addAssemblerRecipe(new ItemStack[]{ItemList.Electric_Motor_LV.get(2L),
                            GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Silicone, 6),
                            GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Tin, 1)}, GT_Values.NF,
                    ItemList.Conveyor_Module_LV.get(1L), 200, 30);
            RA.addAssemblerRecipe(new ItemStack[]{ItemList.Electric_Motor_LV.get(2L),
                            GT_OreDictUnificator.get(OrePrefixes.plate, Materials.StyreneButadieneRubber, 6),
                            GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Tin, 1)}, GT_Values.NF,
                    ItemList.Conveyor_Module_LV.get(1L), 200, 30);
            RA.addAssemblerRecipe(new ItemStack[]{ItemList.Electric_Motor_MV.get(2L),
                            GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Rubber, 6),
                            GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Copper, 1)}, GT_Values.NF,
                    ItemList.Conveyor_Module_MV.get(1L), 200, 60);
            RA.addAssemblerRecipe(new ItemStack[]{ItemList.Electric_Motor_MV.get(2L),
                            GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Silicone, 6),
                            GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Copper, 1)}, GT_Values.NF,
                    ItemList.Conveyor_Module_MV.get(1L), 200, 60);
            RA.addAssemblerRecipe(new ItemStack[]{ItemList.Electric_Motor_MV.get(2L),
                            GT_OreDictUnificator.get(OrePrefixes.plate, Materials.StyreneButadieneRubber, 6),
                            GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Copper, 1)}, GT_Values.NF,
                    ItemList.Conveyor_Module_MV.get(1L), 200, 60);
            RA.addAssemblerRecipe(new ItemStack[]{ItemList.Electric_Motor_HV.get(2L),
                            GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Rubber, 6),
                            GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Gold, 1)}, GT_Values.NF,
                    ItemList.Conveyor_Module_HV.get(1L), 200, 120);
            RA.addAssemblerRecipe(new ItemStack[]{ItemList.Electric_Motor_HV.get(2L),
                            GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Silicone, 6),
                            GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Gold, 1)}, GT_Values.NF,
                    ItemList.Conveyor_Module_HV.get(1L), 200, 120);
            RA.addAssemblerRecipe(new ItemStack[]{ItemList.Electric_Motor_HV.get(2L),
                            GT_OreDictUnificator.get(OrePrefixes.plate, Materials.StyreneButadieneRubber, 6),
                            GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Gold, 1)}, GT_Values.NF,
                    ItemList.Conveyor_Module_HV.get(1L), 200, 120);
            RA.addAssemblerRecipe(new ItemStack[]{ItemList.Electric_Motor_EV.get(2L),
                            GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Silicone, 6),
                            GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Aluminium, 1)}, GT_Values.NF,
                    ItemList.Conveyor_Module_EV.get(1L), 200, 240);
            RA.addAssemblerRecipe(new ItemStack[]{ItemList.Electric_Motor_EV.get(2L),
                            GT_OreDictUnificator.get(OrePrefixes.plate, Materials.StyreneButadieneRubber, 6),
                            GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Aluminium, 1)}, GT_Values.NF,
                    ItemList.Conveyor_Module_EV.get(1L), 200, 240);
            RA.addAssemblerRecipe(new ItemStack[]{ItemList.Electric_Motor_IV.get(2L),
                            GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Silicone, 6),
                            GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Tungsten, 1)}, GT_Values.NF,
                    ItemList.Conveyor_Module_IV.get(1L), 200, 480);
            RA.addAssemblerRecipe(new ItemStack[]{ItemList.Electric_Motor_IV.get(2L),
                            GT_OreDictUnificator.get(OrePrefixes.plate, Materials.StyreneButadieneRubber, 6),
                            GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Tungsten, 1)}, GT_Values.NF,
                    ItemList.Conveyor_Module_IV.get(1L), 200, 480);

            //Pistons
            RA.addAssemblerRecipe(new ItemStack[]{GT_ItemList.ULVMotor.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.plate, Materials.WroughtIron, 2),
                            GT_OreDictUnificator.get(OrePrefixes.stick, Materials.WroughtIron, 2),
                            GT_OreDictUnificator.get(OrePrefixes.gearGtSmall, Materials.WroughtIron, 1)},
                    GT_Values.NF, GT_ItemList.ULVPiston.get(1L), 100, 8);
            RA.addAssemblerRecipe(new ItemStack[]{ItemList.Electric_Motor_LV.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Steel, 3),
                            GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Steel, 2),
                            GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Tin, 2),
                            GT_OreDictUnificator.get(OrePrefixes.gearGtSmall, Materials.Steel, 1)}, GT_Values.NF,
                    ItemList.Electric_Piston_LV.get(1L), 200, 30);
            RA.addAssemblerRecipe(new ItemStack[]{ItemList.Electric_Motor_MV.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Aluminium, 3),
                            GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Aluminium, 2),
                            GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Copper, 2),
                            GT_OreDictUnificator.get(OrePrefixes.gearGtSmall, Materials.Aluminium, 1)}, GT_Values.NF,
                    ItemList.Electric_Piston_MV.get(1L), 200, 60);
            RA.addAssemblerRecipe(new ItemStack[]{ItemList.Electric_Motor_HV.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.plate, Materials.StainlessSteel, 3),
                            GT_OreDictUnificator.get(OrePrefixes.stick, Materials.StainlessSteel, 2),
                            GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Gold, 2),
                            GT_OreDictUnificator.get(OrePrefixes.gearGtSmall, Materials.StainlessSteel, 1)},
                    GT_Values.NF, ItemList.Electric_Piston_HV.get(1L), 200, 120);
            RA.addAssemblerRecipe(new ItemStack[]{ItemList.Electric_Motor_EV.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Titanium, 3),
                            GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Titanium, 2),
                            GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Aluminium, 2),
                            GT_OreDictUnificator.get(OrePrefixes.gearGtSmall, Materials.Titanium, 1)}, GT_Values.NF,
                    ItemList.Electric_Piston_EV.get(1L), 200, 240);
            RA.addAssemblerRecipe(new ItemStack[]{ItemList.Electric_Motor_IV.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.plate, Materials.TungstenSteel, 3),
                            GT_OreDictUnificator.get(OrePrefixes.stick, Materials.TungstenSteel, 2),
                            GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Tungsten, 2),
                            GT_OreDictUnificator.get(OrePrefixes.gearGtSmall, Materials.TungstenSteel, 1)},
                    GT_Values.NF, ItemList.Electric_Piston_IV.get(1L), 200, 480);

            //Robot Arms
            RA.addAssemblerRecipe(
                    new ItemStack[]{GT_ItemList.ULVMotor.get(2L), GT_ItemList.ULVPiston.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.stick, Materials.WroughtIron, 2),
                            GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Primitive, 1L),
                            GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Lead, 3)}, GT_Values.NF,
                    GT_ItemList.ULVRobotArm.get(1L), 100, 8);
            RA.addAssemblerRecipe(
                    new ItemStack[]{ItemList.Electric_Motor_LV.get(2L), ItemList.Electric_Piston_LV.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Steel, 2),
                            GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Basic, 1L),
                            GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Tin, 3)}, GT_Values.NF,
                    ItemList.Robot_Arm_LV.get(1L), 200, 30);
            RA.addAssemblerRecipe(
                    new ItemStack[]{ItemList.Electric_Motor_MV.get(2L), ItemList.Electric_Piston_MV.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Aluminium, 2),
                            GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Good, 1L),
                            GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Copper, 3)}, GT_Values.NF,
                    ItemList.Robot_Arm_MV.get(1L), 200, 60);
            RA.addAssemblerRecipe(
                    new ItemStack[]{ItemList.Electric_Motor_HV.get(2L), ItemList.Electric_Piston_HV.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.stick, Materials.StainlessSteel, 2),
                            GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Advanced, 1L),
                            GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Gold, 3)}, GT_Values.NF,
                    ItemList.Robot_Arm_HV.get(1L), 200, 120);
            RA.addAssemblerRecipe(
                    new ItemStack[]{ItemList.Electric_Motor_EV.get(2L), ItemList.Electric_Piston_EV.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Titanium, 2),
                            GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Data, 1L),
                            GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Aluminium, 3)},
                    GT_Values.NF, ItemList.Robot_Arm_EV.get(1L), 200, 240);
            RA.addAssemblerRecipe(
                    new ItemStack[]{ItemList.Electric_Motor_IV.get(2L), ItemList.Electric_Piston_IV.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.stick, Materials.TungstenSteel, 2),
                            GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Elite, 1L),
                            GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Tungsten, 3)}, GT_Values.NF,
                    ItemList.Robot_Arm_IV.get(1L), 200, 480);

            //Emitter
            RA.addAssemblerRecipe(
                    new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.gem, Materials.CertusQuartz, 1),
                            GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Brass, 4),
                            GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Basic, 2L),
                            GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Tin, 2)}, GT_Values.NF,
                    ItemList.Emitter_LV.get(1L), 200, 30);
            RA.addAssemblerRecipe(
                    new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.gem, Materials.Quartzite, 1),
                            GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Brass, 4),
                            GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Basic, 2L),
                            GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Tin, 2)}, GT_Values.NF,
                    ItemList.Emitter_LV.get(1L), 200, 30);
            RA.addAssemblerRecipe(
                    new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.gem, Materials.NetherQuartz, 1),
                            GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Electrum, 4),
                            GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Good, 2L),
                            GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Copper, 2)}, GT_Values.NF,
                    ItemList.Emitter_MV.get(1L), 200, 60);
            RA.addAssemblerRecipe(
                    new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.gemFlawed, Materials.Emerald, 1),
                            GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Chrome, 4),
                            GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Advanced, 2L),
                            GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Gold, 2)}, GT_Values.NF,
                    ItemList.Emitter_HV.get(1L), 200, 120);
            RA.addAssemblerRecipe(
                    new ItemStack[]{CoreItems2.getRecipe(ChargedGlassLense.getMetaID(), 1),
                            GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Platinum, 4),
                            GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Data, 2L),
                            GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Aluminium, 2)},
                    GT_Values.NF, ItemList.Emitter_EV.get(1L), 200, 240);
            RA.addAssemblerRecipe(
                    new ItemStack[]{CoreItems2.getRecipe(HugeChargedGlassLense.getMetaID(), 1),
                            GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Iridium, 4),
                            GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Elite, 2L),
                            GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Tungsten, 2)}, GT_Values.NF,
                    ItemList.Emitter_IV.get(1L), 200, 480);

            //Sensor
            RA.addAssemblerRecipe(
                    new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.gem, Materials.CertusQuartz, 1),
                            GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Steel, 4),
                            GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Brass, 1),
                            GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Basic, 1L),}, GT_Values.NF,
                    ItemList.Sensor_LV.get(1L), 200, 30);
            RA.addAssemblerRecipe(
                    new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.gem, Materials.Quartzite, 1),
                            GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Steel, 4),
                            GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Brass, 1),
                            GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Basic, 1L),}, GT_Values.NF,
                    ItemList.Sensor_LV.get(1L), 200, 30);
            RA.addAssemblerRecipe(
                    new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.gem, Materials.NetherQuartz, 1),
                            GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Aluminium, 4),
                            GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Electrum, 1),
                            GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Good, 1L),}, GT_Values.NF,
                    ItemList.Sensor_MV.get(1L), 200, 60);
            RA.addAssemblerRecipe(
                    new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.gemFlawed, Materials.Emerald, 1),
                            GT_OreDictUnificator.get(OrePrefixes.plate, Materials.StainlessSteel, 4),
                            GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Chrome, 1),
                            GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Advanced, 1L),}, GT_Values.NF,
                    ItemList.Sensor_HV.get(1L), 200, 120);
            RA.addAssemblerRecipe(
                    new ItemStack[]{CoreItems2.getRecipe(ChargedGlassLense.getMetaID(), 1),
                            GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Titanium, 4),
                            GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Platinum, 1),
                            GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Data, 1L),}, GT_Values.NF,
                    ItemList.Sensor_EV.get(1L), 200, 240);
            RA.addAssemblerRecipe(
                    new ItemStack[]{CoreItems2.getRecipe(HugeChargedGlassLense.getMetaID(), 1),
                            GT_OreDictUnificator.get(OrePrefixes.plate, Materials.TungstenSteel, 4),
                            GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Iridium, 1),
                            GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Elite, 1L),}, GT_Values.NF,
                    ItemList.Sensor_IV.get(1L), 200, 480);

            //FieldGenerators
            RA.addAssemblerRecipe(new ItemStack[]{ItemList.Emitter_LV.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Good, 4),
                            GT_OreDictUnificator.get(OrePrefixes.plate, Materials.RedSteel, 4)}, null,
                    ItemList.Field_Generator_LV.get(1), 600, 30);
            RA.addAssemblerRecipe(new ItemStack[]{ItemList.Emitter_MV.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Advanced, 4),
                            GT_OreDictUnificator.get(OrePrefixes.plate, Materials.BT6, 4)}, null,
                    ItemList.Field_Generator_MV.get(1), 600, 120);
            RA.addAssemblerRecipe(new ItemStack[]{ItemList.Emitter_HV.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Data, 4),
                            GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.HSSG, 4)}, null,
                    ItemList.Field_Generator_HV.get(1), 600, 480);
            RA.addAssemblerRecipe(new ItemStack[]{ItemList.Emitter_EV.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Elite, 4),
                            GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.NiobiumTitanium, 4)}, null,
                    ItemList.Field_Generator_EV.get(1), 600, 1920);
            RA.addAssemblerRecipe(new ItemStack[]{ItemList.Emitter_IV.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Master, 4),
                            GT_OreDictUnificator.get(OrePrefixes.plateTriple, Materials.HSSS, 4)}, null,
                    ItemList.Field_Generator_IV.get(1L), 600, 7680);

        }

        //Empty Shape Plate
        RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Steel, 4),
                GT_Utility.getIntegratedCircuit(4), GT_Values.NF, ItemList.Shape_Empty.get(1L), 2 * 20, 8);

        //OilDrill1
        RA.addAssemblerRecipe(
                new ItemStack[]{ItemList.Hull_MV.get(1L), ItemList.Electric_Motor_MV.get(2L),
                        ItemList.Electric_Pump_MV.get(2L),
                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Good, 2),
                        GT_OreDictUnificator.get(OrePrefixes.gearGt, Materials.Steel, 2),
                        GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Steel, 4),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Steel, 8)}, GT_Values.NF,
                ItemList.OilDrill1.get(1L), 20 * 20, 120);

        //Maintenance Hatch
        RA
                .addAssemblerRecipe(ItemList.Casing_LV.get(1), ItemList.Duct_Tape.get(4), GT_Values.NF,
                        ItemList.Hatch_Maintenance.get(1L), 40 * 20, 30);

        //Quadruple Input Hatch
        RA.addAssemblerRecipe(
                new ItemStack[]{ItemList.Hull_EV.get(1), ItemList.Large_Fluid_Cell_Titanium.get(1),
                        GT_OreDictUnificator.get(OrePrefixes.pipeQuadruple, Materials.Titanium, 1L),
                        GT_Utility.getIntegratedCircuit(4)}, Materials.Polytetrafluoroethylene.getMolten(576L),
                GT_ItemList.Quadruple_Input_Hatch.get(1), 480, 1920);
        RA.addAssemblerRecipe(
                new ItemStack[]{ItemList.Hull_EV.get(1), ItemList.Large_Fluid_Cell_Titanium.get(1),
                        GT_OreDictUnificator.get(OrePrefixes.pipeQuadruple, Materials.Titanium, 1L),
                        GT_Utility.getIntegratedCircuit(4)}, Materials.Polybenzimidazole.getMolten(72L),
                GT_ItemList.Quadruple_Input_Hatch.get(1), 480, 1920);
        //Nonuple Input Hatch
        RA.addAssemblerRecipe(
                new ItemStack[]{ItemList.Hull_IV.get(1), ItemList.Large_Fluid_Cell_TungstenSteel.get(1),
                        GT_OreDictUnificator.get(OrePrefixes.pipeNonuple, Materials.TungstenSteel, 1L),
                        GT_Utility.getIntegratedCircuit(9)}, Materials.Polytetrafluoroethylene.getMolten(1152L),
                GT_ItemList.Nonuple_Input_Hatch.get(1), 480, 7680);
        RA.addAssemblerRecipe(
                new ItemStack[]{ItemList.Hull_IV.get(1), ItemList.Large_Fluid_Cell_TungstenSteel.get(1),
                        GT_OreDictUnificator.get(OrePrefixes.pipeNonuple, Materials.TungstenSteel, 1L),
                        GT_Utility.getIntegratedCircuit(9)}, Materials.Polybenzimidazole.getMolten(144L),
                GT_ItemList.Nonuple_Input_Hatch.get(1), 480, 7680);

        //ME Output Hatch
        RA.addAssemblerRecipe(GT_ModHandler.getModItem("appliedenergistics2", "tile.BlockInterface", 1L, 0),
                ItemList.Hatch_Output_Bus_HV.get(1L), ItemList.Hatch_Output_Bus_ME.get(1L), 200, 480);

		//Radiation Proof Casing
		RA.addAssemblerRecipe(
				new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.plateDense, Materials.Lead, 6L), 
						GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.TungstenCarbide, 1L), GT_Utility.getIntegratedCircuit(1)}, 
						Materials.Concrete.getMolten(576L), 
				ItemList.Casing_RadiationProof.get(2L), 600, 120);


        ItemStack[] inHatches = {GT_ItemList.Hatch_Input_UEV.get(1), GT_ItemList.Hatch_Input_UIV.get(1),
                GT_ItemList.Hatch_Input_UMV.get(1), GT_ItemList.Hatch_Input_UXV.get(1),
                GT_ItemList.Hatch_Input_OPV.get(1), GT_ItemList.Hatch_Input_MAX.get(1)};
        ItemStack[] outHatches = {GT_ItemList.Hatch_Output_UEV.get(1),
                GT_ItemList.Hatch_Output_UIV.get(1), GT_ItemList.Hatch_Output_UMV.get(1),
                GT_ItemList.Hatch_Output_UXV.get(1), GT_ItemList.Hatch_Output_OPV.get(1),
                GT_ItemList.Hatch_Output_MAX.get(1)};
        ItemStack[][] flInputs = new ItemStack[6][3];
        ItemStack[][] flInputs2 = new ItemStack[6][3];
        ItemStack[] tanks = {GT_ModHandler.getModItem("gregtech", "gt.blockmachines", 1, 142),
                GT_ModHandler.getModItem("gregtech", "gt.blockmachines", 1, 143),
                GT_ModHandler.getModItem("gregtech", "gt.blockmachines", 1, 144),
                GT_ModHandler.getModItem("gregtech", "gt.blockmachines", 1, 120),
                GT_ModHandler.getModItem("gregtech", "gt.blockmachines", 1, 121),
                GT_ModHandler.getModItem("gregtech", "gt.blockmachines", 1, 122),};
        ItemStack[] hulls = {ItemList.Casing_UEV.get(1), ItemList.Casing_UIV.get(1),
                ItemList.Casing_UMV.get(1), ItemList.Casing_UXV.get(1), ItemList.Casing_OPV.get(1),
                ItemList.Casing_MAXV.get(1),};
        for (int i = 0; i < 6; i++) {
            flInputs[i] = new ItemStack[]{hulls[i].copy(), tanks[i].copy(),
                    GT_Utility.getIntegratedCircuit(1)};
            flInputs2[i] = new ItemStack[]{hulls[i].copy(), tanks[i].copy(),
                    GT_Utility.getIntegratedCircuit(2)};
        }

        //10-15 since MAX crashes., change to 16 somwhen the NEI handler is fixed and MAX is optainable
        for (int aTier = 10; aTier < 15; aTier++) {
            RA.addAssemblerRecipe(flInputs[aTier - 10],
                    Materials.PerroxPolymer.getMolten((long) (2.25 * Math.pow(2, (aTier - 9)))),
                    inHatches[aTier - 10], 480, (int) (30 * Math.pow(4, (aTier - 1))), false);
            RA.addAssemblerRecipe(flInputs2[aTier - 10],
                    Materials.PerroxPolymer.getMolten((long) (2.25 * Math.pow(2, (aTier - 9)))),
                    outHatches[aTier - 10], 480, (int) (30 * Math.pow(4, (aTier - 1))), false);
        }

        ItemStack[] inBuses = {GT_ItemList.Bus_Input_UEV.get(1), GT_ItemList.Bus_Input_UIV.get(1),
                GT_ItemList.Bus_Input_UMV.get(1), GT_ItemList.Bus_Input_UXV.get(1),
                GT_ItemList.Bus_Input_OPV.get(1), GT_ItemList.Bus_Input_MAX.get(1)};
        ItemStack[] outBuses = {GT_ItemList.Bus_Output_UEV.get(1), GT_ItemList.Bus_Output_UIV.get(1),
                GT_ItemList.Bus_Output_UMV.get(1), GT_ItemList.Bus_Output_UXV.get(1),
                GT_ItemList.Bus_Output_OPV.get(1), GT_ItemList.Bus_Output_MAX.get(1)};
        ItemStack[][] itInputs = new ItemStack[6][3];
        ItemStack[][] itInputs2 = new ItemStack[6][3];
        ItemStack[] chests = {GT_ModHandler.getModItem("gregtech", "gt.blockmachines", 1, 147),
                GT_ModHandler.getModItem("gregtech", "gt.blockmachines", 1, 148),
                GT_ModHandler.getModItem("gregtech", "gt.blockmachines", 1, 149),
                GT_ModHandler.getModItem("gregtech", "gt.blockmachines", 1, 127),
                GT_ModHandler.getModItem("gregtech", "gt.blockmachines", 1, 128),
                GT_ModHandler.getModItem("gregtech", "gt.blockmachines", 1, 129),};
        for (int i = 0; i < 6; i++) {
            itInputs[i] = new ItemStack[]{hulls[i].copy(), chests[i].copy(),
                    GT_Utility.getIntegratedCircuit(1)};
            itInputs2[i] = new ItemStack[]{hulls[i].copy(), chests[i].copy(),
                    GT_Utility.getIntegratedCircuit(2)};
        }
        for (int aTier = 10; aTier < 15; aTier++) {
            RA.addAssemblerRecipe(itInputs[aTier - 10],
                    Materials.PerroxPolymer.getMolten((long) (2.25 * Math.pow(2, (aTier - 9)))),
                    inBuses[aTier - 10], 480, (int) (30 * Math.pow(4, (aTier - 1))), false);
            RA.addAssemblerRecipe(itInputs2[aTier - 10],
                    Materials.PerroxPolymer.getMolten((long) (2.25 * Math.pow(2, (aTier - 9)))),
                    outBuses[aTier - 10], 480, (int) (30 * Math.pow(4, (aTier - 1))), false);
        }
    }

    private void blastSmelter() {
        RA.addBlastSmelterRecipe(
                new ItemStack[]{ItemList.Circuit_Integrated.getWithDamage(0L, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Cobalt, 1),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Molybdenum, 8),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Tungsten, 1),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Copper, 1),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Chrome, 7),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Nickel, 32)}, null, null,
                Materials.HastelloyC276.getMoltenHot(144L * 50), 500 * 20, 7680, 3666);
        RA.addBlastSmelterRecipe(
                new ItemStack[]{ItemList.Circuit_Integrated.getWithDamage(0L, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Titanium, 1),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Niobium, 23),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Tantalum, 1),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Zirconium, 2)}, null, null,
                Materials.GumMetal.getMoltenHot(144L * 27), 270 * 20, 7680, 3777);
        RA.addBlastSmelterRecipe(
                new ItemStack[]{ItemList.Circuit_Integrated.getWithDamage(0L, 2L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Titanium, 1),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Niobium, 1),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Tantalum, 1)}, null, null,
                Materials.Titaniolum.getMoltenHot(144L * 3), 30 * 20, 7680, 3888);
        RA.addBlastSmelterRecipe(
                new ItemStack[]{ItemList.Circuit_Integrated.getWithDamage(0L, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Steel, 5),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Manganese, 2)}, null, null,
                Materials.Mangalloy.getMoltenHot(144L * 7), 70 * 20, 7680, 3940);
        RA.addBlastSmelterRecipe(
                new ItemStack[]{ItemList.Circuit_Integrated.getWithDamage(0L, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Aluminium, 4),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Copper, 3),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Magnesium, 1)}, null, null,
                Materials.Zamak.getMoltenHot(144L * 8), 80 * 20, 7680, 3999);
        RA.addBlastSmelterRecipe(
                new ItemStack[]{ItemList.Circuit_Integrated.getWithDamage(0L, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Iron, 5),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Nickel, 3),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Cobalt, 2)}, null, null,
                Materials.Kovar.getMoltenHot(144L * 10), 80 * 20, 7680, 4002);
        RA.addBlastSmelterRecipe(
                new ItemStack[]{ItemList.Circuit_Integrated.getWithDamage(0L, 2L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Aluminium, 3),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Copper, 3),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Magnesium, 1),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Manganese, 1)}, null, null,
                Materials.Duraluminium.getMoltenHot(144L * 8), 64 * 20, 7680, 4111);
        RA.addBlastSmelterRecipe(
                new ItemStack[]{ItemList.Circuit_Integrated.getWithDamage(0L, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Chrome, 1),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Niobium, 2),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Molybdenum, 2),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Nichrome, 1)}, null, null,
                Materials.Inconel690.getMoltenHot(144L * 6), 48 * 20, 7680, 4222);
        RA.addBlastSmelterRecipe(
                new ItemStack[]{ItemList.Circuit_Integrated.getWithDamage(0L, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Titanium, 1),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Nickel, 1)}, null, null,
                Materials.Nitinol.getMoltenHot(144L * 2), 16 * 20, 7680, 4333);
        RA.addBlastSmelterRecipe(
                new ItemStack[]{ItemList.Circuit_Integrated.getWithDamage(0L, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Nickel, 2),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Niobium, 1),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Aluminium, 2),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Nichrome, 1)}, null, null,
                Materials.Inconel792.getMoltenHot(144L * 6), 48 * 20, 7680, 4444);
        RA.addBlastSmelterRecipe(
                new ItemStack[]{ItemList.Circuit_Integrated.getWithDamage(0L, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Titanium, 2),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Aluminium, 3),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Vanadium, 8),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Chrome, 6),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Molybdenum, 4),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Zirconium, 4)}, null, null,
                Materials.TiBetaC.getMoltenHot(144L * 27), 161 * 20, 7680, 4555);
        RA.addBlastSmelterRecipe(
                new ItemStack[]{ItemList.Circuit_Integrated.getWithDamage(0L, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Titanium, 9),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Carbon, 9),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Kalium, 9),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Lithium, 9),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Sulfur, 9)}, null, null,
                Materials.Grisium.getMoltenHot(144L * 45), 315 * 20, 7680, 4601);
        RA.addBlastSmelterRecipe(
                new ItemStack[]{ItemList.Circuit_Integrated.getWithDamage(0L, 2L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Steel, 16),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Titanium, 1),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Aluminium, 1),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Nickel, 4),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Cobalt, 2)}, null, null,
                Materials.MaragingSteel250.getMoltenHot(144L * 24), 168 * 20, 7680, 4666);
        RA.addBlastSmelterRecipe(
                new ItemStack[]{ItemList.Circuit_Integrated.getWithDamage(0L, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Cobalt, 4),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Chrome, 3),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Phosphor, 2),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Molybdenum, 1)}, null, null,
                Materials.Talonite.getMoltenHot(144L * 10), 70 * 20, 7680, 4770);
        RA.addBlastSmelterRecipe(
                new ItemStack[]{ItemList.Circuit_Integrated.getWithDamage(0L, 4L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Titanium, 3),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Nickel, 2)}, null, null,
                Materials.Nitinol60.getMoltenHot(144L * 5), 35 * 20, 7680, 4701);
        RA.addBlastSmelterRecipe(
                new ItemStack[]{ItemList.Circuit_Integrated.getWithDamage(0L, 3L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Steel, 16),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Aluminium, 1),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Titanium, 1),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Nickel, 4),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Cobalt, 2)}, null, null,
                Materials.MaragingSteel300.getMoltenHot(144L * 24), 192 * 20, 7680, 4300);
        RA.addBlastSmelterRecipe(
                new ItemStack[]{ItemList.Circuit_Integrated.getWithDamage(0L, 2L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Chrome, 3),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Cobalt, 7),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Phosphor, 2),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Molybdenum, 1)}, null, null,
                Materials.Stellite.getMoltenHot(144L * 13), 104 * 20, 7680, 4121);
        RA.addBlastSmelterRecipe(
                new ItemStack[]{ItemList.Circuit_Integrated.getWithDamage(0L, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Chrome, 26),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Nickel, 6),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Molybdenum, 4),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Copper, 20),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Tungsten, 4),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Steel, 40)}, null, null,
                Materials.Zeron100.getMoltenHot(144L * 100), 600 * 20, 7680, 5100);
        RA.addBlastSmelterRecipe(
                new ItemStack[]{ItemList.Circuit_Integrated.getWithDamage(0L, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Zeron100, 16),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Gadolinium, 5),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Aluminium, 3),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Tin, 2),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Titanium, 12),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Osmiridium, 6)}, null, null,
                Materials.CinobiteA243.getMoltenHot(144L * 44), 264 * 20, 122880, 7350);
        RA.addBlastSmelterRecipe(
                new ItemStack[]{ItemList.Circuit_Integrated.getWithDamage(0L, 3L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Yttrium, 8),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Molybdenum, 16),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Chrome, 8),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Titanium, 8),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Nickel, 60)}, null, null,
                Materials.HastelloyN.getMoltenHot(144L * 100), 800 * 20, 7680, 4350);
        RA.addBlastSmelterRecipe(
                new ItemStack[]{ItemList.Circuit_Integrated.getWithDamage(0L, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.HastelloyN, 8),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Samarium, 2),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Tungsten, 4),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Aluminium, 6),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Nickel, 8),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Carbon, 2)}, null, null,
                Materials.Lafium.getMoltenHot(144L * 30), 180 * 20, 30720, 6105);
        RA.addBlastSmelterRecipe(
                new ItemStack[]{ItemList.Circuit_Integrated.getWithDamage(0L, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Stellite, 15),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.EnergeticAlloy, 5),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Carbon, 5),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Gallium, 5),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Americium, 5),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Palladium, 5)}, null, null,
                Materials.Quantum.getMoltenHot(144L * 40), 240 * 20, 2000000, 12000);
        RA.addBlastSmelterRecipe(
                new ItemStack[]{ItemList.Circuit_Integrated.getWithDamage(0L, 2L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Stellite, 15),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Inconel792, 16),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.EglinSteel, 10),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.NaquadahEnriched, 8),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Cerium, 6),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Antimony, 4),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Platinum, 4),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.TungstenSteel, 8)}, null, null,
                Materials.Pikyonium64B.getMoltenHot(144L * 71), 336 * 20, 500000, 9900);
        RA.addBlastSmelterRecipe(
                new ItemStack[]{ItemList.Circuit_Integrated.getWithDamage(0L, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Iron, 3),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Carbon, 1),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Vanadium, 5),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Titan, 40),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Aluminium, 6)}, null, null,
                Materials.BT6.getMoltenHot(144L * 55), 300 * 20, 1920, 3200);

    }

    private void cuttingSaw() {
        RA.addCutterRecipe(ItemList.Circuit_Silicon_Ingot10.get(1), GT_Values.NI,
                ItemList.Circuit_Silicon_Wafer10.get(64), ItemList.Circuit_Silicon_Wafer10.get(64), 6400,
                122880, true);
        RA.addCutterRecipe(ItemList.Circuit_Silicon_Ingot9.get(1), GT_Values.NI,
                ItemList.Circuit_Silicon_Wafer9.get(40), null, 1000, 240, true);
        RA.addCutterRecipe(ItemList.Circuit_Silicon_Ingot8.get(1), GT_Values.NI,
                ItemList.Circuit_Silicon_Wafer8.get(64), ItemList.Circuit_Silicon_Wafer8.get(64), 3200,
                7680, true);
        RA.addCutterRecipe(ItemList.Circuit_Silicon_Ingot7.get(1), GT_Values.NI,
                ItemList.Circuit_Silicon_Wafer7.get(64), ItemList.Circuit_Silicon_Wafer7.get(32), 2400,
                1920, true);
        RA.addCutterRecipe(ItemList.Circuit_Silicon_Ingot6.get(1), GT_Values.NI,
                ItemList.Circuit_Silicon_Wafer6.get(64), ItemList.Circuit_Silicon_Wafer6.get(64), 4800,
                122880, true);
        RA.addCutterRecipe(ItemList.Circuit_Silicon_Ingot5.get(1), GT_Values.NI,
                ItemList.Circuit_Silicon_Wafer5.get(64), null, 3700, 7680, true);
        RA.addCutterRecipe(ItemList.Circuit_Silicon_Ingot4.get(1), GT_Values.NI,
                ItemList.Circuit_Silicon_Wafer4.get(48), null, 1200, 240, true);
        RA.addCutterRecipe(ItemList.Circuit_Silicon_Ingot3.get(1), GT_Values.NI,
                ItemList.Circuit_Silicon_Wafer3.get(64), null, 1600, 480, true);
        RA.addCutterRecipe(ItemList.Circuit_Silicon_Ingot2.get(1), GT_Values.NI,
                ItemList.Circuit_Silicon_Wafer2.get(32), null, 800, 120, true);
        RA.addCutterRecipe(ItemList.Circuit_Silicon_Ingot.get(1),
                ItemList.Circuit_Silicon_Wafer.get(16), null, 400, 16);

        // --- ULV Circuit
        RA.addCutterRecipe(CoreItems2.getRecipe(194, 1),
                ItemList.NandChip.get(16L), null, 100, 120);

    }

    private void bath() {
        //spacebox0
        RA
                .addChemicalBathRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Stone, 64),
                        Materials.Glue.getFluid(1000), GT_ItemList.packEarth.get(1L), GT_Values.NI,
                        GT_Values.NI, new int[]{10000}, 200, 8);
        //spacebox1
        RA
                .addChemicalBathRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Moon, 64),
                        Materials.Plastic.getMolten(144L), GT_ItemList.packMoon.get(1L), GT_Values.NI,
                        GT_Values.NI, new int[]{10000}, 200, 20);
        //spacebox2
        RA
                .addChemicalBathRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Mars, 64),
                        Materials.PolyvinylChloride.getMolten(144L), GT_ItemList.packMars.get(1L), GT_Values.NI,
                        GT_Values.NI, new int[]{10000}, 200, 50);
        RA.addChemicalBathRecipe(GregTech_API.getStackofAmountFromOreDict("dustPhobos", 64),
                Materials.PolyvinylChloride.getMolten(144L), GT_ItemList.packPhobos.get(1L), GT_Values.NI,
                GT_Values.NI, new int[]{10000}, 200, 50);
        RA.addChemicalBathRecipe(GregTech_API.getStackofAmountFromOreDict("dustDeimos", 64),
                Materials.PolyvinylChloride.getMolten(144L), GT_ItemList.packDeimos.get(1L), GT_Values.NI,
                GT_Values.NI, new int[]{10000}, 200, 50);
        //spacebox3
        RA
                .addChemicalBathRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Asteroid, 64),
                        Materials.Polystyrene.getMolten(144L), GT_ItemList.packAsteroids.get(1L), GT_Values.NI,
                        GT_Values.NI, new int[]{10000}, 200, 125);
        RA.addChemicalBathRecipe(GregTech_API.getStackofAmountFromOreDict("dustCeres", 64),
                Materials.Polystyrene.getMolten(144L), GT_ItemList.packCeres.get(1L), GT_Values.NI,
                GT_Values.NI, new int[]{10000}, 200, 125);
        RA.addChemicalBathRecipe(GregTech_API.getStackofAmountFromOreDict("dustEuropa", 64),
                Materials.Polystyrene.getMolten(144L), GT_ItemList.packEuropa.get(1L), GT_Values.NI,
                GT_Values.NI, new int[]{10000}, 200, 125);
        RA.addChemicalBathRecipe(GregTech_API.getStackofAmountFromOreDict("dustGanymed", 64),
                Materials.Polystyrene.getMolten(144L), GT_ItemList.packGanymed.get(1L), GT_Values.NI,
                GT_Values.NI, new int[]{10000}, 200, 125);
        RA.addChemicalBathRecipe(GregTech_API.getStackofAmountFromOreDict("dustCallisto", 64),
                Materials.Polystyrene.getMolten(144L), GT_ItemList.packCallisto.get(1L), GT_Values.NI,
                GT_Values.NI, new int[]{10000}, 200, 125);
        //spacebox4
        RA.addChemicalBathRecipe(GregTech_API.getStackofAmountFromOreDict("dustVenus", 64),
                Materials.Polytetrafluoroethylene.getMolten(144L), GT_ItemList.packVenus.get(1L),
                GT_Values.NI, GT_Values.NI, new int[]{10000}, 200, 312);
        RA.addChemicalBathRecipe(GregTech_API.getStackofAmountFromOreDict("dustMercuryP", 64),
                Materials.Polytetrafluoroethylene.getMolten(144L), GT_ItemList.packMercury.get(1L),
                GT_Values.NI, GT_Values.NI, new int[]{10000}, 200, 312);
        //spacebox5
        RA
                .addChemicalBathRecipe(GregTech_API.getStackofAmountFromOreDict("dustEnceladus", 64),
                        Materials.PolyphenyleneSulfide.getMolten(144L), GT_ItemList.packIapetus.get(1L),
                        GT_Values.NI, GT_Values.NI, new int[]{10000}, 200, 780);
        RA.addChemicalBathRecipe(GregTech_API.getStackofAmountFromOreDict("dustTitan", 64),
                Materials.PolyphenyleneSulfide.getMolten(144L), GT_ItemList.packTitan.get(1L), GT_Values.NI,
                GT_Values.NI, new int[]{10000}, 200, 780);
        RA.addChemicalBathRecipe(GregTech_API.getStackofAmountFromOreDict("dustOberon", 64),
                Materials.PolyphenyleneSulfide.getMolten(144L), GT_ItemList.packOberon.get(1L),
                GT_Values.NI, GT_Values.NI, new int[]{10000}, 200, 780);
        RA.addChemicalBathRecipe(GregTech_API.getStackofAmountFromOreDict("dustMiranda", 64),
                Materials.PolyphenyleneSulfide.getMolten(144L), GT_ItemList.packEris.get(1L), GT_Values.NI,
                GT_Values.NI, new int[]{10000}, 200, 780);
        //spacebox6
        RA.addChemicalBathRecipe(GregTech_API.getStackofAmountFromOreDict("dustTriton", 64),
                Materials.Polybenzimidazole.getMolten(144L), GT_ItemList.packTriton.get(1L), GT_Values.NI,
                GT_Values.NI, new int[]{10000}, 200, 1950);
        RA.addChemicalBathRecipe(GregTech_API.getStackofAmountFromOreDict("dustProteus", 64),
                Materials.Polybenzimidazole.getMolten(144L), GT_ItemList.packProteus.get(1L), GT_Values.NI,
                GT_Values.NI, new int[]{10000}, 200, 1950);
        //spacebox7
        RA.addChemicalBathRecipe(GregTech_API.getStackofAmountFromOreDict("dustPluto", 64),
                Materials.Polybenzimidazole.getMolten(288L), GT_ItemList.packPluto.get(1L), GT_Values.NI,
                GT_Values.NI, new int[]{10000}, 200, 4875);
        RA.addChemicalBathRecipe(GregTech_API.getStackofAmountFromOreDict("dustMakeMake", 64),
                Materials.Polybenzimidazole.getMolten(288L), GT_ItemList.packMakeMake.get(1L), GT_Values.NI,
                GT_Values.NI, new int[]{10000}, 200, 4875);
        RA.addChemicalBathRecipe(GregTech_API.getStackofAmountFromOreDict("dustHaumea", 64),
                Materials.Polybenzimidazole.getMolten(288L), GT_ItemList.packHaumea.get(1L), GT_Values.NI,
                GT_Values.NI, new int[]{10000}, 200, 4875);
        //spacebox8
        RA
                .addChemicalBathRecipe(GregTech_API.getStackofAmountFromOreDict("dustCentauriA", 64),
                        Materials.RadoxPolymer.getMolten(144L), GT_ItemList.packCentauriA.get(1L), GT_Values.NI,
                        GT_Values.NI, new int[]{10000}, 200, 12188);
        RA.addChemicalBathRecipe(GregTech_API.getStackofAmountFromOreDict("dustVegaB", 64),
                Materials.RadoxPolymer.getMolten(144L), GT_ItemList.packVegaB.get(1L), GT_Values.NI,
                GT_Values.NI, new int[]{10000}, 200, 12188);
        RA
                .addChemicalBathRecipe(GregTech_API.getStackofAmountFromOreDict("dustBarnardaE", 64),
                        Materials.RadoxPolymer.getMolten(144L), GT_ItemList.packBarnardaE.get(1L), GT_Values.NI,
                        GT_Values.NI, new int[]{10000}, 200, 12188);
        RA
                .addChemicalBathRecipe(GregTech_API.getStackofAmountFromOreDict("dustBarnardaF", 64),
                        Materials.RadoxPolymer.getMolten(144L), GT_ItemList.packBarnardaF.get(1L), GT_Values.NI,
                        GT_Values.NI, new int[]{10000}, 200, 12188);
        RA.addChemicalBathRecipe(GregTech_API.getStackofAmountFromOreDict("dustTCetiE", 64),
                Materials.RadoxPolymer.getMolten(144L), GT_ItemList.packTCetiE.get(1L), GT_Values.NI,
                GT_Values.NI, new int[]{10000}, 200, 12188);
        RA
                .addChemicalBathRecipe(GT_OreDictUnificator.get(OrePrefixes.gem, Materials.Mithril, 2),
                        Materials.SulfuricAcid.getFluid(1000),
                        GT_OreDictUnificator.get(OrePrefixes.gem, Materials.CertusQuartz, 1),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Mytryl, 1),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SluiceSand, 1),
                        new int[]{10000, 8000, 7500}, 400, 1920);
        RA
                .addChemicalBathRecipe(GT_OreDictUnificator.get(OrePrefixes.gem, Materials.Forcicium, 2),
                        Materials.SulfuricAcid.getFluid(1000),
                        GT_OreDictUnificator.get(OrePrefixes.gem, Materials.MysteriousCrystal, 1),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Lutetium, 1),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Trinium, 1),
                        new int[]{10000, 8000, 7500}, 600, 30720);
        RA
                .addChemicalBathRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.DeepIron, 4),
                        Materials.SodiumPersulfate.getFluid(1000),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Iron, 2),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Trinium, 1),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Indium, 1),
                        new int[]{10000, 10000, 10000}, 600, 7680);

        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < Dyes.VALUES[i].getSizeOfFluidList(); j++) {
                if (i != 15) {
                    RA.addChemicalBathRecipe(new ItemStack(Blocks.wool, 1, 0),
                            Dyes.VALUES[i].getFluidDye(j, 72L), new ItemStack(Blocks.wool, 1, 15 - i),
                            GT_Values.NI, GT_Values.NI, null, 64, 2);
                }
                RA.addChemicalBathRecipe(new ItemStack(Blocks.glass, 1, 0),
                        Dyes.VALUES[i].getFluidDye(j, 18L), new ItemStack(Blocks.stained_glass, 1, 15 - i),
                        GT_Values.NI, GT_Values.NI, null, 64, 2);
                RA.addChemicalBathRecipe(new ItemStack(Blocks.hardened_clay, 1, 0),
                        Dyes.VALUES[i].getFluidDye(j, 18L),
                        new ItemStack(Blocks.stained_hardened_clay, 1, 15 - i), GT_Values.NI, GT_Values.NI,
                        null, 64, 2);
            }
        }

        // --- Chlorine cleaning of pistons
        RA
                .addChemicalBathRecipe(new ItemStack(Blocks.sticky_piston), Materials.Chlorine.getGas(10L),
                        new ItemStack(Blocks.piston), GT_Values.NI, GT_Values.NI, null, 30, 30);
        // --- Leather
        RA.addChemicalBathRecipe(new ItemStack(Items.string, 4),
                Materials.PolyvinylChloride.getMolten(36L), new ItemStack(Items.leather, 1), GT_Values.NI,
                GT_Values.NI, new int[]{10000}, 100, 30);
    }

    private void ciruit() {
             // --- GT Circuits
                // --- ULV
                RA.addCircuitAssemblerRecipe(
                        new ItemStack[]{ItemList.Circuit_Board_Phenolic_Good.get(1L),
                                ItemList.Circuit_Chip_Simple_SoC.get(1L),
                                GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.RedAlloy, 1),
                                GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 1)},
                        Materials.SolderingAlloy.getMolten(72L),
                        CoreItems2.getRecipe(194, 1), 300, 120);
                RA.addCircuitAssemblerRecipe(
                        new ItemStack[]{ItemList.Circuit_Board_Phenolic_Good.get(1L),
                                ItemList.Circuit_Chip_Simple_SoC.get(1L),
                                GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.RedAlloy, 1),
                                GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.AnnealedCopper, 1)},
                        Materials.SolderingAlloy.getMolten(72L),
                        CoreItems2.getRecipe(194, 1), 300, 120);
                RA.addCircuitAssemblerRecipe(
                        new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                                ItemList.Circuit_Chip_Simple_SoC.get(2L),
                                GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.RedstoneAlloy, 1),
                                GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Gold, 1)},
                        Materials.SolderingAlloy.getMolten(72L),
                        CoreItems2.getRecipe(194, 2), 400, 120);
                RA.addCircuitAssemblerRecipe(
                        new ItemStack[]{ItemList.Circuit_Board_Epoxy_Advanced.get(1L),
                                ItemList.Circuit_Chip_Simple_SoC.get(4L),
                                GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.EnergeticAlloy, 1),
                                GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Platinum, 1)},
                        Materials.SolderingAlloy.getMolten(72L),
                        CoreItems2.getRecipe(194, 4), 500, 250);
                RA.addCircuitAssemblerRecipe(
                        new ItemStack[]{ItemList.Circuit_Board_Fiberglass_Advanced.get(1L),
                                ItemList.Circuit_Chip_Simple_SoC.get(8L),
                                GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.VibrantAlloy, 1),
                                GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Osmium, 1)},
                        Materials.SolderingAlloy.getMolten(72L),
                        CoreItems2.getRecipe(194, 8), 600, 480);

                // --- LV
                //1
                RA.addCircuitAssemblerRecipe(
                        new ItemStack[]{ItemList.Circuit_Board_Coated_Basic.get(1),
                                ItemList.Circuit_Parts_Resistor.get(2),
                                GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.RedAlloy, 2),
                                ItemList.Circuit_Parts_Vacuum_Tube.get(2)}, Materials.SolderingAlloy.getMolten(72L),
                        GT_ModHandler.getModItem("IC2", "itemPartCircuit", 2L, 0), 200, 16);
                RA.addCircuitAssemblerRecipe(
                        new ItemStack[]{ItemList.Circuit_Board_Coated_Basic.get(1),
                                ItemList.Circuit_Parts_ResistorSMD.get(2),
                                GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.RedAlloy, 2),
                                ItemList.Circuit_Parts_Vacuum_Tube.get(2)}, Materials.SolderingAlloy.getMolten(72L),
                        GT_ModHandler.getModItem("IC2", "itemPartCircuit", 2L, 0), 200, 16);
                RA.addCircuitAssemblerRecipe(
                        new ItemStack[]{ItemList.Circuit_Board_Coated_Basic.get(1),
                                ItemList.Circuit_Parts_Resistor.get(2),
                                GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.RedAlloy, 2),
                                ItemList.NandChip.get(2)}, Materials.SolderingAlloy.getMolten(72L),
                        GT_ModHandler.getModItem("IC2", "itemPartCircuit", 2L, 0), 200, 16);
                RA.addCircuitAssemblerRecipe(
                        new ItemStack[]{ItemList.Circuit_Board_Coated_Basic.get(1),
                                ItemList.Circuit_Parts_ResistorSMD.get(2),
                                GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.RedAlloy, 2),
                                ItemList.NandChip.get(2)}, Materials.SolderingAlloy.getMolten(72L),
                        GT_ModHandler.getModItem("IC2", "itemPartCircuit", 2L, 0), 200, 16);
                //2
                RA.addCircuitAssemblerRecipe(
                        new ItemStack[]{ItemList.Circuit_Board_Coated_Basic.get(1),
                                ItemList.Circuit_Chip_ILC.get(1), ItemList.Circuit_Parts_Resistor.get(2),
                                ItemList.Circuit_Parts_Diode.get(2),
                                GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 2),
                                GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Tin, 2)},
                        Materials.SolderingAlloy.getMolten(72L), ItemList.Circuit_Basic.get(3), 200, 16);
                RA.addCircuitAssemblerRecipe(
                        new ItemStack[]{ItemList.Circuit_Board_Coated_Basic.get(1),
                                ItemList.Circuit_Chip_ILC.get(1), ItemList.Circuit_Parts_ResistorSMD.get(2),
                                ItemList.Circuit_Parts_Diode.get(2),
                                GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 2),
                                GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Tin, 2)},
                        Materials.SolderingAlloy.getMolten(72L), ItemList.Circuit_Basic.get(3), 200, 16);
                RA.addCircuitAssemblerRecipe(
                        new ItemStack[]{ItemList.Circuit_Board_Coated_Basic.get(1),
                                ItemList.Circuit_Chip_ILC.get(1), ItemList.Circuit_Parts_ResistorSMD.get(2),
                                ItemList.Circuit_Parts_DiodeSMD.get(2),
                                GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 2),
                                GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Tin, 2)},
                        Materials.SolderingAlloy.getMolten(72L), ItemList.Circuit_Basic.get(3), 200, 16);
                RA.addCircuitAssemblerRecipe(
                        new ItemStack[]{ItemList.Circuit_Board_Coated_Basic.get(1),
                                ItemList.Circuit_Chip_ILC.get(1), ItemList.Circuit_Parts_Resistor.get(2),
                                ItemList.Circuit_Parts_DiodeSMD.get(2),
                                GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 2),
                                GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Tin, 2)},
                        Materials.SolderingAlloy.getMolten(72L), ItemList.Circuit_Basic.get(3), 200, 16);
                //3
                RA.addCircuitAssemblerRecipe(
                        new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1),
                                ItemList.Circuit_Chip_CPU.get(1), ItemList.Circuit_Parts_Resistor.get(2),
                                ItemList.Circuit_Parts_Capacitor.get(2), ItemList.Circuit_Parts_Transistor.get(2),
                                GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 2)},
                        Materials.SolderingAlloy.getMolten(72L), ItemList.Circuit_Microprocessor.get(4), 200,
                        60, true);
                RA.addCircuitAssemblerRecipe(
                        new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1),
                                ItemList.Circuit_Chip_CPU.get(1), ItemList.Circuit_Parts_ResistorSMD.get(2),
                                ItemList.Circuit_Parts_Capacitor.get(2), ItemList.Circuit_Parts_Transistor.get(2),
                                GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 2)},
                        Materials.SolderingAlloy.getMolten(72L), ItemList.Circuit_Microprocessor.get(4), 200,
                        60, true);
                RA.addCircuitAssemblerRecipe(
                        new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1),
                                ItemList.Circuit_Chip_CPU.get(1), ItemList.Circuit_Parts_Resistor.get(2),
                                ItemList.Circuit_Parts_CapacitorSMD.get(2),
                                ItemList.Circuit_Parts_Transistor.get(2),
                                GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 2)},
                        Materials.SolderingAlloy.getMolten(72L), ItemList.Circuit_Microprocessor.get(4), 200,
                        60, true);
                RA.addCircuitAssemblerRecipe(
                        new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1),
                                ItemList.Circuit_Chip_CPU.get(1), ItemList.Circuit_Parts_Resistor.get(2),
                                ItemList.Circuit_Parts_Capacitor.get(2),
                                ItemList.Circuit_Parts_TransistorSMD.get(2),
                                GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 2)},
                        Materials.SolderingAlloy.getMolten(72L), ItemList.Circuit_Microprocessor.get(4), 200,
                        60, true);
                RA.addCircuitAssemblerRecipe(
                        new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1),
                                ItemList.Circuit_Chip_CPU.get(1), ItemList.Circuit_Parts_ResistorSMD.get(2),
                                ItemList.Circuit_Parts_CapacitorSMD.get(2),
                                ItemList.Circuit_Parts_Transistor.get(2),
                                GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 2)},
                        Materials.SolderingAlloy.getMolten(72L), ItemList.Circuit_Microprocessor.get(4), 200,
                        60, true);
                RA.addCircuitAssemblerRecipe(
                        new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1),
                                ItemList.Circuit_Chip_CPU.get(1), ItemList.Circuit_Parts_ResistorSMD.get(2),
                                ItemList.Circuit_Parts_Capacitor.get(2),
                                ItemList.Circuit_Parts_TransistorSMD.get(2),
                                GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 2)},
                        Materials.SolderingAlloy.getMolten(72L), ItemList.Circuit_Microprocessor.get(4), 200,
                        60, true);
                RA.addCircuitAssemblerRecipe(
                        new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1),
                                ItemList.Circuit_Chip_CPU.get(1), ItemList.Circuit_Parts_Resistor.get(2),
                                ItemList.Circuit_Parts_CapacitorSMD.get(2),
                                ItemList.Circuit_Parts_TransistorSMD.get(2),
                                GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 2)},
                        Materials.SolderingAlloy.getMolten(72L), ItemList.Circuit_Microprocessor.get(4), 200,
                        60, true);
                RA.addCircuitAssemblerRecipe(
                        new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1),
                                ItemList.Circuit_Chip_CPU.get(1), ItemList.Circuit_Parts_ResistorSMD.get(2),
                                ItemList.Circuit_Parts_CapacitorSMD.get(2),
                                ItemList.Circuit_Parts_TransistorSMD.get(2),
                                GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 2)},
                        Materials.SolderingAlloy.getMolten(72L), ItemList.Circuit_Microprocessor.get(4), 200,
                        60, true);

                RA.addCircuitAssemblerRecipe(
                        new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1),
                                ItemList.Circuit_Chip_SoC.get(1),
                                GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 2),
                                GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Tin, 2)},
                        Materials.SolderingAlloy.getMolten(72L), ItemList.Circuit_Microprocessor.get(6), 50,
                        600, true);

                // --- MV
                //1
                RA.addCircuitAssemblerRecipe(
                        new ItemStack[]{ItemList.Circuit_Board_Phenolic_Good.get(1),
                                GT_ModHandler.getModItem("IC2", "itemPartCircuit", 2L, 0),
                                ItemList.Circuit_Parts_Diode.get(2),
                                GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.Copper, 2)},
                        Materials.SolderingAlloy.getMolten(72L), ItemList.Circuit_Good.get(2), 300, 30);
                RA.addCircuitAssemblerRecipe(
                        new ItemStack[]{ItemList.Circuit_Board_Phenolic_Good.get(1),
                                GT_ModHandler.getModItem("IC2", "itemPartCircuit", 2L, 0),
                                ItemList.Circuit_Parts_DiodeSMD.get(2),
                                GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.Copper, 2)},
                        Materials.SolderingAlloy.getMolten(72L), ItemList.Circuit_Good.get(2), 300, 30);
                //2
                RA.addCircuitAssemblerRecipe(
                        new ItemStack[]{ItemList.Circuit_Board_Phenolic_Good.get(1),
                                ItemList.Circuit_Basic.get(3), ItemList.Circuit_Parts_Resistor.get(4),
                                ItemList.Circuit_Parts_Diode.get(4),
                                GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Gold, 4),
                                GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Silver, 4)},
                        Materials.SolderingAlloy.getMolten(72L), ItemList.Circuit_Integrated_Good.get(3), 400,
                        24);
                RA.addCircuitAssemblerRecipe(
                        new ItemStack[]{ItemList.Circuit_Board_Phenolic_Good.get(1),
                                ItemList.Circuit_Basic.get(3), ItemList.Circuit_Parts_ResistorSMD.get(4),
                                ItemList.Circuit_Parts_Diode.get(4),
                                GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Gold, 4),
                                GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Silver, 4)},
                        Materials.SolderingAlloy.getMolten(72L), ItemList.Circuit_Integrated_Good.get(3), 400,
                        24);
                RA.addCircuitAssemblerRecipe(
                        new ItemStack[]{ItemList.Circuit_Board_Phenolic_Good.get(1),
                                ItemList.Circuit_Basic.get(3), ItemList.Circuit_Parts_ResistorSMD.get(4),
                                ItemList.Circuit_Parts_DiodeSMD.get(4),
                                GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Gold, 4),
                                GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Silver, 4)},
                        Materials.SolderingAlloy.getMolten(72L), ItemList.Circuit_Integrated_Good.get(3), 400,
                        24);
                RA.addCircuitAssemblerRecipe(
                        new ItemStack[]{ItemList.Circuit_Board_Phenolic_Good.get(1),
                                ItemList.Circuit_Basic.get(3), ItemList.Circuit_Parts_Resistor.get(4),
                                ItemList.Circuit_Parts_DiodeSMD.get(4),
                                GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Gold, 4),
                                GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Silver, 4)},
                        Materials.SolderingAlloy.getMolten(72L), ItemList.Circuit_Integrated_Good.get(3), 400,
                        24);
                //3
                RA.addCircuitAssemblerRecipe(
                        new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1),
                                ItemList.Circuit_Chip_CPU.get(1), ItemList.Circuit_Parts_Resistor.get(4),
                                ItemList.Circuit_Parts_Capacitor.get(4), ItemList.Circuit_Parts_Transistor.get(4),
                                GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.RedAlloy, 4)},
                        Materials.SolderingAlloy.getMolten(72L), ItemList.Circuit_Processor.get(4), 200, 60,
                        true);
                RA.addCircuitAssemblerRecipe(
                        new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1),
                                ItemList.Circuit_Chip_CPU.get(1), ItemList.Circuit_Parts_ResistorSMD.get(4),
                                ItemList.Circuit_Parts_Capacitor.get(4), ItemList.Circuit_Parts_Transistor.get(4),
                                GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.RedAlloy, 4)},
                        Materials.SolderingAlloy.getMolten(72L), ItemList.Circuit_Processor.get(4), 200, 60,
                        true);
                RA.addCircuitAssemblerRecipe(
                        new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1),
                                ItemList.Circuit_Chip_CPU.get(1), ItemList.Circuit_Parts_Resistor.get(4),
                                ItemList.Circuit_Parts_CapacitorSMD.get(4),
                                ItemList.Circuit_Parts_Transistor.get(4),
                                GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.RedAlloy, 4)},
                        Materials.SolderingAlloy.getMolten(72L), ItemList.Circuit_Processor.get(4), 200, 60,
                        true);
                RA.addCircuitAssemblerRecipe(
                        new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1),
                                ItemList.Circuit_Chip_CPU.get(1), ItemList.Circuit_Parts_Resistor.get(4),
                                ItemList.Circuit_Parts_Capacitor.get(4),
                                ItemList.Circuit_Parts_TransistorSMD.get(4),
                                GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.RedAlloy, 4)},
                        Materials.SolderingAlloy.getMolten(72L), ItemList.Circuit_Processor.get(4), 200, 60,
                        true);
                RA.addCircuitAssemblerRecipe(
                        new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1),
                                ItemList.Circuit_Chip_CPU.get(1), ItemList.Circuit_Parts_ResistorSMD.get(4),
                                ItemList.Circuit_Parts_CapacitorSMD.get(4),
                                ItemList.Circuit_Parts_Transistor.get(4),
                                GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.RedAlloy, 4)},
                        Materials.SolderingAlloy.getMolten(72L), ItemList.Circuit_Processor.get(4), 200, 60,
                        true);
                RA.addCircuitAssemblerRecipe(
                        new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1),
                                ItemList.Circuit_Chip_CPU.get(1), ItemList.Circuit_Parts_ResistorSMD.get(4),
                                ItemList.Circuit_Parts_Capacitor.get(4),
                                ItemList.Circuit_Parts_TransistorSMD.get(4),
                                GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.RedAlloy, 4)},
                        Materials.SolderingAlloy.getMolten(72L), ItemList.Circuit_Processor.get(4), 200, 60,
                        true);
                RA.addCircuitAssemblerRecipe(
                        new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1),
                                ItemList.Circuit_Chip_CPU.get(1), ItemList.Circuit_Parts_Resistor.get(4),
                                ItemList.Circuit_Parts_CapacitorSMD.get(4),
                                ItemList.Circuit_Parts_TransistorSMD.get(4),
                                GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.RedAlloy, 4)},
                        Materials.SolderingAlloy.getMolten(72L), ItemList.Circuit_Processor.get(4), 200, 60,
                        true);
                RA.addCircuitAssemblerRecipe(
                        new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1),
                                ItemList.Circuit_Chip_CPU.get(1), ItemList.Circuit_Parts_ResistorSMD.get(4),
                                ItemList.Circuit_Parts_CapacitorSMD.get(4),
                                ItemList.Circuit_Parts_TransistorSMD.get(4),
                                GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.RedAlloy, 4)},
                        Materials.SolderingAlloy.getMolten(72L), ItemList.Circuit_Processor.get(4), 200, 60,
                        true);
                RA.addCircuitAssemblerRecipe(
                        new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                                ItemList.Circuit_Chip_CPU.get(1L), ItemList.Circuit_Parts_ResistorASMD.get(1L),
                                ItemList.Circuit_Parts_CapacitorASMD.get(1L),
                                ItemList.Circuit_Parts_TransistorASMD.get(1L),
                                GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.RedAlloy, 4)},
                        Materials.SolderingAlloy.getMolten(72L), ItemList.Circuit_Processor.get(4L), 100, 60,
                        true);

                RA.addCircuitAssemblerRecipe(
                        new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1),
                                ItemList.Circuit_Chip_SoC.get(1),
                                GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.RedAlloy, 4),
                                GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.AnnealedCopper, 4)},
                        Materials.SolderingAlloy.getMolten(72L), ItemList.Circuit_Processor.get(6), 50, 2400,
                        true);

                // --- HV
                //1
                RA.addCircuitAssemblerRecipe(
                        new ItemStack[]{ItemList.Circuit_Integrated_Good.get(1),
                                ItemList.Circuit_Chip_ILC.get(2), ItemList.Circuit_Chip_Ram.get(2),
                                ItemList.Circuit_Parts_Transistor.get(4),
                                GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Electrum, 8),
                                GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.AnnealedCopper, 8)},
                        Materials.SolderingAlloy.getMolten(72L),
                        GT_ModHandler.getIC2Item("advancedCircuit", 1L), 800, 30, false);
                RA.addCircuitAssemblerRecipe(
                        new ItemStack[]{ItemList.Circuit_Integrated_Good.get(1),
                                ItemList.Circuit_Chip_ILC.get(2), ItemList.Circuit_Chip_Ram.get(2),
                                ItemList.Circuit_Parts_TransistorSMD.get(4),
                                GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Electrum, 8),
                                GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.AnnealedCopper, 8)},
                        Materials.SolderingAlloy.getMolten(72L),
                        GT_ModHandler.getIC2Item("advancedCircuit", 1L), 800, 30, false);
                //2
                RA.addCircuitAssemblerRecipe(
                        new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1),
                                ItemList.Circuit_Processor.get(2), ItemList.Circuit_Parts_Coil.get(4),
                                ItemList.Circuit_Parts_Capacitor.get(8), ItemList.Circuit_Chip_Ram.get(4),
                                GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.RedAlloy, 8)},
                        Materials.SolderingAlloy.getMolten(144L), ItemList.Circuit_Computer.get(2), 400, 120, true);
                RA.addCircuitAssemblerRecipe(
                        new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1),
                                ItemList.Circuit_Processor.get(2), ItemList.Circuit_Parts_Coil.get(4),
                                ItemList.Circuit_Parts_CapacitorSMD.get(8), ItemList.Circuit_Chip_Ram.get(4),
                                GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.RedAlloy, 8)},
                        Materials.SolderingAlloy.getMolten(144L), ItemList.Circuit_Computer.get(2), 400, 96, true);
                //3
                RA.addCircuitAssemblerRecipe(
                        new ItemStack[]{ItemList.Circuit_Board_Epoxy_Advanced.get(1),
                                ItemList.Circuit_Chip_NanoCPU.get(1), ItemList.Circuit_Parts_ResistorSMD.get(8),
                                ItemList.Circuit_Parts_CapacitorSMD.get(8),
                                ItemList.Circuit_Parts_TransistorSMD.get(8),
                                GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Electrum, 8)},
                        Materials.SolderingAlloy.getMolten(72L), ItemList.Circuit_Nanoprocessor.get(3), 200,
                        600, true);
                RA.addCircuitAssemblerRecipe(
                        new ItemStack[]{ItemList.Circuit_Board_Epoxy_Advanced.get(1),
                                ItemList.Circuit_Chip_NanoCPU.get(1L), ItemList.Circuit_Parts_ResistorASMD.get(2L),
                                ItemList.Circuit_Parts_CapacitorASMD.get(2L),
                                ItemList.Circuit_Parts_TransistorASMD.get(2L),
                                GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Electrum, 8)},
                        Materials.SolderingAlloy.getMolten(72L), ItemList.Circuit_Nanoprocessor.get(3), 100,
                        600, true);

                RA.addCircuitAssemblerRecipe(
                        new ItemStack[]{ItemList.Circuit_Board_Epoxy_Advanced.get(1),
                                ItemList.Circuit_Chip_SoC2.get(1),
                                GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Electrum, 8),
                                GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Platinum, 8)},
                        Materials.SolderingAlloy.getMolten(72L), ItemList.Circuit_Nanoprocessor.get(4), 50,
                        9600, true);

                // --- EV
                //1
                RA.addCircuitAssemblerRecipe(
                        new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1),
                                ItemList.Circuit_Advanced.get(2), ItemList.Circuit_Parts_Diode.get(4),
                                ItemList.Circuit_Chip_Ram.get(8),
                                GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Electrum, 16),
                                GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Platinum, 16)},
                        Materials.SolderingAlloy.getMolten(144L), ItemList.Circuit_Data.get(1), 400, 120, true);
                RA.addCircuitAssemblerRecipe(
                        new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1),
                                ItemList.Circuit_Advanced.get(2), ItemList.Circuit_Parts_DiodeSMD.get(4),
                                ItemList.Circuit_Chip_Ram.get(8),
                                GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Electrum, 16),
                                GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Platinum, 16)},
                        Materials.SolderingAlloy.getMolten(144L), ItemList.Circuit_Data.get(1), 400, 120, true);
                //2
                RA.addCircuitAssemblerRecipe(
                        new ItemStack[]{ItemList.Circuit_Board_Epoxy_Advanced.get(1),
                                ItemList.Circuit_Nanoprocessor.get(2), ItemList.Circuit_Parts_Coil.get(8),
                                ItemList.Circuit_Parts_CapacitorSMD.get(8), ItemList.Circuit_Chip_Ram.get(8),
                                GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Electrum, 16)},
                        Materials.SolderingAlloy.getMolten(144L), ItemList.Circuit_Nanocomputer.get(1), 400, 600,
                        true);
                RA.addCircuitAssemblerRecipe(
                        new ItemStack[]{ItemList.Circuit_Board_Epoxy_Advanced.get(1L),
                                ItemList.Circuit_Nanoprocessor.get(2L), ItemList.Circuit_Parts_Coil.get(8L),
                                ItemList.Circuit_Parts_CapacitorASMD.get(2L), ItemList.Circuit_Chip_Ram.get(8L),
                                GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Electrum, 16)},
                        Materials.SolderingAlloy.getMolten(144L), ItemList.Circuit_Nanocomputer.get(1L), 200, 600,
                        true);

                //3
                RA.addCircuitAssemblerRecipe(
                        new ItemStack[]{ItemList.Circuit_Board_Fiberglass_Advanced.get(1),
                                ItemList.Circuit_Chip_QuantumCPU.get(1), ItemList.Circuit_Chip_NanoCPU.get(1),
                                ItemList.Circuit_Parts_CapacitorSMD.get(12),
                                ItemList.Circuit_Parts_TransistorSMD.get(12),
                                GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Platinum, 12)},
                        Materials.SolderingAlloy.getMolten(72L), ItemList.Circuit_Quantumprocessor.get(2), 200,
                        2400, true);
                RA.addCircuitAssemblerRecipe(
                        new ItemStack[]{ItemList.Circuit_Board_Fiberglass_Advanced.get(1L),
                                ItemList.Circuit_Chip_QuantumCPU.get(1L), ItemList.Circuit_Chip_NanoCPU.get(1L),
                                ItemList.Circuit_Parts_CapacitorASMD.get(3L),
                                ItemList.Circuit_Parts_TransistorASMD.get(3L),
                                GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Platinum, 16)},
                        Materials.SolderingAlloy.getMolten(72L), ItemList.Circuit_Quantumprocessor.get(2L), 100,
                        2400, true);

                RA.addCircuitAssemblerRecipe(
                        new ItemStack[]{ItemList.Circuit_Board_Fiberglass_Advanced.get(1),
                                ItemList.Circuit_Chip_SoC3.get(1),
                                GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Platinum, 16),
                                GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.NiobiumTitanium, 8)},
                        Materials.SolderingAlloy.getMolten(72L), ItemList.Circuit_Quantumprocessor.get(3), 50,
                        38400, true);

                // --- IV
                //1
                RA.addCircuitAssemblerRecipe(
                        new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Aluminium, 2),
                                ItemList.Circuit_Data.get(2), ItemList.Circuit_Parts_Coil.get(12),
                                ItemList.Circuit_Parts_Capacitor.get(24), ItemList.Circuit_Chip_Ram.get(16),
                                GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.AnnealedCopper, 24)},
                        Materials.SolderingAlloy.getMolten(288L), ItemList.Circuit_Elite.get(1), 1600, 480, true);
                RA.addCircuitAssemblerRecipe(
                        new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Aluminium, 2),
                                ItemList.Circuit_Data.get(2), ItemList.Circuit_Parts_Coil.get(12),
                                ItemList.Circuit_Parts_CapacitorSMD.get(16), ItemList.Circuit_Chip_Ram.get(16),
                                GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.AnnealedCopper, 16)},
                        Materials.SolderingAlloy.getMolten(288L), ItemList.Circuit_Elite.get(1), 1600, 480, true);
                RA.addCircuitAssemblerRecipe(
                        new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Aluminium, 2),
                                ItemList.Circuit_Data.get(2), ItemList.Circuit_Parts_Coil.get(12L),
                                ItemList.Circuit_Parts_CapacitorASMD.get(4L), ItemList.Circuit_Chip_Ram.get(16L),
                                GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.AnnealedCopper, 16)},
                        Materials.SolderingAlloy.getMolten(288L), ItemList.Circuit_Elite.get(1L), 800, 480, true);

                //2
                RA.addCircuitAssemblerRecipe(
                        new ItemStack[]{ItemList.Circuit_Board_Epoxy_Advanced.get(1),
                                ItemList.Circuit_Nanocomputer.get(2), ItemList.Circuit_Parts_DiodeSMD.get(8),
                                ItemList.Circuit_Chip_NOR.get(4), ItemList.Circuit_Chip_Ram.get(16),
                                GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Electrum, 16)},
                        Materials.SolderingAlloy.getMolten(144L), ItemList.Circuit_Elitenanocomputer.get(1), 400, 600,
                        true);
                RA.addCircuitAssemblerRecipe(
                        new ItemStack[]{ItemList.Circuit_Board_Epoxy_Advanced.get(1L),
                                ItemList.Circuit_Nanocomputer.get(2L), ItemList.Circuit_Parts_DiodeASMD.get(2L),
                                ItemList.Circuit_Chip_NOR.get(4L), ItemList.Circuit_Chip_Ram.get(16L),
                                GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Electrum, 16)},
                        Materials.SolderingAlloy.getMolten(144L), ItemList.Circuit_Elitenanocomputer.get(1L), 200,
                        600, true);

                //3
                RA.addCircuitAssemblerRecipe(
                        new ItemStack[]{ItemList.Circuit_Board_Fiberglass_Advanced.get(1),
                                ItemList.Circuit_Quantumprocessor.get(2), ItemList.Circuit_Parts_Coil.get(12),
                                ItemList.Circuit_Parts_CapacitorSMD.get(16), ItemList.Circuit_Chip_Ram.get(4),
                                GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Platinum, 16)},
                        Materials.SolderingAlloy.getMolten(144L), ItemList.Circuit_Quantumcomputer.get(2), 400, 2400,
                        true);
                RA.addCircuitAssemblerRecipe(
                        new ItemStack[]{ItemList.Circuit_Board_Fiberglass_Advanced.get(1L),
                                ItemList.Circuit_Quantumprocessor.get(2L), ItemList.Circuit_Parts_Coil.get(12L),
                                ItemList.Circuit_Parts_CapacitorASMD.get(4L), ItemList.Circuit_Chip_Ram.get(4L),
                                GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Platinum, 24)},
                        Materials.SolderingAlloy.getMolten(144L), ItemList.Circuit_Quantumcomputer.get(2L), 200, 2400,
                        true);

                RA.addCircuitAssemblerSpaceRecipe(
                        new ItemStack[]{ItemList.Circuit_Board_Fiberglass_Advanced.get(1),
                                ItemList.Circuit_Chip_SoC4.get(1),
                                GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Platinum, 16),
                                GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.YttriumBariumCuprate, 8)},
                        Materials.SolderingAlloy.getMolten(144L), ItemList.Circuit_Quantumcomputer.get(2), 50, 38400,
                        true);
                //4
                RA.addCircuitAssemblerSpaceRecipe(
                        new ItemStack[]{ItemList.Circuit_Board_Multifiberglass_Elite.get(1L),
                                ItemList.Circuit_Chip_CrystalCPU.get(1L), ItemList.Circuit_Chip_NanoCPU.get(2L),
                                ItemList.Circuit_Parts_CapacitorASMD.get(6),
                                ItemList.Circuit_Parts_TransistorASMD.get(6),
                                GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.NiobiumTitanium, 8)},
                        Materials.SolderingAlloy.getMolten(72L), ItemList.Circuit_Crystalprocessor.get(2L), 100,
                        9600, true);

                RA.addCircuitAssemblerSpaceRecipe(
                        new ItemStack[]{ItemList.Circuit_Board_Multifiberglass_Elite.get(1),
                                ItemList.Circuit_Chip_CrystalSoC.get(1),
                                GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.NiobiumTitanium, 8),
                                GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.YttriumBariumCuprate, 8)},
                        Materials.SolderingAlloy.getMolten(72L), ItemList.Circuit_Crystalprocessor.get(3), 50,
                        153600, true);

                // --- LuV
                //1
                RA.addCircuitAssemblerRecipe(
                        new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Aluminium, 2),
                                ItemList.Circuit_Elitenanocomputer.get(2), ItemList.Circuit_Parts_Coil.get(16),
                                ItemList.Circuit_Parts_CapacitorSMD.get(32), ItemList.Circuit_Chip_Ram.get(16),
                                GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.AnnealedCopper, 32)},
                        Materials.SolderingAlloy.getMolten(288L), ItemList.Circuit_Master.get(1), 1600, 1920,
                        true);
                RA.addCircuitAssemblerRecipe(
                        new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Aluminium, 2),
                                ItemList.Circuit_Elitenanocomputer.get(2L), ItemList.Circuit_Parts_Coil.get(16L),
                                ItemList.Circuit_Parts_CapacitorASMD.get(8L), ItemList.Circuit_Chip_Ram.get(16L),
                                GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.AnnealedCopper, 32)},
                        Materials.SolderingAlloy.getMolten(288L), ItemList.Circuit_Master.get(1L), 800, 1920,
                        true);

                RA.addCircuitAssemblerSpaceRecipe(
                        new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Aluminium, 2),
                                ItemList.Circuit_Chip_SoC4.get(1),
                                GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.AnnealedCopper, 32),
                                GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.YttriumBariumCuprate, 8)},
                        Materials.SolderingAlloy.getMolten(72L), ItemList.Circuit_Master.get(1), 50, 500000,
                        true);
                //2
                RA.addCircuitAssemblerRecipe(
                        new ItemStack[]{ItemList.Circuit_Board_Fiberglass_Advanced.get(1),
                                ItemList.Circuit_Quantumcomputer.get(2), ItemList.Circuit_Parts_DiodeSMD.get(8),
                                ItemList.Circuit_Chip_NOR.get(4), ItemList.Circuit_Chip_Ram.get(16),
                                GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Platinum, 32)},
                        Materials.SolderingAlloy.getMolten(144L), ItemList.Circuit_Masterquantumcomputer.get(1), 400,
                        2400, true);
                RA.addCircuitAssemblerRecipe(
                        new ItemStack[]{ItemList.Circuit_Board_Fiberglass_Advanced.get(1L),
                                ItemList.Circuit_Quantumcomputer.get(2L), ItemList.Circuit_Parts_DiodeASMD.get(2L),
                                ItemList.Circuit_Chip_NOR.get(4L), ItemList.Circuit_Chip_Ram.get(16L),
                                GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Platinum, 48)},
                        Materials.SolderingAlloy.getMolten(144L), ItemList.Circuit_Masterquantumcomputer.get(1L), 200,
                        2400, true);

                //3
                RA.addCircuitAssemblerSpaceRecipe(
                        new ItemStack[]{ItemList.Circuit_Board_Multifiberglass_Elite.get(1L),
                                ItemList.Circuit_Crystalprocessor.get(2L), ItemList.Circuit_Parts_Coil.get(24),
                                ItemList.Circuit_Parts_CapacitorASMD.get(8L), ItemList.Circuit_Chip_Ram.get(24),
                                GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.NiobiumTitanium, 16)},
                        Materials.SolderingAlloy.getMolten(144L), ItemList.Circuit_Crystalcomputer.get(2L), 200, 9600,
                        true);

                RA.addCircuitAssemblerSpaceRecipe(
                        new ItemStack[]{ItemList.Circuit_Board_Multifiberglass_Elite.get(1),
                                ItemList.Circuit_Chip_SoC4.get(1),
                                GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.NiobiumTitanium, 16),
                                GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.YttriumBariumCuprate, 8)},
                        Materials.SolderingAlloy.getMolten(72L), ItemList.Circuit_Crystalcomputer.get(2), 50,
                        153600, true);
                //4
                RA.addCircuitAssemblerSpaceRecipe(
                        new ItemStack[]{ItemList.Circuit_Chip_NeuroCPU.get(1L),
                                ItemList.Circuit_Chip_CrystalCPU.get(1L), ItemList.Circuit_Chip_NanoCPU.get(1L),
                                ItemList.Circuit_Parts_CapacitorASMD.get(8L),
                                ItemList.Circuit_Parts_TransistorASMD.get(8L),
                                GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.YttriumBariumCuprate, 8)},
                        Materials.SolderingAlloy.getMolten(72L), ItemList.Circuit_Neuroprocessor.get(2L), 200,
                        38400, true);

                RA.addCircuitAssemblerSpaceRecipe(
                        new ItemStack[]{ItemList.Circuit_Chip_NeuroCPU.get(1),
                                ItemList.Circuit_Chip_CrystalSoC2.get(1),
                                GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.YttriumBariumCuprate, 8),
                                GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Naquadah, 8)},
                        Materials.SolderingAlloy.getMolten(72L), ItemList.Circuit_Neuroprocessor.get(3), 50,
                        614400, true);

                // --- ZPM
                //1
                RA.addCircuitAssemblerSpaceRecipe(
                        new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Aluminium, 2),
                                ItemList.Circuit_Masterquantumcomputer.get(2), ItemList.Circuit_Parts_Coil.get(24),
                                ItemList.Circuit_Parts_CapacitorSMD.get(48), ItemList.Circuit_Chip_Ram.get(24),
                                GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.AnnealedCopper, 48)},
                        Materials.SolderingAlloy.getMolten(288L), ItemList.Circuit_Quantummainframe.get(1), 1600,
                        7680, true);
                RA.addCircuitAssemblerSpaceRecipe(
                        new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Aluminium, 2),
                                ItemList.Circuit_Masterquantumcomputer.get(2L), ItemList.Circuit_Parts_Coil.get(24),
                                ItemList.Circuit_Parts_CapacitorASMD.get(12L), ItemList.Circuit_Chip_Ram.get(24),
                                GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.AnnealedCopper, 48)},
                        Materials.SolderingAlloy.getMolten(288L), ItemList.Circuit_Quantummainframe.get(1L), 800,
                        7680, true);

                RA.addCircuitAssemblerSpaceRecipe(
                        new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Trinium, 2),
                                ItemList.Circuit_Chip_CrystalSoC.get(1),
                                GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.Platinum, 32),
                                GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Europium, 16)},
                        Materials.SolderingAlloy.getMolten(72L), ItemList.Circuit_Quantummainframe.get(1), 50,
                        2000000, true);
                //2
                RA.addCircuitAssemblerSpaceRecipe(
                        new ItemStack[]{ItemList.Circuit_Board_Multifiberglass_Elite.get(1),
                                ItemList.Circuit_Crystalcomputer.get(2), ItemList.Circuit_Chip_Ram.get(4),
                                ItemList.Circuit_Chip_NOR.get(32), ItemList.Circuit_Chip_NAND.get(64),
                                GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.NiobiumTitanium, 32)},
                        Materials.SolderingAlloy.getMolten(144L), ItemList.Circuit_Ultimatecrystalcomputer.get(1),
                        400, 9600, true);
                //3
                RA.addCircuitAssemblerSpaceRecipe(
                        new ItemStack[]{ItemList.Circuit_Board_Wetware_Extreme.get(1L),
                                ItemList.Circuit_Neuroprocessor.get(2L), ItemList.Circuit_Parts_Coil.get(32L),
                                ItemList.Circuit_Parts_CapacitorASMD.get(12L), ItemList.Circuit_Chip_Ram.get(24L),
                                GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.YttriumBariumCuprate, 16)},
                        Materials.SolderingAlloy.getMolten(144L), ItemList.Circuit_Wetwarecomputer.get(2L), 300,
                        38400, true);

                //4
                RA.addCircuitAssemblerSpaceRecipe(
                        new ItemStack[]{ItemList.Circuit_Chip_BioCPU.get(1L),
                                ItemList.Circuit_Chip_CrystalSoC2.get(1L), ItemList.Circuit_Chip_NanoCPU.get(2L),
                                ItemList.Circuit_Parts_CapacitorASMD.get(12L),
                                ItemList.Circuit_Parts_TransistorASMD.get(12L),
                                GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.NiobiumTitanium, 16)},
                        Materials.SolderingAlloy.getMolten(72L), ItemList.Circuit_Bioprocessor.get(2L), 300,
                        153600, true);

                RA.addCircuitAssemblerSpaceRecipe(
                        new ItemStack[]{ItemList.Circuit_Chip_BioCPU.get(1L),
                                ItemList.Circuit_Chip_MCrystalCPU.get(1L),
                                GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.NiobiumTitanium, 16),
                                GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.ElectrumFlux, 16)},
                        Materials.SolderingAlloy.getMolten(72L), ItemList.Circuit_Bioprocessor.get(3), 150,
                        2457600, true);

                // --- UV
                //1
                RA.addCircuitAssemblerSpaceRecipe(
                        new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Aluminium, 2),
                                ItemList.Circuit_Ultimatecrystalcomputer.get(2L),
                                ItemList.Circuit_Parts_Coil.get(32L), ItemList.Circuit_Parts_CapacitorASMD.get(16L),
                                ItemList.Circuit_Chip_Ram.get(32L),
                                GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.SuperconductorLuV, 8)},
                        Materials.SolderingAlloy.getMolten(288L), ItemList.Circuit_Crystalmainframe.get(1L), 800,
                        30720, true);

                RA.addCircuitAssemblerSpaceRecipe(
                        new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Oriharukon, 2),
                                ItemList.Circuit_Chip_CrystalSoC.get(2),
                                GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.SuperconductorLuV, 8),
                                GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Americium, 32)},
                        Materials.SolderingAlloy.getMolten(288L), ItemList.Circuit_Crystalmainframe.get(1), 50,
                        8000000, true);
                //2
                RA.addCircuitAssemblerSpaceRecipe(
                        new ItemStack[]{ItemList.Circuit_Board_Wetware_Extreme.get(2L),
                                ItemList.Circuit_Wetwarecomputer.get(2L), ItemList.Circuit_Parts_DiodeASMD.get(8L),
                                ItemList.Circuit_Chip_NOR.get(16L), ItemList.Circuit_Chip_Ram.get(64L),
                                GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.YttriumBariumCuprate, 24)},
                        Materials.SolderingAlloy.getMolten(144L), ItemList.Circuit_Wetwaresupercomputer.get(1L), 600,
                        38400, true);

                //3
                RA.addCircuitAssemblerSpaceRecipe(
                        new ItemStack[]{ItemList.Circuit_Board_Bio_Ultra.get(1L),
                                ItemList.Circuit_Bioprocessor.get(2L), ItemList.Circuit_Parts_Coil.get(48L),
                                ItemList.Circuit_Parts_CapacitorASMD.get(16L), ItemList.Circuit_Chip_Ram.get(32L),
                                GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.NiobiumTitanium, 24)},
                        Materials.SolderingAlloy.getMolten(144L), ItemList.Circuit_Biowarecomputer.get(2L), 400,
                        153600, true);

                // --- UHV
                //1
                RA.addCircuitAssemblerSpaceRecipe(
                        new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Adamantium, 2),
                                ItemList.Circuit_Chip_MCrystalCPU.get(2),
                                GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.SuperconductorZPM, 16),
                                GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Neutronium, 64)},
                        Materials.SolderingAlloy.getMolten(288L), ItemList.Circuit_Wetwaremainframe.get(1), 50,
                        32000000, true);

                RA.addCircuitAssemblerRecipe(
                        new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1),
                                ItemList.Circuit_Chip_CPU.get(2), ItemList.Circuit_Chip_NAND.get(32),
                                ItemList.Circuit_Chip_Ram.get(4),
                                GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.RedAlloy, 16),
                                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Plastic, 4)},
                        Materials.SolderingAlloy.getMolten(144L), ItemList.Tool_DataStick.get(1), 400, 90, true);
                RA.addCircuitAssemblerRecipe(
                        new ItemStack[]{ItemList.Circuit_Board_Epoxy_Advanced.get(1),
                                ItemList.Circuit_Nanoprocessor.get(2), ItemList.Circuit_Chip_Ram.get(4),
                                ItemList.Circuit_Chip_NOR.get(32), ItemList.Circuit_Chip_NAND.get(64),
                                GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Platinum, 32)},
                        Materials.SolderingAlloy.getMolten(144L), ItemList.Tool_DataOrb.get(1), 400, 1200, true);

                //Energy Flow Circuit
                RA.addCircuitAssemblerRecipe(
                        new ItemStack[]{ItemList.Circuit_Board_Multifiberglass_Elite.get(1L),
                                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Ultimate, 2),
                                ItemList.Circuit_Chip_UHPIC.get(4L), ItemList.Circuit_Chip_QuantumCPU.get(2L),
                                ItemList.Circuit_Chip_NanoCPU.get(2L),
                                GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.SuperconductorZPM, 16)},
                        Materials.SolderingAlloy.getMolten(288L), ItemList.Circuit_HighEnergyFlow.get(1L), 2400,
                        7680, true);

                //Lapoorbs
                RA.addCircuitAssemblerRecipe(
                        new ItemStack[]{ItemList.Circuit_Board_Fiberglass_Advanced.get(1),
                                ItemList.Circuit_Chip_PIC.get(4),
                                ItemList.Circuit_Parts_Crystal_Chip_Master.get(24L),
                                ItemList.Circuit_Chip_NanoCPU.get(2),
                                GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Platinum, 16),
                                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Platinum, 8)},
                        Materials.SolderingAlloy.getMolten(144L), ItemList.Energy_LapotronicOrb.get(1), 512, 1024,
                        true);
                //Wetware Board
                RA.addCircuitAssemblerRecipe(
                        new ItemStack[]{ItemList.Circuit_Board_Multifiberglass.get(16L),
                                ItemList.Circuit_Parts_PetriDish.get(1L), ItemList.Electric_Pump_LuV.get(1L),
                                ItemList.Sensor_IV.get(1L),
                                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Elite, 1L),
                                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.NiobiumTitanium, 16L)},
                        Materials.GrowthMediumSterilized.getFluid(4000L),
                        ItemList.Circuit_Board_Wetware.get(16L), 1200, 30720, true);

                //Bio Board
                RA.addCircuitAssemblerRecipe(
                        new ItemStack[]{ItemList.Circuit_Board_Wetware.get(32L),
                                ItemList.Circuit_Parts_PetriDish.get(32L), ItemList.Electric_Pump_UV.get(1L),
                                ItemList.Sensor_LuV.get(2L),
                                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Superconductor, 1L),
                                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Neutronium, 32L)},
                        Materials.BioMediumSterilized.getFluid(16000L), ItemList.Circuit_Board_Bio.get(32L),
                        1200, 500000, true);

                //Crystal Board
                RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Circuit_Board_Bio.get(32L),
                                GT_OreDictUnificator.get(OrePrefixes.pipeTiny, Materials.DraconiumAwakened, 32),
                                ItemList.Electric_Pump_UHV.get(1L), ItemList.Sensor_ZPM.get(2L),
                                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Infinite, 1L),
                                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Oriharukon, 64)},
                        Materials.SuperCoolant.getFluid(12000L), ItemList.Circuit_Board_Crystal.get(32L),
                        1400, 2000000, true);

                // --- Blank Gene Sample
                RA.addCircuitAssemblerRecipe(
                        new ItemStack[]{ItemList.Circuit_Board_Epoxy_Advanced.get(1),
                                ItemList.Circuit_Parts_PetriDish.get(1L), ItemList.Circuit_Chip_CPU.get(2),
                                ItemList.Circuit_Chip_Ram.get(4),
                                GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Platinum, 16),
                                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Europium, 4)},
                        Materials.SolderingAlloy.getMolten(144L),
                        CoreItems2.getRecipe(179, 1), 400, 2560, true);
                // --- Genetic Template
                RA.addCircuitAssemblerRecipe(
                        new ItemStack[]{ItemList.Circuit_Board_Epoxy_Advanced.get(1),
                                ItemList.Circuit_Parts_PetriDish.get(1L), ItemList.Circuit_Chip_Ram.get(4),
                                ItemList.Circuit_Chip_NOR.get(32),
                                GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Platinum, 32),
                                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Europium, 8)},
                        Materials.SolderingAlloy.getMolten(144L),
                        CoreItems2.getRecipe(180, 1), 500, 7680, true);
    }

    private void assemblyLine() {
//Motors
        RA.addAssemblylineRecipe(ItemList.Electric_Motor_IV.get(1, new Object() {
                }), 144000, new ItemStack[]{
                        GT_OreDictUnificator.get(OrePrefixes.stickLong, Materials.NeodymiumMagnetic, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.stickLong, Materials.HSSS, 2L),
                        GT_OreDictUnificator.get(OrePrefixes.ring, Materials.MeteoricSteel, 4L),
                        GT_OreDictUnificator.get(OrePrefixes.round, Materials.MeteoricSteel, 16L),
                        GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.AnnealedCopper, 64L),
                        GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.AnnealedCopper, 64L),
                        GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.AnnealedCopper, 64L),
                        GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.AnnealedCopper, 64L),
                        GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.YttriumBariumCuprate, 2L)
                },
                new FluidStack[]{
                        Materials.SolderingAlloy.getMolten(144),
                        Materials.Lubricant.getFluid(250)
                },
                ItemList.Electric_Motor_LuV.get(1), 600, 6000);

        RA.addAssemblylineRecipe(ItemList.Electric_Motor_LuV.get(1, new Object() {
                }), 144000, new ItemStack[]{
                        GT_OreDictUnificator.get(OrePrefixes.stick, Materials.EuropiumoxideMagnetic, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.stickLong, Materials.Osmiridium, 4L),
                        GT_OreDictUnificator.get(OrePrefixes.ring, Materials.Desh, 6L),
                        GT_OreDictUnificator.get(OrePrefixes.round, Materials.Desh, 24L),
                        GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.NaquadahAlloy, 64L),
                        GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.NaquadahAlloy, 64L),
                        GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.NaquadahAlloy, 64L),
                        GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.NaquadahAlloy, 64L),
                        GT_OreDictUnificator.get(OrePrefixes.cableGt04, Materials.Naquadah, 2L)
                },
                new FluidStack[]{
                        Materials.SolderingAlloy.getMolten(288),
                        Materials.Lubricant.getFluid(750)
                },
                ItemList.Electric_Motor_ZPM.get(1), 600, 24000);

        RA.addAssemblylineRecipe(ItemList.Electric_Motor_ZPM.get(1, new Object() {
                }), 288000, new ItemStack[]{
                        GT_OreDictUnificator.get(OrePrefixes.stick, Materials.EuropiumoxideMagnetic, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.stickLong, Materials.Tritanium, 6L),
                        GT_OreDictUnificator.get(OrePrefixes.ring, Materials.Oriharukon, 8L),
                        GT_OreDictUnificator.get(OrePrefixes.round, Materials.Oriharukon, 32L),
                        GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Americium, 64L),
                        GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Americium, 64L),
                        GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Americium, 64L),
                        GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Americium, 64L),
                        GT_OreDictUnificator.get(OrePrefixes.cableGt04, Materials.NaquadahAlloy, 2L)
                },
                new FluidStack[]{
                        Materials.SolderingAlloy.getMolten(1296),
                        Materials.Lubricant.getFluid(2000),
                        Materials.Naquadria.getMolten(1296)
                },
                ItemList.Electric_Motor_UV.get(1), 600, 100000);

    }

    private void centrifuge() {
        RA.addCentrifugeRecipe(ItemList.AdsorptionFilterDirty.get(1L), GT_Values.NI, GT_Values.NF, Materials.Pollution.getFluid(100), ItemList.AdsorptionFilterCasing.get(1L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Coal, 8L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.DarkAsh, 8L), GT_Values.NI, GT_Values.NI, GT_Values.NI, new int[]{9900, 10000, 10000}, 800, 480);

        // --- Greywacke Dust
        RA.addCentrifugeRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Greywacke, 8L), GT_Values.NI, GT_Values.NF, GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SiliconDioxide, 4L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.CertusQuartz, 1L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Quartzite, 1L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.GarnetRed, 1L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.GarnetYellow, 1L), GT_Values.NI, new int[]{10000, 10000, 10000, 10000, 10000}, 400, 8);

    }

    private void canner() {
        //Air Filter
        RA.addCannerRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Coal, 32L),
                ItemList.AdsorptionFilterCasing.get(1L),
                ItemList.AdsorptionFilter.get(1L),
                null, 100, 120);

        RA.addCannerRecipe(ItemList.Large_Fluid_Cell_TungstenSteel.get(1L),
                Itemstack(Core_Items2.getInstance(), 1, 184),
                ItemList.NaquadahCell_1.get(1L), null, 30, 16);
        RA.addCannerRecipe(ItemList.Large_Fluid_Cell_TungstenSteel.get(1L),
                Itemstack(Core_Items2.getInstance(), 1, 186),
                ItemList.MNqCell_1.get(1L), null, 30, 16);

        RA.addCannerRecipe(GT_ModHandler.getIC2Item("fuelRod", 1),
                CoreItems2.getRecipe(188, 1),
                ItemList.ThoriumCell_1.get(1L), null, 30, 16);
        RA.addCannerRecipe(GT_ModHandler.getIC2Item("fuelRod", 1),
                CoreItems2.getRecipe(189, 1),
                ItemList.MThCell_1.get(1L), null, 30, 16);

    }

    private void distil() {
        RA.addDistillationTowerRecipe(Materials.Pollution.getFluid(1300), new FluidStack[]{Materials.CarbonMonoxide.getGas(50L), Materials.CarbonDioxide.getGas(50L), Materials.HydricSulfide.getGas(50L), Materials.SulfuricAcid.getFluid(50L), Materials.NitrogenDioxide.getGas(50L), Materials.Methane.getGas(50L), Materials.Mercury.getFluid(1L)}, GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Ash, 1L), 600, 480);

        // --- Oils
        RA.addUniversalDistillationRecipe(Materials.OilLight.getFluid(150), new FluidStack[]{Materials.SulfuricHeavyFuel.getFluid(10), Materials.SulfuricLightFuel.getFluid(20), Materials.SulfuricNaphtha.getFluid(30), Materials.SulfuricGas.getGas(240)}, CoreItems.getRecipe(50, 1), 20, 96);
        RA.addUniversalDistillationRecipe(Materials.OilMedium.getFluid(100), new FluidStack[]{Materials.SulfuricHeavyFuel.getFluid(15), Materials.SulfuricLightFuel.getFluid(50), Materials.SulfuricNaphtha.getFluid(20), Materials.SulfuricGas.getGas(60)}, CoreItems.getRecipe(50, 1), 20, 96);
        RA.addUniversalDistillationRecipe(Materials.Oil.getFluid(50L), new FluidStack[]{Materials.SulfuricHeavyFuel.getFluid(15), Materials.SulfuricLightFuel.getFluid(50), Materials.SulfuricNaphtha.getFluid(20), Materials.SulfuricGas.getGas(60)}, CoreItems.getRecipe(50, 1), 20, 96);
        RA.addUniversalDistillationRecipe(Materials.OilHeavy.getFluid(100), new FluidStack[]{Materials.SulfuricHeavyFuel.getFluid(250), Materials.SulfuricLightFuel.getFluid(45), Materials.SulfuricNaphtha.getFluid(15), Materials.SulfuricGas.getGas(60)}, CoreItems.getRecipe(50, 2), 20, 288);
        RA.addUniversalDistillationRecipe(new FluidStack(ItemList.sOilExtraHeavy, 100), new FluidStack[]{Materials.SulfuricHeavyFuel.getFluid(750), Materials.SulfuricTar.getFluid(200), Materials.SulfuricLightFuel.getFluid(90), Materials.SulfuricNaphtha.getFluid(60), Materials.SulfuricGas.getGas(360)}, CoreItems.getRecipe(50, 4), 20, 430);

        if (GregTech_API.sSpecialFile.get("general", "EnableLagencyOilGalactiCraft", false) && FluidRegistry.getFluid("oilgc") != null) {
            RA.addUniversalDistillationRecipe(new FluidStack(FluidRegistry.getFluid("oilgc"), 50), new FluidStack[]{Materials.SulfuricHeavyFuel.getFluid(15), Materials.SulfuricLightFuel.getFluid(50), Materials.SulfuricNaphtha.getFluid(20), Materials.SulfuricGas.getGas(60)}, CoreItems.getRecipe(50, 1), 20, 96);
        }

    }
	
	private void wormhole() {
		//Tiny Wormhole
        RA.addTinyWormHoleRecipe(GT_Values.NI, Materials.EnrichedNaquadria.getFluid(1000L), GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Duranium, 54L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Europium, 45L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Plutonium241, 36L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.NaquadahEnriched, 33L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Trinium, 26L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Californium, 23L), new int[]{10000, 10000, 10000, 10000, 10000, 10000}, 200, 2000000);

	}

    private void implosionCompressor() {
        // --- Amethyst
        RA.addImplosionRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Amethyst, 4L), 24,
                GT_OreDictUnificator.get(OrePrefixes.gem, Materials.Amethyst, 3L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.DarkAshes, 2L), new int[]{10000, 10000}
        );
    }

    private void fluidExtractor() {
        // --- Tar from Coal Coke
        RA.addFluidExtractionRecipe(GT_OreDictUnificator.get(OrePrefixes.gem, Materials.CokeCoal, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Ash, 1L),
                Materials.Tar.getFluid(100L), 2000, 30, 16);
    }
}
