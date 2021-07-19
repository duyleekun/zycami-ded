/*
 * Decompiled with CFR 0.151.
 */
package androidx.databinding;

import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding$ObservableReference;
import androidx.databinding.ViewDataBinding$WeakListener;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;

public class ViewDataBinding$LiveDataListener
implements Observer,
ViewDataBinding$ObservableReference {
    public LifecycleOwner mLifecycleOwner;
    public final ViewDataBinding$WeakListener mListener;

    public ViewDataBinding$LiveDataListener(ViewDataBinding viewDataBinding, int n10) {
        ViewDataBinding$WeakListener viewDataBinding$WeakListener;
        this.mListener = viewDataBinding$WeakListener = new ViewDataBinding$WeakListener(viewDataBinding, n10, this);
    }

    public void addListener(LiveData liveData) {
        LifecycleOwner lifecycleOwner = this.mLifecycleOwner;
        if (lifecycleOwner != null) {
            liveData.observe(lifecycleOwner, this);
        }
    }

    public ViewDataBinding$WeakListener getListener() {
        return this.mListener;
    }

    public void onChanged(Object object) {
        object = this.mListener.getBinder();
        if (object != null) {
            Object object2 = this.mListener;
            int n10 = ((ViewDataBinding$WeakListener)object2).mLocalFieldId;
            object2 = ((ViewDataBinding$WeakListener)object2).getTarget();
            ViewDataBinding.access$800((ViewDataBinding)object, n10, object2, 0);
        }
    }

    public void removeListener(LiveData liveData) {
        liveData.removeObserver(this);
    }

    public void setLifecycleOwner(LifecycleOwner lifecycleOwner) {
        LiveData liveData = (LiveData)this.mListener.getTarget();
        if (liveData != null) {
            LifecycleOwner lifecycleOwner2 = this.mLifecycleOwner;
            if (lifecycleOwner2 != null) {
                liveData.removeObserver(this);
            }
            if (lifecycleOwner != null) {
                liveData.observe(lifecycleOwner, this);
            }
        }
        this.mLifecycleOwner = lifecycleOwner;
    }
}

