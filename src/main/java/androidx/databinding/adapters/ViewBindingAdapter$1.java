/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnAttachStateChangeListener
 */
package androidx.databinding.adapters;

import android.view.View;
import androidx.databinding.adapters.ViewBindingAdapter$OnViewAttachedToWindow;
import androidx.databinding.adapters.ViewBindingAdapter$OnViewDetachedFromWindow;

public final class ViewBindingAdapter$1
implements View.OnAttachStateChangeListener {
    public final /* synthetic */ ViewBindingAdapter$OnViewAttachedToWindow val$attach;
    public final /* synthetic */ ViewBindingAdapter$OnViewDetachedFromWindow val$detach;

    public ViewBindingAdapter$1(ViewBindingAdapter$OnViewAttachedToWindow onViewAttachedToWindow, ViewBindingAdapter$OnViewDetachedFromWindow onViewDetachedFromWindow) {
        this.val$attach = onViewAttachedToWindow;
        this.val$detach = onViewDetachedFromWindow;
    }

    public void onViewAttachedToWindow(View view) {
        ViewBindingAdapter$OnViewAttachedToWindow viewBindingAdapter$OnViewAttachedToWindow = this.val$attach;
        if (viewBindingAdapter$OnViewAttachedToWindow != null) {
            viewBindingAdapter$OnViewAttachedToWindow.onViewAttachedToWindow(view);
        }
    }

    public void onViewDetachedFromWindow(View view) {
        ViewBindingAdapter$OnViewDetachedFromWindow viewBindingAdapter$OnViewDetachedFromWindow = this.val$detach;
        if (viewBindingAdapter$OnViewDetachedFromWindow != null) {
            viewBindingAdapter$OnViewDetachedFromWindow.onViewDetachedFromWindow(view);
        }
    }
}

