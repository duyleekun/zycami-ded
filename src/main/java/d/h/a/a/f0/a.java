/*
 * Decompiled with CFR 0.151.
 */
package d.h.a.a.f0;

import com.google.android.exoplayer2.audio.AudioRendererEventListener$EventDispatcher;

public final class a
implements Runnable {
    public final /* synthetic */ AudioRendererEventListener$EventDispatcher a;
    public final /* synthetic */ boolean b;

    public /* synthetic */ a(AudioRendererEventListener$EventDispatcher audioRendererEventListener$EventDispatcher, boolean bl2) {
        this.a = audioRendererEventListener$EventDispatcher;
        this.b = bl2;
    }

    public final void run() {
        AudioRendererEventListener$EventDispatcher audioRendererEventListener$EventDispatcher = this.a;
        boolean bl2 = this.b;
        audioRendererEventListener$EventDispatcher.p(bl2);
    }
}

