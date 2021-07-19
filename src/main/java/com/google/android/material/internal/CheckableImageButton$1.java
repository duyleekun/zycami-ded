/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.accessibility.AccessibilityEvent
 */
package com.google.android.material.internal;

import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.internal.CheckableImageButton;

public class CheckableImageButton$1
extends AccessibilityDelegateCompat {
    public final /* synthetic */ CheckableImageButton this$0;

    public CheckableImageButton$1(CheckableImageButton checkableImageButton) {
        this.this$0 = checkableImageButton;
    }

    public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(view, accessibilityEvent);
        boolean bl2 = this.this$0.isChecked();
        accessibilityEvent.setChecked(bl2);
    }

    public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
        accessibilityNodeInfoCompat.setCheckable(true);
        boolean bl2 = this.this$0.isChecked();
        accessibilityNodeInfoCompat.setChecked(bl2);
    }
}

