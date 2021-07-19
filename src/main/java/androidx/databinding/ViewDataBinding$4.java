/*
 * Decompiled with CFR 0.151.
 */
package androidx.databinding;

import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding$CreateWeakListener;
import androidx.databinding.ViewDataBinding$LiveDataListener;
import androidx.databinding.ViewDataBinding$WeakListener;

public final class ViewDataBinding$4
implements ViewDataBinding$CreateWeakListener {
    public ViewDataBinding$WeakListener create(ViewDataBinding viewDataBinding, int n10) {
        ViewDataBinding$LiveDataListener viewDataBinding$LiveDataListener = new ViewDataBinding$LiveDataListener(viewDataBinding, n10);
        return viewDataBinding$LiveDataListener.getListener();
    }
}

