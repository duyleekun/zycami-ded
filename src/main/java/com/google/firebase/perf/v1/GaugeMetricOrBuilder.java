/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.perf.v1;

import com.google.firebase.perf.v1.AndroidMemoryReading;
import com.google.firebase.perf.v1.CpuMetricReading;
import com.google.firebase.perf.v1.GaugeMetadata;
import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;
import java.util.List;

public interface GaugeMetricOrBuilder
extends MessageLiteOrBuilder {
    public AndroidMemoryReading getAndroidMemoryReadings(int var1);

    public int getAndroidMemoryReadingsCount();

    public List getAndroidMemoryReadingsList();

    public CpuMetricReading getCpuMetricReadings(int var1);

    public int getCpuMetricReadingsCount();

    public List getCpuMetricReadingsList();

    public GaugeMetadata getGaugeMetadata();

    public String getSessionId();

    public ByteString getSessionIdBytes();

    public boolean hasGaugeMetadata();

    public boolean hasSessionId();
}

