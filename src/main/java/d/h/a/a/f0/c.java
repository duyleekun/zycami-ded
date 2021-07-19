/*
 * Decompiled with CFR 0.151.
 */
package d.h.a.a.f0;

import com.google.android.exoplayer2.audio.AudioRendererEventListener$EventDispatcher;

public final class c
implements Runnable {
    public final /* synthetic */ AudioRendererEventListener$EventDispatcher a;
    public final /* synthetic */ Exception b;

    public /* synthetic */ c(AudioRendererEventListener$EventDispatcher audioRendererEventListener$EventDispatcher, Exception exception) {
        this.a = audioRendererEventListener$EventDispatcher;
        this.b = exception;
    }

    public final void run() {
        AudioRendererEventListener$EventDispatcher audioRendererEventListener$EventDispatcher = this.a;
        Exception exception = this.b;
        audioRendererEventListener$EventDispatcher.b(exception);
    }
}

