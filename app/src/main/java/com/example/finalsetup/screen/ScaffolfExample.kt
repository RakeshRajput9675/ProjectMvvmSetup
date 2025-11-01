package com.example.finalsetup.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.finalsetup.NavRoute


@Preview(showSystemUi = true, showBackground = true)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScaffoldExample(navController: NavController? = null) {
    var selectedScreen by remember { mutableStateOf(NavRoute.HomeScreen.route) }

    Scaffold(
        topBar = {
            TopAppBar(
                colors = topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                navigationIcon = {
                    IconButton(onClick = {}) {
                        Icon(Icons.Default.Menu, contentDescription = "Menu")
                    }
                },
                title = {
                    Text("Top app bar")
                },

                )
        },
        bottomBar = {
            BottomAppBar(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                contentColor = MaterialTheme.colorScheme.primary
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    var selectedIndex by remember { mutableIntStateOf(0) }
                    listOf(
                        Icons.Default.Home to "Home",
                        Icons.Default.Search to "Search",
                        Icons.Default.Person to "Profile",
                        Icons.Default.Settings to "Setting"
                    ).forEachIndexed { index, (icon, label) ->
                        val isSelected = index == selectedIndex
                        Column(
                            modifier = Modifier
                                .weight(1f)
                                .clickable(
                                    interactionSource = remember { MutableInteractionSource() },
                                    indication = null,
                                ) {
                                    selectedScreen = when (label) {
                                        "Search" -> NavRoute.DetailScreen.route
                                        "Profile" -> NavRoute.ProfileScreen.route
                                        else -> ""
                                    }
                                    selectedIndex = index
                                }
                                .padding(vertical = 4.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Icon(

                                icon, contentDescription = label, modifier = Modifier,
                                tint = if (isSelected) MaterialTheme.colorScheme.primary
                                else Color.Gray
                            )
                            Text(label, fontSize = 12.sp, maxLines = 1)
                        }
                    }
                }
            }

        },

        ) { innerPadding ->
        when (selectedScreen) {
            NavRoute.HomeScreen.route -> HomeScreen(

            )

            NavRoute.DetailScreen.route -> DetailScreen(
                modifier = Modifier.padding(innerPadding)

            )
            NavRoute.ProfileScreen.route -> ProfileScreen(
                modifier = Modifier.padding(innerPadding)

            )

            else -> HomeScreen(

            )

        }
    }
}
