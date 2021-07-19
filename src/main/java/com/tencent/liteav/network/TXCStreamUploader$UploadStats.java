/*
 * Decompiled with CFR 0.151.
 */
package com.tencent.liteav.network;

import com.tencent.liteav.network.TXCStreamUploader;

public class TXCStreamUploader$UploadStats {
    public long audioCacheLen;
    public long audioDropCount;
    public long bandwidthEst;
    public long channelType;
    public long connTS;
    public long connectTimeCost;
    public String connectionID;
    public String connectionStats;
    public long dnsTS;
    public long dnsparseTimeCost;
    public long handshakeTimeCost;
    public long inAudioBytes;
    public long inVideoBytes;
    public long outAudioBytes;
    public long outVideoBytes;
    public String serverIP;
    public long startTS;
    public final /* synthetic */ TXCStreamUploader this$0;
    public long videoCacheLen;
    public long videoDropCount;

    public TXCStreamUploader$UploadStats(TXCStreamUploader tXCStreamUploader) {
        this.this$0 = tXCStreamUploader;
    }
}

