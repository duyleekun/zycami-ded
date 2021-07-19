/*
 * Decompiled with CFR 0.151.
 */
package d.h.a.a.f0;

import com.google.android.exoplayer2.audio.AudioRendererEventListener$EventDispatcher;

public final class e
implements Runnable {
    public final /* synthetic */ AudioRendererEventListener$EventDispatcher a;
    public final /* synthetic */ String b;
    public final /* synthetic */ long c;
    public final /* synthetic */ long d;

    public /* synthetic */ e(AudioRendererEventListener$EventDispatcher audioRendererEventListener$EventDispatcher, String string2, long l10, long l11) {
        this.a = audioRendererEventListener$EventDispatcher;
        this.b = string2;
        this.c = l10;
        this.d = l11;
    }

    public final void run() {
        AudioRendererEventListener$EventDispatcher audioRendererEventListener$EventDispatcher = this.a;
        String string2 = this.b;
        long l10 = this.c;
        long l11 = this.d;
        audioRendererEventListener$EventDispatcher.d(string2, l10, l11);
    }
}

