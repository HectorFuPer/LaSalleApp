package com.example.lasalleapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lasalleapp.components.MateriaCard
import com.example.lasalleapp.models.Alumno
import com.example.lasalleapp.models.Materia
import com.example.lasalleapp.ui.components.GradesModal

@Composable
fun GradesScreen(alumno: Alumno, innerPadding: PaddingValues) {
    var selectedMateria by remember { mutableStateOf<Materia?>(null) }
    var showSemestresDialog by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)
            .background(MaterialTheme.colorScheme.background)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .clip(RoundedCornerShape(16.dp))
                .background(MaterialTheme.colorScheme.primary.copy(alpha = 0.1f))
                .padding(16.dp)
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = alumno.nombre,
                    style = MaterialTheme.typography.headlineLarge.copy(fontSize = 28.sp, fontWeight = FontWeight.Bold),
                    color = MaterialTheme.colorScheme.primary
                )

                Text(
                    text = alumno.carrera,
                    style = MaterialTheme.typography.bodyLarge.copy(fontSize = 20.sp, fontWeight = FontWeight.Light),
                    color = MaterialTheme.colorScheme.onBackground,
                    modifier = Modifier.padding(top = 8.dp, bottom = 16.dp)
                )
            }
        }

        // Lista de Materias (LazyColumn)
        LazyColumn(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
                .padding(horizontal = 24.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            item {
                // Título de las Materias
                Text(
                    text = "Materias ${alumno.semestre}:",
                    style = MaterialTheme.typography.titleLarge.copy(fontSize = 24.sp, fontWeight = FontWeight.SemiBold),
                    color = MaterialTheme.colorScheme.onBackground,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
            }

            items(alumno.materias) { materia ->
                // MateriaCard con onClick para mostrar el modal
                MateriaCard(materia = materia, onClick = { selectedMateria = materia })
            }
        }

        // Botón de Semestres Anteriores
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .clip(RoundedCornerShape(12.dp))
                .background(Color.Gray.copy(alpha = 0.2f))  // Fondo gris claro
                .clickable { showSemestresDialog = true },
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Revisar semestres anteriores",
                style = MaterialTheme.typography.bodyLarge.copy(fontSize = 18.sp, fontWeight = FontWeight.Medium),
                color = MaterialTheme.colorScheme.primary
            )
        }

        // Mostrar el modal cuando se selecciona una materia
        selectedMateria?.let { materia ->
            GradesModal(materia = materia, onDismiss = { selectedMateria = null })
        }

        // Modal de Semestres Anteriores
        if (showSemestresDialog) {
            AlertDialog(
                onDismissRequest = { showSemestresDialog = false },
                title = {
                    Text(
                        text = "Semestres Anteriores",
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = androidx.compose.ui.text.style.TextAlign.Center,
                        style = MaterialTheme.typography.titleLarge.copy(fontSize = 22.sp, fontWeight = FontWeight.Bold)
                    )
                },
                text = {
                    LazyColumn(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(200.dp)
                            .background(Color(0xFFE0E0E0)),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        items((1..8).toList()) { semestre ->
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(horizontal = 16.dp)
                                    .clip(RoundedCornerShape(12.dp))
                                    .background(MaterialTheme.colorScheme.primary)
                                    .padding(vertical = 16.dp),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = "$semestre° Semestre",
                                    style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Medium),
                                    color = MaterialTheme.colorScheme.onPrimary
                                )
                            }
                        }
                    }
                },
                confirmButton = {
                    Button(onClick = { showSemestresDialog = false }) {
                        Text("Cerrar")
                    }
                }
            )
        }
    }
}
