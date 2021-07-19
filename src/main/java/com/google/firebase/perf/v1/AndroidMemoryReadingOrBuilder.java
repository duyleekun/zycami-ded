/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.perf.v1;

import com.google.protobuf.MessageLiteOrBuilder;

public interface AndroidMemoryReadingOrBuilder
extends MessageLiteOrBuilder {
    public long getClientTimeUs();

    public int getUsedAppJavaHeapMemoryKb();

    public boolean hasClientTimeUs();

    public boolean hasUsedAppJavaHeapMemoryKb();
}

