/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.perf.v1;

import com.google.firebase.perf.v1.GaugeMetadata$1;
import com.google.firebase.perf.v1.GaugeMetadata$Builder;
import com.google.firebase.perf.v1.GaugeMetadataOrBuilder;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.GeneratedMessageLite$DefaultInstanceBasedParser;
import com.google.protobuf.GeneratedMessageLite$MethodToInvoke;
import com.google.protobuf.Parser;
import java.io.InputStream;
import java.nio.ByteBuffer;

public final class GaugeMetadata
extends GeneratedMessageLite
implements GaugeMetadataOrBuilder {
    public static final int CPU_CLOCK_RATE_KHZ_FIELD_NUMBER = 2;
    public static final int CPU_PROCESSOR_COUNT_FIELD_NUMBER = 6;
    private static final GaugeMetadata DEFAULT_INSTANCE;
    public static final int DEVICE_RAM_SIZE_KB_FIELD_NUMBER = 3;
    public static final int MAX_APP_JAVA_HEAP_MEMORY_KB_FIELD_NUMBER = 4;
    public static final int MAX_ENCOURAGED_APP_JAVA_HEAP_MEMORY_KB_FIELD_NUMBER = 5;
    private static volatile Parser PARSER;
    public static final int PROCESS_NAME_FIELD_NUMBER = 1;
    private int bitField0_;
    private int cpuClockRateKhz_;
    private int cpuProcessorCount_;
    private int deviceRamSizeKb_;
    private int maxAppJavaHeapMemoryKb_;
    private int maxEncouragedAppJavaHeapMemoryKb_;
    private String processName_ = "";

    static {
        GaugeMetadata gaugeMetadata;
        DEFAULT_INSTANCE = gaugeMetadata = new GaugeMetadata();
        GeneratedMessageLite.registerDefaultInstance(GaugeMetadata.class, gaugeMetadata);
    }

    private GaugeMetadata() {
    }

    public static /* synthetic */ GaugeMetadata access$000() {
        return DEFAULT_INSTANCE;
    }

    public static /* synthetic */ void access$100(GaugeMetadata gaugeMetadata, String string2) {
        gaugeMetadata.setProcessName(string2);
    }

    public static /* synthetic */ void access$1000(GaugeMetadata gaugeMetadata, int n10) {
        gaugeMetadata.setMaxAppJavaHeapMemoryKb(n10);
    }

    public static /* synthetic */ void access$1100(GaugeMetadata gaugeMetadata) {
        gaugeMetadata.clearMaxAppJavaHeapMemoryKb();
    }

    public static /* synthetic */ void access$1200(GaugeMetadata gaugeMetadata, int n10) {
        gaugeMetadata.setMaxEncouragedAppJavaHeapMemoryKb(n10);
    }

    public static /* synthetic */ void access$1300(GaugeMetadata gaugeMetadata) {
        gaugeMetadata.clearMaxEncouragedAppJavaHeapMemoryKb();
    }

    public static /* synthetic */ void access$200(GaugeMetadata gaugeMetadata) {
        gaugeMetadata.clearProcessName();
    }

    public static /* synthetic */ void access$300(GaugeMetadata gaugeMetadata, ByteString byteString) {
        gaugeMetadata.setProcessNameBytes(byteString);
    }

    public static /* synthetic */ void access$400(GaugeMetadata gaugeMetadata, int n10) {
        gaugeMetadata.setCpuClockRateKhz(n10);
    }

    public static /* synthetic */ void access$500(GaugeMetadata gaugeMetadata) {
        gaugeMetadata.clearCpuClockRateKhz();
    }

    public static /* synthetic */ void access$600(GaugeMetadata gaugeMetadata, int n10) {
        gaugeMetadata.setCpuProcessorCount(n10);
    }

    public static /* synthetic */ void access$700(GaugeMetadata gaugeMetadata) {
        gaugeMetadata.clearCpuProcessorCount();
    }

    public static /* synthetic */ void access$800(GaugeMetadata gaugeMetadata, int n10) {
        gaugeMetadata.setDeviceRamSizeKb(n10);
    }

    public static /* synthetic */ void access$900(GaugeMetadata gaugeMetadata) {
        gaugeMetadata.clearDeviceRamSizeKb();
    }

    private void clearCpuClockRateKhz() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFD;
        this.cpuClockRateKhz_ = 0;
    }

    private void clearCpuProcessorCount() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFB;
        this.cpuProcessorCount_ = 0;
    }

    private void clearDeviceRamSizeKb() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFF7;
        this.deviceRamSizeKb_ = 0;
    }

    private void clearMaxAppJavaHeapMemoryKb() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFEF;
        this.maxAppJavaHeapMemoryKb_ = 0;
    }

    private void clearMaxEncouragedAppJavaHeapMemoryKb() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFDF;
        this.maxEncouragedAppJavaHeapMemoryKb_ = 0;
    }

    private void clearProcessName() {
        String string2;
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFE;
        this.processName_ = string2 = GaugeMetadata.getDefaultInstance().getProcessName();
    }

    public static GaugeMetadata getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static GaugeMetadata$Builder newBuilder() {
        return (GaugeMetadata$Builder)DEFAULT_INSTANCE.createBuilder();
    }

    public static GaugeMetadata$Builder newBuilder(GaugeMetadata gaugeMetadata) {
        return (GaugeMetadata$Builder)DEFAULT_INSTANCE.createBuilder(gaugeMetadata);
    }

    public static GaugeMetadata parseDelimitedFrom(InputStream inputStream) {
        return (GaugeMetadata)GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GaugeMetadata parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (GaugeMetadata)GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static GaugeMetadata parseFrom(ByteString byteString) {
        return (GaugeMetadata)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, byteString);
    }

    public static GaugeMetadata parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (GaugeMetadata)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static GaugeMetadata parseFrom(CodedInputStream codedInputStream) {
        return (GaugeMetadata)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, codedInputStream);
    }

    public static GaugeMetadata parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (GaugeMetadata)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static GaugeMetadata parseFrom(InputStream inputStream) {
        return (GaugeMetadata)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, inputStream);
    }

    public static GaugeMetadata parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (GaugeMetadata)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static GaugeMetadata parseFrom(ByteBuffer byteBuffer) {
        return (GaugeMetadata)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, byteBuffer);
    }

    public static GaugeMetadata parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (GaugeMetadata)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static GaugeMetadata parseFrom(byte[] byArray) {
        return (GaugeMetadata)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, byArray);
    }

    public static GaugeMetadata parseFrom(byte[] byArray, ExtensionRegistryLite extensionRegistryLite) {
        return (GaugeMetadata)GeneratedMessageLite.parseFrom((GeneratedMessageLite)DEFAULT_INSTANCE, byArray, extensionRegistryLite);
    }

    public static Parser parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setCpuClockRateKhz(int n10) {
        int n11;
        this.bitField0_ = n11 = this.bitField0_ | 2;
        this.cpuClockRateKhz_ = n10;
    }

    private void setCpuProcessorCount(int n10) {
        int n11;
        this.bitField0_ = n11 = this.bitField0_ | 4;
        this.cpuProcessorCount_ = n10;
    }

    private void setDeviceRamSizeKb(int n10) {
        int n11;
        this.bitField0_ = n11 = this.bitField0_ | 8;
        this.deviceRamSizeKb_ = n10;
    }

    private void setMaxAppJavaHeapMemoryKb(int n10) {
        int n11;
        this.bitField0_ = n11 = this.bitField0_ | 0x10;
        this.maxAppJavaHeapMemoryKb_ = n10;
    }

    private void setMaxEncouragedAppJavaHeapMemoryKb(int n10) {
        int n11;
        this.bitField0_ = n11 = this.bitField0_ | 0x20;
        this.maxEncouragedAppJavaHeapMemoryKb_ = n10;
    }

    private void setProcessName(String string2) {
        int n10;
        string2.getClass();
        this.bitField0_ = n10 = this.bitField0_ | 1;
        this.processName_ = string2;
    }

    private void setProcessNameBytes(ByteString object) {
        int n10;
        this.processName_ = object = ((ByteString)object).toStringUtf8();
        this.bitField0_ = n10 = this.bitField0_ | 1;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object dynamicMethod(GeneratedMessageLite$MethodToInvoke objectArray, Object clazz, Object object) {
        clazz = (Class<GaugeMetadata>)GaugeMetadata$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke;
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
                clazz = GaugeMetadata.class;
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
                objectArray[by2] = "processName_";
                objectArray[2] = "cpuClockRateKhz_";
                objectArray[3] = "deviceRamSizeKb_";
                objectArray[4] = "maxAppJavaHeapMemoryKb_";
                objectArray[5] = "maxEncouragedAppJavaHeapMemoryKb_";
                objectArray[6] = "cpuProcessorCount_";
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001\u1008\u0000\u0002\u1004\u0001\u0003\u1004\u0003\u0004\u1004\u0004\u0005\u1004\u0005\u0006\u1004\u0002", objectArray);
            }
            case 2: {
                return new GaugeMetadata$Builder(null);
            }
            case 1: 
        }
        return new GaugeMetadata();
    }

    public int getCpuClockRateKhz() {
        return this.cpuClockRateKhz_;
    }

    public int getCpuProcessorCount() {
        return this.cpuProcessorCount_;
    }

    public int getDeviceRamSizeKb() {
        return this.deviceRamSizeKb_;
    }

    public int getMaxAppJavaHeapMemoryKb() {
        return this.maxAppJavaHeapMemoryKb_;
    }

    public int getMaxEncouragedAppJavaHeapMemoryKb() {
        return this.maxEncouragedAppJavaHeapMemoryKb_;
    }

    public String getProcessName() {
        return this.processName_;
    }

    public ByteString getProcessNameBytes() {
        return ByteString.copyFromUtf8(this.processName_);
    }

    public boolean hasCpuClockRateKhz() {
        int n10 = this.bitField0_ & 2;
        n10 = n10 != 0 ? 1 : 0;
        return n10 != 0;
    }

    public boolean hasCpuProcessorCount() {
        int n10 = this.bitField0_ & 4;
        n10 = n10 != 0 ? 1 : 0;
        return n10 != 0;
    }

    public boolean hasDeviceRamSizeKb() {
        int n10 = this.bitField0_ & 8;
        n10 = n10 != 0 ? 1 : 0;
        return n10 != 0;
    }

    public boolean hasMaxAppJavaHeapMemoryKb() {
        int n10 = this.bitField0_ & 0x10;
        n10 = n10 != 0 ? 1 : 0;
        return n10 != 0;
    }

    public boolean hasMaxEncouragedAppJavaHeapMemoryKb() {
        int n10 = this.bitField0_ & 0x20;
        n10 = n10 != 0 ? 1 : 0;
        return n10 != 0;
    }

    public boolean hasProcessName() {
        int n10 = this.bitField0_;
        int n11 = 1;
        if ((n10 &= n11) == 0) {
            n11 = 0;
        }
        return n11 != 0;
    }
}

