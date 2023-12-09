package com.impactrecipes.recipes;

import com.impact.common.item.Core_Items;
import com.impact.common.item.Core_Items2;
import gregtech.api.GregTech_API;
import gregtech.api.enums.GT_Values;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.util.GT_ModHandler;
import gregtech.api.util.GT_OreDictUnificator;
import gregtech.api.util.GT_Utility;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;

import static com.impact.common.item.Core_List_Items.IceCompressedPlate;
import static com.impact.common.item.Core_List_Items.TCetiESeaweedExtract;
import static com.impactrecipes.util.RecipeUtils.getItemStack;
import static gregtech.api.enums.GT_Values.RA;
import static gregtech.api.util.GT_ModHandler.removeRecipeByOutput;

public class GalaxySpace implements Runnable {

    private static final long tBitMask = GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE;

    final Core_Items2 CoreItems2 = Core_Items2.getInstance();
    final Core_Items CoreItems = Core_Items.getInstance();

    @Override
    public void run() {
        removeGalaxySpace();
        hand();
        sifter();
        pulverizer();
        fluidCanner();
        extractor();
        centrifuge();
        arcFurnace();
        assembler();
        autoclave();
        compressor();
        chemical();
        assemblyLine();
    }

    private void removeGalaxySpace() {
        removeRecipeByOutput(GT_ModHandler.getModItem("GalaxySpace", "item.ThermalClothT2", 1L, 0),
                true, false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("GalaxySpace", "item.ThermalPaddingT2", 1L, 0),
                true, false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("GalaxySpace", "item.ThermalPaddingT2", 1L, 1),
                true, false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("GalaxySpace", "item.ThermalPaddingT2", 1L, 2),
                true, false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("GalaxySpace", "item.ThermalPaddingT2", 1L, 3),
                true, false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("GalaxySpace", "futureglass", 1L, 0), true, false,
                true);
        removeRecipeByOutput(GT_ModHandler.getModItem("GalaxySpace", "item.cobalt_boots", 1L, 0), true,
                false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("GalaxySpace", "item.cobalt_plate", 1L, 0), true,
                false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("GalaxySpace", "item.cobalt_helmet", 1L, 0), true,
                false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("GalaxySpace", "item.cobalt_leg", 1L, 0), true,
                false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("GalaxySpace", "item.plasmasword", 1L, 0), true,
                false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("GalaxySpace", "item.plasmapickaxe", 1L, 0), true,
                false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("GalaxySpace", "item.plasmaaxe", 1L, 0), true,
                false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("GalaxySpace", "item.plasmahoe", 1L, 0), true,
                false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("GalaxySpace", "item.plasmashovel", 1L, 0), true,
                false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("GalaxySpace", "item.Modules", 1L, 3), true,
                false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("GalaxySpace", "item.BasicItems", 1L, 0), true,
                false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("GalaxySpace", "item.BasicItems", 1L, 1), true,
                false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("GalaxySpace", "item.BasicItems", 1L, 2), true,
                false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("GalaxySpace", "solarwindpanel", 1L, 0), true,
                false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("GalaxySpace", "item.QuantBow", 1L, 0), true,
                false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("GalaxySpace", "item.JetPack", 1L, GT_Values.W),
                true, false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("GalaxySpace", "fuelgenerator", 1L, 0), true,
                false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("GalaxySpace", "assemblymachine", 1L, 0), true,
                false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("GalaxySpace", "convertersurface", 1L, 0), true,
                false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("GalaxySpace", "dungeonglowstone", 1L, 0), true,
                false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("GalaxySpace", "dungeonglowstone", 1L, 1), true, false,
                true);
        //removeRecipeByOutput(GT_ModHandler.getModItem("GalaxySpace", "item.RocketParts", 1L, 0), true, false, true);
        //removeRecipeByOutput(GT_ModHandler.getModItem("GalaxySpace", "item.RocketParts", 1L, 1), true, false, true);
        //removeRecipeByOutput(GT_ModHandler.getModItem("GalaxySpace", "item.RocketParts", 1L, 2), true, false, true);
        //removeRecipeByOutput(GT_ModHandler.getModItem("GalaxySpace", "item.RocketParts", 1L, 3), true, false, true);
        //removeRecipeByOutput(GT_ModHandler.getModItem("GalaxySpace", "metalsblock", 1L, 0), true, false, true);
        //removeRecipeByOutput(GT_ModHandler.getModItem("GalaxySpace", "metalsblock", 1L, 1), true, false, true);
        //removeRecipeByOutput(GT_ModHandler.getModItem("GalaxySpace", "metalsblock", 1L, 2), true, false, true);
        //removeRecipeByOutput(GT_ModHandler.getModItem("GalaxySpace", "metalsblock", 1L, 3), true, false, true);
        //removeRecipeByOutput(GT_ModHandler.getModItem("GalaxySpace", "metalsblock", 1L, 4), true, false, true);
        //removeRecipeByOutput(GT_ModHandler.getModItem("GalaxySpace", "metalsblock", 1L, 5), true, false, true);
        //removeRecipeByOutput(GT_ModHandler.getModItem("GalaxySpace", "metalsblock", 1L, 6), true, false, true);
        //removeRecipeByOutput(GT_ModHandler.getModItem("GalaxySpace", "metalsblock", 1L, 7), true, false, true);
        //removeRecipeByOutput(GT_ModHandler.getModItem("GalaxySpace", "metalsblock", 1L, 8), true, false, true);
        //removeRecipeByOutput(GT_ModHandler.getModItem("GalaxySpace", "metalsblock", 1L, 9), true, false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("GalaxySpace", "machineframes", 1L, 0), true,
                false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("GalaxySpace", "solarPanel", 1L, 0), true, false,
                true);
        removeRecipeByOutput(GT_ModHandler.getModItem("GalaxySpace", "storagemoduleT3", 1L, 0), true,
                false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("GalaxySpace", "oxstoragemoduleT2", 1L, 0), true,
                false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("GalaxySpace", "machineframes", 1L, 2), true,
                false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("GalaxySpace", "advFuelLoader", 1L, 0), true,
                false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("GalaxySpace", "advlandingpad", 1L, 0), true,
                false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("GalaxySpace", "fluidtank", 1L, 0), true, false,
                true);
        removeRecipeByOutput(GT_ModHandler.getModItem("GalaxySpace", "gravitationmoduleon", 1L, 0),
                true, false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("GalaxySpace", "hydroponicbase", 1L, 0), true,
                false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("GalaxySpace", "hydroponicfarm", 1L, 0), true,
                false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("GalaxySpace", "liquidextractor", 1L, 0), true,
                false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("GalaxySpace", "liquidseparator", 1L, 0), true,
                false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("GalaxySpace", "modificationtable", 1L, 0), true,
                false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("GalaxySpace", "oxygenfiller", 1L, 0), true,
                false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("GalaxySpace", "portablenuclearreactor", 1L, 0),
                true, false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("GalaxySpace", "radiationstabiliser", 1L, 0),
                true, false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("GalaxySpace", "recycler", 1L, 0), true, false,
                true);
        removeRecipeByOutput(GT_ModHandler.getModItem("GalaxySpace", "rocketAssembly", 1L, 0), true,
                false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("GalaxySpace", "windTurbine", 1L, 0), true, false,
                true);
        removeRecipeByOutput(GT_ModHandler.getModItem("GalaxySpace", "item.BasicItems", 1L, 3), true,
                false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("GalaxySpace", "item.BasicItems", 1L, 14), true,
                false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("GalaxySpace", "item.BasicItems", 1L, 15), true,
                false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("GalaxySpace", "item.cobalt_sword", 1L, 0), true,
                false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("GalaxySpace", "item.cobalt_pickaxe", 1L, 0),
                true, false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("GalaxySpace", "item.cobalt_axe", 1L, 0), true,
                false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("GalaxySpace", "item.cobalt_shovel", 1L, 0), true,
                false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("GalaxySpace", "item.cobalt_hoe", 1L, 0), true,
                false, true);
        removeRecipeByOutput(
                GT_ModHandler.getModItem("GalaxySpace", "item.AdvancedBattery", 1L, GT_Values.W), true,
                false, true);
        removeRecipeByOutput(
                GT_ModHandler.getModItem("GalaxySpace", "item.ModernBattery", 1L, GT_Values.W), true, false,
                true);
        removeRecipeByOutput(
                GT_ModHandler.getModItem("GalaxySpace", "item.ExtraBattery", 1L, GT_Values.W), true, false,
                true);
        removeRecipeByOutput(
                GT_ModHandler.getModItem("GalaxySpace", "item.UltraBattery", 1L, GT_Values.W), true, false,
                true);
        removeRecipeByOutput(GT_ModHandler.getModItem("GalaxySpace", "item.Modules", 1L, 0), true,
                false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("GalaxySpace", "item.Modules", 1L, 1), true,
                false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("GalaxySpace", "item.Modules", 1L, 2), true,
                false, true);
        removeRecipeByOutput(
                GT_ModHandler.getModItem("GalaxySpace", "item.oxygentank_t4", 1L, GT_Values.W), true, false,
                true);
        removeRecipeByOutput(
                GT_ModHandler.getModItem("GalaxySpace", "item.oxygentank_t5", 1L, GT_Values.W), true, false,
                true);
        removeRecipeByOutput(
                GT_ModHandler.getModItem("GalaxySpace", "item.oxygentank_t6", 1L, GT_Values.W), true, false,
                true);

