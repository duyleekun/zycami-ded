/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  android.view.accessibility.AccessibilityNodeInfo$RangeInfo
 */
package androidx.core.view.accessibility;

import android.os.Build;
import android.view.accessibility.AccessibilityNodeInfo;

public class AccessibilityNodeInfoCompat$RangeInfoCompat {
    public static final int RANGE_TYPE_FLOAT = 1;
    public static final int RANGE_TYPE_INT = 0;
    public static final int RANGE_TYPE_PERCENT = 2;
    public final Object mInfo;

    public AccessibilityNodeInfoCompat$RangeInfoCompat(Object object) {
        this.mInfo = object;
    }

    public static AccessibilityNodeInfoCompat$RangeInfoCompat obtain(int n10, float f10, float f11, float f12) {
        int n11 = Build.VERSION.SDK_INT;
        int n12 = 19;
        if (n11 >= n12) {
            AccessibilityNodeInfo.RangeInfo rangeInfo = AccessibilityNodeInfo.RangeInfo.obtain((int)n10, (float)f10, (float)f11, (float)f12);
            AccessibilityNodeInfoCompat$RangeInfoCompat accessibilityNodeInfoCompat$RangeInfoCompat = new AccessibilityNodeInfoCompat$RangeInfoCompat(rangeInfo);
            return accessibilityNodeInfoCompat$RangeInfoCompat;
        }
        AccessibilityNodeInfoCompat$RangeInfoCompat accessibilityNodeInfoCompat$RangeInfoCompat = new AccessibilityNodeInfoCompat$RangeInfoCompat(null);
        return accessibilityNodeInfoCompat$RangeInfoCompat;
    }

    public float getCurrent() {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 19;
        if (n10 >= n11) {
            return ((AccessibilityNodeInfo.RangeInfo)this.mInfo).getCurrent();
        }
        return 0.0f;
    }

    public float getMax() {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 19;
        if (n10 >= n11) {
            return ((AccessibilityNodeInfo.RangeInfo)this.mInfo).getMax();
        }
        return 0.0f;
    }

    public float getMin() {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 19;
        if (n10 >= n11) {
            return ((AccessibilityNodeInfo.RangeInfo)this.mInfo).getMin();
        }
        return 0.0f;
    }

    public int getType() {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 19;
        if (n10 >= n11) {
            return ((AccessibilityNodeInfo.RangeInfo)this.mInfo).getType();
        }
        return 0;
    }
}

