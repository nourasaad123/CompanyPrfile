package com.example.profile.navigation


import android.graphics.drawable.Icon
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.profile.R
import com.example.profile.ui.theme.basicColor
import kotlinx.coroutines.launch

@Preview(showBackground = true)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DrawerNavigation() {
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    val items = listOf(
        NavigationItem(
            title = "Home",
            route = "",
            selectedIcon = R.drawable.baseline_home_24,
            unSelectedIcon = R.drawable.baseline_home_24,

            ),
        NavigationItem(
            title = "Profile",
            route = "",
            selectedIcon =R.drawable.baseline_person_24,
            unSelectedIcon =R.drawable.baseline_person_24
        ),
        NavigationItem(
            title = "Notification",
            route = "",
            selectedIcon = R.drawable.baseline_notifications_active_24,
            unSelectedIcon = R.drawable.baseline_notifications_none_24
        ),
        NavigationItem(
            title = "Favourite",
            route = "",
            selectedIcon = R.drawable.baseline_favorite_24,
            unSelectedIcon = R.drawable.baseline_favorite_border_24,
        ),
        NavigationItem(
            title = "Sign in",
            route = "",
            selectedIcon = R.drawable.login,
            unSelectedIcon = R.drawable.login

        ),
        NavigationItem(
            title = "Settings",
            route = "",
            selectedIcon = R.drawable.baseline_settings_24,
            unSelectedIcon = R.drawable.baseline_settings_24

        ),
        NavigationItem(
            title = "About App",
            route = "",
            selectedIcon =R.drawable.baseline_info_24,
            unSelectedIcon = R.drawable.baseline_info_24,


            ),
        NavigationItem(
            title = "Arabic",
            route = "",
            selectedIcon = R.drawable.baseline_translate_24,
            unSelectedIcon = R.drawable.baseline_translate_24

        )
    )
    val selectedItem = remember { mutableStateOf(items[0]) }

        ModalNavigationDrawer(
            drawerState = drawerState,
            drawerContent = {
                ModalDrawerSheet(drawerContainerColor = basicColor) {
                    NavBarHeader()
                    Spacer(Modifier.height(12.dp))
                    //  NavBarBody(items = items, currentRoute = Screens.profile.route) {

                    // }
                    items.forEach { item ->
                        NavigationDrawerItem(
                            icon = {
Icon(painter= painterResource(id = item.selectedIcon),contentDescription = null)
                            },
                            label = { Text(item.title, color = Color.White, fontSize = 24.sp) },
                            selected = item == selectedItem.value,
                            onClick = {
                                scope.launch { drawerState.close() }
                                selectedItem.value = item
                            },
                            modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding),

                            colors = NavigationDrawerItemDefaults.colors(
                                selectedContainerColor = basicColor,
                                unselectedContainerColor = basicColor
                            )
                        )


                    }

                }


            },


            content = {

                TopAppBar(
                    title = {
                        Box(
                            modifier = Modifier.fillMaxWidth(),
                            contentAlignment = Alignment.Center
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.log2),
                                contentDescription = ""
                            )
                        }


                    },
                    Modifier.padding(10.dp),
                    navigationIcon = {
                        IconButton(onClick = { /*TODO */ }) {
                            Icon(
                                painter = painterResource(id = R.drawable.baseline_search_24),
                                contentDescription = "search"
                            )
                        }
                    },
                    actions = {
                        IconButton(onClick = {
                            scope.launch { drawerState.open() }
                        })
                        {
                            Icon(
                                painter = painterResource(id = R.drawable.baseline_menu_24),
                                contentDescription = ""

                            )
                        }
                    }, colors = TopAppBarDefaults.smallTopAppBarColors(
                        containerColor = Color.White
                    )
                )

            }
        )

    }

