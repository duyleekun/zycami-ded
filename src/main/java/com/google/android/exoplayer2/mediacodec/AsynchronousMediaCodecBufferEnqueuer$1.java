/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Looper
 *  android.os.Message
 */
package com.google.android.exoplayer2.mediacodec;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.android.exoplayer2.mediacodec.AsynchronousMediaCodecBufferEnqueuer;

public class AsynchronousMediaCodecBufferEnqueuer$1
extends Handler {
    public final /* synthetic */ AsynchronousMediaCodecBufferEnqueuer this$0;

    public AsynchronousMediaCodecBufferEnqueuer$1(AsynchronousMediaCodecBufferEnqueuer asynchronousMediaCodecBufferEnqueuer, Looper looper) {
        this.this$0 = asynchronousMediaCodecBufferEnqueuer;
        super(looper);
    }

    public void handleMessage(Message message) {
        AsynchronousMediaCodecBufferEnqueuer.access$000(this.this$0, message);
    }
}

