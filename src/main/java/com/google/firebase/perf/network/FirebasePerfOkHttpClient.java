/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.perf.network;

import com.google.firebase.perf.impl.NetworkRequestMetricBuilder;
import com.google.firebase.perf.network.InstrumentOkHttpEnqueueCallback;
import com.google.firebase.perf.network.NetworkRequestMetricBuilderUtil;
import com.google.firebase.perf.transport.TransportManager;
import com.google.firebase.perf.util.Timer;
import g.a0;
import g.b0;
import g.c0;
import g.d0;
import g.e;
import g.f;
import g.t;
import g.v;
import java.io.IOException;

public class FirebasePerfOkHttpClient {
    private FirebasePerfOkHttpClient() {
    }

    public static void enqueue(e e10, f f10) {
        Timer timer = new Timer();
        long l10 = timer.getMicros();
        TransportManager transportManager = TransportManager.getInstance();
        InstrumentOkHttpEnqueueCallback instrumentOkHttpEnqueueCallback = new InstrumentOkHttpEnqueueCallback(f10, transportManager, timer, l10);
        e10.S(instrumentOkHttpEnqueueCallback);
    }

    public static c0 execute(e object) {
        Object object2;
        c0 c02;
        NetworkRequestMetricBuilder networkRequestMetricBuilder = NetworkRequestMetricBuilder.builder(TransportManager.getInstance());
        Timer timer = new Timer();
        long l10 = timer.getMicros();
        try {
            c02 = object.execute();
        }
        catch (IOException iOException) {
            object = object.C();
            if (object != null) {
                object2 = ((a0)object).q();
                if (object2 != null) {
                    object2 = ((t)object2).a0().toString();
                    networkRequestMetricBuilder.setUrl((String)object2);
                }
                if ((object2 = ((a0)object).m()) != null) {
                    object = ((a0)object).m();
                    networkRequestMetricBuilder.setHttpMethod((String)object);
                }
            }
            networkRequestMetricBuilder.setRequestStartTimeMicros(l10);
            long l11 = timer.getDurationMicros();
            networkRequestMetricBuilder.setTimeToResponseCompletedMicros(l11);
            NetworkRequestMetricBuilderUtil.logError(networkRequestMetricBuilder);
            throw iOException;
        }
        long l12 = timer.getDurationMicros();
        c0 c03 = c02;
        object2 = networkRequestMetricBuilder;
        FirebasePerfOkHttpClient.sendNetworkMetric(c02, networkRequestMetricBuilder, l10, l12);
        return c02;
    }

    public static void sendNetworkMetric(c0 c02, NetworkRequestMetricBuilder networkRequestMetricBuilder, long l10, long l11) {
        long l12;
        long l13;
        long l14;
        Object object = c02.L0();
        if (object == null) {
            return;
        }
        Object object2 = ((a0)object).q().a0().toString();
        networkRequestMetricBuilder.setUrl((String)object2);
        object2 = ((a0)object).m();
        networkRequestMetricBuilder.setHttpMethod((String)object2);
        object2 = ((a0)object).f();
        long l15 = -1;
        if (object2 != null && (l14 = (l13 = (l12 = ((b0)(object = ((a0)object).f())).contentLength()) - l15) == 0L ? 0 : (l13 < 0L ? -1 : 1)) != false) {
            networkRequestMetricBuilder.setRequestPayloadBytes(l12);
        }
        if ((object = c02.r0()) != null) {
            long l16 = ((d0)object).contentLength();
            long l17 = l16 - l15;
            Object object3 = l17 == 0L ? 0 : (l17 < 0L ? -1 : 1);
            if (object3 != false) {
                networkRequestMetricBuilder.setResponsePayloadBytes(l16);
            }
            if ((object = ((d0)object).contentType()) != null) {
                object = ((v)object).toString();
                networkRequestMetricBuilder.setResponseContentType((String)object);
            }
        }
        int n10 = c02.v0();
        networkRequestMetricBuilder.setHttpResponseCode(n10);
        networkRequestMetricBuilder.setRequestStartTimeMicros(l10);
        networkRequestMetricBuilder.setTimeToResponseCompletedMicros(l11);
        networkRequestMetricBuilder.build();
    }
}

