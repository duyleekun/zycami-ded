/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.VelocityTracker
 */
package androidx.core.view;

import android.view.VelocityTracker;

public final class VelocityTrackerCompat {
    private VelocityTrackerCompat() {
    }

    public static float getXVelocity(VelocityTracker velocityTracker, int n10) {
        return velocityTracker.getXVelocity(n10);
    }

    public static float getYVelocity(VelocityTracker velocityTracker, int n10) {
        return velocityTracker.getYVelocity(n10);
    }
}

