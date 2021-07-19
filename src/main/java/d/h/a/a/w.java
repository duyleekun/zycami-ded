/*
 * Decompiled with CFR 0.151.
 */
package d.h.a.a;

import com.google.android.exoplayer2.ExoPlayerImpl;
import com.google.android.exoplayer2.PlaybackInfo;
import com.google.android.exoplayer2.Player$EventListener;
import com.google.android.exoplayer2.util.ListenerSet$Event;

public final class w
implements ListenerSet$Event {
    public final /* synthetic */ PlaybackInfo a;

    public /* synthetic */ w(PlaybackInfo playbackInfo) {
        this.a = playbackInfo;
    }

    public final void invoke(Object object) {
        PlaybackInfo playbackInfo = this.a;
        object = (Player$EventListener)object;
        ExoPlayerImpl.q(playbackInfo, (Player$EventListener)object);
    }
}

