/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 */
package com.google.android.material.internal;

import android.view.View;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.internal.NavigationMenuItemView;

public class NavigationMenuItemView$1
extends AccessibilityDelegateCompat {
    public final /* synthetic */ NavigationMenuItemView this$0;

    public NavigationMenuItemView$1(NavigationMenuItemView navigationMenuItemView) {
        this.this$0 = navigationMenuItemView;
    }

    public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
        boolean bl2 = this.this$0.checkable;
        accessibilityNodeInfoCompat.setCheckable(bl2);
    }
}

