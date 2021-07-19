/*
 * Decompiled with CFR 0.151.
 */
package d.h.a.a;

import com.google.android.exoplayer2.ExoPlayerImpl;
import com.google.android.exoplayer2.Player$EventListener;
import com.google.android.exoplayer2.util.ListenerSet$Event;

public final class q
implements ListenerSet$Event {
    public static final /* synthetic */ q a;

    static {
        q q10;
        a = q10 = new q();
    }

    public final void invoke(Object object) {
        ExoPlayerImpl.f((Player$EventListener)object);
    }
}

