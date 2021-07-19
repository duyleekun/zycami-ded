/*
 * Decompiled with CFR 0.151.
 */
package d.h.a.a.f0;

import com.google.android.exoplayer2.audio.AudioRendererEventListener$EventDispatcher;

public final class h
implements Runnable {
    public final /* synthetic */ AudioRendererEventListener$EventDispatcher a;
    public final /* synthetic */ int b;
    public final /* synthetic */ long c;
    public final /* synthetic */ long d;

    public /* synthetic */ h(AudioRendererEventListener$EventDispatcher audioRendererEventListener$EventDispatcher, int n10, long l10, long l11) {
        this.a = audioRendererEventListener$EventDispatcher;
        this.b = n10;
        this.c = l10;
        this.d = l11;
    }

    public final void run() {
        AudioRendererEventListener$EventDispatcher audioRendererEventListener$EventDispatcher = this.a;
        int n10 = this.b;
        long l10 = this.c;
        long l11 = this.d;
        audioRendererEventListener$EventDispatcher.r(n10, l10, l11);
    }
}

