/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  android.view.accessibility.AccessibilityNodeInfo$CollectionInfo
 */
package androidx.core.view.accessibility;

import android.os.Build;
import android.view.accessibility.AccessibilityNodeInfo;

public class AccessibilityNodeInfoCompat$CollectionInfoCompat {
    public static final int SELECTION_MODE_MULTIPLE = 2;
    public static final int SELECTION_MODE_NONE = 0;
    public static final int SELECTION_MODE_SINGLE = 1;
    public final Object mInfo;

    public AccessibilityNodeInfoCompat$CollectionInfoCompat(Object object) {
        this.mInfo = object;
    }

    public static AccessibilityNodeInfoCompat$CollectionInfoCompat obtain(int n10, int n11, boolean bl2) {
        int n12 = Build.VERSION.SDK_INT;
        int n13 = 19;
        if (n12 >= n13) {
            AccessibilityNodeInfo.CollectionInfo collectionInfo = AccessibilityNodeInfo.CollectionInfo.obtain((int)n10, (int)n11, (boolean)bl2);
            AccessibilityNodeInfoCompat$CollectionInfoCompat accessibilityNodeInfoCompat$CollectionInfoCompat = new AccessibilityNodeInfoCompat$CollectionInfoCompat(collectionInfo);
            return accessibilityNodeInfoCompat$CollectionInfoCompat;
        }
        AccessibilityNodeInfoCompat$CollectionInfoCompat accessibilityNodeInfoCompat$CollectionInfoCompat = new AccessibilityNodeInfoCompat$CollectionInfoCompat(null);
        return accessibilityNodeInfoCompat$CollectionInfoCompat;
    }

    public static AccessibilityNodeInfoCompat$CollectionInfoCompat obtain(int n10, int n11, boolean bl2, int n12) {
        int n13 = Build.VERSION.SDK_INT;
        int n14 = 21;
        if (n13 >= n14) {
            AccessibilityNodeInfo.CollectionInfo collectionInfo = AccessibilityNodeInfo.CollectionInfo.obtain((int)n10, (int)n11, (boolean)bl2, (int)n12);
            AccessibilityNodeInfoCompat$CollectionInfoCompat accessibilityNodeInfoCompat$CollectionInfoCompat = new AccessibilityNodeInfoCompat$CollectionInfoCompat(collectionInfo);
            return accessibilityNodeInfoCompat$CollectionInfoCompat;
        }
        n12 = 19;
        if (n13 >= n12) {
            AccessibilityNodeInfo.CollectionInfo collectionInfo = AccessibilityNodeInfo.CollectionInfo.obtain((int)n10, (int)n11, (boolean)bl2);
            AccessibilityNodeInfoCompat$CollectionInfoCompat accessibilityNodeInfoCompat$CollectionInfoCompat = new AccessibilityNodeInfoCompat$CollectionInfoCompat(collectionInfo);
            return accessibilityNodeInfoCompat$CollectionInfoCompat;
        }
        AccessibilityNodeInfoCompat$CollectionInfoCompat accessibilityNodeInfoCompat$CollectionInfoCompat = new AccessibilityNodeInfoCompat$CollectionInfoCompat(null);
        return accessibilityNodeInfoCompat$CollectionInfoCompat;
    }

    public int getColumnCount() {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 19;
        if (n10 >= n11) {
            return ((AccessibilityNodeInfo.CollectionInfo)this.mInfo).getColumnCount();
        }
        return -1;
    }

    public int getRowCount() {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 19;
        if (n10 >= n11) {
            return ((AccessibilityNodeInfo.CollectionInfo)this.mInfo).getRowCount();
        }
        return -1;
    }

    public int getSelectionMode() {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 21;
        if (n10 >= n11) {
            return ((AccessibilityNodeInfo.CollectionInfo)this.mInfo).getSelectionMode();
        }
        return 0;
    }

    public boolean isHierarchical() {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 19;
        if (n10 >= n11) {
            return ((AccessibilityNodeInfo.CollectionInfo)this.mInfo).isHierarchical();
        }
        return false;
    }
}

