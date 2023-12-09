package com.impactrecipes.recipes;

import com.impact.mods.gregtech.GT_ItemList;
import gregtech.api.enums.GT_Values;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.util.GT_ModHandler;
import gregtech.api.util.GT_OreDictUnificator;
import gregtech.api.util.GT_Utility;
import net.minecraft.item.ItemStack;

import static gregtech.api.enums.GT_Values.RA;
import static gregtech.api.util.GT_ModHandler.removeRecipeByOutput;

public class ExtraUtilities implements Runnable {

    private static final long tBitMask = GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE;

    @Override
    public void run() {
        removeExtraUtilities();
        hand();
        printer3d();
        alloySmalter();
        assembler();
        chemical();
    }

    private void removeExtraUtilities() {
        removeRecipeByOutput(GT_ModHandler.getModItem("ExtraUtilities", "enderQuarry", 1L, 0), true,
                false, false);
        removeRecipeByOutput(GT_ModHandler.getModItem("ExtraUtilities", "endMarker", 1L, 0), true,
                false, false);
        removeRecipeByOutput(GT_ModHandler.getModItem("ExtraUtilities", "dark_portal", 1L, 2), true,
                false, false);
        removeRecipeByOutput(GT_ModHandler.getModItem("ExtraUtilities", "dark_portal", 1, 0), true,
                false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("ExtraUtilities", "enderThermicPump", 1, 0), true,
                false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("ExtraUtilities", "chestMini", 1, 0), true, false,
                true);
        removeRecipeByOutput(GT_ModHandler.getModItem("ExtraUtilities", "chestFull", 1, 0), true, false,
                true);
        removeRecipeByOutput(GT_ModHandler.getModItem("ExtraUtilities", "trashcan", 1, 0), true, false,
                true);
        removeRecipeByOutput(GT_ModHandler.getModItem("ExtraUtilities", "watering_can", 1, 1), true,
                false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("ExtraUtilities", "timer", 1, 0), true, false,
                true);
        removeRecipeByOutput(GT_ModHandler.getModItem("ExtraUtilities", "angelBlock", 1, 0), true,
                false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("ExtraUtilities", "golden_bag", 1, 0), true,
                false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("ExtraUtilities", "decorativeBlock2", 1, 0), true,
                false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("ExtraUtilities", "decorativeBlock2", 1, 4), true,
                false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("ExtraUtilities", "decorativeBlock2", 1, 5), true,
                false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("ExtraUtilities", "decorativeBlock2", 1, 3), true,
                false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("ExtraUtilities", "decorativeBlock2", 1, 7), true,
                false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("ExtraUtilities", "decorativeBlock2", 1, 8), true,
                false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("ExtraUtilities", "decorativeBlock2", 1, 1), true,
                false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("ExtraUtilities", "decorativeBlock2", 1, 2), true,
                false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("ExtraUtilities", "decorativeBlock2", 1, 6), true,
                false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("ExtraUtilities", "decorativeBlock2", 1, 9), true,
                false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("ExtraUtilities", "decorativeBlock2", 1, 10),
                true, false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("ExtraUtilities", "decorativeBlock2", 1, 11),
                true, false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("ExtraUtilities", "decorativeBlock1", 1), true,
                false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("ExtraUtilities", "decorativeBlock1", 1, 9), true,
                false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("ExtraUtilities", "decorativeBlock1", 1, 4), true,
                false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("ExtraUtilities", "decorativeBlock1", 1, 7), true,
                false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("ExtraUtilities", "decorativeBlock1", 1, 6), true,
                false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("ExtraUtilities", "decorativeBlock1", 1, 3), true,
                false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("ExtraUtilities", "decorativeBlock1", 1, 10),
                true, false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("ExtraUtilities", "decorativeBlock1", 1, 13),
                true, false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("ExtraUtilities", "decorativeBlock1", 1, 8),
                true, false, true);
		for (int i = 0; i < 16; i++) {
            removeRecipeByOutput(GT_ModHandler.getModItem("ExtraUtilities", "greenscreen", 1, i),
                true, false, true);
        }

    }

