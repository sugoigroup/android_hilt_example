package com.sugoijapaneseschool.androidhiltexample.myservices

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Inject
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
abstract class MyHiltAbs{ //추상클래스를 모듈로 선언
    @Singleton
    @Binds  //PowerInterfaceImpl 을 powerImpl에 Inject하고, PowerInterface형식을 선언하는 곳에 구현제를 바인드 해준다.
    abstract fun bindMyComputer(powerImpl: PowerInterfaceImpl): PowerInterface
}

interface PowerInterface {
    fun getPower(): String
}

class PowerInterfaceImpl @Inject constructor(): PowerInterface {
    override fun getPower(): String {
        return "Low Power(<220)"
    }
}

// Binds에 의해 자동으로 powerImpl 변수는  PowerInterfaceImpl 구현체에 바인드 되어 진다.
class MyComputer @Inject constructor(private val powerImpl: PowerInterface) {
    fun powerStart(): String {
        return "${powerImpl.getPower()}" //구현체의 getPower가 실행된다.
    }
}
