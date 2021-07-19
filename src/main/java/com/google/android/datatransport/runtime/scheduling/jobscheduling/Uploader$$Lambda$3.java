/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.backends.BackendResponse;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.Uploader;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard$CriticalSection;

public final class Uploader$$Lambda$3
implements SynchronizationGuard$CriticalSection {
    private final Uploader arg$1;
    private final BackendResponse arg$2;
    private final Iterable arg$3;
    private final TransportContext arg$4;
    private final int arg$5;

    private Uploader$$Lambda$3(Uploader uploader, BackendResponse backendResponse, Iterable iterable, TransportContext transportContext, int n10) {
        this.arg$1 = uploader;
        this.arg$2 = backendResponse;
        this.arg$3 = iterable;
        this.arg$4 = transportContext;
        this.arg$5 = n10;
    }

    public static SynchronizationGuard$CriticalSection lambdaFactory$(Uploader uploader, BackendResponse backendResponse, Iterable iterable, TransportContext transportContext, int n10) {
        Uploader$$Lambda$3 uploader$$Lambda$3 = new Uploader$$Lambda$3(uploader, backendResponse, iterable, transportContext, n10);
        return uploader$$Lambda$3;
    }

    public Object execute() {
        Uploader uploader = this.arg$1;
        BackendResponse backendResponse = this.arg$2;
        Iterable iterable = this.arg$3;
        TransportContext transportContext = this.arg$4;
        int n10 = this.arg$5;
        return Uploader.lambda$logAndUpdateState$3(uploader, backendResponse, iterable, transportContext, n10);
    }
}

