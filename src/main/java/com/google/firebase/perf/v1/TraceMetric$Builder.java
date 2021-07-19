/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.perf.v1;

import com.google.firebase.perf.v1.PerfSession;
import com.google.firebase.perf.v1.PerfSession$Builder;
import com.google.firebase.perf.v1.TraceMetric;
import com.google.firebase.perf.v1.TraceMetric$1;
import com.google.firebase.perf.v1.TraceMetricOrBuilder;
import com.google.protobuf.ByteString;
import com.google.protobuf.GeneratedMessageLite$Builder;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public final class TraceMetric$Builder
extends GeneratedMessageLite$Builder
implements TraceMetricOrBuilder {
    private TraceMetric$Builder() {
        TraceMetric traceMetric = TraceMetric.access$000();
        super(traceMetric);
    }

    public /* synthetic */ TraceMetric$Builder(TraceMetric$1 traceMetric$1) {
        this();
    }

    public TraceMetric$Builder addAllPerfSessions(Iterable iterable) {
        this.copyOnWrite();
        TraceMetric.access$2100((TraceMetric)this.instance, iterable);
        return this;
    }

    public TraceMetric$Builder addAllSubtraces(Iterable iterable) {
        this.copyOnWrite();
        TraceMetric.access$1400((TraceMetric)this.instance, iterable);
        return this;
    }

    public TraceMetric$Builder addPerfSessions(int n10, PerfSession$Builder perfSessionOrBuilder) {
        this.copyOnWrite();
        TraceMetric traceMetric = (TraceMetric)this.instance;
        perfSessionOrBuilder = (PerfSession)perfSessionOrBuilder.build();
        TraceMetric.access$2000(traceMetric, n10, (PerfSession)perfSessionOrBuilder);
        return this;
    }

    public TraceMetric$Builder addPerfSessions(int n10, PerfSession perfSession) {
        this.copyOnWrite();
        TraceMetric.access$2000((TraceMetric)this.instance, n10, perfSession);
        return this;
    }

    public TraceMetric$Builder addPerfSessions(PerfSession$Builder perfSessionOrBuilder) {
        this.copyOnWrite();
        TraceMetric traceMetric = (TraceMetric)this.instance;
        perfSessionOrBuilder = (PerfSession)perfSessionOrBuilder.build();
        TraceMetric.access$1900(traceMetric, (PerfSession)perfSessionOrBuilder);
        return this;
    }

    public TraceMetric$Builder addPerfSessions(PerfSession perfSession) {
        this.copyOnWrite();
        TraceMetric.access$1900((TraceMetric)this.instance, perfSession);
        return this;
    }

    public TraceMetric$Builder addSubtraces(int n10, TraceMetric$Builder traceMetricOrBuilder) {
        this.copyOnWrite();
        TraceMetric traceMetric = (TraceMetric)this.instance;
        traceMetricOrBuilder = (TraceMetric)traceMetricOrBuilder.build();
        TraceMetric.access$1300(traceMetric, n10, (TraceMetric)traceMetricOrBuilder);
        return this;
    }

    public TraceMetric$Builder addSubtraces(int n10, TraceMetric traceMetric) {
        this.copyOnWrite();
        TraceMetric.access$1300((TraceMetric)this.instance, n10, traceMetric);
        return this;
    }

    public TraceMetric$Builder addSubtraces(TraceMetric$Builder traceMetricOrBuilder) {
        this.copyOnWrite();
        TraceMetric traceMetric = (TraceMetric)this.instance;
        traceMetricOrBuilder = (TraceMetric)traceMetricOrBuilder.build();
        TraceMetric.access$1200(traceMetric, (TraceMetric)traceMetricOrBuilder);
        return this;
    }

    public TraceMetric$Builder addSubtraces(TraceMetric traceMetric) {
        this.copyOnWrite();
        TraceMetric.access$1200((TraceMetric)this.instance, traceMetric);
        return this;
    }

    public TraceMetric$Builder clearClientStartTimeUs() {
        this.copyOnWrite();
        TraceMetric.access$700((TraceMetric)this.instance);
        return this;
    }

    public TraceMetric$Builder clearCounters() {
        this.copyOnWrite();
        TraceMetric.access$1000((TraceMetric)this.instance).clear();
        return this;
    }

    public TraceMetric$Builder clearCustomAttributes() {
        this.copyOnWrite();
        TraceMetric.access$1700((TraceMetric)this.instance).clear();
        return this;
    }

    public TraceMetric$Builder clearDurationUs() {
        this.copyOnWrite();
        TraceMetric.access$900((TraceMetric)this.instance);
        return this;
    }

    public TraceMetric$Builder clearIsAuto() {
        this.copyOnWrite();
        TraceMetric.access$500((TraceMetric)this.instance);
        return this;
    }

    public TraceMetric$Builder clearName() {
        this.copyOnWrite();
        TraceMetric.access$200((TraceMetric)this.instance);
        return this;
    }

    public TraceMetric$Builder clearPerfSessions() {
        this.copyOnWrite();
        TraceMetric.access$2200((TraceMetric)this.instance);
        return this;
    }

    public TraceMetric$Builder clearSubtraces() {
        this.copyOnWrite();
        TraceMetric.access$1500((TraceMetric)this.instance);
        return this;
    }

    public boolean containsCounters(String string2) {
        string2.getClass();
        return ((TraceMetric)this.instance).getCountersMap().containsKey(string2);
    }

    public boolean containsCustomAttributes(String string2) {
        string2.getClass();
        return ((TraceMetric)this.instance).getCustomAttributesMap().containsKey(string2);
    }

    public long getClientStartTimeUs() {
        return ((TraceMetric)this.instance).getClientStartTimeUs();
    }

    public Map getCounters() {
        return this.getCountersMap();
    }

    public int getCountersCount() {
        return ((TraceMetric)this.instance).getCountersMap().size();
    }

    public Map getCountersMap() {
        return Collections.unmodifiableMap(((TraceMetric)this.instance).getCountersMap());
    }

    public long getCountersOrDefault(String object, long l10) {
        object.getClass();
        Map map = ((TraceMetric)this.instance).getCountersMap();
        boolean bl2 = map.containsKey(object);
        if (bl2) {
            object = (Long)map.get(object);
            l10 = (Long)object;
        }
        return l10;
    }

    public long getCountersOrThrow(String object) {
        object.getClass();
        Map map = ((TraceMetric)this.instance).getCountersMap();
        boolean bl2 = map.containsKey(object);
        if (bl2) {
            return (Long)map.get(object);
        }
        object = new IllegalArgumentException();
        throw object;
    }

    public Map getCustomAttributes() {
        return this.getCustomAttributesMap();
    }

    public int getCustomAttributesCount() {
        return ((TraceMetric)this.instance).getCustomAttributesMap().size();
    }

    public Map getCustomAttributesMap() {
        return Collections.unmodifiableMap(((TraceMetric)this.instance).getCustomAttributesMap());
    }

    public String getCustomAttributesOrDefault(String string2, String string3) {
        string2.getClass();
        Map map = ((TraceMetric)this.instance).getCustomAttributesMap();
        boolean bl2 = map.containsKey(string2);
        if (bl2) {
            string3 = string2 = map.get(string2);
            string3 = string2;
        }
        return string3;
    }

    public String getCustomAttributesOrThrow(String object) {
        object.getClass();
        Map map = ((TraceMetric)this.instance).getCustomAttributesMap();
        boolean bl2 = map.containsKey(object);
        if (bl2) {
            return (String)map.get(object);
        }
        object = new IllegalArgumentException();
        throw object;
    }

    public long getDurationUs() {
        return ((TraceMetric)this.instance).getDurationUs();
    }

    public boolean getIsAuto() {
        return ((TraceMetric)this.instance).getIsAuto();
    }

    public String getName() {
        return ((TraceMetric)this.instance).getName();
    }

    public ByteString getNameBytes() {
        return ((TraceMetric)this.instance).getNameBytes();
    }

    public PerfSession getPerfSessions(int n10) {
        return ((TraceMetric)this.instance).getPerfSessions(n10);
    }

    public int getPerfSessionsCount() {
        return ((TraceMetric)this.instance).getPerfSessionsCount();
    }

    public List getPerfSessionsList() {
        return Collections.unmodifiableList(((TraceMetric)this.instance).getPerfSessionsList());
    }

    public TraceMetric getSubtraces(int n10) {
        return ((TraceMetric)this.instance).getSubtraces(n10);
    }

    public int getSubtracesCount() {
        return ((TraceMetric)this.instance).getSubtracesCount();
    }

    public List getSubtracesList() {
        return Collections.unmodifiableList(((TraceMetric)this.instance).getSubtracesList());
    }

    public boolean hasClientStartTimeUs() {
        return ((TraceMetric)this.instance).hasClientStartTimeUs();
    }

    public boolean hasDurationUs() {
        return ((TraceMetric)this.instance).hasDurationUs();
    }

    public boolean hasIsAuto() {
        return ((TraceMetric)this.instance).hasIsAuto();
    }

    public boolean hasName() {
        return ((TraceMetric)this.instance).hasName();
    }

    public TraceMetric$Builder putAllCounters(Map map) {
        this.copyOnWrite();
        TraceMetric.access$1000((TraceMetric)this.instance).putAll(map);
        return this;
    }

    public TraceMetric$Builder putAllCustomAttributes(Map map) {
        this.copyOnWrite();
        TraceMetric.access$1700((TraceMetric)this.instance).putAll(map);
        return this;
    }

    public TraceMetric$Builder putCounters(String string2, long l10) {
        string2.getClass();
        this.copyOnWrite();
        Map map = TraceMetric.access$1000((TraceMetric)this.instance);
        Long l11 = l10;
        map.put(string2, l11);
        return this;
    }

    public TraceMetric$Builder putCustomAttributes(String string2, String string3) {
        string2.getClass();
        string3.getClass();
        this.copyOnWrite();
        TraceMetric.access$1700((TraceMetric)this.instance).put(string2, string3);
        return this;
    }

    public TraceMetric$Builder removeCounters(String string2) {
        string2.getClass();
        this.copyOnWrite();
        TraceMetric.access$1000((TraceMetric)this.instance).remove(string2);
        return this;
    }

    public TraceMetric$Builder removeCustomAttributes(String string2) {
        string2.getClass();
        this.copyOnWrite();
        TraceMetric.access$1700((TraceMetric)this.instance).remove(string2);
        return this;
    }

    public TraceMetric$Builder removePerfSessions(int n10) {
        this.copyOnWrite();
        TraceMetric.access$2300((TraceMetric)this.instance, n10);
        return this;
    }

    public TraceMetric$Builder removeSubtraces(int n10) {
        this.copyOnWrite();
        TraceMetric.access$1600((TraceMetric)this.instance, n10);
        return this;
    }

    public TraceMetric$Builder setClientStartTimeUs(long l10) {
        this.copyOnWrite();
        TraceMetric.access$600((TraceMetric)this.instance, l10);
        return this;
    }

    public TraceMetric$Builder setDurationUs(long l10) {
        this.copyOnWrite();
        TraceMetric.access$800((TraceMetric)this.instance, l10);
        return this;
    }

    public TraceMetric$Builder setIsAuto(boolean bl2) {
        this.copyOnWrite();
        TraceMetric.access$400((TraceMetric)this.instance, bl2);
        return this;
    }

    public TraceMetric$Builder setName(String string2) {
        this.copyOnWrite();
        TraceMetric.access$100((TraceMetric)this.instance, string2);
        return this;
    }

    public TraceMetric$Builder setNameBytes(ByteString byteString) {
        this.copyOnWrite();
        TraceMetric.access$300((TraceMetric)this.instance, byteString);
        return this;
    }

    public TraceMetric$Builder setPerfSessions(int n10, PerfSession$Builder perfSessionOrBuilder) {
        this.copyOnWrite();
        TraceMetric traceMetric = (TraceMetric)this.instance;
        perfSessionOrBuilder = (PerfSession)perfSessionOrBuilder.build();
        TraceMetric.access$1800(traceMetric, n10, (PerfSession)perfSessionOrBuilder);
        return this;
    }

    public TraceMetric$Builder setPerfSessions(int n10, PerfSession perfSession) {
        this.copyOnWrite();
        TraceMetric.access$1800((TraceMetric)this.instance, n10, perfSession);
        return this;
    }

    public TraceMetric$Builder setSubtraces(int n10, TraceMetric$Builder traceMetricOrBuilder) {
        this.copyOnWrite();
        TraceMetric traceMetric = (TraceMetric)this.instance;
        traceMetricOrBuilder = (TraceMetric)traceMetricOrBuilder.build();
        TraceMetric.access$1100(traceMetric, n10, (TraceMetric)traceMetricOrBuilder);
        return this;
    }

    public TraceMetric$Builder setSubtraces(int n10, TraceMetric traceMetric) {
        this.copyOnWrite();
        TraceMetric.access$1100((TraceMetric)this.instance, n10, traceMetric);
        return this;
    }
}

