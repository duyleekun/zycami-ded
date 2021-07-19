/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  android.os.Bundle
 */
package androidx.core.view.accessibility;

import android.os.Build;
import android.os.Bundle;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeProviderCompat$AccessibilityNodeProviderApi16;
import androidx.core.view.accessibility.AccessibilityNodeProviderCompat$AccessibilityNodeProviderApi19;
import androidx.core.view.accessibility.AccessibilityNodeProviderCompat$AccessibilityNodeProviderApi26;
import java.util.List;

public class AccessibilityNodeProviderCompat {
    public static final int HOST_VIEW_ID = 255;
    private final Object mProvider;

    public AccessibilityNodeProviderCompat() {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 26;
        if (n10 >= n11) {
            AccessibilityNodeProviderCompat$AccessibilityNodeProviderApi26 accessibilityNodeProviderCompat$AccessibilityNodeProviderApi26 = new AccessibilityNodeProviderCompat$AccessibilityNodeProviderApi26(this);
            this.mProvider = accessibilityNodeProviderCompat$AccessibilityNodeProviderApi26;
        } else {
            n11 = 19;
            if (n10 >= n11) {
                AccessibilityNodeProviderCompat$AccessibilityNodeProviderApi19 accessibilityNodeProviderCompat$AccessibilityNodeProviderApi19 = new AccessibilityNodeProviderCompat$AccessibilityNodeProviderApi19(this);
                this.mProvider = accessibilityNodeProviderCompat$AccessibilityNodeProviderApi19;
            } else {
                n11 = 16;
                if (n10 >= n11) {
                    AccessibilityNodeProviderCompat$AccessibilityNodeProviderApi16 accessibilityNodeProviderCompat$AccessibilityNodeProviderApi16 = new AccessibilityNodeProviderCompat$AccessibilityNodeProviderApi16(this);
                    this.mProvider = accessibilityNodeProviderCompat$AccessibilityNodeProviderApi16;
                } else {
                    n10 = 0;
                    Object var3_6 = null;
                    this.mProvider = null;
                }
            }
        }
    }

    public AccessibilityNodeProviderCompat(Object object) {
        this.mProvider = object;
    }

    public void addExtraDataToAccessibilityNodeInfo(int n10, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat, String string2, Bundle bundle) {
    }

    public AccessibilityNodeInfoCompat createAccessibilityNodeInfo(int n10) {
        return null;
    }

    public List findAccessibilityNodeInfosByText(String string2, int n10) {
        return null;
    }

    public AccessibilityNodeInfoCompat findFocus(int n10) {
        return null;
    }

    public Object getProvider() {
        return this.mProvider;
    }

    public boolean performAction(int n10, int n11, Bundle bundle) {
        return false;
    }
}

