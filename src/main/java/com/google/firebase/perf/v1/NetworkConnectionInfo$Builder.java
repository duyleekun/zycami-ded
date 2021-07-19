/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.perf.v1;

import com.google.firebase.perf.v1.NetworkConnectionInfo;
import com.google.firebase.perf.v1.NetworkConnectionInfo$1;
import com.google.firebase.perf.v1.NetworkConnectionInfo$MobileSubtype;
import com.google.firebase.perf.v1.NetworkConnectionInfo$NetworkType;
import com.google.firebase.perf.v1.NetworkConnectionInfoOrBuilder;
import com.google.protobuf.GeneratedMessageLite$Builder;

public final class NetworkConnectionInfo$Builder
extends GeneratedMessageLite$Builder
implements NetworkConnectionInfoOrBuilder {
    private NetworkConnectionInfo$Builder() {
        NetworkConnectionInfo networkConnectionInfo = NetworkConnectionInfo.access$000();
        super(networkConnectionInfo);
    }

    public /* synthetic */ NetworkConnectionInfo$Builder(NetworkConnectionInfo$1 networkConnectionInfo$1) {
        this();
    }

    public NetworkConnectionInfo$Builder clearMobileSubtype() {
        this.copyOnWrite();
        NetworkConnectionInfo.access$400((NetworkConnectionInfo)this.instance);
        return this;
    }

    public NetworkConnectionInfo$Builder clearNetworkType() {
        this.copyOnWrite();
        NetworkConnectionInfo.access$200((NetworkConnectionInfo)this.instance);
        return this;
    }

    public NetworkConnectionInfo$MobileSubtype getMobileSubtype() {
        return ((NetworkConnectionInfo)this.instance).getMobileSubtype();
    }

    public NetworkConnectionInfo$NetworkType getNetworkType() {
        return ((NetworkConnectionInfo)this.instance).getNetworkType();
    }

    public boolean hasMobileSubtype() {
        return ((NetworkConnectionInfo)this.instance).hasMobileSubtype();
    }

    public boolean hasNetworkType() {
        return ((NetworkConnectionInfo)this.instance).hasNetworkType();
    }

    public NetworkConnectionInfo$Builder setMobileSubtype(NetworkConnectionInfo$MobileSubtype networkConnectionInfo$MobileSubtype) {
        this.copyOnWrite();
        NetworkConnectionInfo.access$300((NetworkConnectionInfo)this.instance, networkConnectionInfo$MobileSubtype);
        return this;
    }

    public NetworkConnectionInfo$Builder setNetworkType(NetworkConnectionInfo$NetworkType networkConnectionInfo$NetworkType) {
        this.copyOnWrite();
        NetworkConnectionInfo.access$100((NetworkConnectionInfo)this.instance, networkConnectionInfo$NetworkType);
        return this;
    }
}

