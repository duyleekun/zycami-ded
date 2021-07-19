/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.drm;

import com.google.android.exoplayer2.drm.DefaultDrmSessionManager;
import com.google.android.exoplayer2.drm.DefaultDrmSessionManager$1;
import com.google.android.exoplayer2.drm.DefaultDrmSessionManager$MediaDrmHandler;
import com.google.android.exoplayer2.drm.ExoMediaDrm;
import com.google.android.exoplayer2.drm.ExoMediaDrm$OnEventListener;
import com.google.android.exoplayer2.util.Assertions;

public class DefaultDrmSessionManager$MediaDrmEventListener
implements ExoMediaDrm$OnEventListener {
    public final /* synthetic */ DefaultDrmSessionManager this$0;

    private DefaultDrmSessionManager$MediaDrmEventListener(DefaultDrmSessionManager defaultDrmSessionManager) {
        this.this$0 = defaultDrmSessionManager;
    }

    public /* synthetic */ DefaultDrmSessionManager$MediaDrmEventListener(DefaultDrmSessionManager defaultDrmSessionManager, DefaultDrmSessionManager$1 defaultDrmSessionManager$1) {
        this(defaultDrmSessionManager);
    }

    public void onEvent(ExoMediaDrm exoMediaDrm, byte[] byArray, int n10, int n11, byte[] byArray2) {
        ((DefaultDrmSessionManager$MediaDrmHandler)((Object)Assertions.checkNotNull((Object)this.this$0.mediaDrmHandler))).obtainMessage(n10, byArray).sendToTarget();
    }
}

