package com.example.irkokey.common.utils;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * A lifecycle-aware observable that sends only new updates after subscription, used for events like navigation and Snackbar messages.
 * This avoids a common problem with events: on configuration change (like rotation) an update can be emitted if the observer is active.
 * This LiveData only calls the observable if there's an explicit call to setValue() or call().
 *
 * @param <T> The type of data hold by this instance
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0006\u0010\u0006\u001a\u00020\u0007J \u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\u000e\u0010\u000b\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00000\fH\u0016J\u0017\u0010\r\u001a\u00020\u00072\b\u0010\u000e\u001a\u0004\u0018\u00018\u0000H\u0016\u00a2\u0006\u0002\u0010\u000fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"Lcom/example/irkokey/common/utils/SingleLiveEvent;", "T", "Landroidx/lifecycle/MutableLiveData;", "()V", "pending", "Ljava/util/concurrent/atomic/AtomicBoolean;", "call", "", "observe", "owner", "Landroidx/lifecycle/LifecycleOwner;", "observer", "Landroidx/lifecycle/Observer;", "setValue", "t", "(Ljava/lang/Object;)V", "app_debug"})
public final class SingleLiveEvent<T extends java.lang.Object> extends androidx.lifecycle.MutableLiveData<T> {
    @org.jetbrains.annotations.NotNull
    private final java.util.concurrent.atomic.AtomicBoolean pending = null;
    
    public SingleLiveEvent() {
        super(null);
    }
    
    /**
     * Adds the given observer to the observers list within the lifespan of the given owner.
     * The events are dispatched on the main thread. If the pending flag is true, the observer is notified.
     *
     * @param owner The LifecycleOwner which controls the observer
     * @param observer The observer that will receive the events
     */
    @java.lang.Override
    public void observe(@org.jetbrains.annotations.NotNull
    androidx.lifecycle.LifecycleOwner owner, @org.jetbrains.annotations.NotNull
    androidx.lifecycle.Observer<? super T> observer) {
    }
    
    /**
     * Sets the value. If there are active observers, the value will be dispatched to them.
     * Also sets the pending flag to true.
     *
     * @param t The new value
     */
    @java.lang.Override
    public void setValue(@org.jetbrains.annotations.Nullable
    T t) {
    }
    
    /**
     * Used for cases where T is Void, to make calls cleaner.
     * Sets the value to null.
     */
    public final void call() {
    }
}