/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.accessibility.AccessibilityManager$TouchExplorationStateChangeListener
 */
package androidx.core.view.accessibility;

import android.view.accessibility.AccessibilityManager;
import androidx.core.view.accessibility.AccessibilityManagerCompat$TouchExplorationStateChangeListener;

public final class AccessibilityManagerCompat$TouchExplorationStateChangeListenerWrapper
implements AccessibilityManager.TouchExplorationStateChangeListener {
    public final AccessibilityManagerCompat$TouchExplorationStateChangeListener mListener;

    public AccessibilityManagerCompat$TouchExplorationStateChangeListenerWrapper(AccessibilityManagerCompat$TouchExplorationStateChangeListener accessibilityManagerCompat$TouchExplorationStateChangeListener) {
        this.mListener = accessibilityManagerCompat$TouchExplorationStateChangeListener;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        boolean bl2 = object instanceof AccessibilityManagerCompat$TouchExplorationStateChangeListenerWrapper;
        if (!bl2) {
            return false;
        }
        object = (AccessibilityManagerCompat$TouchExplorationStateChangeListenerWrapper)object;
        AccessibilityManagerCompat$TouchExplorationStateChangeListener accessibilityManagerCompat$TouchExplorationStateChangeListener = this.mListener;
        object = ((AccessibilityManagerCompat$TouchExplorationStateChangeListenerWrapper)object).mListener;
        return accessibilityManagerCompat$TouchExplorationStateChangeListener.equals(object);
    }

    public int hashCode() {
        return this.mListener.hashCode();
    }

    public void onTouchExplorationStateChanged(boolean bl2) {
        this.mListener.onTouchExplorationStateChanged(bl2);
    }
}

