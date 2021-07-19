/*
 * Decompiled with CFR 0.151.
 */
package com.tencent.liteav.txcvodplayer;

import com.tencent.ijk.media.player.IMediaPlayer;
import com.tencent.ijk.media.player.IMediaPlayer$OnBufferingUpdateListener;
import com.tencent.liteav.txcvodplayer.TXCVodVideoView;

public class TXCVodVideoView$2
implements IMediaPlayer$OnBufferingUpdateListener {
    public final /* synthetic */ TXCVodVideoView a;

    public TXCVodVideoView$2(TXCVodVideoView tXCVodVideoView) {
        this.a = tXCVodVideoView;
    }

    public void onBufferingUpdate(IMediaPlayer iMediaPlayer, int n10) {
        TXCVodVideoView.k(this.a, n10);
    }
}

