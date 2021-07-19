/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.os.Bundle
 */
package com.mob.tools.utils;

import android.app.Activity;
import android.os.Bundle;
import com.mob.tools.utils.ActivityTracker;
import com.mob.tools.utils.ActivityTracker$EachTracker;
import com.mob.tools.utils.ActivityTracker$Tracker;

public class ActivityTracker$3
implements ActivityTracker$EachTracker {
    public final /* synthetic */ ActivityTracker this$0;
    public final /* synthetic */ Activity val$activity;
    public final /* synthetic */ Bundle val$savedInstanceState;

    public ActivityTracker$3(ActivityTracker activityTracker, Activity activity, Bundle bundle) {
        this.this$0 = activityTracker;
        this.val$activity = activity;
        this.val$savedInstanceState = bundle;
    }

    public void each(ActivityTracker$Tracker activityTracker$Tracker) {
        Activity activity = this.val$activity;
        Bundle bundle = this.val$savedInstanceState;
        activityTracker$Tracker.onCreated(activity, bundle);
    }
}

