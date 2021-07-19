/*
 * Decompiled with CFR 0.151.
 */
package d.h.a.a.l0;

import com.google.android.exoplayer2.scheduler.RequirementsWatcher$NetworkCallback;

public final class b
implements Runnable {
    public final /* synthetic */ RequirementsWatcher$NetworkCallback a;

    public /* synthetic */ b(RequirementsWatcher$NetworkCallback requirementsWatcher$NetworkCallback) {
        this.a = requirementsWatcher$NetworkCallback;
    }

    public final void run() {
        this.a.d();
    }
}

