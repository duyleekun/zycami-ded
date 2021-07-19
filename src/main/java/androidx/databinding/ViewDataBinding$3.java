/*
 * Decompiled with CFR 0.151.
 */
package androidx.databinding;

import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding$CreateWeakListener;
import androidx.databinding.ViewDataBinding$WeakListener;
import androidx.databinding.ViewDataBinding$WeakMapListener;

public final class ViewDataBinding$3
implements ViewDataBinding$CreateWeakListener {
    public ViewDataBinding$WeakListener create(ViewDataBinding viewDataBinding, int n10) {
        ViewDataBinding$WeakMapListener viewDataBinding$WeakMapListener = new ViewDataBinding$WeakMapListener(viewDataBinding, n10);
        return viewDataBinding$WeakMapListener.getListener();
    }
}

