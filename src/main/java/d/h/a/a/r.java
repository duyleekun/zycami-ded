/*
 * Decompiled with CFR 0.151.
 */
package d.h.a.a;

import com.google.android.exoplayer2.ExoPlayerImpl;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.Player$EventListener;
import com.google.android.exoplayer2.util.ListenerSet$Event;

public final class r
implements ListenerSet$Event {
    public final /* synthetic */ MediaItem a;
    public final /* synthetic */ int b;

    public /* synthetic */ r(MediaItem mediaItem, int n10) {
        this.a = mediaItem;
        this.b = n10;
    }

    public final void invoke(Object object) {
        MediaItem mediaItem = this.a;
        int n10 = this.b;
        object = (Player$EventListener)object;
        ExoPlayerImpl.v(mediaItem, n10, (Player$EventListener)object);
    }
}

