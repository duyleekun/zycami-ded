/*
 * Decompiled with CFR 0.151.
 */
package com.tencent.ijk.media.player;

import com.tencent.ijk.media.player.IMediaPlayer;
import com.tencent.ijk.media.player.IMediaPlayer$OnVideoSizeChangedListener;
import com.tencent.ijk.media.player.MediaPlayerProxy;

public class MediaPlayerProxy$5
implements IMediaPlayer$OnVideoSizeChangedListener {
    public final /* synthetic */ MediaPlayerProxy this$0;
    public final /* synthetic */ IMediaPlayer$OnVideoSizeChangedListener val$finalListener;

    public MediaPlayerProxy$5(MediaPlayerProxy mediaPlayerProxy, IMediaPlayer$OnVideoSizeChangedListener iMediaPlayer$OnVideoSizeChangedListener) {
        this.this$0 = mediaPlayerProxy;
        this.val$finalListener = iMediaPlayer$OnVideoSizeChangedListener;
    }

    public void onVideoSizeChanged(IMediaPlayer iMediaPlayer, int n10, int n11, int n12, int n13) {
        IMediaPlayer$OnVideoSizeChangedListener iMediaPlayer$OnVideoSizeChangedListener = this.val$finalListener;
        MediaPlayerProxy mediaPlayerProxy = this.this$0;
        iMediaPlayer$OnVideoSizeChangedListener.onVideoSizeChanged(mediaPlayerProxy, n10, n11, n12, n13);
    }
}

