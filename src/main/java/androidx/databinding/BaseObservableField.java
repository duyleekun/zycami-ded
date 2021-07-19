/*
 * Decompiled with CFR 0.151.
 */
package androidx.databinding;

import androidx.databinding.BaseObservable;
import androidx.databinding.BaseObservableField$DependencyCallback;
import androidx.databinding.Observable;

public abstract class BaseObservableField
extends BaseObservable {
    public BaseObservableField() {
    }

    public BaseObservableField(Observable ... observableArray) {
        int n10;
        if (observableArray != null && (n10 = observableArray.length) != 0) {
            int n11;
            BaseObservableField$DependencyCallback baseObservableField$DependencyCallback = new BaseObservableField$DependencyCallback(this);
            for (int i10 = 0; i10 < (n11 = observableArray.length); ++i10) {
                Observable observable = observableArray[i10];
                observable.addOnPropertyChangedCallback(baseObservableField$DependencyCallback);
            }
        }
    }
}

