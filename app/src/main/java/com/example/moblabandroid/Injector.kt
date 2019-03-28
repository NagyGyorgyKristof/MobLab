package com.example.moblabandroid

import android.app.Activity
import android.support.v4.app.Fragment

val Activity.injector: ApplicationComponent
    get() {
        return (this.applicationContext as Application).injector
    }

val Fragment.injector: ApplicationComponent
    get() {
        return (this.context!!.applicationContext as Application).injector
    }