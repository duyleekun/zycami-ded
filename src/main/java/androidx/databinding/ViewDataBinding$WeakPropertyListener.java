/*
 * Decompiled with CFR 0.151.
 */
package androidx.databinding;

import androidx.databinding.Observable;
import androidx.databinding.Observable$OnPropertyChangedCallback;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding$ObservableReference;
import androidx.databinding.ViewDataBinding$WeakListener;
import androidx.lifecycle.LifecycleOwner;

public class ViewDataBinding$WeakPropertyListener
extends Observable$OnPropertyChangedCallback
implements ViewDataBinding$ObservableReference {
    public final ViewDataBinding$WeakListener mListener;

    public ViewDataBinding$WeakPropertyListener(ViewDataBinding viewDataBinding, int n10) {
        ViewDataBinding$WeakListener viewDataBinding$WeakListener;
        this.mListener = viewDataBinding$WeakListener = new ViewDataBinding$WeakListener(viewDataBinding, n10, this);
    }

    public void addListener(Observable observable) {
        observable.addOnPropertyChangedCallback(this);
    }

    public ViewDataBinding$WeakListener getListener() {
        return this.mListener;
    }

    public void onPropertyChanged(Observable observable, int n10) {
        ViewDataBinding viewDataBinding = this.mListener.getBinder();
        if (viewDataBinding == null) {
            return;
        }
        Observable observable2 = (Observable)this.mListener.getTarget();
        if (observable2 != observable) {
            return;
        }
        int n11 = this.mListener.mLocalFieldId;
        ViewDataBinding.access$800(viewDataBinding, n11, observable, n10);
    }

    public void removeListener(Observable observable) {
        observable.removeOnPropertyChangedCallback(this);
    }

    public void setLifecycleOwner(LifecycleOwner lifecycleOwner) {
    }
}

