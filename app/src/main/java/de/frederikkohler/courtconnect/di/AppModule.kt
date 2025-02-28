package de.frederikkohler.courtconnect.di

import de.frederikkohler.courtconnect.data.repository.Repository
import de.frederikkohler.courtconnect.viewModel.SignInViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val myModule = module {
    singleOf(::Repository) { bind<Repository>() }

    viewModel { SignInViewModel(get()) }
}