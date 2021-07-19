/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 */
package com.google.android.material.bottomsheet;

import android.view.View;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

public class BottomSheetBehavior$1
implements Runnable {
    public final /* synthetic */ BottomSheetBehavior this$0;
    public final /* synthetic */ View val$child;
    public final /* synthetic */ int val$finalState;

    public BottomSheetBehavior$1(BottomSheetBehavior bottomSheetBehavior, View view, int n10) {
        this.this$0 = bottomSheetBehavior;
        this.val$child = view;
        this.val$finalState = n10;
    }

    public void run() {
        BottomSheetBehavior bottomSheetBehavior = this.this$0;
        View view = this.val$child;
        int n10 = this.val$finalState;
        bottomSheetBehavior.startSettlingAnimation(view, n10);
    }
}

