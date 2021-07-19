/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.perf.v1;

import com.google.firebase.perf.v1.GaugeMetadata;
import com.google.firebase.perf.v1.GaugeMetadata$1;
import com.google.firebase.perf.v1.GaugeMetadataOrBuilder;
import com.google.protobuf.ByteString;
import com.google.protobuf.GeneratedMessageLite$Builder;

public final class GaugeMetadata$Builder
extends GeneratedMessageLite$Builder
implements GaugeMetadataOrBuilder {
    private GaugeMetadata$Builder() {
        GaugeMetadata gaugeMetadata = GaugeMetadata.access$000();
        super(gaugeMetadata);
    }

    public /* synthetic */ GaugeMetadata$Builder(GaugeMetadata$1 gaugeMetadata$1) {
        this();
    }

    public GaugeMetadata$Builder clearCpuClockRateKhz() {
        this.copyOnWrite();
        GaugeMetadata.access$500((GaugeMetadata)this.instance);
        return this;
    }

    public GaugeMetadata$Builder clearCpuProcessorCount() {
        this.copyOnWrite();
        GaugeMetadata.access$700((GaugeMetadata)this.instance);
        return this;
    }

    public GaugeMetadata$Builder clearDeviceRamSizeKb() {
        this.copyOnWrite();
        GaugeMetadata.access$900((GaugeMetadata)this.instance);
        return this;
    }

    public GaugeMetadata$Builder clearMaxAppJavaHeapMemoryKb() {
        this.copyOnWrite();
        GaugeMetadata.access$1100((GaugeMetadata)this.instance);
        return this;
    }

    public GaugeMetadata$Builder clearMaxEncouragedAppJavaHeapMemoryKb() {
        this.copyOnWrite();
        GaugeMetadata.access$1300((GaugeMetadata)this.instance);
        return this;
    }

    public GaugeMetadata$Builder clearProcessName() {
        this.copyOnWrite();
        GaugeMetadata.access$200((GaugeMetadata)this.instance);
        return this;
    }

    public int getCpuClockRateKhz() {
        return ((GaugeMetadata)this.instance).getCpuClockRateKhz();
    }

    public int getCpuProcessorCount() {
        return ((GaugeMetadata)this.instance).getCpuProcessorCount();
    }

    public int getDeviceRamSizeKb() {
        return ((GaugeMetadata)this.instance).getDeviceRamSizeKb();
    }

    public int getMaxAppJavaHeapMemoryKb() {
        return ((GaugeMetadata)this.instance).getMaxAppJavaHeapMemoryKb();
    }

    public int getMaxEncouragedAppJavaHeapMemoryKb() {
        return ((GaugeMetadata)this.instance).getMaxEncouragedAppJavaHeapMemoryKb();
    }

    public String getProcessName() {
        return ((GaugeMetadata)this.instance).getProcessName();
    }

    public ByteString getProcessNameBytes() {
        return ((GaugeMetadata)this.instance).getProcessNameBytes();
    }

    public boolean hasCpuClockRateKhz() {
        return ((GaugeMetadata)this.instance).hasCpuClockRateKhz();
    }

    public boolean hasCpuProcessorCount() {
        return ((GaugeMetadata)this.instance).hasCpuProcessorCount();
    }

    public boolean hasDeviceRamSizeKb() {
        return ((GaugeMetadata)this.instance).hasDeviceRamSizeKb();
    }

    public boolean hasMaxAppJavaHeapMemoryKb() {
        return ((GaugeMetadata)this.instance).hasMaxAppJavaHeapMemoryKb();
    }

    public boolean hasMaxEncouragedAppJavaHeapMemoryKb() {
        return ((GaugeMetadata)this.instance).hasMaxEncouragedAppJavaHeapMemoryKb();
    }

    public boolean hasProcessName() {
        return ((GaugeMetadata)this.instance).hasProcessName();
    }

    public GaugeMetadata$Builder setCpuClockRateKhz(int n10) {
        this.copyOnWrite();
        GaugeMetadata.access$400((GaugeMetadata)this.instance, n10);
        return this;
    }

    public GaugeMetadata$Builder setCpuProcessorCount(int n10) {
        this.copyOnWrite();
        GaugeMetadata.access$600((GaugeMetadata)this.instance, n10);
        return this;
    }

    public GaugeMetadata$Builder setDeviceRamSizeKb(int n10) {
        this.copyOnWrite();
        GaugeMetadata.access$800((GaugeMetadata)this.instance, n10);
        return this;
    }

    public GaugeMetadata$Builder setMaxAppJavaHeapMemoryKb(int n10) {
        this.copyOnWrite();
        GaugeMetadata.access$1000((GaugeMetadata)this.instance, n10);
        return this;
    }

    public GaugeMetadata$Builder setMaxEncouragedAppJavaHeapMemoryKb(int n10) {
        this.copyOnWrite();
        GaugeMetadata.access$1200((GaugeMetadata)this.instance, n10);
        return this;
    }

    public GaugeMetadata$Builder setProcessName(String string2) {
        this.copyOnWrite();
        GaugeMetadata.access$100((GaugeMetadata)this.instance, string2);
        return this;
    }

    public GaugeMetadata$Builder setProcessNameBytes(ByteString byteString) {
        this.copyOnWrite();
        GaugeMetadata.access$300((GaugeMetadata)this.instance, byteString);
        return this;
    }
}

