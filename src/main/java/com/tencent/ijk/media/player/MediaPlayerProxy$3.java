/*
 * Decompiled with CFR 0.151.
 */
package com.tencent.ijk.media.player;

import com.tencent.ijk.media.player.IMediaPlayer;
import com.tencent.ijk.media.player.IMediaPlayer$OnBufferingUpdateListener;
import com.tencent.ijk.media.player.MediaPlayerProxy;

public class MediaPlayerProxy$3
implements IMediaPlayer$OnBufferingUpdateListener {
    public final /* synthetic */ MediaPlayerProxy this$0;
    public final /* synthetic */ IMediaPlayer$OnBufferingUpdateListener val$finalListener;

    public MediaPlayerProxy$3(MediaPlayerProxy mediaPlayerProxy, IMediaPlayer$OnBufferingUpdateListener iMediaPlayer$OnBufferingUpdateListener) {
        this.this$0 = mediaPlayerProxy;
        this.val$finalListener = iMediaPlayer$OnBufferingUpdateListener;
    }

    public void onBufferingUpdate(IMediaPlayer object, int n10) {
        object = this.val$finalListener;
        MediaPlayerProxy mediaPlayerProxy = this.this$0;
        object.onBufferingUpdate(mediaPlayerProxy, n10);
    }
}

