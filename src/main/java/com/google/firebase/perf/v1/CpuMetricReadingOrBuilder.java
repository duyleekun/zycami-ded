/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.perf.v1;

import com.google.protobuf.MessageLiteOrBuilder;

public interface CpuMetricReadingOrBuilder
extends MessageLiteOrBuilder {
    public long getClientTimeUs();

    public long getSystemTimeUs();

    public long getUserTimeUs();

    public boolean hasClientTimeUs();

    public boolean hasSystemTimeUs();

    public boolean hasUserTimeUs();
}

