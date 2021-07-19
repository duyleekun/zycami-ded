/*
 * Decompiled with CFR 0.151.
 */
package com.tencent.liteav.network;

import com.tencent.liteav.network.TXCStreamUploader;

public class TXCStreamUploader$3
implements Runnable {
    public final /* synthetic */ boolean a;
    public final /* synthetic */ TXCStreamUploader b;

    public TXCStreamUploader$3(TXCStreamUploader tXCStreamUploader, boolean bl2) {
        this.b = tXCStreamUploader;
        this.a = bl2;
    }

    public void run() {
        TXCStreamUploader tXCStreamUploader = this.b;
        boolean bl2 = this.a;
        TXCStreamUploader.access$3000(tXCStreamUploader, bl2);
    }
}

