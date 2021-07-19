/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.network;

import cn.leancloud.network.NetworkingDetector$NetworkType;

public interface NetworkingDetector {
    public NetworkingDetector$NetworkType getNetworkType();

    public boolean isConnected();
}

