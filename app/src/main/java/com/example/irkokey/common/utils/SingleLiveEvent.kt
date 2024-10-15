package com.example.irkokey.common.utils

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import java.util.concurrent.atomic.AtomicBoolean

class SingleLiveEvent<T> : MutableLiveData<T>() {

    private val pending = AtomicBoolean(false)

    override fun observe(owner: LifecycleOwner, observer: Observer<in T>){
        // Observe the internal MutableLiveData
        super.observe(owner) {
            if(pending.compareAndSet(true, false)){
                observer.onChanged(it)
            }
        }
    }

    override fun setValue(t:  T?){
        pending.set(true)
        super.setValue(t)
    }

    // Used for cases where T is Void, to make calls cleaner
    fun call(){
        value = null
    }
}