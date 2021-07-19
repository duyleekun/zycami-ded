/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 */
package com.google.android.material.behavior;

import android.view.View;
import androidx.core.view.ViewCompat;
import androidx.customview.widget.ViewDragHelper;
import com.google.android.material.behavior.SwipeDismissBehavior;

public class SwipeDismissBehavior$SettleRunnable
implements Runnable {
    private final boolean dismiss;
    public final /* synthetic */ SwipeDismissBehavior this$0;
    private final View view;

    public SwipeDismissBehavior$SettleRunnable(SwipeDismissBehavior swipeDismissBehavior, View view, boolean bl2) {
        this.this$0 = swipeDismissBehavior;
        this.view = view;
        this.dismiss = bl2;
    }

    public void run() {
        boolean bl2;
        boolean bl3;
        Object object = this.this$0.viewDragHelper;
        if (object != null && (bl3 = ((ViewDragHelper)object).continueSettling(bl2 = true))) {
            object = this.view;
            ViewCompat.postOnAnimation((View)object, this);
        } else {
            bl3 = this.dismiss;
            if (bl3 && (object = this.this$0.listener) != null) {
                View view = this.view;
                object.onDismiss(view);
            }
        }
    }
}

