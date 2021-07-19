/*
 * Decompiled with CFR 0.151.
 */
package d.h.a.a;

import com.google.android.exoplayer2.Player$EventListener;
import com.google.android.exoplayer2.util.ListenerSet$Event;

public final class a
implements ListenerSet$Event {
    public static final /* synthetic */ a a;

    static {
        a a10;
        a = a10 = new a();
    }

    public final void invoke(Object object) {
        ((Player$EventListener)object).onSeekProcessed();
    }
}

