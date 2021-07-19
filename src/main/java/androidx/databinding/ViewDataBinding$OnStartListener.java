/*
 * Decompiled with CFR 0.151.
 */
package androidx.databinding;

import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding$1;
import androidx.lifecycle.LifecycleObserver;
import java.lang.ref.WeakReference;

public class ViewDataBinding$OnStartListener
implements LifecycleObserver {
    public final WeakReference mBinding;

    private ViewDataBinding$OnStartListener(ViewDataBinding viewDataBinding) {
        WeakReference<ViewDataBinding> weakReference;
        this.mBinding = weakReference = new WeakReference<ViewDataBinding>(viewDataBinding);
    }

    public /* synthetic */ ViewDataBinding$OnStartListener(ViewDataBinding viewDataBinding, ViewDataBinding$1 viewDataBinding$1) {
        this(viewDataBinding);
    }

    public void onStart() {
        ViewDataBinding viewDataBinding = (ViewDataBinding)this.mBinding.get();
        if (viewDataBinding != null) {
            viewDataBinding.executePendingBindings();
        }
    }
}

