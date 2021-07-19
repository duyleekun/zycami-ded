/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Looper
 *  android.os.Message
 *  android.util.Pair
 */
package com.google.android.exoplayer2.drm;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Pair;
import com.google.android.exoplayer2.drm.DefaultDrmSession;

public class DefaultDrmSession$ResponseHandler
extends Handler {
    public final /* synthetic */ DefaultDrmSession this$0;

    public DefaultDrmSession$ResponseHandler(DefaultDrmSession defaultDrmSession, Looper looper) {
        this.this$0 = defaultDrmSession;
        super(looper);
    }

    public void handleMessage(Message object) {
        Object object2 = (Pair)object.obj;
        Object object3 = object2.first;
        object2 = object2.second;
        int n10 = object.what;
        if (n10 != 0) {
            int n11 = 1;
            if (n10 == n11) {
                object = this.this$0;
                DefaultDrmSession.access$100((DefaultDrmSession)object, object3, object2);
            }
        } else {
            object = this.this$0;
            DefaultDrmSession.access$000((DefaultDrmSession)object, object3, object2);
        }
    }
}

