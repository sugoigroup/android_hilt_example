package com.sugoijapaneseschool.androidhiltexample.myservices

import android.content.Context
import com.sugoijapaneseschool.androidhiltexample.MainApplication
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module // Module은 클래스에 정의
@InstallIn(ApplicationComponent::class) //Application 의 라이프사이클에 맞추어 동작한다는 의미
/*
아래처럼 미리정의된 것중 어떤 component를 지정하느냐에 따라서 현재 모듈의 생성주기가 바뀐다.
지정은 @InstallIn 으로 한다.
ApplicationComponent	        : Application
ActivityRetainedComponent	    : Application
ActivityComponent	            : Application, Activity
FragmentComponent	            : Application, Activity, Fragment
ViewComponent	                : Application, Activity, View
ViewWithFragmentComponent	    : Application, Activity, Fragment, View
ServiceComponent	            : Application, Service

 */
class MyHiltModule {

    @Singleton
    @Provides
    // 리턴 타입이 MainApplication 이라면 이게 실행됨.
    fun provideMeApplication(@ApplicationContext app: Context): MainApplication  {
        // send data to server then receive results
        return app as MainApplication
    }

    @Singleton
    @Provides
    // 리턴 타입이 Int형이라면 이게 실행
    fun sendAndBringApiService(): Int {
        // send data to server then receive results
        return 200
    }

    @Singleton
    @Provides
    // 리턴 타입이 String 이라면 이게 실행
    fun saveToRepository(): String = "Saved"
}
