package com.impactrecipes.recipes;

import gregtech.api.GregTech_API;
import gregtech.api.enums.GT_Values;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.util.GT_ModHandler;
import gregtech.api.util.GT_OreDictUnificator;
import gregtech.api.util.GT_Utility;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

import static gregtech.api.enums.GT_Values.RA;
import static gregtech.api.util.GT_ModHandler.removeRecipeByOutput;

public class Ztones implements Runnable {

    private static final long tBitMask = GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE;

    @Override
    public void run() {
        removeZtones();
        hand();
        forgeHammer();
        assembler();
        cutting();
    }

    private void removeZtones() {
        removeRecipeByOutput(GT_ModHandler.getModItem("Ztones", "stoneTile", 1L, 0), true, false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("Ztones", "cleanDirt", 1L, 0), true, false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("Ztones", "booster", 1L, 0), true, false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("Ztones", "lampf", 1L, 0), true, false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("Ztones", "lampt", 1L, 0), true, false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("Ztones", "lampb", 1L, 0), true, false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("Ztones", "auroraBlock", 1L, 0), true, false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("Ztones", "minicharcoal", 1L, 0), true, false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("Ztones", "minicoal", 1L, 0), true, false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("Ztones", "ofanix", 1L, 0), true, false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("Ztones", "diamondZane", 1L, 0), true, false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("Ztones", "splatAxe", 1L, 0), true, false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("Ztones", "terrainEater", 1L, 0), true, false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("Ztones", "tile.korpBlock", 1L, 0), true, false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("Ztones", "tile.tankBlock", 1L, 0), true, false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("Ztones", "tile.solsBlock", 1L, 0), true, false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("Ztones", "tile.ztylBlock", 1L, 0), true, false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("Ztones", "tile.vectBlock", 1L, 0), true, false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("Ztones", "tile.jeltBlock", 1L, 0), true, false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("Ztones", "tile.reedBlock", 1L, 0), true, false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("Ztones", "tile.venaBlock", 1L, 0), true, false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("Ztones", "tile.krypBlock", 1L, 0), true, false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("Ztones", "tile.mintBlock", 1L, 0), true, false, true);

    }

