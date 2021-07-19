/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnAttachStateChangeListener
 */
package androidx.databinding;

import android.view.View;
import androidx.databinding.ViewDataBinding;

public final class ViewDataBinding$6
implements View.OnAttachStateChangeListener {
    public void onViewAttachedToWindow(View view) {
        ViewDataBinding.access$100(ViewDataBinding.getBinding(view)).run();
        view.removeOnAttachStateChangeListener((View.OnAttachStateChangeListener)this);
    }

    public void onViewDetachedFromWindow(View view) {
    }
}

