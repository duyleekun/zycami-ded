/*
 * Decompiled with CFR 0.151.
 */
package d.h.a.a.s0;

import com.google.android.exoplayer2.video.VideoRendererEventListener$EventDispatcher;

public final class i
implements Runnable {
    public final /* synthetic */ VideoRendererEventListener$EventDispatcher a;
    public final /* synthetic */ long b;
    public final /* synthetic */ int c;

    public /* synthetic */ i(VideoRendererEventListener$EventDispatcher videoRendererEventListener$EventDispatcher, long l10, int n10) {
        this.a = videoRendererEventListener$EventDispatcher;
        this.b = l10;
        this.c = n10;
    }

    public final void run() {
        VideoRendererEventListener$EventDispatcher videoRendererEventListener$EventDispatcher = this.a;
        long l10 = this.b;
        int n10 = this.c;
        videoRendererEventListener$EventDispatcher.p(l10, n10);
    }
}

