/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 */
package androidx.drawerlayout.widget;

import android.view.View;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.drawerlayout.widget.DrawerLayout;

public final class DrawerLayout$ChildAccessibilityDelegate
extends AccessibilityDelegateCompat {
    public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
        boolean bl2 = DrawerLayout.includeChildForAccessibility(view);
        if (!bl2) {
            bl2 = false;
            view = null;
            accessibilityNodeInfoCompat.setParent(null);
        }
    }
}

