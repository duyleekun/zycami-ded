/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.perf.internal;

import com.google.firebase.perf.internal.PerfMetricValidator;
import com.google.firebase.perf.logging.AndroidLogger;
import com.google.firebase.perf.v1.TraceMetric;
import java.util.Map;

public final class FirebasePerfTraceValidator
extends PerfMetricValidator {
    private static final AndroidLogger logger = AndroidLogger.getInstance();
    private TraceMetric mTraceMetric;

    public FirebasePerfTraceValidator(TraceMetric traceMetric) {
        this.mTraceMetric = traceMetric;
    }

    private boolean areCountersValid(TraceMetric traceMetric) {
        return this.areCountersValid(traceMetric, 0);
    }

    private boolean areCountersValid(TraceMetric object, int n10) {
        boolean bl2;
        int n11;
        if (object == null) {
            return false;
        }
        int n12 = 1;
        if (n10 > n12) {
            logger.warn("Exceed MAX_SUBTRACE_DEEP:1");
            return false;
        }
        Object object2 = ((TraceMetric)object).getCountersMap().entrySet().iterator();
        while ((n11 = object2.hasNext()) != 0) {
            Map.Entry entry = object2.next();
            Object object3 = (String)entry.getKey();
            boolean bl3 = this.isValidCounterId((String)object3);
            if (!bl3) {
                object = logger;
                CharSequence charSequence = new StringBuilder();
                charSequence.append("invalid CounterId:");
                String string2 = (String)entry.getKey();
                charSequence.append(string2);
                charSequence = charSequence.toString();
                ((AndroidLogger)object).warn((String)charSequence);
                return false;
            }
            object3 = (Long)entry.getValue();
            bl3 = this.isValidCounterValue((Long)object3);
            if (bl3) continue;
            object = logger;
            CharSequence charSequence = new StringBuilder();
            charSequence.append("invalid CounterValue:");
            Object v10 = entry.getValue();
            charSequence.append(v10);
            charSequence = charSequence.toString();
            ((AndroidLogger)object).warn((String)charSequence);
            return false;
        }
        object = ((TraceMetric)object).getSubtracesList().iterator();
        while (bl2 = object.hasNext()) {
            object2 = (TraceMetric)object.next();
            bl2 = this.areCountersValid((TraceMetric)object2, n11 = n10 + 1);
            if (bl2) continue;
            return false;
        }
        return n12;
    }

    private boolean hasCounters(TraceMetric object) {
        TraceMetric traceMetric;
        int n10 = ((TraceMetric)object).getCountersCount();
        int n11 = 1;
        if (n10 > 0) {
            n10 = n11;
        } else {
            n10 = 0;
            traceMetric = null;
        }
        if (n10) {
            return n11 != 0;
        }
        object = ((TraceMetric)object).getSubtracesList().iterator();
        while (n10 = object.hasNext()) {
            traceMetric = (TraceMetric)object.next();
            n10 = traceMetric.getCountersCount();
            if (n10 > 0) {
                n10 = n11;
            } else {
                n10 = 0;
                traceMetric = null;
            }
            if (!n10) continue;
            return n11 != 0;
        }
        return false;
    }

    private boolean hasValidAttributes(Map object) {
        boolean bl2;
        object = object.entrySet().iterator();
        while (bl2 = object.hasNext()) {
            String string2 = PerfMetricValidator.validateAttribute((Map.Entry)object.next());
            if (string2 == null) continue;
            logger.warn(string2);
            return false;
        }
        return true;
    }

    private boolean isValidCounterId(String string2) {
        if (string2 == null) {
            return false;
        }
        int n10 = (string2 = string2.trim()).isEmpty();
        if (n10 != 0) {
            logger.warn("counterId is empty");
            return false;
        }
        int n11 = string2.length();
        if (n11 > (n10 = 100)) {
            logger.warn("counterId exceeded max length 100");
            return false;
        }
        return true;
    }

    private boolean isValidCounterValue(Long l10) {
        boolean bl2;
        if (l10 != null) {
            bl2 = true;
        } else {
            bl2 = false;
            l10 = null;
        }
        return bl2;
    }

    private boolean isValidTrace(TraceMetric object, int n10) {
        boolean bl2;
        if (object == null) {
            logger.warn("TraceMetric is null");
            return false;
        }
        int n11 = 1;
        if (n10 > n11) {
            logger.warn("Exceed MAX_SUBTRACE_DEEP:1");
            return false;
        }
        Object object2 = ((TraceMetric)object).getName();
        boolean bl3 = this.isValidTraceId((String)object2);
        if (!bl3) {
            AndroidLogger androidLogger = logger;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("invalid TraceId:");
            object = ((TraceMetric)object).getName();
            stringBuilder.append((String)object);
            object = stringBuilder.toString();
            androidLogger.warn((String)object);
            return false;
        }
        bl3 = this.isValidTraceDuration((TraceMetric)object);
        if (!bl3) {
            AndroidLogger androidLogger = logger;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("invalid TraceDuration:");
            long l10 = ((TraceMetric)object).getDurationUs();
            stringBuilder.append(l10);
            object = stringBuilder.toString();
            androidLogger.warn((String)object);
            return false;
        }
        bl3 = ((TraceMetric)object).hasClientStartTimeUs();
        if (!bl3) {
            logger.warn("clientStartTimeUs is null.");
            return false;
        }
        object2 = ((TraceMetric)object).getSubtracesList().iterator();
        while (bl2 = object2.hasNext()) {
            int n12;
            TraceMetric traceMetric = (TraceMetric)object2.next();
            bl2 = this.isValidTrace(traceMetric, n12 = n10 + 1);
            if (bl2) continue;
            return false;
        }
        boolean bl4 = this.hasValidAttributes((Map)(object = ((TraceMetric)object).getCustomAttributesMap()));
        if (!bl4) {
            return false;
        }
        return n11;
    }

    private boolean isValidTraceDuration(TraceMetric traceMetric) {
        long l10;
        long l11;
        long l12;
        int n10;
        if (traceMetric != null && (n10 = (l12 = (l11 = traceMetric.getDurationUs()) - (l10 = 0L)) == 0L ? 0 : (l12 < 0L ? -1 : 1)) > 0) {
            n10 = 1;
        } else {
            n10 = 0;
            traceMetric = null;
        }
        return n10 != 0;
    }

    private boolean isValidTraceId(String string2) {
        int n10;
        boolean bl2 = false;
        if (string2 == null) {
            return false;
        }
        int n11 = (string2 = string2.trim()).isEmpty();
        if (n11 == 0 && (n10 = string2.length()) <= (n11 = 100)) {
            bl2 = true;
        }
        return bl2;
    }

    public boolean isValidPerfMetric() {
        Object object = this.mTraceMetric;
        boolean bl2 = this.isValidTrace((TraceMetric)object, 0);
        if (!bl2) {
            object = logger;
            CharSequence charSequence = new StringBuilder();
            charSequence.append("Invalid Trace:");
            String string2 = this.mTraceMetric.getName();
            charSequence.append(string2);
            charSequence = charSequence.toString();
            ((AndroidLogger)object).warn((String)charSequence);
            return false;
        }
        object = this.mTraceMetric;
        bl2 = this.hasCounters((TraceMetric)object);
        if (bl2 && !(bl2 = this.areCountersValid((TraceMetric)(object = this.mTraceMetric)))) {
            object = logger;
            CharSequence charSequence = new StringBuilder();
            charSequence.append("Invalid Counters for Trace:");
            String string3 = this.mTraceMetric.getName();
            charSequence.append(string3);
            charSequence = charSequence.toString();
            ((AndroidLogger)object).warn((String)charSequence);
            return false;
        }
        return true;
    }
}

