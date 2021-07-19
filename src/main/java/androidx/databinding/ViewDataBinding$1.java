/*
 * Decompiled with CFR 0.151.
 */
package androidx.databinding;

import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding$CreateWeakListener;
import androidx.databinding.ViewDataBinding$WeakListener;
import androidx.databinding.ViewDataBinding$WeakPropertyListener;

public final class ViewDataBinding$1
implements ViewDataBinding$CreateWeakListener {
    public ViewDataBinding$WeakListener create(ViewDataBinding viewDataBinding, int n10) {
        ViewDataBinding$WeakPropertyListener viewDataBinding$WeakPropertyListener = new ViewDataBinding$WeakPropertyListener(viewDataBinding, n10);
        return viewDataBinding$WeakPropertyListener.getListener();
    }
}

