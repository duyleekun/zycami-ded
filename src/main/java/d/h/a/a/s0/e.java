/*
 * Decompiled with CFR 0.151.
 */
package d.h.a.a.s0;

import com.google.android.exoplayer2.video.VideoRendererEventListener$EventDispatcher;

public final class e
implements Runnable {
    public final /* synthetic */ VideoRendererEventListener$EventDispatcher a;
    public final /* synthetic */ int b;
    public final /* synthetic */ long c;

    public /* synthetic */ e(VideoRendererEventListener$EventDispatcher videoRendererEventListener$EventDispatcher, int n10, long l10) {
        this.a = videoRendererEventListener$EventDispatcher;
        this.b = n10;
        this.c = l10;
    }

    public final void run() {
        VideoRendererEventListener$EventDispatcher videoRendererEventListener$EventDispatcher = this.a;
        int n10 = this.b;
        long l10 = this.c;
        videoRendererEventListener$EventDispatcher.h(n10, l10);
    }
}

