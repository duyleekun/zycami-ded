/*
 * Decompiled with CFR 0.151.
 */
package com.tencent.ijk.media.player;

import com.tencent.ijk.media.player.IMediaPlayer;
import com.tencent.ijk.media.player.IMediaPlayer$OnSeekCompleteListener;
import com.tencent.ijk.media.player.MediaPlayerProxy;

public class MediaPlayerProxy$4
implements IMediaPlayer$OnSeekCompleteListener {
    public final /* synthetic */ MediaPlayerProxy this$0;
    public final /* synthetic */ IMediaPlayer$OnSeekCompleteListener val$finalListener;

    public MediaPlayerProxy$4(MediaPlayerProxy mediaPlayerProxy, IMediaPlayer$OnSeekCompleteListener iMediaPlayer$OnSeekCompleteListener) {
        this.this$0 = mediaPlayerProxy;
        this.val$finalListener = iMediaPlayer$OnSeekCompleteListener;
    }

    public void onSeekComplete(IMediaPlayer object) {
        object = this.val$finalListener;
        MediaPlayerProxy mediaPlayerProxy = this.this$0;
        object.onSeekComplete(mediaPlayerProxy);
    }
}

