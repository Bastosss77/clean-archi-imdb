package org.jazzilla.cleanarchitectuteimdb.presentation.extension

import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer

fun <T> Fragment.observe(liveData: LiveData<T>, on: LifecycleOwner = this, body: (T) -> Unit) {
    liveData.observe(on, Observer {
        body(it)
    })
}