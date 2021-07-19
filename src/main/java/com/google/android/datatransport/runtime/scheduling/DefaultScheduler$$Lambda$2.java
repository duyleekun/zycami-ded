/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.datatransport.runtime.scheduling;

import com.google.android.datatransport.runtime.EventInternal;
import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.scheduling.DefaultScheduler;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard$CriticalSection;

public final class DefaultScheduler$$Lambda$2
implements SynchronizationGuard$CriticalSection {
    private final DefaultScheduler arg$1;
    private final TransportContext arg$2;
    private final EventInternal arg$3;

    private DefaultScheduler$$Lambda$2(DefaultScheduler defaultScheduler, TransportContext transportContext, EventInternal eventInternal) {
        this.arg$1 = defaultScheduler;
        this.arg$2 = transportContext;
        this.arg$3 = eventInternal;
    }

    public static SynchronizationGuard$CriticalSection lambdaFactory$(DefaultScheduler defaultScheduler, TransportContext transportContext, EventInternal eventInternal) {
        DefaultScheduler$$Lambda$2 defaultScheduler$$Lambda$2 = new DefaultScheduler$$Lambda$2(defaultScheduler, transportContext, eventInternal);
        return defaultScheduler$$Lambda$2;
    }

    public Object execute() {
        DefaultScheduler defaultScheduler = this.arg$1;
        TransportContext transportContext = this.arg$2;
        EventInternal eventInternal = this.arg$3;
        return DefaultScheduler.lambda$schedule$0(defaultScheduler, transportContext, eventInternal);
    }
}

