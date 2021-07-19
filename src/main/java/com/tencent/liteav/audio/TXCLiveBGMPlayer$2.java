/*
 * Decompiled with CFR 0.151.
 */
package com.tencent.liteav.audio;

import com.tencent.liteav.audio.TXCLiveBGMPlayer;
import com.tencent.liteav.audio.g;

public class TXCLiveBGMPlayer$2
implements Runnable {
    public final /* synthetic */ g a;
    public final /* synthetic */ int b;
    public final /* synthetic */ TXCLiveBGMPlayer c;

    public TXCLiveBGMPlayer$2(TXCLiveBGMPlayer tXCLiveBGMPlayer, g g10, int n10) {
        this.c = tXCLiveBGMPlayer;
        this.a = g10;
        this.b = n10;
    }

    public void run() {
        g g10 = this.a;
        if (g10 != null) {
            int n10 = this.b;
            g10.a(n10);
        }
    }
}

