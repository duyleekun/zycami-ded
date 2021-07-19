/*
 * Decompiled with CFR 0.151.
 */
package d.h.a.a.g0;

import com.google.android.exoplayer2.drm.DefaultDrmSession;
import com.google.android.exoplayer2.drm.DrmSessionEventListener$EventDispatcher;
import com.google.android.exoplayer2.util.Consumer;

public final class c
implements Consumer {
    public final /* synthetic */ Exception a;

    public /* synthetic */ c(Exception exception) {
        this.a = exception;
    }

    public final void accept(Object object) {
        Exception exception = this.a;
        object = (DrmSessionEventListener$EventDispatcher)object;
        DefaultDrmSession.a(exception, (DrmSessionEventListener$EventDispatcher)object);
    }
}

