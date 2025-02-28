package de.frederikkohler.courtconnect.viewModel

import androidx.lifecycle.ViewModel
import de.frederikkohler.courtconnect.data.interfaces.AuthInterface
import de.frederikkohler.courtconnect.data.interfaces.checkUserIsLogged
import de.frederikkohler.courtconnect.data.repository.Repository
import io.github.jan.supabase.auth.user.UserInfo

class SignInViewModel(
    override val repository: Repository
) : ViewModel(), AuthInterface {
    override var user: UserInfo? = null

    init {
        checkUserIsLogged()
    }
}