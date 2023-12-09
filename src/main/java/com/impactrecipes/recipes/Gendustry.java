package com.impactrecipes.recipes;

import com.impact.common.item.Core_Items;
import com.impact.common.item.Core_Items2;
import com.impact.mods.gregtech.GT_ItemList;
import gregtech.api.enums.GT_Values;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.util.GT_ModHandler;
import gregtech.api.util.GT_OreDictUnificator;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

import static gregtech.api.enums.GT_Values.RA;
import static gregtech.api.util.GT_ModHandler.removeRecipeByOutput;

public class Gendustry implements Runnable {

    private static final long tBitMask = GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE;

    final Core_Items2 CoreItems2 = Core_Items2.getInstance();

    @Override
    public void run() {
        removeGendustry();
        hand();
        printer3d();
        assembler();
    }

    private void removeGendustry() {
        removeRecipeByOutput(GT_ModHandler.getModItem("gendustry", "IndustrialApiary", 1L, 0), true,
                false, false);
        removeRecipeByOutput(GT_ModHandler.getModItem("gendustry", "MutagenProducer", 1L, 0), true,
                false, false);
        removeRecipeByOutput(GT_ModHandler.getModItem("gendustry", "Mutatron", 1L, 0), true, false,
                false);
        removeRecipeByOutput(GT_ModHandler.getModItem("gendustry", "Imprinter", 1L, 0), true, false,
                false);
        removeRecipeByOutput(GT_ModHandler.getModItem("gendustry", "Sampler", 1L, 0), true, false,
                false);
        removeRecipeByOutput(GT_ModHandler.getModItem("gendustry", "MutatronAdv", 1L, 0), true, false,
                false);
        removeRecipeByOutput(GT_ModHandler.getModItem("gendustry", "Liquifier", 1L, 0), true, false,
                false);
        removeRecipeByOutput(GT_ModHandler.getModItem("gendustry", "Extractor", 1L, 0), true, false,
                false);
        removeRecipeByOutput(GT_ModHandler.getModItem("gendustry", "Transposer", 1L, 0), true, false,
                false);
        removeRecipeByOutput(GT_ModHandler.getModItem("gendustry", "Replicator", 1L, 0), true, false,
                false);
    /*removeRecipeByOutput(GT_ModHandler.getModItem("gendustry", "GeneSampleBlank", 1L, 0), true,
        false, false);
    removeRecipeByOutput(GT_ModHandler.getModItem("gendustry", "GeneTemplate", 1L, 0), true, false,
        false);
        */
        removeRecipeByOutput(GT_ModHandler.getModItem("gendustry", "Labware", 1L, 0), true, false,
                false);
        removeRecipeByOutput(GT_ModHandler.getModItem("gendustry", "BeeReceptacle", 1L, 0), true, false,
                false);
        removeRecipeByOutput(GT_ModHandler.getModItem("gendustry", "PowerModule", 1L, 0), true, false,
                false);
        removeRecipeByOutput(GT_ModHandler.getModItem("gendustry", "MutagenTank", 1L, 0), true, false,
                false);
        removeRecipeByOutput(GT_ModHandler.getModItem("gendustry", "GeneticsProcessor", 1L, 0), true,
                false, false);
        removeRecipeByOutput(GT_ModHandler.getModItem("gendustry", "EnvProcessor", 1L, 0), true, false,
                false);
        removeRecipeByOutput(GT_ModHandler.getModItem("gendustry", "UpgradeFrame", 1L, 0), true, false,
                false);
        removeRecipeByOutput(GT_ModHandler.getModItem("gendustry", "ClimateModule", 1L, 0), true, false,
                false);
        removeRecipeByOutput(GT_ModHandler.getModItem("gendustry", "ApiaryUpgrade", 1L, GT_Values.W),
                true, false, false);
        removeRecipeByOutput(
                GT_ModHandler.getModItem("gendustry", "IndustrialGrafter", 1L, GT_Values.W), true, false,
                false);
        removeRecipeByOutput(GT_ModHandler.getModItem("gendustry", "IndustrialScoop", 1L, GT_Values.W),
                true, false, false);
        removeRecipeByOutput(GT_ModHandler.getModItem("gendustry", "EjectCover", 1L, 0), true, false,
                false);
        removeRecipeByOutput(GT_ModHandler.getModItem("gendustry", "ImportCover", 1L, 0), true, false,
                false);
        removeRecipeByOutput(GT_ModHandler.getModItem("gendustry", "ErrorSensorCover", 1L, 0), true,
                false, false);
    }

