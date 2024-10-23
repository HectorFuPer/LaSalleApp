package com.example.lasalleapp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lasalleapp.models.Materia

@Composable
fun GradesModal(materia: Materia, onDismiss: () -> Unit) {
    val promedioRedondeado = String.format("%.2f", materia.promedio)
    val promedioColor = if (materia.promedio < 60) Color.Red else Color.Green

    AlertDialog(
        onDismissRequest = { onDismiss() },
        title = null,  // Quitamos el título del AlertDialog para personalizar el diseño
        text = {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFFBDBDBD), shape = RoundedCornerShape(16.dp))  // Fondo gris y esquinas redondeadas
                    .padding(16.dp),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    // Título en negritas y centrado
                    Text(
                        text = materia.nombre,
                        textAlign = androidx.compose.ui.text.style.TextAlign.Center,
                        fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.bodyLarge.copy(fontSize = 24.sp),
                        modifier = Modifier.padding(bottom = 16.dp)
                    )

                    // Caja interna para mostrar las calificaciones
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)  // Añadimos padding para evitar que el texto esté pegado a los bordes
                    ) {
                        // Parciales con texto más grande
                        Text(
                            text = "1° Parcial: ${materia.primerP}",
                            fontSize = 20.sp
                        )
                        Text(
                            text = "2° Parcial: ${materia.segundoP}",
                            fontSize = 20.sp
                        )
                        Text(
                            text = "3° Parcial: ${materia.tercerP}",
                            fontSize = 20.sp
                        )

                        Spacer(modifier = Modifier.height(16.dp))

                        // Promedio final con el color solo en el número
                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "Promedio Final: ",
                                fontSize = 20.sp
                            )
                            Text(
                                text = promedioRedondeado,
                                fontSize = 20.sp,
                                color = promedioColor
                            )
                        }
                    }
                }
            }
        },
        confirmButton = {
            Button(onClick = { onDismiss() }) {
                Text("Cerrar")
            }
        },
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFFBDBDBD), shape = RoundedCornerShape(16.dp)) // Fondo gris del modal completo con esquinas redondeadas
    )
}
