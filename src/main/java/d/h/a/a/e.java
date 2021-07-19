/*
 * Decompiled with CFR 0.151.
 */
package d.h.a.a;

import com.google.android.exoplayer2.ExoPlayerImpl;
import com.google.android.exoplayer2.Player$EventListener;
import com.google.android.exoplayer2.util.ListenerSet$Event;

public final class e
implements ListenerSet$Event {
    public final /* synthetic */ int a;

    public /* synthetic */ e(int n10) {
        this.a = n10;
    }

    public final void invoke(Object object) {
        int n10 = this.a;
        object = (Player$EventListener)object;
        ExoPlayerImpl.g(n10, (Player$EventListener)object);
    }
}

