package com.impactrecipes.recipes;

import com.impact.common.item.Core_Items;
import gregtech.api.enums.GT_Values;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.util.GT_ModHandler;
import gregtech.api.util.GT_OreDictUnificator;
import gregtech.api.util.GT_Utility;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

import static gregtech.api.enums.GT_Values.RA;
import static gregtech.api.util.GT_ModHandler.removeRecipeByOutput;

public class ChiselRecipes implements Runnable {

    public static final Core_Items CoreItems = Core_Items.getInstance();

    private static final long tBitMask = GT_ModHandler.RecipeBits.BUFFERED
            | GT_ModHandler.RecipeBits.NOT_REMOVABLE;

    @Override
    public void run() {
        remove();
        handRecipe();
        alloySmelter();
        assembler();
        cutting();
        fluidSolidifier();
    }

    private void remove() {
        removeRecipeByOutput(GT_ModHandler.getModItem("chisel", "chisel", 1L));
        removeRecipeByOutput(GT_ModHandler.getModItem("chisel", "diamondChisel", 1L));
        removeRecipeByOutput(GT_ModHandler.getModItem("chisel", "obsidianChisel", 1L));
        removeRecipeByOutput(GT_ModHandler.getModItem("chisel", "valentines", 1L));
        removeRecipeByOutput(GT_ModHandler.getModItem("chisel", "cloudinabottle", 1L));
        removeRecipeByOutput(GT_ModHandler.getModItem("chisel", "smashingrock", 1L));
        removeRecipeByOutput(GT_ModHandler.getModItem("chisel", "autoChisel", 1L));
        removeRecipeByOutput(GT_ModHandler.getModItem("chisel", "upgrade", 1L));
        removeRecipeByOutput(GT_ModHandler.getModItem("chisel", "upgrade", 1L, 1));
        removeRecipeByOutput(GT_ModHandler.getModItem("chisel", "upgrade", 1L, 2));
        removeRecipeByOutput(GT_ModHandler.getModItem("chisel", "factoryblock", 1L));
        removeRecipeByOutput(GT_ModHandler.getModItem("chisel", "fantasyblock", 1L));
        removeRecipeByOutput(GT_ModHandler.getModItem("chisel", "tyrian", 1L));
        removeRecipeByOutput(GT_ModHandler.getModItem("chisel", "road_line", 1L));
        removeRecipeByOutput(GT_ModHandler.getModItem("chisel", "technical", 1L));
        removeRecipeByOutput(GT_ModHandler.getModItem("chisel", "hexPlating", 1L));
        removeRecipeByOutput(GT_ModHandler.getModItem("chisel", "holystone", 1L));
        removeRecipeByOutput(GT_ModHandler.getModItem("chisel", "laboratoryblock", 1L));
        removeRecipeByOutput(GT_ModHandler.getModItem("chisel", "rebel", 1L));
        removeRecipeByOutput(GT_ModHandler.getModItem("chisel", "voidstone", 1L));
        removeRecipeByOutput(GT_ModHandler.getModItem("chisel", "paperwall_block", 1L));
        removeRecipeByOutput(GT_ModHandler.getModItem("chisel", "warningSign", 1L));
    }

