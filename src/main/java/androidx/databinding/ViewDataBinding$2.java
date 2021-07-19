/*
 * Decompiled with CFR 0.151.
 */
package androidx.databinding;

import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding$CreateWeakListener;
import androidx.databinding.ViewDataBinding$WeakListListener;
import androidx.databinding.ViewDataBinding$WeakListener;

public final class ViewDataBinding$2
implements ViewDataBinding$CreateWeakListener {
    public ViewDataBinding$WeakListener create(ViewDataBinding viewDataBinding, int n10) {
        ViewDataBinding$WeakListListener viewDataBinding$WeakListListener = new ViewDataBinding$WeakListListener(viewDataBinding, n10);
        return viewDataBinding$WeakListListener.getListener();
    }
}

