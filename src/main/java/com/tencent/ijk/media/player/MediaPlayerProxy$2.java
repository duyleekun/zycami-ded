/*
 * Decompiled with CFR 0.151.
 */
package com.tencent.ijk.media.player;

import com.tencent.ijk.media.player.IMediaPlayer;
import com.tencent.ijk.media.player.IMediaPlayer$OnCompletionListener;
import com.tencent.ijk.media.player.MediaPlayerProxy;

public class MediaPlayerProxy$2
implements IMediaPlayer$OnCompletionListener {
    public final /* synthetic */ MediaPlayerProxy this$0;
    public final /* synthetic */ IMediaPlayer$OnCompletionListener val$finalListener;

    public MediaPlayerProxy$2(MediaPlayerProxy mediaPlayerProxy, IMediaPlayer$OnCompletionListener iMediaPlayer$OnCompletionListener) {
        this.this$0 = mediaPlayerProxy;
        this.val$finalListener = iMediaPlayer$OnCompletionListener;
    }

    public void onCompletion(IMediaPlayer object) {
        object = this.val$finalListener;
        MediaPlayerProxy mediaPlayerProxy = this.this$0;
        object.onCompletion(mediaPlayerProxy);
    }
}

