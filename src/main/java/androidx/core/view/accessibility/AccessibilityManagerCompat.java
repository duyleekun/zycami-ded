/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  android.view.accessibility.AccessibilityManager
 *  android.view.accessibility.AccessibilityManager$AccessibilityStateChangeListener
 *  android.view.accessibility.AccessibilityManager$TouchExplorationStateChangeListener
 */
package androidx.core.view.accessibility;

import android.os.Build;
import android.view.accessibility.AccessibilityManager;
import androidx.core.view.accessibility.AccessibilityManagerCompat$AccessibilityStateChangeListener;
import androidx.core.view.accessibility.AccessibilityManagerCompat$AccessibilityStateChangeListenerWrapper;
import androidx.core.view.accessibility.AccessibilityManagerCompat$TouchExplorationStateChangeListener;
import androidx.core.view.accessibility.AccessibilityManagerCompat$TouchExplorationStateChangeListenerWrapper;
import java.util.List;

public final class AccessibilityManagerCompat {
    private AccessibilityManagerCompat() {
    }

    public static boolean addAccessibilityStateChangeListener(AccessibilityManager accessibilityManager, AccessibilityManagerCompat$AccessibilityStateChangeListener accessibilityManagerCompat$AccessibilityStateChangeListener) {
        if (accessibilityManagerCompat$AccessibilityStateChangeListener == null) {
            return false;
        }
        AccessibilityManagerCompat$AccessibilityStateChangeListenerWrapper accessibilityManagerCompat$AccessibilityStateChangeListenerWrapper = new AccessibilityManagerCompat$AccessibilityStateChangeListenerWrapper(accessibilityManagerCompat$AccessibilityStateChangeListener);
        return accessibilityManager.addAccessibilityStateChangeListener((AccessibilityManager.AccessibilityStateChangeListener)accessibilityManagerCompat$AccessibilityStateChangeListenerWrapper);
    }

    public static boolean addTouchExplorationStateChangeListener(AccessibilityManager accessibilityManager, AccessibilityManagerCompat$TouchExplorationStateChangeListener accessibilityManagerCompat$TouchExplorationStateChangeListener) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 19;
        if (n10 >= n11) {
            if (accessibilityManagerCompat$TouchExplorationStateChangeListener == null) {
                return false;
            }
            AccessibilityManagerCompat$TouchExplorationStateChangeListenerWrapper accessibilityManagerCompat$TouchExplorationStateChangeListenerWrapper = new AccessibilityManagerCompat$TouchExplorationStateChangeListenerWrapper(accessibilityManagerCompat$TouchExplorationStateChangeListener);
            return accessibilityManager.addTouchExplorationStateChangeListener((AccessibilityManager.TouchExplorationStateChangeListener)accessibilityManagerCompat$TouchExplorationStateChangeListenerWrapper);
        }
        return false;
    }

    public static List getEnabledAccessibilityServiceList(AccessibilityManager accessibilityManager, int n10) {
        return accessibilityManager.getEnabledAccessibilityServiceList(n10);
    }

    public static List getInstalledAccessibilityServiceList(AccessibilityManager accessibilityManager) {
        return accessibilityManager.getInstalledAccessibilityServiceList();
    }

    public static boolean isTouchExplorationEnabled(AccessibilityManager accessibilityManager) {
        return accessibilityManager.isTouchExplorationEnabled();
    }

    public static boolean removeAccessibilityStateChangeListener(AccessibilityManager accessibilityManager, AccessibilityManagerCompat$AccessibilityStateChangeListener accessibilityManagerCompat$AccessibilityStateChangeListener) {
        if (accessibilityManagerCompat$AccessibilityStateChangeListener == null) {
            return false;
        }
        AccessibilityManagerCompat$AccessibilityStateChangeListenerWrapper accessibilityManagerCompat$AccessibilityStateChangeListenerWrapper = new AccessibilityManagerCompat$AccessibilityStateChangeListenerWrapper(accessibilityManagerCompat$AccessibilityStateChangeListener);
        return accessibilityManager.removeAccessibilityStateChangeListener((AccessibilityManager.AccessibilityStateChangeListener)accessibilityManagerCompat$AccessibilityStateChangeListenerWrapper);
    }

    public static boolean removeTouchExplorationStateChangeListener(AccessibilityManager accessibilityManager, AccessibilityManagerCompat$TouchExplorationStateChangeListener accessibilityManagerCompat$TouchExplorationStateChangeListener) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 19;
        if (n10 >= n11) {
            if (accessibilityManagerCompat$TouchExplorationStateChangeListener == null) {
                return false;
            }
            AccessibilityManagerCompat$TouchExplorationStateChangeListenerWrapper accessibilityManagerCompat$TouchExplorationStateChangeListenerWrapper = new AccessibilityManagerCompat$TouchExplorationStateChangeListenerWrapper(accessibilityManagerCompat$TouchExplorationStateChangeListener);
            return accessibilityManager.removeTouchExplorationStateChangeListener((AccessibilityManager.TouchExplorationStateChangeListener)accessibilityManagerCompat$TouchExplorationStateChangeListenerWrapper);
        }
        return false;
    }
}

