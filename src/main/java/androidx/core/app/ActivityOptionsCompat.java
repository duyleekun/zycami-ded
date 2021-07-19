/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.ActivityOptions
 *  android.app.PendingIntent
 *  android.content.Context
 *  android.graphics.Bitmap
 *  android.graphics.Rect
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.util.Pair
 *  android.view.View
 */
package androidx.core.app;

import android.app.Activity;
import android.app.ActivityOptions;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import androidx.core.app.ActivityOptionsCompat$ActivityOptionsCompatImpl;

public class ActivityOptionsCompat {
    public static final String EXTRA_USAGE_TIME_REPORT = "android.activity.usage_time";
    public static final String EXTRA_USAGE_TIME_REPORT_PACKAGES = "android.usage_time_packages";

    public static ActivityOptionsCompat makeBasic() {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 23;
        if (n10 >= n11) {
            ActivityOptions activityOptions = ActivityOptions.makeBasic();
            ActivityOptionsCompat$ActivityOptionsCompatImpl activityOptionsCompat$ActivityOptionsCompatImpl = new ActivityOptionsCompat$ActivityOptionsCompatImpl(activityOptions);
            return activityOptionsCompat$ActivityOptionsCompatImpl;
        }
        ActivityOptionsCompat activityOptionsCompat = new ActivityOptionsCompat();
        return activityOptionsCompat;
    }

    public static ActivityOptionsCompat makeClipRevealAnimation(View object, int n10, int n11, int n12, int n13) {
        int n14 = Build.VERSION.SDK_INT;
        int n15 = 23;
        if (n14 >= n15) {
            object = ActivityOptions.makeClipRevealAnimation((View)object, (int)n10, (int)n11, (int)n12, (int)n13);
            ActivityOptionsCompat$ActivityOptionsCompatImpl activityOptionsCompat$ActivityOptionsCompatImpl = new ActivityOptionsCompat$ActivityOptionsCompatImpl((ActivityOptions)object);
            return activityOptionsCompat$ActivityOptionsCompatImpl;
        }
        object = new ActivityOptionsCompat();
        return object;
    }

    public static ActivityOptionsCompat makeCustomAnimation(Context object, int n10, int n11) {
        int n12 = Build.VERSION.SDK_INT;
        int n13 = 16;
        if (n12 >= n13) {
            object = ActivityOptions.makeCustomAnimation((Context)object, (int)n10, (int)n11);
            ActivityOptionsCompat$ActivityOptionsCompatImpl activityOptionsCompat$ActivityOptionsCompatImpl = new ActivityOptionsCompat$ActivityOptionsCompatImpl((ActivityOptions)object);
            return activityOptionsCompat$ActivityOptionsCompatImpl;
        }
        object = new ActivityOptionsCompat();
        return object;
    }

    public static ActivityOptionsCompat makeScaleUpAnimation(View object, int n10, int n11, int n12, int n13) {
        int n14 = Build.VERSION.SDK_INT;
        int n15 = 16;
        if (n14 >= n15) {
            object = ActivityOptions.makeScaleUpAnimation((View)object, (int)n10, (int)n11, (int)n12, (int)n13);
            ActivityOptionsCompat$ActivityOptionsCompatImpl activityOptionsCompat$ActivityOptionsCompatImpl = new ActivityOptionsCompat$ActivityOptionsCompatImpl((ActivityOptions)object);
            return activityOptionsCompat$ActivityOptionsCompatImpl;
        }
        object = new ActivityOptionsCompat();
        return object;
    }

    public static ActivityOptionsCompat makeSceneTransitionAnimation(Activity object, View view, String string2) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 21;
        if (n10 >= n11) {
            object = ActivityOptions.makeSceneTransitionAnimation((Activity)object, (View)view, (String)string2);
            ActivityOptionsCompat$ActivityOptionsCompatImpl activityOptionsCompat$ActivityOptionsCompatImpl = new ActivityOptionsCompat$ActivityOptionsCompatImpl((ActivityOptions)object);
            return activityOptionsCompat$ActivityOptionsCompatImpl;
        }
        object = new ActivityOptionsCompat();
        return object;
    }

    public static ActivityOptionsCompat makeSceneTransitionAnimation(Activity object, androidx.core.util.Pair ... object2) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 21;
        if (n10 >= n11) {
            n10 = 0;
            Pair[] pairArray = null;
            if (object2 != null) {
                int n12;
                n10 = ((androidx.core.util.Pair[])object2).length;
                pairArray = new Pair[n10];
                for (n11 = 0; n11 < (n12 = ((androidx.core.util.Pair[])object2).length); ++n11) {
                    Object object3 = object2[n11].first;
                    Object object4 = object2[n11].second;
                    object3 = Pair.create((Object)object3, (Object)object4);
                    pairArray[n11] = object3;
                }
            }
            object = ActivityOptions.makeSceneTransitionAnimation((Activity)object, pairArray);
            object2 = new ActivityOptionsCompat$ActivityOptionsCompatImpl((ActivityOptions)object);
            return object2;
        }
        object = new ActivityOptionsCompat();
        return object;
    }

    public static ActivityOptionsCompat makeTaskLaunchBehind() {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 21;
        if (n10 >= n11) {
            ActivityOptions activityOptions = ActivityOptions.makeTaskLaunchBehind();
            ActivityOptionsCompat$ActivityOptionsCompatImpl activityOptionsCompat$ActivityOptionsCompatImpl = new ActivityOptionsCompat$ActivityOptionsCompatImpl(activityOptions);
            return activityOptionsCompat$ActivityOptionsCompatImpl;
        }
        ActivityOptionsCompat activityOptionsCompat = new ActivityOptionsCompat();
        return activityOptionsCompat;
    }

    public static ActivityOptionsCompat makeThumbnailScaleUpAnimation(View object, Bitmap bitmap, int n10, int n11) {
        int n12 = Build.VERSION.SDK_INT;
        int n13 = 16;
        if (n12 >= n13) {
            object = ActivityOptions.makeThumbnailScaleUpAnimation((View)object, (Bitmap)bitmap, (int)n10, (int)n11);
            ActivityOptionsCompat$ActivityOptionsCompatImpl activityOptionsCompat$ActivityOptionsCompatImpl = new ActivityOptionsCompat$ActivityOptionsCompatImpl((ActivityOptions)object);
            return activityOptionsCompat$ActivityOptionsCompatImpl;
        }
        object = new ActivityOptionsCompat();
        return object;
    }

    public Rect getLaunchBounds() {
        return null;
    }

    public void requestUsageTimeReport(PendingIntent pendingIntent) {
    }

    public ActivityOptionsCompat setLaunchBounds(Rect rect) {
        return this;
    }

    public Bundle toBundle() {
        return null;
    }

    public void update(ActivityOptionsCompat activityOptionsCompat) {
    }
}