    private void hand() {
        // --- Ztones Tile
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("Ztones", "stoneTile", 8L, 0), tBitMask, new Object[]{"LLL", "LSL", "LLL", 'L', GT_ModHandler.getModItem("minecraft", "stone_slab", 1L, 0), 'S', GT_ModHandler.getModItem("minecraft", "stone", 1L, 0)});
        // --- Mine Charcoal
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("Ztones", "minicharcoal", 7L, 0), tBitMask, new Object[]{"h", "C", 'C', "gemCharcoal"});
        // --- Mine Coal
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("Ztones", "minicoal", 7L, 0), tBitMask, new Object[]{"h", "C", 'C', "gemCoal"});
        // --- Aurora Block
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("Ztones", "auroraBlock", 8L, 0), tBitMask, new Object[]{"LLL", "LLL", "LSL", 'L', "blockGlass", 'S', "dye"});
        // --- Korp Block
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("Ztones", "tile.korpBlock", 8L, 0), tBitMask, new Object[]{"LLL", "LSL", "LLL", 'L', GT_ModHandler.getModItem("Ztones", "stoneTile", 1L, 0), 'S', OrePrefixes.plate.get(Materials.Obsidian)});
        // --- Tank Block
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("Ztones", "tile.tankBlock", 8L, 0), tBitMask, new Object[]{"LLL", "LSL", "LLL", 'L', GT_ModHandler.getModItem("Ztones", "stoneTile", 1L, 0), 'S', OrePrefixes.plate.get(Materials.Iron)});
        // --- Sols Block
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("Ztones", "tile.solsBlock", 8L, 0), tBitMask, new Object[]{"LLL", "LSL", "LLL", 'L', GT_ModHandler.getModItem("Ztones", "stoneTile", 1L, 0), 'S', OrePrefixes.plate.get(Materials.Brass)});
        // --- Ztyl Block
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("Ztones", "tile.ztylBlock", 8L, 0), tBitMask, new Object[]{"LLL", "LSL", "LLL", 'L', GT_ModHandler.getModItem("Ztones", "stoneTile", 1L, 0), 'S', OrePrefixes.plate.get(Materials.Steel)});
        // --- Vect Block
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("Ztones", "tile.vectBlock", 8L, 0), tBitMask, new Object[]{"LLL", "LSL", "LLL", 'L', GT_ModHandler.getModItem("Ztones", "stoneTile", 1L, 0), 'S', OrePrefixes.plate.get(Materials.Carbon)});
        // --- Jelt Block
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("Ztones", "tile.jeltBlock", 8L, 0), tBitMask, new Object[]{"LLL", "LSL", "LLL", 'L', GT_ModHandler.getModItem("Ztones", "stoneTile", 1L, 0), 'S', OrePrefixes.plate.get(Materials.Gold)});
        // --- Reed Block
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("Ztones", "tile.reedBlock", 8L, 0), tBitMask, new Object[]{"LLL", "LSL", "LLL", 'L', GT_ModHandler.getModItem("Ztones", "stoneTile", 1L, 0), 'S', OrePrefixes.plate.get(Materials.Wood)});
        // --- Vena Block
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("Ztones", "tile.venaBlock", 8L, 0), tBitMask, new Object[]{"LLL", "LSL", "LLL", 'L', GT_ModHandler.getModItem("Ztones", "stoneTile", 1L, 0), 'S', OrePrefixes.plate.get(Materials.Cobalt)});
        // --- Ofanix
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("Ztones", "ofanix", 1L, 0), tBitMask,
                new Object[]{"hSC", "SGS", "fSs", 'C', new ItemStack(Blocks.crafting_table),
                        'S', OrePrefixes.stick.get(Materials.Iron), 'G', OrePrefixes.gem.get(Materials.Diamond)});
        // --- Kryp Block
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("Ztones", "tile.krypBlock", 8L, 0), tBitMask, new Object[]{"LLL", "LSL", "LLL", 'L', GT_ModHandler.getModItem("Ztones", "stoneTile", 1L, 0), 'S', GT_ModHandler.getModItem("chisel", "concrete", 1L, 0)});
        // --- Mint Block
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("Ztones", "tile.mintBlock", 8L, 0), tBitMask, new Object[]{"LLL", "LSL", "LLL", 'L', GT_ModHandler.getModItem("Ztones", "stoneTile", 1L, 0), 'S', OrePrefixes.plate.get(Materials.Rubber)});


    }

    private void forgeHammer() {
        // --- Mine Charcoal
        RA.addForgeHammerRecipe(GT_ModHandler.getModItem("minecraft", "coal", 1L, 1),
                GT_ModHandler.getModItem("Ztones", "minicharcoal", 9L, 0), 50, 8);
        // --- Mine Charcoal
        RA.addForgeHammerRecipe(GT_ModHandler.getModItem("minecraft", "coal", 1L, 0),
                GT_ModHandler.getModItem("Ztones", "minicoal", 9L, 0), 50, 8);
    }

    private void assembler() {
        // --- Ztones Tile
        RA.addAssemblerRecipe(GT_ModHandler.getModItem("minecraft", "stone_slab", 8L, 0),
                GT_ModHandler.getModItem("minecraft", "stone", 1L, 0),
                GT_ModHandler.getModItem("Ztones", "stoneTile", 8L, 0), 160, 4);
        RA.addAssemblerRecipe(GT_ModHandler.getModItem("minecraft", "stone_slab", 8L, 0),
                GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Iron, 1L),
                GT_ModHandler.getModItem("Ztones", "stoneTile", 16L, 0), 140, 6);
        RA.addAssemblerRecipe(GT_ModHandler.getModItem("minecraft", "stone_slab", 8L, 0),
                GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Steel, 1L),
                GT_ModHandler.getModItem("Ztones", "stoneTile", 32L, 0), 120, 8);
        RA.addAssemblerRecipe(GT_ModHandler.getModItem("minecraft", "stone_slab", 8L, 0),
                GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Aluminium, 1L),
                GT_ModHandler.getModItem("Ztones", "stoneTile", 64L, 0), 100, 12);
        // --- Garden Soil
        RA.addAssemblerRecipe(GT_ModHandler.getModItem("minecraft", "sand", 4L, 0),
                GT_ModHandler.getModItem("minecraft", "dirt", 4L, 0), Materials.SeedOil.getFluid(5),
                GT_ModHandler.getModItem("Ztones", "cleanDirt", 8L, 0), 160, 4);
        // --- Booster
        GT_Values.RA
                .addAssemblerRecipe(GT_ModHandler.getModItem("minecraft", "stone_pressure_plate", 1L, 0),
                        GT_Utility.getIntegratedCircuit(1), Materials.Blaze.getMolten(8),
                        GT_ModHandler.getModItem("Ztones", "booster", 1L, 0), 100, 30);
        // --- Aurora Block
        for (int i = 0; i < OreDictionary.getOres("dye").size(); i++) {
            RA.addAssemblerRecipe(GT_ModHandler.getModItem("minecraft", "glass", 4L, 0),
                    OreDictionary.getOres("dye").get(i),
                    GT_ModHandler.getModItem("Ztones", "auroraBlock", 8L, 0), 160, 4);
        }
        // --- Korp
        RA.addAssemblerRecipe(GT_ModHandler.getModItem("Ztones", "stoneTile", 24L, 0),
                GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Obsidian, 1L),
                GT_ModHandler.getModItem("Ztones", "tile.korpBlock", 24L, 0), 100, 8);
        // --- Zech
        RA.addAssemblerRecipe(GT_ModHandler.getModItem("Ztones", "tile.ztylBlock", 16L, 4),
                GT_ModHandler.getModItem("Ztones", "auroraBlock", 1L, 0),
                GT_ModHandler.getModItem("Ztones", "tile.zechBlock", 16L, 0), 100, 8);
        // --- Tank
        RA.addAssemblerRecipe(GT_ModHandler.getModItem("Ztones", "stoneTile", 24L, 0),
                GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Iron, 1L),
                GT_ModHandler.getModItem("Ztones", "tile.tankBlock", 16L, 0), 100, 8);
        // --- Sync
        RA.addAssemblerRecipe(GT_ModHandler.getModItem("Ztones", "stoneTile", 16L, 0),
                GT_OreDictUnificator.get(OrePrefixes.gem, Materials.Emerald, 1L),
                GT_ModHandler.getModItem("Ztones", "tile.syncBlock", 16L, 0), 100, 8);
        // --- Zkul
        RA.addAssemblerRecipe(GT_ModHandler.getModItem("Ztones", "tile.ztylBlock", 16L, 10),
                GT_ModHandler.getModItem("Ztones", "auroraBlock", 1L, 0),
                GT_ModHandler.getModItem("Ztones", "tile.zkulBlock", 16L, 0), 100, 8);
        // --- Mint
        RA.addAssemblerRecipe(GT_ModHandler.getModItem("Ztones", "stoneTile", 24L, 0),
                GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Rubber, 1L),
                GT_ModHandler.getModItem("Ztones", "tile.mintBlock", 24L, 0), 100, 8);
        // --- Lair
        RA.addAssemblerRecipe(GT_ModHandler.getModItem("Ztones", "stoneTile", 16L, 0),
                GT_ModHandler.getModItem("minecraft", "netherrack", 1L, 0),
                GT_ModHandler.getModItem("Ztones", "tile.lairBlock", 16L, 0), 100, 8);
        // --- Sols
        RA.addAssemblerRecipe(GT_ModHandler.getModItem("Ztones", "stoneTile", 24L, 0),
                GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Brass, 1L),
                GT_ModHandler.getModItem("Ztones", "tile.solsBlock", 24L, 0), 100, 8);
        // --- Reds
        RA.addAssemblerRecipe(GT_ModHandler.getModItem("Ztones", "stoneTile", 16L, 0),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Redstone, 1L),
                GT_ModHandler.getModItem("Ztones", "tile.redsBlock", 16L, 0), 100, 8);
        // --- Ztyl
        RA.addAssemblerRecipe(GT_ModHandler.getModItem("Ztones", "stoneTile", 24L, 0),
                GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Steel, 1L),
                GT_ModHandler.getModItem("Ztones", "tile.ztylBlock", 24L, 0), 100, 8);
        // --- Iszm
        RA.addAssemblerRecipe(GT_ModHandler.getModItem("Ztones", "tile.ztylBlock", 16L, 8),
                GT_ModHandler.getModItem("Ztones", "auroraBlock", 1L, 0),
                GT_ModHandler.getModItem("Ztones", "tile.iszmBlock", 16L, 0), 100, 8);
        // --- Roen
        RA.addAssemblerRecipe(GT_ModHandler.getModItem("Ztones", "stoneTile", 16L, 0),
                GT_ModHandler.getModItem("minecraft", "sandstone", 1L, 0),
                GT_ModHandler.getModItem("Ztones", "tile.roenBlock", 16L, 0), 100, 8);
        // --- Vect
        RA.addAssemblerRecipe(GT_ModHandler.getModItem("Ztones", "stoneTile", 24L, 0),
                GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Carbon, 1L),
                GT_ModHandler.getModItem("Ztones", "tile.vectBlock", 24L, 0), 100, 8);
        // --- Lave
        RA.addAssemblerRecipe(GT_ModHandler.getModItem("Ztones", "stoneTile", 16L, 0),
                GT_ModHandler.getModItem("minecraft", "ice", 1L, 0),
                GT_ModHandler.getModItem("Ztones", "tile.laveBlock", 16L, 0), 100, 8);
        // --- Zest
        RA.addAssemblerRecipe(GT_ModHandler.getModItem("Ztones", "tile.ztylBlock", 16L, 11),
                GT_ModHandler.getModItem("Ztones", "auroraBlock", 1L, 0),
                GT_ModHandler.getModItem("Ztones", "tile.zestBlock", 16L, 0), 100, 8);
        // --- Zyth
        RA.addAssemblerRecipe(GT_ModHandler.getModItem("Ztones", "tile.ztylBlock", 16L, 15),
                GT_ModHandler.getModItem("Ztones", "auroraBlock", 1L, 0),
                GT_ModHandler.getModItem("Ztones", "tile.zythBlock", 16L, 0), 100, 8);
        // --- Bitt
        RA.addAssemblerRecipe(GT_ModHandler.getModItem("Ztones", "stoneTile", 16L, 0),
                GT_ModHandler.getModItem("minecraft", "wool", 1L, 0),
                GT_ModHandler.getModItem("Ztones", "tile.bittBlock", 16L, 0), 100, 8);
        // --- Tinted Glass
        RA.addAssemblerRecipe(GT_ModHandler.getModItem("minecraft", "glass", 16L, 0),
                GT_ModHandler.getModItem("Ztones", "auroraBlock", 1L, 0),
                GT_ModHandler.getModItem("Ztones", "tile.glaxx", 16L, 0), 100, 8);
        // --- Agon
        RA.addAssemblerRecipe(GT_ModHandler.getModItem("Ztones", "stoneTile", 16L, 0),
                GT_ModHandler.getModItem("Ztones", "auroraBlock", 1L, 0),
                GT_ModHandler.getModItem("Ztones", "tile.agonBlock", 16L, 0), 100, 8);
        // --- Zone
        RA.addAssemblerRecipe(GT_ModHandler.getModItem("Ztones", "tile.ztylBlock", 16L, 3),
                GT_ModHandler.getModItem("Ztones", "auroraBlock", 1L, 0),
                GT_ModHandler.getModItem("Ztones", "tile.zoneBlock", 16L, 0), 100, 8);
        // --- Zoea
        RA.addAssemblerRecipe(GT_ModHandler.getModItem("Ztones", "tile.ztylBlock", 16L, 14),
                GT_ModHandler.getModItem("Ztones", "auroraBlock", 1L, 0),
                GT_ModHandler.getModItem("Ztones", "tile.zoeaBlock", 16L, 0), 100, 8);
        // --- Jelt
        RA.addAssemblerRecipe(GT_ModHandler.getModItem("Ztones", "stoneTile", 24L, 0),
                GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Gold, 1L),
                GT_ModHandler.getModItem("Ztones", "tile.jeltBlock", 24L, 0), 100, 8);
        // --- Zeta
        RA.addAssemblerRecipe(GT_ModHandler.getModItem("Ztones", "tile.ztylBlock", 16L, 13),
                GT_ModHandler.getModItem("Ztones", "auroraBlock", 1L, 0),
                GT_ModHandler.getModItem("Ztones", "tile.zetaBlock", 16L, 0), 100, 8);
        // --- Reed
        RA.addAssemblerRecipe(GT_ModHandler.getModItem("Ztones", "stoneTile", 24L, 0),
                GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Wood, 1L),
                GT_ModHandler.getModItem("Ztones", "tile.reedBlock", 24L, 0), 100, 8);
        // --- Cray
        RA.addAssemblerRecipe(GT_ModHandler.getModItem("minecraft", "hardened_clay", 16L, 0),
                GT_ModHandler.getModItem("Ztones", "auroraBlock", 1L, 0),
                GT_ModHandler.getModItem("Ztones", "tile.crayBlock", 16L, 0), 100, 8);
        // --- Fort
        RA.addAssemblerRecipe(GT_ModHandler.getModItem("Ztones", "tile.ztylBlock", 16L, 9),
                GT_ModHandler.getModItem("Ztones", "auroraBlock", 1L, 0),
                GT_ModHandler.getModItem("Ztones", "tile.fortBlock", 16L, 0), 100, 8);
        // --- Vena
        RA.addAssemblerRecipe(GT_ModHandler.getModItem("Ztones", "stoneTile", 24L, 0),
                GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Cobalt, 1L),
                GT_ModHandler.getModItem("Ztones", "tile.venaBlock", 24L, 0), 100, 8);
        // --- Kryp
        RA.addAssemblerRecipe(GT_ModHandler.getModItem("Ztones", "stoneTile", 16L, 0),
                GT_ModHandler.getModItem("chisel", "concrete", 1L, 0),
                GT_ModHandler.getModItem("Ztones", "tile.krypBlock", 16L, 0), 100, 8);
        // --- Zion
        RA.addAssemblerRecipe(GT_ModHandler.getModItem("Ztones", "tile.ztylBlock", 16L, 7),
                GT_ModHandler.getModItem("Ztones", "auroraBlock", 1L, 0),
                GT_ModHandler.getModItem("Ztones", "tile.zionBlock", 16L, 0), 100, 8);
        // --- Zome
        RA.addAssemblerRecipe(GT_ModHandler.getModItem("Ztones", "tile.ztylBlock", 16L, 6),
                GT_ModHandler.getModItem("Ztones", "auroraBlock", 1L, 0),
                GT_ModHandler.getModItem("Ztones", "tile.zomeBlock", 16L, 0), 100, 8);
        // --- Zane
        RA.addAssemblerRecipe(GT_ModHandler.getModItem("Ztones", "tile.ztylBlock", 16L, 12),
                GT_ModHandler.getModItem("Ztones", "auroraBlock", 1L, 0),
                GT_ModHandler.getModItem("Ztones", "tile.zaneBlock", 16L, 0), 100, 8);
        // --- Azur
        RA.addAssemblerRecipe(GT_ModHandler.getModItem("Ztones", "stoneTile", 16L, 0),
                GT_OreDictUnificator.get(OrePrefixes.gem, Materials.Lapis, 1L),
                GT_ModHandler.getModItem("Ztones", "tile.azurBlock", 16L, 0), 100, 8);
        // --- Zorg
        RA.addAssemblerRecipe(GT_ModHandler.getModItem("Ztones", "tile.ztylBlock", 16L, 5),
                GT_ModHandler.getModItem("Ztones", "auroraBlock", 1L, 0),
                GT_ModHandler.getModItem("Ztones", "tile.zorgBlock", 16L, 0), 100, 8);

    }

    private void cutting() {
        RA.addCutterRecipe(
                GT_ModHandler.getModItem("ProjRed|Illumination", "projectred.illumination.lamp", 1L, 16),
                GT_ModHandler.getModItem("Ztones", "lampf", 4L, 0), GT_Values.NI, 200, 4);
        // --- Flat Lamp white
        RA.addCutterRecipe(
                GT_ModHandler.getModItem("ProjRed|Illumination", "projectred.illumination.lamp", 1L, 24),
                GT_ModHandler.getModItem("Ztones", "lampt", 4L, 0), GT_Values.NI, 200, 4);
        // --- Flat Lamp black
        RA.addCutterRecipe(
                GT_ModHandler.getModItem("ProjRed|Illumination", "projectred.illumination.lamp", 1L, 23),
                GT_ModHandler.getModItem("Ztones", "lampb", 4L, 0), GT_Values.NI, 200, 4);

    }
}
