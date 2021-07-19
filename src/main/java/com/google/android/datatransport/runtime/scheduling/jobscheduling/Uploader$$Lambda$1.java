/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.Uploader;

public final class Uploader$$Lambda$1
implements Runnable {
    private final Uploader arg$1;
    private final TransportContext arg$2;
    private final int arg$3;
    private final Runnable arg$4;

    private Uploader$$Lambda$1(Uploader uploader, TransportContext transportContext, int n10, Runnable runnable) {
        this.arg$1 = uploader;
        this.arg$2 = transportContext;
        this.arg$3 = n10;
        this.arg$4 = runnable;
    }

    public static Runnable lambdaFactory$(Uploader uploader, TransportContext transportContext, int n10, Runnable runnable) {
        Uploader$$Lambda$1 uploader$$Lambda$1 = new Uploader$$Lambda$1(uploader, transportContext, n10, runnable);
        return uploader$$Lambda$1;
    }

    public void run() {
        Uploader uploader = this.arg$1;
        TransportContext transportContext = this.arg$2;
        int n10 = this.arg$3;
        Runnable runnable = this.arg$4;
        Uploader.lambda$upload$1(uploader, transportContext, n10, runnable);
    }
}

