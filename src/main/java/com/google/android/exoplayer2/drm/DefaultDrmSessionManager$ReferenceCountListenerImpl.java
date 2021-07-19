/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.SystemClock
 */
package com.google.android.exoplayer2.drm;

import android.os.Handler;
import android.os.SystemClock;
import com.google.android.exoplayer2.drm.DefaultDrmSession;
import com.google.android.exoplayer2.drm.DefaultDrmSession$ReferenceCountListener;
import com.google.android.exoplayer2.drm.DefaultDrmSessionManager;
import com.google.android.exoplayer2.drm.DefaultDrmSessionManager$1;
import com.google.android.exoplayer2.util.Assertions;
import d.h.a.a.g0.d;

public class DefaultDrmSessionManager$ReferenceCountListenerImpl
implements DefaultDrmSession$ReferenceCountListener {
    public final /* synthetic */ DefaultDrmSessionManager this$0;

    private DefaultDrmSessionManager$ReferenceCountListenerImpl(DefaultDrmSessionManager defaultDrmSessionManager) {
        this.this$0 = defaultDrmSessionManager;
    }

    public /* synthetic */ DefaultDrmSessionManager$ReferenceCountListenerImpl(DefaultDrmSessionManager defaultDrmSessionManager, DefaultDrmSessionManager$1 defaultDrmSessionManager$1) {
        this(defaultDrmSessionManager);
    }

    public static /* synthetic */ void a(DefaultDrmSession defaultDrmSession) {
        defaultDrmSession.release(null);
    }

    public void onReferenceCountDecremented(DefaultDrmSession defaultDrmSession, int n10) {
        DefaultDrmSessionManager defaultDrmSessionManager;
        long l10;
        long l11;
        long l12;
        long l13 = -9223372036854775807L;
        int n11 = 1;
        if (n10 == n11 && (l12 = (l11 = (l10 = DefaultDrmSessionManager.access$700(defaultDrmSessionManager = this.this$0)) - l13) == 0L ? 0 : (l11 < 0L ? -1 : 1)) != false) {
            DefaultDrmSessionManager.access$800(this.this$0).add(defaultDrmSession);
            Handler handler = (Handler)Assertions.checkNotNull(DefaultDrmSessionManager.access$900(this.this$0));
            d d10 = new d(defaultDrmSession);
            long l14 = SystemClock.uptimeMillis();
            defaultDrmSessionManager = this.this$0;
            l10 = DefaultDrmSessionManager.access$700(defaultDrmSessionManager);
            handler.postAtTime((Runnable)d10, (Object)defaultDrmSession, l14 += l10);
        } else if (n10 == 0) {
            DefaultDrmSessionManager.access$500(this.this$0).remove(defaultDrmSession);
            Object object = DefaultDrmSessionManager.access$1000(this.this$0);
            l12 = 0;
            defaultDrmSessionManager = null;
            if (object == defaultDrmSession) {
                object = this.this$0;
                DefaultDrmSessionManager.access$1002((DefaultDrmSessionManager)object, null);
            }
            if ((object = DefaultDrmSessionManager.access$1100(this.this$0)) == defaultDrmSession) {
                object = this.this$0;
                DefaultDrmSessionManager.access$1102((DefaultDrmSessionManager)object, null);
            }
            if ((n10 = (object = DefaultDrmSessionManager.access$600(this.this$0)).size()) > n11) {
                object = DefaultDrmSessionManager.access$600(this.this$0);
                l12 = 0;
                defaultDrmSessionManager = null;
                if ((object = object.get(0)) == defaultDrmSession) {
                    object = (DefaultDrmSession)DefaultDrmSessionManager.access$600(this.this$0).get(n11);
                    ((DefaultDrmSession)object).provision();
                }
            }
            DefaultDrmSessionManager.access$600(this.this$0).remove(defaultDrmSession);
            object = this.this$0;
            long l15 = DefaultDrmSessionManager.access$700((DefaultDrmSessionManager)object);
            n10 = (int)(l15 == l13 ? 0 : (l15 < l13 ? -1 : 1));
            if (n10 != 0) {
                ((Handler)Assertions.checkNotNull(DefaultDrmSessionManager.access$900(this.this$0))).removeCallbacksAndMessages((Object)defaultDrmSession);
                object = DefaultDrmSessionManager.access$800(this.this$0);
                object.remove(defaultDrmSession);
            }
        }
    }

    public void onReferenceCountIncremented(DefaultDrmSession defaultDrmSession, int n10) {
        long l10;
        DefaultDrmSessionManager defaultDrmSessionManager = this.this$0;
        long l11 = DefaultDrmSessionManager.access$700(defaultDrmSessionManager);
        long l12 = l11 - (l10 = -9223372036854775807L);
        n10 = (int)(l12 == 0L ? 0 : (l12 < 0L ? -1 : 1));
        if (n10 != 0) {
            DefaultDrmSessionManager.access$800(this.this$0).remove(defaultDrmSession);
            defaultDrmSessionManager = (Handler)Assertions.checkNotNull(DefaultDrmSessionManager.access$900(this.this$0));
            defaultDrmSessionManager.removeCallbacksAndMessages(defaultDrmSession);
        }
    }
}

