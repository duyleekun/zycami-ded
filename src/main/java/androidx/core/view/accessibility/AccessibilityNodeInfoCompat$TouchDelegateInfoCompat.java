/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Region
 *  android.os.Build$VERSION
 *  android.view.accessibility.AccessibilityNodeInfo
 *  android.view.accessibility.AccessibilityNodeInfo$TouchDelegateInfo
 */
package androidx.core.view.accessibility;

import android.graphics.Region;
import android.os.Build;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import java.util.Map;

public final class AccessibilityNodeInfoCompat$TouchDelegateInfoCompat {
    public final AccessibilityNodeInfo.TouchDelegateInfo mInfo;

    public AccessibilityNodeInfoCompat$TouchDelegateInfoCompat(AccessibilityNodeInfo.TouchDelegateInfo touchDelegateInfo) {
        this.mInfo = touchDelegateInfo;
    }

    public AccessibilityNodeInfoCompat$TouchDelegateInfoCompat(Map map) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 29;
        if (n10 >= n11) {
            AccessibilityNodeInfo.TouchDelegateInfo touchDelegateInfo;
            this.mInfo = touchDelegateInfo = new AccessibilityNodeInfo.TouchDelegateInfo(map);
        } else {
            map = null;
            this.mInfo = null;
        }
    }

    public Region getRegionAt(int n10) {
        int n11 = Build.VERSION.SDK_INT;
        int n12 = 29;
        if (n11 >= n12) {
            return this.mInfo.getRegionAt(n10);
        }
        return null;
    }

    public int getRegionCount() {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 29;
        if (n10 >= n11) {
            return this.mInfo.getRegionCount();
        }
        return 0;
    }

    public AccessibilityNodeInfoCompat getTargetForRegion(Region region) {
        AccessibilityNodeInfo.TouchDelegateInfo touchDelegateInfo;
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 29;
        if (n10 >= n11 && (region = (touchDelegateInfo = this.mInfo).getTargetForRegion(region)) != null) {
            return AccessibilityNodeInfoCompat.wrap((AccessibilityNodeInfo)region);
        }
        return null;
    }
}