    private void hand() {
        // --- Mini Chest
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("ExtraUtilities", "chestMini", 1L), tBitMask, new Object[]{"hPs", "P P", " P ", 'P', OrePrefixes.plate.get(Materials.Wood)});
        // --- Slightly larger Chest
        //GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("ExtraUtilities", "chestFull", 1L), tBitMask, new Object[]{"hPs", "PСP", " P ", 'P', OrePrefixes.plate.get(Materials.Wood), 'C', GT_ModHandler.getModItem("minecraft", "chest", 1L)});
        // --- Filing Cabinet
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("ExtraUtilities", "filing", 1L), tBitMask, new Object[]{"PUP", "SCS", "PUP", 'P', OrePrefixes.plate.get(Materials.Steel), 'S', OrePrefixes.screw.get(Materials.Steel), 'U', GT_ModHandler.getModItem("ExtraUtilities", "chestFull", 1L, 0), 'C', GT_ModHandler.getModItem("chestup", "Blockchestup", 1L, 1)});
        // --- Advanced Filing Cabinet
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("ExtraUtilities", "filing", 1L, 1), tBitMask, new Object[]{"PUP", "SUS", "PUP", 'P', OrePrefixes.plateDouble.get(Materials.Gold), 'S', OrePrefixes.screw.get(Materials.Steel), 'U', GT_ModHandler.getModItem("ExtraUtilities", "filing", 1L, 0)});
        // --- Trash Can
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("ExtraUtilities", "trashcan", 1L), tBitMask, new Object[]{"PhP", "PBP", "PSP", 'S', "slimeball", 'P', OrePrefixes.plate.get(Materials.Iron), 'B', GT_ModHandler.getModItem("minecraft", "bucket", 1L, 0)});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("ExtraUtilities", "trashcan", 1L), tBitMask, new Object[]{"PhP", "PBP", "PSP", 'S', GT_ModHandler.getModItem("IC2", "itemHarz", 1L), 'P', OrePrefixes.plate.get(Materials.Iron), 'B', GT_ModHandler.getModItem("minecraft", "bucket", 1L, 0)});
        // --- Watering Can
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("ExtraUtilities", "watering_can", 1L, 1), tBitMask, new Object[]{"hRd", "PPI", "PPS", 'I', OrePrefixes.stick.get(Materials.Steel), 'S', OrePrefixes.screw.get(Materials.Steel), 'P', OrePrefixes.plate.get(Materials.Iron), 'R', OrePrefixes.ring.get(Materials.Iron)});
        // --- Redstone Clock
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("ExtraUtilities", "timer", 1L), tBitMask, new Object[]{"PGP", "GCG", "PGP", 'G', OrePrefixes.gearGt.get(Materials.Wood), 'C', GT_ModHandler.getModItem("minecraft", "clock", 1L), 'P', OrePrefixes.plate.get(Materials.RedAlloy)});
        // --- Angel Block
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("ExtraUtilities", "angelBlock", 1L), tBitMask, new Object[]{"FPF", "FOF", "FPF", 'O', OrePrefixes.stone.get(Materials.Obsidian), 'F', GT_ModHandler.getModItem("minecraft", "feather", 1L), 'P', OrePrefixes.plate.get(Materials.Gold)});
        // --- Golden Bag
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("ExtraUtilities", "golden_bag", 1L), tBitMask, new Object[]{"FDF", "PBP", "hPf", 'F', OrePrefixes.foil.get(Materials.Gold), 'D', OrePrefixes.gemExquisite.get(Materials.Diamond), 'B', GT_ModHandler.getModItem("Backpack", "backpack", 1L), 'P', OrePrefixes.plate.get(Materials.Gold)});
        // --- Drum
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("ExtraUtilities", "drum", 1L), tBitMask, new Object[]{"PRP", "PCP", "PRP", 'R', OrePrefixes.ring.get(Materials.Steel), 'C', ItemList.Casing_Tank_0.get(1), 'P', OrePrefixes.plateDouble.get(Materials.Steel)});

    }

    private void printer3d() {
        //Ender Quarry
        RA.addBasicLineRecipe(new ItemStack[]{
                GT_ItemList.AdvancedMiner.get(1L), ItemList.Field_Generator_LuV.get(1L),
                ItemList.Electric_Motor_LuV.get(3L),
                GT_ModHandler.getModItem("ExtraUtilities", "enderThermicPump", 1, 0),
                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Master, 4),
                GT_OreDictUnificator.get(OrePrefixes.stickLong, Materials.HastelloyN, 8),
                GT_OreDictUnificator.get(OrePrefixes.gearGt, Materials.HastelloyC276, 8),
                GT_ModHandler.getModItem("ExtraUtilities", "enderQuarryUpgrade", 8, 0)
        }, GT_ModHandler.getModItem("ExtraUtilities", "enderQuarry", 1, 0), null, 60 * 20, 30720);

        //Marker
        RA.addBasicLineRecipe(new ItemStack[]{
                ItemList.Emitter_LuV.get(1L),
                GT_ModHandler.getModItem("ExtraUtilities", "enderQuarryUpgrade", 4, 0),
                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Master, 4),
                GT_OreDictUnificator.get(OrePrefixes.stickLong, Materials.HastelloyN, 4),
                GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Enderium, 8),
                GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.HastelloyC276, 8)
        }, GT_ModHandler.getModItem("ExtraUtilities", "endMarker", 1, 0), null, 50 * 20, 7680);
    }

    private void alloySmalter() {
        // --- Obsidain Glass
        RA.addAlloySmelterRecipe(
                GT_ModHandler.getModItem("ExtraUtilities", "decorativeBlock2", 1L, 0),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Obsidian, 4L),
                GT_ModHandler.getModItem("ExtraUtilities", "decorativeBlock2", 1L, 5), 200, 6);
        // --- Golden Edge Glass
        RA.addAlloySmelterRecipe(
                GT_ModHandler.getModItem("ExtraUtilities", "decorativeBlock2", 1L, 0),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Gold, 1L),
                GT_ModHandler.getModItem("ExtraUtilities", "decorativeBlock2", 1L, 4), 200, 6);
        // --- Carved Glass
        RA.addAlloySmelterRecipe(
                GT_ModHandler.getModItem("ExtraUtilities", "decorativeBlock2", 1L, 0),
                GT_ModHandler.getModItem("minecraft", "gunpowder", 1L, 0),
                GT_ModHandler.getModItem("ExtraUtilities", "decorativeBlock2", 1L, 3), 200, 6);
        // --- Glowstone Glass
        RA.addAlloySmelterRecipe(
                GT_ModHandler.getModItem("ExtraUtilities", "decorativeBlock2", 1L, 0),
                GT_ModHandler.getModItem("gregtech", "gt.metaitem.01", 1L, 17811),
                GT_ModHandler.getModItem("ExtraUtilities", "decorativeBlock2", 1L, 7), 400, 12);
        // --- Heart Glass
        RA.addAlloySmelterRecipe(
                GT_ModHandler.getModItem("ExtraUtilities", "decorativeBlock2", 1L, 0),
                GT_ModHandler.getModItem("minecraft", "dye", 1L, 9),
                GT_ModHandler.getModItem("ExtraUtilities", "decorativeBlock2", 1L, 8), 200, 6);
        // --- Thickened Glass (Alternative)
        RA.addAlloySmelterRecipe(
                GT_ModHandler.getModItem("minecraft", "sand", 1L, 0),
                GT_ModHandler.getModItem("minecraft", "glass", 1L, 0),
                GT_ModHandler.getModItem("ExtraUtilities", "decorativeBlock2", 2L, 0), 200, 6);

    }

    private void assembler() {
        // --- Quarry Upgrade
        RA.addAssemblerRecipe(new ItemStack[]{ItemList.Casing_Gearbox_TungstenSteel2.get(1),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Talonite, 4L),
                        GT_OreDictUnificator.get(OrePrefixes.gear, Materials.Stellite, 4L),
                        GT_OreDictUnificator.get(OrePrefixes.stickLong, Materials.Talonite, 8L),
                        GT_OreDictUnificator.get(OrePrefixes.screw, Materials.Stellite, 32L)}, null,
                GT_ModHandler.getModItem("ExtraUtilities", "enderQuarryUpgrade", 1L, 0), 600, 1920);
        // --- Hole Upgrade
        GT_Values.RA
                .addAssemblerRecipe(GT_ModHandler.getModItem("ExtraUtilities", "enderQuarryUpgrade", 1L, 0),
                        GT_OreDictUnificator.get(OrePrefixes.toolHeadDrill, Materials.Titanium, 2L), null,
                        GT_ModHandler.getModItem("ExtraUtilities", "enderQuarryUpgrade", 1L, 1), 800, 7680);
        // --- Silk Upgrade
        GT_Values.RA
                .addAssemblerRecipe(GT_ModHandler.getModItem("ExtraUtilities", "enderQuarryUpgrade", 1L, 0),
                        GT_OreDictUnificator.get(OrePrefixes.toolHeadDrill, Materials.Enderium, 2L), null,
                        GT_ModHandler.getModItem("ExtraUtilities", "enderQuarryUpgrade", 1L, 2), 800, 30720);
        // --- Fortune 1 Upgrade
        GT_Values.RA
                .addAssemblerRecipe(GT_ModHandler.getModItem("ExtraUtilities", "enderQuarryUpgrade", 1L, 0),
                        GT_OreDictUnificator.get(OrePrefixes.toolHeadDrill, Materials.Iridium, 2L), null,
                        GT_ModHandler.getModItem("ExtraUtilities", "enderQuarryUpgrade", 1L, 3), 800, 7680);
        // --- Fortune 2 Upgrade
        GT_Values.RA
                .addAssemblerRecipe(GT_ModHandler.getModItem("ExtraUtilities", "enderQuarryUpgrade", 1L, 3),
                        GT_OreDictUnificator.get(OrePrefixes.toolHeadDrill, Materials.Trinium, 2L), null,
                        GT_ModHandler.getModItem("ExtraUtilities", "enderQuarryUpgrade", 1L, 4), 1000, 30720);
        // --- Fortune 3 Upgrade
        GT_Values.RA
                .addAssemblerRecipe(GT_ModHandler.getModItem("ExtraUtilities", "enderQuarryUpgrade", 1L, 4),
                        GT_OreDictUnificator.get(OrePrefixes.toolHeadDrill, Materials.Tritanium, 2L), null,
                        GT_ModHandler.getModItem("ExtraUtilities", "enderQuarryUpgrade", 1L, 5), 1200, 122880);
        // --- Speed 1 Upgrade
        GT_Values.RA
                .addAssemblerRecipe(GT_ModHandler.getModItem("ExtraUtilities", "enderQuarryUpgrade", 1L, 0),
                        GT_OreDictUnificator.get(OrePrefixes.gear, Materials.HSSG, 2L), null,
                        GT_ModHandler.getModItem("ExtraUtilities", "enderQuarryUpgrade", 1L, 6), 800, 7680);
        // --- Speed 2 Upgrade
        GT_Values.RA
                .addAssemblerRecipe(GT_ModHandler.getModItem("ExtraUtilities", "enderQuarryUpgrade", 1L, 6),
                        GT_OreDictUnificator.get(OrePrefixes.gear, Materials.HSSE, 2L), null,
                        GT_ModHandler.getModItem("ExtraUtilities", "enderQuarryUpgrade", 1L, 7), 1000, 30720);
        // --- Speed 3 Upgrade
        GT_Values.RA
                .addAssemblerRecipe(GT_ModHandler.getModItem("ExtraUtilities", "enderQuarryUpgrade", 1L, 7),
                        GT_OreDictUnificator.get(OrePrefixes.gear, Materials.HSSS, 2L), null,
                        GT_ModHandler.getModItem("ExtraUtilities", "enderQuarryUpgrade", 1L, 8), 1200, 122880);
        // --- Pump Upgrade
        GT_Values.RA
                .addAssemblerRecipe(GT_ModHandler.getModItem("ExtraUtilities", "enderQuarryUpgrade", 1L, 0),
                        ItemList.Electric_Pump_IV.get(1L), null,
                        GT_ModHandler.getModItem("ExtraUtilities", "enderQuarryUpgrade", 1L, 9), 1000, 30720);
        // --- Thermionic Pump
        RA.addAssemblerRecipe(new ItemStack[]{ItemList.Pump_IV.get(1),
                        GT_ModHandler.getModItem("ExtraUtilities", "enderQuarryUpgrade", 4L, 0),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Talonite, 4L),
                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Elite, 4L),
                        GT_OreDictUnificator.get(OrePrefixes.gear, Materials.GumMetal, 2L),
                        GT_OreDictUnificator.get(OrePrefixes.stickLong, Materials.Inconel690, 8L),
                        GT_OreDictUnificator.get(OrePrefixes.screw, Materials.BT6, 32L)}, null,
                GT_ModHandler.getModItem("ExtraUtilities", "enderThermicPump", 1L, 0), 1000, 7680);
        // --- Slightly Larger Chest
        RA.addAssemblerRecipe(GT_ModHandler.getModItem("minecraft", "chest", 1L, 0),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Wood, 2L), null,
                GT_ModHandler.getModItem("ExtraUtilities", "chestFull", 1L, 0), 100, 30);
        // --- Trash Can
        GT_Values.RA
                .addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.round, Materials.Rubber, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Iron, 10L), null,
                        GT_ModHandler.getModItem("ExtraUtilities", "trashcan", 1L, 0), 400, 30);
        RA.addAssemblerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.round, Materials.StyreneButadieneRubber, 1L),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Iron, 10L), null,
                GT_ModHandler.getModItem("ExtraUtilities", "trashcan", 1L, 0), 400, 30);
        GT_Values.RA
                .addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.round, Materials.Silicone, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Iron, 10L), null,
                        GT_ModHandler.getModItem("ExtraUtilities", "trashcan", 1L, 0), 400, 30);
        // --- Block Update Detector
        GT_Values.RA
                .addAssemblerRecipe(GT_ModHandler.getModItem("gregtech", "gt.metaitem.01", 1L, 32731),
                        GT_ModHandler.getModItem("minecraft", "sticky_piston", 1L, 0), null,
                        GT_ModHandler.getModItem("ExtraUtilities", "budoff", 1L, 0), 200, 30);
        // --- Block Update Detector (Advanced)
        RA.addAssemblerRecipe(GT_ModHandler.getModItem("ExtraUtilities", "budoff", 1L, 0),
                GT_ModHandler.getModItem("minecraft", "redstone_block", 4L, 0), null,
                GT_ModHandler.getModItem("ExtraUtilities", "budoff", 1L, 3), 200, 120);
        // --- Etched Glass
        GT_Values.RA
                .addAssemblerRecipe(GT_ModHandler.getModItem("ExtraUtilities", "decorativeBlock2", 1L, 0),
                        GT_Utility.getIntegratedCircuit(1), null,
                        GT_ModHandler.getModItem("ExtraUtilities", "decorativeBlock2", 1L, 1), 100, 8);
        // --- Glass Bricks
        GT_Values.RA
                .addAssemblerRecipe(GT_ModHandler.getModItem("ExtraUtilities", "decorativeBlock2", 1L, 0),
                        GT_Utility.getIntegratedCircuit(4), null,
                        GT_ModHandler.getModItem("ExtraUtilities", "decorativeBlock2", 1L, 2), 100, 8);
        // --- Swirling Glass
        GT_Values.RA
                .addAssemblerRecipe(GT_ModHandler.getModItem("ExtraUtilities", "decorativeBlock2", 1L, 0),
                        GT_Utility.getIntegratedCircuit(5), null,
                        GT_ModHandler.getModItem("ExtraUtilities", "decorativeBlock2", 1L, 6), 100, 8);
        // --- Squared Glass
        GT_Values.RA
                .addAssemblerRecipe(GT_ModHandler.getModItem("ExtraUtilities", "decorativeBlock2", 1L, 0),
                        GT_Utility.getIntegratedCircuit(2), null,
                        GT_ModHandler.getModItem("ExtraUtilities", "decorativeBlock2", 1L, 9), 100, 8);
        // --- Dark Glass
        GT_Values.RA
                .addAssemblerRecipe(GT_ModHandler.getModItem("ExtraUtilities", "decorativeBlock2", 1L, 0),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.DarkAsh, 2L), null,
                        GT_ModHandler.getModItem("ExtraUtilities", "decorativeBlock2", 1L, 10), 100, 8);
        // --- Reinforced Dark Glass
        GT_Values.RA
                .addAssemblerRecipe(GT_ModHandler.getModItem("ExtraUtilities", "decorativeBlock2", 1L, 10),
                        GT_ModHandler.getModItem("gregtech", "gt.metaitem.01", 4L, 2804), null,
                        GT_ModHandler.getModItem("ExtraUtilities", "decorativeBlock2", 1L, 11), 400, 30);
        // --- Sandy Glass
        RA.addAssemblerRecipe(GT_ModHandler.getModItem("minecraft", "sand", 1L, 0),
                GT_ModHandler.getModItem("minecraft", "glass", 1L, 0), null,
                GT_ModHandler.getModItem("ExtraUtilities", "decorativeBlock1", 2L, 9), 40, 4);
        // --- Edged Stone Bricks
        RA.addAssemblerRecipe(GT_ModHandler.getModItem("minecraft", "stone", 4L, 0),
                GT_ModHandler.getModItem("minecraft", "stonebrick", 5L, 0), null,
                GT_ModHandler.getModItem("ExtraUtilities", "decorativeBlock1", 9L, 0), 180, 4);
        // --- Border Stone
        GT_Values.RA
                .addAssemblerRecipe(GT_ModHandler.getModItem("ExtraUtilities", "decorativeBlock1", 1L, 0),
                        GT_Utility.getIntegratedCircuit(4), null,
                        GT_ModHandler.getModItem("ExtraUtilities", "decorativeBlock1", 1L, 4), 20, 4);
        // --- Border Stone (Alternate)
        GT_Values.RA
                .addAssemblerRecipe(GT_ModHandler.getModItem("ExtraUtilities", "decorativeBlock1", 1L, 4),
                        GT_Utility.getIntegratedCircuit(4), null,
                        GT_ModHandler.getModItem("ExtraUtilities", "decorativeBlock1", 1L, 7), 20, 4);
        // --- Gravel Bricks
        RA.addAssemblerRecipe(GT_ModHandler.getModItem("minecraft", "gravel", 1L, 0),
                GT_Utility.getIntegratedCircuit(2), null,
                GT_ModHandler.getModItem("ExtraUtilities", "decorativeBlock1", 1L, 6), 20, 4);
        // --- Frosted Stone
        RA.addAssemblerRecipe(GT_ModHandler.getModItem("minecraft", "stone", 1L, 0),
                GT_ModHandler.getModItem("minecraft", "ice", 4L, 0), null,
                GT_ModHandler.getModItem("ExtraUtilities", "decorativeBlock1", 4L, 3), 80, 4);
        // --- Gravel Road
        GT_Values.RA
                .addAssemblerRecipe(GT_ModHandler.getModItem("ExtraUtilities", "decorativeBlock1", 5L, 6),
                        GT_ModHandler.getModItem("minecraft", "stone_slab", 5L, 5), null,
                        GT_ModHandler.getModItem("ExtraUtilities", "decorativeBlock1", 5L, 10), 100, 4);
        // --- Ender-Sand Alloy
        RA.addAssemblerRecipe(GT_ModHandler.getModItem("minecraft", "sandstone", 1L, 0),
                GT_ModHandler.getModItem("minecraft", "end_stone", 1L, 1), null,
                GT_ModHandler.getModItem("ExtraUtilities", "decorativeBlock1", 2L, 13), 40, 4);
        // --- Ineffable Glass
        GT_Values.RA
                .addAssemblerRecipe(GT_ModHandler.getModItem("ExtraUtilities", "etherealglass", 1L, 0),
                        GT_Utility.getIntegratedCircuit(2), null,
                        GT_ModHandler.getModItem("ExtraUtilities", "etherealglass", 1L, 1), 100, 8);
        // --- Ethereal Glass (Inverted)
        GT_Values.RA
                .addAssemblerRecipe(GT_ModHandler.getModItem("ExtraUtilities", "etherealglass", 1L, 0),
                        GT_Utility.getIntegratedCircuit(1), null,
                        GT_ModHandler.getModItem("ExtraUtilities", "etherealglass", 1L, 3), 100, 8);
        // --- Ineffable Glass (Inverted)
        GT_Values.RA
                .addAssemblerRecipe(GT_ModHandler.getModItem("ExtraUtilities", "etherealglass", 1L, 1),
                        GT_Utility.getIntegratedCircuit(1), null,
                        GT_ModHandler.getModItem("ExtraUtilities", "etherealglass", 1L, 4), 100, 8);
        // --- Dark Ethereal Glass
        GT_Values.RA
                .addAssemblerRecipe(GT_ModHandler.getModItem("ExtraUtilities", "etherealglass", 1L, 1),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.DarkAsh, 2L), null,
                        GT_ModHandler.getModItem("ExtraUtilities", "etherealglass", 1L, 2), 200, 16);
        // --- Dark Ethereal Glass (Inverted)
        GT_Values.RA
                .addAssemblerRecipe(GT_ModHandler.getModItem("ExtraUtilities", "etherealglass", 1L, 2),
                        GT_Utility.getIntegratedCircuit(1), null,
                        GT_ModHandler.getModItem("ExtraUtilities", "etherealglass", 1L, 5), 100, 8);

    }

    private void chemical() {
        // --- Ethereal Glass
        GT_Values.RA
                .addChemicalRecipe(GT_ModHandler.getModItem("ExtraUtilities", "decorativeBlock2", 1L, 0),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.EnderPearl, 1L), null, null,
                        GT_ModHandler.getModItem("ExtraUtilities", "etherealglass", 1L, 0), 100);
        GT_Values.RA
                .addChemicalRecipe(GT_ModHandler.getModItem("ExtraUtilities", "decorativeBlock2", 1L, 0),
                        GT_OreDictUnificator.get(OrePrefixes.gem, Materials.EnderPearl, 1L), null, null,
                        GT_ModHandler.getModItem("ExtraUtilities", "etherealglass", 1L, 0), 100);

    }

}
