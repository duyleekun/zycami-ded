/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.media.MediaCodec
 *  android.media.MediaCodec$CryptoInfo
 *  android.media.MediaCodec$CryptoInfo$Pattern
 *  android.os.Handler
 *  android.os.HandlerThread
 *  android.os.Looper
 *  android.os.Message
 */
package com.google.android.exoplayer2.mediacodec;

import android.media.MediaCodec;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.google.android.exoplayer2.decoder.CryptoInfo;
import com.google.android.exoplayer2.mediacodec.AsynchronousMediaCodecBufferEnqueuer$1;
import com.google.android.exoplayer2.mediacodec.AsynchronousMediaCodecBufferEnqueuer$MessageParams;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ConditionVariable;
import com.google.android.exoplayer2.util.Util;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;

public class AsynchronousMediaCodecBufferEnqueuer {
    private static final ArrayDeque MESSAGE_PARAMS_INSTANCE_POOL;
    private static final int MSG_OPEN_CV = 2;
    private static final int MSG_QUEUE_INPUT_BUFFER = 0;
    private static final int MSG_QUEUE_SECURE_INPUT_BUFFER = 1;
    private static final Object QUEUE_SECURE_LOCK;
    private final MediaCodec codec;
    private final ConditionVariable conditionVariable;
    private Handler handler;
    private final HandlerThread handlerThread;
    private final boolean needsSynchronizationWorkaround;
    private final AtomicReference pendingRuntimeException;
    private boolean started;

    static {
        Object object = new ArrayDeque();
        MESSAGE_PARAMS_INSTANCE_POOL = object;
        QUEUE_SECURE_LOCK = object = new Object();
    }

    public AsynchronousMediaCodecBufferEnqueuer(MediaCodec mediaCodec, HandlerThread handlerThread, boolean bl2) {
        ConditionVariable conditionVariable = new ConditionVariable();
        this(mediaCodec, handlerThread, bl2, conditionVariable);
    }

    public AsynchronousMediaCodecBufferEnqueuer(MediaCodec object, HandlerThread handlerThread, boolean bl2, ConditionVariable conditionVariable) {
        boolean bl3;
        this.codec = object;
        this.handlerThread = handlerThread;
        this.conditionVariable = conditionVariable;
        this.pendingRuntimeException = object;
        if (!bl2 && !(bl3 = AsynchronousMediaCodecBufferEnqueuer.needsSynchronizationWorkaround())) {
            bl3 = false;
            object = null;
        } else {
            bl3 = true;
        }
        this.needsSynchronizationWorkaround = bl3;
    }

    public static /* synthetic */ void access$000(AsynchronousMediaCodecBufferEnqueuer asynchronousMediaCodecBufferEnqueuer, Message message) {
        asynchronousMediaCodecBufferEnqueuer.doHandleMessage(message);
    }

    private void blockUntilHandlerThreadIsIdle() {
        this.conditionVariable.close();
        ((Handler)Util.castNonNull(this.handler)).obtainMessage(2).sendToTarget();
        this.conditionVariable.block();
    }

    private static void copy(CryptoInfo cryptoInfo, MediaCodec.CryptoInfo cryptoInfo2) {
        int n10;
        cryptoInfo2.numSubSamples = n10 = cryptoInfo.numSubSamples;
        Object object = cryptoInfo.numBytesOfClearData;
        Object[] objectArray = cryptoInfo2.numBytesOfClearData;
        object = AsynchronousMediaCodecBufferEnqueuer.copy(object, objectArray);
        cryptoInfo2.numBytesOfClearData = object;
        object = cryptoInfo.numBytesOfEncryptedData;
        objectArray = cryptoInfo2.numBytesOfEncryptedData;
        object = AsynchronousMediaCodecBufferEnqueuer.copy(object, objectArray);
        cryptoInfo2.numBytesOfEncryptedData = object;
        object = cryptoInfo.key;
        objectArray = cryptoInfo2.key;
        object = (byte[])Assertions.checkNotNull(AsynchronousMediaCodecBufferEnqueuer.copy((byte[])object, (byte[])objectArray));
        cryptoInfo2.key = (byte[])object;
        object = cryptoInfo.iv;
        objectArray = cryptoInfo2.iv;
        object = (byte[])Assertions.checkNotNull(AsynchronousMediaCodecBufferEnqueuer.copy((byte[])object, (byte[])objectArray));
        cryptoInfo2.iv = (byte[])object;
        cryptoInfo2.mode = n10 = cryptoInfo.mode;
        n10 = Util.SDK_INT;
        int n11 = 24;
        if (n10 >= n11) {
            object = new MediaCodec.CryptoInfo.Pattern;
            n11 = cryptoInfo.encryptedBlocks;
            int n12 = cryptoInfo.clearBlocks;
            object(n11, n12);
            cryptoInfo2.setPattern((MediaCodec.CryptoInfo.Pattern)object);
        }
    }

