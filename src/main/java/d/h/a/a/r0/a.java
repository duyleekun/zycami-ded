/*
 * Decompiled with CFR 0.151.
 */
package d.h.a.a.r0;

import com.google.android.exoplayer2.util.ListenerSet;
import com.google.android.exoplayer2.util.ListenerSet$Event;
import java.util.concurrent.CopyOnWriteArraySet;

public final class a
implements Runnable {
    public final /* synthetic */ CopyOnWriteArraySet a;
    public final /* synthetic */ int b;
    public final /* synthetic */ ListenerSet$Event c;

    public /* synthetic */ a(CopyOnWriteArraySet copyOnWriteArraySet, int n10, ListenerSet$Event listenerSet$Event) {
        this.a = copyOnWriteArraySet;
        this.b = n10;
        this.c = listenerSet$Event;
    }

    public final void run() {
        CopyOnWriteArraySet copyOnWriteArraySet = this.a;
        int n10 = this.b;
        ListenerSet$Event listenerSet$Event = this.c;
        ListenerSet.b(copyOnWriteArraySet, n10, listenerSet$Event);
    }
}

