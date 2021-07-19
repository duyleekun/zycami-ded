/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Log
 */
package com.tencent.liteav.txcvodplayer;

import android.util.Log;
import com.tencent.ijk.media.player.IMediaPlayer;
import com.tencent.ijk.media.player.IMediaPlayer$OnHLSKeyErrorListener;
import com.tencent.liteav.txcvodplayer.TXCVodVideoView;

public class TXCVodVideoView$6
implements IMediaPlayer$OnHLSKeyErrorListener {
    public final /* synthetic */ TXCVodVideoView a;

    public TXCVodVideoView$6(TXCVodVideoView tXCVodVideoView) {
        this.a = tXCVodVideoView;
    }

    public void onHLSKeyError(IMediaPlayer object) {
        object = TXCVodVideoView.k(this.a);
        String string2 = "onHLSKeyError";
        Log.e((String)object, (String)string2);
        object = this.a;
        int n10 = -2305;
        String string3 = "HLS decypt key get failed";
        String string4 = "hls key error";
        TXCVodVideoView.a((TXCVodVideoView)((Object)object), n10, string3, string4);
        object = TXCVodVideoView.w(this.a);
        if (object != null) {
            TXCVodVideoView.w(this.a).stop();
            TXCVodVideoView.w(this.a).release();
            object = this.a;
            n10 = 0;
            string2 = null;
            TXCVodVideoView.a((TXCVodVideoView)((Object)object), null);
        }
        object = this.a;
        n10 = -1;
        TXCVodVideoView.f((TXCVodVideoView)((Object)object), n10);
        TXCVodVideoView.e(this.a, n10);
    }
}

