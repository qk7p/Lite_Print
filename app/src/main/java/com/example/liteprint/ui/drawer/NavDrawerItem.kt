package com.example.liteprint.ui.drawer

import com.example.liteprint.R

sealed class NavDrawerItem (var route: String, var icon: Int, var title: String) {
    object Nesting: NavDrawerItem("nesting", R.drawable.ic_nest, "Nesting")
    object Databse: NavDrawerItem("database", R.drawable.ic_database, "Database")
}
