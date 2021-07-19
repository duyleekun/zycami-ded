/*
 * Decompiled with CFR 0.151.
 */
package com.tencent.ijk.media.player;

import com.tencent.ijk.media.player.IMediaPlayer;
import com.tencent.ijk.media.player.IMediaPlayer$OnInfoListener;
import com.tencent.ijk.media.player.MediaPlayerProxy;

public class MediaPlayerProxy$7
implements IMediaPlayer$OnInfoListener {
    public final /* synthetic */ MediaPlayerProxy this$0;
    public final /* synthetic */ IMediaPlayer$OnInfoListener val$finalListener;

    public MediaPlayerProxy$7(MediaPlayerProxy mediaPlayerProxy, IMediaPlayer$OnInfoListener iMediaPlayer$OnInfoListener) {
        this.this$0 = mediaPlayerProxy;
        this.val$finalListener = iMediaPlayer$OnInfoListener;
    }

    public boolean onInfo(IMediaPlayer object, int n10, int n11) {
        object = this.val$finalListener;
        MediaPlayerProxy mediaPlayerProxy = this.this$0;
        return object.onInfo(mediaPlayerProxy, n10, n11);
    }
}

