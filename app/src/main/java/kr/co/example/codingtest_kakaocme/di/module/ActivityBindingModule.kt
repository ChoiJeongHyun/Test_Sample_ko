package kr.co.example.codingtest_kakaocme.di.module

import dagger.Module
import dagger.android.ContributesAndroidInjector
import kr.co.example.codingtest_kakaocme.di.ActivityScope
import kr.co.example.codingtest_kakaocme.views.MainActivity

@Module
abstract class ActivityBindingModule {

    @ActivityScope
    @ContributesAndroidInjector
    abstract fun mainActivity(): MainActivity

}