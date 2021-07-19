/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.view.accessibility.AccessibilityNodeInfo
 *  android.view.accessibility.AccessibilityNodeProvider
 */
package androidx.core.view.accessibility;

import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeProviderCompat;
import java.util.ArrayList;
import java.util.List;

public class AccessibilityNodeProviderCompat$AccessibilityNodeProviderApi16
extends AccessibilityNodeProvider {
    public final AccessibilityNodeProviderCompat mCompat;

    public AccessibilityNodeProviderCompat$AccessibilityNodeProviderApi16(AccessibilityNodeProviderCompat accessibilityNodeProviderCompat) {
        this.mCompat = accessibilityNodeProviderCompat;
    }

    public AccessibilityNodeInfo createAccessibilityNodeInfo(int n10) {
        AccessibilityNodeProviderCompat accessibilityNodeProviderCompat = this.mCompat;
        AccessibilityNodeInfoCompat accessibilityNodeInfoCompat = accessibilityNodeProviderCompat.createAccessibilityNodeInfo(n10);
        if (accessibilityNodeInfoCompat == null) {
            return null;
        }
        return accessibilityNodeInfoCompat.unwrap();
    }

    public List findAccessibilityNodeInfosByText(String object, int n10) {
        AccessibilityNodeProviderCompat accessibilityNodeProviderCompat = this.mCompat;
        if ((object = accessibilityNodeProviderCompat.findAccessibilityNodeInfosByText((String)object, n10)) == null) {
            return null;
        }
        ArrayList<AccessibilityNodeInfo> arrayList = new ArrayList<AccessibilityNodeInfo>();
        int n11 = object.size();
        for (int i10 = 0; i10 < n11; ++i10) {
            AccessibilityNodeInfo accessibilityNodeInfo = ((AccessibilityNodeInfoCompat)object.get(i10)).unwrap();
            arrayList.add(accessibilityNodeInfo);
        }
        return arrayList;
    }

    public boolean performAction(int n10, int n11, Bundle bundle) {
        return this.mCompat.performAction(n10, n11, bundle);
    }
}

