/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.media.MediaCodec
 *  android.os.HandlerThread
 */
package com.google.android.exoplayer2.mediacodec;

import android.media.MediaCodec;
import android.os.HandlerThread;
import com.google.android.exoplayer2.mediacodec.AsynchronousMediaCodecAdapter;
import com.google.android.exoplayer2.mediacodec.MediaCodecAdapter$Factory;
import com.google.common.base.Supplier;
import d.h.a.a.i0.a;
import d.h.a.a.i0.b;

public final class AsynchronousMediaCodecAdapter$Factory
implements MediaCodecAdapter$Factory {
    private final Supplier callbackThreadSupplier;
    private final boolean forceQueueingSynchronizationWorkaround;
    private final Supplier queueingThreadSupplier;
    private final boolean synchronizeCodecInteractionsWithQueueing;

    public AsynchronousMediaCodecAdapter$Factory(int n10) {
        this(n10, false, false);
    }

    public AsynchronousMediaCodecAdapter$Factory(int n10, boolean bl2, boolean bl3) {
        a a10 = new a(n10);
        b b10 = new b(n10);
        this(a10, b10, bl2, bl3);
    }

    public AsynchronousMediaCodecAdapter$Factory(Supplier supplier, Supplier supplier2, boolean bl2, boolean bl3) {
        this.callbackThreadSupplier = supplier;
        this.queueingThreadSupplier = supplier2;
        this.forceQueueingSynchronizationWorkaround = bl2;
        this.synchronizeCodecInteractionsWithQueueing = bl3;
    }

    public static /* synthetic */ HandlerThread a(int n10) {
        String string2 = AsynchronousMediaCodecAdapter.access$200(n10);
        HandlerThread handlerThread = new HandlerThread(string2);
        return handlerThread;
    }

    public static /* synthetic */ HandlerThread b(int n10) {
        String string2 = AsynchronousMediaCodecAdapter.access$100(n10);
        HandlerThread handlerThread = new HandlerThread(string2);
        return handlerThread;
    }

    public AsynchronousMediaCodecAdapter createAdapter(MediaCodec mediaCodec) {
        AsynchronousMediaCodecAdapter asynchronousMediaCodecAdapter;
        Object object;
        Object object2 = object = this.callbackThreadSupplier.get();
        object2 = (HandlerThread)object;
        Object object3 = object = this.queueingThreadSupplier.get();
        object3 = (HandlerThread)object;
        boolean bl2 = this.forceQueueingSynchronizationWorkaround;
        boolean bl3 = this.synchronizeCodecInteractionsWithQueueing;
        object = asynchronousMediaCodecAdapter;
        asynchronousMediaCodecAdapter = new AsynchronousMediaCodecAdapter(mediaCodec, (HandlerThread)object2, (HandlerThread)object3, bl2, bl3, null);
        return asynchronousMediaCodecAdapter;
    }
}

