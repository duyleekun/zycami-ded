/*
 * Decompiled with CFR 0.151.
 */
package com.tencent.liteav.txcvodplayer;

import com.tencent.ijk.media.player.IMediaPlayer;
import com.tencent.ijk.media.player.IMediaPlayer$OnCompletionListener;
import com.tencent.liteav.txcvodplayer.TXCVodVideoView;

public class TXCVodVideoView$11
implements IMediaPlayer$OnCompletionListener {
    public final /* synthetic */ TXCVodVideoView a;

    public TXCVodVideoView$11(TXCVodVideoView tXCVodVideoView) {
        this.a = tXCVodVideoView;
    }

    public void onCompletion(IMediaPlayer object) {
        object = this.a;
        int n10 = 5;
        TXCVodVideoView.f((TXCVodVideoView)((Object)object), n10);
        TXCVodVideoView.e(this.a, n10);
        TXCVodVideoView.a(this.a, 2006, "Playback completed", "play end");
    }
}

