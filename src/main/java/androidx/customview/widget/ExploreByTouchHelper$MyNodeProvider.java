/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 */
package androidx.customview.widget;

import android.os.Bundle;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeProviderCompat;
import androidx.customview.widget.ExploreByTouchHelper;

public class ExploreByTouchHelper$MyNodeProvider
extends AccessibilityNodeProviderCompat {
    public final /* synthetic */ ExploreByTouchHelper this$0;

    public ExploreByTouchHelper$MyNodeProvider(ExploreByTouchHelper exploreByTouchHelper) {
        this.this$0 = exploreByTouchHelper;
    }

    public AccessibilityNodeInfoCompat createAccessibilityNodeInfo(int n10) {
        return AccessibilityNodeInfoCompat.obtain(this.this$0.obtainAccessibilityNodeInfo(n10));
    }

    public AccessibilityNodeInfoCompat findFocus(int n10) {
        int n11 = 2;
        if (n10 == n11) {
            ExploreByTouchHelper exploreByTouchHelper = this.this$0;
            n10 = exploreByTouchHelper.mAccessibilityFocusedVirtualViewId;
        } else {
            ExploreByTouchHelper exploreByTouchHelper = this.this$0;
            n10 = exploreByTouchHelper.mKeyboardFocusedVirtualViewId;
        }
        n11 = -1 << -1;
        if (n10 == n11) {
            return null;
        }
        return this.createAccessibilityNodeInfo(n10);
    }

    public boolean performAction(int n10, int n11, Bundle bundle) {
        return this.this$0.performAction(n10, n11, bundle);
    }
}

