/*
 * Decompiled with CFR 0.151.
 */
package androidx.databinding;

import androidx.databinding.CallbackRegistry$NotifierCallback;
import androidx.databinding.ObservableMap;
import androidx.databinding.ObservableMap$OnMapChangedCallback;

public final class MapChangeRegistry$1
extends CallbackRegistry$NotifierCallback {
    public void onNotifyCallback(ObservableMap$OnMapChangedCallback observableMap$OnMapChangedCallback, ObservableMap observableMap, int n10, Object object) {
        observableMap$OnMapChangedCallback.onMapChanged(observableMap, object);
    }
}

