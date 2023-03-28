package com.example.sweep.data.screens.account

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ContactSupport
import androidx.compose.material.icons.outlined.CreditCard
import androidx.compose.material.icons.outlined.Language
import androidx.compose.material.icons.outlined.ManageAccounts
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AccountMainCategory(
    @SerialName("category")
    val mainCategoryItems: List<AccountMainCategoryItem>
)

val accountMainCategory = AccountMainCategory(
    mainCategoryItems = listOf(
        AccountMainCategoryItem(
            icon = Icons.Outlined.Language,
            name = "Language"
        ),
        AccountMainCategoryItem(
            icon = Icons.Outlined.CreditCard,
            name = "Payments"
        ),
        AccountMainCategoryItem(
            icon = Icons.Outlined.ManageAccounts,
            name = "Profile"
        ),
        AccountMainCategoryItem(
            icon = Icons.Outlined.ContactSupport,
            name = "Support"
        )
    )
)
