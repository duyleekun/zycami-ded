/*
 * Decompiled with CFR 0.151.
 */
package d.h.a.a.g0;

import com.google.android.exoplayer2.drm.DefaultDrmSession;
import com.google.android.exoplayer2.drm.DefaultDrmSessionManager$ReferenceCountListenerImpl;

public final class d
implements Runnable {
    public final /* synthetic */ DefaultDrmSession a;

    public /* synthetic */ d(DefaultDrmSession defaultDrmSession) {
        this.a = defaultDrmSession;
    }

    public final void run() {
        DefaultDrmSessionManager$ReferenceCountListenerImpl.a(this.a);
    }
}

