/*
 * Decompiled with CFR 0.151.
 */
package com.tencent.liteav.audio;

import com.tencent.liteav.audio.TXCLiveBGMPlayer;
import com.tencent.liteav.audio.g;

public class TXCLiveBGMPlayer$1
implements Runnable {
    public final /* synthetic */ g a;
    public final /* synthetic */ TXCLiveBGMPlayer b;

    public TXCLiveBGMPlayer$1(TXCLiveBGMPlayer tXCLiveBGMPlayer, g g10) {
        this.b = tXCLiveBGMPlayer;
        this.a = g10;
    }

    public void run() {
        g g10 = this.a;
        if (g10 != null) {
            g10.a();
        }
    }
}

