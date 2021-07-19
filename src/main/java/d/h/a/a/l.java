/*
 * Decompiled with CFR 0.151.
 */
package d.h.a.a;

import com.google.android.exoplayer2.ExoPlayerImpl;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.Player$EventListener;
import com.google.android.exoplayer2.Player$Events;
import com.google.android.exoplayer2.util.ListenerSet$IterationFinishedEvent;
import com.google.android.exoplayer2.util.MutableFlags;

public final class l
implements ListenerSet$IterationFinishedEvent {
    public final /* synthetic */ Player a;

    public /* synthetic */ l(Player player) {
        this.a = player;
    }

    public final void invoke(Object object, MutableFlags mutableFlags) {
        Player player = this.a;
        object = (Player$EventListener)object;
        mutableFlags = (Player$Events)mutableFlags;
        ExoPlayerImpl.a(player, (Player$EventListener)object, (Player$Events)mutableFlags);
    }
}

