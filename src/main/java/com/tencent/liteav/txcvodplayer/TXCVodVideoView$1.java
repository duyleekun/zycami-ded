/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.Surface
 */
package com.tencent.liteav.txcvodplayer;

import android.view.Surface;
import com.tencent.ijk.media.player.IMediaPlayer;
import com.tencent.liteav.txcvodplayer.TXCVodVideoView;
import com.tencent.liteav.txcvodplayer.a;
import com.tencent.liteav.txcvodplayer.a$b;

public class TXCVodVideoView$1
implements a$b {
    public final /* synthetic */ Surface a;
    public final /* synthetic */ TXCVodVideoView b;

    public TXCVodVideoView$1(TXCVodVideoView tXCVodVideoView, Surface surface) {
        this.b = tXCVodVideoView;
        this.a = surface;
    }

    public a a() {
        return TXCVodVideoView.a(this.b);
    }

    public void a(IMediaPlayer iMediaPlayer) {
        Surface surface = this.a;
        iMediaPlayer.setSurface(surface);
    }
}

