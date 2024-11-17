package com.example.irkokey.common.utils

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import java.util.concurrent.atomic.AtomicBoolean
/**
 * A lifecycle-aware observable that sends only new updates after subscription, used for events like navigation and Snackbar messages.
 * This avoids a common problem with events: on configuration change (like rotation) an update can be emitted if the observer is active.
 * This LiveData only calls the observable if there's an explicit call to setValue() or call().
 *
 * @param <T> The type of data hold by this instance
 */
class SingleLiveEvent<T> : MutableLiveData<T>() {

    // Used for main thread synchronization
    private val pending = AtomicBoolean(false)

    /**
     * Adds the given observer to the observers list within the lifespan of the given owner.
     * The events are dispatched on the main thread. If the pending flag is true, the observer is notified.
     *
     * @param owner The LifecycleOwner which controls the observer
     * @param observer The observer that will receive the events
     */
    override fun observe(owner: LifecycleOwner, observer: Observer<in T>){
        // Observe the internal MutableLiveData
        super.observe(owner) {
            if(pending.compareAndSet(true, false)){
                observer.onChanged(it)
            }
        }
    }

    /**
     * Sets the value. If there are active observers, the value will be dispatched to them.
     * Also sets the pending flag to true.
     *
     * @param t The new value
     */
    override fun setValue(t:  T?){
        pending.set(true)
        super.setValue(t)
    }

    /**
     * Used for cases where T is Void, to make calls cleaner.
     * Sets the value to null.
     */
    fun call(){
        value = null
    }
}