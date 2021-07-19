/*
 * Decompiled with CFR 0.151.
 */
package d.h.a.a.f0;

import com.google.android.exoplayer2.audio.AudioRendererEventListener$EventDispatcher;
import com.google.android.exoplayer2.decoder.DecoderCounters;

public final class b
implements Runnable {
    public final /* synthetic */ AudioRendererEventListener$EventDispatcher a;
    public final /* synthetic */ DecoderCounters b;

    public /* synthetic */ b(AudioRendererEventListener$EventDispatcher audioRendererEventListener$EventDispatcher, DecoderCounters decoderCounters) {
        this.a = audioRendererEventListener$EventDispatcher;
        this.b = decoderCounters;
    }

    public final void run() {
        AudioRendererEventListener$EventDispatcher audioRendererEventListener$EventDispatcher = this.a;
        DecoderCounters decoderCounters = this.b;
        audioRendererEventListener$EventDispatcher.h(decoderCounters);
    }
}

