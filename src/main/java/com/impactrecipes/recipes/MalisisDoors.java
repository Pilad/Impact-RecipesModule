package com.impactrecipes.recipes;

import com.impact.common.item.Core_Items;
import com.impact.common.item.Core_Items2;
import gregtech.api.enums.GT_Values;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.util.GT_ModHandler;
import gregtech.api.util.GT_OreDictUnificator;
import gregtech.api.util.GT_Utility;
import net.minecraft.item.ItemStack;

import static com.impact.common.item.Core_List_Items.SteelBars;
import static gregtech.api.enums.GT_Values.RA;
import static gregtech.api.util.GT_ModHandler.removeRecipeByOutput;

public class MalisisDoors implements Runnable {

    private static final long tBitMask = GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE;

    final Core_Items2 CoreItems2 = Core_Items2.getInstance();

    @Override
    public void run() {
        removeMalisisDoors();
        hand();
        assembler();
    }

    private void removeMalisisDoors() {
        removeRecipeByOutput(GT_ModHandler.getModItem("malisisdoors", "iron_trapdoor", 1L, 0), true,
                false, false);
        removeRecipeByOutput(GT_ModHandler.getModItem("malisisdoors", "sliding_trapdoor", 1L, 0), true,
                false, false);
        removeRecipeByOutput(GT_ModHandler.getModItem("malisisdoors", "player_sensor", 1L, 0), true,
                false, false);
        removeRecipeByOutput(GT_ModHandler.getModItem("malisisdoors", "vanishing_block", 1L, 0), true,
                false, false);
        removeRecipeByOutput(GT_ModHandler.getModItem("malisisdoors", "vanishing_block", 1L, 1), true,
                false, false);
        removeRecipeByOutput(GT_ModHandler.getModItem("malisisdoors", "vanishing_block", 1L, 2), true,
                false, false);
        removeRecipeByOutput(GT_ModHandler.getModItem("malisisdoors", "vanishing_block", 1L, 3), true,
                false, false);
        removeRecipeByOutput(GT_ModHandler.getModItem("malisisdoors", "block_mixer", 1L, 0), true,
                false, false);
        removeRecipeByOutput(GT_ModHandler.getModItem("malisisdoors", "door_factory", 1L, 0), true,
                false, false);
        removeRecipeByOutput(GT_ModHandler.getModItem("malisisdoors", "rustyHatch", 1L, 0), true, false,
                false);
        removeRecipeByOutput(GT_ModHandler.getModItem("malisisdoors", "garage_door", 1L, 0), true,
                false, false);
        removeRecipeByOutput(GT_ModHandler.getModItem("malisisdoors", "item.rustyHandle", 1L, 0), true,
                false, false);
        removeRecipeByOutput(GT_ModHandler.getModItem("malisisdoors", "rustyLadder", 1L, 0), true,
                false, false);
        removeRecipeByOutput(GT_ModHandler.getModItem("malisisdoors", "item.door_acacia", 1L, 0), true,
                false, false);
        removeRecipeByOutput(GT_ModHandler.getModItem("malisisdoors", "item.door_birch", 1L, 0), true,
                false, false);
        removeRecipeByOutput(GT_ModHandler.getModItem("malisisdoors", "item.door_dark_oak", 1L, 0),
                true, false, false);
        removeRecipeByOutput(GT_ModHandler.getModItem("malisisdoors", "item.door_jungle", 1L, 0), true,
                false, false);
        removeRecipeByOutput(GT_ModHandler.getModItem("malisisdoors", "item.door_spruce", 1L, 0), true,
                false, false);
        removeRecipeByOutput(GT_ModHandler.getModItem("malisisdoors", "item.wood_sliding_door", 1L, 0),
                true, false, false);
        removeRecipeByOutput(GT_ModHandler.getModItem("malisisdoors", "item.iron_sliding_door", 1L, 0),
                true, false, false);
        removeRecipeByOutput(GT_ModHandler.getModItem("malisisdoors", "item.jail_door", 1L, 0), true,
                false, false);
        removeRecipeByOutput(GT_ModHandler.getModItem("malisisdoors", "item.laboratory_door", 1L, 0),
                true, false, false);
        removeRecipeByOutput(GT_ModHandler.getModItem("malisisdoors", "item.factory_door", 1L, 0), true,
                false, false);
        removeRecipeByOutput(GT_ModHandler.getModItem("malisisdoors", "item.shoji_door", 1L, 0), true,
                false, false);
        removeRecipeByOutput(GT_ModHandler.getModItem("malisisdoors", "item.curtain_purple", 1L, 0),
                true, false, false);
        removeRecipeByOutput(GT_ModHandler.getModItem("malisisdoors", "item.curtain_yellow", 1L, 0),
                true, false, false);
        removeRecipeByOutput(GT_ModHandler.getModItem("malisisdoors", "item.curtain_magenta", 1L, 0),
                true, false, false);
        removeRecipeByOutput(GT_ModHandler.getModItem("malisisdoors", "item.curtain_pink", 1L, 0), true,
                false, false);
        removeRecipeByOutput(GT_ModHandler.getModItem("malisisdoors", "item.curtain_white", 1L, 0),
                true, false, false);
        removeRecipeByOutput(GT_ModHandler.getModItem("malisisdoors", "item.curtain_blue", 1L, 0), true,
                false, false);
        removeRecipeByOutput(GT_ModHandler.getModItem("malisisdoors", "item.curtain_gray", 1L, 0), true,
                false, false);
        removeRecipeByOutput(GT_ModHandler.getModItem("malisisdoors", "item.curtain_cyan", 1L, 0), true,
                false, false);
        removeRecipeByOutput(GT_ModHandler.getModItem("malisisdoors", "item.curtain_red", 1L, 0), true,
                false, false);
        removeRecipeByOutput(GT_ModHandler.getModItem("malisisdoors", "item.curtain_brown", 1L, 0),
                true, false, false);
        removeRecipeByOutput(GT_ModHandler.getModItem("malisisdoors", "item.curtain_lime", 1L, 0), true,
                false, false);
        removeRecipeByOutput(GT_ModHandler.getModItem("malisisdoors", "item.curtain_orange", 1L, 0),
                true, false, false);
        removeRecipeByOutput(GT_ModHandler.getModItem("malisisdoors", "item.curtain_silver", 1L, 0),
                true, false, false);
        removeRecipeByOutput(GT_ModHandler.getModItem("malisisdoors", "item.curtain_green", 1L, 0),
                true, false, false);
        removeRecipeByOutput(GT_ModHandler.getModItem("malisisdoors", "item.curtain_light_blue", 1L, 0),
                true, false, false);
        removeRecipeByOutput(GT_ModHandler.getModItem("malisisdoors", "item.curtain_black", 1L, 0),
                true, false, false);
        removeRecipeByOutput(GT_ModHandler.getModItem("malisisdoors", "item.saloon", 1L, 0), true,
                false, false);
        removeRecipeByOutput(GT_ModHandler.getModItem("malisisdoors", "item.forcefieldItem", 1L, 0),
                true, false, false);
        removeRecipeByOutput(GT_ModHandler.getModItem("malisisdoors", "acaciaFenceGate", 1L, 0), true,
                false, false);
        removeRecipeByOutput(GT_ModHandler.getModItem("malisisdoors", "birchFenceGate", 1L, 0), true,
                false, false);
        removeRecipeByOutput(GT_ModHandler.getModItem("malisisdoors", "darkOakFenceGate", 1L, 0), true,
                false, false);
        removeRecipeByOutput(GT_ModHandler.getModItem("malisisdoors", "jungleFenceGate", 1L, 0), true,
                false, false);
        removeRecipeByOutput(GT_ModHandler.getModItem("malisisdoors", "spruceFenceGate", 1L, 0), true,
                false, false);
        removeRecipeByOutput(GT_ModHandler.getModItem("malisisdoors", "trapdoor_acacia", 1L, 0), true,
                false, false);
        removeRecipeByOutput(GT_ModHandler.getModItem("malisisdoors", "trapdoor_birch", 1L, 0), true,
                false, false);
        removeRecipeByOutput(GT_ModHandler.getModItem("malisisdoors", "trapdoor_dark_oak", 1L, 0), true,
                false, false);
        removeRecipeByOutput(GT_ModHandler.getModItem("malisisdoors", "trapdoor_jungle", 1L, 0), true,
                false, false);
        removeRecipeByOutput(GT_ModHandler.getModItem("malisisdoors", "trapdoor_spruce", 1L, 0), true,
                false, false);
    }

