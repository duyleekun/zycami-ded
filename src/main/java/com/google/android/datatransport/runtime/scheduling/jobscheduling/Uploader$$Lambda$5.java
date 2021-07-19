/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.Uploader;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard$CriticalSection;

public final class Uploader$$Lambda$5
implements SynchronizationGuard$CriticalSection {
    private final Uploader arg$1;
    private final TransportContext arg$2;
    private final int arg$3;

    private Uploader$$Lambda$5(Uploader uploader, TransportContext transportContext, int n10) {
        this.arg$1 = uploader;
        this.arg$2 = transportContext;
        this.arg$3 = n10;
    }

    public static SynchronizationGuard$CriticalSection lambdaFactory$(Uploader uploader, TransportContext transportContext, int n10) {
        Uploader$$Lambda$5 uploader$$Lambda$5 = new Uploader$$Lambda$5(uploader, transportContext, n10);
        return uploader$$Lambda$5;
    }

    public Object execute() {
        Uploader uploader = this.arg$1;
        TransportContext transportContext = this.arg$2;
        int n10 = this.arg$3;
        return Uploader.lambda$upload$0(uploader, transportContext, n10);
    }
}

