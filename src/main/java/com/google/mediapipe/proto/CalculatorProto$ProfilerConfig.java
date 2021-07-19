/*
 * Decompiled with CFR 0.151.
 */
package com.google.mediapipe.proto;

import com.google.mediapipe.proto.CalculatorProto$1;
import com.google.mediapipe.proto.CalculatorProto$ProfilerConfig$Builder;
import com.google.mediapipe.proto.CalculatorProto$ProfilerConfigOrBuilder;
import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.GeneratedMessageLite$DefaultInstanceBasedParser;
import com.google.protobuf.GeneratedMessageLite$MethodToInvoke;
import com.google.protobuf.Internal$IntList;
import com.google.protobuf.Parser;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

public final class CalculatorProto$ProfilerConfig
extends GeneratedMessageLite
implements CalculatorProto$ProfilerConfigOrBuilder {
    private static final CalculatorProto$ProfilerConfig DEFAULT_INSTANCE;
    public static final int ENABLE_INPUT_OUTPUT_LATENCY_FIELD_NUMBER = 3;
    public static final int ENABLE_PROFILER_FIELD_NUMBER = 4;
    public static final int ENABLE_STREAM_LATENCY_FIELD_NUMBER = 5;
    public static final int HISTOGRAM_INTERVAL_SIZE_USEC_FIELD_NUMBER = 1;
    public static final int NUM_HISTOGRAM_INTERVALS_FIELD_NUMBER = 2;
    private static volatile Parser PARSER;
    public static final int TRACE_ENABLED_FIELD_NUMBER = 16;
    public static final int TRACE_EVENT_TYPES_DISABLED_FIELD_NUMBER = 8;
    public static final int TRACE_LOG_CAPACITY_FIELD_NUMBER = 7;
    public static final int TRACE_LOG_COUNT_FIELD_NUMBER = 10;
    public static final int TRACE_LOG_DISABLED_FIELD_NUMBER = 15;
    public static final int TRACE_LOG_DURATION_EVENTS_FIELD_NUMBER = 13;
    public static final int TRACE_LOG_INTERVAL_COUNT_FIELD_NUMBER = 14;
    public static final int TRACE_LOG_INTERVAL_USEC_FIELD_NUMBER = 11;
    public static final int TRACE_LOG_MARGIN_USEC_FIELD_NUMBER = 12;
    public static final int TRACE_LOG_PATH_FIELD_NUMBER = 9;
    public static final int USE_PACKET_TIMESTAMP_FOR_ADDED_PACKET_FIELD_NUMBER = 6;
    private boolean enableInputOutputLatency_;
    private boolean enableProfiler_;
    private boolean enableStreamLatency_;
    private long histogramIntervalSizeUsec_;
    private long numHistogramIntervals_;
    private boolean traceEnabled_;
    private int traceEventTypesDisabledMemoizedSerializedSize = -1;
    private Internal$IntList traceEventTypesDisabled_;
    private long traceLogCapacity_;
    private int traceLogCount_;
    private boolean traceLogDisabled_;
    private boolean traceLogDurationEvents_;
    private int traceLogIntervalCount_;
    private long traceLogIntervalUsec_;
    private long traceLogMarginUsec_;
    private String traceLogPath_;
    private boolean usePacketTimestampForAddedPacket_;

    static {
        CalculatorProto$ProfilerConfig calculatorProto$ProfilerConfig;
        DEFAULT_INSTANCE = calculatorProto$ProfilerConfig = new CalculatorProto$ProfilerConfig();
        GeneratedMessageLite.registerDefaultInstance(CalculatorProto$ProfilerConfig.class, calculatorProto$ProfilerConfig);
    }

    private CalculatorProto$ProfilerConfig() {
        Internal$IntList internal$IntList;
        this.traceEventTypesDisabled_ = internal$IntList = GeneratedMessageLite.emptyIntList();
        this.traceLogPath_ = "";
    }

    public static /* synthetic */ CalculatorProto$ProfilerConfig access$4700() {
        return DEFAULT_INSTANCE;
    }

    public static /* synthetic */ void access$4800(CalculatorProto$ProfilerConfig calculatorProto$ProfilerConfig, long l10) {
        calculatorProto$ProfilerConfig.setHistogramIntervalSizeUsec(l10);
    }

    public static /* synthetic */ void access$4900(CalculatorProto$ProfilerConfig calculatorProto$ProfilerConfig) {
        calculatorProto$ProfilerConfig.clearHistogramIntervalSizeUsec();
    }

    public static /* synthetic */ void access$5000(CalculatorProto$ProfilerConfig calculatorProto$ProfilerConfig, long l10) {
        calculatorProto$ProfilerConfig.setNumHistogramIntervals(l10);
    }

    public static /* synthetic */ void access$5100(CalculatorProto$ProfilerConfig calculatorProto$ProfilerConfig) {
        calculatorProto$ProfilerConfig.clearNumHistogramIntervals();
    }

    public static /* synthetic */ void access$5200(CalculatorProto$ProfilerConfig calculatorProto$ProfilerConfig, boolean bl2) {
        calculatorProto$ProfilerConfig.setEnableInputOutputLatency(bl2);
    }

    public static /* synthetic */ void access$5300(CalculatorProto$ProfilerConfig calculatorProto$ProfilerConfig) {
        calculatorProto$ProfilerConfig.clearEnableInputOutputLatency();
    }

    public static /* synthetic */ void access$5400(CalculatorProto$ProfilerConfig calculatorProto$ProfilerConfig, boolean bl2) {
        calculatorProto$ProfilerConfig.setEnableProfiler(bl2);
    }

    public static /* synthetic */ void access$5500(CalculatorProto$ProfilerConfig calculatorProto$ProfilerConfig) {
        calculatorProto$ProfilerConfig.clearEnableProfiler();
    }

    public static /* synthetic */ void access$5600(CalculatorProto$ProfilerConfig calculatorProto$ProfilerConfig, boolean bl2) {
        calculatorProto$ProfilerConfig.setEnableStreamLatency(bl2);
    }

    public static /* synthetic */ void access$5700(CalculatorProto$ProfilerConfig calculatorProto$ProfilerConfig) {
        calculatorProto$ProfilerConfig.clearEnableStreamLatency();
    }

    public static /* synthetic */ void access$5800(CalculatorProto$ProfilerConfig calculatorProto$ProfilerConfig, boolean bl2) {
        calculatorProto$ProfilerConfig.setUsePacketTimestampForAddedPacket(bl2);
    }

    public static /* synthetic */ void access$5900(CalculatorProto$ProfilerConfig calculatorProto$ProfilerConfig) {
        calculatorProto$ProfilerConfig.clearUsePacketTimestampForAddedPacket();
    }

    public static /* synthetic */ void access$6000(CalculatorProto$ProfilerConfig calculatorProto$ProfilerConfig, long l10) {
        calculatorProto$ProfilerConfig.setTraceLogCapacity(l10);
    }

    public static /* synthetic */ void access$6100(CalculatorProto$ProfilerConfig calculatorProto$ProfilerConfig) {
        calculatorProto$ProfilerConfig.clearTraceLogCapacity();
    }

    public static /* synthetic */ void access$6200(CalculatorProto$ProfilerConfig calculatorProto$ProfilerConfig, int n10, int n11) {
        calculatorProto$ProfilerConfig.setTraceEventTypesDisabled(n10, n11);
    }

    public static /* synthetic */ void access$6300(CalculatorProto$ProfilerConfig calculatorProto$ProfilerConfig, int n10) {
        calculatorProto$ProfilerConfig.addTraceEventTypesDisabled(n10);
    }

    public static /* synthetic */ void access$6400(CalculatorProto$ProfilerConfig calculatorProto$ProfilerConfig, Iterable iterable) {
        calculatorProto$ProfilerConfig.addAllTraceEventTypesDisabled(iterable);
    }

    public static /* synthetic */ void access$6500(CalculatorProto$ProfilerConfig calculatorProto$ProfilerConfig) {
        calculatorProto$ProfilerConfig.clearTraceEventTypesDisabled();
    }

    public static /* synthetic */ void access$6600(CalculatorProto$ProfilerConfig calculatorProto$ProfilerConfig, String string2) {
        calculatorProto$ProfilerConfig.setTraceLogPath(string2);
    }

    public static /* synthetic */ void access$6700(CalculatorProto$ProfilerConfig calculatorProto$ProfilerConfig) {
        calculatorProto$ProfilerConfig.clearTraceLogPath();
    }

    public static /* synthetic */ void access$6800(CalculatorProto$ProfilerConfig calculatorProto$ProfilerConfig, ByteString byteString) {
        calculatorProto$ProfilerConfig.setTraceLogPathBytes(byteString);
    }

    public static /* synthetic */ void access$6900(CalculatorProto$ProfilerConfig calculatorProto$ProfilerConfig, int n10) {
        calculatorProto$ProfilerConfig.setTraceLogCount(n10);
    }

    public static /* synthetic */ void access$7000(CalculatorProto$ProfilerConfig calculatorProto$ProfilerConfig) {
        calculatorProto$ProfilerConfig.clearTraceLogCount();
    }

    public static /* synthetic */ void access$7100(CalculatorProto$ProfilerConfig calculatorProto$ProfilerConfig, long l10) {
        calculatorProto$ProfilerConfig.setTraceLogIntervalUsec(l10);
    }

    public static /* synthetic */ void access$7200(CalculatorProto$ProfilerConfig calculatorProto$ProfilerConfig) {
        calculatorProto$ProfilerConfig.clearTraceLogIntervalUsec();
    }

    public static /* synthetic */ void access$7300(CalculatorProto$ProfilerConfig calculatorProto$ProfilerConfig, long l10) {
        calculatorProto$ProfilerConfig.setTraceLogMarginUsec(l10);
    }

    public static /* synthetic */ void access$7400(CalculatorProto$ProfilerConfig calculatorProto$ProfilerConfig) {
        calculatorProto$ProfilerConfig.clearTraceLogMarginUsec();
    }

    public static /* synthetic */ void access$7500(CalculatorProto$ProfilerConfig calculatorProto$ProfilerConfig, boolean bl2) {
        calculatorProto$ProfilerConfig.setTraceLogDurationEvents(bl2);
    }

    public static /* synthetic */ void access$7600(CalculatorProto$ProfilerConfig calculatorProto$ProfilerConfig) {
        calculatorProto$ProfilerConfig.clearTraceLogDurationEvents();
    }

    public static /* synthetic */ void access$7700(CalculatorProto$ProfilerConfig calculatorProto$ProfilerConfig, int n10) {
        calculatorProto$ProfilerConfig.setTraceLogIntervalCount(n10);
    }

    public static /* synthetic */ void access$7800(CalculatorProto$ProfilerConfig calculatorProto$ProfilerConfig) {
        calculatorProto$ProfilerConfig.clearTraceLogIntervalCount();
    }

    public static /* synthetic */ void access$7900(CalculatorProto$ProfilerConfig calculatorProto$ProfilerConfig, boolean bl2) {
        calculatorProto$ProfilerConfig.setTraceLogDisabled(bl2);
    }

    public static /* synthetic */ void access$8000(CalculatorProto$ProfilerConfig calculatorProto$ProfilerConfig) {
        calculatorProto$ProfilerConfig.clearTraceLogDisabled();
    }

    public static /* synthetic */ void access$8100(CalculatorProto$ProfilerConfig calculatorProto$ProfilerConfig, boolean bl2) {
        calculatorProto$ProfilerConfig.setTraceEnabled(bl2);
    }

    public static /* synthetic */ void access$8200(CalculatorProto$ProfilerConfig calculatorProto$ProfilerConfig) {
        calculatorProto$ProfilerConfig.clearTraceEnabled();
    }

    private void addAllTraceEventTypesDisabled(Iterable iterable) {
        this.ensureTraceEventTypesDisabledIsMutable();
        Internal$IntList internal$IntList = this.traceEventTypesDisabled_;
        AbstractMessageLite.addAll(iterable, internal$IntList);
    }

    private void addTraceEventTypesDisabled(int n10) {
        this.ensureTraceEventTypesDisabledIsMutable();
        this.traceEventTypesDisabled_.addInt(n10);
    }

    private void clearEnableInputOutputLatency() {
        this.enableInputOutputLatency_ = false;
    }

    private void clearEnableProfiler() {
        this.enableProfiler_ = false;
    }

    private void clearEnableStreamLatency() {
        this.enableStreamLatency_ = false;
    }

    private void clearHistogramIntervalSizeUsec() {
        this.histogramIntervalSizeUsec_ = 0L;
    }

    private void clearNumHistogramIntervals() {
        this.numHistogramIntervals_ = 0L;
    }

    private void clearTraceEnabled() {
        this.traceEnabled_ = false;
    }

    private void clearTraceEventTypesDisabled() {
        Internal$IntList internal$IntList;
        this.traceEventTypesDisabled_ = internal$IntList = GeneratedMessageLite.emptyIntList();
    }

    private void clearTraceLogCapacity() {
        this.traceLogCapacity_ = 0L;
    }

    private void clearTraceLogCount() {
        this.traceLogCount_ = 0;
    }

    private void clearTraceLogDisabled() {
        this.traceLogDisabled_ = false;
    }

    private void clearTraceLogDurationEvents() {
        this.traceLogDurationEvents_ = false;
    }

    private void clearTraceLogIntervalCount() {
        this.traceLogIntervalCount_ = 0;
    }

    private void clearTraceLogIntervalUsec() {
        this.traceLogIntervalUsec_ = 0L;
    }

    private void clearTraceLogMarginUsec() {
        this.traceLogMarginUsec_ = 0L;
    }

    private void clearTraceLogPath() {
        String string2;
        this.traceLogPath_ = string2 = CalculatorProto$ProfilerConfig.getDefaultInstance().getTraceLogPath();
    }

    private void clearUsePacketTimestampForAddedPacket() {
        this.usePacketTimestampForAddedPacket_ = false;
    }

    private void ensureTraceEventTypesDisabledIsMutable() {
        Internal$IntList internal$IntList = this.traceEventTypesDisabled_;
        boolean bl2 = internal$IntList.isModifiable();
        if (!bl2) {
            this.traceEventTypesDisabled_ = internal$IntList = GeneratedMessageLite.mutableCopy(this.traceEventTypesDisabled_);
        }
    }

    public static CalculatorProto$ProfilerConfig getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static CalculatorProto$ProfilerConfig$Builder newBuilder() {
        return (CalculatorProto$ProfilerConfig$Builder)DEFAULT_INSTANCE.createBuilder();
    }

    public static CalculatorProto$ProfilerConfig$Builder newBuilder(CalculatorProto$ProfilerConfig calculatorProto$ProfilerConfig) {
        return (CalculatorProto$ProfilerConfig$Builder)DEFAULT_INSTANCE.createBuilder(calculatorProto$ProfilerConfig);
    }

    public static CalculatorProto$ProfilerConfig parseDelimitedFrom(InputStream inputStream) {
        return (CalculatorProto$ProfilerConfig)GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static CalculatorProto$ProfilerConfig parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (CalculatorProto$ProfilerConfig)GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static CalculatorProto$ProfilerConfig parseFrom(ByteString byteString) {
        return (CalculatorProto$ProfilerConfig)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, byteString);
    }

    public static CalculatorProto$ProfilerConfig parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (CalculatorProto$ProfilerConfig)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static CalculatorProto$ProfilerConfig parseFrom(CodedInputStream codedInputStream) {
        return (CalculatorProto$ProfilerConfig)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, codedInputStream);
    }

    public static CalculatorProto$ProfilerConfig parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (CalculatorProto$ProfilerConfig)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static CalculatorProto$ProfilerConfig parseFrom(InputStream inputStream) {
        return (CalculatorProto$ProfilerConfig)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, inputStream);
    }

    public static CalculatorProto$ProfilerConfig parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (CalculatorProto$ProfilerConfig)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static CalculatorProto$ProfilerConfig parseFrom(ByteBuffer byteBuffer) {
        return (CalculatorProto$ProfilerConfig)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, byteBuffer);
    }

    public static CalculatorProto$ProfilerConfig parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (CalculatorProto$ProfilerConfig)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static CalculatorProto$ProfilerConfig parseFrom(byte[] byArray) {
        return (CalculatorProto$ProfilerConfig)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, byArray);
    }

    public static CalculatorProto$ProfilerConfig parseFrom(byte[] byArray, ExtensionRegistryLite extensionRegistryLite) {
        return (CalculatorProto$ProfilerConfig)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, byArray, extensionRegistryLite);
    }

    public static Parser parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setEnableInputOutputLatency(boolean bl2) {
        this.enableInputOutputLatency_ = bl2;
    }

    private void setEnableProfiler(boolean bl2) {
        this.enableProfiler_ = bl2;
    }

    private void setEnableStreamLatency(boolean bl2) {
        this.enableStreamLatency_ = bl2;
    }

    private void setHistogramIntervalSizeUsec(long l10) {
        this.histogramIntervalSizeUsec_ = l10;
    }

    private void setNumHistogramIntervals(long l10) {
        this.numHistogramIntervals_ = l10;
    }

    private void setTraceEnabled(boolean bl2) {
        this.traceEnabled_ = bl2;
    }

    private void setTraceEventTypesDisabled(int n10, int n11) {
        this.ensureTraceEventTypesDisabledIsMutable();
        this.traceEventTypesDisabled_.setInt(n10, n11);
    }

    private void setTraceLogCapacity(long l10) {
        this.traceLogCapacity_ = l10;
    }

    private void setTraceLogCount(int n10) {
        this.traceLogCount_ = n10;
    }

    private void setTraceLogDisabled(boolean bl2) {
        this.traceLogDisabled_ = bl2;
    }

    private void setTraceLogDurationEvents(boolean bl2) {
        this.traceLogDurationEvents_ = bl2;
    }

    private void setTraceLogIntervalCount(int n10) {
        this.traceLogIntervalCount_ = n10;
    }

    private void setTraceLogIntervalUsec(long l10) {
        this.traceLogIntervalUsec_ = l10;
    }

    private void setTraceLogMarginUsec(long l10) {
        this.traceLogMarginUsec_ = l10;
    }

    private void setTraceLogPath(String string2) {
        string2.getClass();
        this.traceLogPath_ = string2;
    }

    private void setTraceLogPathBytes(ByteString object) {
        AbstractMessageLite.checkByteStringIsUtf8((ByteString)object);
        this.traceLogPath_ = object = ((ByteString)object).toStringUtf8();
    }

    private void setUsePacketTimestampForAddedPacket(boolean bl2) {
        this.usePacketTimestampForAddedPacket_ = bl2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object dynamicMethod(GeneratedMessageLite$MethodToInvoke objectArray, Object clazz, Object object) {
        clazz = (Class<CalculatorProto$ProfilerConfig>)CalculatorProto$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke;
        Object object2 = objectArray.ordinal();
        object2 = clazz[object2];
        byte by2 = 1;
        object = null;
        switch (object2) {
            default: {
                objectArray = new UnsupportedOperationException();
                throw objectArray;
            }
            case 7: {
                return null;
            }
            case 6: {
                return by2;
            }
            case 5: {
                objectArray = PARSER;
                if (objectArray != null) return objectArray;
                clazz = CalculatorProto$ProfilerConfig.class;
                synchronized (clazz) {
                    objectArray = PARSER;
                    if (objectArray != null) return objectArray;
                    object = DEFAULT_INSTANCE;
                    PARSER = objectArray = new GeneratedMessageLite$DefaultInstanceBasedParser((GeneratedMessageLite)object);
                    return objectArray;
                }
            }
            case 4: {
                return DEFAULT_INSTANCE;
            }
            case 3: {
                objectArray = new Object[16];
                objectArray[0] = "histogramIntervalSizeUsec_";
                objectArray[by2] = "numHistogramIntervals_";
                objectArray[2] = "enableInputOutputLatency_";
                objectArray[3] = "enableProfiler_";
                objectArray[4] = "enableStreamLatency_";
                objectArray[5] = "usePacketTimestampForAddedPacket_";
                objectArray[6] = "traceLogCapacity_";
                objectArray[7] = "traceEventTypesDisabled_";
                objectArray[8] = "traceLogPath_";
                objectArray[9] = "traceLogCount_";
                objectArray[10] = "traceLogIntervalUsec_";
                objectArray[11] = "traceLogMarginUsec_";
                objectArray[12] = "traceLogDurationEvents_";
                objectArray[13] = "traceLogIntervalCount_";
                objectArray[14] = "traceLogDisabled_";
                objectArray[15] = "traceEnabled_";
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0010\u0000\u0000\u0001\u0010\u0010\u0000\u0001\u0000\u0001\u0002\u0002\u0002\u0003\u0007\u0004\u0007\u0005\u0007\u0006\u0007\u0007\u0002\b'\t\u0208\n\u0004\u000b\u0002\f\u0002\r\u0007\u000e\u0004\u000f\u0007\u0010\u0007", objectArray);
            }
            case 2: {
                return new CalculatorProto$ProfilerConfig$Builder(null);
            }
            case 1: 
        }
        return new CalculatorProto$ProfilerConfig();
    }

    public boolean getEnableInputOutputLatency() {
        return this.enableInputOutputLatency_;
    }

    public boolean getEnableProfiler() {
        return this.enableProfiler_;
    }

    public boolean getEnableStreamLatency() {
        return this.enableStreamLatency_;
    }

    public long getHistogramIntervalSizeUsec() {
        return this.histogramIntervalSizeUsec_;
    }

    public long getNumHistogramIntervals() {
        return this.numHistogramIntervals_;
    }

    public boolean getTraceEnabled() {
        return this.traceEnabled_;
    }

    public int getTraceEventTypesDisabled(int n10) {
        return this.traceEventTypesDisabled_.getInt(n10);
    }

    public int getTraceEventTypesDisabledCount() {
        return this.traceEventTypesDisabled_.size();
    }

    public List getTraceEventTypesDisabledList() {
        return this.traceEventTypesDisabled_;
    }

    public long getTraceLogCapacity() {
        return this.traceLogCapacity_;
    }

    public int getTraceLogCount() {
        return this.traceLogCount_;
    }

    public boolean getTraceLogDisabled() {
        return this.traceLogDisabled_;
    }

    public boolean getTraceLogDurationEvents() {
        return this.traceLogDurationEvents_;
    }

    public int getTraceLogIntervalCount() {
        return this.traceLogIntervalCount_;
    }

    public long getTraceLogIntervalUsec() {
        return this.traceLogIntervalUsec_;
    }

    public long getTraceLogMarginUsec() {
        return this.traceLogMarginUsec_;
    }

    public String getTraceLogPath() {
        return this.traceLogPath_;
    }

    public ByteString getTraceLogPathBytes() {
        return ByteString.copyFromUtf8(this.traceLogPath_);
    }

    public boolean getUsePacketTimestampForAddedPacket() {
        return this.usePacketTimestampForAddedPacket_;
    }
}

