/*
 * Decompiled with CFR 0.151.
 */
package com.tencent.ijk.media.player;

import com.tencent.ijk.media.player.IMediaPlayer;
import com.tencent.ijk.media.player.IMediaPlayer$OnPreparedListener;
import com.tencent.ijk.media.player.MediaPlayerProxy;

public class MediaPlayerProxy$1
implements IMediaPlayer$OnPreparedListener {
    public final /* synthetic */ MediaPlayerProxy this$0;
    public final /* synthetic */ IMediaPlayer$OnPreparedListener val$finalListener;

    public MediaPlayerProxy$1(MediaPlayerProxy mediaPlayerProxy, IMediaPlayer$OnPreparedListener iMediaPlayer$OnPreparedListener) {
        this.this$0 = mediaPlayerProxy;
        this.val$finalListener = iMediaPlayer$OnPreparedListener;
    }

    public void onPrepared(IMediaPlayer object) {
        object = this.val$finalListener;
        MediaPlayerProxy mediaPlayerProxy = this.this$0;
        object.onPrepared(mediaPlayerProxy);
    }
}

