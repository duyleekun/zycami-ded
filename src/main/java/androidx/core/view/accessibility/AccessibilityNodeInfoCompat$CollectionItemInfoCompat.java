/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  android.view.accessibility.AccessibilityNodeInfo$CollectionItemInfo
 */
package androidx.core.view.accessibility;

import android.os.Build;
import android.view.accessibility.AccessibilityNodeInfo;

public class AccessibilityNodeInfoCompat$CollectionItemInfoCompat {
    public final Object mInfo;

    public AccessibilityNodeInfoCompat$CollectionItemInfoCompat(Object object) {
        this.mInfo = object;
    }

    public static AccessibilityNodeInfoCompat$CollectionItemInfoCompat obtain(int n10, int n11, int n12, int n13, boolean bl2) {
        int n14 = Build.VERSION.SDK_INT;
        int n15 = 19;
        if (n14 >= n15) {
            AccessibilityNodeInfo.CollectionItemInfo collectionItemInfo = AccessibilityNodeInfo.CollectionItemInfo.obtain((int)n10, (int)n11, (int)n12, (int)n13, (boolean)bl2);
            AccessibilityNodeInfoCompat$CollectionItemInfoCompat accessibilityNodeInfoCompat$CollectionItemInfoCompat = new AccessibilityNodeInfoCompat$CollectionItemInfoCompat(collectionItemInfo);
            return accessibilityNodeInfoCompat$CollectionItemInfoCompat;
        }
        AccessibilityNodeInfoCompat$CollectionItemInfoCompat accessibilityNodeInfoCompat$CollectionItemInfoCompat = new AccessibilityNodeInfoCompat$CollectionItemInfoCompat(null);
        return accessibilityNodeInfoCompat$CollectionItemInfoCompat;
    }

    public static AccessibilityNodeInfoCompat$CollectionItemInfoCompat obtain(int n10, int n11, int n12, int n13, boolean bl2, boolean n14) {
        int n15 = Build.VERSION.SDK_INT;
        int n16 = 21;
        if (n15 >= n16) {
            AccessibilityNodeInfo.CollectionItemInfo collectionItemInfo = AccessibilityNodeInfo.CollectionItemInfo.obtain((int)n10, (int)n11, (int)n12, (int)n13, (boolean)bl2, n14 != 0);
            AccessibilityNodeInfoCompat$CollectionItemInfoCompat accessibilityNodeInfoCompat$CollectionItemInfoCompat = new AccessibilityNodeInfoCompat$CollectionItemInfoCompat(collectionItemInfo);
            return accessibilityNodeInfoCompat$CollectionItemInfoCompat;
        }
        n14 = 19;
        if (n15 >= n14) {
            AccessibilityNodeInfo.CollectionItemInfo collectionItemInfo = AccessibilityNodeInfo.CollectionItemInfo.obtain((int)n10, (int)n11, (int)n12, (int)n13, (boolean)bl2);
            AccessibilityNodeInfoCompat$CollectionItemInfoCompat accessibilityNodeInfoCompat$CollectionItemInfoCompat = new AccessibilityNodeInfoCompat$CollectionItemInfoCompat(collectionItemInfo);
            return accessibilityNodeInfoCompat$CollectionItemInfoCompat;
        }
        AccessibilityNodeInfoCompat$CollectionItemInfoCompat accessibilityNodeInfoCompat$CollectionItemInfoCompat = new AccessibilityNodeInfoCompat$CollectionItemInfoCompat(null);
        return accessibilityNodeInfoCompat$CollectionItemInfoCompat;
    }

    public int getColumnIndex() {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 19;
        if (n10 >= n11) {
            return ((AccessibilityNodeInfo.CollectionItemInfo)this.mInfo).getColumnIndex();
        }
        return 0;
    }

    public int getColumnSpan() {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 19;
        if (n10 >= n11) {
            return ((AccessibilityNodeInfo.CollectionItemInfo)this.mInfo).getColumnSpan();
        }
        return 0;
    }

    public int getRowIndex() {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 19;
        if (n10 >= n11) {
            return ((AccessibilityNodeInfo.CollectionItemInfo)this.mInfo).getRowIndex();
        }
        return 0;
    }

    public int getRowSpan() {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 19;
        if (n10 >= n11) {
            return ((AccessibilityNodeInfo.CollectionItemInfo)this.mInfo).getRowSpan();
        }
        return 0;
    }

    public boolean isHeading() {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 19;
        if (n10 >= n11) {
            return ((AccessibilityNodeInfo.CollectionItemInfo)this.mInfo).isHeading();
        }
        return false;
    }

    public boolean isSelected() {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 21;
        if (n10 >= n11) {
            return ((AccessibilityNodeInfo.CollectionItemInfo)this.mInfo).isSelected();
        }
        return false;
    }
}

