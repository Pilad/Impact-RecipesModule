package com.impactrecipes.recipes;

import com.github.technus.tectech.recipe.TT_recipeAdder;
import com.github.technus.tectech.thing.CustomItemList;
import com.impact.common.item.Core_Items2;
import com.impact.mods.gregtech.GT_ItemList;
import gregtech.api.enums.*;
import gregtech.api.util.GT_ModHandler;
import gregtech.api.util.GT_OreDictUnificator;
import gregtech.api.util.GT_Utility;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;

public class TecTech implements Runnable {

    final Core_Items2 CoreItems2 = Core_Items2.getInstance();

    @Override
    public void run() {
//####################################################################################################################################################################################################################################################################################################################################################################################################

        //region multi blocks

        //Active Transformer
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{
                        ItemList.WetTransformer_ZPM_LuV.get(1),
                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Energy, 1),
                        GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.SuperconductorLuV, 16),
                        ItemList.Circuit_Chip_UHPIC.get(2),
                }, Materials.TungstenSteel.getMolten(576), CustomItemList.Machine_Multi_Transformer.get(1), 400,
                30720);

        //Essentia Quantizer
        TT_recipeAdder.addResearchableAssemblylineRecipe(CustomItemList.Machine_Multi_MatterToEM.get(1),
                15000, 32, 500000, 8, new ItemStack[]{
                        CustomItemList.Machine_Multi_MatterToEM.get(1),
                        GT_OreDictUnificator.get(OrePrefixes.pipeMedium, Materials.Neutronium, 4),
                        ItemList.Emitter_UV.get(2),
                        ItemList.Circuit_Wetwaresupercomputer.get(1),
                        GT_OreDictUnificator.get(OrePrefixes.wireGt02, Materials.Diamericiumtitanium, 2),
                }, new FluidStack[]{
                        Materials.SolderingAlloy.getMolten(1296),
                        Materials.Silver.getMolten(2592),
                        new FluidStack(FluidRegistry.getFluid("ic2coolant"), 4000),
                        Materials.Osmium.getMolten(1296),
                }, CustomItemList.Machine_Multi_EssentiaToEM.get(1), 24000, 500000);

        //Essentia DeQuantizer
        TT_recipeAdder.addResearchableAssemblylineRecipe(CustomItemList.Machine_Multi_EMToMatter.get(1),
                15000, 32, 500000, 8, new ItemStack[]{
                        CustomItemList.Machine_Multi_EMToMatter.get(1),
                        GT_OreDictUnificator.get(OrePrefixes.pipeMedium, Materials.Neutronium, 4),
                        ItemList.Sensor_UV.get(2),
                        ItemList.Circuit_Wetwaresupercomputer.get(1),
                        GT_OreDictUnificator.get(OrePrefixes.wireGt02, Materials.Diamericiumtitanium, 2),
                }, new FluidStack[]{
                        Materials.SolderingAlloy.getMolten(1296),
                        Materials.Silver.getMolten(2592),
                        new FluidStack(FluidRegistry.getFluid("ic2coolant"), 4000),
                        Materials.Osmium.getMolten(1296),
                }, CustomItemList.Machine_Multi_EMToEssentia.get(1), 24000, 500000);

        //EM Scanner
        TT_recipeAdder.addResearchableAssemblylineRecipe(CustomItemList.Machine_Multi_Research.get(1),
                150000, 128, 500000, 16, new ItemStack[]{
                        CustomItemList.Machine_Multi_EMjunction.get(1),
                        CustomItemList.eM_Computer_Bus.get(4),
                        ItemList.Field_Generator_UV.get(4),
                        ItemList.Sensor_UV.get(4),
                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Nano, 4),
                        GT_OreDictUnificator.get(OrePrefixes.lens, Materials.MysteriousCrystal, 4),
                        GT_OreDictUnificator.get(OrePrefixes.wireGt02, Materials.Diamericiumtitanium, 4),
                }, new FluidStack[]{
                        Materials.SolderingAlloy.getMolten(1296),
                        Materials.Neutronium.getMolten(2592),
                        new FluidStack(FluidRegistry.getFluid("ic2coolant"), 4000),
                        Materials.Osmiridium.getMolten(1296),
                }, CustomItemList.Machine_Multi_Scanner.get(1), 24000, 500000);

