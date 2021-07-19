/*
 * Decompiled with CFR 0.151.
 */
package androidx.databinding;

import androidx.databinding.CallbackRegistry$NotifierCallback;
import androidx.databinding.OnRebindCallback;
import androidx.databinding.ViewDataBinding;

public final class ViewDataBinding$5
extends CallbackRegistry$NotifierCallback {
    public void onNotifyCallback(OnRebindCallback onRebindCallback, ViewDataBinding viewDataBinding, int n10, Void void_) {
        int n11 = 1;
        if (n10 != n11) {
            n11 = 2;
            if (n10 != n11) {
                n11 = 3;
                if (n10 == n11) {
                    onRebindCallback.onBound(viewDataBinding);
                }
            } else {
                onRebindCallback.onCanceled(viewDataBinding);
            }
        } else {
            boolean bl2 = onRebindCallback.onPreBind(viewDataBinding);
            if (!bl2) {
                ViewDataBinding.access$002(viewDataBinding, n11 != 0);
            }
        }
    }
}

