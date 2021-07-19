/*
 * Decompiled with CFR 0.151.
 */
package androidx.navigation;

import androidx.core.app.ActivityOptionsCompat;
import androidx.navigation.ActivityNavigator$Extras;

public final class ActivityNavigator$Extras$Builder {
    private ActivityOptionsCompat mActivityOptions;
    private int mFlags;

    public ActivityNavigator$Extras$Builder addFlags(int n10) {
        int n11 = this.mFlags;
        this.mFlags = n10 |= n11;
        return this;
    }

    public ActivityNavigator$Extras build() {
        int n10 = this.mFlags;
        ActivityOptionsCompat activityOptionsCompat = this.mActivityOptions;
        ActivityNavigator$Extras activityNavigator$Extras = new ActivityNavigator$Extras(n10, activityOptionsCompat);
        return activityNavigator$Extras;
    }

    public ActivityNavigator$Extras$Builder setActivityOptions(ActivityOptionsCompat activityOptionsCompat) {
        this.mActivityOptions = activityOptionsCompat;
        return this;
    }
}

