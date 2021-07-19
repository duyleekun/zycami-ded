/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.ActivityOptions
 *  android.app.PendingIntent
 *  android.graphics.Rect
 *  android.os.Build$VERSION
 *  android.os.Bundle
 */
package androidx.core.app;

import android.app.ActivityOptions;
import android.app.PendingIntent;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import androidx.core.app.ActivityOptionsCompat;

public class ActivityOptionsCompat$ActivityOptionsCompatImpl
extends ActivityOptionsCompat {
    private final ActivityOptions mActivityOptions;

    public ActivityOptionsCompat$ActivityOptionsCompatImpl(ActivityOptions activityOptions) {
        this.mActivityOptions = activityOptions;
    }

    public Rect getLaunchBounds() {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 24;
        if (n10 < n11) {
            return null;
        }
        return this.mActivityOptions.getLaunchBounds();
    }

    public void requestUsageTimeReport(PendingIntent pendingIntent) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 23;
        if (n10 >= n11) {
            ActivityOptions activityOptions = this.mActivityOptions;
            activityOptions.requestUsageTimeReport(pendingIntent);
        }
    }

    public ActivityOptionsCompat setLaunchBounds(Rect rect) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 24;
        if (n10 < n11) {
            return this;
        }
        rect = this.mActivityOptions.setLaunchBounds(rect);
        ActivityOptionsCompat$ActivityOptionsCompatImpl activityOptionsCompat$ActivityOptionsCompatImpl = new ActivityOptionsCompat$ActivityOptionsCompatImpl((ActivityOptions)rect);
        return activityOptionsCompat$ActivityOptionsCompatImpl;
    }

    public Bundle toBundle() {
        return this.mActivityOptions.toBundle();
    }

    public void update(ActivityOptionsCompat activityOptionsCompat) {
        boolean bl2 = activityOptionsCompat instanceof ActivityOptionsCompat$ActivityOptionsCompatImpl;
        if (bl2) {
            activityOptionsCompat = (ActivityOptionsCompat$ActivityOptionsCompatImpl)activityOptionsCompat;
            ActivityOptions activityOptions = this.mActivityOptions;
            activityOptionsCompat = ((ActivityOptionsCompat$ActivityOptionsCompatImpl)activityOptionsCompat).mActivityOptions;
            activityOptions.update((ActivityOptions)activityOptionsCompat);
        }
    }
}

