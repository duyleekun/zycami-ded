/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.view.View
 */
package com.google.android.material.snackbar;

import android.os.Bundle;
import android.view.View;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.snackbar.BaseTransientBottomBar;

public class BaseTransientBottomBar$3
extends AccessibilityDelegateCompat {
    public final /* synthetic */ BaseTransientBottomBar this$0;

    public BaseTransientBottomBar$3(BaseTransientBottomBar baseTransientBottomBar) {
        this.this$0 = baseTransientBottomBar;
    }

    public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
        accessibilityNodeInfoCompat.addAction(0x100000);
        accessibilityNodeInfoCompat.setDismissable(true);
    }

    public boolean performAccessibilityAction(View view, int n10, Bundle bundle) {
        int n11 = 0x100000;
        if (n10 == n11) {
            this.this$0.dismiss();
            return true;
        }
        return super.performAccessibilityAction(view, n10, bundle);
    }
}

