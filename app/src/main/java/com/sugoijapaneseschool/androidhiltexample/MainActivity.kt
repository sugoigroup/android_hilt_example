package com.sugoijapaneseschool.androidhiltexample

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.sugoijapaneseschool.androidhiltexample.myservices.CalcMe
import com.sugoijapaneseschool.androidhiltexample.myservices.DeleteRepoAction
import com.sugoijapaneseschool.androidhiltexample.myservices.SaveRepoAction
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var calcme: CalcMe

    @Inject
    lateinit var myapp: MainApplication // MainApplication 을 리턴타입으로 하는 프로바이더 자동 삽입

    var resultCode: Int = 0
        @Inject set // Int 을 리턴타입으로 하는 프로바이더 자동 삽입

    @Inject @SaveRepoAction
    lateinit var saveRepo: String // Int 을 리턴타입으로 하는 프로바이더 자동 삽입

    @Inject @DeleteRepoAction
    lateinit var deleteRepo: String // Int 을 리턴타입으로 하는 프로바이더 자동 삽입

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        Log.e("Test", calcme.sumMe(1, 2).toString())

        Log.v("Test", "my app: ${myapp}")
        Log.v("Test", "result Code: ${resultCode}")
        Log.v("Test", "deleteRepo result: ${deleteRepo}")
        Log.v("Test", "saveRepo result: ${saveRepo}")

    }
}