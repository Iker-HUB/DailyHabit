package com.iab.dailyhabit.model

data class User(
    val userId: String, // Identificador único del usuario en Firebase
    val displayName: String, // Nombre del usuario
    val avatarUrl: String = "", // URL del avatar (puedes usar un valor por defecto)
    val quote: String = "Lo difícil ya pasó", // Frase motivadora del usuario
    val profession: String = "Android Developer", // Profesión o rol
    val pendingTasks: List<String> = listOf(), // Lista de tareas pendientes, inicialmente vacía
    val completedTasks: List<String> = listOf(), // Lista de tareas completadas, inicialmente vacía
    val id: String? = null // Campo opcional para el ID del documento en Firestore
) {
    // Convierte la clase a un Map para guardarla en Firestore
    fun toMap(): Map<String, Any?> {
        return mapOf(
            "userId" to userId,
            "displayName" to displayName,
            "avatarUrl" to avatarUrl,
            "quote" to quote,
            "profession" to profession,
            "pendingTasks" to pendingTasks,
            "completedTasks" to completedTasks,
            "id" to id
        )
    }
}