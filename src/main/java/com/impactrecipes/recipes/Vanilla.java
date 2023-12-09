package com.impactrecipes.recipes;

import com.impact.common.item.Core_Items2;
import com.impactrecipes.util.RecipeUtils;
import gregtech.api.enums.*;
import gregtech.api.util.GT_ModHandler;
import gregtech.api.util.GT_OreDictUnificator;
import gregtech.api.util.GT_Utility;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

import static com.impactrecipes.util.RecipeUtils.*;
import static gregtech.api.enums.GT_Values.RA;
import static gregtech.api.util.GT_ModHandler.removeFurnaceSmelting;
import static gregtech.api.util.GT_ModHandler.removeRecipeByOutput;

public class Vanilla implements Runnable {

    public static final Core_Items2 CoreItems2 = Core_Items2.getInstance();
    private static final long tBitMask = GT_ModHandler.RecipeBits.BUFFERED
            | GT_ModHandler.RecipeBits.NOT_REMOVABLE;

    @Override
    public void run() {
        removeVanila();
        handRecipe();
        oreRegisterRecipe();
        assembler();
		slicer();
        autoclave();
    }

    private void removeVanila() {
        removeFurnaceSmelting(new ItemStack(Items.clay_ball, 1, 0));
        removeFurnaceSmelting(new ItemStack(Blocks.stone));
        removeFurnaceSmelting(new ItemStack(Blocks.gravel));
        RecipeUtils.removeRecipeByOutput(new ItemStack(Blocks.wooden_slab, 1, 0) /*getItemStack("minecraft", "wooden_slab", 1, GT_Values.W)*/);


        removeRecipeByOutput(GT_ModHandler.getModItem("minecraft", "crafting_table", 1L, 0), true,
                false, false);
        removeRecipeByOutput(GT_ModHandler.getModItem("minecraft", "chest", 1L, 0), true, false, false);
        removeRecipeByOutput(GT_ModHandler.getModItem("minecraft", "trapped_chest", 1L, 0), true, false,
                false);
        removeRecipeByOutput(GT_ModHandler.getModItem("minecraft", "dispenser", 1L, 0), true, false,
                false);
        removeRecipeByOutput(GT_ModHandler.getModItem("minecraft", "dropper", 1L, 0), true, false,
                false);
        removeRecipeByOutput(GT_ModHandler.getModItem("minecraft", "sticky_piston", 1L, 0), true, false,
                false);
        removeRecipeByOutput(GT_ModHandler.getModItem("minecraft", "noteblock", 1L, 0), true, false,
                false);
        removeRecipeByOutput(GT_ModHandler.getModItem("minecraft", "jukebox", 1L, 0), true, false,
                false);
        removeRecipeByOutput(GT_ModHandler.getModItem("minecraft", "trapdoor", 1L, 0), true, false,
                false);
        removeRecipeByOutput(GT_ModHandler.getModItem("minecraft", "stone_pressure_plate", 1L, 0), true,
                false, false);
        removeRecipeByOutput(GT_ModHandler.getModItem("minecraft", "wooden_pressure_plate", 1L, 0),
                true, false, false);
        removeRecipeByOutput(GT_ModHandler.getModItem("minecraft", "glass_pane", 1L, 0), true, false,
                false);
        removeRecipeByOutput(GT_ModHandler.getModItem("minecraft", "torch", 1L, 0), true, false, false);
        removeRecipeByOutput(GT_ModHandler.getModItem("minecraft", "fence", 1L, 0), true, false, false);
        removeRecipeByOutput(GT_ModHandler.getModItem("minecraft", "fence_gate", 1L, 0), true, false,
                false);
        removeRecipeByOutput(GT_ModHandler.getModItem("minecraft", "tripwire_hook", 1L, 0), true, false,
                false);
        removeRecipeByOutput(GT_ModHandler.getModItem("minecraft", "anvil", 1L, 0), true, false, false);
        removeRecipeByOutput(GT_ModHandler.getModItem("minecraft", "wooden_door", 1L, 0), true, false,
                false);
        removeRecipeByOutput(GT_ModHandler.getModItem("minecraft", "iron_door", 1L, 0), true, false,
                false);
        removeRecipeByOutput(GT_ModHandler.getModItem("minecraft", "iron_sword", 1L, 0), true, false,
                false);
        removeRecipeByOutput(GT_ModHandler.getModItem("minecraft", "iron_shovel", 1L, 0), true, false,
                false);
        removeRecipeByOutput(GT_ModHandler.getModItem("minecraft", "iron_pickaxe", 1L, 0), true, false,
                false);
        removeRecipeByOutput(GT_ModHandler.getModItem("minecraft", "iron_axe", 1L, 0), true, false,
                false);
        removeRecipeByOutput(GT_ModHandler.getModItem("minecraft", "iron_hoe", 1L, 0), true, false,
                false);
        removeRecipeByOutput(GT_ModHandler.getModItem("minecraft", "golden_sword", 1L, 0), true, false,
                false);
        removeRecipeByOutput(GT_ModHandler.getModItem("minecraft", "golden_shovel", 1L, 0), true, false,
                false);
        removeRecipeByOutput(GT_ModHandler.getModItem("minecraft", "golden_pickaxe", 1L, 0), true, false,
                false);
        removeRecipeByOutput(GT_ModHandler.getModItem("minecraft", "golden_axe", 1L, 0), true, false,
                false);
        removeRecipeByOutput(GT_ModHandler.getModItem("minecraft", "golden_hoe", 1L, 0), true, false,
                false);
        removeRecipeByOutput(GT_ModHandler.getModItem("minecraft", "diamond_sword", 1L, 0), true, false,
                false);
        removeRecipeByOutput(GT_ModHandler.getModItem("minecraft", "diamond_shovel", 1L, 0), true,
                false, false);
        removeRecipeByOutput(GT_ModHandler.getModItem("minecraft", "diamond_pickaxe", 1L, 0), true,
                false, false);
        removeRecipeByOutput(GT_ModHandler.getModItem("minecraft", "diamond_axe", 1L, 0), true, false,
                false);
        removeRecipeByOutput(GT_ModHandler.getModItem("minecraft", "diamond_hoe", 1L, 0), true, false,
                false);
        removeRecipeByOutput(GT_ModHandler.getModItem("minecraft", "diamond_helmet", 1L, 0), true,
                false, false);
        removeRecipeByOutput(GT_ModHandler.getModItem("minecraft", "diamond_chestplate", 1L, 0), true,
                false, false);
        removeRecipeByOutput(GT_ModHandler.getModItem("minecraft", "diamond_leggings", 1L, 0), true,
                false, false);
        removeRecipeByOutput(GT_ModHandler.getModItem("minecraft", "diamond_boots", 1L, 0), true, false,
                false);
        removeRecipeByOutput(GT_ModHandler.getModItem("minecraft", "saddle", 1L, 0), true, false,
                false);
        removeRecipeByOutput(GT_ModHandler.getModItem("minecraft", "item_frame", 1L, 0), true, false,
                false);
        removeRecipeByOutput(GT_ModHandler.getModItem("minecraft", "bed", 1L, 0), true, false, false);
        removeRecipeByOutput(GT_ModHandler.getModItem("minecraft", "fishing_rod", 1L, 0), true, false,
                false);
        removeRecipeByOutput(GT_ModHandler.getModItem("minecraft", "ladder", 1L, 0), true, false,
                false);
        removeRecipeByOutput(GT_ModHandler.getModItem("minecraft", "stone_pressure_plate", 1L, 0), true,
                false, false);
        removeRecipeByOutput(GT_ModHandler.getModItem("minecraft", "wooden_pressure_plate", 1L, 0),
                true, false, false);
        removeRecipeByOutput(GT_ModHandler.getModItem("minecraft", "enchanting_table", 1L, 0), true,
                false, false);
        removeRecipeByOutput(GT_ModHandler.getModItem("minecraft", "brewing_stand", 1L, 0), true, false,
                false);
        removeRecipeByOutput(GT_ModHandler.getModItem("minecraft", "lit_pumpkin", 1L, 0), true, false,
                false);
        removeRecipeByOutput(GT_ModHandler.getModItem("minecraft", "redstone_lamp", 1L, 0), true, false,
                false);
        removeRecipeByOutput(GT_ModHandler.getModItem("minecraft", "daylight_detector", 1L, 0), true,
                false, false);
        removeRecipeByOutput(GT_ModHandler.getModItem("minecraft", "comparator", 1L, 0), true, false,
                false);
        removeRecipeByOutput(GT_ModHandler.getModItem("minecraft", "repeater", 1L, 0), true, false,
                false);
        removeRecipeByOutput(GT_ModHandler.getModItem("minecraft", "ender_eye", 1L, 0), true, false,
                false);
        removeRecipeByOutput(new ItemStack(Blocks.carpet, 1, GT_Values.W), true, false, false);
        removeRecipeByOutput(new ItemStack(Blocks.stained_glass_pane, 1, GT_Values.W), true, false,
                false);
        removeRecipeByOutput(new ItemStack(Items.enchanted_book, 1, 0), true, false,
                false);

        removeRecipeByOutput(getItemStack("minecraft", "ender_chest", 1, 0), true, false,
                false);
        removeRecipeByOutput(getItemStack("minecraft", "iron_ingot", 1, 0), true, false,
                false);

        removeRecipeByOutput(getItemStack("minecraft", "wooden_button", 1, 0), true, false,
                false);
        removeRecipeByOutput(getItemStack("minecraft", "stone_slab", 1, GT_Values.W), true, false,
                false);
        removeRecipeByOutput(getItemStack("minecraft", "arrow", 1, 0), true, false,
                false);

        removeRecipeByOutput(getItemStack("minecraft", "oak_stairs", 1, 0), true, false,
                false);
        removeRecipeByOutput(getItemStack("minecraft", "spruce_stairs", 1, 0), true, false,
                false);
        removeRecipeByOutput(getItemStack("minecraft", "birch_stairs", 1, 0), true, false,
                false);
        removeRecipeByOutput(getItemStack("minecraft", "jungle_stairs", 1, 0), true, false,
                false);
        removeRecipeByOutput(getItemStack("minecraft", "acacia_stairs", 1, 0), true, false,
                false);
        removeRecipeByOutput(getItemStack("minecraft", "dark_oak_stairs", 1, 0), true, false,
                false);

        removeRecipeByOutput(getItemStack("minecraft", "wooden_sword", 1, 0), true, false,
                false);
        removeRecipeByOutput(getItemStack("minecraft", "wooden_shovel", 1, 0), true, false,
                false);
        removeRecipeByOutput(getItemStack("minecraft", "wooden_pickaxe", 1, 0), true, false,
                false);
        removeRecipeByOutput(getItemStack("minecraft", "wooden_axe", 1, 0), true, false,
                false);
        removeRecipeByOutput(getItemStack("minecraft", "wooden_hoe", 1, 0), true, false,
                false);

        removeRecipeByOutput(getItemStack("minecraft", "stone_sword", 1, 0), true, false,
                false);
        removeRecipeByOutput(getItemStack("minecraft", "stone_shovel", 1, 0), true, false,
                false);
        removeRecipeByOutput(getItemStack("minecraft", "stone_pickaxe", 1, 0), true, false,
                false);
        removeRecipeByOutput(getItemStack("minecraft", "stone_axe", 1, 0), true, false,
                false);
        removeRecipeByOutput(getItemStack("minecraft", "stone_hoe", 1, 0), true, false,
                false);
		removeRecipeByOutput(getItemStack("minecraft", "lead", 1, 0), true, false,
                false);

    }

