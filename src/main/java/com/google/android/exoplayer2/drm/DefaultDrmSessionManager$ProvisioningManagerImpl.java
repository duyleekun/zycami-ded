/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.drm;

import com.google.android.exoplayer2.drm.DefaultDrmSession;
import com.google.android.exoplayer2.drm.DefaultDrmSession$ProvisioningManager;
import com.google.android.exoplayer2.drm.DefaultDrmSessionManager;
import com.google.android.exoplayer2.drm.DefaultDrmSessionManager$1;
import java.util.Iterator;
import java.util.List;

public class DefaultDrmSessionManager$ProvisioningManagerImpl
implements DefaultDrmSession$ProvisioningManager {
    public final /* synthetic */ DefaultDrmSessionManager this$0;

    private DefaultDrmSessionManager$ProvisioningManagerImpl(DefaultDrmSessionManager defaultDrmSessionManager) {
        this.this$0 = defaultDrmSessionManager;
    }

    public /* synthetic */ DefaultDrmSessionManager$ProvisioningManagerImpl(DefaultDrmSessionManager defaultDrmSessionManager, DefaultDrmSessionManager$1 defaultDrmSessionManager$1) {
        this(defaultDrmSessionManager);
    }

    public void onProvisionCompleted() {
        boolean bl2;
        Iterator iterator2 = DefaultDrmSessionManager.access$600(this.this$0).iterator();
        while (bl2 = iterator2.hasNext()) {
            DefaultDrmSession defaultDrmSession = (DefaultDrmSession)iterator2.next();
            defaultDrmSession.onProvisionCompleted();
        }
        DefaultDrmSessionManager.access$600(this.this$0).clear();
    }

    public void onProvisionError(Exception exception) {
        boolean bl2;
        Iterator iterator2 = DefaultDrmSessionManager.access$600(this.this$0).iterator();
        while (bl2 = iterator2.hasNext()) {
            DefaultDrmSession defaultDrmSession = (DefaultDrmSession)iterator2.next();
            defaultDrmSession.onProvisionError(exception);
        }
        DefaultDrmSessionManager.access$600(this.this$0).clear();
    }

    public void provisionRequired(DefaultDrmSession defaultDrmSession) {
        List list = DefaultDrmSessionManager.access$600(this.this$0);
        int n10 = list.contains(defaultDrmSession);
        if (n10 != 0) {
            return;
        }
        DefaultDrmSessionManager.access$600(this.this$0).add(defaultDrmSession);
        list = DefaultDrmSessionManager.access$600(this.this$0);
        n10 = list.size();
        int n11 = 1;
        if (n10 == n11) {
            defaultDrmSession.provision();
        }
    }
}

