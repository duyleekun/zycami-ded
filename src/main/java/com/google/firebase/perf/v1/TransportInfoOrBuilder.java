/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.perf.v1;

import com.google.firebase.perf.v1.TransportInfo$DispatchDestination;
import com.google.protobuf.MessageLiteOrBuilder;

public interface TransportInfoOrBuilder
extends MessageLiteOrBuilder {
    public TransportInfo$DispatchDestination getDispatchDestination();

    public boolean hasDispatchDestination();
}

