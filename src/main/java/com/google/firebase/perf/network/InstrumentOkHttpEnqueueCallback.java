/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.perf.network;

import com.google.firebase.perf.impl.NetworkRequestMetricBuilder;
import com.google.firebase.perf.network.FirebasePerfOkHttpClient;
import com.google.firebase.perf.network.NetworkRequestMetricBuilderUtil;
import com.google.firebase.perf.transport.TransportManager;
import com.google.firebase.perf.util.Timer;
import g.a0;
import g.c0;
import g.e;
import g.f;
import g.t;
import java.io.IOException;

public class InstrumentOkHttpEnqueueCallback
implements f {
    private final NetworkRequestMetricBuilder mBuilder;
    private final f mCallback;
    private final long mStartTimeMicros;
    private final Timer mTimer;

    public InstrumentOkHttpEnqueueCallback(f object, TransportManager transportManager, Timer timer, long l10) {
        this.mCallback = object;
        this.mBuilder = object = NetworkRequestMetricBuilder.builder(transportManager);
        this.mStartTimeMicros = l10;
        this.mTimer = timer;
    }

    public void onFailure(e e10, IOException iOException) {
        Object object = e10.C();
        if (object != null) {
            Object object2 = ((a0)object).q();
            if (object2 != null) {
                NetworkRequestMetricBuilder networkRequestMetricBuilder = this.mBuilder;
                object2 = ((t)object2).a0().toString();
                networkRequestMetricBuilder.setUrl((String)object2);
            }
            if ((object2 = ((a0)object).m()) != null) {
                object2 = this.mBuilder;
                object = ((a0)object).m();
                ((NetworkRequestMetricBuilder)object2).setHttpMethod((String)object);
            }
        }
        object = this.mBuilder;
        long l10 = this.mStartTimeMicros;
        ((NetworkRequestMetricBuilder)object).setRequestStartTimeMicros(l10);
        object = this.mBuilder;
        l10 = this.mTimer.getDurationMicros();
        ((NetworkRequestMetricBuilder)object).setTimeToResponseCompletedMicros(l10);
        NetworkRequestMetricBuilderUtil.logError(this.mBuilder);
        this.mCallback.onFailure(e10, iOException);
    }

    public void onResponse(e e10, c0 c02) {
        long l10 = this.mTimer.getDurationMicros();
        NetworkRequestMetricBuilder networkRequestMetricBuilder = this.mBuilder;
        long l11 = this.mStartTimeMicros;
        FirebasePerfOkHttpClient.sendNetworkMetric(c02, networkRequestMetricBuilder, l11, l10);
        this.mCallback.onResponse(e10, c02);
    }
}

