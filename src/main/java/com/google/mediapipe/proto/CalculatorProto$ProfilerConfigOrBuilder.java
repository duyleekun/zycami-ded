/*
 * Decompiled with CFR 0.151.
 */
package com.google.mediapipe.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;
import java.util.List;

public interface CalculatorProto$ProfilerConfigOrBuilder
extends MessageLiteOrBuilder {
    public boolean getEnableInputOutputLatency();

    public boolean getEnableProfiler();

    public boolean getEnableStreamLatency();

    public long getHistogramIntervalSizeUsec();

    public long getNumHistogramIntervals();

    public boolean getTraceEnabled();

    public int getTraceEventTypesDisabled(int var1);

    public int getTraceEventTypesDisabledCount();

    public List getTraceEventTypesDisabledList();

    public long getTraceLogCapacity();

    public int getTraceLogCount();

    public boolean getTraceLogDisabled();

    public boolean getTraceLogDurationEvents();

    public int getTraceLogIntervalCount();

    public long getTraceLogIntervalUsec();

    public long getTraceLogMarginUsec();

    public String getTraceLogPath();

    public ByteString getTraceLogPathBytes();

    public boolean getUsePacketTimestampForAddedPacket();
}

