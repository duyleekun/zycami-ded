/*
 * Decompiled with CFR 0.151.
 */
package com.tencent.liteav.txcvodplayer;

import com.tencent.ijk.media.player.IMediaPlayer;
import com.tencent.ijk.media.player.IMediaPlayer$OnPreparedListener;
import com.tencent.liteav.txcvodplayer.TXCVodVideoView;

public class TXCVodVideoView$10
implements IMediaPlayer$OnPreparedListener {
    public final /* synthetic */ TXCVodVideoView a;

    public TXCVodVideoView$10(TXCVodVideoView tXCVodVideoView) {
        this.a = tXCVodVideoView;
    }

    public void onPrepared(IMediaPlayer object) {
        int n10;
        int n11;
        TXCVodVideoView tXCVodVideoView = this.a;
        int n12 = TXCVodVideoView.g(tXCVodVideoView);
        if (n12 == (n11 = 1)) {
            tXCVodVideoView = this.a;
            String string2 = "VOD ready";
            String string3 = "prepared";
            TXCVodVideoView.a(tXCVodVideoView, 2013, string2, string3);
            tXCVodVideoView = this.a;
            n10 = tXCVodVideoView.c;
            if (n10 == 0) {
                n10 = 4;
                TXCVodVideoView.e(tXCVodVideoView, n10);
                tXCVodVideoView = this.a;
                tXCVodVideoView.c = n11;
            }
            tXCVodVideoView = this.a;
            n11 = 2;
            TXCVodVideoView.f(tXCVodVideoView, n11);
        }
        tXCVodVideoView = this.a;
        TXCVodVideoView tXCVodVideoView2 = null;
        TXCVodVideoView.g(tXCVodVideoView, 0);
        tXCVodVideoView = this.a;
        n12 = TXCVodVideoView.g(tXCVodVideoView);
        n11 = -1;
        n10 = 3;
        if (n12 == n11) {
            TXCVodVideoView.f(this.a, n10);
            tXCVodVideoView = this.a;
            TXCVodVideoView.e(tXCVodVideoView, n10);
        }
        if ((tXCVodVideoView = TXCVodVideoView.f(this.a)) != null) {
            TXCVodVideoView.f(this.a).sendEmptyMessage(100);
            tXCVodVideoView = TXCVodVideoView.f(this.a);
            n11 = 103;
            tXCVodVideoView.sendEmptyMessage(n11);
        }
        tXCVodVideoView = this.a;
        n11 = object.getVideoWidth();
        TXCVodVideoView.a(tXCVodVideoView, n11);
        tXCVodVideoView = this.a;
        int n13 = object.getVideoHeight();
        TXCVodVideoView.b(tXCVodVideoView, n13);
        object = this.a;
        n13 = TXCVodVideoView.c((TXCVodVideoView)((Object)object));
        if (n13 != 0 && (n13 = TXCVodVideoView.b((TXCVodVideoView)((Object)(object = this.a)))) != 0) {
            object = TXCVodVideoView.a(this.a);
            if (object != null) {
                object = TXCVodVideoView.a(this.a);
                n12 = TXCVodVideoView.c(this.a);
                n11 = TXCVodVideoView.b(this.a);
                object.setVideoSize(n12, n11);
                object = TXCVodVideoView.a(this.a);
                tXCVodVideoView = this.a;
                n12 = TXCVodVideoView.d(tXCVodVideoView);
                tXCVodVideoView2 = this.a;
                n11 = TXCVodVideoView.e(tXCVodVideoView2);
                object.setVideoSampleAspectRatio(n12, n11);
                object = TXCVodVideoView.a(this.a);
                n13 = (int)(object.shouldWaitForResize() ? 1 : 0);
                if ((n13 == 0 || (n13 = TXCVodVideoView.h((TXCVodVideoView)((Object)(object = this.a)))) == (n12 = TXCVodVideoView.c(tXCVodVideoView = this.a)) && (n13 = TXCVodVideoView.i((TXCVodVideoView)((Object)(object = this.a)))) == (n12 = TXCVodVideoView.b(tXCVodVideoView = this.a))) && (n13 = TXCVodVideoView.j((TXCVodVideoView)((Object)(object = this.a)))) == n10) {
                    object = this.a;
                    ((TXCVodVideoView)((Object)object)).b();
                }
            }
        } else {
            object = this.a;
            n13 = TXCVodVideoView.j((TXCVodVideoView)((Object)object));
            if (n13 == n10) {
                object = this.a;
                ((TXCVodVideoView)((Object)object)).b();
            }
        }
    }
}

