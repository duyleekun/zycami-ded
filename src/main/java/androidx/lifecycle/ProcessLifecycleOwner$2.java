/*
 * Decompiled with CFR 0.151.
 */
package androidx.lifecycle;

import androidx.lifecycle.ProcessLifecycleOwner;
import androidx.lifecycle.ReportFragment$ActivityInitializationListener;

public class ProcessLifecycleOwner$2
implements ReportFragment$ActivityInitializationListener {
    public final /* synthetic */ ProcessLifecycleOwner this$0;

    public ProcessLifecycleOwner$2(ProcessLifecycleOwner processLifecycleOwner) {
        this.this$0 = processLifecycleOwner;
    }

    public void onCreate() {
    }

    public void onResume() {
        this.this$0.activityResumed();
    }

    public void onStart() {
        this.this$0.activityStarted();
    }
}

