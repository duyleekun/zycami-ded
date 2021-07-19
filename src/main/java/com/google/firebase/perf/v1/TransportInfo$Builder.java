/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.perf.v1;

import com.google.firebase.perf.v1.TransportInfo;
import com.google.firebase.perf.v1.TransportInfo$1;
import com.google.firebase.perf.v1.TransportInfo$DispatchDestination;
import com.google.firebase.perf.v1.TransportInfoOrBuilder;
import com.google.protobuf.GeneratedMessageLite$Builder;

public final class TransportInfo$Builder
extends GeneratedMessageLite$Builder
implements TransportInfoOrBuilder {
    private TransportInfo$Builder() {
        TransportInfo transportInfo = TransportInfo.access$000();
        super(transportInfo);
    }

    public /* synthetic */ TransportInfo$Builder(TransportInfo$1 transportInfo$1) {
        this();
    }

    public TransportInfo$Builder clearDispatchDestination() {
        this.copyOnWrite();
        TransportInfo.access$200((TransportInfo)this.instance);
        return this;
    }

    public TransportInfo$DispatchDestination getDispatchDestination() {
        return ((TransportInfo)this.instance).getDispatchDestination();
    }

    public boolean hasDispatchDestination() {
        return ((TransportInfo)this.instance).hasDispatchDestination();
    }

    public TransportInfo$Builder setDispatchDestination(TransportInfo$DispatchDestination transportInfo$DispatchDestination) {
        this.copyOnWrite();
        TransportInfo.access$100((TransportInfo)this.instance, transportInfo$DispatchDestination);
        return this;
    }
}