        removeRecipeByOutput(getItemStack("GalaxySpace", "item.cobalt_sword", 1, 0), true, false,
                false);
        removeRecipeByOutput(getItemStack("GalaxySpace", "item.cobalt_shovel", 1, 0), true, false,
                false);
        removeRecipeByOutput(getItemStack("GalaxySpace", "item.cobalt_pickaxe", 1, 0), true, false,
                false);
        removeRecipeByOutput(getItemStack("GalaxySpace", "item.cobalt_axe", 1, 0), true, false,
                false);
        removeRecipeByOutput(getItemStack("GalaxySpace", "item.cobalt_hoe", 1, 0), true, false,
                false);
    }

    private void hand() {
        // --- Cobalt Boots
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("GalaxySpace", "item.cobalt_boots", 1L), tBitMask, new Object[]{"P P", "ChC", "C C", 'P', OrePrefixes.plate.get(Materials.Desh), 'C', GT_ModHandler.getModItem("GalaxySpace", "item.CompressedPlates", 1L, 0)});
        // --- Cobalt Chestplate
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("GalaxySpace", "item.cobalt_plate", 1L), tBitMask, new Object[]{"ChC", "CPC", "C C", 'P', OrePrefixes.plate.get(Materials.Desh), 'C', GT_ModHandler.getModItem("GalaxySpace", "item.CompressedPlates", 1L, 0)});
        // --- Cobalt Helmet
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("GalaxySpace", "item.cobalt_helmet", 1L), tBitMask, new Object[]{"CCC", "ChC", "P P", 'P', OrePrefixes.plate.get(Materials.Desh), 'C', GT_ModHandler.getModItem("GalaxySpace", "item.CompressedPlates", 1L, 0)});
        // --- Cobalt Leggings
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("GalaxySpace", "item.cobalt_leg", 1L), tBitMask, new Object[]{"CCC", "CPC", "ChC", 'P', OrePrefixes.plate.get(Materials.Desh), 'C', GT_ModHandler.getModItem("GalaxySpace", "item.CompressedPlates", 1L, 0)});
        // --- Plasma Sword
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("GalaxySpace", "item.plasmasword", 1L), tBitMask, new Object[]{"PCP", "fCh", "PBW", 'P', OrePrefixes.plate.get(Materials.Desh), 'C', GT_ModHandler.getModItem("GalaxySpace", "item.CompressedPlates", 1L, 0), 'B', GT_ModHandler.getModItem("GalaxySpace", "item.LeadBattery", 1L, 100), 'W', GT_ModHandler.getModItem("GalacticraftCore", "tile.aluminumWire", 1L, 1)});
        // --- Plasma Pickaxe
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("GalaxySpace", "item.plasmapickaxe", 1L), tBitMask, new Object[]{"CCC", "fSh", "PBW", 'P', OrePrefixes.plate.get(Materials.Desh), 'C', GT_ModHandler.getModItem("GalaxySpace", "item.CompressedPlates", 1L, 0), 'B', GT_ModHandler.getModItem("GalaxySpace", "item.LeadBattery", 1L, 100), 'W', GT_ModHandler.getModItem("GalacticraftCore", "tile.aluminumWire", 1L, 1), 'S', GT_ModHandler.getModItem("GalacticraftCore", "item.steelPole", 1L)});
        // --- Plasma Axe
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("GalaxySpace", "item.plasmaaxe", 1L), tBitMask, new Object[]{"CCh", "CSP", "fBW", 'P', OrePrefixes.plate.get(Materials.Desh), 'C', GT_ModHandler.getModItem("GalaxySpace", "item.CompressedPlates", 1L, 0), 'B', GT_ModHandler.getModItem("GalaxySpace", "item.LeadBattery", 1L, 100), 'W', GT_ModHandler.getModItem("GalacticraftCore", "tile.aluminumWire", 1L, 1), 'S', GT_ModHandler.getModItem("GalacticraftCore", "item.steelPole", 1L)});
        // --- Plasma Hoe
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("GalaxySpace", "item.plasmahoe", 1L), tBitMask, new Object[]{"CCh", "fSP", "WBP", 'P', OrePrefixes.plate.get(Materials.Desh), 'C', GT_ModHandler.getModItem("GalaxySpace", "item.CompressedPlates", 1L, 0), 'B', GT_ModHandler.getModItem("GalaxySpace", "item.LeadBattery", 1L, 100), 'W', GT_ModHandler.getModItem("GalacticraftCore", "tile.aluminumWire", 1L, 1), 'S', GT_ModHandler.getModItem("GalacticraftCore", "item.steelPole", 1L)});
        // --- Plasma Shovel
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("GalaxySpace", "item.plasmashovel", 1L), tBitMask, new Object[]{"fCh", "PSP", "WBW", 'P', OrePrefixes.plate.get(Materials.Desh), 'C', GT_ModHandler.getModItem("GalaxySpace", "item.CompressedPlates", 1L, 0), 'B', GT_ModHandler.getModItem("GalaxySpace", "item.LeadBattery", 1L, 100), 'W', GT_ModHandler.getModItem("GalacticraftCore", "tile.aluminumWire", 1L, 1), 'S', GT_ModHandler.getModItem("GalacticraftCore", "item.steelPole", 1L)});
        // --- Small Fuel Canister
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("GalaxySpace", "item.Modules", 1L, 3), tBitMask, new Object[]{"SdS", "CMC", "ShS", 'C', GT_ModHandler.getModItem("GalaxySpace", "item.CompressedPlates", 1L, 4), 'S', OrePrefixes.screw.get(Materials.HSLA), 'M', GT_ModHandler.getModItem("GalaxySpace", "item.BasicItems", 1L)});
        // --- Blank Fuel Tank
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("GalaxySpace", "item.BasicItems", 1L), tBitMask, new Object[]{"PRP", "PwP", "PRP", 'P', GT_ModHandler.getModItem("GalacticraftCore", "item.basicItem", 1L, 9), 'R', OrePrefixes.ring.get(Materials.Steel)});
        // --- Decorate Lead
        //GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("GalaxySpace", "metalsblock", 5L), tBitMask, new Object[]{"hP ", "PSP", " Pw", 'P', GT_ModHandler.getModItem("GalaxySpace", "item.CompressedPlates", 1L, 3), 'S', "stone"});
        // --- Decorate Adamantite
        //GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("GalaxySpace", "metalsblock", 5L, 1), tBitMask, new Object[]{"hP ", "PSP", " Pw", 'P', GT_ModHandler.getModItem("GalaxySpace", "item.CompressedPlates", 1L), 'S', "stone"});
        // --- Decorate Cobaltum
        //GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("GalaxySpace", "metalsblock", 5L, 2), tBitMask, new Object[]{"hP ", "PSP", " Pw", 'P', GT_ModHandler.getModItem("GalaxySpace", "item.CompressedPlates", 1L, 1), 'S', "stone"});
        // --- Decorate Magnesium
        //GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("GalaxySpace", "metalsblock", 5L, 3), tBitMask, new Object[]{"hP ", "PSP", " Pw", 'P', GT_ModHandler.getModItem("GalaxySpace", "item.CompressedPlates", 1L, 4), 'S', "stone"});
        // --- Decorate Mithril
        //GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("GalaxySpace", "metalsblock", 5L, 4), tBitMask, new Object[]{"hP ", "PSP", " Pw", 'P', GT_ModHandler.getModItem("GalaxySpace", "item.CompressedPlates", 1L, 5), 'S', "stone"});
        // --- Decorate Nickel
        //GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("GalaxySpace", "metalsblock", 5L, 5), tBitMask, new Object[]{"hP ", "PSP", " Pw", 'P', GT_ModHandler.getModItem("GalaxySpace", "item.CompressedPlates", 1L, 6), 'S', "stone"});
        // --- Decorate Oriharukon
        //GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("GalaxySpace", "metalsblock", 5L, 6), tBitMask, new Object[]{"hP ", "PSP", " Pw", 'P', GT_ModHandler.getModItem("GalaxySpace", "item.CompressedPlates", 1L, 7), 'S', "stone"});
        // --- Decorate Platinum
        //GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("GalaxySpace", "metalsblock", 5L, 7), tBitMask, new Object[]{"hP ", "PSP", " Pw", 'P', GT_ModHandler.getModItem("GalaxySpace", "item.CompressedPlates", 1L, 8), 'S', "stone"});
        // --- Decorate Tungsten
        //GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("GalaxySpace", "metalsblock", 5L, 8), tBitMask, new Object[]{"hP ", "PSP", " Pw", 'P', GT_ModHandler.getModItem("GalaxySpace", "item.CompressedPlates", 1L, 9), 'S', "stone"});
        // --- Decorate Copper
        //GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("GalaxySpace", "metalsblock", 5L, 9), tBitMask, new Object[]{"hP ", "PSP", " Pw", 'P', GT_ModHandler.getModItem("GalacticraftCore", "item.basicItem", 1L, 6), 'S', "stone"});
        // --- Advanced Fuel Loader
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("GalaxySpace", "advFuelLoader", 1L), tBitMask, new Object[]{"SWS", "PTM", "AIA", 'I', OrePrefixes.pipeMedium.get(Materials.TungstenSteel), 'S', GT_ModHandler.getModItem("GalacticraftMars", "item.null", 1L, 5), 'A', CoreItems2.getRecipe(IceCompressedPlate.getMetaID(), 1), 'W', OrePrefixes.circuit.get(Materials.Elite), 'M', ItemList.Electric_Motor_IV, 'P', ItemList.Electric_Pump_IV, 'T', ItemList.Large_Fluid_Cell_TungstenSteel});
        // --- Gravity Module
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("GalaxySpace", "gravitationmoduleon", 1L), tBitMask, new Object[]{"PLP", "CFC", "IHI", 'L', OrePrefixes.lens.get(Materials.Diamond), 'C', OrePrefixes.cableGt02.get(Materials.Aluminium), 'I', OrePrefixes.circuit.get(Materials.Data), 'F', ItemList.Field_Generator_HV, 'H', ItemList.Hull_EV, 'P', GT_ModHandler.getModItem("GalaxySpace", "item.CompressedPlates", 1L, 4)});
        // --- Magnetic Field Generator
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("GalaxySpace", "radiationstabiliser", 1L), tBitMask, new Object[]{"ACA", "WHF", "SCS", 'A', OrePrefixes.compressed.get(Materials.Aluminium), 'S', OrePrefixes.compressed.get(Materials.Steel), 'C', OrePrefixes.circuit.get(Materials.Data), 'W', OrePrefixes.cableGt02.get(Materials.Aluminium), 'F', ItemList.EV_Coil, 'H', ItemList.Hull_EV});
        // --- Very Heavy Oxygen Tank
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("GalaxySpace", "item.oxygentank_t4", 1L, 10800), tBitMask, new Object[]{"PTP", "PCP", "PPP", 'P', CoreItems2.getRecipe(79, 1), 'C', ItemList.Large_Fluid_Cell_Chrome.get(1), 'T', GT_ModHandler.getModItem("GalacticraftCore", "tile.oxygenPipe", 1L)});
        // --- Ultra Oxygen Tank
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("GalaxySpace", "item.oxygentank_t5", 1L, 12600), tBitMask, new Object[]{"PTP", "PCP", "PPP", 'P', CoreItems2.getRecipe(83, 1), 'C', ItemList.Large_Fluid_Cell_Iridium.get(1), 'T', GT_ModHandler.getModItem("GalacticraftCore", "tile.oxygenPipe", 1L)});
        // --- Very Ultra Oxygen Tank
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("GalaxySpace", "item.oxygentank_t6", 1L, 14400), tBitMask, new Object[]{"PTP", "PCP", "PPP", 'P', CoreItems2.getRecipe(85, 1), 'C', ItemList.Large_Fluid_Cell_Osmium.get(1), 'T', GT_ModHandler.getModItem("GalacticraftCore", "tile.oxygenPipe", 1L)});
        // --- Module "Expander"
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("GalaxySpace", "item.BasicItems", 1L, 14), tBitMask, new Object[]{"SCS", "PIP", "RFR", 'S', OrePrefixes.stick.get(Materials.ElectricalSteel), 'P', OrePrefixes.plate.get(Materials.ElectricalSteel), 'R', OrePrefixes.ring.get(Materials.ElectricalSteel), 'I', OrePrefixes.circuit.get(Materials.Advanced), 'F', ItemList.Field_Generator_MV, 'C', ItemList.HV_Coil});
        // --- Module "Stabilization"
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("GalaxySpace", "item.BasicItems", 1L, 15), tBitMask, new Object[]{"SCS", "PIP", "RFR", 'S', OrePrefixes.stick.get(Materials.VanadiumSteel), 'P', OrePrefixes.plate.get(Materials.VanadiumSteel), 'R', OrePrefixes.ring.get(Materials.VanadiumSteel), 'I', OrePrefixes.circuit.get(Materials.Advanced), 'F', ItemList.Field_Generator_MV, 'C', ItemList.Electric_Pump_HV});

    }

    private void sifter() {
        RA.addSifterRecipe(GT_ModHandler.getModItem("GalaxySpace", "barnardaCdirt", 1L),
                new ItemStack[]{GT_ModHandler.getModItem("minecraft", "sand", 1L),
                        GT_ModHandler.getModItem("GalaxySpace", "barnardaCdandelions", 1L, 0),
                        GT_ModHandler.getModItem("GalaxySpace", "barnardaCdandelions", 1L, 1),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Gallium, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Yttrium, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Niobium, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Neutronium, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.InfinityCatalyst, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.DraconiumAwakened, 1L)},
                new int[]{5000, 2000, 2000, 600, 500, 400, 100, 30, 30}, 20, 2000000);
    }

    private void pulverizer() {
        RA.addPulveriserRecipe(GT_ModHandler.getModItem("GalaxySpace", "ceresblocks", 1L, 0),
                new ItemStack[]{GregTech_API.getStackofAmountFromOreDict("dustCeres", 1),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.MeteoricIron, 1),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Beryllium, 1)},
                new int[]{10000, 1200, 600}, 400, 120);
        RA.addPulveriserRecipe(GT_ModHandler.getModItem("GalaxySpace", "ceresblocks", 1L, 1),
                new ItemStack[]{GregTech_API.getStackofAmountFromOreDict("dustCeres", 1),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.MeteoricIron, 1),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Beryllium, 1)},
                new int[]{10000, 1200, 600}, 400, 120);
        RA.addPulveriserRecipe(GT_ModHandler.getModItem("GalaxySpace", "europablocks", 1L, 1),
                new ItemStack[]{GregTech_API.getStackofAmountFromOreDict("dustEuropa", 1),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SiliconDioxide, 1),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Iron, 1)},
                new int[]{10000, 1200, 600}, 400, 120);
        RA.addPulveriserRecipe(GT_ModHandler.getModItem("GalaxySpace", "europablocks", 1L, 2),
                new ItemStack[]{GregTech_API.getStackofAmountFromOreDict("dustIceEuropa", 1),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Ledox, 1),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Lapis, 1)},
                new int[]{10000, 1200, 600}, 400, 120);
        RA.addPulveriserRecipe(
                GT_ModHandler.getModItem("GalaxySpace", "europaunderwatergeyser", 1L, 0),
                new ItemStack[]{GregTech_API.getStackofAmountFromOreDict("dustIceEuropa", 1),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Ledox, 2),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Lapis, 2)},
                new int[]{10000, 1200, 600}, 400, 120);
        RA.addPulveriserRecipe(GT_ModHandler.getModItem("GalaxySpace", "europablocks", 1L, 0),
                new ItemStack[]{GregTech_API.getStackofAmountFromOreDict("dustEuropa", 1),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SiliconDioxide, 1),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Iron, 1)},
                new int[]{10000, 1200, 600}, 400, 120);
        RA.addPulveriserRecipe(GT_ModHandler.getModItem("GalaxySpace", "europageyser", 1L, 0),
                new ItemStack[]{GregTech_API.getStackofAmountFromOreDict("dustEuropa", 1),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SiliconDioxide, 2),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Iron, 2)},
                new int[]{10000, 1200, 800}, 400, 120);
        RA.addPulveriserRecipe(GT_ModHandler.getModItem("GalaxySpace", "ganymedeblocks", 1L, 0),
                new ItemStack[]{GregTech_API.getStackofAmountFromOreDict("dustGanymed", 1),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Titanium, 1),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Chromite, 1)},
                new int[]{10000, 900, 200}, 400, 120);
        RA.addPulveriserRecipe(GT_ModHandler.getModItem("GalaxySpace", "ganymedeblocks", 1L, 1),
                new ItemStack[]{GregTech_API.getStackofAmountFromOreDict("dustGanymed", 1),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Titanium, 1),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Chromite, 1)},
                new int[]{10000, 900, 200}, 400, 120);
        RA.addPulveriserRecipe(GT_ModHandler.getModItem("GalaxySpace", "callistoblocks", 1L, 0),
                new ItemStack[]{GregTech_API.getStackofAmountFromOreDict("dustCallisto", 1),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Galena, 1)},
                new int[]{10000, 1200, 600}, 400, 120);
        RA.addPulveriserRecipe(GT_ModHandler.getModItem("GalaxySpace", "callistoblocks", 1L, 1),
                new ItemStack[]{GregTech_API.getStackofAmountFromOreDict("dustIceCallisto", 1),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Galena, 1)},
                new int[]{10000, 1200, 600}, 400, 120);
        RA.addPulveriserRecipe(GT_ModHandler.getModItem("GalaxySpace", "ioblocks", 1L, 0),
                new ItemStack[]{GregTech_API.getStackofAmountFromOreDict("dustIo", 1),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Sulfur, 1),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Tantalite, 1),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Tungsten, 1)},
                new int[]{10000, 1200, 600, 400}, 400, 250);
        RA.addPulveriserRecipe(GT_ModHandler.getModItem("GalaxySpace", "ioblocks", 1L, 7),
                new ItemStack[]{GregTech_API.getStackofAmountFromOreDict("dustIo", 1),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Sulfur, 2),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Tantalite, 2),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Tungsten, 2)},
                new int[]{10000, 1200, 900, 600}, 400, 250);
        RA.addPulveriserRecipe(GT_ModHandler.getModItem("GalaxySpace", "ioblocks", 1L, 1),
                new ItemStack[]{GregTech_API.getStackofAmountFromOreDict("dustIo", 1),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Ash, 1),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Sulfur, 1),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Tantalite, 1)},
                new int[]{10000, 1200, 800, 500}, 400, 250);
        RA.addPulveriserRecipe(GT_ModHandler.getModItem("GalaxySpace", "ioblocks", 1L, 8),
                new ItemStack[]{GregTech_API.getStackofAmountFromOreDict("dustIo", 1),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Ash, 2),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Sulfur, 2),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Tantalite, 2)},
                new int[]{10000, 1200, 1000, 700}, 400, 250);
        RA.addPulveriserRecipe(GT_ModHandler.getModItem("GalaxySpace", "ioblocks", 1L, 2),
                new ItemStack[]{GregTech_API.getStackofAmountFromOreDict("dustIo", 1),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Sulfur, 1),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Tantalite, 1),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Tungsten, 1)},
                new int[]{10000, 1200, 600, 400}, 400, 250);
        RA.addPulveriserRecipe(GT_ModHandler.getModItem("GalaxySpace", "venusblocks", 1L, 0),
                new ItemStack[]{GregTech_API.getStackofAmountFromOreDict("dustVenus", 1),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Tetrahedrite, 1),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Scheelite, 1)},
                new int[]{10000, 1100, 600, 400}, 400, 250);
        RA.addPulveriserRecipe(GT_ModHandler.getModItem("GalaxySpace", "venusblocks", 1L, 1),
                new ItemStack[]{GregTech_API.getStackofAmountFromOreDict("dustVenus", 1),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Tetrahedrite, 1),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Scheelite, 1)},
                new int[]{10000, 1100, 600, 400}, 400, 250);
        RA.addPulveriserRecipe(GT_ModHandler.getModItem("GalaxySpace", "mercuryblocks", 1L, 0),
                new ItemStack[]{GregTech_API.getStackofAmountFromOreDict("dustMercuryP", 1),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Ilmenite, 1),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Tungsten, 1),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Mithril, 1)},
                new int[]{10000, 800, 500, 300}, 400, 250);
        RA.addPulveriserRecipe(GT_ModHandler.getModItem("GalaxySpace", "mercuryblocks", 1L, 1),
                new ItemStack[]{GregTech_API.getStackofAmountFromOreDict("dustMercuryP", 1),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Ilmenite, 1),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Tungsten, 1),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Mithril, 1)},
                new int[]{10000, 800, 500, 300}, 400, 250);
        RA.addPulveriserRecipe(GT_ModHandler.getModItem("GalaxySpace", "mercuryblocks", 1L, 2),
                new ItemStack[]{GregTech_API.getStackofAmountFromOreDict("dustMercuryP", 1),
                         GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Ilmenite, 1),
                         GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Tungsten, 1),
                         GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Mithril, 1)},
                new int[]{10000, 800, 500, 300}, 400, 250);
        RA.addPulveriserRecipe(GT_ModHandler.getModItem("GalaxySpace", "enceladusblocks", 1L, 0),
                new ItemStack[]{GregTech_API.getStackofAmountFromOreDict("dustIceEnceladus", 1),
                         GT_OreDictUnificator.get(OrePrefixes.dust, Materials.MysteriousCrystal, 1),
                         GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Chrome, 1),
                         GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Iridium, 1)},
                new int[]{10000, 400, 500, 300}, 400, 480);
        RA.addPulveriserRecipe(GT_ModHandler.getModItem("GalaxySpace", "enceladusblocks", 1L, 1),
                new ItemStack[]{GregTech_API.getStackofAmountFromOreDict("dustEnceladus", 1),
                         GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Chrome, 1),
                         GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Iridium, 1),
                         GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Osmium, 1)},
                new int[]{10000, 800, 500, 300}, 400, 480);
        RA.addPulveriserRecipe(GT_ModHandler.getModItem("GalaxySpace", "titanblocks", 1L, 0),
                new ItemStack[]{GregTech_API.getStackofAmountFromOreDict("dustTitan", 1),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Nickel, 1),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Iridium, 1),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Osmium, 1)},
                new int[]{10000, 1100, 800, 500}, 400, 480);
        RA.addPulveriserRecipe(GT_ModHandler.getModItem("GalaxySpace", "titanblocks", 1L, 1),
                new ItemStack[]{GregTech_API.getStackofAmountFromOreDict("dustTitan", 1),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Nickel, 1),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Iridium, 1),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Osmium, 1)},
                new int[]{10000, 1100, 800, 500}, 400, 480);
        RA.addPulveriserRecipe(GT_ModHandler.getModItem("GalaxySpace", "titanblocks", 1L, 2),
                new ItemStack[]{GregTech_API.getStackofAmountFromOreDict("dustTitan", 1),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Nickel, 1),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Iridium, 1),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Osmium, 1)},
                new int[]{10000, 1100, 800, 500}, 400, 480);
        RA.addPulveriserRecipe(GT_ModHandler.getModItem("GalaxySpace", "mirandablocks", 1L, 0),
                new ItemStack[]{GregTech_API.getStackofAmountFromOreDict("dustMiranda", 1),
                         GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Tin, 1),
                         GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Tetrahedrite, 1),
                         GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Iridium, 1)},
                new int[]{10000, 600, 400, 300}, 400, 480);
        RA.addPulveriserRecipe(GT_ModHandler.getModItem("GalaxySpace", "mirandablocks", 1L, 1),
                new ItemStack[]{GregTech_API.getStackofAmountFromOreDict("dustMiranda", 1),
                         GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Tin, 1),
                         GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Tetrahedrite, 1),
                         GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Iridium, 1)},
                new int[]{10000, 600, 400, 300}, 400, 480);
        RA.addPulveriserRecipe(GT_ModHandler.getModItem("GalaxySpace", "mirandablocks", 1L, 2),
                new ItemStack[]{GregTech_API.getStackofAmountFromOreDict("dustMiranda", 1),
                         GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Tin, 1),
                         GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Tetrahedrite, 1),
                         GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Iridium, 1)},
                new int[]{10000, 600, 400, 300}, 400, 480);
        RA.addPulveriserRecipe(GT_ModHandler.getModItem("GalaxySpace", "tritonblocks", 1L, 0),
                new ItemStack[]{GregTech_API.getStackofAmountFromOreDict("dustTriton", 1),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Gold, 1),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Neodymium, 1),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.RareEarth, 1)},
                new int[]{10000, 1200, 600, 300}, 400, 1020);
        RA.addPulveriserRecipe(GT_ModHandler.getModItem("GalaxySpace", "tritonblocks", 1L, 1),
                new ItemStack[]{GregTech_API.getStackofAmountFromOreDict("dustTriton", 1),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Gold, 1),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Neodymium, 1),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.RareEarth, 1)},
                new int[]{10000, 1200, 600, 300}, 400, 1020);
        RA.addPulveriserRecipe(GT_ModHandler.getModItem("GalaxySpace", "tritonblocks", 1L, 2),
                new ItemStack[]{GregTech_API.getStackofAmountFromOreDict("dustTriton", 1),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Gold, 1),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Neodymium, 1),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.RareEarth, 1)},
                new int[]{10000, 1200, 600, 300}, 400, 1020);
        RA.addPulveriserRecipe(GT_ModHandler.getModItem("GalaxySpace", "tritonblocks", 1L, 3),
                new ItemStack[]{GregTech_API.getStackofAmountFromOreDict("dustTriton", 1),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Gold, 1),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Neodymium, 1),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.RareEarth, 1)},
                new int[]{10000, 1200, 600, 300}, 400, 1020);
        RA.addPulveriserRecipe(GT_ModHandler.getModItem("GalaxySpace", "tritonblocks", 1L, 4),
                new ItemStack[]{GregTech_API.getStackofAmountFromOreDict("dustTriton", 1),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Gold, 2),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Neodymium, 2),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.RareEarth, 2)},
                new int[]{10000, 1200, 600, 300}, 400, 1020);
        RA.addPulveriserRecipe(GT_ModHandler.getModItem("GalaxySpace", "plutoblocks", 1L, 0),
                new ItemStack[]{GregTech_API.getStackofAmountFromOreDict("dustIcePluto", 1),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Thorium, 1),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Uranium, 1),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Plutonium, 1)},
                new int[]{10000, 1200, 600, 300}, 400, 1920);
        RA.addPulveriserRecipe(GT_ModHandler.getModItem("GalaxySpace", "plutoblocks", 1L, 1),
                new ItemStack[]{GregTech_API.getStackofAmountFromOreDict("dustIcePluto", 1),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Thorium, 1),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Uranium, 1),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Plutonium, 1)},
                new int[]{10000, 1200, 600, 300}, 400, 1920);
        RA.addPulveriserRecipe(GT_ModHandler.getModItem("GalaxySpace", "plutoblocks", 1L, 2),
                new ItemStack[]{GregTech_API.getStackofAmountFromOreDict("dustIcePluto", 1),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Thorium, 1),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Uranium, 1),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Plutonium, 1)},
                new int[]{10000, 1200, 600, 300}, 400, 1920);
        RA.addPulveriserRecipe(GT_ModHandler.getModItem("GalaxySpace", "plutoblocks", 1L, 3),
                new ItemStack[]{GregTech_API.getStackofAmountFromOreDict("dustIcePluto", 1),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Thorium, 1),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Uranium, 1),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Plutonium, 1)},
                new int[]{10000, 1200, 600, 300}, 400, 1920);
        RA.addPulveriserRecipe(GT_ModHandler.getModItem("GalaxySpace", "plutoblocks", 1L, 4),
                new ItemStack[]{GregTech_API.getStackofAmountFromOreDict("dustIcePluto", 1),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Thorium, 1),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Uranium, 1),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Plutonium, 1)},
                new int[]{10000, 1200, 600, 300}, 400, 1920);
        RA.addPulveriserRecipe(GT_ModHandler.getModItem("GalaxySpace", "plutoblocks", 1L, 5),
                new ItemStack[]{GregTech_API.getStackofAmountFromOreDict("dustPluto", 1),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Uranium, 1),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Plutonium, 1),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.BlackPlutonium, 1)},
                new int[]{10000, 1200, 600, 200}, 400, 1920);
        RA.addPulveriserRecipe(GT_ModHandler.getModItem("GalaxySpace", "enceladuscrystal", 1L, 0),
                new ItemStack[]{GT_ModHandler.getModItem("GalaxySpace", "item.BasicItems", 1L, 10),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.MysteriousCrystal, 1),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.MysteriousCrystal, 1),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.MysteriousCrystal, 1)},
                new int[]{10000, 3500, 500, 150}, 200, 480);
        RA.addPulveriserRecipe(GT_ModHandler.getModItem("GalaxySpace", "barnardaclog", 1L),
                new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Wood, 6L),
                        CoreItems2.getRecipe(151, 1)}, new int[]{10000, 3300}, 600, 8);
        RA.addPulveriserRecipe(GT_ModHandler.getModItem("GalaxySpace", "barnardacleaves", 8L),
                new ItemStack[]{CoreItems2.getRecipe(152, 1),
                        GT_ModHandler.getModItem("GalaxySpace", "barnardacdandelions", 1L, 1)},
                new int[]{10000, 5000}, 200, 2);
        RA.addPulveriserRecipe(CoreItems2.getRecipe(152, 1),
                new ItemStack[]{GT_ModHandler.getModItem("GalaxySpace", "barnardacblocks", 1L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.AlienOrganic, 1L)},
                new int[]{10000, 2000}, 100, 40);
        RA.addPulveriserRecipe(GT_ModHandler.getModItem("GalaxySpace", "dungeonglowstone", 1L, 0),
                new ItemStack[]{GT_ModHandler.getModItem("GalaxySpace", "item.GlowstoneDusts", 4L, 0)},
                new int[]{10000}, 300, 2);
        RA.addPulveriserRecipe(GT_ModHandler.getModItem("GalaxySpace", "dungeonglowstone", 1L, 1),
                new ItemStack[]{GT_ModHandler.getModItem("GalaxySpace", "item.GlowstoneDusts", 4L, 1)},
                new int[]{10000}, 300, 2);
        RA.addPulveriserRecipe(GT_ModHandler.getModItem("GalaxySpace", "item.UnknowCrystal", 1L),
                new ItemStack[]{
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.MysteriousCrystal, 1L)},
                new int[]{10000}, 300, 2);
        RA.addPulveriserRecipe(GT_ModHandler.getModItem("GalaxySpace", "surfaceice", 1L, 0),
                new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Ledox, 1),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SiliconDioxide, 1),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.MeteoricIron, 1)},
                new int[]{10000, 1200, 600}, 400, 120);
    }

    private void fluidCanner() {
        RA.addFluidCannerRecipe(
                GT_ModHandler.getModItem("GalaxySpace", "item.oxygentank_t4", 1L, 10800),
                GT_ModHandler.getModItem("GalaxySpace", "item.oxygentank_t4", 1L, 0),
                Materials.Oxygen.getGas(10800L), GT_Values.NF);
        RA.addFluidCannerRecipe(
                GT_ModHandler.getModItem("GalaxySpace", "item.oxygentank_t5", 1L, 12600),
                GT_ModHandler.getModItem("GalaxySpace", "item.oxygentank_t5", 1L, 0),
                Materials.Oxygen.getGas(12600L), GT_Values.NF);
        RA.addFluidCannerRecipe(
                GT_ModHandler.getModItem("GalaxySpace", "item.oxygentank_t6", 1L, 14400),
                GT_ModHandler.getModItem("GalaxySpace", "item.oxygentank_t6", 1L, 0),
                Materials.Oxygen.getGas(14400L), GT_Values.NF);
    }

    private void extractor() {
        for (byte i = 0; i < 6; ++i) {
            RA.addExtractorRecipe(GT_ModHandler.getModItem("GalaxySpace", "tcetiedandelions", 64L, i),
                    CoreItems.getRecipe(TCetiESeaweedExtract.getMetaID(), 1), 400, 262132);
        }
    }

    private void centrifuge() {
        GT_Values.RA
                .addCentrifugeRecipe(GT_ModHandler.getModItem("GalaxySpace", "item.GlowstoneDusts", 1L, 0),
                        GT_Values.NI, GT_Values.NF, GT_Values.NF,
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Glowstone, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.MeteoricIron, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Beryllium, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Platinum, 1L), null, null,
                        new int[]{10000, 1800, 1500, 1200}, 400, 120);
        GT_Values.RA
                .addCentrifugeRecipe(GT_ModHandler.getModItem("GalaxySpace", "item.GlowstoneDusts", 1L, 1),
                        GT_Values.NI, GT_Values.NF, GT_Values.NF,
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Glowstone, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Sulfur, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Tantalite, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Tungsten, 1L), null, null,
                        new int[]{10000, 1800, 1500, 1200}, 500, 250);
    }

    private void arcFurnace() {
        GT_Values.RA
                .addArcFurnaceRecipe(GT_ModHandler.getModItem("GalaxySpace", "item.Tier4Rocket", 1L, 0),
                        new ItemStack[]{CoreItems2.getRecipe(16, 64), CoreItems2.getRecipe(16, 3),
                                ItemList.Ingot_Heavy3.get(28),
                                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.HastelloyN, 24)}, null, 1800,
                        24576);
        GT_Values.RA
                .addArcFurnaceRecipe(GT_ModHandler.getModItem("GalaxySpace", "item.Tier5Rocket", 1L, 0),
                        new ItemStack[]{CoreItems2.getRecipe(17, 64), CoreItems2.getRecipe(17, 17),
                                CoreItems2.getRecipe(16, 30),
                                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Europium, 30)}, null, 2000,
                        98304);
        GT_Values.RA
                .addArcFurnaceRecipe(GT_ModHandler.getModItem("GalaxySpace", "item.Tier6Rocket", 1L, 0),
                        new ItemStack[]{CoreItems2.getRecipe(18, 64), CoreItems2.getRecipe(18, 43),
                                CoreItems2.getRecipe(17, 40),
                                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Americium, 40)}, null, 2200,
                        393216);
        GT_Values.RA
                .addArcFurnaceRecipe(GT_ModHandler.getModItem("GalaxySpace", "item.Tier7Rocket", 1L, 0),
                        new ItemStack[]{CoreItems2.getRecipe(19, 64), CoreItems2.getRecipe(19, 64),
                                CoreItems2.getRecipe(18, 50),
                                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Neutronium, 54)}, null, 2400,
                        1572864);
        GT_Values.RA
                .addArcFurnaceRecipe(GT_ModHandler.getModItem("GalaxySpace", "item.Tier8Rocket", 1L, 0),
                        new ItemStack[]{CoreItems2.getRecipe(20, 64), CoreItems2.getRecipe(20, 64),
                                CoreItems2.getRecipe(19, 60),
                                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Phoenixite, 64)}, null, 2800,
                        6291456);

        //Canisters
        GT_Values.RA
                .addArcFurnaceRecipe(GT_ModHandler.getModItem("GalaxySpace", "item.oxygentank_t4", 1L, GT_Values.W),
                        new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Draconium, 21),
                                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Chrome, 9)}, null, 1000, 1920);
        GT_Values.RA
                .addArcFurnaceRecipe(GT_ModHandler.getModItem("GalaxySpace", "item.oxygentank_t5", 1L, GT_Values.W),
                        new ItemStack[]{CoreItems2.getRecipe(73, 21),
                                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Iridium, 9)}, null, 1100, 4092);
        GT_Values.RA
                .addArcFurnaceRecipe(GT_ModHandler.getModItem("GalaxySpace", "item.oxygentank_t6", 1L, GT_Values.W),
                        new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Quantium, 21),
                                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Osmium, 9)}, null, 1200, 7680);

    }

    private void assembler() {
        // ---  T1 Rocket + chest
        // ---  T4 Rocket + chest
        RA.addAssemblerRecipe(GT_ModHandler.getModItem("GalaxySpace", "item.Tier4Rocket", 1L),
                GT_ModHandler.getModItem("chestup", "Blockchestup", 1L, 2),
                GT_ModHandler.getModItem("GalaxySpace", "item.Tier4Rocket", 1L, 3), 200, 60);
        // ---  T5 Rocket + chest
        RA.addAssemblerRecipe(GT_ModHandler.getModItem("GalaxySpace", "item.Tier5Rocket", 1L),
                GT_ModHandler.getModItem("chestup", "Blockchestup", 1L, 2),
                GT_ModHandler.getModItem("GalaxySpace", "item.Tier5Rocket", 1L, 3), 200, 60);
        // ---  T6 Rocket + chest
        RA.addAssemblerRecipe(GT_ModHandler.getModItem("GalaxySpace", "item.Tier6Rocket", 1L),
                GT_ModHandler.getModItem("chestup", "Blockchestup", 1L, 2),
                GT_ModHandler.getModItem("GalaxySpace", "item.Tier6Rocket", 1L, 3), 200, 60);
        // ---  T7 Rocket + chest
        RA.addAssemblerRecipe(GT_ModHandler.getModItem("GalaxySpace", "item.Tier7Rocket", 1L),
                GT_ModHandler.getModItem("chestup", "Blockchestup", 1L, 2),
                GT_ModHandler.getModItem("GalaxySpace", "item.Tier7Rocket", 1L, 3), 200, 60);
        // ---  T8 Rocket + chest
        RA.addAssemblerRecipe(GT_ModHandler.getModItem("GalaxySpace", "item.Tier8Rocket", 1L),
                GT_ModHandler.getModItem("chestup", "Blockchestup", 1L, 2),
                GT_ModHandler.getModItem("GalaxySpace", "item.Tier8Rocket", 1L, 3), 200, 60);


        // --- Thermal Cloth Tier 2
        RA.addAssemblerRecipe(
                new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.foil, Materials.MeteoricSteel, 4),
                        GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Titanium, 4),
                        GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Tungsten, 4),
                        GT_ModHandler.getModItem("GalacticraftMars", "item.itemBasicAsteroids", 1L, 7)},
                Materials.Polycaprolactam.getMolten(576),
                GT_ModHandler.getModItem("GalaxySpace", "item.ThermalClothT2", 1L), 200, 7680);
        // --- Thermal Padding Helmet Tier 2
        GT_Values.RA
                .addAssemblerRecipe(GT_ModHandler.getModItem("GalaxySpace", "item.ThermalClothT2", 5L),
                        GT_Utility.getIntegratedCircuit(5),
                        GT_ModHandler.getModItem("GalaxySpace", "item.ThermalPaddingT2", 1L), 1500, 7680);
        // --- Thermal Padding Chestpiece Tier 2
        GT_Values.RA
                .addAssemblerRecipe(GT_ModHandler.getModItem("GalaxySpace", "item.ThermalClothT2", 8L),
                        GT_Utility.getIntegratedCircuit(8),
                        GT_ModHandler.getModItem("GalaxySpace", "item.ThermalPaddingT2", 1L, 1), 2400, 7680);
        // --- Thermal Padding Leggings Tier 2
        GT_Values.RA
                .addAssemblerRecipe(GT_ModHandler.getModItem("GalaxySpace", "item.ThermalClothT2", 7L),
                        GT_Utility.getIntegratedCircuit(7),
                        GT_ModHandler.getModItem("GalaxySpace", "item.ThermalPaddingT2", 1L, 2), 2100, 7680);
        // --- Thermal Padding Boots Tier 2
        GT_Values.RA
                .addAssemblerRecipe(GT_ModHandler.getModItem("GalaxySpace", "item.ThermalClothT2", 4L),
                        GT_Utility.getIntegratedCircuit(4),
                        GT_ModHandler.getModItem("GalaxySpace", "item.ThermalPaddingT2", 1L, 3), 1200, 7680);
        // --- Space Suit Jetpack
        //RA.addAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem("GalaxySpace", "item.spacesuit_plate", 1L), GT_ModHandler.getModItem("IC2", "itemArmorJetpackElectric", 1L, GT_Values.W), GT_ModHandler.getModItem("GalaxySpace", "item.CompressedPlates", 4L, 2)}, Materials.Platinum.getMolten(1440), GT_ModHandler.getModItem("GalaxySpace", "item.spacesuit_jetplate", 1L), 600, 1920);
        // --- Space Suit Gravity Boots
        //RA.addAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem("GalaxySpace", "item.spacesuit_boots", 1L), GT_ModHandler.getModItem("GalaxySpace", "item.CompressedPlates", 2L, 4), GT_ModHandler.getModItem("GalaxySpace", "item.CompressedPlates", 4L, 2)}, Materials.Platinum.getMolten(1440), GT_ModHandler.getModItem("GalaxySpace", "item.spacesuit_gravityboots", 1L), 600, 1920);
        // --- Space Suit Sensor Glasses
        //RA.addAssemblerRecipe(new ItemStack[]{GT_ModHandler.getModItem("GalaxySpace", "item.spacesuit_helmet", 1L), GT_ModHandler.getModItem("GalacticraftCore", "item.sensorGlasses", 1L), GT_ModHandler.getModItem("GalaxySpace", "item.CompressedPlates", 4L, 2)}, Materials.Platinum.getMolten(1440), GT_ModHandler.getModItem("GalaxySpace", "item.spacesuit_helmetglasses", 1L), 600, 1920);
        // --- Future Glass
        RA.addAssemblerRecipe(GT_ModHandler.getModItem("minecraft", "glass", 1L),
                GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Desh, 8),
                GT_ModHandler.getModItem("GalaxySpace", "futureglass", 1L), 200, 480);
        // --- Blank Fuel Tank
        RA.addAssemblerRecipe(
                new ItemStack[]{GT_ModHandler.getModItem("GalacticraftCore", "item.basicItem", 6L, 9),
                        GT_OreDictUnificator.get(OrePrefixes.ring, Materials.Steel, 2),
                        GT_Utility.getIntegratedCircuit(2)}, null,
                GT_ModHandler.getModItem("GalaxySpace", "item.BasicItems", 1L, 0), 50, 16);
        // --- Small Fuel Canister
        RA.addAssemblerRecipe(
                new ItemStack[]{GT_ModHandler.getModItem("GalaxySpace", "item.BasicItems", 1L, 0),
                        GT_ModHandler.getModItem("GalaxySpace", "item.CompressedPlates", 2L, 4),
                        GT_Utility.getIntegratedCircuit(1)}, Materials.HSLA.getMolten(72),
                GT_ModHandler.getModItem("GalaxySpace", "item.Modules", 1L, 3), 100, 60);
        // --- EPOT
        RA.addAssemblerRecipe(
                GT_ModHandler.getModItem("GalaxySpace", "item.oxygentank_t4", 1L, 10800),
                GT_ModHandler.getModItem("GalacticraftCore", "item.oxygenConcentrator", 1L, 0),
                GT_ModHandler.getModItem("GalaxySpace", "item.oxygentank_epp_t1", 1L, 10800), 600, 4092);

    }

    private void autoclave() {
        RA.addAutoclaveSpaceRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.MysteriousCrystal, 9L),
                Materials.EnrichedBacterialSludge.getFluid(1000L),
                GT_ModHandler.getModItem("GalaxySpace", "item.BasicItems", 1L, 10), 10000, 2000, 7680,
                true);
    }

    private void compressor() {
        GT_Values.RA
                .addCompressorRecipe(GT_ModHandler.getModItem("GalaxySpace", "item.GlowstoneDusts", 4L),
                        GT_ModHandler.getModItem("GalaxySpace", "dungeonglowstone", 1L), 200, 8);
        GT_Values.RA
                .addCompressorRecipe(GT_ModHandler.getModItem("GalaxySpace", "item.GlowstoneDusts", 4L, 1),
                        GT_ModHandler.getModItem("GalaxySpace", "dungeonglowstone", 1L, 1), 200, 8);

    }

    private void chemical() {
        RA.addChemicalRecipe(GT_ModHandler.getModItem("GalaxySpace", "item.BasicItems", 4L, 10),
                Materials.Osmiridium.getDust(2), Materials.GrowthMediumSterilized.getFluid(1000L),
                Materials.BacterialSludge.getFluid(1000L), ItemList.Circuit_Chip_Stemcell.get(64L),
                GT_Values.NI, 600, 30720);
    }

    private void assemblyLine() {
        RA.addAssemblylineRecipe(CoreItems2.getRecipe(3, 1), 144000, new Object[]{
                        CoreItems2.getRecipe(21, 1),
                        GT_ModHandler.getModItem("GalacticraftMars", "item.itemBasicAsteroids", 4L, 0),
                        CoreItems2.getRecipe(11, 14),
                        CoreItems2.getRecipe(31, 6),
                        CoreItems2.getRecipe(36, 4),
                        CoreItems2.getRecipe(133, 4),
                        CoreItems2.getRecipe(26, 2)
                },
                new FluidStack[]{
                        Materials.SolderingAlloy.getMolten(576),
                        Materials.Lubricant.getFluid(500),
                        new FluidStack(FluidRegistry.getFluid("ic2coolant"), 500)
                },
                GT_ModHandler.getModItem("GalaxySpace", "item.Tier4Rocket", 1L, 0), 3000, 16324);

        RA.addAssemblylineRecipe(CoreItems2.getRecipe(4, 1), 288000, new Object[]{
                        CoreItems2.getRecipe(22, 1),
                        CoreItems2.getRecipe(11, 6),
                        CoreItems2.getRecipe(12, 16),
                        CoreItems2.getRecipe(32, 6),
                        CoreItems2.getRecipe(37, 4),
                        CoreItems2.getRecipe(134, 2),
                        CoreItems2.getRecipe(27, 3)
                },
                new FluidStack[]{
                        Materials.SolderingAlloy.getMolten(1152),
                        Materials.Lubricant.getFluid(1000),
                        new FluidStack(FluidRegistry.getFluid("ic2coolant"), 1000),
                        Materials.Duranium.getMolten(576)
                },
                GT_ModHandler.getModItem("GalaxySpace", "item.Tier5Rocket", 1L, 0), 4000, 65524);

        RA.addAssemblylineRecipe(CoreItems2.getRecipe(5, 1), 432000, new Object[]{
                        CoreItems2.getRecipe(23, 1),
                        CoreItems2.getRecipe(12, 8),
                        CoreItems2.getRecipe(13, 18),
                        CoreItems2.getRecipe(33, 8),
                        CoreItems2.getRecipe(38, 6),
                        CoreItems2.getRecipe(134, 4),
                        CoreItems2.getRecipe(28, 4)
                },
                new FluidStack[]{
                        Materials.SolderingAlloy.getMolten(2304),
                        Materials.Lubricant.getFluid(2000),
                        new FluidStack(FluidRegistry.getFluid("ic2coolant"), 2000),
                        Materials.Tritanium.getMolten(1152)
                },
                GT_ModHandler.getModItem("GalaxySpace", "item.Tier6Rocket", 1L, 0), 5000, 262132);

        RA.addAssemblylineRecipe(CoreItems2.getRecipe(6, 1), 576000, new Object[]{
                        CoreItems2.getRecipe(24, 1),
                        CoreItems2.getRecipe(13, 10),
                        CoreItems2.getRecipe(14, 20),
                        CoreItems2.getRecipe(34, 10),
                        CoreItems2.getRecipe(39, 8),
                        CoreItems2.getRecipe(135, 2),
                        CoreItems2.getRecipe(29, 5)
                },
                new FluidStack[]{
                        Materials.SolderingAlloy.getMolten(4608),
                        Materials.Lubricant.getFluid(4000),
                        new FluidStack(FluidRegistry.getFluid("ic2coolant"), 4000),
                        Materials.Neutronium.getMolten(2304)
                },
                GT_ModHandler.getModItem("GalaxySpace", "item.Tier7Rocket", 1L, 0), 6000, 1000000);

        RA.addAssemblylineRecipe(CoreItems2.getRecipe(7, 1), 1152000, new Object[]{
                        CoreItems2.getRecipe(25, 1),
                        CoreItems2.getRecipe(14, 12),
                        CoreItems2.getRecipe(15, 24),
                        CoreItems2.getRecipe(35, 12),
                        CoreItems2.getRecipe(40, 10),
                        CoreItems2.getRecipe(135, 4),
                        CoreItems2.getRecipe(30, 6)
                },
                new FluidStack[]{
                        Materials.SolderingAlloy.getMolten(9216),
                        Materials.Lubricant.getFluid(8000),
                        new FluidStack(FluidRegistry.getFluid("ic2coolant"), 8000),
                        Materials.Phoenixite.getMolten(4608)
                },
                GT_ModHandler.getModItem("GalaxySpace", "item.Tier8Rocket", 1L, 0), 7000, 4000000);

    }

}