    private static byte[] copy(byte[] byArray, byte[] byArray2) {
        int n10;
        int n11;
        if (byArray == null) {
            return byArray2;
        }
        if (byArray2 != null && (n11 = byArray2.length) >= (n10 = byArray.length)) {
            n11 = byArray.length;
            System.arraycopy(byArray, 0, byArray2, 0, n11);
            return byArray2;
        }
        int n12 = byArray.length;
        return Arrays.copyOf(byArray, n12);
    }

    private static int[] copy(int[] nArray, int[] nArray2) {
        int n10;
        int n11;
        if (nArray == null) {
            return nArray2;
        }
        if (nArray2 != null && (n11 = nArray2.length) >= (n10 = nArray.length)) {
            n11 = nArray.length;
            System.arraycopy(nArray, 0, nArray2, 0, n11);
            return nArray2;
        }
        int n12 = nArray.length;
        return Arrays.copyOf(nArray, n12);
    }

    private void doHandleMessage(Message object) {
        int n10 = ((Message)object).what;
        if (n10 != 0) {
            int n11 = 1;
            if (n10 != n11) {
                int n12;
                n11 = 2;
                if (n10 != n11) {
                    n12 = ((Message)object).what;
                    object = String.valueOf(n12);
                    IllegalStateException illegalStateException = new IllegalStateException((String)object);
                    this.setPendingRuntimeException(illegalStateException);
                } else {
                    object = this.conditionVariable;
                    ((ConditionVariable)object).open();
                }
                n12 = 0;
                object = null;
            } else {
                object = (AsynchronousMediaCodecBufferEnqueuer$MessageParams)((Message)object).obj;
                n11 = ((AsynchronousMediaCodecBufferEnqueuer$MessageParams)object).index;
                int n13 = ((AsynchronousMediaCodecBufferEnqueuer$MessageParams)object).offset;
                MediaCodec.CryptoInfo cryptoInfo = ((AsynchronousMediaCodecBufferEnqueuer$MessageParams)object).cryptoInfo;
                long l10 = ((AsynchronousMediaCodecBufferEnqueuer$MessageParams)object).presentationTimeUs;
                int n14 = ((AsynchronousMediaCodecBufferEnqueuer$MessageParams)object).flags;
                AsynchronousMediaCodecBufferEnqueuer asynchronousMediaCodecBufferEnqueuer = this;
                this.doQueueSecureInputBuffer(n11, n13, cryptoInfo, l10, n14);
            }
        } else {
            object = (AsynchronousMediaCodecBufferEnqueuer$MessageParams)((Message)object).obj;
            int n15 = ((AsynchronousMediaCodecBufferEnqueuer$MessageParams)object).index;
            int n16 = ((AsynchronousMediaCodecBufferEnqueuer$MessageParams)object).offset;
            int n17 = ((AsynchronousMediaCodecBufferEnqueuer$MessageParams)object).size;
            long l11 = ((AsynchronousMediaCodecBufferEnqueuer$MessageParams)object).presentationTimeUs;
            int n18 = ((AsynchronousMediaCodecBufferEnqueuer$MessageParams)object).flags;
            AsynchronousMediaCodecBufferEnqueuer asynchronousMediaCodecBufferEnqueuer = this;
            this.doQueueInputBuffer(n15, n16, n17, l11, n18);
        }
        if (object != null) {
            AsynchronousMediaCodecBufferEnqueuer.recycleMessageParams((AsynchronousMediaCodecBufferEnqueuer$MessageParams)object);
        }
    }

