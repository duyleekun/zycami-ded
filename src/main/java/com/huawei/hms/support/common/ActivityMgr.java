/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.Application
 *  android.app.Application$ActivityLifecycleCallbacks
 *  android.os.Bundle
 */
package com.huawei.hms.support.common;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.huawei.hms.support.log.HMSLog;
import java.lang.ref.WeakReference;

public final class ActivityMgr
implements Application.ActivityLifecycleCallbacks {
    public static final ActivityMgr INST;
    public WeakReference a;

    static {
        ActivityMgr activityMgr;
        INST = activityMgr = new ActivityMgr();
    }

    public static String a(Object object) {
        if (object == null) {
            object = "null";
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            String string2 = object.getClass().getName();
            stringBuilder.append(string2);
            char c10 = '@';
            stringBuilder.append(c10);
            int n10 = object.hashCode();
            object = Integer.toHexString(n10);
            stringBuilder.append((String)object);
            object = stringBuilder.toString();
        }
        return object;
    }

    public Activity getCurrentActivity() {
        Object object = this.a;
        String string2 = "ActivityMgr";
        if (object == null) {
            object = new StringBuilder();
            ((StringBuilder)object).append("mCurrentActivity is ");
            WeakReference weakReference = this.a;
            ((StringBuilder)object).append(weakReference);
            object = ((StringBuilder)object).toString();
            HMSLog.i(string2, (String)object);
            return null;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("mCurrentActivity.get() is ");
        Object t10 = this.a.get();
        ((StringBuilder)object).append(t10);
        object = ((StringBuilder)object).toString();
        HMSLog.i(string2, (String)object);
        return (Activity)this.a.get();
    }

    public void init(Application application) {
        Object object = "ActivityMgr";
        String string2 = "init";
        HMSLog.d((String)object, string2);
        if (application == null) {
            HMSLog.w((String)object, "init failed for app is null");
            return;
        }
        object = INST;
        application.unregisterActivityLifecycleCallbacks((Application.ActivityLifecycleCallbacks)object);
        application.registerActivityLifecycleCallbacks((Application.ActivityLifecycleCallbacks)object);
    }

    public void onActivityCreated(Activity activity, Bundle object) {
        object = new StringBuilder();
        ((StringBuilder)object).append("onCreated:");
        String string2 = ActivityMgr.a(activity);
        ((StringBuilder)object).append(string2);
        object = ((StringBuilder)object).toString();
        HMSLog.d("ActivityMgr", (String)object);
        this.a = object = new WeakReference(activity);
    }

    public void onActivityDestroyed(Activity activity) {
    }

    public void onActivityPaused(Activity activity) {
    }

    public void onActivityResumed(Activity activity) {
        WeakReference<Activity> weakReference = new WeakReference<Activity>();
        ((StringBuilder)((Object)weakReference)).append("onResumed:");
        String string2 = ActivityMgr.a(activity);
        ((StringBuilder)((Object)weakReference)).append(string2);
        weakReference = ((StringBuilder)((Object)weakReference)).toString();
        HMSLog.d("ActivityMgr", (String)((Object)weakReference));
        this.a = weakReference = new WeakReference<Activity>(activity);
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onActivityStarted(Activity activity) {
        WeakReference<Activity> weakReference = new WeakReference<Activity>();
        ((StringBuilder)((Object)weakReference)).append("onStarted:");
        String string2 = ActivityMgr.a(activity);
        ((StringBuilder)((Object)weakReference)).append(string2);
        weakReference = ((StringBuilder)((Object)weakReference)).toString();
        HMSLog.d("ActivityMgr", (String)((Object)weakReference));
        this.a = weakReference = new WeakReference<Activity>(activity);
    }

    public void onActivityStopped(Activity activity) {
    }
}