    private void hand() {
        // --- Iron Trap Door
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("malisisdoors", "iron_trapdoor", 1L), tBitMask, new Object[]{"SPS", "PTP", "sPd", 'S', OrePrefixes.screw.get(Materials.Iron), 'P', OrePrefixes.plate.get(Materials.Iron), 'T', GT_ModHandler.getModItem("minecraft", "trapdoor", 1L)});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("malisisdoors", "iron_trapdoor", 1L), tBitMask, new Object[]{"SPS", "PTP", "sPd", 'S', OrePrefixes.screw.get(Materials.Iron), 'P', OrePrefixes.plate.get(Materials.Iron), 'T', GT_ModHandler.getModItem("malisisdoors", "trapdoor_acacia", 1L)});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("malisisdoors", "iron_trapdoor", 1L), tBitMask, new Object[]{"SPS", "PTP", "sPd", 'S', OrePrefixes.screw.get(Materials.Iron), 'P', OrePrefixes.plate.get(Materials.Iron), 'T', GT_ModHandler.getModItem("malisisdoors", "trapdoor_spruce", 1L)});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("malisisdoors", "iron_trapdoor", 1L), tBitMask, new Object[]{"SPS", "PTP", "sPd", 'S', OrePrefixes.screw.get(Materials.Iron), 'P', OrePrefixes.plate.get(Materials.Iron), 'T', GT_ModHandler.getModItem("malisisdoors", "trapdoor_birch", 1L)});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("malisisdoors", "iron_trapdoor", 1L), tBitMask, new Object[]{"SPS", "PTP", "sPd", 'S', OrePrefixes.screw.get(Materials.Iron), 'P', OrePrefixes.plate.get(Materials.Iron), 'T', GT_ModHandler.getModItem("malisisdoors", "trapdoor_jungle", 1L)});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("malisisdoors", "iron_trapdoor", 1L), tBitMask, new Object[]{"SPS", "PTP", "sPd", 'S', OrePrefixes.screw.get(Materials.Iron), 'P', OrePrefixes.plate.get(Materials.Iron), 'T', GT_ModHandler.getModItem("malisisdoors", "trapdoor_dark_oak", 1L)});
        // --- Sliding Trap Door
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("malisisdoors", "sliding_trapdoor", 1L), tBitMask, new Object[]{"S S", "PTP", "s d", 'S', OrePrefixes.screw.get(Materials.Steel), 'P', OrePrefixes.plate.get(Materials.Steel), 'T', GT_ModHandler.getModItem("malisisdoors", "iron_trapdoor", 1L)});
        // --- Player Sensor
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("malisisdoors", "player_sensor", 1L), tBitMask, new Object[]{"BRB", "hPs", 'R', OrePrefixes.plate.get(Materials.RedAlloy), 'B', GT_ModHandler.getModItem("minecraft", "stone_button", 1L), 'P', GT_ModHandler.getModItem("minecraft", "heavy_weighted_pressure_plate", 1L)});
        // --- Wooden Vanishing Frame
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("malisisdoors", "vanishing_block", 1L), tBitMask, new Object[]{"SIS", "IPI", "sId", 'S', OrePrefixes.screw.get(Materials.RedAlloy), 'I', OrePrefixes.stick.get(Materials.Wood), 'P', OrePrefixes.plate.get(Materials.EnderPearl)});
        // --- Iron Vanishing Frame
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("malisisdoors", "vanishing_block", 1L, 1), tBitMask, new Object[]{"SIS", "IPI", "sId", 'S', OrePrefixes.screw.get(Materials.RedAlloy), 'I', OrePrefixes.stick.get(Materials.Iron), 'P', OrePrefixes.plate.get(Materials.EnderPearl)});
        // --- Gold Vanishing Frame
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("malisisdoors", "vanishing_block", 1L, 2), tBitMask, new Object[]{"SIS", "IPI", "sId", 'S', OrePrefixes.screw.get(Materials.RedAlloy), 'I', OrePrefixes.stick.get(Materials.Gold), 'P', OrePrefixes.plate.get(Materials.EnderPearl)});
        // --- Diamond Vanishing Frame
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("malisisdoors", "vanishing_block", 1L, 3), tBitMask, new Object[]{"SIS", "IPI", "sId", 'S', OrePrefixes.screw.get(Materials.RedAlloy), 'I', OrePrefixes.stick.get(Materials.Diamond), 'P', OrePrefixes.plate.get(Materials.EnderPearl)});
        // --- Block Mixer
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("malisisdoors", "block_mixer", 1L), tBitMask, new Object[]{"CMC", "SOS", "GPG", 'S', OrePrefixes.springSmall.get(Materials.Iron), 'G', OrePrefixes.gearGtSmall.get(Materials.Iron), 'O', ItemList.Casing_SolidSteel, 'C', ItemList.Conveyor_Module_LV, 'M', ItemList.Electric_Motor_LV, 'P', GT_ModHandler.getModItem("minecraft", "sticky_piston", 1L)});
        // --- Door Factory
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("malisisdoors", "door_factory", 1L), tBitMask, new Object[]{"CMC", "SOS", "GPG", 'S', OrePrefixes.springSmall.get(Materials.Steel), 'G', OrePrefixes.gearGtSmall.get(Materials.Steel), 'O', ItemList.Casing_SolidSteel, 'C', ItemList.Conveyor_Module_LV, 'M', ItemList.Electric_Motor_LV, 'P', GT_ModHandler.getModItem("minecraft", "sticky_piston", 1L)});
        // --- Rusty Hatch
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("malisisdoors", "rustyHatch", 1L), tBitMask, new Object[]{"PPP", "hHw", "PPP", 'P', OrePrefixes.plate.get(Materials.Iron), 'H', GT_ModHandler.getModItem("malisisdoors", "item.rustyHandle", 1L)});
        // --- Garage Door
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("malisisdoors", "garage_door", 5L), tBitMask, new Object[]{"PRP", "RPR", "PRP", 'P', OrePrefixes.plate.get(Materials.Iron), 'R', OrePrefixes.ring.get(Materials.Steel)});
        // --- Rusty Handle
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("malisisdoors", "item.rustyHandle", 1L), tBitMask, new Object[]{"SRS", "RwR", "SRS", 'S', OrePrefixes.stick.get(Materials.Iron), 'R', OrePrefixes.ring.get(Materials.Iron)});
        // --- Rusty Ladder
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("malisisdoors", "rustyLadder", 4L), tBitMask, new Object[]{"RRR", "SwS", "RRR", 'S', OrePrefixes.screw.get(Materials.Iron), 'R', OrePrefixes.stick.get(Materials.Iron)});
        // --- Acacia Door
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("malisisdoors", "item.door_acacia", 1L), tBitMask, new Object[]{"SPP", "RPP", "dPP", 'S', OrePrefixes.screw.get(Materials.Iron), 'R', OrePrefixes.ring.get(Materials.Iron), 'P', GT_ModHandler.getModItem("minecraft", "planks", 1L, 4)});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("malisisdoors", "item.door_acacia", 1L), tBitMask, new Object[]{"SPP", "RPP", "dPP", 'S', OrePrefixes.screw.get(Materials.Copper), 'R', OrePrefixes.ring.get(Materials.Copper), 'P', GT_ModHandler.getModItem("minecraft", "planks", 1L, 4)});
        // --- Birch Door
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("malisisdoors", "item.door_birch", 1L), tBitMask, new Object[]{"SPP", "RPP", "dPP", 'S', OrePrefixes.screw.get(Materials.Iron), 'R', OrePrefixes.ring.get(Materials.Iron), 'P', GT_ModHandler.getModItem("minecraft", "planks", 1L, 2)});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("malisisdoors", "item.door_birch", 1L), tBitMask, new Object[]{"SPP", "RPP", "dPP", 'S', OrePrefixes.screw.get(Materials.Copper), 'R', OrePrefixes.ring.get(Materials.Copper), 'P', GT_ModHandler.getModItem("minecraft", "planks", 1L, 2)});
        // --- Dark Oak Door
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("malisisdoors", "item.door_dark_oak", 1L), tBitMask, new Object[]{"SPP", "RPP", "dPP", 'S', OrePrefixes.screw.get(Materials.Iron), 'R', OrePrefixes.ring.get(Materials.Iron), 'P', GT_ModHandler.getModItem("minecraft", "planks", 1L, 5)});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("malisisdoors", "item.door_dark_oak", 1L), tBitMask, new Object[]{"SPP", "RPP", "dPP", 'S', OrePrefixes.screw.get(Materials.Copper), 'R', OrePrefixes.ring.get(Materials.Copper), 'P', GT_ModHandler.getModItem("minecraft", "planks", 1L, 5)});
        // --- Jungle Door
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("malisisdoors", "item.door_jungle", 1L), tBitMask, new Object[]{"SPP", "RPP", "dPP", 'S', OrePrefixes.screw.get(Materials.Iron), 'R', OrePrefixes.ring.get(Materials.Iron), 'P', GT_ModHandler.getModItem("minecraft", "planks", 1L, 3)});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("malisisdoors", "item.door_jungle", 1L), tBitMask, new Object[]{"SPP", "RPP", "dPP", 'S', OrePrefixes.screw.get(Materials.Copper), 'R', OrePrefixes.ring.get(Materials.Copper), 'P', GT_ModHandler.getModItem("minecraft", "planks", 1L, 3)});
        // --- Spruce Door
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("malisisdoors", "item.door_spruce", 1L), tBitMask, new Object[]{"SPP", "RPP", "dPP", 'S', OrePrefixes.screw.get(Materials.Iron), 'R', OrePrefixes.ring.get(Materials.Iron), 'P', GT_ModHandler.getModItem("minecraft", "planks", 1L, 1)});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("malisisdoors", "item.door_spruce", 1L), tBitMask, new Object[]{"SPP", "RPP", "dPP", 'S', OrePrefixes.screw.get(Materials.Copper), 'R', OrePrefixes.ring.get(Materials.Copper), 'P', GT_ModHandler.getModItem("minecraft", "planks", 1L, 1)});
        // --- Trapdoor Acacia
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("malisisdoors", "trapdoor_acacia", 1L), tBitMask, new Object[]{"PSP", "SSS", "PSP", 'S', OrePrefixes.stick.get(Materials.Wood), 'P', GT_ModHandler.getModItem("minecraft", "wooden_slab", 1L, 4)});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("malisisdoors", "trapdoor_acacia", 2L), tBitMask, new Object[]{"PSP", "SRS", "PSP", 'S', OrePrefixes.stick.get(Materials.Wood), 'R', OrePrefixes.screw.get(Materials.Iron), 'P', GT_ModHandler.getModItem("minecraft", "wooden_slab", 1L, 4)});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("malisisdoors", "trapdoor_acacia", 3L), tBitMask, new Object[]{"PSP", "SRS", "PSP", 'S', OrePrefixes.stick.get(Materials.Wood), 'R', OrePrefixes.screw.get(Materials.Steel), 'P', GT_ModHandler.getModItem("minecraft", "wooden_slab", 1L, 4)});
        // --- Trapdoor Spruce
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("malisisdoors", "trapdoor_spruce", 1L), tBitMask, new Object[]{"PSP", "SSS", "PSP", 'S', OrePrefixes.stick.get(Materials.Wood), 'P', GT_ModHandler.getModItem("minecraft", "wooden_slab", 1L, 1)});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("malisisdoors", "trapdoor_spruce", 2L), tBitMask, new Object[]{"PSP", "SRS", "PSP", 'S', OrePrefixes.stick.get(Materials.Wood), 'R', OrePrefixes.screw.get(Materials.Iron), 'P', GT_ModHandler.getModItem("minecraft", "wooden_slab", 1L, 1)});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("malisisdoors", "trapdoor_spruce", 3L), tBitMask, new Object[]{"PSP", "SRS", "PSP", 'S', OrePrefixes.stick.get(Materials.Wood), 'R', OrePrefixes.screw.get(Materials.Steel), 'P', GT_ModHandler.getModItem("minecraft", "wooden_slab", 1L, 1)});
        // --- Trapdoor Birch
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("malisisdoors", "trapdoor_birch", 1L), tBitMask, new Object[]{"PSP", "SSS", "PSP", 'S', OrePrefixes.stick.get(Materials.Wood), 'P', GT_ModHandler.getModItem("minecraft", "wooden_slab", 1L, 2)});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("malisisdoors", "trapdoor_birch", 2L), tBitMask, new Object[]{"PSP", "SRS", "PSP", 'S', OrePrefixes.stick.get(Materials.Wood), 'R', OrePrefixes.screw.get(Materials.Iron), 'P', GT_ModHandler.getModItem("minecraft", "wooden_slab", 1L, 2)});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("malisisdoors", "trapdoor_birch", 3L), tBitMask, new Object[]{"PSP", "SRS", "PSP", 'S', OrePrefixes.stick.get(Materials.Wood), 'R', OrePrefixes.screw.get(Materials.Steel), 'P', GT_ModHandler.getModItem("minecraft", "wooden_slab", 1L, 2)});
        // --- Trapdoor Jungle
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("malisisdoors", "trapdoor_jungle", 1L), tBitMask, new Object[]{"PSP", "SSS", "PSP", 'S', OrePrefixes.stick.get(Materials.Wood), 'P', GT_ModHandler.getModItem("minecraft", "wooden_slab", 1L, 3)});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("malisisdoors", "trapdoor_jungle", 2L), tBitMask, new Object[]{"PSP", "SRS", "PSP", 'S', OrePrefixes.stick.get(Materials.Wood), 'R', OrePrefixes.screw.get(Materials.Iron), 'P', GT_ModHandler.getModItem("minecraft", "wooden_slab", 1L, 3)});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("malisisdoors", "trapdoor_jungle", 3L), tBitMask, new Object[]{"PSP", "SRS", "PSP", 'S', OrePrefixes.stick.get(Materials.Wood), 'R', OrePrefixes.screw.get(Materials.Steel), 'P', GT_ModHandler.getModItem("minecraft", "wooden_slab", 1L, 3)});
        // --- Trapdoor Dark Oak
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("malisisdoors", "trapdoor_dark_oak", 1L), tBitMask, new Object[]{"PSP", "SSS", "PSP", 'S', OrePrefixes.stick.get(Materials.Wood), 'P', GT_ModHandler.getModItem("minecraft", "wooden_slab", 1L, 5)});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("malisisdoors", "trapdoor_dark_oak", 2L), tBitMask, new Object[]{"PSP", "SRS", "PSP", 'S', OrePrefixes.stick.get(Materials.Wood), 'R', OrePrefixes.screw.get(Materials.Iron), 'P', GT_ModHandler.getModItem("minecraft", "wooden_slab", 1L, 5)});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("malisisdoors", "trapdoor_dark_oak", 3L), tBitMask, new Object[]{"PSP", "SRS", "PSP", 'S', OrePrefixes.stick.get(Materials.Wood), 'R', OrePrefixes.screw.get(Materials.Steel), 'P', GT_ModHandler.getModItem("minecraft", "wooden_slab", 1L, 5)});
        // --- Wooden Glass Door
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("malisisdoors", "item.wood_sliding_door", 1L), tBitMask, new Object[]{" P ", "PDP", " s ", 'P', "paneGlassColorless", 'D', GT_ModHandler.getModItem("minecraft", "wooden_door", 1L)});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("malisisdoors", "item.wood_sliding_door", 1L), tBitMask, new Object[]{" P ", "PDP", " s ", 'P', "paneGlassColorless", 'D', GT_ModHandler.getModItem("malisisdoors", "item.door_acacia", 1L)});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("malisisdoors", "item.wood_sliding_door", 1L), tBitMask, new Object[]{" P ", "PDP", " s ", 'P', "paneGlassColorless", 'D', GT_ModHandler.getModItem("malisisdoors", "item.door_birch", 1L)});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("malisisdoors", "item.wood_sliding_door", 1L), tBitMask, new Object[]{" P ", "PDP", " s ", 'P', "paneGlassColorless", 'D', GT_ModHandler.getModItem("malisisdoors", "item.door_dark_oak", 1L)});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("malisisdoors", "item.wood_sliding_door", 1L), tBitMask, new Object[]{" P ", "PDP", " s ", 'P', "paneGlassColorless", 'D', GT_ModHandler.getModItem("malisisdoors", "item.door_jungle", 1L)});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("malisisdoors", "item.wood_sliding_door", 1L), tBitMask, new Object[]{" P ", "PDP", " s ", 'P', "paneGlassColorless", 'D', GT_ModHandler.getModItem("malisisdoors", "item.door_spruce", 1L)});
        // --- Iron Glass Door
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("malisisdoors", "item.iron_sliding_door", 1L), tBitMask, new Object[]{" P ", "PDP", " s ", 'P', "paneGlassColorless", 'D', GT_ModHandler.getModItem("minecraft", "iron_door", 1L)});
        // --- Jail Door
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("malisisdoors", "item.jail_door", 1L), tBitMask, new Object[]{" P ", "PDP", " s ", 'P', CoreItems2.getRecipe(SteelBars.getMetaID(), 1), 'D', GT_ModHandler.getModItem("minecraft", "iron_door", 1L)});
        // --- Laboratory Door
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("malisisdoors", "item.laboratory_door", 1L), tBitMask, new Object[]{" P ", "SDS", " h ", 'P', OrePrefixes.plate.get(Materials.Iron), 'S', OrePrefixes.plate.get(Materials.Steel), 'D', GT_ModHandler.getModItem("minecraft", "iron_door", 1L)});
        // --- Factory Door
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("malisisdoors", "item.factory_door", 1L), tBitMask, new Object[]{" P ", "SDS", " h ", 'P', OrePrefixes.plate.get(Materials.Steel), 'S', OrePrefixes.plate.get(Materials.Iron), 'D', GT_ModHandler.getModItem("minecraft", "iron_door", 1L)});
        // --- Shoji Door
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("malisisdoors", "item.shoji_door", 1L), tBitMask, new Object[]{"PTS", "PTR", "PTd", 'P', GT_ModHandler.getModItem("minecraft", "paper", 1L), 'T', OrePrefixes.stick.get(Materials.Wood), 'S', OrePrefixes.screw.get(Materials.Iron), 'R', OrePrefixes.ring.get(Materials.Iron)});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("malisisdoors", "item.shoji_door", 1L), tBitMask, new Object[]{"PTS", "PTR", "PTd", 'P', GT_ModHandler.getModItem("minecraft", "paper", 1L), 'T', OrePrefixes.stick.get(Materials.Wood), 'S', OrePrefixes.screw.get(Materials.Copper), 'R', OrePrefixes.ring.get(Materials.Copper)});
        // --- Curtain Purple
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("malisisdoors", "item.curtain_purple", 1L), tBitMask, new Object[]{"C C", "CSC", "C C", 'C', GT_ModHandler.getModItem("minecraft", "carpet", 1L, 10), 'S', GT_ModHandler.getModItem("minecraft", "string", 1L)});
        // --- Curtain Yellow
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("malisisdoors", "item.curtain_yellow", 1L), tBitMask, new Object[]{"C C", "CSC", "C C", 'C', GT_ModHandler.getModItem("minecraft", "carpet", 1L, 4), 'S', GT_ModHandler.getModItem("minecraft", "string", 1L)});
        // --- Curtain Magenta
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("malisisdoors", "item.curtain_magenta", 1L), tBitMask, new Object[]{"C C", "CSC", "C C", 'C', GT_ModHandler.getModItem("minecraft", "carpet", 1L, 2), 'S', GT_ModHandler.getModItem("minecraft", "string", 1L)});
        // --- Curtain Pink
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("malisisdoors", "item.curtain_pink", 1L), tBitMask, new Object[]{"C C", "CSC", "C C", 'C', GT_ModHandler.getModItem("minecraft", "carpet", 1L, 6), 'S', GT_ModHandler.getModItem("minecraft", "string", 1L)});
        // --- Curtain White
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("malisisdoors", "item.curtain_white", 1L), tBitMask, new Object[]{"C C", "CSC", "C C", 'C', GT_ModHandler.getModItem("minecraft", "carpet", 1L), 'S', GT_ModHandler.getModItem("minecraft", "string", 1L)});
        // --- Curtain Blue
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("malisisdoors", "item.curtain_blue", 1L), tBitMask, new Object[]{"C C", "CSC", "C C", 'C', GT_ModHandler.getModItem("minecraft", "carpet", 1L, 11), 'S', GT_ModHandler.getModItem("minecraft", "string", 1L)});
        // --- Curtain Gray
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("malisisdoors", "item.curtain_gray", 1L), tBitMask, new Object[]{"C C", "CSC", "C C", 'C', GT_ModHandler.getModItem("minecraft", "carpet", 1L, 7), 'S', GT_ModHandler.getModItem("minecraft", "string", 1L)});
        // --- Curtain Cyan
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("malisisdoors", "item.curtain_cyan", 1L), tBitMask, new Object[]{"C C", "CSC", "C C", 'C', GT_ModHandler.getModItem("minecraft", "carpet", 1L, 9), 'S', GT_ModHandler.getModItem("minecraft", "string", 1L)});
        // --- Curtain Red
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("malisisdoors", "item.curtain_red", 1L), tBitMask, new Object[]{"C C", "CSC", "C C", 'C', GT_ModHandler.getModItem("minecraft", "carpet", 1L, 14), 'S', GT_ModHandler.getModItem("minecraft", "string", 1L)});
        // --- Curtain Brown
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("malisisdoors", "item.curtain_brown", 1L), tBitMask, new Object[]{"C C", "CSC", "C C", 'C', GT_ModHandler.getModItem("minecraft", "carpet", 1L, 12), 'S', GT_ModHandler.getModItem("minecraft", "string", 1L)});
        // --- Curtain Lime
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("malisisdoors", "item.curtain_lime", 1L), tBitMask, new Object[]{"C C", "CSC", "C C", 'C', GT_ModHandler.getModItem("minecraft", "carpet", 1L, 5), 'S', GT_ModHandler.getModItem("minecraft", "string", 1L)});
        // --- Curtain Orange
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("malisisdoors", "item.curtain_orange", 1L), tBitMask, new Object[]{"C C", "CSC", "C C", 'C', GT_ModHandler.getModItem("minecraft", "carpet", 1L, 1), 'S', GT_ModHandler.getModItem("minecraft", "string", 1L)});
        // --- Curtain Light Gray
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("malisisdoors", "item.curtain_silver", 1L), tBitMask, new Object[]{"C C", "CSC", "C C", 'C', GT_ModHandler.getModItem("minecraft", "carpet", 1L, 8), 'S', GT_ModHandler.getModItem("minecraft", "string", 1L)});
        // --- Curtain Green
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("malisisdoors", "item.curtain_green", 1L), tBitMask, new Object[]{"C C", "CSC", "C C", 'C', GT_ModHandler.getModItem("minecraft", "carpet", 1L, 13), 'S', GT_ModHandler.getModItem("minecraft", "string", 1L)});
        // --- Curtain Light Blue
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("malisisdoors", "item.curtain_light_blue", 1L), tBitMask, new Object[]{"C C", "CSC", "C C", 'C', GT_ModHandler.getModItem("minecraft", "carpet", 1L, 3), 'S', GT_ModHandler.getModItem("minecraft", "string", 1L)});
        // --- Curtain Black
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("malisisdoors", "item.curtain_black", 1L), tBitMask, new Object[]{"C C", "CSC", "C C", 'C', GT_ModHandler.getModItem("minecraft", "carpet", 1L, 15), 'S', GT_ModHandler.getModItem("minecraft", "string", 1L)});
        // --- Saloon Door
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("malisisdoors", "item.saloon", 1L), tBitMask, new Object[]{" SW", "hPW", " SW", 'S', OrePrefixes.stick.get(Materials.Wood), 'P', OrePrefixes.springSmall.get(Materials.Iron), 'W', OrePrefixes.plank.get(Materials.Wood)});
        // --- Arcania Fence Gate
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("malisisdoors", "acaciaFenceGate", 1L), tBitMask, new Object[]{"PSP", "PSP", "PSP", 'P', GT_ModHandler.getModItem("minecraft", "planks", 1L, 4), 'S', OrePrefixes.stick.get(Materials.Wood)});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("malisisdoors", "acaciaFenceGate", 1L), tBitMask, new Object[]{"CdC", "PSP", "PSP", 'P', GT_ModHandler.getModItem("minecraft", "planks", 1L, 4), 'S', OrePrefixes.stick.get(Materials.Wood), 'C', OrePrefixes.screw.get(Materials.Wood)});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("malisisdoors", "acaciaFenceGate", 2L), tBitMask, new Object[]{"CdC", "PSP", "PSP", 'P', GT_ModHandler.getModItem("minecraft", "planks", 1L, 4), 'S', OrePrefixes.stick.get(Materials.Wood), 'C', OrePrefixes.screw.get(Materials.Iron)});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("malisisdoors", "acaciaFenceGate", 4L), tBitMask, new Object[]{"CdC", "PSP", "PSP", 'P', GT_ModHandler.getModItem("minecraft", "planks", 1L, 4), 'S', OrePrefixes.stick.get(Materials.Wood), 'C', OrePrefixes.screw.get(Materials.Steel)});
        // --- Birch Fence Gate
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("malisisdoors", "birchFenceGate", 1L), tBitMask, new Object[]{"PSP", "PSP", "PSP", 'P', GT_ModHandler.getModItem("minecraft", "planks", 1L, 2), 'S', OrePrefixes.stick.get(Materials.Wood)});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("malisisdoors", "birchFenceGate", 1L), tBitMask, new Object[]{"CdC", "PSP", "PSP", 'P', GT_ModHandler.getModItem("minecraft", "planks", 1L, 2), 'S', OrePrefixes.stick.get(Materials.Wood), 'C', OrePrefixes.screw.get(Materials.Wood)});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("malisisdoors", "birchFenceGate", 2L), tBitMask, new Object[]{"CdC", "PSP", "PSP", 'P', GT_ModHandler.getModItem("minecraft", "planks", 1L, 2), 'S', OrePrefixes.stick.get(Materials.Wood), 'C', OrePrefixes.screw.get(Materials.Iron)});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("malisisdoors", "birchFenceGate", 4L), tBitMask, new Object[]{"CdC", "PSP", "PSP", 'P', GT_ModHandler.getModItem("minecraft", "planks", 1L, 2), 'S', OrePrefixes.stick.get(Materials.Wood), 'C', OrePrefixes.screw.get(Materials.Steel)});
        // --- Dark Oak Fence Gate
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("malisisdoors", "darkOakFenceGate", 1L), tBitMask, new Object[]{"PSP", "PSP", "PSP", 'P', GT_ModHandler.getModItem("minecraft", "planks", 1L, 5), 'S', OrePrefixes.stick.get(Materials.Wood)});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("malisisdoors", "darkOakFenceGate", 1L), tBitMask, new Object[]{"CdC", "PSP", "PSP", 'P', GT_ModHandler.getModItem("minecraft", "planks", 1L, 5), 'S', OrePrefixes.stick.get(Materials.Wood), 'C', OrePrefixes.screw.get(Materials.Wood)});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("malisisdoors", "darkOakFenceGate", 2L), tBitMask, new Object[]{"CdC", "PSP", "PSP", 'P', GT_ModHandler.getModItem("minecraft", "planks", 1L, 5), 'S', OrePrefixes.stick.get(Materials.Wood), 'C', OrePrefixes.screw.get(Materials.Iron)});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("malisisdoors", "darkOakFenceGate", 4L), tBitMask, new Object[]{"CdC", "PSP", "PSP", 'P', GT_ModHandler.getModItem("minecraft", "planks", 1L, 5), 'S', OrePrefixes.stick.get(Materials.Wood), 'C', OrePrefixes.screw.get(Materials.Steel)});
        // --- Jungle Fence Gate
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("malisisdoors", "jungleFenceGate", 1L), tBitMask, new Object[]{"PSP", "PSP", "PSP", 'P', GT_ModHandler.getModItem("minecraft", "planks", 1L, 3), 'S', OrePrefixes.stick.get(Materials.Wood)});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("malisisdoors", "jungleFenceGate", 1L), tBitMask, new Object[]{"CdC", "PSP", "PSP", 'P', GT_ModHandler.getModItem("minecraft", "planks", 1L, 3), 'S', OrePrefixes.stick.get(Materials.Wood), 'C', OrePrefixes.screw.get(Materials.Wood)});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("malisisdoors", "jungleFenceGate", 2L), tBitMask, new Object[]{"CdC", "PSP", "PSP", 'P', GT_ModHandler.getModItem("minecraft", "planks", 1L, 3), 'S', OrePrefixes.stick.get(Materials.Wood), 'C', OrePrefixes.screw.get(Materials.Iron)});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("malisisdoors", "jungleFenceGate", 4L), tBitMask, new Object[]{"CdC", "PSP", "PSP", 'P', GT_ModHandler.getModItem("minecraft", "planks", 1L, 3), 'S', OrePrefixes.stick.get(Materials.Wood), 'C', OrePrefixes.screw.get(Materials.Steel)});
        // --- Spruce Fence Gate
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("malisisdoors", "spruceFenceGate", 1L), tBitMask, new Object[]{"PSP", "PSP", "PSP", 'P', GT_ModHandler.getModItem("minecraft", "planks", 1L, 1), 'S', OrePrefixes.stick.get(Materials.Wood)});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("malisisdoors", "spruceFenceGate", 1L), tBitMask, new Object[]{"CdC", "PSP", "PSP", 'P', GT_ModHandler.getModItem("minecraft", "planks", 1L, 1), 'S', OrePrefixes.stick.get(Materials.Wood), 'C', OrePrefixes.screw.get(Materials.Wood)});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("malisisdoors", "spruceFenceGate", 2L), tBitMask, new Object[]{"CdC", "PSP", "PSP", 'P', GT_ModHandler.getModItem("minecraft", "planks", 1L, 1), 'S', OrePrefixes.stick.get(Materials.Wood), 'C', OrePrefixes.screw.get(Materials.Iron)});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("malisisdoors", "spruceFenceGate", 4L), tBitMask, new Object[]{"CdC", "PSP", "PSP", 'P', GT_ModHandler.getModItem("minecraft", "planks", 1L, 1), 'S', OrePrefixes.stick.get(Materials.Wood), 'C', OrePrefixes.screw.get(Materials.Steel)});

    }

    private void assembler() {
        // --- Iron Trap Door
        RA.addAssemblerRecipe(GT_ModHandler.getModItem("minecraft", "trapdoor", 1L),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Iron, 4L),
                GT_ModHandler.getModItem("malisisdoors", "iron_trapdoor", 1L), 100, 16);
        RA.addAssemblerRecipe(GT_ModHandler.getModItem("malisisdoors", "trapdoor_acacia", 1L),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Iron, 4L),
                GT_ModHandler.getModItem("malisisdoors", "iron_trapdoor", 1L), 100, 16);
        RA.addAssemblerRecipe(GT_ModHandler.getModItem("malisisdoors", "trapdoor_spruce", 1L),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Iron, 4L),
                GT_ModHandler.getModItem("malisisdoors", "iron_trapdoor", 1L), 100, 16);
        RA.addAssemblerRecipe(GT_ModHandler.getModItem("malisisdoors", "trapdoor_birch", 1L),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Iron, 4L),
                GT_ModHandler.getModItem("malisisdoors", "iron_trapdoor", 1L), 100, 16);
        RA.addAssemblerRecipe(GT_ModHandler.getModItem("malisisdoors", "trapdoor_jungle", 1L),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Iron, 4L),
                GT_ModHandler.getModItem("malisisdoors", "iron_trapdoor", 1L), 100, 16);
        GT_Values.RA
                .addAssemblerRecipe(GT_ModHandler.getModItem("malisisdoors", "trapdoor_dark_oak", 1L),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Iron, 4L),
                        GT_ModHandler.getModItem("malisisdoors", "iron_trapdoor", 1L), 100, 16);
        // --- Sliding Trap Door
        RA.addAssemblerRecipe(GT_ModHandler.getModItem("malisisdoors", "iron_trapdoor", 1L),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Steel, 2L),
                GT_ModHandler.getModItem("malisisdoors", "sliding_trapdoor", 1L), 150, 16);
        // --- Wooden Vanishing Frame
        RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 4L),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Glass, 1L),
                Materials.Redstone.getMolten(288),
                GT_ModHandler.getModItem("malisisdoors", "vanishing_block", 1L), 300, 30);
        // --- Iron Vanishing Frame
        RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Iron, 4L),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Glass, 1L),
                Materials.Redstone.getMolten(288),
                GT_ModHandler.getModItem("malisisdoors", "vanishing_block", 1L, 1), 400, 30);
        // --- Gold Vanishing Frame
        RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Gold, 4L),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Glass, 1L),
                Materials.Redstone.getMolten(288),
                GT_ModHandler.getModItem("malisisdoors", "vanishing_block", 1L, 2), 500, 30);
        // --- Diamond Vanishing Frame
        GT_Values.RA
                .addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Diamond, 4L),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Glass, 1L),
                        Materials.Redstone.getMolten(288),
                        GT_ModHandler.getModItem("malisisdoors", "vanishing_block", 1L, 3), 600, 30);
        // --- Rusty Hatch
        RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Iron, 4L),
                GT_ModHandler.getModItem("malisisdoors", "item.rustyHandle", 1L),
                GT_ModHandler.getModItem("malisisdoors", "rustyHatch", 1L), 200, 16);
        // --- Garage Door
        RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Iron, 2L),
                GT_OreDictUnificator.get(OrePrefixes.ring, Materials.Steel, 1L),
                GT_ModHandler.getModItem("malisisdoors", "garage_door", 3L), 150, 16);
        GT_Values.RA
                .addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Plastic, 2L),
                        GT_OreDictUnificator.get(OrePrefixes.ring, Materials.Steel, 1L),
                        GT_ModHandler.getModItem("malisisdoors", "garage_door", 4L), 160, 16);
        GT_Values.RA
                .addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Plastic, 3L),
                        GT_OreDictUnificator.get(OrePrefixes.ring, Materials.Aluminium, 2L),
                        GT_ModHandler.getModItem("malisisdoors", "garage_door", 6L), 170, 16);
        GT_Values.RA
                .addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Plastic, 3L),
                        GT_OreDictUnificator.get(OrePrefixes.ring, Materials.StainlessSteel, 2L),
                        GT_ModHandler.getModItem("malisisdoors", "garage_door", 8L), 180, 16);
        // --- Rusty Ladder
        GT_Values.RA
                .addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Iron, 3L),
                        GT_Utility.getIntegratedCircuit(6),
                        GT_ModHandler.getModItem("malisisdoors", "rustyLadder", 2L), 60, 16);
        GT_Values.RA
                .addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Steel, 3L),
                        GT_Utility.getIntegratedCircuit(6),
                        GT_ModHandler.getModItem("malisisdoors", "rustyLadder", 4L), 70, 16);
        GT_Values.RA
                .addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Aluminium, 3L),
                        GT_Utility.getIntegratedCircuit(6),
                        GT_ModHandler.getModItem("malisisdoors", "rustyLadder", 8L), 80, 16);
        GT_Values.RA
                .addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.stick, Materials.StainlessSteel, 3L),
                        GT_Utility.getIntegratedCircuit(6),
                        GT_ModHandler.getModItem("malisisdoors", "rustyLadder", 16L), 90, 16);
        // --- Carriage Door
        GT_Values.RA
                .addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.block, Materials.NetherQuartz, 4L),
                        GT_ModHandler.getModItem("minecraft", "door", 1L),
                        GT_ModHandler.getModItem("malisisdoors", "carriage_door", 1L), 200, 30);
        // --- Acacia Door
        RA.addAssemblerRecipe(GT_ModHandler.getModItem("minecraft", "planks", 6L, 4),
                GT_Utility.getIntegratedCircuit(6), Materials.Iron.getMolten(16),
                GT_ModHandler.getModItem("malisisdoors", "item.door_acacia", 1L), 400, 4);
        RA.addAssemblerRecipe(GT_ModHandler.getModItem("minecraft", "planks", 6L, 4),
                GT_Utility.getIntegratedCircuit(6), Materials.Copper.getMolten(16),
                GT_ModHandler.getModItem("malisisdoors", "item.door_acacia", 1L), 400, 4);
        // --- Birch Door
        RA.addAssemblerRecipe(GT_ModHandler.getModItem("minecraft", "planks", 6L, 2),
                GT_Utility.getIntegratedCircuit(6), Materials.Iron.getMolten(16),
                GT_ModHandler.getModItem("malisisdoors", "item.door_birch", 1L), 400, 4);
        RA.addAssemblerRecipe(GT_ModHandler.getModItem("minecraft", "planks", 6L, 2),
                GT_Utility.getIntegratedCircuit(6), Materials.Copper.getMolten(16),
                GT_ModHandler.getModItem("malisisdoors", "item.door_birch", 1L), 400, 4);
        // --- Dark Oak Door
        RA.addAssemblerRecipe(GT_ModHandler.getModItem("minecraft", "planks", 6L, 5),
                GT_Utility.getIntegratedCircuit(6), Materials.Iron.getMolten(16),
                GT_ModHandler.getModItem("malisisdoors", "item.door_dark_oak", 1L), 400, 4);
        RA.addAssemblerRecipe(GT_ModHandler.getModItem("minecraft", "planks", 6L, 5),
                GT_Utility.getIntegratedCircuit(6), Materials.Copper.getMolten(16),
                GT_ModHandler.getModItem("malisisdoors", "item.door_dark_oak", 1L), 400, 4);
        // --- Jungle Door
        RA.addAssemblerRecipe(GT_ModHandler.getModItem("minecraft", "planks", 6L, 3),
                GT_Utility.getIntegratedCircuit(6), Materials.Iron.getMolten(16),
                GT_ModHandler.getModItem("malisisdoors", "item.door_jungle", 1L), 400, 4);
        RA.addAssemblerRecipe(GT_ModHandler.getModItem("minecraft", "planks", 6L, 3),
                GT_Utility.getIntegratedCircuit(6), Materials.Copper.getMolten(16),
                GT_ModHandler.getModItem("malisisdoors", "item.door_jungle", 1L), 400, 4);
        // --- Spruce Door
        RA.addAssemblerRecipe(GT_ModHandler.getModItem("minecraft", "planks", 6L, 1),
                GT_Utility.getIntegratedCircuit(6), Materials.Iron.getMolten(16),
                GT_ModHandler.getModItem("malisisdoors", "item.door_spruce", 1L), 400, 4);
        RA.addAssemblerRecipe(GT_ModHandler.getModItem("minecraft", "planks", 6L, 1),
                GT_Utility.getIntegratedCircuit(6), Materials.Copper.getMolten(16),
                GT_ModHandler.getModItem("malisisdoors", "item.door_spruce", 1L), 400, 4);
        // --- Wooden Glass Door
        RA.addAssemblerRecipe(GT_ModHandler.getModItem("minecraft", "wooden_door", 1L),
                GT_ModHandler.getModItem("minecraft", "glass_pane", 1L),
                GT_ModHandler.getModItem("malisisdoors", "item.wood_sliding_door", 1L), 400, 4);
        GT_Values.RA
                .addAssemblerRecipe(GT_ModHandler.getModItem("malisisdoors", "item.door_acacia", 1L),
                        GT_ModHandler.getModItem("minecraft", "glass_pane", 1L),
                        GT_ModHandler.getModItem("malisisdoors", "item.wood_sliding_door", 1L), 400, 4);
        RA.addAssemblerRecipe(GT_ModHandler.getModItem("malisisdoors", "item.door_birch", 1L),
                GT_ModHandler.getModItem("minecraft", "glass_pane", 1L),
                GT_ModHandler.getModItem("malisisdoors", "item.wood_sliding_door", 1L), 400, 4);
        GT_Values.RA
                .addAssemblerRecipe(GT_ModHandler.getModItem("malisisdoors", "item.door_dark_oak", 1L),
                        GT_ModHandler.getModItem("minecraft", "glass_pane", 1L),
                        GT_ModHandler.getModItem("malisisdoors", "item.wood_sliding_door", 1L), 400, 4);
        GT_Values.RA
                .addAssemblerRecipe(GT_ModHandler.getModItem("malisisdoors", "item.door_jungle", 1L),
                        GT_ModHandler.getModItem("minecraft", "glass_pane", 1L),
                        GT_ModHandler.getModItem("malisisdoors", "item.wood_sliding_door", 1L), 400, 4);
        GT_Values.RA
                .addAssemblerRecipe(GT_ModHandler.getModItem("malisisdoors", "item.door_spruce", 1L),
                        GT_ModHandler.getModItem("minecraft", "glass_pane", 1L),
                        GT_ModHandler.getModItem("malisisdoors", "item.wood_sliding_door", 1L), 400, 4);
        // --- Iron Glass Door
        RA.addAssemblerRecipe(GT_ModHandler.getModItem("minecraft", "iron_door", 1L),
                GT_ModHandler.getModItem("minecraft", "glass_pane", 1L),
                GT_ModHandler.getModItem("malisisdoors", "item.iron_sliding_door", 1L), 400, 4);
        // --- Jail Door
        RA.addAssemblerRecipe(GT_ModHandler.getModItem("minecraft", "iron_door", 1L),
                CoreItems2.getRecipe(51, 2), GT_ModHandler.getModItem("malisisdoors", "item.jail_door", 1L),
                400, 4);
        // --- Laboratory Door
        RA.addAssemblerRecipe(GT_ModHandler.getModItem("minecraft", "wooden_door", 1L),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Steel, 2L),
                GT_ModHandler.getModItem("malisisdoors", "item.laboratory_door", 1L), 400, 4);
        GT_Values.RA
                .addAssemblerRecipe(GT_ModHandler.getModItem("malisisdoors", "item.door_acacia", 1L),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Steel, 2L),
                        GT_ModHandler.getModItem("malisisdoors", "item.laboratory_door", 1L), 400, 4);
        RA.addAssemblerRecipe(GT_ModHandler.getModItem("malisisdoors", "item.door_birch", 1L),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Steel, 2L),
                GT_ModHandler.getModItem("malisisdoors", "item.laboratory_door", 1L), 400, 4);
        GT_Values.RA
                .addAssemblerRecipe(GT_ModHandler.getModItem("malisisdoors", "item.door_dark_oak", 1L),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Steel, 2L),
                        GT_ModHandler.getModItem("malisisdoors", "item.laboratory_door", 1L), 400, 4);
        GT_Values.RA
                .addAssemblerRecipe(GT_ModHandler.getModItem("malisisdoors", "item.door_jungle", 1L),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Steel, 2L),
                        GT_ModHandler.getModItem("malisisdoors", "item.laboratory_door", 1L), 400, 4);
        GT_Values.RA
                .addAssemblerRecipe(GT_ModHandler.getModItem("malisisdoors", "item.door_spruce", 1L),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Steel, 2L),
                        GT_ModHandler.getModItem("malisisdoors", "item.laboratory_door", 1L), 400, 4);
        // --- Factory Door
        RA.addAssemblerRecipe(GT_ModHandler.getModItem("minecraft", "iron_door", 1L),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Iron, 2L),
                GT_ModHandler.getModItem("malisisdoors", "item.factory_door", 1L), 400, 4);
        // --- Shoji Door
        RA.addAssemblerRecipe(GT_ModHandler.getModItem("minecraft", "paper", 2L),
                GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 2L),
                GT_ModHandler.getModItem("malisisdoors", "item.shoji_door", 1L), 400, 4);
        // --- Purple Curtain
        RA.addAssemblerRecipe(GT_ModHandler.getModItem("minecraft", "carpet", 3L, 10),
                GT_ModHandler.getModItem("minecraft", "string", 1L),
                GT_ModHandler.getModItem("malisisdoors", "item.curtain_purple", 1L), 400, 4);
        // --- Yellow Curtain
        RA.addAssemblerRecipe(GT_ModHandler.getModItem("minecraft", "carpet", 3L, 4),
                GT_ModHandler.getModItem("minecraft", "string", 1L),
                GT_ModHandler.getModItem("malisisdoors", "item.curtain_yellow", 1L), 400, 4);
        // --- Magenta Curtain
        RA.addAssemblerRecipe(GT_ModHandler.getModItem("minecraft", "carpet", 3L, 2),
                GT_ModHandler.getModItem("minecraft", "string", 1L),
                GT_ModHandler.getModItem("malisisdoors", "item.curtain_magenta", 1L), 400, 4);
        // --- Pink Curtain
        RA.addAssemblerRecipe(GT_ModHandler.getModItem("minecraft", "carpet", 3L, 6),
                GT_ModHandler.getModItem("minecraft", "string", 1L),
                GT_ModHandler.getModItem("malisisdoors", "item.curtain_pink", 1L), 400, 4);
        // --- White Curtain
        RA.addAssemblerRecipe(GT_ModHandler.getModItem("minecraft", "carpet", 3L),
                GT_ModHandler.getModItem("minecraft", "string", 1L),
                GT_ModHandler.getModItem("malisisdoors", "item.curtain_white", 1L), 400, 4);
        // --- Blue Curtain
        RA.addAssemblerRecipe(GT_ModHandler.getModItem("minecraft", "carpet", 3L, 11),
                GT_ModHandler.getModItem("minecraft", "string", 1L),
                GT_ModHandler.getModItem("malisisdoors", "item.curtain_blue", 1L), 400, 4);
        // --- Cyan Curtain
        RA.addAssemblerRecipe(GT_ModHandler.getModItem("minecraft", "carpet", 3L, 9),
                GT_ModHandler.getModItem("minecraft", "string", 1L),
                GT_ModHandler.getModItem("malisisdoors", "item.curtain_cyan", 1L), 400, 4);
        // --- Red Curtain
        RA.addAssemblerRecipe(GT_ModHandler.getModItem("minecraft", "carpet", 3L, 14),
                GT_ModHandler.getModItem("minecraft", "string", 1L),
                GT_ModHandler.getModItem("malisisdoors", "item.curtain_red", 1L), 400, 4);
        // --- Gray Curtain
        RA.addAssemblerRecipe(GT_ModHandler.getModItem("minecraft", "carpet", 3L, 7),
                GT_ModHandler.getModItem("minecraft", "string", 1L),
                GT_ModHandler.getModItem("malisisdoors", "item.curtain_gray", 1L), 400, 4);
        // --- Brown Curtain
        RA.addAssemblerRecipe(GT_ModHandler.getModItem("minecraft", "carpet", 3L, 12),
                GT_ModHandler.getModItem("minecraft", "string", 1L),
                GT_ModHandler.getModItem("malisisdoors", "item.curtain_brown", 1L), 400, 4);
        // --- Lime Curtain
        RA.addAssemblerRecipe(GT_ModHandler.getModItem("minecraft", "carpet", 3L, 5),
                GT_ModHandler.getModItem("minecraft", "string", 1L),
                GT_ModHandler.getModItem("malisisdoors", "item.curtain_lime", 1L), 400, 4);
        // --- Orange Curtain
        RA.addAssemblerRecipe(GT_ModHandler.getModItem("minecraft", "carpet", 3L, 1),
                GT_ModHandler.getModItem("minecraft", "string", 1L),
                GT_ModHandler.getModItem("malisisdoors", "item.curtain_orange", 1L), 400, 4);
        // --- Light Gray Curtain
        RA.addAssemblerRecipe(GT_ModHandler.getModItem("minecraft", "carpet", 3L, 8),
                GT_ModHandler.getModItem("minecraft", "string", 1L),
                GT_ModHandler.getModItem("malisisdoors", "item.curtain_silver", 1L), 400, 4);
        // --- Green Curtain
        RA.addAssemblerRecipe(GT_ModHandler.getModItem("minecraft", "carpet", 3L, 13),
                GT_ModHandler.getModItem("minecraft", "string", 1L),
                GT_ModHandler.getModItem("malisisdoors", "item.curtain_green", 1L), 400, 4);
        // --- Light Blue Curtain
        RA.addAssemblerRecipe(GT_ModHandler.getModItem("minecraft", "carpet", 3L, 3),
                GT_ModHandler.getModItem("minecraft", "string", 1L),
                GT_ModHandler.getModItem("malisisdoors", "item.curtain_light_blue", 1L), 400, 4);
        // --- Black Curtain
        RA.addAssemblerRecipe(GT_ModHandler.getModItem("minecraft", "carpet", 3L, 15),
                GT_ModHandler.getModItem("minecraft", "string", 1L),
                GT_ModHandler.getModItem("malisisdoors", "item.curtain_black", 1L), 400, 4);
        // --- Saloon Door
        RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.plank, Materials.Wood, 3L),
                GT_OreDictUnificator.get(OrePrefixes.springSmall, Materials.Iron, 1L),
                GT_ModHandler.getModItem("malisisdoors", "item.saloon", 1L), 400, 4);
        // --- Fence Gate Acacia
        RA.addAssemblerRecipe(
                new ItemStack[]{GT_ModHandler.getModItem("minecraft", "planks", 3L, 4),
                        GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 2L),
                        GT_Utility.getIntegratedCircuit(2)}, null,
                GT_ModHandler.getModItem("malisisdoors", "acaciaFenceGate", 1L), 300, 8);
        RA.addAssemblerRecipe(
                new ItemStack[]{GT_ModHandler.getModItem("minecraft", "planks", 3L, 4),
                        GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 2L),
                        GT_Utility.getIntegratedCircuit(3)}, Materials.Iron.getMolten(16),
                GT_ModHandler.getModItem("malisisdoors", "acaciaFenceGate", 2L), 300, 8);
        RA.addAssemblerRecipe(
                new ItemStack[]{GT_ModHandler.getModItem("minecraft", "planks", 3L, 4),
                        GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 2L),
                        GT_Utility.getIntegratedCircuit(3)}, Materials.Steel.getMolten(16),
                GT_ModHandler.getModItem("malisisdoors", "acaciaFenceGate", 4L), 300, 8);
        // --- Fence Gate Birch
        RA.addAssemblerRecipe(
                new ItemStack[]{GT_ModHandler.getModItem("minecraft", "planks", 3L, 2),
                        GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 2L),
                        GT_Utility.getIntegratedCircuit(2)}, null,
                GT_ModHandler.getModItem("malisisdoors", "birchFenceGate", 1L), 300, 8);
        RA.addAssemblerRecipe(
                new ItemStack[]{GT_ModHandler.getModItem("minecraft", "planks", 3L, 2),
                        GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 2L),
                        GT_Utility.getIntegratedCircuit(3)}, Materials.Iron.getMolten(16),
                GT_ModHandler.getModItem("malisisdoors", "birchFenceGate", 2L), 300, 8);
        RA.addAssemblerRecipe(
                new ItemStack[]{GT_ModHandler.getModItem("minecraft", "planks", 3L, 2),
                        GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 2L),
                        GT_Utility.getIntegratedCircuit(3)}, Materials.Steel.getMolten(16),
                GT_ModHandler.getModItem("malisisdoors", "birchFenceGate", 4L), 300, 8);
        // --- Fence Gate Dark Oak
        RA.addAssemblerRecipe(
                new ItemStack[]{GT_ModHandler.getModItem("minecraft", "planks", 3L, 5),
                        GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 2L),
                        GT_Utility.getIntegratedCircuit(2)}, null,
                GT_ModHandler.getModItem("malisisdoors", "darkOakFenceGate", 1L), 300, 8);
        RA.addAssemblerRecipe(
                new ItemStack[]{GT_ModHandler.getModItem("minecraft", "planks", 3L, 5),
                        GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 2L),
                        GT_Utility.getIntegratedCircuit(3)}, Materials.Iron.getMolten(16),
                GT_ModHandler.getModItem("malisisdoors", "darkOakFenceGate", 2L), 300, 8);
        RA.addAssemblerRecipe(
                new ItemStack[]{GT_ModHandler.getModItem("minecraft", "planks", 3L, 5),
                        GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 2L),
                        GT_Utility.getIntegratedCircuit(3)}, Materials.Steel.getMolten(16),
                GT_ModHandler.getModItem("malisisdoors", "darkOakFenceGate", 4L), 300, 8);
        // --- Fence Gate Jungle
        RA.addAssemblerRecipe(
                new ItemStack[]{GT_ModHandler.getModItem("minecraft", "planks", 3L, 3),
                        GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 2L),
                        GT_Utility.getIntegratedCircuit(2)}, null,
                GT_ModHandler.getModItem("malisisdoors", "jungleFenceGate", 1L), 300, 8);
        RA.addAssemblerRecipe(
                new ItemStack[]{GT_ModHandler.getModItem("minecraft", "planks", 3L, 3),
                        GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 2L),
                        GT_Utility.getIntegratedCircuit(3)}, Materials.Iron.getMolten(16),
                GT_ModHandler.getModItem("malisisdoors", "jungleFenceGate", 2L), 300, 8);
        RA.addAssemblerRecipe(
                new ItemStack[]{GT_ModHandler.getModItem("minecraft", "planks", 3L, 3),
                        GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 2L),
                        GT_Utility.getIntegratedCircuit(3)}, Materials.Steel.getMolten(16),
                GT_ModHandler.getModItem("malisisdoors", "jungleFenceGate", 4L), 300, 8);
        // --- Fence Gate Spruce
        RA.addAssemblerRecipe(
                new ItemStack[]{GT_ModHandler.getModItem("minecraft", "planks", 3L, 1),
                        GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 2L),
                        GT_Utility.getIntegratedCircuit(2)}, null,
                GT_ModHandler.getModItem("malisisdoors", "spruceFenceGate", 1L), 300, 8);
        RA.addAssemblerRecipe(
                new ItemStack[]{GT_ModHandler.getModItem("minecraft", "planks", 3L, 1),
                        GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 2L),
                        GT_Utility.getIntegratedCircuit(3)}, Materials.Iron.getMolten(16),
                GT_ModHandler.getModItem("malisisdoors", "spruceFenceGate", 2L), 300, 8);
        RA.addAssemblerRecipe(
                new ItemStack[]{GT_ModHandler.getModItem("minecraft", "planks", 3L, 1),
                        GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 2L),
                        GT_Utility.getIntegratedCircuit(3)}, Materials.Steel.getMolten(16),
                GT_ModHandler.getModItem("malisisdoors", "spruceFenceGate", 4L), 300, 8);
        // --- Trapped Door Arcania
        RA.addAssemblerRecipe(
                new ItemStack[]{GT_ModHandler.getModItem("minecraft", "wooden_slab", 4L, 4),
                        GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 4L),
                        GT_Utility.getIntegratedCircuit(1)}, null,
                GT_ModHandler.getModItem("malisisdoors", "trapdoor_acacia", 2L), 600, 4);
        RA.addAssemblerRecipe(
                new ItemStack[]{GT_ModHandler.getModItem("minecraft", "wooden_slab", 4L, 4),
                        GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 4L),
                        GT_Utility.getIntegratedCircuit(2)}, Materials.Iron.getMolten(16),
                GT_ModHandler.getModItem("malisisdoors", "trapdoor_acacia", 4L), 600, 4);
        RA.addAssemblerRecipe(
                new ItemStack[]{GT_ModHandler.getModItem("minecraft", "wooden_slab", 4L, 4),
                        GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 4L),
                        GT_Utility.getIntegratedCircuit(3)}, Materials.Steel.getMolten(16),
                GT_ModHandler.getModItem("malisisdoors", "trapdoor_acacia", 6L), 600, 4);
        // --- Trapped Door Birch
        RA.addAssemblerRecipe(
                new ItemStack[]{GT_ModHandler.getModItem("minecraft", "wooden_slab", 4L, 2),
                        GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 4L),
                        GT_Utility.getIntegratedCircuit(1)}, null,
                GT_ModHandler.getModItem("malisisdoors", "trapdoor_birch", 2L), 600, 4);
        RA.addAssemblerRecipe(
                new ItemStack[]{GT_ModHandler.getModItem("minecraft", "wooden_slab", 4L, 2),
                        GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 4L),
                        GT_Utility.getIntegratedCircuit(2)}, Materials.Iron.getMolten(16),
                GT_ModHandler.getModItem("malisisdoors", "trapdoor_birch", 4L), 600, 4);
        RA.addAssemblerRecipe(
                new ItemStack[]{GT_ModHandler.getModItem("minecraft", "wooden_slab", 4L, 2),
                        GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 4L),
                        GT_Utility.getIntegratedCircuit(3)}, Materials.Steel.getMolten(16),
                GT_ModHandler.getModItem("malisisdoors", "trapdoor_birch", 6L), 600, 4);
        // --- Trapped Door Dark Oak
        RA.addAssemblerRecipe(
                new ItemStack[]{GT_ModHandler.getModItem("minecraft", "wooden_slab", 4L, 5),
                        GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 4L),
                        GT_Utility.getIntegratedCircuit(1)}, null,
                GT_ModHandler.getModItem("malisisdoors", "trapdoor_dark_oak", 2L), 600, 4);
        RA.addAssemblerRecipe(
                new ItemStack[]{GT_ModHandler.getModItem("minecraft", "wooden_slab", 4L, 5),
                        GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 4L),
                        GT_Utility.getIntegratedCircuit(2)}, Materials.Iron.getMolten(16),
                GT_ModHandler.getModItem("malisisdoors", "trapdoor_dark_oak", 4L), 600, 4);
        RA.addAssemblerRecipe(
                new ItemStack[]{GT_ModHandler.getModItem("minecraft", "wooden_slab", 4L, 5),
                        GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 4L),
                        GT_Utility.getIntegratedCircuit(3)}, Materials.Steel.getMolten(16),
                GT_ModHandler.getModItem("malisisdoors", "trapdoor_dark_oak", 6L), 600, 4);
        // --- Trapped Door Jungle
        RA.addAssemblerRecipe(
                new ItemStack[]{GT_ModHandler.getModItem("minecraft", "wooden_slab", 4L, 3),
                        GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 4L),
                        GT_Utility.getIntegratedCircuit(1)}, null,
                GT_ModHandler.getModItem("malisisdoors", "trapdoor_jungle", 2L), 600, 4);
        RA.addAssemblerRecipe(
                new ItemStack[]{GT_ModHandler.getModItem("minecraft", "wooden_slab", 4L, 3),
                        GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 4L),
                        GT_Utility.getIntegratedCircuit(2)}, Materials.Iron.getMolten(16),
                GT_ModHandler.getModItem("malisisdoors", "trapdoor_jungle", 4L), 600, 4);
        RA.addAssemblerRecipe(
                new ItemStack[]{GT_ModHandler.getModItem("minecraft", "wooden_slab", 4L, 3),
                        GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 4L),
                        GT_Utility.getIntegratedCircuit(3)}, Materials.Steel.getMolten(16),
                GT_ModHandler.getModItem("malisisdoors", "trapdoor_jungle", 6L), 600, 4);
        // --- Trapped Door Spruce
        RA.addAssemblerRecipe(
                new ItemStack[]{GT_ModHandler.getModItem("minecraft", "wooden_slab", 4L, 1),
                        GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 4L),
                        GT_Utility.getIntegratedCircuit(1)}, null,
                GT_ModHandler.getModItem("malisisdoors", "trapdoor_spruce", 2L), 600, 4);
        RA.addAssemblerRecipe(
                new ItemStack[]{GT_ModHandler.getModItem("minecraft", "wooden_slab", 4L, 1),
                        GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 4L),
                        GT_Utility.getIntegratedCircuit(2)}, Materials.Iron.getMolten(16),
                GT_ModHandler.getModItem("malisisdoors", "trapdoor_spruce", 4L), 600, 4);
        RA.addAssemblerRecipe(
                new ItemStack[]{GT_ModHandler.getModItem("minecraft", "wooden_slab", 4L, 1),
                        GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 4L),
                        GT_Utility.getIntegratedCircuit(3)}, Materials.Steel.getMolten(16),
                GT_ModHandler.getModItem("malisisdoors", "trapdoor_spruce", 6L), 600, 4);

    }
}
