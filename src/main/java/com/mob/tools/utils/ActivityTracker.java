/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.Application
 *  android.app.Application$ActivityLifecycleCallbacks
 *  android.content.Context
 *  android.os.Build$VERSION
 *  android.os.Bundle
 */
package com.mob.tools.utils;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import com.mob.tools.MobLog;
import com.mob.tools.log.NLog;
import com.mob.tools.utils.ActivityTracker$1;
import com.mob.tools.utils.ActivityTracker$2;
import com.mob.tools.utils.ActivityTracker$3;
import com.mob.tools.utils.ActivityTracker$4;
import com.mob.tools.utils.ActivityTracker$5;
import com.mob.tools.utils.ActivityTracker$6;
import com.mob.tools.utils.ActivityTracker$7;
import com.mob.tools.utils.ActivityTracker$8;
import com.mob.tools.utils.ActivityTracker$9;
import com.mob.tools.utils.ActivityTracker$EachTracker;
import com.mob.tools.utils.ActivityTracker$Tracker;
import com.mob.tools.utils.DeviceHelper;
import com.mob.tools.utils.ReflectHelper;
import java.util.HashSet;

public class ActivityTracker {
    private static ActivityTracker instance;
    private HashSet trackers;

    private ActivityTracker(Context context) {
        HashSet hashSet;
        this.trackers = hashSet = new HashSet();
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 14;
        if (n10 >= n11) {
            this.initLevel14(context);
        } else {
            this.init(context);
        }
    }

    public static /* synthetic */ void access$000(ActivityTracker activityTracker, Activity activity, Bundle bundle) {
        activityTracker.onCreated(activity, bundle);
    }

    public static /* synthetic */ void access$100(ActivityTracker activityTracker, Activity activity) {
        activityTracker.onStarted(activity);
    }

    public static /* synthetic */ void access$200(ActivityTracker activityTracker, Activity activity) {
        activityTracker.onResumed(activity);
    }

    public static /* synthetic */ void access$300(ActivityTracker activityTracker, Activity activity) {
        activityTracker.onPaused(activity);
    }

    public static /* synthetic */ void access$400(ActivityTracker activityTracker, Activity activity) {
        activityTracker.onStopped(activity);
    }

    public static /* synthetic */ void access$500(ActivityTracker activityTracker, Activity activity) {
        activityTracker.onDestroyed(activity);
    }

    public static /* synthetic */ void access$600(ActivityTracker activityTracker, Activity activity, Bundle bundle) {
        activityTracker.onSaveInstanceState(activity, bundle);
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void eachTracker(ActivityTracker$EachTracker activityTracker$EachTracker) {
        ActivityTracker$Tracker[] activityTracker$TrackerArray;
        int n10;
        ActivityTracker$Tracker[] activityTracker$TrackerArray2;
        Object object;
        try {
            object = this.trackers;
            synchronized (object) {
                activityTracker$TrackerArray2 = this.trackers;
                n10 = activityTracker$TrackerArray2.size();
            }
        }
        catch (Throwable throwable) {
            object = MobLog.getInstance();
            ((NLog)object).w(throwable);
            return;
        }
        {
            activityTracker$TrackerArray = new ActivityTracker$Tracker[n10];
            activityTracker$TrackerArray2 = activityTracker$TrackerArray2.toArray(activityTracker$TrackerArray);
        }
        {
            int n11 = activityTracker$TrackerArray2.length;
            activityTracker$TrackerArray = null;
            for (n10 = 0; n10 < n11; ++n10) {
                ActivityTracker$Tracker activityTracker$Tracker = activityTracker$TrackerArray2[n10];
                if (activityTracker$Tracker == null) continue;
                activityTracker$EachTracker.each(activityTracker$Tracker);
            }
        }
    }

    public static ActivityTracker getInstance(Context object) {
        Class<ActivityTracker> clazz = ActivityTracker.class;
        synchronized (clazz) {
            ActivityTracker activityTracker = instance;
            if (activityTracker == null) {
                instance = activityTracker = new ActivityTracker((Context)object);
            }
            object = instance;
            return object;
        }
    }

    private void init(Context object) {
        Object object2 = "mInstrumentation";
        DeviceHelper.getInstance(object);
        object = DeviceHelper.currentActivityThread();
        Object object3 = ReflectHelper.getInstanceField(object, (String)object2);
        ActivityTracker$2 activityTracker$2 = new ActivityTracker$2(this, object3);
        try {
            ReflectHelper.setInstanceField(object, (String)object2, (Object)activityTracker$2);
        }
        catch (Throwable throwable) {
            object2 = MobLog.getInstance();
            ((NLog)object2).w(throwable);
        }
    }

    private void initLevel14(Context context) {
        context = context.getApplicationContext();
        context = (Application)context;
        Object object = new ActivityTracker$1(this);
        try {
            context.registerActivityLifecycleCallbacks((Application.ActivityLifecycleCallbacks)object);
        }
        catch (Throwable throwable) {
            object = MobLog.getInstance();
            ((NLog)object).w(throwable);
        }
    }

    private void onCreated(Activity activity, Bundle bundle) {
        ActivityTracker$3 activityTracker$3 = new ActivityTracker$3(this, activity, bundle);
        this.eachTracker(activityTracker$3);
    }

    private void onDestroyed(Activity activity) {
        ActivityTracker$8 activityTracker$8 = new ActivityTracker$8(this, activity);
        this.eachTracker(activityTracker$8);
    }

    private void onPaused(Activity activity) {
        ActivityTracker$6 activityTracker$6 = new ActivityTracker$6(this, activity);
        this.eachTracker(activityTracker$6);
    }

    private void onResumed(Activity activity) {
        ActivityTracker$5 activityTracker$5 = new ActivityTracker$5(this, activity);
        this.eachTracker(activityTracker$5);
    }

    private void onSaveInstanceState(Activity activity, Bundle bundle) {
        ActivityTracker$9 activityTracker$9 = new ActivityTracker$9(this, activity, bundle);
        this.eachTracker(activityTracker$9);
    }

    private void onStarted(Activity activity) {
        ActivityTracker$4 activityTracker$4 = new ActivityTracker$4(this, activity);
        this.eachTracker(activityTracker$4);
    }

    private void onStopped(Activity activity) {
        ActivityTracker$7 activityTracker$7 = new ActivityTracker$7(this, activity);
        this.eachTracker(activityTracker$7);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void addTracker(ActivityTracker$Tracker activityTracker$Tracker) {
        HashSet hashSet = this.trackers;
        synchronized (hashSet) {
            HashSet hashSet2 = this.trackers;
            hashSet2.add(activityTracker$Tracker);
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void removeTracker(ActivityTracker$Tracker activityTracker$Tracker) {
        HashSet hashSet = this.trackers;
        synchronized (hashSet) {
            HashSet hashSet2 = this.trackers;
            hashSet2.remove(activityTracker$Tracker);
            return;
        }
    }
}

