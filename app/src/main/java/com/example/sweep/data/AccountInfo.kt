package com.example.sweep.data

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.*
import androidx.compose.ui.graphics.vector.ImageVector

data class MainCategory(
    val icon: ImageVector,
    val name: String
)

data class SubCategory(
    val icon: ImageVector,
    val isLast: Boolean,
    val name: String
)

val accountCategories = listOf(
    MainCategory(
        icon = Icons.Outlined.Language,
        name = "Language"
    ),
    MainCategory(
        icon = Icons.Outlined.CreditCard,
        name = "Payments"
    ),
    MainCategory(
        icon = Icons.Outlined.ManageAccounts,
        name = "Profile"
    ),
    MainCategory(
        icon = Icons.Outlined.ContactSupport,
        name = "Support"
    )
)

val accountDetailsCategories = listOf(
    SubCategory(
        icon = Icons.Outlined.LocationOn,
        isLast = false,
        name = "Addresses"
    ),
    SubCategory(
        icon = Icons.Outlined.FavoriteBorder,
        isLast = false,
        name = "Favorites"
    ),
    SubCategory(
        icon = Icons.Outlined.Notifications,
        isLast = false,
        name = "Notifications"
    ),
    SubCategory(
        icon = Icons.Outlined.Settings,
        isLast = true,
        name = "Preferences"
    )
)

val financesCategories = listOf(
    SubCategory(
        icon = Icons.Outlined.Add,
        isLast = false,
        name = "Add Funds"
    ),
    SubCategory(
        icon = Icons.Outlined.NorthEast,
        isLast = false,
        name = "Send Funds"
    ),
    SubCategory(
        icon = Icons.Outlined.AccountBalanceWallet,
        isLast = true,
        name = "Wallet"
    )
)

val helpCenterCategories = listOf(
    SubCategory(
        icon = Icons.Outlined.HelpOutline,
        isLast = false,
        name = "FAQ"
    ),
    SubCategory(
        icon = Icons.Outlined.Policy,
        isLast = false,
        name = "Legal"
    ),
    SubCategory(
        icon = Icons.Outlined.ConfirmationNumber,
        isLast = true,
        name = "Support Tickets"
    )
)
