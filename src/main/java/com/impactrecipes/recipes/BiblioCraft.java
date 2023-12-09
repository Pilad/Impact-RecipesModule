package com.impactrecipes.recipes;

import gregtech.api.enums.*;
import gregtech.api.util.GT_ModHandler;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

import static gregtech.api.enums.GT_Values.RA;
import static gregtech.api.util.GT_ModHandler.removeRecipeByOutput;

public class BiblioCraft implements Runnable {

    private static final long tBitMask = GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE;

    @Override
    public void run() {
        removeBiblio();
        hand();
        cuttingSaw();
    }

    private void removeBiblio() {
        removeRecipeByOutput(GT_ModHandler.getModItem("BiblioCraft", "Printing Press", 1L, 0), true,
                false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("BiblioCraft", "item.BiblioChase", 1L, 0), true,
                false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("BiblioCraft", "Typesetting Machine", 1L, 0),
                true, false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("BiblioCraft", "tile.BiblioframeGtdChest", 1L, 0),
                true, false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("BiblioCraft", "BiblioPaintPress", 1L, 0), true,
                false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("BiblioCraft", "BiblioLantern", 1L, 0), true,
                false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("BiblioCraft", "BiblioIronLantern", 1L, 0), true,
                false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("BiblioCraft", "BiblioLamp", 1L, 0), true, false,
                true);
        removeRecipeByOutput(GT_ModHandler.getModItem("BiblioCraft", "BiblioIronLamp", 1L, 0), true,
                false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("BiblioCraft", "Armor Stand", 1L, 0), true, false,
                true);
        removeRecipeByOutput(GT_ModHandler.getModItem("BiblioCraft", "BiblioBell", 1L, 0), true, false,
                true);
        removeRecipeByOutput(GT_ModHandler.getModItem("BiblioCraft", "BiblioStuffs", 1L, 0), true,
                false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("BiblioCraft", "BiblioStuffs", 1L, 2), true,
                false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("BiblioCraft", "item.FramingSaw", 1L, 0), true,
                false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("BiblioCraft", "item.FramingSheet", 1L, 0), true,
                false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("BiblioCraft", "item.FramingBoard", 1L, 0), true,
                false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("BiblioCraft", "item.BiblioMapTool", 1L, 0), true,
                false, true);
        removeRecipeByOutput(
                GT_ModHandler.getModItem("BiblioCraft", "item.BiblioWayPointCompass", 1L, 0), true, false,
                true);
        removeRecipeByOutput(GT_ModHandler.getModItem("BiblioCraft", "item.BiblioGlasses", 1L, 0), true,
                false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("BiblioCraft", "item.BiblioGlasses", 1L, 2), true,
                false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("BiblioCraft", "item.PlumbLine", 1L, 0), true,
                false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("BiblioCraft", "item.HandDrill", 1L, 0), true,
                false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("BiblioCraft", "item.BiblioDrill", 1L, 0), true,
                false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("BiblioCraft", "item.tape", 1L, 0), true, false,
                true);
        removeRecipeByOutput(GT_ModHandler.getModItem("BiblioCraft", "item.tapeMeasure", 1L, 0), true,
                false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("BiblioCraft", "item.BiblioClipboard", 1L, 0),
                true, false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("BiblioCraft", "item.SlottedBook", 1L, 0), true,
                false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("BiblioCraft", "item.AtlasBook", 1L, 0), true,
                false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("BiblioCraft", "BiblioClock", 1L, GT_Values.W),
                true, false, true);
    }

