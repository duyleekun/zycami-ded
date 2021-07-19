/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnAttachStateChangeListener
 */
package androidx.fragment.app;

import android.view.View;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.FragmentStateManager;

public class FragmentStateManager$1
implements View.OnAttachStateChangeListener {
    public final /* synthetic */ FragmentStateManager this$0;
    public final /* synthetic */ View val$fragmentView;

    public FragmentStateManager$1(FragmentStateManager fragmentStateManager, View view) {
        this.this$0 = fragmentStateManager;
        this.val$fragmentView = view;
    }

    public void onViewAttachedToWindow(View view) {
        this.val$fragmentView.removeOnAttachStateChangeListener((View.OnAttachStateChangeListener)this);
        ViewCompat.requestApplyInsets(this.val$fragmentView);
    }

    public void onViewDetachedFromWindow(View view) {
    }
}

