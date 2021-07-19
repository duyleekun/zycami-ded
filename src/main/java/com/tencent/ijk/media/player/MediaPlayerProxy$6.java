/*
 * Decompiled with CFR 0.151.
 */
package com.tencent.ijk.media.player;

import com.tencent.ijk.media.player.IMediaPlayer;
import com.tencent.ijk.media.player.IMediaPlayer$OnErrorListener;
import com.tencent.ijk.media.player.MediaPlayerProxy;

public class MediaPlayerProxy$6
implements IMediaPlayer$OnErrorListener {
    public final /* synthetic */ MediaPlayerProxy this$0;
    public final /* synthetic */ IMediaPlayer$OnErrorListener val$finalListener;

    public MediaPlayerProxy$6(MediaPlayerProxy mediaPlayerProxy, IMediaPlayer$OnErrorListener iMediaPlayer$OnErrorListener) {
        this.this$0 = mediaPlayerProxy;
        this.val$finalListener = iMediaPlayer$OnErrorListener;
    }

    public boolean onError(IMediaPlayer object, int n10, int n11) {
        object = this.val$finalListener;
        MediaPlayerProxy mediaPlayerProxy = this.this$0;
        return object.onError(mediaPlayerProxy, n10, n11);
    }
}

