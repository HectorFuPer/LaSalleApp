package com.example.lasalleapp.ui.screens

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.example.lasalleapp.ui.theme.LaSalleAppTheme
import com.example.lasalleapp.R
import com.example.lasalleapp.ui.components.CardImage
import com.example.lasalleapp.ui.components.Widget
import com.example.lasalleapp.utils.*

@Composable
fun HomeScreen( innerPadding: PaddingValues, navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)
            .background(MaterialTheme.colorScheme.background)
            .verticalScroll(rememberScrollState())
    ) {
        //header
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(shape = RoundedCornerShape(bottomStart = 40.dp, bottomEnd = 40.dp))
                .height(270.dp)
                .background(MaterialTheme.colorScheme.primary)

        ) {
            Image(
                painter = painterResource(id = R.drawable.background_1),
                contentDescription = "background",
                modifier = Modifier.fillMaxWidth().offset(y = 80.dp),
            )
            Row (
                modifier = Modifier.padding(15.dp),
                verticalAlignment = Alignment.CenterVertically
            ){
                //Logo
                Image(
                    painter = painterResource(id = R.drawable.sallebajio_09),
                    contentDescription = "logo",
                    modifier = Modifier.size(70.dp)
                )

                //User
                Column (
                    modifier = Modifier.padding(start = 10.dp).weight(1f)
                ){
                    Text(text = stringResource(id = R.string.welcome_text), color = MaterialTheme.colorScheme.onPrimary, fontSize = 18.sp)
                    Text(text = "Héctor Fuentes", color = Color.White, fontSize = 22.sp, fontWeight = FontWeight.W900)
                }

                //Icon
                Icon(
                    imageVector = Logout,
                    contentDescription = "logout",
                    modifier = Modifier.size(30.dp),
                    tint = MaterialTheme.colorScheme.onPrimary
                )
            }

        }

        //Caja con widgets
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .offset(y = (-50).dp)
                .padding(horizontal = 24.dp)
                .clip(shape = RoundedCornerShape(16.dp))
                .background(MaterialTheme.colorScheme.onPrimary)
                .height(140.dp),
            contentAlignment = Alignment.Center
        ){
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Absolute.SpaceEvenly
            ) {
                Widget(icon = Icons.Default.DateRange, title = "Sin eventos", navController = navController, route = Screens.Calendar.route)
                Widget(icon = Task, title = "2 tareas", navController = navController, route = Screens.Calendar.route)
                Widget(icon = Cash, title = "Pagos", navController = navController, route = Screens.Payments.route)
            }
        }

        //Body
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
                .padding(10.dp)
        ) {
            Column {
                Text(
                    text = stringResource(id = R.string.news),
                    style = MaterialTheme.typography.titleLarge
                )

                //Carrusel

                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    items(newsList){news ->
                        CardImage(news = news){
                            Log.i("News", it.id.toString())
                        }
                    }
                }

                //Titulo Comunidad
                Text(
                    text = stringResource(id = R.string.news),
                    style = MaterialTheme.typography.titleLarge
                )

                //Grid de comunidad
                LazyVerticalGrid(
                    columns = GridCells.Fixed(2),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(500.dp)
                ){
                    items(communities){ community ->
                        Box(modifier = Modifier
                            .size(180.dp)
                            .padding(16.dp)
                        ){
                            AsyncImage(
                                model = community.image,
                                contentDescription = "community",
                                modifier = Modifier.fillMaxSize()
                            )
                        }
                    }
                }
            }
        }
    }
}
@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun HomeScreenPreview() {
    LaSalleAppTheme{
        HomeScreen(innerPadding = PaddingValues(0.dp), navController = rememberNavController())
    }
}