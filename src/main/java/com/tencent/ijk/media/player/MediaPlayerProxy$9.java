/*
 * Decompiled with CFR 0.151.
 */
package com.tencent.ijk.media.player;

import com.tencent.ijk.media.player.IMediaPlayer;
import com.tencent.ijk.media.player.IMediaPlayer$OnHLSKeyErrorListener;
import com.tencent.ijk.media.player.MediaPlayerProxy;

public class MediaPlayerProxy$9
implements IMediaPlayer$OnHLSKeyErrorListener {
    public final /* synthetic */ MediaPlayerProxy this$0;
    public final /* synthetic */ IMediaPlayer$OnHLSKeyErrorListener val$finalListener;

    public MediaPlayerProxy$9(MediaPlayerProxy mediaPlayerProxy, IMediaPlayer$OnHLSKeyErrorListener iMediaPlayer$OnHLSKeyErrorListener) {
        this.this$0 = mediaPlayerProxy;
        this.val$finalListener = iMediaPlayer$OnHLSKeyErrorListener;
    }

    public void onHLSKeyError(IMediaPlayer object) {
        object = this.val$finalListener;
        MediaPlayerProxy mediaPlayerProxy = this.this$0;
        object.onHLSKeyError(mediaPlayerProxy);
    }
}

