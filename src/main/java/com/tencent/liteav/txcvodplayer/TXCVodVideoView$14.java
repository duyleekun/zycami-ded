/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Log
 */
package com.tencent.liteav.txcvodplayer;

import android.util.Log;
import com.tencent.ijk.media.player.IMediaPlayer;
import com.tencent.ijk.media.player.IMediaPlayer$OnHevcVideoDecoderErrorListener;
import com.tencent.liteav.txcvodplayer.TXCVodVideoView;

public class TXCVodVideoView$14
implements IMediaPlayer$OnHevcVideoDecoderErrorListener {
    public final /* synthetic */ TXCVodVideoView a;

    public TXCVodVideoView$14(TXCVodVideoView tXCVodVideoView) {
        this.a = tXCVodVideoView;
    }

    public void onHevcVideoDecoderError(IMediaPlayer iMediaPlayer) {
        Log.d((String)TXCVodVideoView.k(this.a), (String)"onHevcVideoDecoderError");
        TXCVodVideoView.a(this.a, -2304, "Vod H265 decoding failed", "hevc decode fail");
    }
}