    private void handRecipe() {

        GT_ModHandler.addCraftingRecipe(new ItemStack(Blocks.stone_slab, 2, 0), new Object[]{"TB", 'T', "craftingToolSaw", 'B', ordictItemStack("stone")});
        GT_ModHandler.addCraftingRecipe(new ItemStack(Blocks.stone_slab, 2, 1), new Object[]{"TB", 'T', "craftingToolSaw", 'B', ordictItemStack(
                "sandstone")});
        GT_ModHandler.addCraftingRecipe(new ItemStack(Blocks.stone_slab, 2, 3), new Object[]{"TB", 'T', "craftingToolSaw", 'B', ordictItemStack(
                "cobblestone")});
        GT_ModHandler.addCraftingRecipe(new ItemStack(Blocks.stone_slab, 2, 4), new Object[]{"TB", 'T', "craftingToolSaw", 'B',
                new ItemStack(Blocks.brick_block)});
        GT_ModHandler.addCraftingRecipe(new ItemStack(Blocks.stone_slab, 2, 5), new Object[]{"TB", 'T', "craftingToolSaw", 'B', ordictItemStack(
                "stoneBricks")});
        GT_ModHandler.addCraftingRecipe(new ItemStack(Blocks.stone_slab, 2, 6), new Object[]{"TB", 'T', "craftingToolSaw", 'B', ordictItemStack(
                "stoneNetherBrick")});
        GT_ModHandler.addCraftingRecipe(new ItemStack(Blocks.stone_slab, 2, 7), new Object[]{"TB", 'T', "craftingToolSaw", 'B', ordictItemStack(
                "blockQuartz")});

        for (int i = 0; i <= 5; i++) {
            GT_ModHandler.addCraftingRecipe(new ItemStack(Blocks.wooden_slab, 2, i), new Object[]{"TB", 'T', "craftingToolSaw", 'B',
                    new ItemStack(Blocks.planks, 1, i)});
        }

        // --- Crafting Table
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("minecraft", "crafting_table", 1L), tBitMask, new Object[]{"WW", "WW", 'W', "logWood"});
        // --- Chest
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("minecraft", "chest", 1L), tBitMask, new Object[]{"WWW", "W W", "WWW", 'W', "plankWood"});
        // --- Trapper Chest
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("minecraft", "trapped_chest", 1L), tBitMask, new Object[]{" T ", "SCS", " d ", 'C', GT_ModHandler.getModItem("minecraft", "chest", 1L), 'S', OrePrefixes.screw.get(Materials.Iron), 'T', GT_ModHandler.getModItem("minecraft", "tripwire_hook", 1L)});
        // --- Dispenser
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("minecraft", "dispenser", 1L), tBitMask, new Object[]{"CRC", "SMS", "GWG", 'C', "cobblestone", 'S', OrePrefixes.spring.get(Materials.Iron), 'G', OrePrefixes.gearGtSmall.get(Materials.Iron), 'W', OrePrefixes.wireGt01.get(Materials.RedAlloy), 'R', OrePrefixes.ring.get(Materials.Iron), 'M', GT_ModHandler.getModItem("minecraft", "string", 1L)});
        // --- Dropper
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("minecraft", "dropper", 1L), tBitMask, new Object[]{"CRC", "SMS", "GWG", 'C', "cobblestone", 'S', OrePrefixes.springSmall.get(Materials.Iron), 'G', OrePrefixes.gearGtSmall.get(Materials.Iron), 'W', OrePrefixes.wireGt01.get(Materials.RedAlloy), 'R', OrePrefixes.ring.get(Materials.Iron), 'M', GT_ModHandler.getModItem("minecraft", "string", 1L)});
        // --- Sticky Piston
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("minecraft", "sticky_piston", 1L), tBitMask, new Object[]{"r", "S", "P", 'S', "slimeball", 'P', GT_ModHandler.getModItem("minecraft", "piston", 1L)});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("minecraft", "sticky_piston", 1L), tBitMask, new Object[]{"r", "S", "P", 'S', GT_ModHandler.getModItem("IC2", "itemHarz", 1L), 'P', GT_ModHandler.getModItem("minecraft", "piston", 1L)});
        // --- Noteblock
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("minecraft", "noteblock", 1L), tBitMask, new Object[]{"PPP", "BGB", "PWP", 'P', "plankWood", 'B', GT_ModHandler.getModItem("minecraft", "iron_bars", 1L), 'G', OrePrefixes.gearGt.get(Materials.Wood), 'W', OrePrefixes.wireGt01.get(Materials.RedAlloy)});
        // --- Jukebox
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("minecraft", "jukebox", 1L), tBitMask, new Object[]{"LBL", "NRN", "LGL", 'L', "plankWood", 'N', GT_ModHandler.getModItem("minecraft", "noteblock", 1L), 'G', OrePrefixes.gearGt.get(Materials.Iron), 'B', OrePrefixes.bolt.get(Materials.Diamond), 'R', "record"});
        // --- Jack O' Lantern
        GT_ModHandler.addShapelessCraftingRecipe(GT_ModHandler.getModItem("minecraft", "lit_pumpkin", 1L), tBitMask, new Object[]{GT_ModHandler.getModItem("minecraft", "pumpkin", 1L), GT_ModHandler.getModItem("minecraft", "torch", 1L), ToolDictNames.craftingToolKnife});
        // --- Trapdoor Oak
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("minecraft", "trapdoor", 1L), tBitMask, new Object[]{"PSP", "SSS", "PSP", 'S', OrePrefixes.stick.get(Materials.Wood), 'P', GT_ModHandler.getModItem("minecraft", "wooden_slab", 1L)});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("minecraft", "trapdoor", 2L), tBitMask, new Object[]{"PSP", "SRS", "PSP", 'S', OrePrefixes.stick.get(Materials.Wood), 'R', OrePrefixes.screw.get(Materials.Iron), 'P', GT_ModHandler.getModItem("minecraft", "wooden_slab", 1L)});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("minecraft", "trapdoor", 3L), tBitMask, new Object[]{"PSP", "SRS", "PSP", 'S', OrePrefixes.stick.get(Materials.Wood), 'R', OrePrefixes.screw.get(Materials.Steel), 'P', GT_ModHandler.getModItem("minecraft", "wooden_slab", 1L)});
        // --- Pressure Plate
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("minecraft", "stone_pressure_plate", 2L), tBitMask, new Object[]{"ShS", "BPB", "SdS", 'S', OrePrefixes.screw.get(Materials.Iron), 'P', OrePrefixes.spring.get(Materials.Iron), 'B', GT_ModHandler.getModItem("minecraft", "stone_slab", 1L)});
        // --- Wooden Pressure Plate
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("minecraft", "wooden_pressure_plate", 2L), tBitMask, new Object[]{"ShS", "BPB", "SdS", 'S', OrePrefixes.screw.get(Materials.Iron), 'P', OrePrefixes.spring.get(Materials.Iron), 'B', "slabWood"});
        // --- Glass Pane
        GT_ModHandler.addShapelessCraftingRecipe(GT_ModHandler.getModItem("minecraft", "glass_pane", 2L), tBitMask, new Object[]{ToolDictNames.craftingToolSaw, GT_ModHandler.getModItem("minecraft", "glass", 1L)});
        // --- Torch
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("minecraft", "torch", 3L), tBitMask, new Object[]{"C", "S", 'S', OrePrefixes.stick.get(Materials.Wood), 'C', OrePrefixes.gem.get(Materials.Coal)});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("minecraft", "torch", 2L), tBitMask, new Object[]{"C", "S", 'S', OrePrefixes.stick.get(Materials.Wood), 'C', OrePrefixes.gem.get(Materials.Charcoal)});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("minecraft", "torch", 1L), tBitMask, new Object[]{"C", "S", 'S', OrePrefixes.stick.get(Materials.Wood), 'C', OrePrefixes.gem.get(Materials.Lignite)});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("minecraft", "torch", 5L), tBitMask, new Object[]{"C", "S", 'S', OrePrefixes.stick.get(Materials.Wood), 'C', OrePrefixes.gem.get(Materials.CokeCoal)});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("minecraft", "torch", 3L), tBitMask, new Object[]{"C", "S", 'S', OrePrefixes.stick.get(Materials.Wood), 'C', OrePrefixes.dust.get(Materials.Sulfur)});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("minecraft", "torch", 6L), tBitMask, new Object[]{"C", "S", 'S', OrePrefixes.stick.get(Materials.Wood), 'C', OrePrefixes.dust.get(Materials.Phosphorus)});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("minecraft", "torch", 2L), tBitMask, new Object[]{"C", "S", 'S', OrePrefixes.stick.get(Materials.Wood), 'C', GT_ModHandler.getModItem("IC2", "itemHarz", 1L)});
        // --- Ladder
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("minecraft", "ladder", 1L), tBitMask, new Object[]{"SIS", "SSS", "SrS", 'S', OrePrefixes.stick.get(Materials.Wood), 'I', GT_ModHandler.getModItem("minecraft", "string", 1L)});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("minecraft", "ladder", 2L), tBitMask, new Object[]{"SdS", "SWS", "SrS", 'S', OrePrefixes.stick.get(Materials.Wood), 'W', OrePrefixes.screw.get(Materials.Wood)});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("minecraft", "ladder", 4L), tBitMask, new Object[]{"SdS", "SWS", "SrS", 'S', OrePrefixes.stick.get(Materials.Wood), 'W', OrePrefixes.screw.get(Materials.Iron)});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("minecraft", "ladder", 8L), tBitMask, new Object[]{"SdS", "SWS", "SrS", 'S', OrePrefixes.stick.get(Materials.Wood), 'W', OrePrefixes.screw.get(Materials.Steel)});
        // --- Fence
        for (int i = 0; i < 6; i++) {
            GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("minecraft", "fence", 1L), tBitMask, new Object[]{"SPS", "SPS", "SPS", 'S', OrePrefixes.stick.get(Materials.Wood), 'P', GT_ModHandler.getModItem("minecraft", "planks", 1L, i)});
            GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("minecraft", "fence", 1L), tBitMask, new Object[]{"WdW", "SPS", "SPS", 'W', OrePrefixes.screw.get(Materials.Wood), 'S', OrePrefixes.stick.get(Materials.Wood), 'P', GT_ModHandler.getModItem("minecraft", "planks", 1L, i)});
            GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("minecraft", "fence", 2L), tBitMask, new Object[]{"WdW", "SPS", "SPS", 'W', OrePrefixes.screw.get(Materials.Iron), 'S', OrePrefixes.stick.get(Materials.Wood), 'P', GT_ModHandler.getModItem("minecraft", "planks", 1L, i)});
            GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("minecraft", "fence", 4L), tBitMask, new Object[]{"WdW", "SPS", "SPS", 'W', OrePrefixes.screw.get(Materials.Steel), 'S', OrePrefixes.stick.get(Materials.Wood), 'P', GT_ModHandler.getModItem("minecraft", "planks", 1L, i)});
        }
        // --- Oak Fence Gate
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("minecraft", "fence_gate", 1L), tBitMask, new Object[]{"PSP", "PSP", "PSP", 'P', GT_ModHandler.getModItem("minecraft", "planks", 1L), 'S', OrePrefixes.stick.get(Materials.Wood)});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("minecraft", "fence_gate", 1L), tBitMask, new Object[]{"CdC", "PSP", "PSP", 'P', GT_ModHandler.getModItem("minecraft", "planks", 1L), 'S', OrePrefixes.stick.get(Materials.Wood), 'C', OrePrefixes.screw.get(Materials.Wood)});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("minecraft", "fence_gate", 2L), tBitMask, new Object[]{"CdC", "PSP", "PSP", 'P', GT_ModHandler.getModItem("minecraft", "planks", 1L), 'S', OrePrefixes.stick.get(Materials.Wood), 'C', OrePrefixes.screw.get(Materials.Iron)});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("minecraft", "fence_gate", 4L), tBitMask, new Object[]{"CdC", "PSP", "PSP", 'P', GT_ModHandler.getModItem("minecraft", "planks", 1L), 'S', OrePrefixes.stick.get(Materials.Wood), 'C', OrePrefixes.screw.get(Materials.Steel)});
        // --- Redstone Lamp
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("minecraft", "redstone_lamp", 1L), tBitMask, new Object[]{"GGG", "GBG", "GRG", 'R', OrePrefixes.wireGt01.get(Materials.RedAlloy), 'B', GT_ModHandler.getModItem("minecraft", "glowstone", 1L), 'G', GT_ModHandler.getModItem("minecraft", "glass_pane", 1L)});
        // --- Tripwire Hook
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("minecraft", "tripwire_hook", 1L), tBitMask, new Object[]{"RSR", "ISI", " I ", 'S', OrePrefixes.stick.get(Materials.Wood), 'R', OrePrefixes.ring.get(Materials.Iron), 'I', GT_ModHandler.getModItem("minecraft", "string", 1L)});
        // --- Anvil
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("minecraft", "anvil", 1L), tBitMask, new Object[]{"BBB", "SBS", "PBP", 'S', OrePrefixes.screw.get(Materials.Iron), 'P', OrePrefixes.plate.get(Materials.Iron), 'B', OrePrefixes.block.get(Materials.Iron)});
        // --- Daylight Sensor
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("minecraft", "daylight_detector", 1L), tBitMask, new Object[]{"GGG", "QQQ", "SRS", 'R', OrePrefixes.wireGt01.get(Materials.RedAlloy), 'Q', OrePrefixes.plate.get(Materials.NetherQuartz), 'S', "slabWood", 'G', GT_ModHandler.getModItem("minecraft", "glass_pane", 1L)});
        // --- Oak Door
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("minecraft", "wooden_door", 1L), tBitMask, new Object[]{"SPP", "RPP", "dPP", 'S', OrePrefixes.screw.get(Materials.Iron), 'R', OrePrefixes.ring.get(Materials.Iron), 'P', GT_ModHandler.getModItem("minecraft", "planks", 1L)});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("minecraft", "wooden_door", 1L), tBitMask, new Object[]{"SPP", "RPP", "dPP", 'S', OrePrefixes.screw.get(Materials.Copper), 'R', OrePrefixes.ring.get(Materials.Copper), 'P', GT_ModHandler.getModItem("minecraft", "planks", 1L)});
        // --- Iron Door
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("minecraft", "iron_door", 1L), tBitMask, new Object[]{"SPP", "RPP", "dPP", 'S', OrePrefixes.screw.get(Materials.Steel), 'R', OrePrefixes.ring.get(Materials.Steel), 'P', OrePrefixes.plate.get(Materials.Iron)});
        // --- Diamond Suit
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("minecraft", "diamond_helmet", 1L), tBitMask, new Object[]{"DDD", "DfD", 'D', OrePrefixes.gem.get(Materials.Diamond)});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("minecraft", "diamond_chestplate", 1L), tBitMask, new Object[]{"DfD", "DDD", "DDD", 'D', OrePrefixes.gem.get(Materials.Diamond)});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("minecraft", "diamond_leggings", 1L), tBitMask, new Object[]{"DDD", "DfD", "D D", 'D', OrePrefixes.gem.get(Materials.Diamond)});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("minecraft", "diamond_boots", 1L), tBitMask, new Object[]{"D D", "DfD", 'D', OrePrefixes.gem.get(Materials.Diamond)});
        // --- Iron Horse Armor
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("minecraft", "iron_horse_armor", 1L), tBitMask, new Object[]{"hdH", "PCP", "LSL", 'P', OrePrefixes.plate.get(Materials.Iron), 'S', OrePrefixes.screw.get(Materials.Iron), 'H', GT_ModHandler.getModItem("minecraft", "iron_helmet", 1L), 'C', GT_ModHandler.getModItem("minecraft", "iron_chestplate", 1L), 'L', GT_ModHandler.getModItem("minecraft", "iron_leggings", 1L)});
        // --- Gold Horse Armor
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("minecraft", "golden_horse_armor", 1L), tBitMask, new Object[]{"hdH", "PCP", "LSL", 'P', OrePrefixes.plate.get(Materials.Gold), 'S', OrePrefixes.screw.get(Materials.Gold), 'H', GT_ModHandler.getModItem("minecraft", "golden_helmet", 1L), 'C', GT_ModHandler.getModItem("minecraft", "golden_chestplate", 1L), 'L', GT_ModHandler.getModItem("minecraft", "golden_leggings", 1L)});
        // --- Diamond Horse Armor
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("minecraft", "diamond_horse_armor", 1L), tBitMask, new Object[]{"hdH", "PCP", "LSL", 'P', OrePrefixes.plate.get(Materials.Diamond), 'S', OrePrefixes.screw.get(Materials.Diamond), 'H', GT_ModHandler.getModItem("minecraft", "diamond_helmet", 1L), 'C', GT_ModHandler.getModItem("minecraft", "diamond_chestplate", 1L), 'L', GT_ModHandler.getModItem("minecraft", "diamond_leggings", 1L)});
        // --- Saddle
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("minecraft", "saddle", 1L), tBitMask, new Object[]{"LBL", "LCL", "RSR", 'C', "blockWool", 'L', GT_ModHandler.getModItem("minecraft", "leather", 1L), 'B', GT_ModHandler.getModItem("Backpack", "tannedLeather", 1L), 'S', GT_ModHandler.getModItem("minecraft", "string", 1L), 'R', OrePrefixes.ring.get(Materials.Iron)});
        // --- Item Frame
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("minecraft", "item_frame", 1L), tBitMask, new Object[]{"IRI", "SLS", "SSS", 'S', OrePrefixes.stick.get(Materials.Wood), 'R', OrePrefixes.ring.get(Materials.Iron), 'I', GT_ModHandler.getModItem("minecraft", "string", 1L), 'L', GT_ModHandler.getModItem("minecraft", "leather", 1L)});
        // --- Comparator
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("minecraft", "comparator", 1L), tBitMask, new Object[]{"STS", "TPT", "LdL", 'S', OrePrefixes.screw.get(Materials.Iron), 'P', OrePrefixes.plate.get(Materials.NetherQuartz), 'T', GT_ModHandler.getModItem("minecraft", "redstone_torch", 1L), 'L', GT_ModHandler.getModItem("minecraft", "stone_slab", 1L)});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("minecraft", "comparator", 1L), tBitMask, new Object[]{"STS", "TPT", "LdL", 'S', OrePrefixes.screw.get(Materials.Iron), 'P', OrePrefixes.plate.get(Materials.Quartzite), 'T', GT_ModHandler.getModItem("minecraft", "redstone_torch", 1L), 'L', GT_ModHandler.getModItem("minecraft", "stone_slab", 1L)});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("minecraft", "comparator", 1L), tBitMask, new Object[]{"STS", "TPT", "LdL", 'S', OrePrefixes.screw.get(Materials.Iron), 'P', OrePrefixes.plate.get(Materials.CertusQuartz), 'T', GT_ModHandler.getModItem("minecraft", "redstone_torch", 1L), 'L', GT_ModHandler.getModItem("minecraft", "stone_slab", 1L)});
        // --- Redstone Repeater
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("minecraft", "repeater", 1L), tBitMask, new Object[]{"S S", "TdT", "LIL", 'S', OrePrefixes.screw.get(Materials.Iron), 'I', OrePrefixes.stick.get(Materials.RedAlloy), 'T', GT_ModHandler.getModItem("minecraft", "redstone_torch", 1L), 'L', GT_ModHandler.getModItem("minecraft", "stone_slab", 1L)});
        // --- Bed
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("minecraft", "bed", 1L), tBitMask, new Object[]{"WWW", "FPF", 'P', OrePrefixes.plank.get(Materials.Wood), 'F', GT_ModHandler.getModItem("minecraft", "fence", 1L), 'W', "blockWool"});
        // --- Fishing Rod
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("minecraft", "fishing_rod", 1L), tBitMask, new Object[]{"  S", " SI", "SxR", 'S', OrePrefixes.stickLong.get(Materials.Wood), 'R', OrePrefixes.ring.get(Materials.Iron), 'I', GT_ModHandler.getModItem("minecraft", "string", 1L)});
        for (int i = 0; i < 16; i++) {
            // --- Carpet
            GT_ModHandler.addCraftingRecipe(new ItemStack(Blocks.carpet, 1, i), tBitMask, new Object[]{"WW", 'W', new ItemStack(Blocks.wool, 1, i)});
            GT_ModHandler.addCraftingRecipe(new ItemStack(Blocks.carpet, 3, i), tBitMask, new Object[]{"WWs", 'W', new ItemStack(Blocks.wool, 1, i)});
            GT_ModHandler.addShapelessCraftingRecipe(new ItemStack(Blocks.carpet, 1, 15 - i), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{new ItemStack(Blocks.carpet, 1, 0), Dyes.VALUES[i]});
            // --- Glass Pane
            GT_ModHandler.addCraftingRecipe(new ItemStack(Blocks.stained_glass_pane, 2, i), tBitMask, new Object[]{"sW", 'W', new ItemStack(Blocks.stained_glass, 1, i)});
            GT_ModHandler.addCraftingRecipe(new ItemStack(Blocks.stained_glass_pane, 8, 15 - i), tBitMask, new Object[]{"WWW", "WDW", "WWW", 'W', new ItemStack(Blocks.glass_pane, 1, 0), 'D', Dyes.VALUES[i]});
            GT_ModHandler.addShapelessCraftingRecipe(new ItemStack(Blocks.stained_glass_pane, 1, 15 - i), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{new ItemStack(Blocks.glass_pane, 1, 0), Dyes.VALUES[i]});
            // --- GT's Dye
            GT_ModHandler.addShapelessCraftingRecipe(ItemList.DYE_ONLY_ITEMS[i].get(1), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{Dyes.VALUES[i]});
        }

        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("minecraft", "string", 2L), tBitMask, new Object[]{"Wk", 'W', "blockWool"});

        // --- Stairs
        ItemStack[] stairs2 = {GT_ModHandler.getModItem("minecraft", "oak_stairs", 2L), GT_ModHandler.getModItem("minecraft", "spruce_stairs", 2L),
                GT_ModHandler.getModItem("minecraft", "birch_stairs", 2L), GT_ModHandler.getModItem("minecraft", "jungle_stairs", 2L),
                GT_ModHandler.getModItem("minecraft", "acacia_stairs", 2L), GT_ModHandler.getModItem("minecraft", "dark_oak_stairs", 2L)};
        ItemStack[] stairs4 = {GT_ModHandler.getModItem("minecraft", "oak_stairs", 4L), GT_ModHandler.getModItem("minecraft", "spruce_stairs", 4L),
                GT_ModHandler.getModItem("minecraft", "birch_stairs", 4L), GT_ModHandler.getModItem("minecraft", "jungle_stairs", 4L),
                GT_ModHandler.getModItem("minecraft", "acacia_stairs", 4L), GT_ModHandler.getModItem("minecraft", "dark_oak_stairs", 4L)};
        for (int i = 0; i < 6; i++) {
            GT_ModHandler.addCraftingRecipe(stairs2[i], tBitMask, new Object[]{"sP", "PP", 'P', GT_ModHandler.getModItem("minecraft", "wooden_slab", 1L, i)});
            GT_ModHandler.addCraftingRecipe(stairs4[i], tBitMask, new Object[]{"sP", "PP", 'P', GT_ModHandler.getModItem("minecraft", "planks", 1L, i)});
        }
		
		// --- Lead
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("minecraft", "lead", 1L), tBitMask, new Object[]{"SSS", "SBS", "SSS", 'S', GT_ModHandler.getModItem("minecraft", "string", 1L), 'B', "slimeball"});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("minecraft", "lead", 1L), tBitMask, new Object[]{"SSS", "SBS", "SSS", 'S', GT_ModHandler.getModItem("minecraft", "string", 1L), 'B', GT_ModHandler.getModItem("IC2", "itemHarz", 1L)});
        // --- Book
        GT_ModHandler.addShapelessCraftingRecipe(new ItemStack(Items.book), tBitMask, new Object[]{"platePaper", "platePaper", "platePaper", new ItemStack(Items.string), CoreItems2.getRecipe(197, 1), CoreItems2.getRecipe(197, 1)});

		// --- Alternative recipe of Flint
        GT_ModHandler.addShapelessCraftingRecipe(new ItemStack(Items.flint), tBitMask, new Object[]{GT_ModHandler.getModItem("minecraft", "gravel", 1L), GT_ModHandler.getModItem("minecraft", "gravel", 1L), GT_ModHandler.getModItem("minecraft", "gravel", 1L)});

    }

    private void oreRegisterRecipe() {
        // --- Dye Black
        OreDictionary.registerOre("dyeBlack", GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Coal, 1L));
        OreDictionary.registerOre("dyeBlack", GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Charcoal, 1L));
        OreDictionary.registerOre("dyeBlack", GT_OreDictUnificator.get(OrePrefixes.dust, Materials.DarkAshes, 1L));
        OreDictionary.registerOre("dyeBlack", GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Magnetite, 1L));
        // --- Dye Gray
        OreDictionary.registerOre("dyeGray", GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Ashes, 1L));
        // --- Dye Green
        OreDictionary.registerOre("dyeGreen", GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Malachite, 1L));
        OreDictionary.registerOre("dyeGreen", GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Glauconite, 1L));
        OreDictionary.registerOre("dyeGreen", GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Garnierite, 1L));
        // --- Dye White
        OreDictionary.registerOre("dyeWhite", GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Calcite, 1L));
        OreDictionary.registerOre("dyeWhite", GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Zincite, 1L));
        OreDictionary.registerOre("dyeWhite", GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Barite, 1L));
        OreDictionary.registerOre("dyeWhite", GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Quicklime, 1L));
        OreDictionary.registerOre("dyeWhite", GT_OreDictUnificator.get(OrePrefixes.dust, Materials.AntimonyTrioxide, 1L));
        // --- Dye Red
        OreDictionary.registerOre("dyeRed", GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Cinnabar, 1L));
        OreDictionary.registerOre("dyeRed", GT_OreDictUnificator.get(OrePrefixes.dust, Materials.BandedIron, 1L));
        // --- Dye Yellow
        OreDictionary.registerOre("dyeYellow", GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Massicot, 1L));
        // --- Dye Brown
        OreDictionary.registerOre("dyeBrown", GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Lignite, 1L));
        for (int i = 0; i < 6; i++) {
            OreDictionary.registerOre("plankWood", new ItemStack(Blocks.planks, i));
        }
    }

    private void assembler() {
        // --- Oak Door
        RA.addAssemblerRecipe(GT_ModHandler.getModItem("minecraft", "planks", 6L),
                GT_Utility.getIntegratedCircuit(6), Materials.Iron.getMolten(16),
                GT_ModHandler.getModItem("minecraft", "wooden_door", 1L), 400, 4);
        RA.addAssemblerRecipe(GT_ModHandler.getModItem("minecraft", "planks", 6L),
                GT_Utility.getIntegratedCircuit(6), Materials.Copper.getMolten(16),
                GT_ModHandler.getModItem("minecraft", "wooden_door", 1L), 400, 4);
        // --- Iron Door
        RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Iron, 6L),
                GT_Utility.getIntegratedCircuit(6), Materials.Steel.getMolten(16),
                GT_ModHandler.getModItem("minecraft", "iron_door", 1L), 400, 8);
        // --- Traped Door Oak
        RA.addAssemblerRecipe(
                new ItemStack[]{GT_ModHandler.getModItem("minecraft", "wooden_slab", 4L),
                        GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 4L),
                        GT_Utility.getIntegratedCircuit(1)}, null,
                GT_ModHandler.getModItem("minecraft", "trapdoor", 2L), 600, 4);
        RA.addAssemblerRecipe(
                new ItemStack[]{GT_ModHandler.getModItem("minecraft", "wooden_slab", 4L),
                        GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 4L),
                        GT_Utility.getIntegratedCircuit(2)}, Materials.Iron.getMolten(16),
                GT_ModHandler.getModItem("minecraft", "trapdoor", 4L), 600, 4);
        RA.addAssemblerRecipe(
                new ItemStack[]{GT_ModHandler.getModItem("minecraft", "wooden_slab", 4L),
                        GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 4L),
                        GT_Utility.getIntegratedCircuit(3)}, Materials.Steel.getMolten(16),
                GT_ModHandler.getModItem("minecraft", "trapdoor", 6L), 600, 4);
        // --- Fence Gate Oak
        RA.addAssemblerRecipe(
                new ItemStack[]{GT_ModHandler.getModItem("minecraft", "planks", 3L),
                        GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 2L),
                        GT_Utility.getIntegratedCircuit(2)}, null,
                GT_ModHandler.getModItem("minecraft", "fence_gate", 1L), 300, 8);
        RA.addAssemblerRecipe(
                new ItemStack[]{GT_ModHandler.getModItem("minecraft", "planks", 3L),
                        GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 2L),
                        GT_Utility.getIntegratedCircuit(3)}, Materials.Iron.getMolten(16),
                GT_ModHandler.getModItem("minecraft", "fence_gate", 2L), 300, 8);
        RA.addAssemblerRecipe(
                new ItemStack[]{GT_ModHandler.getModItem("minecraft", "planks", 3L),
                        GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 2L),
                        GT_Utility.getIntegratedCircuit(3)}, Materials.Steel.getMolten(16),
                GT_ModHandler.getModItem("minecraft", "fence_gate", 4L), 300, 8);
        // --- Wooden Pressure Plate
        RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.slab, Materials.Wood, 2L),
                GT_OreDictUnificator.get(OrePrefixes.spring, Materials.Iron, 1L),
                GT_ModHandler.getModItem("minecraft", "wooden_pressure_plate", 2L), 100, 8);
        // --- Pressure Plate
        RA.addAssemblerRecipe(GT_ModHandler.getModItem("minecraft", "stone_slab", 2L),
                GT_OreDictUnificator.get(OrePrefixes.spring, Materials.Iron, 1L),
                GT_ModHandler.getModItem("minecraft", "stone_pressure_plate", 2L), 100, 8);
        // --- Ladder
        RA.addAssemblerRecipe(
                new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 3L),
                        GT_Utility.getIntegratedCircuit(5)}, null,
                GT_ModHandler.getModItem("minecraft", "ladder", 2L), 400, 4);
        RA.addAssemblerRecipe(
                new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 3L),
                        GT_Utility.getIntegratedCircuit(6)}, Materials.Iron.getMolten(16),
                GT_ModHandler.getModItem("minecraft", "ladder", 4L), 300, 8);
        RA.addAssemblerRecipe(
                new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 3L),
                        GT_Utility.getIntegratedCircuit(7)}, Materials.Steel.getMolten(16),
                GT_ModHandler.getModItem("minecraft", "ladder", 8L), 200, 16);
        RA.addAssemblerRecipe(
                new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 3L),
                        GT_Utility.getIntegratedCircuit(7)}, Materials.Aluminium.getMolten(16),
                GT_ModHandler.getModItem("minecraft", "ladder", 32L), 100, 30);
        // --- Fence
        for (int i = 0; i < 6; i++) {
            RA.addAssemblerRecipe(
                    new ItemStack[]{GT_ModHandler.getModItem("minecraft", "planks", 2L, i),
                            GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 2L),
                            GT_Utility.getIntegratedCircuit(10)}, null,
                    GT_ModHandler.getModItem("minecraft", "fence", 1L), 300, 8);
            RA.addAssemblerRecipe(
                    new ItemStack[]{GT_ModHandler.getModItem("minecraft", "planks", 2L, i),
                            GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 2L),
                            GT_Utility.getIntegratedCircuit(11)}, Materials.Iron.getMolten(16),
                    GT_ModHandler.getModItem("minecraft", "fence", 2L), 300, 8);
            RA.addAssemblerRecipe(
                    new ItemStack[]{GT_ModHandler.getModItem("minecraft", "planks", 2L, i),
                            GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 2L),
                            GT_Utility.getIntegratedCircuit(11)}, Materials.Steel.getMolten(16),
                    GT_ModHandler.getModItem("minecraft", "fence", 4L), 300, 8);
        }
        // --- Carpet
        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < Dyes.VALUES[i].getSizeOfFluidList(); j++) {
                RA.addAssemblerRecipe(new ItemStack(Items.string, 3),
                        ItemList.Circuit_Integrated.getWithDamage(0L, 3L),
                        Dyes.VALUES[i].getFluidDye(j, 24L), new ItemStack(Blocks.carpet, 2, 15 - i), 128, 5);
            }
        }
        // --- Stairs
        ItemStack[] stairs2 = {GT_ModHandler.getModItem("minecraft", "oak_stairs", 2L), GT_ModHandler.getModItem("minecraft", "spruce_stairs", 2L),
                GT_ModHandler.getModItem("minecraft", "birch_stairs", 2L), GT_ModHandler.getModItem("minecraft", "jungle_stairs", 2L),
                GT_ModHandler.getModItem("minecraft", "acacia_stairs", 2L), GT_ModHandler.getModItem("minecraft", "dark_oak_stairs", 2L)};
        ItemStack[] stairs4 = {GT_ModHandler.getModItem("minecraft", "oak_stairs", 4L), GT_ModHandler.getModItem("minecraft", "spruce_stairs", 4L),
                GT_ModHandler.getModItem("minecraft", "birch_stairs", 4L), GT_ModHandler.getModItem("minecraft", "jungle_stairs", 4L),
                GT_ModHandler.getModItem("minecraft", "acacia_stairs", 4L), GT_ModHandler.getModItem("minecraft", "dark_oak_stairs", 4L)};
        for (int i = 0; i < 6; i++) {
            RA.addAssemblerRecipe(
                    new ItemStack[]{GT_ModHandler.getModItem("minecraft", "wooden_slab", 3L, i),
                            GT_Utility.getIntegratedCircuit(7)}, null, stairs2[i], 300, 8);
            RA.addAssemblerRecipe(
                    new ItemStack[]{GT_ModHandler.getModItem("minecraft", "planks", 3L, i),
                            GT_Utility.getIntegratedCircuit(7)}, null, stairs4[i], 300, 8);
        }
    }
	
	private void slicer() {
		RA.addSlicerRecipe(GT_ModHandler.getModItem("minecraft", "melon_block", 1L), ItemList.Shape_Slicer_Flat.get(0L), GT_ModHandler.getModItem("minecraft", "melon", 8L), 128, 4);

	}

    private void autoclave() {
        RA.addAutoclaveRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Clay, 1), Materials.Water.getFluid(250L),
                new ItemStack(Items.clay_ball), 10000,
                20, 2);
    }
}
