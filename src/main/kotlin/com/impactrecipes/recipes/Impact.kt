package com.impactrecipes.recipes

import com.impact.common.item.DrillHeads
import com.impactrecipes.util.get
import com.impactrecipes.util.toEuPercent
import gregtech.api.enums.GT_Values.RA
import gregtech.api.enums.Materials
import gregtech.api.enums.OrePrefixes
import gregtech.api.util.GT_Utility
import net.minecraft.item.ItemStack

object Impact {

    fun run() {
        minerDrills()
    }

    private fun minerDrills() {
        val circuit3 = GT_Utility.getIntegratedCircuit(3)

        val materials = arrayOf(
            Materials.Iron, Materials.Steel, Materials.StainlessSteel, Materials.Titanium,
            Materials.TungstenSteel, Materials.Inconel690, Materials.Iridium, Materials.Neutronium,
        )

        materials.forEachIndexed { index, material ->
            val drill = DrillHeads.create(ItemStack(DrillHeads.getInstance(), 1, index))
            val prefixPlate = (if (material == Materials.Steel || material == Materials.Iron) OrePrefixes.plateDouble else OrePrefixes.plateDense)
            RA.addAssemblerRecipe(
                arrayOf(
                    material.get(prefixPlate, 3),
                    material.get(OrePrefixes.frameGt),
                    circuit3,
                ),
                null, drill, 20 * 10, 25.toEuPercent(index + 1)
            )
        }
    }
}