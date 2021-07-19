/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.datatransport.runtime;

import com.google.android.datatransport.TransportScheduleCallback;
import com.google.android.datatransport.runtime.TransportImpl;

public final class TransportImpl$$Lambda$1
implements TransportScheduleCallback {
    private static final TransportImpl$$Lambda$1 instance;

    static {
        TransportImpl$$Lambda$1 transportImpl$$Lambda$1;
        instance = transportImpl$$Lambda$1 = new TransportImpl$$Lambda$1();
    }

    private TransportImpl$$Lambda$1() {
    }

    public static TransportScheduleCallback lambdaFactory$() {
        return instance;
    }

    public void onSchedule(Exception exception) {
        TransportImpl.lambda$send$0(exception);
    }
}

