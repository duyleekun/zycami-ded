/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 */
package androidx.lifecycle;

import android.app.Activity;
import androidx.lifecycle.EmptyActivityLifecycleCallbacks;
import androidx.lifecycle.ProcessLifecycleOwner$3;

public class ProcessLifecycleOwner$3$1
extends EmptyActivityLifecycleCallbacks {
    public final /* synthetic */ ProcessLifecycleOwner$3 this$1;

    public ProcessLifecycleOwner$3$1(ProcessLifecycleOwner$3 var1_1) {
        this.this$1 = var1_1;
    }

    public void onActivityPostResumed(Activity activity) {
        this.this$1.this$0.activityResumed();
    }

    public void onActivityPostStarted(Activity activity) {
        this.this$1.this$0.activityStarted();
    }
}

