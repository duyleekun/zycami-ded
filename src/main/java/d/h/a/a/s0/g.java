/*
 * Decompiled with CFR 0.151.
 */
package d.h.a.a.s0;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.decoder.DecoderReuseEvaluation;
import com.google.android.exoplayer2.video.VideoRendererEventListener$EventDispatcher;

public final class g
implements Runnable {
    public final /* synthetic */ VideoRendererEventListener$EventDispatcher a;
    public final /* synthetic */ Format b;
    public final /* synthetic */ DecoderReuseEvaluation c;

    public /* synthetic */ g(VideoRendererEventListener$EventDispatcher videoRendererEventListener$EventDispatcher, Format format, DecoderReuseEvaluation decoderReuseEvaluation) {
        this.a = videoRendererEventListener$EventDispatcher;
        this.b = format;
        this.c = decoderReuseEvaluation;
    }

    public final void run() {
        VideoRendererEventListener$EventDispatcher videoRendererEventListener$EventDispatcher = this.a;
        Format format = this.b;
        DecoderReuseEvaluation decoderReuseEvaluation = this.c;
        videoRendererEventListener$EventDispatcher.l(format, decoderReuseEvaluation);
    }
}

