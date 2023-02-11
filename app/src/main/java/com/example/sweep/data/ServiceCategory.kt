package com.example.sweep.data

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.*
import androidx.compose.ui.graphics.vector.ImageVector

data class ServiceCategory(
    val icon: ImageVector,
    val name: String
)

val serviceCategories = listOf(
    ServiceCategory(
        icon = Icons.Outlined.Countertops,
        name = "Keeper"
    ),
    ServiceCategory(
        icon = Icons.Outlined.SupervisorAccount,
        name = "Caregiver"
    ),
    ServiceCategory(
        icon = Icons.Outlined.LocalDining,
        name = "Cook"
    ),
    ServiceCategory(
        icon = Icons.Outlined.Lightbulb,
        name = "Electrician"
    ),
    ServiceCategory(
        icon = Icons.Outlined.Grass,
        name = "Gardener"
    ),
    ServiceCategory(
        icon = Icons.Outlined.Construction,
        name = "Mechanic"
    ),
    ServiceCategory(
        icon = Icons.Outlined.PestControl,
        name = "Pest Control"
    ),
    ServiceCategory(
        icon = Icons.Outlined.Plumbing,
        name = "Plumber"
    )
)