/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.view.View
 */
package com.google.android.material.bottomsheet;

import android.os.Bundle;
import android.view.View;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.bottomsheet.BottomSheetDialog;

public class BottomSheetDialog$2
extends AccessibilityDelegateCompat {
    public final /* synthetic */ BottomSheetDialog this$0;

    public BottomSheetDialog$2(BottomSheetDialog bottomSheetDialog) {
        this.this$0 = bottomSheetDialog;
    }

    public void onInitializeAccessibilityNodeInfo(View object, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        super.onInitializeAccessibilityNodeInfo((View)object, accessibilityNodeInfoCompat);
        object = this.this$0;
        boolean bl2 = object.cancelable;
        if (bl2) {
            accessibilityNodeInfoCompat.addAction(0x100000);
            bl2 = true;
            accessibilityNodeInfoCompat.setDismissable(bl2);
        } else {
            bl2 = false;
            object = null;
            accessibilityNodeInfoCompat.setDismissable(false);
        }
    }

    public boolean performAccessibilityAction(View view, int n10, Bundle bundle) {
        int n11 = 0x100000;
        if (n10 == n11) {
            BottomSheetDialog bottomSheetDialog = this.this$0;
            boolean bl2 = bottomSheetDialog.cancelable;
            if (bl2) {
                bottomSheetDialog.cancel();
                return true;
            }
        }
        return super.performAccessibilityAction(view, n10, bundle);
    }
}

