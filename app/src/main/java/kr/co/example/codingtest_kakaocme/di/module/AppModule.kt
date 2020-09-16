package kr.co.example.codingtest_kakaocme.di.module

import android.app.Application
import dagger.Module
import dagger.Provides
import kr.co.example.codingtest_kakaocme.api.ApiManager
import kr.co.example.codingtest_kakaocme.di.ApplicationContext
import kr.co.example.codingtest_kakaocme.repository.AppRepository
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    @Singleton
    @ApplicationContext
    fun provideContext(application: Application) = application

    @Provides
    @Singleton
    fun provideAppRepository(apiManager: ApiManager) = AppRepository(apiManager)

    @Provides
    @Singleton
    fun provideApiManager() = ApiManager()

}