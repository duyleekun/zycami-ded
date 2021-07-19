/*
 * Decompiled with CFR 0.151.
 */
package com.tencent.ijk.media.player;

import com.tencent.ijk.media.player.IMediaPlayer;
import com.tencent.ijk.media.player.IMediaPlayer$OnVideoDecoderErrorListener;
import com.tencent.ijk.media.player.MediaPlayerProxy;

public class MediaPlayerProxy$11
implements IMediaPlayer$OnVideoDecoderErrorListener {
    public final /* synthetic */ MediaPlayerProxy this$0;
    public final /* synthetic */ IMediaPlayer$OnVideoDecoderErrorListener val$finalListener;

    public MediaPlayerProxy$11(MediaPlayerProxy mediaPlayerProxy, IMediaPlayer$OnVideoDecoderErrorListener iMediaPlayer$OnVideoDecoderErrorListener) {
        this.this$0 = mediaPlayerProxy;
        this.val$finalListener = iMediaPlayer$OnVideoDecoderErrorListener;
    }

    public void onVideoDecoderError(IMediaPlayer object) {
        object = this.val$finalListener;
        MediaPlayerProxy mediaPlayerProxy = this.this$0;
        object.onVideoDecoderError(mediaPlayerProxy);
    }
}

