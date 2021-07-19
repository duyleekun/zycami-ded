/*
 * Decompiled with CFR 0.151.
 */
package d.h.a.a.f0;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.audio.AudioRendererEventListener$EventDispatcher;
import com.google.android.exoplayer2.decoder.DecoderReuseEvaluation;

public final class d
implements Runnable {
    public final /* synthetic */ AudioRendererEventListener$EventDispatcher a;
    public final /* synthetic */ Format b;
    public final /* synthetic */ DecoderReuseEvaluation c;

    public /* synthetic */ d(AudioRendererEventListener$EventDispatcher audioRendererEventListener$EventDispatcher, Format format, DecoderReuseEvaluation decoderReuseEvaluation) {
        this.a = audioRendererEventListener$EventDispatcher;
        this.b = format;
        this.c = decoderReuseEvaluation;
    }

    public final void run() {
        AudioRendererEventListener$EventDispatcher audioRendererEventListener$EventDispatcher = this.a;
        Format format = this.b;
        DecoderReuseEvaluation decoderReuseEvaluation = this.c;
        audioRendererEventListener$EventDispatcher.l(format, decoderReuseEvaluation);
    }
}

