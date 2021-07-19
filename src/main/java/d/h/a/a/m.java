/*
 * Decompiled with CFR 0.151.
 */
package d.h.a.a;

import com.google.android.exoplayer2.ExoPlayerImpl;
import com.google.android.exoplayer2.PlaybackInfo;
import com.google.android.exoplayer2.Player$EventListener;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.google.android.exoplayer2.util.ListenerSet$Event;

public final class m
implements ListenerSet$Event {
    public final /* synthetic */ PlaybackInfo a;
    public final /* synthetic */ TrackSelectionArray b;

    public /* synthetic */ m(PlaybackInfo playbackInfo, TrackSelectionArray trackSelectionArray) {
        this.a = playbackInfo;
        this.b = trackSelectionArray;
    }

    public final void invoke(Object object) {
        PlaybackInfo playbackInfo = this.a;
        TrackSelectionArray trackSelectionArray = this.b;
        object = (Player$EventListener)object;
        ExoPlayerImpl.i(playbackInfo, trackSelectionArray, (Player$EventListener)object);
    }
}

