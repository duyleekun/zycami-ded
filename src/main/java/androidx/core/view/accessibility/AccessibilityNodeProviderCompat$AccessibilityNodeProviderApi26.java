/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.view.accessibility.AccessibilityNodeInfo
 */
package androidx.core.view.accessibility;

import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeProviderCompat;
import androidx.core.view.accessibility.AccessibilityNodeProviderCompat$AccessibilityNodeProviderApi19;

public class AccessibilityNodeProviderCompat$AccessibilityNodeProviderApi26
extends AccessibilityNodeProviderCompat$AccessibilityNodeProviderApi19 {
    public AccessibilityNodeProviderCompat$AccessibilityNodeProviderApi26(AccessibilityNodeProviderCompat accessibilityNodeProviderCompat) {
        super(accessibilityNodeProviderCompat);
    }

    public void addExtraDataToAccessibilityNodeInfo(int n10, AccessibilityNodeInfo object, String string2, Bundle bundle) {
        AccessibilityNodeProviderCompat accessibilityNodeProviderCompat = this.mCompat;
        object = AccessibilityNodeInfoCompat.wrap(object);
        accessibilityNodeProviderCompat.addExtraDataToAccessibilityNodeInfo(n10, (AccessibilityNodeInfoCompat)object, string2, bundle);
    }
}

