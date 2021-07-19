/*
 * Decompiled with CFR 0.151.
 */
package androidx.databinding;

import androidx.databinding.ViewDataBinding;

public abstract class OnRebindCallback {
    public void onBound(ViewDataBinding viewDataBinding) {
    }

    public void onCanceled(ViewDataBinding viewDataBinding) {
    }

    public boolean onPreBind(ViewDataBinding viewDataBinding) {
        return true;
    }
}

