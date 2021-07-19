/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.media.MediaCodec
 *  android.media.MediaCodec$BufferInfo
 *  android.media.MediaCodec$CodecException
 *  android.media.MediaCodec$CryptoException
 *  android.media.MediaCrypto
 *  android.media.MediaCryptoException
 *  android.media.MediaFormat
 *  android.os.Bundle
 *  android.os.SystemClock
 */
package com.google.android.exoplayer2.mediacodec;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaCryptoException;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.SystemClock;
import com.google.android.exoplayer2.BaseRenderer;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.decoder.Buffer;
import com.google.android.exoplayer2.decoder.DecoderCounters;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.decoder.DecoderReuseEvaluation;
import com.google.android.exoplayer2.drm.DrmSession;
import com.google.android.exoplayer2.drm.FrameworkMediaCrypto;
import com.google.android.exoplayer2.mediacodec.AsynchronousMediaCodecAdapter$Factory;
import com.google.android.exoplayer2.mediacodec.BatchBuffer;
import com.google.android.exoplayer2.mediacodec.C2Mp3TimestampTracker;
import com.google.android.exoplayer2.mediacodec.MediaCodecAdapter;
import com.google.android.exoplayer2.mediacodec.MediaCodecAdapter$Factory;
import com.google.android.exoplayer2.mediacodec.MediaCodecDecoderException;
import com.google.android.exoplayer2.mediacodec.MediaCodecInfo;
import com.google.android.exoplayer2.mediacodec.MediaCodecRenderer$DecoderInitializationException;
import com.google.android.exoplayer2.mediacodec.MediaCodecSelector;
import com.google.android.exoplayer2.mediacodec.MediaCodecUtil$DecoderQueryException;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.NalUnitUtil;
import com.google.android.exoplayer2.util.TimedValueQueue;
import com.google.android.exoplayer2.util.TraceUtil;
import com.google.android.exoplayer2.util.Util;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public abstract class MediaCodecRenderer
extends BaseRenderer {
    private static final byte[] ADAPTATION_WORKAROUND_BUFFER;
    private static final int ADAPTATION_WORKAROUND_MODE_ALWAYS = 2;
    private static final int ADAPTATION_WORKAROUND_MODE_NEVER = 0;
    private static final int ADAPTATION_WORKAROUND_MODE_SAME_RESOLUTION = 1;
    private static final int ADAPTATION_WORKAROUND_SLICE_WIDTH_HEIGHT = 32;
    public static final float CODEC_OPERATING_RATE_UNSET = -1.0f;
    private static final int DRAIN_ACTION_FLUSH = 1;
    private static final int DRAIN_ACTION_FLUSH_AND_UPDATE_DRM_SESSION = 2;
    private static final int DRAIN_ACTION_NONE = 0;
    private static final int DRAIN_ACTION_REINITIALIZE = 3;
    private static final int DRAIN_STATE_NONE = 0;
    private static final int DRAIN_STATE_SIGNAL_END_OF_STREAM = 1;
    private static final int DRAIN_STATE_WAIT_END_OF_STREAM = 2;
    private static final long MAX_CODEC_HOTSWAP_TIME_MS = 1000L;
    private static final int MAX_PENDING_OUTPUT_STREAM_OFFSET_COUNT = 10;
    private static final int RECONFIGURATION_STATE_NONE = 0;
    private static final int RECONFIGURATION_STATE_QUEUE_PENDING = 2;
    private static final int RECONFIGURATION_STATE_WRITE_PENDING = 1;
    private static final String TAG = "MediaCodecRenderer";
    private final float assumedMinimumCodecOperatingRate;
    private ArrayDeque availableCodecInfos;
    private final DecoderInputBuffer buffer;
    private final BatchBuffer bypassBatchBuffer;
    private boolean bypassDrainAndReinitialize;
    private boolean bypassEnabled;
    private final DecoderInputBuffer bypassSampleBuffer;
    private boolean bypassSampleBufferPending;
    private C2Mp3TimestampTracker c2Mp3TimestampTracker;
    private MediaCodecAdapter codec;
    private int codecAdaptationWorkaroundMode;
    private final MediaCodecAdapter$Factory codecAdapterFactory;
    private int codecDrainAction;
    private int codecDrainState;
    private DrmSession codecDrmSession;
    private boolean codecHasOutputMediaFormat;
    private long codecHotswapDeadlineMs;
    private MediaCodecInfo codecInfo;
    private Format codecInputFormat;
    private boolean codecNeedsAdaptationWorkaroundBuffer;
    private boolean codecNeedsDiscardToSpsWorkaround;
    private boolean codecNeedsEosBufferTimestampWorkaround;
    private boolean codecNeedsEosFlushWorkaround;
    private boolean codecNeedsEosOutputExceptionWorkaround;
    private boolean codecNeedsEosPropagation;
    private boolean codecNeedsFlushWorkaround;
    private boolean codecNeedsMonoChannelCountWorkaround;
    private boolean codecNeedsSosFlushWorkaround;
    private float codecOperatingRate;
    private MediaFormat codecOutputMediaFormat;
    private boolean codecOutputMediaFormatChanged;
    private boolean codecReceivedBuffers;
    private boolean codecReceivedEos;
    private int codecReconfigurationState;
    private boolean codecReconfigured;
    private float currentPlaybackSpeed;
    private final ArrayList decodeOnlyPresentationTimestamps;
    public DecoderCounters decoderCounters;
    private boolean enableAsynchronousBufferQueueing;
    private final boolean enableDecoderFallback;
    private boolean enableSynchronizeCodecInteractionsWithQueueing;
    private final DecoderInputBuffer flagsOnlyBuffer;
    private boolean forceAsyncQueueingSynchronizationWorkaround;
    private final TimedValueQueue formatQueue;
    private Format inputFormat;
    private int inputIndex;
    private boolean inputStreamEnded;
    private boolean isDecodeOnlyOutputBuffer;
    private boolean isLastOutputBuffer;
    private long largestQueuedPresentationTimeUs;
    private long lastBufferInStreamPresentationTimeUs;
    private final MediaCodecSelector mediaCodecSelector;
    private MediaCrypto mediaCrypto;
    private boolean mediaCryptoRequiresSecureDecoder;
    private ByteBuffer outputBuffer;
    private final MediaCodec.BufferInfo outputBufferInfo;
    private Format outputFormat;
    private int outputIndex;
    private boolean outputStreamEnded;
    private long outputStreamOffsetUs;
    private long outputStreamStartPositionUs;
    private boolean pendingOutputEndOfStream;
    private int pendingOutputStreamOffsetCount;
    private final long[] pendingOutputStreamOffsetsUs;
    private final long[] pendingOutputStreamStartPositionsUs;
    private final long[] pendingOutputStreamSwitchTimesUs;
    private ExoPlaybackException pendingPlaybackException;
    private MediaCodecRenderer$DecoderInitializationException preferredDecoderInitializationException;
    private long renderTimeLimitMs;
    private boolean shouldSkipAdaptationWorkaroundOutputBuffer;
    private DrmSession sourceDrmSession;
    private float targetPlaybackSpeed;
    private boolean waitingForFirstSampleInFormat;

    static {
        byte[] byArray;
        byte[] byArray2 = byArray = new byte[38];
        byte[] byArray3 = byArray;
        byArray2[0] = 0;
        byArray3[1] = 0;
        byArray2[2] = 1;
        byArray3[3] = 103;
        byArray2[4] = 66;
        byArray3[5] = -64;
        byArray2[6] = 11;
        byArray3[7] = -38;
        byArray2[8] = 37;
        byArray3[9] = -112;
        byArray2[10] = 0;
        byArray3[11] = 0;
        byArray2[12] = 1;
        byArray3[13] = 104;
        byArray2[14] = -50;
        byArray3[15] = 15;
        byArray2[16] = 19;
        byArray3[17] = 32;
        byArray2[18] = 0;
        byArray3[19] = 0;
        byArray2[20] = 1;
        byArray3[21] = 101;
        byArray2[22] = -120;
        byArray3[23] = -124;
        byArray2[24] = 13;
        byArray3[25] = -50;
        byArray2[26] = 113;
        byArray3[27] = 24;
        byArray2[28] = -96;
        byArray3[29] = 0;
        byArray2[30] = 47;
        byArray3[31] = -65;
        byArray2[32] = 28;
        byArray3[33] = 49;
        byArray2[34] = -61;
        byArray3[35] = 39;
        byArray2[36] = 93;
        byArray3[37] = 120;
        ADAPTATION_WORKAROUND_BUFFER = byArray;
    }

    public MediaCodecRenderer(int n10, MediaCodecAdapter$Factory object, MediaCodecSelector bufferInfo, boolean bl2, float f10) {
        super(n10);
        long l10;
        float f11;
        this.codecAdapterFactory = object;
        Object object2 = (MediaCodecSelector)Assertions.checkNotNull(bufferInfo);
        this.mediaCodecSelector = object2;
        this.enableDecoderFallback = bl2;
        this.assumedMinimumCodecOperatingRate = f10;
        this.flagsOnlyBuffer = object2 = DecoderInputBuffer.newFlagsOnlyInstance();
        this.buffer = object2 = new DecoderInputBuffer(0);
        this.bypassSampleBuffer = object2 = new DecoderInputBuffer(2);
        this.bypassBatchBuffer = object2 = new BatchBuffer();
        bufferInfo = new TimedValueQueue();
        this.formatQueue = bufferInfo;
        this.decodeOnlyPresentationTimestamps = bufferInfo = new ArrayList();
        this.outputBufferInfo = bufferInfo = new MediaCodec.BufferInfo();
        this.currentPlaybackSpeed = f11 = 1.0f;
        this.targetPlaybackSpeed = f11;
        this.renderTimeLimitMs = l10 = -9223372036854775807L;
        int n11 = 10;
        long[] lArray = new long[n11];
        this.pendingOutputStreamStartPositionsUs = lArray;
        lArray = new long[n11];
        this.pendingOutputStreamOffsetsUs = lArray;
        long[] lArray2 = new long[n11];
        this.pendingOutputStreamSwitchTimesUs = lArray2;
        this.outputStreamStartPositionUs = l10;
        this.outputStreamOffsetUs = l10;
        ((DecoderInputBuffer)object2).ensureSpaceForWrite(0);
        object2 = ((DecoderInputBuffer)object2).data;
        object = ByteOrder.nativeOrder();
        ((ByteBuffer)object2).order((ByteOrder)object);
        this.resetCodecStateForRelease();
    }

    private void bypassRead() {
        Object object;
        block5: {
            DecoderInputBuffer decoderInputBuffer;
            int n10;
            int n11 = this.inputStreamEnded;
            int n12 = 1;
            Assertions.checkState((n11 ^= n12) != 0);
            object = this.getFormatHolder();
            Object object2 = this.bypassSampleBuffer;
            ((DecoderInputBuffer)object2).clear();
            do {
                this.bypassSampleBuffer.clear();
                object2 = this.bypassSampleBuffer;
                decoderInputBuffer = null;
                n10 = this.readSource((FormatHolder)object, (DecoderInputBuffer)object2, false);
                int n13 = -5;
                if (n10 == n13) break block5;
                n13 = -4;
                if (n10 != n13) {
                    n11 = -3;
                    if (n10 == n11) {
                        return;
                    }
                    object = new IllegalStateException();
                    throw object;
                }
                object2 = this.bypassSampleBuffer;
                n10 = (int)(((Buffer)object2).isEndOfStream() ? 1 : 0);
                if (n10 != 0) {
                    this.inputStreamEnded = n12;
                    return;
                }
                n10 = (int)(this.waitingForFirstSampleInFormat ? 1 : 0);
                if (n10 != 0) {
                    this.outputFormat = object2 = (Format)Assertions.checkNotNull(this.inputFormat);
                    n13 = 0;
                    this.onOutputFormatChanged((Format)object2, null);
                    this.waitingForFirstSampleInFormat = false;
                }
                this.bypassSampleBuffer.flip();
            } while ((n10 = (int)(((BatchBuffer)(object2 = this.bypassBatchBuffer)).append(decoderInputBuffer = this.bypassSampleBuffer) ? 1 : 0)) != 0);
            this.bypassSampleBufferPending = n12;
            return;
        }
        this.onInputFormatChanged((FormatHolder)object);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private boolean bypassRender(long l10, long l11) {
        BatchBuffer batchBuffer;
        Object object;
        MediaCodecRenderer mediaCodecRenderer = this;
        boolean bl2 = this.outputStreamEnded;
        boolean bl3 = true;
        Assertions.checkState(bl2 ^ bl3);
        Object object2 = this.bypassBatchBuffer;
        bl2 = ((BatchBuffer)object2).hasSamples();
        if (bl2) {
            object2 = this.bypassBatchBuffer;
            ByteBuffer byteBuffer = ((DecoderInputBuffer)object2).data;
            int n10 = this.outputIndex;
            int n11 = ((BatchBuffer)object2).getSampleCount();
            long l12 = this.bypassBatchBuffer.getFirstSampleTimeUs();
            boolean bl4 = this.bypassBatchBuffer.isDecodeOnly();
            boolean bl5 = this.bypassBatchBuffer.isEndOfStream();
            object = this.outputFormat;
            object2 = this;
            bl2 = this.processOutputBuffer(l10, l11, null, byteBuffer, n10, 0, n11, l12, bl4, bl5, (Format)object);
            if (!bl2) return false;
            long l13 = this.bypassBatchBuffer.getLastSampleTimeUs();
            this.onProcessedOutputBuffer(l13);
            this.bypassBatchBuffer.clear();
            bl2 = false;
            object2 = null;
        } else {
            bl2 = false;
            object2 = null;
        }
        boolean bl6 = mediaCodecRenderer.inputStreamEnded;
        if (bl6) {
            mediaCodecRenderer.outputStreamEnded = true;
            return false;
        }
        bl6 = true;
        boolean bl7 = mediaCodecRenderer.bypassSampleBufferPending;
        if (bl7) {
            batchBuffer = mediaCodecRenderer.bypassBatchBuffer;
            object = mediaCodecRenderer.bypassSampleBuffer;
            bl7 = batchBuffer.append((DecoderInputBuffer)object);
            Assertions.checkState(bl7);
            mediaCodecRenderer.bypassSampleBufferPending = false;
        }
        if (bl7 = mediaCodecRenderer.bypassDrainAndReinitialize) {
            batchBuffer = mediaCodecRenderer.bypassBatchBuffer;
            bl7 = batchBuffer.hasSamples();
            if (bl7) {
                return bl6;
            }
            this.disableBypass();
            mediaCodecRenderer.bypassDrainAndReinitialize = false;
            this.maybeInitCodecOrBypass();
            bl7 = mediaCodecRenderer.bypassEnabled;
            if (!bl7) {
                return false;
            }
        }
        this.bypassRead();
        batchBuffer = mediaCodecRenderer.bypassBatchBuffer;
        bl7 = batchBuffer.hasSamples();
        if (bl7) {
            batchBuffer = mediaCodecRenderer.bypassBatchBuffer;
            batchBuffer.flip();
        }
        if (bl7 = (batchBuffer = mediaCodecRenderer.bypassBatchBuffer).hasSamples()) return bl6;
        bl7 = mediaCodecRenderer.inputStreamEnded;
        if (bl7) return bl6;
        bl7 = mediaCodecRenderer.bypassDrainAndReinitialize;
        if (!bl7) return false;
        return bl6;
    }

    private int codecAdaptationWorkaroundMode(String string2) {
        boolean bl2;
        String string3;
        String string4;
        boolean bl3;
        String string5;
        int n10 = Util.SDK_INT;
        int n11 = 25;
        if (n10 <= n11 && (n11 = (int)((string5 = "OMX.Exynos.avc.dec.secure").equals(string2) ? 1 : 0)) != 0 && ((bl3 = (string5 = Util.MODEL).startsWith(string4 = "SM-T585")) || (bl3 = string5.startsWith(string4 = "SM-A510")) || (bl3 = string5.startsWith(string4 = "SM-A520")) || (n11 = (int)(string5.startsWith(string4 = "SM-J700") ? 1 : 0)) != 0)) {
            return 2;
        }
        n11 = 24;
        if (n10 < n11 && ((n10 = (int)((string3 = "OMX.Nvidia.h264.decode").equals(string2) ? 1 : 0)) != 0 || (bl2 = (string3 = "OMX.Nvidia.h264.decode.secure").equals(string2))) && ((n10 = (int)((string3 = "flounder").equals(string2 = Util.DEVICE) ? 1 : 0)) != 0 || (n10 = (int)((string3 = "flounder_lte").equals(string2) ? 1 : 0)) != 0 || (n10 = (int)((string3 = "grouper").equals(string2) ? 1 : 0)) != 0 || (bl2 = (string3 = "tilapia").equals(string2)))) {
            return 1;
        }
        return 0;
    }

    private static boolean codecNeedsDiscardToSpsWorkaround(String string2, Format object) {
        boolean bl2;
        boolean bl3;
        int n10 = Util.SDK_INT;
        int n11 = 21;
        if (n10 < n11 && (bl3 = (object = ((Format)object).initializationData).isEmpty()) && (bl2 = ((String)(object = "OMX.MTK.VIDEO.DECODER.AVC")).equals(string2))) {
            bl2 = true;
        } else {
            bl2 = false;
            string2 = null;
        }
        return bl2;
    }

    private static boolean codecNeedsEosBufferTimestampWorkaround(String string2) {
        String string3;
        boolean bl2;
        int n10 = Util.SDK_INT;
        int n11 = 21;
        if (n10 < n11 && (bl2 = (string3 = "OMX.SEC.mp3.dec").equals(string2)) && (bl2 = (string3 = "samsung").equals(string2 = Util.MANUFACTURER)) && ((n10 = (int)((string2 = Util.DEVICE).startsWith(string3 = "baffin") ? 1 : 0)) != 0 || (n10 = (int)(string2.startsWith(string3 = "grand") ? 1 : 0)) != 0 || (n10 = (int)(string2.startsWith(string3 = "fortuna") ? 1 : 0)) != 0 || (n10 = (int)(string2.startsWith(string3 = "gprimelte") ? 1 : 0)) != 0 || (n10 = (int)(string2.startsWith(string3 = "j2y18lte") ? 1 : 0)) != 0 || (bl2 = string2.startsWith(string3 = "ms01")))) {
            bl2 = true;
        } else {
            bl2 = false;
            string2 = null;
        }
        return bl2;
    }

    private static boolean codecNeedsEosFlushWorkaround(String string2) {
        boolean bl2;
        String string3;
        String string4;
        int n10 = Util.SDK_INT;
        int n11 = 23;
        if (n10 <= n11 && (n11 = (int)((string4 = "OMX.google.vorbis.decoder").equals(string2) ? 1 : 0)) != 0 || n10 <= (n11 = 19) && ((n11 = (int)((string4 = "hb2000").equals(string3 = Util.DEVICE) ? 1 : 0)) != 0 || (n10 = (int)((string4 = "stvm8").equals(string3) ? 1 : 0)) != 0) && ((n10 = (int)((string3 = "OMX.amlogic.avc.decoder.awesome").equals(string2) ? 1 : 0)) != 0 || (bl2 = (string3 = "OMX.amlogic.avc.decoder.awesome.secure").equals(string2)))) {
            bl2 = true;
        } else {
            bl2 = false;
            string2 = null;
        }
        return bl2;
    }

    private static boolean codecNeedsEosOutputExceptionWorkaround(String string2) {
        String string3;
        boolean bl2;
        int n10 = Util.SDK_INT;
        int n11 = 21;
        if (n10 == n11 && (bl2 = (string3 = "OMX.google.aac.decoder").equals(string2))) {
            bl2 = true;
        } else {
            bl2 = false;
            string2 = null;
        }
        return bl2;
    }

    private static boolean codecNeedsEosPropagationWorkaround(MediaCodecInfo mediaCodecInfo) {
        boolean bl2;
        boolean bl3;
        String string2;
        String string3;
        String string4 = mediaCodecInfo.name;
        int n10 = Util.SDK_INT;
        int n11 = 25;
        if (n10 <= n11 && (n11 = (int)((string3 = "OMX.rk.video_decoder.avc").equals(string4) ? 1 : 0)) != 0 || n10 <= (n11 = 17) && (n11 = (int)((string3 = "OMX.allwinner.video.decoder.avc").equals(string4) ? 1 : 0)) != 0 || n10 <= (n11 = 29) && ((n10 = (int)((string2 = "OMX.broadcom.video_decoder.tunnel").equals(string4) ? 1 : 0)) != 0 || (bl3 = (string2 = "OMX.broadcom.video_decoder.tunnel.secure").equals(string4))) || (bl3 = (string2 = "Amazon").equals(string4 = Util.MANUFACTURER)) && (bl3 = (string2 = "AFTS").equals(string4 = Util.MODEL)) && (bl2 = mediaCodecInfo.secure)) {
            bl2 = true;
        } else {
            bl2 = false;
            mediaCodecInfo = null;
        }
        return bl2;
    }

    private static boolean codecNeedsFlushWorkaround(String string2) {
        boolean bl2;
        String string3;
        String string4;
        int n10 = Util.SDK_INT;
        int n11 = 18;
        if (n10 >= n11 && (n10 != n11 || (n11 = (int)((string4 = "OMX.SEC.avc.dec").equals(string2) ? 1 : 0)) == 0 && (n11 = (int)((string4 = "OMX.SEC.avc.dec.secure").equals(string2) ? 1 : 0)) == 0) && (n10 != (n11 = 19) || (n10 = (int)((string3 = Util.MODEL).startsWith(string4 = "SM-G800") ? 1 : 0)) == 0 || (n10 = (int)((string3 = "OMX.Exynos.avc.dec").equals(string2) ? 1 : 0)) == 0 && !(bl2 = (string3 = "OMX.Exynos.avc.dec.secure").equals(string2)))) {
            bl2 = false;
            string2 = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }

    private static boolean codecNeedsMonoChannelCountWorkaround(String string2, Format object) {
        boolean bl2;
        int n10;
        int n11 = Util.SDK_INT;
        int n12 = 1;
        int n13 = 18;
        if (n11 > n13 || (n10 = ((Format)object).channelCount) != n12 || !(bl2 = ((String)(object = "OMX.MTK.AUDIO.DECODER.MP3")).equals(string2))) {
            n12 = 0;
        }
        return n12 != 0;
    }

    private static boolean codecNeedsSosFlushWorkaround(String string2) {
        String string3;
        boolean bl2;
        int n10 = Util.SDK_INT;
        int n11 = 29;
        if (n10 == n11 && (bl2 = (string3 = "c2.android.aac.decoder").equals(string2))) {
            bl2 = true;
        } else {
            bl2 = false;
            string2 = null;
        }
        return bl2;
    }

    private void disableBypass() {
        this.bypassDrainAndReinitialize = false;
        this.bypassBatchBuffer.clear();
        this.bypassSampleBuffer.clear();
        this.bypassSampleBufferPending = false;
        this.bypassEnabled = false;
    }

    private boolean drainAndFlushCodec() {
        boolean bl2 = this.codecReceivedBuffers;
        int n10 = 1;
        if (bl2) {
            this.codecDrainState = n10;
            bl2 = this.codecNeedsFlushWorkaround;
            if (!bl2 && !(bl2 = this.codecNeedsEosFlushWorkaround)) {
                this.codecDrainAction = n10;
            } else {
                this.codecDrainAction = 3;
                return false;
            }
        }
        return n10 != 0;
    }

    private void drainAndReinitializeCodec() {
        int n10 = this.codecReceivedBuffers;
        if (n10 != 0) {
            this.codecDrainState = 1;
            this.codecDrainAction = n10 = 3;
        } else {
            this.reinitializeCodec();
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    private boolean drainAndUpdateCodecDrmSessionV23() {
        int n10 = this.codecReceivedBuffers;
        boolean bl2 = true;
        if (n10 == 0) {
            this.updateDrmSessionV23();
            return bl2;
        }
        this.codecDrainState = bl2;
        n10 = this.codecNeedsFlushWorkaround;
        if (n10 == 0 && (n10 = this.codecNeedsEosFlushWorkaround) == 0) {
            this.codecDrainAction = n10 = 2;
            return bl2;
        }
        this.codecDrainAction = 3;
        return false;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    private boolean drainOutputBuffer(long var1_1, long var3_2) {
        block37: {
            var5_3 = this;
            var6_4 = this.hasOutputBuffer();
            var7_5 = true;
            var8_6 = false;
            var9_7 = null;
            if (!var6_4) {
                var6_4 = this.codecNeedsEosOutputExceptionWorkaround;
                if (var6_4 && (var6_4 = this.codecReceivedEos)) {
                    try {
                        var10_8 = this.codec;
                    }
                    catch (IllegalStateException v0) {
                        this.processEndOfStream();
                        var6_4 = var5_3.outputStreamEnded;
                        if (var6_4) {
                            this.releaseCodec();
                        }
                        return false;
                    }
                    var11_9 = this.outputBufferInfo;
                    var6_4 = var10_8.dequeueOutputBufferIndex((MediaCodec.BufferInfo)var11_9);
                } else {
                    var10_8 = var5_3.codec;
                    var11_9 = var5_3.outputBufferInfo;
                    var6_4 = var10_8.dequeueOutputBufferIndex((MediaCodec.BufferInfo)var11_9);
                }
                if (var6_4 < false) {
                    var12_10 = -2 != 0;
                    if (var6_4 == var12_10) {
                        this.processOutputMediaFormatChanged();
                        return var7_5;
                    }
                    var6_4 = var5_3.codecNeedsEosPropagation;
                    if (var6_4 && ((var6_4 = (boolean)var5_3.inputStreamEnded) || (var6_4 = var5_3.codecDrainState) == (var12_10 = 2 != 0))) {
                        this.processEndOfStream();
                    }
                    return false;
                }
                var12_11 = var5_3.shouldSkipAdaptationWorkaroundOutputBuffer;
                if (var12_11 != 0) {
                    var5_3.shouldSkipAdaptationWorkaroundOutputBuffer = false;
                    var5_3.codec.releaseOutputBuffer((int)var6_4, false);
                    return var7_5;
                }
                var11_9 = var5_3.outputBufferInfo;
                var13_12 = var11_9.size;
                if (var13_12 == 0 && (var12_11 = var11_9.flags & 4) != 0) {
                    this.processEndOfStream();
                    return false;
                }
                var5_3.outputIndex = var6_4;
                var11_9 = var5_3.codec;
                var5_3.outputBuffer = var10_8 = var11_9.getOutputBuffer((int)var6_4);
                if (var10_8 != null) {
                    var12_11 = var5_3.outputBufferInfo.offset;
                    var10_8.position(var12_11);
                    var10_8 = var5_3.outputBuffer;
                    var11_9 = var5_3.outputBufferInfo;
                    var13_12 = var11_9.offset;
                    var12_11 = var11_9.size;
                    var10_8.limit(var13_12 += var12_11);
                }
                if (var6_4 = (boolean)var5_3.codecNeedsEosBufferTimestampWorkaround) {
                    var10_8 = var5_3.outputBufferInfo;
                    var14_13 = var10_8.presentationTimeUs;
                    var16_14 = 0L;
                    cfr_temp_0 = var14_13 - var16_14;
                    var12_11 = (int)(cfr_temp_0 == 0L ? 0 : (cfr_temp_0 < 0L ? -1 : 1));
                    if (var12_11 == 0 && (var12_11 = var10_8.flags & 4) != 0 && (var18_15 = (cfr_temp_1 = (var14_13 = var5_3.largestQueuedPresentationTimeUs) - (var16_14 = -9223372036854775807L)) == 0L ? 0 : (cfr_temp_1 < 0L ? -1 : 1)) != false) {
                        var10_8.presentationTimeUs = var14_13;
                    }
                }
                var10_8 = var5_3.outputBufferInfo;
                var19_16 = var10_8.presentationTimeUs;
                var5_3.isDecodeOnlyOutputBuffer = var6_4 = (boolean)var5_3.isDecodeOnlyBuffer(var19_16);
                var19_16 = var5_3.lastBufferInStreamPresentationTimeUs;
                var21_17 = var5_3.outputBufferInfo;
                var22_18 = var21_17.presentationTimeUs;
                cfr_temp_2 = var19_16 - var22_18;
                var6_4 = (boolean)(cfr_temp_2 == 0L ? 0 : (cfr_temp_2 < 0L ? -1 : 1));
                if (!var6_4) {
                    var6_4 = var7_5;
                } else {
                    var6_4 = false;
                    var10_8 = null;
                }
                var5_3.isLastOutputBuffer = var6_4;
                var5_3.updateOutputFormatForTime(var22_18);
            }
            if ((var6_4 = var5_3.codecNeedsEosOutputExceptionWorkaround) && (var6_4 = var5_3.codecReceivedEos)) {
                try {
                    var24_19 = var5_3.codec;
                }
                catch (IllegalStateException v1) lbl-1000:
                // 2 sources

                {
                    while (true) {
                        this.processEndOfStream();
                        var6_4 = var5_3.outputStreamEnded;
                        if (var6_4) {
                            this.releaseCodec();
                        }
                        return false;
                    }
                }
                var25_21 = var5_3.outputBuffer;
                var26_23 = var5_3.outputIndex;
                var10_8 = var5_3.outputBufferInfo;
                var27_25 = var10_8.flags;
                var28_27 = 1;
                var29_29 = var10_8.presentationTimeUs;
                var31_31 = var5_3.isDecodeOnlyOutputBuffer;
                var32_33 = var5_3.isLastOutputBuffer;
                var33_35 = var5_3.outputFormat;
                var10_8 = this;
                var14_13 = var1_1;
                var16_14 = var3_2;
                var9_7 = var33_35;
                var6_4 = this.processOutputBuffer(var1_1, var3_2, var24_19, var25_21, var26_23, var27_25, var28_27, var29_29, var31_31, var32_33, var33_35);
                break block37;
            }
            var24_20 = var5_3.codec;
            var25_22 = var5_3.outputBuffer;
            var26_24 = var5_3.outputIndex;
            var10_8 = var5_3.outputBufferInfo;
            var27_26 = var10_8.flags;
            var28_28 = 1;
            var29_30 = var10_8.presentationTimeUs;
            var31_32 = var5_3.isDecodeOnlyOutputBuffer;
            var32_34 = var5_3.isLastOutputBuffer;
            var9_7 = var5_3.outputFormat;
            var10_8 = this;
            var14_13 = var1_1;
            var16_14 = var3_2;
            var6_4 = this.processOutputBuffer(var1_1, var3_2, var24_20, var25_22, var26_24, var27_26, var28_28, var29_30, var31_32, var32_34, var9_7);
        }
        if (var6_4) {
            var19_16 = var5_3.outputBufferInfo.presentationTimeUs;
            var5_3.onProcessedOutputBuffer(var19_16);
            var10_8 = var5_3.outputBufferInfo;
            var6_4 = var10_8.flags & 4;
            if (var6_4) {
                var8_6 = var7_5;
            } else {
                var8_6 = false;
                var9_7 = null;
            }
            this.resetOutputBuffer();
            if (!var8_6) {
                return var7_5;
            }
            this.processEndOfStream();
        }
        return false;
        catch (IllegalStateException v2) {
            ** continue;
        }
    }

    private boolean drmNeedsCodecReinitialization(MediaCodecInfo mediaCodecInfo, Format format, DrmSession object, DrmSession drmSession) {
        if (object == drmSession) {
            return false;
        }
        boolean bl2 = true;
        if (drmSession != null && object != null) {
            int n10 = Util.SDK_INT;
            int n11 = 23;
            if (n10 < n11) {
                return bl2;
            }
            UUID uUID = C.PLAYREADY_UUID;
            boolean bl3 = uUID.equals(object = object.getSchemeUuid());
            if (!bl3 && !(bl3 = uUID.equals(object = drmSession.getSchemeUuid()))) {
                object = this.getFrameworkMediaCrypto(drmSession);
                if (object == null) {
                    return bl2;
                }
                boolean bl4 = mediaCodecInfo.secure;
                if (!bl4 && (bl4 = this.maybeRequiresSecureDecoder((FrameworkMediaCrypto)object, format))) {
                    return bl2;
                }
                return false;
            }
        }
        return bl2;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private boolean feedInputBuffer() {
        var1_1 = this.codec;
        var2_4 = 0;
        var3_5 /* !! */  = null;
        if (var1_1 == null) return false;
        var4_6 = this.codecDrainState;
        var5_7 = 2;
        if (var4_6 == var5_7) return false;
        var4_6 = (int)this.inputStreamEnded;
        if (var4_6 != 0) {
            return false;
        }
        var4_6 = this.inputIndex;
        if (var4_6 < 0) {
            this.inputIndex = var6_8 = var1_1.dequeueInputBufferIndex();
            if (var6_8 < 0) {
                return false;
            }
            var7_9 = this.buffer;
            var8_10 = this.codec;
            var7_9.data = var1_1 = var8_10.getInputBuffer(var6_8);
            var1_1 = this.buffer;
            var1_1.clear();
        }
        if ((var6_8 = this.codecDrainState) == (var4_6 = 1)) {
            var6_8 = (int)this.codecNeedsEosPropagation;
            if (var6_8 == 0) {
                this.codecReceivedEos = var4_6;
                var8_10 = this.codec;
                var9_11 = this.inputIndex;
                var10_13 = false;
                var11_16 = null;
                var12_19 = false;
                var13_22 = 0L;
                var15_23 = 4;
                var8_10.queueInputBuffer(var9_11, 0, 0, var13_22, var15_23);
                this.resetInputBuffer();
            }
            this.codecDrainState = var5_7;
            return false;
        }
        var6_8 = (int)this.codecNeedsAdaptationWorkaroundBuffer;
        if (var6_8 != 0) {
            this.codecNeedsAdaptationWorkaroundBuffer = false;
            var1_1 = this.buffer.data;
            var3_5 /* !! */  = MediaCodecRenderer.ADAPTATION_WORKAROUND_BUFFER;
            var1_1.put(var3_5 /* !! */ );
            var16_24 = this.codec;
            var17_27 = this.inputIndex;
            var10_14 = var3_5 /* !! */ .length;
            var16_24.queueInputBuffer(var17_27, 0, var10_14, 0L, 0);
            this.resetInputBuffer();
            this.codecReceivedBuffers = var4_6;
            return (boolean)var4_6;
        }
        var6_8 = this.codecReconfigurationState;
        if (var6_8 == var4_6) {
            var1_1 = null;
            for (var6_8 = 0; var6_8 < (var17_28 = (var8_10 = this.codecInputFormat.initializationData).size()); ++var6_8) {
                var8_10 = (byte[])this.codecInputFormat.initializationData.get(var6_8);
                var18_29 = this.buffer.data;
                var18_29.put((byte[])var8_10);
            }
            this.codecReconfigurationState = var5_7;
        }
        var1_1 = this.buffer.data;
        var6_8 = var1_1.position();
        var8_10 = this.getFormatHolder();
        var18_29 = this.buffer;
        var9_12 = this.readSource((FormatHolder)var8_10, (DecoderInputBuffer)var18_29, false);
        var10_15 = this.hasReadStreamToEnd();
        if (var10_15 != 0) {
            this.lastBufferInStreamPresentationTimeUs = var19_30 = this.largestQueuedPresentationTimeUs;
        }
        if (var9_12 == (var10_15 = -3)) {
            return false;
        }
        var10_15 = -5;
        if (var9_12 == var10_15) {
            var6_8 = this.codecReconfigurationState;
            if (var6_8 == var5_7) {
                var1_1 = this.buffer;
                var1_1.clear();
                this.codecReconfigurationState = var4_6;
            }
            this.onInputFormatChanged((FormatHolder)var8_10);
            return (boolean)var4_6;
        }
        var8_10 = this.buffer;
        var17_28 = (int)var8_10.isEndOfStream();
        if (var17_28 != 0) {
            var6_8 = this.codecReconfigurationState;
            if (var6_8 == var5_7) {
                var1_1 = this.buffer;
                var1_1.clear();
                this.codecReconfigurationState = var4_6;
            }
            this.inputStreamEnded = var4_6;
            var6_8 = (int)this.codecReceivedBuffers;
            if (var6_8 == 0) {
                this.processEndOfStream();
                return false;
            }
            try {
                var6_8 = (int)this.codecNeedsEosPropagation;
                if (var6_8 != 0) {
                    return false;
                }
                this.codecReceivedEos = var4_6;
                var16_25 = this.codec;
                var17_28 = this.inputIndex;
                var9_12 = 0;
                var18_29 = null;
                var10_15 = 0;
                var11_17 = null;
                var21_31 = 0L;
                var23_32 = 4;
                var16_25.queueInputBuffer(var17_28, 0, 0, var21_31, var23_32);
                this.resetInputBuffer();
                return false;
            }
            catch (MediaCodec.CryptoException var1_2) {
                var3_5 /* !! */  = (byte[])this.inputFormat;
                throw this.createRendererException(var1_2, (Format)var3_5 /* !! */ );
            }
        }
        var17_28 = (int)this.codecReceivedBuffers;
        if (var17_28 == 0 && (var17_28 = (int)(var8_10 = this.buffer).isKeyFrame()) == 0) {
            var1_1 = this.buffer;
            var1_1.clear();
            var6_8 = this.codecReconfigurationState;
            if (var6_8 != var5_7) return (boolean)var4_6;
            this.codecReconfigurationState = var4_6;
            return (boolean)var4_6;
        }
        var16_26 = this.buffer;
        var5_7 = (int)var16_26.isEncrypted();
        if (var5_7 != 0) {
            var8_10 = this.buffer.cryptoInfo;
            var8_10.increaseClearDataFirstSubSampleBy(var6_8);
        }
        if ((var6_8 = (int)this.codecNeedsDiscardToSpsWorkaround) != 0 && var5_7 == 0) {
            NalUnitUtil.discardToSps(this.buffer.data);
            var1_1 = this.buffer.data;
            var6_8 = var1_1.position();
            if (var6_8 == 0) {
                return (boolean)var4_6;
            }
            this.codecNeedsDiscardToSpsWorkaround = false;
        }
        var1_1 = this.buffer;
        var24_34 = var1_1.timeUs;
        var11_18 = this.c2Mp3TimestampTracker;
        if (var11_18 != null) {
            var8_10 = this.inputFormat;
            var24_34 = var11_18.updateAndGetPresentationTimeUs((Format)var8_10, (DecoderInputBuffer)var1_1);
        }
        var26_35 = var24_34;
        var1_1 = this.buffer;
        var6_8 = var1_1.isDecodeOnly();
        if (var6_8 != 0) {
            var1_1 = this.decodeOnlyPresentationTimestamps;
            var8_10 = var24_34;
            var1_1.add(var8_10);
        }
        if ((var6_8 = this.waitingForFirstSampleInFormat) != 0) {
            var1_1 = this.formatQueue;
            var8_10 = this.inputFormat;
            var1_1.add(var26_35, var8_10);
            this.waitingForFirstSampleInFormat = false;
        }
        if ((var1_1 = this.c2Mp3TimestampTracker) != null) {
            var24_34 = this.largestQueuedPresentationTimeUs;
            var1_1 = this.buffer;
            var19_30 = var1_1.timeUs;
            this.largestQueuedPresentationTimeUs = var24_34 = Math.max(var24_34, var19_30);
        } else {
            this.largestQueuedPresentationTimeUs = var24_34 = Math.max(this.largestQueuedPresentationTimeUs, var26_35);
        }
        this.buffer.flip();
        var1_1 = this.buffer;
        var6_8 = var1_1.hasSupplementalData();
        if (var6_8 != 0) {
            var1_1 = this.buffer;
            this.handleInputBufferSupplementalData((DecoderInputBuffer)var1_1);
        }
        var1_1 = this.buffer;
        this.onQueueInputBuffer((DecoderInputBuffer)var1_1);
        if (var5_7 == 0) ** GOTO lbl174
        try {
            block30: {
                var11_18 = this.codec;
                var12_20 = this.inputIndex;
                var1_1 = this.buffer;
                var28_36 = var1_1.cryptoInfo;
                var11_18.queueSecureInputBuffer(var12_20, 0, var28_36, var26_35, 0);
                break block30;
lbl174:
                // 1 sources

                var11_18 = this.codec;
                var12_21 = this.inputIndex;
                var1_1 = this.buffer;
                var1_1 = var1_1.data;
                var23_33 = var1_1.limit();
                var11_18.queueInputBuffer(var12_21, 0, var23_33, var26_35, 0);
            }
            this.resetInputBuffer();
            this.codecReceivedBuffers = var4_6;
            this.codecReconfigurationState = 0;
            var1_1 = this.decoderCounters;
            var1_1.inputBufferCount = var2_4 = var1_1.inputBufferCount + var4_6;
            return (boolean)var4_6;
        }
        catch (MediaCodec.CryptoException var1_3) {
            var3_5 /* !! */  = (byte[])this.inputFormat;
            throw this.createRendererException(var1_3, (Format)var3_5 /* !! */ );
        }
    }

    private void flushCodec() {
        try {
            MediaCodecAdapter mediaCodecAdapter = this.codec;
            mediaCodecAdapter.flush();
            return;
        }
        finally {
            this.resetCodecStateForFlush();
        }
    }

    private List getAvailableCodecInfos(boolean bl2) {
        Object object = this.mediaCodecSelector;
        Object object2 = this.inputFormat;
        boolean bl3 = (object = this.getDecoderInfos((MediaCodecSelector)object, (Format)object2, bl2)).isEmpty();
        if (bl3 && bl2) {
            Object object3 = this.mediaCodecSelector;
            object = this.inputFormat;
            bl3 = false;
            object2 = null;
            bl2 = (object = this.getDecoderInfos((MediaCodecSelector)object3, (Format)object, false)).isEmpty();
            if (!bl2) {
                object3 = this.inputFormat.sampleMimeType;
                object2 = String.valueOf(object);
                int n10 = String.valueOf(object3).length() + 99;
                int n11 = String.valueOf(object2).length();
                StringBuilder stringBuilder = new StringBuilder(n10 += n11);
                String string2 = "Drm session requires secure decoder for ";
                stringBuilder.append(string2);
                stringBuilder.append((String)object3);
                stringBuilder.append(", but no secure decoder available. Trying to proceed with ");
                stringBuilder.append((String)object2);
                stringBuilder.append(".");
                object3 = stringBuilder.toString();
                object2 = TAG;
                Log.w((String)object2, (String)object3);
            }
        }
        return object;
    }

    private FrameworkMediaCrypto getFrameworkMediaCrypto(DrmSession object) {
        boolean bl2;
        if ((object = object.getMediaCrypto()) != null && !(bl2 = object instanceof FrameworkMediaCrypto)) {
            object = String.valueOf(object);
            int n10 = String.valueOf(object).length() + 42;
            StringBuilder stringBuilder = new StringBuilder(n10);
            stringBuilder.append("Expecting FrameworkMediaCrypto but found: ");
            stringBuilder.append((String)object);
            object = stringBuilder.toString();
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)object);
            object = this.inputFormat;
            throw this.createRendererException(illegalArgumentException, (Format)object);
        }
        return (FrameworkMediaCrypto)object;
    }

    private boolean hasOutputBuffer() {
        int n10 = this.outputIndex;
        n10 = n10 >= 0 ? 1 : 0;
        return n10 != 0;
    }

    private void initBypass(Format object) {
        boolean bl2;
        this.disableBypass();
        object = ((Format)object).sampleMimeType;
        String string2 = "audio/mp4a-latm";
        int n10 = string2.equals(object);
        int n11 = 1;
        if (n10 == 0 && (n10 = (int)((string2 = "audio/mpeg").equals(object) ? 1 : 0)) == 0 && !(bl2 = (string2 = "audio/opus").equals(object))) {
            object = this.bypassBatchBuffer;
            ((BatchBuffer)object).setMaxSampleCount(n11);
        } else {
            object = this.bypassBatchBuffer;
            n10 = 32;
            ((BatchBuffer)object).setMaxSampleCount(n10);
        }
        this.bypassEnabled = n11;
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void initCodec(MediaCodecInfo mediaCodecInfo, MediaCrypto mediaCrypto) {
        void var23_25;
        Object object;
        block13: {
            long l10;
            int n10;
            long l11;
            Object object5;
            Object object2;
            Object object3;
            long l12;
            Object object4;
            float f13;
            String string2 = mediaCodecInfo.name;
            int n11 = Util.SDK_INT;
            int n102 = -1082130432;
            float f11 = -1.0f;
            int n12 = 23;
            if (n11 < n12) {
                f13 = f11;
            } else {
                f13 = this.targetPlaybackSpeed;
                object4 = this.inputFormat;
                Format[] formatArray = this.getStreamFormats();
                f13 = this.getCodecOperatingRateV23(f13, (Format)object4, formatArray);
            }
            float f14 = this.assumedMinimumCodecOperatingRate;
            float f12 = f13 == f14 ? 0 : (f13 < f14 ? -1 : 1);
            float f10 = f12 <= 0 ? f11 : f13;
            n102 = 0;
            f11 = 0.0f;
            object = null;
            try {
                l12 = SystemClock.elapsedRealtime();
                object3 = "createCodec:";
                object4 = String.valueOf(string2);
                int bl2 = ((String)object4).length();
                object3 = bl2 != 0 ? ((String)object3).concat((String)object4) : (object4 = new String((String)object3));
                TraceUtil.beginSection((String)object3);
                object3 = MediaCodec.createByCodecName((String)string2);
                f12 = (float)this.enableAsynchronousBufferQueueing;
                if (f12 != false && n11 >= n12) {
                    n12 = this.getTrackType();
                    f12 = (float)this.forceAsyncQueueingSynchronizationWorkaround;
                    boolean bl22 = this.enableSynchronizeCodecInteractionsWithQueueing;
                    object2 = new AsynchronousMediaCodecAdapter$Factory(n12, (boolean)f12, bl22);
                    object2 = ((AsynchronousMediaCodecAdapter$Factory)object2).createAdapter((MediaCodec)object3);
                } else {
                    object2 = this.codecAdapterFactory;
                    object2 = object2.createAdapter((MediaCodec)object3);
                }
                object5 = object2;
            }
            catch (Exception exception2) {
                // empty catch block
                break block13;
            }
            try {
                TraceUtil.endSection();
                object2 = "configureCodec";
                TraceUtil.beginSection((String)object2);
                object3 = this.inputFormat;
                object2 = this;
                object = mediaCodecInfo;
                object4 = mediaCrypto;
                this.configureCodec(mediaCodecInfo, (MediaCodecAdapter)object5, (Format)object3, mediaCrypto, f10);
                TraceUtil.endSection();
                object2 = "startCodec";
                TraceUtil.beginSection((String)object2);
                object5.start();
                TraceUtil.endSection();
                l11 = SystemClock.elapsedRealtime();
                this.codec = object5;
                this.codecInfo = mediaCodecInfo;
                this.codecOperatingRate = f10;
                this.codecInputFormat = object2 = this.inputFormat;
                this.codecAdaptationWorkaroundMode = n11 = this.codecAdaptationWorkaroundMode(string2);
                object2 = this.codecInputFormat;
            }
            catch (Exception exception) {
                object = object5;
                break block13;
            }
            n11 = (int)(MediaCodecRenderer.codecNeedsDiscardToSpsWorkaround(string2, (Format)object2) ? 1 : 0);
            this.codecNeedsDiscardToSpsWorkaround = n11;
            n11 = (int)(MediaCodecRenderer.codecNeedsFlushWorkaround(string2) ? 1 : 0);
            this.codecNeedsFlushWorkaround = n11;
            n11 = (int)(MediaCodecRenderer.codecNeedsSosFlushWorkaround(string2) ? 1 : 0);
            this.codecNeedsSosFlushWorkaround = n11;
            n11 = (int)(MediaCodecRenderer.codecNeedsEosFlushWorkaround(string2) ? 1 : 0);
            this.codecNeedsEosFlushWorkaround = n11;
            n11 = (int)(MediaCodecRenderer.codecNeedsEosOutputExceptionWorkaround(string2) ? 1 : 0);
            this.codecNeedsEosOutputExceptionWorkaround = n11;
            n11 = (int)(MediaCodecRenderer.codecNeedsEosBufferTimestampWorkaround(string2) ? 1 : 0);
            this.codecNeedsEosBufferTimestampWorkaround = n11;
            object2 = this.codecInputFormat;
            n11 = (int)(MediaCodecRenderer.codecNeedsMonoChannelCountWorkaround(string2, (Format)object2) ? 1 : 0);
            this.codecNeedsMonoChannelCountWorkaround = n11;
            n11 = (int)(MediaCodecRenderer.codecNeedsEosPropagationWorkaround(mediaCodecInfo) ? 1 : 0);
            n102 = 1;
            f11 = Float.MIN_VALUE;
            if (n11 == 0 && (n11 = (int)(this.getCodecNeedsEosPropagation() ? 1 : 0)) == 0) {
                n11 = 0;
                object2 = null;
            } else {
                n11 = n102;
            }
            this.codecNeedsEosPropagation = n11;
            Object exception = mediaCodecInfo.name;
            object2 = "c2.android.mp3.decoder";
            boolean bl3 = ((String)object2).equals(exception);
            if (bl3) {
                this.c2Mp3TimestampTracker = exception = new C2Mp3TimestampTracker();
            }
            if ((n10 = this.getState()) == (n11 = 2)) {
                long l13 = SystemClock.elapsedRealtime();
                l10 = 1000L;
                this.codecHotswapDeadlineMs = l13 += l10;
            }
            exception = this.decoderCounters;
            ((DecoderCounters)exception).decoderInitCount = n11 = ((DecoderCounters)exception).decoderInitCount + n102;
            l10 = l11 - l12;
            object2 = this;
            object = string2;
            this.onCodecInitialized(string2, l11, l10);
            return;
        }
        if (object != null) {
            object.release();
        }
        throw var23_25;
    }

    private boolean isDecodeOnlyBuffer(long l10) {
        ArrayList arrayList = this.decodeOnlyPresentationTimestamps;
        int n10 = arrayList.size();
        for (int i10 = 0; i10 < n10; ++i10) {
            Long l11 = (Long)this.decodeOnlyPresentationTimestamps.get(i10);
            long l12 = l11;
            long l13 = l12 - l10;
            Object object = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
            if (object != false) continue;
            this.decodeOnlyPresentationTimestamps.remove(i10);
            return true;
        }
        return false;
    }

    private static boolean isMediaCodecException(IllegalStateException object) {
        String string2;
        boolean bl2;
        int n10 = Util.SDK_INT;
        boolean bl3 = true;
        int n11 = 21;
        if (n10 >= n11 && (n10 = (int)(MediaCodecRenderer.isMediaCodecExceptionV21((IllegalStateException)object) ? 1 : 0)) != 0) {
            return bl3;
        }
        object = ((Throwable)object).getStackTrace();
        n10 = ((StackTraceElement[])object).length;
        n11 = 0;
        if (n10 <= 0 || !(bl2 = ((String)(object = object[0].getClassName())).equals(string2 = "android.media.MediaCodec"))) {
            bl3 = false;
        }
        return bl3;
    }

    private static boolean isMediaCodecExceptionV21(IllegalStateException illegalStateException) {
        return illegalStateException instanceof MediaCodec.CodecException;
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive exception aggregation
     */
    private void maybeInitCodecWithFallback(MediaCrypto object, boolean bl2) {
        boolean bl3;
        Object object2;
        boolean bl4;
        void var2_4;
        Object object3 = this.availableCodecInfos;
        Format format = null;
        if (object3 == null) {
            try {
                ArrayDeque arrayDeque;
                object3 = this.getAvailableCodecInfos((boolean)var2_4);
                this.availableCodecInfos = arrayDeque = new ArrayDeque();
                boolean bl5 = this.enableDecoderFallback;
                if (bl5) {
                    arrayDeque.addAll(object3);
                } else {
                    bl4 = object3.isEmpty();
                    if (!bl4) {
                        arrayDeque = this.availableCodecInfos;
                        bl5 = false;
                        object2 = null;
                        object3 = object3.get(0);
                        object3 = (MediaCodecInfo)object3;
                        arrayDeque.add(object3);
                    }
                }
                this.preferredDecoderInitializationException = null;
            }
            catch (MediaCodecUtil$DecoderQueryException mediaCodecUtil$DecoderQueryException) {
                format = this.inputFormat;
                object3 = new MediaCodecRenderer$DecoderInitializationException(format, (Throwable)mediaCodecUtil$DecoderQueryException, (boolean)var2_4, -49998);
                throw object3;
            }
        }
        if (!(bl3 = ((ArrayDeque)(object3 = this.availableCodecInfos)).isEmpty())) {
            while ((object3 = this.codec) == null) {
                object3 = (MediaCodecInfo)this.availableCodecInfos.peekFirst();
                bl4 = this.shouldInitCodec((MediaCodecInfo)object3);
                if (!bl4) {
                    return;
                }
                try {
                    this.initCodec((MediaCodecInfo)object3, (MediaCrypto)object);
                }
                catch (Exception exception) {
                    object2 = String.valueOf(object3);
                    int n10 = String.valueOf(object2).length() + 30;
                    StringBuilder stringBuilder = new StringBuilder(n10);
                    stringBuilder.append("Failed to initialize decoder: ");
                    stringBuilder.append((String)object2);
                    object2 = stringBuilder.toString();
                    Log.w(TAG, (String)object2, exception);
                    this.availableCodecInfos.removeFirst();
                    Format format2 = this.inputFormat;
                    object2 = new MediaCodecRenderer$DecoderInitializationException(format2, (Throwable)exception, (boolean)var2_4, (MediaCodecInfo)object3);
                    object3 = this.preferredDecoderInitializationException;
                    this.preferredDecoderInitializationException = object3 == null ? object2 : (object3 = MediaCodecRenderer$DecoderInitializationException.access$000(this.preferredDecoderInitializationException, (MediaCodecRenderer$DecoderInitializationException)object2));
                    object3 = this.availableCodecInfos;
                    bl3 = ((ArrayDeque)object3).isEmpty();
                    if (!bl3) continue;
                    throw this.preferredDecoderInitializationException;
                }
            }
            this.availableCodecInfos = null;
            return;
        }
        object3 = this.inputFormat;
        MediaCodecRenderer$DecoderInitializationException mediaCodecRenderer$DecoderInitializationException = new MediaCodecRenderer$DecoderInitializationException((Format)object3, null, (boolean)var2_4, -49999);
        throw mediaCodecRenderer$DecoderInitializationException;
    }

    private boolean maybeRequiresSecureDecoder(FrameworkMediaCrypto object, Format format) {
        UUID uUID;
        boolean bl2 = ((FrameworkMediaCrypto)object).forceAllowInsecureDecoderComponents;
        if (bl2) {
            return false;
        }
        try {
            uUID = ((FrameworkMediaCrypto)object).uuid;
        }
        catch (MediaCryptoException mediaCryptoException) {
            return true;
        }
        object = ((FrameworkMediaCrypto)object).sessionId;
        MediaCrypto mediaCrypto = new MediaCrypto(uUID, (byte[])object);
        try {
            object = format.sampleMimeType;
            boolean bl3 = mediaCrypto.requiresSecureDecoderComponent((String)object);
            return bl3;
        }
        finally {
            mediaCrypto.release();
        }
    }

    private void processEndOfStream() {
        int n10 = this.codecDrainAction;
        int n11 = 1;
        if (n10 != n11) {
            int n12 = 2;
            if (n10 != n12) {
                n12 = 3;
                if (n10 != n12) {
                    this.outputStreamEnded = n11;
                    this.renderToEndOfStream();
                } else {
                    this.reinitializeCodec();
                }
            } else {
                this.flushCodec();
                this.updateDrmSessionV23();
            }
        } else {
            this.flushCodec();
        }
    }

    private void processOutputMediaFormatChanged() {
        int n10;
        String string2;
        int n11 = 1;
        this.codecHasOutputMediaFormat = n11;
        MediaFormat mediaFormat = this.codec.getOutputFormat();
        int n12 = this.codecAdaptationWorkaroundMode;
        if (n12 != 0 && (n12 = mediaFormat.getInteger(string2 = "width")) == (n10 = 32) && (n12 = mediaFormat.getInteger(string2 = "height")) == n10) {
            this.shouldSkipAdaptationWorkaroundOutputBuffer = n11;
            return;
        }
        n12 = (int)(this.codecNeedsMonoChannelCountWorkaround ? 1 : 0);
        if (n12 != 0) {
            string2 = "channel-count";
            mediaFormat.setInteger(string2, n11);
        }
        this.codecOutputMediaFormat = mediaFormat;
        this.codecOutputMediaFormatChanged = n11;
    }

    private boolean readToFlagsOnlyBuffer(boolean n10) {
        DecoderInputBuffer decoderInputBuffer;
        FormatHolder formatHolder = this.getFormatHolder();
        this.flagsOnlyBuffer.clear();
        DecoderInputBuffer decoderInputBuffer2 = this.flagsOnlyBuffer;
        n10 = this.readSource(formatHolder, decoderInputBuffer2, n10 != 0);
        boolean bl2 = true;
        int n11 = -5;
        if (n10 == n11) {
            this.onInputFormatChanged(formatHolder);
            return bl2;
        }
        int n12 = -4;
        if (n10 == n12 && (n10 = (int)((decoderInputBuffer = this.flagsOnlyBuffer).isEndOfStream() ? 1 : 0)) != 0) {
            this.inputStreamEnded = bl2;
            this.processEndOfStream();
        }
        return false;
    }

    private void reinitializeCodec() {
        this.releaseCodec();
        this.maybeInitCodecOrBypass();
    }

    private void resetInputBuffer() {
        this.inputIndex = -1;
        this.buffer.data = null;
    }

    private void resetOutputBuffer() {
        this.outputIndex = -1;
        this.outputBuffer = null;
    }

    private void setCodecDrmSession(DrmSession drmSession) {
        DrmSession.replaceSession(this.codecDrmSession, drmSession);
        this.codecDrmSession = drmSession;
    }

    private void setSourceDrmSession(DrmSession drmSession) {
        DrmSession.replaceSession(this.sourceDrmSession, drmSession);
        this.sourceDrmSession = drmSession;
    }

    private boolean shouldContinueRendering(long l10) {
        long l11;
        int n10;
        long l12 = this.renderTimeLimitMs;
        long l13 = -9223372036854775807L;
        long l14 = l12 - l13;
        Object object = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
        n10 = object != false && (n10 = (l11 = (l12 = SystemClock.elapsedRealtime() - l10) - (l10 = this.renderTimeLimitMs)) == 0L ? 0 : (l11 < 0L ? -1 : 1)) >= 0 ? 0 : 1;
        return n10 != 0;
    }

    public static boolean supportsFormatDrm(Format object) {
        Class<FrameworkMediaCrypto> clazz;
        boolean bl2;
        object = ((Format)object).exoMediaCryptoType;
        if (object != null && !(bl2 = (clazz = FrameworkMediaCrypto.class).equals(object))) {
            bl2 = false;
            object = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }

    private boolean updateCodecOperatingRate(Format format) {
        float f10;
        int n10 = Util.SDK_INT;
        boolean bl2 = true;
        int n11 = 23;
        float f11 = 3.2E-44f;
        if (n10 < n11) {
            return bl2;
        }
        float f12 = this.targetPlaybackSpeed;
        f12 = this.codecOperatingRate;
        Format[] formatArray = this.getStreamFormats();
        float f13 = this.getCodecOperatingRateV23(f12, format, formatArray);
        float f14 = f12 - f13;
        n11 = (int)(f14 == 0.0f ? 0 : (f14 > 0.0f ? 1 : -1));
        if (n11 == 0) {
            return bl2;
        }
        n11 = -1082130432;
        f11 = -1.0f;
        float f15 = f13 - f11;
        Object object = f15 == 0.0f ? 0 : (f15 > 0.0f ? 1 : -1);
        if (object == false) {
            this.drainAndReinitializeCodec();
            return false;
        }
        n10 = (int)(f12 == f11 ? 0 : (f12 > f11 ? 1 : -1));
        if (n10 == 0 && (n10 = (int)((f10 = f13 - (f12 = this.assumedMinimumCodecOperatingRate)) == 0.0f ? 0 : (f10 > 0.0f ? 1 : -1))) <= 0) {
            return bl2;
        }
        Bundle bundle = new Bundle();
        bundle.putFloat("operating-rate", f13);
        this.codec.setParameters(bundle);
        this.codecOperatingRate = f13;
        return bl2;
    }

    private void updateDrmSessionV23() {
        Object object;
        Object object2;
        try {
            object2 = this.mediaCrypto;
        }
        catch (MediaCryptoException mediaCryptoException) {
            object = this.inputFormat;
            throw this.createRendererException(mediaCryptoException, (Format)object);
        }
        object = this.sourceDrmSession;
        object = this.getFrameworkMediaCrypto((DrmSession)object);
        object = ((FrameworkMediaCrypto)object).sessionId;
        object2.setMediaDrmSession((byte[])object);
        object2 = this.sourceDrmSession;
        this.setCodecDrmSession((DrmSession)object2);
        this.codecDrainState = 0;
        this.codecDrainAction = 0;
    }

    public DecoderReuseEvaluation canReuseCodec(MediaCodecInfo mediaCodecInfo, Format format, Format format2) {
        String string2 = mediaCodecInfo.name;
        DecoderReuseEvaluation decoderReuseEvaluation = new DecoderReuseEvaluation(string2, format, format2, 0, 1);
        return decoderReuseEvaluation;
    }

    public abstract void configureCodec(MediaCodecInfo var1, MediaCodecAdapter var2, Format var3, MediaCrypto var4, float var5);

    public MediaCodecDecoderException createDecoderException(Throwable throwable, MediaCodecInfo mediaCodecInfo) {
        MediaCodecDecoderException mediaCodecDecoderException = new MediaCodecDecoderException(throwable, mediaCodecInfo);
        return mediaCodecDecoderException;
    }

    public void experimentalSetAsynchronousBufferQueueingEnabled(boolean bl2) {
        this.enableAsynchronousBufferQueueing = bl2;
    }

    public void experimentalSetForceAsyncQueueingSynchronizationWorkaround(boolean bl2) {
        this.forceAsyncQueueingSynchronizationWorkaround = bl2;
    }

    public void experimentalSetSynchronizeCodecInteractionsWithQueueingEnabled(boolean bl2) {
        this.enableSynchronizeCodecInteractionsWithQueueing = bl2;
    }

    public final boolean flushOrReinitializeCodec() {
        boolean bl2 = this.flushOrReleaseCodec();
        if (bl2) {
            this.maybeInitCodecOrBypass();
        }
        return bl2;
    }

    public boolean flushOrReleaseCodec() {
        MediaCodecAdapter mediaCodecAdapter = this.codec;
        if (mediaCodecAdapter == null) {
            return false;
        }
        int n10 = this.codecDrainAction;
        int n11 = 3;
        if (!(n10 == n11 || (n10 = (int)(this.codecNeedsFlushWorkaround ? 1 : 0)) != 0 || (n10 = (int)(this.codecNeedsSosFlushWorkaround ? 1 : 0)) != 0 && (n10 = (int)(this.codecHasOutputMediaFormat ? 1 : 0)) == 0 || (n10 = (int)(this.codecNeedsEosFlushWorkaround ? 1 : 0)) != 0 && (n10 = (int)(this.codecReceivedEos ? 1 : 0)) != 0)) {
            this.flushCodec();
            return false;
        }
        this.releaseCodec();
        return true;
    }

    public final MediaCodecAdapter getCodec() {
        return this.codec;
    }

    public final MediaCodecInfo getCodecInfo() {
        return this.codecInfo;
    }

    public boolean getCodecNeedsEosPropagation() {
        return false;
    }

    public float getCodecOperatingRate() {
        return this.codecOperatingRate;
    }

    public float getCodecOperatingRateV23(float f10, Format format, Format[] formatArray) {
        return -1.0f;
    }

    public final MediaFormat getCodecOutputMediaFormat() {
        return this.codecOutputMediaFormat;
    }

    public abstract List getDecoderInfos(MediaCodecSelector var1, Format var2, boolean var3);

    public final long getOutputStreamOffsetUs() {
        return this.outputStreamOffsetUs;
    }

    public float getPlaybackSpeed() {
        return this.currentPlaybackSpeed;
    }

    public void handleInputBufferSupplementalData(DecoderInputBuffer decoderInputBuffer) {
    }

    public boolean isEnded() {
        return this.outputStreamEnded;
    }

    public boolean isReady() {
        long l10;
        long l11;
        long l12;
        long l13;
        int n10;
        Format format = this.inputFormat;
        if (format != null && ((n10 = this.isSourceReady()) != 0 || (n10 = this.hasOutputBuffer()) != 0 || (n10 = (l13 = (l12 = this.codecHotswapDeadlineMs) - (l11 = -9223372036854775807L)) == 0L ? 0 : (l13 < 0L ? -1 : 1)) != 0 && (n10 = (l10 = (l12 = SystemClock.elapsedRealtime()) - (l11 = this.codecHotswapDeadlineMs)) == 0L ? 0 : (l10 < 0L ? -1 : 1)) < 0)) {
            n10 = 1;
        } else {
            n10 = 0;
            format = null;
        }
        return n10 != 0;
    }

    public boolean legacyKeepAvailableCodecInfosWithoutCodec() {
        return false;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void maybeInitCodecOrBypass() {
        int n11;
        Object object = this.codec;
        if (object != null) return;
        int n10 = this.bypassEnabled;
        if (n10 != 0) return;
        object = this.inputFormat;
        if (object == null) {
            return;
        }
        Object object2 = this.sourceDrmSession;
        if (object2 == null && (n10 = this.shouldUseBypass((Format)object)) != 0) {
            object = this.inputFormat;
            this.initBypass((Format)object);
            return;
        }
        object = this.sourceDrmSession;
        this.setCodecDrmSession((DrmSession)object);
        object = this.inputFormat.sampleMimeType;
        object2 = this.codecDrmSession;
        if (object2 != null) {
            MediaCrypto mediaCrypto = this.mediaCrypto;
            int n12 = 1;
            if (mediaCrypto == null) {
                if ((object2 = this.getFrameworkMediaCrypto((DrmSession)object2)) == null) {
                    object = this.codecDrmSession.getError();
                    if (object == null) return;
                } else {
                    try {
                        UUID uUID = ((FrameworkMediaCrypto)object2).uuid;
                        byte[] byArray = ((FrameworkMediaCrypto)object2).sessionId;
                        this.mediaCrypto = mediaCrypto = new MediaCrypto(uUID, byArray);
                    }
                    catch (MediaCryptoException mediaCryptoException) {
                        object2 = this.inputFormat;
                        throw this.createRendererException(mediaCryptoException, (Format)object2);
                    }
                    n11 = (int)(((FrameworkMediaCrypto)object2).forceAllowInsecureDecoderComponents ? 1 : 0);
                    if (n11 == 0 && (n10 = (int)(mediaCrypto.requiresSecureDecoderComponent((String)object) ? 1 : 0)) != 0) {
                        n10 = n12;
                    } else {
                        n10 = 0;
                        object = null;
                    }
                    this.mediaCryptoRequiresSecureDecoder = n10;
                }
            }
            if ((n10 = FrameworkMediaCrypto.WORKAROUND_DEVICE_NEEDS_KEYS_TO_CONFIGURE_CODEC) != 0) {
                object = this.codecDrmSession;
                n10 = object.getState();
                if (n10 == n12) {
                    object = this.codecDrmSession.getError();
                    object2 = this.inputFormat;
                    throw this.createRendererException((Throwable)object, (Format)object2);
                }
                n11 = 4;
                if (n10 != n11) {
                    return;
                }
            }
        }
        try {
            object = this.mediaCrypto;
            n11 = this.mediaCryptoRequiresSecureDecoder;
            this.maybeInitCodecWithFallback((MediaCrypto)object, n11 != 0);
            return;
        }
        catch (MediaCodecRenderer$DecoderInitializationException mediaCodecRenderer$DecoderInitializationException) {
            object2 = this.inputFormat;
            throw this.createRendererException(mediaCodecRenderer$DecoderInitializationException, (Format)object2);
        }
    }

    public void onCodecInitialized(String string2, long l10, long l11) {
    }

    public void onCodecReleased(String string2) {
    }

    public void onDisabled() {
        long l10;
        this.inputFormat = null;
        this.outputStreamStartPositionUs = l10 = -9223372036854775807L;
        this.outputStreamOffsetUs = l10;
        this.pendingOutputStreamOffsetCount = 0;
        DrmSession drmSession = this.sourceDrmSession;
        if (drmSession == null && (drmSession = this.codecDrmSession) == null) {
            this.flushOrReleaseCodec();
        } else {
            this.onReset();
        }
    }

    public void onEnabled(boolean bl2, boolean bl3) {
        DecoderCounters decoderCounters;
        this.decoderCounters = decoderCounters = new DecoderCounters();
    }

    public DecoderReuseEvaluation onInputFormatChanged(FormatHolder object) {
        Object object2;
        block10: {
            MediaCodecAdapter mediaCodecAdapter;
            int n10;
            int n11;
            Object object3;
            Object object4;
            Format format;
            int n12;
            Object object5;
            int n13;
            block19: {
                block16: {
                    block11: {
                        int n14;
                        block17: {
                            int n15;
                            block18: {
                                int n16;
                                block15: {
                                    block12: {
                                        block13: {
                                            block14: {
                                                int n17;
                                                this.waitingForFirstSampleInFormat = n13 = 1;
                                                object2 = object5 = Assertions.checkNotNull(((FormatHolder)object).format);
                                                object2 = (Format)object5;
                                                object5 = ((Format)object2).sampleMimeType;
                                                if (object5 == null) break block10;
                                                object = ((FormatHolder)object).drmSession;
                                                this.setSourceDrmSession((DrmSession)object);
                                                this.inputFormat = object2;
                                                n12 = this.bypassEnabled;
                                                object5 = null;
                                                if (n12 != 0) {
                                                    this.bypassDrainAndReinitialize = n13;
                                                    return null;
                                                }
                                                object = this.codec;
                                                if (object == null) {
                                                    n12 = this.legacyKeepAvailableCodecInfosWithoutCodec();
                                                    if (n12 == 0) {
                                                        this.availableCodecInfos = null;
                                                    }
                                                    this.maybeInitCodecOrBypass();
                                                    return null;
                                                }
                                                object5 = this.codecInfo;
                                                format = this.codecInputFormat;
                                                object4 = this.codecDrmSession;
                                                object3 = this.sourceDrmSession;
                                                n15 = this.drmNeedsCodecReinitialization((MediaCodecInfo)object5, (Format)object2, (DrmSession)object4, (DrmSession)object3);
                                                if (n15 != 0) {
                                                    this.drainAndReinitializeCodec();
                                                    object3 = ((MediaCodecInfo)object5).name;
                                                    object4 = object;
                                                    object = new DecoderReuseEvaluation((String)object3, format, (Format)object2, 0, 128);
                                                    return object;
                                                }
                                                object4 = this.sourceDrmSession;
                                                object3 = this.codecDrmSession;
                                                if (object4 != object3) {
                                                    n15 = n13;
                                                } else {
                                                    n15 = 0;
                                                    object4 = null;
                                                }
                                                if (n15 != 0 && (n17 = Util.SDK_INT) < (n11 = 23)) {
                                                    n17 = 0;
                                                    object3 = null;
                                                } else {
                                                    n17 = n13;
                                                }
                                                Assertions.checkState(n17 != 0);
                                                object3 = this.canReuseCodec((MediaCodecInfo)object5, format, (Format)object2);
                                                n11 = ((DecoderReuseEvaluation)object3).result;
                                                n10 = 3;
                                                n16 = 16;
                                                n14 = 2;
                                                if (n11 == 0) break block11;
                                                if (n11 == n13) break block12;
                                                if (n11 == n14) break block13;
                                                if (n11 != n10) break block14;
                                                n13 = (int)(this.updateCodecOperatingRate((Format)object2) ? 1 : 0);
                                                if (n13 == 0) break block15;
                                                this.codecInputFormat = object2;
                                                if (n15 == 0 || (n13 = (int)(this.drainAndUpdateCodecDrmSessionV23() ? 1 : 0)) != 0) break block16;
                                                break block17;
                                            }
                                            object = new IllegalStateException();
                                            throw object;
                                        }
                                        n11 = (int)(this.updateCodecOperatingRate((Format)object2) ? 1 : 0);
                                        if (n11 == 0) break block15;
                                        this.codecReconfigured = n13;
                                        this.codecReconfigurationState = n13;
                                        n11 = this.codecAdaptationWorkaroundMode;
                                        if (n11 != n14 && (n11 != n13 || (n11 = ((Format)object2).width) != (n16 = format.width) || (n11 = ((Format)object2).height) != (n16 = format.height))) {
                                            n13 = 0;
                                            mediaCodecAdapter = null;
                                        }
                                        this.codecNeedsAdaptationWorkaroundBuffer = n13;
                                        this.codecInputFormat = object2;
                                        if (n15 == 0 || (n13 = (int)(this.drainAndUpdateCodecDrmSessionV23() ? 1 : 0)) != 0) break block16;
                                        break block17;
                                    }
                                    n13 = (int)(this.updateCodecOperatingRate((Format)object2) ? 1 : 0);
                                    if (n13 != 0) break block18;
                                }
                                n11 = n16;
                                break block19;
                            }
                            this.codecInputFormat = object2;
                            if (!(n15 != 0 ? (n13 = (int)(this.drainAndUpdateCodecDrmSessionV23() ? 1 : 0)) == 0 : (n13 = (int)(this.drainAndFlushCodec() ? 1 : 0)) == 0)) break block16;
                        }
                        n11 = n14;
                        break block19;
                    }
                    this.drainAndReinitializeCodec();
                }
                n11 = 0;
            }
            n13 = ((DecoderReuseEvaluation)object3).result;
            if (n13 != 0 && ((mediaCodecAdapter = this.codec) != object || (n12 = this.codecDrainAction) == n10)) {
                object3 = ((MediaCodecInfo)object5).name;
                object4 = object;
                object = new DecoderReuseEvaluation((String)object3, format, (Format)object2, 0, n11);
                return object;
            }
            return object3;
        }
        object = new IllegalArgumentException();
        throw this.createRendererException((Throwable)object, (Format)object2);
    }

    public void onOutputFormatChanged(Format format, MediaFormat mediaFormat) {
    }

    public void onPositionReset(long l10, boolean bl2) {
        Object object;
        this.inputStreamEnded = false;
        this.outputStreamEnded = false;
        this.pendingOutputEndOfStream = false;
        int n10 = this.bypassEnabled;
        if (n10 != 0) {
            this.bypassBatchBuffer.clear();
            object = this.bypassSampleBuffer;
            ((DecoderInputBuffer)object).clear();
            this.bypassSampleBufferPending = false;
        } else {
            this.flushOrReinitializeCodec();
        }
        object = this.formatQueue;
        n10 = ((TimedValueQueue)object).size();
        bl2 = true;
        if (n10 > 0) {
            this.waitingForFirstSampleInFormat = bl2;
        }
        object = this.formatQueue;
        ((TimedValueQueue)object).clear();
        n10 = this.pendingOutputStreamOffsetCount;
        if (n10 != 0) {
            long l11;
            long l12;
            long[] lArray = this.pendingOutputStreamOffsetsUs;
            int n11 = n10 + -1;
            this.outputStreamOffsetUs = l12 = lArray[n11];
            lArray = this.pendingOutputStreamStartPositionsUs;
            this.outputStreamStartPositionUs = l11 = lArray[n10 -= bl2];
            this.pendingOutputStreamOffsetCount = 0;
        }
    }

    public void onProcessedOutputBuffer(long l10) {
        long[] lArray;
        long l11;
        long l12;
        long l13;
        int n10;
        while ((n10 = this.pendingOutputStreamOffsetCount) != 0 && (l13 = (l12 = l10 - (l11 = (lArray = this.pendingOutputStreamSwitchTimesUs)[0])) == 0L ? 0 : (l12 < 0L ? -1 : 1)) >= 0) {
            long l14;
            lArray = this.pendingOutputStreamStartPositionsUs;
            this.outputStreamStartPositionUs = l11 = lArray[0];
            long[] lArray2 = this.pendingOutputStreamOffsetsUs;
            this.outputStreamOffsetUs = l14 = lArray2[0];
            this.pendingOutputStreamOffsetCount = n10 += -1;
            int n11 = 1;
            System.arraycopy(lArray, n11, lArray, 0, n10);
            long[] lArray3 = this.pendingOutputStreamOffsetsUs;
            l13 = this.pendingOutputStreamOffsetCount;
            System.arraycopy(lArray3, n11, lArray3, 0, (int)l13);
            lArray3 = this.pendingOutputStreamSwitchTimesUs;
            l13 = this.pendingOutputStreamOffsetCount;
            System.arraycopy(lArray3, n11, lArray3, 0, (int)l13);
            this.onProcessedStreamChange();
        }
    }

    public void onProcessedStreamChange() {
    }

    public void onQueueInputBuffer(DecoderInputBuffer decoderInputBuffer) {
    }

    public void onReset() {
        try {
            this.disableBypass();
            this.releaseCodec();
            return;
        }
        finally {
            this.setSourceDrmSession(null);
        }
    }

    public void onStarted() {
    }

    public void onStopped() {
    }

    public void onStreamChanged(Format[] object, long l10, long l11) {
        long l12 = this.outputStreamOffsetUs;
        long l13 = -9223372036854775807L;
        Object object2 = l12 == l13 ? 0 : (l12 < l13 ? -1 : 1);
        int n10 = 1;
        if (object2 == false) {
            long l14 = this.outputStreamStartPositionUs;
            long l15 = l14 - l13;
            object2 = l15 == 0L ? 0 : (l15 < 0L ? -1 : 1);
            if (object2 != false) {
                n10 = 0;
            }
            Assertions.checkState(n10 != 0);
            this.outputStreamStartPositionUs = l10;
            this.outputStreamOffsetUs = l11;
        } else {
            object2 = this.pendingOutputStreamOffsetCount;
            Object object3 = this.pendingOutputStreamOffsetsUs;
            int n11 = ((long[])object3).length;
            if (object2 == n11) {
                l13 = object3[object2 -= n10];
                object2 = 65;
                object3 = new StringBuilder;
                object3((int)object2);
                object3.append("Too many stream changes, so dropping offset: ");
                object3.append(l13);
                object = object3.toString();
                object3 = "MediaCodecRenderer";
                Log.w((String)object3, (String)object);
            } else {
                this.pendingOutputStreamOffsetCount = (int)(object2 += n10);
            }
            object = this.pendingOutputStreamStartPositionsUs;
            int n12 = this.pendingOutputStreamOffsetCount;
            n11 = n12 + -1;
            object[n11] = (Format)l10;
            object = this.pendingOutputStreamOffsetsUs;
            int n13 = n12 + -1;
            object[n13] = (Format)l11;
            object = this.pendingOutputStreamSwitchTimesUs;
            l10 = this.largestQueuedPresentationTimeUs;
            object[n12 -= n10] = (Format)l10;
        }
    }

    public abstract boolean processOutputBuffer(long var1, long var3, MediaCodecAdapter var5, ByteBuffer var6, int var7, int var8, int var9, long var10, boolean var12, boolean var13, Format var14);

    public void releaseCodec() {
        block16: {
            Object object;
            block15: {
                try {
                    object = this.codec;
                    if (object == null) break block15;
                }
                catch (Throwable throwable) {
                    block17: {
                        this.codec = null;
                        MediaCrypto mediaCrypto = this.mediaCrypto;
                        if (mediaCrypto == null) break block17;
                        mediaCrypto.release();
                    }
                    throw throwable;
                    finally {
                        this.mediaCrypto = null;
                        this.setCodecDrmSession(null);
                        this.resetCodecStateForRelease();
                    }
                }
                object.release();
                object = this.decoderCounters;
                int n10 = ((DecoderCounters)object).decoderReleaseCount + 1;
                ((DecoderCounters)object).decoderReleaseCount = n10;
                object = this.codecInfo;
                object = ((MediaCodecInfo)object).name;
                this.onCodecReleased((String)object);
            }
            this.codec = null;
            object = this.mediaCrypto;
            if (object == null) break block16;
            object.release();
        }
        return;
        finally {
            this.mediaCrypto = null;
            this.setCodecDrmSession(null);
            this.resetCodecStateForRelease();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void render(long l10, long l11) {
        Object object;
        boolean bl2 = this.pendingOutputEndOfStream;
        if (bl2) {
            this.pendingOutputEndOfStream = false;
            this.processEndOfStream();
        }
        if ((object = this.pendingPlaybackException) != null) {
            this.pendingPlaybackException = null;
            throw object;
        }
        try {
            bl2 = this.outputStreamEnded;
            if (bl2) {
                this.renderToEndOfStream();
                return;
            }
            object = this.inputFormat;
            if (object == null) {
                bl2 = true;
                if (!(bl2 = this.readToFlagsOnlyBuffer(bl2))) {
                    return;
                }
            }
            this.maybeInitCodecOrBypass();
            bl2 = this.bypassEnabled;
            if (bl2) {
                object = "bypassRender";
                TraceUtil.beginSection((String)object);
                while (bl2 = this.bypassRender(l10, l11)) {
                }
                TraceUtil.endSection();
            } else {
                object = this.codec;
                if (object != null) {
                    boolean bl3;
                    boolean bl4;
                    long l12 = SystemClock.elapsedRealtime();
                    String string2 = "drainAndFeed";
                    TraceUtil.beginSection(string2);
                    while ((bl4 = this.drainOutputBuffer(l10, l11)) && (bl4 = this.shouldContinueRendering(l12))) {
                    }
                    while ((bl3 = this.feedInputBuffer()) && (bl3 = this.shouldContinueRendering(l12))) {
                    }
                    TraceUtil.endSection();
                } else {
                    DecoderCounters decoderCounters = this.decoderCounters;
                    int n10 = decoderCounters.skippedInputBufferCount;
                    int n11 = this.skipSource(l10);
                    decoderCounters.skippedInputBufferCount = n10 += n11;
                    this.readToFlagsOnlyBuffer(false);
                }
            }
            DecoderCounters decoderCounters = this.decoderCounters;
            decoderCounters.ensureUpdated();
            return;
        }
        catch (IllegalStateException illegalStateException) {
            boolean bl5 = MediaCodecRenderer.isMediaCodecException(illegalStateException);
            if (bl5) {
                Object object2 = this.getCodecInfo();
                MediaCodecDecoderException mediaCodecDecoderException = this.createDecoderException(illegalStateException, (MediaCodecInfo)object2);
                object2 = this.inputFormat;
                throw this.createRendererException(mediaCodecDecoderException, (Format)object2);
            }
            throw illegalStateException;
        }
    }

    public void renderToEndOfStream() {
    }

    public void resetCodecStateForFlush() {
        long l10;
        this.resetInputBuffer();
        this.resetOutputBuffer();
        this.codecHotswapDeadlineMs = l10 = -9223372036854775807L;
        this.codecReceivedEos = false;
        this.codecReceivedBuffers = false;
        this.codecNeedsAdaptationWorkaroundBuffer = false;
        this.shouldSkipAdaptationWorkaroundOutputBuffer = false;
        this.isDecodeOnlyOutputBuffer = false;
        this.isLastOutputBuffer = false;
        ArrayList arrayList = this.decodeOnlyPresentationTimestamps;
        arrayList.clear();
        this.largestQueuedPresentationTimeUs = l10;
        this.lastBufferInStreamPresentationTimeUs = l10;
        C2Mp3TimestampTracker c2Mp3TimestampTracker = this.c2Mp3TimestampTracker;
        if (c2Mp3TimestampTracker != null) {
            c2Mp3TimestampTracker.reset();
        }
        this.codecDrainState = 0;
        this.codecDrainAction = 0;
        boolean bl2 = this.codecReconfigured;
        this.codecReconfigurationState = (int)(bl2 ? 1 : 0);
    }

    public void resetCodecStateForRelease() {
        this.resetCodecStateForFlush();
        this.pendingPlaybackException = null;
        this.c2Mp3TimestampTracker = null;
        this.availableCodecInfos = null;
        this.codecInfo = null;
        this.codecInputFormat = null;
        this.codecOutputMediaFormat = null;
        this.codecOutputMediaFormatChanged = false;
        this.codecHasOutputMediaFormat = false;
        this.codecOperatingRate = -1.0f;
        this.codecAdaptationWorkaroundMode = 0;
        this.codecNeedsDiscardToSpsWorkaround = false;
        this.codecNeedsFlushWorkaround = false;
        this.codecNeedsSosFlushWorkaround = false;
        this.codecNeedsEosFlushWorkaround = false;
        this.codecNeedsEosOutputExceptionWorkaround = false;
        this.codecNeedsEosBufferTimestampWorkaround = false;
        this.codecNeedsMonoChannelCountWorkaround = false;
        this.codecNeedsEosPropagation = false;
        this.codecReconfigured = false;
        this.codecReconfigurationState = 0;
        this.mediaCryptoRequiresSecureDecoder = false;
    }

    public final void setPendingOutputEndOfStream() {
        this.pendingOutputEndOfStream = true;
    }

    public final void setPendingPlaybackException(ExoPlaybackException exoPlaybackException) {
        this.pendingPlaybackException = exoPlaybackException;
    }

    public void setPlaybackSpeed(float f10, float f11) {
        this.currentPlaybackSpeed = f10;
        this.targetPlaybackSpeed = f11;
        Object object = this.codec;
        if (object != null) {
            int n10 = this.codecDrainAction;
            int n11 = 3;
            f11 = 4.2E-45f;
            if (n10 != n11 && (n10 = this.getState()) != 0) {
                object = this.codecInputFormat;
                this.updateCodecOperatingRate((Format)object);
            }
        }
    }

    public void setRenderTimeLimitMs(long l10) {
        this.renderTimeLimitMs = l10;
    }

    public boolean shouldInitCodec(MediaCodecInfo mediaCodecInfo) {
        return true;
    }

    public boolean shouldUseBypass(Format format) {
        return false;
    }

    public final int supportsFormat(Format format) {
        MediaCodecSelector mediaCodecSelector;
        try {
            mediaCodecSelector = this.mediaCodecSelector;
        }
        catch (MediaCodecUtil$DecoderQueryException mediaCodecUtil$DecoderQueryException) {
            throw this.createRendererException(mediaCodecUtil$DecoderQueryException, format);
        }
        return this.supportsFormat(mediaCodecSelector, format);
    }

    public abstract int supportsFormat(MediaCodecSelector var1, Format var2);

    public final int supportsMixedMimeTypeAdaptation() {
        return 8;
    }

    public final void updateOutputFormatForTime(long l10) {
        boolean bl2;
        boolean bl3;
        TimedValueQueue timedValueQueue = this.formatQueue;
        Format format = (Format)timedValueQueue.pollFloor(l10);
        if (format == null && (bl3 = this.codecOutputMediaFormatChanged)) {
            format = (Format)this.formatQueue.pollFirst();
        }
        bl3 = false;
        if (format != null) {
            this.outputFormat = format;
            bl2 = true;
        } else {
            bl2 = false;
            format = null;
        }
        if (bl2 || (bl2 = this.codecOutputMediaFormatChanged) && (format = this.outputFormat) != null) {
            format = this.outputFormat;
            timedValueQueue = this.codecOutputMediaFormat;
            this.onOutputFormatChanged(format, (MediaFormat)timedValueQueue);
            this.codecOutputMediaFormatChanged = false;
        }
    }
}

