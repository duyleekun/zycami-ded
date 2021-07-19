/*
 * Decompiled with CFR 0.151.
 */
package androidx.databinding;

import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding$ObservableReference;
import androidx.lifecycle.LifecycleOwner;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

public class ViewDataBinding$WeakListener
extends WeakReference {
    public final int mLocalFieldId;
    private final ViewDataBinding$ObservableReference mObservable;
    private Object mTarget;

    public ViewDataBinding$WeakListener(ViewDataBinding viewDataBinding, int n10, ViewDataBinding$ObservableReference viewDataBinding$ObservableReference) {
        ReferenceQueue referenceQueue = ViewDataBinding.access$700();
        super(viewDataBinding, referenceQueue);
        this.mLocalFieldId = n10;
        this.mObservable = viewDataBinding$ObservableReference;
    }

    public ViewDataBinding getBinder() {
        ViewDataBinding viewDataBinding = (ViewDataBinding)this.get();
        if (viewDataBinding == null) {
            this.unregister();
        }
        return viewDataBinding;
    }

    public Object getTarget() {
        return this.mTarget;
    }

    public void setLifecycleOwner(LifecycleOwner lifecycleOwner) {
        this.mObservable.setLifecycleOwner(lifecycleOwner);
    }

    public void setTarget(Object object) {
        this.unregister();
        this.mTarget = object;
        if (object != null) {
            ViewDataBinding$ObservableReference viewDataBinding$ObservableReference = this.mObservable;
            viewDataBinding$ObservableReference.addListener(object);
        }
    }

    public boolean unregister() {
        boolean bl2;
        Object object = this.mTarget;
        if (object != null) {
            ViewDataBinding$ObservableReference viewDataBinding$ObservableReference = this.mObservable;
            viewDataBinding$ObservableReference.removeListener(object);
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        this.mTarget = null;
        return bl2;
    }
}

