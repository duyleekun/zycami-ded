/*
 * Decompiled with CFR 0.151.
 */
package com.tencent.liteav.network;

import com.tencent.liteav.network.TXCStreamDownloader;

public class TXCStreamDownloader$1
implements Runnable {
    public final /* synthetic */ TXCStreamDownloader a;

    public TXCStreamDownloader$1(TXCStreamDownloader tXCStreamDownloader) {
        this.a = tXCStreamDownloader;
    }

    public void run() {
        this.a.stop();
        TXCStreamDownloader tXCStreamDownloader = this.a;
        String string2 = TXCStreamDownloader.access$000(tXCStreamDownloader);
        boolean bl2 = TXCStreamDownloader.access$100(this.a);
        int n10 = TXCStreamDownloader.access$200(this.a);
        boolean bl3 = TXCStreamDownloader.access$300(this.a);
        boolean bl4 = TXCStreamDownloader.access$400(this.a);
        tXCStreamDownloader.start(string2, bl2, n10, bl3, bl4);
    }
}

