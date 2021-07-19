/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.perf.v1;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;

public interface GaugeMetadataOrBuilder
extends MessageLiteOrBuilder {
    public int getCpuClockRateKhz();

    public int getCpuProcessorCount();

    public int getDeviceRamSizeKb();

    public int getMaxAppJavaHeapMemoryKb();

    public int getMaxEncouragedAppJavaHeapMemoryKb();

    public String getProcessName();

    public ByteString getProcessNameBytes();

    public boolean hasCpuClockRateKhz();

    public boolean hasCpuProcessorCount();

    public boolean hasDeviceRamSizeKb();

    public boolean hasMaxAppJavaHeapMemoryKb();

    public boolean hasMaxEncouragedAppJavaHeapMemoryKb();

    public boolean hasProcessName();
}

