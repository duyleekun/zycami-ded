/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.Application$ActivityLifecycleCallbacks
 *  android.os.Build$VERSION
 *  android.os.Bundle
 */
package androidx.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.os.Build;
import android.os.Bundle;
import androidx.lifecycle.EmptyActivityLifecycleCallbacks;
import androidx.lifecycle.ProcessLifecycleOwner;
import androidx.lifecycle.ProcessLifecycleOwner$3$1;
import androidx.lifecycle.ReportFragment;
import androidx.lifecycle.ReportFragment$ActivityInitializationListener;

public class ProcessLifecycleOwner$3
extends EmptyActivityLifecycleCallbacks {
    public final /* synthetic */ ProcessLifecycleOwner this$0;

    public ProcessLifecycleOwner$3(ProcessLifecycleOwner processLifecycleOwner) {
        this.this$0 = processLifecycleOwner;
    }

    public void onActivityCreated(Activity object, Bundle object2) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 29;
        if (n10 < n11) {
            object = ReportFragment.get((Activity)object);
            object2 = this.this$0.mInitializationListener;
            ((ReportFragment)((Object)object)).setProcessListener((ReportFragment$ActivityInitializationListener)object2);
        }
    }

    public void onActivityPaused(Activity activity) {
        this.this$0.activityPaused();
    }

    public void onActivityPreCreated(Activity activity, Bundle object) {
        object = new ProcessLifecycleOwner$3$1(this);
        activity.registerActivityLifecycleCallbacks((Application.ActivityLifecycleCallbacks)object);
    }

    public void onActivityStopped(Activity activity) {
        this.this$0.activityStopped();
    }
}

