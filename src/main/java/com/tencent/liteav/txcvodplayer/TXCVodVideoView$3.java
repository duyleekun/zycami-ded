/*
 * Decompiled with CFR 0.151.
 */
package com.tencent.liteav.txcvodplayer;

import com.tencent.ijk.media.player.IMediaPlayer;
import com.tencent.ijk.media.player.IMediaPlayer$OnSeekCompleteListener;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.txcvodplayer.TXCVodVideoView;

public class TXCVodVideoView$3
implements IMediaPlayer$OnSeekCompleteListener {
    public final /* synthetic */ TXCVodVideoView a;

    public TXCVodVideoView$3(TXCVodVideoView tXCVodVideoView) {
        this.a = tXCVodVideoView;
    }

    public void onSeekComplete(IMediaPlayer object) {
        TXCLog.v(TXCVodVideoView.k(this.a), "seek complete");
        object = this.a;
        int n10 = 0;
        TXCVodVideoView.b((TXCVodVideoView)((Object)object), false);
        object = this.a;
        int n11 = TXCVodVideoView.u((TXCVodVideoView)((Object)object));
        if (n11 >= 0) {
            object = this.a;
            n10 = TXCVodVideoView.u((TXCVodVideoView)((Object)object));
            ((TXCVodVideoView)((Object)object)).a(n10);
        }
    }
}

