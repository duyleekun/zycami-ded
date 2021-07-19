/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 */
package com.tencent.liteav.txcvodplayer;

import android.os.Handler;
import com.tencent.ijk.media.player.IMediaPlayer;
import com.tencent.liteav.txcvodplayer.b$1;

public class b {
    private IMediaPlayer a;
    private Handler b;

    public b() {
        b$1 b$1 = new b$1(this);
        this.b = b$1;
    }

    public static /* synthetic */ IMediaPlayer a(b b10) {
        return b10.a;
    }

    public static /* synthetic */ Handler b(b b10) {
        return b10.b;
    }

    public void a(IMediaPlayer iMediaPlayer) {
        this.a = iMediaPlayer;
        int n10 = 1;
        if (iMediaPlayer != null) {
            iMediaPlayer = this.b;
            long l10 = 500L;
            iMediaPlayer.sendEmptyMessageDelayed(n10, l10);
        } else {
            iMediaPlayer = this.b;
            iMediaPlayer.removeMessages(n10);
        }
    }
}