    private void handRecipe() {
        // --- Iron Chisel
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("chisel", "chisel", 1L), tBitMask, new Object[]{"fI ", "SOI", 'S', "stickWood", 'O', "ingotIron", 'I', "stickLongIron"});
        // --- Diamond Chisel
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("chisel", "diamondChisel", 1L), tBitMask, new Object[]{"fI ", "SOI", 'S', "stickWood", 'O', "gemDiamond", 'I', "stickLongSteel"});
        // --- Obsidian Chisel
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("chisel", "obsidianChisel", 1L), tBitMask, new Object[]{"fI ", "SOI", 'S', "stickWood", 'O', "ingotObsidian", 'I', "stickLongBlackSteel"});
        // --- Auto Chisel
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("chisel", "autoChisel", 1L), tBitMask, new Object[]{"SOS", "CUR", "dYh", 'S', "screwSteel", 'O', "ringWoodSealed", 'C', ItemList.Conveyor_Module_LV, 'U', ItemList.Cover_Crafting, 'R', ItemList.Robot_Arm_LV, 'Y', GT_ModHandler.getModItem("chestup", "Blockchestup", 1L, 1)});
        // --- Speed Upgrade
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("chisel", "upgrade", 1L), tBitMask, new Object[]{"SPS", "PCP", "WOW", 'S', "screwSteel", 'P', "plateEmerald", 'C', "circuitAdvanced", 'W', "wireGt01RedAlloy", 'O', ItemList.Conveyor_Module_LV});
        // --- Automation Upgrade
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("chisel", "upgrade", 1L, 1), tBitMask, new Object[]{"SPS", "PCP", "WOW", 'S', "screwSteel", 'P', "plateEmerald", 'C', "circuitAdvanced", 'W', "wireGt01RedAlloy", 'O', ItemList.Robot_Arm_LV});
        // --- Stack Upgrade
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("chisel", "upgrade", 1L, 2), tBitMask, new Object[]{"SPS", "PCP", "WOW", 'S', "screwSteel", 'P', "plateEmerald", 'C', "circuitAdvanced", 'W', "wireGt01RedAlloy", 'O', ItemList.Cover_Crafting});
        // --- Factory Block
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("chisel", "factoryblock", 32L), tBitMask, new Object[]{"SFS", "F F", "SFS", 'S', "stone", 'F', "frameGtIron"});
        // --- Fantasy Block
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("chisel", "fantasyblock", 8L), tBitMask, new Object[]{"SSS", "SFS", "SSS", 'S', "stone", 'F', "frameGtGold"});
        // --- Tyrian Block
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("chisel", "tyrian", 8L), tBitMask, new Object[]{"SSS", "SFS", "SSS", 'S', "stone", 'F', "frameGtIron"});
        // --- Road Line
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("chisel", "road_line", 2L), tBitMask, new Object[]{"Cs", 'C', GT_ModHandler.getModItem("minecraft", "carpet", 1L)});
        // --- Technical Block
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("chisel", "technical", 32L), tBitMask, new Object[]{"SFS", "FSF", "SFS", 'S', "stone", 'F', "frameGtIron"});
        // --- Hex Plating Block
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("chisel", "hexPlating", 8L), tBitMask, new Object[]{"SSS", "SFS", "SSS", 'S', "stone", 'F', "frameGtCarbon"});
        // --- Holystone Block
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("chisel", "holystone", 8L), tBitMask, new Object[]{"SSS", "SDS", "SSS", 'S', "stone", 'D', "dustGlass"});
        // --- Laboratory Block
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("chisel", "laboratoryblock", 8L), tBitMask, new Object[]{"SSS", "SGS", "SSS", 'S', "stone", 'G', "craftingQuartz"});
        // --- Rebellious Block
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("chisel", "rebel", 8L), tBitMask, new Object[]{"SSS", "SFS", "SSS", 'S', "stone", 'F', "frameGtWroughtIron"});
        // --- Voidstone
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("chisel", "voidstone", 8L), tBitMask, new Object[]{"SSS", "SDS", "SSS", 'S', "stone", 'D', "dustObsidian"});
        // --- Paperwall Block
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("chisel", "paperwall_block", 8L), tBitMask, new Object[]{"SSS", "SFS", "SSS", 'S', GT_ModHandler.getModItem("chisel", "paperwall", 1L, GT_Values.W), 'F', "frameGtWood"});
        // --- Warning Sign
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("chisel", "warningSign", 8L), tBitMask, new Object[]{"SSS", "SFS", "SSS", 'S', "stone", 'F', GT_ModHandler.getModItem("minecraft", "sign", 1L)});

    }

    private void alloySmelter() {
        // --- Anti Block
        RA.addAlloySmelterRecipe(new ItemStack(Blocks.stone, 8), new ItemStack(Items.glowstone_dust, 1),
                GT_ModHandler.getModItem("chisel", "antiBlock", 16L, 15), 100, 8);
        RA.addAlloySmelterRecipe(GT_ModHandler.getModItem("gregtech", "gt.blockconcretes", 8L, 8),
                new ItemStack(Items.glowstone_dust, 1),
                GT_ModHandler.getModItem("chisel", "antiBlock", 32L, 15), 100, 8);
        // --- Futura Block
        RA.addAlloySmelterRecipe(new ItemStack(Blocks.stone, 8), new ItemStack(Items.redstone, 1),
                GT_ModHandler.getModItem("chisel", "futura", 16L), 100, 8);
        RA.addAlloySmelterRecipe(GT_ModHandler.getModItem("gregtech", "gt.blockconcretes", 8L, 8),
                new ItemStack(Items.redstone, 1),
                GT_ModHandler.getModItem("chisel", "futura", 32L), 100, 8);
        RA.addAlloySmelterRecipe(new ItemStack(Blocks.stone, 8),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.RedAlloy, 1),
                GT_ModHandler.getModItem("chisel", "futura", 32L), 100, 8);
        RA.addAlloySmelterRecipe(GT_ModHandler.getModItem("gregtech", "gt.blockconcretes", 8L, 8),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.RedAlloy, 1),
                GT_ModHandler.getModItem("chisel", "futura", 64L), 100, 8);
        // --- Grimstone
        RA.addAlloySmelterRecipe(new ItemStack(Blocks.stone, 8),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Coal, 1),
                GT_ModHandler.getModItem("chisel", "grimstone", 16L), 100, 8);
        RA.addAlloySmelterRecipe(GT_ModHandler.getModItem("gregtech", "gt.blockconcretes", 8L, 8),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Coal, 1),
                GT_ModHandler.getModItem("chisel", "grimstone", 32L), 100, 8);
        RA.addAlloySmelterRecipe(new ItemStack(Blocks.stone, 8),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Charcoal, 1),
                GT_ModHandler.getModItem("chisel", "grimstone", 16L), 100, 8);
        RA.addAlloySmelterRecipe(GT_ModHandler.getModItem("gregtech", "gt.blockconcretes", 8L, 8),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Charcoal, 1),
                GT_ModHandler.getModItem("chisel", "grimstone", 32L), 100, 8);
        RA.addAlloySmelterRecipe(new ItemStack(Blocks.stone, 8),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Ash, 1),
                GT_ModHandler.getModItem("chisel", "grimstone", 32L), 100, 8);
        RA.addAlloySmelterRecipe(GT_ModHandler.getModItem("gregtech", "gt.blockconcretes", 8L, 8),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Ash, 1),
                GT_ModHandler.getModItem("chisel", "grimstone", 64L), 100, 8);
        RA.addAlloySmelterRecipe(new ItemStack(Blocks.stone, 8),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.DarkAsh, 1),
                GT_ModHandler.getModItem("chisel", "grimstone", 32L), 100, 8);
        RA.addAlloySmelterRecipe(GT_ModHandler.getModItem("gregtech", "gt.blockconcretes", 8L, 8),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.DarkAsh, 1),
                GT_ModHandler.getModItem("chisel", "grimstone", 64L), 100, 8);
        // --- Holystone
        RA.addAlloySmelterRecipe(new ItemStack(Blocks.stone, 8),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Glass, 1),
                GT_ModHandler.getModItem("chisel", "holystone", 16L), 100, 8);
        RA.addAlloySmelterRecipe(GT_ModHandler.getModItem("gregtech", "gt.blockconcretes", 8L, 8),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Glass, 1),
                GT_ModHandler.getModItem("chisel", "holystone", 32L), 100, 8);
        RA.addAlloySmelterRecipe(new ItemStack(Blocks.stone, 8),
                CoreItems.getRecipe(33, 1),
                GT_ModHandler.getModItem("chisel", "holystone", 32L), 100, 8);
        RA.addAlloySmelterRecipe(GT_ModHandler.getModItem("gregtech", "gt.blockconcretes", 8L, 8),
                CoreItems.getRecipe(33, 1),
                GT_ModHandler.getModItem("chisel", "holystone", 64L), 100, 8);
        // --- Laboratory Block
        RA.addAlloySmelterRecipe(new ItemStack(Blocks.stone, 8),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.CertusQuartz, 1),
                GT_ModHandler.getModItem("chisel", "laboratoryblock", 16L), 100, 8);
        RA.addAlloySmelterRecipe(new ItemStack(Blocks.stone, 8),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.NetherQuartz, 1),
                GT_ModHandler.getModItem("chisel", "laboratoryblock", 16L), 100, 8);
        RA.addAlloySmelterRecipe(new ItemStack(Blocks.stone, 8),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Quartzite, 1),
                GT_ModHandler.getModItem("chisel", "laboratoryblock", 16L), 100, 8);
        RA.addAlloySmelterRecipe(GT_ModHandler.getModItem("gregtech", "gt.blockconcretes", 8L, 8),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.CertusQuartz, 1),
                GT_ModHandler.getModItem("chisel", "laboratoryblock", 32L), 100, 8);
        RA.addAlloySmelterRecipe(GT_ModHandler.getModItem("gregtech", "gt.blockconcretes", 8L, 8),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.NetherQuartz, 1),
                GT_ModHandler.getModItem("chisel", "laboratoryblock", 32L), 100, 8);
        RA.addAlloySmelterRecipe(GT_ModHandler.getModItem("gregtech", "gt.blockconcretes", 8L, 8),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Quartzite, 1),
                GT_ModHandler.getModItem("chisel", "laboratoryblock", 32L), 100, 8);
        RA.addAlloySmelterRecipe(new ItemStack(Blocks.stone, 8),
                CoreItems.getRecipe(38, 1),
                GT_ModHandler.getModItem("chisel", "laboratoryblock", 32L), 100, 8);
        RA.addAlloySmelterRecipe(GT_ModHandler.getModItem("gregtech", "gt.blockconcretes", 8L, 8),
                CoreItems.getRecipe(38, 1),
                GT_ModHandler.getModItem("chisel", "laboratoryblock", 64L), 100, 8);
        // --- Templeblock
        RA.addAlloySmelterRecipe(new ItemStack(Blocks.stone, 8),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Lazurite, 1),
                GT_ModHandler.getModItem("chisel", "templeblock", 16L), 100, 8);
        RA.addAlloySmelterRecipe(new ItemStack(Blocks.stone, 8),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Lapis, 1),
                GT_ModHandler.getModItem("chisel", "templeblock", 16L), 100, 8);
        RA.addAlloySmelterRecipe(new ItemStack(Blocks.stone, 8),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Sodalite, 1),
                GT_ModHandler.getModItem("chisel", "templeblock", 16L), 100, 8);
        RA.addAlloySmelterRecipe(GT_ModHandler.getModItem("gregtech", "gt.blockconcretes", 8L, 8),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Lazurite, 1),
                GT_ModHandler.getModItem("chisel", "templeblock", 32L), 100, 8);
        RA.addAlloySmelterRecipe(GT_ModHandler.getModItem("gregtech", "gt.blockconcretes", 8L, 8),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Lapis, 1),
                GT_ModHandler.getModItem("chisel", "templeblock", 32L), 100, 8);
        RA.addAlloySmelterRecipe(GT_ModHandler.getModItem("gregtech", "gt.blockconcretes", 8L, 8),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Sodalite, 1),
                GT_ModHandler.getModItem("chisel", "templeblock", 32L), 100, 8);
        RA.addAlloySmelterRecipe(new ItemStack(Blocks.stone, 8),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Cobalt, 1),
                GT_ModHandler.getModItem("chisel", "templeblock", 32L), 100, 8);
        RA.addAlloySmelterRecipe(GT_ModHandler.getModItem("gregtech", "gt.blockconcretes", 8L, 8),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Cobalt, 1),
                GT_ModHandler.getModItem("chisel", "templeblock", 64L), 100, 8);
        // --- Voidtone
        RA.addAlloySmelterRecipe(new ItemStack(Blocks.stone, 8),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Obsidian, 1),
                GT_ModHandler.getModItem("chisel", "voidstone", 16L), 100, 8);
        RA.addAlloySmelterRecipe(GT_ModHandler.getModItem("gregtech", "gt.blockconcretes", 8L, 8),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Obsidian, 1),
                GT_ModHandler.getModItem("chisel", "voidstone", 32L), 100, 8);
        RA.addAlloySmelterRecipe(new ItemStack(Blocks.stone, 8),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.BlackBronze, 1),
                GT_ModHandler.getModItem("chisel", "voidstone", 32L), 100, 8);
        RA.addAlloySmelterRecipe(GT_ModHandler.getModItem("gregtech", "gt.blockconcretes", 8L, 8),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.BlackBronze, 1),
                GT_ModHandler.getModItem("chisel", "voidstone", 64L), 100, 8);

    }

    private void assembler() {
        // --- Carpet
        for (int i = 0; i < 16; i++) {
            RA.addAssemblerRecipe(new ItemStack[]{
                            new ItemStack(Blocks.wool, 8, i),
                            new ItemStack(Items.string, 1),
                            GT_Utility.getIntegratedCircuit(8)}, null,
                    GT_ModHandler.getModItem("chisel", "carpet_block", 16L, i), 100, 8);
        }
        // --- Factory Block
        RA.addAssemblerRecipe(new ItemStack[]{
                        new ItemStack(Blocks.stone, 1),
                        GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Iron, 1),
                        GT_Utility.getIntegratedCircuit(8)}, null,
                GT_ModHandler.getModItem("chisel", "factoryblock", 8L), 100, 8);
        RA.addAssemblerRecipe(new ItemStack[]{
                        GT_ModHandler.getModItem("gregtech", "gt.blockconcretes", 1L, 8),
                        GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Iron, 1),
                        GT_Utility.getIntegratedCircuit(8)}, null,
                GT_ModHandler.getModItem("chisel", "factoryblock", 16L), 100, 8);
        RA.addAssemblerRecipe(new ItemStack[]{
                        new ItemStack(Blocks.stone, 1),
                        GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Steel, 1),
                        GT_Utility.getIntegratedCircuit(8)}, null,
                GT_ModHandler.getModItem("chisel", "factoryblock", 16L), 100, 8);
        RA.addAssemblerRecipe(new ItemStack[]{
                        GT_ModHandler.getModItem("gregtech", "gt.blockconcretes", 1L, 8),
                        GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Steel, 1),
                        GT_Utility.getIntegratedCircuit(8)}, null,
                GT_ModHandler.getModItem("chisel", "factoryblock", 32L), 100, 8);
        RA.addAssemblerRecipe(new ItemStack[]{
                        new ItemStack(Blocks.stone, 1),
                        GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Aluminium, 1),
                        GT_Utility.getIntegratedCircuit(8)}, null,
                GT_ModHandler.getModItem("chisel", "factoryblock", 32L), 100, 8);
        RA.addAssemblerRecipe(new ItemStack[]{
                        GT_ModHandler.getModItem("gregtech", "gt.blockconcretes", 1L, 8),
                        GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Aluminium, 1),
                        GT_Utility.getIntegratedCircuit(8)}, null,
                GT_ModHandler.getModItem("chisel", "factoryblock", 64L), 100, 8);
        // --- Fantasy Block
        RA.addAssemblerRecipe(new ItemStack[]{
                        new ItemStack(Blocks.stone, 8),
                        GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Gold, 1),
                        GT_Utility.getIntegratedCircuit(8)}, null,
                GT_ModHandler.getModItem("chisel", "fantasyblock", 8L), 100, 8);
        RA.addAssemblerRecipe(new ItemStack[]{
                        GT_ModHandler.getModItem("gregtech", "gt.blockconcretes", 8L, 8),
                        GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Gold, 1),
                        GT_Utility.getIntegratedCircuit(8)}, null,
                GT_ModHandler.getModItem("chisel", "fantasyblock", 16L), 100, 8);
        RA.addAssemblerRecipe(new ItemStack[]{
                        new ItemStack(Blocks.stone, 8),
                        GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Electrum, 1),
                        GT_Utility.getIntegratedCircuit(8)}, null,
                GT_ModHandler.getModItem("chisel", "fantasyblock", 16L), 100, 8);
        RA.addAssemblerRecipe(new ItemStack[]{
                        GT_ModHandler.getModItem("gregtech", "gt.blockconcretes", 8L, 8),
                        GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Electrum, 1),
                        GT_Utility.getIntegratedCircuit(8)}, null,
                GT_ModHandler.getModItem("chisel", "fantasyblock", 32L), 100, 8);
        RA.addAssemblerRecipe(new ItemStack[]{
                        new ItemStack(Blocks.stone, 8),
                        GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.RoseGold, 1),
                        GT_Utility.getIntegratedCircuit(8)}, null,
                GT_ModHandler.getModItem("chisel", "fantasyblock", 32L), 100, 8);
        RA.addAssemblerRecipe(new ItemStack[]{
                        GT_ModHandler.getModItem("gregtech", "gt.blockconcretes", 8L, 8),
                        GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.RoseGold, 1),
                        GT_Utility.getIntegratedCircuit(8)}, null,
                GT_ModHandler.getModItem("chisel", "fantasyblock", 64L), 100, 8);
        // --- Hex Plating
        RA.addAssemblerRecipe(new ItemStack[]{
                        new ItemStack(Blocks.stone, 8),
                        GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Carbon, 1),
                        GT_Utility.getIntegratedCircuit(8)}, null,
                GT_ModHandler.getModItem("chisel", "hexPlating", 8L), 100, 8);
        RA.addAssemblerRecipe(new ItemStack[]{
                        GT_ModHandler.getModItem("gregtech", "gt.blockconcretes", 8L, 8),
                        GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Carbon, 1),
                        GT_Utility.getIntegratedCircuit(8)}, null,
                GT_ModHandler.getModItem("chisel", "hexPlating", 16L), 100, 8);
        RA.addAssemblerRecipe(new ItemStack[]{
                        new ItemStack(Blocks.stone, 8),
                        GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Silicon, 1),
                        GT_Utility.getIntegratedCircuit(8)}, null,
                GT_ModHandler.getModItem("chisel", "hexPlating", 16L), 100, 8);
        RA.addAssemblerRecipe(new ItemStack[]{
                        GT_ModHandler.getModItem("gregtech", "gt.blockconcretes", 8L, 8),
                        GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Silicon, 1),
                        GT_Utility.getIntegratedCircuit(8)}, null,
                GT_ModHandler.getModItem("chisel", "hexPlating", 32L), 100, 8);
        RA.addAssemblerRecipe(new ItemStack[]{
                        new ItemStack(Blocks.stone, 8),
                        GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Rubber, 1),
                        GT_Utility.getIntegratedCircuit(8)}, null,
                GT_ModHandler.getModItem("chisel", "hexPlating", 32L), 100, 8);
        RA.addAssemblerRecipe(new ItemStack[]{
                        GT_ModHandler.getModItem("gregtech", "gt.blockconcretes", 8L, 8),
                        GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Rubber, 1),
                        GT_Utility.getIntegratedCircuit(8)}, null,
                GT_ModHandler.getModItem("chisel", "hexPlating", 64L), 100, 8);
        // --- Rebellious Block
        RA.addAssemblerRecipe(new ItemStack[]{
                        new ItemStack(Blocks.stone, 8),
                        GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.WroughtIron, 1),
                        GT_Utility.getIntegratedCircuit(8)}, null,
                GT_ModHandler.getModItem("chisel", "rebel", 8L), 100, 8);
        RA.addAssemblerRecipe(new ItemStack[]{
                        GT_ModHandler.getModItem("gregtech", "gt.blockconcretes", 8L, 8),
                        GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.WroughtIron, 1),
                        GT_Utility.getIntegratedCircuit(8)}, null,
                GT_ModHandler.getModItem("chisel", "rebel", 16L), 100, 8);
        RA.addAssemblerRecipe(new ItemStack[]{
                        new ItemStack(Blocks.stone, 8),
                        GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Nickel, 1),
                        GT_Utility.getIntegratedCircuit(8)}, null,
                GT_ModHandler.getModItem("chisel", "rebel", 16L), 100, 8);
        RA.addAssemblerRecipe(new ItemStack[]{
                        GT_ModHandler.getModItem("gregtech", "gt.blockconcretes", 8L, 8),
                        GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Nickel, 1),
                        GT_Utility.getIntegratedCircuit(8)}, null,
                GT_ModHandler.getModItem("chisel", "rebel", 32L), 100, 8);
        RA.addAssemblerRecipe(new ItemStack[]{
                        new ItemStack(Blocks.stone, 8),
                        GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Nicrofer, 1),
                        GT_Utility.getIntegratedCircuit(8)}, null,
                GT_ModHandler.getModItem("chisel", "rebel", 32L), 100, 8);
        RA.addAssemblerRecipe(new ItemStack[]{
                        GT_ModHandler.getModItem("gregtech", "gt.blockconcretes", 8L, 8),
                        GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Nicrofer, 1),
                        GT_Utility.getIntegratedCircuit(8)}, null,
                GT_ModHandler.getModItem("chisel", "rebel", 64L), 100, 8);
        // --- Paperwall
        RA.addAssemblerRecipe(new ItemStack[]{
                        new ItemStack(Items.paper, 8),
                        GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 1),
                        GT_Utility.getIntegratedCircuit(10)}, null,
                GT_ModHandler.getModItem("chisel", "paperwall", 8L), 100, 8);
        RA.addAssemblerRecipe(new ItemStack[]{
                        new ItemStack(Items.paper, 8),
                        GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 1),
                        GT_Utility.getIntegratedCircuit(11)}, Materials.Iron.getMolten(16),
                GT_ModHandler.getModItem("chisel", "paperwall", 16L), 100, 8);
        RA.addAssemblerRecipe(new ItemStack[]{
                        new ItemStack(Items.paper, 8),
                        GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 1),
                        GT_Utility.getIntegratedCircuit(11)}, Materials.Steel.getMolten(16),
                GT_ModHandler.getModItem("chisel", "paperwall", 32L), 100, 8);
        RA.addAssemblerRecipe(new ItemStack[]{
                        new ItemStack(Items.paper, 8),
                        GT_OreDictUnificator.get(OrePrefixes.stick, Materials.WoodSealed, 1),
                        GT_Utility.getIntegratedCircuit(10)}, null,
                GT_ModHandler.getModItem("chisel", "paperwall", 16L), 100, 8);
        RA.addAssemblerRecipe(new ItemStack[]{
                        new ItemStack(Items.paper, 8),
                        GT_OreDictUnificator.get(OrePrefixes.stick, Materials.WoodSealed, 1),
                        GT_Utility.getIntegratedCircuit(11)}, Materials.Iron.getMolten(16),
                GT_ModHandler.getModItem("chisel", "paperwall", 32L), 100, 8);
        RA.addAssemblerRecipe(new ItemStack[]{
                        new ItemStack(Items.paper, 8),
                        GT_OreDictUnificator.get(OrePrefixes.stick, Materials.WoodSealed, 1),
                        GT_Utility.getIntegratedCircuit(11)}, Materials.Steel.getMolten(16),
                GT_ModHandler.getModItem("chisel", "paperwall", 64L), 100, 8);
        // --- Paperwall Block
        RA.addAssemblerRecipe(new ItemStack[]{
                        GT_ModHandler.getModItem("chisel", "paperwall", 8L, GT_Values.W),
                        GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Wood, 1),
                        GT_Utility.getIntegratedCircuit(8)}, null,
                GT_ModHandler.getModItem("chisel", "paperwall_block", 8L), 100, 8);
        RA.addAssemblerRecipe(new ItemStack[]{
                        GT_ModHandler.getModItem("chisel", "paperwall", 8L, GT_Values.W),
                        GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.WoodSealed, 1),
                        GT_Utility.getIntegratedCircuit(8)}, null,
                GT_ModHandler.getModItem("chisel", "paperwall_block", 16L), 100, 8);
        // --- Technical Block
        RA.addAssemblerRecipe(new ItemStack[]{
                        new ItemStack(Blocks.stone, 1),
                        GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Iron, 1),
                        GT_Utility.getIntegratedCircuit(5)}, null,
                GT_ModHandler.getModItem("chisel", "technical", 8L), 100, 8);
        RA.addAssemblerRecipe(new ItemStack[]{
                        GT_ModHandler.getModItem("gregtech", "gt.blockconcretes", 1L, 8),
                        GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Iron, 1),
                        GT_Utility.getIntegratedCircuit(5)}, null,
                GT_ModHandler.getModItem("chisel", "technical", 16L), 100, 8);
        RA.addAssemblerRecipe(new ItemStack[]{
                        new ItemStack(Blocks.stone, 1),
                        GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Steel, 1),
                        GT_Utility.getIntegratedCircuit(5)}, null,
                GT_ModHandler.getModItem("chisel", "technical", 16L), 100, 8);
        RA.addAssemblerRecipe(new ItemStack[]{
                        GT_ModHandler.getModItem("gregtech", "gt.blockconcretes", 1L, 8),
                        GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Steel, 1),
                        GT_Utility.getIntegratedCircuit(5)}, null,
                GT_ModHandler.getModItem("chisel", "technical", 32L), 100, 8);
        RA.addAssemblerRecipe(new ItemStack[]{
                        new ItemStack(Blocks.stone, 1),
                        GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Aluminium, 1),
                        GT_Utility.getIntegratedCircuit(5)}, null,
                GT_ModHandler.getModItem("chisel", "technical", 32L), 100, 8);
        RA.addAssemblerRecipe(new ItemStack[]{
                        GT_ModHandler.getModItem("gregtech", "gt.blockconcretes", 1L, 8),
                        GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Aluminium, 1),
                        GT_Utility.getIntegratedCircuit(5)}, null,
                GT_ModHandler.getModItem("chisel", "technical", 64L), 100, 8);
        // --- Tyrian Block
        RA.addAssemblerRecipe(new ItemStack[]{
                        new ItemStack(Blocks.stone, 8),
                        GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Iron, 1),
                        GT_Utility.getIntegratedCircuit(6)}, null,
                GT_ModHandler.getModItem("chisel", "tyrian", 8L), 100, 8);
        RA.addAssemblerRecipe(new ItemStack[]{
                        GT_ModHandler.getModItem("gregtech", "gt.blockconcretes", 8L, 8),
                        GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Iron, 1),
                        GT_Utility.getIntegratedCircuit(6)}, null,
                GT_ModHandler.getModItem("chisel", "tyrian", 16L), 100, 8);
        RA.addAssemblerRecipe(new ItemStack[]{
                        new ItemStack(Blocks.stone, 8),
                        GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Steel, 1),
                        GT_Utility.getIntegratedCircuit(6)}, null,
                GT_ModHandler.getModItem("chisel", "tyrian", 16L), 100, 8);
        RA.addAssemblerRecipe(new ItemStack[]{
                        GT_ModHandler.getModItem("gregtech", "gt.blockconcretes", 8L, 8),
                        GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Steel, 1),
                        GT_Utility.getIntegratedCircuit(6)}, null,
                GT_ModHandler.getModItem("chisel", "tyrian", 32L), 100, 8);
        RA.addAssemblerRecipe(new ItemStack[]{
                        new ItemStack(Blocks.stone, 8),
                        GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Aluminium, 1),
                        GT_Utility.getIntegratedCircuit(6)}, null,
                GT_ModHandler.getModItem("chisel", "tyrian", 32L), 100, 8);
        RA.addAssemblerRecipe(new ItemStack[]{
                        GT_ModHandler.getModItem("gregtech", "gt.blockconcretes", 8L, 8),
                        GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Aluminium, 1),
                        GT_Utility.getIntegratedCircuit(6)}, null,
                GT_ModHandler.getModItem("chisel", "tyrian", 64L), 100, 8);
        // --- Warning Sign
        RA.addAssemblerRecipe(new ItemStack[]{
                        new ItemStack(Blocks.stone, 8),
                        GT_ModHandler.getModItem("minecraft", "sign", 1L),
                        GT_Utility.getIntegratedCircuit(8)}, null,
                GT_ModHandler.getModItem("chisel", "warningSign", 8L), 100, 8);
        RA.addAssemblerRecipe(new ItemStack[]{
                        GT_ModHandler.getModItem("gregtech", "gt.blockconcretes", 8L, 8),
                        GT_ModHandler.getModItem("minecraft", "sign", 1L),
                        GT_Utility.getIntegratedCircuit(8)}, null,
                GT_ModHandler.getModItem("chisel", "warningSign", 16L), 100, 8);

    }

    private void cutting() {
        RA.addCutterRecipe(new ItemStack(Blocks.carpet, 1), GT_ModHandler.getModItem("chisel", "road_line", 4L), GT_Values.NI, 50, 8);
    }

    private void fluidSolidifier() {
        // --- Lavastone
        RA.addFluidSolidifierRecipe(new ItemStack(Blocks.stone, 8),
                Materials.Lava.getFluid(1000L),
                GT_ModHandler.getModItem("chisel", "lavastone", 16L), 200, 2);
        RA.addFluidSolidifierRecipe(GT_ModHandler.getModItem("gregtech", "gt.blockconcretes", 8L, 8),
                Materials.Lava.getFluid(1000L),
                GT_ModHandler.getModItem("chisel", "lavastone", 32L), 200, 2);
        // --- Waterstone
        RA.addFluidSolidifierRecipe(new ItemStack(Blocks.stone, 8),
                Materials.Water.getFluid(1000L),
                GT_ModHandler.getModItem("chisel", "waterstone", 16L), 200, 2);
        RA.addFluidSolidifierRecipe(GT_ModHandler.getModItem("gregtech", "gt.blockconcretes", 8L, 8),
                Materials.Water.getFluid(1000L),
                GT_ModHandler.getModItem("chisel", "waterstone", 32L), 200, 2);
    }
}
