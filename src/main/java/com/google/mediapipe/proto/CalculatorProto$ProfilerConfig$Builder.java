/*
 * Decompiled with CFR 0.151.
 */
package com.google.mediapipe.proto;

import com.google.mediapipe.proto.CalculatorProto$1;
import com.google.mediapipe.proto.CalculatorProto$ProfilerConfig;
import com.google.mediapipe.proto.CalculatorProto$ProfilerConfigOrBuilder;
import com.google.protobuf.ByteString;
import com.google.protobuf.GeneratedMessageLite$Builder;
import java.util.Collections;
import java.util.List;

public final class CalculatorProto$ProfilerConfig$Builder
extends GeneratedMessageLite$Builder
implements CalculatorProto$ProfilerConfigOrBuilder {
    private CalculatorProto$ProfilerConfig$Builder() {
        CalculatorProto$ProfilerConfig calculatorProto$ProfilerConfig = CalculatorProto$ProfilerConfig.access$4700();
        super(calculatorProto$ProfilerConfig);
    }

    public /* synthetic */ CalculatorProto$ProfilerConfig$Builder(CalculatorProto$1 calculatorProto$1) {
        this();
    }

    public CalculatorProto$ProfilerConfig$Builder addAllTraceEventTypesDisabled(Iterable iterable) {
        this.copyOnWrite();
        CalculatorProto$ProfilerConfig.access$6400((CalculatorProto$ProfilerConfig)this.instance, iterable);
        return this;
    }

    public CalculatorProto$ProfilerConfig$Builder addTraceEventTypesDisabled(int n10) {
        this.copyOnWrite();
        CalculatorProto$ProfilerConfig.access$6300((CalculatorProto$ProfilerConfig)this.instance, n10);
        return this;
    }

    public CalculatorProto$ProfilerConfig$Builder clearEnableInputOutputLatency() {
        this.copyOnWrite();
        CalculatorProto$ProfilerConfig.access$5300((CalculatorProto$ProfilerConfig)this.instance);
        return this;
    }

    public CalculatorProto$ProfilerConfig$Builder clearEnableProfiler() {
        this.copyOnWrite();
        CalculatorProto$ProfilerConfig.access$5500((CalculatorProto$ProfilerConfig)this.instance);
        return this;
    }

    public CalculatorProto$ProfilerConfig$Builder clearEnableStreamLatency() {
        this.copyOnWrite();
        CalculatorProto$ProfilerConfig.access$5700((CalculatorProto$ProfilerConfig)this.instance);
        return this;
    }

    public CalculatorProto$ProfilerConfig$Builder clearHistogramIntervalSizeUsec() {
        this.copyOnWrite();
        CalculatorProto$ProfilerConfig.access$4900((CalculatorProto$ProfilerConfig)this.instance);
        return this;
    }

    public CalculatorProto$ProfilerConfig$Builder clearNumHistogramIntervals() {
        this.copyOnWrite();
        CalculatorProto$ProfilerConfig.access$5100((CalculatorProto$ProfilerConfig)this.instance);
        return this;
    }

    public CalculatorProto$ProfilerConfig$Builder clearTraceEnabled() {
        this.copyOnWrite();
        CalculatorProto$ProfilerConfig.access$8200((CalculatorProto$ProfilerConfig)this.instance);
        return this;
    }

    public CalculatorProto$ProfilerConfig$Builder clearTraceEventTypesDisabled() {
        this.copyOnWrite();
        CalculatorProto$ProfilerConfig.access$6500((CalculatorProto$ProfilerConfig)this.instance);
        return this;
    }

    public CalculatorProto$ProfilerConfig$Builder clearTraceLogCapacity() {
        this.copyOnWrite();
        CalculatorProto$ProfilerConfig.access$6100((CalculatorProto$ProfilerConfig)this.instance);
        return this;
    }

    public CalculatorProto$ProfilerConfig$Builder clearTraceLogCount() {
        this.copyOnWrite();
        CalculatorProto$ProfilerConfig.access$7000((CalculatorProto$ProfilerConfig)this.instance);
        return this;
    }

    public CalculatorProto$ProfilerConfig$Builder clearTraceLogDisabled() {
        this.copyOnWrite();
        CalculatorProto$ProfilerConfig.access$8000((CalculatorProto$ProfilerConfig)this.instance);
        return this;
    }

    public CalculatorProto$ProfilerConfig$Builder clearTraceLogDurationEvents() {
        this.copyOnWrite();
        CalculatorProto$ProfilerConfig.access$7600((CalculatorProto$ProfilerConfig)this.instance);
        return this;
    }

    public CalculatorProto$ProfilerConfig$Builder clearTraceLogIntervalCount() {
        this.copyOnWrite();
        CalculatorProto$ProfilerConfig.access$7800((CalculatorProto$ProfilerConfig)this.instance);
        return this;
    }

    public CalculatorProto$ProfilerConfig$Builder clearTraceLogIntervalUsec() {
        this.copyOnWrite();
        CalculatorProto$ProfilerConfig.access$7200((CalculatorProto$ProfilerConfig)this.instance);
        return this;
    }

    public CalculatorProto$ProfilerConfig$Builder clearTraceLogMarginUsec() {
        this.copyOnWrite();
        CalculatorProto$ProfilerConfig.access$7400((CalculatorProto$ProfilerConfig)this.instance);
        return this;
    }

    public CalculatorProto$ProfilerConfig$Builder clearTraceLogPath() {
        this.copyOnWrite();
        CalculatorProto$ProfilerConfig.access$6700((CalculatorProto$ProfilerConfig)this.instance);
        return this;
    }

    public CalculatorProto$ProfilerConfig$Builder clearUsePacketTimestampForAddedPacket() {
        this.copyOnWrite();
        CalculatorProto$ProfilerConfig.access$5900((CalculatorProto$ProfilerConfig)this.instance);
        return this;
    }

    public boolean getEnableInputOutputLatency() {
        return ((CalculatorProto$ProfilerConfig)this.instance).getEnableInputOutputLatency();
    }

    public boolean getEnableProfiler() {
        return ((CalculatorProto$ProfilerConfig)this.instance).getEnableProfiler();
    }

    public boolean getEnableStreamLatency() {
        return ((CalculatorProto$ProfilerConfig)this.instance).getEnableStreamLatency();
    }

    public long getHistogramIntervalSizeUsec() {
        return ((CalculatorProto$ProfilerConfig)this.instance).getHistogramIntervalSizeUsec();
    }

    public long getNumHistogramIntervals() {
        return ((CalculatorProto$ProfilerConfig)this.instance).getNumHistogramIntervals();
    }

    public boolean getTraceEnabled() {
        return ((CalculatorProto$ProfilerConfig)this.instance).getTraceEnabled();
    }

    public int getTraceEventTypesDisabled(int n10) {
        return ((CalculatorProto$ProfilerConfig)this.instance).getTraceEventTypesDisabled(n10);
    }

    public int getTraceEventTypesDisabledCount() {
        return ((CalculatorProto$ProfilerConfig)this.instance).getTraceEventTypesDisabledCount();
    }

    public List getTraceEventTypesDisabledList() {
        return Collections.unmodifiableList(((CalculatorProto$ProfilerConfig)this.instance).getTraceEventTypesDisabledList());
    }

    public long getTraceLogCapacity() {
        return ((CalculatorProto$ProfilerConfig)this.instance).getTraceLogCapacity();
    }

    public int getTraceLogCount() {
        return ((CalculatorProto$ProfilerConfig)this.instance).getTraceLogCount();
    }

    public boolean getTraceLogDisabled() {
        return ((CalculatorProto$ProfilerConfig)this.instance).getTraceLogDisabled();
    }

    public boolean getTraceLogDurationEvents() {
        return ((CalculatorProto$ProfilerConfig)this.instance).getTraceLogDurationEvents();
    }

    public int getTraceLogIntervalCount() {
        return ((CalculatorProto$ProfilerConfig)this.instance).getTraceLogIntervalCount();
    }

    public long getTraceLogIntervalUsec() {
        return ((CalculatorProto$ProfilerConfig)this.instance).getTraceLogIntervalUsec();
    }

    public long getTraceLogMarginUsec() {
        return ((CalculatorProto$ProfilerConfig)this.instance).getTraceLogMarginUsec();
    }

    public String getTraceLogPath() {
        return ((CalculatorProto$ProfilerConfig)this.instance).getTraceLogPath();
    }

    public ByteString getTraceLogPathBytes() {
        return ((CalculatorProto$ProfilerConfig)this.instance).getTraceLogPathBytes();
    }

    public boolean getUsePacketTimestampForAddedPacket() {
        return ((CalculatorProto$ProfilerConfig)this.instance).getUsePacketTimestampForAddedPacket();
    }

    public CalculatorProto$ProfilerConfig$Builder setEnableInputOutputLatency(boolean bl2) {
        this.copyOnWrite();
        CalculatorProto$ProfilerConfig.access$5200((CalculatorProto$ProfilerConfig)this.instance, bl2);
        return this;
    }

    public CalculatorProto$ProfilerConfig$Builder setEnableProfiler(boolean bl2) {
        this.copyOnWrite();
        CalculatorProto$ProfilerConfig.access$5400((CalculatorProto$ProfilerConfig)this.instance, bl2);
        return this;
    }

    public CalculatorProto$ProfilerConfig$Builder setEnableStreamLatency(boolean bl2) {
        this.copyOnWrite();
        CalculatorProto$ProfilerConfig.access$5600((CalculatorProto$ProfilerConfig)this.instance, bl2);
        return this;
    }

    public CalculatorProto$ProfilerConfig$Builder setHistogramIntervalSizeUsec(long l10) {
        this.copyOnWrite();
        CalculatorProto$ProfilerConfig.access$4800((CalculatorProto$ProfilerConfig)this.instance, l10);
        return this;
    }

    public CalculatorProto$ProfilerConfig$Builder setNumHistogramIntervals(long l10) {
        this.copyOnWrite();
        CalculatorProto$ProfilerConfig.access$5000((CalculatorProto$ProfilerConfig)this.instance, l10);
        return this;
    }

    public CalculatorProto$ProfilerConfig$Builder setTraceEnabled(boolean bl2) {
        this.copyOnWrite();
        CalculatorProto$ProfilerConfig.access$8100((CalculatorProto$ProfilerConfig)this.instance, bl2);
        return this;
    }

    public CalculatorProto$ProfilerConfig$Builder setTraceEventTypesDisabled(int n10, int n11) {
        this.copyOnWrite();
        CalculatorProto$ProfilerConfig.access$6200((CalculatorProto$ProfilerConfig)this.instance, n10, n11);
        return this;
    }

    public CalculatorProto$ProfilerConfig$Builder setTraceLogCapacity(long l10) {
        this.copyOnWrite();
        CalculatorProto$ProfilerConfig.access$6000((CalculatorProto$ProfilerConfig)this.instance, l10);
        return this;
    }

    public CalculatorProto$ProfilerConfig$Builder setTraceLogCount(int n10) {
        this.copyOnWrite();
        CalculatorProto$ProfilerConfig.access$6900((CalculatorProto$ProfilerConfig)this.instance, n10);
        return this;
    }

    public CalculatorProto$ProfilerConfig$Builder setTraceLogDisabled(boolean bl2) {
        this.copyOnWrite();
        CalculatorProto$ProfilerConfig.access$7900((CalculatorProto$ProfilerConfig)this.instance, bl2);
        return this;
    }

    public CalculatorProto$ProfilerConfig$Builder setTraceLogDurationEvents(boolean bl2) {
        this.copyOnWrite();
        CalculatorProto$ProfilerConfig.access$7500((CalculatorProto$ProfilerConfig)this.instance, bl2);
        return this;
    }

    public CalculatorProto$ProfilerConfig$Builder setTraceLogIntervalCount(int n10) {
        this.copyOnWrite();
        CalculatorProto$ProfilerConfig.access$7700((CalculatorProto$ProfilerConfig)this.instance, n10);
        return this;
    }

    public CalculatorProto$ProfilerConfig$Builder setTraceLogIntervalUsec(long l10) {
        this.copyOnWrite();
        CalculatorProto$ProfilerConfig.access$7100((CalculatorProto$ProfilerConfig)this.instance, l10);
        return this;
    }

    public CalculatorProto$ProfilerConfig$Builder setTraceLogMarginUsec(long l10) {
        this.copyOnWrite();
        CalculatorProto$ProfilerConfig.access$7300((CalculatorProto$ProfilerConfig)this.instance, l10);
        return this;
    }

    public CalculatorProto$ProfilerConfig$Builder setTraceLogPath(String string2) {
        this.copyOnWrite();
        CalculatorProto$ProfilerConfig.access$6600((CalculatorProto$ProfilerConfig)this.instance, string2);
        return this;
    }

    public CalculatorProto$ProfilerConfig$Builder setTraceLogPathBytes(ByteString byteString) {
        this.copyOnWrite();
        CalculatorProto$ProfilerConfig.access$6800((CalculatorProto$ProfilerConfig)this.instance, byteString);
        return this;
    }

    public CalculatorProto$ProfilerConfig$Builder setUsePacketTimestampForAddedPacket(boolean bl2) {
        this.copyOnWrite();
        CalculatorProto$ProfilerConfig.access$5800((CalculatorProto$ProfilerConfig)this.instance, bl2);
        return this;
    }
}

