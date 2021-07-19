/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.Surface
 */
package d.h.a.a.s0;

import android.view.Surface;
import com.google.android.exoplayer2.video.VideoRendererEventListener$EventDispatcher;

public final class d
implements Runnable {
    public final /* synthetic */ VideoRendererEventListener$EventDispatcher a;
    public final /* synthetic */ Surface b;

    public /* synthetic */ d(VideoRendererEventListener$EventDispatcher videoRendererEventListener$EventDispatcher, Surface surface) {
        this.a = videoRendererEventListener$EventDispatcher;
        this.b = surface;
    }

    public final void run() {
        VideoRendererEventListener$EventDispatcher videoRendererEventListener$EventDispatcher = this.a;
        Surface surface = this.b;
        videoRendererEventListener$EventDispatcher.n(surface);
    }
}

