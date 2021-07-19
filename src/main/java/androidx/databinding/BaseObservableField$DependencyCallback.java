/*
 * Decompiled with CFR 0.151.
 */
package androidx.databinding;

import androidx.databinding.BaseObservableField;
import androidx.databinding.Observable;
import androidx.databinding.Observable$OnPropertyChangedCallback;

public class BaseObservableField$DependencyCallback
extends Observable$OnPropertyChangedCallback {
    public final /* synthetic */ BaseObservableField this$0;

    public BaseObservableField$DependencyCallback(BaseObservableField baseObservableField) {
        this.this$0 = baseObservableField;
    }

    public void onPropertyChanged(Observable observable, int n10) {
        this.this$0.notifyChange();
    }
}

