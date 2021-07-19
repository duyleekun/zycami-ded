/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 */
package com.google.android.material.bottomsheet;

import android.view.View;
import androidx.core.view.ViewCompat;
import androidx.customview.widget.ViewDragHelper;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

public class BottomSheetBehavior$SettleRunnable
implements Runnable {
    private final int targetState;
    public final /* synthetic */ BottomSheetBehavior this$0;
    private final View view;

    public BottomSheetBehavior$SettleRunnable(BottomSheetBehavior bottomSheetBehavior, View view, int n10) {
        this.this$0 = bottomSheetBehavior;
        this.view = view;
        this.targetState = n10;
    }

    public void run() {
        int n10;
        boolean bl2;
        Object object = this.this$0.viewDragHelper;
        if (object != null && (bl2 = ((ViewDragHelper)object).continueSettling((n10 = 1) != 0))) {
            object = this.view;
            ViewCompat.postOnAnimation((View)object, this);
        } else {
            object = this.this$0;
            n10 = this.targetState;
            ((BottomSheetBehavior)object).setStateInternal(n10);
        }
    }
}