    private void hand() {
        // --- ItemStack Name Tester (Book)
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("BiblioCraft", "item.TesterItem", 1L, 0), tBitMask, new Object[]{"sD ", "Sh ", 'S', new ItemStack(Items.book, 1, 0), 'D', new ItemStack(Items.diamond, 1, 0)});
        // --- Print Press Case
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("BiblioCraft", "item.BiblioChase", 1L, 0), tBitMask, new Object[]{"SSS", "S S", "SSS", 'S', OrePrefixes.stick.get(Materials.WoodSealed)});
        // --- Typesetting Table
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("BiblioCraft", "Typesetting Machine", 1L, 0), tBitMask, new Object[]{"PCP", "WFW", "WWW", 'W', OrePrefixes.plate.get(Materials.WoodSealed), 'F', OrePrefixes.frameGt.get(Materials.WoodSealed), 'P', OrePrefixes.plate.get(Materials.Aluminium), 'C', GT_ModHandler.getModItem("BiblioCraft", "item.BiblioChase", 1L, 0)});
        // --- Framed Chest
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("BiblioCraft", "tile.BiblioframeGtdChest", 1L, 0), tBitMask, new Object[]{"FFF", "SLS", "FFF", 'F', GT_ModHandler.getModItem("BiblioCraft", "item.FramingSheet", 1L, 0), 'S', OrePrefixes.screw.get(Materials.Iron), 'L', GT_ModHandler.getModItem("BiblioCraft", "BiblioLabel", 1L, 6)});
        // --- Oak Furniture Paneler
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("BiblioCraft", "BiblioPaneler", 1L, 0), tBitMask, new Object[]{"PsP", "WGW", "LLL", 'G', GT_ModHandler.getModItem("gregtech", "gt.metaitem.02", 1L, 32470), 'P', OrePrefixes.plate.get(Materials.Iron), 'W', GT_ModHandler.getModItem("minecraft", "wooden_slab", 1L, 0),  'L', GT_ModHandler.getModItem("minecraft", "planks", 1L, 0)});
        // --- Spruce Furniture Paneler
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("BiblioCraft", "BiblioPaneler", 1L, 1), tBitMask, new Object[]{"PsP", "WGW", "LLL", 'G', GT_ModHandler.getModItem("gregtech", "gt.metaitem.02", 1L, 32471), 'P', OrePrefixes.plate.get(Materials.Iron), 'W', GT_ModHandler.getModItem("minecraft", "wooden_slab", 1L, 1),  'L', GT_ModHandler.getModItem("minecraft", "planks", 1L, 1)});
        // --- Birce Furniture Paneler
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("BiblioCraft", "BiblioPaneler", 1L, 2), tBitMask, new Object[]{"PsP", "WGW", "LLL", 'G', GT_ModHandler.getModItem("gregtech", "gt.metaitem.02", 1L, 32472), 'P', OrePrefixes.plate.get(Materials.Iron), 'W', GT_ModHandler.getModItem("minecraft", "wooden_slab", 1L, 2),  'L', GT_ModHandler.getModItem("minecraft", "planks", 1L, 2)});
        // --- Jungle Furniture Paneler
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("BiblioCraft", "BiblioPaneler", 1L, 3), tBitMask, new Object[]{"PsP", "WGW", "LLL", 'G', GT_ModHandler.getModItem("gregtech", "gt.metaitem.02", 1L, 32473), 'P', OrePrefixes.plate.get(Materials.Iron), 'W', GT_ModHandler.getModItem("minecraft", "wooden_slab", 1L, 3),  'L', GT_ModHandler.getModItem("minecraft", "planks", 1L, 3)});
        // --- Arcacia Furniture Paneler
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("BiblioCraft", "BiblioPaneler", 1L, 4), tBitMask, new Object[]{"PsP", "WGW", "LLL", 'G', GT_ModHandler.getModItem("gregtech", "gt.metaitem.02", 1L, 32474), 'P', OrePrefixes.plate.get(Materials.Iron), 'W', GT_ModHandler.getModItem("minecraft", "wooden_slab", 1L, 4),  'L', GT_ModHandler.getModItem("minecraft", "planks", 1L, 4)});
        // --- Dark Oak Furniture Paneler
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("BiblioCraft", "BiblioPaneler", 1L, 5), tBitMask, new Object[]{"PsP", "WGW", "LLL", 'G', GT_ModHandler.getModItem("gregtech", "gt.metaitem.02", 1L, 32475), 'P', OrePrefixes.plate.get(Materials.Iron), 'W', GT_ModHandler.getModItem("minecraft", "wooden_slab", 1L, 5),  'L', GT_ModHandler.getModItem("minecraft", "planks", 1L, 5)});
        // --- Framed Furniture Paneler
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("BiblioCraft", "BiblioPaneler", 1L, 6), tBitMask, new Object[]{"PsP", "WLW", "LLL", 'P', OrePrefixes.plate.get(Materials.Iron), 'W', GT_ModHandler.getModItem("BiblioCraft", "item.FramingBoard", 1L, 0),  'L', GT_ModHandler.getModItem("BiblioCraft", "FramingSheet", 1L, 0)});
        // --- Atlas
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("BiblioCraft", "item.AtlasBook", 1L, 0), tBitMask, new Object[]{"PTP", "PBP", "PMP", 'P', OrePrefixes.plate.get(Materials.Paper), 'B', OreDictNames.craftingBook, 'M', "paperMap", 'T', GT_ModHandler.getModItem("BiblioCraft", "item.BiblioMapTool", 1L, 0)});
        // --- Painting Press
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("BiblioCraft", "item.BiblioPaintPress", 1L, 0), tBitMask, new Object[]{"PPB", "R  ", "BIB", 'P', OrePrefixes.plate.get(Materials.Iron), 'B', OrePrefixes.bolt.get(Materials.Iron), 'R', OrePrefixes.ring.get(Materials.Iron), 'I', OrePrefixes.block.get(Materials.Iron)});
        // --- Fancy Gold Latern
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("BiblioCraft", "BiblioLantern", 1L, 0), tBitMask, new Object[]{"PDP", "GTG", "PPP", 'P', OrePrefixes.plate.get(Materials.Gold), 'D', OrePrefixes.dust.get(Materials.Glowstone), 'G', new ItemStack(Blocks.glass_pane), 'T', GT_ModHandler.getModItem("minecraft", "torch", 1L, 0)});
        // --- Fancy Iron Latern
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("BiblioCraft", "BiblioIronLantern", 1L, 0), tBitMask, new Object[]{"PDP", "GTG", "PPP", 'P', OrePrefixes.plate.get(Materials.Iron), 'D', OrePrefixes.dust.get(Materials.Glowstone), 'G', new ItemStack(Blocks.glass_pane), 'T', GT_ModHandler.getModItem("minecraft", "torch", 1L, 0)});
        // --- Fancy Gold Lamp
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("BiblioCraft", "BiblioLamp", 1L, 0), tBitMask, new Object[]{"PBP", " S ", "PPP", 'P', OrePrefixes.plate.get(Materials.Gold), 'S', OrePrefixes.stick.get(Materials.Gold), 'B', GT_ModHandler.getModItem("GregsLighting", "glowstoneBulb", 1L, 0)});
        // --- Fancy Iron Lamp
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("BiblioCraft", "BiblioIronLamp", 1L, 0), tBitMask, new Object[]{"PBP", " S ", "PPP", 'P', OrePrefixes.plate.get(Materials.Iron), 'S', OrePrefixes.stick.get(Materials.Iron), 'B', GT_ModHandler.getModItem("GregsLighting", "glowstoneBulb", 1L, 0)});
        // --- Armor Stand
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("BiblioCraft", "Armor Stand", 1L, 0), tBitMask, new Object[]{"BSB", "hSs", "PMP", 'P', OrePrefixes.plate.get(Materials.Iron), 'S', OrePrefixes.stick.get(Materials.Iron), 'B', OrePrefixes.bolt.get(Materials.Iron), 'M', GT_ModHandler.getModItem("minecraft", "stone_pressure_plate", 1L, 0)});
        // --- Desk Bell
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("BiblioCraft", "BiblioBell", 1L, 0), tBitMask, new Object[]{" B ", " P ", "PhP", 'P', OrePrefixes.plate.get(Materials.Iron), 'B', GT_ModHandler.getModItem("minecraft", "stone_button", 1L, 0)});
        // --- Cookie Jar
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("BiblioCraft", "BiblioStuffs", 1L, 0), tBitMask, new Object[]{" P ", "G G", "GGG", 'P', OrePrefixes.plate.get(Materials.Rubber), 'G', GT_ModHandler.getModItem("minecraft", "glass_pane", 1L, 0)});
        // --- Diner Plate
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("BiblioCraft", "BiblioStuffs", 1L, 2), tBitMask, new Object[]{"P P", " P ", 'P', OrePrefixes.plate.get(Materials.NetherQuartz)});
        // --- Clock
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("BiblioCraft", "BiblioClock", 1L, 6), tBitMask, new Object[]{"SCS", "SIS","SPS", 'S', GT_ModHandler.getModItem("BiblioCraft", "item.FramingSheet", 1L, 0), 'C', new ItemStack(Items.clock), 'I', new ItemStack(Items.stick), 'P', OrePrefixes.plate.get(Materials.Gold)});
        for (int i = 0; i < 6; i++) {
            // --- Frame Sheet
            GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("BiblioCraft", "item.FramingSheet", 2L, 0), tBitMask, new Object[]{"Gs", 'G', new ItemStack(Blocks.planks, 1, i)});
            // --- Clock
            GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("BiblioCraft", "BiblioClock", 1L, i), tBitMask, new Object[]{"SCS", "SIS","SPS", 'S', new ItemStack(Blocks.wooden_slab, 1, i), 'C', new ItemStack(Items.clock), 'I', new ItemStack(Items.stick), 'P', OrePrefixes.plate.get(Materials.Gold)});
        }
        // --- Frame Board
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("BiblioCraft", "item.FramingBoard", 2L, 0), tBitMask, new Object[]{"Gs", 'G', GT_ModHandler.getModItem("BiblioCraft", "item.FramingSheet", 1L, 0)});
        // --- Drafting Compass
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("BiblioCraft", "item.BiblioMapTool", 1L, 0), tBitMask, new Object[]{"IWI", "IIf", "IWd", 'I', OrePrefixes.stick.get(Materials.Iron), 'W', OrePrefixes.screw.get(Materials.Iron)});
        // --- Waypoint Compass
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("BiblioCraft", "item.BiblioWayPointCompass", 1L, 0), tBitMask, new Object[]{"IRf", "WCW", "dRI", 'I', OrePrefixes.stick.get(Materials.Gold), 'W', OrePrefixes.screw.get(Materials.Gold), 'R', OrePrefixes.ring.get(Materials.Gold), 'C', GT_ModHandler.getModItem("minecraft", "compass", 1L, 0)});
        // --- Monocle
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("BiblioCraft", "item.BiblioGlasses", 1L, 0), tBitMask, new Object[]{"IWI", "RBR", "LdL", 'I', OrePrefixes.stick.get(Materials.Iron), 'W', OrePrefixes.screw.get(Materials.Iron), 'B', OrePrefixes.bolt.get(Materials.Iron), 'R', OrePrefixes.ring.get(Materials.Iron), 'L', OrePrefixes.lens.get(Materials.Glass)});
        // --- Reading Glasses
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("BiblioCraft", "item.BiblioGlasses", 1L, 2), tBitMask, new Object[]{"RWW", "LrW", " W ", 'W', OrePrefixes.wireFine.get(Materials.Gold), 'R', OrePrefixes.ring.get(Materials.Gold), 'L', OrePrefixes.lens.get(Materials.Glass)});
        // --- Plum Line
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("BiblioCraft", "item.PlumbLine", 1L, 0), tBitMask, new Object[]{"WWW", "PrW", "R W", 'W', OrePrefixes.wireFine.get(Materials.Steel), 'R', OrePrefixes.round.get(Materials.Lead), 'P', OrePrefixes.plate.get(Materials.Lead)});
        // --- Screw Gun
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("BiblioCraft", "item.BiblioDrill", 1L, 0), tBitMask, new Object[]{"IBd", "GRG", "PEP", 'I', OrePrefixes.screw.get(Materials.Iron), 'B', OrePrefixes.bolt.get(Materials.Iron), 'P', OrePrefixes.plate.get(Materials.Iron), 'G', OrePrefixes.gearGtSmall.get(Materials.Iron), 'R', GT_ModHandler.getModItem("IC2", "itemRecipePart", 1L, 3), 'E', GT_ModHandler.getModItem("IC2", "itemBatREDischarged", 1L, 0)});
        // --- Tape Measure Real
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("BiblioCraft", "item.tape", 1L, 0), tBitMask, new Object[]{"WWW", "WYW", "WWW", 'W', OrePrefixes.wireFine.get(Materials.Iron), 'B', "dyeYellow"});
        // --- Tape Maesure
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("BiblioCraft", "item.tapeMeasure", 1L, 0), tBitMask, new Object[]{"TTT", "SSS", 'T', GT_ModHandler.getModItem("BiblioCraft", "item.tape", 1L, 0), 'S', OrePrefixes.stick.get(Materials.Iron)});
        // --- Clipboard
        for (int i = 0; i < 6; i++) {
            GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("BiblioCraft", "item.BiblioClipboard", 1L, 0), tBitMask, new Object[]{"ERE", "dGs", "PPP", 'E', OrePrefixes.screw.get(Materials.Iron), 'R', OrePrefixes.springSmall.get(Materials.Iron), 'G', GT_ModHandler.getModItem("minecraft", "wooden_slab", 1L, i), 'P', GT_ModHandler.getModItem("minecraft", "paper", 1L, 0)});
        }
    }

    private void cuttingSaw() {
        // --- Frame Sheet
        RA.addCutterRecipe(ItemList.Plank_Oak.get(1L),
                GT_ModHandler.getModItem("BiblioCraft", "item.FramingSheet", 4L, 0), GT_Values.NI, 50, 4);
        RA.addCutterRecipe(ItemList.Plank_Spruce.get(1L),
                GT_ModHandler.getModItem("BiblioCraft", "item.FramingSheet", 4L, 0), GT_Values.NI, 50, 4);
        RA.addCutterRecipe(ItemList.Plank_Birch.get(1L),
                GT_ModHandler.getModItem("BiblioCraft", "item.FramingSheet", 4L, 0), GT_Values.NI, 50, 4);
        RA.addCutterRecipe(ItemList.Plank_Jungle.get(1L),
                GT_ModHandler.getModItem("BiblioCraft", "item.FramingSheet", 4L, 0), GT_Values.NI, 50, 4);
        RA.addCutterRecipe(ItemList.Plank_Acacia.get(1L),
                GT_ModHandler.getModItem("BiblioCraft", "item.FramingSheet", 4L, 0), GT_Values.NI, 50, 4);
        RA.addCutterRecipe(ItemList.Plank_DarkOak.get(1L),
                GT_ModHandler.getModItem("BiblioCraft", "item.FramingSheet", 4L, 0), GT_Values.NI, 50, 4);
        // --- Frame Board
        GT_Values.RA
                .addCutterRecipe(GT_ModHandler.getModItem("BiblioCraft", "item.FramingSheet", 1L, 0),
                        GT_ModHandler.getModItem("BiblioCraft", "item.FramingBoard", 4L, 0), GT_Values.NI, 50, 4);
    }
}
