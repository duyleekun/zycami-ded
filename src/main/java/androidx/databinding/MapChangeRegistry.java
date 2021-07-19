/*
 * Decompiled with CFR 0.151.
 */
package androidx.databinding;

import androidx.databinding.CallbackRegistry;
import androidx.databinding.CallbackRegistry$NotifierCallback;
import androidx.databinding.MapChangeRegistry$1;
import androidx.databinding.ObservableMap;

public class MapChangeRegistry
extends CallbackRegistry {
    private static CallbackRegistry$NotifierCallback NOTIFIER_CALLBACK;

    static {
        MapChangeRegistry$1 mapChangeRegistry$1 = new MapChangeRegistry$1();
        NOTIFIER_CALLBACK = mapChangeRegistry$1;
    }

    public MapChangeRegistry() {
        CallbackRegistry$NotifierCallback callbackRegistry$NotifierCallback = NOTIFIER_CALLBACK;
        super(callbackRegistry$NotifierCallback);
    }

    public void notifyChange(ObservableMap observableMap, Object object) {
        this.notifyCallbacks(observableMap, 0, object);
    }
}

