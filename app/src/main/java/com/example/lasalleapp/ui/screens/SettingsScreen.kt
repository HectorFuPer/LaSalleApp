package com.example.lasalleapp.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavController
import com.example.lasalleapp.R
import com.example.lasalleapp.models.Alumno
import com.example.lasalleapp.utils.Screens
import java.time.format.DateTimeFormatter

@Composable
fun SettingsScreen(alumno: Alumno, innerPadding: PaddingValues, navController: NavController) {
    val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")
    val fechaNacFormatted = alumno.fechaNac.format(formatter)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)
            .background(MaterialTheme.colorScheme.background)
    ) {
        Text(
            text = "Información del Alumno",
            fontSize = 35.sp,
            lineHeight = 40.sp,
            color = MaterialTheme.colorScheme.onBackground,
            modifier = Modifier.padding(16.dp)
        )

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .clip(RoundedCornerShape(16.dp))
                .background(MaterialTheme.colorScheme.primary)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.foto_alumno),
                    contentDescription = "Foto del alumno",
                    modifier = Modifier
                        .size(120.dp)
                        .clip(RoundedCornerShape(60.dp))
                        .aspectRatio(1f)
                        .fillMaxWidth(),
                    contentScale = ContentScale.Crop
                )

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = alumno.nombre,
                    color = MaterialTheme.colorScheme.onPrimary
                )

                Text(
                    text = fechaNacFormatted,
                    color = MaterialTheme.colorScheme.onPrimary
                )

                Text(
                    text = alumno.carrera,
                    color = MaterialTheme.colorScheme.onPrimary
                )

                Text(
                    text = alumno.correo,
                    color = MaterialTheme.colorScheme.onPrimary
                )
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .background(Color.White)
                    .padding(8.dp)
                    .clickable {
                        navController.navigate(Screens.ChangePassword.route)
                    }
            ) {
                Text(text = "Cambiar Contraseña",
                    fontWeight = FontWeight.Bold)
            }

            Spacer(modifier = Modifier.width(16.dp))

            Box(
                modifier = Modifier
                    .background(Color.White)
                    .padding(8.dp)
                    .clickable {
                        navController.navigate(Screens.ChangeTheme.route)
                    }
            ) {
                Text(text = "Cambiar Tema App",
                    fontWeight = FontWeight.Bold)
            }
        }
    }
}
