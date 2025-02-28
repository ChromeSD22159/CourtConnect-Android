package de.frederikkohler.courtconnect.data.repository

import io.github.jan.supabase.auth.auth
import io.github.jan.supabase.auth.user.UserInfo
import kotlinx.coroutines.runBlocking

class Repository {
    val userRepository = UserRepository()
}

class UserRepository( ) {
    fun isUserAuthenticated(): UserInfo? {
        return runBlocking {
            try {
                supabase.auth.currentUserOrNull()
            } catch (e: Exception) {
                println("Fehler beim Abrufen des Benutzerstatus: ${e.message}")
                null
            }
        }
    }
}