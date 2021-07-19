/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.perf.v1;

import com.google.firebase.perf.v1.AndroidMemoryReading;
import com.google.firebase.perf.v1.AndroidMemoryReading$1;
import com.google.firebase.perf.v1.AndroidMemoryReadingOrBuilder;
import com.google.protobuf.GeneratedMessageLite$Builder;

public final class AndroidMemoryReading$Builder
extends GeneratedMessageLite$Builder
implements AndroidMemoryReadingOrBuilder {
    private AndroidMemoryReading$Builder() {
        AndroidMemoryReading androidMemoryReading = AndroidMemoryReading.access$000();
        super(androidMemoryReading);
    }

    public /* synthetic */ AndroidMemoryReading$Builder(AndroidMemoryReading$1 androidMemoryReading$1) {
        this();
    }

    public AndroidMemoryReading$Builder clearClientTimeUs() {
        this.copyOnWrite();
        AndroidMemoryReading.access$200((AndroidMemoryReading)this.instance);
        return this;
    }

    public AndroidMemoryReading$Builder clearUsedAppJavaHeapMemoryKb() {
        this.copyOnWrite();
        AndroidMemoryReading.access$400((AndroidMemoryReading)this.instance);
        return this;
    }

    public long getClientTimeUs() {
        return ((AndroidMemoryReading)this.instance).getClientTimeUs();
    }

    public int getUsedAppJavaHeapMemoryKb() {
        return ((AndroidMemoryReading)this.instance).getUsedAppJavaHeapMemoryKb();
    }

    public boolean hasClientTimeUs() {
        return ((AndroidMemoryReading)this.instance).hasClientTimeUs();
    }

    public boolean hasUsedAppJavaHeapMemoryKb() {
        return ((AndroidMemoryReading)this.instance).hasUsedAppJavaHeapMemoryKb();
    }

    public AndroidMemoryReading$Builder setClientTimeUs(long l10) {
        this.copyOnWrite();
        AndroidMemoryReading.access$100((AndroidMemoryReading)this.instance, l10);
        return this;
    }

    public AndroidMemoryReading$Builder setUsedAppJavaHeapMemoryKb(int n10) {
        this.copyOnWrite();
        AndroidMemoryReading.access$300((AndroidMemoryReading)this.instance, n10);
        return this;
    }
}

