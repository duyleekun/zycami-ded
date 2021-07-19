/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.perf.metrics;

import com.google.firebase.perf.internal.PerfSession;
import com.google.firebase.perf.metrics.Counter;
import com.google.firebase.perf.metrics.Trace;
import com.google.firebase.perf.util.Timer;
import com.google.firebase.perf.v1.TraceMetric;
import com.google.firebase.perf.v1.TraceMetric$Builder;
import java.util.Arrays;
import java.util.Map;

public class TraceMetricBuilder {
    private final Trace mTrace;

    public TraceMetricBuilder(Trace trace) {
        this.mTrace = trace;
    }

    public TraceMetric build() {
        Object object;
        boolean bl2;
        TraceMetric$Builder traceMetric$Builder = TraceMetric.newBuilder();
        Object object2 = this.mTrace.getName();
        traceMetric$Builder = traceMetric$Builder.setName((String)object2);
        long l10 = this.mTrace.getStartTime().getMicros();
        traceMetric$Builder = traceMetric$Builder.setClientStartTimeUs(l10);
        object2 = this.mTrace.getStartTime();
        Object object3 = this.mTrace.getEndTime();
        l10 = object2.getDurationMicros((Timer)object3);
        traceMetric$Builder = traceMetric$Builder.setDurationUs(l10);
        object2 = this.mTrace.getCounters().values().iterator();
        while (bl2 = object2.hasNext()) {
            object3 = (Counter)object2.next();
            object = ((Counter)object3).getName();
            long l11 = ((Counter)object3).getCount();
            traceMetric$Builder.putCounters((String)object, l11);
        }
        object2 = this.mTrace.getSubtraces();
        bl2 = object2.isEmpty();
        if (!bl2) {
            object2 = object2.iterator();
            while (bl2 = object2.hasNext()) {
                object3 = (Trace)object2.next();
                object = new TraceMetricBuilder((Trace)object3);
                object3 = ((TraceMetricBuilder)object).build();
                traceMetric$Builder.addSubtraces((TraceMetric)object3);
            }
        }
        object2 = this.mTrace.getAttributes();
        traceMetric$Builder.putAllCustomAttributes((Map)object2);
        object2 = PerfSession.buildAndSort(this.mTrace.getSessions());
        if (object2 != null) {
            object2 = Arrays.asList(object2);
            traceMetric$Builder.addAllPerfSessions((Iterable)object2);
        }
        return (TraceMetric)traceMetric$Builder.build();
    }
}

