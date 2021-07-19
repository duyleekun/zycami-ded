/*
 * Decompiled with CFR 0.151.
 */
package d.h.a.a.s0;

import com.google.android.exoplayer2.video.VideoRendererEventListener$EventDispatcher;

public final class f
implements Runnable {
    public final /* synthetic */ VideoRendererEventListener$EventDispatcher a;
    public final /* synthetic */ String b;
    public final /* synthetic */ long c;
    public final /* synthetic */ long d;

    public /* synthetic */ f(VideoRendererEventListener$EventDispatcher videoRendererEventListener$EventDispatcher, String string2, long l10, long l11) {
        this.a = videoRendererEventListener$EventDispatcher;
        this.b = string2;
        this.c = l10;
        this.d = l11;
    }

    public final void run() {
        VideoRendererEventListener$EventDispatcher videoRendererEventListener$EventDispatcher = this.a;
        String string2 = this.b;
        long l10 = this.c;
        long l11 = this.d;
        videoRendererEventListener$EventDispatcher.b(string2, l10, l11);
    }
}

