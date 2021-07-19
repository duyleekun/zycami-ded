/*
 * Decompiled with CFR 0.151.
 */
package d.h.a.a.f0;

import com.google.android.exoplayer2.audio.AudioRendererEventListener$EventDispatcher;

public final class f
implements Runnable {
    public final /* synthetic */ AudioRendererEventListener$EventDispatcher a;
    public final /* synthetic */ String b;

    public /* synthetic */ f(AudioRendererEventListener$EventDispatcher audioRendererEventListener$EventDispatcher, String string2) {
        this.a = audioRendererEventListener$EventDispatcher;
        this.b = string2;
    }

    public final void run() {
        AudioRendererEventListener$EventDispatcher audioRendererEventListener$EventDispatcher = this.a;
        String string2 = this.b;
        audioRendererEventListener$EventDispatcher.f(string2);
    }
}

