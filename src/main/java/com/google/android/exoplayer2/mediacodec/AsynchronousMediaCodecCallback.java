/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.media.MediaCodec
 *  android.media.MediaCodec$BufferInfo
 *  android.media.MediaCodec$Callback
 *  android.media.MediaCodec$CodecException
 *  android.media.MediaFormat
 *  android.os.Handler
 *  android.os.HandlerThread
 *  android.os.Looper
 */
package com.google.android.exoplayer2.mediacodec;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.IntArrayQueue;
import com.google.android.exoplayer2.util.Util;
import d.h.a.a.i0.d;
import java.util.ArrayDeque;

public final class AsynchronousMediaCodecCallback
extends MediaCodec.Callback {
    private final IntArrayQueue availableInputBuffers;
    private final IntArrayQueue availableOutputBuffers;
    private final ArrayDeque bufferInfos;
    private final HandlerThread callbackThread;
    private MediaFormat currentFormat;
    private final ArrayDeque formats;
    private Handler handler;
    private IllegalStateException internalException;
    private final Object lock;
    private MediaCodec.CodecException mediaCodecException;
    private long pendingFlushCount;
    private MediaFormat pendingOutputFormat;
    private boolean shutDown;

    public AsynchronousMediaCodecCallback(HandlerThread object) {
        Object object2;
        this.lock = object2 = new Object();
        this.callbackThread = object;
        this.availableInputBuffers = object;
        super();
        this.availableOutputBuffers = object;
        super();
        this.bufferInfos = object;
        super();
        this.formats = object;
    }

    private /* synthetic */ void a(Runnable runnable) {
        this.onFlushCompleted(runnable);
    }

    private void addOutputFormat(MediaFormat mediaFormat) {
        this.availableOutputBuffers.add(-2);
        this.formats.add(mediaFormat);
    }

    private void flushInternal() {
        ArrayDeque arrayDeque = this.formats;
        boolean bl2 = arrayDeque.isEmpty();
        if (!bl2) {
            arrayDeque = (MediaFormat)this.formats.getLast();
            this.pendingOutputFormat = arrayDeque;
        }
        this.availableInputBuffers.clear();
        this.availableOutputBuffers.clear();
        this.bufferInfos.clear();
        this.formats.clear();
        this.mediaCodecException = null;
    }

    private boolean isFlushingOrShutdown() {
        long l10 = this.pendingFlushCount;
        long l11 = 0L;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        object = object <= 0 && (object = (Object)this.shutDown) == false ? (Object)0 : (Object)1;
        return (boolean)object;
    }

    private void maybeThrowException() {
        this.maybeThrowInternalException();
        this.maybeThrowMediaCodecException();
    }

    private void maybeThrowInternalException() {
        IllegalStateException illegalStateException = this.internalException;
        if (illegalStateException == null) {
            return;
        }
        this.internalException = null;
        throw illegalStateException;
    }

    private void maybeThrowMediaCodecException() {
        MediaCodec.CodecException codecException = this.mediaCodecException;
        if (codecException == null) {
            return;
        }
        this.mediaCodecException = null;
        throw codecException;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void onFlushCompleted(Runnable runnable) {
        Object object = this.lock;
        synchronized (object) {
            this.onFlushCompletedSynchronized(runnable);
            return;
        }
    }

    private void onFlushCompletedSynchronized(Runnable object) {
        long l10;
        Object object2 = this.shutDown;
        if (object2 != 0) {
            return;
        }
        this.pendingFlushCount = l10 = this.pendingFlushCount - 1L;
        long l11 = 0L;
        long l12 = l10 - l11;
        Object object3 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object3 > 0) {
            return;
        }
        object2 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        if (object2 < 0) {
            object = new IllegalStateException();
            this.setInternalException((IllegalStateException)object);
            return;
        }
        this.flushInternal();
        try {
            object.run();
        }
        catch (Exception exception) {
            IllegalStateException illegalStateException = new IllegalStateException(exception);
            this.setInternalException(illegalStateException);
        }
        catch (IllegalStateException illegalStateException) {
            this.setInternalException(illegalStateException);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void setInternalException(IllegalStateException illegalStateException) {
        Object object = this.lock;
        synchronized (object) {
            this.internalException = illegalStateException;
            return;
        }
    }

    public /* synthetic */ void b(Runnable runnable) {
        this.a(runnable);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public int dequeueInputBufferIndex() {
        Object object = this.lock;
        synchronized (object) {
            boolean bl2 = this.isFlushingOrShutdown();
            int n10 = -1;
            if (bl2) {
                return n10;
            }
            this.maybeThrowException();
            IntArrayQueue intArrayQueue = this.availableInputBuffers;
            bl2 = intArrayQueue.isEmpty();
            if (!bl2) {
                intArrayQueue = this.availableInputBuffers;
                return intArrayQueue.remove();
            }
            return n10;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public int dequeueOutputBufferIndex(MediaCodec.BufferInfo object) {
        Object object2 = this.lock;
        synchronized (object2) {
            int n10 = this.isFlushingOrShutdown();
            int n11 = -1;
            if (n10 != 0) {
                return n11;
            }
            this.maybeThrowException();
            IntArrayQueue intArrayQueue = this.availableOutputBuffers;
            n10 = intArrayQueue.isEmpty();
            if (n10 != 0) {
                return n11;
            }
            intArrayQueue = this.availableOutputBuffers;
            n10 = intArrayQueue.remove();
            if (n10 >= 0) {
                Object object3 = this.currentFormat;
                Assertions.checkStateNotNull(object3);
                object3 = this.bufferInfos;
                object3 = object3.remove();
                object3 = (MediaCodec.BufferInfo)object3;
                int n12 = object3.offset;
                int n13 = object3.size;
                long l10 = object3.presentationTimeUs;
                int n14 = object3.flags;
                object.set(n12, n13, l10, n14);
            } else {
                int n15 = -2;
                if (n10 == n15) {
                    object = this.formats;
                    object = object.remove();
                    object = (MediaFormat)object;
                    this.currentFormat = object;
                }
            }
            return n10;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void flushAsync(Runnable runnable) {
        Object object = this.lock;
        synchronized (object) {
            long l10 = this.pendingFlushCount;
            long l11 = 1L;
            this.pendingFlushCount = l10 += l11;
            Object object2 = this.handler;
            object2 = Util.castNonNull(object2);
            d d10 = new d(this, runnable);
            object2.post((Runnable)d10);
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public MediaFormat getOutputFormat() {
        Object object = this.lock;
        synchronized (object) {
            Object object2 = this.currentFormat;
            if (object2 != null) {
                return object2;
            }
            object2 = new IllegalStateException();
            throw object2;
        }
    }

    public void initialize(MediaCodec mediaCodec) {
        boolean bl2;
        Handler handler = this.handler;
        if (handler == null) {
            bl2 = true;
        } else {
            bl2 = false;
            handler = null;
        }
        Assertions.checkState(bl2);
        this.callbackThread.start();
        Looper looper = this.callbackThread.getLooper();
        handler = new Handler(looper);
        mediaCodec.setCallback((MediaCodec.Callback)this, handler);
        this.handler = handler;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void onError(MediaCodec object, MediaCodec.CodecException codecException) {
        object = this.lock;
        synchronized (object) {
            this.mediaCodecException = codecException;
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void onInputBufferAvailable(MediaCodec object, int n10) {
        object = this.lock;
        synchronized (object) {
            IntArrayQueue intArrayQueue = this.availableInputBuffers;
            intArrayQueue.add(n10);
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void onOutputBufferAvailable(MediaCodec object, int n10, MediaCodec.BufferInfo bufferInfo) {
        object = this.lock;
        synchronized (object) {
            Object object2 = this.pendingOutputFormat;
            if (object2 != null) {
                this.addOutputFormat((MediaFormat)object2);
                object2 = null;
                this.pendingOutputFormat = null;
            }
            object2 = this.availableOutputBuffers;
            ((IntArrayQueue)object2).add(n10);
            ArrayDeque arrayDeque = this.bufferInfos;
            arrayDeque.add(bufferInfo);
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void onOutputFormatChanged(MediaCodec object, MediaFormat mediaFormat) {
        object = this.lock;
        synchronized (object) {
            this.addOutputFormat(mediaFormat);
            mediaFormat = null;
            this.pendingOutputFormat = null;
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void shutdown() {
        Object object = this.lock;
        synchronized (object) {
            boolean bl2;
            this.shutDown = bl2 = true;
            HandlerThread handlerThread = this.callbackThread;
            handlerThread.quit();
            this.flushInternal();
            return;
        }
    }
}

