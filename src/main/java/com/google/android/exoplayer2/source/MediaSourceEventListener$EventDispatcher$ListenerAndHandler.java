/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 */
package com.google.android.exoplayer2.source;

import android.os.Handler;
import com.google.android.exoplayer2.source.MediaSourceEventListener;

public final class MediaSourceEventListener$EventDispatcher$ListenerAndHandler {
    public Handler handler;
    public MediaSourceEventListener listener;

    public MediaSourceEventListener$EventDispatcher$ListenerAndHandler(Handler handler, MediaSourceEventListener mediaSourceEventListener) {
        this.handler = handler;
        this.listener = mediaSourceEventListener;
    }
}

