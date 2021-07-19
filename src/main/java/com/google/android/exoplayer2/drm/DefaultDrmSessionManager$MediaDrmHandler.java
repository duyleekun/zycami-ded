/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Looper
 *  android.os.Message
 */
package com.google.android.exoplayer2.drm;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.android.exoplayer2.drm.DefaultDrmSession;
import com.google.android.exoplayer2.drm.DefaultDrmSessionManager;
import java.util.Iterator;

public class DefaultDrmSessionManager$MediaDrmHandler
extends Handler {
    public final /* synthetic */ DefaultDrmSessionManager this$0;

    public DefaultDrmSessionManager$MediaDrmHandler(DefaultDrmSessionManager defaultDrmSessionManager, Looper looper) {
        this.this$0 = defaultDrmSessionManager;
        super(looper);
    }

    public void handleMessage(Message message) {
        boolean bl2;
        byte[] byArray = (byte[])message.obj;
        if (byArray == null) {
            return;
        }
        Iterator iterator2 = DefaultDrmSessionManager.access$500(this.this$0).iterator();
        while (bl2 = iterator2.hasNext()) {
            DefaultDrmSession defaultDrmSession = (DefaultDrmSession)iterator2.next();
            boolean bl3 = defaultDrmSession.hasSessionId(byArray);
            if (!bl3) continue;
            int n10 = message.what;
            defaultDrmSession.onMediaDrmEvent(n10);
            break;
        }
    }
}

