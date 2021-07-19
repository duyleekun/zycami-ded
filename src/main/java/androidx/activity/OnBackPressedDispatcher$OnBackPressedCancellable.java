/*
 * Decompiled with CFR 0.151.
 */
package androidx.activity;

import androidx.activity.Cancellable;
import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcher;
import java.util.ArrayDeque;

public class OnBackPressedDispatcher$OnBackPressedCancellable
implements Cancellable {
    private final OnBackPressedCallback mOnBackPressedCallback;
    public final /* synthetic */ OnBackPressedDispatcher this$0;

    public OnBackPressedDispatcher$OnBackPressedCancellable(OnBackPressedDispatcher onBackPressedDispatcher, OnBackPressedCallback onBackPressedCallback) {
        this.this$0 = onBackPressedDispatcher;
        this.mOnBackPressedCallback = onBackPressedCallback;
    }

    public void cancel() {
        ArrayDeque arrayDeque = this.this$0.mOnBackPressedCallbacks;
        OnBackPressedCallback onBackPressedCallback = this.mOnBackPressedCallback;
        arrayDeque.remove(onBackPressedCallback);
        this.mOnBackPressedCallback.removeCancellable(this);
    }
}

