/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.datatransport.runtime.scheduling;

import com.google.android.datatransport.TransportScheduleCallback;
import com.google.android.datatransport.runtime.EventInternal;
import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.scheduling.DefaultScheduler;

public final class DefaultScheduler$$Lambda$1
implements Runnable {
    private final DefaultScheduler arg$1;
    private final TransportContext arg$2;
    private final TransportScheduleCallback arg$3;
    private final EventInternal arg$4;

    private DefaultScheduler$$Lambda$1(DefaultScheduler defaultScheduler, TransportContext transportContext, TransportScheduleCallback transportScheduleCallback, EventInternal eventInternal) {
        this.arg$1 = defaultScheduler;
        this.arg$2 = transportContext;
        this.arg$3 = transportScheduleCallback;
        this.arg$4 = eventInternal;
    }

    public static Runnable lambdaFactory$(DefaultScheduler defaultScheduler, TransportContext transportContext, TransportScheduleCallback transportScheduleCallback, EventInternal eventInternal) {
        DefaultScheduler$$Lambda$1 defaultScheduler$$Lambda$1 = new DefaultScheduler$$Lambda$1(defaultScheduler, transportContext, transportScheduleCallback, eventInternal);
        return defaultScheduler$$Lambda$1;
    }

    public void run() {
        DefaultScheduler defaultScheduler = this.arg$1;
        TransportContext transportContext = this.arg$2;
        TransportScheduleCallback transportScheduleCallback = this.arg$3;
        EventInternal eventInternal = this.arg$4;
        DefaultScheduler.lambda$schedule$1(defaultScheduler, transportContext, transportScheduleCallback, eventInternal);
    }
}

