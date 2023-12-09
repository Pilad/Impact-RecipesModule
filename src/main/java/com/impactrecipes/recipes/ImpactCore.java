package com.impactrecipes.recipes;

import com.github.technus.tectech.thing.CustomItemList;
import com.impact.common.item.Core_Items;
import com.impact.common.item.Core_Items2;
import com.impact.common.item.DrillHeads;
import com.impact.common.item.WoodBrickFormTool;
import com.impact.common.te.TE_DryingRack;
import com.impact.impact;
import com.impact.loader.ItemRegistery;
import com.impact.mods.gregtech.GT_ItemList;
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
import net.minecraftforge.oredict.OreDictionary;

import static com.impact.common.item.Core_List_Items.*;
import static com.impact.loader.ItemRegistery.*;
import static com.impact.mods.gregtech.GT_ItemList.Casing_Farm;
import static com.impact.util.Utilits.Blockstack;
import static com.impact.util.Utilits.Itemstack;
import static gregtech.api.enums.GT_Values.RA;
import static gregtech.api.util.GT_ModHandler.RecipeBits.DELETE_ALL_OTHER_RECIPES;

public class ImpactCore implements Runnable {
	
	public static final Core_Items CoreItems = Core_Items.getInstance();
	public static final Core_Items2 CoreItems2 = Core_Items2.getInstance();
	private static final long bits = GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE | GT_ModHandler.RecipeBits.DISMANTLEABLE | GT_ModHandler.RecipeBits.BUFFERED;
	private static final long bits2 = GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE | GT_ModHandler.RecipeBits.DISMANTLEABLE | GT_ModHandler.RecipeBits.BUFFERED | DELETE_ALL_OTHER_RECIPES;
	private static final long tBitMask = GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE/* | GT_ModHandler.RecipeBits.REVERSIBLE*/;
	private static final String AE2 = "appliedenergistics2";
	private final static long bitsd = GT_ModHandler.RecipeBits.DISMANTLEABLE | bits;
	final WoodBrickFormTool WoodForm = WoodBrickFormTool.getInstance(); //вуд форма
	
	@Override
	public void run() {
		hand();
		furnace();
		unboxing();
		pulverizer();
		printer3d();
		mixer();
		lathe();
		implosionCompressor();
		formingPress();
		fluidExtractor();
		woodFarm();
		extruder();
		extractor();
		ebf();
		centrifuge();
		alloySmelter();
		assembler();
		cutting();
		compressor();
		chemical();
		bath();
		ciruit();
		assemblyLine();
		wireassembler();
		disassembler();
		cyclon();
		tesseract();
		drying();
		arcFurnace();
		forgeHammer();
	}
	
	private void hand() {
		final Object[] tfft_recipe = {
				"HFH", "PVP", "CFC",
				'H', OrePrefixes.pipeMedium.get(Materials.Titanium),
				'F', ItemList.Field_Generator_MV.get(1L),
				'P', ItemList.Electric_Pump_HV.get(1L),
				'V', ItemList.Hull_HV.get(1L),
				'C', OrePrefixes.circuit.get(Materials.Data)};
		GT_ModHandler.addCraftingRecipe(GT_ItemList.Multi_Tank.get(1), tfft_recipe);
		//SingleTank
		final Object[] singletank_recipe = {
				"HFH", "PVP", "CFC",
				'H', OrePrefixes.pipeMedium.get(Materials.StainlessSteel),
				'F', ItemList.Field_Generator_LV.get(1L),
				'P', ItemList.Electric_Pump_MV.get(1L),
				'V', ItemList.Hull_MV.get(1L),
				'C', OrePrefixes.circuit.get(Materials.Data)};
		GT_ModHandler.addCraftingRecipe(GT_ItemList.Single_Tank.get(1), singletank_recipe);
		
		final Object[] tank_hatch = {
				"PRP", "UFU", "PRP",
				'P', GT_OreDictUnificator.get(OrePrefixes.pipeHuge, Materials.Titanium, 1),
				'R', ItemList.Hatch_Output_EV.get(1L),
				'U', ItemList.Hatch_Input_EV.get(1L),
				'F', ItemList.Electric_Pump_HV.get(1L)};
		GT_ModHandler.addCraftingRecipe(GT_ItemList.Tank_Hatch.get(1), tank_hatch);
		
		GT_ModHandler.addCraftingRecipe(GT_ItemList.ULVConveyorModule.get(1L), GT_ModHandler.RecipeBits.DISMANTLEABLE | GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE, new Object[]{"PPP", "MWM", "PPP", 'P', GT_ModHandler.getModItem("minecraft", "leather", 1L, 0), 'M', GT_ItemList.ULVMotor, 'W', OrePrefixes.cableGt01.get(Materials.Lead)});
		GT_ModHandler.addCraftingRecipe(GT_ItemList.ULVConveyorModule.get(1L), GT_ModHandler.RecipeBits.DISMANTLEABLE | GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE, new Object[]{"PPP", "MWM", "PPP", 'P', OrePrefixes.plate.get(Materials.Rubber), 'M', GT_ItemList.ULVMotor, 'W', OrePrefixes.cableGt01.get(Materials.Lead)});
		GT_ModHandler.addCraftingRecipe(GT_ItemList.ULVPump.get(1L), GT_ModHandler.RecipeBits.DISMANTLEABLE | GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE, new Object[]{"SXO", "dPw", "OMS", 'M', GT_ItemList.ULVMotor, 'O', OrePrefixes.ring.get(Materials.Paper), 'X', OrePrefixes.rotor.get(Materials.Lead), 'S', OrePrefixes.screw.get(Materials.Lead), 'P', OrePrefixes.pipeMedium.get(Materials.Copper)});
		GT_ModHandler.addCraftingRecipe(GT_ItemList.ULVPump.get(1L), GT_ModHandler.RecipeBits.DISMANTLEABLE | GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE, new Object[]{"SXO", "dPw", "OMS", 'M', GT_ItemList.ULVMotor, 'O', OrePrefixes.ring.get(Materials.Rubber), 'X', OrePrefixes.rotor.get(Materials.Lead), 'S', OrePrefixes.screw.get(Materials.Lead), 'P', OrePrefixes.pipeMedium.get(Materials.Copper)});
		GT_ModHandler.addCraftingRecipe(GT_ItemList.ULVPump.get(1L), GT_ModHandler.RecipeBits.DISMANTLEABLE | GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE, new Object[]{"SXO", "dPw", "OMS", 'M', GT_ItemList.ULVMotor, 'O', OrePrefixes.ring.get(Materials.StyreneButadieneRubber), 'X', OrePrefixes.rotor.get(Materials.Lead), 'S', OrePrefixes.screw.get(Materials.Lead), 'P', OrePrefixes.pipeMedium.get(Materials.Copper)});
		GT_ModHandler.addCraftingRecipe(GT_ItemList.ULVMotor.get(1L), GT_ModHandler.RecipeBits.DISMANTLEABLE | GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE, new Object[]{"CWR", "WIW", "RWC", 'I', OrePrefixes.bolt.get(Materials.IronMagnetic), 'R', OrePrefixes.stick.get(Materials.Iron), 'W', OrePrefixes.wireFine.get(Materials.Tin), 'C', OrePrefixes.cableGt01.get(Materials.Lead)});
		GT_ModHandler.addCraftingRecipe(GT_ItemList.ULVRobotArm.get(1L), GT_ModHandler.RecipeBits.DISMANTLEABLE | GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE, new Object[]{"CCC", "MSM", "PES", 'S', OrePrefixes.stick.get(Materials.WroughtIron), 'M', GT_ItemList.ULVMotor, 'P', GT_ItemList.ULVPiston, 'E', OrePrefixes.circuit.get(Materials.Primitive), 'C', OrePrefixes.cableGt01.get(Materials.Lead)});
		GT_ModHandler.addCraftingRecipe(GT_ItemList.ULVPiston.get(1L), GT_ModHandler.RecipeBits.DISMANTLEABLE | GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE, new Object[]{"CPP", "dSS", "CMG", 'P', OrePrefixes.plate.get(Materials.WroughtIron), 'S', OrePrefixes.stick.get(Materials.WroughtIron), 'G', OrePrefixes.gearGtSmall.get(Materials.WroughtIron), 'M', GT_ItemList.ULVMotor, 'C', OrePrefixes.screw.get(Materials.WroughtIron)});
		
		
		GT_ModHandler.addCraftingRecipe(GT_ItemList.Generator_Semi_Turbine_ULV.get(1L), bitsd, new Object[]{"GCG", "EME", "PWP", 'M', ItemList.Hull_ULV, 'P', GT_ItemList.ULVPiston, 'E', GT_ItemList.ULVMotor, 'C', OrePrefixes.circuit.get(Materials.Primitive), 'W', OrePrefixes.cableGt01.get(Materials.Lead), 'G', OrePrefixes.gearGt.get(Materials.WroughtIron)});
		GT_ModHandler.addCraftingRecipe(GT_ItemList.Generator_Steam_Turbine_ULV.get(1L), bitsd, new Object[]{"PCP", "RHR", "EWE", 'H', ItemList.Hull_ULV, 'E', GT_ItemList.ULVMotor, 'R', OrePrefixes.rotor.get(Materials.Lead), 'C', OrePrefixes.circuit.get(Materials.Primitive), 'W', OrePrefixes.cableGt01.get(Materials.Lead), 'P', OrePrefixes.pipeSmall.get(Materials.Lead)});
		GT_ModHandler.addCraftingRecipe(GT_ItemList.Generator_Diesel_ULV.get(1L), bitsd, new Object[]{"PCP", "EME", "GWG", 'M', ItemList.Hull_ULV, 'P', GT_ItemList.ULVPiston, 'E', GT_ItemList.ULVMotor, 'C', OrePrefixes.circuit.get(Materials.Primitive), 'W', OrePrefixes.cableGt01.get(Materials.Lead), 'G', OrePrefixes.gearGt.get(Materials.WroughtIron)});
		GT_ModHandler.addCraftingRecipe(GT_ItemList.Generator_Gas_Turbine_ULV.get(1L), bitsd, new Object[]{"CRC", "RHR", "EWE", 'H', ItemList.Hull_ULV, 'E', GT_ItemList.ULVMotor, 'R', OrePrefixes.rotor.get(Materials.Lead), 'C', OrePrefixes.circuit.get(Materials.Primitive), 'W', OrePrefixes.cableGt01.get(Materials.Lead)});
		GT_ModHandler.addCraftingRecipe(GT_ItemList.Machine_ULV_Assembler.get(1L), bitsd, new Object[]{"RCR", "OMO", "WCW", 'M', ItemList.Hull_ULV, 'R', GT_ItemList.ULVRobotArm, 'O', GT_ItemList.ULVConveyorModule, 'C', OrePrefixes.circuit.get(Materials.Primitive), 'W', OrePrefixes.cableGt01.get(Materials.Lead)});
		GT_ModHandler.addCraftingRecipe(ItemList.Casing_CokeOvenBrick.get(1L), bits, new Object[]{"BB", "BB", 'B', CoreItems2.getRecipe(CokeOvenBrick.getMetaID(), 1)});
		GT_ModHandler.addCraftingRecipe(GT_ItemList.Hatch_Output_Prim.get(1L), bitsd, new Object[]{"CBC", " C ", 'B', ItemList.Casing_CokeOvenBrick.get(1L), 'C', new ItemStack(Blocks.stone_slab, 1, 0)});
		GT_ModHandler.addCraftingRecipe(GT_ItemList.Bus_Input_Prim.get(1L), bitsd, new Object[]{"C", "B", 'B', ItemList.Casing_CokeOvenBrick.get(1L), 'C', new ItemStack(Blocks.chest, 1, 32767)});
		GT_ModHandler.addCraftingRecipe(GT_ItemList.Bus_Output_Prim.get(1L), bitsd, new Object[]{"B", "C", 'B', ItemList.Casing_CokeOvenBrick.get(1L), 'C', new ItemStack(Blocks.chest, 1, 32767)});
		GT_ModHandler.addCraftingRecipe(GT_ItemList.Machine_CokeOven.get(1L), bitsd, new Object[]{" B ", "BFB", " B ", 'B', CoreItems2.getRecipe(CokeOvenBrick.getMetaID(), 1), 'F', OreDictNames.craftingFurnace});
		GT_ModHandler.addCraftingRecipe(GT_ItemList.Generator_Semi_Turbine_LV.get(1L), bitsd, new Object[]{"GCG", "EME", "PWP", 'M', ItemList.Hull_LV, 'P', ItemList.Electric_Piston_LV, 'E', ItemList.Electric_Motor_LV, 'C', OrePrefixes.circuit.get(Materials.Basic), 'W', OrePrefixes.cableGt01.get(Materials.Tin), 'G', OrePrefixes.gearGt.get(Materials.Steel)});
		GT_ModHandler.addCraftingRecipe(GT_ItemList.Generator_Semi_Turbine_MV.get(1L), bitsd, new Object[]{"GCG", "EME", "PWP", 'M', ItemList.Hull_MV, 'P', ItemList.Electric_Piston_MV, 'E', ItemList.Electric_Motor_MV, 'C', OrePrefixes.circuit.get(Materials.Good), 'W', OrePrefixes.cableGt01.get(Materials.Copper), 'G', OrePrefixes.gearGt.get(Materials.Aluminium)});
		GT_ModHandler.addCraftingRecipe(GT_ItemList.Generator_Semi_Turbine_HV.get(1L), bitsd, new Object[]{"GCG", "EME", "PWP", 'M', ItemList.Hull_HV, 'P', ItemList.Electric_Piston_HV, 'E', ItemList.Electric_Motor_HV, 'C', OrePrefixes.circuit.get(Materials.Advanced), 'W', OrePrefixes.cableGt01.get(Materials.Gold), 'G', OrePrefixes.gearGt.get(Materials.StainlessSteel)});
		GT_ModHandler.addCraftingRecipe(GT_ItemList.Machine_Multi_Farm.get(1L), bitsd, new Object[]{"ROR", "CHC", "PWP", 'H', ItemList.Hull_MV, 'W', OrePrefixes.cableGt02.get(Materials.Copper), 'C', OrePrefixes.circuit.get(Materials.Good), 'P', ItemList.Electric_Pump_MV, 'R', ItemList.Robot_Arm_MV, 'O', OreDictNames.craftingDiamondBlade});
		GT_ModHandler.addCraftingRecipe(GT_ItemList.Generator_Semi_Turbine_EV.get(1L), bitsd, new Object[]{"GCG", "EME", "PWP", 'M', ItemList.Hull_EV, 'P', ItemList.Electric_Piston_EV, 'E', ItemList.Electric_Motor_EV, 'C', OrePrefixes.circuit.get(Materials.Data), 'W', OrePrefixes.cableGt01.get(Materials.Aluminium), 'G', OrePrefixes.gearGt.get(Materials.Titanium)});
		GT_ModHandler.addCraftingRecipe(GT_ItemList.Generator_Steam_Turbine_EV.get(1L), bitsd, new Object[]{"PCP", "RHR", "EWE", 'H', ItemList.Hull_EV, 'E', ItemList.Electric_Motor_EV, 'R', OrePrefixes.rotor.get(Materials.StainlessSteel), 'C', OrePrefixes.circuit.get(Materials.Data), 'W', OrePrefixes.cableGt01.get(Materials.Aluminium), 'P', OrePrefixes.pipeLarge.get(Materials.Titanium)});
		GT_ModHandler.addCraftingRecipe(GT_ItemList.Generator_Diesel_EV.get(1L), bitsd, new Object[]{"PCP", "EME", "GWG", 'M', ItemList.Hull_EV, 'P', ItemList.Electric_Piston_EV, 'E', ItemList.Electric_Motor_EV, 'C', OrePrefixes.circuit.get(Materials.Data), 'W', OrePrefixes.cableGt01.get(Materials.Aluminium), 'G', OrePrefixes.gearGt.get(Materials.Titanium)});
		
		//Portable Tank
		GT_ModHandler.addCraftingRecipe(GT_ItemList.Portable_Tank_ULV.get(1L), tBitMask, new Object[]{"SPS", "PTP", "hPC", 'T', ItemList.Large_Fluid_Cell_Steel.get(1L), 'P', OrePrefixes.plateDouble.get(Materials.Lead), 'S', OrePrefixes.screw.get(Materials.WroughtIron), 'C', ToolDictNames.craftingToolScrewdriver});
		
		//Potin Alloy
		GT_ModHandler.addShapelessCraftingRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Potin, 9L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{OrePrefixes.dust.get(Materials.Copper), OrePrefixes.dust.get(Materials.Copper), OrePrefixes.dust.get(Materials.Copper), OrePrefixes.dust.get(Materials.Copper), OrePrefixes.dust.get(Materials.Copper), OrePrefixes.dust.get(Materials.Copper), OrePrefixes.dust.get(Materials.Tin), OrePrefixes.dust.get(Materials.Tin), OrePrefixes.dust.get(Materials.Lead)});
		
		//Wooden Brick Form
		GT_ModHandler.addShapelessCraftingRecipe(WoodForm.getRecipe(1), tBitMask, new Object[]{ToolDictNames.craftingToolKnife, CoreItems2.getRecipe(197, 1)});
		
		//Bricks
		GT_ModHandler.addCraftingRecipe(CoreItems2.getRecipe(UnfiredClayBrick.getMetaID(), 8), tBitMask, new Object[]{"CCC", "CFC", "CCC", 'C', new ItemStack(Items.clay_ball, 1, 0), 'F', WoodForm.get()});
		GT_ModHandler.addShapelessCraftingRecipe(CoreItems2.getRecipe(UnfiredClayBrick.getMetaID(), 1), tBitMask, new Object[]{new ItemStack(Items.clay_ball, 1, 0), WoodForm.get()});
		GT_ModHandler.addCraftingRecipe(CoreItems2.getRecipe(UnfiredCokeOvenBrick.getMetaID(), 3), tBitMask, new Object[]{"CCC", "SFS", "SSS", 'C', new ItemStack(Items.clay_ball, 1, 0), 'S', new ItemStack(Blocks.sand, 1, 0), 'F', WoodForm.get()});
		GT_ModHandler.addShapelessCraftingRecipe(CoreItems2.getRecipe(UnfiredCokeOvenBrick.getMetaID(), 1), tBitMask, new Object[]{new ItemStack(Items.clay_ball, 1, 0), new ItemStack(Blocks.sand, 1, 0), OrePrefixes.block.get(Materials.Sand), WoodForm.get()});
		
		GT_ModHandler.addCraftingRecipe(CoreItems2.getRecipe(SteelBars.getMetaID(), 3), tBitMask, new Object[]{" h ", "SSS", "SSS", 'S', OrePrefixes.stick.get(Materials.Steel)});
		GT_ModHandler.addCraftingRecipe(GT_ItemList.Casing_Farm.get(1L), tBitMask, new Object[]{"ThT", "TFT", "TwT", 'T', CoreItems2.getRecipe(SteelBars.getMetaID(), 1), 'F', OrePrefixes.frameGt.get(Materials.Steel)});
		GT_ModHandler.addCraftingRecipe(CoreItems.getRecipe(DustSmallFertilizer.getMetaID(), 4), tBitMask, new Object[]{" D", "  ", 'D', GT_ModHandler.getModItem("IC2", "itemFertilizer", 1L, 0)});
		GT_ModHandler.addCraftingRecipe(CoreItems.getRecipe(DustTinyFertilizer.getMetaID(), 9), tBitMask, new Object[]{"D ", "  ", 'D', GT_ModHandler.getModItem("IC2", "itemFertilizer", 1L, 0)});
		GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("IC2", "itemFertilizer", 1L, 0), tBitMask, new Object[]{"DD", "DD", 'D', CoreItems.getRecipe(DustSmallFertilizer.getMetaID(), 4)});
		GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("IC2", "itemFertilizer", 1L, 0), tBitMask, new Object[]{"DDD", "DDD", "DDD", 'D', CoreItems.getRecipe(DustTinyFertilizer.getMetaID(), 9)});
		
		GT_ModHandler.addCraftingRecipe(CoreItems2.getRecipe(UnfiredClayBrick.getMetaID(), 8), tBitMask, new Object[]{"CCC", "CFC", "CCC", ('C'), new ItemStack(Items.clay_ball, 1, 0), ('F'), new ItemStack(WoodBrickFormTool.WoodBrickFormTool, 1, OreDictionary.WILDCARD_VALUE)});
		GT_ModHandler.addCraftingRecipe(CoreItems2.getRecipe(UnfiredCokeOvenBrick.getMetaID(), 3), tBitMask, new Object[]{"CCC", "SFS", "SSS", ('S'), GT_ModHandler.getModItem("minecraft", "sand", 1L, 0), ('C'), new ItemStack(Items.clay_ball, 1, 0), ('F'), new ItemStack(WoodBrickFormTool.WoodBrickFormTool, 1, OreDictionary.WILDCARD_VALUE)});
		GT_ModHandler.addCraftingRecipe(ItemList.CompressedFireclay.get(8), tBitMask, new Object[]{"CCC", "TFT", "CCC", 'C', OrePrefixes.dust.get(Materials.Clay), 'T', CoreItems.getRecipe(ConcreteDust.getMetaID(), 1), ('F'), new ItemStack(WoodBrickFormTool.WoodBrickFormTool, 1, OreDictionary.WILDCARD_VALUE)});
		
		GT_ModHandler.addShapelessCraftingRecipe(CoreItems.getRecipe(37, 4), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{OrePrefixes.dust.get(Materials.Stone), OrePrefixes.dust.get(Materials.Stone), OrePrefixes.dust.get(Materials.Gypsum), OrePrefixes.dust.get(Materials.Calcite)});
		GT_ModHandler.addShapelessCraftingRecipe(CoreItems.getRecipe(37, 4), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{OrePrefixes.dust.get(Materials.Stone), OrePrefixes.dust.get(Materials.Stone), OrePrefixes.dust.get(Materials.Gypsum), OrePrefixes.dust.get(Materials.Marble)});
		GT_ModHandler.addShapelessCraftingRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Fireclay, 4L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{OrePrefixes.dust.get(Materials.Clay), OrePrefixes.dust.get(Materials.Clay), OrePrefixes.dust.get(Materials.Clay), CoreItems.getRecipe(37, 1)});
		
		GT_ModHandler.addCraftingRecipe(CoreItems2.getRecipe(98, 1), tBitMask, new Object[]{"PRP", "ICI", "PMP", 'P', CoreItems2.getRecipe(84, 1), 'R', OrePrefixes.rotor.get(Materials.Iridium), 'M', ItemList.Electric_Motor_ZPM, 'I', ItemList.Neutron_Reflector, 'C', ItemList.Reactor_Coolant_Le_3});
		
		//IC2 Batteries
		GT_ModHandler.addShapelessCraftingRecipe(ItemList.EnergyCrystal.get(1), tBitMask, new Object[]{OrePrefixes.battery.get(Materials.Elite)});
		GT_ModHandler.addShapelessCraftingRecipe(ItemList.LapotronCrystal.get(1), tBitMask, new Object[]{OrePrefixes.battery.get(Materials.Master)});
		
		//Rods
		GT_ModHandler.addCraftingRecipe(CoreItems2.getRecipe(177, 1), tBitMask, new Object[]{"f ", " S", 'S', new ItemStack(Blocks.cobblestone)});
		GT_ModHandler.addCraftingRecipe(CoreItems2.getRecipe(178, 1), tBitMask, new Object[]{"f ", " S", 'S', new ItemStack(Blocks.sandstone)});
		
		/**====START SOLAR COVER====*/
		GT_ModHandler.addCraftingRecipe(CoreItems2.getRecipe(109, 1), tBitMask, new Object[]{"PAP", "ACA", "PAP", 'C', CoreItems2.getRecipe(101, 1), 'A', OrePrefixes.plateAlloy.get(Materials.Carbon), 'P', OrePrefixes.plateAlloy.get(Materials.Advanced)});
		GT_ModHandler.addCraftingRecipe(CoreItems2.getRecipe(110, 1), tBitMask, new Object[]{"PAP", "ACA", "PAP", 'C', CoreItems2.getRecipe(102, 1), 'A', OrePrefixes.plate.get(Materials.Silicon), 'P', OrePrefixes.plateAlloy.get(Materials.Advanced)});
		GT_ModHandler.addCraftingRecipe(CoreItems2.getRecipe(111, 1), tBitMask, new Object[]{"PAP", "ACA", "PAP", 'C', CoreItems2.getRecipe(103, 1), 'A', OrePrefixes.plate.get(Materials.Tungsten), 'P', OrePrefixes.plateAlloy.get(Materials.Advanced)});
		GT_ModHandler.addCraftingRecipe(CoreItems2.getRecipe(112, 1), tBitMask, new Object[]{"PAP", "ACA", "PAP", 'C', CoreItems2.getRecipe(104, 1), 'A', OrePrefixes.plate.get(Materials.TungstenSteel), 'P', OrePrefixes.plateAlloy.get(Materials.Advanced)});
		GT_ModHandler.addCraftingRecipe(CoreItems2.getRecipe(113, 1), tBitMask, new Object[]{"PAP", "ACA", "PAP", 'C', CoreItems2.getRecipe(105, 1), 'A', OrePrefixes.plate.get(Materials.Diamond), 'P', OrePrefixes.plateAlloy.get(Materials.Advanced)});
		GT_ModHandler.addCraftingRecipe(CoreItems2.getRecipe(114, 1), tBitMask, new Object[]{"PAP", "ACA", "PAP", 'C', CoreItems2.getRecipe(106, 1), 'A', OrePrefixes.plateAlloy.get(Materials.Iridium), 'P', OrePrefixes.plateAlloy.get(Materials.Advanced)});
		GT_ModHandler.addCraftingRecipe(CoreItems2.getRecipe(115, 1), tBitMask, new Object[]{"PAP", "ACA", "PAP", 'C', CoreItems2.getRecipe(107, 1), 'A', OrePrefixes.plate.get(Materials.MysteriousCrystal), 'P', OrePrefixes.plateAlloy.get(Materials.Advanced)});
		GT_ModHandler.addCraftingRecipe(CoreItems2.getRecipe(116, 1), tBitMask, new Object[]{"PAP", "ACA", "PAP", 'C', CoreItems2.getRecipe(108, 1), 'A', OrePrefixes.plate.get(Materials.BlackPlutonium), 'P', OrePrefixes.plateAlloy.get(Materials.Advanced)});
		
		/*====END SOLAR COVER====*/
		/**====START SPACE ADDITION====*/
		GT_ModHandler.addCraftingRecipe(CoreItems2.getRecipe(97, 1), tBitMask, new Object[]{"SdS", "BTA", "ShS", 'T', GT_ModHandler.getModItem("GalacticraftCore", "item.basicItem", 1L, 9), 'S', OrePrefixes.screw.get(Materials.StainlessSteel), 'B', GT_ModHandler.getModItem("GalaxySpace", "item.CompressedDualBronze", 1L, 0), 'A', GT_ModHandler.getModItem("GalaxySpace", "item.CompressedDualAluminium", 1L, 0)});
		
		GT_ModHandler.addCraftingRecipe(CoreItems2.getRecipe(HeavyDutyNoseConeTier4.getMetaID(), 1), tBitMask, new Object[]{"dNh", "SPS", "PAP", 'N', GT_ModHandler.getModItem("GalacticraftMars", "item.heavyNoseCone", 1L), 'S', OrePrefixes.screw.get(Materials.Osmiridium), 'P', CoreItems2.getRecipe(80, 1), 'A', CoreItems2.getRecipe(11, 1)});
		GT_ModHandler.addCraftingRecipe(CoreItems2.getRecipe(HeavyDutyNoseConeTier5.getMetaID(), 1), tBitMask, new Object[]{"dNh", "SPS", "PAP", 'N', CoreItems2.getRecipe(HeavyDutyNoseConeTier4.getMetaID(), 1), 'S', OrePrefixes.screw.get(Materials.Duranium), 'P', OrePrefixes.plateTriple.get(Materials.NaquadahAlloy), 'A', CoreItems2.getRecipe(12, 1)});
		GT_ModHandler.addCraftingRecipe(CoreItems2.getRecipe(HeavyDutyNoseConeTier6.getMetaID(), 1), tBitMask, new Object[]{"dNh", "SPS", "PAP", 'N', CoreItems2.getRecipe(HeavyDutyNoseConeTier5.getMetaID(), 1), 'S', OrePrefixes.screw.get(Materials.Tritanium), 'P', CoreItems2.getRecipe(83, 1), 'A', CoreItems2.getRecipe(13, 1)});
		GT_ModHandler.addCraftingRecipe(CoreItems2.getRecipe(HeavyDutyNoseConeTier7.getMetaID(), 1), tBitMask, new Object[]{"dNh", "SPS", "PAP", 'N', CoreItems2.getRecipe(HeavyDutyNoseConeTier6.getMetaID(), 1), 'S', OrePrefixes.screw.get(Materials.Neutronium), 'P', CoreItems2.getRecipe(85, 1), 'A', CoreItems2.getRecipe(14, 1)});
		GT_ModHandler.addCraftingRecipe(CoreItems2.getRecipe(HeavyDutyNoseConeTier8.getMetaID(), 1), tBitMask, new Object[]{"dNh", "SPS", "PAP", 'N', CoreItems2.getRecipe(HeavyDutyNoseConeTier7.getMetaID(), 1), 'S', OrePrefixes.screw.get(Materials.Phoenixite), 'P', CoreItems2.getRecipe(77, 1), 'A', CoreItems2.getRecipe(15, 1)});
		
		GT_ModHandler.addCraftingRecipe(CoreItems2.getRecipe(HeavyDutyRocketEngineTier4.getMetaID(), 1), tBitMask, new Object[]{"PIP", "PSP", "BEB", 'I', OrePrefixes.pipeTiny.get(Materials.NiobiumTitanium), 'S', ItemList.Electric_Piston_LuV, 'B', CoreItems2.getRecipe(36, 1), 'P', CoreItems2.getRecipe(11, 1), 'E', GT_ModHandler.getModItem("GalacticraftMars", "item.itemBasicAsteroids", 1L, 1)});
		GT_ModHandler.addCraftingRecipe(CoreItems2.getRecipe(HeavyDutyRocketEngineTier5.getMetaID(), 1), tBitMask, new Object[]{"PIP", "PSP", "BEB", 'I', OrePrefixes.pipeTiny.get(Materials.Enderium), 'S', ItemList.Electric_Piston_ZPM, 'B', CoreItems2.getRecipe(37, 1), 'P', CoreItems2.getRecipe(12, 1), 'E', CoreItems2.getRecipe(26, 1)});
		GT_ModHandler.addCraftingRecipe(CoreItems2.getRecipe(HeavyDutyRocketEngineTier6.getMetaID(), 1), tBitMask, new Object[]{"PIP", "PSP", "BEB", 'I', OrePrefixes.pipeTiny.get(Materials.Naquadah), 'S', ItemList.Electric_Piston_UV, 'B', CoreItems2.getRecipe(38, 1), 'P', CoreItems2.getRecipe(13, 1), 'E', CoreItems2.getRecipe(27, 1)});
		GT_ModHandler.addCraftingRecipe(CoreItems2.getRecipe(HeavyDutyRocketEngineTier7.getMetaID(), 1), tBitMask, new Object[]{"PIP", "PSP", "BEB", 'I', OrePrefixes.pipeTiny.get(Materials.Duranium), 'S', ItemList.Electric_Piston_UHV, 'B', CoreItems2.getRecipe(39, 1), 'P', CoreItems2.getRecipe(14, 1), 'E', CoreItems2.getRecipe(28, 1)});
		GT_ModHandler.addCraftingRecipe(CoreItems2.getRecipe(HeavyDutyRocketEngineTier8.getMetaID(), 1), tBitMask, new Object[]{"PIP", "PSP", "BEB", 'I', OrePrefixes.pipeTiny.get(Materials.Neutronium), 'S', ItemList.Electric_Piston_UEV, 'B', CoreItems2.getRecipe(40, 1), 'P', CoreItems2.getRecipe(15, 1), 'E', CoreItems2.getRecipe(29, 1)});
		
		GT_ModHandler.addCraftingRecipe(CoreItems2.getRecipe(HeavyDutyRocketFinsTier4.getMetaID(), 1), tBitMask, new Object[]{"fPh", "APA", "ACA", 'P', CoreItems2.getRecipe(11, 1), 'C', CoreItems2.getRecipe(92, 1), 'A', GT_ModHandler.getModItem("GalacticraftMars", "item.itemBasicAsteroids", 1L)});
		GT_ModHandler.addCraftingRecipe(CoreItems2.getRecipe(HeavyDutyRocketFinsTier5.getMetaID(), 1), tBitMask, new Object[]{"fPh", "APA", "ACA", 'P', CoreItems2.getRecipe(12, 1), 'C', CoreItems2.getRecipe(91, 1), 'A', CoreItems2.getRecipe(11, 1)});
		GT_ModHandler.addCraftingRecipe(CoreItems2.getRecipe(HeavyDutyRocketFinsTier6.getMetaID(), 1), tBitMask, new Object[]{"fPh", "APA", "ACA", 'P', CoreItems2.getRecipe(13, 1), 'C', CoreItems2.getRecipe(94, 1), 'A', CoreItems2.getRecipe(12, 1)});
		GT_ModHandler.addCraftingRecipe(CoreItems2.getRecipe(HeavyDutyRocketFinsTier7.getMetaID(), 1), tBitMask, new Object[]{"fPh", "APA", "ACA", 'P', CoreItems2.getRecipe(14, 1), 'C', CoreItems2.getRecipe(95, 1), 'A', CoreItems2.getRecipe(13, 1)});
		GT_ModHandler.addCraftingRecipe(CoreItems2.getRecipe(HeavyDutyRocketFinsTier8.getMetaID(), 1), tBitMask, new Object[]{"fPh", "APA", "ACA", 'P', CoreItems2.getRecipe(15, 1), 'C', GT_OreDictUnificator.get(OrePrefixes.plateTriple, Materials.Adamantium, 1), 'A', CoreItems2.getRecipe(14, 1)});
		
		GT_ModHandler.addCraftingRecipe(CoreItems2.getRecipe(Tier4Booster.getMetaID(), 1), tBitMask, new Object[]{"PPP", "ABA", "ACA", 'P', OrePrefixes.plate.get(Materials.HastelloyN), 'A', CoreItems2.getRecipe(11, 1), 'C', CoreItems2.getRecipe(86, 1), 'B', GT_ModHandler.getModItem("GalacticraftCore", "item.engine", 1L, 1)});
		GT_ModHandler.addCraftingRecipe(CoreItems2.getRecipe(Tier5Booster.getMetaID(), 1), tBitMask, new Object[]{"PPP", "ABA", "ACA", 'P', OrePrefixes.plate.get(Materials.Europium), 'A', CoreItems2.getRecipe(12, 1), 'C', CoreItems2.getRecipe(88, 1), 'B', CoreItems2.getRecipe(36, 1)});
		GT_ModHandler.addCraftingRecipe(CoreItems2.getRecipe(Tier6Booster.getMetaID(), 1), tBitMask, new Object[]{"PPP", "ABA", "ACA", 'P', OrePrefixes.plate.get(Materials.Americium), 'A', CoreItems2.getRecipe(13, 1), 'C', CoreItems2.getRecipe(79, 1), 'B', CoreItems2.getRecipe(37, 1)});
		GT_ModHandler.addCraftingRecipe(CoreItems2.getRecipe(Tier7Booster.getMetaID(), 1), tBitMask, new Object[]{"PPP", "ABA", "ACA", 'P', OrePrefixes.plate.get(Materials.Neutronium), 'A', CoreItems2.getRecipe(14, 1), 'C', CoreItems2.getRecipe(85, 1), 'B', CoreItems2.getRecipe(38, 1)});
		GT_ModHandler.addCraftingRecipe(CoreItems2.getRecipe(Tier8Booster.getMetaID(), 1), tBitMask, new Object[]{"PPP", "ABA", "ACA", 'P', OrePrefixes.plate.get(Materials.Phoenixite), 'A', CoreItems2.getRecipe(15, 1), 'C', CoreItems2.getRecipe(77, 1), 'B', CoreItems2.getRecipe(39, 1)});
		
		GT_ModHandler.addCraftingRecipe(CoreItems2.getRecipe(MediumFuelCanister.getMetaID(), 1), tBitMask, new Object[]{"SdS", "PCA", "ShS", 'S', OrePrefixes.screw.get(Materials.HastelloyC276), 'P', CoreItems2.getRecipe(96, 1), 'A', CoreItems2.getRecipe(90, 1), 'C', GT_ModHandler.getModItem("GalaxySpace", "item.Modules", 1L, 3)});
		GT_ModHandler.addCraftingRecipe(CoreItems2.getRecipe(LargeFuelCanister.getMetaID(), 1), tBitMask, new Object[]{"SdS", "PCA", "ShS", 'S', OrePrefixes.screw.get(Materials.Lafium), 'P', CoreItems2.getRecipe(91, 1), 'A', CoreItems2.getRecipe(92, 1), 'C', CoreItems2.getRecipe(133, 1)});
		GT_ModHandler.addCraftingRecipe(CoreItems2.getRecipe(ExtraLargeFuelCanister.getMetaID(), 1), tBitMask, new Object[]{"SdS", "PCA", "ShS", 'S', OrePrefixes.screw.get(Materials.Neutronium), 'P', CoreItems2.getRecipe(94, 1), 'A', CoreItems2.getRecipe(95, 1), 'C', CoreItems2.getRecipe(134, 1)});
		
		/*====END SPACE ADDITION====*/
		
		GT_ModHandler.addCraftingRecipe(CoreItems2.getRecipe(IndustryFrame.getMetaID(), 1), tBitMask, new Object[]{"PPP", "SBS", "SSS", 'P', OrePrefixes.plate.get(Materials.Iridium), 'S', OrePrefixes.stick.get(Materials.Osmium), 'B', GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Europium, 1)});
		
		GT_ModHandler.addShapelessCraftingRecipe(new ItemStack(WoodBrickFormTool.WoodBrickFormTool, 1), tBitMask, new Object[]{CoreItems2.getRecipe(197, 1), ToolDictNames.craftingToolKnife});
		
		//Sawmill
		GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("impact", "impact_sawmill_block", 5L), tBitMask, new Object[]{"SCS", "BLB", "BdB", 'S', OrePrefixes.screw.get(Materials.WroughtIron), 'B', OrePrefixes.frameGt.get(Materials.Wood), 'L', OrePrefixes.slab.get(Materials.Wood), 'C', GT_ItemList.ULVConveyorModule});
		GT_ModHandler.addCraftingRecipe(GT_ItemList.SawCase.get(2L), tBitMask, new Object[]{"SrS", "SBS", "SsS", 'S', OrePrefixes.slab.get(Materials.Wood), 'B', OrePrefixes.frameGt.get(Materials.Wood)});
		GT_ModHandler.addCraftingRecipe(GT_ItemList.SawMill.get(1L), tBitMask, new Object[]{"SBd", "MCM", "LWL", 'S', OrePrefixes.screw.get(Materials.WroughtIron), 'B', OrePrefixes.toolHeadBuzzSaw.get(Materials.Iron), 'L', OrePrefixes.circuit.get(Materials.Primitive), 'W', OrePrefixes.wireGt01.get(Materials.Lead), 'M', GT_ItemList.ULVMotor, 'C', GT_ItemList.SawCase});
		
		//Pyrolyse Oven
		GT_ModHandler.addCraftingRecipe(GT_ItemList.Pyrolyse.get(1L), tBitMask, new Object[]{"PQW", "CHC", "ICW", 'Q', OrePrefixes.pipeNonuple.get(Materials.Bronze), 'C', OrePrefixes.circuit.get(Materials.Basic), 'W', OrePrefixes.wireGt08.get(Materials.Cupronickel), 'P', ItemList.Electric_Pump_LV, 'I', ItemList.Electric_Piston_LV, 'H', ItemList.Hull_LV});
		
		//WaterPump
		GT_ModHandler.addCraftingRecipe(GT_ItemList.PrimitiveWaterPumpCase.get(1L), tBitMask, new Object[]{"SWS", "dCr", 'S', OrePrefixes.screw.get(Materials.Iron), 'W', OrePrefixes.plank.get(Materials.Wood), 'C', OrePrefixes.slab.get(Materials.Cobblestone)});
		GT_ModHandler.addCraftingRecipe(GT_ItemList.BasicWaterPump.get(1L), tBitMask, new Object[]{"RPS", "OWd", "CHC", 'O', OrePrefixes.rotor.get(Materials.Iron), 'S', OrePrefixes.screw.get(Materials.Iron), 'R', OrePrefixes.ring.get(Materials.Iron), 'P', OrePrefixes.pipeMedium.get(Materials.Wood), 'H', GT_OreDictUnificator.get(OrePrefixes.pipeLarge, Materials.Wood, 1), 'W', OrePrefixes.plank.get(Materials.Wood), 'C', OrePrefixes.slab.get(Materials.Cobblestone)});
		GT_ModHandler.addCraftingRecipe(GT_ItemList.Hatch_Output_Pump.get(1L), tBitMask, new Object[]{"SRd", "WHW", "CRC", 'S', OrePrefixes.screw.get(Materials.Iron), 'R', OrePrefixes.ring.get(Materials.Iron), 'H', GT_OreDictUnificator.get(OrePrefixes.pipeLarge, Materials.Wood, 1), 'W', OrePrefixes.plank.get(Materials.Wood), 'C', OrePrefixes.slab.get(Materials.Cobblestone)});
		//WaterDrill
		GT_ModHandler.addCraftingRecipe(GT_ItemList.WaterDrill.get(1L), tBitMask, new Object[]{"BDB", "GPG", "CHC", 'B', GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Steel, 1), 'D', GT_OreDictUnificator.get(OrePrefixes.toolHeadDrill, Materials.Steel, 1), 'G', GT_OreDictUnificator.get(OrePrefixes.gearGt, Materials.Steel, 1), 'P', OrePrefixes.pipeHuge.get(Materials.Steel), 'C', OrePrefixes.circuit.get(Materials.Good), 'H', ItemList.Hull_MV});
		
		//Diodes 2A
		GT_ModHandler.addCraftingRecipe(GT_ItemList.Diode_2A_ULV.get(1L), 0, new Object[]{"PSP", "WCW", 'P', OrePrefixes.plate.get(Materials.WroughtIron), 'W', OrePrefixes.cableGt02.get(Materials.Lead), 'S', OrePrefixes.wireFine.get(Materials.Lead), 'C', ItemList.Casing_ULV});
		GT_ModHandler.addCraftingRecipe(GT_ItemList.Diode_2A_LV.get(1L), 0, new Object[]{"PSP", "WCW", 'P', OrePrefixes.plate.get(Materials.Steel), 'W', OrePrefixes.cableGt02.get(Materials.Tin), 'S', OrePrefixes.wireFine.get(Materials.Tin), 'C', ItemList.Casing_LV});
		GT_ModHandler.addCraftingRecipe(GT_ItemList.Diode_2A_MV.get(1L), 0, new Object[]{"PSP", "WCW", 'P', OrePrefixes.plate.get(Materials.Birmabright), 'W', OrePrefixes.cableGt02.get(Materials.Copper), 'S', OrePrefixes.wireFine.get(Materials.Copper), 'C', ItemList.Casing_MV});
		GT_ModHandler.addCraftingRecipe(GT_ItemList.Diode_2A_HV.get(1L), 0, new Object[]{"PSP", "WCW", 'P', OrePrefixes.plate.get(Materials.StainlessSteel), 'W', OrePrefixes.cableGt02.get(Materials.Electrum), 'S', OrePrefixes.wireFine.get(Materials.Electrum), 'C', ItemList.Casing_HV});
		GT_ModHandler.addCraftingRecipe(GT_ItemList.Diode_2A_EV.get(1L), 0, new Object[]{"PSP", "WCW", 'P', OrePrefixes.plate.get(Materials.BT6), 'W', OrePrefixes.cableGt02.get(Materials.Aluminium), 'S', OrePrefixes.wireFine.get(Materials.Aluminium), 'C', ItemList.Casing_EV});
		GT_ModHandler.addCraftingRecipe(GT_ItemList.Diode_2A_IV.get(1L), 0, new Object[]{"PSP", "WCW", 'P', OrePrefixes.plate.get(Materials.HastelloyC276), 'W', OrePrefixes.cableGt02.get(Materials.TungstenSteel), 'S', OrePrefixes.wireFine.get(Materials.TungstenSteel), 'C', ItemList.Casing_IV});
		GT_ModHandler.addCraftingRecipe(GT_ItemList.Diode_2A_LuV.get(1L), 0, new Object[]{"PSP", "WCW", 'P', OrePrefixes.plate.get(Materials.HastelloyN), 'W', OrePrefixes.cableGt02.get(Materials.YttriumBariumCuprate), 'S', OrePrefixes.wireFine.get(Materials.YttriumBariumCuprate), 'C', ItemList.Casing_LuV});
		GT_ModHandler.addCraftingRecipe(GT_ItemList.Diode_2A_ZPM.get(1L), 0, new Object[]{"PSP", "WCW", 'P', OrePrefixes.plate.get(Materials.Lafium), 'W', OrePrefixes.cableGt02.get(Materials.Naquadah), 'S', OrePrefixes.wireFine.get(Materials.Naquadah), 'C', ItemList.Casing_ZPM});
		GT_ModHandler.addCraftingRecipe(GT_ItemList.Diode_2A_UV.get(1L), 0, new Object[]{"PSP", "WCW", 'P', OrePrefixes.plate.get(Materials.CinobiteA243), 'W', OrePrefixes.cableGt02.get(Materials.ElectrumFlux), 'S', OrePrefixes.wireFine.get(Materials.ElectrumFlux), 'C', ItemList.Casing_UV});
		
		//Diodes 4A
		GT_ModHandler.addCraftingRecipe(GT_ItemList.Diode_4A_ULV.get(1L), 0, new Object[]{"PSP", "WCW", 'P', OrePrefixes.plate.get(Materials.WroughtIron), 'W', OrePrefixes.cableGt04.get(Materials.Lead), 'S', OrePrefixes.springSmall.get(Materials.Lead), 'C', ItemList.Casing_ULV});
		GT_ModHandler.addCraftingRecipe(GT_ItemList.Diode_4A_LV.get(1L), 0, new Object[]{"PSP", "WCW", 'P', OrePrefixes.plate.get(Materials.Steel), 'W', OrePrefixes.cableGt04.get(Materials.Tin), 'S', OrePrefixes.springSmall.get(Materials.Tin), 'C', ItemList.Casing_LV});
		GT_ModHandler.addCraftingRecipe(GT_ItemList.Diode_4A_MV.get(1L), 0, new Object[]{"PSP", "WCW", 'P', OrePrefixes.plate.get(Materials.Birmabright), 'W', OrePrefixes.cableGt04.get(Materials.Copper), 'S', OrePrefixes.springSmall.get(Materials.Copper), 'C', ItemList.Casing_MV});
		GT_ModHandler.addCraftingRecipe(GT_ItemList.Diode_4A_HV.get(1L), 0, new Object[]{"PSP", "WCW", 'P', OrePrefixes.plate.get(Materials.StainlessSteel), 'W', OrePrefixes.cableGt04.get(Materials.Electrum), 'S', OrePrefixes.springSmall.get(Materials.Electrum), 'C', ItemList.Casing_HV});
		GT_ModHandler.addCraftingRecipe(GT_ItemList.Diode_4A_EV.get(1L), 0, new Object[]{"PSP", "WCW", 'P', OrePrefixes.plate.get(Materials.BT6), 'W', OrePrefixes.cableGt04.get(Materials.Aluminium), 'S', OrePrefixes.springSmall.get(Materials.Aluminium), 'C', ItemList.Casing_EV});
		GT_ModHandler.addCraftingRecipe(GT_ItemList.Diode_4A_IV.get(1L), 0, new Object[]{"PSP", "WCW", 'P', OrePrefixes.plate.get(Materials.HastelloyC276), 'W', OrePrefixes.cableGt04.get(Materials.TungstenSteel), 'S', OrePrefixes.springSmall.get(Materials.TungstenSteel), 'C', ItemList.Casing_IV});
		GT_ModHandler.addCraftingRecipe(GT_ItemList.Diode_4A_LuV.get(1L), 0, new Object[]{"PSP", "WCW", 'P', OrePrefixes.plate.get(Materials.HastelloyN), 'W', OrePrefixes.cableGt04.get(Materials.YttriumBariumCuprate), 'S', OrePrefixes.springSmall.get(Materials.YttriumBariumCuprate), 'C', ItemList.Casing_LuV});
		GT_ModHandler.addCraftingRecipe(GT_ItemList.Diode_4A_ZPM.get(1L), 0, new Object[]{"PSP", "WCW", 'P', OrePrefixes.plate.get(Materials.Lafium), 'W', OrePrefixes.cableGt04.get(Materials.Naquadah), 'S', OrePrefixes.springSmall.get(Materials.Naquadah), 'C', ItemList.Casing_ZPM});
		GT_ModHandler.addCraftingRecipe(GT_ItemList.Diode_4A_UV.get(1L), 0, new Object[]{"PSP", "WCW", 'P', OrePrefixes.plate.get(Materials.CinobiteA243), 'W', OrePrefixes.cableGt04.get(Materials.ElectrumFlux), 'S', OrePrefixes.springSmall.get(Materials.ElectrumFlux), 'C', ItemList.Casing_UV});
		
		//Diodes 16A
		GT_ModHandler.addCraftingRecipe(GT_ItemList.Diode_16A_ULV.get(1L), 0, new Object[]{"PSP", "WCW", 'P', OrePrefixes.plate.get(Materials.WroughtIron), 'W', OrePrefixes.cableGt16.get(Materials.Lead), 'S', OrePrefixes.spring.get(Materials.Lead), 'C', ItemList.Casing_ULV});
		GT_ModHandler.addCraftingRecipe(GT_ItemList.Diode_16A_LV.get(1L), 0, new Object[]{"PSP", "WCW", 'P', OrePrefixes.plate.get(Materials.Steel), 'W', OrePrefixes.cableGt16.get(Materials.Tin), 'S', OrePrefixes.spring.get(Materials.Tin), 'C', ItemList.Casing_LV});
		GT_ModHandler.addCraftingRecipe(GT_ItemList.Diode_16A_MV.get(1L), 0, new Object[]{"PSP", "WCW", 'P', OrePrefixes.plate.get(Materials.Birmabright), 'W', OrePrefixes.cableGt16.get(Materials.Copper), 'S', OrePrefixes.spring.get(Materials.Copper), 'C', ItemList.Casing_MV});
		GT_ModHandler.addCraftingRecipe(GT_ItemList.Diode_16A_HV.get(1L), 0, new Object[]{"PSP", "WCW", 'P', OrePrefixes.plate.get(Materials.StainlessSteel), 'W', OrePrefixes.cableGt16.get(Materials.Electrum), 'S', OrePrefixes.spring.get(Materials.Electrum), 'C', ItemList.Casing_HV});
		GT_ModHandler.addCraftingRecipe(GT_ItemList.Diode_16A_EV.get(1L), 0, new Object[]{"PSP", "WCW", 'P', OrePrefixes.plate.get(Materials.BT6), 'W', OrePrefixes.cableGt16.get(Materials.Aluminium), 'S', OrePrefixes.spring.get(Materials.Aluminium), 'C', ItemList.Casing_EV});
		GT_ModHandler.addCraftingRecipe(GT_ItemList.Diode_16A_IV.get(1L), 0, new Object[]{"PSP", "WCW", 'P', OrePrefixes.plate.get(Materials.HastelloyC276), 'W', OrePrefixes.cableGt16.get(Materials.TungstenSteel), 'S', OrePrefixes.spring.get(Materials.TungstenSteel), 'C', ItemList.Casing_IV});
		GT_ModHandler.addCraftingRecipe(GT_ItemList.Diode_16A_LuV.get(1L), 0, new Object[]{"PSP", "WCW", 'P', OrePrefixes.plate.get(Materials.HastelloyN), 'W', OrePrefixes.cableGt16.get(Materials.YttriumBariumCuprate), 'S', OrePrefixes.spring.get(Materials.YttriumBariumCuprate), 'C', ItemList.Casing_LuV});
		GT_ModHandler.addCraftingRecipe(GT_ItemList.Diode_16A_ZPM.get(1L), 0, new Object[]{"PSP", "WCW", 'P', OrePrefixes.plate.get(Materials.Lafium), 'W', OrePrefixes.cableGt16.get(Materials.Naquadah), 'S', OrePrefixes.spring.get(Materials.Naquadah), 'C', ItemList.Casing_ZPM});
		GT_ModHandler.addCraftingRecipe(GT_ItemList.Diode_16A_UV.get(1L), 0, new Object[]{"PSP", "WCW", 'P', OrePrefixes.plate.get(Materials.CinobiteA243), 'W', OrePrefixes.cableGt16.get(Materials.ElectrumFlux), 'S', OrePrefixes.spring.get(Materials.ElectrumFlux), 'C', ItemList.Casing_UV});
		
		//White Concrete
		GT_ModHandler.addCraftingRecipe(Blockstack(UtilBlock, 8, 2), tBitMask, new Object[]{"CCC", "CDC", "CCC", 'C', Blockstack(UtilBlock, 1, 0), 'D', Dyes.dyeWhite});
		
		// --- Long Distance Pipeline
		GT_ModHandler.addCraftingRecipe(GT_ItemList.Long_Distance_Pipeline_Fluid.get(1L), tBitMask, new Object[]{"GPG", "IwI", "GPG", 'G', GT_OreDictUnificator.get(OrePrefixes.gear, Materials.Steel, 1L), 'P', GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Steel, 1L), 'I', GT_OreDictUnificator.get(OrePrefixes.pipeHuge, Materials.Steel, 1L)});
		GT_ModHandler.addCraftingRecipe(GT_ItemList.Long_Distance_Pipeline_Item.get(1L), tBitMask, new Object[]{"GPG", "IwI", "GPG", 'G', GT_OreDictUnificator.get(OrePrefixes.gear, Materials.Steel, 1L), 'P', GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Steel, 1L), 'I', GT_OreDictUnificator.get(OrePrefixes.pipeHuge, Materials.Tin, 1L)});
		GT_ModHandler.addCraftingRecipe(GT_ItemList.Long_Distance_Pipeline_Fluid_Pipe.get(32L), tBitMask, new Object[]{"PPP", "IwI", "PPP", 'P', GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Steel, 1L), 'I', GT_OreDictUnificator.get(OrePrefixes.pipeLarge, Materials.Steel, 1L)});
		GT_ModHandler.addCraftingRecipe(GT_ItemList.Long_Distance_Pipeline_Item_Pipe.get(32L), tBitMask, new Object[]{"PPP", "IwI", "PPP", 'P', GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Steel, 1L), 'I', GT_OreDictUnificator.get(OrePrefixes.pipeLarge, Materials.Tin, 1L)});
		
		// --- Regulate Digital Chest
		GT_ModHandler.addCraftingRecipe(GT_ItemList.Regulate_Digital_Chest.get(1L), tBitMask, new Object[]{"COY", 'C', OrePrefixes.circuit.get(Materials.Advanced), 'O', ItemList.Super_Chest_LV, 'Y', ItemList.Conveyor_Module_HV});
		
		// --- One Stack Regulate Chest
		GT_ModHandler.addCraftingRecipe(GT_ItemList.Regulate_One_Stack_Chest.get(1), tBitMask, new Object[]{"EHR", " C ", 'C', OrePrefixes.circuit.get(Materials.Basic), 'E', GT_ModHandler.getModItem("minecraft", "chest", 1L), 'R', ItemList.Robot_Arm_LV, 'H', ItemList.Hull_LV});
		
		// --- Lasers
        GT_ModHandler.addShapelessCraftingRecipe(GT_ItemList.DynamoTunnel1_IV.get(1L), tBitMask, new Object[]{CustomItemList.eM_dynamoTunnel1_IV.get(1)});
        GT_ModHandler.addShapelessCraftingRecipe(GT_ItemList.DynamoTunnel2_IV.get(1L), tBitMask, new Object[]{CustomItemList.eM_dynamoTunnel2_IV.get(1)});
        GT_ModHandler.addShapelessCraftingRecipe(GT_ItemList.DynamoTunnel3_IV.get(1L), tBitMask, new Object[]{CustomItemList.eM_dynamoTunnel3_IV.get(1)});
        GT_ModHandler.addShapelessCraftingRecipe(GT_ItemList.DynamoTunnel4_IV.get(1L), tBitMask, new Object[]{CustomItemList.eM_dynamoTunnel4_IV.get(1)});
        GT_ModHandler.addShapelessCraftingRecipe(GT_ItemList.DynamoTunnel5_IV.get(1L), tBitMask, new Object[]{CustomItemList.eM_dynamoTunnel5_IV.get(1)});
        GT_ModHandler.addShapelessCraftingRecipe(GT_ItemList.DynamoTunnel6_IV.get(1L), tBitMask, new Object[]{CustomItemList.eM_dynamoTunnel6_IV.get(1)});
        GT_ModHandler.addShapelessCraftingRecipe(GT_ItemList.DynamoTunnel7_IV.get(1L), tBitMask, new Object[]{CustomItemList.eM_dynamoTunnel7_IV.get(1)});

        GT_ModHandler.addShapelessCraftingRecipe(GT_ItemList.DynamoTunnel1_LuV.get(1L), tBitMask, new Object[]{CustomItemList.eM_dynamoTunnel1_LuV.get(1)});
        GT_ModHandler.addShapelessCraftingRecipe(GT_ItemList.DynamoTunnel2_LuV.get(1L), tBitMask, new Object[]{CustomItemList.eM_dynamoTunnel2_LuV.get(1)});
        GT_ModHandler.addShapelessCraftingRecipe(GT_ItemList.DynamoTunnel3_LuV.get(1L), tBitMask, new Object[]{CustomItemList.eM_dynamoTunnel3_LuV.get(1)});
        GT_ModHandler.addShapelessCraftingRecipe(GT_ItemList.DynamoTunnel4_LuV.get(1L), tBitMask, new Object[]{CustomItemList.eM_dynamoTunnel4_LuV.get(1)});
        GT_ModHandler.addShapelessCraftingRecipe(GT_ItemList.DynamoTunnel5_LuV.get(1L), tBitMask, new Object[]{CustomItemList.eM_dynamoTunnel5_LuV.get(1)});
        GT_ModHandler.addShapelessCraftingRecipe(GT_ItemList.DynamoTunnel6_LuV.get(1L), tBitMask, new Object[]{CustomItemList.eM_dynamoTunnel6_LuV.get(1)});
        GT_ModHandler.addShapelessCraftingRecipe(GT_ItemList.DynamoTunnel7_LuV.get(1L), tBitMask, new Object[]{CustomItemList.eM_dynamoTunnel7_LuV.get(1)});

        GT_ModHandler.addShapelessCraftingRecipe(GT_ItemList.DynamoTunnel1_ZPM.get(1L), tBitMask, new Object[]{CustomItemList.eM_dynamoTunnel1_ZPM.get(1)});
        GT_ModHandler.addShapelessCraftingRecipe(GT_ItemList.DynamoTunnel2_ZPM.get(1L), tBitMask, new Object[]{CustomItemList.eM_dynamoTunnel2_ZPM.get(1)});
        GT_ModHandler.addShapelessCraftingRecipe(GT_ItemList.DynamoTunnel3_ZPM.get(1L), tBitMask, new Object[]{CustomItemList.eM_dynamoTunnel3_ZPM.get(1)});
        GT_ModHandler.addShapelessCraftingRecipe(GT_ItemList.DynamoTunnel4_ZPM.get(1L), tBitMask, new Object[]{CustomItemList.eM_dynamoTunnel4_ZPM.get(1)});
        GT_ModHandler.addShapelessCraftingRecipe(GT_ItemList.DynamoTunnel5_ZPM.get(1L), tBitMask, new Object[]{CustomItemList.eM_dynamoTunnel5_ZPM.get(1)});
        GT_ModHandler.addShapelessCraftingRecipe(GT_ItemList.DynamoTunnel6_ZPM.get(1L), tBitMask, new Object[]{CustomItemList.eM_dynamoTunnel6_ZPM.get(1)});
        GT_ModHandler.addShapelessCraftingRecipe(GT_ItemList.DynamoTunnel7_ZPM.get(1L), tBitMask, new Object[]{CustomItemList.eM_dynamoTunnel7_ZPM.get(1)});

        GT_ModHandler.addShapelessCraftingRecipe(GT_ItemList.DynamoTunnel1_UV.get(1L), tBitMask, new Object[]{CustomItemList.eM_dynamoTunnel1_UV.get(1)});
        GT_ModHandler.addShapelessCraftingRecipe(GT_ItemList.DynamoTunnel2_UV.get(1L), tBitMask, new Object[]{CustomItemList.eM_dynamoTunnel2_UV.get(1)});
        GT_ModHandler.addShapelessCraftingRecipe(GT_ItemList.DynamoTunnel3_UV.get(1L), tBitMask, new Object[]{CustomItemList.eM_dynamoTunnel3_UV.get(1)});
        GT_ModHandler.addShapelessCraftingRecipe(GT_ItemList.DynamoTunnel4_UV.get(1L), tBitMask, new Object[]{CustomItemList.eM_dynamoTunnel4_UV.get(1)});
        GT_ModHandler.addShapelessCraftingRecipe(GT_ItemList.DynamoTunnel5_UV.get(1L), tBitMask, new Object[]{CustomItemList.eM_dynamoTunnel5_UV.get(1)});
        GT_ModHandler.addShapelessCraftingRecipe(GT_ItemList.DynamoTunnel6_UV.get(1L), tBitMask, new Object[]{CustomItemList.eM_dynamoTunnel6_UV.get(1)});
        GT_ModHandler.addShapelessCraftingRecipe(GT_ItemList.DynamoTunnel7_UV.get(1L), tBitMask, new Object[]{CustomItemList.eM_dynamoTunnel7_UV.get(1)});

        GT_ModHandler.addShapelessCraftingRecipe(GT_ItemList.DynamoTunnel1_UHV.get(1L), tBitMask, new Object[]{CustomItemList.eM_dynamoTunnel1_UHV.get(1)});
        GT_ModHandler.addShapelessCraftingRecipe(GT_ItemList.DynamoTunnel2_UHV.get(1L), tBitMask, new Object[]{CustomItemList.eM_dynamoTunnel2_UHV.get(1)});
        GT_ModHandler.addShapelessCraftingRecipe(GT_ItemList.DynamoTunnel3_UHV.get(1L), tBitMask, new Object[]{CustomItemList.eM_dynamoTunnel3_UHV.get(1)});
        GT_ModHandler.addShapelessCraftingRecipe(GT_ItemList.DynamoTunnel4_UHV.get(1L), tBitMask, new Object[]{CustomItemList.eM_dynamoTunnel4_UHV.get(1)});
        GT_ModHandler.addShapelessCraftingRecipe(GT_ItemList.DynamoTunnel5_UHV.get(1L), tBitMask, new Object[]{CustomItemList.eM_dynamoTunnel5_UHV.get(1)});
        GT_ModHandler.addShapelessCraftingRecipe(GT_ItemList.DynamoTunnel6_UHV.get(1L), tBitMask, new Object[]{CustomItemList.eM_dynamoTunnel6_UHV.get(1)});
        GT_ModHandler.addShapelessCraftingRecipe(GT_ItemList.DynamoTunnel7_UHV.get(1L), tBitMask, new Object[]{CustomItemList.eM_dynamoTunnel7_UHV.get(1)});

        GT_ModHandler.addShapelessCraftingRecipe(GT_ItemList.DynamoTunnel1_UEV.get(1L), tBitMask, new Object[]{CustomItemList.eM_dynamoTunnel1_UEV.get(1)});
        GT_ModHandler.addShapelessCraftingRecipe(GT_ItemList.DynamoTunnel2_UEV.get(1L), tBitMask, new Object[]{CustomItemList.eM_dynamoTunnel2_UEV.get(1)});
        GT_ModHandler.addShapelessCraftingRecipe(GT_ItemList.DynamoTunnel3_UEV.get(1L), tBitMask, new Object[]{CustomItemList.eM_dynamoTunnel3_UEV.get(1)});
        GT_ModHandler.addShapelessCraftingRecipe(GT_ItemList.DynamoTunnel4_UEV.get(1L), tBitMask, new Object[]{CustomItemList.eM_dynamoTunnel4_UEV.get(1)});
        GT_ModHandler.addShapelessCraftingRecipe(GT_ItemList.DynamoTunnel5_UEV.get(1L), tBitMask, new Object[]{CustomItemList.eM_dynamoTunnel5_UEV.get(1)});
        GT_ModHandler.addShapelessCraftingRecipe(GT_ItemList.DynamoTunnel6_UEV.get(1L), tBitMask, new Object[]{CustomItemList.eM_dynamoTunnel6_UEV.get(1)});
        GT_ModHandler.addShapelessCraftingRecipe(GT_ItemList.DynamoTunnel7_UEV.get(1L), tBitMask, new Object[]{CustomItemList.eM_dynamoTunnel7_UEV.get(1)});

        GT_ModHandler.addShapelessCraftingRecipe(GT_ItemList.EnergyTunnel1_IV.get(1L), tBitMask, new Object[]{CustomItemList.eM_energyTunnel1_IV.get(1)});
        GT_ModHandler.addShapelessCraftingRecipe(GT_ItemList.EnergyTunnel2_IV.get(1L), tBitMask, new Object[]{CustomItemList.eM_energyTunnel2_IV.get(1)});
        GT_ModHandler.addShapelessCraftingRecipe(GT_ItemList.EnergyTunnel3_IV.get(1L), tBitMask, new Object[]{CustomItemList.eM_energyTunnel3_IV.get(1)});
        GT_ModHandler.addShapelessCraftingRecipe(GT_ItemList.EnergyTunnel4_IV.get(1L), tBitMask, new Object[]{CustomItemList.eM_energyTunnel4_IV.get(1)});
        GT_ModHandler.addShapelessCraftingRecipe(GT_ItemList.EnergyTunnel5_IV.get(1L), tBitMask, new Object[]{CustomItemList.eM_energyTunnel5_IV.get(1)});
        GT_ModHandler.addShapelessCraftingRecipe(GT_ItemList.EnergyTunnel6_IV.get(1L), tBitMask, new Object[]{CustomItemList.eM_energyTunnel6_IV.get(1)});
        GT_ModHandler.addShapelessCraftingRecipe(GT_ItemList.EnergyTunnel7_IV.get(1L), tBitMask, new Object[]{CustomItemList.eM_energyTunnel7_IV.get(1)});

        GT_ModHandler.addShapelessCraftingRecipe(GT_ItemList.EnergyTunnel1_LuV.get(1L), tBitMask, new Object[]{CustomItemList.eM_energyTunnel1_LuV.get(1)});
        GT_ModHandler.addShapelessCraftingRecipe(GT_ItemList.EnergyTunnel2_LuV.get(1L), tBitMask, new Object[]{CustomItemList.eM_energyTunnel2_LuV.get(1)});
        GT_ModHandler.addShapelessCraftingRecipe(GT_ItemList.EnergyTunnel3_LuV.get(1L), tBitMask, new Object[]{CustomItemList.eM_energyTunnel3_LuV.get(1)});
        GT_ModHandler.addShapelessCraftingRecipe(GT_ItemList.EnergyTunnel4_LuV.get(1L), tBitMask, new Object[]{CustomItemList.eM_energyTunnel4_LuV.get(1)});
        GT_ModHandler.addShapelessCraftingRecipe(GT_ItemList.EnergyTunnel5_LuV.get(1L), tBitMask, new Object[]{CustomItemList.eM_energyTunnel5_LuV.get(1)});
        GT_ModHandler.addShapelessCraftingRecipe(GT_ItemList.EnergyTunnel6_LuV.get(1L), tBitMask, new Object[]{CustomItemList.eM_energyTunnel6_LuV.get(1)});
        GT_ModHandler.addShapelessCraftingRecipe(GT_ItemList.EnergyTunnel7_LuV.get(1L), tBitMask, new Object[]{CustomItemList.eM_energyTunnel7_LuV.get(1)});

        GT_ModHandler.addShapelessCraftingRecipe(GT_ItemList.EnergyTunnel1_ZPM.get(1L), tBitMask, new Object[]{CustomItemList.eM_energyTunnel1_ZPM.get(1)});
        GT_ModHandler.addShapelessCraftingRecipe(GT_ItemList.EnergyTunnel2_ZPM.get(1L), tBitMask, new Object[]{CustomItemList.eM_energyTunnel2_ZPM.get(1)});
        GT_ModHandler.addShapelessCraftingRecipe(GT_ItemList.EnergyTunnel3_ZPM.get(1L), tBitMask, new Object[]{CustomItemList.eM_energyTunnel3_ZPM.get(1)});
        GT_ModHandler.addShapelessCraftingRecipe(GT_ItemList.EnergyTunnel4_ZPM.get(1L), tBitMask, new Object[]{CustomItemList.eM_energyTunnel4_ZPM.get(1)});
        GT_ModHandler.addShapelessCraftingRecipe(GT_ItemList.EnergyTunnel5_ZPM.get(1L), tBitMask, new Object[]{CustomItemList.eM_energyTunnel5_ZPM.get(1)});
        GT_ModHandler.addShapelessCraftingRecipe(GT_ItemList.EnergyTunnel6_ZPM.get(1L), tBitMask, new Object[]{CustomItemList.eM_energyTunnel6_ZPM.get(1)});
        GT_ModHandler.addShapelessCraftingRecipe(GT_ItemList.EnergyTunnel7_ZPM.get(1L), tBitMask, new Object[]{CustomItemList.eM_energyTunnel7_ZPM.get(1)});

        GT_ModHandler.addShapelessCraftingRecipe(GT_ItemList.EnergyTunnel1_UV.get(1L), tBitMask, new Object[]{CustomItemList.eM_energyTunnel1_UV.get(1)});
        GT_ModHandler.addShapelessCraftingRecipe(GT_ItemList.EnergyTunnel2_UV.get(1L), tBitMask, new Object[]{CustomItemList.eM_energyTunnel2_UV.get(1)});
        GT_ModHandler.addShapelessCraftingRecipe(GT_ItemList.EnergyTunnel3_UV.get(1L), tBitMask, new Object[]{CustomItemList.eM_energyTunnel3_UV.get(1)});
        GT_ModHandler.addShapelessCraftingRecipe(GT_ItemList.EnergyTunnel4_UV.get(1L), tBitMask, new Object[]{CustomItemList.eM_energyTunnel4_UV.get(1)});
        GT_ModHandler.addShapelessCraftingRecipe(GT_ItemList.EnergyTunnel5_UV.get(1L), tBitMask, new Object[]{CustomItemList.eM_energyTunnel5_UV.get(1)});
        GT_ModHandler.addShapelessCraftingRecipe(GT_ItemList.EnergyTunnel6_UV.get(1L), tBitMask, new Object[]{CustomItemList.eM_energyTunnel6_UV.get(1)});
        GT_ModHandler.addShapelessCraftingRecipe(GT_ItemList.EnergyTunnel7_UV.get(1L), tBitMask, new Object[]{CustomItemList.eM_energyTunnel7_UV.get(1)});

        GT_ModHandler.addShapelessCraftingRecipe(GT_ItemList.EnergyTunnel1_UHV.get(1L), tBitMask, new Object[]{CustomItemList.eM_energyTunnel1_UHV.get(1)});
        GT_ModHandler.addShapelessCraftingRecipe(GT_ItemList.EnergyTunnel2_UHV.get(1L), tBitMask, new Object[]{CustomItemList.eM_energyTunnel2_UHV.get(1)});
        GT_ModHandler.addShapelessCraftingRecipe(GT_ItemList.EnergyTunnel3_UHV.get(1L), tBitMask, new Object[]{CustomItemList.eM_energyTunnel3_UHV.get(1)});
        GT_ModHandler.addShapelessCraftingRecipe(GT_ItemList.EnergyTunnel4_UHV.get(1L), tBitMask, new Object[]{CustomItemList.eM_energyTunnel4_UHV.get(1)});
        GT_ModHandler.addShapelessCraftingRecipe(GT_ItemList.EnergyTunnel5_UHV.get(1L), tBitMask, new Object[]{CustomItemList.eM_energyTunnel5_UHV.get(1)});
        GT_ModHandler.addShapelessCraftingRecipe(GT_ItemList.EnergyTunnel6_UHV.get(1L), tBitMask, new Object[]{CustomItemList.eM_energyTunnel6_UHV.get(1)});
        GT_ModHandler.addShapelessCraftingRecipe(GT_ItemList.EnergyTunnel7_UHV.get(1L), tBitMask, new Object[]{CustomItemList.eM_energyTunnel7_UHV.get(1)});

        GT_ModHandler.addShapelessCraftingRecipe(GT_ItemList.EnergyTunnel1_UEV.get(1L), tBitMask, new Object[]{CustomItemList.eM_energyTunnel1_UEV.get(1)});
        GT_ModHandler.addShapelessCraftingRecipe(GT_ItemList.EnergyTunnel2_UEV.get(1L), tBitMask, new Object[]{CustomItemList.eM_energyTunnel2_UEV.get(1)});
        GT_ModHandler.addShapelessCraftingRecipe(GT_ItemList.EnergyTunnel3_UEV.get(1L), tBitMask, new Object[]{CustomItemList.eM_energyTunnel3_UEV.get(1)});
        GT_ModHandler.addShapelessCraftingRecipe(GT_ItemList.EnergyTunnel4_UEV.get(1L), tBitMask, new Object[]{CustomItemList.eM_energyTunnel4_UEV.get(1)});
        GT_ModHandler.addShapelessCraftingRecipe(GT_ItemList.EnergyTunnel5_UEV.get(1L), tBitMask, new Object[]{CustomItemList.eM_energyTunnel5_UEV.get(1)});
        GT_ModHandler.addShapelessCraftingRecipe(GT_ItemList.EnergyTunnel6_UEV.get(1L), tBitMask, new Object[]{CustomItemList.eM_energyTunnel6_UEV.get(1)});
        GT_ModHandler.addShapelessCraftingRecipe(GT_ItemList.EnergyTunnel7_UEV.get(1L), tBitMask, new Object[]{CustomItemList.eM_energyTunnel7_UEV.get(1)});

		// --- Drying Rack
		GT_ModHandler.addCraftingRecipe(new ItemStack(ItemRegistery.DryingRack, 1, 0), tBitMask, new Object[]{"SSS", "CsC", 'S', "slabWood", 'C', OrePrefixes.bolt.get(Materials.Wood)});

		// --- Blank Pattern
		GT_ModHandler
				.addCraftingRecipe(CoreItems2.getRecipe(197, 1), tBitMask,
						new Object[]{"PP", "PP", 'P', new ItemStack(Items.paper)});
		GT_ModHandler
				.addCraftingRecipe(CoreItems2.getRecipe(197, 1), tBitMask,
						new Object[]{"DDD", "DOD", "DDD", 'O', new ItemStack(Items.water_bucket), 'D', OrePrefixes.dust.get(Materials.Wood)});

		// --- Multiblock Structure Hologram Projector
		GT_ModHandler.addShapelessCraftingRecipe(GT_ModHandler.getModItem("impactapi", "item.impactapi.constructableTrigger", 1L, 0), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{GT_ModHandler.getModItem("tectech", "item.em.constructable", 1L, 0)});
		GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("impactapi", "item.impactapi.constructableTrigger", 1L, 0), tBitMask, new Object[]{"RY", "YR", 'R', "dyeRed", 'Y', "dyeYellow"});

		// --- Matrix Particles Reflector
		GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("impact", "impact_matrix_system", 2L, 0), tBitMask,
				new Object[]{"PFP", "FBF", "PFP", 'P', "plateDoubleSilver", 'F', "foilAluminium", 'B', "frameGtHSLA"});

		// --- The Mill Wood Plank
		GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("impact", "gt.blockCase3", 4L, 2), tBitMask,
				new Object[]{"PFP", "FBF", "PFP", 'P', "plankWood", 'F', "boltWood", 'B', ToolDictNames.craftingToolSoftHammer});

        // --- The Mill
		GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("gregtech", "gt.blockmachines", 1L, 14074), tBitMask,
				new Object[]{"PLP", "CGC", "PBP", 'P', GT_ModHandler.getModItem("impact", "gt.blockCase3", 1L, 2),
						'L', GT_ModHandler.getModItem("Backpack", "tannedLeather", 1L, 0),
						'C', "cobblestone", 'G', "gearWood", 'B', ToolDictNames.craftingToolSoftHammer});
		
		// --- The Mill Rotor
		GT_ModHandler.addCraftingRecipe(new ItemStack(ItemRegistery.TheWind, 1, 0), tBitMask,
				new Object[]{"SLS", "LGL", "SLS", 'L', GT_ModHandler.getModItem("Backpack", "tannedLeather", 1L, 0),
						'S', "stickWood", 'G', "gearWood"});			

		// --- Volumetric Configurator
		GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("gregtech", "gt.blockmachines", 1L, 14604), tBitMask,
				new Object[]{" C ", "hHw", " G ", 'C', "craftingChest", 'G', "gearGtSmallSteel", 'H', ItemList.Hull_LV});

        // --- Coal Miner
		GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("gregtech", "gt.blockmachines", 1L, 14071), tBitMask,
				new Object[]{"SBS", "GFG", "hLd", 'B', GT_ModHandler.getModItem("IC2", "itemRecipePart", 1L, 6),
						'F', GT_ModHandler.getModItem("IC2", "blockMachine", 1L, 1),
						'S', "screwIron", 'G', "gearGtSmallIron", 'L', "stickLongIron"});

		// --- Mining Hatch
		GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("gregtech", "gt.blockmachines", 1L, 14747), tBitMask,
				new Object[]{"SCd", "GFG", "hRS", 'S', "screwIron", 'C', "craftingChest", 'G', "gearIron", 'F', "frameGtIron",
						'R', "ringIron"});

		// --- Iron Drill Head
		ItemStack drill = DrillHeads.create(new ItemStack(DrillHeads.getInstance(), 1, 0));
		GT_ModHandler.addCraftingRecipe(drill, tBitMask,
				new Object[]{" P ", "PFP", "PhP", 'P', "plateDoubleIron", 'F', "frameGtIron"});
		// --- Steel Drill Head
		drill = DrillHeads.create(new ItemStack(DrillHeads.getInstance(), 1, 1));
		GT_ModHandler.addCraftingRecipe(drill, tBitMask,
				new Object[]{" P ", "PFP", "PhP", 'P', "plateDoubleSteel", 'F', "frameGtSteel"});

		// --- Ore and Oil Prospector LV
		GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("gregtech", "gt.blockmachines", 1L, 14751), tBitMask,
				new Object[]{"PPP", "CHC", "SOS", 'H', ItemList.Hull_LV, 'S', ItemList.Sensor_LV, 'P', "plateDoubleSteel",
						'C', "circuitBasic", 'O', "cableGt02Tin"});
		// --- Ore and Oil Prospector MV
		GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("gregtech", "gt.blockmachines", 1L, 14752), tBitMask,
				new Object[]{"PPP", "CHC", "SOS", 'H', ItemList.Hull_MV, 'S', ItemList.Sensor_MV, 'P', "plateDoubleBlackSteel",
						'C', "circuitGood", 'O', "cableGt02Copper"});
		// --- Ore and Oil Prospector HV
		GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("gregtech", "gt.blockmachines", 1L, 14753), tBitMask,
				new Object[]{"PPP", "CHC", "SOS", 'H', ItemList.Hull_HV, 'S', ItemList.Sensor_HV, 'P', "plateTripleStainlessSteel",
						'C', "circuitAdvanced", 'O', "cableGt04Gold"});
		// --- Ore and Oil Prospector EV
		GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("gregtech", "gt.blockmachines", 1L, 14754), tBitMask,
				new Object[]{"PPP", "CHC", "SOS", 'H', ItemList.Hull_EV, 'S', ItemList.Sensor_EV, 'P', "plateQuadrupleVanadiumSteel",
						'C', "circuitData", 'O', "cableGt04Aluminium"});
		// --- Ore and Oil Prospector IV
		GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("gregtech", "gt.blockmachines", 1L, 14755), tBitMask,
				new Object[]{"PPP", "CHC", "SOS", 'H', ItemList.Hull_IV, 'S', ItemList.Sensor_IV, 'P', "plateQuintupleTungstenSteel",
						'C', "circuitElite", 'O', "cableGt08Platinum"});

		// --- Ore Finder
		GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("gregtech", "gt.metaitem.04", 1L, 32008), tBitMask,
				new Object[]{"F  ", " B ", "  S", 'F', "itemFlint", 'B', "boltIron", 'S', "stickLongWood"});

		// --- Mask L
		GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("impact", "mask_of_vision", 1L), tBitMask,
				new Object[]{" D ", "PGP", "PSP", 'D', "dyeLightBlue", 'P', "plateRubber", 'S', CoreItems2.getRecipe(51, 1),
				'G', GT_ModHandler.getModItem("IC2", "blockAlloyGlass", 1L)});

		// --- Aerostat
		GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("gregtech", "gt.metaitem.04", 1L, 32006), tBitMask,
				new Object[]{"GGG", "GAG", "SBS", 'S', "wireFineSteel", 'A', ToolDictNames.craftingToolWireCutter,
						'B', GT_ModHandler.getModItem("minecraft", "boat", 1L),
						'G', GT_ModHandler.getModItem("GalacticraftCore", "item.canvas", 1L)});

		// --- Aerostate Platform Casing
		GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("impact", "gt.blockCase3", 4L, 1), tBitMask,
				new Object[]{"SSS", "PBP", "PsP", 'S', "slabWood", 'B', "frameGtWood", 'P', "plankWood"});

		// --- Aerostate
		GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("gregtech", "gt.blockmachines", 1L, 14064), tBitMask,
				new Object[]{"sSP", "RFR", "WWW", 'S', "slabWood", 'P', "pipeSmallSteel", 'F', "frameGtWood", 'R', "plateRubber", 'W', "plankWood"});

		// --- Data Reader
		GT_ModHandler.addCraftingRecipe(GT_ItemList.Machine_DataReader.get(1L), tBitMask,
				new Object[]{"BdB","GES","PwP",
						'B', OrePrefixes.screw.get(Materials.Iridium),
						'P', OrePrefixes.plate.get(Materials.Iridium),
						'G', ItemList.Cover_Screen,
						'S', OrePrefixes.circuit.get(Materials.Elite),
						'E', ItemList.Hull_IV});

		// --- Mud Ball
		GT_ModHandler.addShapelessCraftingRecipe(CoreItems2.getRecipe(202, 2), tBitMask,
						new Object[]{new ItemStack(Blocks.dirt), new ItemStack(Items.water_bucket)});

	}
	
	private void furnace() {
		GT_ModHandler.addSmeltingRecipe(CoreItems2.getRecipe(UnfiredClayBrick.getMetaID(), 1), new ItemStack(Items.brick, 1, 0));
		GT_ModHandler.addSmeltingRecipe(CoreItems2.getRecipe(UnfiredCokeOvenBrick.getMetaID(), 1), CoreItems2.getRecipe(CokeOvenBrick.getMetaID(), 1));
		
	}
	
	private void unboxing() {
		RA.addUnboxingRecipe(GT_ItemList.Solar_ULV.get(1),
				ItemList.Cover_SolarPanel_8V.get(1L), GT_ItemList.ULVRobotArm.get(1L), 800, 1
		);
		RA.addUnboxingRecipe(GT_ItemList.Solar_LV.get(1),
				ItemList.Cover_SolarPanel_LV.get(1L), ItemList.Robot_Arm_LV.get(1L), 1000, 2
		);
		RA.addUnboxingRecipe(GT_ItemList.Solar_MV.get(1),
				ItemList.Cover_SolarPanel_MV.get(1L), ItemList.Robot_Arm_MV.get(1L), 1200, 4
		);
		RA.addUnboxingRecipe(GT_ItemList.Solar_HV.get(1),
				ItemList.Cover_SolarPanel_HV.get(1L), ItemList.Robot_Arm_HV.get(1L), 1400, 16
		);
		RA.addUnboxingRecipe(GT_ItemList.Solar_EV.get(1),
				ItemList.Cover_SolarPanel_EV.get(1L), ItemList.Robot_Arm_EV.get(1L), 1600, 64
		);
		RA.addUnboxingRecipe(GT_ItemList.Solar_IV.get(1),
				ItemList.Cover_SolarPanel_IV.get(1L), ItemList.Robot_Arm_IV.get(1L), 1800, 256
		);
		RA.addUnboxingRecipe(GT_ItemList.Solar_LuV.get(1),
				ItemList.Cover_SolarPanel_LuV.get(1L), ItemList.Robot_Arm_LuV.get(1L), 2000, 1024
		);
		RA.addUnboxingRecipe(GT_ItemList.Solar_ZPM.get(1),
				ItemList.Cover_SolarPanel_ZPM.get(1L), ItemList.Robot_Arm_ZPM.get(1L), 2200, 4096
		);
		RA.addUnboxingRecipe(GT_ItemList.Solar_UV.get(1),
				ItemList.Cover_SolarPanel_UV.get(1L), ItemList.Robot_Arm_UV.get(1L), 2400, 7680
		);
		
		RA.addUnboxingRecipe(
				GT_ModHandler.getModItem("impact", "impact_lapotronicenergyunit_block", 1, 1),
				GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Inconel792, 1),
				ItemList.Energy_LapotronicOrb.get(1L), 1600, 64
		);
		RA.addUnboxingRecipe(
				GT_ModHandler.getModItem("impact", "impact_lapotronicenergyunit_block", 1, 6),
				GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Inconel792, 1),
				ItemList.EnergyCrystal_IV.get(1L), 1600, 64
		);
		RA.addUnboxingRecipe(
				GT_ModHandler.getModItem("impact", "impact_lapotronicenergyunit_block", 1, 2),
				GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Inconel792, 1),
				ItemList.Energy_LapotronicOrb2.get(1L), 1800, 256
		);
		RA.addUnboxingRecipe(
				GT_ModHandler.getModItem("impact", "impact_lapotronicenergyunit_block", 1, 3),
				GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Inconel792, 1),
				ItemList.Energy_Module.get(1L), 2000, 1024
		);
		RA.addUnboxingRecipe(
				GT_ModHandler.getModItem("impact", "impact_lapotronicenergyunit_block", 1, 4),
				GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Inconel792, 1),
				ItemList.Energy_Cluster.get(1L), 2200, 4096
		);
		RA.addUnboxingRecipe(
				GT_ModHandler.getModItem("impact", "impact_lapotronicenergyunit_block", 1, 5),
				GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Inconel792, 1),
				ItemList.ZPM2.get(1L), 2400, 7680
		);
		RA.addUnboxingRecipe(
				GT_ModHandler.getModItem("impact", "impact_lapotronicenergyunit_block", 1, 7),
				GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Inconel792, 1),
				ItemList.MysteriousCrystalOrb.get(1L), 2400, 4096
		);
		RA.addUnboxingRecipe(
				GT_ModHandler.getModItem("impact", "impact_lapotronicenergyunit_block", 1, 8),
				GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Inconel792, 1),
				ItemList.MysteriousCrystalModule.get(1L), 2400, 7680
		);

		RA.addUnboxingRecipe(
				CoreItems2.getRecipe(203, 1),
				GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Titanium, 1),
				ItemList.Circuit_Data.get(2L), 800, 15
		);
		RA.addUnboxingRecipe(
				CoreItems2.getRecipe(204, 1),
				GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.TungstenSteel, 1),
				ItemList.Circuit_Elite.get(2L), 1000, 30
		);
		RA.addUnboxingRecipe(
				CoreItems2.getRecipe(205, 1),
				GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Chrome, 1),
				ItemList.Circuit_Master.get(2L), 1200, 48
		);
		RA.addUnboxingRecipe(
				CoreItems2.getRecipe(206, 1),
				GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Iridium, 1),
				ItemList.Circuit_Quantummainframe.get(2L), 1400, 96
		);
		RA.addUnboxingRecipe(
				CoreItems2.getRecipe(207, 1),
				GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Osmium, 1),
				ItemList.Circuit_Crystalmainframe.get(2L), 1600, 192
		);
		RA.addUnboxingRecipe(
				CoreItems2.getRecipe(208, 1),
				GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Neutronium, 1),
				ItemList.Circuit_Wetwaremainframe.get(2L), 1800, 360
		);
		RA.addUnboxingRecipe(
				CoreItems2.getRecipe(209, 1),
				GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Phoenixite, 1),
				ItemList.Circuit_Biomainframe.get(2L), 2000, 940
		);
	}
	
	private void pulverizer() {
		RA.addPulveriserRecipe(
				GT_ModHandler.getModItem("Impact|GalacticModule", "phobosblocks", 1L, 0),
				new ItemStack[]{GregTech_API.getStackofAmountFromOreDict("dustPhobos", 1),
						GT_OreDictUnificator.get(OrePrefixes.dust, Materials.BandedIron, 1)},
				new int[]{10000, 1200}, 400, 64
		);
		RA.addPulveriserRecipe(
				GT_ModHandler.getModItem("Impact|GalacticModule", "phobosblocks", 1L, 1),
				new ItemStack[]{GregTech_API.getStackofAmountFromOreDict("dustPhobos", 1),
						GT_OreDictUnificator.get(OrePrefixes.dust, Materials.BandedIron, 1)},
				new int[]{10000, 1200}, 400, 64
		);
		//RA.addPulveriserRecipe(GT_ModHandler.getModItem("GalaxySpace", "phobosblocks", 1L, 2), new ItemStack[]{GregTech_API.getStackofAmountFromOreDict("dustPhobos", 1), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.BandedIron, 1)}, new int[]{10000, 5000}, 400, 60);
		RA.addPulveriserRecipe(
				GT_ModHandler.getModItem("Impact|GalacticModule", "deimosblocks", 1L, 0),
				new ItemStack[]{GregTech_API.getStackofAmountFromOreDict("dustDeimos", 1),
						GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Magnesite, 1)},
				new int[]{10000, 1200}, 400, 64
		);
		RA.addPulveriserRecipe(
				GT_ModHandler.getModItem("Impact|GalacticModule", "deimosblocks", 1L, 1),
				new ItemStack[]{GregTech_API.getStackofAmountFromOreDict("dustDeimos", 1),
						GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Magnesite, 1)},
				new int[]{10000, 1200}, 400, 64
		);
		
		RA.addPulveriserRecipe(
				GT_ModHandler.getModItem("Impact|GalacticModule", "oberonblocks", 1L, 0),
				new ItemStack[]{GregTech_API.getStackofAmountFromOreDict("dustOberon", 1),
						GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Iridium, 1),
						GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Osmium, 1),
						GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Naquadah, 1)},
				new int[]{10000, 500, 250, 210}, 400, 480
		);
		RA.addPulveriserRecipe(
				GT_ModHandler.getModItem("Impact|GalacticModule", "oberonblocks", 1L, 1),
				new ItemStack[]{GregTech_API.getStackofAmountFromOreDict("dustOberon", 1),
						GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Iridium, 1),
						GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Osmium, 1),
						GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Naquadah, 1)},
				new int[]{10000, 500, 250, 210}, 400, 480
		);
		RA.addPulveriserRecipe(
				GT_ModHandler.getModItem("Impact|GalacticModule", "oberonblocks", 1L, 2),
				new ItemStack[]{GregTech_API.getStackofAmountFromOreDict("dustOberon", 1),
						GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Iridium, 1),
						GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Osmium, 1),
						GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Naquadah, 1)},
				new int[]{10000, 500, 250, 210}, 400, 480
		);
		
		RA.addPulveriserRecipe(
				GT_ModHandler.getModItem("Impact|GalacticModule", "proteusblocks", 1L, 0),
				new ItemStack[]{GregTech_API.getStackofAmountFromOreDict("dustProteus", 1),
						GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Copper, 1),
						GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Uraninite, 1),
						GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Draconium, 1)},
				new int[]{10000, 1200, 600, 250}, 400, 1024
		);
		RA.addPulveriserRecipe(
				GT_ModHandler.getModItem("Impact|GalacticModule", "proteusblocks", 1L, 1),
				new ItemStack[]{GregTech_API.getStackofAmountFromOreDict("dustProteus", 1),
						GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Copper, 1),
						GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Uraninite, 1),
						GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Draconium, 1)},
				new int[]{10000, 1200, 600, 250}, 400, 1024
		);
		RA.addPulveriserRecipe(
				GT_ModHandler.getModItem("Impact|GalacticModule", "proteusblocks", 1L, 2),
				new ItemStack[]{GregTech_API.getStackofAmountFromOreDict("dustProteus", 1),
						GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Copper, 1),
						GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Uraninite, 1),
						GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Draconium, 1)},
				new int[]{10000, 1200, 600, 250}, 400, 1024
		);
		
		RA.addPulveriserRecipe(
				GT_ModHandler.getModItem("Impact|GalacticModule", "makemakeblocks", 1L, 0),
				new ItemStack[]{GregTech_API.getStackofAmountFromOreDict("dustMakeMake", 1),
						GT_OreDictUnificator.get(OrePrefixes.dust, Materials.GarnetRed, 1),
						GT_OreDictUnificator.get(OrePrefixes.dust, Materials.GarnetYellow, 1),
						GT_OreDictUnificator.get(OrePrefixes.dust, Materials.BlackPlutonium, 1)},
				new int[]{10000, 600, 600, 250}, 400, 1920
		);
		RA.addPulveriserRecipe(
				GT_ModHandler.getModItem("Impact|GalacticModule", "makemakeblocks", 1L, 1),
				new ItemStack[]{GregTech_API.getStackofAmountFromOreDict("dustMakeMake", 1),
						GT_OreDictUnificator.get(OrePrefixes.dust, Materials.GarnetRed, 1),
						GT_OreDictUnificator.get(OrePrefixes.dust, Materials.GarnetYellow, 1),
						GT_OreDictUnificator.get(OrePrefixes.dust, Materials.BlackPlutonium, 1)},
				new int[]{10000, 600, 600, 250}, 400, 1920
		);
		RA.addPulveriserRecipe(
				GT_ModHandler.getModItem("Impact|GalacticModule", "haumeablocks", 1L, 0),
				new ItemStack[]{GregTech_API.getStackofAmountFromOreDict("dustHaumea", 1),
						GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Gold, 1),
						GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Naquadah, 1),
						GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Draconium, 1)},
				new int[]{10000, 500, 250, 210}, 400, 1920
		);
		
		RA.addPulveriserRecipe(
				GregTech_API.getStackofAmountFromOreDict("ingotCokeOvenBrick", 1),
				new ItemStack[]{CoreItems.getRecipe(31, 1)}, new int[]{10000}, 300, 2
		);
		RA.addPulveriserRecipe(ItemList.Casing_BronzePlatedBricks.get(1),
				new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Bronze, 4L),
						GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Stone, 1L)},
				new int[]{10000, 10000}, 300, 2
		);
	}
	
	private void printer3d() {
//Controllers
		RA.addBasicLineRecipe(new ItemStack[]{
				ItemList.Hull_IV.get(1L),
				GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.GumMetal, 4),
				GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Elite, 4),
				Itemstack(Core_Items2.getInstance(), 1, 182),
				ItemList.Electric_Piston_IV.get(4L), ItemList.Conveyor_Module_IV.get(4L),
				GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.GumMetal, 8),
				GT_OreDictUnificator.get(OrePrefixes.stickLong, Materials.HSSG, 4),
				GT_OreDictUnificator.get(OrePrefixes.gear, Materials.Titaniolum, 4),
				GT_OreDictUnificator.get(OrePrefixes.gearGtSmall, Materials.Titaniolum, 16),
				GT_OreDictUnificator.get(OrePrefixes.gearGtSmall, Materials.HSSG, 16),
				GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.HSSE, 16),
				GT_OreDictUnificator.get(OrePrefixes.screw, Materials.HSSE, 16)
		}, GT_ItemList.Machine_PBE.get(1L), null, 40 * 20, 7680);
		
		RA.addBasicLineRecipe(new ItemStack[]{
				ItemList.Hull_IV.get(1L), GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Zamak, 4),
				GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Elite, 4),
				Itemstack(Core_Items2.getInstance(), 1, 182),
				ItemList.Electric_Piston_IV.get(4L), ItemList.Robot_Arm_IV.get(4L),
				ItemList.Emitter_IV.get(4L),
				GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Zamak, 8),
				GT_OreDictUnificator.get(OrePrefixes.stickLong, Materials.HSSG, 4),
				GT_OreDictUnificator.get(OrePrefixes.gear, Materials.Duraluminium, 8),
				GT_OreDictUnificator.get(OrePrefixes.gearGtSmall, Materials.Duraluminium, 16),
				GT_OreDictUnificator.get(OrePrefixes.gearGtSmall, Materials.HSSG, 16),
				GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.HSSE, 16),
				GT_OreDictUnificator.get(OrePrefixes.screw, Materials.HSSE, 16)
		}, GT_ItemList.Machine_LaserEngraver.get(1L), null, 40 * 20, 7680);
		
		RA.addBasicLineRecipe(new ItemStack[]{
				ItemList.Hull_IV.get(1L),
				GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Inconel690, 4),
				GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Elite, 8),
				Itemstack(Core_Items2.getInstance(), 1, 182),
				ItemList.Electric_Piston_IV.get(4L), ItemList.Robot_Arm_IV.get(4L),
				ItemList.Emitter_IV.get(4L), ItemList.Conveyor_Module_IV.get(4L),
				GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Inconel690, 8),
				GT_OreDictUnificator.get(OrePrefixes.stickLong, Materials.HSSG, 4),
				GT_OreDictUnificator.get(OrePrefixes.gear, Materials.Nitinol, 4),
				GT_OreDictUnificator.get(OrePrefixes.gearGtSmall, Materials.Nitinol, 8),
				GT_OreDictUnificator.get(OrePrefixes.gearGtSmall, Materials.HSSG, 8),
				GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.HSSE, 16),
				GT_OreDictUnificator.get(OrePrefixes.screw, Materials.HSSE, 16)
		}, GT_ItemList.Machine_Assembler.get(1L), null, 40 * 20, 7680);
		
		RA.addBasicLineRecipe(new ItemStack[]{
				ItemList.Hull_IV.get(1L),
				GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Inconel792, 4),
				GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Elite, 4),
				Itemstack(Core_Items2.getInstance(), 1, 182),
				ItemList.Electric_Motor_IV.get(4L), ItemList.Conveyor_Module_IV.get(4L),
				GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Inconel792, 8),
				GT_OreDictUnificator.get(OrePrefixes.stickLong, Materials.HSSG, 4),
				GT_OreDictUnificator.get(OrePrefixes.gear, Materials.TiBetaC, 8),
				GT_OreDictUnificator.get(OrePrefixes.gearGtSmall, Materials.TiBetaC, 8),
				GT_OreDictUnificator.get(OrePrefixes.gearGtSmall, Materials.HSSG, 8),
				GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.HSSE, 16),
				GT_OreDictUnificator.get(OrePrefixes.screw, Materials.HSSE, 16)
		}, GT_ItemList.Machine_Centrifuge.get(1L), null, 40 * 20, 7680);
		
		RA.addBasicLineRecipe(new ItemStack[]{
				ItemList.Hull_IV.get(1L),
				GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.HastelloyC276, 4),
				GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Elite, 4),
				Itemstack(Core_Items2.getInstance(), 1, 182),
				ItemList.Electric_Piston_IV.get(4L),
				GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.HastelloyC276, 8),
				GT_OreDictUnificator.get(OrePrefixes.stickLong, Materials.HSSG, 4),
				GT_OreDictUnificator.get(OrePrefixes.gear, Materials.Zamak, 4),
				GT_OreDictUnificator.get(OrePrefixes.gearGtSmall, Materials.Zamak, 8),
				GT_OreDictUnificator.get(OrePrefixes.gearGtSmall, Materials.HSSG, 8),
				GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.HSSE, 16),
				GT_OreDictUnificator.get(OrePrefixes.screw, Materials.HSSE, 16)
		}, GT_ItemList.Machine_Electrolyzer.get(1L), null, 40 * 20, 7680);
		
		RA.addBasicLineRecipe(new ItemStack[]{
				ItemList.Hull_IV.get(1L),
				GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Titaniolum, 4),
				GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Elite, 4),
				Itemstack(Core_Items2.getInstance(), 1, 182),
				ItemList.Conveyor_Module_IV.get(4L), ItemList.Electric_Piston_IV.get(4L),
				ItemList.Robot_Arm_IV.get(4L),
				GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Titaniolum, 8),
				GT_OreDictUnificator.get(OrePrefixes.stickLong, Materials.HSSG, 4),
				GT_OreDictUnificator.get(OrePrefixes.gear, Materials.Inconel690, 8),
				GT_OreDictUnificator.get(OrePrefixes.gearGtSmall, Materials.Inconel690, 16),
				GT_OreDictUnificator.get(OrePrefixes.gearGtSmall, Materials.HSSG, 16),
				GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.HSSE, 16),
				GT_OreDictUnificator.get(OrePrefixes.screw, Materials.HSSE, 16)
		}, GT_ItemList.Machine_Wire.get(1L), null, 40 * 20, 7680);
		
		RA.addBasicLineRecipe(new ItemStack[]{
				ItemList.Hull_IV.get(1L),
				GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.MaragingSteel250, 4),
				GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Elite, 4),
				Itemstack(Core_Items2.getInstance(), 1, 182),
				ItemList.Electric_Motor_IV.get(4L), ItemList.Conveyor_Module_IV.get(4L),
				GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.MaragingSteel250, 8),
				GT_OreDictUnificator.get(OrePrefixes.stickLong, Materials.HSSG, 4),
				GT_OreDictUnificator.get(OrePrefixes.gear, Materials.Inconel792, 4),
				GT_OreDictUnificator.get(OrePrefixes.gearGtSmall, Materials.Inconel792, 8),
				GT_OreDictUnificator.get(OrePrefixes.gearGtSmall, Materials.HSSG, 8),
				GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.HSSE, 16),
				GT_OreDictUnificator.get(OrePrefixes.screw, Materials.HSSE, 16)
		}, GT_ItemList.Machine_Supply.get(1L), null, 40 * 20, 7680);
		
		RA.addBasicLineRecipe(new ItemStack[]{
				ItemList.Hull_IV.get(1L),
				GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Nitinol, 4),
				GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Elite, 8),
				Itemstack(Core_Items2.getInstance(), 1, 182),
				ItemList.Electric_Piston_IV.get(4L), ItemList.Electric_Pump_IV.get(4L),
				ItemList.Conveyor_Module_IV.get(4L),
				GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Nitinol, 8),
				GT_OreDictUnificator.get(OrePrefixes.stickLong, Materials.HSSG, 4),
				GT_OreDictUnificator.get(OrePrefixes.gear, Materials.HastelloyC276, 4),
				GT_OreDictUnificator.get(OrePrefixes.gearGtSmall, Materials.HastelloyC276, 8),
				GT_OreDictUnificator.get(OrePrefixes.gearGtSmall, Materials.HSSG, 8),
				GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.HSSE, 16),
				GT_OreDictUnificator.get(OrePrefixes.screw, Materials.HSSE, 16)
		}, GT_ItemList.Machine_Utility.get(1L), null, 40 * 20, 7680);
		
		RA.addBasicLineRecipe(new ItemStack[]{
				ItemList.Hull_IV.get(1L),
				GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Talonite, 4),
				GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Elite, 8),
				Itemstack(Core_Items2.getInstance(), 1, 182),
				ItemList.Electric_Piston_IV.get(4L), ItemList.Electric_Pump_IV.get(4L),
				GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Talonite, 8),
				GT_OreDictUnificator.get(OrePrefixes.stickLong, Materials.HSSG, 4),
				GT_OreDictUnificator.get(OrePrefixes.gear, Materials.Grisium, 4),
				GT_OreDictUnificator.get(OrePrefixes.gearGtSmall, Materials.Grisium, 8),
				GT_OreDictUnificator.get(OrePrefixes.gearGtSmall, Materials.HSSG, 8),
				GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.HSSE, 16),
				GT_OreDictUnificator.get(OrePrefixes.screw, Materials.HSSE, 16)
		}, GT_ItemList.Machine_Brewmenter.get(1L), null, 40 * 20, 7680);
		
		RA.addBasicLineRecipe(new ItemStack[]{
				ItemList.Hull_IV.get(1L),
				GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Nitinol, 4),
				GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Elite, 8),
				Itemstack(Core_Items2.getInstance(), 1, 182),
				ItemList.Electric_Piston_IV.get(4L), ItemList.Conveyor_Module_IV.get(4L),
				GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Nitinol, 8),
				GT_OreDictUnificator.get(OrePrefixes.stickLong, Materials.HSSG, 4),
				GT_OreDictUnificator.get(OrePrefixes.gear, Materials.Inconel690, 4),
				GT_OreDictUnificator.get(OrePrefixes.gearGtSmall, Materials.Inconel690, 8),
				GT_OreDictUnificator.get(OrePrefixes.gearGtSmall, Materials.HSSG, 8),
				GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.HSSE, 16),
				GT_OreDictUnificator.get(OrePrefixes.screw, Materials.HSSE, 16)
		}, GT_ItemList.Machine_Siftarator.get(1L), null, 40 * 20, 7680);
		
		RA.addBasicLineRecipe(new ItemStack[]{
				ItemList.Hull_IV.get(1L),
				GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Nitinol60, 4),
				GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Elite, 8),
				Itemstack(Core_Items2.getInstance(), 1, 182),
				ItemList.Electric_Piston_IV.get(4L),
				GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Nitinol60, 8),
				GT_OreDictUnificator.get(OrePrefixes.stickLong, Materials.HSSG, 4),
				GT_OreDictUnificator.get(OrePrefixes.gear, Materials.Kovar, 4),
				GT_OreDictUnificator.get(OrePrefixes.gearGtSmall, Materials.Kovar, 8),
				GT_OreDictUnificator.get(OrePrefixes.gearGtSmall, Materials.HSSG, 8),
				GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.HSSE, 16),
				GT_OreDictUnificator.get(OrePrefixes.screw, Materials.HSSE, 16)
		}, GT_ItemList.Machine_ArcFurnace.get(1L), null, 40 * 20, 7680);
		
		RA.addBasicLineRecipe(new ItemStack[]{
				ItemList.Hull_IV.get(1L),
				GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.TiBetaC, 4),
				GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Elite, 8),
				Itemstack(Core_Items2.getInstance(), 1, 182),
				ItemList.Electric_Piston_IV.get(4L), ItemList.Electric_Pump_IV.get(4L),
				GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.TiBetaC, 8),
				GT_OreDictUnificator.get(OrePrefixes.stickLong, Materials.HSSG, 4),
				GT_OreDictUnificator.get(OrePrefixes.gear, Materials.Talonite, 4),
				GT_OreDictUnificator.get(OrePrefixes.gearGtSmall, Materials.Talonite, 8),
				GT_OreDictUnificator.get(OrePrefixes.gearGtSmall, Materials.HSSG, 8),
				GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.HSSE, 16),
				GT_OreDictUnificator.get(OrePrefixes.screw, Materials.HSSE, 16)
		}, GT_ItemList.Machine_Extradifier.get(1L), null, 40 * 20, 7680);
		
		RA.addBasicLineRecipe(new ItemStack[]{
				ItemList.Hull_IV.get(1L),
				GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Titaniolum, 4),
				GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Elite, 8),
				Itemstack(Core_Items2.getInstance(), 1, 182),
				ItemList.Electric_Motor_IV.get(4L), ItemList.Conveyor_Module_IV.get(4L),
				GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Titaniolum, 8),
				GT_OreDictUnificator.get(OrePrefixes.stickLong, Materials.HSSG, 4),
				GT_OreDictUnificator.get(OrePrefixes.gear, Materials.MaragingSteel250, 8),
				GT_OreDictUnificator.get(OrePrefixes.gearGtSmall, Materials.MaragingSteel250, 16),
				GT_OreDictUnificator.get(OrePrefixes.gearGtSmall, Materials.HSSG, 16),
				GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.HSSE, 16),
				GT_OreDictUnificator.get(OrePrefixes.screw, Materials.HSSE, 16)
		}, GT_ItemList.Machine_Mixer.get(1L), null, 40 * 20, 7680);
		
		RA.addBasicLineRecipe(new ItemStack[]{
				ItemList.Hull_IV.get(1L),
				GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.HastelloyC276, 4),
				GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Elite, 8),
				Itemstack(Core_Items2.getInstance(), 1, 182),
				ItemList.Electric_Piston_IV.get(4L), ItemList.Conveyor_Module_IV.get(4L),
				GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.HastelloyC276, 8),
				GT_OreDictUnificator.get(OrePrefixes.stickLong, Materials.HSSG, 4),
				GT_OreDictUnificator.get(OrePrefixes.gear, Materials.Mangalloy, 8),
				GT_OreDictUnificator.get(OrePrefixes.gearGtSmall, Materials.Mangalloy, 16),
				GT_OreDictUnificator.get(OrePrefixes.gearGtSmall, Materials.HSSG, 16),
				GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.HSSE, 16),
				GT_OreDictUnificator.get(OrePrefixes.screw, Materials.HSSE, 16)
		}, GT_ItemList.Machine_Macerator.get(1L), null, 40 * 20, 7680);
		
		RA.addBasicLineRecipe(new ItemStack[]{
				ItemList.Hull_IV.get(1L),
				GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.MaragingSteel300, 4),
				GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Elite, 8),
				Itemstack(Core_Items2.getInstance(), 1, 182),
				ItemList.Electric_Motor_IV.get(4L), ItemList.Conveyor_Module_IV.get(4L),
				GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.MaragingSteel300, 8),
				GT_OreDictUnificator.get(OrePrefixes.stickLong, Materials.HSSG, 4),
				GT_OreDictUnificator.get(OrePrefixes.gear, Materials.Stellite, 4),
				GT_OreDictUnificator.get(OrePrefixes.gearGtSmall, Materials.Stellite, 16),
				GT_OreDictUnificator.get(OrePrefixes.gearGtSmall, Materials.HSSG, 16),
				GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.HSSE, 16),
				GT_OreDictUnificator.get(OrePrefixes.screw, Materials.HSSE, 16)
		}, GT_ItemList.Machine_Cutting.get(1L), null, 40 * 20, 7680);
		
		//UpgradeCasingT1
		RA.addBasicLineRecipe(new ItemStack[]{
				ItemList.Hull_IV.get(1L),
				GT_ModHandler.getModItem(AE2, "tile.BlockCraftingStorage", 1, 3),
				GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.GumMetal, 4),
				GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Nitinol, 16),
				ItemList.Electric_Motor_IV.get(4L), ItemList.Electric_Piston_IV.get(4L),
				ItemList.Conveyor_Module_IV.get(4L), ItemList.Robot_Arm_IV.get(4L),
				GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Elite, 8),
				GT_OreDictUnificator.get(OrePrefixes.wireGt04, Materials.Graphene, 16),
				GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.TungstenSteel, 16),
				GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.HSSE, 16)
		}, GT_ItemList.UpgradeCasingT1.get(1L), null, 80 * 20, 7680);
		
		RA.addPrimitiveLineRecipe(new ItemStack[]{
				GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 1L, 500),
				ItemList.Cover_ItemDetector.get(8L),
				GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Nitinol, 8),
				ItemList.Robot_Arm_IV.get(8L), GT_ItemList.DDDPrinterCasing3x3.get(9),
				GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Elite, 16),
				GT_OreDictUnificator.get(OrePrefixes.gearGt, Materials.TungstenSteel, 16),
				GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.GumMetal, 32),
				GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.HSSE, 64)
		}, GT_ItemList.DDDPrinterCasing4x4.get(16L), null, 200 * 20, 1920);
		
		//Machine_BlastSmelter
		RA.addPrimitiveLineRecipe(new ItemStack[]{
				ItemList.Machine_Multi_BlastFurnace.get(1L),
				GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.HSLA, 2),
				GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Data, 4),
				GT_OreDictUnificator.get(OrePrefixes.wireGt08, Materials.Kanthal, 4),
				GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.HSLA, 6),
				GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Titanium, 16)
		}, GT_ItemList.Machine_BlastSmelter.get(1L), null, 40 * 20, 1920);
		
		//Machine_FreezSolidifier
		RA.addPrimitiveLineRecipe(new ItemStack[]{
				ItemList.Machine_Multi_VacuumFreezer.get(1L),
				GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.BlueSteel, 2),
				GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Data, 4),
				GT_OreDictUnificator.get(OrePrefixes.pipeLarge, Materials.StainlessSteel, 4),
				GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Aluminium, 6),
				GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Titanium, 16)
		}, GT_ItemList.Machine_FreezSolidifier.get(1L), null, 40 * 20, 1920);
		
		//AdvancedFreezer
		RA.addBasicLineRecipe(new ItemStack[]{
				ItemList.Hull_ZPM.get(1L),
				GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Lafium, 4),
				GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Ultimate, 6),
				GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Iridium, 8),
				ItemList.Electric_Pump_ZPM.get(4L), ItemList.Robot_Arm_ZPM.get(4L),
				ItemList.Reactor_Coolant_Le_3.get(1L), ItemList.Reactor_Coolant_Le_3.get(1L),
				GT_OreDictUnificator.get(OrePrefixes.pipeMedium, Materials.Enderium, 8),
				GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Osmiridium, 16),
				GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.HSSE, 64)
		}, GT_ItemList.AdvVacuumFreezer.get(1L), null, 200 * 20, 122880);
		
		//AdvancedEBF
		RA.addBasicLineRecipe(new ItemStack[]{
				ItemList.Hull_ZPM.get(1L),
				GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Lafium, 4),
				GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Ultimate, 6),
				GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Iridium, 8),
				ItemList.Conveyor_Module_ZPM.get(4L), ItemList.Robot_Arm_ZPM.get(4L),
				ItemList.Casing_Coil_Superconductor.get(8L), ItemList.Casing_Coil_NaquadahAlloy.get(16L),
				GT_OreDictUnificator.get(OrePrefixes.wireGt08, Materials.Naquadah, 16),
				GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Osmiridium, 16),
				GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.HSSE, 64)
		}, GT_ItemList.Machine_EIF.get(1L), null, 200 * 20, 122880);
		
		//LapatronicSupercapacitor
		RA.addBasicLineRecipe(new ItemStack[]{
				ItemList.Hull_IV.get(1L), ItemList.Battery_TurboCharger_4by4_IV.get(1L),
				GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.HastelloyC276, 6),
				GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Elite, 8),
				ItemList.Circuit_Chip_HPIC.get(16L),
				GT_OreDictUnificator.get(OrePrefixes.spring, Materials.Platinum, 16),
				ItemList.Reactor_Coolant_He_6.get(1L), ItemList.Reactor_Coolant_He_6.get(1L),
				ItemList.Electric_Pump_IV.get(4L),
				GT_OreDictUnificator.get(OrePrefixes.pipeSmall, Materials.Inconel690, 8),
				GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Kovar, 16),
				GT_OreDictUnificator.get(OrePrefixes.stickLong, Materials.TungstenSteel, 32),
				GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.HSSE, 64),
				GT_OreDictUnificator.get(OrePrefixes.screw, Materials.HSSG, 64)
		}, GT_ItemList.LapPowerStation.get(1L), null, 200 * 20, 4092);
		
		//LapotronicCapacitorIV
		RA.addBasicLineRecipe(new ItemStack[]{
				GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Inconel792, 1),
				ItemList.Energy_LapotronicOrb.get(4L),
				GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Platinum, 8),
				ItemList.Circuit_Chip_PIC.get(12L),
				GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.TungstenSteel, 32),
				GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.HastelloyC276, 64),
				GT_OreDictUnificator.get(OrePrefixes.screw, Materials.HSSG, 64)
		}, new ItemStack(lscLapotronicEnergyUnit, 1, 1), null, 100 * 20, 7680);
		
		//Energium Orb Capacitor
		RA.addBasicLineRecipe(new ItemStack[]{
				GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Inconel792, 1),
				ItemList.EnergyCrystal_IV.get(4L),
				GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Platinum, 8),
				ItemList.Circuit_Chip_PIC.get(12L),
				GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.TungstenSteel, 32),
				GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.HastelloyC276, 64),
				GT_OreDictUnificator.get(OrePrefixes.screw, Materials.HSSG, 64)
		}, new ItemStack(lscLapotronicEnergyUnit, 1, 6), null, 100 * 20, 7680);
		
		//LapotronicCapacitorLuV
		RA.addBasicLineRecipe(new ItemStack[]{
				GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Inconel792, 1),
				ItemList.Energy_LapotronicOrb2.get(4L),
				GT_OreDictUnificator.get(OrePrefixes.foil, Materials.NiobiumTitanium, 8),
				ItemList.Circuit_Chip_HPIC.get(12L),
				GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.YttriumBariumCuprate, 32),
				GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.HastelloyN, 64),
				GT_OreDictUnificator.get(OrePrefixes.screw, Materials.HSSE, 64)
		}, new ItemStack(lscLapotronicEnergyUnit, 1, 2), null, 120 * 20, 30720);
		
		//LapotronicCapacitorZPM
		RA.addBasicLineRecipe(new ItemStack[]{
				GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Inconel792, 1),
				ItemList.Energy_Module.get(4L),
				GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Osmiridium, 8),
				ItemList.Circuit_Chip_UHPIC.get(12L),
				GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Naquadah, 32),
				GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Lafium, 64),
				GT_OreDictUnificator.get(OrePrefixes.screw, Materials.HSSS, 64)
		}, new ItemStack(lscLapotronicEnergyUnit, 1, 3), null, 140 * 20, 122880);
		
		//LapotronicCapacitorUV
		RA.addBasicLineRecipe(new ItemStack[]{
				GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Inconel792, 1),
				ItemList.Energy_Cluster.get(4L),
				GT_OreDictUnificator.get(OrePrefixes.foil, Materials.NaquadahAlloy, 8),
				ItemList.Circuit_Chip_NPIC.get(12L),
				GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Duranium, 32),
				GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.CinobiteA243, 64),
				GT_OreDictUnificator.get(OrePrefixes.screw, Materials.Tritanium, 64)
		}, new ItemStack(lscLapotronicEnergyUnit, 1, 4), null, 160 * 20, 500000);
		
		//LapotronicCapacitorUHV
		/*RA.addBasicLineRecipe(new ItemStack[]{
				GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Inconel792, 1),
				ItemList.ZPM2.get(1L), GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Americium, 8),
				ItemList.Circuit_Chip_PPIC.get(12L),
				GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Europium, 32),
				GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Pikyonium64B, 64),
				GT_OreDictUnificator.get(OrePrefixes.screw, Materials.Neutronium, 64)
		}, new ItemStack(lscLapotronicEnergyUnit, 1, 5), null, 180 * 20, 2000000);*/
		
		//Mysterious Crystal Orb Capacitor
		RA.addBasicLineRecipe(new ItemStack[]{
				GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Inconel792, 1),
				ItemList.MysteriousCrystalOrb.get(4L), GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Americium, 8),
				ItemList.Circuit_Chip_PPIC.get(12L),
				GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Europium, 32),
				GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Pikyonium64B, 64),
				GT_OreDictUnificator.get(OrePrefixes.screw, Materials.Neutronium, 64)
		}, new ItemStack(lscLapotronicEnergyUnit, 1, 7), null, 180 * 20, 2000000);
		
		//Mysterious Crystal Module Capacitor
		RA.addBasicLineRecipe(new ItemStack[]{
				GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Inconel792, 1),
				ItemList.MysteriousCrystalModule.get(4L), GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Americium, 8),
				ItemList.Circuit_Chip_QPIC.get(12L),
				GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Draconium, 32),
				GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Quantum, 64),
				GT_OreDictUnificator.get(OrePrefixes.screw, Materials.Phoenixite, 64)
		}, new ItemStack(lscLapotronicEnergyUnit, 1, 8), null, 200 * 20, 8000000);
		
		//AdvancedPyrolyseOven
		RA.addPrimitiveLineRecipe(new ItemStack[]{
				GT_ItemList.Pyrolyse.get(1L),
				GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.HSLA, 2),
				ItemList.Electric_Pump_EV.get(2L),
				ItemList.Electric_Piston_EV.get(2L),
				GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Data, 4),
				GT_OreDictUnificator.get(OrePrefixes.pipeNonuple, Materials.StainlessSteel, 4),
				GT_OreDictUnificator.get(OrePrefixes.wireGt08, Materials.Kanthal, 6),
				GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.HSLA, 6),
				GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Titanium, 16)
		}, GT_ItemList.AdvPyrolyse.get(1L), null, 60 * 20, 1920);
		
		//Naquadah Chamber Part
		RA.addBasicLineRecipe(new ItemStack[]{
				GT_OreDictUnificator.get(OrePrefixes.stickLong, Materials.NaquadahAlloy, 8),
				GT_OreDictUnificator.get(OrePrefixes.stickLong, Materials.TungstenSteel, 8),
				GT_OreDictUnificator.get(OrePrefixes.stickLong, Materials.GumMetal, 8),
				GT_OreDictUnificator.get(OrePrefixes.stickLong, Materials.Desh, 8),
				GT_OreDictUnificator.get(OrePrefixes.ring, Materials.TungstenCarbide, 16),
				GT_OreDictUnificator.get(OrePrefixes.ring, Materials.Talonite, 16),
				GT_OreDictUnificator.get(OrePrefixes.screw, Materials.HSSS, 32)
		}, CoreItems2.getRecipe(163, 1), null, 30 * 20, 7680);
		
		//Tachyon Tube
		RA.addBasicLineRecipe(new ItemStack[]{
				CoreItems2.getRecipe(163, 3), CoreItems2.getRecipe(161, 4),
				GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Californium, 32),
				GT_OreDictUnificator.get(OrePrefixes.foil, Materials.NiobiumTitanium, 32),
				GT_OreDictUnificator.get(OrePrefixes.ring, Materials.Trinium, 32),
				GT_OreDictUnificator.get(OrePrefixes.ring, Materials.Iridium, 32),
				GT_OreDictUnificator.get(OrePrefixes.screw, Materials.NaquadahAlloy, 32)
		}, CoreItems2.getRecipe(162, 1), null, 40 * 20, 7680);
		
		//Cyclone Chamber Casing
		RA.addBasicLineRecipe(new ItemStack[]{
				GT_ItemList.CycloneCasing.get(1), ItemList.Electric_Motor_LuV.get(1L),
				GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.MaragingSteel250, 2),
				GT_OreDictUnificator.get(OrePrefixes.pipeLarge, Materials.MaragingSteel300, 2),
				GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Master, 4),
				GT_OreDictUnificator.get(OrePrefixes.plateTriple, Materials.Inconel792, 4),
				GT_OreDictUnificator.get(OrePrefixes.stickLong, Materials.TiBetaC, 6),
				GT_OreDictUnificator.get(OrePrefixes.ring, Materials.Inconel690, 12),
				GT_OreDictUnificator.get(OrePrefixes.screw, Materials.HSSS, 16)
		}, new ItemStack(InsideBlock, 1, 1), null, 60 * 20, 30720);
		
		//3DPrinter 4x4
		RA.addPrimitiveLineRecipe(new ItemStack[]{
				ItemList.Machine_IV_Printer.get(1L),
				GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 1L, 500),
				ItemList.Conveyor_Module_IV.get(4L),
				GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Inconel690, 4),
				GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Elite, 6),
				GT_OreDictUnificator.get(OrePrefixes.gearGt, Materials.TungstenSteel, 8),
				GT_OreDictUnificator.get(OrePrefixes.gearGtSmall, Materials.HastelloyC276, 16),
				GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.HSSG, 16),
				GT_OreDictUnificator.get(OrePrefixes.screw, Materials.HSSE, 16)
		}, GT_ItemList.Machine_AdvDDDPrinter.get(1L), null, 50 * 20, 1920);
		
		//Communication Tower
		RA.addPrimitiveLineRecipe(new ItemStack[]{
				ItemList.Hull_HV.get(1L),
				GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Advanced, 4),
				Itemstack(Core_Items2.getInstance(), 1, 182),
				GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.StainlessSteel, 4),
				ItemList.Tool_DataStick.get(1L),
				GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.HSLA, 4),
				GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.RedSteel, 8),
				GT_OreDictUnificator.get(OrePrefixes.screw, Materials.BlueSteel, 8)
		}, GT_ItemList.Communication_Tower.get(1L), null, 40 * 20, 480);
		//Space Satelitte
		RA.addPrimitiveLineRecipe(new ItemStack[]{
				ItemList.Hull_HV.get(1L),
				GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Advanced, 4),
				Itemstack(Core_Items2.getInstance(), 1, 182),
				GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.StainlessSteel, 4),
				GT_ModHandler.getModItem(AE2, "tile.BlockCraftingUnit", 4L, 1),
				GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.VanadiumSteel, 4),
				GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.RedSteel, 8),
				GT_OreDictUnificator.get(OrePrefixes.screw, Materials.BlueSteel, 8)
		}, GT_ItemList.Space_Satellite.get(1L), null, 50 * 20, 480);
		
		//Space Elevator
		RA.addPrimitiveLineRecipe(new ItemStack[]{
				ItemList.Hull_EV.get(1L),
				GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Data, 4),
				Itemstack(Core_Items2.getInstance(), 1, 182),
				GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.HSLA, 4),
				GT_ModHandler.getModItem("EnderIO", "blockTravelAnchor", 2L, 0),
				ItemList.Conveyor_Module_EV.get(8L),
				GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Vanadium, 16),
				GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.HSLA, 32),
				GT_OreDictUnificator.get(OrePrefixes.screw, Materials.Titanium, 32)
		}, GT_ItemList.Space_Elevator.get(1L), null, 60 * 20, 1920);
		
		//Nuclear Reactor I
		RA.addPrimitiveLineRecipe(new ItemStack[]{
				ItemList.Hull_EV.get(1L), ItemList.Robot_Arm_EV.get(1L),
				GT_OreDictUnificator.get(OrePrefixes.plateDense, Materials.Titanium, 2),
				GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Data, 4),
				GT_ModHandler.getModItem("IC2", "reactorPlatingExplosive", 8), GT_OreDictUnificator.get(OrePrefixes.plateTriple, Materials.Lead, 8)
		}, GT_ItemList.Nuclear_Reactor_I.get(1), null, 30 * 20, 1920);
		
		//Nuclear Reactor II
		RA.addBasicLineRecipe(new ItemStack[]{
				ItemList.Hull_IV.get(1L), ItemList.Robot_Arm_IV.get(2L),
				GT_OreDictUnificator.get(OrePrefixes.plateDense, Materials.Titanium, 4),
				GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Elite, 6),
				GT_ModHandler.getModItem("IC2", "reactorPlatingExplosive", 8), CoreItems2.getRecipe(141, 8),
				GT_OreDictUnificator.get(OrePrefixes.plateTriple, Materials.Lead, 10)
		}, GT_ItemList.Nuclear_Reactor_II.get(1), null, 50 * 20, 7680);
		
		//Nuclear Reactor III
		RA.addBasicLineRecipe(new ItemStack[]{
				ItemList.Hull_LuV.get(1L), ItemList.Robot_Arm_LuV.get(4L),
				GT_OreDictUnificator.get(OrePrefixes.plateDense, Materials.Titanium, 8),
				GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Master, 8),
				GT_OreDictUnificator.get(OrePrefixes.plateDense, Materials.TungstenSteel, 8),
				CoreItems2.getRecipe(142, 8), GT_OreDictUnificator.get(OrePrefixes.plateTriple, Materials.Lead, 12)
		}, GT_ItemList.Nuclear_Reactor_III.get(1), null, 80 * 20, 30720);
		
		//Huge Steam Turbine
		RA.addBasicLineRecipe(new ItemStack[]{
				ItemList.Hull_IV.get(1L), ItemList.Electric_Pump_IV.get(4L),
				GT_OreDictUnificator.get(OrePrefixes.gearGt, Materials.TiBetaC, 4),
				GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Elite, 6),
				GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Titaniolum, 8),
				GT_OreDictUnificator.get(OrePrefixes.pipeHuge, Materials.Inconel690, 8),
				GT_OreDictUnificator.get(OrePrefixes.stickLong, Materials.Inconel792, 8),
				GT_OreDictUnificator.get(OrePrefixes.ring, Materials.Desh, 8),
				GT_OreDictUnificator.get(OrePrefixes.round, Materials.HSSG, 16),
				GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Inconel792, 16)
		}, GT_ItemList.Huge_Steam_Turbine.get(1L), null, 60 * 20, 7680);
		
		//MultiChemicalReactor
		RA.addBasicLineRecipe(new ItemStack[]{
				ItemList.Hull_LuV.get(1L),
				GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Talonite, 4),
				GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Master, 8),
				ItemList.Electric_Pump_LuV.get(4L),
				GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Talonite, 8),
				GT_OreDictUnificator.get(OrePrefixes.pipeHuge, Materials.Polytetrafluoroethylene, 4),
				GT_OreDictUnificator.get(OrePrefixes.gear, Materials.Inconel792, 4),
				GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.Grisium, 8),
				GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.HSSE, 16),
				GT_OreDictUnificator.get(OrePrefixes.screw, Materials.HSSE, 16)
		}, GT_ItemList.Machine_ChemicalReactor.get(1L), null, 80 * 20, 30720);
		
		//MultiDistillationTower
		RA.addBasicLineRecipe(new ItemStack[]{
				ItemList.Hull_LuV.get(1L),
				GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.MaragingSteel250, 4),
				GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Master, 8),
				ItemList.Electric_Pump_LuV.get(8L),
				GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.TiBetaC, 8),
				GT_OreDictUnificator.get(OrePrefixes.pipeHuge, Materials.NiobiumTitanium, 4),
				GT_OreDictUnificator.get(OrePrefixes.spring, Materials.Tungsten, 16),
				GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.HSSE, 16),
				GT_OreDictUnificator.get(OrePrefixes.screw, Materials.HSSE, 16)
		}, GT_ItemList.Machine_DistTower.get(1L), null, 80 * 20, 30720);
		
		//ElectricImplosionCompressor
		RA.addBasicLineRecipe(new ItemStack[]{
				ItemList.Hull_LuV.get(1L),
				GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Kovar, 4),
				GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Master, 8),
				ItemList.Electric_Piston_LuV.get(8L),
				GT_OreDictUnificator.get(OrePrefixes.plateDense, Materials.Zamak, 8),
				GT_OreDictUnificator.get(OrePrefixes.stickLong, Materials.HSSG, 8),
				GT_OreDictUnificator.get(OrePrefixes.gearGt, Materials.Titaniolum, 8),
				GT_OreDictUnificator.get(OrePrefixes.gearGtSmall, Materials.Titaniolum, 16),
				GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.HSSE, 16),
				GT_OreDictUnificator.get(OrePrefixes.screw, Materials.HSSE, 16)
		}, GT_ItemList.Machine_ElectricImplosion.get(1L), null, 80 * 20, 30720);
		
		// --- LuV Orb
		RA.addBasicLineRecipe(new ItemStack[]{
						ItemList.Circuit_Board_Fiberglass_Advanced.get(1),
						GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Plutonium241, 4),
						GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Europium, 32L),
						GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Master, 4),
						GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Californium, 8),
						ItemList.Energy_LapotronicOrb.get(4L),
						ItemList.Field_Generator_EV.get(1),
						ItemList.Circuit_Chip_UHPIC.get(16),
						ItemList.Circuit_Parts_DiodeASMD.get(8),
						ItemList.Circuit_Parts_CapacitorASMD.get(8),
						ItemList.Circuit_Parts_ResistorASMD.get(8),
						ItemList.Circuit_Parts_TransistorASMD.get(8),
						GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.SuperconductorLuV, 16),
						GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Trinium, 16L)
				},
				ItemList.Energy_LapotronicOrb2.get(1), null, 1000, 80000
		);
		
		RA.addBasicLineRecipe(new ItemStack[]{
						ItemList.Circuit_Board_Fiberglass_Advanced.get(1),
						GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.NaquadahEnriched, 4),
						GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Europium, 32L),
						GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Master, 4),
						GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Californium, 8),
						ItemList.Energy_LapotronicOrb.get(2L),
						ItemList.Field_Generator_IV.get(1),
						ItemList.Circuit_Chip_UHPIC.get(16),
						ItemList.Circuit_Parts_DiodeASMD.get(8),
						ItemList.Circuit_Parts_CapacitorASMD.get(8),
						ItemList.Circuit_Parts_ResistorASMD.get(8),
						ItemList.Circuit_Parts_TransistorASMD.get(8),
						GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.SuperconductorLuV, 16),
						GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Oriharukon, 16L)
				},
				ItemList.Energy_LapotronicOrb2.get(1), null, 1000, 80000
		);
		
		RA.addBasicLineRecipe(new ItemStack[]{
						ItemList.Circuit_Board_Fiberglass_Advanced.get(1),
						GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Naquadria, 4),
						GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Europium, 32L),
						GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Master, 4),
						GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Californium, 8),
						ItemList.Energy_LapotronicOrb.get(1L),
						ItemList.Field_Generator_LuV.get(1),
						ItemList.Circuit_Chip_UHPIC.get(16),
						ItemList.Circuit_Parts_DiodeASMD.get(8),
						ItemList.Circuit_Parts_CapacitorASMD.get(8),
						ItemList.Circuit_Parts_ResistorASMD.get(8),
						ItemList.Circuit_Parts_TransistorASMD.get(8),
						GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.SuperconductorLuV, 16),
						GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Quantium, 16L)
				},
				ItemList.Energy_LapotronicOrb2.get(1), null, 1000, 80000
		);
		
		// --- ZPM Orb
		RA.addBasicLineRecipe(new ItemStack[]{
						ItemList.Circuit_Board_Multifiberglass_Elite.get(1),
						GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Plutonium241, 8),
						GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Americium, 32L),
						GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Ultimate, 4),
						GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Californium, 16),
						ItemList.Energy_LapotronicOrb2.get(4L),
						ItemList.Field_Generator_IV.get(1),
						ItemList.Circuit_Chip_NPIC.get(16),
						ItemList.Circuit_Parts_DiodeASMD.get(16),
						ItemList.Circuit_Parts_CapacitorASMD.get(16),
						ItemList.Circuit_Parts_ResistorASMD.get(16),
						ItemList.Circuit_Parts_TransistorASMD.get(16),
						GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.SuperconductorZPM, 16),
						GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Oriharukon, 16L)
				},
				ItemList.Energy_Module.get(1), null, 1200, 100000
		);
		
		RA.addBasicLineRecipe(new ItemStack[]{
						ItemList.Circuit_Board_Multifiberglass_Elite.get(1),
						GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.NaquadahEnriched, 8),
						GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Americium, 32L),
						GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Ultimate, 4),
						GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Californium, 16),
						ItemList.Energy_LapotronicOrb2.get(2L),
						ItemList.Field_Generator_LuV.get(1),
						ItemList.Circuit_Chip_NPIC.get(16),
						ItemList.Circuit_Parts_DiodeASMD.get(16),
						ItemList.Circuit_Parts_CapacitorASMD.get(16),
						ItemList.Circuit_Parts_ResistorASMD.get(16),
						ItemList.Circuit_Parts_TransistorASMD.get(16),
						GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.SuperconductorZPM, 16),
						GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Quantium, 16L)
				},
				ItemList.Energy_Module.get(1), null, 1200, 100000
		);
		
		RA.addBasicLineRecipe(new ItemStack[]{
						ItemList.Circuit_Board_Multifiberglass_Elite.get(1),
						GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Naquadria, 8),
						GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Americium, 32L),
						GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Ultimate, 4),
						GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Californium, 16),
						ItemList.Energy_LapotronicOrb2.get(1L),
						ItemList.Field_Generator_ZPM.get(1),
						ItemList.Circuit_Chip_NPIC.get(16),
						ItemList.Circuit_Parts_DiodeASMD.get(16),
						ItemList.Circuit_Parts_CapacitorASMD.get(16),
						ItemList.Circuit_Parts_ResistorASMD.get(16),
						ItemList.Circuit_Parts_TransistorASMD.get(16),
						GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.SuperconductorZPM, 16),
						GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Adamantium, 16L)
				},
				ItemList.Energy_Module.get(1), null, 1200, 100000
		);
		
		// --- UV Orb
		RA.addBasicLineRecipe(new ItemStack[]{
						ItemList.Circuit_Board_Wetware_Extreme.get(1),
						GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Plutonium241, 16),
						GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Neutronium, 32L),
						GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Superconductor, 4),
						GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Californium, 32),
						ItemList.Energy_Module.get(4L),
						ItemList.Field_Generator_LuV.get(1),
						ItemList.Circuit_Chip_PPIC.get(16),
						ItemList.Circuit_Parts_DiodeASMD.get(32),
						ItemList.Circuit_Parts_CapacitorASMD.get(32),
						ItemList.Circuit_Parts_ResistorASMD.get(32),
						ItemList.Circuit_Parts_TransistorASMD.get(32),
						GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.SuperconductorUV, 16),
						GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Quantium, 16L)
				},
				ItemList.Energy_Cluster.get(1), null, 1400, 200000
		);
		
		RA.addBasicLineRecipe(new ItemStack[]{
						ItemList.Circuit_Board_Wetware_Extreme.get(1),
						GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.NaquadahEnriched, 16),
						GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Neutronium, 32L),
						GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Superconductor, 4),
						GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Californium, 32),
						ItemList.Energy_Module.get(2L),
						ItemList.Field_Generator_ZPM.get(1),
						ItemList.Circuit_Chip_PPIC.get(16),
						ItemList.Circuit_Parts_DiodeASMD.get(32),
						ItemList.Circuit_Parts_CapacitorASMD.get(32),
						ItemList.Circuit_Parts_ResistorASMD.get(32),
						ItemList.Circuit_Parts_TransistorASMD.get(32),
						GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.SuperconductorUV, 16),
						GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Adamantium, 16L)
				},
				ItemList.Energy_Cluster.get(1), null, 1400, 200000
		);
		
		RA.addBasicLineRecipe(new ItemStack[]{
						ItemList.Circuit_Board_Wetware_Extreme.get(1),
						GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Naquadria, 16),
						GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Neutronium, 32L),
						GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Superconductor, 4),
						GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Californium, 32),
						ItemList.Energy_Module.get(1L),
						ItemList.Field_Generator_UV.get(1),
						ItemList.Circuit_Chip_PPIC.get(16),
						ItemList.Circuit_Parts_DiodeASMD.get(32),
						ItemList.Circuit_Parts_CapacitorASMD.get(32),
						ItemList.Circuit_Parts_ResistorASMD.get(32),
						ItemList.Circuit_Parts_TransistorASMD.get(32),
						GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.SuperconductorUV, 16),
						GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.BlackPlutonium, 16L)
				},
				ItemList.Energy_Cluster.get(1), null, 1400, 200000
		);
		
		// --- UHV Orb
		RA.addBasicLineRecipe(new ItemStack[]{
						CoreItems2.getRecipe(190, 1),
						GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Plutonium241, 24),
						GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Neutronium, 32L),
						GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Infinite, 4),
						GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Californium, 48),
						ItemList.Circuit_Parts_MECrystal_Chip_Elite.get(60L),
						ItemList.Field_Generator_IV.get(1),
						ItemList.Circuit_Chip_QPIC.get(16),
						ItemList.Circuit_Parts_DiodeASMD.get(48),
						ItemList.Circuit_Parts_CapacitorASMD.get(48),
						ItemList.Circuit_Parts_ResistorASMD.get(48),
						ItemList.Circuit_Parts_TransistorASMD.get(48),
						GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.Europium, 16),
						GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Adamantium, 16L)
				},
				ItemList.MysteriousCrystalOrb.get(1), null, 2000, 1000000
		);
		
		RA.addBasicLineRecipe(new ItemStack[]{
						CoreItems2.getRecipe(190, 1),
						GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.NaquadahEnriched, 24),
						GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Neutronium, 32L),
						GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Infinite, 4),
						GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Californium, 48),
						ItemList.Circuit_Parts_MECrystal_Chip_Elite.get(48L),
						ItemList.Field_Generator_LuV.get(1),
						ItemList.Circuit_Chip_QPIC.get(16),
						ItemList.Circuit_Parts_DiodeASMD.get(48),
						ItemList.Circuit_Parts_CapacitorASMD.get(48),
						ItemList.Circuit_Parts_ResistorASMD.get(48),
						ItemList.Circuit_Parts_TransistorASMD.get(48),
						GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.Europium, 16),
						GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.BlackPlutonium, 16L)
				},
				ItemList.MysteriousCrystalOrb.get(1), null, 1600, 1000000
		);
		
		RA.addBasicLineRecipe(new ItemStack[]{
						CoreItems2.getRecipe(190, 1),
						GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Naquadria, 24),
						GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Neutronium, 32L),
						GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Infinite, 4),
						GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Californium, 48),
						ItemList.Circuit_Parts_MECrystal_Chip_Elite.get(36L),
						ItemList.Field_Generator_ZPM.get(1),
						ItemList.Circuit_Chip_QPIC.get(16),
						ItemList.Circuit_Parts_DiodeASMD.get(48),
						ItemList.Circuit_Parts_CapacitorASMD.get(48),
						ItemList.Circuit_Parts_ResistorASMD.get(48),
						ItemList.Circuit_Parts_TransistorASMD.get(48),
						GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.Europium, 16),
						GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.CosmicNeutronium, 16L)
				},
				ItemList.MysteriousCrystalOrb.get(1), null, 1200, 1000000
		);
		
		// --- UEV Orb
		RA.addBasicLineRecipe(new ItemStack[]{
						CoreItems2.getRecipe(191, 1),
						GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Plutonium241, 32),
						GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Phoenixite, 32L),
						GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Bio, 4),
						GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Californium, 64),
						ItemList.MysteriousCrystalOrb.get(4),
						ItemList.Field_Generator_ZPM.get(1),
						ItemList.Circuit_Chip_FPIC.get(16),
						ItemList.Circuit_Parts_DiodeASMD.get(64),
						ItemList.Circuit_Parts_CapacitorASMD.get(64),
						ItemList.Circuit_Parts_ResistorASMD.get(64),
						ItemList.Circuit_Parts_TransistorASMD.get(64),
						GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.SuperconductorUEV, 16),
						GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.BlackPlutonium, 16L)
				},
				ItemList.MysteriousCrystalModule.get(1), null, 1600, 4000000
		);
		
		RA.addBasicLineRecipe(new ItemStack[]{
						CoreItems2.getRecipe(191, 1),
						GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.NaquadahEnriched, 32),
						GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Phoenixite, 32L),
						GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Bio, 4),
						GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Californium, 64),
						ItemList.MysteriousCrystalOrb.get(2),
						ItemList.Field_Generator_UV.get(1),
						ItemList.Circuit_Chip_FPIC.get(16),
						ItemList.Circuit_Parts_DiodeASMD.get(64),
						ItemList.Circuit_Parts_CapacitorASMD.get(64),
						ItemList.Circuit_Parts_ResistorASMD.get(64),
						ItemList.Circuit_Parts_TransistorASMD.get(64),
						GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.SuperconductorUEV, 16),
						GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.CosmicNeutronium, 16L)
				},
				ItemList.MysteriousCrystalModule.get(1), null, 1600, 4000000
		);
		
		RA.addBasicLineRecipe(new ItemStack[]{
						CoreItems2.getRecipe(191, 1),
						GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Naquadria, 32),
						GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Phoenixite, 32L),
						GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Bio, 4),
						GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Californium, 64),
						ItemList.MysteriousCrystalOrb.get(1),
						ItemList.Field_Generator_UHV.get(1),
						ItemList.Circuit_Chip_FPIC.get(16),
						ItemList.Circuit_Parts_DiodeASMD.get(64),
						ItemList.Circuit_Parts_CapacitorASMD.get(64),
						ItemList.Circuit_Parts_ResistorASMD.get(64),
						ItemList.Circuit_Parts_TransistorASMD.get(64),
						GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.SuperconductorUEV, 16),
						GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.DraconiumAwakened, 16L)
				},
				ItemList.MysteriousCrystalModule.get(1), null, 1600, 4000000
		);

		// --- Solid-Oxide Generator T1
		RA.addPrimitiveLineRecipe(new ItemStack[]{
				ItemList.Hull_HV.get(1L), GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Data, 2),
				ItemList.Electric_Pump_HV.get(2L), GT_OreDictUnificator.get(OrePrefixes.pipeLarge, Materials.Titanium, 4),
				GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.HSLA, 4), GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.StainlessSteel, 6)
		}, GT_ItemList.SOFC_Low.get(1), null, 15 * 20, 480);

		// --- Solid-Oxide Generator T2
		RA.addPrimitiveLineRecipe(new ItemStack[]{
				ItemList.Hull_EV.get(1L), GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Elite, 2),
				ItemList.Electric_Pump_EV.get(2L), GT_OreDictUnificator.get(OrePrefixes.pipeLarge, Materials.TungstenSteel, 4),
				GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.Zamak, 4), GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Titanium, 6)
		}, GT_ItemList.SOFC_Medium.get(1), null, 20 * 20, 1920);

		// --- Solid-Oxide Generator T3
		RA.addPrimitiveLineRecipe(new ItemStack[]{
				ItemList.Hull_IV.get(1L), GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Master, 2),
				ItemList.Electric_Pump_IV.get(2L), GT_OreDictUnificator.get(OrePrefixes.pipeLarge, Materials.Ultimate, 4),
				GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.HSSS, 4), GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.TungstenSteel, 6)
		}, GT_ItemList.SOFC_Huge.get(1), null, 30 * 20, 7680);

        //MultiCrackerUnit
        RA.addBasicLineRecipe(new ItemStack[]{
                ItemList.Hull_LuV.get(1L),
                GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.MaragingSteel250, 4),
                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Master, 4),
                ItemList.Electric_Pump_LuV.get(4L),
                GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Talonite, 8),
                GT_OreDictUnificator.get(OrePrefixes.pipeHuge, Materials.Polytetrafluoroethylene, 4),
                GT_OreDictUnificator.get(OrePrefixes.spring, Materials.Tungsten, 8),
                GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.Grisium, 8),
                GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.HSSE, 16),
                GT_OreDictUnificator.get(OrePrefixes.screw, Materials.HSSE, 16)
        }, GT_ItemList.AdvCrackUnit.get(1L), null, 80 * 20, 30720);

		//Miner Enrichment Unit
		RA.addBasicLineRecipe(new ItemStack[]{
				ItemList.Machine_FlotationUnit.get(1L),
				ItemList.Electric_Pump_IV.get(6L),
				GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Elite, 8),
				GT_OreDictUnificator.get(OrePrefixes.pipeHuge, Materials.Inconel690, 8),
				ItemList.Casing_Coil_Nichrome.get(8),
				GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.HastelloyC276, 12),
				GT_OreDictUnificator.get(OrePrefixes.gearGt, Materials.Inconel792, 16),
				GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.MaragingSteel250, 16),
				GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.HSSG, 32),
				GT_OreDictUnificator.get(OrePrefixes.screw, Materials.HSSE, 32)
		}, GT_ItemList.Mining_Enrich_HV.get(1L), null, 40 * 20, 7680);
	}
	
	private void mixer() {
		//HastelloyC276
		RA.addMixerRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Nickel, 32L),
				GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Molybdenum, 8L),
				GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Chrome, 7L),
				GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Cobalt, 1L),
				GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Tungsten, 1L),
				GT_Utility.getIntegratedCircuit(6), GT_Values.NF, GT_Values.NF,
				GT_OreDictUnificator.get(OrePrefixes.dust, Materials.HastelloyC276, 49L), 150 * 20, 1920
		);
		//Potin
		RA.addMixerRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Copper, 6L),
				GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Tin, 2L),
				GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Lead, 1L), GT_Values.NI, GT_Values.NI,
				GT_Utility.getIntegratedCircuit(3), GT_Values.NF, GT_Values.NF,
				GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Potin, 9L), 20 * 20, 8
		);
		//EglinSteel
		RA.addMixerRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Iron, 5L),
				GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Invar, 5L),
				GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Silicon, 4L),
				GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Sulfur, 1L),
				GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Carbon, 1L),
				GT_Utility.getIntegratedCircuit(3), GT_Values.NF, GT_Values.NF,
				GT_OreDictUnificator.get(OrePrefixes.dust, Materials.EglinSteel, 16L), 30 * 20, 16
		);
		
		RA.addMixerRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Neutronium, 1L),
				GT_Utility.getIntegratedCircuit(1), GT_Values.NI, GT_Values.NI,
				Materials.Helium.getPlasma(125), GT_Values.NF, CoreItems.getRecipe(34, 1), 200,
				122880
		);
		
		RA.addMixerRecipe(CoreItems.getRecipe(28, 64), Materials.DeepIron.getDust(64),
				Materials.EuropiumoxideMagnetic.getDust(21), Materials.ChromiumTrioxide.getDust(64),
				GT_OreDictUnificator.get(OrePrefixes.gemExquisite, Materials.GarnetRed, 54L),
				GT_OreDictUnificator.get(OrePrefixes.gemExquisite, Materials.Opal, 47L), GT_Values.NF,
				GT_Values.NF, CoreItems.getRecipe(36, 1), 3600, 262144
		);
		RA.addMixerRecipe(CoreItems.getRecipe(35, 64), Materials.DeepIron.getDust(64),
				Materials.EuropiumoxideMagnetic.getDust(21), Materials.ChromiumTrioxide.getDust(64),
				GT_OreDictUnificator.get(OrePrefixes.gemExquisite, Materials.GarnetRed, 54L),
				GT_OreDictUnificator.get(OrePrefixes.gemExquisite, Materials.Opal, 47L), GT_Values.NF,
				GT_Values.NF, CoreItems.getRecipe(36, 1), 3600, 262144
		);
		
		RA.addMixerRecipe(CoreItems.getRecipe(28, 16), Materials.MysteriousCrystal.getDust(8),
				Materials.Oriharukon.getDust(8), Materials.BlackPlutonium.getDust(1),
				GT_Utility.getIntegratedCircuit(1), GT_Values.NI, Materials.Mutagen.getFluid(8000),
				Materials.BioMediumRaw.getFluid(4000), Materials.Diamond.getDust(1), 200, 122880
		);
		RA.addMixerRecipe(CoreItems.getRecipe(35, 16), Materials.MysteriousCrystal.getDust(8),
				Materials.Oriharukon.getDust(8), Materials.BlackPlutonium.getDust(1),
				GT_Utility.getIntegratedCircuit(1), GT_Values.NI, Materials.Mutagen.getFluid(8000),
				Materials.BioMediumRaw.getFluid(16000), Materials.Diamond.getDust(2), 200, 122880
		);
		RA.addMixerRecipe(CoreItems.getRecipe(28, 64), Materials.MysteriousCrystal.getDust(32),
				Materials.Oriharukon.getDust(32), Materials.InfinityCatalyst.getDust(1),
				GT_Utility.getIntegratedCircuit(2), GT_Values.NI, Materials.Mutagen.getFluid(32000),
				Materials.BioMediumRaw.getFluid(32000), Materials.Diamond.getDust(2), 400, 122880
		);
		RA.addMixerRecipe(CoreItems.getRecipe(35, 64), Materials.MysteriousCrystal.getDust(32),
				Materials.Oriharukon.getDust(32), Materials.InfinityCatalyst.getDust(1),
				GT_Utility.getIntegratedCircuit(2), GT_Values.NI, Materials.Mutagen.getFluid(32000),
				Materials.BioMediumRaw.getFluid(64000), Materials.Diamond.getDust(2), 400, 122880
		);
		
		RA.addMixerRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Stone, 2L),
				GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Gypsum, 1L),
				GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Calcite, 1L),
				GT_Utility.getIntegratedCircuit(1), GT_Values.NF, GT_Values.NF, CoreItems.getRecipe(37, 4),
				200, 8
		);
		RA.addMixerRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Stone, 2L),
				GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Gypsum, 1L),
				GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Marble, 1L),
				GT_Utility.getIntegratedCircuit(1), GT_Values.NF, GT_Values.NF, CoreItems.getRecipe(37, 4),
				200, 8
		);
		
		RA.addMixerRecipe(GregTech_API.getStackofAmountFromOreDict("dustZirconium", 1),
				Itemstack(Core_Items.getInstance(), 1, 40), null, null, null,
				GT_Utility.getIntegratedCircuit(2), null, null, Itemstack(Core_Items.getInstance(), 2, 42),
				400, 96
		);
		RA.addMixerRecipe(GregTech_API.getStackofAmountFromOreDict("dustCerium", 9),
				GregTech_API.getStackofAmountFromOreDict("dustGadolinium", 1), null, null, null,
				GT_Utility.getIntegratedCircuit(2), null, null, Itemstack(Core_Items.getInstance(), 10, 43),
				400, 96
		);
		RA.addMixerRecipe(GregTech_API.getStackofAmountFromOreDict("dustLanthanum", 15),
				GregTech_API.getStackofAmountFromOreDict("dustStrontium", 13),
				GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Iron, 8),
				GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Cobalt, 2), null,
				GT_Utility.getIntegratedCircuit(2), null, null, Itemstack(Core_Items.getInstance(), 38, 44),
				400, 96
		);
		// --- Mud Ball
		RA.addMixerRecipe(new ItemStack(Blocks.dirt), GT_Utility.getIntegratedCircuit(4), null,
				null, null, null, Materials.Water.getFluid(1000L), null,
				CoreItems2.getRecipe(202, 4), 50, 7
		);
	}
	
	private void lathe() {
		RA.addLatheRecipe(new ItemStack(Blocks.cobblestone), CoreItems2.getRecipe(177, 2), null, 100,
				16
		);
		RA.addLatheRecipe(new ItemStack(Blocks.sandstone), CoreItems2.getRecipe(178, 2), null, 100,
				16
		);
		// --- Flawed Fluix Crystal
		RA.addLatheRecipe(GT_ModHandler.getModItem(AE2, "tile.BlockFluix", 1L),
				CoreItems2.getRecipe(195, 1), GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 3L, 8), 2400,
				30
		);
		// --- Stone Rod
		RA.addLatheRecipe(new ItemStack(Blocks.stone),
				GT_ModHandler.getModItem("ForgeMicroblock", "stoneRod", 2L), null, 100, 16);
	}
	
	private void implosionCompressor() {
		RA.addImplosionRecipe(CoreItems2.getRecipe(97, 1), 5,
				GT_ModHandler.getModItem("GalaxySpace", "item.CompressedPlates", 1L, 4),
				GT_OreDictUnificator.get(OrePrefixes.dust, Materials.StainlessSteel, 1L), new int[]{10000, 1000}
		);
		RA.addImplosionRecipe(GT_OreDictUnificator.get(OrePrefixes.block, Materials.Coal, 1L), 1,
				GT_ModHandler.getModItem("GalaxySpace", "item.CompressedCoal", 1L, 0),
				GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Ash, 1L), new int[]{10000, 1000}
		);
		RA.addImplosionRecipe(
				GT_OreDictUnificator.get(OrePrefixes.compressed, Materials.Aluminium, 2L), 1,
				CoreItems2.getRecipe(176, 1),
				GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Ash, 1L), new int[]{10000, 1000}
		);
		RA.addImplosionRecipe(GT_OreDictUnificator.get(OrePrefixes.compressed, Materials.Bronze, 2L),
				1, CoreItems2.getRecipe(175, 1),
				GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Ash, 1L), new int[]{10000, 1000}
		);
		
		RA.addImplosionRecipe(CoreItems2.getRecipe(74, 3), 1, CoreItems2.getRecipe(78, 1),
				GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Ash, 1L), new int[]{10000, 1000}
		);
		RA.addImplosionRecipe(CoreItems2.getRecipe(75, 3), 1, CoreItems2.getRecipe(82, 1),
				GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Ash, 1L), new int[]{10000, 1000}
		);
		RA.addImplosionRecipe(CoreItems2.getRecipe(76, 3), 1, CoreItems2.getRecipe(83, 1),
				GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Ash, 1L), new int[]{10000, 1000}
		);
		RA.addImplosionRecipe(GT_ModHandler.getModItem("IC2", "itemPartIridium", 3L), 2,
				CoreItems2.getRecipe(81, 1),
				GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Ash, 1L), new int[]{10000, 1000}
		);
		RA.addImplosionRecipe(GT_ModHandler.getModItem("GalacticraftMars", "item.null", 2L, 5), 1,
				CoreItems2.getRecipe(90, 1),
				GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Ash, 1L), new int[]{10000, 1000}
		);
		RA.addImplosionRecipe(CoreItems2.getRecipe(80, 2), 1, CoreItems2.getRecipe(91, 1),
				GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Ash, 1L), new int[]{10000, 1000}
		);
		RA.addImplosionRecipe(CoreItems2.getRecipe(81, 2), 2, CoreItems2.getRecipe(92, 1),
				GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Ash, 1L), new int[]{10000, 1000}
		);
		RA.addImplosionRecipe(
				GT_OreDictUnificator.get(OrePrefixes.compressed, Materials.MeteoricIron, 2L), 1,
				CoreItems2.getRecipe(93, 1),
				GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Ash, 1L), new int[]{10000, 1000}
		);
		RA.addImplosionRecipe(CoreItems2.getRecipe(83, 2), 1, CoreItems2.getRecipe(94, 1),
				GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Ash, 1L), new int[]{10000, 1000}
		);
		RA.addImplosionRecipe(CoreItems2.getRecipe(85, 2), 1, CoreItems2.getRecipe(95, 1),
				GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Ash, 1L), new int[]{10000, 1000}
		);
		RA.addImplosionRecipe(
				GT_OreDictUnificator.get(OrePrefixes.compressed, Materials.Titanium, 2L), 1,
				CoreItems2.getRecipe(96, 1),
				GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Ash, 1L), new int[]{10000, 1000}
		);
		RA.addImplosionRecipe(ItemList.Ingot_Heavy1.get(1L), 8,
				GT_ModHandler.getModItem("GalacticraftCore", "item.heavyPlating", 1L),
				GT_OreDictUnificator.get(OrePrefixes.dust, Materials.StainlessSteel, 1L), new int[]{10000, 5000}
		);
		RA.addImplosionRecipe(ItemList.Ingot_Heavy2.get(1L), 8,
				GT_ModHandler.getModItem("GalacticraftMars", "item.null", 1L, 3),
				GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Titanium, 1L), new int[]{10000, 5000}
		);
		RA.addImplosionRecipe(ItemList.Ingot_Heavy3.get(1L), 8,
				GT_ModHandler.getModItem("GalacticraftMars", "item.itemBasicAsteroids", 1L),
				GT_OreDictUnificator.get(OrePrefixes.dust, Materials.TungstenSteel, 1L), new int[]{10000, 5000}
		);
		RA.addImplosionRecipe(CoreItems2.getRecipe(16, 1), 8, CoreItems2.getRecipe(11, 1),
				GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Chrome, 1L), new int[]{10000, 5000}
		);
		RA.addImplosionRecipe(CoreItems2.getRecipe(17, 1), 8, CoreItems2.getRecipe(12, 1),
				GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Iridium, 1L), new int[]{10000, 5000}
		);
		RA.addImplosionRecipe(CoreItems2.getRecipe(18, 1), 8, CoreItems2.getRecipe(13, 1),
				GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Osmium, 1L), new int[]{10000, 5000}
		);
		RA.addImplosionRecipe(CoreItems2.getRecipe(19, 1), 8, CoreItems2.getRecipe(14, 1),
				GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Neutronium, 1L), new int[]{10000, 5000}
		);
		RA.addImplosionRecipe(CoreItems2.getRecipe(20, 1), 8, CoreItems2.getRecipe(15, 1),
				GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Phoenixite, 1L), new int[]{10000, 5000}
		);
		RA.addImplosionRecipe(GT_OreDictUnificator.get(OrePrefixes.plateTriple, Materials.Lead, 1L),
				1, CoreItems2.getRecipe(171, 1),
				GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Ash, 1L), new int[]{10000, 1000}
		);
		RA.addImplosionRecipe(GT_OreDictUnificator.get(OrePrefixes.plateTriple, Materials.Nickel, 1L),
				1, GT_ModHandler.getModItem("GalaxySpace", "item.CompressedPlates", 1L, 2),
				GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Ash, 1L), new int[]{10000, 1000}
		);
		RA.addImplosionRecipe(
				GT_OreDictUnificator.get(OrePrefixes.plateTriple, Materials.Oriharukon, 1L), 1,
				CoreItems2.getRecipe(173, 1),
				GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Ash, 1L), new int[]{10000, 1000}
		);
		RA.addImplosionRecipe(
				GT_OreDictUnificator.get(OrePrefixes.plateTriple, Materials.Platinum, 1L), 1,
				CoreItems2.getRecipe(172, 1),
				GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Ash, 1L), new int[]{10000, 1000}
		);
		RA.addImplosionRecipe(
				GT_OreDictUnificator.get(OrePrefixes.plateTriple, Materials.Adamantium, 1L), 1,
				CoreItems2.getRecipe(174, 1),
				GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Ash, 1L), new int[]{10000, 1000}
		);
		RA.addImplosionRecipe(GT_OreDictUnificator.get(OrePrefixes.plateTriple, Materials.Cobalt, 1L),
				1, GT_ModHandler.getModItem("GalaxySpace", "item.CompressedPlates", 1L, 0),
				GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Ash, 1L), new int[]{10000, 1000}
		);
		
		RA.addImplosionRecipe(ItemList.Ingot_IridiumAlloy.get(1L), 8,
				GT_OreDictUnificator.get(OrePrefixes.plateAlloy, Materials.Iridium, 1L),
				GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Titanium, 1L), new int[]{10000, 1500}
		);
		// --- Flawless Fluix Crystal
		RA.addImplosionRecipe(CoreItems2.getRecipe(195, 3), 8,
				CoreItems2.getRecipe(196, 1),
				GT_OreDictUnificator.get(OrePrefixes.dust, Materials.DarkAshes, 1L), new int[]{10000, 1500}
		);
		// --- Matrix Transducer
		RA.addImplosionRecipe(CoreItems2.getRecipe(196, 9), 8,
				GT_ModHandler.getModItem("impact", "impact_matrix_transducer", 1L, 0),
				GT_OreDictUnificator.get(OrePrefixes.dust, Materials.DarkAshes, 1L), new int[]{10000, 1500}
		);
	}
	
	private void formingPress() {
//Spatial Chip
		RA.addFormingPressRecipe(
				GT_OreDictUnificator.get(ItemList.Circuit_Parts_Crystal_Chip_Master.get(1L)),
				GT_ItemList.RedstonePulsatingChipset.get(1L), GT_ItemList.PulsatingSpatialCoreChip.get(1L),
				300, 7680
		);
		//Fluid Chips
		RA.addFormingPressRecipe(
				GT_OreDictUnificator.get(ItemList.Circuit_Parts_Crystal_Chip_Master.get(1L)),
				GT_ItemList.RedstoneGoldChipset.get(1L), GT_ItemList.GoldFluidCoreChip.get(1L), 300, 1024
		);
		RA.addFormingPressRecipe(
				GT_OreDictUnificator.get(ItemList.Circuit_Parts_Crystal_Chip_Master.get(1L)),
				GT_ItemList.RedstoneDiamondChipset.get(1L), GT_ItemList.DiamondFluidCoreChip.get(1L), 300,
				1920
		);
		RA.addFormingPressRecipe(
				GT_OreDictUnificator.get(ItemList.Circuit_Parts_Crystal_Chip_Master.get(1L)),
				GT_ItemList.RedstoneEmeraldChipset.get(1L),
				GT_ItemList.EmeraldAdvancedFluidCoreChip.get(1L), 300, 4096
		);
		//Item Chips
		RA
				.addFormingPressRecipe(GT_OreDictUnificator.get(GT_ItemList.EngravedGoldChip.get(1L)),
						GT_ItemList.RedstoneGoldChipset.get(1L), GT_ItemList.GoldCoreChip.get(1L), 300, 480
				);
		RA.addFormingPressRecipe(
				GT_OreDictUnificator.get(GT_ItemList.EngravedDiamondCrystalChip.get(1L)),
				GT_ItemList.RedstoneDiamondChipset.get(1L), GT_ItemList.DiamondCoreChip.get(1L), 300, 1920
		);
		RA
				.addFormingPressRecipe(GT_OreDictUnificator.get(GT_ItemList.EngravedEnergyChip.get(1L)),
						GT_ItemList.RedstoneEmeraldChipset.get(1L), GT_ItemList.EmeraldAdvancedCoreChip.get(1L),
						300, 4096
				);
		RA
				.addFormingPressRecipe(GT_OreDictUnificator.get(GT_ItemList.EngravedQuantumChip.get(1L)),
						GT_ItemList.RedstoneEmeraldChipset.get(1L),
						GT_ItemList.EmeraldHighAdvancedCoreChip.get(1L), 300, 7680
				);
		//Gendustry Chips
		RA.addFormingPressRecipe(
				GT_OreDictUnificator.get(ItemList.Circuit_Parts_Crystal_Chip_Elite.get(1L)),
				GT_ItemList.RedstonePulsatingChipset.get(1L), GT_ItemList.GeneticCircuit.get(1L), 300,
				7680
		);
		RA.addFormingPressRecipe(
				GT_OreDictUnificator.get(ItemList.Circuit_Parts_Crystal_Chip_Elite.get(1L)),
				GT_ItemList.RedstoneDiamondChipset.get(1L), GT_ItemList.EnvironmentalCircuit.get(1L), 300,
				7680
		);
		//Redstone Chips
		RA.addFormingPressRecipe(
				GT_OreDictUnificator.get(OrePrefixes.plate, Materials.EnderPearl, 1L),
				GT_ItemList.RedstoneRedChipset.get(1L), GT_ItemList.RedstonePulsatingChipset.get(2L), 200,
				120
		);
		RA.addFormingPressRecipe(
				GT_OreDictUnificator.get(OrePrefixes.plate, Materials.NetherQuartz, 1L),
				GT_ItemList.RedstoneRedChipset.get(1L), GT_ItemList.RedstoneQuartzChipset.get(1L), 300,
				120
		);
		RA
				.addFormingPressRecipe(GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Iron, 1L),
						GT_ItemList.RedstoneRedChipset.get(1L), GT_ItemList.RedstoneIronChipset.get(1L), 100,
						120
				);
		RA
				.addFormingPressRecipe(GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Gold, 1L),
						GT_ItemList.RedstoneRedChipset.get(1L), GT_ItemList.RedstoneGoldChipset.get(1L), 200,
						120
				);
		RA
				.addFormingPressRecipe(GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Diamond, 1L),
						GT_ItemList.RedstoneRedChipset.get(1L), GT_ItemList.RedstoneDiamondChipset.get(1L), 100,
						480
				);
		RA
				.addFormingPressRecipe(GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Emerald, 1L),
						GT_ItemList.RedstoneRedChipset.get(1L), GT_ItemList.RedstoneEmeraldChipset.get(1L), 150,
						480
				);
		
		RA
				.addFormingPressRecipe(CoreItems.getRecipe(2, 4), ItemList.Shape_Extruder_Ingot.get(0L),
						CoreItems2.getRecipe(70, 1), 200, 120
				);
		RA.addFormingPressRecipe(
				GT_OreDictUnificator.get(OrePrefixes.dust, Materials.MysteriousCrystal, 4L),
				ItemList.Shape_Extruder_Ingot.get(0L), CoreItems2.getRecipe(73, 1), 300, 480
		);
		
		RA
				.addFormingPressRecipe(GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Aluminium, 2L),
						GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Iron, 4L),
						CoreItems2.getRecipe(101, 1), 600, 120
				);
		RA
				.addFormingPressRecipe(GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Titanium, 2L),
						GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Iron, 4L),
						CoreItems2.getRecipe(102, 1), 600, 480
				);
		RA
				.addFormingPressRecipe(GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Tungsten, 2L),
						GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Iron, 4L),
						CoreItems2.getRecipe(103, 1), 600, 1920
				);
		RA.addFormingPressRecipe(
				GT_OreDictUnificator.get(OrePrefixes.plate, Materials.TungstenSteel, 2L),
				GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Iron, 4L),
				CoreItems2.getRecipe(104, 1), 600, 7680
		);
		RA
				.addFormingPressRecipe(GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Chrome, 2L),
						GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Iron, 4L),
						CoreItems2.getRecipe(105, 1), 600, 30720
				);
		RA
				.addFormingPressRecipe(GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Iridium, 2L),
						GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Iron, 4L),
						CoreItems2.getRecipe(106, 1), 600, 122880
				);
		RA
				.addFormingPressRecipe(GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Naquadria, 2L),
						GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Iron, 4L),
						CoreItems2.getRecipe(107, 1), 600, 500000
				);
		RA.addFormingPressRecipe(
				GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Neutronium, 2L),
				GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Iron, 4L),
				CoreItems2.getRecipe(108, 1), 600, 2000000
		);
		
		// --- Leather
		RA
				.addFormingPressRecipe(GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Rubber, 4L),
						ItemList.Shape_Mold_Plate.get(0), new ItemStack(Items.leather, 1), 800, 16
				);
		RA.addFormingPressRecipe(
				GT_OreDictUnificator.get(OrePrefixes.foil, Materials.StyreneButadieneRubber, 4L),
				ItemList.Shape_Mold_Plate.get(0), new ItemStack(Items.leather, 1), 800, 16
		);
		RA
				.addFormingPressRecipe(GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Silicone, 4L),
						ItemList.Shape_Mold_Plate.get(0), new ItemStack(Items.leather, 1), 800, 16
				);
		
		// --- Graphene Foil
		RA
				.addFormingPressRecipe(new ItemStack[]{
						GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Plastic, 1L),
						GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Graphite, 1L),
						GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Copper, 1L)
				}, CoreItems2.getRecipe(192, 1), 200, 480);
		RA
				.addFormingPressRecipe(new ItemStack[]{
						GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Polytetrafluoroethylene, 1L),
						GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Graphite, 4L),
						GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Copper, 4L)
				}, CoreItems2.getRecipe(192, 4), 400, 480);
		RA
				.addFormingPressRecipe(new ItemStack[]{
						GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Polybenzimidazole, 1L),
						GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Graphite, 16L),
						GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Copper, 16L)
				}, CoreItems2.getRecipe(192, 16), 800, 480);
		
	}
	
	private void fluidExtractor() {
		RA.addFluidExtractionRecipe(CoreItems.getRecipe(33, 1), null, Materials.Glass.getMolten(144),
				10000, 50, 30
		);

		// --- Tar from Petrocoke
		RA.addFluidExtractionRecipe(CoreItems2.getRecipe(201, 1),
				GT_OreDictUnificator.get(OrePrefixes.dust, Materials.DarkAshes, 1L),
				Materials.Tar.getFluid(100L), 2000, 30, 16);
	}
	
	private void woodFarm() {
		//Oak
		RA.addFarmRecipe(CoreItems2.getRecipe(OakScheme.getMetaID(), 0),
				GT_ModHandler.getModItem("IC2", "itemFertilizer", 1L), null,
				Materials.Water.getFluid(1000L), GT_Values.NF,
				new ItemStack[]{GT_ModHandler.getModItem("minecraft", "log", 40L, 0),
						GT_ModHandler.getModItem("minecraft", "log", 10L, 0),
						GT_ModHandler.getModItem("minecraft", "sapling", 8L, 0),
						GT_ModHandler.getModItem("minecraft", "sapling", 4L, 0),
						GT_ModHandler.getModItem("minecraft", "apple", 3L, 0),
						GT_ModHandler.getModItem("minecraft", "leaves", 40L, 0)},
				new int[]{10000, 7000, 10000, 7500, 10000, 10000}, 300, 120
		);
		//Spruce
		RA.addFarmRecipe(CoreItems2.getRecipe(SpruceScheme.getMetaID(), 0),
				GT_ModHandler.getModItem("IC2", "itemFertilizer", 1L), null,
				Materials.Water.getFluid(1000L), GT_Values.NF,
				new ItemStack[]{GT_ModHandler.getModItem("minecraft", "log", 60L, 1),
						GT_ModHandler.getModItem("minecraft", "log", 20L, 1),
						GT_ModHandler.getModItem("minecraft", "sapling", 10L, 1),
						GT_ModHandler.getModItem("minecraft", "sapling", 4L, 1),
						GT_ModHandler.getModItem("minecraft", "brown_mushroom", 1L, 0),
						GT_ModHandler.getModItem("minecraft", "leaves", 50L, 1)},
				new int[]{10000, 8000, 10000, 3000, 750, 10000}, 480, 120
		);
		//Birch
		RA.addFarmRecipe(CoreItems2.getRecipe(BirchScheme.getMetaID(), 0),
				GT_ModHandler.getModItem("IC2", "itemFertilizer", 1L), null,
				Materials.Water.getFluid(1000L), GT_Values.NF,
				new ItemStack[]{GT_ModHandler.getModItem("minecraft", "log", 30L, 2),
						GT_ModHandler.getModItem("minecraft", "log", 8L, 2),
						GT_ModHandler.getModItem("minecraft", "sapling", 6L, 2),
						GT_ModHandler.getModItem("minecraft", "sapling", 4L, 2),
						GT_ModHandler.getModItem("minecraft", "sugar", 2L, 0),
						GT_ModHandler.getModItem("minecraft", "leaves", 48L, 2)},
				new int[]{10000, 7000, 10000, 6000, 500, 10000}, 240, 120
		);
		//Jungle
		RA.addFarmRecipe(CoreItems2.getRecipe(JungleScheme.getMetaID(), 0),
				GT_ModHandler.getModItem("IC2", "itemFertilizer", 1L), null,
				Materials.Water.getFluid(1000L), GT_Values.NF,
				new ItemStack[]{GT_ModHandler.getModItem("minecraft", "log", 50L, 3),
						GT_ModHandler.getModItem("minecraft", "log", 10L, 3),
						GT_ModHandler.getModItem("minecraft", "sapling", 10L, 3),
						GT_ModHandler.getModItem("minecraft", "dye", 6L, 3),
						GT_ModHandler.getModItem("minecraft", "vine", 10L, 0),
						GT_ModHandler.getModItem("minecraft", "leaves", 30L, 3)},
				new int[]{10000, 6000, 10000, 2000, 10000, 10000}, 360, 120
		);
		//Acacia
		RA.addFarmRecipe(CoreItems2.getRecipe(AcaciaScheme.getMetaID(), 0),
				GT_ModHandler.getModItem("IC2", "itemFertilizer", 1L), null,
				Materials.Water.getFluid(1000L), GT_Values.NF,
				new ItemStack[]{GT_ModHandler.getModItem("minecraft", "log2", 30L, 0),
						GT_ModHandler.getModItem("minecraft", "log2", 10L, 0),
						GT_ModHandler.getModItem("minecraft", "sapling", 6L, 4),
						GT_ModHandler.getModItem("minecraft", "sapling", 4L, 4),
						GT_ModHandler.getModItem("minecraft", "deadbush", 2L, 0),
						GT_ModHandler.getModItem("minecraft", "leaves2", 40L, 0)},
				new int[]{10000, 6000, 10000, 4000, 4000, 10000}, 420, 120
		);
		//DarkOak
		RA.addFarmRecipe(CoreItems2.getRecipe(DarkOakScheme.getMetaID(), 0),
				GT_ModHandler.getModItem("IC2", "itemFertilizer", 1L), null,
				Materials.Water.getFluid(1000L), GT_Values.NF,
				new ItemStack[]{GT_ModHandler.getModItem("minecraft", "log2", 40L, 1),
						GT_ModHandler.getModItem("minecraft", "log2", 12L, 1),
						GT_ModHandler.getModItem("minecraft", "sapling", 8L, 5),
						GT_ModHandler.getModItem("minecraft", "sapling", 4L, 5),
						GT_ModHandler.getModItem("minecraft", "apple", 3L, 0),
						GT_ModHandler.getModItem("minecraft", "leaves2", 50L, 1)},
				new int[]{10000, 7000, 10000, 6000, 10000, 10000}, 360, 120
		);
		//Rubber
		RA.addFarmRecipe(CoreItems2.getRecipe(RubberScheme.getMetaID(), 0),
				GT_ModHandler.getModItem("IC2", "itemFertilizer", 1L), null,
				Materials.Water.getFluid(1000L), GT_Values.NF,
				new ItemStack[]{GT_ModHandler.getModItem("IC2", "blockRubWood", 20L, 0),
						GT_ModHandler.getModItem("IC2", "blockRubWood", 5L, 0),
						GT_ModHandler.getModItem("IC2", "blockRubSapling", 6L, 0),
						GT_ModHandler.getModItem("IC2", "blockRubSapling", 4L, 0),
						GT_ModHandler.getModItem("IC2", "itemHarz", 3L, 0),
						GT_ModHandler.getModItem("IC2", "blockRubLeaves", 40L, 0)},
				new int[]{10000, 5000, 10000, 5000, 10000, 10000}, 510, 120
		);
		//Barnarda
		RA.addFarmRecipe(CoreItems2.getRecipe(BarnardaCScheme.getMetaID(), 0),
				GT_ModHandler.getModItem("IC2", "itemFertilizer", 1L), null,
				Materials.Water.getFluid(1000L), GT_Values.NF,
				new ItemStack[]{GT_ModHandler.getModItem("GalaxySpace", "barnardaclog", 50L),
						GT_ModHandler.getModItem("GalaxySpace", "barnardaclog", 5L),
						GT_ModHandler.getModItem("minecraft", "sapling", 5L, 3),
						GT_ModHandler.getModItem("GalaxySpace", "barnardacdandelions", 5L, 1),
						GT_ModHandler.getModItem("GalaxySpace", "barnardacleaves", 30L)},
				new int[]{10000, 4000, 10000, 10000, 10000}, 400, 120
		);
	}
	
	private void extruder() {
		RA.addExtruderRecipe(CoreItems2.getRecipe(69, 1), ItemList.Shape_Extruder_Plate.get(0L),
				CoreItems2.getRecipe(74, 1), 200, 120
		);
		RA.addExtruderRecipe(CoreItems2.getRecipe(71, 1), ItemList.Shape_Extruder_Plate.get(0L),
				CoreItems2.getRecipe(75, 1), 200, 120
		);
		RA.addExtruderRecipe(CoreItems2.getRecipe(72, 1), ItemList.Shape_Extruder_Plate.get(0L),
				CoreItems2.getRecipe(76, 1), 300, 480
		);
	}
	
	private void extractor() {
		RA.addExtractorRecipe(CoreItems2.getRecipe(151, 64), CoreItems.getRecipe(35, 1), 400, 262144);
		RA.addExtractorRecipe(ItemList.Casing_CokeOvenBrick.get(1L), CoreItems2.getRecipe(65, 4), 300, 2);
		RA.addExtractorRecipe(CoreItems2.getRecipe(202, 1), new ItemStack(Items.clay_ball), 200, 2);
	}
	
	private void ebf() {
		RA.addBlastRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.HastelloyC276, 1L),
				GT_Utility.getIntegratedCircuit(1), GT_Values.NF, GT_Values.NF,
				GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.HastelloyC276, 1L), null,
				60 * 20, 1920, 3601
		);
		RA.addBlastRecipe(Itemstack(Core_Items.getInstance(), 16, 42),
				GT_Utility.getIntegratedCircuit(1), null, null, Itemstack(Core_Items.getInstance(), 1, 45),
				null, 20 * 300, 480, 3200
		);
		RA.addBlastRecipe(Itemstack(Core_Items.getInstance(), 16, 43),
				GT_Utility.getIntegratedCircuit(1), null, null, Itemstack(Core_Items.getInstance(), 1, 46),
				null, 20 * 300, 1920, 4200
		);
		RA.addBlastRecipe(Itemstack(Core_Items.getInstance(), 16, 44),
				GT_Utility.getIntegratedCircuit(1), null, null, Itemstack(Core_Items.getInstance(), 1, 47),
				null, 20 * 300, 7680, 4200
		);
	}
	
	private void centrifuge() {
		RA.addCentrifugeRecipe(GregTech_API.getStackofAmountFromOreDict("dustPhobos", 1),
				GT_Values.NI, GT_Values.NF, GT_Values.NF,
				GT_OreDictUnificator.get(OrePrefixes.dust, Materials.BandedIron, 1L),
				GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Bauxite, 1L),
				GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Molybdenite, 1L),
				GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Desh, 1L),
				GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Uranium, 1L),
				GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Plutonium, 1L),
				new int[]{1200, 600, 300, 80, 50, 20}, 600, 60
		);
		RA.addCentrifugeRecipe(GregTech_API.getStackofAmountFromOreDict("dustDeimos", 1),
				GT_Values.NI, GT_Values.NF, Materials.SulfuricAcid.getFluid(50L),
				GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Magnesite, 1L),
				GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Lapis, 1L),
				GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Pitchblende, 1L),
				GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Cooperite, 1L),
				GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Neodymium, 1L),
				GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Tungstate, 1L),
				new int[]{1200, 600, 300, 80, 50, 20}, 600, 60
		);
		RA.addCentrifugeRecipe(GregTech_API.getStackofAmountFromOreDict("dustCeres", 1), GT_Values.NI,
				GT_Values.NF, GT_Values.NF,
				GT_OreDictUnificator.get(OrePrefixes.dust, Materials.MeteoricIron, 1L),
				GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Beryllium, 1L),
				GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Platinum, 1L),
				GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Titanium, 1L),
				GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Tungsten, 1L),
				GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Naquadah, 1L),
				new int[]{1200, 600, 300, 80, 50, 20}, 800, 120
		);
		RA.addCentrifugeRecipe(GregTech_API.getStackofAmountFromOreDict("dustIceEuropa", 1),
				GT_Values.NI, GT_Values.NF, Materials.Oxygen.getGas(50L),
				GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Ledox, 1L),
				GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Lapis, 1L),
				GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Lazurite, 1L),
				GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Mithril, 1L),
				GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Barium, 1L),
				GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Naquadah, 1L),
				new int[]{1200, 600, 300, 80, 50, 20}, 800, 120
		);
		RA.addCentrifugeRecipe(GregTech_API.getStackofAmountFromOreDict("dustEuropa", 1),
				GT_Values.NI, GT_Values.NF, Materials.Nitrogen.getGas(100L),
				GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SiliconDioxide, 1L),
				GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Iron, 1L),
				GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Ledox, 1L),
				GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Sodalite, 1L),
				GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Barium, 1L),
				GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Uranium, 1L),
				new int[]{1200, 600, 300, 80, 50, 20}, 800, 120
		);
		RA.addCentrifugeRecipe(GregTech_API.getStackofAmountFromOreDict("dustGanymed", 1),
				GT_Values.NI, GT_Values.NF, GT_Values.NF,
				GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Titanium, 1L),
				GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Chromite, 1L),
				GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Galena, 1L),
				GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Diamond, 1L),
				GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Uranium, 1L),
				GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Palladium, 1L),
				new int[]{1200, 600, 300, 80, 50, 20}, 800, 120
		);
		RA.addCentrifugeRecipe(GregTech_API.getStackofAmountFromOreDict("dustCallisto", 1),
				GT_Values.NI, GT_Values.NF, GT_Values.NF,
				GregTech_API.getStackofAmountFromOreDict("dustIceCallisto", 1),
				GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Galena, 1L),
				GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Topaz, 1L),
				GT_OreDictUnificator.get(OrePrefixes.dust, Materials.BlueTopaz, 1L),
				GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Lithium, 1L),
				GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Tungsten, 1L),
				new int[]{1500, 600, 300, 80, 50, 20}, 800, 120
		);
		RA.addCentrifugeRecipe(GregTech_API.getStackofAmountFromOreDict("dustIo", 1), GT_Values.NI,
				GT_Values.NF, Materials.SulfuricGas.getGas(100L),
				GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Sulfur, 1L),
				GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Tantalite, 1L),
				GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Tungsten, 1L),
				GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Ruby, 1L),
				GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Gold, 1L),
				GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Iridium, 1L),
				new int[]{1200, 600, 300, 80, 50, 20}, 1000, 256
		);
		RA.addCentrifugeRecipe(GregTech_API.getStackofAmountFromOreDict("dustVenus", 1), GT_Values.NI,
				GT_Values.NF, Materials.CarbonDioxide.getGas(500L),
				GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Carbon, 1L),
				GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Scheelite, 1L),
				GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Mithril, 1L),
				GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Amethyst, 1L),
				GT_OreDictUnificator.get(OrePrefixes.dust, Materials.GarnetRed, 1L),
				GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Mytryl, 1L),
				new int[]{1200, 600, 300, 80, 50, 20}, 1000, 256
		);
		RA.addCentrifugeRecipe(GregTech_API.getStackofAmountFromOreDict("dustMercuryP", 1),
				GT_Values.NI, GT_Values.NF, Materials.Helium_3.getGas(50L),
				GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Vanadium, 1L),
				GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Tungstate, 1L),
				GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Mithril, 1L),
				GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Titanium, 1L),
				GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Ruby, 1L),
				GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Diamond, 1L),
				new int[]{1200, 600, 300, 80, 50, 20}, 1000, 256
		);
		RA.addCentrifugeRecipe(GregTech_API.getStackofAmountFromOreDict("dustIceEnceladus", 1),
				GT_Values.NI, GT_Values.NF, Materials.Oxygen.getGas(150L),
				GT_OreDictUnificator.get(OrePrefixes.dust, Materials.MysteriousCrystal, 1L),
				GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Chrome, 1L),
				GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Iridium, 1L),
				GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Ledox, 1L),
				GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Trinium, 1L),
				GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Naquadah, 1L),
				new int[]{1200, 600, 300, 80, 50, 20}, 1200, 480
		);
		RA.addCentrifugeRecipe(GregTech_API.getStackofAmountFromOreDict("dustEnceladus", 1),
				GT_Values.NI, GT_Values.NF, Materials.Nitrogen.getGas(150L),
				GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Chrome, 1L),
				GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Iridium, 1L),
				GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Osmium, 1L),
				GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Opal, 1L),
				GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Trinium, 1L),
				GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Naquadah, 1L),
				new int[]{1200, 600, 300, 80, 50, 20}, 1200, 480
		);
		RA.addCentrifugeRecipe(GregTech_API.getStackofAmountFromOreDict("dustTitan", 1), GT_Values.NI,
				GT_Values.NF, Materials.Methane.getGas(100L),
				GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Nickel, 1L),
				GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Iridium, 1L),
				GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Osmium, 1L),
				GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Emerald, 1L),
				GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Gallium, 1L),
				GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Trinium, 1L),
				new int[]{1200, 600, 300, 80, 50, 20}, 1200, 480
		);
		RA.addCentrifugeRecipe(GregTech_API.getStackofAmountFromOreDict("dustOberon", 1),
				GT_Values.NI, GT_Values.NF, Materials.Argon.getGas(50L),
				GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Iridium, 1L),
				GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Osmium, 1L),
				GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Naquadah, 1L),
				GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Uranium235, 1L),
				GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Plutonium241, 1L),
				GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Trinium, 1L),
				new int[]{1200, 600, 300, 80, 50, 20}, 1200, 480
		);
		RA.addCentrifugeRecipe(GregTech_API.getStackofAmountFromOreDict("dustMiranda", 1),
				GT_Values.NI, GT_Values.NF, Materials.Argon.getGas(50L),
				GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Tin, 1L),
				GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Tetrahedrite, 1L),
				GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Iridium, 1L),
				GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Desh, 1L),
				GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Chrome, 1L),
				GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Osmium, 1L),
				new int[]{1200, 600, 300, 80, 50, 20}, 1200, 480
		);
		RA.addCentrifugeRecipe(GregTech_API.getStackofAmountFromOreDict("dustTriton", 1),
				GT_Values.NI, GT_Values.NF, GT_Values.NF,
				GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Gold, 1L),
				GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Neodymium, 1L),
				GT_OreDictUnificator.get(OrePrefixes.dust, Materials.RareEarth, 1L),
				GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Niobium, 1L),
				GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Yttrium, 1L),
				GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Gallium, 1L),
				new int[]{1200, 600, 300, 80, 50, 20}, 1400, 1024
		);
		RA.addCentrifugeRecipe(GregTech_API.getStackofAmountFromOreDict("dustProteus", 1),
				GT_Values.NI, GT_Values.NF, Materials.Radon.getGas(10L),
				GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Copper, 1L),
				GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Uraninite, 1L),
				GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Draconium, 1L),
				GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Diamond, 1L),
				GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Uranium, 1L),
				GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Plutonium, 1L),
				new int[]{1200, 600, 300, 80, 50, 20}, 1400, 1024
		);
		RA.addCentrifugeRecipe(GregTech_API.getStackofAmountFromOreDict("dustIcePluto", 1),
				GT_Values.NI, GT_Values.NF, GT_Values.NF,
				GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Thorium, 1L),
				GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Uranium, 1L),
				GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Plutonium, 1L),
				GT_OreDictUnificator.get(OrePrefixes.dust, Materials.BlackPlutonium, 1L),
				GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Ledox, 1L),
				GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Naquadah, 1L),
				new int[]{1200, 600, 300, 80, 70, 60}, 1600, 1920
		);
		RA.addCentrifugeRecipe(GregTech_API.getStackofAmountFromOreDict("dustPluto", 1), GT_Values.NI,
				GT_Values.NF, GT_Values.NF,
				GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Thorium, 1L),
				GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Uranium, 1L),
				GT_OreDictUnificator.get(OrePrefixes.dust, Materials.BlackPlutonium, 1L),
				GT_OreDictUnificator.get(OrePrefixes.dust, Materials.GarnetRed, 1L),
				GT_OreDictUnificator.get(OrePrefixes.dust, Materials.GarnetYellow, 1L),
				GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Naquadah, 1L),
				new int[]{1200, 600, 300, 80, 70, 60}, 1600, 1920
		);
		RA.addCentrifugeRecipe(GregTech_API.getStackofAmountFromOreDict("dustMakeMake", 1),
				GT_Values.NI, GT_Values.NF, GT_Values.NF,
				GT_OreDictUnificator.get(OrePrefixes.dust, Materials.GarnetRed, 1L),
				GT_OreDictUnificator.get(OrePrefixes.dust, Materials.GarnetYellow, 1L),
				GT_OreDictUnificator.get(OrePrefixes.dust, Materials.BlackPlutonium, 1L),
				GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Gallium, 1L),
				GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Yttrium, 1L),
				GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Niobium, 1L),
				new int[]{1200, 600, 300, 80, 70, 60}, 1600, 1920
		);
		RA.addCentrifugeRecipe(GregTech_API.getStackofAmountFromOreDict("dustHaumea", 1),
				GT_Values.NI, GT_Values.NF, GT_Values.NF,
				GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Gold, 1L),
				GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Naquadah, 1L),
				GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Draconium, 1L),
				GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Lanthanum, 1L),
				GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Caesium, 1L),
				GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Cerium, 1L),
				new int[]{1200, 600, 300, 80, 70, 50}, 1600, 1920
		);
		
		RA.addCentrifugeRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Electrotine, 8L),
				GT_Values.NI, GT_Values.NF, GT_Values.NF,
				GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Redstone, 1L),
				GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Electrum, 1L), GT_Values.NI,
				GT_Values.NI, GT_Values.NI, GT_Values.NI, new int[]{10000, 10000}, 400, 480
		);
		
		RA.addCentrifugeRecipe(CoreItems.getRecipe(31, 4), GT_Values.NI, GT_Values.NF, GT_Values.NF,
				GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Clay, 2L),
				GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SiliconDioxide, 1L),
				GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Brick, 1L), GT_Values.NI,
				GT_Values.NI, GT_Values.NI, new int[]{10000, 9000, 7500}, 400, 30
		);
		RA.addCentrifugeRecipe(CoreItems.getRecipe(32, 4), GT_Values.NI, GT_Values.NF, GT_Values.NF,
				GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Brick, 2L),
				GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Stone, 1L),
				GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SiliconDioxide, 1L),
				GT_Values.NI, GT_Values.NI, GT_Values.NI, new int[]{10000, 7500, 2000}, 400, 30
		);
		
		RA.addCentrifugeRecipe(GT_ModHandler.getModItem("GalaxySpace", "barnardaCgrass", 1L),
				GT_Values.NI, GT_Values.NF, GT_Values.NF, CoreItems2.getRecipe(151, 1),
				GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Neutronium, 1L),
				GT_ModHandler.getModItem("minecraft", "sand", 1L), GT_Values.NI, GT_Values.NI, GT_Values.NI,
				new int[]{5000, 100, 5000}, 400, 8
		);
		RA.addCentrifugeRecipe(GT_ModHandler.getModItem("GalaxySpace", "barnardacblocks", 1L),
				GT_Values.NI, GT_Values.NF, GT_Values.NF, CoreItems2.getRecipe(151, 1),
				GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Neutronium, 1L),
				GT_ModHandler.getModItem("minecraft", "sand", 1L), GT_Values.NI, GT_Values.NI, GT_Values.NI,
				new int[]{2500, 100, 5000}, 400, 8
		);
		RA.addCentrifugeRecipe(GT_ModHandler.getModItem("GalaxySpace", "barnardaclog", 1L),
				GT_Values.NI, GT_Values.NF, Materials.Radon.getGas(60L), CoreItems2.getRecipe(151, 1),
				GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Carbon, 1L),
				GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Wood, 1L), GT_Values.NI, GT_Values.NI,
				GT_Values.NI, new int[]{3750, 2500, 2500}, 400, 8
		);
		RA
				.addCentrifugeRecipe(GT_ModHandler.getModItem("GalaxySpace", "barnardaCdandelion3", 64L),
						GT_Values.NI, GT_Values.NF, Materials.Biomass.getGas(1000L),
						GT_ModHandler.getModItem("IC2", "itemFuelPlantBall", 64L),
						CoreItems2.getRecipe(151, 16),
						GT_OreDictUnificator.get(OrePrefixes.dust, Materials.AlienOrganic, 4L), GT_Values.NI,
						GT_Values.NI, GT_Values.NI, new int[]{10000, 10000, 10000}, 400, 8
				);
		RA.addCentrifugeRecipe(GT_ModHandler.getModItem("GalaxySpace", "barnardaCreed", 64L),
				GT_Values.NI, GT_Values.NF, Materials.Biomass.getGas(1000L),
				GT_ModHandler.getModItem("IC2", "itemFuelPlantBall", 64L), CoreItems2.getRecipe(151, 16),
				GT_OreDictUnificator.get(OrePrefixes.dust, Materials.AlienOrganic, 4L), GT_Values.NI,
				GT_Values.NI, GT_Values.NI, new int[]{10000, 10000, 10000}, 400, 8
		);
		RA
				.addCentrifugeRecipe(GT_ModHandler.getModItem("GalaxySpace", "barnardaCdandelions", 64L),
						GT_Values.NI, GT_Values.NF, Materials.Biomass.getGas(1000L),
						GT_ModHandler.getModItem("IC2", "itemFuelPlantBall", 64L),
						CoreItems2.getRecipe(151, 16),
						GT_OreDictUnificator.get(OrePrefixes.dust, Materials.AlienOrganic, 4L), GT_Values.NI,
						GT_Values.NI, GT_Values.NI, new int[]{10000, 10000, 10000}, 400, 8
				);
		RA
				.addCentrifugeRecipe(GT_ModHandler.getModItem("GalaxySpace", "barnardacdandelions", 64L, 1),
						GT_Values.NI, GT_Values.NF, Materials.Biomass.getGas(1000L),
						GT_ModHandler.getModItem("IC2", "itemFuelPlantBall", 64L),
						CoreItems2.getRecipe(151, 16),
						GT_OreDictUnificator.get(OrePrefixes.dust, Materials.AlienOrganic, 4L), GT_Values.NI,
						GT_Values.NI, GT_Values.NI, new int[]{10000, 10000, 10000}, 400, 8
				);
		
		RA.addCentrifugeRecipe(
				GT_OreDictUnificator.get(OrePrefixes.dust.get(Materials.Orichalcum), 4L), GT_Values.NI,
				GT_Values.NF, GT_Values.NF,
				GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Trinium, 1L),
				GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Trinium, 1L),
				GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Trinium, 1L),
				GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Oriharukon, 1L), GT_Values.NI,
				GT_Values.NI, new int[]{10000, 10000, 10000, 10000}, 300, 122880
		);
		RA
				.addCentrifugeRecipe(GT_OreDictUnificator.get(OrePrefixes.dust.get(Materials.Mytryl), 6L),
						GT_Values.NI, GT_Values.NF, GT_Values.NF,
						GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Lead, 3L),
						GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Platinum, 2L),
						GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Draconium, 1L), GT_Values.NI,
						GT_Values.NI, GT_Values.NI, new int[]{10000, 10000, 5000}, 400, 1920
				);

		// --- Petcoke Dust to Ash
		RA.addCentrifugeRecipe(CoreItems.getRecipe(50, 1),
				GT_Values.NI, GT_Values.NF, GT_Values.NF,
				GT_OreDictUnificator.get(OrePrefixes.dust, Materials.DarkAsh, 1L),
				GT_Values.NI, GT_Values.NI, GT_Values.NI, GT_Values.NI, GT_Values.NI,
				new int[]{1000}, 200, 5
		);
	}
	
	private void alloySmelter() {
		RA.addAlloySmelterRecipe(new ItemStack(Items.clay_ball, 3, 0),
				new ItemStack(Blocks.sand, 5, 0), CoreItems2.getRecipe(CokeOvenBrick.getMetaID(), 3), 130,
				3
		);
		RA.addAlloySmelterRecipe(new ItemStack(Items.clay_ball, 1, 0),
				ItemList.Shape_Mold_Ingot.get(0), GT_ModHandler.getModItem("minecraft", "brick", 1L, 0),
				130, 3
		);
		RA
				.addAlloySmelterRecipe(new ItemStack(Items.clay_ball, 3), new ItemStack(Blocks.sand, 5),
						CoreItems2.getRecipe(65, 3), 390, 3
				);
		RA.addAlloySmelterRecipe(GT_ModHandler.getModItem("IC2", "itemPartIridium", 2L),
				ItemList.Shape_Mold_Casing.get(0), CoreItems2.getRecipe(52, 3), 1200, 256
		);
		RA.addAlloySmelterRecipe(new ItemStack(Items.clay_ball, 1, 0),
				ItemList.Shape_Mold_Ingot.get(0), new ItemStack(Items.brick, 1, 0), 130, 3
		);
		RA.addAlloySmelterRecipe(CoreItems.getRecipe(33, 1), ItemList.Shape_Mold_Ball.get(0),
				ItemList.Circuit_Parts_Glass_Tube.get(1), 120, 16
		);
	}
	
	private void assembler() {
		//LaserCore MK1	
		final ItemStack[] LaserCore1 = {
                GT_OreDictUnificator.get(OrePrefixes.gemExquisite, Materials.Diamond, 1),
                GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.TungstenSteel, 1),
                GregTech_API.getStackofAmountFromOreDict("plateYSZ", 4),
                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Silver, 16),
                GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.HastelloyC276, 16)			
        };
		RA.addAssemblerRecipe(
                LaserCore1,
                null,
                CoreItems2.getRecipe(198, 1),
                20 * 20, 7680
        );

		//LaserCore MK2
		final ItemStack[] LaserCore2 = {
                GT_OreDictUnificator.get(OrePrefixes.gemExquisite, Materials.Ruby, 1),
                GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Osmiridium, 1),
                GregTech_API.getStackofAmountFromOreDict("plateGDC", 4),
                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Trinium, 16),
                GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Lafium, 16)			
        };
		RA.addAssemblerRecipe(
                LaserCore2,
                null,
                CoreItems2.getRecipe(199, 1),
                20 * 30, 122800
        );

		//LaserCore MK3
		final ItemStack[] LaserCore3 = {
                GT_OreDictUnificator.get(OrePrefixes.gemExquisite, Materials.MysteriousCrystal, 1),
                GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.NaquadahAlloy, 1),
                GregTech_API.getStackofAmountFromOreDict("plateLSCF", 4),
                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Adamantium, 16),
                GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Quantum, 16)			
        };
		RA.addAssemblerRecipe(
                LaserCore3,
                null,
                CoreItems2.getRecipe(200, 1),
                20 * 40, 2000000
        );

		//YSZ Unit	
		final ItemStack[] yszUnit = {
				GT_Utility.getIntegratedCircuit(6),
				GregTech_API.getStackofAmountFromOreDict("plateYSZ", 6),
				GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.StainlessSteel, 1),
				GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.StainlessSteel, 1),
				ItemList.Electric_Motor_EV.get(1L)};
		RA.addAssemblerRecipe(
				yszUnit,
				Materials.Hydrogen.getGas(4000),
				Blockstack(CeramicBlock, 1, 0),
				20 * 60, 480
		);
		
		//GDC Unit
		final ItemStack[] gdcUnit = {
				GT_Utility.getIntegratedCircuit(6),
				GregTech_API.getStackofAmountFromOreDict("plateGDC", 6),
				GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Titanium, 1),
				GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.Titanium, 1),
				ItemList.Electric_Motor_IV.get(1L)};
		RA.addAssemblerRecipe(
				gdcUnit,
				Materials.Hydrogen.getGas(8000),
				Blockstack(CeramicBlock, 1, 1),
				20 * 60, 1920
		);
		//LSCF Unit
		final ItemStack[] lscfUnit = {
				GT_Utility.getIntegratedCircuit(6),
				GregTech_API.getStackofAmountFromOreDict("plateLSCF", 6),
				GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.TungstenSteel, 1),
				GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.TungstenSteel, 1),
				ItemList.Electric_Motor_LuV.get(1L)};
		RA.addAssemblerRecipe(
				lscfUnit, Materials.Hydrogen.getGas(16000),
				Blockstack(CeramicBlock, 1, 2),
				20 * 60, 7680
		);
		
		//Field Tier 1
		final ItemStack[] tfftstoragefield1 = {
				GT_Utility.getIntegratedCircuit(6),
				ItemList.Electric_Pump_MV.get(1L),
				GT_OreDictUnificator.get(OrePrefixes.plate, Materials.StainlessSteel, 4)};
		RA.addAssemblerRecipe(
				tfftstoragefield1, FluidRegistry.getFluidStack("molten.polytetrafluoroethylene", 36),
				Blockstack(FluidTankBlock, 1, 0),
				200, 480
		);
		//Field Tier 2
		final ItemStack[] tfftstoragefield2 = {
				GT_Utility.getIntegratedCircuit(6),
				ItemList.Field_Generator_LV.get(1L),
				ItemList.Electric_Pump_HV.get(1L),
				GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Titanium, 4)};
		RA.addAssemblerRecipe(
				tfftstoragefield2, FluidRegistry.getFluidStack("molten.polytetrafluoroethylene", 144),
				Blockstack(FluidTankBlock, 1, 1),
				200, 1920
		);
		//Field Tier 3
		final ItemStack[] tfftstoragefield3 = {
				GT_Utility.getIntegratedCircuit(6),
				ItemList.Field_Generator_MV.get(1L),
				ItemList.Electric_Pump_EV.get(1L),
				GT_OreDictUnificator.get(OrePrefixes.plate, Materials.TungstenSteel, 4)};
		RA.addAssemblerRecipe(
				tfftstoragefield3, FluidRegistry.getFluidStack("molten.epoxid", 144),
				Blockstack(FluidTankBlock, 1, 2),
				200, 7680
		);
		//Field Tier 4
		final ItemStack[] tfftstoragefield4 = {
				GT_Utility.getIntegratedCircuit(6),
				ItemList.Field_Generator_HV.get(1L),
				ItemList.Electric_Pump_IV.get(1L),
				GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Chrome, 4)};
		RA.addAssemblerRecipe(
				tfftstoragefield4, FluidRegistry.getFluidStack("molten.epoxid", 144),
				Blockstack(FluidTankBlock, 1, 3),
				200, 30720
		);
		//Field Tier 5
		final ItemStack[] tfftstoragefield5 = {
				GT_Utility.getIntegratedCircuit(6),
				ItemList.Field_Generator_EV.get(1L),
				ItemList.Electric_Pump_LuV.get(1L),
				GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Iridium, 4)};
		RA.addAssemblerRecipe(
				tfftstoragefield5, FluidRegistry.getFluidStack("molten.epoxid", 144),
				Blockstack(FluidTankBlock, 1, 4),
				200, 122880
		);
		
		//Field Tier 6
		final ItemStack[] tfftstoragefield6 = {
				GT_Utility.getIntegratedCircuit(6),
				ItemList.Field_Generator_IV.get(1L),
				ItemList.Electric_Pump_ZPM.get(1L),
				GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Osmium, 4)};
		RA.addAssemblerRecipe(
				tfftstoragefield6, FluidRegistry.getFluidStack("molten.epoxid", 144),
				Blockstack(FluidTankBlock, 1, 5),
				200, 491520
		);
		//Field Tier 7
		final ItemStack[] tfftstoragefield7 = {
				GT_Utility.getIntegratedCircuit(6),
				ItemList.Field_Generator_LuV.get(1L),
				ItemList.Electric_Pump_UV.get(1L),
				GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Tritanium, 4)};
		RA.addAssemblerRecipe(
				tfftstoragefield7, FluidRegistry.getFluidStack("molten.epoxid", 144),
				Blockstack(FluidTankBlock, 1, 6),
				200, 1966080
		);
		//Field Tier 8
		final ItemStack[] tfftstoragefield8 = {
				GT_Utility.getIntegratedCircuit(6),
				ItemList.Field_Generator_ZPM.get(1L),
				ItemList.Electric_Pump_UHV.get(1L),
				GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Neutronium, 4)};
		RA.addAssemblerRecipe(
				tfftstoragefield8, FluidRegistry.getFluidStack("molten.epoxid", 144),
				Blockstack(FluidTankBlock, 1, 7),
				200, 7864320
		);
		
		//Casings
		RA.addAssemblerRecipe(
				new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.GumMetal, 1),
						GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Titaniolum, 6),
						GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.HSSG, 16)},
				Materials.HSSE.getMolten(288L), GT_ItemList.PBECasing.get(2), 200, 1920
		);
		RA.addAssemblerRecipe(
				new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Zamak, 1),
						GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Duraluminium, 6),
						GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.HSSG, 16)},
				Materials.HSSE.getMolten(288L), GT_ItemList.EngraverCasing.get(2), 200, 1920
		);
		RA.addAssemblerRecipe(
				new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Inconel690, 1),
						GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Nitinol, 6),
						GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.HSSG, 16)},
				Materials.HSSE.getMolten(288L), GT_ItemList.AssemblerCasing.get(2), 200, 1920
		);
		RA.addAssemblerRecipe(
				new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Inconel792, 1),
						GT_OreDictUnificator.get(OrePrefixes.plate, Materials.TiBetaC, 6),
						GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.HSSG, 16)},
				Materials.HSSE.getMolten(288L), GT_ItemList.CentrifugeCasing.get(2), 200, 1920
		);
		RA.addAssemblerRecipe(
				new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.HastelloyC276, 1),
						GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Zamak, 6),
						GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.HSSG, 16)},
				Materials.HSSE.getMolten(288L), GT_ItemList.ElectrolyzerCasing.get(2), 200, 1920
		);
		RA.addAssemblerRecipe(
				new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Titaniolum, 1),
						GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Inconel690, 6),
						GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.HSSG, 16)},
				Materials.HSSE.getMolten(288L), GT_ItemList.WireFactoryCasing.get(2), 200, 1920
		);
		RA.addAssemblerRecipe(new ItemStack[]{
						GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.MaragingSteel250, 1),
						GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Inconel792, 6),
						GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.HSSG, 16)},
				Materials.HSSE.getMolten(288L), GT_ItemList.SupplyProductionCasing.get(2), 200, 1920
		);
		RA.addAssemblerRecipe(
				new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Nitinol, 1),
						GT_OreDictUnificator.get(OrePrefixes.plate, Materials.HastelloyC276, 6),
						GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.HSSG, 16)},
				Materials.HSSE.getMolten(288L), GT_ItemList.UtilityMachineCasing.get(2), 200, 1920
		);
		RA.addAssemblerRecipe(
				new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Talonite, 1),
						GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Grisium, 6),
						GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.HSSG, 16)},
				Materials.HSSE.getMolten(288L), GT_ItemList.BrewmenterCasing.get(2), 200, 1920
		);
		RA.addAssemblerRecipe(
				new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Nitinol, 1),
						GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Inconel690, 6),
						GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.HSSG, 16)},
				Materials.HSSE.getMolten(288L), GT_ItemList.ElectromagneticCasing.get(2), 200, 1920
		);
		RA.addAssemblerRecipe(
				new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Nitinol60, 1),
						GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Kovar, 6),
						GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.HSSG, 16)},
				Materials.HSSE.getMolten(288L), GT_ItemList.ArcCasing.get(2), 200, 1920
		);
		RA.addAssemblerRecipe(
				new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.TiBetaC, 1),
						GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Talonite, 6),
						GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.HSSG, 16)},
				Materials.HSSE.getMolten(288L), GT_ItemList.ExtradificationCasing.get(2), 200, 1920
		);
		RA.addAssemblerRecipe(
				new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Titaniolum, 1),
						GT_OreDictUnificator.get(OrePrefixes.plate, Materials.MaragingSteel250, 6),
						GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.HSSG, 16)},
				Materials.HSSE.getMolten(288L), GT_ItemList.MixingCasing.get(2), 200, 1920
		);
		RA.addAssemblerRecipe(
				new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.HastelloyC276, 1),
						GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Mangalloy, 6),
						GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.HSSG, 16)},
				Materials.HSSE.getMolten(288L), GT_ItemList.MacerationCasing.get(2), 200, 1920
		);
		RA.addAssemblerRecipe(new ItemStack[]{
						GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.MaragingSteel300, 1),
						GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Stellite, 6),
						GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.HSSG, 16)},
				Materials.HSSE.getMolten(288L), GT_ItemList.CuttingCasing.get(2), 200, 1920
		);
		RA.addAssemblerRecipe(
				new ItemStack[]{ItemList.Machine_HV_Printer.get(1L), ItemList.Cover_Crafting.get(1L),
						ItemList.Conveyor_Module_HV.get(2L),
						GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Advanced, 4),
						GT_OreDictUnificator.get(OrePrefixes.gearGtSmall, Materials.BlackSteel, 8),
						GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.StainlessSteel, 16)},
				Materials.SolderingAlloy.getMolten(288L), GT_ItemList.Machine_DDDPrinter.get(1), 200, 480
		);
		RA.addAssemblerRecipe(
				new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.StainlessSteel, 1),
						GT_OreDictUnificator.get(OrePrefixes.plate, Materials.VanadiumSteel, 6),
						GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.RedSteel, 8)}, null,
				GT_ItemList.DDDPrinterCasing.get(2), 100, 120
		);
		RA.addAssemblerRecipe(new ItemStack[]{
						GT_ModHandler.getModItem(AE2, "item.ItemMultiPart", 1L, 340),
						ItemList.Cover_ItemDetector.get(4L),
						GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.VanadiumSteel, 4),
						ItemList.Robot_Arm_HV.get(4L),
						GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Advanced, 8),
						GT_OreDictUnificator.get(OrePrefixes.gearGt, Materials.BlackSteel, 16),
						GT_OreDictUnificator.get(OrePrefixes.plate, Materials.StainlessSteel, 24),
						GT_OreDictUnificator.get(OrePrefixes.screw, Materials.BlueSteel, 32)}, null,
				GT_ItemList.DDDPrinterCasing3x3.get(9), 800, 120
		);
		RA.addAssemblerRecipe(
				new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.GumMetal, 1),
						GT_OreDictUnificator.get(OrePrefixes.plateDense, Materials.Naquadah, 1),
						GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Desh, 6),
						GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.TungstenSteel, 12),
						GT_OreDictUnificator.get(OrePrefixes.screw, Materials.TungstenSteel, 12),
						ItemList.Field_Generator_MV.get(1L)}, null, GT_ItemList.NqCasing.get(2), 200, 7680);
		RA.addAssemblerRecipe(
				new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Inconel792, 1),
						GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.MaragingSteel300, 6),
						GT_OreDictUnificator.get(OrePrefixes.foil, Materials.BlackSteel, 12),
						GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.HSSS, 16)},
				Materials.HSSG.getMolten(288L), GT_ItemList.CycloneCasing.get(2), 200, 7680
		);
		
		// --- Turbine Casing
		RA.addAssemblerRecipe(
				new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Titaniolum, 1),
						GT_OreDictUnificator.get(OrePrefixes.plate, Materials.TiBetaC, 6),
						GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.HSSG, 16)},
				Materials.HSSE.getMolten(288L), GT_ItemList.Huge_Casing_Turbine.get(2), 200, 1920
		);
		
		//SolarPanel
		RA.addAssemblerRecipe(
				new ItemStack[]{ItemList.Cover_SolarPanel_8V.get(1L), GT_ItemList.ULVRobotArm.get(1L),
						ItemList.Large_Fluid_Cell_Steel.get(1L), ItemList.Sensor_LV.get(1L),
						GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Basic, 2),
						GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Silicon, 6),
						ItemList.Battery_Buffer_2by2_ULV.get(1L)}, Materials.SolderingAlloy.getMolten(144),
                GT_ItemList.Solar_ULV.get(1), 100, 30
		);
		RA.addAssemblerRecipe(
				new ItemStack[]{ItemList.Cover_SolarPanel_LV.get(1L), ItemList.Robot_Arm_LV.get(1L),
						ItemList.Large_Fluid_Cell_Aluminium.get(1L), ItemList.Sensor_MV.get(1L),
						GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Good, 4),
						GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Silicon, 6),
						ItemList.Battery_Buffer_2by2_LV.get(1L)}, Materials.SolderingAlloy.getMolten(288),
                GT_ItemList.Solar_LV.get(1), 200, 120
		);
		RA.addAssemblerRecipe(
				new ItemStack[]{ItemList.Cover_SolarPanel_MV.get(1L), ItemList.Robot_Arm_MV.get(1L),
						ItemList.Large_Fluid_Cell_StainlessSteel.get(1L), ItemList.Sensor_HV.get(1L),
						GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Advanced, 6),
						GT_OreDictUnificator.get(OrePrefixes.plateTriple, Materials.Silicon, 6),
						ItemList.Battery_Buffer_2by2_MV.get(1L)}, Materials.SolderingAlloy.getMolten(576),
                GT_ItemList.Solar_MV.get(1), 300, 480
		);
		RA.addAssemblerRecipe(
				new ItemStack[]{ItemList.Cover_SolarPanel_HV.get(1L), ItemList.Robot_Arm_HV.get(1L),
						ItemList.Large_Fluid_Cell_Titanium.get(1L), ItemList.Sensor_EV.get(1L),
						GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Data, 8),
						GT_OreDictUnificator.get(OrePrefixes.plate, Materials.GalliumArsenide, 8),
						ItemList.Battery_Buffer_2by2_HV.get(1L)}, Materials.SolderingAlloy.getMolten(1152),
                GT_ItemList.Solar_HV.get(1), 400, 1920
		);
		RA.addAssemblerRecipe(
				new ItemStack[]{ItemList.Cover_SolarPanel_EV.get(1L), ItemList.Robot_Arm_EV.get(1L),
						ItemList.Large_Fluid_Cell_TungstenSteel.get(1L), ItemList.Sensor_IV.get(1L),
						GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Elite, 10),
						GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.GalliumArsenide, 8),
						ItemList.Battery_Buffer_2by2_EV.get(1L)}, Materials.SolderingAlloy.getMolten(2304),
                GT_ItemList.Solar_EV.get(1), 500, 7680
		);
		RA.addAssemblerRecipe(
				new ItemStack[]{ItemList.Cover_SolarPanel_IV.get(1L), ItemList.Robot_Arm_IV.get(1L),
						ItemList.Large_Fluid_Cell_Chrome.get(1L), ItemList.Sensor_LuV.get(1L),
						GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Master, 12),
						GT_OreDictUnificator.get(OrePrefixes.plateTriple, Materials.GalliumArsenide, 8),
						ItemList.Battery_Buffer_2by2_IV.get(1L)}, Materials.SolderingAlloy.getMolten(4608),
                GT_ItemList.Solar_IV.get(1), 600, 30720
		);
		RA.addAssemblerRecipe(
				new ItemStack[]{ItemList.Cover_SolarPanel_LuV.get(1L), ItemList.Robot_Arm_LuV.get(1L),
						ItemList.Large_Fluid_Cell_Iridium.get(1L), ItemList.Sensor_ZPM.get(1L),
						GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Ultimate, 14),
						GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Sunnarium, 10),
						ItemList.Battery_Buffer_2by2_LuV.get(1L)}, Materials.SolderingAlloy.getMolten(9216),
                GT_ItemList.Solar_LuV.get(1), 700, 122880
		);
		RA.addAssemblerRecipe(
				new ItemStack[]{ItemList.Cover_SolarPanel_ZPM.get(1L), ItemList.Robot_Arm_ZPM.get(1L),
						ItemList.Large_Fluid_Cell_Osmium.get(1L), ItemList.Sensor_UV.get(1L),
						GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Superconductor, 16),
						GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Sunnarium, 10),
						ItemList.Battery_Buffer_2by2_ZPM.get(1L)}, Materials.SolderingAlloy.getMolten(18432),
                GT_ItemList.Solar_ZPM.get(1), 800, 500000
		);
		RA.addAssemblerRecipe(
				new ItemStack[]{ItemList.Cover_SolarPanel_UV.get(1L), ItemList.Robot_Arm_UV.get(1L),
						ItemList.Large_Fluid_Cell_Neutronium.get(1L), ItemList.Sensor_UHV.get(1L),
						GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Infinite, 18),
						GT_OreDictUnificator.get(OrePrefixes.plateTriple, Materials.Sunnarium, 10),
						ItemList.Battery_Buffer_2by2_UV.get(1L)}, Materials.SolderingAlloy.getMolten(36864),
                GT_ItemList.Solar_UV.get(1), 900, 2000000
		);
		
		//Portable Tank
		RA.addAssemblerRecipe(
				new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Lead, 8),
						ItemList.Large_Fluid_Cell_Steel.get(1L),
						ItemList.Circuit_Integrated.getWithDamage(0L, 2L)}, GT_Values.NF,
				GT_ItemList.Portable_Tank_ULV.get(1L), 100, 6
		);
		RA.addAssemblerRecipe(
				new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Steel, 8),
						ItemList.Large_Fluid_Cell_Aluminium.get(1L),
						ItemList.Circuit_Integrated.getWithDamage(0L, 2L)}, GT_Values.NF,
				GT_ItemList.Portable_Tank_LV.get(1L), 200, 30
		);
		RA.addAssemblerRecipe(
				new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Aluminium, 8),
						ItemList.Large_Fluid_Cell_StainlessSteel.get(1L),
						ItemList.Circuit_Integrated.getWithDamage(0L, 2L)}, GT_Values.NF,
				GT_ItemList.Portable_Tank_MV.get(1L), 300, 120
		);
		RA.addAssemblerRecipe(
				new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.plate, Materials.HSLA, 8),
						ItemList.Large_Fluid_Cell_Titanium.get(1L),
						ItemList.Circuit_Integrated.getWithDamage(0L, 2L)}, GT_Values.NF,
				GT_ItemList.Portable_Tank_HV.get(1L), 400, 480
		);
		RA.addAssemblerRecipe(
				new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.plate, Materials.HSSG, 8),
						ItemList.Large_Fluid_Cell_TungstenSteel.get(1L),
						ItemList.Circuit_Integrated.getWithDamage(0L, 2L)}, GT_Values.NF,
				GT_ItemList.Portable_Tank_EV.get(1L), 500, 1920
		);
		RA.addAssemblerRecipe(
				new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.plate, Materials.HastelloyC276, 8),
						ItemList.Large_Fluid_Cell_Chrome.get(1L),
						ItemList.Circuit_Integrated.getWithDamage(0L, 2L)}, GT_Values.NF,
				GT_ItemList.Portable_Tank_IV.get(1L), 600, 7680
		);
		RA.addAssemblerRecipe(
				new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.plate, Materials.HastelloyN, 8),
						ItemList.Large_Fluid_Cell_Iridium.get(1L),
						ItemList.Circuit_Integrated.getWithDamage(0L, 2L)}, GT_Values.NF,
				GT_ItemList.Portable_Tank_LuV.get(1L), 700, 30720
		);
		RA.addAssemblerRecipe(
				new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Lafium, 8),
						ItemList.Large_Fluid_Cell_Osmium.get(1L),
						ItemList.Circuit_Integrated.getWithDamage(0L, 2L)}, GT_Values.NF,
				GT_ItemList.Portable_Tank_ZPM.get(1L), 800, 122880
		);
		RA.addAssemblerRecipe(
				new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.plate, Materials.CinobiteA243, 8),
						ItemList.Large_Fluid_Cell_Neutronium.get(1L),
						ItemList.Circuit_Integrated.getWithDamage(0L, 2L)}, GT_Values.NF,
				GT_ItemList.Portable_Tank_UV.get(1L), 900, 500000
		);
		
		//Sawmill
		RA.addAssemblerRecipe(
				new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.slab, Materials.Wood, 6L),
						GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Wood, 1L),
						GT_Utility.getIntegratedCircuit(2)}, null, GT_ItemList.SawCase.get(2L), 50, 16);
		RA.addAssemblerRecipe(new ItemStack[]{GT_ItemList.ULVConveyorModule.get(1),
						GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Wood, 4L),
						GT_Utility.getIntegratedCircuit(1)}, null,
				GT_ModHandler.getModItem("impact", "impact_sawmill_block", 5L), 60, 30
		);
		//Communication Transmitter Hatch
		RA.addAssemblerRecipe(new ItemStack[]{
				ItemList.Hull_HV.get(1L),
				ItemList.Field_Generator_HV.get(2L), ItemList.Sensor_HV.get(4L),
				GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.HSLA, 4),
				GT_OreDictUnificator.get(OrePrefixes.stickLong, Materials.StainlessSteel, 4),
				GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Advanced, 4),
				GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.RedSteel, 8),
				GT_OreDictUnificator.get(OrePrefixes.screw, Materials.BlueSteel, 8)
		}, null, GT_ItemList.Communication_Hatch_Transmitter.get(1L), 40 * 20, 480);
		//Communication Receiver Hatch
		RA.addAssemblerRecipe(new ItemStack[]{
				ItemList.Hull_HV.get(1L),
				ItemList.Field_Generator_HV.get(2L), ItemList.Emitter_HV.get(4L),
				GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.HSLA, 4),
				GT_OreDictUnificator.get(OrePrefixes.stickLong, Materials.StainlessSteel, 4),
				GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Advanced, 4),
				GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.RedSteel, 8),
				GT_OreDictUnificator.get(OrePrefixes.screw, Materials.BlueSteel, 8)
		}, null, GT_ItemList.Communication_Hatch_Receiver.get(1L), 40 * 20, 480);
		//Parallel Hatch 4P IN
		RA.addAssemblerRecipe(
				new ItemStack[]{ItemList.Hull_IV.get(1), GT_ModHandler.getModItem(AE2, "tile.BlockCraftingStorage", 1L, 1),
						ItemList.Sensor_IV.get(1), GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Elite, 4L),
						GT_Utility.getIntegratedCircuit(1)}, null,
				GT_ItemList.Parallel_Hatch_IN4.get(1), 600, 7680
		);
		//Parallel Hatch 4P OUT
		RA.addAssemblerRecipe(
				new ItemStack[]{ItemList.Hull_IV.get(1), GT_ModHandler.getModItem(AE2, "tile.BlockCraftingStorage", 1L, 1),
						ItemList.Emitter_IV.get(1), GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Elite, 4L),
						GT_Utility.getIntegratedCircuit(1)}, null,
				GT_ItemList.Parallel_Hatch_OUT4.get(1), 600, 7680
		);
		//Parallel Hatch 16P IN
		RA.addAssemblerRecipe(
				new ItemStack[]{ItemList.Hull_LuV.get(1), GT_ModHandler.getModItem(AE2, "tile.BlockCraftingStorage", 1L, 2),
						ItemList.Sensor_LuV.get(1), GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Master, 4L),
						GT_Utility.getIntegratedCircuit(1)}, null,
				GT_ItemList.Parallel_Hatch_IN16.get(1), 800, 30720
		);
		//Parallel Hatch 16P OUT
		RA.addAssemblerRecipe(
				new ItemStack[]{ItemList.Hull_LuV.get(1), GT_ModHandler.getModItem(AE2, "tile.BlockCraftingStorage", 1L, 2),
						ItemList.Emitter_LuV.get(1), GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Master, 4L),
						GT_Utility.getIntegratedCircuit(1)}, null,
				GT_ItemList.Parallel_Hatch_OUT16.get(1), 800, 30720
		);
		//Parallel Hatch 64P IN
		RA.addAssemblerRecipe(
				new ItemStack[]{ItemList.Hull_ZPM.get(1), GT_ModHandler.getModItem(AE2, "tile.BlockCraftingStorage", 1L, 3),
						ItemList.Sensor_ZPM.get(1), GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Ultimate, 4L),
						GT_Utility.getIntegratedCircuit(1)}, null,
				GT_ItemList.Parallel_Hatch_IN64.get(1), 1000, 122880
		);
		//Parallel Hatch 64P OUT
		RA.addAssemblerRecipe(
				new ItemStack[]{ItemList.Hull_ZPM.get(1), GT_ModHandler.getModItem(AE2, "tile.BlockCraftingStorage", 1L, 3),
						ItemList.Emitter_ZPM.get(1), GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Ultimate, 4L),
						GT_Utility.getIntegratedCircuit(1)}, null,
				GT_ItemList.Parallel_Hatch_OUT64.get(1), 1000, 122880
		);
		//Parallel Hatch 256P IN
		RA.addAssemblerRecipe(
				new ItemStack[]{ItemList.Hull_UV.get(1), GT_ModHandler.getModItem(AE2, "tile.BlockAdvancedCraftingStorage", 1L),
						ItemList.Sensor_UV.get(1), GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Superconductor, 4L),
						GT_Utility.getIntegratedCircuit(1)}, null,
				GT_ItemList.Parallel_Hatch_IN256.get(1), 1200, 500000
		);
		//Parallel Hatch 256P OUT
		RA.addAssemblerRecipe(
				new ItemStack[]{ItemList.Hull_UV.get(1), GT_ModHandler.getModItem(AE2, "BlockAdvancedCraftingStorage", 1L),
						ItemList.Emitter_UV.get(1), GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Superconductor, 4L),
						GT_Utility.getIntegratedCircuit(1)}, null,
				GT_ItemList.Parallel_Hatch_OUT256.get(1), 1200, 500000
		);
		
		// --- Computer Rack
		RA.addAssemblerRecipe(
				new ItemStack[]{GT_ItemList.Computer_Casing.get(1L), ItemList.Hatch_Input_Bus_IV.get(1),
						GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Elite, 2L), ItemList.Circuit_Parts_GlassFiber.get(16)},
				Materials.TungstenSteel.getMolten(1296L),
				GT_ItemList.Parallel_Hatch_Rack.get(1), 400, 7680
		);
		
		// --- Nuclear Rod Hatch
		RA.addAssemblerRecipe(
				new ItemStack[]{ItemList.Hull_EV.get(1), ItemList.Electric_Motor_EV.get(1),
						GT_OreDictUnificator.get(OrePrefixes.plateTriple, Materials.Lead, 4L), GT_Utility.getIntegratedCircuit(4)},
				Materials.Polytetrafluoroethylene.getMolten(576L),
				GT_ItemList.Nuclear_Hatch_Rod.get(1), 480, 1920
		);
		RA.addAssemblerRecipe(
				new ItemStack[]{ItemList.Hull_EV.get(1), ItemList.Electric_Motor_EV.get(1),
						GT_OreDictUnificator.get(OrePrefixes.plateTriple, Materials.Lead, 4L), GT_Utility.getIntegratedCircuit(4)},
				Materials.Polybenzimidazole.getMolten(72L),
				GT_ItemList.Nuclear_Hatch_Rod.get(1), 480, 1920
		);
		RA.addAssemblerRecipe(
				new ItemStack[]{GT_ModHandler.getModItem("IC2", "blockAlloyGlass", 1L, 0),
						GT_OreDictUnificator.get(OrePrefixes.plate, Materials.TungstenSteel, 4L),
						GT_Utility.getIntegratedCircuit(1)}, GT_Values.NF, CoreItems2.getRecipe(54, 1), 100,
				120
		);
		RA.addAssemblerRecipe(new ItemStack[]{CoreItems2.getRecipe(54, 2),
				GT_OreDictUnificator.get(OrePrefixes.plate, Materials.TungstenSteel, 3L),
				GT_Utility.getIntegratedCircuit(2)}, GT_Values.NF, CoreItems2.getRecipe(55, 1), 200, 250);
		RA.addAssemblerRecipe(new ItemStack[]{CoreItems2.getRecipe(54, 3),
				GT_OreDictUnificator.get(OrePrefixes.plate, Materials.TungstenSteel, 6L),
				GT_Utility.getIntegratedCircuit(3)}, GT_Values.NF, CoreItems2.getRecipe(56, 1), 300, 480);
		RA.addAssemblerRecipe(
				new ItemStack[]{CoreItems2.getRecipe(54, 1), CoreItems2.getRecipe(55, 1),
						GT_OreDictUnificator.get(OrePrefixes.plate, Materials.TungstenSteel, 7L),
						GT_Utility.getIntegratedCircuit(1)}, GT_Values.NF, CoreItems2.getRecipe(56, 1), 100,
				480
		);
		RA.addAssemblerRecipe(new ItemStack[]{CoreItems2.getRecipe(56, 2),
				GT_OreDictUnificator.get(OrePrefixes.plate, Materials.TungstenSteel, 6L),
				GT_OreDictUnificator.get(OrePrefixes.plateDense, Materials.ElectrumFlux, 1L),
				GT_Utility.getIntegratedCircuit(2)}, GT_Values.NF, CoreItems2.getRecipe(57, 1), 200, 1020);
		
		//Bars
		RA
				.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Steel, 3L),
						GT_Utility.getIntegratedCircuit(3), CoreItems2.getRecipe(51, 4), 400, 48
				);
		
		//Casings
		RA
				.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Steel, 1L),
						CoreItems2.getRecipe(SteelBars.getMetaID(), 6), Casing_Farm.get(1L), 50, 16
				);
		
		//Piston
		RA.addAssemblerRecipe(
				new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.cobblestone, 1L),
						GT_OreDictUnificator.get(OrePrefixes.gearGtSmall, Materials.Iron, 1L)},
				Materials.Redstone.getMolten(72L), Blockstack(UtilBlock, 1, 1), 100, 8, false
		);
		RA.addAssemblerRecipe(
				new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.cobblestone, 1L),
						GT_OreDictUnificator.get(OrePrefixes.gearGtSmall, Materials.Bronze, 1L)},
				Materials.Redstone.getMolten(72L), Blockstack(UtilBlock, 1, 1), 100, 8, false
		);
		RA.addAssemblerRecipe(
				new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.cobblestone, 2L),
						GT_OreDictUnificator.get(OrePrefixes.gearGtSmall, Materials.Steel, 1L)},
				Materials.Redstone.getMolten(144L), Blockstack(UtilBlock, 2, 1), 100, 16, false
		);
		RA.addAssemblerRecipe(
				new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.cobblestone, 4L),
						GT_OreDictUnificator.get(OrePrefixes.gearGtSmall, Materials.Aluminium, 1L)},
				Materials.Redstone.getMolten(216L), Blockstack(UtilBlock, 4, 1), 200, 30, false
		);
		RA.addAssemblerRecipe(
				new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.cobblestone, 8L),
						GT_OreDictUnificator.get(OrePrefixes.gearGtSmall, Materials.StainlessSteel, 1L)},
				Materials.Redstone.getMolten(288L), Blockstack(UtilBlock, 8, 1), 300, 30, false
		);
		RA.addAssemblerRecipe(
				new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.cobblestone, 16L),
						GT_OreDictUnificator.get(OrePrefixes.gearGtSmall, Materials.Titanium, 1L)},
				Materials.Redstone.getMolten(576L), Blockstack(UtilBlock, 16, 1), 400, 30, false
		);
		
		RA.addAssemblerRecipe(new ItemStack[]{new ItemStack(Blocks.fence),
						GT_OreDictUnificator.get(OrePrefixes.slab, Materials.Wood, 1)},
				Materials.Redstone.getMolten(72L), CoreItems2.getRecipe(53, 1), 100, 8, false
		);
		RA.addAssemblerRecipe(
				new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Iron, 1L),
						GT_OreDictUnificator.get(OrePrefixes.slab, Materials.Wood, 1)},
				Materials.Redstone.getMolten(72L), CoreItems2.getRecipe(53, 1), 100, 8, false
		);
		RA.addAssemblerRecipe(
				new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Bronze, 1L),
						GT_OreDictUnificator.get(OrePrefixes.slab, Materials.Wood, 1)},
				Materials.Redstone.getMolten(72L), CoreItems2.getRecipe(53, 1), 100, 8, false
		);
		RA.addAssemblerRecipe(
				new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Steel, 1L),
						GT_OreDictUnificator.get(OrePrefixes.slab, Materials.Wood, 2)},
				Materials.Redstone.getMolten(144L), CoreItems2.getRecipe(53, 2), 100, 16, false
		);
		RA.addAssemblerRecipe(
				new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Aluminium, 1L),
						GT_OreDictUnificator.get(OrePrefixes.slab, Materials.Wood, 4)},
				Materials.Redstone.getMolten(216L), CoreItems2.getRecipe(53, 4), 200, 30, false
		);
		RA.addAssemblerRecipe(
				new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.stick, Materials.StainlessSteel, 1L),
						GT_OreDictUnificator.get(OrePrefixes.slab, Materials.Wood, 8)},
				Materials.Redstone.getMolten(288L), CoreItems2.getRecipe(53, 8), 300, 30, false
		);
		RA.addAssemblerRecipe(
				new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Titanium, 1L),
						GT_OreDictUnificator.get(OrePrefixes.slab, Materials.Wood, 16)},
				Materials.Redstone.getMolten(576L), CoreItems2.getRecipe(53, 16), 400, 30, false
		);
		
		RA.addAssemblerRecipe(CoreItems2.getRecipe(53, 1), Blockstack(UtilBlock, 1, 1), null,
				Blockstack(Blocks.piston, 1), 40, 8
		);
		
		RA.addAssemblerRecipe(
				new ItemStack[]{CoreItems2.getRecipe(78, 1), CoreItems2.getRecipe(82, 1)},
				new FluidStack(FluidRegistry.getFluid("ic2coolant"), 2000), CoreItems2.getRecipe(80, 1),
				1000, 480
		);

//Solar parts
		RA.addAssemblerRecipe(new ItemStack[]{CoreItems2.getRecipe(109, 1),
						GT_ModHandler.getModItem("minecraft", "glowstone", 1L),
						GT_OreDictUnificator.get(OrePrefixes.compressed, Materials.Iron, 1),
						GT_OreDictUnificator.get(OrePrefixes.plate, Materials.RedAlloy, 2),
						GT_OreDictUnificator.get(OrePrefixes.screw, Materials.RedAlloy, 4)},
				Materials.SolderingAlloy.getMolten(144), CoreItems2.getRecipe(117, 1), 600, 120
		);
		RA.addAssemblerRecipe(new ItemStack[]{CoreItems2.getRecipe(110, 1),
						GT_OreDictUnificator.get(OrePrefixes.gem, Materials.Diamond, 1),
						GT_OreDictUnificator.get(OrePrefixes.compressed, Materials.MeteoricIron, 1),
						GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Lapis, 2),
						GT_OreDictUnificator.get(OrePrefixes.screw, Materials.RedAlloy, 4)},
				Materials.SolderingAlloy.getMolten(288), CoreItems2.getRecipe(118, 1), 600, 480
		);
		RA.addAssemblerRecipe(new ItemStack[]{CoreItems2.getRecipe(111, 1),
						GT_OreDictUnificator.get(OrePrefixes.gemExquisite, Materials.Ruby, 1),
						GT_ModHandler.getModItem("GalacticraftMars", "item.null", 1L, 5),
						GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Uranium, 2),
						GT_OreDictUnificator.get(OrePrefixes.screw, Materials.RedAlloy, 4)},
				Materials.SolderingAlloy.getMolten(576), CoreItems2.getRecipe(119, 1), 600, 1920
		);
		RA.addAssemblerRecipe(
				new ItemStack[]{CoreItems2.getRecipe(112, 1), CoreItems2.getRecipe(126, 1),
						GT_OreDictUnificator.get(OrePrefixes.compressed, Materials.Naquadah, 1),
						GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Plutonium, 2),
						GT_OreDictUnificator.get(OrePrefixes.screw, Materials.RedAlloy, 4)},
				Materials.SolderingAlloy.getMolten(1152), CoreItems2.getRecipe(120, 1), 600, 7680
		);
		RA.addAssemblerRecipe(
				new ItemStack[]{CoreItems2.getRecipe(113, 1), CoreItems2.getRecipe(127, 1),
						GT_OreDictUnificator.get(OrePrefixes.compressed, Materials.Draconium, 1),
						GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Europium, 2),
						GT_OreDictUnificator.get(OrePrefixes.screw, Materials.RedAlloy, 4)},
				Materials.SolderingAlloy.getMolten(2304), CoreItems2.getRecipe(121, 1), 600, 30720
		);
		RA.addAssemblerRecipe(
				new ItemStack[]{CoreItems2.getRecipe(114, 1), CoreItems2.getRecipe(130, 1),
						CoreItems2.getRecipe(83, 1),
						GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Americium, 2),
						GT_OreDictUnificator.get(OrePrefixes.screw, Materials.RedAlloy, 4)},
				Materials.SolderingAlloy.getMolten(4608), CoreItems2.getRecipe(122, 1), 600, 122880
		);
		RA.addAssemblerRecipe(
				new ItemStack[]{CoreItems2.getRecipe(115, 1), CoreItems2.getRecipe(131, 1),
						GT_OreDictUnificator.get(OrePrefixes.compressed, Materials.Quantium, 1),
						GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Neutronium, 2),
						GT_OreDictUnificator.get(OrePrefixes.screw, Materials.RedAlloy, 4)},
				Materials.SolderingAlloy.getMolten(9216), CoreItems2.getRecipe(123, 1), 600, 500000
		);
		RA.addAssemblerRecipe(
				new ItemStack[]{CoreItems2.getRecipe(116, 1), CoreItems2.getRecipe(132, 1),
						GT_OreDictUnificator.get(OrePrefixes.compressed, Materials.BlackPlutonium, 1),
						GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Phoenixite, 2),
						GT_OreDictUnificator.get(OrePrefixes.screw, Materials.RedAlloy, 4)},
				Materials.SolderingAlloy.getMolten(18432), CoreItems2.getRecipe(124, 1), 600, 2000000
		);
		
		RA.addAssemblerRecipe(
				new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Sunnarium, 4),
						GT_OreDictUnificator.get(OrePrefixes.plateAlloy, Materials.Iridium, 8)}, null,
				CoreItems2.getRecipe(127, 1), 800, 30720
		);
		RA.addAssemblerRecipe(
				new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Uranium, 1),
						GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Glowstone, 4)}, null,
				CoreItems2.getRecipe(128, 1), 600, 1920
		);
		RA.addAssemblerRecipe(
				new ItemStack[]{CoreItems2.getRecipe(126, 1), CoreItems2.getRecipe(128, 8)}, null,
				CoreItems2.getRecipe(129, 1), 1200, 7680
		);
		RA.addAssemblerRecipe(
				new ItemStack[]{CoreItems2.getRecipe(127, 1), CoreItems2.getRecipe(129, 8)}, null,
				CoreItems2.getRecipe(130, 1), 1600, 122880
		);
		RA.addAssemblerRecipe(new ItemStack[]{CoreItems2.getRecipe(130, 1),
						GT_OreDictUnificator.get(OrePrefixes.plateDense, Materials.Naquadria, 8)}, null,
				CoreItems2.getRecipe(131, 1), 1800, 500000
		);
		RA.addAssemblerRecipe(new ItemStack[]{CoreItems2.getRecipe(131, 1),
						GT_OreDictUnificator.get(OrePrefixes.plateDense, Materials.Neutronium, 8)},
				Materials.ElectrumFlux.getMolten(1152), CoreItems2.getRecipe(132, 1), 2000, 2000000
		);
		
		RA
				.addAssemblerRecipe(ItemList.Cover_SolarPanel.get(8L), GT_Utility.getIntegratedCircuit(8),
						ItemList.Cover_SolarPanel_8V.get(1L), 100, 6
				);
		RA.addAssemblerRecipe(ItemList.Cover_SolarPanel_8V.get(6L),
				GT_Utility.getIntegratedCircuit(6), ItemList.Cover_SolarPanel_LV.get(1L), 120, 12
		);
		RA.addAssemblerRecipe(ItemList.Cover_SolarPanel_LV.get(6L),
				GT_Utility.getIntegratedCircuit(6), ItemList.Cover_SolarPanel_MV.get(1L), 140, 24
		);
		RA.addAssemblerRecipe(ItemList.Cover_SolarPanel_MV.get(6L),
				GT_Utility.getIntegratedCircuit(6), ItemList.Cover_SolarPanel_HV.get(1L), 160, 48
		);
		RA.addAssemblerRecipe(ItemList.Cover_SolarPanel_HV.get(6L),
				GT_Utility.getIntegratedCircuit(6), ItemList.Cover_SolarPanel_EV.get(1L), 180, 96
		);
		RA.addAssemblerRecipe(ItemList.Cover_SolarPanel_EV.get(6L),
				GT_Utility.getIntegratedCircuit(6), ItemList.Cover_SolarPanel_IV.get(1L), 200, 192
		);
		RA.addAssemblerRecipe(ItemList.Cover_SolarPanel_IV.get(6L),
				GT_Utility.getIntegratedCircuit(6), ItemList.Cover_SolarPanel_LuV.get(1L), 220, 384
		);
		RA.addAssemblerRecipe(ItemList.Cover_SolarPanel_LuV.get(6L),
				GT_Utility.getIntegratedCircuit(6), ItemList.Cover_SolarPanel_ZPM.get(1L), 240, 768
		);
		RA.addAssemblerRecipe(ItemList.Cover_SolarPanel_ZPM.get(6L),
				GT_Utility.getIntegratedCircuit(6), ItemList.Cover_SolarPanel_UV.get(1L), 260, 1536
		);
//Space parts
		RA.addAssemblerRecipe(
				new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.compressed, Materials.Steel, 1),
						CoreItems2.getRecipe(175, 1), CoreItems2.getRecipe(176, 1)},
				Materials.StainlessSteel.getMolten(72), CoreItems2.getRecipe(97, 1), 200, 256
		);
		RA.addAssemblerRecipe(
				new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.compressed, Materials.Bronze, 1),
						GT_OreDictUnificator.get(OrePrefixes.compressed, Materials.Aluminium, 1),
						GT_OreDictUnificator.get(OrePrefixes.compressed, Materials.Steel, 1),
						GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.HSLA, 8)},
				Materials.StainlessSteel.getMolten(288), ItemList.Ingot_Heavy1.get(1L), 200, 256
		);
		RA.addAssemblerRecipe(
				new ItemStack[]{GT_ModHandler.getModItem("GalacticraftCore", "item.heavyPlating", 1L),
						GT_ModHandler.getModItem("GalaxySpace", "item.CompressedPlates", 1L, 4),
						CoreItems2.getRecipe(93, 1),
						GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.HSSG, 8)},
				Materials.Titanium.getMolten(288), ItemList.Ingot_Heavy2.get(1L), 300, 1024
		);
		RA.addAssemblerRecipe(
				new ItemStack[]{GT_ModHandler.getModItem("GalacticraftMars", "item.null", 1L, 3),
						CoreItems2.getRecipe(90, 1), CoreItems2.getRecipe(96, 1),
						GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Inconel690, 8)},
				Materials.TungstenSteel.getMolten(288), ItemList.Ingot_Heavy3.get(1L), 400, 4096
		);
		RA.addAssemblerRecipe(
				new ItemStack[]{GT_ModHandler.getModItem("GalacticraftMars", "item.itemBasicAsteroids", 1L),
						CoreItems2.getRecipe(84, 1), CoreItems2.getRecipe(92, 1),
						GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.HastelloyN, 8)},
				Materials.Chrome.getMolten(288), CoreItems2.getRecipe(16, 1), 500, 16384
		);
		RA.addAssemblerRecipe(
				new ItemStack[]{CoreItems2.getRecipe(11, 1), CoreItems2.getRecipe(86, 1),
						CoreItems2.getRecipe(91, 1),
						GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Lafium, 10)},
				Materials.Iridium.getMolten(288), CoreItems2.getRecipe(17, 1), 600, 65536
		);
		RA.addAssemblerRecipe(
				new ItemStack[]{CoreItems2.getRecipe(12, 1), CoreItems2.getRecipe(89, 1),
						CoreItems2.getRecipe(94, 1),
						GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.CinobiteA243, 12)},
				Materials.Osmium.getMolten(288), CoreItems2.getRecipe(18, 1), 700, 262144
		);
		RA.addAssemblerRecipe(
				new ItemStack[]{CoreItems2.getRecipe(13, 1), CoreItems2.getRecipe(79, 1),
						CoreItems2.getRecipe(95, 1),
						GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Pikyonium64B, 14)},
				Materials.Neutronium.getMolten(288), CoreItems2.getRecipe(19, 1), 800, 1048576
		);
		RA.addAssemblerRecipe(
				new ItemStack[]{CoreItems2.getRecipe(14, 1), CoreItems2.getRecipe(77, 1),
						CoreItems2.getRecipe(174, 1),
						GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Quantum, 16)},
				Materials.Phoenixite.getMolten(288), CoreItems2.getRecipe(20, 1), 900, 4194304
		);
		RA.addAssemblerRecipe(
				new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Molybdenum, 1),
						GT_OreDictUnificator.get(OrePrefixes.plateTriple, Materials.Iridium, 1),
						GT_OreDictUnificator.get(OrePrefixes.plateAlloy, Materials.Advanced, 4),
						GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Diamond, 2)},
				Materials.Titanium.getMolten(144), ItemList.Ingot_IridiumAlloy.get(1L), 200, 256
		);
		RA.addAssemblerRecipe(
				new ItemStack[]{GT_ModHandler.getModItem("GalaxySpace", "item.CompressedPlates", 1L, 2),
						CoreItems2.getRecipe(171, 1), CoreItems2.getRecipe(172, 1)},
				Materials.Duranium.getMolten(288L), CoreItems2.getRecipe(88, 1), 600, 1920
		);
		RA.addAssemblerRecipe(
				new ItemStack[]{CoreItems2.getRecipe(88, 1), CoreItems2.getRecipe(173, 1),
						CoreItems2.getRecipe(87, 1)}, Materials.Tritanium.getMolten(288L),
				CoreItems2.getRecipe(89, 1), 1200, 7680
		);
		
		RA.addAssemblerRecipe(new ItemStack[]{GT_ItemList.packEarth.get(64L)},
				Materials.HSLA.getMolten(288), GT_ItemList.spacebox1.get(1L), 1200, 64
		);
		RA.addAssemblerRecipe(new ItemStack[]{GT_ItemList.packMoon.get(64L)},
				Materials.BT6.getMolten(288), GT_ItemList.spacebox2.get(1L), 1200, 256
		);
		RA.addAssemblerRecipe(
				new ItemStack[]{GT_ItemList.packMars.get(64L), GT_ItemList.packDeimos.get(64L),
						GT_ItemList.packPhobos.get(64L)}, Materials.HastelloyC276.getMolten(288),
				GT_ItemList.spacebox3.get(1L), 1200, 1024
		);
		RA.addAssemblerRecipe(
				new ItemStack[]{GT_ItemList.packAsteroids.get(64L), GT_ItemList.packCeres.get(64L),
						GT_ItemList.packEuropa.get(64L), GT_ItemList.packGanymed.get(64L)},
				Materials.HastelloyN.getMolten(288), GT_ItemList.spacebox4.get(1L), 1200, 4096
		);
		RA.addAssemblerRecipe(
				new ItemStack[]{GT_ItemList.packMercury.get(64L),
						GT_ItemList.packVenus.get(64L)}, Materials.Lafium.getMolten(288),
				GT_ItemList.spacebox5.get(1L), 1200, 16384
		);
		RA.addAssemblerRecipe(
				new ItemStack[]{GT_ItemList.packIapetus.get(64L), GT_ItemList.packTitan.get(64L),
						GT_ItemList.packEris.get(64L), GT_ItemList.packOberon.get(64L)},
				Materials.CinobiteA243.getMolten(288), GT_ItemList.spacebox6.get(1L), 1200, 65536
		);
		RA.addAssemblerRecipe(
				new ItemStack[]{GT_ItemList.packProteus.get(64L), GT_ItemList.packTriton.get(64L)},
				Materials.Pikyonium64B.getMolten(288), GT_ItemList.spacebox7.get(1L), 1200, 262144
		);
		RA.addAssemblerRecipe(
				new ItemStack[]{GT_ItemList.packPluto.get(64L), GT_ItemList.packHaumea.get(64L),
						GT_ItemList.packMakeMake.get(64L)}, Materials.Quantum.getMolten(288),
				GT_ItemList.spacebox8.get(1L), 1200, 1048576
		);
//Casings
		//LuV
		RA.addAssemblerRecipe(
				new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.HastelloyN, 1),
						GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Chrome, 4),
						GT_OreDictUnificator.get(OrePrefixes.plate, Materials.HastelloyN, 6),
						GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Chrome, 4),
						GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.HastelloyN, 4),
						GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.HSSG, 4),
						GT_OreDictUnificator.get(OrePrefixes.screw, Materials.HSSE, 4)}, null,
				ItemList.Casing_LuV.get(1L), 200, 7680
		);
		
		//ZPM
		RA.addAssemblerRecipe(
				new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Lafium, 1),
						GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Iridium, 6),
						GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Lafium, 8),
						GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Iridium, 8),
						GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Lafium, 4),
						GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.HSSG, 8),
						GT_OreDictUnificator.get(OrePrefixes.screw, Materials.HSSE, 8)}, null,
				ItemList.Casing_ZPM.get(1L), 400, 30720
		);
		
		//UV
		RA.addAssemblerRecipe(
				new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.CinobiteA243, 1),
						GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Osmium, 8),
						GT_OreDictUnificator.get(OrePrefixes.plate, Materials.CinobiteA243, 12),
						GT_OreDictUnificator.get(OrePrefixes.stickLong, Materials.Osmium, 12),
						GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.CinobiteA243, 6),
						GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.HSSG, 12),
						GT_OreDictUnificator.get(OrePrefixes.screw, Materials.HSSE, 12)}, null,
				ItemList.Casing_UV.get(1L), 600, 122880
		);
		
		//UHV
		RA.addAssemblerRecipe(
				new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Pikyonium64B, 1),
						GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Neutronium, 10),
						GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Pikyonium64B, 16),
						GT_OreDictUnificator.get(OrePrefixes.stickLong, Materials.Neutronium, 16),
						GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Pikyonium64B, 8),
						GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.HSSG, 16),
						GT_OreDictUnificator.get(OrePrefixes.screw, Materials.HSSE, 16)}, null,
				ItemList.Casing_MAX.get(1L), 800, 500000
		);
		
		//UEV
		RA.addAssemblerRecipe(
				new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Quantum, 1),
						GT_OreDictUnificator.get(OrePrefixes.plateTriple, Materials.Phoenixite, 12),
						GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Quantum, 20),
						GT_OreDictUnificator.get(OrePrefixes.stickLong, Materials.Phoenixite, 20),
						GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Quantum, 10),
						GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.HSSG, 24),
						GT_OreDictUnificator.get(OrePrefixes.screw, Materials.HSSE, 24)}, null,
				ItemList.Casing_UEV.get(1L), 1000, 2000000
		);
		
		//Lapotron Casing
		RA.addAssemblerRecipe(
				new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Inconel792, 1),
						GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Iridium, 6),
						GT_OreDictUnificator.get(OrePrefixes.foil, Materials.NiobiumTitanium, 12),
						GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Palladium, 16),
						GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.HastelloyC276, 16),
						GT_OreDictUnificator.get(OrePrefixes.screw, Materials.HSSE, 16)}, null,
				GT_ItemList.LSCC.get(1L), 600, 7680
		);
		
		//Space Satellite Casing
		RA.addAssemblerRecipe(
				new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.StainlessSteel, 1),
						GT_OreDictUnificator.get(OrePrefixes.plate, Materials.HSLA, 6),
						GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.RedSteel, 8)}, null,
				GT_ItemList.Space_Satellite_Casing.get(2L), 100, 120
		);
		
		//Tower Casing
		RA.addAssemblerRecipe(
				new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.StainlessSteel, 1),
						GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Ultimet, 6),
						GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.RedSteel, 8)}, null,
				GT_ItemList.Tower_Casing.get(2L), 100, 120
		);
		
		//Computer Casing
		RA.addAssemblerRecipe(
				new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Zamak, 1),
						GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.MaragingSteel300, 6),
						GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Data, 1),
						GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Cobalt, 16),
						GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 16),
						GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.HSSG, 16)}, Materials.HSSE.getMolten(288),
				GT_ItemList.Computer_Casing.get(2L), 200, 1920
		);
		
		//Vent Casing
		RA.addAssemblerRecipe(
				new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.StainlessSteel, 1),
						GT_OreDictUnificator.get(OrePrefixes.plate, Materials.MaragingSteel300, 6),
						GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.RedSteel, 8)}, null,
				new ItemStack(InsideBlock, 2, 2), 100, 120
		);
		
		//Space Elevator Casing
		RA.addAssemblerRecipe(
				new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.HSLA, 1),
						GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Vanadium, 6),
						GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.BlueSteel, 8)}, null,
				GT_ItemList.SpaceElevatorCasing.get(2L), 100, 120
		);
		
		RA
				.addAssemblerRecipe(new ItemStack[]{CoreItems2.getRecipe(QuantumPartHelmet.getMetaID(), 1),
								CoreItems2.getRecipe(QuantumCrystal.getMetaID(), 1),
								GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Master, 2),
								GT_OreDictUnificator.get(OrePrefixes.wireGt04, Materials.TungstenSteel, 4),
								ItemList.Energy_LapotronicOrb.get(1L),
								ItemList.Sensor_IV.get(1L),
								ItemList.Field_Generator_EV.get(1L),
								GT_OreDictUnificator.get(OrePrefixes.screw, Materials.TungstenSteel, 4),
								GT_Utility.getIntegratedCircuit(10)},
						Materials.Titanium.getMolten(1728L),
						GT_ModHandler.getIC2Item("quantumHelmet", 1L, 26), 1500, 7680
				);
		
		RA.addAssemblerRecipe(
				new ItemStack[]{CoreItems2.getRecipe(QuantumPartChestplate.getMetaID(), 1),
						CoreItems2.getRecipe(QuantumCrystal.getMetaID(), 1),
						GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Master, 2),
						GT_OreDictUnificator.get(OrePrefixes.wireGt04, Materials.TungstenSteel, 6),
						ItemList.Energy_LapotronicOrb.get(1L),
						ItemList.Field_Generator_EV.get(3L),
						ItemList.Electric_Motor_IV.get(2L),
						GT_OreDictUnificator.get(OrePrefixes.screw, Materials.TungstenSteel, 4),
						GT_Utility.getIntegratedCircuit(11)},
				Materials.Titanium.getMolten(2880L),
				GT_ModHandler.getIC2Item("quantumBodyarmor", 1L, 26), 1500, 7680
		);
		
		RA.addAssemblerRecipe(
				new ItemStack[]{CoreItems2.getRecipe(QuantumPartLeggings.getMetaID(), 1),
						CoreItems2.getRecipe(QuantumCrystal.getMetaID(), 1),
						GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Master, 2),
						GT_OreDictUnificator.get(OrePrefixes.wireGt04, Materials.TungstenSteel, 6),
						ItemList.Energy_LapotronicOrb.get(1L),
						ItemList.Field_Generator_EV.get(2L),
						ItemList.Electric_Motor_IV.get(4L),
						GT_OreDictUnificator.get(OrePrefixes.screw, Materials.TungstenSteel, 4),
						GT_Utility.getIntegratedCircuit(12)},
				Materials.Titanium.getMolten(2304L),
				GT_ModHandler.getIC2Item("quantumLeggings", 1L, 26), 1500, 7680
		);
		
		RA
				.addAssemblerRecipe(new ItemStack[]{CoreItems2.getRecipe(QuantumPartBoots.getMetaID(), 1),
								CoreItems2.getRecipe(QuantumCrystal.getMetaID(), 1),
								GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Master, 2),
								GT_OreDictUnificator.get(OrePrefixes.wireGt04, Materials.TungstenSteel, 4),
								ItemList.Energy_LapotronicOrb.get(1L),
								ItemList.Field_Generator_EV.get(1L),
								ItemList.Electric_Piston_IV.get(2L),
								GT_OreDictUnificator.get(OrePrefixes.screw, Materials.TungstenSteel, 4),
								GT_Utility.getIntegratedCircuit(12)},
						Materials.Titanium.getMolten(1440L),
						GT_ModHandler.getIC2Item("quantumBoots", 1L, 26), 1500, 7680
				);
		/*====END QUANTUM SUITE====*/
		
		RA.addAssemblerRecipe(
				new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.block, Materials.Glass, 1),
						GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Tin, 4L),
						GT_Utility.getIntegratedCircuit(1)}, GT_Values.NF, CoreItems2.getRecipe(143, 1), 100,
				30
		);
		RA.addAssemblerRecipe(
				CoreItems2.getRecipe(143, 3), GT_Utility.getIntegratedCircuit(3),
				CoreItems2.getRecipe(144, 1), 300, 60);
		RA.addAssemblerRecipe(
				CoreItems2.getRecipe(144, 2), GT_Utility.getIntegratedCircuit(2),
				CoreItems2.getRecipe(145, 1), 600, 90);
		
		RA.addAssemblerRecipe(
				GT_OreDictUnificator.get(OrePrefixes.plateAlloy, Materials.Carbon, 5),
				GT_Utility.getIntegratedCircuit(5), CoreItems2.getRecipe(136, 1), 500, 120);
		RA.addAssemblerRecipe(
				GT_OreDictUnificator.get(OrePrefixes.plateAlloy, Materials.Carbon, 8),
				GT_Utility.getIntegratedCircuit(8), CoreItems2.getRecipe(138, 1), 800, 120);
		RA.addAssemblerRecipe(
				GT_OreDictUnificator.get(OrePrefixes.plateAlloy, Materials.Carbon, 7),
				GT_Utility.getIntegratedCircuit(7), CoreItems2.getRecipe(139, 1), 700, 120);
		RA.addAssemblerRecipe(
				GT_OreDictUnificator.get(OrePrefixes.plateAlloy, Materials.Carbon, 4),
				GT_Utility.getIntegratedCircuit(4), CoreItems2.getRecipe(140, 1), 400, 120);
		RA.addAssemblerRecipe(
				CoreItems2.getRecipe(136, 1),
				GT_ModHandler.getModItem("IC2", "itemNightvisionGoggles", 1L, GT_Values.W),
				CoreItems2.getRecipe(137, 1), 600, 256);
		
		// --- Long Distance Pipeline
		RA.addAssemblerRecipe(
				new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.pipeHuge, Materials.Steel, 2L),
						GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Steel, 6L),
						GT_OreDictUnificator.get(OrePrefixes.gear, Materials.Steel, 2L),
						GT_Utility.getIntegratedCircuit(2)}, Materials.Tin.getMolten(144L),
				GT_ItemList.Long_Distance_Pipeline_Fluid.get(2L), 300, 16
		);
		RA.addAssemblerRecipe(
				new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.pipeHuge, Materials.Tin, 2L),
						GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Steel, 6L),
						GT_OreDictUnificator.get(OrePrefixes.gear, Materials.Steel, 2L),
						GT_Utility.getIntegratedCircuit(2)}, Materials.Tin.getMolten(144L),
				GT_ItemList.Long_Distance_Pipeline_Item.get(2L), 300, 16
		);
		RA.addAssemblerRecipe(
				new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.pipeLarge, Materials.Steel, 2L),
						GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Steel, 9L),
						GT_Utility.getIntegratedCircuit(24)}, Materials.Tin.getMolten(144L),
				GT_ItemList.Long_Distance_Pipeline_Fluid_Pipe.get(64L), 600, 24
		);
		RA.addAssemblerRecipe(
				new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.pipeLarge, Materials.Tin, 2L),
						GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Steel, 9L),
						GT_Utility.getIntegratedCircuit(24)}, Materials.Tin.getMolten(144L),
				GT_ItemList.Long_Distance_Pipeline_Item_Pipe.get(64L), 600, 24
		);
		RA.addAssemblerRecipe(
				new ItemStack[]{ItemList.Hull_LV.get(1), ItemList.LV_Coil.get(1),
						GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Steel, 1L),
						GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Basic, 2L),
						GT_OreDictUnificator.get(OrePrefixes.cableGt04, Materials.Tin, 3L),
						GT_Utility.getIntegratedCircuit(2)}, null,
				GT_ItemList.LDPE_LV.get(2L), 150, 16
		);
		RA.addAssemblerRecipe(
				new ItemStack[]{ItemList.Hull_MV.get(1), ItemList.MV_Coil.get(1),
						GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Birmabright, 1L),
						GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Good, 2L),
						GT_OreDictUnificator.get(OrePrefixes.cableGt04, Materials.Copper, 3L),
						GT_Utility.getIntegratedCircuit(2)}, null,
				GT_ItemList.LDPE_MV.get(2L), 150, 64
		);
		RA.addAssemblerRecipe(
				new ItemStack[]{ItemList.Hull_HV.get(1), ItemList.HV_Coil.get(1),
						GT_OreDictUnificator.get(OrePrefixes.plate, Materials.StainlessSteel, 1L),
						GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Advanced, 2L),
						GT_OreDictUnificator.get(OrePrefixes.cableGt04, Materials.Gold, 3L),
						GT_Utility.getIntegratedCircuit(2)}, null,
				GT_ItemList.LDPE_HV.get(2L), 150, 256
		);
		RA.addAssemblerRecipe(
				new ItemStack[]{ItemList.Hull_EV.get(1), ItemList.EV_Coil.get(1),
						GT_OreDictUnificator.get(OrePrefixes.plate, Materials.BT6, 1L),
						GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Data, 2L),
						GT_OreDictUnificator.get(OrePrefixes.cableGt04, Materials.Aluminium, 3L),
						GT_Utility.getIntegratedCircuit(2)}, null,
				GT_ItemList.LDPE_EV.get(2L), 150, 1024
		);
		RA.addAssemblerRecipe(
				new ItemStack[]{ItemList.Hull_IV.get(1), ItemList.IV_Coil.get(1),
						GT_OreDictUnificator.get(OrePrefixes.plate, Materials.HastelloyC276, 1L),
						GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Elite, 2L),
						GT_OreDictUnificator.get(OrePrefixes.cableGt04, Materials.Platinum, 3L),
						GT_Utility.getIntegratedCircuit(2)}, null,
				GT_ItemList.LDPE_IV.get(2L), 150, 4096
		);
		
		// --- Electromagnetic Chamber
		RA.addAssemblerRecipe(
				new ItemStack[]{ItemList.Block_Magnetic_Coil.get(1),
						GT_ModHandler.getModItem("IC2", "blockAlloyGlass", 1L, 0),
						GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Trinium, 8),
						GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.TungstenSteel, 20),
						GT_OreDictUnificator.get(OrePrefixes.screw, Materials.TungstenSteel, 20),
						ItemList.Field_Generator_IV.get(1L)}, null, new ItemStack(InsideBlock, 1, 5), 400, 122880);
		
		// --- Large Screen
		RA.addAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem("minecraft", "glass_pane", 1L),
						GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Basic, 1),
						GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Cobalt, 4),
						GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Silicon, 8)}, null,
				Itemstack(Core_Items2.getInstance(), 1, 182), 200, 8
		);
		
		// --- NaquadahE Nuclear Fuel
		RA.addAssemblerRecipe(
				CoreItems2.getRecipe(183, 6),
				CoreItems2.getRecipe(185, 3),
				Materials.SuperCoolant.getFluid(1000L),
				CoreItems2.getRecipe(186, 1), 500, 1920
		);
		// --- Naquadah Nuclear Fuel
		RA.addAssemblerRecipe(
				CoreItems2.getRecipe(183, 6),
				GT_OreDictUnificator.get(OrePrefixes.nugget, Materials.Plutonium241, 3),
				Materials.SuperCoolant.getFluid(1000L),
				CoreItems2.getRecipe(184, 1), 500, 1024
		);
		
		// --- Thorium Nuclear Fuel
		RA.addAssemblerRecipe(
				GT_ModHandler.getModItem("IC2", "itemUran238", 6L),
				CoreItems2.getRecipe(187, 3),
				new FluidStack(FluidRegistry.getFluid("ic2coolant"), 1000),
				CoreItems2.getRecipe(188, 1), 400, 120
		);
		// --- MOX Thorium Fuel
		RA.addAssemblerRecipe(
				CoreItems2.getRecipe(187, 6),
				GT_ModHandler.getModItem("IC2", "itemPlutonium", 3L),
				new FluidStack(FluidRegistry.getFluid("ic2coolant"), 1000),
				CoreItems2.getRecipe(189, 1), 400, 256
		);
		
		// --- Input Item/Fluid Bus
		RA.addAssemblerRecipe(
				new ItemStack[]{ItemList.Hatch_Input_Bus_HV.get(1),
						ItemList.Large_Fluid_Cell_Aluminium.get(1),
						GT_Utility.getIntegratedCircuit(1)}, null,
				GT_ItemList.BusHatch_Input.get(1L), 480, 480
		);

		//Laser Dynamo IV-UV 256/t
		RA.addAssemblerRecipe(new ItemStack[]{ItemList.Hull_IV.get(1), CoreItems2.getRecipe(198, 1), ItemList.Emitter_IV.get(1), ItemList.Electric_Pump_IV.get(1), GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.TungstenSteel, 2), GT_Utility.getIntegratedCircuit(1)}, null, GT_ItemList.DynamoTunnel1_IV.get(1L), 1000, 7680);
		RA.addAssemblerRecipe(new ItemStack[]{ItemList.Hull_LuV.get(1), CoreItems2.getRecipe(198, 1), ItemList.Emitter_LuV.get(1), ItemList.Electric_Pump_LuV.get(1), GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.VanadiumGallium, 2), GT_Utility.getIntegratedCircuit(1)}, null, GT_ItemList.DynamoTunnel1_LuV.get(1L), 1000, 30720);
		RA.addAssemblerRecipe(new ItemStack[]{ItemList.Hull_ZPM.get(1), CoreItems2.getRecipe(199, 1), ItemList.Emitter_ZPM.get(1), ItemList.Electric_Pump_ZPM.get(1), GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.Naquadah, 2), GT_Utility.getIntegratedCircuit(1)}, null, GT_ItemList.DynamoTunnel1_ZPM.get(1L), 1000, 122880);
		RA.addAssemblerRecipe(new ItemStack[]{ItemList.Hull_UV.get(1), CoreItems2.getRecipe(199, 1), ItemList.Emitter_UV.get(1), ItemList.Electric_Pump_UV.get(1), GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.NaquadahAlloy, 2), GT_Utility.getIntegratedCircuit(1)}, null, GT_ItemList.DynamoTunnel1_UV.get(1L), 1000, 500000);
		RA.addAssemblerRecipe(new ItemStack[]{ItemList.Hull_MAX.get(1), CoreItems2.getRecipe(200, 1), ItemList.Emitter_UHV.get(1), ItemList.Electric_Pump_UHV.get(1), GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.Europium, 2), GT_Utility.getIntegratedCircuit(1)}, null, GT_ItemList.DynamoTunnel1_UHV.get(1), 1000, 2000000);
		RA.addAssemblerRecipe(new ItemStack[]{ItemList.Hull_UEV.get(1), CoreItems2.getRecipe(200, 1), ItemList.Emitter_UEV.get(1), ItemList.Electric_Pump_UEV.get(1), GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.Diamericiumtitanium, 2), GT_Utility.getIntegratedCircuit(1)}, null, GT_ItemList.DynamoTunnel1_UEV.get(1), 1000, 8000000);

		//Laser Dynamo IV-UV 1024/t
		RA.addAssemblerRecipe(new ItemStack[]{ItemList.Hull_IV.get(1), CoreItems2.getRecipe(198, 2), ItemList.Emitter_IV.get(2), ItemList.Electric_Pump_IV.get(2), GT_OreDictUnificator.get(OrePrefixes.wireGt02, Materials.TungstenSteel, 4), GT_Utility.getIntegratedCircuit(2)}, null, GT_ItemList.DynamoTunnel2_IV.get(1L), 2000, 7680);
		RA.addAssemblerRecipe(new ItemStack[]{ItemList.Hull_LuV.get(1), CoreItems2.getRecipe(198, 2), ItemList.Emitter_LuV.get(2), ItemList.Electric_Pump_LuV.get(2), GT_OreDictUnificator.get(OrePrefixes.wireGt02, Materials.VanadiumGallium, 4), GT_Utility.getIntegratedCircuit(2)}, null, GT_ItemList.DynamoTunnel2_LuV.get(1), 2000, 30720);
		RA.addAssemblerRecipe(new ItemStack[]{ItemList.Hull_ZPM.get(1), CoreItems2.getRecipe(199, 2), ItemList.Emitter_ZPM.get(2), ItemList.Electric_Pump_ZPM.get(2), GT_OreDictUnificator.get(OrePrefixes.wireGt02, Materials.Naquadah, 4), GT_Utility.getIntegratedCircuit(2)}, null, GT_ItemList.DynamoTunnel2_ZPM.get(1), 2000, 122880);
		RA.addAssemblerRecipe(new ItemStack[]{ItemList.Hull_UV.get(1), CoreItems2.getRecipe(199, 2), ItemList.Emitter_UV.get(2), ItemList.Electric_Pump_UV.get(2), GT_OreDictUnificator.get(OrePrefixes.wireGt02, Materials.NaquadahAlloy, 4), GT_Utility.getIntegratedCircuit(2)}, null, GT_ItemList.DynamoTunnel2_UV.get(1), 2000, 500000);
		RA.addAssemblerRecipe(new ItemStack[]{ItemList.Hull_MAX.get(1), CoreItems2.getRecipe(200, 2), ItemList.Emitter_UHV.get(2), ItemList.Electric_Pump_UHV.get(2), GT_OreDictUnificator.get(OrePrefixes.wireGt02, Materials.Europium, 4), GT_Utility.getIntegratedCircuit(2)}, null, GT_ItemList.DynamoTunnel2_UHV.get(1), 2000, 2000000);
		RA.addAssemblerRecipe(new ItemStack[]{ItemList.Hull_UEV.get(1), CoreItems2.getRecipe(200, 2), ItemList.Emitter_UEV.get(2), ItemList.Electric_Pump_UEV.get(2), GT_OreDictUnificator.get(OrePrefixes.wireGt02, Materials.Diamericiumtitanium, 4), GT_Utility.getIntegratedCircuit(2)}, null, GT_ItemList.DynamoTunnel2_UEV.get(1), 2000, 8000000);

		//Laser Dynamo IV-UV 4096/t
		RA.addAssemblerRecipe(new ItemStack[]{ItemList.Hull_IV.get(1), CoreItems2.getRecipe(198, 4), ItemList.Emitter_IV.get(4), ItemList.Electric_Pump_IV.get(4), GT_OreDictUnificator.get(OrePrefixes.wireGt04, Materials.TungstenSteel, 4), GT_Utility.getIntegratedCircuit(3)}, null, GT_ItemList.DynamoTunnel3_IV.get(1L), 4000, 7680);
		RA.addAssemblerRecipe(new ItemStack[]{ItemList.Hull_LuV.get(1), CoreItems2.getRecipe(198, 4), ItemList.Emitter_LuV.get(4), ItemList.Electric_Pump_LuV.get(4), GT_OreDictUnificator.get(OrePrefixes.wireGt04, Materials.VanadiumGallium, 4), GT_Utility.getIntegratedCircuit(3)}, null, GT_ItemList.DynamoTunnel3_LuV.get(1), 4000, 30720);
		RA.addAssemblerRecipe(new ItemStack[]{ItemList.Hull_ZPM.get(1), CoreItems2.getRecipe(199, 4), ItemList.Emitter_ZPM.get(4), ItemList.Electric_Pump_ZPM.get(4), GT_OreDictUnificator.get(OrePrefixes.wireGt04, Materials.Naquadah, 4), GT_Utility.getIntegratedCircuit(3)}, null, GT_ItemList.DynamoTunnel3_ZPM.get(1), 4000, 122880);
		RA.addAssemblerRecipe(new ItemStack[]{ItemList.Hull_UV.get(1), CoreItems2.getRecipe(199, 4), ItemList.Emitter_UV.get(4), ItemList.Electric_Pump_UV.get(4), GT_OreDictUnificator.get(OrePrefixes.wireGt04, Materials.NaquadahAlloy, 4), GT_Utility.getIntegratedCircuit(3)}, null, GT_ItemList.DynamoTunnel3_UV.get(1), 4000, 500000);
		RA.addAssemblerRecipe(new ItemStack[]{ItemList.Hull_MAX.get(1), CoreItems2.getRecipe(200, 4), ItemList.Emitter_UHV.get(4), ItemList.Electric_Pump_UHV.get(4), GT_OreDictUnificator.get(OrePrefixes.wireGt04, Materials.Europium, 4), GT_Utility.getIntegratedCircuit(3)}, null, GT_ItemList.DynamoTunnel3_UHV.get(1), 4000, 2000000);
		RA.addAssemblerRecipe(new ItemStack[]{ItemList.Hull_UEV.get(1), CoreItems2.getRecipe(200, 4), ItemList.Emitter_UEV.get(4), ItemList.Electric_Pump_UEV.get(4), GT_OreDictUnificator.get(OrePrefixes.wireGt04, Materials.Diamericiumtitanium, 4), GT_Utility.getIntegratedCircuit(3)}, null, GT_ItemList.DynamoTunnel3_UEV.get(1), 4000, 8000000);

		//Laser Dynamo IV-UV 16384/t
		RA.addAssemblerRecipe(new ItemStack[]{ItemList.Hull_IV.get(1), CoreItems2.getRecipe(198, 8), ItemList.Emitter_IV.get(8), ItemList.Electric_Pump_IV.get(8), GT_OreDictUnificator.get(OrePrefixes.wireGt04, Materials.TungstenSteel, 8), GT_Utility.getIntegratedCircuit(4)}, null, GT_ItemList.DynamoTunnel4_IV.get(1L), 8000, 7680);
		RA.addAssemblerRecipe(new ItemStack[]{ItemList.Hull_LuV.get(1), CoreItems2.getRecipe(198, 8), ItemList.Emitter_LuV.get(8), ItemList.Electric_Pump_LuV.get(8), GT_OreDictUnificator.get(OrePrefixes.wireGt04, Materials.VanadiumGallium, 8), GT_Utility.getIntegratedCircuit(4)}, null, GT_ItemList.DynamoTunnel4_LuV.get(1), 8000, 30720);
		RA.addAssemblerRecipe(new ItemStack[]{ItemList.Hull_ZPM.get(1), CoreItems2.getRecipe(199, 8), ItemList.Emitter_ZPM.get(8), ItemList.Electric_Pump_ZPM.get(8), GT_OreDictUnificator.get(OrePrefixes.wireGt04, Materials.Naquadah, 8), GT_Utility.getIntegratedCircuit(4)}, null, GT_ItemList.DynamoTunnel4_ZPM.get(1), 8000, 122880);
		RA.addAssemblerRecipe(new ItemStack[]{ItemList.Hull_UV.get(1), CoreItems2.getRecipe(199, 8), ItemList.Emitter_UV.get(8), ItemList.Electric_Pump_UV.get(8), GT_OreDictUnificator.get(OrePrefixes.wireGt04, Materials.NaquadahAlloy, 8), GT_Utility.getIntegratedCircuit(4)}, null, GT_ItemList.DynamoTunnel4_UV.get(1), 8000, 500000);
		RA.addAssemblerRecipe(new ItemStack[]{ItemList.Hull_MAX.get(1), CoreItems2.getRecipe(200, 8), ItemList.Emitter_UHV.get(8), ItemList.Electric_Pump_UHV.get(8), GT_OreDictUnificator.get(OrePrefixes.wireGt04, Materials.Europium, 8), GT_Utility.getIntegratedCircuit(4)}, null, GT_ItemList.DynamoTunnel4_UHV.get(1), 8000, 2000000);
		RA.addAssemblerRecipe(new ItemStack[]{ItemList.Hull_UEV.get(1), CoreItems2.getRecipe(200, 8), ItemList.Emitter_UEV.get(8), ItemList.Electric_Pump_UEV.get(8), GT_OreDictUnificator.get(OrePrefixes.wireGt04, Materials.Diamericiumtitanium, 8), GT_Utility.getIntegratedCircuit(4)}, null, GT_ItemList.DynamoTunnel4_UEV.get(1), 8000, 8000000);

		//Laser Dynamo IV-UV 65536/t
		RA.addAssemblerRecipe(new ItemStack[]{ItemList.Hull_IV.get(1), CoreItems2.getRecipe(198, 16), ItemList.Emitter_IV.get(16), ItemList.Electric_Pump_IV.get(16), GT_OreDictUnificator.get(OrePrefixes.wireGt08, Materials.TungstenSteel, 8), GT_Utility.getIntegratedCircuit(5)}, null, GT_ItemList.DynamoTunnel5_IV.get(1L), 16000, 7680);
		RA.addAssemblerRecipe(new ItemStack[]{ItemList.Hull_LuV.get(1), CoreItems2.getRecipe(198, 16), ItemList.Emitter_LuV.get(16), ItemList.Electric_Pump_LuV.get(16), GT_OreDictUnificator.get(OrePrefixes.wireGt08, Materials.VanadiumGallium, 8), GT_Utility.getIntegratedCircuit(5)}, null, GT_ItemList.DynamoTunnel5_LuV.get(1), 16000, 30720);
		RA.addAssemblerRecipe(new ItemStack[]{ItemList.Hull_ZPM.get(1), CoreItems2.getRecipe(199, 16), ItemList.Emitter_ZPM.get(16), ItemList.Electric_Pump_ZPM.get(16), GT_OreDictUnificator.get(OrePrefixes.wireGt08, Materials.Naquadah, 8), GT_Utility.getIntegratedCircuit(5)}, null, GT_ItemList.DynamoTunnel5_ZPM.get(1), 16000, 122880);
		RA.addAssemblerRecipe(new ItemStack[]{ItemList.Hull_UV.get(1), CoreItems2.getRecipe(199, 16), ItemList.Emitter_UV.get(16), ItemList.Electric_Pump_UV.get(16), GT_OreDictUnificator.get(OrePrefixes.wireGt08, Materials.NaquadahAlloy, 8), GT_Utility.getIntegratedCircuit(5)}, null, GT_ItemList.DynamoTunnel5_UV.get(1), 16000, 500000);
		RA.addAssemblerRecipe(new ItemStack[]{ItemList.Hull_MAX.get(1), CoreItems2.getRecipe(200, 16), ItemList.Emitter_UHV.get(16), ItemList.Electric_Pump_UHV.get(16), GT_OreDictUnificator.get(OrePrefixes.wireGt08, Materials.Europium, 8), GT_Utility.getIntegratedCircuit(5)}, null, GT_ItemList.DynamoTunnel5_UHV.get(1), 16000, 2000000);
		RA.addAssemblerRecipe(new ItemStack[]{ItemList.Hull_UEV.get(1), CoreItems2.getRecipe(200, 16), ItemList.Emitter_UEV.get(16), ItemList.Electric_Pump_UEV.get(16), GT_OreDictUnificator.get(OrePrefixes.wireGt08, Materials.Diamericiumtitanium, 8), GT_Utility.getIntegratedCircuit(5)}, null, GT_ItemList.DynamoTunnel5_UEV.get(1), 16000, 8000000);

		//Laser Dynamo IV-UV 262144/t
		RA.addAssemblerRecipe(new ItemStack[]{ItemList.Hull_IV.get(1), CoreItems2.getRecipe(198, 32), ItemList.Emitter_IV.get(32), ItemList.Electric_Pump_IV.get(32), GT_OreDictUnificator.get(OrePrefixes.wireGt08, Materials.TungstenSteel, 16), GT_Utility.getIntegratedCircuit(6)}, null, GT_ItemList.DynamoTunnel6_IV.get(1), 32000, 7680);
		RA.addAssemblerRecipe(new ItemStack[]{ItemList.Hull_LuV.get(1), CoreItems2.getRecipe(198, 32), ItemList.Emitter_LuV.get(32), ItemList.Electric_Pump_LuV.get(32), GT_OreDictUnificator.get(OrePrefixes.wireGt08, Materials.VanadiumGallium, 16), GT_Utility.getIntegratedCircuit(6)}, null, GT_ItemList.DynamoTunnel6_LuV.get(1), 32000, 30720);
		RA.addAssemblerRecipe(new ItemStack[]{ItemList.Hull_ZPM.get(1), CoreItems2.getRecipe(199, 32), ItemList.Emitter_ZPM.get(32), ItemList.Electric_Pump_ZPM.get(32), GT_OreDictUnificator.get(OrePrefixes.wireGt08, Materials.Naquadah, 16), GT_Utility.getIntegratedCircuit(6)}, null, GT_ItemList.DynamoTunnel6_ZPM.get(1), 32000, 122880);
		RA.addAssemblerRecipe(new ItemStack[]{ItemList.Hull_UV.get(1), CoreItems2.getRecipe(199, 32), ItemList.Emitter_UV.get(32), ItemList.Electric_Pump_UV.get(32), GT_OreDictUnificator.get(OrePrefixes.wireGt08, Materials.NaquadahAlloy, 16), GT_Utility.getIntegratedCircuit(6)}, null, GT_ItemList.DynamoTunnel6_UV.get(1), 32000, 500000);
		RA.addAssemblerRecipe(new ItemStack[]{ItemList.Hull_MAX.get(1), CoreItems2.getRecipe(200, 32), ItemList.Emitter_UHV.get(32), ItemList.Electric_Pump_UHV.get(32), GT_OreDictUnificator.get(OrePrefixes.wireGt08, Materials.Europium, 16), GT_Utility.getIntegratedCircuit(6)}, null, GT_ItemList.DynamoTunnel6_UHV.get(1), 32000, 2000000);
		RA.addAssemblerRecipe(new ItemStack[]{ItemList.Hull_UEV.get(1), CoreItems2.getRecipe(200, 32), ItemList.Emitter_UEV.get(32), ItemList.Electric_Pump_UEV.get(32), GT_OreDictUnificator.get(OrePrefixes.wireGt08, Materials.Diamericiumtitanium, 16), GT_Utility.getIntegratedCircuit(6)}, null, GT_ItemList.DynamoTunnel6_UEV.get(1), 32000, 8000000);

		//Laser Dynamo IV-UV 1048576/t
		RA.addAssemblerRecipe(new ItemStack[]{ItemList.Hull_IV.get(1), CoreItems2.getRecipe(198, 64), ItemList.Emitter_IV.get(64), ItemList.Electric_Pump_IV.get(64), GT_OreDictUnificator.get(OrePrefixes.wireGt16, Materials.TungstenSteel, 16), GT_Utility.getIntegratedCircuit(7)}, null, GT_ItemList.DynamoTunnel7_IV.get(1), 64000, 7680);
		RA.addAssemblerRecipe(new ItemStack[]{ItemList.Hull_LuV.get(1), CoreItems2.getRecipe(198, 64), ItemList.Emitter_LuV.get(64), ItemList.Electric_Pump_LuV.get(64), GT_OreDictUnificator.get(OrePrefixes.wireGt16, Materials.VanadiumGallium, 16), GT_Utility.getIntegratedCircuit(7)}, null, GT_ItemList.DynamoTunnel7_LuV.get(1), 64000, 30720);
		RA.addAssemblerRecipe(new ItemStack[]{ItemList.Hull_ZPM.get(1), CoreItems2.getRecipe(199, 64), ItemList.Emitter_ZPM.get(64), ItemList.Electric_Pump_ZPM.get(64), GT_OreDictUnificator.get(OrePrefixes.wireGt16, Materials.Naquadah, 16), GT_Utility.getIntegratedCircuit(7)}, null, GT_ItemList.DynamoTunnel7_ZPM.get(1), 64000, 122880);
		RA.addAssemblerRecipe(new ItemStack[]{ItemList.Hull_UV.get(1), CoreItems2.getRecipe(199, 64), ItemList.Emitter_UV.get(64), ItemList.Electric_Pump_UV.get(64), GT_OreDictUnificator.get(OrePrefixes.wireGt16, Materials.NaquadahAlloy, 16), GT_Utility.getIntegratedCircuit(7)}, null, GT_ItemList.DynamoTunnel7_UV.get(1), 64000, 500000);
		RA.addAssemblerRecipe(new ItemStack[]{ItemList.Hull_MAX.get(1), CoreItems2.getRecipe(200, 64), ItemList.Emitter_UHV.get(64), ItemList.Electric_Pump_UHV.get(64), GT_OreDictUnificator.get(OrePrefixes.wireGt16, Materials.Europium, 16), GT_Utility.getIntegratedCircuit(7)}, null, GT_ItemList.DynamoTunnel7_UHV.get(1), 64000, 2000000);
		RA.addAssemblerRecipe(new ItemStack[]{ItemList.Hull_UEV.get(1), CoreItems2.getRecipe(200, 64), ItemList.Emitter_UEV.get(64), ItemList.Electric_Pump_UEV.get(64), GT_OreDictUnificator.get(OrePrefixes.wireGt16, Materials.Diamericiumtitanium, 16), GT_Utility.getIntegratedCircuit(7)}, null, GT_ItemList.DynamoTunnel7_UEV.get(1), 64000, 8000000);

		//Laser Target IV-UV 256/t
		RA.addAssemblerRecipe(new ItemStack[]{ItemList.Hull_IV.get(1), CoreItems2.getRecipe(198, 1), ItemList.Sensor_IV.get(1), ItemList.Electric_Pump_IV.get(1), GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.TungstenSteel, 2), GT_Utility.getIntegratedCircuit(1)}, null, GT_ItemList.EnergyTunnel1_IV.get(1), 1000, 7680);
		RA.addAssemblerRecipe(new ItemStack[]{ItemList.Hull_LuV.get(1), CoreItems2.getRecipe(198, 1), ItemList.Sensor_LuV.get(1), ItemList.Electric_Pump_LuV.get(1), GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.VanadiumGallium, 2), GT_Utility.getIntegratedCircuit(1)}, null, GT_ItemList.EnergyTunnel1_LuV.get(1), 1000, 30720);
		RA.addAssemblerRecipe(new ItemStack[]{ItemList.Hull_ZPM.get(1), CoreItems2.getRecipe(199, 1), ItemList.Sensor_ZPM.get(1), ItemList.Electric_Pump_ZPM.get(1), GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.Naquadah, 2), GT_Utility.getIntegratedCircuit(1)}, null, GT_ItemList.EnergyTunnel1_ZPM.get(1), 1000, 122880);
		RA.addAssemblerRecipe(new ItemStack[]{ItemList.Hull_UV.get(1), CoreItems2.getRecipe(199, 1), ItemList.Sensor_UV.get(1), ItemList.Electric_Pump_UV.get(1), GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.NaquadahAlloy, 2), GT_Utility.getIntegratedCircuit(1)}, null, GT_ItemList.EnergyTunnel1_UV.get(1), 1000, 500000);
		RA.addAssemblerRecipe(new ItemStack[]{ItemList.Hull_MAX.get(1), CoreItems2.getRecipe(200, 1), ItemList.Sensor_UHV.get(1), ItemList.Electric_Pump_UHV.get(1), GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.Europium, 2), GT_Utility.getIntegratedCircuit(1)}, null, GT_ItemList.EnergyTunnel1_UHV.get(1), 1000, 2000000);
		RA.addAssemblerRecipe(new ItemStack[]{ItemList.Hull_UEV.get(1), CoreItems2.getRecipe(200, 1), ItemList.Sensor_UEV.get(1), ItemList.Electric_Pump_UEV.get(1), GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.Diamericiumtitanium, 2), GT_Utility.getIntegratedCircuit(1)}, null, GT_ItemList.EnergyTunnel1_UEV.get(1), 1000, 8000000);

		//Laser Target IV-UV 1024/t
		RA.addAssemblerRecipe(new ItemStack[]{ItemList.Hull_IV.get(1), CoreItems2.getRecipe(198, 2), ItemList.Sensor_IV.get(2), ItemList.Electric_Pump_IV.get(2), GT_OreDictUnificator.get(OrePrefixes.wireGt02, Materials.TungstenSteel, 4), GT_Utility.getIntegratedCircuit(2)}, null, GT_ItemList.EnergyTunnel2_IV.get(1), 2000, 7680);
		RA.addAssemblerRecipe(new ItemStack[]{ItemList.Hull_LuV.get(1), CoreItems2.getRecipe(198, 2), ItemList.Sensor_LuV.get(2), ItemList.Electric_Pump_LuV.get(2), GT_OreDictUnificator.get(OrePrefixes.wireGt02, Materials.VanadiumGallium, 4), GT_Utility.getIntegratedCircuit(2)}, null, GT_ItemList.EnergyTunnel2_LuV.get(1), 2000, 30720);
		RA.addAssemblerRecipe(new ItemStack[]{ItemList.Hull_ZPM.get(1), CoreItems2.getRecipe(199, 2), ItemList.Sensor_ZPM.get(2), ItemList.Electric_Pump_ZPM.get(2), GT_OreDictUnificator.get(OrePrefixes.wireGt02, Materials.Naquadah, 4), GT_Utility.getIntegratedCircuit(2)}, null, GT_ItemList.EnergyTunnel2_ZPM.get(1), 2000, 122880);
		RA.addAssemblerRecipe(new ItemStack[]{ItemList.Hull_UV.get(1), CoreItems2.getRecipe(199, 2), ItemList.Sensor_UV.get(2), ItemList.Electric_Pump_UV.get(2), GT_OreDictUnificator.get(OrePrefixes.wireGt02, Materials.NaquadahAlloy, 4), GT_Utility.getIntegratedCircuit(2)}, null, GT_ItemList.EnergyTunnel2_UV.get(1), 2000, 500000);
		RA.addAssemblerRecipe(new ItemStack[]{ItemList.Hull_MAX.get(1), CoreItems2.getRecipe(200, 2), ItemList.Sensor_UHV.get(2), ItemList.Electric_Pump_UHV.get(2), GT_OreDictUnificator.get(OrePrefixes.wireGt02, Materials.Europium, 4), GT_Utility.getIntegratedCircuit(2)}, null, GT_ItemList.EnergyTunnel2_UHV.get(1), 2000, 2000000);
		RA.addAssemblerRecipe(new ItemStack[]{ItemList.Hull_UEV.get(1), CoreItems2.getRecipe(200, 2), ItemList.Sensor_UEV.get(2), ItemList.Electric_Pump_UEV.get(2), GT_OreDictUnificator.get(OrePrefixes.wireGt02, Materials.Diamericiumtitanium, 4), GT_Utility.getIntegratedCircuit(2)}, null, GT_ItemList.EnergyTunnel2_UEV.get(1), 2000, 8000000);

		//Laser Target IV-UV 4096/t
		RA.addAssemblerRecipe(new ItemStack[]{ItemList.Hull_IV.get(1), CoreItems2.getRecipe(198, 4), ItemList.Sensor_IV.get(4), ItemList.Electric_Pump_IV.get(4), GT_OreDictUnificator.get(OrePrefixes.wireGt04, Materials.TungstenSteel, 4), GT_Utility.getIntegratedCircuit(3)}, null, GT_ItemList.EnergyTunnel3_IV.get(1), 4000, 7680);
		RA.addAssemblerRecipe(new ItemStack[]{ItemList.Hull_LuV.get(1), CoreItems2.getRecipe(198, 4), ItemList.Sensor_LuV.get(4), ItemList.Electric_Pump_LuV.get(4), GT_OreDictUnificator.get(OrePrefixes.wireGt04, Materials.VanadiumGallium, 4), GT_Utility.getIntegratedCircuit(3)}, null, GT_ItemList.EnergyTunnel3_LuV.get(1), 4000, 30720);
		RA.addAssemblerRecipe(new ItemStack[]{ItemList.Hull_ZPM.get(1), CoreItems2.getRecipe(199, 4), ItemList.Sensor_ZPM.get(4), ItemList.Electric_Pump_ZPM.get(4), GT_OreDictUnificator.get(OrePrefixes.wireGt04, Materials.Naquadah, 4), GT_Utility.getIntegratedCircuit(3)}, null, GT_ItemList.EnergyTunnel3_ZPM.get(1), 4000, 122880);
		RA.addAssemblerRecipe(new ItemStack[]{ItemList.Hull_UV.get(1), CoreItems2.getRecipe(199, 4), ItemList.Sensor_UV.get(4), ItemList.Electric_Pump_UV.get(4), GT_OreDictUnificator.get(OrePrefixes.wireGt04, Materials.NaquadahAlloy, 4), GT_Utility.getIntegratedCircuit(3)}, null, GT_ItemList.EnergyTunnel3_UV.get(1), 4000, 500000);
		RA.addAssemblerRecipe(new ItemStack[]{ItemList.Hull_MAX.get(1), CoreItems2.getRecipe(200, 4), ItemList.Sensor_UHV.get(4), ItemList.Electric_Pump_UHV.get(4), GT_OreDictUnificator.get(OrePrefixes.wireGt04, Materials.Europium, 4), GT_Utility.getIntegratedCircuit(3)}, null, GT_ItemList.EnergyTunnel3_UHV.get(1), 4000, 2000000);
		RA.addAssemblerRecipe(new ItemStack[]{ItemList.Hull_UEV.get(1), CoreItems2.getRecipe(200, 4), ItemList.Sensor_UEV.get(4), ItemList.Electric_Pump_UEV.get(4), GT_OreDictUnificator.get(OrePrefixes.wireGt04, Materials.Diamericiumtitanium, 4), GT_Utility.getIntegratedCircuit(3)}, null, GT_ItemList.EnergyTunnel3_UEV.get(1), 4000, 8000000);

		//Laser Target IV-UV 16384/t
		RA.addAssemblerRecipe(new ItemStack[]{ItemList.Hull_IV.get(1), CoreItems2.getRecipe(198, 8), ItemList.Sensor_IV.get(8), ItemList.Electric_Pump_IV.get(8), GT_OreDictUnificator.get(OrePrefixes.wireGt04, Materials.TungstenSteel, 8), GT_Utility.getIntegratedCircuit(4)}, null, GT_ItemList.EnergyTunnel4_IV.get(1), 8000, 7680);
		RA.addAssemblerRecipe(new ItemStack[]{ItemList.Hull_LuV.get(1), CoreItems2.getRecipe(198, 8), ItemList.Sensor_LuV.get(8), ItemList.Electric_Pump_LuV.get(8), GT_OreDictUnificator.get(OrePrefixes.wireGt04, Materials.VanadiumGallium, 8), GT_Utility.getIntegratedCircuit(4)}, null, GT_ItemList.EnergyTunnel4_LuV.get(1), 8000, 30720);
		RA.addAssemblerRecipe(new ItemStack[]{ItemList.Hull_ZPM.get(1), CoreItems2.getRecipe(199, 8), ItemList.Sensor_ZPM.get(8), ItemList.Electric_Pump_ZPM.get(8), GT_OreDictUnificator.get(OrePrefixes.wireGt04, Materials.Naquadah, 8), GT_Utility.getIntegratedCircuit(4)}, null, GT_ItemList.EnergyTunnel4_ZPM.get(1), 8000, 122880);
		RA.addAssemblerRecipe(new ItemStack[]{ItemList.Hull_UV.get(1), CoreItems2.getRecipe(199, 8), ItemList.Sensor_UV.get(8), ItemList.Electric_Pump_UV.get(8), GT_OreDictUnificator.get(OrePrefixes.wireGt04, Materials.NaquadahAlloy, 8), GT_Utility.getIntegratedCircuit(4)}, null, GT_ItemList.EnergyTunnel4_UV.get(1), 8000, 500000);
		RA.addAssemblerRecipe(new ItemStack[]{ItemList.Hull_MAX.get(1), CoreItems2.getRecipe(200, 8), ItemList.Sensor_UHV.get(8), ItemList.Electric_Pump_UHV.get(8), GT_OreDictUnificator.get(OrePrefixes.wireGt04, Materials.Europium, 8), GT_Utility.getIntegratedCircuit(4)}, null, GT_ItemList.EnergyTunnel4_UHV.get(1), 8000, 2000000);
		RA.addAssemblerRecipe(new ItemStack[]{ItemList.Hull_UEV.get(1), CoreItems2.getRecipe(200, 8), ItemList.Sensor_UEV.get(8), ItemList.Electric_Pump_UEV.get(8), GT_OreDictUnificator.get(OrePrefixes.wireGt04, Materials.Diamericiumtitanium, 8), GT_Utility.getIntegratedCircuit(4)}, null, GT_ItemList.EnergyTunnel4_UEV.get(1), 8000, 8000000);

		//Laser Target IV-UV 65536/t
		RA.addAssemblerRecipe(new ItemStack[]{ItemList.Hull_IV.get(1), CoreItems2.getRecipe(198, 16), ItemList.Sensor_IV.get(16), ItemList.Electric_Pump_IV.get(16), GT_OreDictUnificator.get(OrePrefixes.wireGt08, Materials.TungstenSteel, 8), GT_Utility.getIntegratedCircuit(5)}, null, GT_ItemList.EnergyTunnel5_IV.get(1), 16000, 7680);
		RA.addAssemblerRecipe(new ItemStack[]{ItemList.Hull_LuV.get(1), CoreItems2.getRecipe(198, 16), ItemList.Sensor_LuV.get(16), ItemList.Electric_Pump_LuV.get(16), GT_OreDictUnificator.get(OrePrefixes.wireGt08, Materials.VanadiumGallium, 8), GT_Utility.getIntegratedCircuit(5)}, null, GT_ItemList.EnergyTunnel5_LuV.get(1), 16000, 30720);
		RA.addAssemblerRecipe(new ItemStack[]{ItemList.Hull_ZPM.get(1), CoreItems2.getRecipe(199, 16), ItemList.Sensor_ZPM.get(16), ItemList.Electric_Pump_ZPM.get(16), GT_OreDictUnificator.get(OrePrefixes.wireGt08, Materials.Naquadah, 8), GT_Utility.getIntegratedCircuit(5)}, null, GT_ItemList.EnergyTunnel5_ZPM.get(1), 16000, 122880);
		RA.addAssemblerRecipe(new ItemStack[]{ItemList.Hull_UV.get(1), CoreItems2.getRecipe(199, 16), ItemList.Sensor_UV.get(16), ItemList.Electric_Pump_UV.get(16), GT_OreDictUnificator.get(OrePrefixes.wireGt08, Materials.NaquadahAlloy, 8), GT_Utility.getIntegratedCircuit(5)}, null, GT_ItemList.EnergyTunnel5_UV.get(1), 16000, 500000);
		RA.addAssemblerRecipe(new ItemStack[]{ItemList.Hull_MAX.get(1), CoreItems2.getRecipe(200, 16), ItemList.Sensor_UHV.get(16), ItemList.Electric_Pump_UHV.get(16), GT_OreDictUnificator.get(OrePrefixes.wireGt08, Materials.Europium, 8), GT_Utility.getIntegratedCircuit(5)}, null, GT_ItemList.EnergyTunnel5_UHV.get(1), 16000, 2000000);
		RA.addAssemblerRecipe(new ItemStack[]{ItemList.Hull_UEV.get(1), CoreItems2.getRecipe(200, 16), ItemList.Sensor_UEV.get(16), ItemList.Electric_Pump_UEV.get(16), GT_OreDictUnificator.get(OrePrefixes.wireGt08, Materials.Diamericiumtitanium, 8), GT_Utility.getIntegratedCircuit(5)}, null, GT_ItemList.EnergyTunnel5_UEV.get(1), 16000, 8000000);

		//Laser Target IV-UV 262144/t
		RA.addAssemblerRecipe(new ItemStack[]{ItemList.Hull_IV.get(1), CoreItems2.getRecipe(198, 32), ItemList.Sensor_IV.get(32), ItemList.Electric_Pump_IV.get(32), GT_OreDictUnificator.get(OrePrefixes.wireGt08, Materials.TungstenSteel, 16), GT_Utility.getIntegratedCircuit(6)}, null, GT_ItemList.EnergyTunnel6_IV.get(1), 32000, 7680);
		RA.addAssemblerRecipe(new ItemStack[]{ItemList.Hull_LuV.get(1), CoreItems2.getRecipe(198, 32), ItemList.Sensor_LuV.get(32), ItemList.Electric_Pump_LuV.get(32), GT_OreDictUnificator.get(OrePrefixes.wireGt08, Materials.VanadiumGallium, 16), GT_Utility.getIntegratedCircuit(6)}, null, GT_ItemList.EnergyTunnel6_LuV.get(1), 32000, 30720);
		RA.addAssemblerRecipe(new ItemStack[]{ItemList.Hull_ZPM.get(1), CoreItems2.getRecipe(199, 32), ItemList.Sensor_ZPM.get(32), ItemList.Electric_Pump_ZPM.get(32), GT_OreDictUnificator.get(OrePrefixes.wireGt08, Materials.Naquadah, 16), GT_Utility.getIntegratedCircuit(6)}, null, GT_ItemList.EnergyTunnel6_ZPM.get(1), 32000, 122880);
		RA.addAssemblerRecipe(new ItemStack[]{ItemList.Hull_UV.get(1), CoreItems2.getRecipe(199, 32), ItemList.Sensor_UV.get(32), ItemList.Electric_Pump_UV.get(32), GT_OreDictUnificator.get(OrePrefixes.wireGt08, Materials.NaquadahAlloy, 16), GT_Utility.getIntegratedCircuit(6)}, null, GT_ItemList.EnergyTunnel6_UV.get(1), 32000, 500000);
		RA.addAssemblerRecipe(new ItemStack[]{ItemList.Hull_MAX.get(1), CoreItems2.getRecipe(200, 32), ItemList.Sensor_UHV.get(32), ItemList.Electric_Pump_UHV.get(32), GT_OreDictUnificator.get(OrePrefixes.wireGt08, Materials.Europium, 16), GT_Utility.getIntegratedCircuit(6)}, null, GT_ItemList.EnergyTunnel6_UHV.get(1), 32000, 2000000);
		RA.addAssemblerRecipe(new ItemStack[]{ItemList.Hull_UEV.get(1), CoreItems2.getRecipe(200, 32), ItemList.Sensor_UEV.get(32), ItemList.Electric_Pump_UEV.get(32), GT_OreDictUnificator.get(OrePrefixes.wireGt08, Materials.Diamericiumtitanium, 16), GT_Utility.getIntegratedCircuit(6)}, null, GT_ItemList.EnergyTunnel6_UEV.get(1), 32000, 8000000);

		//Laser Target IV-UV 1048576/t
		RA.addAssemblerRecipe(new ItemStack[]{ItemList.Hull_IV.get(1), CoreItems2.getRecipe(198, 64), ItemList.Sensor_IV.get(64), ItemList.Electric_Pump_IV.get(64), GT_OreDictUnificator.get(OrePrefixes.wireGt16, Materials.TungstenSteel, 16), GT_Utility.getIntegratedCircuit(7)}, null, GT_ItemList.EnergyTunnel7_IV.get(1), 64000, 7680);
		RA.addAssemblerRecipe(new ItemStack[]{ItemList.Hull_LuV.get(1), CoreItems2.getRecipe(198, 64), ItemList.Sensor_LuV.get(64), ItemList.Electric_Pump_LuV.get(64), GT_OreDictUnificator.get(OrePrefixes.wireGt16, Materials.VanadiumGallium, 16), GT_Utility.getIntegratedCircuit(7)}, null, GT_ItemList.EnergyTunnel7_LuV.get(1), 64000, 30720);
		RA.addAssemblerRecipe(new ItemStack[]{ItemList.Hull_ZPM.get(1), CoreItems2.getRecipe(199, 64), ItemList.Sensor_ZPM.get(64), ItemList.Electric_Pump_ZPM.get(64), GT_OreDictUnificator.get(OrePrefixes.wireGt16, Materials.Naquadah, 16), GT_Utility.getIntegratedCircuit(7)}, null, GT_ItemList.EnergyTunnel7_ZPM.get(1), 64000, 122880);
		RA.addAssemblerRecipe(new ItemStack[]{ItemList.Hull_UV.get(1), CoreItems2.getRecipe(199, 64), ItemList.Sensor_UV.get(64), ItemList.Electric_Pump_UV.get(64), GT_OreDictUnificator.get(OrePrefixes.wireGt16, Materials.NaquadahAlloy, 16), GT_Utility.getIntegratedCircuit(7)}, null, GT_ItemList.EnergyTunnel7_UV.get(1), 64000, 500000);
		RA.addAssemblerRecipe(new ItemStack[]{ItemList.Hull_MAX.get(1), CoreItems2.getRecipe(200, 64), ItemList.Sensor_UHV.get(64), ItemList.Electric_Pump_UHV.get(64), GT_OreDictUnificator.get(OrePrefixes.wireGt16, Materials.Europium, 16), GT_Utility.getIntegratedCircuit(7)}, null, GT_ItemList.EnergyTunnel7_UHV.get(1), 64000, 2000000);
		RA.addAssemblerRecipe(new ItemStack[]{ItemList.Hull_UEV.get(1), CoreItems2.getRecipe(200, 64), ItemList.Sensor_UEV.get(64), ItemList.Electric_Pump_UEV.get(64), GT_OreDictUnificator.get(OrePrefixes.wireGt16, Materials.Diamericiumtitanium, 16), GT_Utility.getIntegratedCircuit(7)}, null, GT_ItemList.EnergyTunnel7_UEV.get(1), 64000, 8000000);

		//Dynamo Hatches IV-UEV
		RA.addAssemblerRecipe(new ItemStack[]{
						ItemList.Hatch_Dynamo_EV.get(1L),
						ItemList.EV_Coil.get(2),
						GT_OreDictUnificator.get(OrePrefixes.wireGt02, Materials.SuperconductorEV, 4),
						GT_OreDictUnificator.get(OrePrefixes.plateTriple, Materials.BT6, 2)},
				Materials.Silver.getMolten(144),
				GT_ItemList.DynamoMulti2_EV.get(1), 50, 1920
		);
		
		RA.addAssemblerRecipe(new ItemStack[]{
						ItemList.Hatch_Dynamo_IV.get(1L),
						ItemList.IV_Coil.get(2),
						GT_OreDictUnificator.get(OrePrefixes.wireGt02, Materials.SuperconductorIV, 4),
						GT_OreDictUnificator.get(OrePrefixes.plateTriple, Materials.Nitinol, 2)},
				Materials.Silver.getMolten(288),
				GT_ItemList.DynamoMulti2_IV.get(1), 50, 7680
		);
		
		RA.addAssemblerRecipe(new ItemStack[]{
						ItemList.Transformer_LuV_IV.get(1L),
						GT_ItemList.DynamoMulti2_IV.get(1L),
						ItemList.Circuit_Chip_HPIC.get(4L),
						ItemList.IV_Coil.get(4),
						GT_OreDictUnificator.get(OrePrefixes.wireGt04, Materials.SuperconductorIV, 8),
						GT_OreDictUnificator.get(OrePrefixes.plateDense, Materials.Nitinol, 2)},
				Materials.Electrum.getMolten(288),
				GT_ItemList.DynamoMulti4_IV.get(1), 200, 7680
		);
		
		RA.addAssemblerRecipe(new ItemStack[]{
						ItemList.Hatch_Dynamo_LuV.get(1),
						ItemList.LuV_Coil.get(2),
						GT_OreDictUnificator.get(OrePrefixes.wireGt02, Materials.SuperconductorLuV, 4),
						GT_OreDictUnificator.get(OrePrefixes.plateTriple, Materials.HastelloyN, 2)},
				Materials.Silver.getMolten(576),
				GT_ItemList.DynamoMulti2_LuV.get(1), 50, 30720
		);
		RA.addAssemblerRecipe(new ItemStack[]{
						ItemList.Transformer_ZPM_LuV.get(1L),
						GT_ItemList.DynamoMulti2_LuV.get(1),
						ItemList.Circuit_Chip_UHPIC.get(4),
						ItemList.LuV_Coil.get(4),
						GT_OreDictUnificator.get(OrePrefixes.wireGt04, Materials.SuperconductorLuV, 8),
						GT_OreDictUnificator.get(OrePrefixes.plateDense, Materials.HastelloyN, 2)},
				Materials.Electrum.getMolten(576),
				GT_ItemList.DynamoMulti4_LuV.get(1), 200, 30720
		);
		RA.addAssemblerRecipe(new ItemStack[]{
						ItemList.Transformer_HA_ZPM_LuV.get(1L),
						GT_ItemList.DynamoMulti4_LuV.get(1),
						ItemList.Circuit_Chip_UHPIC.get(8),
						ItemList.LuV_Coil.get(16),
						GT_OreDictUnificator.get(OrePrefixes.wireGt08, Materials.SuperconductorLuV, 16),
						GT_OreDictUnificator.get(OrePrefixes.plateDense, Materials.HastelloyN, 4)},
				Materials.Tungsten.getMolten(576),
				GT_ItemList.DynamoMulti16_LuV.get(1), 800, 30720
		);
		
		RA.addAssemblerRecipe(new ItemStack[]{
						ItemList.Hatch_Dynamo_ZPM.get(1),
						ItemList.ZPM_Coil.get(2),
						GT_OreDictUnificator.get(OrePrefixes.wireGt02, Materials.SuperconductorZPM, 4),
						GT_OreDictUnificator.get(OrePrefixes.plateTriple, Materials.Lafium, 2)},
				Materials.Silver.getMolten(1152),
				GT_ItemList.DynamoMulti2_ZPM.get(1), 50, 122880
		);
		RA.addAssemblerRecipe(new ItemStack[]{
						ItemList.Transformer_UV_ZPM.get(1L),
						GT_ItemList.DynamoMulti2_ZPM.get(1),
						GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Energy, 1),
						ItemList.Circuit_Chip_NPIC.get(4),
						ItemList.ZPM_Coil.get(4),
						GT_OreDictUnificator.get(OrePrefixes.wireGt04, Materials.SuperconductorZPM, 8),
						GT_OreDictUnificator.get(OrePrefixes.plateDense, Materials.Lafium, 2)},
				Materials.Electrum.getMolten(1152),
				GT_ItemList.DynamoMulti4_ZPM.get(1), 200, 122880
		);
		RA.addAssemblerRecipe(new ItemStack[]{
						ItemList.Transformer_HA_UV_ZPM.get(1L),
						GT_ItemList.DynamoMulti4_ZPM.get(1),
						GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Energy, 2),
						ItemList.Circuit_Chip_NPIC.get(8),
						ItemList.ZPM_Coil.get(16),
						GT_OreDictUnificator.get(OrePrefixes.wireGt08, Materials.SuperconductorZPM, 16),
						GT_OreDictUnificator.get(OrePrefixes.plateDense, Materials.Lafium, 4)},
				Materials.Tungsten.getMolten(1152),
				GT_ItemList.DynamoMulti16_ZPM.get(1), 800, 122880
		);
		RA.addAssemblerRecipe(new ItemStack[]{
						ItemList.WetTransformer_UV_ZPM.get(1L),
						GT_ItemList.DynamoMulti16_ZPM.get(1),
						GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Energy, 4),
						ItemList.Circuit_Chip_NPIC.get(16),
						ItemList.ZPM_Coil.get(64),
						GT_OreDictUnificator.get(OrePrefixes.wireGt16, Materials.SuperconductorZPM, 32),
						GT_OreDictUnificator.get(OrePrefixes.plateDense, Materials.Lafium, 8)},
				Materials.NiobiumTitanium.getMolten(1152),
				GT_ItemList.DynamoMulti64_ZPM.get(1), 3200, 122880
		);
		
		RA.addAssemblerRecipe(new ItemStack[]{
						ItemList.Hatch_Dynamo_UV.get(1),
						ItemList.UV_Coil.get(2),
						GT_OreDictUnificator.get(OrePrefixes.wireGt02, Materials.SuperconductorUV, 4),
						GT_OreDictUnificator.get(OrePrefixes.plateTriple, Materials.CinobiteA243, 2)},
				Materials.Silver.getMolten(2304),
				GT_ItemList.DynamoMulti2_UV.get(1), 50, 500000
		);
		RA.addAssemblerRecipe(new ItemStack[]{
						ItemList.Transformer_MAX_UV.get(1),
						GT_ItemList.DynamoMulti2_UV.get(1),
						GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Energy, 1),
						ItemList.Circuit_Chip_PPIC.get(4),
						ItemList.UV_Coil.get(4),
						GT_OreDictUnificator.get(OrePrefixes.wireGt04, Materials.SuperconductorUV, 8),
						GT_OreDictUnificator.get(OrePrefixes.plateDense, Materials.CinobiteA243, 2)},
				Materials.Electrum.getMolten(2304),
				GT_ItemList.DynamoMulti4_UV.get(1), 200, 500000
		);
		RA.addAssemblerRecipe(new ItemStack[]{
						ItemList.Transformer_HA_UHV_UV.get(1),
						GT_ItemList.DynamoMulti4_UV.get(1),
						GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Energy, 2),
						ItemList.Circuit_Chip_PPIC.get(8),
						ItemList.UV_Coil.get(16),
						GT_OreDictUnificator.get(OrePrefixes.wireGt08, Materials.SuperconductorUV, 16),
						GT_OreDictUnificator.get(OrePrefixes.plateDense, Materials.CinobiteA243, 4)},
				Materials.Tungsten.getMolten(2304),
				GT_ItemList.DynamoMulti16_UV.get(1), 800, 500000
		);
		RA.addAssemblerRecipe(new ItemStack[]{
						ItemList.WetTransformer_UHV_UV.get(1),
						GT_ItemList.DynamoMulti16_UV.get(1),
						GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Energy, 4),
						ItemList.Circuit_Chip_PPIC.get(16),
						ItemList.UV_Coil.get(64),
						GT_OreDictUnificator.get(OrePrefixes.wireGt16, Materials.SuperconductorUV, 32),
						GT_OreDictUnificator.get(OrePrefixes.plateDense, Materials.CinobiteA243, 8)},
				Materials.NiobiumTitanium.getMolten(2304),
				GT_ItemList.DynamoMulti64_UV.get(1), 3200, 500000
		);

        RA.addAssemblerRecipe(new ItemStack[]{
                        ItemList.Hatch_Dynamo_MAX.get(1),
						ItemList.UHV_Coil.get(2),
                        GT_OreDictUnificator.get(OrePrefixes.wireGt02, Materials.Superconductor, 4),
                        GT_OreDictUnificator.get(OrePrefixes.plateTriple, Materials.Pikyonium64B, 2)},
                Materials.Silver.getMolten(4608),
                GT_ItemList.DynamoMulti2_UHV.get(1), 50, 2000000);
        RA.addAssemblerRecipe(new ItemStack[]{
                        ItemList.Transformer_UEV_UHV.get(1L),
                        GT_ItemList.DynamoMulti2_UHV.get(1),
						GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Energy, 1),
                        ItemList.Circuit_Chip_QPIC.get(4),
						ItemList.UHV_Coil.get(4),
                        GT_OreDictUnificator.get(OrePrefixes.wireGt04, Materials.Superconductor, 8),
                        GT_OreDictUnificator.get(OrePrefixes.plateDense, Materials.Pikyonium64B, 2)},
                Materials.Electrum.getMolten(4608),
                GT_ItemList.DynamoMulti4_UHV.get(1), 200, 2000000);
        RA.addAssemblerRecipe(new ItemStack[]{
                        ItemList.Transformer_HA_UEV_UHV.get(1L),
                        GT_ItemList.DynamoMulti4_UHV.get(1),
						GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Energy, 2),
                        ItemList.Circuit_Chip_QPIC.get(8),
						ItemList.UHV_Coil.get(16),
                        GT_OreDictUnificator.get(OrePrefixes.wireGt08, Materials.Superconductor, 16),
                        GT_OreDictUnificator.get(OrePrefixes.plateDense, Materials.Pikyonium64B, 4)},
                Materials.Tungsten.getMolten(4608),
                GT_ItemList.DynamoMulti16_UHV.get(1), 800, 2000000);
        RA.addAssemblerRecipe(new ItemStack[]{
                        ItemList.WetTransformer_UEV_UHV.get(1L),
                        GT_ItemList.DynamoMulti16_UHV.get(1),
						GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Energy, 4),
                        ItemList.Circuit_Chip_QPIC.get(16),
						ItemList.UHV_Coil.get(64),
                        GT_OreDictUnificator.get(OrePrefixes.wireGt16, Materials.Superconductor, 32),
                        GT_OreDictUnificator.get(OrePrefixes.plateDense, Materials.Pikyonium64B, 8)},
                Materials.NiobiumTitanium.getMolten(4608),
                GT_ItemList.DynamoMulti64_UHV.get(1), 3200, 2000000);

		RA.addAssemblerRecipe(new ItemStack[]{
						ItemList.Hatch_Dynamo_UEV.get(1),
						ItemList.UEV_Coil.get(2),
						GT_OreDictUnificator.get(OrePrefixes.wireGt02, Materials.SuperconductorUEV, 4),
						GT_OreDictUnificator.get(OrePrefixes.plateTriple, Materials.Quantum, 2)},
				Materials.Silver.getMolten(9216),
				GT_ItemList.DynamoMulti2_UEV.get(1), 50, 8000000);
		RA.addAssemblerRecipe(new ItemStack[]{
						ItemList.Transformer_UIV_UEV.get(1L),
						GT_ItemList.DynamoMulti2_UEV.get(1),
						GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Energy, 1),
						ItemList.Circuit_Chip_FPIC.get(4),
						ItemList.UEV_Coil.get(4),
						GT_OreDictUnificator.get(OrePrefixes.wireGt04, Materials.SuperconductorUEV, 8),
						GT_OreDictUnificator.get(OrePrefixes.plateDense, Materials.Quantum, 2)},
				Materials.Electrum.getMolten(9216),
				GT_ItemList.DynamoMulti4_UEV.get(1), 200, 8000000);
		RA.addAssemblerRecipe(new ItemStack[]{
						ItemList.Transformer_HA_UIV_UEV.get(1L),
						GT_ItemList.DynamoMulti4_UEV.get(1),
						GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Energy, 2),
						ItemList.Circuit_Chip_FPIC.get(8),
						ItemList.UEV_Coil.get(16),
						GT_OreDictUnificator.get(OrePrefixes.wireGt08, Materials.SuperconductorUEV, 16),
						GT_OreDictUnificator.get(OrePrefixes.plateDense, Materials.Quantum, 4)},
				Materials.Tungsten.getMolten(9216),
				GT_ItemList.DynamoMulti16_UEV.get(1), 800, 8000000);
		RA.addAssemblerRecipe(new ItemStack[]{
						ItemList.WetTransformer_UIV_UEV.get(1L),
						GT_ItemList.DynamoMulti16_UEV.get(1),
						GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Energy, 4),
						ItemList.Circuit_Chip_FPIC.get(16),
						ItemList.UEV_Coil.get(64),
						GT_OreDictUnificator.get(OrePrefixes.wireGt16, Materials.SuperconductorUEV, 32),
						GT_OreDictUnificator.get(OrePrefixes.plateDense, Materials.Quantum, 8)},
				Materials.NiobiumTitanium.getMolten(9216),
				GT_ItemList.DynamoMulti64_UEV.get(1), 3200, 8000000);
		
		//Energy Hatches 4A-64A  IV-UEV
		RA.addAssemblerRecipe(new ItemStack[]{
						ItemList.Transformer_LuV_IV.get(1L),
						ItemList.Hatch_Energy_IV.get(1),
						ItemList.Circuit_Chip_HPIC.get(4),
						ItemList.IV_Coil.get(4),
						GT_OreDictUnificator.get(OrePrefixes.wireGt04, Materials.SuperconductorIV, 8),
						GT_OreDictUnificator.get(OrePrefixes.plateDense, Materials.Nitinol, 2)},
				Materials.Electrum.getMolten(288),
				GT_ItemList.EnergyMulti4_IV.get(1), 200, 7680
		);
		
		RA.addAssemblerRecipe(new ItemStack[]{
						ItemList.Transformer_ZPM_LuV.get(1L),
						ItemList.Hatch_Energy_LuV.get(1),
						ItemList.Circuit_Chip_UHPIC.get(4),
						ItemList.LuV_Coil.get(4),
						GT_OreDictUnificator.get(OrePrefixes.wireGt04, Materials.SuperconductorLuV, 8),
						GT_OreDictUnificator.get(OrePrefixes.plateDense, Materials.HastelloyN, 2)},
				Materials.Electrum.getMolten(576),
				GT_ItemList.EnergyMulti4_LuV.get(1), 200, 30720
		);
		RA.addAssemblerRecipe(new ItemStack[]{
						ItemList.Transformer_HA_ZPM_LuV.get(1L),
						GT_ItemList.EnergyMulti4_LuV.get(1),
						ItemList.Circuit_Chip_UHPIC.get(8),
						ItemList.LuV_Coil.get(16),
						GT_OreDictUnificator.get(OrePrefixes.wireGt08, Materials.SuperconductorLuV, 16),
						GT_OreDictUnificator.get(OrePrefixes.plateDense, Materials.HastelloyN, 4)},
				Materials.Tungsten.getMolten(576),
				GT_ItemList.EnergyMulti16_LuV.get(1), 800, 30720
		);
		
		RA.addAssemblerRecipe(new ItemStack[]{
						ItemList.Transformer_UV_ZPM.get(1L),
						ItemList.Hatch_Energy_ZPM.get(1),
						GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Energy, 1),
						ItemList.Circuit_Chip_NPIC.get(4),
						ItemList.ZPM_Coil.get(4),
						GT_OreDictUnificator.get(OrePrefixes.wireGt04, Materials.SuperconductorZPM, 8),
						GT_OreDictUnificator.get(OrePrefixes.plateDense, Materials.Lafium, 2)},
				Materials.Electrum.getMolten(1152),
				GT_ItemList.EnergyMulti4_ZPM.get(1), 200, 122880
		);
		RA.addAssemblerRecipe(new ItemStack[]{
						ItemList.Transformer_HA_UV_ZPM.get(1L),
						GT_ItemList.EnergyMulti4_ZPM.get(1),
						GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Energy, 2),
						ItemList.Circuit_Chip_NPIC.get(8),
						ItemList.ZPM_Coil.get(16),
						GT_OreDictUnificator.get(OrePrefixes.wireGt08, Materials.SuperconductorZPM, 16),
						GT_OreDictUnificator.get(OrePrefixes.plateDense, Materials.Lafium, 4)},
				Materials.Tungsten.getMolten(1152),
				GT_ItemList.EnergyMulti16_ZPM.get(1), 800, 122880
		);
		RA.addAssemblerRecipe(new ItemStack[]{
						ItemList.WetTransformer_UV_ZPM.get(1L),
						GT_ItemList.EnergyMulti16_ZPM.get(1),
						GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Energy, 4),
						ItemList.Circuit_Chip_NPIC.get(16),
						ItemList.ZPM_Coil.get(64),
						GT_OreDictUnificator.get(OrePrefixes.wireGt16, Materials.SuperconductorZPM, 32),
						GT_OreDictUnificator.get(OrePrefixes.plateDense, Materials.Lafium, 8)},
				Materials.NiobiumTitanium.getMolten(1152),
				GT_ItemList.EnergyMulti64_ZPM.get(1), 3200, 122880
		);
		
		RA.addAssemblerRecipe(new ItemStack[]{
						ItemList.Transformer_MAX_UV.get(1L),
						ItemList.Hatch_Energy_UV.get(1),
						GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Energy, 1),
						ItemList.Circuit_Chip_PPIC.get(4),
						ItemList.UV_Coil.get(4),
						GT_OreDictUnificator.get(OrePrefixes.wireGt04, Materials.SuperconductorUV, 8),
						GT_OreDictUnificator.get(OrePrefixes.plateDense, Materials.CinobiteA243, 2)},
				Materials.Electrum.getMolten(2304),
				GT_ItemList.EnergyMulti4_UV.get(1), 200, 500000
		);
		RA.addAssemblerRecipe(new ItemStack[]{
						ItemList.Transformer_HA_UHV_UV.get(1L),
						GT_ItemList.EnergyMulti4_UV.get(1),
						GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Energy, 2),
						ItemList.Circuit_Chip_PPIC.get(8),
						ItemList.UV_Coil.get(16),
						GT_OreDictUnificator.get(OrePrefixes.wireGt08, Materials.SuperconductorUV, 16),
						GT_OreDictUnificator.get(OrePrefixes.plateDense, Materials.CinobiteA243, 4)},
				Materials.Tungsten.getMolten(2304),
				GT_ItemList.EnergyMulti16_UV.get(1), 800, 500000
		);
		RA.addAssemblerRecipe(new ItemStack[]{
						ItemList.WetTransformer_UHV_UV.get(1L),
						GT_ItemList.EnergyMulti16_UV.get(1),
						GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Energy, 4),
						ItemList.Circuit_Chip_PPIC.get(16),
						ItemList.UV_Coil.get(64),
						GT_OreDictUnificator.get(OrePrefixes.wireGt16, Materials.SuperconductorUV, 32),
						GT_OreDictUnificator.get(OrePrefixes.plateDense, Materials.CinobiteA243, 8)},
				Materials.NiobiumTitanium.getMolten(2304),
				GT_ItemList.EnergyMulti64_UV.get(1), 3200, 500000
		);

        RA.addAssemblerRecipe(new ItemStack[]{
                        ItemList.Transformer_UEV_UHV.get(1L),
                        ItemList.Hatch_Energy_MAX.get(1),
						GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Energy, 1),
                        ItemList.Circuit_Chip_QPIC.get(4),
						ItemList.UHV_Coil.get(4),
                        GT_OreDictUnificator.get(OrePrefixes.wireGt04, Materials.Superconductor, 8),
                        GT_OreDictUnificator.get(OrePrefixes.plateDense, Materials.Pikyonium64B, 2)},
                Materials.Electrum.getMolten(4608),
                GT_ItemList.EnergyMulti4_UHV.get(1), 200, 2000000);
        RA.addAssemblerRecipe(new ItemStack[]{
                        ItemList.Transformer_HA_UEV_UHV.get(1L),
                        GT_ItemList.EnergyMulti4_UHV.get(1),
						GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Energy, 2),
                        ItemList.Circuit_Chip_QPIC.get(8),
						ItemList.UHV_Coil.get(16),
                        GT_OreDictUnificator.get(OrePrefixes.wireGt08, Materials.Superconductor, 16),
                        GT_OreDictUnificator.get(OrePrefixes.plateDense, Materials.Pikyonium64B, 4)},
                Materials.Tungsten.getMolten(4608),
                GT_ItemList.EnergyMulti16_UHV.get(1), 800, 2000000);
        RA.addAssemblerRecipe(new ItemStack[]{
                        ItemList.WetTransformer_UEV_UHV.get(1L),
                        GT_ItemList.EnergyMulti16_UHV.get(1),
						GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Energy, 4),
                        ItemList.Circuit_Chip_QPIC.get(16),
						ItemList.UHV_Coil.get(64),
                        GT_OreDictUnificator.get(OrePrefixes.wireGt16, Materials.Superconductor, 32),
                        GT_OreDictUnificator.get(OrePrefixes.plateDense, Materials.Pikyonium64B, 8)},
                Materials.NiobiumTitanium.getMolten(4608),
                GT_ItemList.EnergyMulti64_UHV.get(1), 3200, 2000000);

		RA.addAssemblerRecipe(new ItemStack[]{
						ItemList.Transformer_UIV_UEV.get(1L),
						ItemList.Hatch_Energy_UEV.get(1),
						GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Energy, 1),
						ItemList.Circuit_Chip_FPIC.get(4),
						ItemList.UEV_Coil.get(4),
						GT_OreDictUnificator.get(OrePrefixes.wireGt04, Materials.SuperconductorUEV, 8),
						GT_OreDictUnificator.get(OrePrefixes.plateDense, Materials.Quantum, 2)},
				Materials.Electrum.getMolten(9216),
				GT_ItemList.EnergyMulti4_UEV.get(1), 200, 8000000);
		RA.addAssemblerRecipe(new ItemStack[]{
						ItemList.Transformer_HA_UIV_UEV.get(1L),
						GT_ItemList.EnergyMulti4_UEV.get(1),
						GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Energy, 2),
						ItemList.Circuit_Chip_FPIC.get(8),
						ItemList.UEV_Coil.get(16),
						GT_OreDictUnificator.get(OrePrefixes.wireGt08, Materials.SuperconductorUEV, 16),
						GT_OreDictUnificator.get(OrePrefixes.plateDense, Materials.Quantum, 4)},
				Materials.Tungsten.getMolten(9216),
				GT_ItemList.EnergyMulti16_UEV.get(1), 800, 8000000);
		RA.addAssemblerRecipe(new ItemStack[]{
						ItemList.WetTransformer_UIV_UEV.get(1L),
						GT_ItemList.EnergyMulti16_UEV.get(1),
						GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Energy, 4),
						ItemList.Circuit_Chip_FPIC.get(16),
						ItemList.UEV_Coil.get(64),
						GT_OreDictUnificator.get(OrePrefixes.wireGt16, Materials.SuperconductorUEV, 32),
						GT_OreDictUnificator.get(OrePrefixes.plateDense, Materials.Quantum, 8)},
				Materials.NiobiumTitanium.getMolten(9216),
				GT_ItemList.EnergyMulti64_UEV.get(1), 3200, 8000000);

				// --- Advanced Fluid Detector
				RA.addAssemblerRecipe(new ItemStack(Blocks.heavy_weighted_pressure_plate, 1, 32767), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Birmabright, 1L), Materials.SolderingAlloy.getMolten(72L), GT_ModHandler.getModItem("impact", "impact_cover", 1), 600, 96);
				// --- Advanced Energy Detector
				RA.addAssemblerRecipe(GT_ModHandler.getIC2Item("ecMeter", 1L), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Birmabright, 1L), Materials.SolderingAlloy.getMolten(72L), GT_ModHandler.getModItem("impact", "impact_cover", 1, 1), 600, 96);
	}
	
	private void cutting() {
		RA.addCutterRecipe(Itemstack(Core_Items.getInstance(), 1, 45),
				Itemstack(Core_Items2.getInstance(), 4, 159), null, 20 * 40, 480, true
		);
		RA.addCutterRecipe(Itemstack(Core_Items.getInstance(), 1, 46),
				Itemstack(Core_Items2.getInstance(), 4, 160), null, 20 * 40, 1920, true
		);
		RA.addCutterRecipe(Itemstack(Core_Items.getInstance(), 1, 47),
				Itemstack(Core_Items2.getInstance(), 4, 161), null, 20 * 40, 7680, true
		);
		// --- Carpet
		for (int i = 0; i < 16; i++) {
			RA
					.addCutterRecipe(new ItemStack(Blocks.wool, 1, i), new ItemStack(Blocks.carpet, 2, i),
							GT_Values.NI, 50, 8
					);
		}
	}
	
	private void compressor() {
		RA.addCompressorRecipe(CoreItems2.getRecipe(CokeOvenBrick.getMetaID(), 4),
				ItemList.Casing_CokeOvenBrick.get(1L), 200, 8
		);
		RA
				.addCompressorRecipe(GT_OreDictUnificator.get(OrePrefixes.gem, Materials.CokeCoal, 9L),
						Blockstack(CoalBlock, 1, 0), 200, 8
				);
		RA.addCompressorRecipe(CoreItems.getRecipe(33, 1),
				GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Glass, 1L), 200, 2
		);
		RA
				.addCompressorRecipe(CoreItems2.getRecipe(125, 9), CoreItems2.getRecipe(126, 1), 400, 1920);
		RA
				.addCompressorRecipe(GT_ModHandler.getModItem("GalaxySpace", "barnardacleaves", 16L),
						CoreItems2.getRecipe(151, 1), 200, 8
				);
		
		RA
				.addCompressorRecipe(Blockstack(CoalBlock, 9, 0), Blockstack(CoalBlock, 1, 1), 100, 20);
		RA
				.addCompressorRecipe(Blockstack(CoalBlock, 9, 1), Blockstack(CoalBlock, 1, 2), 100, 120);
		RA
				.addCompressorRecipe(Blockstack(CoalBlock, 9, 2), Blockstack(CoalBlock, 1, 3), 100, 480);
		RA
				.addCompressorRecipe(Blockstack(CoalBlock, 9, 3), Blockstack(CoalBlock, 1, 4), 100, 1920);
		
		RA
				.addCompressorRecipe(GT_OreDictUnificator.get(OrePrefixes.block, Materials.Charcoal, 9L),
						Blockstack(CoalBlock, 1, 5), 120, 20
				);
		RA
				.addCompressorRecipe(Blockstack(CoalBlock, 9, 5), Blockstack(CoalBlock, 1, 6), 120, 120);
		RA
				.addCompressorRecipe(Blockstack(CoalBlock, 9, 6), Blockstack(CoalBlock, 1, 7), 120, 480);
		RA
				.addCompressorRecipe(Blockstack(CoalBlock, 9, 7), Blockstack(CoalBlock, 1, 8), 120, 1920);
		
		RA
				.addCompressorRecipe(GT_OreDictUnificator.get(OrePrefixes.block, Materials.Coal, 9L),
						Blockstack(CoalBlock, 1, 9), 110, 20
				);
		RA
				.addCompressorRecipe(Blockstack(CoalBlock, 9, 9), Blockstack(CoalBlock, 1, 10), 110, 120);
		RA
				.addCompressorRecipe(Blockstack(CoalBlock, 9, 10), Blockstack(CoalBlock, 1, 11), 110, 480);
		RA
				.addCompressorRecipe(Blockstack(CoalBlock, 9, 11), Blockstack(CoalBlock, 1, 12), 110, 1920);
		
		RA
				.addCompressorRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Naquadah, 4L), Itemstack(Core_Items2.getInstance(), 1, 183), 400, 120);
		RA
				.addCompressorRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.NaquadahEnriched, 4L), Itemstack(Core_Items2.getInstance(), 1, 185), 400, 120);
		
		RA
				.addCompressorRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Thorium, 1L), Itemstack(Core_Items2.getInstance(), 1, 187), 400, 120);

		// --- Petcoke Dust -> Petcoke
		RA
				.addCompressorRecipe(CoreItems.getRecipe(50, 9), CoreItems2.getRecipe(201, 1), 300, 2);

	}
	
	private void chemical() {
		RA.addMultiblockChemicalRecipe(
				new ItemStack[]{ItemList.Circuit_Chip_RPico.get(1L), Materials.MysteriousCrystal.getDust(2),
						GT_OreDictUnificator.get(OrePrefixes.dust, Materials.InfinityCatalyst, 1L)
								.copy().splitStack(0), CoreItems.getRecipe(TCetiESeaweedExtract.getMetaID(), 1)},
				new FluidStack[]{Materials.Neutronium.getMolten(100L)}, new FluidStack[]{GT_Values.NF},
				new ItemStack[]{ItemList.Circuit_Chip_Pico.get(1L)}, 3000, 500000
		);
		RA.addMultiblockChemicalRecipe(
				new ItemStack[]{ItemList.Circuit_Chip_RPico.get(1L), Materials.MysteriousCrystal.getDust(2),
						GT_OreDictUnificator.get(OrePrefixes.dust, Materials.InfinityCatalyst, 1L)
								.copy().splitStack(0), CoreItems.getRecipe(35, 1)},
				new FluidStack[]{Materials.Neutronium.getMolten(100L)}, new FluidStack[]{GT_Values.NF},
				new ItemStack[]{ItemList.Circuit_Chip_Pico.get(1L)}, 3000, 500000
		);
		
		RA.addMultiblockChemicalRecipe(
				new ItemStack[]{CoreItems.getRecipe(TCetiESeaweedExtract.getMetaID(), 1),
						GT_Utility.getIntegratedCircuit(1)}, new FluidStack[]{Materials.Radon.getGas(1000)},
				new FluidStack[]{Materials.OilHeavy.getFluid(500), Materials.Ethanol.getFluid(300),
						Materials.EnrichedBacterialSludge.getFluid(200)},
				new ItemStack[]{Materials.AlienOrganic.getDust(1)}, 500, 500000
		);
		RA.addMultiblockChemicalRecipe(
				new ItemStack[]{CoreItems.getRecipe(35, 1), GT_Utility.getIntegratedCircuit(1)},
				new FluidStack[]{Materials.Radon.getGas(1000)},
				new FluidStack[]{Materials.OilMedium.getFluid(500), Materials.Methanol.getFluid(350),
						Materials.EnrichedBacterialSludge.getFluid(150)},
				new ItemStack[]{Materials.AlienOrganic.getDust(1)}, 500, 500000
		);
		
		RA.addChemicalRecipe(Materials.Yttrium.getDust(2), GT_Utility.getIntegratedCircuit(6),
				Materials.Oxygen.getGas(3000), null, Itemstack(Core_Items.getInstance(), 1, 40), null, 400,
				30
		);
		//NO2
		RA.addMultiblockChemicalRecipe(
				new ItemStack[]{GT_Utility.getIntegratedCircuit(3)},
				new FluidStack[]{Materials.Nitrogen.getGas(1000L), Materials.Oxygen.getGas(2000L)},
				new FluidStack[]{Materials.NitrogenDioxide.getGas(3000L)},
				null, 8 * 20, 30
		);
		
		//InfinityCatalyst
		RA.addMultiblockChemicalRecipe(
				new ItemStack[]{GT_ModHandler.getModItem("SGCraft", "sgCoreCrystal", 1L), ItemList.Gravistar.get(16),
						Materials.CosmicNeutronium.getDust(32), Materials.Adamantium.getDust(64)},
				new FluidStack[]{Materials.InfinityCatalyst.getMolten(5760L)}, new FluidStack[]{GT_Values.NF},
				new ItemStack[]{CoreItems2.getRecipe(181, 1)}, 3000, 8000000
		);
		
		//Infinity
		RA.addMultiblockChemicalRecipe(
				new ItemStack[]{CoreItems2.getRecipe(181, 1), GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Adamantium, 1L)},
				new FluidStack[]{Materials.Neutronium.getPlasma(144L)}, new FluidStack[]{Materials.Neutronium.getMolten(144L)},
				new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Infinity, 1L)}, 4000, 8000000
		);
		
		// --- Zirconium
		RA.addMultiblockChemicalRecipe(
				new ItemStack[]{CoreItems.getRecipe(48, 1)},
				new FluidStack[]{Materials.Chlorine.getGas(2000)},
				new FluidStack[]{Materials.Oxygen.getGas(1000)},
				new ItemStack[]{Materials.SiliconDioxide.getDust(1), CoreItems.getRecipe(49, 1)}, 300, 256
		);
		RA.addChemicalRecipe(
				CoreItems.getRecipe(49, 1), Materials.Magnesium.getDust(2),
				null, null,
				Materials.Zirconium.getDust(1), Materials.Magnesiumchloride.getDust(2), 200, 120
		);
		RA.addMultiblockChemicalRecipe(
				new ItemStack[]{null},
				new FluidStack[]{Materials.SiliconTetrachloride.getFluid(1000), Materials.Water.getFluid(2000)},
				new FluidStack[]{Materials.HydrochloricAcid.getFluid(2000)},
				new ItemStack[]{Materials.SiliconDioxide.getDust(1)}, 200, 120
		);
		
		// --- Graphene
		RA.addMultiblockChemicalRecipe(
				new ItemStack[]{null},
				new FluidStack[]{Materials.SulfuricAcid.getFluid(1000), Materials.Ammonia.getGas(2000)},
				new FluidStack[]{Materials.AmmoniumSulfate.getFluid(3000)},
				new ItemStack[]{null}, 200, 480
		);
		RA.addMultiblockChemicalRecipe(
				new ItemStack[]{null},
				new FluidStack[]{Materials.AmmoniumSulfate.getFluid(1000), Materials.SulfuricAcid.getFluid(1000)},
				new FluidStack[]{Materials.AmmoniumPersulfate.getFluid(1000), Materials.Hydrogen.getGas(1000)},
				new ItemStack[]{null}, 200, 480
		);

	}
	
	private void bath() {
		// --- White Concrete
		RA.addChemicalBathRecipe(Blockstack(UtilBlock, 1, 0),
				new FluidStack(FluidRegistry.getFluid("dye.chemical.dyewhite"), 18),
				Blockstack(UtilBlock, 1, 2), GT_Values.NI, GT_Values.NI, new int[]{10000}, 64, 2
		);
		RA.addChemicalBathRecipe(Blockstack(UtilBlock, 1, 0),
				new FluidStack(FluidRegistry.getFluid("dye.watermixed.dyewhite"), 18),
				Blockstack(UtilBlock, 1, 2), GT_Values.NI, GT_Values.NI, new int[]{10000}, 64, 2
		);
		
		//Lens
		RA.addChemicalBathRecipe(
				GT_OreDictUnificator.get(OrePrefixes.lens, Materials.ReinforcedGlass, 1L),
				Materials.Chlorine.getGas(100L),
				CoreItems2.getRecipe(RefinedReinforcedGlassLense.getMetaID(), 1), GT_Values.NI,
				GT_Values.NI, null, 600, 16
		);
		RA
				.addChemicalBathRecipe(CoreItems2.getRecipe(RefinedReinforcedGlassLense.getMetaID(), 1),
						Materials.Radon.getGas(250), CoreItems2.getRecipe(ChargedGlassLense.getMetaID(), 1),
						null, null, null, 384, 480
				);
		RA
				.addChemicalBathRecipe(CoreItems2.getRecipe(HugeRefinedReinforcedGlassLense.getMetaID(), 1),
						Materials.Radon.getGas(1250),
						CoreItems2.getRecipe(HugeChargedGlassLense.getMetaID(), 1), null, null, null, 384,
						1920
				);
		RA
				.addLaserEngraverRecipe(CoreItems2.getRecipe(RefinedReinforcedGlassLense.getMetaID(), 3),
						GT_Utility
								.copyAmount(0, GT_OreDictUnificator.get(OrePrefixes.lens, Materials.Diamond, 1)),
						CoreItems2.getRecipe(HugeRefinedReinforcedGlassLense.getMetaID(), 1), 2400, 2000,
						false
				);
		
		for (int i = 1; i <= 15; i++) {
			if (i != 0) {
				RA.addChemicalBathRecipe(Blockstack(IGlassBlock, 1, i), Materials.Chlorine.getGas(50L), Blockstack(IGlassBlock, 0, 0), GT_Values.NI, GT_Values.NI, null, 200, 2);
			}
		}
		
		for (int i = 0; i <= 15; i++) {
			for (int j = 0; j < Dyes.VALUES[i].getSizeOfFluidList(); j++) {
				if (i != 15) {
					RA.addChemicalBathRecipe(Blockstack(IGlassBlock, 1, 0), Dyes.VALUES[i].getFluidDye(j, 18L), Blockstack(IGlassBlock, 1, (15 - i)), GT_Values.NI, GT_Values.NI, null, 200, 2);
				}
			}
		}
		
		RA.addChemicalBathRecipe(
				CoreItems2.getRecipe(RefinedReinforcedGlassLense.getMetaID(), 1),
				Materials.PulsatingIron.getMolten(72),
				new ItemStack(Items.ender_pearl, 1, 0), null, null, null, 1000,
				30);
		
		// --- Graphene Foil
		RA.addChemicalBathRecipe(
				CoreItems2.getRecipe(192, 1),
				Materials.AmmoniumPersulfate.getFluid(200),
				CoreItems2.getRecipe(193, 1),
				GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Copper, 1L), null, null, 300, 120);
		
	}
	
	private void ciruit() {
				
				//Rocket Circuits
				RA.addCircuitAssemblerRecipe(
						new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Good, 1L),
								GT_ModHandler.getModItem("GalacticraftCore", "item.heavyPlating", 1L, 0),
								GT_ItemList.spacebox1.get(1)}, Materials.SolderingAlloy.getMolten(144L),
						CoreItems2.getRecipe(0, 1), 1000, 256
				);
				RA.addCircuitAssemblerRecipe(
						new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Advanced, 1L),
								GT_ModHandler.getModItem("GalacticraftMars", "item.null", 1L, 3),
								GT_ItemList.spacebox2.get(1)}, Materials.SolderingAlloy.getMolten(288L),
						CoreItems2.getRecipe(1, 1), 1600, 480
				);
				RA.addCircuitAssemblerRecipe(
						new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Data, 1L),
								GT_ModHandler.getModItem("GalacticraftMars", "item.itemBasicAsteroids", 1L, 0),
								GT_ItemList.spacebox3.get(2)}, Materials.SolderingAlloy.getMolten(576L),
						CoreItems2.getRecipe(2, 1), 2200, 1920
				);
				RA.addCircuitAssemblerRecipe(
						new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Elite, 1L),
								CoreItems2.getRecipe(11, 1), GT_ItemList.spacebox4.get(2)},
						Materials.SolderingAlloy.getMolten(1152L), CoreItems2.getRecipe(3, 1), 2800, 4096
				);
				RA.addCircuitAssemblerRecipe(
						new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Master, 1L),
								CoreItems2.getRecipe(12, 1), GT_ItemList.spacebox5.get(4)},
						Materials.SolderingAlloy.getMolten(2304L), CoreItems2.getRecipe(4, 1), 3400, 16384
				);
				RA.addCircuitAssemblerRecipe(
						new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Ultimate, 1L),
								CoreItems2.getRecipe(13, 1), GT_ItemList.spacebox6.get(4)},
						Materials.SolderingAlloy.getMolten(4608L), CoreItems2.getRecipe(5, 1), 4000, 65536
				);
				RA.addCircuitAssemblerRecipe(new ItemStack[]{
								GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Superconductor, 1L),
								CoreItems2.getRecipe(14, 1), GT_ItemList.spacebox7.get(8)},
						Materials.SolderingAlloy.getMolten(9216L), CoreItems2.getRecipe(6, 1), 4600, 262144
				);
				RA.addCircuitAssemblerRecipe(
						new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Infinite, 1L),
								CoreItems2.getRecipe(15, 1), GT_ItemList.spacebox8.get(8)},
						Materials.SolderingAlloy.getMolten(18432L), CoreItems2.getRecipe(7, 1), 5200, 1048576
				);
				
				//Farm Circuits
				RA.addCircuitAssemblerRecipe(
						new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Good, 1L),
								GT_ModHandler.getModItem("minecraft", "sapling", 64L, 0)},
						Materials.SolderingAlloy.getMolten(72L), CoreItems2.getRecipe(OakScheme.getMetaID(), 1),
						200, 30
				);
				RA.addCircuitAssemblerRecipe(
						new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Good, 1L),
								GT_ModHandler.getModItem("minecraft", "sapling", 64L, 1)},
						Materials.SolderingAlloy.getMolten(72L),
						CoreItems2.getRecipe(SpruceScheme.getMetaID(), 1), 200, 30
				);
				RA.addCircuitAssemblerRecipe(
						new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Good, 1L),
								GT_ModHandler.getModItem("minecraft", "sapling", 64L, 2)},
						Materials.SolderingAlloy.getMolten(72L),
						CoreItems2.getRecipe(BirchScheme.getMetaID(), 1), 200, 30
				);
				RA.addCircuitAssemblerRecipe(
						new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Good, 1L),
								GT_ModHandler.getModItem("minecraft", "sapling", 64L, 3)},
						Materials.SolderingAlloy.getMolten(72L),
						CoreItems2.getRecipe(JungleScheme.getMetaID(), 1), 200, 30
				);
				RA.addCircuitAssemblerRecipe(
						new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Good, 1L),
								GT_ModHandler.getModItem("minecraft", "sapling", 64L, 4)},
						Materials.SolderingAlloy.getMolten(72L),
						CoreItems2.getRecipe(AcaciaScheme.getMetaID(), 1), 200, 30
				);
				RA.addCircuitAssemblerRecipe(
						new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Good, 1L),
								GT_ModHandler.getModItem("minecraft", "sapling", 64L, 5)},
						Materials.SolderingAlloy.getMolten(72L),
						CoreItems2.getRecipe(DarkOakScheme.getMetaID(), 1), 200, 30
				);
				RA.addCircuitAssemblerRecipe(
						new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Good, 1L),
								GT_ModHandler.getModItem("IC2", "blockRubSapling", 64L, 0)},
						Materials.SolderingAlloy.getMolten(72L),
						CoreItems2.getRecipe(RubberScheme.getMetaID(), 1), 200, 30
				);
				RA.addCircuitAssemblerRecipe(
						new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Bio, 1L),
								GT_OreDictUnificator.get(OrePrefixes.plateDense, Materials.DraconiumAwakened, 4L),
								GT_ModHandler.getModItem("minecraft", "sapling", 64L, 3),
								GT_OreDictUnificator.get(OrePrefixes.dust, Materials.AlienOrganic, 64L),
								GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Phoenixite, 64L),
								GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.CosmicNeutronium, 64L)},
						Materials.SolderingAlloy.getMolten(576L),
						CoreItems2.getRecipe(BarnardaCScheme.getMetaID(), 1), 1000, 8000000
				);

		// --- Co-Processors
		//1
		RA.addCircuitAssemblerRecipe(
				new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Titanium, 1),
						GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Data, 2L),
						GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 2L, 23),
						ItemList.Circuit_Parts_CapacitorSMD.get(8), ItemList.Circuit_Chip_Ram.get(8),
						GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.AnnealedCopper, 16)},
				Materials.SolderingAlloy.getMolten(288L), CoreItems2.getRecipe(203, 1), 400, 400,
				true);
		RA.addCircuitAssemblerRecipe(
				new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Titanium, 1),
						GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Data, 2L),
						GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 2L, 23),
						ItemList.Circuit_Parts_CapacitorASMD.get(2), ItemList.Circuit_Chip_Ram.get(8),
						GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.AnnealedCopper, 16)},
				Materials.SolderingAlloy.getMolten(288L), CoreItems2.getRecipe(203, 1), 200, 400,
				true);
		//4
		RA.addCircuitAssemblerRecipe(
				new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.TungstenSteel, 1),
						GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Elite, 2L),
						GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 4L, 23),
						ItemList.Circuit_Parts_CapacitorSMD.get(16), ItemList.Circuit_Chip_Ram.get(12),
						GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.Electrum, 16)},
				Materials.SolderingAlloy.getMolten(576L), CoreItems2.getRecipe(204, 1), 600, 1600,
				true);
		RA.addCircuitAssemblerRecipe(
				new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.TungstenSteel, 1),
						GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Elite, 2L),
						GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 4L, 23),
						ItemList.Circuit_Parts_CapacitorASMD.get(4), ItemList.Circuit_Chip_Ram.get(12),
						GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.Electrum, 16)},
				Materials.SolderingAlloy.getMolten(576L), CoreItems2.getRecipe(204, 1), 300, 1600,
				true);
		//16
		RA.addCircuitAssemblerRecipe(
				new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Chrome, 1),
						GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Master, 2L),
						GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 8L, 23),
						ItemList.Circuit_Parts_CapacitorSMD.get(32), ItemList.Circuit_Chip_NAND.get(16),
						GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.Aluminium, 16)},
				Materials.SolderingAlloy.getMolten(1152L), CoreItems2.getRecipe(205, 1), 800, 3500,
				true);
		RA.addCircuitAssemblerRecipe(
				new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Chrome, 1),
						GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Master, 2L),
						GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 8L, 23),
						ItemList.Circuit_Parts_CapacitorASMD.get(8), ItemList.Circuit_Chip_NAND.get(16),
						GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.Aluminium, 16)},
				Materials.SolderingAlloy.getMolten(1152L), CoreItems2.getRecipe(205, 1), 400, 3500,
				true);
		//64
		RA.addCircuitAssemblerRecipe(
				new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Iridium, 1),
						GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Ultimate, 2L),
						GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 12L, 23),
						ItemList.Circuit_Parts_CapacitorASMD.get(16), ItemList.Circuit_Chip_NAND.get(20),
						GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.Graphene, 16)},
				Materials.SolderingAlloy.getMolten(2304L), CoreItems2.getRecipe(206, 1), 800, 16500,
				true);
		//256
		RA.addCircuitAssemblerRecipe(
				new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Osmium, 1),
						GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Superconductor, 2L),
						GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 16L, 23),
						ItemList.Circuit_Parts_CapacitorASMD.get(24), ItemList.Circuit_Chip_NOR.get(24),
						GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.NiobiumTitanium, 16)},
				Materials.SolderingAlloy.getMolten(4608L), CoreItems2.getRecipe(207, 1), 1600, 70000,
				true);
		//1024
		RA.addCircuitAssemblerRecipe(
				new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Neutronium, 1),
						GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Infinite, 2L),
						GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 20L, 23),
						ItemList.Circuit_Parts_CapacitorASMD.get(32), ItemList.Circuit_Chip_NOR.get(28),
						GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.Enderium, 16)},
				Materials.SolderingAlloy.getMolten(9216L), CoreItems2.getRecipe(208, 1), 3200, 230000,
				true);
		//4096
		RA.addCircuitAssemblerRecipe(
				new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Phoenixite, 1),
						GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Bio, 2L),
						GT_ModHandler.getModItem(AE2, "item.ItemMultiMaterial", 24L, 23),
						ItemList.Circuit_Parts_CapacitorASMD.get(48), ItemList.Circuit_Chip_NOR.get(32),
						GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.NaquadahAlloy, 16)},
				Materials.SolderingAlloy.getMolten(18432L), CoreItems2.getRecipe(209, 1), 6400, 1250000,
				true);

	}
	
	private void assemblyLine() {
		//UpgradeCasingT2
		RA.addAssemblylineRecipe(GT_ItemList.UpgradeCasingT1.get(1L), 144000, new Object[]{
						ItemList.Hull_LuV.get(1L),
						GT_ModHandler.getModItem(AE2, "tile.BlockAdvancedCraftingStorage", 1, 0),
						GT_ItemList.UpgradeCasingT1.get(4L),
						GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.HastelloyN, 16),
						ItemList.Electric_Motor_LuV.get(4L),
						ItemList.Electric_Piston_LuV.get(4L),
						ItemList.Conveyor_Module_LuV.get(4L),
						ItemList.Robot_Arm_LuV.get(4L),
						new Object[]{OrePrefixes.circuit.get(Materials.Master), 8},
						GT_OreDictUnificator.get(OrePrefixes.wireGt04, Materials.YttriumBariumCuprate, 16),
						GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Chrome, 16),
						GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.HSSE, 32)
				},
				new FluidStack[]{
						Materials.SolderingAlloy.getMolten(1152),
						Materials.Lubricant.getFluid(1000),
						new FluidStack(FluidRegistry.getFluid("ic2coolant"), 1000)
				},
				GT_ItemList.UpgradeCasingT2.get(1L), 120 * 20, 30720
		);
		
		//UpgradeCasingT3
		RA.addAssemblylineRecipe(GT_ItemList.UpgradeCasingT2.get(1L), 288000, new Object[]{
						ItemList.Hull_ZPM.get(1L),
						GT_ModHandler.getModItem(AE2, "tile.BlockAdvancedCraftingStorage", 1, 1),
						GT_ItemList.UpgradeCasingT2.get(4L),
						GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Lafium, 16),
						ItemList.Electric_Motor_ZPM.get(4L),
						ItemList.Electric_Piston_ZPM.get(4L),
						ItemList.Conveyor_Module_ZPM.get(4L),
						ItemList.Robot_Arm_ZPM.get(4L),
						new Object[]{OrePrefixes.circuit.get(Materials.Ultimate), 8},
						GT_OreDictUnificator.get(OrePrefixes.wireGt04, Materials.Naquadah, 16),
						GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Iridium, 16),
						GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.HSSE, 48)
				},
				new FluidStack[]{
						Materials.SolderingAlloy.getMolten(2304),
						Materials.Lubricant.getFluid(2000),
						new FluidStack(FluidRegistry.getFluid("ic2coolant"), 2000)
				},
				GT_ItemList.UpgradeCasingT3.get(1L), 160 * 20, 122880
		);
		
		//UpgradeCasingT4
		RA.addAssemblylineRecipe(GT_ItemList.UpgradeCasingT3.get(1L), 576000, new Object[]{
						ItemList.Hull_UV.get(1L),
						GT_ModHandler.getModItem(AE2, "tile.BlockAdvancedCraftingStorage", 1, 2),
						GT_ItemList.UpgradeCasingT3.get(4L),
						GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.CinobiteA243, 16),
						ItemList.Electric_Motor_UV.get(4L),
						ItemList.Electric_Piston_UV.get(4L),
						ItemList.Conveyor_Module_UV.get(4L),
						ItemList.Robot_Arm_UV.get(4L),
						new Object[]{OrePrefixes.circuit.get(Materials.Superconductor), 8},
						GT_OreDictUnificator.get(OrePrefixes.wireGt04, Materials.NaquadahAlloy, 16),
						GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Osmium, 16),
						GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.HSSE, 64)
				},
				new FluidStack[]{
						Materials.SolderingAlloy.getMolten(4608),
						Materials.Lubricant.getFluid(4000),
						new FluidStack(FluidRegistry.getFluid("ic2coolant"), 4000)
				},
				GT_ItemList.UpgradeCasingT4.get(1L), 200 * 20, 500000
		);
		
		//Naquadah Chamber Casing
		RA.addAssemblylineRecipe(CoreItems2.getRecipe(163, 1), 144000, new Object[]{
						GT_ItemList.NqCasing.get(1),
						CoreItems2.getRecipe(163, 6),
						ItemList.Electric_Pump_LuV.get(4L),
						GT_OreDictUnificator.get(OrePrefixes.plateDense, Materials.Europium, 1),
						GT_OreDictUnificator.get(OrePrefixes.plateTriple, Materials.Plutonium, 2),
						GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Lead, 4),
						GT_OreDictUnificator.get(OrePrefixes.plate, Materials.NaquadahAlloy, 10),
						GT_OreDictUnificator.get(OrePrefixes.screw, Materials.Desh, 16)
				},
				new FluidStack[]{
						Materials.Trinium.getMolten(1296),
						Materials.Osmium.getMolten(1296),
						new FluidStack(FluidRegistry.getFluid("ic2coolant"), 2000),
						Materials.Argon.getGas(1000)
				},
				new ItemStack(InsideBlock, 1, 0), 120 * 20, 10000
		);
		
		//Tether Core
		RA.addAssemblylineRecipe(CoreItems2.getRecipe(162, 1), 156000, new Object[]{
						CoreItems2.getRecipe(162, 6),
						ItemList.Electric_Piston_LuV.get(8L),
						ItemList.Emitter_LuV.get(8L),
						ItemList.Sensor_LuV.get(8L),
						CoreItems2.getRecipe(50, 10),
						new Object[]{OrePrefixes.circuit.get(Materials.Master), 16},
						GT_OreDictUnificator.get(OrePrefixes.plateDense, Materials.NaquadahAlloy, 8),
						GT_OreDictUnificator.get(OrePrefixes.plateDense, Materials.NaquadahAlloy, 8),
						GT_OreDictUnificator.get(OrePrefixes.gemExquisite, Materials.Diamond, 16),
						GT_OreDictUnificator.get(OrePrefixes.gemExquisite, Materials.Diamond, 16)
				},
				new FluidStack[]{
						Materials.Duranium.getMolten(1296),
						Materials.Osmiridium.getMolten(1296),
						Materials.Tetraindiumditindibariumtitaniumheptacoppertetrakaidekaoxid.getMolten(1296),
						Materials.NiobiumTitanium.getMolten(1296)
				},
				new ItemStack(NqTetherBlock, 1, 0), 160 * 20, 14576
		);
		
		//Heavy Metal Cyclon
		RA.addAssemblylineRecipe(
				GT_OreDictUnificator.get(OrePrefixes.pipeHuge, Materials.Inconel792, 1), 156000,
				new Object[]{
						ItemList.Hull_LuV.get(1L),
						GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Inconel792, 4),
						new Object[]{OrePrefixes.circuit.get(Materials.Master), 4},
						Itemstack(Core_Items2.getInstance(), 1, 182),
						ItemList.Electric_Motor_LuV.get(4L),
						ItemList.Electric_Pump_LuV.get(4L),
						ItemList.Conveyor_Module_LuV.get(4L),
						GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Inconel792, 8),
						GT_OreDictUnificator.get(OrePrefixes.stickLong, Materials.HSSS, 4),
						GT_OreDictUnificator.get(OrePrefixes.gear, Materials.TiBetaC, 8),
						GT_OreDictUnificator.get(OrePrefixes.gearGtSmall, Materials.TiBetaC, 8),
						GT_OreDictUnificator.get(OrePrefixes.gearGtSmall, Materials.HSSS, 8),
						GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.HSSG, 16),
						GT_OreDictUnificator.get(OrePrefixes.screw, Materials.HSSG, 16)
				},
				new FluidStack[]{
						Materials.SolderingAlloy.getMolten(1152),
						Materials.Lubricant.getFluid(1000),
						new FluidStack(FluidRegistry.getFluid("ic2coolant"), 1000),
						Materials.Osmiridium.getMolten(1152)
				},
				GT_ItemList.Heavy_Metal_Cyclone.get(1L), 160 * 20, 30720
		);
		
		//Naquadah Generator
		RA.addAssemblylineRecipe(
				GT_OreDictUnificator.get(OrePrefixes.pipeHuge, Materials.MaragingSteel300, 1), 172000,
				new Object[]{
						GT_ModHandler.getModItem("impact", "impact_inside_block", 1),
						GT_OreDictUnificator.get(OrePrefixes.pipeLarge, Materials.MaragingSteel300, 4),
						ItemList.Electric_Pump_LuV.get(4L),
						ItemList.Field_Generator_LuV.get(4L),
						ItemList.Sensor_LuV.get(4L),
						new Object[]{OrePrefixes.circuit.get(Materials.Master), 4L},
						GT_OreDictUnificator.get(OrePrefixes.wireGt04, Materials.SuperconductorLuV, 8),
						GT_OreDictUnificator.get(OrePrefixes.lens, Materials.Ruby, 8)
				},
				new FluidStack[]{
						Materials.SolderingAlloy.getMolten(1152),
						Materials.Lubricant.getFluid(1000),
						new FluidStack(FluidRegistry.getFluid("ic2coolant"), 1000),
						Materials.Trinium.getMolten(1152)
				},
				GT_ItemList.Naquadah_Liquid_multi.get(1L), 240 * 20, 26780
		);
		
		//Naquadah Enriched Generator
		RA.addAssemblylineRecipe(
				GT_OreDictUnificator.get(OrePrefixes.pipeHuge, Materials.Inconel690, 1), 256000,
				new Object[]{
						GT_ModHandler.getModItem("impact", "impact_nqtether_block", 1),
						GT_OreDictUnificator.get(OrePrefixes.pipeLarge, Materials.Inconel690, 6),
						ItemList.Electric_Pump_ZPM.get(6L),
						ItemList.Field_Generator_ZPM.get(8L),
						ItemList.Sensor_ZPM.get(8L),
						new Object[]{OrePrefixes.circuit.get(Materials.Ultimate), 8},
						GT_OreDictUnificator.get(OrePrefixes.wireGt04, Materials.SuperconductorZPM, 16),
						GT_OreDictUnificator.get(OrePrefixes.lens, Materials.Sapphire, 16)
				},
				new FluidStack[]{
						Materials.SolderingAlloy.getMolten(2304),
						Materials.Lubricant.getFluid(2000),
						new FluidStack(FluidRegistry.getFluid("ic2coolant"), 2000),
						Materials.Oriharukon.getMolten(2304)
				},
				GT_ItemList.Naquadah_Liquid_Enriched.get(1L), 320 * 20, 118236
		);
		
		//Parallel Supercomputer
		RA.addAssemblylineRecipe(
				GT_ModHandler.getModItem(AE2, "tile.BlockController", 1), 172000,
				new Object[]{
						GT_ModHandler.getModItem(AE2, "tile.BlockController", 1),
						new Object[]{OrePrefixes.circuit.get(Materials.Elite), 4},
						ItemList.Tool_DataOrb.get(1L),
						Itemstack(Core_Items2.getInstance(), 1, 182),
						GT_OreDictUnificator.get(OrePrefixes.wireGt04, Materials.SuperconductorIV, 4),
						GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Duraluminium, 8),
						GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.HSSG, 16),
						GT_OreDictUnificator.get(OrePrefixes.screw, Materials.HSSE, 16)
				},
				new FluidStack[]{
						Materials.SolderingAlloy.getMolten(2304),
						Materials.Lubricant.getFluid(2000),
						new FluidStack(FluidRegistry.getFluid("ic2coolant"), 2000),
						Materials.Hydrogen.getGas(2000)
				},
				GT_ItemList.Parallel_Computer.get(1L), 100 * 20, 30720
		);
	}
	
	public void wireassembler() {
		// --- Space Elevator Hawser
		RA.addWireAssemblerRecipe(new ItemStack[]{
						GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.HSLA, 1L),
						GT_OreDictUnificator.get(OrePrefixes.wireGt08, Materials.Steel, 64L),
						GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Vanadium, 64L)}, null,
				new ItemStack(SpaceElevatorBlock, 1, 0), 80 * 20, 1024, false
		);
		
		// --- Long Distance Pipe Line Energy
		//LV
		RA.addWireAssemblerRecipe(
				new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Steel, 1L),
						GT_OreDictUnificator.get(OrePrefixes.cableGt16, Materials.Tin, 4L),
						GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Steel, 6L),
						GT_Utility.getIntegratedCircuit(24)}, Materials.Rubber.getMolten(1440L),
				GT_ItemList.LDPFE_LV.get(32L), 600, 24
		);
		RA.addWireAssemblerRecipe(
				new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Steel, 1L),
						GT_OreDictUnificator.get(OrePrefixes.cableGt16, Materials.Tin, 4L),
						GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Steel, 6L),
						GT_Utility.getIntegratedCircuit(24)}, Materials.StyreneButadieneRubber.getMolten(1080L),
				GT_ItemList.LDPFE_LV.get(32L), 600, 24
		);
		RA.addWireAssemblerRecipe(
				new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Steel, 1L),
						GT_OreDictUnificator.get(OrePrefixes.cableGt16, Materials.Tin, 4L),
						GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Steel, 6L),
						GT_Utility.getIntegratedCircuit(24)}, Materials.Silicone.getMolten(720L),
				GT_ItemList.LDPFE_LV.get(32L), 600, 24
		);
		//MV
		RA.addWireAssemblerRecipe(
				new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Birmabright, 1L),
						GT_OreDictUnificator.get(OrePrefixes.cableGt16, Materials.Copper, 4L),
						GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Birmabright, 6L),
						GT_Utility.getIntegratedCircuit(24)}, Materials.Rubber.getMolten(1440L),
				GT_ItemList.LDPFE_MV.get(32L), 600, 96
		);
		RA.addWireAssemblerRecipe(
				new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Birmabright, 1L),
						GT_OreDictUnificator.get(OrePrefixes.cableGt16, Materials.Copper, 4L),
						GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Birmabright, 6L),
						GT_Utility.getIntegratedCircuit(24)}, Materials.StyreneButadieneRubber.getMolten(1080L),
				GT_ItemList.LDPFE_MV.get(32L), 600, 96
		);
		RA.addWireAssemblerRecipe(
				new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Birmabright, 1L),
						GT_OreDictUnificator.get(OrePrefixes.cableGt16, Materials.Copper, 4L),
						GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Birmabright, 6L),
						GT_Utility.getIntegratedCircuit(24)}, Materials.Silicone.getMolten(720L),
				GT_ItemList.LDPFE_MV.get(32L), 600, 96
		);
		//HV
		RA.addWireAssemblerRecipe(
				new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.StainlessSteel, 1L),
						GT_OreDictUnificator.get(OrePrefixes.cableGt16, Materials.Gold, 4L),
						GT_OreDictUnificator.get(OrePrefixes.plate, Materials.StainlessSteel, 6L),
						GT_Utility.getIntegratedCircuit(24)}, Materials.Rubber.getMolten(1440L),
				GT_ItemList.LDPFE_HV.get(32L), 600, 480
		);
		RA.addWireAssemblerRecipe(
				new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.StainlessSteel, 1L),
						GT_OreDictUnificator.get(OrePrefixes.cableGt16, Materials.Gold, 4L),
						GT_OreDictUnificator.get(OrePrefixes.plate, Materials.StainlessSteel, 6L),
						GT_Utility.getIntegratedCircuit(24)}, Materials.StyreneButadieneRubber.getMolten(1080L),
				GT_ItemList.LDPFE_HV.get(32L), 600, 480
		);
		RA.addWireAssemblerRecipe(
				new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.StainlessSteel, 1L),
						GT_OreDictUnificator.get(OrePrefixes.cableGt16, Materials.Gold, 4L),
						GT_OreDictUnificator.get(OrePrefixes.plate, Materials.StainlessSteel, 6L),
						GT_Utility.getIntegratedCircuit(24)}, Materials.Silicone.getMolten(720L),
				GT_ItemList.LDPFE_HV.get(32L), 600, 480
		);
		//EV
		RA.addWireAssemblerRecipe(
				new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.BT6, 1L),
						GT_OreDictUnificator.get(OrePrefixes.cableGt16, Materials.Aluminium, 4L),
						GT_OreDictUnificator.get(OrePrefixes.plate, Materials.BT6, 6L),
						GT_Utility.getIntegratedCircuit(24)}, Materials.Rubber.getMolten(1440L),
				GT_ItemList.LDPFE_EV.get(32L), 600, 1920
		);
		RA.addWireAssemblerRecipe(
				new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.BT6, 1L),
						GT_OreDictUnificator.get(OrePrefixes.cableGt16, Materials.Aluminium, 4L),
						GT_OreDictUnificator.get(OrePrefixes.plate, Materials.BT6, 6L),
						GT_Utility.getIntegratedCircuit(24)}, Materials.StyreneButadieneRubber.getMolten(1080L),
				GT_ItemList.LDPFE_EV.get(32L), 600, 1920
		);
		RA.addWireAssemblerRecipe(
				new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.BT6, 1L),
						GT_OreDictUnificator.get(OrePrefixes.cableGt16, Materials.Aluminium, 4L),
						GT_OreDictUnificator.get(OrePrefixes.plate, Materials.BT6, 6L),
						GT_Utility.getIntegratedCircuit(24)}, Materials.Silicone.getMolten(720L),
				GT_ItemList.LDPFE_EV.get(32L), 600, 1920
		);
		//IV
		RA.addWireAssemblerRecipe(
				new ItemStack[]{
						GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.HastelloyC276, 1L),
						GT_OreDictUnificator.get(OrePrefixes.cableGt16, Materials.Platinum, 4L),
						GT_OreDictUnificator.get(OrePrefixes.plate, Materials.HastelloyC276, 6L),
						GT_OreDictUnificator.get(OrePrefixes.foil, Materials.PolyphenyleneSulfide, 10L),
						GT_Utility.getIntegratedCircuit(24)}, Materials.Silicone.getMolten(720L),
				GT_ItemList.LDPFE_IV.get(32L), 600, 7680
		);
		RA.addWireAssemblerRecipe(
				new ItemStack[]{
						GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.HastelloyC276, 1L),
						GT_OreDictUnificator.get(OrePrefixes.cableGt16, Materials.Platinum, 4L),
						GT_OreDictUnificator.get(OrePrefixes.plate, Materials.HastelloyC276, 6L),
						GT_OreDictUnificator.get(OrePrefixes.dust, Materials.PolyvinylChloride, 10L),
						GT_OreDictUnificator.get(OrePrefixes.foil, Materials.PolyphenyleneSulfide, 20L),
						GT_Utility.getIntegratedCircuit(24)}, Materials.StyreneButadieneRubber.getMolten(1440L),
				GT_ItemList.LDPFE_IV.get(32L), 600, 7680
		);
		RA.addWireAssemblerRecipe(
				new ItemStack[]{
						GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.HastelloyC276, 1L),
						GT_OreDictUnificator.get(OrePrefixes.cableGt16, Materials.Platinum, 4L),
						GT_OreDictUnificator.get(OrePrefixes.plate, Materials.HastelloyC276, 6L),
						GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Polydimethylsiloxane, 10L),
						GT_OreDictUnificator.get(OrePrefixes.foil, Materials.PolyphenyleneSulfide, 20L),
						GT_Utility.getIntegratedCircuit(24)}, Materials.StyreneButadieneRubber.getMolten(1440L),
				GT_ItemList.LDPFE_IV.get(32L), 600, 7680
		);
	}
	
	private void disassembler() {
		//Parallel Hatch 4P IN
		RA.addDisassemblerRecipe(
				GT_ItemList.Parallel_Hatch_IN4.get(1), new ItemStack[]{ItemList.Hull_IV.get(1),
						GT_ModHandler.getModItem(AE2, "tile.BlockCraftingStorage", 1L, 1),
						ItemList.Sensor_IV.get(1), ItemList.Circuit_Elite.get(4)}, 6000, 7680);
		//Parallel Hatch 4P OUT
		RA.addDisassemblerRecipe(
				GT_ItemList.Parallel_Hatch_OUT4.get(1), new ItemStack[]{ItemList.Hull_IV.get(1),
						GT_ModHandler.getModItem(AE2, "tile.BlockCraftingStorage", 1L, 1),
						ItemList.Emitter_IV.get(1), ItemList.Circuit_Elite.get(4)}, 6000, 7680);
		//Parallel Hatch 16P IN
		RA.addDisassemblerRecipe(
				GT_ItemList.Parallel_Hatch_IN16.get(1), new ItemStack[]{ItemList.Hull_LuV.get(1),
						GT_ModHandler.getModItem(AE2, "tile.BlockCraftingStorage", 1L, 2),
						ItemList.Sensor_LuV.get(1), ItemList.Circuit_Master.get(4)}, 8000, 30720);
		//Parallel Hatch 16P OUT
		RA.addDisassemblerRecipe(
				GT_ItemList.Parallel_Hatch_OUT16.get(1), new ItemStack[]{ItemList.Hull_LuV.get(1),
						GT_ModHandler.getModItem(AE2, "tile.BlockCraftingStorage", 1L, 2),
						ItemList.Emitter_LuV.get(1), ItemList.Circuit_Master.get(4)}, 8000, 30720);
		//Parallel Hatch 64P IN
		RA.addDisassemblerRecipe(
				GT_ItemList.Parallel_Hatch_IN64.get(1), new ItemStack[]{ItemList.Hull_ZPM.get(1),
						GT_ModHandler.getModItem(AE2, "tile.BlockCraftingStorage", 1L, 3),
						ItemList.Sensor_ZPM.get(1), ItemList.Circuit_Quantummainframe.get(4)}, 10000, 122880);
		//Parallel Hatch 64P OUT
		RA.addDisassemblerRecipe(
				GT_ItemList.Parallel_Hatch_OUT64.get(1), new ItemStack[]{ItemList.Hull_ZPM.get(1),
						GT_ModHandler.getModItem(AE2, "tile.BlockCraftingStorage", 1L, 3),
						ItemList.Emitter_ZPM.get(1), ItemList.Circuit_Quantummainframe.get(4)}, 10000, 122880);
		//Parallel Hatch 256P IN
		RA.addDisassemblerRecipe(
				GT_ItemList.Parallel_Hatch_IN256.get(1), new ItemStack[]{ItemList.Hull_UV.get(1),
						GT_ModHandler.getModItem(AE2, "tile.BlockAdvancedCraftingStorage", 1L),
						ItemList.Sensor_UV.get(1), ItemList.Circuit_Crystalmainframe.get(4L)}, 12000, 500000);
		//Parallel Hatch 256P OUT
		RA.addDisassemblerRecipe(
				GT_ItemList.Parallel_Hatch_OUT256.get(1), new ItemStack[]{ItemList.Hull_UV.get(1),
						GT_ModHandler.getModItem(AE2, "tile.BlockAdvancedCraftingStorage", 1L),
						ItemList.Emitter_UV.get(1), ItemList.Circuit_Crystalmainframe.get(4L)}, 12000, 500000);
		
		//SolarPanel
		RA.addDisassemblerRecipe(
                GT_ItemList.Solar_ULV.get(1),
				new ItemStack[]{ItemList.Cover_SolarPanel_8V.get(1L), GT_ItemList.ULVRobotArm.get(1L),
						ItemList.Large_Fluid_Cell_Steel.get(1L), ItemList.Sensor_LV.get(1L),
						GT_ModHandler.getModItem("IC2", "itemPartCircuit", 1L),
						GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Silicon, 6),
						ItemList.Battery_Buffer_2by2_ULV.get(1L)}, 1000, 30
		);
		RA.addDisassemblerRecipe(
                GT_ItemList.Solar_LV.get(1),
				new ItemStack[]{ItemList.Cover_SolarPanel_LV.get(1L), ItemList.Robot_Arm_LV.get(1L),
						ItemList.Large_Fluid_Cell_Aluminium.get(1L), ItemList.Sensor_MV.get(1L),
						ItemList.Circuit_Good.get(4), GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Silicon, 6),
						ItemList.Battery_Buffer_2by2_LV.get(1L)}, 2000, 120
		);
		RA.addDisassemblerRecipe(
                GT_ItemList.Solar_MV.get(1),
				new ItemStack[]{ItemList.Cover_SolarPanel_MV.get(1L), ItemList.Robot_Arm_MV.get(1L),
						ItemList.Large_Fluid_Cell_StainlessSteel.get(1L), ItemList.Sensor_HV.get(1L),
						GT_ModHandler.getModItem("IC2", "itemPartCircuitAdv", 6L),
						GT_OreDictUnificator.get(OrePrefixes.plateTriple, Materials.Silicon, 6),
						ItemList.Battery_Buffer_2by2_MV.get(1L)}, 3000, 480
		);
		RA.addDisassemblerRecipe(
                GT_ItemList.Solar_HV.get(1),
				new ItemStack[]{ItemList.Cover_SolarPanel_HV.get(1L), ItemList.Robot_Arm_HV.get(1L),
						ItemList.Large_Fluid_Cell_Titanium.get(1L), ItemList.Sensor_EV.get(1L),
						ItemList.Circuit_Data.get(8), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.GalliumArsenide, 8),
						ItemList.Battery_Buffer_2by2_HV.get(1L)}, 4000, 1920
		);
		RA.addDisassemblerRecipe(
                GT_ItemList.Solar_EV.get(1),
				new ItemStack[]{ItemList.Cover_SolarPanel_EV.get(1L), ItemList.Robot_Arm_EV.get(1L),
						ItemList.Large_Fluid_Cell_TungstenSteel.get(1L), ItemList.Sensor_IV.get(1L),
						ItemList.Circuit_Elite.get(10), GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.GalliumArsenide, 8),
						ItemList.Battery_Buffer_2by2_EV.get(1L)}, 5000, 7680
		);
		RA.addDisassemblerRecipe(
                GT_ItemList.Solar_IV.get(1),
				new ItemStack[]{ItemList.Cover_SolarPanel_IV.get(1L), ItemList.Robot_Arm_IV.get(1L),
						ItemList.Large_Fluid_Cell_Chrome.get(1L), ItemList.Sensor_LuV.get(1L),
						ItemList.Circuit_Master.get(12),
						GT_OreDictUnificator.get(OrePrefixes.plateTriple, Materials.GalliumArsenide, 8),
						ItemList.Battery_Buffer_2by2_IV.get(1L)}, 6000, 30720
		);
		RA.addDisassemblerRecipe(
                GT_ItemList.Solar_LuV.get(1),
				new ItemStack[]{ItemList.Cover_SolarPanel_LuV.get(1L), ItemList.Robot_Arm_LuV.get(1L),
						ItemList.Large_Fluid_Cell_Iridium.get(1L), ItemList.Sensor_ZPM.get(1L),
						ItemList.Circuit_Quantummainframe.get(14),
						GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Sunnarium, 10),
						ItemList.Battery_Buffer_2by2_LuV.get(1L)}, 7000, 122880
		);
		RA.addDisassemblerRecipe(
                GT_ItemList.Solar_ZPM.get(1),
				new ItemStack[]{ItemList.Cover_SolarPanel_ZPM.get(1L), ItemList.Robot_Arm_ZPM.get(1L),
						ItemList.Large_Fluid_Cell_Osmium.get(1L), ItemList.Sensor_UV.get(1L),
						ItemList.Circuit_Crystalmainframe.get(16L),
						GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Sunnarium, 10),
						ItemList.Battery_Buffer_2by2_ZPM.get(1L)}, 8000, 500000
		);
		RA.addDisassemblerRecipe(
                GT_ItemList.Solar_UV.get(1),
				new ItemStack[]{ItemList.Cover_SolarPanel_UV.get(1L), ItemList.Robot_Arm_UV.get(1L),
						ItemList.Large_Fluid_Cell_Neutronium.get(1L), ItemList.Sensor_UHV.get(1L),
						ItemList.Circuit_Wetwaremainframe.get(18),
						GT_OreDictUnificator.get(OrePrefixes.plateTriple, Materials.Sunnarium, 10),
						ItemList.Battery_Buffer_2by2_UV.get(1L)}, 10000, 500000
		);
		
		//LapotronicCapacitorIV
		RA.addDisassemblerRecipe(
				new ItemStack(lscLapotronicEnergyUnit, 1, 1),
				new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Inconel792, 1),
						ItemList.Energy_LapotronicOrb.get(4L), GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Platinum, 8),
						ItemList.Circuit_Chip_PIC.get(12L),
						GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.TungstenSteel, 32),
						GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.HastelloyC276, 64),
						GT_OreDictUnificator.get(OrePrefixes.screw, Materials.HSSG, 64)}, 1000 * 20, 7680
		);
		
		//Energium Orb Capacitor
		RA.addDisassemblerRecipe(
				new ItemStack(lscLapotronicEnergyUnit, 1, 6),
				new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Inconel792, 1),
						ItemList.EnergyCrystal_IV.get(4L),
						GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Platinum, 8),
						ItemList.Circuit_Chip_PIC.get(12L),
						GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.TungstenSteel, 32),
						GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.HastelloyC276, 64),
						GT_OreDictUnificator.get(OrePrefixes.screw, Materials.HSSG, 64)}, 1000 * 20, 7680
		);
		
		//LapotronicCapacitorLuV
		RA.addDisassemblerRecipe(
				new ItemStack(lscLapotronicEnergyUnit, 1, 2),
				new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Inconel792, 1),
						ItemList.Energy_LapotronicOrb2.get(4L),
						GT_OreDictUnificator.get(OrePrefixes.foil, Materials.NiobiumTitanium, 8),
						ItemList.Circuit_Chip_HPIC.get(12L),
						GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.YttriumBariumCuprate, 32),
						GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.HastelloyN, 64),
						GT_OreDictUnificator.get(OrePrefixes.screw, Materials.HSSE, 64)}, 1200 * 20, 30720
		);
		
		//LapotronicCapacitorZPM
		RA.addDisassemblerRecipe(
				new ItemStack(lscLapotronicEnergyUnit, 1, 3),
				new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Inconel792, 1),
						ItemList.Energy_Module.get(4L),
						GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Osmiridium, 8),
						ItemList.Circuit_Chip_UHPIC.get(12L),
						GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Naquadah, 32),
						GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Lafium, 64),
						GT_OreDictUnificator.get(OrePrefixes.screw, Materials.HSSS, 64)}, 1400 * 20, 122880
		);
		
		//LapotronicCapacitorUV
		RA.addBasicLineRecipe(new ItemStack[]{
				GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Inconel792, 1),
				ItemList.Energy_Cluster.get(4L),
				GT_OreDictUnificator.get(OrePrefixes.foil, Materials.NaquadahAlloy, 8),
				ItemList.Circuit_Chip_NPIC.get(12L),
				GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Duranium, 32),
				GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.CinobiteA243, 64),
				GT_OreDictUnificator.get(OrePrefixes.screw, Materials.Tritanium, 64)
		}, new ItemStack(lscLapotronicEnergyUnit, 1, 4), null, 1600 * 20, 500000);
		
		//LapotronicCapacitorUHV
		//RA.addDisassemblerRecipe(
		//		new ItemStack(lscLapotronicEnergyUnit, 1, 5),
		//		new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Inconel792, 1),
		//				ItemList.ZPM2.get(4L), GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Americium, 8),
		//				ItemList.Circuit_Chip_PPIC.get(12L),
		//				GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Europium, 32),
		//				GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Pikyonium64B, 64),
		//				GT_OreDictUnificator.get(OrePrefixes.screw, Materials.Neutronium, 64)}, 1800 * 20, 500000
		//);
		
		//Mysterious Crystal Orb Capacitor
		RA.addDisassemblerRecipe(
				new ItemStack(lscLapotronicEnergyUnit, 1, 7),
				new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Inconel792, 1),
						ItemList.MysteriousCrystalOrb.get(4L), GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Americium, 8),
						ItemList.Circuit_Chip_PPIC.get(12L),
						GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Europium, 32),
						GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Pikyonium64B, 64),
						GT_OreDictUnificator.get(OrePrefixes.screw, Materials.Neutronium, 64)}, 1800 * 20, 500000
		);
		
		//Mysterious Crystal Module Capacitor
		RA.addDisassemblerRecipe(
				new ItemStack(lscLapotronicEnergyUnit, 1, 8),
				new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Inconel792, 1),
						ItemList.MysteriousCrystalModule.get(4L), GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Neutronium, 8),
						ItemList.Circuit_Chip_QPIC.get(12L),
						GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Draconium, 32),
						GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Quantum, 64),
						GT_OreDictUnificator.get(OrePrefixes.screw, Materials.Phoenixite, 64)}, 2000 * 20, 500000
		);

		//Dynamo Hatches IV-UHV
		RA.addDisassemblerRecipe(
				GT_ItemList.DynamoMulti2_EV.get(1), new ItemStack[]{ItemList.Hatch_Dynamo_EV.get(1L),
						ItemList.EV_Coil.get(2),
						GT_OreDictUnificator.get(OrePrefixes.wireGt02, Materials.SuperconductorEV, 4),
						GT_OreDictUnificator.get(OrePrefixes.plateTriple, Materials.BT6, 2)}, 500, 1920);

		RA.addDisassemblerRecipe(
				GT_ItemList.DynamoMulti2_IV.get(1), new ItemStack[]{ItemList.Hatch_Dynamo_IV.get(1L),
						ItemList.IV_Coil.get(2),
						GT_OreDictUnificator.get(OrePrefixes.wireGt02, Materials.SuperconductorIV, 4),
						GT_OreDictUnificator.get(OrePrefixes.plateTriple, Materials.Nitinol, 2)}, 500, 7680);
		RA.addDisassemblerRecipe(
				GT_ItemList.DynamoMulti4_IV.get(1), new ItemStack[]{ItemList.Transformer_LuV_IV.get(1L),
						GT_ItemList.DynamoMulti2_IV.get(1L),
						ItemList.Circuit_Chip_HPIC.get(4L),
						ItemList.IV_Coil.get(4),
						GT_OreDictUnificator.get(OrePrefixes.wireGt04, Materials.SuperconductorIV, 8),
						GT_OreDictUnificator.get(OrePrefixes.plateDense, Materials.Nitinol, 2)}, 1000, 7680);

		RA.addDisassemblerRecipe(
				GT_ItemList.DynamoMulti2_LuV.get(1), new ItemStack[]{ItemList.Hatch_Dynamo_LuV.get(1),
						ItemList.LuV_Coil.get(2),
						GT_OreDictUnificator.get(OrePrefixes.wireGt02, Materials.SuperconductorLuV, 4),
						GT_OreDictUnificator.get(OrePrefixes.plateTriple, Materials.HastelloyN, 2)}, 500, 30720);
		RA.addDisassemblerRecipe(
				GT_ItemList.DynamoMulti4_LuV.get(1), new ItemStack[]{ItemList.Transformer_ZPM_LuV.get(1L),
						GT_ItemList.DynamoMulti2_LuV.get(1),
						ItemList.Circuit_Chip_UHPIC.get(4),
						ItemList.LuV_Coil.get(4),
						GT_OreDictUnificator.get(OrePrefixes.wireGt04, Materials.SuperconductorLuV, 8),
						GT_OreDictUnificator.get(OrePrefixes.plateDense, Materials.HastelloyN, 2)}, 1000, 30720);
		RA.addDisassemblerRecipe(
				GT_ItemList.DynamoMulti16_LuV.get(1), new ItemStack[]{ItemList.Transformer_HA_ZPM_LuV.get(1L),
						GT_ItemList.DynamoMulti4_LuV.get(1),
						ItemList.Circuit_Chip_UHPIC.get(8),
						ItemList.LuV_Coil.get(16),
						GT_OreDictUnificator.get(OrePrefixes.wireGt08, Materials.SuperconductorLuV, 16),
						GT_OreDictUnificator.get(OrePrefixes.plateDense, Materials.HastelloyN, 4)}, 2000, 30720);

		RA.addDisassemblerRecipe(
				GT_ItemList.DynamoMulti2_ZPM.get(1), new ItemStack[]{ItemList.Hatch_Dynamo_ZPM.get(1),
						ItemList.ZPM_Coil.get(2),
						GT_OreDictUnificator.get(OrePrefixes.wireGt02, Materials.SuperconductorZPM, 4),
						GT_OreDictUnificator.get(OrePrefixes.plateTriple, Materials.Lafium, 2)}, 500, 122880);
		RA.addDisassemblerRecipe(
				GT_ItemList.DynamoMulti4_ZPM.get(1), new ItemStack[]{ItemList.Transformer_UV_ZPM.get(1L),
						GT_ItemList.DynamoMulti2_ZPM.get(1),
						GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Energy, 1),
						ItemList.Circuit_Chip_NPIC.get(4),
						ItemList.ZPM_Coil.get(4),
						GT_OreDictUnificator.get(OrePrefixes.wireGt04, Materials.SuperconductorZPM, 8),
						GT_OreDictUnificator.get(OrePrefixes.plateDense, Materials.Lafium, 2)}, 1000, 122880);
		RA.addDisassemblerRecipe(
				GT_ItemList.DynamoMulti16_ZPM.get(1), new ItemStack[]{ItemList.Transformer_HA_UV_ZPM.get(1L),
						GT_ItemList.DynamoMulti4_ZPM.get(1),
						GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Energy, 2),
						ItemList.Circuit_Chip_NPIC.get(8),
						ItemList.ZPM_Coil.get(16),
						GT_OreDictUnificator.get(OrePrefixes.wireGt08, Materials.SuperconductorZPM, 16),
						GT_OreDictUnificator.get(OrePrefixes.plateDense, Materials.Lafium, 4)}, 2000, 122880);
		RA.addDisassemblerRecipe(
				GT_ItemList.DynamoMulti64_ZPM.get(1), new ItemStack[]{ItemList.WetTransformer_UV_ZPM.get(1L),
						GT_ItemList.DynamoMulti16_ZPM.get(1),
						GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Energy, 4),
						ItemList.Circuit_Chip_NPIC.get(16),
						ItemList.ZPM_Coil.get(64),
						GT_OreDictUnificator.get(OrePrefixes.wireGt16, Materials.SuperconductorZPM, 32),
						GT_OreDictUnificator.get(OrePrefixes.plateDense, Materials.Lafium, 8)}, 4000, 122880);

		RA.addDisassemblerRecipe(
				GT_ItemList.DynamoMulti2_UV.get(1), new ItemStack[]{ItemList.Hatch_Dynamo_UV.get(1),
						ItemList.UV_Coil.get(2),
						GT_OreDictUnificator.get(OrePrefixes.wireGt02, Materials.SuperconductorUV, 4),
						GT_OreDictUnificator.get(OrePrefixes.plateTriple, Materials.CinobiteA243, 2)}, 500, 500000);
		RA.addDisassemblerRecipe(
				GT_ItemList.DynamoMulti4_ZPM.get(1), new ItemStack[]{ItemList.Transformer_UV_ZPM.get(1L),
						GT_ItemList.DynamoMulti2_UV.get(1),
						GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Energy, 1),
						ItemList.Circuit_Chip_PPIC.get(4),
						ItemList.UV_Coil.get(4),
						GT_OreDictUnificator.get(OrePrefixes.wireGt04, Materials.SuperconductorUV, 8),
						GT_OreDictUnificator.get(OrePrefixes.plateDense, Materials.CinobiteA243, 2)}, 1000, 500000);
		RA.addDisassemblerRecipe(
				GT_ItemList.DynamoMulti16_UV.get(1), new ItemStack[]{ItemList.Transformer_HA_UHV_UV.get(1),
						GT_ItemList.DynamoMulti4_UV.get(1),
						GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Energy, 2),
						ItemList.Circuit_Chip_PPIC.get(8),
						ItemList.UV_Coil.get(16),
						GT_OreDictUnificator.get(OrePrefixes.wireGt08, Materials.SuperconductorUV, 16),
						GT_OreDictUnificator.get(OrePrefixes.plateDense, Materials.CinobiteA243, 4)}, 2000, 500000);
		RA.addDisassemblerRecipe(
				GT_ItemList.DynamoMulti64_UV.get(1), new ItemStack[]{ItemList.WetTransformer_UHV_UV.get(1),
						GT_ItemList.DynamoMulti16_UV.get(1),
						GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Energy, 4),
						ItemList.Circuit_Chip_PPIC.get(16),
						ItemList.UV_Coil.get(64),
						GT_OreDictUnificator.get(OrePrefixes.wireGt16, Materials.SuperconductorUV, 32),
						GT_OreDictUnificator.get(OrePrefixes.plateDense, Materials.CinobiteA243, 8)}, 4000, 500000);

		RA.addDisassemblerRecipe(
				GT_ItemList.DynamoMulti2_UHV.get(1), new ItemStack[]{ItemList.Hatch_Dynamo_MAX.get(1),
						ItemList.UHV_Coil.get(2),
						GT_OreDictUnificator.get(OrePrefixes.wireGt02, Materials.Superconductor, 4),
						GT_OreDictUnificator.get(OrePrefixes.plateTriple, Materials.Pikyonium64B, 2)}, 500, 500000);
		RA.addDisassemblerRecipe(
				GT_ItemList.DynamoMulti4_UHV.get(1), new ItemStack[]{ItemList.Transformer_UEV_UHV.get(1L),
						GT_ItemList.DynamoMulti2_UHV.get(1),
						GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Energy, 1),
						ItemList.Circuit_Chip_QPIC.get(4),
						ItemList.UHV_Coil.get(4),
						GT_OreDictUnificator.get(OrePrefixes.wireGt04, Materials.Superconductor, 8),
						GT_OreDictUnificator.get(OrePrefixes.plateDense, Materials.Pikyonium64B, 2)}, 1000, 500000);
		RA.addDisassemblerRecipe(
				GT_ItemList.DynamoMulti16_UHV.get(1), new ItemStack[]{ItemList.Transformer_HA_UEV_UHV.get(1L),
						GT_ItemList.DynamoMulti4_UHV.get(1),
						GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Energy, 2),
						ItemList.Circuit_Chip_QPIC.get(8),
						ItemList.UHV_Coil.get(16),
						GT_OreDictUnificator.get(OrePrefixes.wireGt08, Materials.Superconductor, 16),
						GT_OreDictUnificator.get(OrePrefixes.plateDense, Materials.Pikyonium64B, 4)}, 2000, 500000);
		RA.addDisassemblerRecipe(
				GT_ItemList.DynamoMulti64_UHV.get(1), new ItemStack[]{ItemList.WetTransformer_UEV_UHV.get(1L),
						GT_ItemList.DynamoMulti16_UHV.get(1),
						GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Energy, 4),
						ItemList.Circuit_Chip_QPIC.get(16),
						ItemList.UHV_Coil.get(64),
						GT_OreDictUnificator.get(OrePrefixes.wireGt16, Materials.Superconductor, 32),
						GT_OreDictUnificator.get(OrePrefixes.plateDense, Materials.Pikyonium64B, 8)}, 4000, 500000);

		RA.addDisassemblerRecipe(
				GT_ItemList.DynamoMulti2_UEV.get(1), new ItemStack[]{ItemList.Hatch_Dynamo_UEV.get(1),
						ItemList.UEV_Coil.get(2),
						GT_OreDictUnificator.get(OrePrefixes.wireGt02, Materials.SuperconductorUEV, 4),
						GT_OreDictUnificator.get(OrePrefixes.plateTriple, Materials.Quantum, 2)}, 500, 500000);
		RA.addDisassemblerRecipe(
				GT_ItemList.DynamoMulti4_UEV.get(1), new ItemStack[]{ItemList.Transformer_UIV_UEV.get(1L),
						GT_ItemList.DynamoMulti2_UEV.get(1),
						GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Energy, 1),
						ItemList.Circuit_Chip_FPIC.get(4),
						ItemList.UEV_Coil.get(4),
						GT_OreDictUnificator.get(OrePrefixes.wireGt04, Materials.SuperconductorUEV, 8),
						GT_OreDictUnificator.get(OrePrefixes.plateDense, Materials.Quantum, 2)}, 1000, 500000);
		RA.addDisassemblerRecipe(
				GT_ItemList.DynamoMulti16_UEV.get(1), new ItemStack[]{ItemList.Transformer_HA_UIV_UEV.get(1L),
						GT_ItemList.DynamoMulti4_UEV.get(1),
						GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Energy, 2),
						ItemList.Circuit_Chip_FPIC.get(8),
						ItemList.UEV_Coil.get(16),
						GT_OreDictUnificator.get(OrePrefixes.wireGt08, Materials.SuperconductorUEV, 16),
						GT_OreDictUnificator.get(OrePrefixes.plateDense, Materials.Quantum, 4)}, 2000, 500000);
		RA.addDisassemblerRecipe(
				GT_ItemList.DynamoMulti64_UEV.get(1), new ItemStack[]{ItemList.WetTransformer_UIV_UEV.get(1L),
						GT_ItemList.DynamoMulti16_UEV.get(1),
						GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Energy, 4),
						ItemList.Circuit_Chip_FPIC.get(16),
						ItemList.UEV_Coil.get(64),
						GT_OreDictUnificator.get(OrePrefixes.wireGt16, Materials.SuperconductorUEV, 32),
						GT_OreDictUnificator.get(OrePrefixes.plateDense, Materials.Quantum, 8)}, 4000, 500000);

		//Energy Hatches 4A-64A  IV-UHV
		RA.addDisassemblerRecipe(
				GT_ItemList.EnergyMulti4_IV.get(1), new ItemStack[]{ItemList.Transformer_LuV_IV.get(1L),
						ItemList.Hatch_Energy_IV.get(1),
						ItemList.Circuit_Chip_HPIC.get(4),
						ItemList.IV_Coil.get(4),
						GT_OreDictUnificator.get(OrePrefixes.wireGt04, Materials.SuperconductorIV, 8),
						GT_OreDictUnificator.get(OrePrefixes.plateDense, Materials.Nitinol, 2)}, 1000, 7680);

		RA.addDisassemblerRecipe(
				GT_ItemList.EnergyMulti4_LuV.get(1), new ItemStack[]{ItemList.Transformer_ZPM_LuV.get(1L),
						ItemList.Hatch_Energy_LuV.get(1),
						ItemList.Circuit_Chip_UHPIC.get(4),
						ItemList.LuV_Coil.get(4),
						GT_OreDictUnificator.get(OrePrefixes.wireGt04, Materials.SuperconductorLuV, 8),
						GT_OreDictUnificator.get(OrePrefixes.plateDense, Materials.HastelloyN, 2)}, 1000, 30720);
		RA.addDisassemblerRecipe(
				GT_ItemList.EnergyMulti16_LuV.get(1), new ItemStack[]{ItemList.Transformer_HA_ZPM_LuV.get(1L),
						GT_ItemList.EnergyMulti4_LuV.get(1),
						ItemList.Circuit_Chip_UHPIC.get(8),
						ItemList.LuV_Coil.get(16),
						GT_OreDictUnificator.get(OrePrefixes.wireGt08, Materials.SuperconductorLuV, 16),
						GT_OreDictUnificator.get(OrePrefixes.plateDense, Materials.HastelloyN, 4)}, 2000, 30720);

		RA.addDisassemblerRecipe(
				GT_ItemList.EnergyMulti4_ZPM.get(1), new ItemStack[]{ItemList.Transformer_UV_ZPM.get(1L),
						ItemList.Hatch_Energy_ZPM.get(1),
						GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Energy, 1),
						ItemList.Circuit_Chip_NPIC.get(4),
						ItemList.ZPM_Coil.get(4),
						GT_OreDictUnificator.get(OrePrefixes.wireGt04, Materials.SuperconductorZPM, 8),
						GT_OreDictUnificator.get(OrePrefixes.plateDense, Materials.Lafium, 2)}, 1000, 122880);
		RA.addDisassemblerRecipe(
				GT_ItemList.EnergyMulti16_ZPM.get(1), new ItemStack[]{ItemList.Transformer_HA_UV_ZPM.get(1L),
						GT_ItemList.EnergyMulti4_ZPM.get(1),
						GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Energy, 2),
						ItemList.Circuit_Chip_NPIC.get(8),
						ItemList.ZPM_Coil.get(16),
						GT_OreDictUnificator.get(OrePrefixes.wireGt08, Materials.SuperconductorZPM, 16),
						GT_OreDictUnificator.get(OrePrefixes.plateDense, Materials.Lafium, 4)}, 2000, 122880);
		RA.addDisassemblerRecipe(
				GT_ItemList.EnergyMulti64_ZPM.get(1), new ItemStack[]{ItemList.WetTransformer_UV_ZPM.get(1L),
						GT_ItemList.EnergyMulti16_ZPM.get(1),
						GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Energy, 4),
						ItemList.Circuit_Chip_NPIC.get(16),
						ItemList.ZPM_Coil.get(64),
						GT_OreDictUnificator.get(OrePrefixes.wireGt16, Materials.SuperconductorZPM, 32),
						GT_OreDictUnificator.get(OrePrefixes.plateDense, Materials.Lafium, 8)}, 4000, 122880);

		RA.addDisassemblerRecipe(
				GT_ItemList.EnergyMulti4_UV.get(1), new ItemStack[]{ItemList.Transformer_MAX_UV.get(1L),
						ItemList.Hatch_Energy_UV.get(1),
						GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Energy, 1),
						ItemList.Circuit_Chip_PPIC.get(4),
						ItemList.UV_Coil.get(4),
						GT_OreDictUnificator.get(OrePrefixes.wireGt04, Materials.SuperconductorUV, 8),
						GT_OreDictUnificator.get(OrePrefixes.plateDense, Materials.CinobiteA243, 2)}, 1000, 500000);
		RA.addDisassemblerRecipe(
				GT_ItemList.EnergyMulti16_UV.get(1), new ItemStack[]{ItemList.Transformer_HA_UHV_UV.get(1L),
						GT_ItemList.EnergyMulti4_UV.get(1),
						GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Energy, 2),
						ItemList.Circuit_Chip_PPIC.get(8),
						ItemList.UV_Coil.get(16),
						GT_OreDictUnificator.get(OrePrefixes.wireGt08, Materials.SuperconductorUV, 16),
						GT_OreDictUnificator.get(OrePrefixes.plateDense, Materials.CinobiteA243, 4)}, 2000, 500000);
		RA.addDisassemblerRecipe(
				GT_ItemList.EnergyMulti64_UV.get(1), new ItemStack[]{ItemList.WetTransformer_UHV_UV.get(1L),
						GT_ItemList.EnergyMulti16_UV.get(1),
						GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Energy, 4),
						ItemList.Circuit_Chip_PPIC.get(16),
						ItemList.UV_Coil.get(64),
						GT_OreDictUnificator.get(OrePrefixes.wireGt16, Materials.SuperconductorUV, 32),
						GT_OreDictUnificator.get(OrePrefixes.plateDense, Materials.CinobiteA243, 8)}, 4000, 500000);

		RA.addDisassemblerRecipe(
				GT_ItemList.EnergyMulti4_UHV.get(1), new ItemStack[]{ItemList.Transformer_UEV_UHV.get(1L),
						ItemList.Hatch_Energy_MAX.get(1),
						GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Energy, 1),
						ItemList.Circuit_Chip_QPIC.get(4),
						ItemList.UHV_Coil.get(4),
						GT_OreDictUnificator.get(OrePrefixes.wireGt04, Materials.Superconductor, 8),
						GT_OreDictUnificator.get(OrePrefixes.plateDense, Materials.Pikyonium64B, 2)}, 1000, 500000);
		RA.addDisassemblerRecipe(
				GT_ItemList.EnergyMulti16_UHV.get(1), new ItemStack[]{ItemList.Transformer_HA_UEV_UHV.get(1L),
						GT_ItemList.EnergyMulti4_UHV.get(1),
						GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Energy, 2),
						ItemList.Circuit_Chip_QPIC.get(8),
						ItemList.UHV_Coil.get(16),
						GT_OreDictUnificator.get(OrePrefixes.wireGt08, Materials.Superconductor, 16),
						GT_OreDictUnificator.get(OrePrefixes.plateDense, Materials.Pikyonium64B, 4)}, 2000, 500000);
		RA.addDisassemblerRecipe(
				GT_ItemList.EnergyMulti64_UHV.get(1), new ItemStack[]{ItemList.WetTransformer_UEV_UHV.get(1L),
						GT_ItemList.EnergyMulti16_UHV.get(1),
						GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Energy, 4),
						ItemList.Circuit_Chip_QPIC.get(16),
						ItemList.UHV_Coil.get(64),
						GT_OreDictUnificator.get(OrePrefixes.wireGt16, Materials.Superconductor, 32),
						GT_OreDictUnificator.get(OrePrefixes.plateDense, Materials.Pikyonium64B, 8)}, 4000, 500000);

		RA.addDisassemblerRecipe(
				GT_ItemList.EnergyMulti4_UEV.get(1), new ItemStack[]{ItemList.Transformer_UIV_UEV.get(1L),
						ItemList.Hatch_Energy_UEV.get(1),
						GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Energy, 1),
						ItemList.Circuit_Chip_FPIC.get(4),
						ItemList.UEV_Coil.get(4),
						GT_OreDictUnificator.get(OrePrefixes.wireGt04, Materials.SuperconductorUEV, 8),
						GT_OreDictUnificator.get(OrePrefixes.plateDense, Materials.Quantum, 2)}, 1000, 500000);
		RA.addDisassemblerRecipe(
				GT_ItemList.EnergyMulti16_UEV.get(1), new ItemStack[]{ItemList.Transformer_HA_UIV_UEV.get(1L),
						GT_ItemList.EnergyMulti4_UEV.get(1),
						GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Energy, 2),
						ItemList.Circuit_Chip_FPIC.get(8),
						ItemList.UEV_Coil.get(16),
						GT_OreDictUnificator.get(OrePrefixes.wireGt08, Materials.SuperconductorUEV, 16),
						GT_OreDictUnificator.get(OrePrefixes.plateDense, Materials.Quantum, 4)}, 2000, 500000);
		RA.addDisassemblerRecipe(
				GT_ItemList.EnergyMulti64_UEV.get(1), new ItemStack[]{ItemList.WetTransformer_UIV_UEV.get(1L),
						GT_ItemList.EnergyMulti16_UEV.get(1),
						GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Energy, 4),
						ItemList.Circuit_Chip_FPIC.get(16),
						ItemList.UEV_Coil.get(64),
						GT_OreDictUnificator.get(OrePrefixes.wireGt16, Materials.SuperconductorUEV, 32),
						GT_OreDictUnificator.get(OrePrefixes.plateDense, Materials.Quantum, 8)}, 4000, 500000);

		//Nuclear Reactor I
		RA.addDisassemblerRecipe(
				GT_ItemList.Nuclear_Reactor_I.get(1), new ItemStack[]{ItemList.Hull_EV.get(1L),
						ItemList.Robot_Arm_EV.get(1L), GT_OreDictUnificator.get(OrePrefixes.plateDense, Materials.Titanium, 2),
						ItemList.Circuit_Data.get(4),
						GT_ModHandler.getModItem("IC2", "reactorPlatingExplosive", 8),
						GT_OreDictUnificator.get(OrePrefixes.plateTriple, Materials.Lead, 8)}, 300 * 20, 1920);
		
		//Nuclear Reactor II
		RA.addDisassemblerRecipe(
				GT_ItemList.Nuclear_Reactor_II.get(1), new ItemStack[]{ItemList.Hull_IV.get(1L),
						ItemList.Robot_Arm_IV.get(2L), GT_OreDictUnificator.get(OrePrefixes.plateDense, Materials.Titanium, 4),
						ItemList.Circuit_Elite.get(6),
						GT_ModHandler.getModItem("IC2", "reactorPlatingExplosive", 8), CoreItems2.getRecipe(141, 8),
						GT_OreDictUnificator.get(OrePrefixes.plateTriple, Materials.Lead, 10)}, 500 * 20, 7680);
		
		//Nuclear Reactor III
		RA.addDisassemblerRecipe(
				GT_ItemList.Nuclear_Reactor_III.get(1), new ItemStack[]{ItemList.Hull_LuV.get(1L),
						ItemList.Robot_Arm_LuV.get(4L), GT_OreDictUnificator.get(OrePrefixes.plateDense, Materials.Titanium, 8),
						ItemList.Circuit_Master.get(8),
						GT_OreDictUnificator.get(OrePrefixes.plateDense, Materials.TungstenSteel, 8), CoreItems2.getRecipe(142, 8),
						GT_OreDictUnificator.get(OrePrefixes.plateTriple, Materials.Lead, 12)}, 800 * 20, 30720);
		
		//Steam Turbine
		RA.addDisassemblerRecipe(ItemList.LargeSteamTurbine.get(1L),
				new ItemStack[]{ItemList.Hull_HV.get(1L),
						GT_ModHandler.getModItem("IC2", "itemPartCircuit", 2L),
						GT_OreDictUnificator.get(OrePrefixes.pipeLarge, Materials.Steel, 2),
						GT_OreDictUnificator.get(OrePrefixes.gearGt, Materials.Steel, 4),
						GT_OreDictUnificator.get(OrePrefixes.ring, Materials.Steel, 4),
						GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Steel, 12)
				}, 200 * 20, 120
		);
		
		//Gas Turbine
		RA.addDisassemblerRecipe(ItemList.LargeGasTurbine.get(1L),
				new ItemStack[]{ItemList.Hull_EV.get(1L),
						ItemList.Circuit_Data.get(2),
						GT_OreDictUnificator.get(OrePrefixes.pipeLarge, Materials.StainlessSteel, 2),
						GT_OreDictUnificator.get(OrePrefixes.gearGt, Materials.StainlessSteel, 4),
						GT_OreDictUnificator.get(OrePrefixes.ring, Materials.StainlessSteel, 4),
						GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.StainlessSteel, 12)
				}, 400 * 20, 480
		);
		
		//HP Turbine
		RA.addDisassemblerRecipe(ItemList.LargeHPSteamTurbine.get(1L),
				new ItemStack[]{ItemList.Hull_EV.get(1L),
						ItemList.Circuit_Data.get(4),
						GT_OreDictUnificator.get(OrePrefixes.gearGt, Materials.Titanium, 4),
						GT_OreDictUnificator.get(OrePrefixes.ring, Materials.Titanium, 4),
						GT_OreDictUnificator.get(OrePrefixes.pipeLarge, Materials.Titanium, 4),
						GT_OreDictUnificator.get(OrePrefixes.stickLong, Materials.HSLA, 6),
						GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Titanium, 12)
				}, 600 * 20, 1920
		);
		
		//Heat Exchanger
		RA.addDisassemblerRecipe(ItemList.Machine_Multi_HeatExchanger.get(1L),
				new ItemStack[]{ItemList.Hull_EV.get(1L),
						ItemList.Casing_Firebox_Titanium.get(1L),
						ItemList.Electric_Pump_EV.get(2L),
						GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Titanium, 2),
						GT_OreDictUnificator.get(OrePrefixes.pipeMedium, Materials.Titanium, 4),
						GT_OreDictUnificator.get(OrePrefixes.ring, Materials.Titanium, 4),
						GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Titanium, 8)
				}, 400 * 20, 480
		);
		
		//OilDrill2
		RA.addDisassemblerRecipe(ItemList.OilDrill2.get(1L),
				new ItemStack[]{ItemList.Hull_HV.get(1L),
						ItemList.Electric_Motor_HV.get(2L),
						ItemList.Electric_Pump_HV.get(2L),
						GT_ModHandler.getModItem("IC2", "itemPartCircuitAdv", 2L),
						GT_OreDictUnificator.get(OrePrefixes.gearGt, Materials.Titanium, 2),
						GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Titanium, 4),
						GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Titanium, 10)
				}, 400 * 20, 480
		);
		
		//OilDrill3
		RA.addDisassemblerRecipe(ItemList.OilDrill3.get(1L),
				new ItemStack[]{ItemList.Hull_EV.get(1L),
						ItemList.Electric_Motor_EV.get(2L),
						ItemList.Electric_Pump_EV.get(2L),
						GT_OreDictUnificator.get(OrePrefixes.gearGt, Materials.TungstenSteel, 4),
						ItemList.Circuit_Data.get(4L),
						GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.TungstenSteel, 12),
						GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.TungstenSteel, 16)
				}, 600 * 20, 1920
		);
		
		//Oil Cracker
		RA.addDisassemblerRecipe(ItemList.OilCracker.get(1L),
				new ItemStack[]{ItemList.Hull_HV.get(1L),
						GT_ModHandler.getModItem("IC2", "itemPartCircuit", 4L),
						ItemList.Casing_Coil_Cupronickel.get(4L),
						ItemList.Electric_Pump_HV.get(4L),
						GT_OreDictUnificator.get(OrePrefixes.plate, Materials.StainlessSteel, 8)
				}, 200 * 20, 120
		);
		
		//DieselGen1
		RA.addDisassemblerRecipe(ItemList.Machine_Multi_DieselEngine.get(1L),
				new ItemStack[]{ItemList.Hull_EV.get(1L),
						ItemList.Circuit_Data.get(2L),
						GT_OreDictUnificator.get(OrePrefixes.gearGt, Materials.Titanium, 2),
						ItemList.Electric_Piston_EV.get(2L), ItemList.Electric_Motor_EV.get(2L),
						GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Titanium, 4),
						GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Titanium, 8)
				}, 400 * 20, 1920
		);
		
		//DieselGen2
		RA.addDisassemblerRecipe(ItemList.Machine_Multi_DieselEngine2.get(1L),
				new ItemStack[]{ItemList.Hull_IV.get(1L),
						ItemList.Circuit_Elite.get(2L),
						GT_OreDictUnificator.get(OrePrefixes.gearGt, Materials.TungstenSteel, 2),
						ItemList.Electric_Piston_IV.get(2L), ItemList.Electric_Motor_IV.get(2L),
						GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.TungstenSteel, 4),
						GT_OreDictUnificator.get(OrePrefixes.plate, Materials.TungstenSteel, 8)
				}, 800 * 20, 7680
		);
		
		//LCR
		RA.addDisassemblerRecipe(ItemList.Machine_Multi_LargeChemicalReactor.get(1L),
				new ItemStack[]{ItemList.Hull_HV.get(1L),
						ItemList.Electric_Pump_HV.get(2L),
						ItemList.Electric_Motor_HV.get(2L),
						GT_ModHandler.getModItem("IC2", "itemPartCircuit", 2L),
						GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.StainlessSteel, 2),
						GT_OreDictUnificator.get(OrePrefixes.pipeLarge, Materials.Polytetrafluoroethylene, 2),
						GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.StainlessSteel, 4),
						GT_OreDictUnificator.get(OrePrefixes.plate, Materials.StainlessSteel, 6)
				}, 200 * 20, 120
		);
		
		//Implosion Compressor
		RA.addDisassemblerRecipe(ItemList.Machine_Multi_ImplosionCompressor.get(1L),
				new ItemStack[]{ItemList.Hull_HV.get(1L), ItemList.Electric_Piston_HV.get(2L),
						GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Steel, 2),
						GT_ModHandler.getModItem("IC2", "itemPartCircuit", 4L),
						GT_OreDictUnificator.get(OrePrefixes.plateDense, Materials.Steel, 8),
						ItemList.Casing_ExplosionHazard.get(1L)
				}, 300 * 20, 256
		);
		
		//Vacuum Freezer
		RA.addDisassemblerRecipe(ItemList.Machine_Multi_VacuumFreezer.get(1L),
				new ItemStack[]{
						ItemList.Hull_HV.get(1L), ItemList.Electric_Pump_HV.get(2L),
						GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Aluminium, 2),
						ItemList.Circuit_Data.get(4L),
						GT_OreDictUnificator.get(OrePrefixes.plateDense, Materials.Aluminium, 8),
						ItemList.Casing_FrostHazard.get(1L)
				}, 300 * 20, 256
		);
		
		//Titanium
		RA.addDisassemblerRecipe(ItemList.Machine_Multi_LargeBoiler_Titanium.get(1L),
				new ItemStack[]{
						ItemList.Hull_EV.get(1L), ItemList.Casing_Firebox_Titanium.get(1L),
						GT_OreDictUnificator.get(OrePrefixes.pipeLarge, Materials.Titanium, 3),
						ItemList.Circuit_Data.get(4L),
						GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Titanium, 4),
						GT_OreDictUnificator.get(OrePrefixes.stickLong, Materials.Titanium, 12)
				}, 400 * 20, 480
		);
		
		//TungstenSteel
		RA.addDisassemblerRecipe(ItemList.Machine_Multi_LargeBoiler_TungstenSteel.get(1L),
				new ItemStack[]{
						ItemList.Hull_IV.get(1L), ItemList.Casing_Firebox_TungstenSteel.get(1L),
						GT_OreDictUnificator.get(OrePrefixes.pipeLarge, Materials.TungstenSteel, 3),
						ItemList.Circuit_Elite.get(4L),
						GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.TungstenSteel, 4),
						GT_OreDictUnificator.get(OrePrefixes.stickLong, Materials.TungstenSteel, 12)
				}, 600 * 20, 1920
		);
		
		//Distillation_Tower
		RA.addDisassemblerRecipe(ItemList.Distillation_Tower.get(1L),
				new ItemStack[]{
						ItemList.Hull_EV.get(1L), ItemList.Electric_Pump_EV.get(4L),
						ItemList.Circuit_Data.get(4L),
						GT_OreDictUnificator.get(OrePrefixes.pipeMedium, Materials.StainlessSteel, 8),
						GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.StainlessSteel, 12)
				}, 400 * 20, 480
		);
		
		//Centrifuge
		RA.addDisassemblerRecipe(ItemList.Machine_MultiblockCentrifuge.get(1L),
				new ItemStack[]{
						ItemList.Machine_EV_Centrifuge.get(1L), ItemList.Electric_Motor_EV.get(4L),
						ItemList.Circuit_Data.get(4L),
						GT_OreDictUnificator.get(OrePrefixes.gearGt, Materials.Titanium, 4),
						GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Titanium, 8)
				}, 400 * 20, 480
		);
		
		//Electrolyzer
		RA.addDisassemblerRecipe(ItemList.Machine_MultiblockElectrolyzer.get(1L),
				new ItemStack[]{
						ItemList.Machine_EV_Electrolyzer.get(1L),
						GT_OreDictUnificator.get(OrePrefixes.wireGt04, Materials.Aluminium, 4),
						ItemList.Circuit_Data.get(4L),
						GT_OreDictUnificator.get(OrePrefixes.stickLong, Materials.Tungsten, 4),
						GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Titanium, 8)
				}, 400 * 20, 480
		);
		
		//Flotation Unit
		RA.addDisassemblerRecipe(ItemList.Machine_FlotationUnit.get(1L),
				new ItemStack[]{
						ItemList.Hull_EV.get(1L), ItemList.Electric_Pump_EV.get(4L),
						ItemList.Circuit_Data.get(6L),
						GT_OreDictUnificator.get(OrePrefixes.pipeMedium, Materials.Titanium, 8),
						GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Titanium, 12)
				}, 400 * 20, 480
		);
		
		// ---  T1 Rocket + chest
		RA.addDisassemblerRecipe(GT_ModHandler.getModItem("GalacticraftCore", "item.spaceship", 1L, 3),
				new ItemStack[]{
						GT_ModHandler.getModItem("chestup", "Blockchestup", 1L, 2),
						GT_ModHandler.getModItem("GalacticraftCore", "item.spaceship", 1L)}, 2000, 64
		);
		// ---  T2 Rocket + chest
		RA.addDisassemblerRecipe(GT_ModHandler.getModItem("GalacticraftMars", "item.spaceshipTier2", 1L, 3),
				new ItemStack[]{
						GT_ModHandler.getModItem("chestup", "Blockchestup", 1L, 2),
						GT_ModHandler.getModItem("GalacticraftMars", "item.spaceshipTier2", 1L)}, 2000, 64
		);
		// ---  T3 Rocket + chest
		RA.addDisassemblerRecipe(GT_ModHandler.getModItem("GalacticraftMars", "item.itemTier3Rocket", 1L, 3),
				new ItemStack[]{
						GT_ModHandler.getModItem("chestup", "Blockchestup", 1L, 2),
						GT_ModHandler.getModItem("GalacticraftMars", "item.itemTier3Rocket", 1L)}, 2000, 64
		);
		// ---  T4 Rocket + chest
		RA.addDisassemblerRecipe(GT_ModHandler.getModItem("GalaxySpace", "item.Tier4Rocket", 1L, 3),
				new ItemStack[]{
						GT_ModHandler.getModItem("chestup", "Blockchestup", 1L, 2),
						GT_ModHandler.getModItem("GalaxySpace", "item.Tier4Rocket", 1L)}, 2000, 64
		);
		// ---  T5 Rocket + chest
		RA.addDisassemblerRecipe(GT_ModHandler.getModItem("GalaxySpace", "item.Tier5Rocket", 1L, 3),
				new ItemStack[]{
						GT_ModHandler.getModItem("chestup", "Blockchestup", 1L, 2),
						GT_ModHandler.getModItem("GalaxySpace", "item.Tier5Rocket", 1L)}, 2000, 64
		);
		// ---  T6 Rocket + chest
		RA.addDisassemblerRecipe(GT_ModHandler.getModItem("GalaxySpace", "item.Tier6Rocket", 1L, 3),
				new ItemStack[]{
						GT_ModHandler.getModItem("chestup", "Blockchestup", 1L, 2),
						GT_ModHandler.getModItem("GalaxySpace", "item.Tier6Rocket", 1L)}, 2000, 64
		);
		// ---  T7 Rocket + chest
		RA.addDisassemblerRecipe(GT_ModHandler.getModItem("GalaxySpace", "item.Tier7Rocket", 1L, 3),
				new ItemStack[]{
						GT_ModHandler.getModItem("chestup", "Blockchestup", 1L, 2),
						GT_ModHandler.getModItem("GalaxySpace", "item.Tier7Rocket", 1L)}, 2000, 64
		);
		// ---  T8 Rocket + chest
		RA.addDisassemblerRecipe(GT_ModHandler.getModItem("GalaxySpace", "item.Tier8Rocket", 1L, 3),
				new ItemStack[]{
						GT_ModHandler.getModItem("chestup", "Blockchestup", 1L, 2),
						GT_ModHandler.getModItem("GalaxySpace", "item.Tier8Rocket", 1L)}, 2000, 64
		);
		
		// --- Field Tier 1
		RA.addDisassemblerRecipe(Blockstack(FluidTankBlock, 1, 0),
				new ItemStack[]{
						ItemList.Electric_Pump_MV.get(1L),
						GT_OreDictUnificator.get(OrePrefixes.plate, Materials.StainlessSteel, 4)}, 2000, 120
		);
		// --- Field Tier 2
		RA.addDisassemblerRecipe(Blockstack(FluidTankBlock, 1, 1),
				new ItemStack[]{
						ItemList.Field_Generator_LV.get(1L),
						ItemList.Electric_Pump_HV.get(1L),
						GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Titanium, 4)}, 2000, 480
		);
		// --- Field Tier 3
		RA.addDisassemblerRecipe(Blockstack(FluidTankBlock, 1, 2),
				new ItemStack[]{
						ItemList.Field_Generator_MV.get(1L),
						ItemList.Electric_Pump_EV.get(1L),
						GT_OreDictUnificator.get(OrePrefixes.plate, Materials.TungstenSteel, 4)}, 2000, 1920
		);
		// --- Field Tier 4
		RA.addDisassemblerRecipe(Blockstack(FluidTankBlock, 1, 3),
				new ItemStack[]{
						ItemList.Field_Generator_HV.get(1L),
						ItemList.Electric_Pump_IV.get(1L),
						GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Chrome, 4)}, 2000, 7680
		);
		// --- Field Tier 5
		RA.addDisassemblerRecipe(Blockstack(FluidTankBlock, 1, 4),
				new ItemStack[]{
						ItemList.Field_Generator_EV.get(1L),
						ItemList.Electric_Pump_LuV.get(1L),
						GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Iridium, 4)}, 2000, 30720
		);
		// --- Field Tier 6
		RA.addDisassemblerRecipe(Blockstack(FluidTankBlock, 1, 5),
				new ItemStack[]{
						ItemList.Field_Generator_IV.get(1L),
						ItemList.Electric_Pump_ZPM.get(1L),
						GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Osmium, 4)}, 2000, 122880
		);
		// --- Field Tier 7
		RA.addDisassemblerRecipe(Blockstack(FluidTankBlock, 1, 6),
				new ItemStack[]{
						ItemList.Field_Generator_LuV.get(1L),
						ItemList.Electric_Pump_UV.get(1L),
						GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Tritanium, 4)}, 2000, 500000
		);
		// --- Field Tier 8
		RA.addDisassemblerRecipe(Blockstack(FluidTankBlock, 1, 7),
				new ItemStack[]{
						ItemList.Field_Generator_ZPM.get(1L),
						ItemList.Electric_Pump_UHV.get(1L),
						GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Neutronium, 4)}, 4000, 500000
		);
		
		// --- Energy Hatches
		RA.addDisassemblerRecipe(ItemList.Hatch_Energy_ULV.get(1L),
				new ItemStack[]{
						ItemList.Hull_ULV.get(1L),
						GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Lead, 1L),
						ItemList.Circuit_Parts_Vacuum_Tube.get(1),
						ItemList.ULV_Coil.get(2L),
						GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.Lead, 1L)}, 2000, 6
		);
		RA.addDisassemblerRecipe(ItemList.Hatch_Energy_LV.get(1L),
				new ItemStack[]{
						ItemList.Hull_LV.get(1L),
						GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Tin, 1L),
						GT_ModHandler.getModItem("IC2", "itemPartCircuit", 1L, 0),
						ItemList.LV_Coil.get(2L),
						ItemList.Electric_Pump_LV.get(1L)}, 2000, 30
		);
		RA.addDisassemblerRecipe(ItemList.Hatch_Energy_MV.get(1L),
				new ItemStack[]{
						ItemList.Hull_MV.get(1L),
						GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Copper, 1L),
						ItemList.Circuit_Good.get(1),
						ItemList.MV_Coil.get(2L),
						ItemList.Electric_Pump_MV.get(1L)}, 2000, 120
		);
		RA.addDisassemblerRecipe(ItemList.Hatch_Energy_HV.get(1L),
				new ItemStack[]{
						ItemList.Hull_HV.get(1L),
						GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Gold, 1L),
						ItemList.Circuit_Chip_LPIC.get(2L),
						ItemList.HV_Coil.get(2L),
						ItemList.Electric_Pump_HV.get(1L)}, 2000, 480
		);
		RA.addDisassemblerRecipe(ItemList.Hatch_Energy_EV.get(1L),
				new ItemStack[]{
						ItemList.Hull_EV.get(1L),
						GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Aluminium, 1L),
						ItemList.Circuit_Chip_PIC.get(2L),
						ItemList.EV_Coil.get(2L),
						ItemList.Electric_Pump_EV.get(1L)}, 2000, 1920
		);
		RA.addDisassemblerRecipe(ItemList.Hatch_Energy_IV.get(1L),
				new ItemStack[]{
						ItemList.Hull_IV.get(1L),
						GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.SuperconductorIV, 1L),
						ItemList.Circuit_Chip_HPIC.get(2L),
						ItemList.IV_Coil.get(2L),
						ItemList.Electric_Pump_IV.get(1L)}, 2000, 7680
		);
		RA.addDisassemblerRecipe(ItemList.Hatch_Energy_LuV.get(1L),
				new ItemStack[]{
						ItemList.Hull_LuV.get(1L),
						GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.SuperconductorLuV, 2L),
						ItemList.Circuit_Chip_UHPIC.get(2L),
						ItemList.Circuit_Master.get(2),
						ItemList.LuV_Coil.get(2L),
						ItemList.Electric_Pump_LuV.get(1L)}, 4000, 30720
		);
		RA.addDisassemblerRecipe(ItemList.Hatch_Energy_ZPM.get(1L),
				new ItemStack[]{
						ItemList.Hull_ZPM.get(1L),
						GT_OreDictUnificator.get(OrePrefixes.wireGt02, Materials.SuperconductorZPM, 2L),
						ItemList.Circuit_Chip_NPIC.get(2L),
						ItemList.Circuit_Quantummainframe.get(2),
						ItemList.ZPM_Coil.get(2L),
						ItemList.Electric_Pump_ZPM.get(1L)}, 6000, 122880
		);
		RA.addDisassemblerRecipe(ItemList.Hatch_Energy_UV.get(1L),
				new ItemStack[]{
						ItemList.Hull_UV.get(1L),
						GT_OreDictUnificator.get(OrePrefixes.wireGt02, Materials.SuperconductorUV, 2L),
						ItemList.Circuit_Chip_PPIC.get(2L),
						ItemList.Circuit_Crystalmainframe.get(2),
						ItemList.UV_Coil.get(2L),
						ItemList.Electric_Pump_UV.get(1L)}, 8000, 500000
		);
		
		// --- Dynamo Hatches
		RA.addDisassemblerRecipe(ItemList.Hatch_Dynamo_ULV.get(1L),
				new ItemStack[]{
						ItemList.Hull_ULV.get(1L),
						GT_OreDictUnificator.get(OrePrefixes.spring, Materials.Lead, 1L),
						ItemList.Circuit_Parts_Vacuum_Tube.get(1),
						ItemList.ULV_Coil.get(2L),
						GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.Lead, 1L)}, 2000, 6
		);
		RA.addDisassemblerRecipe(ItemList.Hatch_Dynamo_LV.get(1L),
				new ItemStack[]{
						ItemList.Hull_LV.get(1L),
						GT_OreDictUnificator.get(OrePrefixes.spring, Materials.Tin, 1L),
						GT_ModHandler.getModItem("IC2", "itemPartCircuit", 1L, 0),
						ItemList.LV_Coil.get(2L),
						ItemList.Electric_Pump_LV.get(1L)}, 2000, 30
		);
		RA.addDisassemblerRecipe(ItemList.Hatch_Dynamo_MV.get(1L),
				new ItemStack[]{
						ItemList.Hull_MV.get(1L),
						GT_OreDictUnificator.get(OrePrefixes.spring, Materials.Copper, 1L),
						ItemList.Circuit_Good.get(1),
						ItemList.MV_Coil.get(2L),
						ItemList.Electric_Pump_MV.get(1L)}, 2000, 120
		);
		RA.addDisassemblerRecipe(ItemList.Hatch_Dynamo_HV.get(1L),
				new ItemStack[]{
						ItemList.Hull_HV.get(1L),
						GT_OreDictUnificator.get(OrePrefixes.spring, Materials.Gold, 1L),
						ItemList.Circuit_Chip_LPIC.get(2L),
						ItemList.HV_Coil.get(2L),
						ItemList.Electric_Pump_HV.get(1L)}, 2000, 480
		);
		RA.addDisassemblerRecipe(ItemList.Hatch_Dynamo_EV.get(1L),
				new ItemStack[]{
						ItemList.Hull_EV.get(1L),
						GT_OreDictUnificator.get(OrePrefixes.spring, Materials.Aluminium, 1L),
						ItemList.Circuit_Chip_PIC.get(2L),
						ItemList.EV_Coil.get(2L),
						ItemList.Electric_Pump_EV.get(1L)}, 2000, 1920
		);
		RA.addDisassemblerRecipe(ItemList.Hatch_Dynamo_IV.get(1L),
				new ItemStack[]{
						ItemList.Hull_IV.get(1L),
						GT_OreDictUnificator.get(OrePrefixes.spring, Materials.Vanadiumtriindinid, 1L),
						ItemList.Circuit_Chip_HPIC.get(2L),
						ItemList.IV_Coil.get(2L),
						ItemList.Electric_Pump_IV.get(1L)}, 2000, 7680
		);
		RA.addDisassemblerRecipe(ItemList.Hatch_Dynamo_LuV.get(1L),
				new ItemStack[]{
						ItemList.Hull_LuV.get(1L),
						GT_OreDictUnificator.get(OrePrefixes.spring, Materials.Tetraindiumditindibariumtitaniumheptacoppertetrakaidekaoxid, 2L),
						ItemList.Circuit_Chip_UHPIC.get(2L),
						ItemList.Circuit_Master.get(2),
						ItemList.LuV_Coil.get(2L),
						ItemList.Electric_Pump_LuV.get(1L)}, 4000, 30720
		);
		RA.addDisassemblerRecipe(ItemList.Hatch_Dynamo_ZPM.get(1L),
				new ItemStack[]{
						ItemList.Hull_ZPM.get(1L),
						GT_OreDictUnificator.get(OrePrefixes.spring, Materials.Tetranaquadahdiindiumhexaplatiumosminid, 2L),
						ItemList.Circuit_Chip_NPIC.get(2L),
						ItemList.Circuit_Quantummainframe.get(2),
						ItemList.ZPM_Coil.get(2L),
						ItemList.Electric_Pump_ZPM.get(1L)}, 6000, 122880
		);
		RA.addDisassemblerRecipe(ItemList.Hatch_Dynamo_UV.get(1L),
				new ItemStack[]{
						ItemList.Hull_UV.get(1L),
						GT_OreDictUnificator.get(OrePrefixes.spring, Materials.ElectrumFlux, 2L),
						ItemList.Circuit_Chip_PPIC.get(2L),
						ItemList.Circuit_Crystalmainframe.get(2),
						ItemList.UV_Coil.get(2L),
						ItemList.Electric_Pump_UV.get(1L)}, 8000, 500000
		);
		
		// --- Muffler Hatches
		RA.addDisassemblerRecipe(ItemList.Hatch_Muffler_HV.get(1L),
				new ItemStack[]{
						ItemList.Hull_HV.get(1L),
						GT_OreDictUnificator.get(OrePrefixes.pipeLarge, Materials.StainlessSteel, 1L),
						GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.StainlessSteel, 1L),
						ItemList.Electric_Motor_HV.get(1L)}, 2000, 480
		);
		RA.addDisassemblerRecipe(ItemList.Hatch_Muffler_EV.get(1L),
				new ItemStack[]{
						ItemList.Hull_EV.get(1L),
						GT_OreDictUnificator.get(OrePrefixes.pipeLarge, Materials.Titanium, 1L),
						ItemList.Electric_Motor_EV.get(1L),
						GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.Titanium, 1L)}, 2000, 1920
		);
		RA.addDisassemblerRecipe(ItemList.Hatch_Muffler_IV.get(1L),
				new ItemStack[]{
						ItemList.Hull_IV.get(1L),
						GT_OreDictUnificator.get(OrePrefixes.pipeLarge, Materials.TungstenSteel, 1L),
						ItemList.Electric_Motor_IV.get(1L),
						GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.TungstenSteel, 1L)}, 2000, 7680
		);
		RA.addDisassemblerRecipe(ItemList.Hatch_Muffler_LuV.get(1L),
				new ItemStack[]{
						ItemList.Hull_LuV.get(1L),
						GT_OreDictUnificator.get(OrePrefixes.pipeLarge, Materials.Enderium, 1L),
						ItemList.Electric_Motor_LuV.get(1L),
						GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.Iridium, 1L)}, 2000, 30720
		);
		RA.addDisassemblerRecipe(ItemList.Hatch_Muffler_ZPM.get(1L),
				new ItemStack[]{
						ItemList.Hull_ZPM.get(1L),
						GT_OreDictUnificator.get(OrePrefixes.pipeLarge, Materials.Naquadah, 1L),
						ItemList.Electric_Motor_ZPM.get(1L),
						GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.Osmium, 1L)}, 2000, 122880
		);
		RA.addDisassemblerRecipe(ItemList.Hatch_Muffler_UV.get(1L),
				new ItemStack[]{
						ItemList.Hull_UV.get(1L),
						GT_OreDictUnificator.get(OrePrefixes.pipeLarge, Materials.Duranium, 1L),
						ItemList.Electric_Motor_UV.get(1L),
						GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.NaquadahAlloy, 1L)}, 2000, 500000
		);
		RA.addDisassemblerRecipe(ItemList.Hatch_Muffler_MAX.get(1L),
				new ItemStack[]{
						ItemList.Hull_MAX.get(1L),
						GT_OreDictUnificator.get(OrePrefixes.pipeLarge, Materials.Infuscolium, 1L),
						ItemList.Electric_Motor_UHV.get(1L),
						GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.Diamericiumtitanium, 1L)}, 4000, 500000
		);
		
		// --- Casings
		RA.addDisassemblerRecipe(GT_ItemList.PBECasing.get(1),
				new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.stick, Materials.GumMetal, 2),
						GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Titaniolum, 3),
						GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.HSSG, 8)},
				1000, 1920
		);
		RA.addDisassemblerRecipe(GT_ItemList.EngraverCasing.get(1),
				new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Zamak, 2),
						GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Duraluminium, 3),
						GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.HSSG, 8)},
				1000, 1920
		);
		RA.addDisassemblerRecipe(GT_ItemList.AssemblerCasing.get(1),
				new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Inconel690, 2),
						GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Nitinol, 3),
						GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.HSSG, 8)},
				1000, 1920
		);
		RA.addDisassemblerRecipe(GT_ItemList.CentrifugeCasing.get(1),
				new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Inconel792, 2),
						GT_OreDictUnificator.get(OrePrefixes.plate, Materials.TiBetaC, 3),
						GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.HSSG, 8)},
				1000, 1920
		);
		RA.addDisassemblerRecipe(GT_ItemList.ElectrolyzerCasing.get(1),
				new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.stick, Materials.HastelloyC276, 2),
						GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Zamak, 3),
						GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.HSSG, 8)},
				1000, 1920
		);
		RA.addDisassemblerRecipe(GT_ItemList.WireFactoryCasing.get(1),
				new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Titaniolum, 2),
						GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Inconel690, 3),
						GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.HSSG, 8)},
				1000, 1920
		);
		RA.addDisassemblerRecipe(GT_ItemList.SupplyProductionCasing.get(1),
				new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.stick, Materials.MaragingSteel250, 2),
						GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Inconel792, 3),
						GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.HSSG, 8)},
				1000, 1920
		);
		RA.addDisassemblerRecipe(GT_ItemList.UtilityMachineCasing.get(1),
				new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Nitinol, 2),
						GT_OreDictUnificator.get(OrePrefixes.plate, Materials.HastelloyC276, 3),
						GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.HSSG, 8)},
				1000, 1920
		);
		RA.addDisassemblerRecipe(GT_ItemList.BrewmenterCasing.get(1),
				new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Talonite, 2),
						GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Grisium, 3),
						GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.HSSG, 8)},
				1000, 1920
		);
		RA.addDisassemblerRecipe(GT_ItemList.ElectromagneticCasing.get(1),
				new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Nitinol, 2),
						GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Inconel690, 3),
						GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.HSSG, 8)},
				1000, 1920
		);
		RA.addDisassemblerRecipe(GT_ItemList.ArcCasing.get(1),
				new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Nitinol60, 2),
						GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Kovar, 3),
						GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.HSSG, 8)},
				1000, 1920
		);
		RA.addDisassemblerRecipe(GT_ItemList.ExtradificationCasing.get(1),
				new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.stick, Materials.TiBetaC, 2),
						GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Talonite, 3),
						GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.HSSG, 8)},
				1000, 1920
		);
		RA.addDisassemblerRecipe(GT_ItemList.MixingCasing.get(1),
				new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Titaniolum, 2),
						GT_OreDictUnificator.get(OrePrefixes.plate, Materials.MaragingSteel250, 3),
						GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.HSSG, 8)},
				1000, 1920
		);
		RA.addDisassemblerRecipe(GT_ItemList.MacerationCasing.get(1),
				new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.stick, Materials.HastelloyC276, 2),
						GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Mangalloy, 3),
						GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.HSSG, 8)},
				1000, 1920
		);
		RA.addDisassemblerRecipe(GT_ItemList.CuttingCasing.get(1),
				new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.stick, Materials.MaragingSteel300, 2),
						GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Stellite, 3),
						GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.HSSG, 8)},
				1000, 1920
		);
		// --- 3D Casing
		RA.addDisassemblerRecipe(GT_ItemList.DDDPrinterCasing.get(1),
				new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.stick, Materials.StainlessSteel, 2),
						GT_OreDictUnificator.get(OrePrefixes.plate, Materials.VanadiumSteel, 3),
						GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.RedSteel, 4)},
				500, 120
		);
		// --- Naq Casing
		RA.addDisassemblerRecipe(GT_ItemList.NqCasing.get(1),
				new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.stick, Materials.GumMetal, 2),
						GT_OreDictUnificator.get(OrePrefixes.plateQuadruple, Materials.Naquadah, 1),
						GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Desh, 3),
						GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.TungstenSteel, 6),
						GT_OreDictUnificator.get(OrePrefixes.screw, Materials.TungstenSteel, 6),
						GT_ModHandler.getIC2Item("advancedCircuit", 2L)},
				1000, 7680
		);
		// --- Cyclone Casing
		RA.addDisassemblerRecipe(GT_ItemList.CycloneCasing.get(1),
				new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Inconel792, 2),
						GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.MaragingSteel300, 3),
						GT_OreDictUnificator.get(OrePrefixes.foil, Materials.BlackSteel, 6),
						GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.HSSS, 8)},
				1000, 7680
		);
		// --- Turbine Casing
		RA.addDisassemblerRecipe(GT_ItemList.Huge_Casing_Turbine.get(1),
				new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Titaniolum, 2),
						GT_OreDictUnificator.get(OrePrefixes.plate, Materials.TiBetaC, 3),
						GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.HSSG, 8)},
				1000, 1920
		);
		// --- Lapotronic Casing
		RA.addDisassemblerRecipe(GT_ItemList.LSCC.get(1L),
				new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Inconel792, 1),
						GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Iridium, 6),
						GT_OreDictUnificator.get(OrePrefixes.foil, Materials.NiobiumTitanium, 12),
						GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Palladium, 16),
						GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.HastelloyC276, 16),
						GT_OreDictUnificator.get(OrePrefixes.screw, Materials.HSSE, 16)},
				6000, 7680
		);
		// --- Space Satellite Casing
		RA.addDisassemblerRecipe(GT_ItemList.Space_Satellite_Casing.get(1L),
				new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.stick, Materials.StainlessSteel, 2),
						GT_OreDictUnificator.get(OrePrefixes.plate, Materials.HSLA, 3),
						GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.RedSteel, 4)},
				500, 120
		);
		// --- Tower Casing
		RA.addDisassemblerRecipe(GT_ItemList.Tower_Casing.get(1L),
				new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.stick, Materials.StainlessSteel, 2),
						GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Ultimet, 3),
						GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.RedSteel, 4)},
				500, 120
		);
		// --- Computer Casing
		RA.addDisassemblerRecipe(GT_ItemList.Computer_Casing.get(1L),
				new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Zamak, 2),
						GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.MaragingSteel300, 3),
						GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Cobalt, 8),
						GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 8),
						GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.HSSG, 8)},
				1000, 1920
		);
		// --- Vent Casing
		RA.addDisassemblerRecipe(new ItemStack(InsideBlock, 1, 2),
				new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.stick, Materials.StainlessSteel, 2),
						GT_OreDictUnificator.get(OrePrefixes.plate, Materials.MaragingSteel300, 3),
						GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.RedSteel, 4)},
				500, 120
		);
		// --- Space Elevator Casing
		RA.addDisassemblerRecipe(GT_ItemList.SpaceElevatorCasing.get(1L),
				new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.stick, Materials.HSLA, 2),
						GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Vanadium, 3),
						GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.BlueSteel, 4)},
				500, 120
		);
		// --- Nuclear Rod Hatch
		RA.addDisassemblerRecipe(GT_ItemList.Nuclear_Hatch_Rod.get(1),
				new ItemStack[]{ItemList.Hull_EV.get(1), ItemList.Electric_Motor_EV.get(1),
						GT_OreDictUnificator.get(OrePrefixes.plateTriple, Materials.Lead, 4L)},
				480, 1920
		);
		// --- Lab-Safe Low Gravity Casing
		RA.addDisassemblerRecipe(GT_ItemList.SpaceElevatorCasing.get(1L),
				new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Zirconium, 2),
						GT_OreDictUnificator.get(OrePrefixes.plate, Materials.BlueSteel, 3),
						GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.RedSteel, 4)},
				500, 120
		);
	}
	
	public void cyclon() {
		RA.addCyclonRecipe(new ItemStack[]{Materials.Draconium.getDust(10)}, new FluidStack[]{Materials.NaquadhaGas.getGas(100), Materials.SulfuricAcid.getFluid(900)}, new FluidStack[]{Materials.DilutedSulfuricAcid.getFluid(900)}, new ItemStack[]{Materials.DeepIron.getDust(5), Materials.Naquadah.getDust(2), Materials.Osmium.getDust(2), Materials.DraconiumAwakened.getDust(1)}, new int[]{10000, 10000, 10000, 10000}, 200, 2000000);
		RA.addCyclonRecipe(new ItemStack[]{Materials.Adamantium.getDust(10)}, new FluidStack[]{Materials.NaquadriaLiquid.getFluid(100), Materials.SulfuricAcid.getFluid(900)}, new FluidStack[]{Materials.DilutedSulfuricAcid.getFluid(900)}, new ItemStack[]{Materials.Trinium.getDust(5), Materials.Americium.getDust(2), Materials.Tungsten.getDust(2), Materials.InfinityCatalyst.getDust(1)}, new int[]{10000, 10000, 10000, 10000}, 250, 2000000);
		RA.addCyclonRecipe(new ItemStack[]{Materials.BlackPlutonium.getDust(10)}, new FluidStack[]{Materials.EnrichedNaquadria.getFluid(144), Materials.SulfuricAcid.getFluid(900)}, new FluidStack[]{Materials.DilutedSulfuricAcid.getFluid(900)}, new ItemStack[]{Materials.Uranium235.getDust(5), Materials.Plutonium.getDust(2), Materials.Plutonium241.getDust(2), Materials.CosmicNeutronium.getDust(1)}, new int[]{10000, 10000, 10000, 10000}, 300, 2000000);
	}
	
	public void tesseract() {
		//Tesseract
		RA.addTesseractRecipe(GT_Values.NI, Materials.HyperFuelI.getFluid(1000L), GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.gemExquisite, Materials.Opal, 64L), GT_OreDictUnificator.get(OrePrefixes.gemFlawless, Materials.Ruby, 64L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.MysteriousCrystal, 51L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Desh, 47L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Quantium, 25L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.AlienOrganic, 16L), new int[]{10000, 10000, 10000, 10000, 10000, 10000}, 500, 8000000);
		RA.addTesseractRecipe(GT_Values.NI, Materials.HyperFuelII.getFluid(1000L), GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.gemExquisite, Materials.GarnetYellow, 64L), GT_OreDictUnificator.get(OrePrefixes.gemFlawless, Materials.Amethyst, 64L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Naquadah, 57L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Draconium, 49L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Adamantium, 36L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.NetherStar, 20L), new int[]{10000, 10000, 10000, 10000, 10000, 10000}, 400, 8000000);
		RA.addTesseractRecipe(GT_Values.NI, Materials.HyperFuelIII.getFluid(1000L), GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.gemExquisite, Materials.GarnetRed, 64L), GT_OreDictUnificator.get(OrePrefixes.gemFlawless, Materials.MysteriousCrystal, 64L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Oriharukon, 61L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Naquadria, 53L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.BlackPlutonium, 47L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Americium, 39L), new int[]{10000, 10000, 10000, 10000, 10000, 10000}, 300, 8000000);
	}
	
	public void drying() {
		// Graphene
		impact.I_RA.addDryingOvenRecipe(CoreItems2.getRecipe(193, 1), new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Graphene, 1L)}, 800, 16);
	}
	
	private void arcFurnace() {
		// --- Heat Proof Machine Casing
        RA.addArcFurnaceRecipe(ItemList.Casing_HeatProof.get(1),
                new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Invar, 4)}, null, 160, 96);
		// --- Solid Steel Machine Casing
        RA.addArcFurnaceRecipe(ItemList.Casing_SolidSteel.get(1),
                new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Steel, 4)}, null, 160, 96);
		// --- Frost Proof Machine Casing
		RA.addArcFurnaceRecipe(ItemList.Casing_FrostProof.get(1),
				new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Aluminium, 4)}, null, 160, 96);
		// --- Bronze Pipe Casing
		RA.addArcFurnaceRecipe(ItemList.Casing_Pipe_Bronze.get(1),
				new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Bronze, 9)}, null, 360, 96);
		// --- Steel Pipe Casing
		RA.addArcFurnaceRecipe(ItemList.Casing_Pipe_Steel.get(1),
				new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Steel, 9)}, null, 360, 96);
		// --- Titanium Pipe Casing
		RA.addArcFurnaceRecipe(ItemList.Casing_Pipe_Titanium.get(1),
				new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Titanium, 9)}, null, 360, 96);
		// --- TungstenSteel Pipe Casing
		RA.addArcFurnaceRecipe(ItemList.Casing_Pipe_TungstenSteel.get(1),
				new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.TungstenSteel, 9)}, null, 360, 96);
		// --- Radiation Proof Machine Casing
		RA.addArcFurnaceRecipe(ItemList.Casing_RadiationProof.get(1),
				new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Lead, 27),
						GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.TungstenCarbide, 1),
						GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Stone, 1)}, null, 360, 96);
		// --- Bronze Firebox Casing
		RA.addArcFurnaceRecipe(ItemList.Casing_Firebox_Bronze.get(1),
				new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Bronze, 4)}, null, 160, 96);
		// --- Steel Firebox Casing
		RA.addArcFurnaceRecipe(ItemList.Casing_Firebox_Steel.get(1),
				new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Steel, 4)}, null, 160, 96);
		// --- Titanium Firebox Casing
		RA.addArcFurnaceRecipe(ItemList.Casing_Firebox_Titanium.get(1),
				new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Titanium, 4)}, null, 160, 96);
		// --- TungstenSteel Firebox Casing
		RA.addArcFurnaceRecipe(ItemList.Casing_Firebox_TungstenSteel.get(1),
				new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.TungstenSteel, 4)}, null, 160, 96);
		// --- Robust Tungstensteel Machine Casing
		RA.addArcFurnaceRecipe(ItemList.Casing_RobustTungstenSteel.get(1),
				new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.TungstenSteel, 4)}, null, 160, 96);
		// --- Clean Stainless Steel Machine Casing
		RA.addArcFurnaceRecipe(ItemList.Casing_CleanStainlessSteel.get(1),
				new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.StainlessSteel, 4)}, null, 160, 96);
		// --- Stable Titanium Machine Casing
		RA.addArcFurnaceRecipe(ItemList.Casing_StableTitanium.get(1),
				new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Titanium, 4)}, null, 160, 96);
		// --- Turbine Casing
		RA.addArcFurnaceRecipe(ItemList.Casing_Turbine.get(1),
				new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Magnalium, 3),
						GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.BlueSteel, 1)}, null, 160, 96);
		// --- Stainless Steel Turbine Casing
		RA.addArcFurnaceRecipe(ItemList.Casing_Turbine1.get(1),
				new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.StainlessSteel, 3),
						GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Magnalium, 1)}, null, 160, 96);
		// --- Titanium Turbine Casing
		RA.addArcFurnaceRecipe(ItemList.Casing_Turbine2.get(1),
				new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Titanium, 3),
						GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Magnalium, 1)}, null, 160, 96);
		// --- Tungstensteel Turbine Casing
		RA.addArcFurnaceRecipe(ItemList.Casing_Turbine3.get(1),
				new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.TungstenSteel, 3),
						GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Magnalium, 1)}, null, 160, 96);
		// --- Mining Osmiridium Casing
		RA.addArcFurnaceRecipe(ItemList.Casing_MiningOsmiridium.get(1),
				new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Osmiridium, 4)}, null, 160, 96);
		// --- Robust Naquadah Alloy Machine Casing
		RA.addArcFurnaceRecipe(ItemList.Casing_RobustNaquadahAlloy.get(1),
				new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.NaquadahAlloy, 4)}, null, 160, 96);
		// --- HSLA Machine Casing
		RA.addArcFurnaceRecipe(ItemList.Casing_HSLA.get(1),
				new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.HSLA, 4)}, null, 160, 96);
		// --- Robust Neutronium Machine Casing
		RA.addArcFurnaceRecipe(ItemList.Casing_RobustNeutronium.get(1),
				new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Neutronium, 4)}, null, 160, 96);

		// --- Empty Rack Casing
		RA.addArcFurnaceRecipe(GT_ItemList.Parallel_Hatch_Rack.get(1),
				new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.MaragingSteel300, 3),
						GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.StainlessSteel, 1)}, null, 160, 96);
		// --- PBE Casing
		RA.addArcFurnaceRecipe(GT_ItemList.PBECasing.get(1),
				new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Titaniolum, 3),
						GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.GumMetal, 1),
						GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.HSSG, 1),
						GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.HSSE, 1)}, null, 240, 96);
		// --- Engraver Casing
		RA.addArcFurnaceRecipe(GT_ItemList.EngraverCasing.get(1),
				new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Duranium, 3),
						GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Zamak, 1),
						GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.HSSG, 1),
						GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.HSSE, 1)}, null, 240, 96);
		// --- Assembler Casing
		RA.addArcFurnaceRecipe(GT_ItemList.AssemblerCasing.get(1),
				new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Nitinol, 3),
						GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Inconel690, 1),
						GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.HSSG, 1),
						GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.HSSE, 1)}, null, 240, 96);
		// --- Centrifuge Casing
		RA.addArcFurnaceRecipe(GT_ItemList.CentrifugeCasing.get(1),
				new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.TiBetaC, 3),
						GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Inconel792, 1),
						GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.HSSG, 1),
						GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.HSSE, 1)}, null, 240, 96);
		// --- Electrolyzer Casing
		RA.addArcFurnaceRecipe(GT_ItemList.ElectrolyzerCasing.get(1),
				new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Zamak, 3),
						GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.HastelloyC276, 1),
						GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.HSSG, 1),
						GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.HSSE, 1)}, null, 240, 96);
		// --- Wire Factory Casing
		RA.addArcFurnaceRecipe(GT_ItemList.WireFactoryCasing.get(1),
				new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Inconel690, 3),
						GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Titaniolum, 1),
						GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.HSSG, 1),
						GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.HSSE, 1)}, null, 240, 96);
		// --- Supply Production Casing
		RA.addArcFurnaceRecipe(GT_ItemList.SupplyProductionCasing.get(1),
				new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Inconel792, 3),
						GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.MaragingSteel250, 1),
						GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.HSSG, 1),
						GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.HSSE, 1)}, null, 240, 96);
		// --- Utility Machine Casing
		RA.addArcFurnaceRecipe(GT_ItemList.UtilityMachineCasing.get(1),
				new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.HastelloyC276, 3),
						GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Nitinol, 1),
						GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.HSSG, 1),
						GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.HSSE, 1)}, null, 240, 96);
		// --- Brewmenter Casing
		RA.addArcFurnaceRecipe(GT_ItemList.BrewmenterCasing.get(1),
				new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Grisium, 3),
						GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Talonite, 1),
						GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.HSSG, 1),
						GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.HSSE, 1)}, null, 240, 96);
		// --- Arc Casing
		RA.addArcFurnaceRecipe(GT_ItemList.ArcCasing.get(1),
				new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Kovar, 3),
						GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Talonite, 1),
						GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.HSSG, 1),
						GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.HSSE, 1)}, null, 240, 96);
		// --- Cutting Casing
		RA.addArcFurnaceRecipe(GT_ItemList.ArcCasing.get(1),
				new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Stellite, 3),
						GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.MaragingSteel300, 1),
						GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.HSSG, 1),
						GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.HSSE, 1)}, null, 240, 96);
		// --- Mixing Casing
		RA.addArcFurnaceRecipe(GT_ItemList.MixingCasing.get(1),
				new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.MaragingSteel250, 3),
						GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Titaniolum, 1),
						GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.HSSG, 1),
						GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.HSSE, 1)}, null, 240, 96);
		// --- Electromagnetic Casing
		RA.addArcFurnaceRecipe(GT_ItemList.ElectromagneticCasing.get(1),
				new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Inconel690, 3),
						GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Nitinol, 1),
						GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.HSSG, 1),
						GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.HSSE, 1)}, null, 240, 96);
		// --- Extradification Casing
		RA.addArcFurnaceRecipe(GT_ItemList.ExtradificationCasing.get(1),
				new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Talonite, 3),
						GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.TiBetaC, 1),
						GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.HSSG, 1),
						GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.HSSE, 1)}, null, 240, 96);
		// --- Maceration Casing
		RA.addArcFurnaceRecipe(GT_ItemList.MacerationCasing.get(1),
				new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Mangalloy, 3),
						GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.HastelloyC276, 1),
						GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.HSSG, 1),
						GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.HSSE, 1)}, null, 240, 96);
		// --- 3D Printed Casing
		RA.addArcFurnaceRecipe(GT_ItemList.DDDPrinterCasing.get(1),
				new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.VanadiumSteel, 3),
						GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.StainlessSteel, 1)}, null, 160, 96);
		// --- Cyclone Casing
		RA.addArcFurnaceRecipe(GT_ItemList.CycloneCasing.get(1),
				new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.MaragingSteel300, 6),
						GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Inconel792, 1),
						GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.HSSG, 1),
						GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.HSSE, 1)}, null, 240, 96);
		// --- Space Elevator Casing
		RA.addArcFurnaceRecipe(GT_ItemList.SpaceElevatorCasing.get(1),
				new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Vanadium, 3),
						GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.HSLA, 1)}, null, 160, 96);
		// --- Huge Turbine Casing
		RA.addArcFurnaceRecipe(GT_ItemList.Huge_Casing_Turbine.get(1),
				new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.TiBetaC, 3),
						GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Titaniolum, 1),
						GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.HSSG, 1),
						GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.HSSE, 1)}, null, 240, 96);
		// --- Space Satellite Casing
		RA.addArcFurnaceRecipe(GT_ItemList.Space_Satellite_Casing.get(1),
				new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.HSLA, 3),
						GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.StainlessSteel, 1)}, null, 160, 96);
		// --- Tower Casing
		RA.addArcFurnaceRecipe(GT_ItemList.Tower_Casing.get(1),
				new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Ultimet, 3),
						GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.StainlessSteel, 1)}, null, 160, 96);
		// --- Lab-Safe Low Gravity Casing
		RA.addArcFurnaceRecipe(GT_ItemList.LabSafeLGCasing.get(1),
				new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.BlueSteel, 3),
						GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Zirconium, 1)}, null, 160, 96);

	}

	private void forgeHammer() {
		// --- Clear Glass Dust
		RA.addForgeHammerRecipe(GT_ModHandler.getModItem("ExtraUtilities", "decorativeBlock2", 1L, 0),
				CoreItems.getRecipe(33, 1), 50, 8);
	}
	
}
