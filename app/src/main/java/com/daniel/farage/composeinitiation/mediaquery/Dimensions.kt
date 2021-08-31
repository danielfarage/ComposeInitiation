package com.daniel.farage.composeinitiation.mediaquery

import androidx.compose.ui.unit.Dp

sealed class Dimensions {
    object Width: Dimensions()
    object Height: Dimensions()

    sealed class DimensionOperator {
        object LessThan: DimensionOperator()
        object GreaterThan: DimensionOperator()
    }

    class DimensionComparator(
        val operator: DimensionOperator,
        private val dimension: Dimensions,
        val value: Dp
    ) {
        fun compare(screenWidth: Dp, screenHeight: Dp) : Boolean {
            return if (dimension is Width) {
                when(operator){
                    DimensionOperator.GreaterThan -> screenWidth > value
                    DimensionOperator.LessThan -> screenWidth < value
                }
            } else {
                when(operator){
                    DimensionOperator.GreaterThan -> screenHeight > value
                    DimensionOperator.LessThan -> screenHeight < value
                }
            }
        }
    }
}

infix fun Dimensions.lessThan(value: Dp) : Dimensions.DimensionComparator {
    return Dimensions.DimensionComparator(
        operator = Dimensions.DimensionOperator.LessThan,
        dimension = this,
        value = value
    )
}

infix fun Dimensions.greaterThan(value: Dp) : Dimensions.DimensionComparator {
    return Dimensions.DimensionComparator(
        operator = Dimensions.DimensionOperator.GreaterThan,
        dimension = this,
        value = value
    )
}