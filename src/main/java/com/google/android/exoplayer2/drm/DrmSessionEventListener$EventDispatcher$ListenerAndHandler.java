/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 */
package com.google.android.exoplayer2.drm;

import android.os.Handler;
import com.google.android.exoplayer2.drm.DrmSessionEventListener;

public final class DrmSessionEventListener$EventDispatcher$ListenerAndHandler {
    public Handler handler;
    public DrmSessionEventListener listener;

    public DrmSessionEventListener$EventDispatcher$ListenerAndHandler(Handler handler, DrmSessionEventListener drmSessionEventListener) {
        this.handler = handler;
        this.listener = drmSessionEventListener;
    }
}

