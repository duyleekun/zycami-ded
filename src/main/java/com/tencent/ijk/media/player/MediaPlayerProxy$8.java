/*
 * Decompiled with CFR 0.151.
 */
package com.tencent.ijk.media.player;

import com.tencent.ijk.media.player.IMediaPlayer;
import com.tencent.ijk.media.player.IMediaPlayer$OnTimedTextListener;
import com.tencent.ijk.media.player.IjkTimedText;
import com.tencent.ijk.media.player.MediaPlayerProxy;

public class MediaPlayerProxy$8
implements IMediaPlayer$OnTimedTextListener {
    public final /* synthetic */ MediaPlayerProxy this$0;
    public final /* synthetic */ IMediaPlayer$OnTimedTextListener val$finalListener;

    public MediaPlayerProxy$8(MediaPlayerProxy mediaPlayerProxy, IMediaPlayer$OnTimedTextListener iMediaPlayer$OnTimedTextListener) {
        this.this$0 = mediaPlayerProxy;
        this.val$finalListener = iMediaPlayer$OnTimedTextListener;
    }

    public void onTimedText(IMediaPlayer object, IjkTimedText ijkTimedText) {
        object = this.val$finalListener;
        MediaPlayerProxy mediaPlayerProxy = this.this$0;
        object.onTimedText(mediaPlayerProxy, ijkTimedText);
    }
}

