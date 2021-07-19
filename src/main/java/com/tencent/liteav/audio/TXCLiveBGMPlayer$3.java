/*
 * Decompiled with CFR 0.151.
 */
package com.tencent.liteav.audio;

import com.tencent.liteav.audio.TXCLiveBGMPlayer;
import com.tencent.liteav.audio.g;

public class TXCLiveBGMPlayer$3
implements Runnable {
    public final /* synthetic */ g a;
    public final /* synthetic */ long b;
    public final /* synthetic */ long c;
    public final /* synthetic */ TXCLiveBGMPlayer d;

    public TXCLiveBGMPlayer$3(TXCLiveBGMPlayer tXCLiveBGMPlayer, g g10, long l10, long l11) {
        this.d = tXCLiveBGMPlayer;
        this.a = g10;
        this.b = l10;
        this.c = l11;
    }

    public void run() {
        g g10 = this.a;
        if (g10 != null) {
            long l10 = this.b;
            long l11 = this.c;
            g10.a(l10, l11);
        }
    }
}

