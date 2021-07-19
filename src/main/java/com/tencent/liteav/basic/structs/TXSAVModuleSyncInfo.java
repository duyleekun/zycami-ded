/*
 * Decompiled with CFR 0.151.
 */
package com.tencent.liteav.basic.structs;

public class TXSAVModuleSyncInfo {
    public long mCurrentDelayMs;
    public long mLatestReceiveTimeMs;
    public long mLatestReceivedCaptureTimestamp;

    public TXSAVModuleSyncInfo() {
        long l10;
        this.mLatestReceiveTimeMs = l10 = 0L;
        this.mLatestReceivedCaptureTimestamp = l10;
        this.mCurrentDelayMs = l10;
    }
}

