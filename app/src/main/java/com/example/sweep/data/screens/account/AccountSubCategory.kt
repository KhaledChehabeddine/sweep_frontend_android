package com.example.sweep.data.screens.account

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccountBalanceWallet
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.ConfirmationNumber
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.HelpOutline
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.material.icons.outlined.NorthEast
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.Policy
import androidx.compose.material.icons.outlined.Settings
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AccountSubCategory(
    @SerialName("category")
    val category: String,
    @SerialName("sub_category_items")
    val accountSubCategoryItems: List<AccountSubCategoryItem>
)

val accountDetailsCategory = AccountSubCategory(
    category = "Account Details",
    accountSubCategoryItems = listOf(
        AccountSubCategoryItem(
            icon = Icons.Outlined.LocationOn,
            name = "Addresses"
        ),
        AccountSubCategoryItem(
            icon = Icons.Outlined.FavoriteBorder,
            name = "Favorites"
        ),
        AccountSubCategoryItem(
            icon = Icons.Outlined.Notifications,
            name = "Notifications"
        ),
        AccountSubCategoryItem(
            icon = Icons.Outlined.Settings,
            name = "Preferences"
        )
    )
)

val financesCategories = AccountSubCategory(
    category = "Finances",
    accountSubCategoryItems = listOf(
        AccountSubCategoryItem(
            icon = Icons.Outlined.Add,
            name = "Add Funds"
        ),
        AccountSubCategoryItem(
            icon = Icons.Outlined.NorthEast,
            name = "Send Funds"
        ),
        AccountSubCategoryItem(
            icon = Icons.Outlined.AccountBalanceWallet,
            name = "Wallet"
        )
    )
)

val helpCenterCategories = AccountSubCategory(
    category = "Help Center",
    accountSubCategoryItems = listOf(
        AccountSubCategoryItem(
            icon = Icons.Outlined.HelpOutline,
            name = "FAQ"
        ),
        AccountSubCategoryItem(
            icon = Icons.Outlined.Policy,
            name = "Legal"
        ),
        AccountSubCategoryItem(
            icon = Icons.Outlined.ConfirmationNumber,
            name = "Support Tickets"
        )
    )
)

val accountSubCategories = listOf(
    accountDetailsCategory,
    financesCategories,
    helpCenterCategories
)
