/*
 * Decompiled with CFR 0.151.
 */
package d.h.a.a;

import com.google.android.exoplayer2.ExoPlayerImpl;
import com.google.android.exoplayer2.Player$EventListener;
import com.google.android.exoplayer2.util.ListenerSet$Event;

public final class h
implements ListenerSet$Event {
    public final /* synthetic */ boolean a;

    public /* synthetic */ h(boolean bl2) {
        this.a = bl2;
    }

    public final void invoke(Object object) {
        boolean bl2 = this.a;
        object = (Player$EventListener)object;
        ExoPlayerImpl.h(bl2, (Player$EventListener)object);
    }
}

