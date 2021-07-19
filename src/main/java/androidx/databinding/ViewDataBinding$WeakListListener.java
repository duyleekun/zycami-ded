/*
 * Decompiled with CFR 0.151.
 */
package androidx.databinding;

import androidx.databinding.ObservableList;
import androidx.databinding.ObservableList$OnListChangedCallback;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding$ObservableReference;
import androidx.databinding.ViewDataBinding$WeakListener;
import androidx.lifecycle.LifecycleOwner;

public class ViewDataBinding$WeakListListener
extends ObservableList$OnListChangedCallback
implements ViewDataBinding$ObservableReference {
    public final ViewDataBinding$WeakListener mListener;

    public ViewDataBinding$WeakListListener(ViewDataBinding viewDataBinding, int n10) {
        ViewDataBinding$WeakListener viewDataBinding$WeakListener;
        this.mListener = viewDataBinding$WeakListener = new ViewDataBinding$WeakListener(viewDataBinding, n10, this);
    }

    public void addListener(ObservableList observableList) {
        observableList.addOnListChangedCallback(this);
    }

    public ViewDataBinding$WeakListener getListener() {
        return this.mListener;
    }

    public void onChanged(ObservableList observableList) {
        ViewDataBinding viewDataBinding = this.mListener.getBinder();
        if (viewDataBinding == null) {
            return;
        }
        ObservableList observableList2 = (ObservableList)this.mListener.getTarget();
        if (observableList2 != observableList) {
            return;
        }
        int n10 = this.mListener.mLocalFieldId;
        ViewDataBinding.access$800(viewDataBinding, n10, observableList2, 0);
    }

    public void onItemRangeChanged(ObservableList observableList, int n10, int n11) {
        this.onChanged(observableList);
    }

    public void onItemRangeInserted(ObservableList observableList, int n10, int n11) {
        this.onChanged(observableList);
    }

    public void onItemRangeMoved(ObservableList observableList, int n10, int n11, int n12) {
        this.onChanged(observableList);
    }

    public void onItemRangeRemoved(ObservableList observableList, int n10, int n11) {
        this.onChanged(observableList);
    }

    public void removeListener(ObservableList observableList) {
        observableList.removeOnListChangedCallback(this);
    }

    public void setLifecycleOwner(LifecycleOwner lifecycleOwner) {
    }
}

