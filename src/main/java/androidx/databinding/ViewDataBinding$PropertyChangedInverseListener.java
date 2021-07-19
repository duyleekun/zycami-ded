/*
 * Decompiled with CFR 0.151.
 */
package androidx.databinding;

import androidx.databinding.InverseBindingListener;
import androidx.databinding.Observable;
import androidx.databinding.Observable$OnPropertyChangedCallback;

public abstract class ViewDataBinding$PropertyChangedInverseListener
extends Observable$OnPropertyChangedCallback
implements InverseBindingListener {
    public final int mPropertyId;

    public ViewDataBinding$PropertyChangedInverseListener(int n10) {
        this.mPropertyId = n10;
    }

    public void onPropertyChanged(Observable observable, int n10) {
        int n11 = this.mPropertyId;
        if (n10 == n11 || n10 == 0) {
            this.onChange();
        }
    }
}

