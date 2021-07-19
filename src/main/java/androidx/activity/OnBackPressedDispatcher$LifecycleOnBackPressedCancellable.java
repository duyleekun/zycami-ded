/*
 * Decompiled with CFR 0.151.
 */
package androidx.activity;

import androidx.activity.Cancellable;
import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcher;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.Lifecycle$Event;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;

public class OnBackPressedDispatcher$LifecycleOnBackPressedCancellable
implements LifecycleEventObserver,
Cancellable {
    private Cancellable mCurrentCancellable;
    private final Lifecycle mLifecycle;
    private final OnBackPressedCallback mOnBackPressedCallback;
    public final /* synthetic */ OnBackPressedDispatcher this$0;

    public OnBackPressedDispatcher$LifecycleOnBackPressedCancellable(OnBackPressedDispatcher onBackPressedDispatcher, Lifecycle lifecycle, OnBackPressedCallback onBackPressedCallback) {
        this.this$0 = onBackPressedDispatcher;
        this.mLifecycle = lifecycle;
        this.mOnBackPressedCallback = onBackPressedCallback;
        lifecycle.addObserver(this);
    }

    public void cancel() {
        this.mLifecycle.removeObserver(this);
        this.mOnBackPressedCallback.removeCancellable(this);
        Cancellable cancellable = this.mCurrentCancellable;
        if (cancellable != null) {
            cancellable.cancel();
            cancellable = null;
            this.mCurrentCancellable = null;
        }
    }

    public void onStateChanged(LifecycleOwner object, Lifecycle$Event object2) {
        object = Lifecycle$Event.ON_START;
        if (object2 == object) {
            object = this.this$0;
            object2 = this.mOnBackPressedCallback;
            object = ((OnBackPressedDispatcher)object).addCancellableCallback((OnBackPressedCallback)object2);
            this.mCurrentCancellable = object;
        } else {
            object = Lifecycle$Event.ON_STOP;
            if (object2 == object) {
                object = this.mCurrentCancellable;
                if (object != null) {
                    object.cancel();
                }
            } else {
                object = Lifecycle$Event.ON_DESTROY;
                if (object2 == object) {
                    this.cancel();
                }
            }
        }
    }
}

