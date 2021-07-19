/*
 * Decompiled with CFR 0.151.
 */
package com.tencent.liteav.network;

import com.tencent.liteav.network.TXCRTMPDownloader;

public class TXCRTMPDownloader$1
implements Runnable {
    public final /* synthetic */ boolean a;
    public final /* synthetic */ TXCRTMPDownloader b;

    public TXCRTMPDownloader$1(TXCRTMPDownloader tXCRTMPDownloader, boolean bl2) {
        this.b = tXCRTMPDownloader;
        this.a = bl2;
    }

    public void run() {
        TXCRTMPDownloader tXCRTMPDownloader = this.b;
        boolean bl2 = this.a;
        TXCRTMPDownloader.access$600(tXCRTMPDownloader, bl2);
    }
}

