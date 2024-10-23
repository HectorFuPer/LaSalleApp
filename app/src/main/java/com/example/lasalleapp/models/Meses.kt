package com.example.lasalleapp.models

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector

data class Meses(
    val nombre: String,
    val icono: ImageVector,
    val descripcion: String,
    val colorIcono: Color
) {
    companion object {
        val mesesPredefinidos = listOf(
            Meses(
                nombre = "Enero",
                icono = Icons.Default.Check,
                descripcion = "Mes Enero ya pagado.",
                colorIcono = Color.Green
            ),
            Meses(
                nombre = "Febrero",
                icono = Icons.Default.Check,
                descripcion = "Mes Febrero ya pagado.",
                colorIcono = Color.Green
            ),
            Meses(
                nombre = "Marzo",
                icono = Icons.Default.Check,
                descripcion = "Mes Marzo ya pagado.",
                colorIcono = Color.Green
            ),
            Meses(
                nombre = "Abril",
                icono = Icons.Default.Check,
                descripcion = "Mes Abril ya pagado.",
                colorIcono = Color.Green
            ),
            Meses(
                nombre = "Mayo",
                icono = Icons.Default.Close,
                descripcion = "Mes Mayo sin pagar.",
                colorIcono = Color.Red
            ),
            Meses(
                nombre = "Junio",
                icono = Icons.Default.Close,
                descripcion = "Mes Junio sin pagar.",
                colorIcono = Color.Red
            )
        )
    }
}
