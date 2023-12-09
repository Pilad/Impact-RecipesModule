package com.impactrecipes.recipes;

import com.impact.common.item.Core_Items2;
import com.impact.mods.gregtech.GT_ItemList;
import gregtech.api.GregTech_API;
import gregtech.api.enums.*;
import gregtech.api.util.GT_ModHandler;
import gregtech.api.util.GT_OreDictUnificator;
import gregtech.api.util.GT_Utility;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

import static com.impact.util.Utilits.Itemstack;
import static gregtech.api.enums.GT_Values.RA;
import static gregtech.api.util.GT_ModHandler.removeRecipeByOutput;

public class OpenComputers implements Runnable {

    private static final long tBitMask = GT_ModHandler.RecipeBits.BUFFERED
            | GT_ModHandler.RecipeBits.NOT_REMOVABLE;

    final Core_Items2 CoreItems2 = Core_Items2.getInstance();

    private final static boolean make_floppy(String displayname, String name, int color,
                                             int circuit) {
        ItemStack floppy = GT_ModHandler.getModItem("OpenComputers", "item", 1L, 4);
        NBTTagCompound tag = new NBTTagCompound(),
                subtag = new NBTTagCompound();
        subtag.setString("Name", displayname);
        tag.setTag("display", subtag);
        subtag = new NBTTagCompound();
        subtag.setString("oc:fs.label", name);
        tag.setTag("oc:data", subtag);
        tag.setInteger("oc:color", color);
        tag.setString("oc:lootFactory", "OpenComputers:" + name);
        floppy.setTagCompound(tag);
        return GT_Values.RA
                .addLaserEngraverRecipe(GT_ModHandler.getModItem("OpenComputers", "item", 1L, 4),
                        GT_Utility.getIntegratedCircuit(circuit), floppy, 200, 120);
    }

    private final static boolean make_lua_bios() {
        ItemStack lua = GT_ModHandler.getModItem("OpenComputers", "eeprom", 1L, 0);
        NBTTagCompound tag = new NBTTagCompound(),
                subtag = new NBTTagCompound();
        subtag.setString("oc:label", "EEPROM (Lua Bios)");
        subtag.setBoolean("oc:readonly", false);
        final byte[] b = {
                108, 111, 99, 97, 108, 32, 99, 111, 109, 112, 111, 110, 101, 110, 116, 95, 105, 110, 118,
                111, 107, 101, 32, 61, 32, 99, 111, 109, 112, 111, 110, 101, 110, 116, 46, 105, 110, 118,
                111, 107, 101, 10, 102, 117, 110, 99, 116, 105, 111, 110, 32, 98, 111, 111, 116, 95, 105,
                110, 118, 111, 107, 101, 40, 97, 100, 100, 114, 101, 115, 115, 44, 32, 109, 101, 116, 104,
                111, 100, 44, 32, 46, 46, 46, 41, 10, 32, 32, 108, 111, 99, 97, 108, 32, 114, 101, 115, 117,
                108, 116, 32, 61, 32, 116, 97, 98, 108, 101, 46, 112, 97, 99, 107, 40, 112, 99, 97, 108,
                108, 40, 99, 111, 109, 112, 111, 110, 101, 110, 116, 95, 105, 110, 118, 111, 107, 101, 44,
                32, 97, 100, 100, 114, 101, 115, 115, 44, 32, 109, 101, 116, 104, 111, 100, 44, 32, 46, 46,
                46, 41, 41, 10, 32, 32, 105, 102, 32, 110, 111, 116, 32, 114, 101, 115, 117, 108, 116, 91,
                49, 93, 32, 116, 104, 101, 110, 10, 32, 32, 32, 32, 114, 101, 116, 117, 114, 110, 32, 110,
                105, 108, 44, 32, 114, 101, 115, 117, 108, 116, 91, 50, 93, 10, 32, 32, 101, 108, 115, 101,
                10, 32, 32, 32, 32, 114, 101, 116, 117, 114, 110, 32, 116, 97, 98, 108, 101, 46, 117, 110,
                112, 97, 99, 107, 40, 114, 101, 115, 117, 108, 116, 44, 32, 50, 44, 32, 114, 101, 115, 117,
                108, 116, 46, 110, 41, 10, 32, 32, 101, 110, 100, 10, 101, 110, 100, 10, 10, 45, 45, 32, 98,
                97, 99, 107, 119, 97, 114, 100, 115, 32, 99, 111, 109, 112, 97, 116, 105, 98, 105, 108, 105,
                116, 121, 44, 32, 109, 97, 121, 32, 114, 101, 109, 111, 118, 101, 32, 108, 97, 116, 101,
                114, 10, 108, 111, 99, 97, 108, 32, 101, 101, 112, 114, 111, 109, 32, 61, 32, 99, 111, 109,
                112, 111, 110, 101, 110, 116, 46, 108, 105, 115, 116, 40, 34, 101, 101, 112, 114, 111, 109,
                34, 41, 40, 41, 10, 99, 111, 109, 112, 117, 116, 101, 114, 46, 103, 101, 116, 66, 111, 111,
                116, 65, 100, 100, 114, 101, 115, 115, 32, 61, 32, 102, 117, 110, 99, 116, 105, 111, 110,
                40, 41, 10, 32, 32, 114, 101, 116, 117, 114, 110, 32, 98, 111, 111, 116, 95, 105, 110, 118,
                111, 107, 101, 40, 101, 101, 112, 114, 111, 109, 44, 32, 34, 103, 101, 116, 68, 97, 116, 97,
                34, 41, 10, 101, 110, 100, 10, 99, 111, 109, 112, 117, 116, 101, 114, 46, 115, 101, 116, 66,
                111, 111, 116, 65, 100, 100, 114, 101, 115, 115, 32, 61, 32, 102, 117, 110, 99, 116, 105,
                111, 110, 40, 97, 100, 100, 114, 101, 115, 115, 41, 10, 32, 32, 114, 101, 116, 117, 114,
                110, 32, 98, 111, 111, 116, 95, 105, 110, 118, 111, 107, 101, 40, 101, 101, 112, 114, 111,
                109, 44, 32, 34, 115, 101, 116, 68, 97, 116, 97, 34, 44, 32, 97, 100, 100, 114, 101, 115,
                115, 41, 10, 101, 110, 100, 10, 10, 100, 111, 10, 32, 32, 108, 111, 99, 97, 108, 32, 115,
                99, 114, 101, 101, 110, 32, 61, 32, 99, 111, 109, 112, 111, 110, 101, 110, 116, 46, 108,
                105, 115, 116, 40, 34, 115, 99, 114, 101, 101, 110, 34, 41, 40, 41, 10, 32, 32, 108, 111,
                99, 97, 108, 32, 103, 112, 117, 32, 61, 32, 99, 111, 109, 112, 111, 110, 101, 110, 116, 46,
                108, 105, 115, 116, 40, 34, 103, 112, 117, 34, 41, 40, 41, 10, 32, 32, 105, 102, 32, 103,
                112, 117, 32, 97, 110, 100, 32, 115, 99, 114, 101, 101, 110, 32, 116, 104, 101, 110, 10, 32,
                32, 32, 32, 98, 111, 111, 116, 95, 105, 110, 118, 111, 107, 101, 40, 103, 112, 117, 44, 32,
                34, 98, 105, 110, 100, 34, 44, 32, 115, 99, 114, 101, 101, 110, 41, 10, 32, 32, 101, 110,
                100, 10, 101, 110, 100, 10, 108, 111, 99, 97, 108, 32, 102, 117, 110, 99, 116, 105, 111,
                110, 32, 116, 114, 121, 76, 111, 97, 100, 70, 114, 111, 109, 40, 97, 100, 100, 114, 101,
                115, 115, 41, 10, 32, 32, 108, 111, 99, 97, 108, 32, 104, 97, 110, 100, 108, 101, 44, 32,
                114, 101, 97, 115, 111, 110, 32, 61, 32, 98, 111, 111, 116, 95, 105, 110, 118, 111, 107,
                101, 40, 97, 100, 100, 114, 101, 115, 115, 44, 32, 34, 111, 112, 101, 110, 34, 44, 32, 34,
                47, 105, 110, 105, 116, 46, 108, 117, 97, 34, 41, 10, 32, 32, 105, 102, 32, 110, 111, 116,
                32, 104, 97, 110, 100, 108, 101, 32, 116, 104, 101, 110, 10, 32, 32, 32, 32, 114, 101, 116,
                117, 114, 110, 32, 110, 105, 108, 44, 32, 114, 101, 97, 115, 111, 110, 10, 32, 32, 101, 110,
                100, 10, 32, 32, 108, 111, 99, 97, 108, 32, 98, 117, 102, 102, 101, 114, 32, 61, 32, 34, 34,
                10, 32, 32, 114, 101, 112, 101, 97, 116, 10, 32, 32, 32, 32, 108, 111, 99, 97, 108, 32, 100,
                97, 116, 97, 44, 32, 114, 101, 97, 115, 111, 110, 32, 61, 32, 98, 111, 111, 116, 95, 105,
                110, 118, 111, 107, 101, 40, 97, 100, 100, 114, 101, 115, 115, 44, 32, 34, 114, 101, 97,
                100, 34, 44, 32, 104, 97, 110, 100, 108, 101, 44, 32, 109, 97, 116, 104, 46, 104, 117, 103,
                101, 41, 10, 32, 32, 32, 32, 105, 102, 32, 110, 111, 116, 32, 100, 97, 116, 97, 32, 97, 110,
                100, 32, 114, 101, 97, 115, 111, 110, 32, 116, 104, 101, 110, 10, 32, 32, 32, 32, 32, 32,
                114, 101, 116, 117, 114, 110, 32, 110, 105, 108, 44, 32, 114, 101, 97, 115, 111, 110, 10,
                32, 32, 32, 32, 101, 110, 100, 10, 32, 32, 32, 32, 98, 117, 102, 102, 101, 114, 32, 61, 32,
                98, 117, 102, 102, 101, 114, 32, 46, 46, 32, 40, 100, 97, 116, 97, 32, 111, 114, 32, 34, 34,
                41, 10, 32, 32, 117, 110, 116, 105, 108, 32, 110, 111, 116, 32, 100, 97, 116, 97, 10, 32,
                32, 98, 111, 111, 116, 95, 105, 110, 118, 111, 107, 101, 40, 97, 100, 100, 114, 101, 115,
                115, 44, 32, 34, 99, 108, 111, 115, 101, 34, 44, 32, 104, 97, 110, 100, 108, 101, 41, 10,
                32, 32, 114, 101, 116, 117, 114, 110, 32, 108, 111, 97, 100, 40, 98, 117, 102, 102, 101,
                114, 44, 32, 34, 61, 105, 110, 105, 116, 34, 41, 10, 101, 110, 100, 10, 108, 111, 99, 97,
                108, 32, 105, 110, 105, 116, 44, 32, 114, 101, 97, 115, 111, 110, 10, 105, 102, 32, 99, 111,
                109, 112, 117, 116, 101, 114, 46, 103, 101, 116, 66, 111, 111, 116, 65, 100, 100, 114, 101,
                115, 115, 40, 41, 32, 116, 104, 101, 110, 10, 32, 32, 105, 110, 105, 116, 44, 32, 114, 101,
                97, 115, 111, 110, 32, 61, 32, 116, 114, 121, 76, 111, 97, 100, 70, 114, 111, 109, 40, 99,
                111, 109, 112, 117, 116, 101, 114, 46, 103, 101, 116, 66, 111, 111, 116, 65, 100, 100, 114,
                101, 115, 115, 40, 41, 41, 10, 101, 110, 100, 10, 105, 102, 32, 110, 111, 116, 32, 105, 110,
                105, 116, 32, 116, 104, 101, 110, 10, 32, 32, 99, 111, 109, 112, 117, 116, 101, 114, 46,
                115, 101, 116, 66, 111, 111, 116, 65, 100, 100, 114, 101, 115, 115, 40, 41, 10, 32, 32, 102,
                111, 114, 32, 97, 100, 100, 114, 101, 115, 115, 32, 105, 110, 32, 99, 111, 109, 112, 111,
                110, 101, 110, 116, 46, 108, 105, 115, 116, 40, 34, 102, 105, 108, 101, 115, 121, 115, 116,
                101, 109, 34, 41, 32, 100, 111, 10, 32, 32, 32, 32, 105, 110, 105, 116, 44, 32, 114, 101,
                97, 115, 111, 110, 32, 61, 32, 116, 114, 121, 76, 111, 97, 100, 70, 114, 111, 109, 40, 97,
                100, 100, 114, 101, 115, 115, 41, 10, 32, 32, 32, 32, 105, 102, 32, 105, 110, 105, 116, 32,
                116, 104, 101, 110, 10, 32, 32, 32, 32, 32, 32, 99, 111, 109, 112, 117, 116, 101, 114, 46,
                115, 101, 116, 66, 111, 111, 116, 65, 100, 100, 114, 101, 115, 115, 40, 97, 100, 100, 114,
                101, 115, 115, 41, 10, 32, 32, 32, 32, 32, 32, 98, 114, 101, 97, 107, 10, 32, 32, 32, 32,
                101, 110, 100, 10, 32, 32, 101, 110, 100, 10, 101, 110, 100, 10, 105, 102, 32, 110, 111,
                116, 32, 105, 110, 105, 116, 32, 116, 104, 101, 110, 10, 32, 32, 101, 114, 114, 111, 114,
                40, 34, 110, 111, 32, 98, 111, 111, 116, 97, 98, 108, 101, 32, 109, 101, 100, 105, 117, 109,
                32, 102, 111, 117, 110, 100, 34, 32, 46, 46, 32, 40, 114, 101, 97, 115, 111, 110, 32, 97,
                110, 100, 32, 40, 34, 58, 32, 34, 32, 46, 46, 32, 116, 111, 115, 116, 114, 105, 110, 103,
                40, 114, 101, 97, 115, 111, 110, 41, 41, 32, 111, 114, 32, 34, 34, 41, 44, 32, 48, 41, 10,
                101, 110, 100, 10, 99, 111, 109, 112, 117, 116, 101, 114, 46, 98, 101, 101, 112, 40, 49, 48,
                48, 48, 44, 32, 48, 46, 50, 41, 10, 105, 110, 105, 116, 40, 41
        };
        subtag.setByteArray("oc:eeprom", b);
        tag.setTag("oc:data", subtag);
        lua.setTagCompound(tag);
        return GT_Values.RA
                .addLaserEngraverRecipe(GT_ModHandler.getModItem("OpenComputers", "eeprom", 1L, 0),
                        GT_Utility.getIntegratedCircuit(1), lua, 200, 120);
    }

