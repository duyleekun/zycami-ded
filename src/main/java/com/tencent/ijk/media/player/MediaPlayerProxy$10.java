/*
 * Decompiled with CFR 0.151.
 */
package com.tencent.ijk.media.player;

import com.tencent.ijk.media.player.IMediaPlayer;
import com.tencent.ijk.media.player.IMediaPlayer$OnHevcVideoDecoderErrorListener;
import com.tencent.ijk.media.player.MediaPlayerProxy;

public class MediaPlayerProxy$10
implements IMediaPlayer$OnHevcVideoDecoderErrorListener {
    public final /* synthetic */ MediaPlayerProxy this$0;
    public final /* synthetic */ IMediaPlayer$OnHevcVideoDecoderErrorListener val$finalListener;

    public MediaPlayerProxy$10(MediaPlayerProxy mediaPlayerProxy, IMediaPlayer$OnHevcVideoDecoderErrorListener iMediaPlayer$OnHevcVideoDecoderErrorListener) {
        this.this$0 = mediaPlayerProxy;
        this.val$finalListener = iMediaPlayer$OnHevcVideoDecoderErrorListener;
    }

    public void onHevcVideoDecoderError(IMediaPlayer object) {
        object = this.val$finalListener;
        MediaPlayerProxy mediaPlayerProxy = this.this$0;
        object.onHevcVideoDecoderError(mediaPlayerProxy);
    }
}

