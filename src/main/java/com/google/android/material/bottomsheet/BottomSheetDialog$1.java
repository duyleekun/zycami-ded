/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnClickListener
 */
package com.google.android.material.bottomsheet;

import android.view.View;
import com.google.android.material.bottomsheet.BottomSheetDialog;

public class BottomSheetDialog$1
implements View.OnClickListener {
    public final /* synthetic */ BottomSheetDialog this$0;

    public BottomSheetDialog$1(BottomSheetDialog bottomSheetDialog) {
        this.this$0 = bottomSheetDialog;
    }

    public void onClick(View object) {
        boolean bl2;
        object = this.this$0;
        boolean bl3 = ((BottomSheetDialog)object).cancelable;
        if (bl3 && (bl2 = object.isShowing()) && (bl2 = ((BottomSheetDialog)(object = this.this$0)).shouldWindowCloseOnTouchOutside())) {
            object = this.this$0;
            object.cancel();
        }
    }
}