    @Override
    public void run() {

        removeOC();

        RA.addCutterRecipe(CoreItems2.getRecipe(158, 1),
                GT_ModHandler.getModItem("OpenComputers", "item", 16L, 28), null, 400, 16);
        RA.addCutterRecipe(CoreItems2.getRecipe(157, 1),
                GT_ModHandler.getModItem("OpenComputers", "item", 16L, 27), null, 400, 16);

        GT_ModHandler
                .addShapelessCraftingRecipe(GT_ModHandler.getModItem("OpenComputers", "cable", 1L, 0),
                        GT_ModHandler.RecipeBits.NOT_REMOVABLE,
                        new Object[]{OrePrefixes.cableGt02.get(Materials.Gold)});
        //scrench
        GT_ModHandler
                .addCraftingRecipe(GT_ModHandler.getModItem("OpenComputers", "wrench", 1, 0), tBitMask,
                        new Object[]{"PhP", " C ", " S ", 'P', OrePrefixes.plate.get(Materials.Steel), 'S',
                                OrePrefixes.stick.get(Materials.Steel), 'C',
                                GT_ModHandler.getModItem("OpenComputers", "item", 1L, 25)});
        //case 1
        GT_ModHandler
                .addCraftingRecipe(GT_ModHandler.getModItem("OpenComputers", "case1", 1, 0), tBitMask,
                        new Object[]{"SCS", "VHV", "SBS", 'H', ItemList.Hull_MV, 'B',
                                OrePrefixes.circuit.get(Materials.Good), 'V',
                                GT_ModHandler.getModItem("IC2", "reactorVent", 1L, 1), 'C',
                                GT_ModHandler.getModItem("OpenComputers", "item", 1L, 24), 'S',
                                OrePrefixes.screw.get(Materials.Aluminium)});
        //case 2
        GT_ModHandler
                .addCraftingRecipe(GT_ModHandler.getModItem("OpenComputers", "case2", 1, 0), tBitMask,
                        new Object[]{"SCS", "VHV", "SBS", 'H', ItemList.Hull_HV, 'B',
                                OrePrefixes.circuit.get(Materials.Advanced), 'V',
                                GT_ModHandler.getModItem("IC2", "reactorVentGold", 1L, 1), 'C',
                                GT_ModHandler.getModItem("OpenComputers", "item", 1L, 25), 'S',
                                OrePrefixes.screw.get(Materials.StainlessSteel)});
        //case 3
        GT_ModHandler
                .addCraftingRecipe(GT_ModHandler.getModItem("OpenComputers", "case3", 1, 0), tBitMask,
                        new Object[]{"SCS", "VHV", "SBS", 'H', ItemList.Hull_EV, 'B',
                                OrePrefixes.circuit.get(Materials.Data), 'V',
                                GT_ModHandler.getModItem("IC2", "reactorVentDiamond", 1L, 1), 'C',
                                GT_ModHandler.getModItem("OpenComputers", "item", 1L, 26), 'S',
                                OrePrefixes.screw.get(Materials.Titanium)});
        //disk
        GT_ModHandler
                .addCraftingRecipe(GT_ModHandler.getModItem("OpenComputers", "item", 1L, 19), tBitMask,
                        new Object[]{"D", "P", "B", 'D', OrePrefixes.dust.get(Materials.NeodymiumMagnetic), 'P',
                                OrePrefixes.plate.get(Materials.Silicon), 'B',
                                OrePrefixes.bolt.get(Materials.StainlessSteel)});
        //rack
        GT_ModHandler
                .addCraftingRecipe(GT_ModHandler.getModItem("OpenComputers", "rack", 1L, 0), tBitMask,
                        new Object[]{"PWP", "VHV", "RBD", 'P',
                                OrePrefixes.itemCasing.get(Materials.StainlessSteel), 'V',
                                GT_ModHandler.getModItem("IC2", "reactorVentDiamond", 1L, 1), 'H',
                                ItemList.Casing_HV, 'B', OrePrefixes.circuit.get(Materials.Advanced), 'W',
                                GT_ModHandler.getModItem("OpenComputers", "item", 1L, 13), 'R',
                                GT_ModHandler.getModItem("OpenComputers", "relay", 1L, 0), 'D',
                                GT_ModHandler.getModItem("OpenComputers", "powerDistributor", 1L, 0)});
        //adapter block
        GT_ModHandler
                .addCraftingRecipe(GT_ModHandler.getModItem("OpenComputers", "adapter", 1L, 0), tBitMask,
                        new Object[]{"PCP", "WHW", "PBP", 'P',
                                OrePrefixes.itemCasing.get(Materials.Birmabright), 'C',
                                GT_ModHandler.getModItem("OpenComputers", "item", 1L, 24), 'H', ItemList.Casing_MV,
                                'B', OrePrefixes.circuit.get(Materials.Good), 'W',
                                GT_ModHandler.getModItem("OpenComputers", "cable", 2L, 0)});
        //assembler
        GT_ModHandler
                .addCraftingRecipe(GT_ModHandler.getModItem("OpenComputers", "assembler", 1L, 0), tBitMask,
                        new Object[]{"PMP", "RHR", "PCP", 'P', OrePrefixes.plate.get(Materials.Birmabright),
                                'C', GT_ModHandler.getModItem("OpenComputers", "item", 1L, 25), 'H',
                                ItemList.Casing_MV, 'M', ItemList.Cover_Screen, 'R', ItemList.Robot_Arm_MV});
        //disassembler
        GT_ModHandler
                .addCraftingRecipe(GT_ModHandler.getModItem("OpenComputers", "disassembler", 1L, 0),
                        tBitMask,
                        new Object[]{"UMA", "PHR", "LCL", 'L', OrePrefixes.plate.get(Materials.StainlessSteel),
                                'A', GT_ModHandler.getModItem("OpenComputers", "item", 1L, 0), 'U',
                                GT_ModHandler.getModItem("OpenComputers", "item", 1L, 28), 'C',
                                GT_ModHandler.getModItem("OpenComputers", "item", 1L, 25), 'H', ItemList.Casing_HV,
                                'M', ItemList.Cover_Screen, 'R', ItemList.Robot_Arm_HV, 'P',
                                ItemList.Electric_Piston_HV});
        //capacitor
        GT_ModHandler
                .addCraftingRecipe(GT_ModHandler.getModItem("OpenComputers", "capacitor", 1L, 0), tBitMask,
                        new Object[]{"PBP", "WHW", "PCP", 'P', OrePrefixes.plate.get(Materials.Invar), 'W',
                                GT_ModHandler.getModItem("OpenComputers", "cable", 1L, 0), 'C',
                                OrePrefixes.circuit.get(Materials.Good), 'H', ItemList.Battery_Buffer_1by1_MV, 'B',
                                ItemList.Battery_RE_MV_Lithium});
        //charger
        GT_ModHandler
                .addCraftingRecipe(GT_ModHandler.getModItem("OpenComputers", "charger", 1L, 0), tBitMask,
                        new Object[]{"PCP", "AHA", "PBP", 'P', OrePrefixes.plate.get(Materials.Invar), 'C',
                                GT_ModHandler.getModItem("OpenComputers", "item", 1L, 24), 'B',
                                OrePrefixes.circuit.get(Materials.Good), 'H', ItemList.Hull_MV, 'A',
                                GT_ModHandler.getModItem("OpenComputers", "capacitor", 1L, 0)});
        //diskDrive
        GT_ModHandler
                .addCraftingRecipe(GT_ModHandler.getModItem("OpenComputers", "diskDrive", 1L, 0), tBitMask,
                        new Object[]{"PCP", "HSL", "PMP", 'P', OrePrefixes.plate.get(Materials.Aluminium), 'C',
                                GT_ModHandler.getModItem("OpenComputers", "item", 1L, 24), 'S',
                                OrePrefixes.stick.get(Materials.IronMagnetic), 'L',
                                OrePrefixes.lens.get(Materials.Glass), 'H', ItemList.Hull_MV, 'M',
                                ItemList.Electric_Motor_MV});
        //geolyzer
        GT_ModHandler
                .addCraftingRecipe(GT_ModHandler.getModItem("OpenComputers", "geolyzer", 1L, 0), tBitMask,
                        new Object[]{"PAP", "SHS", "PCP", 'P', OrePrefixes.plate.get(Materials.Birmabright),
                                'C', GT_ModHandler.getModItem("OpenComputers", "item", 1L, 24), 'A',
                                GT_ModHandler.getModItem("OpenComputers", "item", 1L, 0), 'H', ItemList.Hull_MV,
                                'S', ItemList.Sensor_MV});
        //hologram1
        GT_ModHandler
                .addCraftingRecipe(GT_ModHandler.getModItem("OpenComputers", "hologram1", 1L, 0), tBitMask,
                        new Object[]{"CLC", "PEP", "BHB", 'P', OrePrefixes.plate.get(Materials.Aluminium), 'C',
                                GT_ModHandler.getModItem("OpenComputers", "item", 1L, 24), 'H', ItemList.Hull_MV,
                                'E', ItemList.Emitter_MV, 'L', OrePrefixes.lens.get(Materials.Glass), 'B',
                                OrePrefixes.circuit.get(Materials.Good)});
        //hologram2
        GT_ModHandler
                .addCraftingRecipe(GT_ModHandler.getModItem("OpenComputers", "hologram2", 1L, 0), tBitMask,
                        new Object[]{"RGB", "CEC", "OHO", 'C',
                                GT_ModHandler.getModItem("OpenComputers", "item", 1L, 25), 'H', ItemList.Casing_HV,
                                'E', ItemList.Emitter_HV, 'R', "craftingLensRed", 'G', "craftingLensGreen", 'B',
                                "craftingLensBlue", 'O', OrePrefixes.circuit.get(Materials.Advanced)});
        //motionSensor
        GT_ModHandler
                .addCraftingRecipe(GT_ModHandler.getModItem("OpenComputers", "motionSensor", 1L, 0),
                        tBitMask, new Object[]{"PMP", "SHE", "BUB", 'U',
                                GT_ModHandler.getModItem("OpenComputers", "item", 1L, 42), 'H', ItemList.Casing_MV,
                                'E', ItemList.Emitter_MV, 'S', ItemList.Sensor_MV, 'M', ItemList.Cover_Screen, 'B',
                                OrePrefixes.circuit.get(Materials.Good), 'P',
                                OrePrefixes.plate.get(Materials.Aluminium)});
        //netSplitter
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("OpenComputers", "netSplitter", 1L, 0),
                tBitMask, new Object[]{"WPW", " H ", "CWw", 'W',
                        GT_ModHandler.getModItem("OpenComputers", "cable", 1L, 0), 'H', ItemList.Casing_LV, 'P',
                        ItemList.Electric_Piston_LV, 'C', OrePrefixes.circuit.get(Materials.Basic)});
        //printer
        GT_ModHandler
                .addCraftingRecipe(GT_ModHandler.getModItem("OpenComputers", "printer", 1L, 0), tBitMask,
                        new Object[]{" Ow", "RHE", "BCB", 'C',
                                GT_ModHandler.getModItem("OpenComputers", "item", 1L, 25), 'H', ItemList.Casing_HV,
                                'R', ItemList.Robot_Arm_HV, 'O', ItemList.Conveyor_Module_HV, 'E',
                                ItemList.Emitter_HV, 'B', OrePrefixes.circuit.get(Materials.Advanced)});
        //powerConverter
        GT_ModHandler
                .addCraftingRecipe(GT_ModHandler.getModItem("OpenComputers", "powerConverter", 1L, 0),
                        tBitMask, new Object[]{"PWP", "CTC", "PWP", 'C',
                                GT_ModHandler.getModItem("OpenComputers", "item", 1L, 25), 'T',
                                ItemList.Transformer_HV_MV, 'W',
                                GT_ModHandler.getModItem("OpenComputers", "cable", 1L, 0), 'P',
                                OrePrefixes.plate.get(Materials.Aluminium)});
        //powerDistributor
        GT_ModHandler
                .addCraftingRecipe(GT_ModHandler.getModItem("OpenComputers", "powerDistributor", 1L, 0),
                        tBitMask, new Object[]{" P ", "WHB", "CPw", 'C',
                                GT_ModHandler.getModItem("OpenComputers", "item", 1L, 24), 'W',
                                GT_ModHandler.getModItem("OpenComputers", "cable", 1L, 0), 'H', ItemList.Casing_MV,
                                'B', ItemList.MV_Coil, 'P', OrePrefixes.plate.get(Materials.Aluminium)});
        //raid
        GT_ModHandler
                .addCraftingRecipe(GT_ModHandler.getModItem("OpenComputers", "raid", 1L, 0), tBitMask,
                        new Object[]{"PUP", "MDM", "WCw", 'M',
                                GT_ModHandler.getModItem("OpenComputers", "item", 1L, 1), 'U',
                                GT_ModHandler.getModItem("OpenComputers", "item", 1L, 43), 'C',
                                GT_ModHandler.getModItem("OpenComputers", "item", 1L, 25), 'W',
                                GT_ModHandler.getModItem("OpenComputers", "cable", 1L, 0), 'D',
                                GT_ModHandler.getModItem("OpenComputers", "diskDrive", 1L, 0), 'P',
                                OrePrefixes.plate.get(Materials.StainlessSteel)});
        //redstone
        GT_ModHandler
                .addCraftingRecipe(GT_ModHandler.getModItem("OpenComputers", "redstone", 1L, 0), tBitMask,
                        new Object[]{"PDP", "RHR", "PCP", 'D',
                                GT_ModHandler.getModItem("OpenComputers", "item", 1L, 66), 'C',
                                GT_ModHandler.getModItem("OpenComputers", "item", 1L, 25), 'H', ItemList.Casing_HV,
                                'P', OrePrefixes.plate.get(Materials.StainlessSteel), 'R',
                                OrePrefixes.plate.get(Materials.RedAlloy)});
        //relay
        GT_ModHandler
                .addCraftingRecipe(GT_ModHandler.getModItem("OpenComputers", "relay", 1L, 0), tBitMask,
                        new Object[]{"PNP", "WHW", "PCP", 'N',
                                GT_ModHandler.getModItem("OpenComputers", "item", 1L, 11), 'C',
                                GT_ModHandler.getModItem("OpenComputers", "item", 1L, 25), 'W',
                                GT_ModHandler.getModItem("OpenComputers", "cable", 1L, 0), 'H', ItemList.Casing_MV,
                                'P', OrePrefixes.plate.get(Materials.Aluminium)});
        //transposer
        GT_ModHandler
                .addCraftingRecipe(GT_ModHandler.getModItem("OpenComputers", "transposer", 4L, 0), tBitMask,
                        new Object[]{"PCP", "IHT", "PUP", 'I',
                                GT_ModHandler.getModItem("OpenComputers", "item", 1L, 61), 'T',
                                GT_ModHandler.getModItem("OpenComputers", "item", 1L, 77), 'H', ItemList.Casing_MV,
                                'C', ItemList.Conveyor_Module_MV, 'U', ItemList.Electric_Pump_MV, 'P',
                                OrePrefixes.plate.get(Materials.Aluminium)});
        //waypoint
        GT_ModHandler
                .addCraftingRecipe(GT_ModHandler.getModItem("OpenComputers", "waypoint", 4L, 0), tBitMask,
                        new Object[]{"IEI", "CHC", "BwB", 'I',
                                GT_ModHandler.getModItem("OpenComputers", "item", 1L, 48), 'C',
                                GT_ModHandler.getModItem("OpenComputers", "item", 1L, 24), 'H', ItemList.Casing_MV,
                                'E', ItemList.Emitter_MV, 'B', OrePrefixes.circuit.get(Materials.Good)});

        //Laptop
        GT_ModHandler.addCraftingRecipe(ItemList.Tool_NoteBook.get(1L), tBitMask,
                new Object[]{"BMB", "ACE", "POP", 'M', ItemList.Cover_Screen, 'A',
                        ItemList.Battery_RE_MV_Lithium, 'C',
                        GT_ModHandler.getModItem("OpenComputers", "item", 1L, 29), 'E',
                        GT_ModHandler.getModItem("OpenComputers", "item", 1L, 1), 'O',
                        GT_ModHandler.getModItem("OpenComputers", "keyboard", 1L, 0), 'B',
                        OrePrefixes.bolt.get(Materials.Aluminium), 'P',
                        OrePrefixes.itemCasing.get(Materials.Aluminium)});

        // --- Glasses Terminal
        GT_ModHandler
                .addCraftingRecipe(GT_ModHandler.getModItem("openglasses", "openglassesterminal", 1L, 0),
                        tBitMask, new Object[]{"SCS", "MGW", "SUS", 'W',
                                GT_ModHandler.getModItem("OpenComputers", "item", 1L, 113), 'C',
                                GT_ModHandler.getModItem("OpenComputers", "item", 1L, 25), 'U',
                                GT_ModHandler.getModItem("OpenComputers", "item", 1L, 42), 'M',
                                GT_ModHandler.getModItem("OpenComputers", "item", 1L, 3), 'G',
                                GT_ModHandler.getModItem("OpenComputers", "geolyzer", 1L, 0), 'S',
                                OrePrefixes.screw.get(Materials.StainlessSteel)});
        // --- AR Glasses
        GT_ModHandler
                .addCraftingRecipe(GT_ModHandler.getModItem("openglasses", "openglasses", 1L, 0), tBitMask,
                        new Object[]{"GSG", "RWR", "NdN", 'G',
                                GT_ModHandler.getModItem("OpenComputers", "item", 1L, 9), 'W',
                                GT_ModHandler.getModItem("OpenComputers", "item", 1L, 113), 'N',
                                GT_ModHandler.getModItem("OpenComputers", "screen2", 1L, 0), 'S',
                                OrePrefixes.screw.get(Materials.StainlessSteel), 'R',
                                OrePrefixes.ring.get(Materials.StainlessSteel)});

        // --- Terminal Glasses Bridge
        GT_ModHandler.addShapelessCraftingRecipe(
                GT_ModHandler.getModItem("OpenPeripheral", "glassesbridge", 1L, 0),
                GT_ModHandler.RecipeBits.NOT_REMOVABLE,
                new Object[]{GT_ModHandler.getModItem("openglasses", "openglassesterminal", 1L, 0)});
        // --- Terminal Glasses
        GT_ModHandler
                .addShapelessCraftingRecipe(GT_ModHandler.getModItem("OpenPeripheral", "glasses", 1L, 0),
                        GT_ModHandler.RecipeBits.NOT_REMOVABLE,
                        new Object[]{GT_ModHandler.getModItem("openglasses", "openglasses", 1L, 0)});
        // --- Sensor
        GT_ModHandler
                .addCraftingRecipe(GT_ModHandler.getModItem("OpenPeripheral", "sensor", 1L, 0), tBitMask,
                        new Object[]{" S ", " M ", "CHw", 'C',
                                GT_ModHandler.getModItem("OpenComputers", "item", 1L, 42), 'S', ItemList.Sensor_MV,
                                'M', ItemList.Electric_Motor_MV, 'H', ItemList.Casing_MV});
        // --- PIM
        GT_ModHandler
                .addCraftingRecipe(GT_ModHandler.getModItem("OpenPeripheral", "pim", 1L, 0), tBitMask,
                        new Object[]{"PRP", "CHw", 'C',
                                GT_ModHandler.getModItem("OpenComputers", "item", 1L, 66), 'R',
                                GT_ModHandler.getModItem("minecraft", "heavy_weighted_pressure_plate", 1L, 0), 'H',
                                ItemList.Casing_MV, 'P', OrePrefixes.plate.get(Materials.Aluminium)});
        // --- Item Selector
        GT_ModHandler
                .addCraftingRecipe(GT_ModHandler.getModItem("OpenPeripheral", "selector", 1L, 0), tBitMask,
                        new Object[]{"PRP", "CHw", 'C',
                                GT_ModHandler.getModItem("OpenComputers", "item", 1L, 66), 'R',
                                ItemList.Cover_ItemDetector, 'H', ItemList.Casing_MV, 'P',
                                OrePrefixes.plate.get(Materials.Aluminium)});

        // --- Grog
        RA.addChemicalRecipe(Materials.Acetone.getCells(1), Materials.Sugar.getDust(1),
                Materials.SulfuricAcid.getFluid(1000), null,
                GT_ModHandler.getModItem("OpenComputers", "item", 1L, 18), ItemList.Cell_Empty.get(1), 800,
                480);
        RA.addChemicalRecipe(Materials.SulfuricAcid.getCells(1), Materials.Sugar.getDust(1),
                Materials.Acetone.getFluid(1000), null,
                GT_ModHandler.getModItem("OpenComputers", "item", 1L, 18), ItemList.Cell_Empty.get(1), 800,
                480);

        // --- Computronics
        // --- Cipher Block
        GT_ModHandler
                .addCraftingRecipe(GT_ModHandler.getModItem("computronics", "computronics.cipher", 1L, 0),
                        tBitMask, new Object[]{"SRS", "WHW", "CPC", 'C',
                                GT_ModHandler.getModItem("OpenComputers", "item", 1L, 25), 'R',
                                ItemList.Robot_Arm_MV, 'H', ItemList.Casing_MV, 'P',
                                OrePrefixes.plate.get(Materials.Silicon), 'S',
                                OrePrefixes.screw.get(Materials.Aluminium), 'W',
                                OrePrefixes.cableGt01.get(Materials.Copper)});
        // --- Speech Box
        GT_ModHandler.addCraftingRecipe(
                GT_ModHandler.getModItem("computronics", "computronics.speechBox", 1L, 0), tBitMask,
                new Object[]{"SCS", "PHP", "WRW", 'C',
                        GT_ModHandler.getModItem("OpenComputers", "item", 1L, 25), 'R',
                        GT_ModHandler.getModItem("computronics", "computronics.speaker", 1L, 0), 'H',
                        ItemList.Casing_MV, 'P', OrePrefixes.plate.get(Materials.Silicon), 'S',
                        OrePrefixes.screw.get(Materials.Aluminium), 'W',
                        OrePrefixes.wireGt02.get(Materials.Gold)});
        // --- Iron Note Block
        GT_ModHandler.addCraftingRecipe(
                GT_ModHandler.getModItem("computronics", "computronics.ironNoteBlock", 1L, 0), tBitMask,
                new Object[]{"PPP", "BNB", "PPP", 'N',
                        GT_ModHandler.getModItem("minecraft", "noteblock", 1L, 0), 'P',
                        OrePrefixes.plate.get(Materials.Iron), 'B', CoreItems2.getRecipe(51, 1)});
        // --- Radar
        GT_ModHandler
                .addCraftingRecipe(GT_ModHandler.getModItem("computronics", "computronics.radar", 1L, 0),
                        tBitMask, new Object[]{"CSC", "BEB", "WHW", 'C',
                                GT_ModHandler.getModItem("OpenComputers", "item", 1L, 25), 'B',
                                OrePrefixes.circuit.get(Materials.Advanced), 'H', ItemList.Casing_HV, 'S',
                                ItemList.Sensor_HV, 'E', ItemList.Emitter_HV, 'W',
                                OrePrefixes.cableGt02.get(Materials.Gold)});

