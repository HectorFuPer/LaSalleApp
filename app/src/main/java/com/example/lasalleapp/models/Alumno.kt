package com.example.lasalleapp.models

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDate

data class Alumno(
    val nombre: String,
    val fechaNac: LocalDate,
    val edad: Int,
    val correo: String,
    val carrera: String,
    val semestre: String,
    val materias: List<Materia> = listOf()
) {
    companion object {
        val listaAlumnos = listOf(
            Alumno(
                nombre = "Héctor E. Fuentes Pérez",
                fechaNac = LocalDate.of(2003, 11, 7),
                correo = "hfp77904@lasallebajio.edu.mx",
                edad = 20,
                carrera = "Ingeniería en Software",
                semestre = "5to Semestre",
                materias = Materia.materias
            )
        )
    }
}
