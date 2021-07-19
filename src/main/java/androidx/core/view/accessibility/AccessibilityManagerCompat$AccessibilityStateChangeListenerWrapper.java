/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.accessibility.AccessibilityManager$AccessibilityStateChangeListener
 */
package androidx.core.view.accessibility;

import android.view.accessibility.AccessibilityManager;
import androidx.core.view.accessibility.AccessibilityManagerCompat$AccessibilityStateChangeListener;

public class AccessibilityManagerCompat$AccessibilityStateChangeListenerWrapper
implements AccessibilityManager.AccessibilityStateChangeListener {
    public AccessibilityManagerCompat$AccessibilityStateChangeListener mListener;

    public AccessibilityManagerCompat$AccessibilityStateChangeListenerWrapper(AccessibilityManagerCompat$AccessibilityStateChangeListener accessibilityManagerCompat$AccessibilityStateChangeListener) {
        this.mListener = accessibilityManagerCompat$AccessibilityStateChangeListener;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        boolean bl2 = object instanceof AccessibilityManagerCompat$AccessibilityStateChangeListenerWrapper;
        if (!bl2) {
            return false;
        }
        object = (AccessibilityManagerCompat$AccessibilityStateChangeListenerWrapper)object;
        AccessibilityManagerCompat$AccessibilityStateChangeListener accessibilityManagerCompat$AccessibilityStateChangeListener = this.mListener;
        object = ((AccessibilityManagerCompat$AccessibilityStateChangeListenerWrapper)object).mListener;
        return accessibilityManagerCompat$AccessibilityStateChangeListener.equals(object);
    }

    public int hashCode() {
        return this.mListener.hashCode();
    }

    public void onAccessibilityStateChanged(boolean bl2) {
        this.mListener.onAccessibilityStateChanged(bl2);
    }
}