                //button group
                RA.addAssemblerRecipe(new ItemStack[]{new ItemStack(Blocks.stone_button, 6),
                                GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Aluminium, 1L),
                                GT_Utility.getIntegratedCircuit(2)}, GT_Values.NF,
                        GT_ModHandler.getModItem("OpenComputers", "item", 1L, 20), 50, 16);
                //keyboard
                RA.addAssemblerRecipe(
                        new ItemStack[]{GT_ModHandler.getModItem("OpenComputers", "item", 24L, 20),
                                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Basic, 1),
                                GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Aluminium, 1L),
                                GT_Utility.getIntegratedCircuit(1)}, GT_Values.NF,
                        GT_ModHandler.getModItem("OpenComputers", "keyboard", 1L, 0), 200, 64);
                //micro case 1
                RA.addAssemblerRecipe(new ItemStack[]{ItemList.Casing_MV.get(1L),
                                ItemList.Circuit_Board_Phenolic_Good.get(1L),
                                GT_ModHandler.getModItem("OpenComputers", "item", 1L, 25),
                                GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Aluminium, 1L),
                                GT_Utility.getIntegratedCircuit(1)}, Materials.Plastic.getMolten(72L),
                        GT_ModHandler.getModItem("OpenComputers", "item", 1L, 82), 200, 120);
                //mirco case 2
                RA.addAssemblerRecipe(new ItemStack[]{ItemList.Casing_HV.get(1L),
                                ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                                GT_ModHandler.getModItem("OpenComputers", "item", 1L, 26),
                                GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.StainlessSteel, 1L),
                                GT_Utility.getIntegratedCircuit(1)}, Materials.Plastic.getMolten(72L),
                        GT_ModHandler.getModItem("OpenComputers", "item", 1L, 86), 200, 256);
                //drone case 1
                RA.addAssemblerRecipe(
                        new ItemStack[]{GT_ModHandler.getModItem("OpenComputers", "item", 1L, 82),
                                GT_ModHandler.getModItem("OpenComputers", "item", 1L, 71),
                                GT_ModHandler.getModItem("OpenComputers", "item", 2L, 25),
                                GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.Aluminium, 4L),
                                GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Aluminium, 1L),
                                ItemList.Electric_Motor_HV.get(4L)}, Materials.Plastic.getMolten(72L),
                        GT_ModHandler.getModItem("OpenComputers", "item", 1, 83), 300, 256);
                //drone case 2
                RA.addAssemblerRecipe(
                        new ItemStack[]{GT_ModHandler.getModItem("OpenComputers", "item", 1L, 86),
                                GT_ModHandler.getModItem("OpenComputers", "item", 1L, 72),
                                GT_ModHandler.getModItem("OpenComputers", "item", 2L, 26),
                                GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.Titanium, 4L),
                                GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Titanium, 1L),
                                ItemList.Electric_Motor_EV.get(4L)}, Materials.Plastic.getMolten(72L),
                        GT_ModHandler.getModItem("OpenComputers", "item", 1, 87), 300, 480);
                //Card
                RA.addAssemblerRecipe(
                        new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Iron, 1),
                                ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Gold, 1),
                                GT_Utility.getIntegratedCircuit(2)}, GT_Values.NF,
                        GT_ModHandler.getModItem("OpenComputers", "item", 1L, 33), 200, 64);
                //floppy
                RA.addAssemblerRecipe(
                        new ItemStack[]{GT_ModHandler.getModItem("OpenComputers", "item", 1L, 19),
                                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Plastic, 4),
                                GT_Utility.getIntegratedCircuit(1)}, GT_Values.NF,
                        GT_ModHandler.getModItem("OpenComputers", "item", 1L, 4), 200, 64);

                //floppys w NBT
                make_floppy("OpenOS (Operating System)", "openos", 2, 1);
                make_floppy("Plan9k (Operating System)", "plan9k", 1, 2);
                make_floppy("Network (Network Stack)", "network", 10, 3);
                make_floppy("Data Card Software", "data", 9, 4);
                make_floppy("OpenLoader (Boot Loader)", "openloader", 13, 5);
                make_floppy("Builder", "builder", 11, 6);
                make_floppy("Generator", "generator", 5, 7);
                make_floppy("OPPM (Package Manager)", "oppm", 6, 8);
                make_floppy("Digger", "dig", 3, 9);
                make_floppy("Mazer", "maze", 14, 10);
                make_floppy("OpenIRC (IRC Client)", "irc", 12, 11);

                //HDD 1
                RA.addAssemblerRecipe(new ItemStack[]{
                                GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Aluminium, 2L),
                                GT_ModHandler.getModItem("OpenComputers", "item", 1L, 19),
                                GT_ModHandler.getModItem("OpenComputers", "item", 1L, 24),
                                GT_ModHandler.getModItem("OpenComputers", "item", 2L, 1),
                                GT_Utility.getIntegratedCircuit(1)}, GT_Values.NF,
                        GT_ModHandler.getModItem("OpenComputers", "item", 1L, 5), 300, 120);
                //HDD 2
                RA.addAssemblerRecipe(new ItemStack[]{
                                GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.StainlessSteel, 2L),
                                GT_ModHandler.getModItem("OpenComputers", "item", 2L, 19),
                                GT_ModHandler.getModItem("OpenComputers", "item", 1L, 25),
                                GT_ModHandler.getModItem("OpenComputers", "item", 2L, 2),
                                GT_Utility.getIntegratedCircuit(1)}, GT_Values.NF,
                        GT_ModHandler.getModItem("OpenComputers", "item", 1L, 6), 300, 256);
                //HDD 3
                RA.addAssemblerRecipe(new ItemStack[]{
                                GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Titanium, 2L),
                                GT_ModHandler.getModItem("OpenComputers", "item", 4L, 19),
                                GT_ModHandler.getModItem("OpenComputers", "item", 1L, 26),
                                GT_ModHandler.getModItem("OpenComputers", "item", 2L, 38),
                                GT_Utility.getIntegratedCircuit(1)}, GT_Values.NF,
                        GT_ModHandler.getModItem("OpenComputers", "item", 1L, 7), 300, 480);
                //diskDriver
                RA.addAssemblerRecipe(
                        new ItemStack[]{GT_ModHandler.getModItem("OpenComputers", "diskDrive", 1L, 0),
                                GT_ModHandler.getModItem("OpenComputers", "item", 1L, 24),
                                ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                                GT_ModHandler.getModItem("IC2", "reactorVentDiamond", 1L, 1),
                                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.StainlessSteel, 4),
                                GT_Utility.getIntegratedCircuit(1)}, Materials.Plastic.getMolten(72L),
                        GT_ModHandler.getModItem("OpenComputers", "item", 1L, 109), 200, 480);
                //cartridge empty
                RA.addAssemblerRecipe(
                        new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                                GT_ModHandler.getModItem("OpenComputers", "item", 1L, 24),
                                ItemList.Circuit_Parts_Transistor.get(2L),
                                GT_OreDictUnificator.get(OrePrefixes.pipeTiny, Materials.Plastic, 4),
                                GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Electrum, 8L),
                                GT_Utility.getIntegratedCircuit(1)}, Materials.Plastic.getMolten(36L),
                        GT_ModHandler.getModItem("OpenComputers", "item", 1L, 94), 200, 64);
                //Interweb
                RA.addAssemblerRecipe(
                        new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Plastic, 1),
                                ItemList.Circuit_Parts_GlassFiber.get(4), GT_Utility.getIntegratedCircuit(2)}, null,
                        GT_ModHandler.getModItem("OpenComputers", "item", 1L, 48), 200, 64);
                //Linked Card
                RA.addAssemblerRecipe(
                        new ItemStack[]{GT_ModHandler.getModItem("OpenComputers", "item", 2L, 13),
                                GT_ModHandler.getModItem("OpenComputers", "item", 2L, 28),
                                GT_ModHandler.getModItem("OpenComputers", "item", 1L, 26),
                                GT_ModHandler.getModItem("OpenComputers", "item", 1L, 48),
                                GT_Utility.getIntegratedCircuit(1)}, Materials.EnderEye.getMolten(288L),
                        GT_ModHandler.getModItem("OpenComputers", "item", 2L, 51), 400, 480);
                //Manual
                RA.addAssemblerRecipe(new ItemStack[]{new ItemStack(Items.book, 1, 0),
                                GT_ModHandler.getModItem("OpenComputers", "item", 1L, 24),
                                GT_Utility.getIntegratedCircuit(1)}, Materials.Glue.getFluid(144L),
                        GT_ModHandler.getModItem("OpenComputers", "item", 1L, 98), 100, 30);
                //Nano Machine
                RA.addAssemblerRecipe(
                        new ItemStack[]{GT_ModHandler.getModItem("OpenComputers", "capacitor", 1L, 0),
                                GT_ModHandler.getModItem("OpenComputers", "item", 2L, 2),
                                GT_ModHandler.getModItem("OpenComputers", "item", 1L, 13),
                                GT_ModHandler.getModItem("OpenComputers", "item", 2L, 42),
                                GT_ModHandler.getModItem("OpenComputers", "item", 1L, 18),
                                GT_ModHandler.getModItem("OpenComputers", "item", 9L, 96)},
                        Materials.Plastic.getMolten(144L),
                        GT_ModHandler.getModItem("OpenComputers", "item", 1L, 107), 400, 256);
                //Server Tier 1
                RA.addAssemblerRecipe(
                        new ItemStack[]{ItemList.Circuit_Board_Phenolic_Good.get(1L),
                                GT_ModHandler.getModItem("OpenComputers", "case1", 1L, 0),
                                GT_ModHandler.getModItem("OpenComputers", "item", 2L, 24),
                                GT_ModHandler.getModItem("OpenComputers", "item", 1L, 25),
                                GT_ModHandler.getModItem("OpenComputers", "item", 1L, 3),
                                GT_Utility.getIntegratedCircuit(1)}, Materials.Plastic.getMolten(144L),
                        GT_ModHandler.getModItem("OpenComputers", "item", 1L, 45), 400, 256);
                //Server Tier 2
                RA.addAssemblerRecipe(
                        new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                                GT_ModHandler.getModItem("OpenComputers", "case2", 1L, 0),
                                GT_ModHandler.getModItem("OpenComputers", "item", 2L, 25),
                                GT_ModHandler.getModItem("OpenComputers", "item", 1L, 26),
                                GT_ModHandler.getModItem("OpenComputers", "item", 2L, 38),
                                GT_Utility.getIntegratedCircuit(1)}, Materials.Plastic.getMolten(144L),
                        GT_ModHandler.getModItem("OpenComputers", "item", 1L, 46), 400, 480);
                //Server Tier 3
                RA.addAssemblerRecipe(
                        new ItemStack[]{ItemList.Circuit_Board_Epoxy_Advanced.get(1L),
                                GT_ModHandler.getModItem("OpenComputers", "case3", 1L, 0),
                                GT_ModHandler.getModItem("OpenComputers", "item", 2L, 26),
                                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Data, 1L),
                                GT_ModHandler.getModItem("OpenComputers", "item", 2L, 39),
                                GT_Utility.getIntegratedCircuit(1)}, Materials.Plastic.getMolten(144L),
                        GT_ModHandler.getModItem("OpenComputers", "item", 1L, 40), 400, 1024);
                //Tablet Case Tier 1
                RA.addAssemblerRecipe(
                        new ItemStack[]{GT_ModHandler.getModItem("OpenComputers", "screen2", 1L, 0),
                                ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                                GT_ModHandler.getModItem("OpenComputers", "item", 1L, 25),
                                GT_ModHandler.getModItem("OpenComputers", "item", 1L, 70),
                                GT_ModHandler.getModItem("OpenComputers", "item", 2L, 24),
                                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Electrum, 4L)},
                        Materials.Plastic.getMolten(72L),
                        GT_ModHandler.getModItem("OpenComputers", "item", 1L, 74), 400, 120);
                //Tablet Case Tier 2
                RA.addAssemblerRecipe(
                        new ItemStack[]{GT_ModHandler.getModItem("OpenComputers", "screen2", 1L, 0),
                                ItemList.Circuit_Board_Epoxy_Advanced.get(1L),
                                GT_ModHandler.getModItem("OpenComputers", "item", 1L, 26),
                                GT_ModHandler.getModItem("OpenComputers", "item", 1L, 72),
                                GT_ModHandler.getModItem("OpenComputers", "item", 2L, 25),
                                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Electrum, 4L)},
                        Materials.Plastic.getMolten(72L),
                        GT_ModHandler.getModItem("OpenComputers", "item", 1L, 92), 400, 256);
                // --- Remote Terminal
                RA.addAssemblerRecipe(
                        new ItemStack[]{CoreItems2.getRecipe(182, 1),
                                GT_ModHandler.getModItem("OpenComputers", "item", 1L, 13),
                                GT_ModHandler.getModItem("OpenComputers", "item", 2L, 26),
                                GT_ModHandler.getModItem("OpenComputers", "keyboard", 1L, 0),
                                GT_Utility.getIntegratedCircuit(1)}, Materials.Plastic.getMolten(144L),
                        GT_ModHandler.getModItem("OpenComputers", "item", 1L, 41), 400, 120);
                //Terminal Server
                RA.addAssemblerRecipe(
                        new ItemStack[]{ItemList.Circuit_Board_Epoxy_Advanced.get(1L),
                                GT_ModHandler.getModItem("OpenComputers", "item", 3L, 13),
                                GT_ModHandler.getModItem("OpenComputers", "item", 2L, 25),
                                GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Titanium, 4L),
                                GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Electrum, 16L),
                                GT_Utility.getIntegratedCircuit(1)}, Materials.Plastic.getMolten(144L),
                        GT_ModHandler.getModItem("OpenComputers", "item", 1L, 108), 400, 480);
                //Block of Chamelium
                RA.addCompressorRecipe(GT_ModHandler.getModItem("OpenComputers", "item", 9L, 96),
                        GT_ModHandler.getModItem("OpenComputers", "chameliumBlock", 1L, 0), 300, 2);
                //Chamelium
                GT_Values.RA
                        .addMixerRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Redstone, 4L),
                                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Silicon, 4L),
                                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Coal, 1L), GT_Values.NI,
                                GT_Values.NI, GT_Utility.getIntegratedCircuit(3), Materials.Water.getFluid(1000L),
                                GT_Values.NF, GT_ModHandler.getModItem("OpenComputers", "item", 9L, 96), 200, 120);

                // --- Screen t1
                RA.addAssemblerRecipe(new ItemStack[]{ItemList.Casing_MV.get(1L),
                                CoreItems2.getRecipe(182, 1),
                                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Good, 2L),
                                ItemList.Circuit_Parts_Transistor.get(2L), GT_Utility.getIntegratedCircuit(1)},
                        Materials.SolderingAlloy.getMolten(72L),
                        GT_ModHandler.getModItem("OpenComputers", "screen1", 1L, 0), 240, 64);
                RA.addAssemblerRecipe(new ItemStack[]{ItemList.Casing_MV.get(1L),
                                Itemstack(Core_Items2.getInstance(), 1, 182),
                                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Good, 2L),
                                ItemList.Circuit_Parts_TransistorSMD.get(1L), GT_Utility.getIntegratedCircuit(1)},
                        Materials.SolderingAlloy.getMolten(72L),
                        GT_ModHandler.getModItem("OpenComputers", "screen1", 1L, 0), 240, 64);
                // --- Screen t2
                RA.addAssemblerRecipe(new ItemStack[]{ItemList.Casing_HV.get(1L),
                                Itemstack(Core_Items2.getInstance(), 1, 182),
                                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Advanced, 2L),
                                ItemList.Circuit_Parts_Transistor.get(4L), GT_Utility.getIntegratedCircuit(1)},
                        Materials.SolderingAlloy.getMolten(72L),
                        GT_ModHandler.getModItem("OpenComputers", "screen2", 1L, 0), 240, 120);
                RA.addAssemblerRecipe(new ItemStack[]{ItemList.Casing_HV.get(1L),
                                Itemstack(Core_Items2.getInstance(), 1, 182),
                                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Advanced, 2L),
                                ItemList.Circuit_Parts_TransistorSMD.get(2L), GT_Utility.getIntegratedCircuit(1)},
                        Materials.SolderingAlloy.getMolten(72L),
                        GT_ModHandler.getModItem("OpenComputers", "screen2", 1L, 0), 240, 120);
                // --- Screen t3
                RA.addAssemblerRecipe(new ItemStack[]{ItemList.Casing_EV.get(1L),
                                Itemstack(Core_Items2.getInstance(), 1, 182),
                                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Data, 2L),
                                ItemList.Circuit_Parts_Transistor.get(8L), GT_Utility.getIntegratedCircuit(1)},
                        Materials.SolderingAlloy.getMolten(144L),
                        GT_ModHandler.getModItem("OpenComputers", "screen3", 1L, 0), 240, 256);
                RA.addAssemblerRecipe(new ItemStack[]{ItemList.Casing_EV.get(1L),
                                Itemstack(Core_Items2.getInstance(), 1, 182),
                                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Data, 2L),
                                ItemList.Circuit_Parts_TransistorSMD.get(4L), GT_Utility.getIntegratedCircuit(1)},
                        Materials.SolderingAlloy.getMolten(144L),
                        GT_ModHandler.getModItem("OpenComputers", "screen3", 1L, 0), 240, 256);
                RA.addAssemblerRecipe(new ItemStack[]{ItemList.Casing_EV.get(1L),
                                Itemstack(Core_Items2.getInstance(), 1, 182),
                                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Data, 2L),
                                ItemList.Circuit_Parts_TransistorASMD.get(1L), GT_Utility.getIntegratedCircuit(1)},
                        Materials.SolderingAlloy.getMolten(144L),
                        GT_ModHandler.getModItem("OpenComputers", "screen3", 1L, 0), 120, 256);
                //ALU
                RA.addCircuitAssemblerRecipe(
                        new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                                ItemList.Circuit_Chip_ILC.get(2L), ItemList.Circuit_Parts_Transistor.get(4L),
                                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Electrum, 8),
                                GT_Utility.getIntegratedCircuit(1)}, Materials.SolderingAlloy.getMolten(72L),
                        CoreItems2.getRecipe(157, 1), 400, 64);
                RA.addCircuitAssemblerRecipe(
                        new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                                ItemList.Circuit_Chip_ILC.get(2L), ItemList.Circuit_Parts_TransistorSMD.get(4L),
                                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Electrum, 8),
                                GT_Utility.getIntegratedCircuit(1)}, Materials.SolderingAlloy.getMolten(72L),
                        CoreItems2.getRecipe(157, 1), 400, 64);
						RA.addCircuitAssemblerRecipe(
                        new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                                ItemList.Circuit_Chip_ILC.get(2L), ItemList.Circuit_Parts_TransistorASMD.get(1L),
                                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Electrum, 8),
                                GT_Utility.getIntegratedCircuit(1)}, Materials.SolderingAlloy.getMolten(72L),
                        CoreItems2.getRecipe(157, 1), 400, 64);
                //CU
                RA.addCircuitAssemblerRecipe(
                        new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                                ItemList.Circuit_Chip_CPU.get(2L), ItemList.Circuit_Parts_Transistor.get(4L),
                                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Gold, 8),
                                GT_Utility.getIntegratedCircuit(1)}, Materials.SolderingAlloy.getMolten(72L),
                        CoreItems2.getRecipe(158, 1), 400, 30);
                RA.addCircuitAssemblerRecipe(
                        new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                                ItemList.Circuit_Chip_CPU.get(2L), ItemList.Circuit_Parts_TransistorSMD.get(4L),
                                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Gold, 8),
                                GT_Utility.getIntegratedCircuit(1)}, Materials.SolderingAlloy.getMolten(72L),
                        CoreItems2.getRecipe(158, 1), 200, 30);
				RA.addCircuitAssemblerRecipe(
                        new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                                ItemList.Circuit_Chip_CPU.get(2L), ItemList.Circuit_Parts_TransistorASMD.get(1L),
                                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Gold, 8),
                                GT_Utility.getIntegratedCircuit(1)}, Materials.SolderingAlloy.getMolten(72L),
                        CoreItems2.getRecipe(158, 1), 200, 30);
                //anylyser
                RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Tool_Scanner.get(1L),
                                GT_ModHandler.getModItem("OpenComputers", "item", 2L, 24),
                                ItemList.Circuit_Parts_Transistor.get(2L), ItemList.Sensor_MV.get(1L),
                                GT_Utility.getIntegratedCircuit(1)}, Materials.SolderingAlloy.getMolten(72L),
                        GT_ModHandler.getModItem("OpenComputers", "item", 1L, 0), 300, 120);
                RA.addCircuitAssemblerRecipe(new ItemStack[]{ItemList.Tool_Scanner.get(1L),
                                GT_ModHandler.getModItem("OpenComputers", "item", 2L, 24),
                                ItemList.Circuit_Parts_TransistorSMD.get(2L), ItemList.Sensor_MV.get(1L),
                                GT_Utility.getIntegratedCircuit(1)}, Materials.SolderingAlloy.getMolten(72L),
                        GT_ModHandler.getModItem("OpenComputers", "item", 1L, 0), 300, 120);
                //CPU 1
                RA.addCircuitAssemblerRecipe(
                        new ItemStack[]{GT_ModHandler.getModItem("OpenComputers", "item", 4L, 27),
                                GT_ModHandler.getModItem("OpenComputers", "item", 1L, 28),
                                GT_ModHandler.getModItem("OpenComputers", "item", 1L, 24),
                                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Good, 1),
                                GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Aluminium, 1L),
                                GT_Utility.getIntegratedCircuit(1)}, Materials.SolderingAlloy.getMolten(144L),
                        GT_ModHandler.getModItem("OpenComputers", "item", 1L, 29), 200, 120);
                //CPU 2
                RA.addCircuitAssemblerRecipe(
                        new ItemStack[]{GT_ModHandler.getModItem("OpenComputers", "item", 6L, 27),
                                GT_ModHandler.getModItem("OpenComputers", "item", 2L, 28),
                                GT_ModHandler.getModItem("OpenComputers", "item", 1L, 25),
                                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Advanced, 1),
                                GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.StainlessSteel, 1L),
                                GT_Utility.getIntegratedCircuit(2)}, Materials.SolderingAlloy.getMolten(144L),
                        GT_ModHandler.getModItem("OpenComputers", "item", 1L, 42), 200, 120);
                //CPU 3
                RA.addCircuitAssemblerRecipe(
                        new ItemStack[]{GT_ModHandler.getModItem("OpenComputers", "item", 8L, 27),
                                GT_ModHandler.getModItem("OpenComputers", "item", 4L, 28),
                                GT_ModHandler.getModItem("OpenComputers", "item", 1L, 26),
                                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Data, 1),
                                GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Titanium, 1L),
                                GT_Utility.getIntegratedCircuit(3)}, Materials.SolderingAlloy.getMolten(144L),
                        GT_ModHandler.getModItem("OpenComputers", "item", 1L, 43), 200, 120);
                //Graphics Card 1
                RA.addCircuitAssemblerRecipe(
                        new ItemStack[]{GT_ModHandler.getModItem("OpenComputers", "item", 1L, 33),
                                GT_ModHandler.getModItem("OpenComputers", "item", 2L, 27),
                                GT_ModHandler.getModItem("OpenComputers", "item", 1L, 28),
                                GT_ModHandler.getModItem("OpenComputers", "item", 1L, 24),
                                GT_ModHandler.getModItem("OpenComputers", "item", 1L, 1),
                                GT_Utility.getIntegratedCircuit(7)}, Materials.SolderingAlloy.getMolten(144L),
                        GT_ModHandler.getModItem("OpenComputers", "item", 1L, 8), 400, 120);
                //Graphics Card 2
                RA.addCircuitAssemblerRecipe(
                        new ItemStack[]{GT_ModHandler.getModItem("OpenComputers", "item", 1L, 33),
                                GT_ModHandler.getModItem("OpenComputers", "item", 4L, 27),
                                GT_ModHandler.getModItem("OpenComputers", "item", 2L, 28),
                                GT_ModHandler.getModItem("OpenComputers", "item", 1L, 25),
                                GT_ModHandler.getModItem("OpenComputers", "item", 1L, 2),
                                GT_Utility.getIntegratedCircuit(7)}, Materials.SolderingAlloy.getMolten(144L),
                        GT_ModHandler.getModItem("OpenComputers", "item", 1L, 9), 400, 256);
                //Graphics Card 3
                RA.addCircuitAssemblerRecipe(
                        new ItemStack[]{GT_ModHandler.getModItem("OpenComputers", "item", 1L, 33),
                                GT_ModHandler.getModItem("OpenComputers", "item", 8L, 27),
                                GT_ModHandler.getModItem("OpenComputers", "item", 4L, 28),
                                GT_ModHandler.getModItem("OpenComputers", "item", 1L, 26),
                                GT_ModHandler.getModItem("OpenComputers", "item", 1L, 38),
                                GT_Utility.getIntegratedCircuit(7)}, Materials.SolderingAlloy.getMolten(144L),
                        GT_ModHandler.getModItem("OpenComputers", "item", 1L, 10), 400, 480);
                //Internet Crad
                RA.addCircuitAssemblerRecipe(
                        new ItemStack[]{GT_ModHandler.getModItem("OpenComputers", "item", 1L, 13),
                                GT_ModHandler.getModItem("OpenComputers", "item", 1L, 48),
                                GT_ModHandler.getModItem("OpenComputers", "item", 1L, 26),
                                GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Aluminium, 1L),
                                GT_ItemList.RedstoneRedChipset.get(1L), GT_Utility.getIntegratedCircuit(1)},
                        Materials.SolderingAlloy.getMolten(144L),
                        GT_ModHandler.getModItem("OpenComputers", "item", 1L, 44), 400, 120);
                //APU T1
                RA.addCircuitAssemblerRecipe(
                        new ItemStack[]{GT_ModHandler.getModItem("OpenComputers", "item", 8L, 27),
                                GT_ModHandler.getModItem("OpenComputers", "item", 2L, 28),
                                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Advanced, 1),
                                GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Aluminium, 1L),
                                GT_Utility.getIntegratedCircuit(2)}, Materials.SolderingAlloy.getMolten(144L),
                        GT_ModHandler.getModItem("OpenComputers", "item", 1L, 101), 200, 256);
                //APU T2
                RA.addCircuitAssemblerRecipe(
                        new ItemStack[]{GT_ModHandler.getModItem("OpenComputers", "item", 16L, 27),
                                GT_ModHandler.getModItem("OpenComputers", "item", 4L, 28),
                                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Data, 1),
                                GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.StainlessSteel, 1L),
                                GT_Utility.getIntegratedCircuit(3)}, Materials.SolderingAlloy.getMolten(144L),
                        GT_ModHandler.getModItem("OpenComputers", "item", 1L, 102), 200, 480);
                //EEPROM
                RA.addCircuitAssemblerRecipe(
                        new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                                GT_ModHandler.getModItem("OpenComputers", "item", 1L, 24),
                                ItemList.Circuit_Parts_Transistor.get(6L),
                                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Gold, 1),
                                GT_Utility.getIntegratedCircuit(1)}, Materials.SolderingAlloy.getMolten(72L),
                        GT_ModHandler.getModItem("OpenComputers", "eeprom", 1L, 0), 200, 120);
                RA.addCircuitAssemblerRecipe(
                        new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                                GT_ModHandler.getModItem("OpenComputers", "item", 1L, 24),
                                ItemList.Circuit_Parts_TransistorSMD.get(6L),
                                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Gold, 1),
                                GT_Utility.getIntegratedCircuit(1)}, Materials.SolderingAlloy.getMolten(72L),
                        GT_ModHandler.getModItem("OpenComputers", "eeprom", 1L, 0), 200, 120);
                make_lua_bios();
                // --- Memory (Tier 1)
                RA.addCircuitAssemblerRecipe(
                        new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                                ItemList.Circuit_Chip_Ram.get(4L),
                                GT_ModHandler.getModItem("OpenComputers", "item", 2L, 24),
                                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Copper, 8L),
                                GT_Utility.getIntegratedCircuit(7)}, Materials.SolderingAlloy.getMolten(72L),
                        GT_ModHandler.getModItem("OpenComputers", "item", 1L, 1), 250, 64);
                // --- Memory (Tier 1.5)
                RA.addCircuitAssemblerRecipe(
                        new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                                ItemList.Circuit_Chip_Ram.get(8L),
                                GT_ModHandler.getModItem("OpenComputers", "item", 4L, 24),
                                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Silver, 12L),
                                GT_Utility.getIntegratedCircuit(7)}, Materials.SolderingAlloy.getMolten(72L),
                        GT_ModHandler.getModItem("OpenComputers", "item", 1L, 50), 250, 120);
                // --- Memory (Tier 2)
                RA.addCircuitAssemblerRecipe(
                        new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                                ItemList.Circuit_Chip_Ram.get(12L),
                                GT_ModHandler.getModItem("OpenComputers", "item", 2L, 25),
                                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Gold, 16L),
                                GT_Utility.getIntegratedCircuit(7)}, Materials.SolderingAlloy.getMolten(72L),
                        GT_ModHandler.getModItem("OpenComputers", "item", 1L, 2), 250, 256);
                // --- Memory (Tier 2.5)
                RA.addCircuitAssemblerRecipe(
                        new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                                ItemList.Circuit_Chip_Ram.get(16L), ItemList.Circuit_Chip_NAND.get(8L),
                                GT_ModHandler.getModItem("OpenComputers", "item", 4L, 25),
                                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Electrum, 16),
                                GT_Utility.getIntegratedCircuit(7)}, Materials.SolderingAlloy.getMolten(72L),
                        GT_ModHandler.getModItem("OpenComputers", "item", 1L, 3), 250, 256);
                // --- Memory (Tier 3)
                RA.addCircuitAssemblerRecipe(
                        new ItemStack[]{ItemList.Circuit_Board_Epoxy_Advanced.get(1L),
                                ItemList.Circuit_Chip_Ram.get(24L), ItemList.Circuit_Chip_NAND.get(12L),
                                GT_ModHandler.getModItem("OpenComputers", "item", 2L, 26),
                                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.BlueAlloy, 16L),
                                GT_Utility.getIntegratedCircuit(7)}, Materials.SolderingAlloy.getMolten(72L),
                        GT_ModHandler.getModItem("OpenComputers", "item", 1L, 38), 250, 368);
                // --- Memory (Tier 3.5)
                RA.addCircuitAssemblerRecipe(
                        new ItemStack[]{ItemList.Circuit_Board_Epoxy_Advanced.get(1L),
                                ItemList.Circuit_Chip_Ram.get(32L), ItemList.Circuit_Chip_NAND.get(16L),
                                GT_ModHandler.getModItem("OpenComputers", "item", 4L, 26),
                                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Platinum, 16L),
                                GT_Utility.getIntegratedCircuit(7)}, Materials.SolderingAlloy.getMolten(72L),
                        GT_ModHandler.getModItem("OpenComputers", "item", 1L, 39), 250, 480);
                //Circuit 1
                //1
                RA.addCircuitAssemblerRecipe(
                        new ItemStack[]{ItemList.Circuit_Board_Phenolic_Good.get(1L),
                                ItemList.Circuit_Parts_Transistor.get(2L),
                                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Good, 1),
                                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Electrum, 8L),
                                GT_Utility.getIntegratedCircuit(1)}, Materials.SolderingAlloy.getMolten(72L),
                        CoreItems2.getRecipe(154, 1), 400, 120);
                RA.addCircuitAssemblerRecipe(
                        new ItemStack[]{ItemList.Circuit_Board_Phenolic_Good.get(1L),
                                ItemList.Circuit_Parts_TransistorSMD.get(2L),
                                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Good, 1),
                                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Electrum, 8L),
                                GT_Utility.getIntegratedCircuit(1)}, Materials.SolderingAlloy.getMolten(72L),
                        CoreItems2.getRecipe(154, 1), 400, 120);
                RA.addCircuitAssemblerRecipe(
                        new ItemStack[]{ItemList.Circuit_Board_Phenolic_Good.get(2L),
                                ItemList.Circuit_Parts_TransistorASMD.get(1L),
                                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Good, 2),
                                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Electrum, 16L),
                                GT_Utility.getIntegratedCircuit(1)}, Materials.SolderingAlloy.getMolten(144L),
                        CoreItems2.getRecipe(154, 2), 400, 120);
                //2
                RA.addCircuitAssemblerRecipe(
                        new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                                ItemList.Circuit_Parts_Transistor.get(2L),
                                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Good, 2),
                                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.BlueAlloy, 8L),
                                GT_Utility.getIntegratedCircuit(2)}, Materials.SolderingAlloy.getMolten(72L),
                        CoreItems2.getRecipe(154, 4), 400, 256);
                RA.addCircuitAssemblerRecipe(
                        new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                                ItemList.Circuit_Parts_TransistorSMD.get(2L),
                                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Good, 2),
                                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.BlueAlloy, 8L),
                                GT_Utility.getIntegratedCircuit(2)}, Materials.SolderingAlloy.getMolten(72L),
                        CoreItems2.getRecipe(154, 4), 400, 256);
                RA.addCircuitAssemblerRecipe(
                        new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(2L),
                                ItemList.Circuit_Parts_TransistorASMD.get(1L),
                                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Good, 4),
                                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.BlueAlloy, 16L),
                                GT_Utility.getIntegratedCircuit(2)}, Materials.SolderingAlloy.getMolten(144L),
                        CoreItems2.getRecipe(154, 8), 400, 256);
                //3
                RA.addCircuitAssemblerRecipe(
                        new ItemStack[]{ItemList.Circuit_Board_Epoxy_Advanced.get(1L),
                                ItemList.Circuit_Parts_Transistor.get(2L),
                                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Good, 4),
                                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Platinum, 8L),
                                GT_Utility.getIntegratedCircuit(3)}, Materials.SolderingAlloy.getMolten(72L),
                        CoreItems2.getRecipe(154, 16), 400, 480);
                RA.addCircuitAssemblerRecipe(
                        new ItemStack[]{ItemList.Circuit_Board_Epoxy_Advanced.get(1L),
                                ItemList.Circuit_Parts_TransistorSMD.get(2L),
                                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Good, 4),
                                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Platinum, 8L),
                                GT_Utility.getIntegratedCircuit(3)}, Materials.SolderingAlloy.getMolten(72L),
                        CoreItems2.getRecipe(154, 16), 400, 480);
                RA.addCircuitAssemblerRecipe(
                        new ItemStack[]{ItemList.Circuit_Board_Epoxy_Advanced.get(2L),
                                ItemList.Circuit_Parts_TransistorASMD.get(1L),
                                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Good, 8),
                                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Platinum, 16L),
                                GT_Utility.getIntegratedCircuit(3)}, Materials.SolderingAlloy.getMolten(144L),
                        CoreItems2.getRecipe(154, 32), 400, 480);
                //Circuit 2
                //1
                RA.addCircuitAssemblerRecipe(
                        new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                                ItemList.Circuit_Parts_Transistor.get(4L),
                                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Advanced, 1),
                                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Electrum, 8L),
                                GT_Utility.getIntegratedCircuit(2)}, Materials.SolderingAlloy.getMolten(72L),
                        CoreItems2.getRecipe(155, 1), 500, 256);
                RA.addCircuitAssemblerRecipe(
                        new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                                ItemList.Circuit_Parts_TransistorSMD.get(4L),
                                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Advanced, 1),
                                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Electrum, 8L),
                                GT_Utility.getIntegratedCircuit(2)}, Materials.SolderingAlloy.getMolten(72L),
                        CoreItems2.getRecipe(155, 1), 500, 256);
                RA.addCircuitAssemblerRecipe(
                        new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                                ItemList.Circuit_Parts_TransistorASMD.get(1L),
                                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Advanced, 1),
                                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Electrum, 8L),
                                GT_Utility.getIntegratedCircuit(2)}, Materials.SolderingAlloy.getMolten(72L),
                        CoreItems2.getRecipe(155, 1), 250, 256);
                //2
                RA.addCircuitAssemblerRecipe(
                        new ItemStack[]{ItemList.Circuit_Board_Epoxy_Advanced.get(1L),
                                ItemList.Circuit_Parts_Transistor.get(4L),
                                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Advanced, 2),
                                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.BlueAlloy, 8L),
                                GT_Utility.getIntegratedCircuit(2)}, Materials.SolderingAlloy.getMolten(72L),
                        CoreItems2.getRecipe(155, 3), 500, 480);
                RA.addCircuitAssemblerRecipe(
                        new ItemStack[]{ItemList.Circuit_Board_Epoxy_Advanced.get(1L),
                                ItemList.Circuit_Parts_TransistorSMD.get(4L),
                                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Advanced, 2),
                                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.BlueAlloy, 8L),
                                GT_Utility.getIntegratedCircuit(2)}, Materials.SolderingAlloy.getMolten(72L),
                        CoreItems2.getRecipe(155, 3), 500, 480);
                RA.addCircuitAssemblerRecipe(
                        new ItemStack[]{ItemList.Circuit_Board_Epoxy_Advanced.get(1L),
                                ItemList.Circuit_Parts_TransistorASMD.get(1L),
                                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Advanced, 2),
                                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.BlueAlloy, 8L),
                                GT_Utility.getIntegratedCircuit(2)}, Materials.SolderingAlloy.getMolten(72L),
                        CoreItems2.getRecipe(155, 3), 250, 480);
                //3
                RA.addCircuitAssemblerRecipe(
                        new ItemStack[]{ItemList.Circuit_Board_Fiberglass_Advanced.get(1L),
                                ItemList.Circuit_Parts_Transistor.get(4L),
                                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Advanced, 4),
                                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Platinum, 8L),
                                GT_Utility.getIntegratedCircuit(3)}, Materials.SolderingAlloy.getMolten(72L),
                        CoreItems2.getRecipe(155, 9), 500, 1024);
                RA.addCircuitAssemblerRecipe(
                        new ItemStack[]{ItemList.Circuit_Board_Fiberglass_Advanced.get(1L),
                                ItemList.Circuit_Parts_TransistorSMD.get(4L),
                                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Advanced, 4),
                                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Platinum, 8L),
                                GT_Utility.getIntegratedCircuit(3)}, Materials.SolderingAlloy.getMolten(72L),
                        CoreItems2.getRecipe(155, 9), 500, 1024);
                RA.addCircuitAssemblerRecipe(
                        new ItemStack[]{ItemList.Circuit_Board_Fiberglass_Advanced.get(1L),
                                ItemList.Circuit_Parts_TransistorASMD.get(1L),
                                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Advanced, 4),
                                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Platinum, 8L),
                                GT_Utility.getIntegratedCircuit(3)}, Materials.SolderingAlloy.getMolten(72L),
                        CoreItems2.getRecipe(155, 9), 250, 1024);
                //Circuit 3
                //1
                RA.addCircuitAssemblerRecipe(
                        new ItemStack[]{ItemList.Circuit_Board_Epoxy_Advanced.get(1L),
                                ItemList.Circuit_Parts_Transistor.get(8L),
                                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Data, 1),
                                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Electrum, 8L),
                                GT_Utility.getIntegratedCircuit(1)}, Materials.SolderingAlloy.getMolten(72L),
                        CoreItems2.getRecipe(156, 1), 600, 480);
                RA.addCircuitAssemblerRecipe(
                        new ItemStack[]{ItemList.Circuit_Board_Epoxy_Advanced.get(1L),
                                ItemList.Circuit_Parts_TransistorSMD.get(8L),
                                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Data, 1),
                                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Electrum, 8L),
                                GT_Utility.getIntegratedCircuit(1)}, Materials.SolderingAlloy.getMolten(72L),
                        CoreItems2.getRecipe(156, 1), 600, 480);
                RA.addCircuitAssemblerRecipe(
                        new ItemStack[]{ItemList.Circuit_Board_Epoxy_Advanced.get(1L),
                                ItemList.Circuit_Parts_TransistorASMD.get(2L),
                                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Data, 1),
                                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Electrum, 8L),
                                GT_Utility.getIntegratedCircuit(1)}, Materials.SolderingAlloy.getMolten(72L),
                        CoreItems2.getRecipe(156, 1), 300, 480);
                //2
                RA.addCircuitAssemblerRecipe(
                        new ItemStack[]{ItemList.Circuit_Board_Fiberglass_Advanced.get(1L),
                                ItemList.Circuit_Parts_Transistor.get(8L),
                                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Data, 2),
                                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.BlueAlloy, 8L),
                                GT_Utility.getIntegratedCircuit(2)}, Materials.SolderingAlloy.getMolten(72L),
                        CoreItems2.getRecipe(156, 2), 600, 1024);
                RA.addCircuitAssemblerRecipe(
                        new ItemStack[]{ItemList.Circuit_Board_Fiberglass_Advanced.get(1L),
                                ItemList.Circuit_Parts_TransistorSMD.get(8L),
                                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Data, 2),
                                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.BlueAlloy, 8L),
                                GT_Utility.getIntegratedCircuit(2)}, Materials.SolderingAlloy.getMolten(72L),
                        CoreItems2.getRecipe(156, 2), 600, 1024);
                RA.addCircuitAssemblerRecipe(
                        new ItemStack[]{ItemList.Circuit_Board_Fiberglass_Advanced.get(1L),
                                ItemList.Circuit_Parts_TransistorASMD.get(2L),
                                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Data, 2),
                                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.BlueAlloy, 8L),
                                GT_Utility.getIntegratedCircuit(2)}, Materials.SolderingAlloy.getMolten(72L),
                        CoreItems2.getRecipe(156, 2), 300, 1024);
                //3
                RA.addCircuitAssemblerRecipe(
                        new ItemStack[]{ItemList.Circuit_Board_Multifiberglass_Elite.get(1L),
                                ItemList.Circuit_Parts_Transistor.get(8L),
                                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Data, 4),
                                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Platinum, 8L),
                                GT_Utility.getIntegratedCircuit(3)}, Materials.SolderingAlloy.getMolten(72L),
                        CoreItems2.getRecipe(156, 4), 600, 1920);
                RA.addCircuitAssemblerRecipe(
                        new ItemStack[]{ItemList.Circuit_Board_Multifiberglass_Elite.get(1L),
                                ItemList.Circuit_Parts_TransistorSMD.get(8L),
                                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Data, 4),
                                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Platinum, 8L),
                                GT_Utility.getIntegratedCircuit(3)}, Materials.SolderingAlloy.getMolten(72L),
                        CoreItems2.getRecipe(156, 4), 600, 1920);
                RA.addCircuitAssemblerRecipe(
                        new ItemStack[]{ItemList.Circuit_Board_Multifiberglass_Elite.get(1L),
                                ItemList.Circuit_Parts_TransistorASMD.get(2L),
                                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Data, 4),
                                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Platinum, 8L),
                                GT_Utility.getIntegratedCircuit(3)}, Materials.SolderingAlloy.getMolten(72L),
                        CoreItems2.getRecipe(156, 4), 300, 1920);

                //network card
                RA.addCircuitAssemblerRecipe(
                        new ItemStack[]{GT_ModHandler.getModItem("OpenComputers", "item", 1L, 33),
                                GT_ModHandler.getModItem("OpenComputers", "cable", 2L, 0),
                                GT_ModHandler.getModItem("OpenComputers", "item", 1L, 24),
                                GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Electrum, 8L),
                                GT_Utility.getIntegratedCircuit(1)}, Materials.SolderingAlloy.getMolten(72L),
                        GT_ModHandler.getModItem("OpenComputers", "item", 1L, 11), 200, 120);
                //wlan card1
                RA.addCircuitAssemblerRecipe(
                        new ItemStack[]{GT_ModHandler.getModItem("OpenComputers", "item", 1L, 11),
                                ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                                GT_ModHandler.getModItem("OpenComputers", "item", 1L, 25),
                                ItemList.Emitter_LV.get(1L), ItemList.Sensor_LV.get(1L),
                                GT_Utility.getIntegratedCircuit(1)}, Materials.SolderingAlloy.getMolten(72L),
                        GT_ModHandler.getModItem("OpenComputers", "item", 1L, 113), 200, 120);
                //wlan card2
                RA.addCircuitAssemblerRecipe(
                        new ItemStack[]{GT_ModHandler.getModItem("OpenComputers", "item", 1L, 11),
                                ItemList.Circuit_Board_Epoxy_Advanced.get(1L),
                                GT_ModHandler.getModItem("OpenComputers", "item", 1L, 26),
                                ItemList.Emitter_HV.get(1L), ItemList.Sensor_HV.get(1L),
                                GT_Utility.getIntegratedCircuit(1)}, Materials.SolderingAlloy.getMolten(72L),
                        GT_ModHandler.getModItem("OpenComputers", "item", 1L, 13), 200, 256);
                //World sensor card
                RA.addCircuitAssemblerRecipe(
                        new ItemStack[]{GT_ModHandler.getModItem("OpenComputers", "item", 1L, 33),
                                ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                                GT_ModHandler.getModItem("OpenComputers", "item", 1L, 25),
                                GT_ModHandler.getModItem("GalacticraftCore", "item.sensorLens", 2L, 0),
                                GT_Utility.getIntegratedCircuit(1)}, Materials.SolderingAlloy.getMolten(72L),
                        GT_ModHandler.getModItem("OpenComputers", "item", 1L, 89), 200, 120);
                //redstone card 1
                RA.addCircuitAssemblerRecipe(
                        new ItemStack[]{GT_ModHandler.getModItem("OpenComputers", "item", 1L, 33),
                                GT_ModHandler.getModItem("OpenComputers", "item", 1L, 24),
                                GT_ModHandler.getModItem("OpenComputers", "cable", 1L, 0),
                                ItemList.Circuit_Chip_ILC.get(2L), new ItemStack(Blocks.redstone_torch, 1),
                                GT_Utility.getIntegratedCircuit(1)}, Materials.SolderingAlloy.getMolten(72L),
                        GT_ModHandler.getModItem("OpenComputers", "item", 1L, 66), 200, 120);
                //redstone card 2
                RA.addCircuitAssemblerRecipe(
                        new ItemStack[]{GT_ModHandler.getModItem("OpenComputers", "item", 1L, 33),
                                GT_ModHandler.getModItem("OpenComputers", "item", 1L, 25),
                                GT_ModHandler.getModItem("OpenComputers", "cable", 1L, 0),
                                ItemList.Circuit_Chip_ILC.get(8L), new ItemStack(Blocks.redstone_torch, 2),
                                GT_Utility.getIntegratedCircuit(1)}, Materials.SolderingAlloy.getMolten(72L),
                        GT_ModHandler.getModItem("OpenComputers", "item", 1L, 12), 200, 256);
                //data card 1
                RA.addCircuitAssemblerRecipe(
                        new ItemStack[]{GT_ModHandler.getModItem("OpenComputers", "item", 1L, 33),
                                GT_ModHandler.getModItem("OpenComputers", "item", 1L, 24),
                                GT_ModHandler.getModItem("OpenComputers", "item", 4, 27),
                                GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Electrum, 8L),
                                GT_Utility.getIntegratedCircuit(1)}, Materials.SolderingAlloy.getMolten(72L),
                        GT_ModHandler.getModItem("OpenComputers", "item", 1L, 104), 300, 120);
                //data card 2
                RA.addCircuitAssemblerRecipe(
                        new ItemStack[]{GT_ModHandler.getModItem("OpenComputers", "item", 1L, 33),
                                GT_ModHandler.getModItem("OpenComputers", "item", 1L, 25),
                                GT_ModHandler.getModItem("OpenComputers", "item", 1, 29),
                                GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Electrum, 16L),
                                GT_Utility.getIntegratedCircuit(1)}, Materials.SolderingAlloy.getMolten(72L),
                        GT_ModHandler.getModItem("OpenComputers", "item", 1L, 105), 300, 156);
                //data card 3
                RA.addCircuitAssemblerRecipe(
                        new ItemStack[]{GT_ModHandler.getModItem("OpenComputers", "item", 1L, 33),
                                GT_ModHandler.getModItem("OpenComputers", "item", 1L, 26),
                                GT_ModHandler.getModItem("OpenComputers", "item", 1, 42),
                                GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Electrum, 32L),
                                GT_Utility.getIntegratedCircuit(1)}, Materials.SolderingAlloy.getMolten(72L),
                        GT_ModHandler.getModItem("OpenComputers", "item", 1L, 106), 300, 480);
                //angel upgrade
                RA.addAssemblerRecipe(
                        new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                                GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Aluminium, 2L),
                                GT_ModHandler.getModItem("ExtraUtilities", "angelBlock", 1L, 0),
                                GT_ModHandler.getModItem("OpenComputers", "item", 1L, 25),
                                GT_Utility.getIntegratedCircuit(1)}, Materials.SolderingAlloy.getMolten(72L),
                        GT_ModHandler.getModItem("OpenComputers", "item", 1L, 49), 250, 256);
                //hover upgrade Tier 1
                RA.addAssemblerRecipe(
                        new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                                GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Aluminium, 2L),
                                GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.StainlessSteel, 4L),
                                GT_ModHandler.getModItem("OpenComputers", "item", 2L, 25),
                                ItemList.Electric_Motor_MV.get(1L), GT_Utility.getIntegratedCircuit(1)},
                        Materials.SolderingAlloy.getMolten(72L),
                        GT_ModHandler.getModItem("OpenComputers", "item", 1L, 99), 250, 256);
                //hover upgrade Tier 2
                RA.addAssemblerRecipe(
                        new ItemStack[]{ItemList.Circuit_Board_Epoxy_Advanced.get(1L),
                                GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Aluminium, 4L),
                                GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.StainlessSteel, 8L),
                                GT_ModHandler.getModItem("OpenComputers", "item", 2L, 26),
                                ItemList.Electric_Motor_HV.get(1L), GT_Utility.getIntegratedCircuit(1)},
                        Materials.SolderingAlloy.getMolten(72L),
                        GT_ModHandler.getModItem("OpenComputers", "item", 1L, 100), 250, 480);
                //battery upgrade 1
                RA.addAssemblerRecipe(
                        new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                                GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Aluminium, 2L),
                                GT_ModHandler.getModItem("OpenComputers", "capacitor", 1L, 0),
                                ItemList.Circuit_Parts_Transistor.get(2L),
                                GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.RedAlloy, 4L),
                                GT_Utility.getIntegratedCircuit(1)}, Materials.SolderingAlloy.getMolten(72L),
                        GT_ModHandler.getModItem("OpenComputers", "item", 1L, 63), 250, 120);
                RA.addAssemblerRecipe(
                        new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                                GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Aluminium, 2L),
                                GT_ModHandler.getModItem("OpenComputers", "capacitor", 1L, 0),
                                ItemList.Circuit_Parts_TransistorSMD.get(1L),
                                GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.RedAlloy, 4L),
                                GT_Utility.getIntegratedCircuit(1)}, Materials.SolderingAlloy.getMolten(72L),
                        GT_ModHandler.getModItem("OpenComputers", "item", 1L, 63), 250, 120);
                //battery upgrade 2
                RA.addAssemblerRecipe(
                        new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                                GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Titanium, 2L),
                                GT_ModHandler.getModItem("OpenComputers", "capacitor", 2L, 0),
                                ItemList.Circuit_Parts_Transistor.get(4L),
                                GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Silver, 8L),
                                GT_Utility.getIntegratedCircuit(1)}, Materials.SolderingAlloy.getMolten(72L),
                        GT_ModHandler.getModItem("OpenComputers", "item", 1L, 64), 250, 256);
                RA.addAssemblerRecipe(
                        new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                                GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Titanium, 2L),
                                GT_ModHandler.getModItem("OpenComputers", "capacitor", 2L, 0),
                                ItemList.Circuit_Parts_TransistorSMD.get(2L),
                                GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Silver, 8L),
                                GT_Utility.getIntegratedCircuit(1)}, Materials.SolderingAlloy.getMolten(72L),
                        GT_ModHandler.getModItem("OpenComputers", "item", 1L, 64), 250, 256);
                //battery upgrade 3
                RA.addAssemblerRecipe(
                        new ItemStack[]{ItemList.Circuit_Board_Epoxy_Advanced.get(1L),
                                GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.TungstenSteel, 2L),
                                GT_ModHandler.getModItem("OpenComputers", "capacitor", 4L, 0),
                                ItemList.Circuit_Parts_Transistor.get(8L),
                                GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Electrum, 16L),
                                GT_Utility.getIntegratedCircuit(1)}, Materials.SolderingAlloy.getMolten(72L),
                        GT_ModHandler.getModItem("OpenComputers", "item", 1L, 65), 250, 480);
                RA.addAssemblerRecipe(
                        new ItemStack[]{ItemList.Circuit_Board_Epoxy_Advanced.get(1L),
                                GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.TungstenSteel, 2L),
                                GT_ModHandler.getModItem("OpenComputers", "capacitor", 4L, 0),
                                ItemList.Circuit_Parts_TransistorSMD.get(4L),
                                GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Electrum, 16L),
                                GT_Utility.getIntegratedCircuit(1)}, Materials.SolderingAlloy.getMolten(72L),
                        GT_ModHandler.getModItem("OpenComputers", "item", 1L, 65), 250, 480);
                RA.addAssemblerRecipe(
                        new ItemStack[]{ItemList.Circuit_Board_Epoxy_Advanced.get(1L),
                                GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.TungstenSteel, 2L),
                                GT_ModHandler.getModItem("OpenComputers", "capacitor", 4L, 0),
                                ItemList.Circuit_Parts_TransistorASMD.get(1L),
                                GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Electrum, 16L),
                                GT_Utility.getIntegratedCircuit(1)}, Materials.SolderingAlloy.getMolten(72L),
                        GT_ModHandler.getModItem("OpenComputers", "item", 1L, 65), 125, 480);
                //chunkloader upgrade
                RA.addAssemblerRecipe(
                        new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                                GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Aluminium, 2L),
                                GT_ModHandler.getModItem("ChickenChunks", "chickenChunkLoader", 1L, 0),
                                GT_ModHandler.getModItem("OpenComputers", "item", 1L, 26),
                                GT_Utility.getIntegratedCircuit(1)}, Materials.SolderingAlloy.getMolten(72L),
                        GT_ModHandler.getModItem("OpenComputers", "item", 1L, 62), 250, 256);
                //inventory upgrade
                RA.addAssemblerRecipe(
                        new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                                GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Aluminium, 2L),
                                new ItemStack(Blocks.chest, 1),
                                GT_ModHandler.getModItem("OpenComputers", "item", 1L, 24),
                                GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Silver, 8L),
                                GT_Utility.getIntegratedCircuit(1)}, Materials.SolderingAlloy.getMolten(72L),
                        GT_ModHandler.getModItem("OpenComputers", "item", 1L, 53), 300, 120);
                //inventory controller upgrade
                RA.addAssemblerRecipe(
                        new ItemStack[]{GT_ModHandler.getModItem("OpenComputers", "item", 1L, 53),
                                GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Aluminium, 2L),
                                GT_ModHandler.getModItem("OpenComputers", "item", 1L, 25),
                                GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Electrum, 8L),
                                GT_Utility.getIntegratedCircuit(1)}, Materials.SolderingAlloy.getMolten(72L),
                        GT_ModHandler.getModItem("OpenComputers", "item", 1L, 61), 300, 256);
                //tank upgrade
                RA.addAssemblerRecipe(
                        new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                                GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Aluminium, 2L),
                                ItemList.Large_Fluid_Cell_Steel.get(1),
                                GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Silver, 8L),
                                GT_Utility.getIntegratedCircuit(1)}, Materials.SolderingAlloy.getMolten(72L),
                        GT_ModHandler.getModItem("OpenComputers", "item", 1L, 76), 300, 120);
                //tank controller upgrade
                RA.addAssemblerRecipe(
                        new ItemStack[]{GT_ModHandler.getModItem("OpenComputers", "item", 1L, 76),
                                GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Aluminium, 2L),
                                GT_ModHandler.getModItem("OpenComputers", "item", 1L, 25),
                                GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Electrum, 8L),
                                GT_Utility.getIntegratedCircuit(1)}, Materials.SolderingAlloy.getMolten(72L),
                        GT_ModHandler.getModItem("OpenComputers", "item", 1L, 77), 300, 256);
                //card container 1
                RA.addAssemblerRecipe(
                        new ItemStack[]{GT_ModHandler.getModItem("OpenComputers", "item", 1L, 33),
                                GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Aluminium, 2L),
                                new ItemStack(Blocks.chest, 1),
                                GT_ModHandler.getModItem("OpenComputers", "item", 1L, 24),
                                GT_Utility.getIntegratedCircuit(1)}, Materials.SolderingAlloy.getMolten(72L),
                        GT_ModHandler.getModItem("OpenComputers", "item", 1L, 57), 250, 120);
                //card container 2
                RA.addAssemblerRecipe(
                        new ItemStack[]{GT_ModHandler.getModItem("OpenComputers", "item", 1L, 33),
                                GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.StainlessSteel, 2L),
                                new ItemStack(Blocks.chest, 1),
                                GT_ModHandler.getModItem("OpenComputers", "item", 1L, 25),
                                GT_Utility.getIntegratedCircuit(1)}, Materials.SolderingAlloy.getMolten(72L),
                        GT_ModHandler.getModItem("OpenComputers", "item", 1L, 58), 250, 256);
                //card container 3
                RA.addAssemblerRecipe(
                        new ItemStack[]{GT_ModHandler.getModItem("OpenComputers", "item", 1L, 33),
                                GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Titanium, 2L),
                                new ItemStack(Blocks.chest, 1),
                                GT_ModHandler.getModItem("OpenComputers", "item", 1L, 26),
                                GT_Utility.getIntegratedCircuit(1)}, Materials.SolderingAlloy.getMolten(72L),
                        GT_ModHandler.getModItem("OpenComputers", "item", 1L, 59), 250, 480);
                //upgrade container 1
                RA.addAssemblerRecipe(
                        new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                                GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Aluminium, 2L),
                                new ItemStack(Blocks.chest, 1),
                                GT_ModHandler.getModItem("OpenComputers", "item", 1L, 24),
                                GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.StainlessSteel, 8L),
                                GT_Utility.getIntegratedCircuit(1)}, Materials.SolderingAlloy.getMolten(72L),
                        GT_ModHandler.getModItem("OpenComputers", "item", 1L, 54), 250, 120);
                //upgrade container 2
                RA.addAssemblerRecipe(
                        new ItemStack[]{ItemList.Circuit_Board_Epoxy_Advanced.get(1L),
                                GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Titanium, 2L),
                                new ItemStack(Blocks.chest, 1),
                                GT_ModHandler.getModItem("OpenComputers", "item", 1L, 25),
                                GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Titanium, 8L),
                                GT_Utility.getIntegratedCircuit(1)}, Materials.SolderingAlloy.getMolten(72L),
                        GT_ModHandler.getModItem("OpenComputers", "item", 1L, 55), 250, 256);
                //upgrade container 3
                RA.addAssemblerRecipe(
                        new ItemStack[]{ItemList.Circuit_Board_Fiberglass_Advanced.get(1L),
                                GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.TungstenSteel, 2L),
                                new ItemStack(Blocks.chest, 1),
                                GT_ModHandler.getModItem("OpenComputers", "item", 1L, 26),
                                GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.TungstenSteel, 8L),
                                GT_Utility.getIntegratedCircuit(1)}, Materials.SolderingAlloy.getMolten(72L),
                        GT_ModHandler.getModItem("OpenComputers", "item", 1L, 56), 250, 480);
                //component bus t1
                RA.addCircuitAssemblerRecipe(
                        new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                                GT_ModHandler.getModItem("OpenComputers", "item", 2L, 24),
                                GT_ModHandler.getModItem("OpenComputers", "item", 1L, 28),
                                GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.RedAlloy, 4L),
                                GT_Utility.getIntegratedCircuit(1)}, Materials.SolderingAlloy.getMolten(72L),
                        GT_ModHandler.getModItem("OpenComputers", "item", 1L, 70), 250, 120);
                //component bus t2
                RA.addCircuitAssemblerRecipe(
                        new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                                GT_ModHandler.getModItem("OpenComputers", "item", 2L, 25),
                                GT_ModHandler.getModItem("OpenComputers", "item", 2L, 28),
                                GT_ModHandler.getModItem("OpenComputers", "item", 1L, 2),
                                GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Electrum, 8),
                                GT_Utility.getIntegratedCircuit(1)}, Materials.SolderingAlloy.getMolten(72L),
                        GT_ModHandler.getModItem("OpenComputers", "item", 1L, 71), 250, 256);
                //component bus t3
                RA.addCircuitAssemblerRecipe(
                        new ItemStack[]{ItemList.Circuit_Board_Epoxy_Advanced.get(1L),
                                GT_ModHandler.getModItem("OpenComputers", "item", 2L, 26),
                                GT_ModHandler.getModItem("OpenComputers", "item", 4L, 28),
                                GT_ModHandler.getModItem("OpenComputers", "item", 1L, 38),
                                GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Diamond, 16),
                                GT_Utility.getIntegratedCircuit(1)}, Materials.SolderingAlloy.getMolten(72L),
                        GT_ModHandler.getModItem("OpenComputers", "item", 1L, 72), 250, 480);
                //database upgrade 1
                RA.addAssemblerRecipe(
                        new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                                GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Steel, 1),
                                GT_ModHandler.getModItem("OpenComputers", "item", 1L, 5),
                                GT_ModHandler.getModItem("OpenComputers", "item", 2L, 24),
                                GT_Utility.getIntegratedCircuit(1)}, Materials.SolderingAlloy.getMolten(72L),
                        GT_ModHandler.getModItem("OpenComputers", "item", 1L, 78), 250, 120);
                //database upgrade 2
                RA.addAssemblerRecipe(
                        new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                                GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Birmabright, 1),
                                GT_ModHandler.getModItem("OpenComputers", "item", 1L, 6),
                                GT_ModHandler.getModItem("OpenComputers", "item", 2L, 25),
                                GT_Utility.getIntegratedCircuit(1)}, Materials.SolderingAlloy.getMolten(72L),
                        GT_ModHandler.getModItem("OpenComputers", "item", 1L, 79), 250, 256);
                //database upgrade 3
                RA.addAssemblerRecipe(
                        new ItemStack[]{ItemList.Circuit_Board_Epoxy_Advanced.get(1L),
                                GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.StainlessSteel, 1),
                                GT_ModHandler.getModItem("OpenComputers", "item", 1L, 7),
                                GT_ModHandler.getModItem("OpenComputers", "item", 2L, 26),
                                GT_Utility.getIntegratedCircuit(1)}, Materials.SolderingAlloy.getMolten(72L),
                        GT_ModHandler.getModItem("OpenComputers", "item", 1L, 80), 250, 480);
                //experience upgrade
                RA.addAssemblerRecipe(
                        new ItemStack[]{ItemList.Circuit_Board_Epoxy_Advanced.get(1L),
                                GT_ModHandler.getModItem("OpenComputers", "item", 1L, 0),
                                GT_ModHandler.getModItem("OpenComputers", "item", 2L, 26),
                                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Emerald, 2L),
                                GT_Utility.getIntegratedCircuit(1)}, Materials.SolderingAlloy.getMolten(72L),
                        GT_ModHandler.getModItem("OpenComputers", "item", 1L, 52), 250, 120);
                //crafting component
                RA.addAssemblerRecipe(new ItemStack[]{ItemList.Hull_LV.get(1L),
                                ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                                GT_ModHandler.getModItem("OpenComputers", "item", 2L, 25),
                                ItemList.Cover_Crafting.get(1L), GT_Utility.getIntegratedCircuit(1)},
                        Materials.SolderingAlloy.getMolten(72L),
                        GT_ModHandler.getModItem("OpenComputers", "item", 1L, 14), 250, 120);
                //generator upgrade
                RA.addAssemblerRecipe(new ItemStack[]{ItemList.Generator_Diesel_LV.get(1L),
                                ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                                GT_ModHandler.getModItem("OpenComputers", "item", 2L, 25),
                                GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Aluminium, 1L),
                                GT_Utility.getIntegratedCircuit(1)}, Materials.SolderingAlloy.getMolten(72L),
                        GT_ModHandler.getModItem("OpenComputers", "item", 1L, 15), 250, 120);
                //leash upgrade
                RA.addAssemblerRecipe(
                        new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                                GT_ModHandler.getModItem("OpenComputers", "item", 1L, 28),
                                new ItemStack(Items.lead, 4), GT_Utility.getIntegratedCircuit(1)},
                        Materials.SolderingAlloy.getMolten(72L),
                        GT_ModHandler.getModItem("OpenComputers", "item", 1L, 85), 250, 120);
                //mfu upgrade
                RA.addAssemblerRecipe(
                        new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                                GT_ModHandler.getModItem("OpenComputers", "item", 2L, 51),
                                GT_ModHandler.getModItem("OpenComputers", "item", 4L, 96),
                                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Lapis, 2L),
                                GT_Utility.getIntegratedCircuit(1)}, Materials.SolderingAlloy.getMolten(72L),
                        GT_ModHandler.getModItem("OpenComputers", "item", 1L, 112), 250, 480);
                //navigation upgrade
                RA.addAssemblerRecipe(new ItemStack[]{ItemList.Hull_MV.get(1L),
                                ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                                GT_ModHandler.getModItem("OpenComputers", "item", 2L, 25),
                                new ItemStack(Items.compass, 1), new ItemStack(Items.filled_map, 1),
                                GT_OreDictUnificator.get(OrePrefixes.cell, Materials.Water, 1L)},
                        Materials.SolderingAlloy.getMolten(72L),
                        GT_ModHandler.getModItem("OpenComputers", "item", 1L, 36), 250, 256);
                //piston upgrade
                RA.addAssemblerRecipe(
                        new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                                ItemList.Electric_Piston_MV.get(1L),
                                GT_ModHandler.getModItem("OpenComputers", "item", 2L, 24),
                                GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Aluminium, 1L),
                                GT_Utility.getIntegratedCircuit(1)}, Materials.SolderingAlloy.getMolten(72L),
                        GT_ModHandler.getModItem("OpenComputers", "item", 1L, 75), 250, 120);
                //sing IO upgrade
                RA.addAssemblerRecipe(
                        new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                                GT_ModHandler.getModItem("OpenComputers", "item", 2L, 24),
                                GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Aluminium, 2L),
                                ItemList.Dye_SquidInk.get(1L), new ItemStack(Items.sign, 1),
                                GT_Utility.getIntegratedCircuit(1)}, Materials.SolderingAlloy.getMolten(72L),
                        GT_ModHandler.getModItem("OpenComputers", "item", 1L, 35), 250, 120);
                //solar upgrade
                RA.addAssemblerRecipe(
                        new ItemStack[]{ItemList.Circuit_Board_Epoxy_Advanced.get(1L),
                                GT_ModHandler.getModItem("OpenComputers", "item", 2L, 26),
                                ItemList.Cover_SolarPanel_8V.get(1L),
                                GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Titanium, 2L),
                                GT_Utility.getIntegratedCircuit(1)}, Materials.SolderingAlloy.getMolten(72L),
                        GT_ModHandler.getModItem("OpenComputers", "item", 1L, 34), 250, 256);
                //tractor beam upgrade
                RA.addAssemblerRecipe(
                        new ItemStack[]{GT_ModHandler.getModItem("OpenComputers", "capacitor", 1L, 0),
                                ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                                GT_ModHandler.getModItem("OpenComputers", "item", 1L, 26),
                                ItemList.Electric_Piston_HV.get(1L),
                                GT_OreDictUnificator.get(OrePrefixes.stick, Materials.IronMagnetic, 4L),
                                GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 16L)},
                        Materials.SolderingAlloy.getMolten(72L),
                        GT_ModHandler.getModItem("OpenComputers", "item", 1L, 67), 250, 480);
                //trading upgrade
                RA.addAssemblerRecipe(
                        new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                                GT_ModHandler.getModItem("OpenComputers", "item", 3L, 25),
                                GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Aluminium, 3L),
                                ItemList.Electric_Piston_MV.get(1L),
                                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Emerald, 2L),
                                GT_Utility.getIntegratedCircuit(1)}, Materials.SolderingAlloy.getMolten(72L),
                        GT_ModHandler.getModItem("OpenComputers", "item", 1L, 110), 250, 256);
                //hover Boots
                RA.addAssemblerRecipe(
                        new ItemStack[]{GT_ModHandler.getModItem("OpenComputers", "capacitor", 1L, 0),
                                GT_ModHandler.getModItem("OpenComputers", "item", 1L, 83),
                                GT_ModHandler.getModItem("OpenComputers", "item", 1L, 100),
                                GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Aluminium, 4L),
                                ItemList.Electric_Piston_MV.get(2L), GT_Utility.getIntegratedCircuit(1)},
                        Materials.SolderingAlloy.getMolten(72L),
                        GT_ModHandler.getModItem("OpenComputers", "hoverBoots", 1L, GT_Values.W), 350, 256);

                // --- Wireless Keyboard
                RA.addAssemblerRecipe(
                        new ItemStack[]{GT_ModHandler.getModItem("OpenComputers", "item", 1L, 13),
                                GT_ModHandler.getModItem("OpenComputers", "item", 1L, 26),
                                GT_ModHandler.getModItem("OpenComputers", "keyboard", 1L, 0),
                                GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.StainlessSteel, 1L),
                                GT_Utility.getIntegratedCircuit(2)}, Materials.Plastic.getMolten(144L),
                        GT_ModHandler.getModItem("OpenPeripheral", "keyboard", 1L, 0), 400, 120);

                // --- Computronics
                // --- Tape Reel
                RA.addAssemblerRecipe(new ItemStack[]{
                                GT_OreDictUnificator.get(OrePrefixes.ring, Materials.NiobiumTitanium, 1L),
                                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.ChromiumDioxide, 4L),
                                GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.StainlessSteel, 8L)},
                        Materials.Argon.getGas(1000L),
                        GT_ModHandler.getModItem("computronics", "computronics.gt_parts", 1L, 0), 400, 256);
                // --- Camera Upgrade
                RA.addAssemblerRecipe(
                        new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                                GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Aluminium, 2L),
                                GT_ModHandler.getModItem("computronics", "computronics.camera", 1L, 0),
                                GT_ModHandler.getModItem("OpenComputers", "item", 2L, 25),
                                GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Gold, 4L),
                                GT_Utility.getIntegratedCircuit(1)}, Materials.SolderingAlloy.getMolten(72L),
                        GT_ModHandler.getModItem("computronics", "computronics.ocParts", 1L, 0), 250, 120);
                // --- Chat Upgrade
                RA.addAssemblerRecipe(
                        new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                                GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Aluminium, 2L),
                                GT_ModHandler.getModItem("computronics", "computronics.chatBox", 1L, 0),
                                GT_ModHandler.getModItem("OpenComputers", "item", 2L, 25),
                                GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Silver, 4L),
                                GT_Utility.getIntegratedCircuit(1)}, Materials.SolderingAlloy.getMolten(72L),
                        GT_ModHandler.getModItem("computronics", "computronics.ocParts", 1L, 1), 250, 120);
                // --- Radar Upgrade
                RA.addAssemblerRecipe(
                        new ItemStack[]{ItemList.Circuit_Board_Epoxy_Advanced.get(1L),
                                GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.StainlessSteel, 2L),
                                GT_ModHandler.getModItem("computronics", "computronics.radar", 1L, 0),
                                GT_ModHandler.getModItem("OpenComputers", "item", 2L, 26),
                                GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Electrum, 8L),
                                GT_Utility.getIntegratedCircuit(1)}, Materials.SolderingAlloy.getMolten(72L),
                        GT_ModHandler.getModItem("computronics", "computronics.ocParts", 1L, 2), 300, 256);
                // --- Particle Effect Card
                RA.addCircuitAssemblerRecipe(
                        new ItemStack[]{GT_ModHandler.getModItem("OpenComputers", "item", 1L, 33),
                                GT_ModHandler.getModItem("OpenComputers", "item", 1L, 25),
                                GT_ModHandler.getModItem("OpenComputers", "item", 1L, 27),
                                GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.StainlessSteel, 1L),
                                GT_ItemList.RedstonePulsatingChipset.get(1L), GT_Utility.getIntegratedCircuit(1)},
                        Materials.SolderingAlloy.getMolten(72L),
                        GT_ModHandler.getModItem("computronics", "computronics.ocParts", 1L, 3), 200, 120);
                // --- Spoofing Card
                RA.addCircuitAssemblerRecipe(
                        new ItemStack[]{GT_ModHandler.getModItem("OpenComputers", "item", 1L, 11),
                                GT_ModHandler.getModItem("OpenComputers", "item", 2L, 27),
                                GT_ModHandler.getModItem("OpenComputers", "item", 1L, 28),
                                GT_ModHandler.getModItem("OpenComputers", "item", 1L, 25),
                                GT_ModHandler.getModItem("OpenComputers", "item", 2L, 50),
                                GT_Utility.getIntegratedCircuit(2)}, Materials.SolderingAlloy.getMolten(72L),
                        GT_ModHandler.getModItem("computronics", "computronics.ocParts", 1L, 4), 200, 120);
                // --- Beep Card
                RA.addCircuitAssemblerRecipe(
                        new ItemStack[]{GT_ModHandler.getModItem("OpenComputers", "item", 1L, 33),
                                GT_ModHandler.getModItem("OpenComputers", "item", 2L, 27),
                                GT_ModHandler.getModItem("OpenComputers", "item", 1L, 28),
                                GT_ModHandler.getModItem("OpenComputers", "item", 1L, 24),
                                GT_ModHandler.getModItem("computronics", "computronics.speaker", 1L, 0),
                                GT_Utility.getIntegratedCircuit(2)}, Materials.SolderingAlloy.getMolten(72L),
                        GT_ModHandler.getModItem("computronics", "computronics.ocParts", 1L, 5), 200, 120);
                // --- Self-Destructing Card
                RA.addCircuitAssemblerRecipe(
                        new ItemStack[]{GT_ModHandler.getModItem("OpenComputers", "item", 1L, 66),
                                GT_ModHandler.getModItem("OpenComputers", "item", 1L, 28),
                                GT_ModHandler.getModItem("IC2", "blockITNT", 1L, 0),
                                GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Electrum, 8L),
                                GT_Utility.getIntegratedCircuit(1)}, Materials.SolderingAlloy.getMolten(72L),
                        GT_ModHandler.getModItem("computronics", "computronics.ocParts", 1L, 6), 200, 120);
                // --- Colorful Upgrade
                RA.addAssemblerRecipe(
                        new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                                GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Aluminium, 2L),
                                GT_ModHandler.getModItem("computronics", "computronics.colorfulLamp", 1L, 0),
                                GT_ModHandler.getModItem("OpenComputers", "item", 2L, 25),
                                GT_ModHandler.getModItem("OpenComputers", "item", 4L, 96),
                                GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Gold, 4L),
                                GT_Utility.getIntegratedCircuit(1)}, Materials.SolderingAlloy.getMolten(72L),
                        GT_ModHandler.getModItem("computronics", "computronics.ocParts", 1L, 7), 250, 120);
                // --- Noise Card
                RA.addCircuitAssemblerRecipe(
                        new ItemStack[]{GT_ModHandler.getModItem("computronics", "computronics.ocParts", 1L, 5),
                                GT_ModHandler.getModItem("OpenComputers", "item", 2L, 27),
                                GT_ModHandler.getModItem("OpenComputers", "item", 1L, 28),
                                GT_ModHandler.getModItem("OpenComputers", "item", 1L, 25),
                                GT_ModHandler.getModItem("OpenComputers", "item", 1L, 1),
                                GT_Utility.getIntegratedCircuit(1)}, Materials.SolderingAlloy.getMolten(144L),
                        GT_ModHandler.getModItem("computronics", "computronics.ocParts", 1L, 8), 400, 120);
                // --- Sound Card
                RA.addCircuitAssemblerRecipe(
                        new ItemStack[]{GT_ModHandler.getModItem("computronics", "computronics.ocParts", 1L, 8),
                                GT_ModHandler.getModItem("OpenComputers", "item", 1L, 25),
                                GT_ModHandler.getModItem("OpenComputers", "item", 1, 29),
                                GT_ModHandler.getModItem("OpenComputers", "item", 1, 38),
                                GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Diamond, 16L),
                                GT_Utility.getIntegratedCircuit(1)}, Materials.SolderingAlloy.getMolten(72L),
                        GT_ModHandler.getModItem("computronics", "computronics.ocParts", 1L, 9), 400, 256);
                // --- Light Board
                RA.addAssemblerRecipe(
                        new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                                GT_ModHandler.getModItem("computronics", "computronics.colorfulLamp", 1L, 0),
                                GT_ModHandler.getModItem("OpenComputers", "item", 2L, 24),
                                GT_Utility.getIntegratedCircuit(1)}, Materials.Plastic.getMolten(144L),
                        GT_ModHandler.getModItem("computronics", "computronics.ocParts", 1L, 10), 400, 480);
                // --- Server Self-Destructor
                RA.addAssemblerRecipe(
                        new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                                GT_ModHandler.getModItem("computronics", "computronics.ocParts", 2L, 6),
                                GT_ModHandler.getModItem("OpenComputers", "item", 2L, 24),
                                GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.StainlessSteel, 1L),
                                GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Electrum, 8L),
                                GT_Utility.getIntegratedCircuit(1)}, Materials.Plastic.getMolten(144L),
                        GT_ModHandler.getModItem("computronics", "computronics.ocParts", 1L, 11), 300, 120);
                // --- Rack Capacitor
                RA.addAssemblerRecipe(
                        new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                                GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Aluminium, 2L),
                                GT_ModHandler.getModItem("OpenComputers", "capacitor", 1L, 0),
                                GT_ModHandler.getModItem("OpenComputers", "item", 2L, 25),
                                GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Gold, 8L),
                                GT_Utility.getIntegratedCircuit(1)}, Materials.SolderingAlloy.getMolten(72L),
                        GT_ModHandler.getModItem("computronics", "computronics.ocParts", 1L, 12), 250, 256);
                // --- Switch Board
                RA.addAssemblerRecipe(
                        new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                                GT_ModHandler.getModItem("opensecurity", "opensecurity.SwitchableHub", 1L, 0),
                                GT_ModHandler.getModItem("OpenComputers", "item", 2L, 24),
                                GT_Utility.getIntegratedCircuit(1)}, Materials.Plastic.getMolten(144L),
                        GT_ModHandler.getModItem("computronics", "computronics.ocParts", 1L, 13), 200, 120);
                // --- Speech Upgrade
                RA.addAssemblerRecipe(
                        new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                                GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Aluminium, 2L),
                                GT_ModHandler.getModItem("computronics", "computronics.speechBox", 1L, 0),
                                GT_ModHandler.getModItem("OpenComputers", "item", 2L, 25),
                                GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Gold, 4L),
                                GT_Utility.getIntegratedCircuit(1)}, Materials.SolderingAlloy.getMolten(72L),
                        GT_ModHandler.getModItem("computronics", "computronics.ocParts", 1L, 14), 250, 120);

                // --- Open Security
                //Magnetic Card Reader
                RA.addAssemblerRecipe(
                        new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                                GT_ModHandler.getModItem("OpenComputers", "item", 2L, 25),
                                GT_ModHandler.getModItem("OpenComputers", "cable", 2L, 0),
                                ItemList.Circuit_Parts_Transistor.get(2L), GT_Utility.getIntegratedCircuit(2)},
                        Materials.Plastic.getMolten(72L),
                        GT_ModHandler.getModItem("opensecurity", "magreader", 1L, 0), 300, 256);
                RA.addAssemblerRecipe(
                        new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                                GT_ModHandler.getModItem("OpenComputers", "item", 2L, 25),
                                GT_ModHandler.getModItem("OpenComputers", "cable", 2L, 0),
                                ItemList.Circuit_Parts_TransistorSMD.get(1L), GT_Utility.getIntegratedCircuit(2)},
                        Materials.Plastic.getMolten(72L),
                        GT_ModHandler.getModItem("opensecurity", "magreader", 1L, 0), 300, 256);
                //RFID Reader
                RA.addAssemblerRecipe(new ItemStack[]{
                                GT_ModHandler.getModItem("opensecurity", "opensecurity.rfidReaderCard", 1L, 0),
                                ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                                GT_ModHandler.getModItem("OpenComputers", "item", 1L, 25),
                                GT_ModHandler.getModItem("OpenComputers", "cable", 2L, 0),
                                GT_Utility.getIntegratedCircuit(2)}, Materials.Plastic.getMolten(72L),
                        GT_ModHandler.getModItem("opensecurity", "rfidreader", 1L, 0), 300, 120);
                //Card writer
                RA.addAssemblerRecipe(
                        new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                                GT_ModHandler.getModItem("OpenComputers", "item", 2L, 25),
                                GT_ModHandler.getModItem("OpenComputers", "item", 1L, 1),
                                GT_ModHandler.getModItem("OpenComputers", "item", 1L, 28),
                                GT_ModHandler.getModItem("OpenComputers", "cable", 2L, 0),
                                ItemList.Circuit_Parts_Transistor.get(2L), GT_Utility.getIntegratedCircuit(3)},
                        Materials.Plastic.getMolten(72L),
                        GT_ModHandler.getModItem("opensecurity", "rfidwriter", 1L, 0), 300, 120);
                //Alarm
                RA.addAssemblerRecipe(new ItemStack[]{new ItemStack(Blocks.noteblock, 1, 0),
                                ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                                GT_ModHandler.getModItem("OpenComputers", "item", 1L, 25),
                                GT_ModHandler.getModItem("OpenComputers", "cable", 2L, 0),
                                GT_Utility.getIntegratedCircuit(1)}, Materials.Plastic.getMolten(72L),
                        GT_ModHandler.getModItem("opensecurity", "alarm", 1L, 0), 300, 120);
                //Entity Detector
                RA.addAssemblerRecipe(
                        new ItemStack[]{GT_ModHandler.getModItem("OpenComputers", "item", 1L, 33),
                                GT_ModHandler.getModItem("OpenComputers", "item", 2L, 25),
                                GT_ModHandler.getModItem("OpenComputers", "item", 1L, 1),
                                GT_ModHandler.getModItem("OpenComputers", "item", 1L, 28),
                                GT_Utility.getIntegratedCircuit(1)}, Materials.Plastic.getMolten(72L),
                        GT_ModHandler.getModItem("opensecurity", "entitydetector", 1L, 0), 300, 120);
                //Door Controler
                RA.addAssemblerRecipe(
                        new ItemStack[]{GT_ModHandler.getModItem("OpenComputers", "item", 1L, 28),
                                GT_ModHandler.getModItem("OpenComputers", "item", 2L, 25),
                                ItemList.Circuit_Parts_Transistor.get(2L),
                                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Obsidian, 4L),
                                GT_Utility.getIntegratedCircuit(1)}, Materials.Plastic.getMolten(72L),
                        GT_ModHandler.getModItem("opensecurity", "doorcontroller", 1L, 0), 300, 120);
                RA.addAssemblerRecipe(
                        new ItemStack[]{GT_ModHandler.getModItem("OpenComputers", "item", 1L, 28),
                                GT_ModHandler.getModItem("OpenComputers", "item", 2L, 25),
                                ItemList.Circuit_Parts_TransistorSMD.get(1L),
                                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Obsidian, 4L),
                                GT_Utility.getIntegratedCircuit(1)}, Materials.Plastic.getMolten(72L),
                        GT_ModHandler.getModItem("opensecurity", "doorcontroller", 1L, 0), 300, 120);
                //Data Block
                RA.addAssemblerRecipe(
                        new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                                GT_ModHandler.getModItem("OpenComputers", "item", 1L, 104),
                                GT_ModHandler.getModItem("OpenComputers", "item", 1L, 25),
                                GT_ModHandler.getModItem("OpenComputers", "cable", 1L, 0),
                                GT_Utility.getIntegratedCircuit(1)}, Materials.Plastic.getMolten(72L),
                        GT_ModHandler.getModItem("opensecurity", "opensecurity.DataBlock", 1L, 0), 300, 120);
                //swtichable Hub
                RA.addAssemblerRecipe(
                        new ItemStack[]{GT_ModHandler.getModItem("OpenComputers", "relay", 1L, 0),
                                GT_ModHandler.getModItem("OpenComputers", "item", 2L, 25),
                                GT_ModHandler.getModItem("OpenComputers", "cable", 4L, 0),
                                ItemList.Circuit_Parts_Transistor.get(2L), GT_Utility.getIntegratedCircuit(1)},
                        Materials.Plastic.getMolten(72L),
                        GT_ModHandler.getModItem("opensecurity", "opensecurity.SwitchableHub", 1L, 0), 300,
                        120);
                RA.addAssemblerRecipe(
                        new ItemStack[]{GT_ModHandler.getModItem("OpenComputers", "relay", 1L, 0),
                                GT_ModHandler.getModItem("OpenComputers", "item", 2L, 25),
                                GT_ModHandler.getModItem("OpenComputers", "cable", 4L, 0),
                                ItemList.Circuit_Parts_TransistorSMD.get(1L), GT_Utility.getIntegratedCircuit(1)},
                        Materials.Plastic.getMolten(72L),
                        GT_ModHandler.getModItem("opensecurity", "opensecurity.SwitchableHub", 1L, 0), 300,
                        120);
                //kvm Hub
                RA.addAssemblerRecipe(
                        new ItemStack[]{GT_ModHandler.getModItem("OpenComputers", "relay", 1L, 0),
                                GT_ModHandler.getModItem("OpenComputers", "item", 2L, 25),
                                GT_ModHandler.getModItem("OpenComputers", "cable", 4L, 0),
                                ItemList.Circuit_Parts_Transistor.get(2L), GT_Utility.getIntegratedCircuit(2)},
                        Materials.Plastic.getMolten(72L),
                        GT_ModHandler.getModItem("opensecurity", "opensecurity.BlockKVM", 1L, 0), 300, 120);
                RA.addAssemblerRecipe(
                        new ItemStack[]{GT_ModHandler.getModItem("OpenComputers", "relay", 1L, 0),
                                GT_ModHandler.getModItem("OpenComputers", "item", 2L, 25),
                                GT_ModHandler.getModItem("OpenComputers", "cable", 4L, 0),
                                ItemList.Circuit_Parts_TransistorSMD.get(1L), GT_Utility.getIntegratedCircuit(2)},
                        Materials.Plastic.getMolten(72L),
                        GT_ModHandler.getModItem("opensecurity", "opensecurity.BlockKVM", 1L, 0), 300, 120);
                //energy turret
                RA.addAssemblerRecipe(new ItemStack[]{ItemList.Emitter_MV.get(1L),
                                GT_ModHandler.getModItem("OpenComputers", "item", 4L, 25),
                                GT_ModHandler.getModItem("OpenComputers", "cable", 4L, 0),
                                ItemList.Circuit_Parts_Transistor.get(2L), GT_Utility.getIntegratedCircuit(2)},
                        Materials.Plastic.getMolten(72L),
                        GT_ModHandler.getModItem("opensecurity", "energyTurretBlock", 1L, 0), 300, 120);
                RA.addAssemblerRecipe(new ItemStack[]{ItemList.Emitter_MV.get(1L),
                                GT_ModHandler.getModItem("OpenComputers", "item", 4L, 25),
                                GT_ModHandler.getModItem("OpenComputers", "cable", 4L, 0),
                                ItemList.Circuit_Parts_TransistorSMD.get(1L), GT_Utility.getIntegratedCircuit(2)},
                        Materials.Plastic.getMolten(72L),
                        GT_ModHandler.getModItem("opensecurity", "energyTurretBlock", 1L, 0), 300, 120);
                //keypad
                RA.addAssemblerRecipe(
                        new ItemStack[]{GT_ModHandler.getModItem("OpenComputers", "keyboard", 1L, 0),
                                GT_ModHandler.getModItem("OpenComputers", "item", 2L, 24),
                                ItemList.Circuit_Parts_Transistor.get(2L),
                                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Iron, 4L),
                                GT_Utility.getIntegratedCircuit(2)}, Materials.Plastic.getMolten(72L),
                        GT_ModHandler.getModItem("opensecurity", "keypadLock", 1L, 0), 300, 120);
                RA.addAssemblerRecipe(
                        new ItemStack[]{GT_ModHandler.getModItem("OpenComputers", "keyboard", 1L, 0),
                                GT_ModHandler.getModItem("OpenComputers", "item", 2L, 24),
                                ItemList.Circuit_Parts_TransistorSMD.get(1L),
                                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Iron, 4L),
                                GT_Utility.getIntegratedCircuit(2)}, Materials.Plastic.getMolten(72L),
                        GT_ModHandler.getModItem("opensecurity", "keypadLock", 1L, 0), 300, 120);
                //biometric reader
                RA.addAssemblerRecipe(
                        new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.lens, Materials.Glass, 4L),
                                ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                                GT_ModHandler.getModItem("OpenComputers", "item", 2L, 24),
                                ItemList.Circuit_Parts_Transistor.get(2L), GT_Utility.getIntegratedCircuit(1)},
                        Materials.Plastic.getMolten(72L),
                        GT_ModHandler.getModItem("opensecurity", "biometricScanner", 1L, 0), 300, 120);
                RA.addAssemblerRecipe(
                        new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.lens, Materials.Glass, 4L),
                                ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                                GT_ModHandler.getModItem("OpenComputers", "item", 2L, 24),
                                ItemList.Circuit_Parts_TransistorSMD.get(1L), GT_Utility.getIntegratedCircuit(1)},
                        Materials.Plastic.getMolten(72L),
                        GT_ModHandler.getModItem("opensecurity", "biometricScanner", 1L, 0), 300, 120);
                //magnetic stipe card
                RA.addAssemblerRecipe(
                        new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Paper, 4L),
                                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.IronMagnetic, 2L),
                                ItemList.Circuit_Parts_Transistor.get(1L), GT_Utility.getIntegratedCircuit(1)},
                        Materials.Glue.getMolten(144L),
                        GT_ModHandler.getModItem("opensecurity", "opensecurity.magCard", 2L, 0), 150, 64);
                RA.addAssemblerRecipe(
                        new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Paper, 2L),
                                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.IronMagnetic, 1L),
                                ItemList.Circuit_Parts_TransistorSMD.get(1L), GT_Utility.getIntegratedCircuit(1)},
                        Materials.Glue.getMolten(144L),
                        GT_ModHandler.getModItem("opensecurity", "opensecurity.magCard", 2L, 0), 75, 64);
                //RFID Card
                RA.addAssemblerRecipe(
                        new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Paper, 4L),
                                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.IronMagnetic, 2L),
                                GT_ModHandler.getModItem("OpenComputers", "item", 1L, 24),
                                ItemList.Circuit_Parts_Transistor.get(1L), GT_Utility.getIntegratedCircuit(2)},
                        Materials.Glue.getMolten(144L),
                        GT_ModHandler.getModItem("opensecurity", "opensecurity.rfidCard", 2L, 0), 150, 64);
                RA.addAssemblerRecipe(
                        new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Paper, 2L),
                                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.IronMagnetic, 1L),
                                GT_ModHandler.getModItem("OpenComputers", "item", 1L, 24),
                                ItemList.Circuit_Parts_TransistorSMD.get(1L), GT_Utility.getIntegratedCircuit(2)},
                        Materials.Glue.getMolten(144L),
                        GT_ModHandler.getModItem("opensecurity", "opensecurity.rfidCard", 4L, 0), 75, 64);
                //RFID Reader Card
                RA.addAssemblerRecipe(
                        new ItemStack[]{GT_ModHandler.getModItem("OpenComputers", "item", 1L, 33),
                                GT_ModHandler.getModItem("OpenComputers", "item", 1L, 13),
                                GT_ModHandler.getModItem("OpenComputers", "item", 2L, 25),
                                GT_ModHandler.getModItem("OpenComputers", "item", 1L, 1),
                                GT_ModHandler.getModItem("OpenComputers", "item", 1L, 28),
                                GT_Utility.getIntegratedCircuit(2)}, Materials.Plastic.getMolten(72L),
                        GT_ModHandler.getModItem("opensecurity", "opensecurity.rfidReaderCard", 1L, 0), 300,
                        120);
                //Secure Network Card
                RA.addAssemblerRecipe(
                        new ItemStack[]{GT_ModHandler.getModItem("OpenComputers", "item", 1L, 11),
                                GT_ModHandler.getModItem("OpenComputers", "cable", 2L, 0),
                                GT_ModHandler.getModItem("OpenComputers", "item", 1L, 26),
                                GT_Utility.getIntegratedCircuit(1)}, Materials.Plastic.getMolten(72L),
                        GT_ModHandler.getModItem("opensecurity", "opensecurity.secureNetworkCard", 1L, 0), 300,
                        256);
                //Secure Door
                RA.addAssemblerRecipe(new ItemStack[]{new ItemStack(Items.iron_door, 1),
                                GT_ModHandler.getModItem("OpenComputers", "cable", 2L, 0),
                                GT_ModHandler.getModItem("OpenComputers", "item", 1L, 25),
                                ItemList.Circuit_Parts_Transistor.get(1L),
                                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Obsidian, 4L),
                                GT_Utility.getIntegratedCircuit(1)}, GT_Values.NF,
                        GT_ModHandler.getModItem("opensecurity", "opensecurity.securityDoor", 1L, 0), 300, 120);
                RA.addAssemblerRecipe(new ItemStack[]{new ItemStack(Items.iron_door, 1),
                                GT_ModHandler.getModItem("OpenComputers", "cable", 1L, 0),
                                GT_ModHandler.getModItem("OpenComputers", "item", 1L, 25),
                                ItemList.Circuit_Parts_TransistorSMD.get(1L),
                                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Obsidian, 2L),
                                GT_Utility.getIntegratedCircuit(1)}, GT_Values.NF,
                        GT_ModHandler.getModItem("opensecurity", "opensecurity.securityDoor", 1L, 0), 200, 120);
                //Secure Private Door
                RA.addAssemblerRecipe(new ItemStack[]{new ItemStack(Items.iron_door, 1),
                                GT_ModHandler.getModItem("OpenComputers", "cable", 2L, 0),
                                GT_ModHandler.getModItem("OpenComputers", "item", 1L, 25),
                                ItemList.Circuit_Parts_Transistor.get(1L),
                                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Obsidian, 4L),
                                GT_Utility.getIntegratedCircuit(2)}, GT_Values.NF,
                        GT_ModHandler.getModItem("opensecurity", "opensecurity.securityDoorPrivate", 1L, 0),
                        300, 120);
                RA.addAssemblerRecipe(new ItemStack[]{new ItemStack(Items.iron_door, 1),
                                GT_ModHandler.getModItem("OpenComputers", "cable", 1L, 0),
                                GT_ModHandler.getModItem("OpenComputers", "item", 1L, 25),
                                ItemList.Circuit_Parts_TransistorSMD.get(1L),
                                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Obsidian, 2L),
                                GT_Utility.getIntegratedCircuit(2)}, GT_Values.NF,
                        GT_ModHandler.getModItem("opensecurity", "opensecurity.securityDoorPrivate", 1L, 0),
                        300, 120);
                //Damage Upgrade
                RA.addAssemblerRecipe(
                        new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                                new ItemStack(Blocks.tnt, 1, 0),
                                GT_ModHandler.getModItem("OpenComputers", "item", 1L, 24),
                                GT_Utility.getIntegratedCircuit(1)}, Materials.Redstone.getMolten(72L),
                        GT_ModHandler.getModItem("opensecurity", "opensecurity.damageUpgrade", 1L, 0), 300,
                        256);
                //Cooldown upgrade
                RA.addAssemblerRecipe(
                        new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                                GT_ModHandler.getIC2Item("reactorCoolantSimple", 1L, 1),
                                GT_ModHandler.getModItem("OpenComputers", "item", 1L, 24),
                                GT_Utility.getIntegratedCircuit(1)}, Materials.Redstone.getMolten(72L),
                        GT_ModHandler.getModItem("opensecurity", "opensecurity.cooldownUpgrade", 1L, 0), 300,
                        256);
                //Energy Upgrade
                RA.addAssemblerRecipe(
                        new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                                GT_ModHandler.getModItem("OpenComputers", "item", 1L, 63),
                                GT_ModHandler.getModItem("OpenComputers", "item", 1L, 24),
                                GT_Utility.getIntegratedCircuit(1)}, Materials.Redstone.getMolten(72L),
                        GT_ModHandler.getModItem("opensecurity", "opensecurity.energyUpgrade", 1L, 0), 300,
                        256);
                //Movement Upgrade
                RA.addAssemblerRecipe(
                        new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                                ItemList.Electric_Piston_MV.get(1L),
                                GT_ModHandler.getModItem("OpenComputers", "item", 1L, 24),
                                GT_Utility.getIntegratedCircuit(1)}, Materials.Redstone.getMolten(72L),
                        GT_ModHandler.getModItem("opensecurity", "opensecurity.movementUpgrade", 1L, 0), 300,
                        256);
    }

    private void removeOC() {
        removeRecipeByOutput(GT_ModHandler.getModItem("OpenComputers", "cable", 1L, 0), true, false,
                true);
        removeRecipeByOutput(GT_ModHandler.getModItem("OpenComputers", "wrench", 1L, 0), true, false,
                true);
        removeRecipeByOutput(GT_ModHandler.getModItem("OpenComputers", "case1", 1L, 0), true, false,
                true);
        removeRecipeByOutput(GT_ModHandler.getModItem("OpenComputers", "case2", 1L, 0), true, false,
                true);
        removeRecipeByOutput(GT_ModHandler.getModItem("OpenComputers", "case3", 1L, 0), true, false,
                true);
        removeRecipeByOutput(GT_ModHandler.getModItem("OpenComputers", "rack", 1L, 0), true, false,
                true);
        removeRecipeByOutput(GT_ModHandler.getModItem("OpenComputers", "adapter", 1L, 0), true, false,
                true);
        removeRecipeByOutput(GT_ModHandler.getModItem("OpenComputers", "assembler", 1L, 0), true, false,
                true);
        removeRecipeByOutput(GT_ModHandler.getModItem("OpenComputers", "disassembler", 1L, 0), true,
                false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("OpenComputers", "capacitor", 1L, 0), true, false,
                true);
        removeRecipeByOutput(GT_ModHandler.getModItem("OpenComputers", "charger", 1L, 0), true, false,
                true);
        removeRecipeByOutput(GT_ModHandler.getModItem("OpenComputers", "diskDrive", 1L, 0), true, false,
                true);
        removeRecipeByOutput(GT_ModHandler.getModItem("OpenComputers", "geolyzer", 1L, 0), true, false,
                true);
        removeRecipeByOutput(GT_ModHandler.getModItem("OpenComputers", "hologram1", 1L, 0), true, false,
                true);
        removeRecipeByOutput(GT_ModHandler.getModItem("OpenComputers", "hologram2", 1L, 0), true, false,
                true);
        removeRecipeByOutput(GT_ModHandler.getModItem("OpenComputers", "motionSensor", 1L, 0), true,
                false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("OpenComputers", "netSplitter", 1L, 0), true,
                false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("OpenComputers", "printer", 1L, 0), true, false,
                true);
        removeRecipeByOutput(GT_ModHandler.getModItem("OpenComputers", "powerConverter", 1L, 0), true,
                false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("OpenComputers", "powerDistributor", 1L, 0), true,
                false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("OpenComputers", "raid", 1L, 0), true, false,
                true);
        removeRecipeByOutput(GT_ModHandler.getModItem("OpenComputers", "redstone", 1L, 0), true, false,
                true);
        removeRecipeByOutput(GT_ModHandler.getModItem("OpenComputers", "relay", 1L, 0), true, false,
                true);
        removeRecipeByOutput(GT_ModHandler.getModItem("OpenComputers", "transposer", 1L, 0), true,
                false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("OpenComputers", "waypoint", 1L, 0), true, false,
                true);
        removeRecipeByOutput(GT_ModHandler.getModItem("OpenComputers", "keyboard", 1L, 0), true, false,
                true);
        removeRecipeByOutput(GT_ModHandler.getModItem("OpenComputers", "chameliumBlock", 1L, 0), true,
                false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("OpenComputers", "screen1", 1L, 0), true, false,
                true);
        removeRecipeByOutput(GT_ModHandler.getModItem("OpenComputers", "screen2", 1L, 0), true, false,
                true);
        removeRecipeByOutput(GT_ModHandler.getModItem("OpenComputers", "screen3", 1L, 0), true, false,
                true);
        removeRecipeByOutput(GT_ModHandler.getModItem("OpenComputers", "eeprom", 1L, 0), true, false,
                true);
        removeRecipeByOutput(GT_ModHandler.getModItem("OpenComputers", "hoverBoots", 1L, 0), true,
                false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("OpenComputers", "item", 1L, 20), true, false,
                true);
        removeRecipeByOutput(GT_ModHandler.getModItem("OpenComputers", "item", 1L, 19), true, false,
                true);
        removeRecipeByOutput(GT_ModHandler.getModItem("OpenComputers", "item", 1L, 82), true, false,
                true);
        removeRecipeByOutput(GT_ModHandler.getModItem("OpenComputers", "item", 1L, 86), true, false,
                true);
        removeRecipeByOutput(GT_ModHandler.getModItem("OpenComputers", "item", 1L, 83), true, false,
                true);
        removeRecipeByOutput(GT_ModHandler.getModItem("OpenComputers", "item", 1L, 87), true, false,
                true);
        removeRecipeByOutput(GT_ModHandler.getModItem("OpenComputers", "item", 1L, 33), true, false,
                true);
        removeRecipeByOutput(GT_ModHandler.getModItem("OpenComputers", "item", 1L, 4), true, false,
                true);
        removeRecipeByOutput(GT_ModHandler.getModItem("OpenComputers", "item", 1L, 5), true, false,
                true);
        removeRecipeByOutput(GT_ModHandler.getModItem("OpenComputers", "item", 1L, 6), true, false,
                true);
        removeRecipeByOutput(GT_ModHandler.getModItem("OpenComputers", "item", 1L, 7), true, false,
                true);
        removeRecipeByOutput(GT_ModHandler.getModItem("OpenComputers", "item", 1L, 109), true, false,
                true);
        removeRecipeByOutput(GT_ModHandler.getModItem("OpenComputers", "item", 1L, 94), true, false,
                true);
        removeRecipeByOutput(GT_ModHandler.getModItem("OpenComputers", "item", 1L, 48), true, false,
                true);
        removeRecipeByOutput(GT_ModHandler.getModItem("OpenComputers", "item", 1L, 51), true, false,
                true);
        removeRecipeByOutput(GT_ModHandler.getModItem("OpenComputers", "item", 1L, 98), true, false,
                true);
        removeRecipeByOutput(GT_ModHandler.getModItem("OpenComputers", "item", 1L, 107), true, false,
                true);
        removeRecipeByOutput(GT_ModHandler.getModItem("OpenComputers", "item", 1L, 45), true, false,
                true);
        removeRecipeByOutput(GT_ModHandler.getModItem("OpenComputers", "item", 1L, 46), true, false,
                true);
        removeRecipeByOutput(GT_ModHandler.getModItem("OpenComputers", "item", 1L, 40), true, false,
                true);
        removeRecipeByOutput(GT_ModHandler.getModItem("OpenComputers", "item", 1L, 74), true, false,
                true);
        removeRecipeByOutput(GT_ModHandler.getModItem("OpenComputers", "item", 1L, 92), true, false,
                true);
        removeRecipeByOutput(GT_ModHandler.getModItem("OpenComputers", "item", 1L, 41), true, false,
                true);
        removeRecipeByOutput(GT_ModHandler.getModItem("OpenComputers", "item", 1L, 108), true, false,
                true);
        removeRecipeByOutput(GT_ModHandler.getModItem("OpenComputers", "item", 1L, 96), true, false,
                true);
        removeRecipeByOutput(GT_ModHandler.getModItem("OpenComputers", "item", 1L, 27), true, false,
                true);
        removeRecipeByOutput(GT_ModHandler.getModItem("OpenComputers", "item", 1L, 28), true, false,
                true);
        removeRecipeByOutput(GT_ModHandler.getModItem("OpenComputers", "item", 1L, 0), true, false,
                true);
        removeRecipeByOutput(GT_ModHandler.getModItem("OpenComputers", "item", 1L, 29), true, false,
                true);
        removeRecipeByOutput(GT_ModHandler.getModItem("OpenComputers", "item", 1L, 42), true, false,
                true);
        removeRecipeByOutput(GT_ModHandler.getModItem("OpenComputers", "item", 1L, 43), true, false,
                true);
        removeRecipeByOutput(GT_ModHandler.getModItem("OpenComputers", "item", 1L, 8), true, false,
                true);
        removeRecipeByOutput(GT_ModHandler.getModItem("OpenComputers", "item", 1L, 9), true, false,
                true);
        removeRecipeByOutput(GT_ModHandler.getModItem("OpenComputers", "item", 1L, 10), true, false,
                true);
        removeRecipeByOutput(GT_ModHandler.getModItem("OpenComputers", "item", 1L, 44), true, false,
                true);
        removeRecipeByOutput(GT_ModHandler.getModItem("OpenComputers", "item", 1L, 101), true, false,
                true);
        removeRecipeByOutput(GT_ModHandler.getModItem("OpenComputers", "item", 1L, 102), true, false,
                true);
        removeRecipeByOutput(GT_ModHandler.getModItem("OpenComputers", "item", 1L, 1), true, false,
                true);
        removeRecipeByOutput(GT_ModHandler.getModItem("OpenComputers", "item", 1L, 50), true, false,
                true);
        removeRecipeByOutput(GT_ModHandler.getModItem("OpenComputers", "item", 1L, 2), true, false,
                true);
        removeRecipeByOutput(GT_ModHandler.getModItem("OpenComputers", "item", 1L, 3), true, false,
                true);
        removeRecipeByOutput(GT_ModHandler.getModItem("OpenComputers", "item", 1L, 38), true, false,
                true);
        removeRecipeByOutput(GT_ModHandler.getModItem("OpenComputers", "item", 1L, 39), true, false,
                true);
        removeRecipeByOutput(GT_ModHandler.getModItem("OpenComputers", "item", 1L, 24), true, false,
                true);
        removeRecipeByOutput(GT_ModHandler.getModItem("OpenComputers", "item", 1L, 25), true, false,
                true);
        removeRecipeByOutput(GT_ModHandler.getModItem("OpenComputers", "item", 1L, 26), true, false,
                true);
        removeRecipeByOutput(GT_ModHandler.getModItem("OpenComputers", "item", 1L, 11), true, false,
                true);
        removeRecipeByOutput(GT_ModHandler.getModItem("OpenComputers", "item", 1L, 113), true, false,
                true);
        removeRecipeByOutput(GT_ModHandler.getModItem("OpenComputers", "item", 1L, 89), true, false,
                true);
        removeRecipeByOutput(GT_ModHandler.getModItem("OpenComputers", "item", 1L, 66), true, false,
                true);
        removeRecipeByOutput(GT_ModHandler.getModItem("OpenComputers", "item", 1L, 12), true, false,
                true);
        removeRecipeByOutput(GT_ModHandler.getModItem("OpenComputers", "item", 1L, 104), true, false,
                true);
        removeRecipeByOutput(GT_ModHandler.getModItem("OpenComputers", "item", 1L, 105), true, false,
                true);
        removeRecipeByOutput(GT_ModHandler.getModItem("OpenComputers", "item", 1L, 106), true, false,
                true);
        removeRecipeByOutput(GT_ModHandler.getModItem("OpenComputers", "item", 1L, 49), true, false,
                true);
        removeRecipeByOutput(GT_ModHandler.getModItem("OpenComputers", "item", 1L, 99), true, false,
                true);
        removeRecipeByOutput(GT_ModHandler.getModItem("OpenComputers", "item", 1L, 100), true, false,
                true);
        removeRecipeByOutput(GT_ModHandler.getModItem("OpenComputers", "item", 1L, 63), true, false,
                true);
        removeRecipeByOutput(GT_ModHandler.getModItem("OpenComputers", "item", 1L, 64), true, false,
                true);
        removeRecipeByOutput(GT_ModHandler.getModItem("OpenComputers", "item", 1L, 65), true, false,
                true);
        removeRecipeByOutput(GT_ModHandler.getModItem("OpenComputers", "item", 1L, 62), true, false,
                true);
        removeRecipeByOutput(GT_ModHandler.getModItem("OpenComputers", "item", 1L, 76), true, false,
                true);
        removeRecipeByOutput(GT_ModHandler.getModItem("OpenComputers", "item", 1L, 77), true, false,
                true);
        removeRecipeByOutput(GT_ModHandler.getModItem("OpenComputers", "item", 1L, 57), true, false,
                true);
        removeRecipeByOutput(GT_ModHandler.getModItem("OpenComputers", "item", 1L, 58), true, false,
                true);
        removeRecipeByOutput(GT_ModHandler.getModItem("OpenComputers", "item", 1L, 59), true, false,
                true);
        removeRecipeByOutput(GT_ModHandler.getModItem("OpenComputers", "item", 1L, 54), true, false,
                true);
        removeRecipeByOutput(GT_ModHandler.getModItem("OpenComputers", "item", 1L, 55), true, false,
                true);
        removeRecipeByOutput(GT_ModHandler.getModItem("OpenComputers", "item", 1L, 56), true, false,
                true);
        removeRecipeByOutput(GT_ModHandler.getModItem("OpenComputers", "item", 1L, 70), true, false,
                true);
        removeRecipeByOutput(GT_ModHandler.getModItem("OpenComputers", "item", 1L, 71), true, false,
                true);
        removeRecipeByOutput(GT_ModHandler.getModItem("OpenComputers", "item", 1L, 72), true, false,
                true);
        removeRecipeByOutput(GT_ModHandler.getModItem("OpenComputers", "item", 1L, 78), true, false,
                true);
        removeRecipeByOutput(GT_ModHandler.getModItem("OpenComputers", "item", 1L, 79), true, false,
                true);
        removeRecipeByOutput(GT_ModHandler.getModItem("OpenComputers", "item", 1L, 80), true, false,
                true);
        removeRecipeByOutput(GT_ModHandler.getModItem("OpenComputers", "item", 1L, 52), true, false,
                true);
        removeRecipeByOutput(GT_ModHandler.getModItem("OpenComputers", "item", 1L, 14), true, false,
                true);
        removeRecipeByOutput(GT_ModHandler.getModItem("OpenComputers", "item", 1L, 15), true, false,
                true);
        removeRecipeByOutput(GT_ModHandler.getModItem("OpenComputers", "item", 1L, 85), true, false,
                true);
        removeRecipeByOutput(GT_ModHandler.getModItem("OpenComputers", "item", 1L, 112), true, false,
                true);
        removeRecipeByOutput(GT_ModHandler.getModItem("OpenComputers", "item", 1L, 36), true, false,
                true);
        removeRecipeByOutput(GT_ModHandler.getModItem("OpenComputers", "item", 1L, 75), true, false,
                true);
        removeRecipeByOutput(GT_ModHandler.getModItem("OpenComputers", "item", 1L, 35), true, false,
                true);
        removeRecipeByOutput(GT_ModHandler.getModItem("OpenComputers", "item", 1L, 34), true, false,
                true);
        removeRecipeByOutput(GT_ModHandler.getModItem("OpenComputers", "item", 1L, 67), true, false,
                true);
        removeRecipeByOutput(GT_ModHandler.getModItem("OpenComputers", "item", 1L, 110), true, false,
                true);

        removeRecipeByOutput(GT_ModHandler.getModItem("openglasses", "openglassesterminal", 1L, 0),
                true, false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("openglasses", "openglasses", 1L, 0), true, false,
                true);

        removeRecipeByOutput(GT_ModHandler.getModItem("OpenPeripheral", "keyboard", 1L, 0), true, false,
                true);
        removeRecipeByOutput(GT_ModHandler.getModItem("OpenPeripheral", "glassesbridge", 1L, 0), true,
                false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("OpenPeripheral", "glasses", 1L, 0), true, false,
                true);
        removeRecipeByOutput(GT_ModHandler.getModItem("OpenPeripheral", "sensor", 1L, 0), true, false,
                true);
        removeRecipeByOutput(GT_ModHandler.getModItem("OpenPeripheral", "pim", 1L, 0), true, false,
                true);
        removeRecipeByOutput(GT_ModHandler.getModItem("OpenPeripheral", "selector", 1L, 0), true, false,
                true);

        removeRecipeByOutput(GT_ModHandler.getModItem("opensecurity", "magreader", 1L, 0), true, false,
                true);
        removeRecipeByOutput(GT_ModHandler.getModItem("opensecurity", "rfidreader", 1L, 0), true, false,
                true);
        removeRecipeByOutput(GT_ModHandler.getModItem("opensecurity", "rfidwriter", 1L, 0), true, false,
                true);
        removeRecipeByOutput(GT_ModHandler.getModItem("opensecurity", "alarm", 1L, 0), true, false,
                true);
        removeRecipeByOutput(GT_ModHandler.getModItem("opensecurity", "entitydetector", 1L, 0), true,
                false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("opensecurity", "doorcontroller", 1L, 0), true,
                false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("opensecurity", "opensecurity.DataBlock", 1L, 0),
                true, false, true);
        removeRecipeByOutput(
                GT_ModHandler.getModItem("opensecurity", "opensecurity.SwitchableHub", 1L, 0), true, false,
                true);
        removeRecipeByOutput(GT_ModHandler.getModItem("opensecurity", "opensecurity.BlockKVM", 1L, 0),
                true, false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("opensecurity", "energyTurretBlock", 1L, 0), true,
                false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("opensecurity", "keypadLock", 1L, 0), true, false,
                true);
        removeRecipeByOutput(GT_ModHandler.getModItem("opensecurity", "biometricScanner", 1L, 0), true,
                false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("opensecurity", "opensecurity.magCard", 1L, 0),
                true, false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("opensecurity", "opensecurity.rfidCard", 1L, 0),
                true, false, true);
        removeRecipeByOutput(
                GT_ModHandler.getModItem("opensecurity", "opensecurity.rfidReaderCard", 1L, 0), true, false,
                true);
        removeRecipeByOutput(
                GT_ModHandler.getModItem("opensecurity", "opensecurity.secureNetworkCard", 1L, 0), true,
                false, true);
        removeRecipeByOutput(
                GT_ModHandler.getModItem("opensecurity", "opensecurity.securityDoor", 1L, 0), true, false,
                true);
        removeRecipeByOutput(
                GT_ModHandler.getModItem("opensecurity", "opensecurity.securityDoorPrivate", 1L, 0), true,
                false, true);
        removeRecipeByOutput(
                GT_ModHandler.getModItem("opensecurity", "opensecurity.damageUpgrade", 1L, 0), true, false,
                true);
        removeRecipeByOutput(
                GT_ModHandler.getModItem("opensecurity", "opensecurity.cooldownUpgrade", 1L, 0), true,
                false, true);
        removeRecipeByOutput(
                GT_ModHandler.getModItem("opensecurity", "opensecurity.energyUpgrade", 1L, 0), true, false,
                true);
        removeRecipeByOutput(
                GT_ModHandler.getModItem("opensecurity", "opensecurity.movementUpgrade", 1L, 0), true,
                false, true);

        removeRecipeByOutput(GT_ModHandler.getModItem("computronics", "computronics.cipher", 1L, 0),
                true, false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("computronics", "computronics.speechBox", 1L, 0),
                true, false, true);
        removeRecipeByOutput(
                GT_ModHandler.getModItem("computronics", "computronics.ironNoteBlock", 1L, 0), true, false,
                true);
        removeRecipeByOutput(GT_ModHandler.getModItem("computronics", "computronics.radar", 1L, 0),
                true, false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("computronics", "computronics.gt_parts", 1L, 0),
                true, false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("computronics", "computronics.ocParts", 1L, 0),
                true, false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("computronics", "computronics.ocParts", 1L, 1),
                true, false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("computronics", "computronics.ocParts", 1L, 2),
                true, false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("computronics", "computronics.ocParts", 1L, 3),
                true, false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("computronics", "computronics.ocParts", 1L, 4),
                true, false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("computronics", "computronics.ocParts", 1L, 5),
                true, false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("computronics", "computronics.ocParts", 1L, 6),
                true, false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("computronics", "computronics.ocParts", 1L, 7),
                true, false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("computronics", "computronics.ocParts", 1L, 8),
                true, false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("computronics", "computronics.ocParts", 1L, 9),
                true, false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("computronics", "computronics.ocParts", 1L, 10),
                true, false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("computronics", "computronics.ocParts", 1L, 11),
                true, false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("computronics", "computronics.ocParts", 1L, 12),
                true, false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("computronics", "computronics.ocParts", 1L, 13),
                true, false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("computronics", "computronics.ocParts", 1L, 14),
                true, false, true);
        removeRecipeByOutput(GT_ModHandler.getModItem("computery", "card", 1L, 1),
                true, false, true);
    }
}
