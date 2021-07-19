/*
 * Decompiled with CFR 0.151.
 */
package d.h.a.a;

import com.google.android.exoplayer2.ExoPlayerImpl;
import com.google.android.exoplayer2.Player$EventListener;
import com.google.android.exoplayer2.util.ListenerSet$Event;

public final class d
implements ListenerSet$Event {
    public final /* synthetic */ int a;

    public /* synthetic */ d(int n10) {
        this.a = n10;
    }

    public final void invoke(Object object) {
        int n10 = this.a;
        object = (Player$EventListener)object;
        ExoPlayerImpl.u(n10, (Player$EventListener)object);
    }
}

