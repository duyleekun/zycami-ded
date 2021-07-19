/*
 * Decompiled with CFR 0.151.
 */
package d.h.a.a.f0;

import com.google.android.exoplayer2.audio.AudioRendererEventListener$EventDispatcher;

public final class g
implements Runnable {
    public final /* synthetic */ AudioRendererEventListener$EventDispatcher a;
    public final /* synthetic */ long b;

    public /* synthetic */ g(AudioRendererEventListener$EventDispatcher audioRendererEventListener$EventDispatcher, long l10) {
        this.a = audioRendererEventListener$EventDispatcher;
        this.b = l10;
    }

    public final void run() {
        AudioRendererEventListener$EventDispatcher audioRendererEventListener$EventDispatcher = this.a;
        long l10 = this.b;
        audioRendererEventListener$EventDispatcher.n(l10);
    }
}

