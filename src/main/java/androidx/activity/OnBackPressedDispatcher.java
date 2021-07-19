/*
 * Decompiled with CFR 0.151.
 */
package androidx.activity;

import androidx.activity.Cancellable;
import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcher$LifecycleOnBackPressedCancellable;
import androidx.activity.OnBackPressedDispatcher$OnBackPressedCancellable;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.Lifecycle$State;
import androidx.lifecycle.LifecycleOwner;
import java.util.ArrayDeque;
import java.util.Iterator;

public final class OnBackPressedDispatcher {
    private final Runnable mFallbackOnBackPressed;
    public final ArrayDeque mOnBackPressedCallbacks;

    public OnBackPressedDispatcher() {
        this(null);
    }

    public OnBackPressedDispatcher(Runnable runnable) {
        ArrayDeque arrayDeque;
        this.mOnBackPressedCallbacks = arrayDeque = new ArrayDeque();
        this.mFallbackOnBackPressed = runnable;
    }

    public void addCallback(OnBackPressedCallback onBackPressedCallback) {
        this.addCancellableCallback(onBackPressedCallback);
    }

    public void addCallback(LifecycleOwner object, OnBackPressedCallback onBackPressedCallback) {
        Lifecycle$State lifecycle$State;
        Object object2 = ((Lifecycle)(object = object.getLifecycle())).getCurrentState();
        if (object2 == (lifecycle$State = Lifecycle$State.DESTROYED)) {
            return;
        }
        object2 = new OnBackPressedDispatcher$LifecycleOnBackPressedCancellable(this, (Lifecycle)object, onBackPressedCallback);
        onBackPressedCallback.addCancellable((Cancellable)object2);
    }

    public Cancellable addCancellableCallback(OnBackPressedCallback onBackPressedCallback) {
        this.mOnBackPressedCallbacks.add(onBackPressedCallback);
        OnBackPressedDispatcher$OnBackPressedCancellable onBackPressedDispatcher$OnBackPressedCancellable = new OnBackPressedDispatcher$OnBackPressedCancellable(this, onBackPressedCallback);
        onBackPressedCallback.addCancellable(onBackPressedDispatcher$OnBackPressedCancellable);
        return onBackPressedDispatcher$OnBackPressedCancellable;
    }

    public boolean hasEnabledCallbacks() {
        boolean bl2;
        Iterator iterator2 = this.mOnBackPressedCallbacks.descendingIterator();
        while (bl2 = iterator2.hasNext()) {
            OnBackPressedCallback onBackPressedCallback = (OnBackPressedCallback)iterator2.next();
            bl2 = onBackPressedCallback.isEnabled();
            if (!bl2) continue;
            return true;
        }
        return false;
    }

    public void onBackPressed() {
        boolean bl2;
        Object object = this.mOnBackPressedCallbacks.descendingIterator();
        while (bl2 = object.hasNext()) {
            OnBackPressedCallback onBackPressedCallback = (OnBackPressedCallback)object.next();
            boolean bl3 = onBackPressedCallback.isEnabled();
            if (!bl3) continue;
            onBackPressedCallback.handleOnBackPressed();
            return;
        }
        object = this.mFallbackOnBackPressed;
        if (object != null) {
            object.run();
        }
    }
}

