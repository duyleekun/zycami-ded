/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.accessibility.AccessibilityNodeInfo
 */
package androidx.core.view.accessibility;

import android.view.accessibility.AccessibilityNodeInfo;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeProviderCompat;
import androidx.core.view.accessibility.AccessibilityNodeProviderCompat$AccessibilityNodeProviderApi16;

public class AccessibilityNodeProviderCompat$AccessibilityNodeProviderApi19
extends AccessibilityNodeProviderCompat$AccessibilityNodeProviderApi16 {
    public AccessibilityNodeProviderCompat$AccessibilityNodeProviderApi19(AccessibilityNodeProviderCompat accessibilityNodeProviderCompat) {
        super(accessibilityNodeProviderCompat);
    }

    public AccessibilityNodeInfo findFocus(int n10) {
        AccessibilityNodeProviderCompat accessibilityNodeProviderCompat = this.mCompat;
        AccessibilityNodeInfoCompat accessibilityNodeInfoCompat = accessibilityNodeProviderCompat.findFocus(n10);
        if (accessibilityNodeInfoCompat == null) {
            return null;
        }
        return accessibilityNodeInfoCompat.unwrap();
    }
}

