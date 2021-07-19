/*
 * Decompiled with CFR 0.151.
 */
package d.h.a.a.s0;

import com.google.android.exoplayer2.decoder.DecoderCounters;
import com.google.android.exoplayer2.video.VideoRendererEventListener$EventDispatcher;

public final class c
implements Runnable {
    public final /* synthetic */ VideoRendererEventListener$EventDispatcher a;
    public final /* synthetic */ DecoderCounters b;

    public /* synthetic */ c(VideoRendererEventListener$EventDispatcher videoRendererEventListener$EventDispatcher, DecoderCounters decoderCounters) {
        this.a = videoRendererEventListener$EventDispatcher;
        this.b = decoderCounters;
    }

    public final void run() {
        VideoRendererEventListener$EventDispatcher videoRendererEventListener$EventDispatcher = this.a;
        DecoderCounters decoderCounters = this.b;
        videoRendererEventListener$EventDispatcher.j(decoderCounters);
    }
}

