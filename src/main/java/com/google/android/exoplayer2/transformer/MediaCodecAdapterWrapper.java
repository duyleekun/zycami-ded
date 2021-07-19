/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.media.MediaCodec
 *  android.media.MediaCodec$BufferInfo
 *  android.media.MediaFormat
 */
package com.google.android.exoplayer2.transformer;

import android.media.MediaCodec;
import android.media.MediaFormat;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.Format$Builder;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.mediacodec.MediaCodecAdapter;
import com.google.android.exoplayer2.mediacodec.MediaFormatUtil;
import com.google.android.exoplayer2.mediacodec.SynchronousMediaCodecAdapter$Factory;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.common.collect.ImmutableList$Builder;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.util.List;

public final class MediaCodecAdapterWrapper {
    private static final int MEDIA_CODEC_PCM_ENCODING = 2;
    private final MediaCodecAdapter codec;
    private int inputBufferIndex;
    private boolean inputStreamEnded;
    private ByteBuffer outputBuffer;
    private int outputBufferIndex;
    private final MediaCodec.BufferInfo outputBufferInfo;
    private Format outputFormat;
    private boolean outputStreamEnded;

    private MediaCodecAdapterWrapper(MediaCodecAdapter mediaCodecAdapter) {
        int n10;
        this.codec = mediaCodecAdapter;
        this.outputBufferInfo = mediaCodecAdapter;
        this.inputBufferIndex = n10 = -1;
        this.outputBufferIndex = n10;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static MediaCodecAdapterWrapper createForAudioDecoding(Format object) {
        Object object2;
        Object object3;
        block7: {
            String string2;
            object3 = null;
            try {
                object2 = ((Format)object).sampleMimeType;
                object2 = Assertions.checkNotNull(object2);
                object2 = (String)object2;
                object2 = MediaCodec.createDecoderByType((String)object2);
            }
            catch (Exception exception) {
                object2 = null;
                object3 = exception;
                object = null;
                break block7;
            }
            try {
                string2 = ((Format)object).sampleMimeType;
                int n10 = ((Format)object).sampleRate;
                int n11 = ((Format)object).channelCount;
                string2 = MediaFormat.createAudioFormat((String)string2, (int)n10, (int)n11);
                String string3 = "max-input-size";
                n11 = ((Format)object).maxInputSize;
                MediaFormatUtil.maybeSetInteger((MediaFormat)string2, string3, n11);
                object = ((Format)object).initializationData;
                MediaFormatUtil.setCsdBuffers((MediaFormat)string2, (List)object);
                object = new SynchronousMediaCodecAdapter$Factory();
                object = ((SynchronousMediaCodecAdapter$Factory)object).createAdapter((MediaCodec)object2);
                n10 = 0;
                string3 = null;
            }
            catch (Exception exception) {
                object = null;
                break block7;
            }
            try {
                object.configure((MediaFormat)string2, null, null, 0);
                object.start();
                return new MediaCodecAdapterWrapper((MediaCodecAdapter)object);
            }
            catch (Exception exception) {}
        }
        if (object == null) {
            if (object2 == null) throw object3;
            object2.release();
            throw object3;
        }
        object.release();
        throw object3;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static MediaCodecAdapterWrapper createForAudioEncoding(Format object) {
        Object object2;
        Object object3;
        block7: {
            int n10;
            String string2;
            object3 = null;
            try {
                object2 = ((Format)object).sampleMimeType;
                object2 = Assertions.checkNotNull(object2);
                object2 = (String)object2;
                object2 = MediaCodec.createEncoderByType((String)object2);
            }
            catch (Exception exception) {
                object2 = null;
                object3 = exception;
                boolean bl2 = false;
                object = null;
                break block7;
            }
            try {
                string2 = ((Format)object).sampleMimeType;
                n10 = ((Format)object).sampleRate;
                int n11 = ((Format)object).channelCount;
                string2 = MediaFormat.createAudioFormat((String)string2, (int)n10, (int)n11);
                String string3 = "bitrate";
                int n12 = ((Format)object).bitrate;
                string2.setInteger(string3, n12);
                object = new SynchronousMediaCodecAdapter$Factory();
                object = ((SynchronousMediaCodecAdapter$Factory)object).createAdapter((MediaCodec)object2);
                n10 = 1;
            }
            catch (Exception exception) {
                boolean bl2 = false;
                object = null;
                break block7;
            }
            try {
                object.configure((MediaFormat)string2, null, null, n10);
                object.start();
                return new MediaCodecAdapterWrapper((MediaCodecAdapter)object);
            }
            catch (Exception exception) {}
        }
        if (object == null) {
            if (object2 == null) throw object3;
            object2.release();
            throw object3;
        }
        object.release();
        throw object3;
    }

    private static Format getFormat(MediaFormat object) {
        Object object2 = new ImmutableList$Builder();
        int n10 = 0;
        Object object3 = null;
        while (true) {
            int n11 = 15;
            Object object4 = new StringBuilder(n11);
            ((StringBuilder)object4).append("csd-");
            ((StringBuilder)object4).append(n10);
            Object object5 = ((StringBuilder)object4).toString();
            object5 = object.getByteBuffer((String)object5);
            if (object5 == null) {
                object3 = "mime";
                object5 = object.getString((String)object3);
                object4 = new Format$Builder();
                object3 = object.getString((String)object3);
                object3 = ((Format$Builder)object4).setSampleMimeType((String)object3);
                object2 = ((ImmutableList$Builder)object2).build();
                object2 = ((Format$Builder)object3).setInitializationData((List)object2);
                n10 = (int)(MimeTypes.isVideo((String)object5) ? 1 : 0);
                if (n10 != 0) {
                    n10 = object.getInteger("width");
                    object3 = ((Format$Builder)object2).setWidth(n10);
                    object5 = "height";
                    int n12 = object.getInteger((String)object5);
                    ((Format$Builder)object3).setHeight(n12);
                } else {
                    n10 = (int)(MimeTypes.isAudio((String)object5) ? 1 : 0);
                    if (n10 != 0) {
                        n10 = object.getInteger("channel-count");
                        object3 = ((Format$Builder)object2).setChannelCount(n10);
                        object5 = "sample-rate";
                        int n13 = object.getInteger((String)object5);
                        object = ((Format$Builder)object3).setSampleRate(n13);
                        n10 = 2;
                        ((Format$Builder)object).setPcmEncoding(n10);
                    }
                }
                return ((Format$Builder)object2).build();
            }
            int n14 = ((Buffer)object5).remaining();
            object4 = new byte[n14];
            ((ByteBuffer)object5).get((byte[])object4);
            ((ImmutableList$Builder)object2).add(object4);
            ++n10;
        }
    }

    private boolean maybeDequeueOutputBuffer() {
        int n10;
        int n11;
        int bl2 = this.outputBufferIndex;
        boolean bl3 = true;
        if (bl2 >= 0) {
            return bl3;
        }
        boolean bl4 = this.outputStreamEnded;
        int n12 = 0;
        MediaCodec.BufferInfo bufferInfo = null;
        if (bl4) {
            return false;
        }
        Object object = this.codec;
        MediaCodec.BufferInfo bufferInfo2 = this.outputBufferInfo;
        this.outputBufferIndex = n11 = object.dequeueOutputBufferIndex(bufferInfo2);
        if (n11 < 0) {
            int n13 = -2;
            if (n11 == n13) {
                this.outputFormat = object = MediaCodecAdapterWrapper.getFormat(this.codec.getOutputFormat());
            }
            return false;
        }
        bufferInfo2 = this.outputBufferInfo;
        int n14 = bufferInfo2.flags;
        int n15 = n14 & 4;
        if (n15 != 0) {
            this.outputStreamEnded = bl3;
            n10 = bufferInfo2.size;
            if (n10 == 0) {
                this.releaseOutputBuffer();
                return false;
            }
        }
        if ((n10 = n14 & 2) != 0) {
            this.releaseOutputBuffer();
            return false;
        }
        this.outputBuffer = object = (ByteBuffer)Assertions.checkNotNull(this.codec.getOutputBuffer(n11));
        n12 = this.outputBufferInfo.offset;
        ((ByteBuffer)object).position(n12);
        object = this.outputBuffer;
        bufferInfo = this.outputBufferInfo;
        n10 = bufferInfo.offset;
        n12 = bufferInfo.size;
        ((ByteBuffer)object).limit(n10 += n12);
        return bl3;
    }

    public ByteBuffer getOutputBuffer() {
        ByteBuffer byteBuffer;
        boolean bl2 = this.maybeDequeueOutputBuffer();
        if (bl2) {
            byteBuffer = this.outputBuffer;
        } else {
            bl2 = false;
            byteBuffer = null;
        }
        return byteBuffer;
    }

    public MediaCodec.BufferInfo getOutputBufferInfo() {
        MediaCodec.BufferInfo bufferInfo;
        boolean bl2 = this.maybeDequeueOutputBuffer();
        if (bl2) {
            bufferInfo = this.outputBufferInfo;
        } else {
            bl2 = false;
            bufferInfo = null;
        }
        return bufferInfo;
    }

    public Format getOutputFormat() {
        this.maybeDequeueOutputBuffer();
        return this.outputFormat;
    }

    public boolean isEnded() {
        int n10;
        int n11 = this.outputStreamEnded;
        n11 = n11 != 0 && (n11 = this.outputBufferIndex) == (n10 = -1) ? 1 : 0;
        return n11 != 0;
    }

    public boolean maybeDequeueInputBuffer(DecoderInputBuffer decoderInputBuffer) {
        int n10 = this.inputStreamEnded;
        MediaCodecAdapter mediaCodecAdapter = null;
        if (n10 != 0) {
            return false;
        }
        n10 = this.inputBufferIndex;
        if (n10 < 0) {
            Object object = this.codec;
            this.inputBufferIndex = n10 = object.dequeueInputBufferIndex();
            if (n10 < 0) {
                return false;
            }
            mediaCodecAdapter = this.codec;
            decoderInputBuffer.data = object = mediaCodecAdapter.getInputBuffer(n10);
            decoderInputBuffer.clear();
        }
        Assertions.checkNotNull(decoderInputBuffer.data);
        return true;
    }

    public void queueInputBuffer(DecoderInputBuffer decoderInputBuffer) {
        int n10;
        int n11;
        int n12 = this.inputStreamEnded;
        int n13 = 1;
        Assertions.checkState((n12 ^= n13) != 0, "Input buffer can not be queued after the input stream has ended.");
        ByteBuffer byteBuffer = decoderInputBuffer.data;
        int n14 = 0;
        if (byteBuffer != null && (n12 = byteBuffer.hasRemaining()) != 0) {
            byteBuffer = decoderInputBuffer.data;
            n12 = byteBuffer.position();
            ByteBuffer byteBuffer2 = decoderInputBuffer.data;
            int n15 = byteBuffer2.remaining();
            n11 = n12;
            n10 = n15;
        } else {
            n11 = 0;
            n10 = 0;
        }
        n12 = decoderInputBuffer.isEndOfStream();
        if (n12 != 0) {
            this.inputStreamEnded = n13;
            n14 = 4;
        }
        MediaCodecAdapter mediaCodecAdapter = this.codec;
        int n16 = this.inputBufferIndex;
        long l10 = decoderInputBuffer.timeUs;
        mediaCodecAdapter.queueInputBuffer(n16, n11, n10, l10, n14);
        this.inputBufferIndex = -1;
        decoderInputBuffer.data = null;
    }

    public void release() {
        this.outputBuffer = null;
        this.codec.release();
    }

    public void releaseOutputBuffer() {
        this.outputBuffer = null;
        MediaCodecAdapter mediaCodecAdapter = this.codec;
        int n10 = this.outputBufferIndex;
        mediaCodecAdapter.releaseOutputBuffer(n10, false);
        this.outputBufferIndex = -1;
    }
}

