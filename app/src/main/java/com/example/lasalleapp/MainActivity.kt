package com.example.lasalleapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.lasalleapp.models.Alumno
import com.example.lasalleapp.models.BottomNavigationItem
import com.example.lasalleapp.screens.GradesScreen
import com.example.lasalleapp.ui.screens.*
import com.example.lasalleapp.ui.theme.LaSalleAppTheme
import com.example.lasalleapp.utils.Screens
import com.exyte.animatednavbar.AnimatedNavigationBar
import com.exyte.animatednavbar.animation.indendshape.shapeCornerRadius
import kotlinx.coroutines.selects.select

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            var selectedItem by rememberSaveable {
                mutableIntStateOf(0)
            }
            LaSalleAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize(),
                    bottomBar = {
                        AnimatedNavigationBar(
                            selectedIndex = selectedItem,
                            modifier = Modifier.height(90.dp),
                            barColor = MaterialTheme.colorScheme.primary,
                            cornerRadius = shapeCornerRadius(34.dp)

                        ){
                            BottomNavigationItem.items.forEachIndexed { index, bottomNavigationItem ->
                                Column(
                                    modifier = Modifier.fillMaxSize().clickable {
                                        selectedItem = index
                                        navController.navigate(bottomNavigationItem.route)
                                    },
                                    horizontalAlignment = Alignment.CenterHorizontally,
                                    verticalArrangement = Arrangement.Center
                                ) {
                                    Icon(
                                        imageVector = bottomNavigationItem.icon,
                                        contentDescription = bottomNavigationItem.title,
                                        tint = if(selectedItem == index)MaterialTheme.colorScheme.onPrimary
                                                else MaterialTheme.colorScheme.onPrimary.copy(alpha = .5f),
                                        modifier = Modifier.size(26.dp)
                                    )
                                    Text(bottomNavigationItem.title,
                                        style = MaterialTheme.typography.bodySmall,
                                        color = if(selectedItem == index)MaterialTheme.colorScheme.onPrimary
                                                    else MaterialTheme.colorScheme.onPrimary.copy(alpha = .5f))
                                }
                            }
                        }
                    }
                ) { innerPadding ->
                    NavHost(navController = navController, startDestination = Screens.Home.route) {
                        composable(route = Screens.Home.route) {
                            HomeScreen(innerPadding = innerPadding, navController = navController)
                        }
                        composable(route = Screens.Grades.route) {
                            GradesScreen(alumno = Alumno.listaAlumnos[0], innerPadding = innerPadding)
                        }
                        composable(route = Screens.Calendar.route) {
                            CalendarScreen(innerPadding = innerPadding)
                        }
                        composable(route = Screens.Settings.route) {
                            SettingsScreen(alumno = Alumno.listaAlumnos[0], innerPadding = innerPadding, navController = navController)
                        }
                        composable(route = Screens.NewsDetail.route) {
                            NewsDetailScreen(innerPadding = innerPadding)
                        }
                        composable(route= Screens.Payments.route) {
                            PaymentsScreen(innerPadding = innerPadding)
                        }
                        composable(route = Screens.ChangePassword.route ) {
                            PasswordScreen(innerPadding = innerPadding)
                        }
                        composable(route = Screens.ChangeTheme.route ) {
                            ThemeScreen(innerPadding = innerPadding)
                        }

                    }
                }
            }
        }
    }
}