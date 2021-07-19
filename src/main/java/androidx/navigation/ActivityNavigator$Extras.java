/*
 * Decompiled with CFR 0.151.
 */
package androidx.navigation;

import androidx.core.app.ActivityOptionsCompat;
import androidx.navigation.Navigator$Extras;

public final class ActivityNavigator$Extras
implements Navigator$Extras {
    private final ActivityOptionsCompat mActivityOptions;
    private final int mFlags;

    public ActivityNavigator$Extras(int n10, ActivityOptionsCompat activityOptionsCompat) {
        this.mFlags = n10;
        this.mActivityOptions = activityOptionsCompat;
    }

    public ActivityOptionsCompat getActivityOptions() {
        return this.mActivityOptions;
    }

    public int getFlags() {
        return this.mFlags;
    }
}

