/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.perf.v1;

import com.google.firebase.perf.v1.PerfSession;
import com.google.firebase.perf.v1.TraceMetric;
import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;
import java.util.List;
import java.util.Map;

public interface TraceMetricOrBuilder
extends MessageLiteOrBuilder {
    public boolean containsCounters(String var1);

    public boolean containsCustomAttributes(String var1);

    public long getClientStartTimeUs();

    public Map getCounters();

    public int getCountersCount();

    public Map getCountersMap();

    public long getCountersOrDefault(String var1, long var2);

    public long getCountersOrThrow(String var1);

    public Map getCustomAttributes();

    public int getCustomAttributesCount();

    public Map getCustomAttributesMap();

    public String getCustomAttributesOrDefault(String var1, String var2);

    public String getCustomAttributesOrThrow(String var1);

    public long getDurationUs();

    public boolean getIsAuto();

    public String getName();

    public ByteString getNameBytes();

    public PerfSession getPerfSessions(int var1);

    public int getPerfSessionsCount();

    public List getPerfSessionsList();

    public TraceMetric getSubtraces(int var1);

    public int getSubtracesCount();

    public List getSubtracesList();

    public boolean hasClientStartTimeUs();

    public boolean hasDurationUs();

    public boolean hasIsAuto();

    public boolean hasName();
}

