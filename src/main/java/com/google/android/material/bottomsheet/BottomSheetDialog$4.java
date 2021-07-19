/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 */
package com.google.android.material.bottomsheet;

import android.view.View;
import com.google.android.material.bottomsheet.BottomSheetBehavior$BottomSheetCallback;
import com.google.android.material.bottomsheet.BottomSheetDialog;

public class BottomSheetDialog$4
extends BottomSheetBehavior$BottomSheetCallback {
    public final /* synthetic */ BottomSheetDialog this$0;

    public BottomSheetDialog$4(BottomSheetDialog bottomSheetDialog) {
        this.this$0 = bottomSheetDialog;
    }

    public void onSlide(View view, float f10) {
    }

    public void onStateChanged(View object, int n10) {
        int n11 = 5;
        if (n10 == n11) {
            object = this.this$0;
            object.cancel();
        }
    }
}

