package de.frederikkohler.courtconnect.data.interfaces

import de.frederikkohler.courtconnect.data.repository.Repository
import io.github.jan.supabase.auth.user.UserInfo
import kotlinx.coroutines.runBlocking

interface AuthInterface {
    val repository: Repository
    var user: UserInfo?
}

fun AuthInterface.checkUserIsLogged() {
    return runBlocking {
        try {
            user = repository.userRepository.isUserAuthenticated()
        } catch (e: Exception) {
            println("Fehler beim Abrufen des Benutzerstatus: ${e.message}")
        }
    }
}