/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.perf.v1;

import com.google.firebase.perf.v1.AndroidMemoryReading;
import com.google.firebase.perf.v1.AndroidMemoryReadingOrBuilder;
import com.google.firebase.perf.v1.CpuMetricReading;
import com.google.firebase.perf.v1.CpuMetricReadingOrBuilder;
import com.google.firebase.perf.v1.GaugeMetadata;
import com.google.firebase.perf.v1.GaugeMetadata$Builder;
import com.google.firebase.perf.v1.GaugeMetadataOrBuilder;
import com.google.firebase.perf.v1.GaugeMetric$1;
import com.google.firebase.perf.v1.GaugeMetric$Builder;
import com.google.firebase.perf.v1.GaugeMetricOrBuilder;
import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.GeneratedMessageLite$Builder;
import com.google.protobuf.GeneratedMessageLite$DefaultInstanceBasedParser;
import com.google.protobuf.GeneratedMessageLite$MethodToInvoke;
import com.google.protobuf.Internal$ProtobufList;
import com.google.protobuf.Parser;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

public final class GaugeMetric
extends GeneratedMessageLite
implements GaugeMetricOrBuilder {
    public static final int ANDROID_MEMORY_READINGS_FIELD_NUMBER = 4;
    public static final int CPU_METRIC_READINGS_FIELD_NUMBER = 2;
    private static final GaugeMetric DEFAULT_INSTANCE;
    public static final int GAUGE_METADATA_FIELD_NUMBER = 3;
    private static volatile Parser PARSER;
    public static final int SESSION_ID_FIELD_NUMBER = 1;
    private Internal$ProtobufList androidMemoryReadings_;
    private int bitField0_;
    private Internal$ProtobufList cpuMetricReadings_;
    private GaugeMetadata gaugeMetadata_;
    private String sessionId_ = "";

    static {
        GaugeMetric gaugeMetric;
        DEFAULT_INSTANCE = gaugeMetric = new GaugeMetric();
        GeneratedMessageLite.registerDefaultInstance(GaugeMetric.class, gaugeMetric);
    }

    private GaugeMetric() {
        Internal$ProtobufList internal$ProtobufList;
        this.cpuMetricReadings_ = internal$ProtobufList = GeneratedMessageLite.emptyProtobufList();
        this.androidMemoryReadings_ = internal$ProtobufList = GeneratedMessageLite.emptyProtobufList();
    }

    public static /* synthetic */ GaugeMetric access$000() {
        return DEFAULT_INSTANCE;
    }

    public static /* synthetic */ void access$100(GaugeMetric gaugeMetric, String string2) {
        gaugeMetric.setSessionId(string2);
    }

    public static /* synthetic */ void access$1000(GaugeMetric gaugeMetric, Iterable iterable) {
        gaugeMetric.addAllCpuMetricReadings(iterable);
    }

    public static /* synthetic */ void access$1100(GaugeMetric gaugeMetric) {
        gaugeMetric.clearCpuMetricReadings();
    }

    public static /* synthetic */ void access$1200(GaugeMetric gaugeMetric, int n10) {
        gaugeMetric.removeCpuMetricReadings(n10);
    }

    public static /* synthetic */ void access$1300(GaugeMetric gaugeMetric, int n10, AndroidMemoryReading androidMemoryReading) {
        gaugeMetric.setAndroidMemoryReadings(n10, androidMemoryReading);
    }

    public static /* synthetic */ void access$1400(GaugeMetric gaugeMetric, AndroidMemoryReading androidMemoryReading) {
        gaugeMetric.addAndroidMemoryReadings(androidMemoryReading);
    }

    public static /* synthetic */ void access$1500(GaugeMetric gaugeMetric, int n10, AndroidMemoryReading androidMemoryReading) {
        gaugeMetric.addAndroidMemoryReadings(n10, androidMemoryReading);
    }

    public static /* synthetic */ void access$1600(GaugeMetric gaugeMetric, Iterable iterable) {
        gaugeMetric.addAllAndroidMemoryReadings(iterable);
    }

    public static /* synthetic */ void access$1700(GaugeMetric gaugeMetric) {
        gaugeMetric.clearAndroidMemoryReadings();
    }

    public static /* synthetic */ void access$1800(GaugeMetric gaugeMetric, int n10) {
        gaugeMetric.removeAndroidMemoryReadings(n10);
    }

    public static /* synthetic */ void access$200(GaugeMetric gaugeMetric) {
        gaugeMetric.clearSessionId();
    }

    public static /* synthetic */ void access$300(GaugeMetric gaugeMetric, ByteString byteString) {
        gaugeMetric.setSessionIdBytes(byteString);
    }

    public static /* synthetic */ void access$400(GaugeMetric gaugeMetric, GaugeMetadata gaugeMetadata) {
        gaugeMetric.setGaugeMetadata(gaugeMetadata);
    }

    public static /* synthetic */ void access$500(GaugeMetric gaugeMetric, GaugeMetadata gaugeMetadata) {
        gaugeMetric.mergeGaugeMetadata(gaugeMetadata);
    }

    public static /* synthetic */ void access$600(GaugeMetric gaugeMetric) {
        gaugeMetric.clearGaugeMetadata();
    }

    public static /* synthetic */ void access$700(GaugeMetric gaugeMetric, int n10, CpuMetricReading cpuMetricReading) {
        gaugeMetric.setCpuMetricReadings(n10, cpuMetricReading);
    }

    public static /* synthetic */ void access$800(GaugeMetric gaugeMetric, CpuMetricReading cpuMetricReading) {
        gaugeMetric.addCpuMetricReadings(cpuMetricReading);
    }

    public static /* synthetic */ void access$900(GaugeMetric gaugeMetric, int n10, CpuMetricReading cpuMetricReading) {
        gaugeMetric.addCpuMetricReadings(n10, cpuMetricReading);
    }

    private void addAllAndroidMemoryReadings(Iterable iterable) {
        this.ensureAndroidMemoryReadingsIsMutable();
        Internal$ProtobufList internal$ProtobufList = this.androidMemoryReadings_;
        AbstractMessageLite.addAll(iterable, internal$ProtobufList);
    }

    private void addAllCpuMetricReadings(Iterable iterable) {
        this.ensureCpuMetricReadingsIsMutable();
        Internal$ProtobufList internal$ProtobufList = this.cpuMetricReadings_;
        AbstractMessageLite.addAll(iterable, internal$ProtobufList);
    }

    private void addAndroidMemoryReadings(int n10, AndroidMemoryReading androidMemoryReading) {
        androidMemoryReading.getClass();
        this.ensureAndroidMemoryReadingsIsMutable();
        this.androidMemoryReadings_.add(n10, androidMemoryReading);
    }

    private void addAndroidMemoryReadings(AndroidMemoryReading androidMemoryReading) {
        androidMemoryReading.getClass();
        this.ensureAndroidMemoryReadingsIsMutable();
        this.androidMemoryReadings_.add(androidMemoryReading);
    }

    private void addCpuMetricReadings(int n10, CpuMetricReading cpuMetricReading) {
        cpuMetricReading.getClass();
        this.ensureCpuMetricReadingsIsMutable();
        this.cpuMetricReadings_.add(n10, cpuMetricReading);
    }

    private void addCpuMetricReadings(CpuMetricReading cpuMetricReading) {
        cpuMetricReading.getClass();
        this.ensureCpuMetricReadingsIsMutable();
        this.cpuMetricReadings_.add(cpuMetricReading);
    }

    private void clearAndroidMemoryReadings() {
        Internal$ProtobufList internal$ProtobufList;
        this.androidMemoryReadings_ = internal$ProtobufList = GeneratedMessageLite.emptyProtobufList();
    }

    private void clearCpuMetricReadings() {
        Internal$ProtobufList internal$ProtobufList;
        this.cpuMetricReadings_ = internal$ProtobufList = GeneratedMessageLite.emptyProtobufList();
    }

    private void clearGaugeMetadata() {
        int n10;
        this.gaugeMetadata_ = null;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFD;
    }

    private void clearSessionId() {
        String string2;
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFE;
        this.sessionId_ = string2 = GaugeMetric.getDefaultInstance().getSessionId();
    }

    private void ensureAndroidMemoryReadingsIsMutable() {
        Internal$ProtobufList internal$ProtobufList = this.androidMemoryReadings_;
        boolean bl2 = internal$ProtobufList.isModifiable();
        if (!bl2) {
            this.androidMemoryReadings_ = internal$ProtobufList = GeneratedMessageLite.mutableCopy(internal$ProtobufList);
        }
    }

    private void ensureCpuMetricReadingsIsMutable() {
        Internal$ProtobufList internal$ProtobufList = this.cpuMetricReadings_;
        boolean bl2 = internal$ProtobufList.isModifiable();
        if (!bl2) {
            this.cpuMetricReadings_ = internal$ProtobufList = GeneratedMessageLite.mutableCopy(internal$ProtobufList);
        }
    }

    public static GaugeMetric getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeGaugeMetadata(GaugeMetadata gaugeMetadata) {
        int n10;
        GaugeMetadata gaugeMetadata2;
        gaugeMetadata.getClass();
        GaugeMetadataOrBuilder gaugeMetadataOrBuilder = this.gaugeMetadata_;
        if (gaugeMetadataOrBuilder != null && gaugeMetadataOrBuilder != (gaugeMetadata2 = GaugeMetadata.getDefaultInstance())) {
            gaugeMetadataOrBuilder = GaugeMetadata.newBuilder(this.gaugeMetadata_);
            this.gaugeMetadata_ = gaugeMetadata = (GaugeMetadata)((GaugeMetadata$Builder)((GeneratedMessageLite$Builder)((Object)gaugeMetadataOrBuilder)).mergeFrom(gaugeMetadata)).buildPartial();
        } else {
            this.gaugeMetadata_ = gaugeMetadata;
        }
        this.bitField0_ = n10 = this.bitField0_ | 2;
    }

    public static GaugeMetric$Builder newBuilder() {
        return (GaugeMetric$Builder)DEFAULT_INSTANCE.createBuilder();
    }

    public static GaugeMetric$Builder newBuilder(GaugeMetric gaugeMetric) {
        return (GaugeMetric$Builder)DEFAULT_INSTANCE.createBuilder(gaugeMetric);
    }

    public static GaugeMetric parseDelimitedFrom(InputStream inputStream) {
        return (GaugeMetric)GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GaugeMetric parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (GaugeMetric)GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static GaugeMetric parseFrom(ByteString byteString) {
        return (GaugeMetric)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, byteString);
    }

    public static GaugeMetric parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (GaugeMetric)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static GaugeMetric parseFrom(CodedInputStream codedInputStream) {
        return (GaugeMetric)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, codedInputStream);
    }

    public static GaugeMetric parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (GaugeMetric)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static GaugeMetric parseFrom(InputStream inputStream) {
        return (GaugeMetric)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, inputStream);
    }

    public static GaugeMetric parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (GaugeMetric)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static GaugeMetric parseFrom(ByteBuffer byteBuffer) {
        return (GaugeMetric)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, byteBuffer);
    }

    public static GaugeMetric parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (GaugeMetric)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static GaugeMetric parseFrom(byte[] byArray) {
        return (GaugeMetric)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, byArray);
    }

    public static GaugeMetric parseFrom(byte[] byArray, ExtensionRegistryLite extensionRegistryLite) {
        return (GaugeMetric)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, byArray, extensionRegistryLite);
    }

    public static Parser parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeAndroidMemoryReadings(int n10) {
        this.ensureAndroidMemoryReadingsIsMutable();
        this.androidMemoryReadings_.remove(n10);
    }

    private void removeCpuMetricReadings(int n10) {
        this.ensureCpuMetricReadingsIsMutable();
        this.cpuMetricReadings_.remove(n10);
    }

    private void setAndroidMemoryReadings(int n10, AndroidMemoryReading androidMemoryReading) {
        androidMemoryReading.getClass();
        this.ensureAndroidMemoryReadingsIsMutable();
        this.androidMemoryReadings_.set(n10, androidMemoryReading);
    }

    private void setCpuMetricReadings(int n10, CpuMetricReading cpuMetricReading) {
        cpuMetricReading.getClass();
        this.ensureCpuMetricReadingsIsMutable();
        this.cpuMetricReadings_.set(n10, cpuMetricReading);
    }

    private void setGaugeMetadata(GaugeMetadata gaugeMetadata) {
        int n10;
        gaugeMetadata.getClass();
        this.gaugeMetadata_ = gaugeMetadata;
        this.bitField0_ = n10 = this.bitField0_ | 2;
    }

    private void setSessionId(String string2) {
        int n10;
        string2.getClass();
        this.bitField0_ = n10 = this.bitField0_ | 1;
        this.sessionId_ = string2;
    }

    private void setSessionIdBytes(ByteString object) {
        int n10;
        this.sessionId_ = object = ((ByteString)object).toStringUtf8();
        this.bitField0_ = n10 = this.bitField0_ | 1;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object dynamicMethod(GeneratedMessageLite$MethodToInvoke objectArray, Object clazz, Object object) {
        clazz = (Class<GaugeMetric>)GaugeMetric$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke;
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
                clazz = GaugeMetric.class;
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
                objectArray = new Object[7];
                objectArray[0] = "bitField0_";
                objectArray[by2] = "sessionId_";
                objectArray[2] = "cpuMetricReadings_";
                objectArray[3] = CpuMetricReading.class;
                objectArray[4] = "gaugeMetadata_";
                objectArray[5] = "androidMemoryReadings_";
                objectArray[6] = AndroidMemoryReading.class;
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0002\u0000\u0001\u1008\u0000\u0002\u001b\u0003\u1009\u0001\u0004\u001b", objectArray);
            }
            case 2: {
                return new GaugeMetric$Builder(null);
            }
            case 1: 
        }
        return new GaugeMetric();
    }

    public AndroidMemoryReading getAndroidMemoryReadings(int n10) {
        return (AndroidMemoryReading)this.androidMemoryReadings_.get(n10);
    }

    public int getAndroidMemoryReadingsCount() {
        return this.androidMemoryReadings_.size();
    }

    public List getAndroidMemoryReadingsList() {
        return this.androidMemoryReadings_;
    }

    public AndroidMemoryReadingOrBuilder getAndroidMemoryReadingsOrBuilder(int n10) {
        return (AndroidMemoryReadingOrBuilder)this.androidMemoryReadings_.get(n10);
    }

    public List getAndroidMemoryReadingsOrBuilderList() {
        return this.androidMemoryReadings_;
    }

    public CpuMetricReading getCpuMetricReadings(int n10) {
        return (CpuMetricReading)this.cpuMetricReadings_.get(n10);
    }

    public int getCpuMetricReadingsCount() {
        return this.cpuMetricReadings_.size();
    }

    public List getCpuMetricReadingsList() {
        return this.cpuMetricReadings_;
    }

    public CpuMetricReadingOrBuilder getCpuMetricReadingsOrBuilder(int n10) {
        return (CpuMetricReadingOrBuilder)this.cpuMetricReadings_.get(n10);
    }

    public List getCpuMetricReadingsOrBuilderList() {
        return this.cpuMetricReadings_;
    }

    public GaugeMetadata getGaugeMetadata() {
        GaugeMetadata gaugeMetadata = this.gaugeMetadata_;
        if (gaugeMetadata == null) {
            gaugeMetadata = GaugeMetadata.getDefaultInstance();
        }
        return gaugeMetadata;
    }

    public String getSessionId() {
        return this.sessionId_;
    }

    public ByteString getSessionIdBytes() {
        return ByteString.copyFromUtf8(this.sessionId_);
    }

    public boolean hasGaugeMetadata() {
        int n10 = this.bitField0_ & 2;
        n10 = n10 != 0 ? 1 : 0;
        return n10 != 0;
    }

    public boolean hasSessionId() {
        int n10 = this.bitField0_;
        int n11 = 1;
        if ((n10 &= n11) == 0) {
            n11 = 0;
        }
        return n11 != 0;
    }
}

