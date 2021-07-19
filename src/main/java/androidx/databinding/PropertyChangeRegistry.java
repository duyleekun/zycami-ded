/*
 * Decompiled with CFR 0.151.
 */
package androidx.databinding;

import androidx.databinding.CallbackRegistry;
import androidx.databinding.CallbackRegistry$NotifierCallback;
import androidx.databinding.Observable;
import androidx.databinding.PropertyChangeRegistry$1;

public class PropertyChangeRegistry
extends CallbackRegistry {
    private static final CallbackRegistry$NotifierCallback NOTIFIER_CALLBACK;

    static {
        PropertyChangeRegistry$1 propertyChangeRegistry$1 = new PropertyChangeRegistry$1();
        NOTIFIER_CALLBACK = propertyChangeRegistry$1;
    }

    public PropertyChangeRegistry() {
        CallbackRegistry$NotifierCallback callbackRegistry$NotifierCallback = NOTIFIER_CALLBACK;
        super(callbackRegistry$NotifierCallback);
    }

    public void notifyChange(Observable observable, int n10) {
        this.notifyCallbacks(observable, n10, null);
    }
}

