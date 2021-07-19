/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.Uploader;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard$CriticalSection;

public final class Uploader$$Lambda$2
implements SynchronizationGuard$CriticalSection {
    private final Uploader arg$1;
    private final TransportContext arg$2;

    private Uploader$$Lambda$2(Uploader uploader, TransportContext transportContext) {
        this.arg$1 = uploader;
        this.arg$2 = transportContext;
    }

    public static SynchronizationGuard$CriticalSection lambdaFactory$(Uploader uploader, TransportContext transportContext) {
        Uploader$$Lambda$2 uploader$$Lambda$2 = new Uploader$$Lambda$2(uploader, transportContext);
        return uploader$$Lambda$2;
    }

    public Object execute() {
        Uploader uploader = this.arg$1;
        TransportContext transportContext = this.arg$2;
        return Uploader.lambda$logAndUpdateState$2(uploader, transportContext);
    }
}

