package com.example.lasalleapp.models

data class Materia(
    val nombre: String,
    val primerP: Float = 0f,
    val segundoP: Float = 0f,
    val tercerP: Float = 0f
) {
    val promedio: Float
        get() = (primerP * 0.2f) + (segundoP * 0.2f) + (tercerP * 0.6f)

    companion object {
        val materias = listOf(
            Materia(
                nombre = "Programación Orientada a Objetos",
                primerP = 85.67f,
                segundoP = 78.79f,
                tercerP = 0f,
            ),
            Materia(
                nombre = "Estructuras de Datos",
                primerP = 75.40f,
                segundoP = 68.31f,
                tercerP = 82.98f
            ),
            Materia(
                nombre = "Sistemas Operativos",
                primerP = 88.00f,
                segundoP = 91.27f,
                tercerP = 86.88f
            ),
            Materia(
                nombre = "Bases de Datos",
                primerP = 90.64f,
                segundoP = 87.33f,
                tercerP = 93.44f
            ),
            Materia(
                nombre = "Ingeniería de Software",
                primerP = 80.14f,
                segundoP = 85.20f,
                tercerP = 88.50f
            ),
            Materia(
                nombre = "Algoritmos",
                primerP = 83.50f,
                segundoP = 76.30f,
                tercerP = 81.00f
            ),
            Materia(
                nombre = "Redes de Computadoras",
                primerP = 86.25f,
                segundoP = 88.75f,
                tercerP = 84.50f
            )
        )
    }
}
