/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.accessibility.AccessibilityEvent
 */
package androidx.core.view;

import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.core.R$id;
import androidx.core.view.NestedScrollingParent;
import androidx.core.view.ViewCompat;

public final class ViewGroupCompat {
    public static final int LAYOUT_MODE_CLIP_BOUNDS = 0;
    public static final int LAYOUT_MODE_OPTICAL_BOUNDS = 1;

    private ViewGroupCompat() {
    }

    public static int getLayoutMode(ViewGroup viewGroup) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 18;
        if (n10 >= n11) {
            return viewGroup.getLayoutMode();
        }
        return 0;
    }

    public static int getNestedScrollAxes(ViewGroup viewGroup) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 21;
        if (n10 >= n11) {
            return viewGroup.getNestedScrollAxes();
        }
        n10 = viewGroup instanceof NestedScrollingParent;
        if (n10 != 0) {
            return ((NestedScrollingParent)viewGroup).getNestedScrollAxes();
        }
        return 0;
    }

    public static boolean isTransitionGroup(ViewGroup object) {
        boolean bl2;
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 21;
        if (n10 >= n11) {
            return object.isTransitionGroup();
        }
        n10 = R$id.tag_transition_group;
        Boolean bl3 = (Boolean)object.getTag(n10);
        if ((bl3 == null || (n10 = (int)(bl3.booleanValue() ? 1 : 0)) == 0) && (bl3 = object.getBackground()) == null && (object = ViewCompat.getTransitionName((View)object)) == null) {
            bl2 = false;
            object = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }

    public static boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return viewGroup.onRequestSendAccessibilityEvent(view, accessibilityEvent);
    }

    public static void setLayoutMode(ViewGroup viewGroup, int n10) {
        int n11 = Build.VERSION.SDK_INT;
        int n12 = 18;
        if (n11 >= n12) {
            viewGroup.setLayoutMode(n10);
        }
    }

    public static void setMotionEventSplittingEnabled(ViewGroup viewGroup, boolean bl2) {
        viewGroup.setMotionEventSplittingEnabled(bl2);
    }

    public static void setTransitionGroup(ViewGroup viewGroup, boolean bl2) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 21;
        if (n10 >= n11) {
            viewGroup.setTransitionGroup(bl2);
        } else {
            n10 = R$id.tag_transition_group;
            Boolean bl3 = bl2;
            viewGroup.setTag(n10, (Object)bl3);
        }
    }
}

