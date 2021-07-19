/*
 * Decompiled with CFR 0.151.
 */
package d.h.a.a.s0;

import com.google.android.exoplayer2.video.VideoRendererEventListener$EventDispatcher;

public final class b
implements Runnable {
    public final /* synthetic */ VideoRendererEventListener$EventDispatcher a;
    public final /* synthetic */ String b;

    public /* synthetic */ b(VideoRendererEventListener$EventDispatcher videoRendererEventListener$EventDispatcher, String string2) {
        this.a = videoRendererEventListener$EventDispatcher;
        this.b = string2;
    }

    public final void run() {
        VideoRendererEventListener$EventDispatcher videoRendererEventListener$EventDispatcher = this.a;
        String string2 = this.b;
        videoRendererEventListener$EventDispatcher.d(string2);
    }
}

