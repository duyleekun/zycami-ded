/*
 * Decompiled with CFR 0.151.
 */
package com.uber.autodispose.android.lifecycle;

import androidx.lifecycle.GeneratedAdapter;
import androidx.lifecycle.Lifecycle$Event;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MethodCallsLogger;
import com.uber.autodispose.android.lifecycle.LifecycleEventsObservable$ArchLifecycleObserver;

public class LifecycleEventsObservable_ArchLifecycleObserver_LifecycleAdapter
implements GeneratedAdapter {
    public final LifecycleEventsObservable$ArchLifecycleObserver a;

    public LifecycleEventsObservable_ArchLifecycleObserver_LifecycleAdapter(LifecycleEventsObservable$ArchLifecycleObserver archLifecycleObserver) {
        this.a = archLifecycleObserver;
    }

    public void callMethods(LifecycleOwner lifecycleOwner, Lifecycle$Event lifecycle$Event, boolean bl2, MethodCallsLogger methodCallsLogger) {
        String string2;
        boolean bl3;
        if (methodCallsLogger != null) {
            bl3 = true;
        } else {
            bl3 = false;
            string2 = null;
        }
        if (bl2 && (!bl3 || (bl2 = methodCallsLogger.approveCall(string2 = "onStateChange", 4)))) {
            LifecycleEventsObservable$ArchLifecycleObserver lifecycleEventsObservable$ArchLifecycleObserver = this.a;
            lifecycleEventsObservable$ArchLifecycleObserver.onStateChange(lifecycleOwner, lifecycle$Event);
        }
    }
}