//####################################################################################################################################################################################################################################################################################################################################################################################################

        //region endgame items

        //Motor UHV-UEV
        TT_recipeAdder.addResearchableAssemblylineRecipe(ItemList.Electric_Motor_UV.get(1L),
                24000, 32, 100000, 4, new ItemStack[]{
                        GT_OreDictUnificator.get(OrePrefixes.stickLong, Materials.EuropiumoxideMagnetic, 4L),
                        GT_OreDictUnificator.get(OrePrefixes.stickLong, Materials.Neutronium, 8L),
                        GT_OreDictUnificator.get(OrePrefixes.ring, Materials.Quantium, 8L),
                        GT_OreDictUnificator.get(OrePrefixes.round, Materials.Quantium, 32L),
                        GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Americium, 64L),
                        GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Americium, 64L),
                        GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Americium, 64L),
                        GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Americium, 64L),
                        GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Americium, 64L),
                        GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Americium, 64L),
                        GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Americium, 64L),
                        GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Americium, 64L),
                        GT_OreDictUnificator.get(OrePrefixes.wireGt04, Materials.Europium, 2L)
                }, new FluidStack[]{
                        Materials.SolderingAlloy.getMolten(2592),
                        Materials.Lubricant.getFluid(4000),
                        Materials.Naquadria.getMolten(2592)},
                ItemList.Electric_Motor_UHV.get(1L), 1000, 200000);

        TT_recipeAdder.addResearchableAssemblylineRecipe(ItemList.Electric_Motor_UHV.get(1L),
                48000, 64, 200000, 8, new ItemStack[]{
                        GT_OreDictUnificator.get(OrePrefixes.stickLong, Materials.EuropiumoxideMagnetic, 8L),
                        GT_OreDictUnificator.get(OrePrefixes.stickLong, Materials.CosmicNeutronium, 16L),
                        GT_OreDictUnificator.get(OrePrefixes.ring, Materials.CosmicNeutronium, 8L),
                        GT_OreDictUnificator.get(OrePrefixes.round, Materials.CosmicNeutronium, 32L),
                        GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Neutronium, 64L),
                        GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Neutronium, 64L),
                        GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Neutronium, 64L),
                        GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Neutronium, 64L),
                        GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Neutronium, 64L),
                        GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Neutronium, 64L),
                        GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Neutronium, 64L),
                        GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Neutronium, 64L),
                        GT_OreDictUnificator.get(OrePrefixes.wireGt04, Materials.Diamericiumtitanium, 2L)
                }, new FluidStack[]{
                        Materials.SolderingAlloy.getMolten(5184),
                        Materials.Lubricant.getFluid(8000),
                        Materials.Quantium.getMolten(2592)},
                ItemList.Electric_Motor_UEV.get(1L), 2000, 800000);

        //Pumps UHV-UEV
        TT_recipeAdder.addResearchableAssemblylineRecipe(ItemList.Electric_Pump_UV.get(1L),
                24000, 32, 100000, 4, new ItemStack[]{
                        ItemList.Electric_Motor_UHV.get(1L),
                        GT_OreDictUnificator.get(OrePrefixes.pipeLarge, Materials.Infuscolium, 2L),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Neutronium, 4L),
                        GT_OreDictUnificator.get(OrePrefixes.screw, Materials.Neutronium, 16L),
                        GT_OreDictUnificator.get(OrePrefixes.ring, Materials.Silicone, 32L),
                        GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.Neutronium, 4L),
                        GT_OreDictUnificator.get(OrePrefixes.wireGt04, Materials.Europium, 2L)
                }, new FluidStack[]{
                        Materials.SolderingAlloy.getMolten(2592),
                        Materials.Lubricant.getFluid(4000),
                        Materials.Naquadria.getMolten(2592)},
                ItemList.Electric_Pump_UHV.get(1), 1000, 200000);

        TT_recipeAdder.addResearchableAssemblylineRecipe(ItemList.Electric_Pump_UHV.get(1L),
                48000, 64, 200000, 8, new ItemStack[]{
                        ItemList.Electric_Motor_UEV.get(1L),
                        GT_OreDictUnificator.get(OrePrefixes.pipeLarge, Materials.Neutronium, 2L),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.CosmicNeutronium, 4L),
                        GT_OreDictUnificator.get(OrePrefixes.screw, Materials.CosmicNeutronium, 16L),
                        GT_OreDictUnificator.get(OrePrefixes.ring, (Materials.Silicone), 64L),
                        GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.CosmicNeutronium, 4L),
                        GT_OreDictUnificator.get(OrePrefixes.wireGt04, Materials.Diamericiumtitanium, 2L)
                }, new FluidStack[]{
                        Materials.SolderingAlloy.getMolten(5184),
                        Materials.Lubricant.getFluid(8000),
                        Materials.Quantium.getMolten(2592)},
                ItemList.Electric_Pump_UEV.get(1), 2000, 800000);

        //Conveyor Belt UHV-UEV
        TT_recipeAdder.addResearchableAssemblylineRecipe(ItemList.Conveyor_Module_UV.get(1L),
                24000, 32, 100000, 4, new ItemStack[]{
                        ItemList.Electric_Motor_UHV.get(2L),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Neutronium, 2L),
                        GT_OreDictUnificator.get(OrePrefixes.ring, Materials.Neutronium, 8L),
                        GT_OreDictUnificator.get(OrePrefixes.round, Materials.Neutronium, 64L),
                        GT_OreDictUnificator.get(OrePrefixes.wireGt04, Materials.Europium, 2L)
                }, new FluidStack[]{
                        Materials.SolderingAlloy.getMolten(2592),
                        Materials.Lubricant.getFluid(4000),
                        Materials.Silicone.getMolten(5760),
                        Materials.Naquadria.getMolten(2592)},
                ItemList.Conveyor_Module_UHV.get(1), 1000, 200000);

        TT_recipeAdder.addResearchableAssemblylineRecipe(ItemList.Conveyor_Module_UHV.get(1L),
                48000, 64, 200000, 8, new ItemStack[]{
                        ItemList.Electric_Motor_UEV.get(2L),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.CosmicNeutronium, 2L),
                        GT_OreDictUnificator.get(OrePrefixes.ring, Materials.CosmicNeutronium, 8L),
                        GT_OreDictUnificator.get(OrePrefixes.round, Materials.CosmicNeutronium, 64L),
                        GT_OreDictUnificator.get(OrePrefixes.wireGt04, Materials.Diamericiumtitanium, 2L)
                }, new FluidStack[]{
                        Materials.SolderingAlloy.getMolten(5184),
                        Materials.Lubricant.getFluid(8000),
                        Materials.Silicone.getMolten(11520),
                        Materials.Quantium.getMolten(2592)},
                ItemList.Conveyor_Module_UEV.get(1), 2000, 800000);

        //Piston UHV-UEV
        TT_recipeAdder.addResearchableAssemblylineRecipe(ItemList.Electric_Piston_UV.get(1L),
                24000, 32, 100000, 4, new ItemStack[]{
                        ItemList.Electric_Motor_UHV.get(1L),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Neutronium, 6L),
                        GT_OreDictUnificator.get(OrePrefixes.ring, Materials.Neutronium, 8L),
                        GT_OreDictUnificator.get(OrePrefixes.round, Materials.Neutronium, 64L),
                        GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Neutronium, 8L),
                        GT_OreDictUnificator.get(OrePrefixes.gear, Materials.Neutronium, 2L),
                        GT_OreDictUnificator.get(OrePrefixes.gearGtSmall, Materials.Neutronium, 4L),
                        GT_OreDictUnificator.get(OrePrefixes.wireGt04, Materials.Europium, 4L)
                }, new FluidStack[]{
                        Materials.SolderingAlloy.getMolten(2592),
                        Materials.Lubricant.getFluid(4000),
                        Materials.Naquadria.getMolten(2592)},
                ItemList.Electric_Piston_UHV.get(1), 1000, 200000);

        TT_recipeAdder.addResearchableAssemblylineRecipe(ItemList.Electric_Piston_UHV.get(1L),
                48000, 64, 200000, 8, new ItemStack[]{
                        ItemList.Electric_Motor_UEV.get(1L),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.CosmicNeutronium, 6L),
                        GT_OreDictUnificator.get(OrePrefixes.ring, Materials.CosmicNeutronium, 8L),
                        GT_OreDictUnificator.get(OrePrefixes.round, Materials.CosmicNeutronium, 64L),
                        GT_OreDictUnificator.get(OrePrefixes.stick, Materials.CosmicNeutronium, 8L),
                        GT_OreDictUnificator.get(OrePrefixes.gear, Materials.CosmicNeutronium, 2L),
                        GT_OreDictUnificator.get(OrePrefixes.gearGtSmall, Materials.CosmicNeutronium, 4L),
                        GT_OreDictUnificator.get(OrePrefixes.wireGt04, Materials.Diamericiumtitanium, 4L)
                }, new FluidStack[]{
                        Materials.SolderingAlloy.getMolten(5184),
                        Materials.Lubricant.getFluid(8000),
                        Materials.Quantium.getMolten(2592)},
                ItemList.Electric_Piston_UEV.get(1), 2000, 800000);

        //Robot Arm UHV-UEV
        TT_recipeAdder.addResearchableAssemblylineRecipe(ItemList.Robot_Arm_UV.get(1L),
                24000, 32, 100000, 4, new Object[]{
                        GT_OreDictUnificator.get(OrePrefixes.stickLong, Materials.Neutronium, 8L),
                        GT_OreDictUnificator.get(OrePrefixes.gear, Materials.Neutronium, 2L),
                        GT_OreDictUnificator.get(OrePrefixes.gearGtSmall, Materials.Neutronium, 6L),
                        ItemList.Electric_Motor_UHV.get(2L),
                        ItemList.Electric_Piston_UHV.get(1L),
                        new Object[]{OrePrefixes.circuit.get(Materials.Infinite), 2L},
                        new Object[]{OrePrefixes.circuit.get(Materials.Superconductor), 4L},
                        new Object[]{OrePrefixes.circuit.get(Materials.Ultimate), 8L},
                        GT_OreDictUnificator.get(OrePrefixes.wireGt04, Materials.Europium, 6L)
                }, new FluidStack[]{
                        Materials.SolderingAlloy.getMolten(4608),
                        Materials.Lubricant.getFluid(4000),
                        Materials.Naquadria.getMolten(2592)},
                ItemList.Robot_Arm_UHV.get(1L), 1000, 200000);

        TT_recipeAdder.addResearchableAssemblylineRecipe(ItemList.Robot_Arm_UHV.get(1L),
                48000, 64, 200000, 8, new Object[]{
                        GT_OreDictUnificator.get(OrePrefixes.stickLong, Materials.CosmicNeutronium, 8L),
                        GT_OreDictUnificator.get(OrePrefixes.gear, Materials.CosmicNeutronium, 2L),
                        GT_OreDictUnificator.get(OrePrefixes.gearGtSmall, Materials.CosmicNeutronium, 6L),
                        ItemList.Electric_Motor_UEV.get(2L),
                        ItemList.Electric_Piston_UEV.get(1L),
                        new Object[]{OrePrefixes.circuit.get(Materials.Bio), 2L},
                        new Object[]{OrePrefixes.circuit.get(Materials.Infinite), 4L},
                        new Object[]{OrePrefixes.circuit.get(Materials.Superconductor), 8L},
                        GT_OreDictUnificator.get(OrePrefixes.wireGt04, Materials.Diamericiumtitanium, 6L)
                }, new FluidStack[]{
                        Materials.SolderingAlloy.getMolten(9216),
                        Materials.Lubricant.getFluid(8000),
                        Materials.Quantium.getMolten(2592)},
                ItemList.Robot_Arm_UEV.get(1L), 2000, 800000);

        //Emitter UHV-UEV
        TT_recipeAdder.addResearchableAssemblylineRecipe(ItemList.Emitter_UV.get(1L),
                24000, 32, 100000, 4, new Object[]{
                        GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Neutronium, 1L),
                        ItemList.Electric_Motor_UHV.get(1L),
                        GT_OreDictUnificator.get(OrePrefixes.stickLong, Materials.Neutronium, 8L),
                        GT_OreDictUnificator.get(OrePrefixes.gemExquisite, Materials.MysteriousCrystal, 4L),
                        new Object[]{OrePrefixes.circuit.get(Materials.Infinite), 4L},
                        GT_OreDictUnificator.get(OrePrefixes.foil, Materials.ElectrumFlux, 64L),
                        GT_OreDictUnificator.get(OrePrefixes.foil, Materials.ElectrumFlux, 64L),
                        GT_OreDictUnificator.get(OrePrefixes.foil, Materials.ElectrumFlux, 64L),
                        GT_OreDictUnificator.get(OrePrefixes.foil, Materials.ElectrumFlux, 64L),
                        GT_OreDictUnificator.get(OrePrefixes.wireGt04, Materials.Europium, 7L)
                }, new FluidStack[]{
                        Materials.SolderingAlloy.getMolten(4608),
                        Materials.Naquadria.getMolten(2592)},
                ItemList.Emitter_UHV.get(1L), 1000, 200000);

        TT_recipeAdder.addResearchableAssemblylineRecipe(ItemList.Emitter_UHV.get(1L),
                48000, 64, 200000, 8, new Object[]{
                        GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.CosmicNeutronium, 1L),
                        ItemList.Electric_Motor_UEV.get(1L),
                        GT_OreDictUnificator.get(OrePrefixes.stickLong, Materials.Phoenixite, 12L),
                        GT_OreDictUnificator.get(OrePrefixes.gemExquisite, Materials.EnrichedMysteriousCrystal,
                                8L),
                        new Object[]{OrePrefixes.circuit.get(Materials.Bio), 4L},
                        GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Adamantium, 64L),
                        GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Adamantium, 64L),
                        GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Adamantium, 64L),
                        GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Adamantium, 64L),
                        GT_OreDictUnificator.get(OrePrefixes.wireGt04, Materials.Diamericiumtitanium, 7L)
                }, new FluidStack[]{
                        Materials.SolderingAlloy.getMolten(9216),
                        Materials.Quantium.getMolten(2592)},
                ItemList.Emitter_UEV.get(1L), 2000, 800000);

        //Sensor UHV-UEV
        TT_recipeAdder.addResearchableAssemblylineRecipe(ItemList.Sensor_UV.get(1L),
                24000, 32, 100000, 4, new Object[]{
                        GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Neutronium, 1L),
                        ItemList.Electric_Motor_UHV.get(1L),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Neutronium, 8L),
                        GT_OreDictUnificator.get(OrePrefixes.gemExquisite, Materials.MysteriousCrystal, 4L),
                        new Object[]{OrePrefixes.circuit.get(Materials.Infinite), 4L},
                        GT_OreDictUnificator.get(OrePrefixes.foil, Materials.ElectrumFlux, 64L),
                        GT_OreDictUnificator.get(OrePrefixes.foil, Materials.ElectrumFlux, 64L),
                        GT_OreDictUnificator.get(OrePrefixes.foil, Materials.ElectrumFlux, 64L),
                        GT_OreDictUnificator.get(OrePrefixes.foil, Materials.ElectrumFlux, 64L),
                        GT_OreDictUnificator.get(OrePrefixes.wireGt04, Materials.Europium, 7L)
                }, new FluidStack[]{
                        Materials.SolderingAlloy.getMolten(4608),
                        Materials.Naquadria.getMolten(2592)},
                ItemList.Sensor_UHV.get(1L), 1000, 200000);

        TT_recipeAdder.addResearchableAssemblylineRecipe(ItemList.Sensor_UHV.get(1L),
                48000, 64, 200000, 8, new Object[]{
                        GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.CosmicNeutronium, 1L),
                        ItemList.Electric_Motor_UEV.get(1),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Phoenixite, 12L),
                        GT_OreDictUnificator.get(OrePrefixes.gemExquisite, Materials.EnrichedMysteriousCrystal,
                                8L),
                        new Object[]{OrePrefixes.circuit.get(Materials.Bio), 4L},
                        GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Adamantium, 64L),
                        GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Adamantium, 64L),
                        GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Adamantium, 64L),
                        GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Adamantium, 64L),
                        GT_OreDictUnificator.get(OrePrefixes.wireGt04, Materials.Draconium, 7L)
                }, new FluidStack[]{
                        Materials.SolderingAlloy.getMolten(9216),
                        Materials.Quantium.getMolten(2592)},
                ItemList.Sensor_UEV.get(1L), 2000, 800000);

        //Fieldgen UHV and UEV
        TT_recipeAdder.addResearchableAssemblylineRecipe(ItemList.Field_Generator_UV.get(1),
                48000, 64, 200000, 8, new Object[]{
                        GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Neutronium, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Neutronium, 6L),
                        GT_OreDictUnificator.get(OrePrefixes.gemExquisite, Materials.MysteriousCrystal, 4L),
                        ItemList.Emitter_UHV.get(4),
                        new Object[]{OrePrefixes.circuit.get(Materials.Bio), 4L},
                        GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Tritanium, 64L),
                        GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Tritanium, 64L),
                        GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Tritanium, 64L),
                        GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Tritanium, 64L),
                        GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Tritanium, 64L),
                        GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Tritanium, 64L),
                        GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Tritanium, 64L),
                        GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Tritanium, 64L),
                        GT_OreDictUnificator.get(OrePrefixes.wireGt04, Materials.Europium, 8L)
                }, new FluidStack[]{
                        Materials.SolderingAlloy.getMolten(4608),
                        Materials.Naquadria.getMolten(2592)},
                ItemList.Field_Generator_UHV.get(1L), 2000, 200000);

        TT_recipeAdder.addResearchableAssemblylineRecipe(ItemList.Field_Generator_UHV.get(1L),
                96000, 128, 400000, 16, new Object[]{
                        GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.CosmicNeutronium, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.CosmicNeutronium, 6L),
                        GT_OreDictUnificator.get(OrePrefixes.gemExquisite, Materials.EnrichedMysteriousCrystal,
                                4L),
                        ItemList.Emitter_UEV.get(4),
                        new Object[]{OrePrefixes.circuit.get(Materials.Nano), 8L},
                        GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Neutronium, 64L),
                        GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Neutronium, 64L),
                        GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Neutronium, 64L),
                        GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Neutronium, 64L),
                        GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Neutronium, 64L),
                        GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Neutronium, 64L),
                        GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Neutronium, 64L),
                        GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Neutronium, 64L),
                        GT_OreDictUnificator.get(OrePrefixes.wireGt04, Materials.Diamericiumtitanium, 8L)
                }, new FluidStack[]{
                        Materials.SolderingAlloy.getMolten(9216),
                        Materials.Quantium.getMolten(2592)
                },
                ItemList.Field_Generator_UEV.get(1L), 4000, 800000);

        //Circuits UHV - UXV

        //UHV Circuit
        TT_recipeAdder.addResearchableAssemblylineRecipe(ItemList.Circuit_Wetwaresupercomputer.get(1L),
                24000, 64, 50000, 4, new ItemStack[]{
                        GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Tritanium, 2),
                        ItemList.Circuit_Wetwaresupercomputer.get(2L),
                        ItemList.ZPM_Coil.get(16L),
                        ItemList.Circuit_Parts_CapacitorASMD.get(32L),
                        ItemList.Circuit_Parts_ResistorASMD.get(32L),
                        ItemList.Circuit_Parts_TransistorASMD.get(32L),
                        ItemList.Circuit_Parts_DiodeASMD.get(32L),
                        ItemList.Circuit_Chip_Ram.get(48L),
                        GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.SuperconductorZPM, 64L),
                        GT_OreDictUnificator.get(OrePrefixes.foil, (Materials.Silicone), 64L),
                }, new FluidStack[]{
                        Materials.SolderingAlloy.getMolten(2880L),
                        new FluidStack(FluidRegistry.getFluid("ic2coolant"), 10000),
                        Materials.Radon.getGas(2500L),
                },
                ItemList.Circuit_Wetwaremainframe.get(1L), 2000, 300000);

        //Bio Chips
        TT_recipeAdder.addResearchableAssemblylineRecipe(ItemList.Circuit_Biowarecomputer.get(1L),
                48000, 128, 500000, 8, new ItemStack[]{
                        ItemList.Circuit_Board_Bio_Ultra.get(2L),
                        ItemList.Circuit_Biowarecomputer.get(2L),
                        ItemList.Circuit_Parts_TransistorASMD.get(16L),
                        ItemList.Circuit_Parts_ResistorASMD.get(16L),
                        ItemList.Circuit_Parts_CapacitorASMD.get(16L),
                        ItemList.Circuit_Parts_DiodeASMD.get(48L),
                        ItemList.Circuit_Chip_NOR.get(32L),
                        ItemList.Circuit_Chip_Ram.get(64L),
                        GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.NiobiumTitanium, 32L),
                        GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Silicone, 16L),
                }, new FluidStack[]{
                        Materials.SolderingAlloy.getMolten(1440L),
                        Materials.BioMediumSterilized.getFluid(1440L),
                        new FluidStack(FluidRegistry.getFluid("ic2coolant"), 10000)
                },
                ItemList.Circuit_Biowaresupercomputer.get(1L), 4000, 500000);

        TT_recipeAdder.addResearchableAssemblylineRecipe(ItemList.Circuit_Biowaresupercomputer.get(1L),
                96000, 256, 1000000, 16, new ItemStack[]{
                        GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Tritanium, 4L),
                        ItemList.Circuit_Biowaresupercomputer.get(2L),
                        ItemList.UV_Coil.get(16L),
                        ItemList.Circuit_Parts_CapacitorASMD.get(64L),
                        ItemList.Circuit_Parts_ResistorASMD.get(64L),
                        ItemList.Circuit_Parts_TransistorASMD.get(64L),
                        ItemList.Circuit_Parts_DiodeASMD.get(64L),
                        ItemList.Circuit_Chip_Ram.get(64L),
                        GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.Superconductor, 64),
                        GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Silicone, 64),
                        GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Polybenzimidazole, 64)
                }, new FluidStack[]{
                        Materials.SolderingAlloy.getMolten(2880L),
                        Materials.BioMediumSterilized.getFluid(2880L),
                        new FluidStack(FluidRegistry.getFluid("ic2coolant"), 20000)
                },
                ItemList.Circuit_Biomainframe.get(1L), 6000, 2000000);

        TT_recipeAdder.addResearchableAssemblylineRecipe(ItemList.Circuit_Biomainframe.get(1L),
                192000, 512, 2000000, 32, new ItemStack[]{
                        GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Tritanium, 8),
                        ItemList.Circuit_Biomainframe.get(2L),
                        ItemList.Circuit_Parts_CapacitorASMD.get(64L),
                        ItemList.Circuit_Parts_ResistorASMD.get(64L),
                        ItemList.Circuit_Parts_TransistorASMD.get(64L),
                        ItemList.Circuit_Parts_DiodeASMD.get(64L),
                        ItemList.Circuit_Chip_Ram.get(64L),
                        ItemList.Circuit_Chip_NPIC.get(64L),
                        GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.Diamericiumtitanium, 64),
                        GT_OreDictUnificator.get(OrePrefixes.wireGt02, Materials.Superconductor, 64),
                        GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Silicone, 64),
                        GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Polybenzimidazole, 64)
                }, new FluidStack[]{
                        Materials.SolderingAlloy.getMolten(4032L),
                        Materials.Naquadria.getMolten(4032L),
                        new FluidStack(FluidRegistry.getFluid("ic2coolant"), 20000),
                        Materials.HyperFuelI.getFluid(2000)
                },
                ItemList.Circuit_Nano.get(1L), 8000, 8000000);

        TT_recipeAdder.addResearchableAssemblylineRecipe(ItemList.Circuit_Chip_Pico.get(1L),
                384000, 1024, 4000000, 64, new ItemStack[]{
                        ItemList.Circuit_Board_Bio_Ultra.get(1L),
                        ItemList.Circuit_Chip_Pico.get(4L),
                        ItemList.Circuit_Nano.get(2L),
                        ItemList.Circuit_Parts_TransistorASMD.get(64L),
                        ItemList.Circuit_Parts_ResistorASMD.get(64L),
                        ItemList.Circuit_Parts_CapacitorASMD.get(64L),
                        ItemList.Circuit_Parts_DiodeASMD.get(64L),
                        ItemList.Circuit_Chip_PPIC.get(64L),
                        GT_OreDictUnificator.get(OrePrefixes.foil, Materials.NiobiumTitanium, 16),
                        GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Osmium, 32),
                        GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Neutronium, 16),
                        GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Lanthanum, 64)
                }, new FluidStack[]{
                        Materials.SolderingAlloy.getMolten(4032L),
                        Materials.Osmium.getMolten(1152L),
                        Materials.HyperFuelII.getFluid(4000)
                },
                ItemList.Circuit_Piko.get(1L), 10000, 8000000);

        TT_recipeAdder.addResearchableAssemblylineRecipe(ItemList.Circuit_Piko.get(1L),
                720000, 2048, 8000000, 128, new ItemStack[]{
                        GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Neutronium, 16),
                        ItemList.Circuit_Piko.get(8L),
                        ItemList.Circuit_Parts_CapacitorASMD.get(64L),
                        ItemList.Circuit_Parts_DiodeASMD.get(64L),
                        ItemList.Circuit_Parts_TransistorASMD.get(64L),
                        ItemList.Circuit_Parts_ResistorASMD.get(64L),
                        ItemList.Circuit_Chip_QPIC.get(64L),
                        GT_OreDictUnificator.get(OrePrefixes.foil, Materials.NiobiumTitanium, 64),
                        GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Indium, 64),
                        GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.Neutronium, 8),
                        GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Lanthanum, 64)
                }, new FluidStack[]{
                        Materials.SolderingAlloy.getMolten(4032L),
                        Materials.Osmium.getMolten(2304L),
                        Materials.HyperFuelIII.getFluid(8000)
                },
                ItemList.Circuit_Quantum.get(1L), 20000, 32000000);

        //Batteries

        TT_recipeAdder
                .addResearchableAssemblylineRecipe(ItemList.Energy_Cluster.get(1L), 12000, 16, 100000, 3,
                        new Object[]{
                                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Tritanium, 64L),
                                new Object[]{OrePrefixes.circuit.get(Materials.Infinite), 4L},
                                ItemList.Circuit_HighEnergyFlow.get(4L),
                                ItemList.Energy_Cluster.get(8L),
                                ItemList.Field_Generator_UV.get(2),
                                ItemList.Circuit_Wafer_HPIC.get(64),
                                ItemList.Circuit_Wafer_HPIC.get(64),
                                ItemList.Circuit_Parts_DiodeASMD.get(64),
                                GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.Superconductor, 32),
                        }, new FluidStack[]{
                                Materials.SolderingAlloy.getMolten(2880),
                                new FluidStack(FluidRegistry.getFluid("ic2coolant"), 16000)
                        }, ItemList.ZPM2.get(1), 3000, 400000);

        TT_recipeAdder.addResearchableAssemblylineRecipe(ItemList.ZPM2.get(1L), 24000, 64, 200000, 6,
                new Object[]{
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Neutronium, 32L),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Neutronium, 32L),
                        new Object[]{OrePrefixes.circuit.get(Materials.Bio), 4L},
                        ItemList.Circuit_HighEnergyFlow.get(8L),
                        ItemList.ZPM2.get(8),
                        ItemList.Field_Generator_UHV.get(4),
                        ItemList.Circuit_Wafer_UHPIC.get(64),
                        ItemList.Circuit_Wafer_UHPIC.get(64),
                        ItemList.Circuit_Wafer_SoC2.get(32),
                        ItemList.Circuit_Parts_DiodeASMD.get(64),
                        GT_OreDictUnificator.get(OrePrefixes.wireGt02, Materials.SuperconductorUEV, 64),
                }, new FluidStack[]{
                        Materials.SolderingAlloy.getMolten(4032),
                        Materials.Naquadria.getMolten(9000),
                        new FluidStack(FluidRegistry.getFluid("ic2coolant"), 32000)
                }, ItemList.ZPM3.get(1), 4000, 1600000);

        //Orb Housing
        TT_recipeAdder.addResearchableAssemblylineRecipe(
                GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Quantium, 1L), 12000, 16, 500000, 3,
                new ItemStack[]{
                        ItemList.Circuit_Board_Bio_Ultra.get(1L),
                        CoreItems2.getRecipe(85, 4),
                        GT_OreDictUnificator.get(OrePrefixes.stickLong, Materials.Neutronium, 6),
                        GT_OreDictUnificator.get(OrePrefixes.ring, Materials.Pikyonium64B, 8),
                        GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.HSSG, 16),
                        GT_OreDictUnificator.get(OrePrefixes.screw, Materials.HSSE, 16),
                },
                new FluidStack[]{},
                CoreItems2.getRecipe(190, 1), 400, 300000);
        TT_recipeAdder.addResearchableAssemblylineRecipe(
                GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Adamantium, 1L), 16000, 18, 1000000, 6,
                new ItemStack[]{
                        ItemList.Circuit_Board_Crystal_Extreme.get(1L),
                        CoreItems2.getRecipe(174, 6),
                        GT_OreDictUnificator.get(OrePrefixes.stickLong, Materials.Phoenixite, 8),
                        GT_OreDictUnificator.get(OrePrefixes.ring, Materials.Quantum, 12),
                        GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.HSSG, 24),
                        GT_OreDictUnificator.get(OrePrefixes.screw, Materials.HSSE, 24),
                },
                new FluidStack[]{},
                CoreItems2.getRecipe(191, 1), 500, 800000);


        //Blocks and Multiblocks
        TT_recipeAdder
                .addResearchableAssemblylineRecipe(ItemList.Casing_Core_Chamber.get(1L), 48000, 128,
                        1000000, 6, new Object[]{
                                ItemList.Hull_MAX.get(1L),
                                ItemList.Casing_Dyson_Ring.get(16L),
                                ItemList.Casing_Fusion_Coil.get(16L),
                                ItemList.Field_Generator_UV.get(4L),
                                ItemList.Sensor_UHV.get(4L),
                                ItemList.Emitter_UHV.get(4L),
                                new Object[]{OrePrefixes.circuit.get(Materials.Infinite), 4L},
                                GT_OreDictUnificator.get(OrePrefixes.lens, Materials.EnrichedMysteriousCrystal, 32),
                                GT_OreDictUnificator.get(OrePrefixes.wireGt04, Materials.Superconductor, 16)
                        }, new FluidStack[]{
                                Materials.EnrichedNaquadria.getFluid(2592),
                                Materials.Neutronium.getMolten(2592),
                                new FluidStack(FluidRegistry.getFluid("ic2coolant"), 4000),
                                Materials.Osmiridium.getMolten(1296)
                        },
                        ItemList.Machine_MultiblockTesseract.get(1L), 8000, 2000000);

        TT_recipeAdder
                .addResearchableAssemblylineRecipe(ItemList.Casing_Fusion_Coil3.get(1L), 12000, 32, 500000,
                        6, new Object[]{
                                ItemList.Casing_Fusion_Coil3.get(1L),
                                ItemList.Circuit_Nano.get(1L),
                                ItemList.Circuit_Nano.get(1L),
                                ItemList.Circuit_Nano.get(1L),
                                ItemList.Circuit_Nano.get(1L),
                                GT_OreDictUnificator.get(OrePrefixes.plateDense, Materials.Neutronium, 4L),
                                ItemList.Field_Generator_UHV.get(2L),
                                ItemList.Circuit_Wafer_QPIC.get(64L),
                                ItemList.Circuit_Wafer_QPIC.get(64L),
                                GT_OreDictUnificator.get(OrePrefixes.wireGt04, Materials.SuperconductorUEV, 32),
                        }, new FluidStack[]{
                                Materials.SolderingAlloy.getMolten(5760),
                                Materials.Phoenixite.getMolten(2304L)
                        },
                        ItemList.FusionComputer_UEV.get(1L), 1600, 1000000);

        TT_recipeAdder.addResearchableAssemblylineRecipe(ItemList.Cover_SolarPanel_UV.get(1L),
                96000, 128, 500000, 16, new ItemStack[]{
                        ItemList.Cover_SolarPanel_UV.get(2L),
                        ItemList.Circuit_Nano.get(8L),
                        GT_OreDictUnificator.get(OrePrefixes.plateQuintuple, Materials.Sunnarium, 8),
                        ItemList.Circuit_Silicon_Wafer10.get(4L),
                        ItemList.Circuit_Silicon_Wafer6.get(4L),
                        ItemList.Circuit_Chip_RPico.get(4L),
                        GT_OreDictUnificator.get(OrePrefixes.plateAlloy, Materials.Carbon, 12),
                        GT_OreDictUnificator.get(OrePrefixes.plateDense, Materials.Neutronium, 3),
                        ItemList.Circuit_Chip_QPIC.get(8L),
                        GT_OreDictUnificator.get(OrePrefixes.plateDense, Materials.Silicon, 8),
                        GT_OreDictUnificator.get(OrePrefixes.plateTriple, Materials.ElectrumFlux, 8),
                        GT_OreDictUnificator.get(OrePrefixes.wireGt08, Materials.Superconductor, 16)
                },
                new FluidStack[]{
                        Materials.SolderingAlloy.getMolten(1890),
                        Materials.PerroxPolymer.getMolten(2880)
                },
                ItemList.Cover_SolarPanel_UHV.get(1), 840, 8000000);

        TT_recipeAdder.addResearchableAssemblylineRecipe(ItemList.Cover_SolarPanel_UHV.get(1L),
                192000, 512, 2000000, 32, new ItemStack[]{
                        ItemList.Cover_SolarPanel_UHV.get(1L),
                        ItemList.Circuit_Piko.get(8L),
                        GT_OreDictUnificator.get(OrePrefixes.plateDense, Materials.Sunnarium, 8),
                        ItemList.Circuit_Chip_Pico.get(8L),
                        GT_OreDictUnificator.get(OrePrefixes.plateAlloy, Materials.Carbon, 16),
                        GT_OreDictUnificator.get(OrePrefixes.plateDense, Materials.Phoenixite, 4),
                        ItemList.Circuit_Chip_FPIC.get(12L),
                        GT_OreDictUnificator.get(OrePrefixes.plateDense, Materials.Silicon, 8),
                        GT_OreDictUnificator.get(OrePrefixes.plateQuadruple, Materials.ElectrumFlux, 8),
                        GT_OreDictUnificator.get(OrePrefixes.wireGt12, Materials.SuperconductorUEV, 18)
                },
                new FluidStack[]{
                        Materials.SolderingAlloy.getMolten(3780),
                        Materials.PerroxPolymer.getMolten(5760)
                },
                ItemList.Cover_SolarPanel_UEV.get(1), 960, 32000000);

        TT_recipeAdder.addResearchableAssemblylineRecipe(ItemList.Machine_DigitalTransformer_UV.get(1L),
                12000, 16, 100000, 2, new Object[]{
                        ItemList.WetTransformer_UEV_UHV.get(1),
                        ItemList.Cover_Screen.get(16L),
                        GT_OreDictUnificator.get(OrePrefixes.spring, Materials.Osmium, 2L),
                        ItemList.UHV_Coil.get(1L),
                        ItemList.Circuit_HighEnergyFlow.get(1L, new Object() {
                        }),
                        new Object[]{OrePrefixes.circuit.get(Materials.Infinite), 2},
                },
                new FluidStack[]{
                        Materials.SolderingAlloy.getMolten(11520)
                },
                ItemList.Machine_DigitalTransformer_UHV.get(1L), 1000, 2000000);

        TT_recipeAdder
                .addResearchableAssemblylineRecipe(ItemList.Machine_DigitalTransformer_UHV.get(1L),
                        24000, 32, 100000, 4, new Object[]{
                                ItemList.WetTransformer_UIV_UEV.get(1),
                                ItemList.Cover_Screen.get(32L),
                                GT_OreDictUnificator.get(OrePrefixes.spring, Materials.Osmium, 2L),
                                ItemList.UEV_Coil.get(1L),
                                ItemList.Circuit_HighEnergyFlow.get(2L, new Object() {
                                }),
                                new Object[]{OrePrefixes.circuit.get(Materials.Bio), 2},
                        },
                        new FluidStack[]{
                                Materials.SolderingAlloy.getMolten(23040)
                        },
                        ItemList.Machine_DigitalTransformer_UEV.get(1L), 2000, 8000000);

        //UHV - UIV Energy Hatches
        TT_recipeAdder.addResearchableAssemblylineRecipe(ItemList.Hatch_Energy_UV.get(1L),
                24000, 64, 500000, 4, new Object[]{
                        ItemList.Hull_MAX.get(1L),
                        GT_OreDictUnificator.get(OrePrefixes.wireGt04, Materials.Superconductor, 2L),
                        ItemList.Circuit_Chip_QPIC.get(2L),
                        ItemList.Circuit_HighEnergyFlow.get(1L),
                        new Object[]{OrePrefixes.circuit.get(Materials.Infinite), 2},
                        ItemList.UHV_Coil.get(2L),
                        new ItemStack[]{ItemList.Reactor_Coolant_He_6.get(1),
                                ItemList.Reactor_Coolant_NaK_6.get(1), ItemList.Reactor_Coolant_Le_2.get(1)},
                        new ItemStack[]{ItemList.Reactor_Coolant_He_6.get(1),
                                ItemList.Reactor_Coolant_NaK_6.get(1), ItemList.Reactor_Coolant_Le_2.get(1)},
                        new ItemStack[]{ItemList.Reactor_Coolant_He_6.get(1),
                                ItemList.Reactor_Coolant_NaK_6.get(1), ItemList.Reactor_Coolant_Le_2.get(1)},
                        ItemList.Electric_Pump_UHV.get(1L)},
                new FluidStack[]{
                        new FluidStack(FluidRegistry.getFluid("ic2coolant"), 16000),
                        Materials.SolderingAlloy.getMolten(5760)
                },
                ItemList.Hatch_Energy_MAX.get(1), 1000, 2000000);

        TT_recipeAdder.addResearchableAssemblylineRecipe(ItemList.Hatch_Energy_MAX.get(1L),
                48000, 128, 1000000, 4, new Object[]{
                        ItemList.Hull_UEV.get(1L),
                        GT_OreDictUnificator.get(OrePrefixes.wireGt04, Materials.SuperconductorUEV, 6L),
                        ItemList.Circuit_Chip_FPIC.get(2L),
                        ItemList.Circuit_HighEnergyFlow.get(2L),
                        new Object[]{OrePrefixes.circuit.get(Materials.Bio), 2},
                        ItemList.UEV_Coil.get(2L),
                        ItemList.Reactor_Coolant_Le_2.get(1L),
                        ItemList.Reactor_Coolant_Le_2.get(1L),
                        ItemList.Reactor_Coolant_Le_2.get(1L),
                        ItemList.Electric_Pump_UEV.get(1L)},
                new FluidStack[]{
                        new FluidStack(FluidRegistry.getFluid("ic2coolant"), 32000),
                        Materials.SolderingAlloy.getMolten(11520)
                },
                ItemList.Hatch_Energy_UEV.get(1), 1200, 8000000);

        //UHV - UIV Dynamo Hatches
        TT_recipeAdder.addResearchableAssemblylineRecipe(ItemList.Hatch_Dynamo_UV.get(1L),
                24000, 64, 500000, 4, new Object[]{
                        ItemList.Hull_MAX.get(1L),
                        GT_OreDictUnificator.get(OrePrefixes.spring, Materials.Europium, 4L),
                        ItemList.Circuit_Chip_QPIC.get(2L),
                        ItemList.Circuit_HighEnergyFlow.get(1L),
                        new Object[]{OrePrefixes.circuit.get(Materials.Infinite), 2},
                        ItemList.UHV_Coil.get(2L),
                        new ItemStack[]{ItemList.Reactor_Coolant_He_6.get(1),
                                ItemList.Reactor_Coolant_NaK_6.get(1), ItemList.Reactor_Coolant_Le_2.get(1)},
                        new ItemStack[]{ItemList.Reactor_Coolant_He_6.get(1),
                                ItemList.Reactor_Coolant_NaK_6.get(1), ItemList.Reactor_Coolant_Le_2.get(1)},
                        new ItemStack[]{ItemList.Reactor_Coolant_He_6.get(1),
                                ItemList.Reactor_Coolant_NaK_6.get(1), ItemList.Reactor_Coolant_Le_2.get(1)},
                        ItemList.Electric_Pump_UHV.get(1L)},
                new FluidStack[]{
                        new FluidStack(FluidRegistry.getFluid("ic2coolant"), 16000),
                        Materials.SolderingAlloy.getMolten(5760)
                },
                ItemList.Hatch_Dynamo_MAX.get(1), 1000, 2000000);

        TT_recipeAdder.addResearchableAssemblylineRecipe(ItemList.Hatch_Dynamo_MAX.get(1L),
                48000, 128, 1000000, 4, new Object[]{
                        ItemList.Hull_UEV.get(1L),
                        GT_OreDictUnificator.get(OrePrefixes.spring, Materials.Diamericiumtitanium, 6L),
                        ItemList.Circuit_Chip_FPIC.get(2L),
                        ItemList.Circuit_HighEnergyFlow.get(2L),
                        new Object[]{OrePrefixes.circuit.get(Materials.Bio), 2},
                        ItemList.UEV_Coil.get(2L),
                        ItemList.Reactor_Coolant_Le_2.get(1L),
                        ItemList.Reactor_Coolant_Le_2.get(1L),
                        ItemList.Reactor_Coolant_Le_2.get(1L),
                        ItemList.Electric_Pump_UEV.get(1L)},
                new FluidStack[]{
                        new FluidStack(FluidRegistry.getFluid("ic2coolant"), 32000),
                        Materials.SolderingAlloy.getMolten(11520)
                },
                ItemList.Hatch_Dynamo_UEV.get(1), 1200, 8000000);

        //Stargate Stuff
        //if (Loader.isModLoaded("SGCraft")) {
        TT_recipeAdder.addResearchableAssemblylineRecipe(
                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.CosmicNeutronium, 1L),
                96000, 256, 2000000, 8, new ItemStack[]{
                        ItemList.Sensor_UV.get(16L),
                        GT_OreDictUnificator.get(OrePrefixes.block, Materials.Adamantium, 16L),
                        GT_OreDictUnificator.get(OrePrefixes.block, Materials.Osmiridium, 16L),
                        GT_OreDictUnificator.get(OrePrefixes.block, Materials.NaquadahAlloy, 64L),
                        GT_OreDictUnificator.get(OrePrefixes.block, Materials.NaquadahAlloy, 64L),
                        GT_OreDictUnificator.get(OrePrefixes.block, Materials.NaquadahAlloy, 64L)
                },
                new FluidStack[]{
                        Materials.Neutronium.getMolten(9216L),
                        Materials.Tritanium.getMolten(9216L),
                        Materials.Tetranaquadahdiindiumhexaplatiumosminid.getMolten(9216L),
                        Materials.Silver.getPlasma(9216L)
                },
                CoreItems2.getRecipe(147, 1), 1200, 2000000);

        TT_recipeAdder.addResearchableAssemblylineRecipe(CoreItems2.getRecipe(147, 1),
                96000, 256, 2000000, 8, new Object[]{
                        ItemList.Electric_Piston_UV.get(4L),
                        ItemList.Electric_Motor_UV.get(16L),
                        GT_OreDictUnificator.get(OrePrefixes.block, Materials.Adamantium, 16L),
                        GT_OreDictUnificator.get(OrePrefixes.block, Materials.NaquadahAlloy, 64L),
                        GT_OreDictUnificator.get(OrePrefixes.plateDense, Materials.DraconiumAwakened, 8L),
                        GT_OreDictUnificator.get(OrePrefixes.plateDense, Materials.DraconiumAwakened, 8L),
                        GT_OreDictUnificator.get(OrePrefixes.gemExquisite, Materials.Ruby, 16L),
                        GT_OreDictUnificator.get(OrePrefixes.gemExquisite, Materials.GarnetRed, 16L),
                        new Object[]{OrePrefixes.circuit.get(Materials.Nano), 1}
                },
                new FluidStack[]{
                        Materials.Neutronium.getMolten(9216L),
                        Materials.Tritanium.getMolten(9216L),
                        Materials.Tetranaquadahdiindiumhexaplatiumosminid.getMolten(9216L),
                        Materials.Silver.getPlasma(9216L)
                },
                CoreItems2.getRecipe(149, 1), 1200, 2000000);

        TT_recipeAdder.addResearchableAssemblylineRecipe(
                GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Neutronium, 1L),
                96000, 256, 2000000, 8, new ItemStack[]{
                        GT_OreDictUnificator.get(OrePrefixes.stickLong, Materials.Adamantium, 64L),
                        GT_OreDictUnificator.get(OrePrefixes.stickLong, Materials.NaquadahAlloy, 64L),
                        GT_OreDictUnificator.get(OrePrefixes.stickLong, Materials.CosmicNeutronium, 64L),
                        GT_OreDictUnificator.get(OrePrefixes.stickLong, Materials.Neutronium, 64L),
                        GT_OreDictUnificator.get(OrePrefixes.stickLong, Materials.Osmiridium, 64L)
                },
                new FluidStack[]{
                        Materials.Neutronium.getMolten(9216L),
                        Materials.Tritanium.getMolten(9216L),
                        Materials.Concrete.getMolten(9216L)
                },
                CoreItems2.getRecipe(148, 1), 1200, 2000000);
        //}

        //Hyper Engine
        TT_recipeAdder.addResearchableAssemblylineRecipe(
                GT_OreDictUnificator.get(OrePrefixes.pipeHuge, Materials.Naquadah, 1),
                24000, 64, 500000, 4, new Object[]{
                        GT_ItemList.Naquadah_Liquid_Enriched.get(1L),
                        ItemList.Casing_Fusion_Coil.get(8L),
                        ItemList.Electric_Pump_UV.get(12L),
                        ItemList.Field_Generator_UV.get(16L),
                        ItemList.Sensor_UV.get(16L),
                        new Object[]{OrePrefixes.circuit.get(Materials.Superconductor), 32},
                        GT_OreDictUnificator.get(OrePrefixes.wireGt08, Materials.SuperconductorUV, 32),
                        GT_OreDictUnificator.get(OrePrefixes.lens, Materials.MysteriousCrystal, 64)
                },
                new FluidStack[]{
                        Materials.SolderingAlloy.getMolten(4608),
                        Materials.Lubricant.getFluid(4000),
                        new FluidStack(FluidRegistry.getFluid("ic2coolant"), 4000),
                        Materials.Quantium.getMolten(4608)
                },
                GT_ItemList.Naquadah_multi.get(1L), 320 * 20, 500000);

        //Teleporter
        TT_recipeAdder.addResearchableAssemblylineRecipe(
                GT_ModHandler.getModItem("SGCraft", "stargateController", 1L),
                192000, 512, 2000000, 16, new Object[]{
                        ItemList.Hull_UEV.get(1),
                        GT_ModHandler.getModItem("SGCraft", "stargateBase", 1L),
                        GT_ModHandler.getModItem("SGCraft", "stargateRing", 8L),
                        GT_ModHandler.getModItem("SGCraft", "stargateRing", 4L, 1),
                        GT_ModHandler.getModItem("SGCraft", "ic2PowerUnit", 1L),
                        GT_OreDictUnificator.get(OrePrefixes.wireGt16, Materials.SuperconductorUEV, 16),
                        new Object[]{OrePrefixes.circuit.get(Materials.Nano), 8L},
                        ItemList.Sensor_UEV.get(16),
                        ItemList.Emitter_UEV.get(16),
                        ItemList.Field_Generator_UEV.get(4),
                        ItemList.Circuit_Chip_FPIC.get(64),
                        ItemList.Circuit_Chip_FPIC.get(64),
                        GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.BlackPlutonium, 64),
                        GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.BlackPlutonium, 64),
                        GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.BlackPlutonium, 64)
                },
                new FluidStack[]{
                        Materials.InfinityCatalyst.getMolten(2304L),
                        Materials.PerroxPolymer.getMolten(9216L),
                        Materials.Phoenixite.getMolten(9216L),
                        Materials.Americium.getPlasma(9216L)
                },
                ItemList.Teleporter.get(1L), 300 * 20, 8000000);

        //Debug maintenance hatch
        TT_recipeAdder.addResearchableAssemblylineRecipe(ItemList.Hatch_AutoMaintenance.get(1L),
                2764800, 128, 500000, 6, new Object[]{
                        ItemList.Hatch_AutoMaintenance.get(1L),
                        ItemList.Robot_Arm_UV.get(1L),
                        ItemList.Electric_Pump_UV.get(1L),
                        ItemList.Conveyor_Module_UV.get(1L),
                        new Object[]{OrePrefixes.circuit.get(Materials.Superconductor), 4L},
                        ItemList.Energy_LapotronicOrb2.get(1L),
                        ItemList.Duct_Tape.get(64L),
                        ItemList.Duct_Tape.get(64L),
                        GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Americium, 64L),
                }, new FluidStack[]{
                        Materials.Lubricant.getFluid(256000),
                        Materials.SolderingAlloy.getMolten(1296L),
                }, GT_ItemList.Maintenance.get(1), 6000, 500000);
    }
}
