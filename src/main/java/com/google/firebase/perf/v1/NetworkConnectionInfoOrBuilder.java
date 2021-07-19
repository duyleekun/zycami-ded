/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.perf.v1;

import com.google.firebase.perf.v1.NetworkConnectionInfo$MobileSubtype;
import com.google.firebase.perf.v1.NetworkConnectionInfo$NetworkType;
import com.google.protobuf.MessageLiteOrBuilder;

public interface NetworkConnectionInfoOrBuilder
extends MessageLiteOrBuilder {
    public NetworkConnectionInfo$MobileSubtype getMobileSubtype();

    public NetworkConnectionInfo$NetworkType getNetworkType();

    public boolean hasMobileSubtype();

    public boolean hasNetworkType();
}

