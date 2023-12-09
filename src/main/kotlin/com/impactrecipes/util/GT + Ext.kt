package com.impactrecipes.util

import gregtech.api.enums.GT_Values
import gregtech.api.enums.Materials
import gregtech.api.enums.OrePrefixes
import gregtech.api.util.GT_OreDictUnificator
import net.minecraft.item.ItemStack

fun Materials.get(prefixes: OrePrefixes, amount: Int = 1): ItemStack {
    return GT_OreDictUnificator.get(prefixes, this, amount.toLong())
}

fun Int.toEuPercent(tier: Int): Int {
    val tierEu = GT_Values.V[tier].toInt()
    return (tierEu - tierEu / 100.0 * this).toInt()
}