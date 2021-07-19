/*
 * Decompiled with CFR 0.151.
 */
package d.h.a.a;

import com.google.android.exoplayer2.ExoPlayerImpl;
import com.google.android.exoplayer2.PlaybackInfo;
import com.google.android.exoplayer2.Player$EventListener;
import com.google.android.exoplayer2.util.ListenerSet$Event;

public final class c
implements ListenerSet$Event {
    public final /* synthetic */ PlaybackInfo a;
    public final /* synthetic */ int b;

    public /* synthetic */ c(PlaybackInfo playbackInfo, int n10) {
        this.a = playbackInfo;
        this.b = n10;
    }

    public final void invoke(Object object) {
        PlaybackInfo playbackInfo = this.a;
        int n10 = this.b;
        object = (Player$EventListener)object;
        ExoPlayerImpl.t(playbackInfo, n10, (Player$EventListener)object);
    }
}

