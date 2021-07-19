/*
 * Decompiled with CFR 0.151.
 */
package com.tencent.liteav.txcvodplayer;

import com.tencent.ijk.media.player.IMediaPlayer;
import com.tencent.ijk.media.player.IMediaPlayer$OnErrorListener;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.txcvodplayer.TXCVodVideoView;
import com.tencent.liteav.txcvodplayer.d;

public class TXCVodVideoView$13
implements IMediaPlayer$OnErrorListener {
    public final /* synthetic */ TXCVodVideoView a;

    public TXCVodVideoView$13(TXCVodVideoView tXCVodVideoView) {
        this.a = tXCVodVideoView;
    }

    public boolean onError(IMediaPlayer object, int n10, int n11) {
        d d10;
        float f10;
        long l10;
        TXCVodVideoView tXCVodVideoView;
        long l11;
        long l12;
        float f11;
        object = TXCVodVideoView.k(this.a);
        Object object2 = new StringBuilder();
        ((StringBuilder)object2).append("onError: ");
        ((StringBuilder)object2).append(n10);
        String string2 = ",";
        ((StringBuilder)object2).append(string2);
        ((StringBuilder)object2).append(n11);
        object2 = ((StringBuilder)object2).toString();
        TXCLog.e((String)object, (String)object2);
        object = this.a;
        int n12 = -1;
        TXCVodVideoView.f((TXCVodVideoView)((Object)object), n12);
        object = this.a;
        TXCVodVideoView.e((TXCVodVideoView)((Object)object), n12);
        boolean bl2 = true;
        n12 = -1004;
        float f12 = 0.0f / 0.0f;
        if (n10 == n12) {
            n10 = -2303;
            f11 = 0.0f / 0.0f;
            if (n11 == n10) {
                TXCVodVideoView.a(this.a, n11, "The file does not exist", "file not exist");
                this.a.c();
                return bl2;
            }
        }
        if ((n10 = (int)((l12 = (l11 = TXCVodVideoView.q(tXCVodVideoView = this.a)) - (l10 = (long)(n12 = ((TXCVodVideoView)((Object)(object2 = this.a))).getCurrentPosition()))) == 0L ? 0 : (l12 < 0L ? -1 : 1))) != 0) {
            tXCVodVideoView = this.a;
            n11 = 0;
            f10 = 0.0f;
            d10 = null;
            TXCVodVideoView.j(tXCVodVideoView, 0);
        }
        tXCVodVideoView = this.a;
        n11 = tXCVodVideoView.getCurrentPosition();
        l10 = n11;
        TXCVodVideoView.a(tXCVodVideoView, l10);
        tXCVodVideoView = this.a;
        f11 = TXCVodVideoView.r(tXCVodVideoView);
        d10 = TXCVodVideoView.s(this.a);
        f10 = d10.a;
        n10 = (int)(f11 == f10 ? 0 : (f11 < f10 ? -1 : 1));
        if (n10 < 0) {
            tXCVodVideoView = TXCVodVideoView.f(this.a);
            if (tXCVodVideoView != null) {
                tXCVodVideoView = TXCVodVideoView.f(this.a);
                n11 = 102;
                f10 = 1.43E-43f;
                object2 = TXCVodVideoView.s(this.a);
                f12 = ((d)object2).b;
                float f13 = 1000.0f;
                l10 = (long)(f12 *= f13);
                tXCVodVideoView.sendEmptyMessageDelayed(n11, l10);
            }
        } else {
            tXCVodVideoView = this.a;
            n11 = -2301;
            f10 = 0.0f / 0.0f;
            object2 = "Disconnected from the network. Playback error";
            string2 = "disconnect";
            TXCVodVideoView.a(tXCVodVideoView, n11, (String)object2, string2);
            tXCVodVideoView = this.a;
            tXCVodVideoView.c();
        }
        return bl2;
    }
}

