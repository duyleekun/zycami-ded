/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  android.view.View$OnAttachStateChangeListener
 */
package androidx.databinding;

import android.os.Build;
import android.view.View;
import androidx.databinding.ViewDataBinding;

public class ViewDataBinding$7
implements Runnable {
    public final /* synthetic */ ViewDataBinding this$0;

    public ViewDataBinding$7(ViewDataBinding viewDataBinding) {
        this.this$0 = viewDataBinding;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void run() {
        View.OnAttachStateChangeListener onAttachStateChangeListener;
        int n10;
        ViewDataBinding viewDataBinding;
        synchronized (this) {
            viewDataBinding = this.this$0;
            n10 = 0;
            onAttachStateChangeListener = null;
            ViewDataBinding.access$202(viewDataBinding, false);
        }
        ViewDataBinding.access$300();
        int n11 = Build.VERSION.SDK_INT;
        n10 = 19;
        if (n11 >= n10 && (n11 = (int)((viewDataBinding = ViewDataBinding.access$400(this.this$0)).isAttachedToWindow() ? 1 : 0)) == 0) {
            viewDataBinding = ViewDataBinding.access$400(this.this$0);
            onAttachStateChangeListener = ViewDataBinding.access$500();
            viewDataBinding.removeOnAttachStateChangeListener(onAttachStateChangeListener);
            viewDataBinding = ViewDataBinding.access$400(this.this$0);
            onAttachStateChangeListener = ViewDataBinding.access$500();
            viewDataBinding.addOnAttachStateChangeListener(onAttachStateChangeListener);
            return;
        }
        this.this$0.executePendingBindings();
    }
}