    private void hand() {
        // --- Genetic Imprinter
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("gendustry", "Imprinter", 1L), tBitMask, new Object[]{"PGP", "BCB", "GMG", 'G', OrePrefixes.gearGt.get(Materials.Osmium), 'C', ItemList.Hull_LuV, 'B', GT_ModHandler.getModItem("gendustry", "BeeReceptacle", 1L), 'P', GT_ModHandler.getModItem("gendustry", "GeneticsProcessor", 1L), 'M', GT_ModHandler.getModItem("gendustry", "PowerModule", 1L)});
        // --- Genetic Sampler
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("gendustry", "Sampler", 1L), tBitMask, new Object[]{"PBP", "ICI", "GMG", 'G', OrePrefixes.gearGt.get(Materials.Osmium), 'C', ItemList.Hull_LuV, 'B', GT_ModHandler.getModItem("gendustry", "BeeReceptacle", 1L), 'P', GT_ModHandler.getModItem("gendustry", "GeneticsProcessor", 1L), 'M', GT_ModHandler.getModItem("gendustry", "PowerModule", 1L), 'I', GT_ItemList.EngravedDiamondCrystalChip});
        // --- Protein Liquifier
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("gendustry", "Liquifier", 1L), tBitMask, new Object[]{"GIG", "PCP", "GMG", 'G', OrePrefixes.gearGt.get(Materials.Osmium), 'C', ItemList.Hull_LuV, 'M', GT_ModHandler.getModItem("gendustry", "PowerModule", 1L), 'I', ItemList.Conveyor_Module_LuV, 'P', ItemList.Electric_Piston_LuV});
        // --- DNA Extractor
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("gendustry", "Extractor", 1L), tBitMask, new Object[]{"IBI", "PCP", "GMG", 'G', OrePrefixes.gearGt.get(Materials.Osmium), 'C', ItemList.Hull_LuV, 'B', GT_ModHandler.getModItem("gendustry", "BeeReceptacle", 1L), 'P', GT_ModHandler.getModItem("gendustry", "GeneticsProcessor", 1L), 'M', GT_ModHandler.getModItem("gendustry", "PowerModule", 1L), 'I', ItemList.Electric_Piston_LuV});
        // --- Genetic Transposer
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("gendustry", "Transposer", 1L), tBitMask, new Object[]{"IGI", "PCP", "GMG", 'G', OrePrefixes.gearGt.get(Materials.Osmium), 'C', ItemList.Hull_LuV, 'P', GT_ModHandler.getModItem("gendustry", "GeneticsProcessor", 1L), 'M', GT_ModHandler.getModItem("gendustry", "PowerModule", 1L), 'I', ItemList.Robot_Arm_LuV});
        // --- Genetic Replicator
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("gendustry", "Replicator", 1L), tBitMask, new Object[]{"IPI", "MCM", "GPG", 'G', OrePrefixes.gearGt.get(Materials.Osmium), 'C', ItemList.Hull_LuV, 'P', GT_ModHandler.getModItem("gendustry", "GeneticsProcessor", 1L), 'M', GT_ModHandler.getModItem("gendustry", "PowerModule", 1L), 'I', ItemList.Robot_Arm_LuV});
        // --- Bee Receptacle
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("gendustry", "BeeReceptacle", 1L), tBitMask, new Object[]{"SPS", "CIC", "SdS", 'S', OrePrefixes.screw.get(Materials.HSSS), 'P', OrePrefixes.plate.get(Materials.HSSG), 'C', CoreItems2.getRecipe(52, 1), 'I', CoreItems2.getRecipe(146, 1)});
        // --- Power Module
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("gendustry", "PowerModule", 1L), tBitMask, new Object[]{"WPW", "CIC", "GMG", 'W', OrePrefixes.wireGt02.get(Materials.VanadiumGallium), 'P', OrePrefixes.plate.get(Materials.HSSG), 'C', CoreItems2.getRecipe(52, 1), 'I', OrePrefixes.circuit.get(Materials.Master), 'G', OrePrefixes.gearGtSmall.get(Materials.Osmium), 'M', ItemList.Electric_Motor_LuV});
        // --- Plains Emulation Upgrade
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("gendustry", "ApiaryUpgrade", 1L, 17), tBitMask, new Object[]{"HCH", "OUO", "GPG", 'H', OrePrefixes.gearGtSmall.get(Materials.HastelloyC276), 'G', OrePrefixes.gearGtSmall.get(Materials.Osmium), 'C', GT_ModHandler.getModItem("gendustry", "ClimateModule", 1L), 'P', GT_ModHandler.getModItem("gendustry", "EnvProcessor", 1L), 'U', GT_ModHandler.getModItem("gendustry", "UpgradeFrame", 1L), 'O', new ItemStack(Blocks.grass)});
        // --- Light Upgrade
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("gendustry", "ApiaryUpgrade", 1L, 11), tBitMask, new Object[]{"HSH", "SUS", "GSG", 'H', OrePrefixes.gearGtSmall.get(Materials.HastelloyC276), 'G', OrePrefixes.gearGtSmall.get(Materials.Osmium), 'S', GT_ModHandler.getModItem("ExtraUtilities", "decorativeBlock2", 1L, 7), 'U', GT_ModHandler.getModItem("gendustry", "UpgradeFrame", 1L)});
        // --- Flowering Upgrade
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("gendustry", "ApiaryUpgrade", 1L, 2), tBitMask, new Object[]{"HRH", "YUY", "GRG", 'H', OrePrefixes.gearGtSmall.get(Materials.HastelloyC276), 'G', OrePrefixes.gearGtSmall.get(Materials.Osmium), 'R', new ItemStack(Blocks.red_flower), 'Y', new ItemStack(Blocks.yellow_flower), 'U', GT_ModHandler.getModItem("gendustry", "UpgradeFrame", 1L)});
        // --- Winter Emulation Upgrade
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("gendustry", "ApiaryUpgrade", 1L, 20), tBitMask, new Object[]{"HCH", "OUO", "GPG", 'H', OrePrefixes.gearGtSmall.get(Materials.HastelloyC276), 'G', OrePrefixes.gearGtSmall.get(Materials.Osmium), 'C', GT_ModHandler.getModItem("gendustry", "ClimateModule", 1L), 'P', GT_ModHandler.getModItem("gendustry", "EnvProcessor", 1L), 'U', GT_ModHandler.getModItem("gendustry", "UpgradeFrame", 1L), 'O', new ItemStack(Blocks.ice)});
        // --- Dryer Upgrade
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("gendustry", "ApiaryUpgrade", 1L, 5), tBitMask, new Object[]{"HCH", "OUO", "GOG", 'H', OrePrefixes.gearGtSmall.get(Materials.HastelloyC276), 'G', OrePrefixes.gearGtSmall.get(Materials.Osmium), 'C', GT_ModHandler.getModItem("gendustry", "ClimateModule", 1L), 'U', GT_ModHandler.getModItem("gendustry", "UpgradeFrame", 1L), 'O', new ItemStack(Blocks.sand)});
        // --- Humidifier Upgrade
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("gendustry", "ApiaryUpgrade", 1L, 4), tBitMask, new Object[]{"HCH", "OUO", "GOG", 'H', OrePrefixes.gearGtSmall.get(Materials.HastelloyC276), 'G', OrePrefixes.gearGtSmall.get(Materials.Osmium), 'C', GT_ModHandler.getModItem("gendustry", "ClimateModule", 1L), 'U', GT_ModHandler.getModItem("gendustry", "UpgradeFrame", 1L), 'O', new ItemStack(Blocks.cactus)});
        // --- Hell Emulation Upgrade
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("gendustry", "ApiaryUpgrade", 1L, 13), tBitMask, new Object[]{"HCH", "OUO", "GPG", 'H', OrePrefixes.gearGtSmall.get(Materials.HastelloyC276), 'G', OrePrefixes.gearGtSmall.get(Materials.Osmium), 'C', GT_ModHandler.getModItem("gendustry", "ClimateModule", 1L), 'P', GT_ModHandler.getModItem("gendustry", "EnvProcessor", 1L), 'U', GT_ModHandler.getModItem("gendustry", "UpgradeFrame", 1L), 'O', new ItemStack(Blocks.netherrack)});
        // --- Desert Emulation Upgrade
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("gendustry", "ApiaryUpgrade", 1L, 16), tBitMask, new Object[]{"HCH", "OUO", "GPG", 'H', OrePrefixes.gearGtSmall.get(Materials.HastelloyC276), 'G', OrePrefixes.gearGtSmall.get(Materials.Osmium), 'C', GT_ModHandler.getModItem("gendustry", "ClimateModule", 1L), 'P', GT_ModHandler.getModItem("gendustry", "EnvProcessor", 1L), 'U', GT_ModHandler.getModItem("gendustry", "UpgradeFrame", 1L), 'O', new ItemStack(Blocks.sandstone)});
        // --- Jungle Emulation Upgrade
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("gendustry", "ApiaryUpgrade", 1L, 18), tBitMask, new Object[]{"HCH", "OUO", "GPG", 'H', OrePrefixes.gearGtSmall.get(Materials.HastelloyC276), 'G', OrePrefixes.gearGtSmall.get(Materials.Osmium), 'C', GT_ModHandler.getModItem("gendustry", "ClimateModule", 1L), 'P', GT_ModHandler.getModItem("gendustry", "EnvProcessor", 1L), 'U', GT_ModHandler.getModItem("gendustry", "UpgradeFrame", 1L), 'O', new ItemStack(Blocks.vine)});
        // --- Ocean Emulation Upgrade
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("gendustry", "ApiaryUpgrade", 1L, 21), tBitMask, new Object[]{"HCH", "OUO", "GPG", 'H', OrePrefixes.gearGtSmall.get(Materials.HastelloyC276), 'G', OrePrefixes.gearGtSmall.get(Materials.Osmium), 'C', GT_ModHandler.getModItem("gendustry", "ClimateModule", 1L), 'P', GT_ModHandler.getModItem("gendustry", "EnvProcessor", 1L), 'U', GT_ModHandler.getModItem("gendustry", "UpgradeFrame", 1L), 'O', new ItemStack(Items.water_bucket)});
        // --- Cooler Upgrade
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("gendustry", "ApiaryUpgrade", 1L, 7), tBitMask, new Object[]{"HCH", "OUO", "GOG", 'H', OrePrefixes.gearGtSmall.get(Materials.HastelloyC276), 'G', OrePrefixes.gearGtSmall.get(Materials.Osmium), 'C', GT_ModHandler.getModItem("gendustry", "ClimateModule", 1L), 'U', GT_ModHandler.getModItem("gendustry", "UpgradeFrame", 1L), 'O', new ItemStack(Items.snowball)});
        // --- Automation Upgrade
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("gendustry", "ApiaryUpgrade", 1L, 14), tBitMask, new Object[]{"HCH", "OUO", "GPG", 'H', OrePrefixes.gearGtSmall.get(Materials.HastelloyC276), 'G', OrePrefixes.gearGtSmall.get(Materials.Osmium), 'C', OrePrefixes.gearGt.get(Materials.BT6), 'P', ItemList.Electric_Piston_EV, 'U', GT_ModHandler.getModItem("gendustry", "UpgradeFrame", 1L), 'O', new ItemStack(Blocks.redstone_torch)});
        // --- Pollen Scrubber Upgrade
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("gendustry", "ApiaryUpgrade", 1L, 22), tBitMask, new Object[]{"HPH", "OUO", "GPG", 'H', OrePrefixes.gearGtSmall.get(Materials.HastelloyC276), 'G', OrePrefixes.gearGtSmall.get(Materials.Osmium), 'P', CoreItems2.getRecipe(51, 1), 'U', GT_ModHandler.getModItem("gendustry", "UpgradeFrame", 1L), 'O', OrePrefixes.rotor.get(Materials.Titanium)});
        // --- Live Spawn Upgrade
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("gendustry", "ApiaryUpgrade", 1L, 1), tBitMask, new Object[]{"HPH", "OUO", "GPG", 'H', OrePrefixes.gearGtSmall.get(Materials.HastelloyC276), 'G', OrePrefixes.gearGtSmall.get(Materials.Osmium), 'P', new ItemStack(Items.flower_pot), 'U', GT_ModHandler.getModItem("gendustry", "UpgradeFrame", 1L), 'O', new ItemStack(Items.clock)});
        // --- Seal Upgrade
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("gendustry", "ApiaryUpgrade", 1L, 10), tBitMask, new Object[]{"HPH", "OUO", "GPG", 'H', OrePrefixes.gearGtSmall.get(Materials.HastelloyC276), 'G', OrePrefixes.gearGtSmall.get(Materials.Osmium), 'P', OrePrefixes.plate.get(Materials.Rubber), 'U', GT_ModHandler.getModItem("gendustry", "UpgradeFrame", 1L), 'O', "itemBeeswax"});
        // --- Genetics Stabilizer Upgrade
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("gendustry", "ApiaryUpgrade", 1L, 19), tBitMask, new Object[]{"HPH", "OUO", "GPG", 'H', OrePrefixes.gearGtSmall.get(Materials.HastelloyC276), 'G', OrePrefixes.gearGtSmall.get(Materials.Osmium), 'P', GT_ModHandler.getModItem("gendustry", "GeneticsProcessor", 1L), 'U', GT_ModHandler.getModItem("gendustry", "UpgradeFrame", 1L), 'O', OrePrefixes.plate.get(Materials.RedAlloy)});
        // --- Territory Upgrade
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("gendustry", "ApiaryUpgrade", 1L, 3), tBitMask, new Object[]{"HPH", "OUO", "GPG", 'H', OrePrefixes.gearGtSmall.get(Materials.HastelloyC276), 'G', OrePrefixes.gearGtSmall.get(Materials.Osmium), 'P', OrePrefixes.plate.get(Materials.Iron), 'U', GT_ModHandler.getModItem("gendustry", "UpgradeFrame", 1L), 'O', OrePrefixes.plate.get(Materials.Diamond)});
        // --- Open Sky Upgrade
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("gendustry", "ApiaryUpgrade", 1L, 12), tBitMask, new Object[]{"HPH", "OUO", "GOG", 'H', OrePrefixes.gearGtSmall.get(Materials.HastelloyC276), 'G', OrePrefixes.gearGtSmall.get(Materials.Osmium), 'P', GT_ModHandler.getModItem("ProjRed|Illumination", "projectred.illumination.lamp", 1L, 27), 'U', GT_ModHandler.getModItem("gendustry", "UpgradeFrame", 1L), 'O', "paneGlass"});
        // --- Heater Upgrade
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("gendustry", "ApiaryUpgrade", 1L, 6), tBitMask, new Object[]{"HPH", "OUO", "GOG", 'H', OrePrefixes.gearGtSmall.get(Materials.HastelloyC276), 'G', OrePrefixes.gearGtSmall.get(Materials.Osmium), 'P', GT_ModHandler.getModItem("gendustry", "ClimateModule", 1L), 'U', GT_ModHandler.getModItem("gendustry", "UpgradeFrame", 1L), 'O', new ItemStack(Blocks.netherrack)});
        // --- Sieve Upgrade
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("gendustry", "ApiaryUpgrade", 1L, 15), tBitMask, new Object[]{"HPH", "OUO", "GPG", 'H', OrePrefixes.gearGtSmall.get(Materials.HastelloyC276), 'G', OrePrefixes.gearGtSmall.get(Materials.Osmium), 'P', GT_ModHandler.getModItem("Forestry", "craftingMaterial", 1L, 3), 'U', GT_ModHandler.getModItem("gendustry", "UpgradeFrame", 1L), 'O', CoreItems2.getRecipe(51, 1)});
        // --- Production Upgrade
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("gendustry", "ApiaryUpgrade", 1L), tBitMask, new Object[]{"HPH", "OUO", "GPG", 'H', OrePrefixes.gearGtSmall.get(Materials.HastelloyC276), 'G', OrePrefixes.gearGtSmall.get(Materials.Osmium), 'P', new ItemStack(Items.sugar), 'U', GT_ModHandler.getModItem("gendustry", "UpgradeFrame", 1L), 'O', GT_ModHandler.getModItem("Forestry", "royalJelly", 1L)});
        // --- Industrial Grafter
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("gendustry", "IndustrialGrafter", 1L, 100), tBitMask, new Object[]{"PdI", "GAS", "MBP", 'S', OrePrefixes.screw.get(Materials.StainlessSteel), 'A', OrePrefixes.stickLong.get(Materials.StainlessSteel), 'G', OrePrefixes.gearGtSmall.get(Materials.StainlessSteel), 'P', OrePrefixes.plate.get(Materials.StainlessSteel), 'M', ItemList.Electric_Motor_LV, 'B', ItemList.Battery_RE_LV_Lithium, 'I', GT_ModHandler.getModItem("Forestry", "grafter", 1L)});
        // --- Industrial Scoop
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("gendustry", "IndustrialScoop", 1L, 100), tBitMask, new Object[]{"PdI", "GAS", "MBP", 'S', OrePrefixes.screw.get(Materials.StainlessSteel), 'A', OrePrefixes.stickLong.get(Materials.StainlessSteel), 'G', OrePrefixes.gearGtSmall.get(Materials.StainlessSteel), 'P', OrePrefixes.plate.get(Materials.StainlessSteel), 'M', ItemList.Electric_Motor_LV, 'B', ItemList.Battery_RE_LV_Lithium, 'I', new ItemStack(Blocks.wool)});
        // --- Climate Control Module
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("gendustry", "ClimateModule", 1L), tBitMask, new Object[]{"SIS", "GBG", "PMP", 'S', OrePrefixes.plate.get(Materials.HSSG), 'G', OrePrefixes.stick.get(Materials.Palladium), 'P', CoreItems2.getRecipe(52, 1), 'M', ItemList.Electric_Motor_LuV, 'B', OrePrefixes.rotor.get(Materials.Osmium), 'I', ItemList.LuV_Coil});
        // --- Mutagen Tank
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("gendustry", "MutagenTank", 1L), tBitMask, new Object[]{"SPS", "CIC", "SdS", 'S', OrePrefixes.screw.get(Materials.HSSS), 'P', OrePrefixes.plate.get(Materials.HSSG), 'C', CoreItems2.getRecipe(52, 1), 'I', ItemList.Large_Fluid_Cell_TungstenSteel});

    }

    private void printer3d() {
        // --- Mutagen Producer
        RA.addBasicLineRecipe(new ItemStack[]{
                ItemList.Hull_LuV.get(1), GT_ModHandler.getModItem("gendustry", "GeneticsProcessor", 2L, 0),
                GT_ModHandler.getModItem("gendustry", "BeeReceptacle", 2L, 0),
                GT_ModHandler.getModItem("gendustry", "PowerModule", 2L, 0),
                ItemList.Robot_Arm_LuV.get(2), ItemList.Electric_Pump_LuV.get(4),
                GT_ModHandler.getModItem("gendustry", "MutagenTank", 4L, 0),
                GT_OreDictUnificator.get(OrePrefixes.gear, Materials.Trinium, 4),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Osmium, 8),
                GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.HSSE, 32),
                GT_OreDictUnificator.get(OrePrefixes.screw, Materials.HSSS, 32)
        }, GT_ModHandler.getModItem("gendustry", "MutagenProducer", 1L, 0), null, 100 * 20, 65576);

        // --- Mutatron
        RA.addBasicLineRecipe(new ItemStack[]{
                ItemList.Hull_LuV.get(1), GT_ModHandler.getModItem("gendustry", "GeneticsProcessor", 2L, 0),
                GT_ModHandler.getModItem("gendustry", "BeeReceptacle", 2L, 0),
                GT_ModHandler.getModItem("gendustry", "PowerModule", 2L, 0),
                ItemList.Robot_Arm_LuV.get(2), GT_ModHandler.getModItem("gendustry", "MutagenTank", 4L, 0),
                GT_OreDictUnificator.get(OrePrefixes.gear, Materials.Osmium, 4),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Naquadah, 8),
                GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.HSSE, 32),
                GT_OreDictUnificator.get(OrePrefixes.screw, Materials.HSSS, 32)
        }, GT_ModHandler.getModItem("gendustry", "Mutatron", 1L, 0), null, 100 * 20, 65576);

        // --- Advanced Mutatron
        RA.addBasicLineRecipe(new ItemStack[]{
                ItemList.Hull_ZPM.get(1), GT_ModHandler.getModItem("gendustry", "GeneticsProcessor", 4L, 0),
                GT_ModHandler.getModItem("gendustry", "BeeReceptacle", 4L, 0),
                GT_ModHandler.getModItem("gendustry", "PowerModule", 4L, 0),
                ItemList.Robot_Arm_ZPM.get(4), GT_ModHandler.getModItem("gendustry", "MutagenTank", 8L, 0),
                GT_OreDictUnificator.get(OrePrefixes.gear, Materials.NaquadahAlloy, 8),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.MysteriousCrystal, 16),
                GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.HSSE, 64),
                GT_OreDictUnificator.get(OrePrefixes.screw, Materials.HSSS, 64)
        }, GT_ModHandler.getModItem("gendustry", "MutatronAdv", 1L, 0), null, 200 * 20, 500000);

        // --- Industrial Apiary
        RA.addPrimitiveLineRecipe(new ItemStack[]{
                GT_ModHandler.getModItem("Forestry", "apiculture", 1L, 0),
                GT_ModHandler.getModItem("Forestry", "alveary", 2L, 2),
                GT_ModHandler.getModItem("Forestry", "alveary", 2L, 3),
                GT_ModHandler.getModItem("Forestry", "alveary", 2L, 4),
                GT_ModHandler.getModItem("Forestry", "alveary", 2L, 5),
                GT_ModHandler.getModItem("Forestry", "alveary", 2L, 6),
                GT_ModHandler.getModItem("Forestry", "alveary", 2L, 7),
                GT_ModHandler.getModItem("Forestry", "alveary", 4L, 0), ItemList.Field_Generator_HV.get(4)
        }, GT_ModHandler.getModItem("gendustry", "IndustrialApiary", 1L, 0), null, 60 * 20, 1024);

    }

    private void assembler() {
        RA.addAssemblerRecipe(CoreItems2.getRecipe(146, 1),
                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Elite, 1),
                Materials.Mutagen.getFluid(100L), GT_ModHandler.getModItem("gendustry", "UpgradeFrame", 1L),
                400, 7680);
        // --- Genetics Processor
        RA.addAssemblerRecipe(GT_ItemList.GeneticCircuit.get(1),
                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Elite, 1),
                Materials.Mutagen.getFluid(500L),
                GT_ModHandler.getModItem("gendustry", "GeneticsProcessor", 1L), 400, 7680);
        // --- Environmental Processor
        RA.addAssemblerRecipe(GT_ItemList.EnvironmentalCircuit.get(1),
                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Elite, 1),
                Materials.Bacteria.getFluid(500L),
                GT_ModHandler.getModItem("gendustry", "EnvProcessor", 1L), 400, 7680);
        // --- Genetics Labware
        RA.addAssemblerRecipe(
                new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.plate, Materials.StainlessSteel, 1),
                        GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Diamond, 2),
                        new ItemStack(Items.glass_bottle, 4)}, null,
                GT_ModHandler.getModItem("gendustry", "Labware", 1L), 200, 1920, true);
        // --- Item Ejector Cover
        RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.plate, Materials.HSSG, 1),
                GT_ModHandler.getModItem("IC2", "upgradeModule", 1L, 3),
                GT_ModHandler.getModItem("gendustry", "EjectCover", 1L), 200, 7680);
        // --- Item Import Cover
        RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.plate, Materials.HSSG, 1),
                GT_ModHandler.getModItem("IC2", "upgradeModule", 1L, 6),
                GT_ModHandler.getModItem("gendustry", "ImportCover", 1L), 200, 7680);
        // --- Item Sensor Cover
        RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.plate, Materials.HSSG, 1),
                GT_ModHandler.getModItem("IC2", "upgradeModule", 1L, 5),
                GT_ModHandler.getModItem("gendustry", "ErrorSensorCover", 1L), 200, 7680);

    }
}
