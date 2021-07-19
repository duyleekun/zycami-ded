/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Log
 */
package com.tencent.liteav.txcvodplayer;

import android.util.Log;
import com.tencent.ijk.media.player.IMediaPlayer;
import com.tencent.ijk.media.player.IMediaPlayer$OnVideoDecoderErrorListener;
import com.tencent.liteav.txcvodplayer.TXCVodVideoView;
import com.tencent.liteav.txcvodplayer.d;

public class TXCVodVideoView$15
implements IMediaPlayer$OnVideoDecoderErrorListener {
    public final /* synthetic */ TXCVodVideoView a;

    public TXCVodVideoView$15(TXCVodVideoView tXCVodVideoView) {
        this.a = tXCVodVideoView;
    }

    public void onVideoDecoderError(IMediaPlayer object) {
        object = TXCVodVideoView.k(this.a);
        Object object2 = "onVideoDecoderError";
        Log.d((String)object, (String)object2);
        object = this.a;
        int n10 = TXCVodVideoView.g((TXCVodVideoView)((Object)object));
        int n11 = 4;
        if (n10 != n11) {
            object = this.a;
            n11 = 2106;
            String string2 = "VOD decoding failed";
            String string3 = "decode fail";
            TXCVodVideoView.a((TXCVodVideoView)((Object)object), n11, string2, string3);
        }
        if ((n10 = (int)(TXCVodVideoView.l((TXCVodVideoView)((Object)(object = this.a))) ? 1 : 0)) == 0) {
            object = TXCVodVideoView.s(this.a);
            n10 = (int)(((d)object).d ? 1 : 0);
            if (n10 != 0) {
                object = this.a;
                n10 = TXCVodVideoView.b((TXCVodVideoView)((Object)object));
                object2 = this.a;
                n11 = TXCVodVideoView.c((TXCVodVideoView)((Object)object2));
                if ((n10 = Math.min(n10, n11)) >= (n11 = 1080)) {
                    return;
                }
                object = TXCVodVideoView.s(this.a);
                n11 = 0;
                object2 = null;
                ((d)object).d = false;
                object = this.a;
                TXCVodVideoView.t((TXCVodVideoView)((Object)object));
            }
        }
    }
}

