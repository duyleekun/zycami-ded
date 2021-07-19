/*
 * Decompiled with CFR 0.151.
 */
package d.h.a.a.s0;

import com.google.android.exoplayer2.video.VideoRendererEventListener$EventDispatcher;

public final class h
implements Runnable {
    public final /* synthetic */ VideoRendererEventListener$EventDispatcher a;
    public final /* synthetic */ int b;
    public final /* synthetic */ int c;
    public final /* synthetic */ int d;
    public final /* synthetic */ float e;

    public /* synthetic */ h(VideoRendererEventListener$EventDispatcher videoRendererEventListener$EventDispatcher, int n10, int n11, int n12, float f10) {
        this.a = videoRendererEventListener$EventDispatcher;
        this.b = n10;
        this.c = n11;
        this.d = n12;
        this.e = f10;
    }

    public final void run() {
        VideoRendererEventListener$EventDispatcher videoRendererEventListener$EventDispatcher = this.a;
        int n10 = this.b;
        int n11 = this.c;
        int n12 = this.d;
        float f10 = this.e;
        videoRendererEventListener$EventDispatcher.r(n10, n11, n12, f10);
    }
}

