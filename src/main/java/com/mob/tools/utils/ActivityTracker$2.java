/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.Instrumentation
 *  android.os.Bundle
 */
package com.mob.tools.utils;

import android.app.Activity;
import android.app.Instrumentation;
import android.os.Bundle;
import com.mob.tools.utils.ActivityTracker;
import com.mob.tools.utils.ReflectHelper;

public class ActivityTracker$2
extends Instrumentation {
    public final /* synthetic */ ActivityTracker this$0;
    public final /* synthetic */ Object val$origin;

    public ActivityTracker$2(ActivityTracker activityTracker, Object object) {
        this.this$0 = activityTracker;
        this.val$origin = object;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void callActivityOnCreate(Activity activity, Bundle bundle) {
        Object object = this.val$origin;
        if (object != null) {
            String string2 = "callActivityOnCreate";
            int n10 = 2;
            try {
                Object[] objectArray = new Object[n10];
                int n11 = 0;
                objectArray[0] = activity;
                n11 = 1;
                objectArray[n11] = bundle;
                ReflectHelper.invokeInstanceMethod(object, string2, objectArray);
            }
            catch (Throwable throwable) {}
        }
        super.callActivityOnCreate(activity, bundle);
        ActivityTracker.access$000(this.this$0, activity, bundle);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void callActivityOnDestroy(Activity activity) {
        Object object = this.val$origin;
        if (object != null) {
            String string2 = "callActivityOnDestroy";
            int n10 = 1;
            try {
                Object[] objectArray = new Object[n10];
                objectArray[0] = activity;
                ReflectHelper.invokeInstanceMethod(object, string2, objectArray);
            }
            catch (Throwable throwable) {}
        }
        super.callActivityOnDestroy(activity);
        ActivityTracker.access$500(this.this$0, activity);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void callActivityOnPause(Activity activity) {
        Object object = this.val$origin;
        if (object != null) {
            String string2 = "callActivityOnPause";
            int n10 = 1;
            try {
                Object[] objectArray = new Object[n10];
                objectArray[0] = activity;
                ReflectHelper.invokeInstanceMethod(object, string2, objectArray);
            }
            catch (Throwable throwable) {}
        }
        super.callActivityOnPause(activity);
        ActivityTracker.access$300(this.this$0, activity);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void callActivityOnResume(Activity activity) {
        Object object = this.val$origin;
        if (object != null) {
            String string2 = "callActivityOnResume";
            int n10 = 1;
            try {
                Object[] objectArray = new Object[n10];
                objectArray[0] = activity;
                ReflectHelper.invokeInstanceMethod(object, string2, objectArray);
            }
            catch (Throwable throwable) {}
        }
        super.callActivityOnResume(activity);
        ActivityTracker.access$200(this.this$0, activity);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void callActivityOnSaveInstanceState(Activity activity, Bundle bundle) {
        Object object = this.val$origin;
        if (object != null) {
            String string2 = "callActivityOnSaveInstanceState";
            int n10 = 2;
            try {
                Object[] objectArray = new Object[n10];
                int n11 = 0;
                objectArray[0] = activity;
                n11 = 1;
                objectArray[n11] = bundle;
                ReflectHelper.invokeInstanceMethod(object, string2, objectArray);
            }
            catch (Throwable throwable) {}
        }
        super.callActivityOnSaveInstanceState(activity, bundle);
        ActivityTracker.access$600(this.this$0, activity, bundle);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void callActivityOnStart(Activity activity) {
        Object object = this.val$origin;
        if (object != null) {
            String string2 = "callActivityOnStart";
            int n10 = 1;
            try {
                Object[] objectArray = new Object[n10];
                objectArray[0] = activity;
                ReflectHelper.invokeInstanceMethod(object, string2, objectArray);
            }
            catch (Throwable throwable) {}
        }
        super.callActivityOnStart(activity);
        ActivityTracker.access$100(this.this$0, activity);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void callActivityOnStop(Activity activity) {
        Object object = this.val$origin;
        if (object != null) {
            String string2 = "callActivityOnStop";
            int n10 = 1;
            try {
                Object[] objectArray = new Object[n10];
                objectArray[0] = activity;
                ReflectHelper.invokeInstanceMethod(object, string2, objectArray);
            }
            catch (Throwable throwable) {}
        }
        super.callActivityOnStop(activity);
        ActivityTracker.access$400(this.this$0, activity);
    }
}

