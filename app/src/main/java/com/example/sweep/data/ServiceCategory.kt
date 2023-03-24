package com.example.sweep.data

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.*
import androidx.compose.ui.graphics.vector.ImageVector

data class ServiceCategory(
    val active: Boolean,
    val icon: ImageVector,
    val name: String
)

val serviceCategories = listOf(
    ServiceCategory(
        active = true,
        icon = Icons.Outlined.Countertops,
        name = "Keeper"
    ),
    ServiceCategory(
        active = false,
        icon = Icons.Outlined.SupervisorAccount,
        name = "Caregiver"
    ),
    ServiceCategory(
        active = false,
        icon = Icons.Outlined.LocalDining,
        name = "Cook"
    ),
    ServiceCategory(
        active = false,
        icon = Icons.Outlined.Lightbulb,
        name = "Electrician"
    ),
    ServiceCategory(
        active = false,
        icon = Icons.Outlined.Grass,
        name = "Gardener"
    ),
    ServiceCategory(
        active = false,
        icon = Icons.Outlined.Construction,
        name = "Mechanic"
    ),
    ServiceCategory(
        active = false,
        icon = Icons.Outlined.PestControl,
        name = "Pest Control"
    ),
    ServiceCategory(
        active = false,
        icon = Icons.Outlined.Plumbing,
        name = "Plumber"
    )
)
