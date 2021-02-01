package com.sugoijapaneseschool.androidhiltexample.myservices

import javax.inject.Inject

class CalcMe @Inject constructor() {
    fun sumMe(num1:Int, num2:Int) : Int {
        return num1 + num2
    }

}
