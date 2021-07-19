/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.decoder;

import com.google.android.exoplayer2.decoder.Buffer;
import com.google.android.exoplayer2.decoder.Decoder;
import com.google.android.exoplayer2.decoder.DecoderException;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.decoder.OutputBuffer;
import com.google.android.exoplayer2.util.Assertions;
import java.util.ArrayDeque;

public abstract class SimpleDecoder
implements Decoder {
    private int availableInputBufferCount;
    private final DecoderInputBuffer[] availableInputBuffers;
    private int availableOutputBufferCount;
    private final OutputBuffer[] availableOutputBuffers;
    private final Thread decodeThread;
    private DecoderInputBuffer dequeuedInputBuffer;
    private DecoderException exception;
    private boolean flushed;
    private final Object lock;
    private final ArrayDeque queuedInputBuffers;
    private final ArrayDeque queuedOutputBuffers;
    private boolean released;
    private int skippedOutputBufferCount;

    public SimpleDecoder(DecoderInputBuffer[] object, OutputBuffer[] outputBufferArray) {
        int n10;
        int n11;
        int n12;
        Object object2;
        this.lock = object2 = new Object();
        object2 = new ArrayDeque();
        this.queuedInputBuffers = object2;
        object2 = new ArrayDeque();
        this.queuedOutputBuffers = object2;
        this.availableInputBuffers = object;
        this.availableInputBufferCount = n12 = ((DecoderInputBuffer[])object).length;
        n12 = 0;
        object = null;
        object2 = null;
        for (int i10 = 0; i10 < (n11 = this.availableInputBufferCount); ++i10) {
            DecoderInputBuffer decoderInputBuffer;
            DecoderInputBuffer[] decoderInputBufferArray = this.availableInputBuffers;
            decoderInputBufferArray[i10] = decoderInputBuffer = this.createInputBuffer();
        }
        this.availableOutputBuffers = outputBufferArray;
        this.availableOutputBufferCount = n10 = outputBufferArray.length;
        while (n12 < (n10 = this.availableOutputBufferCount)) {
            outputBufferArray = this.availableOutputBuffers;
            outputBufferArray[n12] = object2 = this.createOutputBuffer();
            ++n12;
        }
        super(this, "ExoPlayer:SimpleDecoder");
        this.decodeThread = object;
        ((Thread)object).start();
    }

    public static /* synthetic */ void access$000(SimpleDecoder simpleDecoder) {
        simpleDecoder.run();
    }

    private boolean canDecodeBuffer() {
        ArrayDeque arrayDeque = this.queuedInputBuffers;
        boolean bl2 = arrayDeque.isEmpty();
        if (!bl2 && (bl2 = this.availableOutputBufferCount) > false) {
            bl2 = true;
        } else {
            bl2 = false;
            arrayDeque = null;
        }
        return bl2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private boolean decode() {
        int n10;
        boolean bl2;
        Object object;
        Object object2;
        Object object3 = this.lock;
        synchronized (object3) {
            boolean bl3;
            while (!(bl3 = this.released) && !(bl3 = this.canDecodeBuffer())) {
                object2 = this.lock;
                object2.wait();
            }
            bl3 = this.released;
            if (bl3) {
                return false;
            }
            object2 = this.queuedInputBuffers;
            object2 = ((ArrayDeque)object2).removeFirst();
            object2 = (DecoderInputBuffer)object2;
            object = this.availableOutputBuffers;
            bl2 = this.availableOutputBufferCount;
            n10 = 1;
            this.availableOutputBufferCount = bl2 -= n10;
            object = object[bl2];
            bl2 = this.flushed;
            this.flushed = false;
        }
        int n11 = ((Buffer)object2).isEndOfStream();
        if (n11 != 0) {
            n11 = 4;
            ((Buffer)object).addFlag(n11);
        } else {
            n11 = (int)(((Buffer)object2).isDecodeOnly() ? 1 : 0);
            if (n11 != 0) {
                n11 = -1 << -1;
                ((Buffer)object).addFlag(n11);
            }
            try {
                object3 = this.decode((DecoderInputBuffer)object2, (OutputBuffer)object, bl2);
            }
            catch (OutOfMemoryError outOfMemoryError) {
                object3 = this.createUnexpectedDecodeException(outOfMemoryError);
            }
            catch (RuntimeException runtimeException) {
                object3 = this.createUnexpectedDecodeException(runtimeException);
            }
            if (object3 != null) {
                Object object4 = this.lock;
                synchronized (object4) {
                    this.exception = object3;
                    return false;
                }
            }
        }
        Object object5 = this.lock;
        synchronized (object5) {
            n11 = (int)(this.flushed ? 1 : 0);
            if (n11 != 0) {
                ((OutputBuffer)object).release();
            } else {
                n11 = (int)(((Buffer)object).isDecodeOnly() ? 1 : 0);
                if (n11 != 0) {
                    this.skippedOutputBufferCount = n11 = this.skippedOutputBufferCount + n10;
                    ((OutputBuffer)object).release();
                } else {
                    ((OutputBuffer)object).skippedOutputBufferCount = n11 = this.skippedOutputBufferCount;
                    this.skippedOutputBufferCount = 0;
                    object3 = this.queuedOutputBuffers;
                    ((ArrayDeque)object3).addLast(object);
                }
            }
            this.releaseInputBufferInternal((DecoderInputBuffer)object2);
            return n10 != 0;
        }
    }

    private void maybeNotifyDecodeLoop() {
        boolean bl2 = this.canDecodeBuffer();
        if (bl2) {
            Object object = this.lock;
            object.notify();
        }
    }

    private void maybeThrowException() {
        DecoderException decoderException = this.exception;
        if (decoderException == null) {
            return;
        }
        throw decoderException;
    }

    private void releaseInputBufferInternal(DecoderInputBuffer decoderInputBuffer) {
        int n10;
        decoderInputBuffer.clear();
        DecoderInputBuffer[] decoderInputBufferArray = this.availableInputBuffers;
        int n11 = this.availableInputBufferCount;
        this.availableInputBufferCount = n10 = n11 + 1;
        decoderInputBufferArray[n11] = decoderInputBuffer;
    }

    private void releaseOutputBufferInternal(OutputBuffer outputBuffer) {
        int n10;
        outputBuffer.clear();
        OutputBuffer[] outputBufferArray = this.availableOutputBuffers;
        int n11 = this.availableOutputBufferCount;
        this.availableOutputBufferCount = n10 = n11 + 1;
        outputBufferArray[n11] = outputBuffer;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void run() {
        try {
            boolean bl2;
            while (bl2 = this.decode()) {
            }
            return;
        }
        catch (InterruptedException interruptedException) {
            IllegalStateException illegalStateException = new IllegalStateException(interruptedException);
            throw illegalStateException;
        }
    }

    public abstract DecoderInputBuffer createInputBuffer();

    public abstract OutputBuffer createOutputBuffer();

    public abstract DecoderException createUnexpectedDecodeException(Throwable var1);

    public abstract DecoderException decode(DecoderInputBuffer var1, OutputBuffer var2, boolean var3);

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final DecoderInputBuffer dequeueInputBuffer() {
        Object object = this.lock;
        synchronized (object) {
            int n10;
            this.maybeThrowException();
            DecoderInputBuffer decoderInputBuffer = this.dequeuedInputBuffer;
            int n11 = 1;
            if (decoderInputBuffer == null) {
                n10 = n11;
            } else {
                n10 = 0;
                decoderInputBuffer = null;
            }
            Assertions.checkState(n10 != 0);
            n10 = this.availableInputBufferCount;
            if (n10 == 0) {
                n10 = 0;
                decoderInputBuffer = null;
            } else {
                DecoderInputBuffer[] decoderInputBufferArray = this.availableInputBuffers;
                this.availableInputBufferCount = n10 -= n11;
                decoderInputBuffer = decoderInputBufferArray[n10];
            }
            this.dequeuedInputBuffer = decoderInputBuffer;
            return decoderInputBuffer;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final OutputBuffer dequeueOutputBuffer() {
        Object object = this.lock;
        synchronized (object) {
            this.maybeThrowException();
            Object object2 = this.queuedOutputBuffers;
            boolean bl2 = ((ArrayDeque)object2).isEmpty();
            if (bl2) {
                return null;
            }
            object2 = this.queuedOutputBuffers;
            object2 = ((ArrayDeque)object2).removeFirst();
            return (OutputBuffer)object2;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void flush() {
        Object object = this.lock;
        synchronized (object) {
            boolean bl2;
            this.flushed = bl2 = true;
            bl2 = false;
            Object object2 = null;
            this.skippedOutputBufferCount = 0;
            object2 = this.dequeuedInputBuffer;
            if (object2 != null) {
                this.releaseInputBufferInternal((DecoderInputBuffer)object2);
                bl2 = false;
                object2 = null;
                this.dequeuedInputBuffer = null;
            }
            while (!(bl2 = ((ArrayDeque)(object2 = this.queuedInputBuffers)).isEmpty())) {
                object2 = this.queuedInputBuffers;
                object2 = ((ArrayDeque)object2).removeFirst();
                object2 = (DecoderInputBuffer)object2;
                this.releaseInputBufferInternal((DecoderInputBuffer)object2);
            }
            while (!(bl2 = ((ArrayDeque)(object2 = this.queuedOutputBuffers)).isEmpty())) {
                object2 = this.queuedOutputBuffers;
                object2 = ((ArrayDeque)object2).removeFirst();
                object2 = (OutputBuffer)object2;
                ((OutputBuffer)object2).release();
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void queueInputBuffer(DecoderInputBuffer decoderInputBuffer) {
        Object object = this.lock;
        synchronized (object) {
            boolean bl2;
            this.maybeThrowException();
            Object object2 = this.dequeuedInputBuffer;
            if (decoderInputBuffer == object2) {
                bl2 = true;
            } else {
                bl2 = false;
                object2 = null;
            }
            Assertions.checkArgument(bl2);
            object2 = this.queuedInputBuffers;
            ((ArrayDeque)object2).addLast(decoderInputBuffer);
            this.maybeNotifyDecodeLoop();
            decoderInputBuffer = null;
            this.dequeuedInputBuffer = null;
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void release() {
        Object object = this.lock;
        synchronized (object) {
            boolean bl2;
            this.released = bl2 = true;
            Object object2 = this.lock;
            object2.notify();
        }
        try {
            object = this.decodeThread;
            ((Thread)object).join();
            return;
        }
        catch (InterruptedException interruptedException) {
            object = Thread.currentThread();
            ((Thread)object).interrupt();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void releaseOutputBuffer(OutputBuffer outputBuffer) {
        Object object = this.lock;
        synchronized (object) {
            this.releaseOutputBufferInternal(outputBuffer);
            this.maybeNotifyDecodeLoop();
            return;
        }
    }

    public final void setInitialInputBufferSize(int n10) {
        DecoderInputBuffer[] decoderInputBufferArray;
        int n11 = this.availableInputBufferCount;
        DecoderInputBuffer[] decoderInputBufferArray2 = this.availableInputBuffers;
        int n12 = decoderInputBufferArray2.length;
        int n13 = 0;
        if (n11 == n12) {
            n11 = 1;
        } else {
            n11 = 0;
            decoderInputBufferArray = null;
        }
        Assertions.checkState(n11 != 0);
        decoderInputBufferArray = this.availableInputBuffers;
        n12 = decoderInputBufferArray.length;
        while (n13 < n12) {
            DecoderInputBuffer decoderInputBuffer = decoderInputBufferArray[n13];
            decoderInputBuffer.ensureSpaceForWrite(n10);
            ++n13;
        }
    }
}