    private void doQueueInputBuffer(int n10, int n11, int n12, long l10, int n13) {
        MediaCodec mediaCodec = this.codec;
        try {
            mediaCodec.queueInputBuffer(n10, n11, n12, l10, n13);
        }
        catch (RuntimeException runtimeException) {
            this.setPendingRuntimeException(runtimeException);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void doQueueSecureInputBuffer(int n10, int n11, MediaCodec.CryptoInfo cryptoInfo, long l10, int n12) {
        block5: {
            MediaCodec mediaCodec;
            try {
                boolean bl2 = this.needsSynchronizationWorkaround;
                if (!bl2) break block5;
                Object object = QUEUE_SECURE_LOCK;
                synchronized (object) {
                    mediaCodec = this.codec;
                }
            }
            catch (RuntimeException runtimeException) {
                this.setPendingRuntimeException(runtimeException);
                return;
            }
            {
                mediaCodec.queueSecureInputBuffer(n10, n11, cryptoInfo, l10, n12);
                return;
            }
        }
        MediaCodec mediaCodec = this.codec;
        mediaCodec.queueSecureInputBuffer(n10, n11, cryptoInfo, l10, n12);
    }

    private void flushHandlerThread() {
        ((Handler)Util.castNonNull(this.handler)).removeCallbacksAndMessages(null);
        this.blockUntilHandlerThreadIsIdle();
        this.maybeThrowException();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static AsynchronousMediaCodecBufferEnqueuer$MessageParams getMessageParams() {
        ArrayDeque arrayDeque = MESSAGE_PARAMS_INSTANCE_POOL;
        synchronized (arrayDeque) {
            boolean bl2 = arrayDeque.isEmpty();
            if (bl2) {
                return new AsynchronousMediaCodecBufferEnqueuer$MessageParams();
            }
            Object object = arrayDeque.removeFirst();
            return (AsynchronousMediaCodecBufferEnqueuer$MessageParams)object;
        }
    }

    private void maybeThrowException() {
        RuntimeException runtimeException = this.pendingRuntimeException.getAndSet(null);
        if (runtimeException == null) {
            return;
        }
        throw runtimeException;
    }

    private static boolean needsSynchronizationWorkaround() {
        boolean bl2;
        String string2;
        String string3 = Util.toLowerInvariant(Util.MANUFACTURER);
        boolean bl3 = string3.contains(string2 = "samsung");
        if (!bl3 && !(bl2 = string3.contains(string2 = "motorola"))) {
            bl2 = false;
            string3 = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static void recycleMessageParams(AsynchronousMediaCodecBufferEnqueuer$MessageParams asynchronousMediaCodecBufferEnqueuer$MessageParams) {
        ArrayDeque arrayDeque = MESSAGE_PARAMS_INSTANCE_POOL;
        synchronized (arrayDeque) {
            arrayDeque.add(asynchronousMediaCodecBufferEnqueuer$MessageParams);
            return;
        }
    }

    public void flush() {
        boolean bl2 = this.started;
        if (bl2) {
            try {
                this.flushHandlerThread();
            }
            catch (InterruptedException interruptedException) {
                Thread.currentThread().interrupt();
                IllegalStateException illegalStateException = new IllegalStateException(interruptedException);
                throw illegalStateException;
            }
        }
    }

    public void queueInputBuffer(int n10, int n11, int n12, long l10, int n13) {
        this.maybeThrowException();
        AsynchronousMediaCodecBufferEnqueuer$MessageParams asynchronousMediaCodecBufferEnqueuer$MessageParams = AsynchronousMediaCodecBufferEnqueuer.getMessageParams();
        asynchronousMediaCodecBufferEnqueuer$MessageParams.setQueueParams(n10, n11, n12, l10, n13);
        ((Handler)Util.castNonNull(this.handler)).obtainMessage(0, (Object)asynchronousMediaCodecBufferEnqueuer$MessageParams).sendToTarget();
    }

    public void queueSecureInputBuffer(int n10, int n11, CryptoInfo cryptoInfo, long l10, int n12) {
        this.maybeThrowException();
        AsynchronousMediaCodecBufferEnqueuer$MessageParams asynchronousMediaCodecBufferEnqueuer$MessageParams = AsynchronousMediaCodecBufferEnqueuer.getMessageParams();
        asynchronousMediaCodecBufferEnqueuer$MessageParams.setQueueParams(n10, n11, 0, l10, n12);
        MediaCodec.CryptoInfo cryptoInfo2 = asynchronousMediaCodecBufferEnqueuer$MessageParams.cryptoInfo;
        AsynchronousMediaCodecBufferEnqueuer.copy(cryptoInfo, cryptoInfo2);
        ((Handler)Util.castNonNull(this.handler)).obtainMessage(1, (Object)asynchronousMediaCodecBufferEnqueuer$MessageParams).sendToTarget();
    }

    public void setPendingRuntimeException(RuntimeException runtimeException) {
        this.pendingRuntimeException.set(runtimeException);
    }

    public void shutdown() {
        boolean bl2 = this.started;
        if (bl2) {
            this.flush();
            HandlerThread handlerThread = this.handlerThread;
            handlerThread.quit();
        }
        this.started = false;
    }

    public void start() {
        boolean bl2 = this.started;
        if (!bl2) {
            this.handlerThread.start();
            Looper looper = this.handlerThread.getLooper();
            AsynchronousMediaCodecBufferEnqueuer$1 asynchronousMediaCodecBufferEnqueuer$1 = new AsynchronousMediaCodecBufferEnqueuer$1(this, looper);
            this.handler = asynchronousMediaCodecBufferEnqueuer$1;
            this.started = bl2 = true;
        }
    }

    public void waitUntilQueueingComplete() {
        this.blockUntilHandlerThreadIsIdle();
    }
}

