/*
 * Decompiled with CFR 0.151.
 */
package androidx.databinding;

import androidx.databinding.CallbackRegistry$NotifierCallback;
import androidx.databinding.Observable;
import androidx.databinding.Observable$OnPropertyChangedCallback;

public final class PropertyChangeRegistry$1
extends CallbackRegistry$NotifierCallback {
    public void onNotifyCallback(Observable$OnPropertyChangedCallback observable$OnPropertyChangedCallback, Observable observable, int n10, Void void_) {
        observable$OnPropertyChangedCallback.onPropertyChanged(observable, n10);
    }
}

