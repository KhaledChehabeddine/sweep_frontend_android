package com.example.sweep.data.screens.account

import androidx.compose.ui.graphics.vector.ImageVector
import kotlinx.serialization.Contextual
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AccountMainCategoryItem(
    @SerialName("icon")
    val icon: @Contextual ImageVector,
    @SerialName("name")
    val name: String
)
