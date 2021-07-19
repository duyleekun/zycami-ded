/*
 * Decompiled with CFR 0.151.
 */
package androidx.databinding;

import androidx.databinding.ObservableMap;
import androidx.databinding.ObservableMap$OnMapChangedCallback;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding$ObservableReference;
import androidx.databinding.ViewDataBinding$WeakListener;
import androidx.lifecycle.LifecycleOwner;

public class ViewDataBinding$WeakMapListener
extends ObservableMap$OnMapChangedCallback
implements ViewDataBinding$ObservableReference {
    public final ViewDataBinding$WeakListener mListener;

    public ViewDataBinding$WeakMapListener(ViewDataBinding viewDataBinding, int n10) {
        ViewDataBinding$WeakListener viewDataBinding$WeakListener;
        this.mListener = viewDataBinding$WeakListener = new ViewDataBinding$WeakListener(viewDataBinding, n10, this);
    }

    public void addListener(ObservableMap observableMap) {
        observableMap.addOnMapChangedCallback(this);
    }

    public ViewDataBinding$WeakListener getListener() {
        return this.mListener;
    }

    public void onMapChanged(ObservableMap observableMap, Object object) {
        Object object2;
        object = this.mListener.getBinder();
        if (object != null && observableMap == (object2 = this.mListener.getTarget())) {
            object2 = this.mListener;
            int n10 = ((ViewDataBinding$WeakListener)object2).mLocalFieldId;
            ViewDataBinding.access$800((ViewDataBinding)object, n10, observableMap, 0);
        }
    }

    public void removeListener(ObservableMap observableMap) {
        observableMap.removeOnMapChangedCallback(this);
    }

    public void setLifecycleOwner(LifecycleOwner lifecycleOwner) {
    }
}

