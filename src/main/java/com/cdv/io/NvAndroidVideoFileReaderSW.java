/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Rect
 *  android.media.Image
 *  android.media.ImageReader
 *  android.media.ImageReader$OnImageAvailableListener
 *  android.media.MediaCodec
 *  android.media.MediaCodec$BufferInfo
 *  android.media.MediaCodecInfo
 *  android.media.MediaCodecInfo$CodecCapabilities
 *  android.media.MediaExtractor
 *  android.media.MediaFormat
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Handler
 *  android.util.Log
 *  android.view.Surface
 */
package com.cdv.io;

import android.content.Context;
import android.graphics.Rect;
import android.media.Image;
import android.media.ImageReader;
import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.os.Build;
import android.os.Handler;
import android.util.Log;
import android.view.Surface;
import com.cdv.io.NvAndroidVideoFileReaderSW$1;
import com.cdv.io.NvAndroidVideoFileReaderSW$2;
import com.cdv.io.NvAndroidVideoFileReaderSW$CueVideoFrameInfo;
import com.cdv.utils.NvAndroidInterruptionChecker;
import com.cdv.utils.NvAndroidUtils;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;

public class NvAndroidVideoFileReaderSW {
    private static final int ERROR_EOF = 1;
    private static final int ERROR_FAIL = 2;
    private static final int ERROR_INTERRUPTED_DECODING = 3;
    private static final int ERROR_MEDIA_EXTRACTOR_PRELOAD_FAILED = 4;
    private static final int ERROR_OK = 0;
    private static final int OPEN_FILE_FLAGS_DECODE_10BIT_FRMAE = 1;
    private static final int SKIP_MODE_ALL_NONREFERENCE = 1;
    private static final int SKIP_MODE_BELOW_TIMESTAMP = 2;
    private static final int SKIP_MODE_NONE = 0;
    private static final String TAG = "NvAndroidVideoFileReaderSW";
    private static final boolean m_verbose = false;
    private long m_actualDuration;
    private MediaCodec.BufferInfo m_bufferInfo;
    private Handler m_cleanupHandler;
    private Context m_context;
    private long m_contiuousDecodingThreshold;
    private MediaCodec m_decoder;
    public ByteBuffer[] m_decoderInputBuffers;
    public ByteBuffer[] m_decoderOutputBuffers;
    private boolean m_decoderSetupFailed;
    private boolean m_decoderStarted;
    private boolean m_decoderUseSurface;
    private long m_duration;
    private MediaExtractor m_extractor;
    private boolean m_extractorInOriginalState;
    private MediaFormat m_format;
    private Object m_frameSyncObject;
    private Handler m_handler;
    private ImageReader m_imageReader;
    private boolean m_imageReady;
    private boolean m_inputBufferQueued;
    private NvAndroidInterruptionChecker m_interruptionChecker;
    private long m_lastSeekActualTimestamp;
    private long m_lastSeekTimestamp;
    private ArrayList m_listPlaybackCueFrame;
    private boolean m_onlyDecodeKeyFrame;
    private int m_openFlags;
    private long m_owner;
    private int m_pendingInputFrameCount;
    private long m_preloadedTimestamp;
    private boolean m_sawInputEOS;
    private boolean m_sawOutputEOS;
    private boolean m_skipNonReferenceFrameWhenPlayback;
    private long m_timestampOfLastCopiedFrame;
    private long m_timestampOfLastDecodedFrame;
    private int m_videoDecodeRetryMaxCount;
    private String m_videoFilePath;
    private int m_videoTrackIndex;

    public NvAndroidVideoFileReaderSW(long l10, Handler handler, Handler handler2) {
        MediaCodec.BufferInfo bufferInfo;
        long l11;
        Object object;
        long l12;
        this.m_owner = l12 = 0L;
        this.m_handler = null;
        this.m_cleanupHandler = null;
        this.m_extractor = null;
        this.m_videoTrackIndex = -1;
        this.m_format = null;
        this.m_duration = l12;
        this.m_actualDuration = l12;
        this.m_extractorInOriginalState = true;
        this.m_bufferInfo = null;
        this.m_decoder = null;
        this.m_imageReader = null;
        this.m_decoderUseSurface = false;
        this.m_frameSyncObject = object = new Object();
        this.m_imageReady = false;
        this.m_decoderSetupFailed = false;
        this.m_decoderStarted = false;
        this.m_decoderInputBuffers = null;
        this.m_decoderOutputBuffers = null;
        this.m_timestampOfLastDecodedFrame = l11 = Long.MIN_VALUE;
        this.m_timestampOfLastCopiedFrame = l11;
        this.m_inputBufferQueued = false;
        this.m_pendingInputFrameCount = 0;
        this.m_sawInputEOS = false;
        this.m_sawOutputEOS = false;
        this.m_preloadedTimestamp = l11;
        this.m_lastSeekTimestamp = l11;
        this.m_lastSeekActualTimestamp = l11;
        this.m_onlyDecodeKeyFrame = false;
        this.m_contiuousDecodingThreshold = 1000000L;
        this.m_skipNonReferenceFrameWhenPlayback = false;
        this.m_videoDecodeRetryMaxCount = 100;
        this.m_openFlags = 0;
        this.m_owner = l10;
        this.m_handler = handler;
        this.m_cleanupHandler = handler2;
        this.m_bufferInfo = bufferInfo = new MediaCodec.BufferInfo();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private Image AwaitNewImage() {
        Object object = this.m_frameSyncObject;
        synchronized (object) {
            Object object2;
            boolean bl2;
            while (!(bl2 = this.m_imageReady)) {
                try {
                    object2 = this.m_frameSyncObject;
                    long l10 = 3000L;
                    object2.wait(l10);
                    bl2 = this.m_imageReady;
                    if (bl2) continue;
                    object2 = TAG;
                    String string2 = "ImageReader wait timed out!";
                    Log.e((String)object2, (String)string2);
                    return null;
                }
                catch (InterruptedException interruptedException) {
                    String string3 = TAG;
                    CharSequence charSequence = new StringBuilder();
                    String string4 = "";
                    charSequence.append(string4);
                    string4 = interruptedException.getMessage();
                    charSequence.append(string4);
                    charSequence = charSequence.toString();
                    Log.e((String)string3, (String)charSequence);
                    interruptedException.printStackTrace();
                    return null;
                }
            }
            bl2 = false;
            object2 = null;
            this.m_imageReady = false;
        }
        try {
            object = this.m_imageReader;
            return object.acquireLatestImage();
        }
        catch (Exception exception) {
            CharSequence charSequence = new StringBuilder();
            charSequence.append("");
            String string5 = exception.getMessage();
            charSequence.append(string5);
            charSequence = charSequence.toString();
            Log.e((String)TAG, (String)charSequence);
            exception.printStackTrace();
            return null;
        }
    }

    private void CleanupDecoder(boolean bl2) {
        long l10;
        Object object;
        boolean bl3;
        MediaCodec mediaCodec;
        block7: {
            mediaCodec = this.m_decoder;
            if (mediaCodec != null && (bl3 = this.m_decoderStarted)) {
                bl3 = this.m_sawInputEOS;
                if (!bl3) break block7;
                bl3 = this.m_sawOutputEOS;
                if (bl3) break block7;
                try {
                    this.DrainOutputBuffers();
                }
                catch (Exception exception) {
                    object = new StringBuilder();
                    ((StringBuilder)object).append("");
                    String string2 = exception.getMessage();
                    ((StringBuilder)object).append(string2);
                    object = ((StringBuilder)object).toString();
                    string2 = TAG;
                    Log.e((String)string2, (String)object);
                    exception.printStackTrace();
                }
            }
        }
        bl3 = false;
        mediaCodec = null;
        if (!bl2) {
            this.CleanupDecoderCore(false);
        } else {
            Handler handler = this.m_cleanupHandler;
            object = new NvAndroidVideoFileReaderSW$2(this);
            handler.post((Runnable)object);
        }
        this.clearCueVideoFrameForPlayback();
        this.m_timestampOfLastDecodedFrame = l10 = Long.MIN_VALUE;
        this.m_timestampOfLastCopiedFrame = l10;
        this.m_pendingInputFrameCount = 0;
        this.m_sawInputEOS = false;
        this.m_sawOutputEOS = false;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    private void CleanupDecoderCore(boolean var1_1) {
        var2_2 = this.m_decoder;
        if (var2_2 == null) ** GOTO lbl36
        var3_4 = this.m_decoderStarted;
        if (!var3_4) ** GOTO lbl33
        var3_4 = this.m_inputBufferQueued;
        if (!var3_4) ** GOTO lbl15
        try {
            var2_2.flush();
        }
        catch (Exception v0) {
            ** continue;
        }
lbl12:
        // 2 sources

        while (true) {
            this.m_inputBufferQueued = false;
lbl15:
            // 2 sources

            var2_2 = this.m_decoder;
            try {
                var2_2.stop();
            }
            catch (Exception var2_3) {
                var4_5 /* !! */  = new StringBuilder();
                var4_5 /* !! */ .append("");
                var5_6 = var2_3.getMessage();
                var4_5 /* !! */ .append(var5_6);
                var4_5 /* !! */  = var4_5 /* !! */ .toString();
                var5_6 = "NvAndroidVideoFileReaderSW";
                Log.e((String)var5_6, (String)var4_5 /* !! */ );
                var2_3.printStackTrace();
            }
            this.m_decoderStarted = false;
            this.m_decoderInputBuffers = null;
lbl33:
            // 2 sources

            var2_2 = this.m_decoder;
            var2_2.release();
            this.m_decoder = null;
lbl36:
            // 2 sources

            if ((var2_2 = this.m_imageReader) != null) {
                var2_2.close();
                this.m_imageReader = null;
            }
            this.m_decoderUseSurface = false;
            return;
        }
    }

    private int DecodeToFrame(long l10, long l11, int n10) {
        try {
            return this.DoDecodeToFrame(l10, l11, n10);
        }
        catch (Exception exception) {
            CharSequence charSequence = new StringBuilder();
            charSequence.append("");
            String string2 = exception.getMessage();
            charSequence.append(string2);
            charSequence = charSequence.toString();
            Log.e((String)TAG, (String)charSequence);
            exception.printStackTrace();
            this.CleanupDecoder(false);
            return 2;
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private int DoDecodeToFrame(long var1_1, long var3_2, int var5_3) {
        var6_4 = this;
        var7_5 = var5_3;
        var8_6 = this.m_decoderInputBuffers.length;
        var9_7 = 3;
        var10_8 = 4.2E-45f;
        var11_9 = 2;
        var12_10 = 2.8E-45f;
        var13_11 = Math.max(var8_6 /= var9_7, var11_9);
        var14_12 /* !! */  = null;
        var8_6 = 0;
        var15_13 = null;
        var16_14 = 0.0f;
        while (true) {
            block44: {
                block48: {
                    block47: {
                        block45: {
                            block46: {
                                block43: {
                                    block41: {
                                        block42: {
                                            block38: {
                                                block40: {
                                                    block39: {
                                                        var17_15 = var6_4.m_sawOutputEOS;
                                                        var18_16 = -9223372036854775808L;
                                                        var20_17 = 1;
                                                        var21_18 = 1.4E-45f;
                                                        if (var17_15 != 0) break block39;
                                                        var17_15 = this.isInterruptedDecoding();
                                                        if (var17_15 != 0) {
                                                            return var9_7;
                                                        }
                                                        var17_15 = var6_4.m_sawInputEOS;
                                                        if (var17_15 != 0 || (var25_21 = (var22_19 /* !! */  = var6_4.m_decoder).dequeueInputBuffer(var23_20 = 4000L)) < 0) break block38;
                                                        break block40;
                                                    }
                                                    var28_24 = var20_17;
                                                    var31_26 = 0;
                                                    var15_13 = var6_4;
                                                    var7_5 = (int)(var1_1 == var18_16 ? 0 : (var1_1 < var18_16 ? -1 : 1));
                                                    if (var7_5 != 0 && (var7_5 = (int)((cfr_temp_0 = (var60_51 = var6_4.m_timestampOfLastCopiedFrame) - var18_16) == 0L ? 0 : (cfr_temp_0 < 0L ? -1 : 1))) != 0) {
                                                        var69_57 = var6_4.m_duration;
                                                        var71_58 = 100000L;
                                                        cfr_temp_1 = var60_51 - (var69_57 -= var71_58);
                                                        var7_5 = (int)(cfr_temp_1 == 0L ? 0 : (cfr_temp_1 < 0L ? -1 : 1));
                                                        if (var7_5 >= 0) {
                                                            return 0;
                                                        }
                                                    }
                                                    return var28_24;
                                                }
                                                var22_19 /* !! */  = var6_4.m_decoderInputBuffers[var25_21];
                                                while (true) {
                                                    if ((var27_23 = (var26_22 /* !! */  = var6_4.m_extractor).readSampleData((ByteBuffer)var22_19 /* !! */ , 0)) < 0) {
                                                        var22_19 /* !! */  = var6_4.m_decoder;
                                                        var28_24 = 0;
                                                        var27_23 = 0;
                                                        var29_25 = 0L;
                                                        var31_26 = 4;
                                                        var32_27 /* !! */  = var22_19 /* !! */ ;
                                                        var22_19 /* !! */ .queueInputBuffer(var25_21, 0, 0, var29_25, var31_26);
                                                        var6_4.m_sawInputEOS = var20_17;
                                                        break block38;
                                                    }
                                                    var26_22 /* !! */  = var6_4.m_extractor;
                                                    var33_28 = var26_22 /* !! */ .getSampleTrackIndex();
                                                    if (var33_28 != (var34_29 = var6_4.m_videoTrackIndex)) {
                                                        var26_22 /* !! */  = "NvAndroidVideoFileReaderSW";
                                                        var35_30 = new StringBuilder();
                                                        var35_30.append("WEIRD: got sample from track ");
                                                        var36_31 = var6_4.m_extractor.getSampleTrackIndex();
                                                        var35_30.append(var36_31);
                                                        var37_32 = ", expected ";
                                                        var35_30.append((String)var37_32);
                                                        var36_31 = var6_4.m_videoTrackIndex;
                                                        var35_30.append(var36_31);
                                                        var35_30 = var35_30.toString();
                                                        Log.w((String)var26_22 /* !! */ , (String)var35_30);
                                                    }
                                                    var26_22 /* !! */  = var6_4.m_extractor;
                                                    var23_20 = var26_22 /* !! */ .getSampleTime();
                                                    var37_32 = var6_4.m_extractor;
                                                    var36_31 = var37_32.getSampleFlags() & var20_17;
                                                    if (var36_31 != 0) {
                                                        var36_31 = var20_17;
                                                    } else {
                                                        var36_31 = 0;
                                                        var37_32 = null;
                                                    }
                                                    if (var7_5 == var20_17 || var7_5 == var11_9 && (var38_33 = (cfr_temp_2 = var23_20 - (var29_25 = var1_1 - var3_2)) == 0L ? 0 : (cfr_temp_2 < 0L ? -1 : 1)) < 0) {
                                                        var38_33 = var20_17;
                                                    } else {
                                                        var38_33 = 0;
                                                        var32_27 /* !! */  = null;
                                                    }
                                                    if (var38_33 != 0 && (var38_33 = (int)super.isNonReferenceFrame((ByteBuffer)var22_19 /* !! */ )) != 0) {
                                                        var26_22 /* !! */  = var6_4.m_extractor;
                                                        var26_22 /* !! */ .advance();
                                                        var6_4.m_extractorInOriginalState = false;
                                                        continue;
                                                    }
                                                    if ((var36_31 = super.canSkipFrameForCuePlayback(var23_20, (boolean)var36_31)) == 0) break;
                                                    var6_4.m_extractor.advance();
                                                    var6_4.m_extractorInOriginalState = false;
                                                    var37_32 = var6_4.m_listPlaybackCueFrame;
                                                    if (var37_32 != null && (var36_31 = (int)var37_32.isEmpty()) == 0) {
                                                        var37_32 = (NvAndroidVideoFileReaderSW$CueVideoFrameInfo)var6_4.m_listPlaybackCueFrame.get(0);
                                                    } else {
                                                        var36_31 = 0;
                                                        var37_32 = null;
                                                    }
                                                    if (var37_32 == null || (var33_28 = (int)((cfr_temp_3 = (var23_20 = (var39_34 = var37_32.cueVideoFrameTimeStamp) - var23_20) - (var41_35 = 2000000L)) == 0L ? 0 : (cfr_temp_3 < 0L ? -1 : 1))) <= 0) continue;
                                                    super.SeekExtractor(var39_34);
                                                }
                                                var22_19 /* !! */  = var6_4.m_decoder;
                                                var28_24 = 0;
                                                var31_26 = 0;
                                                var32_27 /* !! */  = var22_19 /* !! */ ;
                                                var29_25 = var23_20;
                                                var22_19 /* !! */ .queueInputBuffer(var25_21, 0, var27_23, var23_20, 0);
                                                var6_4.m_inputBufferQueued = var20_17;
                                                var6_4.m_pendingInputFrameCount = var17_15 = var6_4.m_pendingInputFrameCount + var20_17;
                                                var22_19 /* !! */  = var6_4.m_extractor;
                                                var22_19 /* !! */ .advance();
                                                var6_4.m_extractorInOriginalState = false;
                                            }
                                            if ((var17_15 = var6_4.m_pendingInputFrameCount) <= var13_11 && (var17_15 = (int)var6_4.m_sawInputEOS) == 0) {
                                                var17_15 = 0;
                                                var22_19 /* !! */  = null;
                                            } else {
                                                var17_15 = 4000;
                                            }
                                            var43_36 /* !! */  = var6_4.m_decoder;
                                            var44_37 /* !! */  = var6_4.m_bufferInfo;
                                            var23_20 = var17_15;
                                            var36_31 = var43_36 /* !! */ .dequeueOutputBuffer(var44_37 /* !! */ , var23_20);
                                            var8_6 += var20_17;
                                            var17_15 = -1;
                                            if (var36_31 == var17_15) break block41;
                                            var17_15 = -3;
                                            if (var36_31 != var17_15) break block42;
                                            var22_19 /* !! */  = var6_4.m_decoder.getOutputBuffers();
                                            var6_4.m_decoderOutputBuffers = var22_19 /* !! */ ;
                                            break block41;
                                        }
                                        var17_15 = -2;
                                        if (var36_31 != var17_15) break block43;
                                        var22_19 /* !! */  = var6_4.m_decoder.getOutputFormat();
                                        var6_4.ParseMediaFormat(var22_19 /* !! */ );
                                    }
                                    var7_5 = var8_6;
                                    var31_26 = 0;
                                    var45_38 = var13_11;
                                    var46_39 = var11_9;
                                    var47_40 = var12_10;
                                    var48_41 = var9_7;
                                    var49_42 = var10_8;
                                    var15_13 = var6_4;
                                    break block44;
                                }
                                if (var36_31 < 0) {
                                    var15_13 = new StringBuilder();
                                    var15_13.append("Unexpected result from decoder.dequeueOutputBuffer: ");
                                    var15_13.append(var36_31);
                                    var15_13 = var15_13.toString();
                                    Log.e((String)"NvAndroidVideoFileReaderSW", (String)var15_13);
                                    return var11_9;
                                }
                                var22_19 /* !! */  = var6_4.m_bufferInfo;
                                var50_43 = var22_19 /* !! */ .flags & 4;
                                if (var50_43 != 0) {
                                    var6_4.m_sawOutputEOS = var20_17;
                                }
                                if ((var33_28 = var22_19 /* !! */ .size) == 0) break block45;
                                var6_4.m_timestampOfLastDecodedFrame = var39_34 = var22_19 /* !! */ .presentationTimeUs;
                                var6_4.m_pendingInputFrameCount = var8_6 = var6_4.m_pendingInputFrameCount - var20_17;
                                var8_6 = (int)(var1_1 == var18_16 ? 0 : (var1_1 < var18_16 ? -1 : 1));
                                if (var8_6 == 0) break block46;
                                var18_16 = var1_1 - var3_2;
                                cfr_temp_4 = var39_34 - var18_16;
                                var8_6 = (int)(cfr_temp_4 == 0L ? 0 : (cfr_temp_4 < 0L ? -1 : 1));
                                if (var8_6 >= 0) {
                                    var8_6 = var20_17;
                                    var16_14 = var21_18;
                                } else {
                                    var8_6 = 0;
                                    var15_13 = null;
                                    var16_14 = 0.0f;
                                }
                                if (var8_6 != 0) ** GOTO lbl-1000
                                var18_16 = var6_4.m_duration;
                                var51_44 = 100000L;
                                cfr_temp_5 = var39_34 - (var18_16 -= var51_44);
                                var50_43 = (int)(cfr_temp_5 == 0L ? 0 : (cfr_temp_5 < 0L ? -1 : 1));
                                if (var50_43 >= 0) {
                                    var8_6 = var20_17;
                                    var16_14 = var21_18;
                                    var50_43 = var20_17;
                                } else lbl-1000:
                                // 2 sources

                                {
                                    var50_43 = 0;
                                    var43_36 /* !! */  = null;
                                }
                                var53_45 = (int)var6_4.m_onlyDecodeKeyFrame;
                                if (var53_45 != 0) {
                                    var54_46 = var50_43;
                                    var34_29 = var20_17;
                                    var55_47 = var21_18;
                                } else {
                                    var34_29 = var8_6;
                                    var55_47 = var16_14;
                                    var54_46 = var50_43;
                                }
                                var27_23 = 0;
                                break block47;
                            }
                            var34_29 = var20_17;
                            var55_47 = var21_18;
                            var27_23 = 0;
                            var54_46 = 0;
                            break block47;
                        }
                        var27_23 = var8_6;
                        var34_29 = 0;
                        var35_30 = null;
                        var55_47 = 0.0f;
                        var54_46 = 0;
                    }
                    var8_6 = (int)var6_4.m_decoderUseSurface;
                    if (var8_6 != 0) break block48;
                    if (var34_29 != 0) {
                        var39_34 = var6_4.m_owner;
                        var56_48 = var6_4.m_decoderOutputBuffers[var36_31];
                        var57_49 = var22_19 /* !! */ .offset;
                        var51_44 = var58_50 = var6_4.m_timestampOfLastDecodedFrame;
                        var15_13 = this;
                        var60_51 = var39_34;
                        var44_37 /* !! */  = var56_48;
                        var62_52 = var57_49;
                        var57_49 = var33_28;
                        var20_17 = var34_29;
                        var21_18 = var55_47;
                        var23_20 = var58_50;
                        this.nativeCopyVideoFrame(var39_34, var56_48, var62_52, var33_28, var58_50);
                        var6_4.m_timestampOfLastCopiedFrame = var58_50 = var6_4.m_timestampOfLastDecodedFrame;
                    } else {
                        var20_17 = var34_29;
                        var21_18 = var55_47;
                    }
                    var15_13 = var6_4.m_decoder;
                    var15_13.releaseOutputBuffer(var36_31, false);
                    var7_5 = var20_17;
                    ** GOTO lbl318
                }
                var8_6 = var34_29;
                var16_14 = var55_47;
                if (var34_29 != 0) {
                    var22_19 /* !! */  = var6_4.m_frameSyncObject;
                    synchronized (var22_19 /* !! */ ) {
                        var6_4.m_imageReady = false;
                    }
                }
                var22_19 /* !! */  = var6_4.m_decoder;
                var22_19 /* !! */ .releaseOutputBuffer(var36_31, (boolean)var8_6);
                if (var8_6 != 0) {
                    var64_53 = this.AwaitNewImage();
                    if (var64_53 == null) {
                        var46_39 = var11_9;
                        var47_40 = var12_10;
                        var15_13 = var6_4;
                        Log.e((String)"NvAndroidVideoFileReaderSW", (String)"Render decoded frame to ImageReader failed!");
                        return var11_9;
                    }
                    var17_15 = var64_53.getWidth();
                    var50_43 = var64_53.getHeight();
                    var53_45 = Build.VERSION.SDK_INT;
                    var62_52 = 21;
                    if (var53_45 >= var62_52) {
                        var22_19 /* !! */  = var64_53.getCropRect();
                        var26_22 /* !! */  = var22_19 /* !! */ ;
                    } else {
                        var44_37 /* !! */  = new Rect(0, 0, var17_15, var50_43);
                        var26_22 /* !! */  = var44_37 /* !! */ ;
                    }
                    var37_32 = var64_53.getPlanes();
                    var17_15 = ((Object)var37_32).length;
                    if (var17_15 == var9_7) {
                        var60_51 = var6_4.m_owner;
                        var53_45 = var26_22 /* !! */ .left;
                        var62_52 = var26_22 /* !! */ .top;
                        var57_49 = var26_22 /* !! */ .right;
                        var33_28 = var26_22 /* !! */ .bottom;
                        var35_30 = var37_32[0].getBuffer();
                        var36_31 = var37_32[0].getRowStride();
                        var38_33 = var37_32[0].getPixelStride();
                        var28_24 = var20_17;
                        var20_17 = var38_33;
                        var32_27 /* !! */  = var37_32[var28_24].getBuffer();
                        var31_26 = 0;
                        var14_12 /* !! */  = var32_27 /* !! */ ;
                        var38_33 = var37_32[var28_24].getRowStride();
                        var45_38 = var13_11;
                        var13_11 = var38_33;
                        var38_33 = var37_32[var28_24].getPixelStride();
                        var46_39 = var11_9;
                        var47_40 = var12_10;
                        var11_9 = var38_33;
                        var32_27 /* !! */  = var37_32[var46_39].getBuffer();
                        var48_41 = var9_7;
                        var49_42 = var10_8;
                        var65_54 /* !! */  = var32_27 /* !! */ ;
                        var32_27 /* !! */  = var37_32[var46_39];
                        var38_33 = var32_27 /* !! */ .getRowStride();
                        var22_19 /* !! */  = var6_4;
                        var66_55 = var38_33;
                        var43_36 /* !! */  = var37_32[var46_39];
                        var38_33 = var43_36 /* !! */ .getPixelStride();
                        var50_43 = var8_6;
                        var67_56 = var6_4.m_timestampOfLastDecodedFrame;
                        var7_5 = var8_6;
                        var15_13 = this;
                        this.nativeCopyVideoFrameFromYUV420ImagePlanes(var60_51, var53_45, var62_52, var57_49, var33_28, (ByteBuffer)var35_30, var36_31, var20_17, (ByteBuffer)var14_12 /* !! */ , var13_11, var11_9, (ByteBuffer)var65_54 /* !! */ , var66_55, var38_33, var67_56);
                        this.m_timestampOfLastCopiedFrame = var60_51 = this.m_timestampOfLastDecodedFrame;
                    } else {
                        var7_5 = var8_6;
                        var31_26 = 0;
                        var45_38 = var13_11;
                        var46_39 = var11_9;
                        var47_40 = var12_10;
                        var48_41 = var9_7;
                        var49_42 = var10_8;
                        var15_13 = var6_4;
                    }
                    var64_53.close();
                } else {
                    var7_5 = var8_6;
lbl318:
                    // 2 sources

                    var31_26 = 0;
                    var45_38 = var13_11;
                    var46_39 = var11_9;
                    var47_40 = var12_10;
                    var48_41 = var9_7;
                    var49_42 = var10_8;
                    var15_13 = var6_4;
                }
                if (var7_5 != 0 && var54_46 == 0) {
                    return 0;
                }
                var7_5 = var27_23;
            }
            var17_15 = var15_13.m_videoDecodeRetryMaxCount;
            if (var7_5 > var17_15) {
                Log.e((String)"NvAndroidVideoFileReaderSW", (String)"We have tried too many times and can't decode a frame!");
                return var46_39;
            }
            var6_4 = var15_13;
            var14_12 /* !! */  = null;
            var13_11 = var45_38;
            var11_9 = var46_39;
            var12_10 = var47_40;
            var9_7 = var48_41;
            var10_8 = var49_42;
            var8_6 = var7_5;
            var7_5 = var5_3;
        }
    }

    private void DrainOutputBuffers() {
        boolean bl2 = this.m_sawInputEOS;
        if (bl2 && !(bl2 = this.m_sawOutputEOS)) {
            int n10;
            bl2 = false;
            CharSequence charSequence = null;
            int n11 = 0;
            MediaCodec.BufferInfo bufferInfo = null;
            while ((n10 = this.m_sawOutputEOS) == 0) {
                MediaCodec mediaCodec = this.m_decoder;
                MediaCodec.BufferInfo bufferInfo2 = this.m_bufferInfo;
                long l10 = 5000L;
                n10 = mediaCodec.dequeueOutputBuffer(bufferInfo2, l10);
                int n12 = 1;
                n11 += n12;
                int n13 = -1;
                String string2 = TAG;
                if (n10 != n13 && n10 != (n13 = -3) && n10 != (n13 = -2)) {
                    if (n10 < 0) {
                        charSequence = new StringBuilder();
                        ((StringBuilder)charSequence).append("DrainDecoderBuffers(): Unexpected result from decoder.dequeueOutputBuffer: ");
                        ((StringBuilder)charSequence).append(n10);
                        charSequence = ((StringBuilder)charSequence).toString();
                        Log.e((String)string2, (String)charSequence);
                        return;
                    }
                    bufferInfo = this.m_bufferInfo;
                    n11 = bufferInfo.flags & 4;
                    if (n11 != 0) {
                        this.m_sawOutputEOS = n12;
                    }
                    this.m_decoder.releaseOutputBuffer(n10, false);
                    n11 = 0;
                    bufferInfo = null;
                }
                if (n11 <= (n10 = 100)) continue;
                charSequence = "DrainDecoderBuffers(): We have tried too many times and can't decode a frame!";
                Log.e((String)string2, (String)charSequence);
                break;
            }
        }
    }

    private void InvalidLastSeekTimestamp() {
        long l10;
        this.m_lastSeekTimestamp = l10 = Long.MIN_VALUE;
        this.m_lastSeekActualTimestamp = l10;
    }

    private boolean IsValid() {
        boolean bl2;
        MediaCodec mediaCodec = this.m_decoder;
        if (mediaCodec != null) {
            bl2 = true;
        } else {
            bl2 = false;
            mediaCodec = null;
        }
        return bl2;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    private void ParseMediaFormat(MediaFormat var1_1) {
        block8: {
            block9: {
                var2_2 = this;
                var3_3 /* !! */  = var1_1;
                var4_4 = "width";
                var5_5 = var1_1.containsKey((String)var4_4);
                if (var5_5 == 0 || (var7_7 = var1_1.containsKey(var6_6 = "height")) == 0 || (var9_9 = var1_1.containsKey((String)(var8_8 = "color-format"))) == 0) break block8;
                var10_10 = var1_1.getInteger((String)var4_4);
                var5_5 = var1_1.getInteger(var6_6);
                var7_7 = var1_1.getInteger((String)var8_8);
                var9_9 = Build.VERSION.SDK_INT;
                var11_11 = 18;
                if (var9_9 >= var11_11) {
                    var12_12 = this.m_decoder.getName();
                    var13_13 = 25;
                    if (var7_7 == var13_13 && (var15_15 = (int)var12_12.equals(var14_14 = "OMX.k3.video.decoder.avc")) != 0) {
                        var7_7 = 2130706688;
                    }
                }
                var15_15 = var7_7;
                var8_8 = new StringBuilder();
                var8_8.append("ParseMediaFormat\uff1a");
                var8_8.append(var7_7);
                var8_8 = var8_8.toString();
                var14_14 = "NvAndroidVideoFileReaderSW";
                Log.e((String)var14_14, (String)var8_8);
                var8_8 = "slice-height";
                var16_16 = var3_3 /* !! */ .containsKey((String)var8_8);
                var7_7 = var16_16 != 0 ? var3_3 /* !! */ .getInteger((String)var8_8) : var5_5;
                var17_17 = "stride";
                var18_18 = var3_3 /* !! */ .containsKey(var17_17);
                var16_16 = var18_18 != 0 ? var3_3 /* !! */ .getInteger(var17_17) : var10_10;
                if (var9_9 < var11_11) ** GOTO lbl-1000
                var19_19 = var2_2.m_decoder.getName();
                var11_11 = (int)var19_19.startsWith((String)(var20_20 = "OMX.Nvidia."));
                if (var11_11 == 0) break block9;
                var7_7 = var7_7 + 15 & -16;
                ** GOTO lbl-1000
            }
            var20_20 = "OMX.SEC.avc.dec";
            var9_9 = (int)var19_19.startsWith((String)var20_20);
            if (var9_9 != 0) {
                var21_21 = var10_10;
                var18_18 = var5_5;
            } else lbl-1000:
            // 3 sources

            {
                var18_18 = var7_7;
                var21_21 = var16_16;
            }
            var8_8 = "crop-left";
            var9_9 = (int)var3_3 /* !! */ .containsKey((String)var8_8);
            var11_11 = 0;
            var20_20 = null;
            var22_22 = var9_9 != 0 ? (var7_7 = var3_3 /* !! */ .getInteger((String)var8_8)) : 0;
            var8_8 = "crop-right";
            var9_9 = (int)var3_3 /* !! */ .containsKey((String)var8_8);
            var16_16 = 1;
            var10_10 = var9_9 != 0 ? var3_3 /* !! */ .getInteger((String)var8_8) : (var10_10 -= var16_16);
            var23_23 = var10_10;
            var4_4 = "crop-top";
            var7_7 = (int)var3_3 /* !! */ .containsKey((String)var4_4);
            var24_24 = var7_7 != 0 ? (var10_10 = var3_3 /* !! */ .getInteger((String)var4_4)) : 0;
            var4_4 = "crop-bottom";
            var7_7 = (int)var3_3 /* !! */ .containsKey((String)var4_4);
            var25_25 = var7_7 != 0 ? (var10_10 = var3_3 /* !! */ .getInteger((String)var4_4)) : (var5_5 -= var16_16);
            var7_7 = var23_23 + 1 - var22_22;
            var9_9 = var25_25 + 1 - var24_24;
            var10_10 = 0;
            var4_4 = null;
            var6_6 = "hdr-static-info";
            var11_11 = (int)var3_3 /* !! */ .containsKey(var6_6);
            if (var11_11 != 0) {
                var4_4 = var3_3 /* !! */ .getByteBuffer(var6_6);
            }
            var26_26 = var4_4;
            var10_10 = 2;
            var6_6 = "color-range";
            var11_11 = (int)var3_3 /* !! */ .containsKey(var6_6);
            if (var11_11 != 0) {
                var10_10 = var3_3 /* !! */ .getInteger(var6_6);
            }
            var27_27 = var10_10;
            var4_4 = "color-standard";
            var5_5 = (int)var3_3 /* !! */ .containsKey((String)var4_4);
            var10_10 = var5_5 != 0 ? var3_3 /* !! */ .getInteger((String)var4_4) : var16_16;
            var6_6 = "color-transfer";
            var11_11 = (int)var3_3 /* !! */ .containsKey(var6_6);
            var28_28 = var11_11 != 0 ? var3_3 /* !! */ .getInteger(var6_6) : 3;
            var5_5 = 6;
            if ((var28_28 == var5_5 || var28_28 == (var5_5 = 7)) && (var5_5 = (int)var2_2.is10bitYUVFormat(var15_15)) == 0 && (var11_11 = (int)(var6_6 = Build.HARDWARE).contains(var20_20 = "kirin")) == 0 && (var11_11 = (int)var6_6.contains(var20_20 = "crosshatch")) == 0 && (var11_11 = (int)var6_6.contains(var20_20 = "qcom")) == 0) {
                var20_20 = new StringBuilder();
                var20_20.append("Change color transfer:");
                var20_20.append(var28_28);
                var3_3 /* !! */  = " to:";
                var20_20.append((String)var3_3 /* !! */ );
                var16_16 = 3;
                var20_20.append(var16_16);
                var17_17 = " and Standard:";
                var20_20.append(var17_17);
                var20_20.append(var10_10);
                var20_20.append((String)var3_3 /* !! */ );
                var28_28 = 1;
                var20_20.append(var28_28);
                var20_20.append(" for CPU:");
                var20_20.append(var6_6);
                var4_4 = var20_20.toString();
                Log.w((String)var14_14, (String)var4_4);
                var13_13 = var28_28;
                var29_29 = 3;
            } else {
                var29_29 = var28_28;
                var13_13 = var10_10;
            }
            var30_30 = var2_2.m_owner;
            var3_3 /* !! */  = this;
            var11_11 = var15_15;
            var15_15 = var29_29;
            var16_16 = var27_27;
            var2_2 = var26_26;
            this.nativeSetFormatInfo(var30_30, var7_7, var9_9, var11_11, var29_29, var13_13, var27_27, var18_18, var21_21, var22_22, var23_23, var24_24, var25_25, (ByteBuffer)var26_26);
        }
    }

    private int SeekExtractor(long l10) {
        this.m_extractor.seekTo(l10, 0);
        Object object = this.m_extractor;
        long l11 = object.getSampleTime();
        long l12 = 0L;
        Object object2 = l11 == l12 ? 0 : (l11 < l12 ? -1 : 1);
        if (object2 < 0) {
            l11 = this.m_duration;
            l12 = 100000L;
            long l13 = l10 - (l11 -= l12);
            object2 = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
            if (object2 < 0) {
                object = TAG;
                String string2 = "Try to recreate MediaExtractor!";
                Log.w((String)object, (String)string2);
                boolean bl2 = this.recreateMediaExtractor();
                if (!bl2) {
                    Log.e((String)object, (String)"Failed to recreate MediaExtractor!");
                    this.CloseFile();
                    return 2;
                }
                object = this.m_extractor;
                object.seekTo(l10, 0);
            }
        }
        return 0;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    private int SeekInternal(long var1_1, long var3_2, int var5_3) {
        block20: {
            var6_4 = this.m_timestampOfLastDecodedFrame;
            var8_5 = -9223372036854775808L;
            var10_6 = var6_4 == var8_5 ? 0 : (var6_4 < var8_5 ? -1 : 1);
            var11_7 = true;
            if (!(var10_6 != false && (var10_6 = var1_1 == var6_4 ? 0 : (var1_1 < var6_4 ? -1 : 1)) > 0 && (var14_9 = (int)((cfr_temp_0 = var1_1 - (var6_4 += (var12_8 = this.m_contiuousDecodingThreshold))) == 0L ? 0 : (cfr_temp_0 < 0L ? -1 : 1))) < 0 || (var14_9 = this.m_extractorInOriginalState) != 0 && (var14_9 = (cfr_temp_1 = var1_1 - (var6_4 = this.m_contiuousDecodingThreshold)) == 0L ? 0 : (cfr_temp_1 < 0L ? -1 : 1)) < 0)) {
                var11_7 = false;
            }
            if ((var14_9 = this.m_onlyDecodeKeyFrame) != 0) {
                var11_7 = false;
            }
            if (!var11_7) {
                block19: {
                    var14_9 = 2;
                    var15_10 /* !! */  = this.m_extractor;
                    var15_10 /* !! */ .seekTo(var1_1, 0);
                    var16_11 = this.m_sawInputEOS;
                    if (var16_11) break block19;
                    var16_11 = this.m_sawOutputEOS;
                    if (var16_11) break block19;
                    var16_11 = this.m_inputBufferQueued;
                    if (!var16_11) break block20;
                    var15_10 /* !! */  = this.m_decoder;
                    var15_10 /* !! */ .flush();
lbl27:
                    // 2 sources

                    while (true) {
                        this.m_inputBufferQueued = false;
                        this.m_pendingInputFrameCount = 0;
                        break;
                    }
                }
                try {
                    this.CleanupDecoder(false);
                    var15_10 /* !! */  = this.m_format;
                    var17_12 = "mime";
                }
                catch (Exception var18_13) {
                    var19_14 /* !! */  = new StringBuilder();
                    var19_14 /* !! */ .append("");
                    var20_15 = var18_13.getMessage();
                    var19_14 /* !! */ .append(var20_15);
                    var19_14 /* !! */  = var19_14 /* !! */ .toString();
                    Log.e((String)"NvAndroidVideoFileReaderSW", (String)var19_14 /* !! */ );
                    var18_13.printStackTrace();
                    return var14_9;
                }
                var15_10 /* !! */  = var15_10 /* !! */ .getString(var17_12);
                var10_6 = this.m_openFlags;
                var16_11 = this.SetupDecoder((String)var15_10 /* !! */ , (int)var10_6);
                if (!var16_11) {
                    return var14_9;
                }
            }
        }
        return this.DecodeToFrame(var1_1, var3_2, var5_3);
        catch (Exception v0) {
            ** continue;
        }
    }

    private boolean SetupDecoder(String string2, int n10) {
        boolean bl2 = this.preferDecodeToImageReader(string2);
        if (bl2 && (bl2 = this.setupDecoderWithImageReader(string2))) {
            return true;
        }
        return this.setupDecoderWithBuffers(string2, n10);
    }

    public static /* synthetic */ Object access$000(NvAndroidVideoFileReaderSW nvAndroidVideoFileReaderSW) {
        return nvAndroidVideoFileReaderSW.m_frameSyncObject;
    }

    public static /* synthetic */ boolean access$102(NvAndroidVideoFileReaderSW nvAndroidVideoFileReaderSW, boolean bl2) {
        nvAndroidVideoFileReaderSW.m_imageReady = bl2;
        return bl2;
    }

    public static /* synthetic */ void access$200(NvAndroidVideoFileReaderSW nvAndroidVideoFileReaderSW, boolean bl2) {
        nvAndroidVideoFileReaderSW.CleanupDecoderCore(bl2);
    }

    private boolean canSkipFrameForCuePlayback(long l10, boolean n10) {
        int n11;
        Object object = this.m_listPlaybackCueFrame;
        if (object != null && (n11 = ((ArrayList)object).isEmpty()) == 0) {
            Object object2;
            long l11;
            long l12;
            long l13;
            n11 = 0;
            object = null;
            ArrayList arrayList = this.m_listPlaybackCueFrame;
            int n12 = arrayList.isEmpty();
            if (!n12) {
                object = (NvAndroidVideoFileReaderSW$CueVideoFrameInfo)this.m_listPlaybackCueFrame.get(0);
            }
            n12 = 1;
            if (object != null && (l13 = (l12 = (l11 = ((NvAndroidVideoFileReaderSW$CueVideoFrameInfo)object).cueVideoFrameTimeStamp) - l10) == 0L ? 0 : (l12 < 0L ? -1 : 1)) > 0 && (l13 = (long)((NvAndroidVideoFileReaderSW$CueVideoFrameInfo)object).isKeyframe) != false) {
                long l14;
                long l15;
                if (n10 != 0 && (n10 = (l15 = (l14 = 50000L + l10) - l11) == 0L ? 0 : (l15 < 0L ? -1 : 1)) >= 0) {
                    ((NvAndroidVideoFileReaderSW$CueVideoFrameInfo)object).cueVideoFrameTimeStamp = l10;
                    this.m_listPlaybackCueFrame.set(0, object);
                    return false;
                }
                return n12 != 0;
            }
            object = this.m_listPlaybackCueFrame;
            n11 = ((ArrayList)object).size();
            if (n11 > n12 && n10 == 0) {
                long l16;
                object2 = (NvAndroidVideoFileReaderSW$CueVideoFrameInfo)this.m_listPlaybackCueFrame.get(0);
                object = (NvAndroidVideoFileReaderSW$CueVideoFrameInfo)this.m_listPlaybackCueFrame.get(n12);
                l11 = ((NvAndroidVideoFileReaderSW$CueVideoFrameInfo)object2).cueVideoFrameTimeStamp;
                long l17 = l10 - l11;
                Object object3 = l17 == 0L ? 0 : (l17 < 0L ? -1 : 1);
                if (object3 > 0 && (n10 = (int)(((NvAndroidVideoFileReaderSW$CueVideoFrameInfo)object2).isKeyframe ? 1 : 0)) != 0 && (n10 = (int)((l16 = l10 - (l11 = ((NvAndroidVideoFileReaderSW$CueVideoFrameInfo)object).cueVideoFrameTimeStamp)) == 0L ? 0 : (l16 < 0L ? -1 : 1))) < 0 && (n10 = (int)(((NvAndroidVideoFileReaderSW$CueVideoFrameInfo)object).isKeyframe ? 1 : 0)) != 0) {
                    this.m_listPlaybackCueFrame.remove(0);
                    return n12 != 0;
                }
            }
            while ((n10 = ((ArrayList)(object2 = this.m_listPlaybackCueFrame)).isEmpty()) == 0) {
                object2 = (NvAndroidVideoFileReaderSW$CueVideoFrameInfo)this.m_listPlaybackCueFrame.get(0);
                long l18 = ((NvAndroidVideoFileReaderSW$CueVideoFrameInfo)object2).cueVideoFrameTimeStamp;
                long l19 = l18 - l10;
                n10 = (int)(l19 == 0L ? 0 : (l19 < 0L ? -1 : 1));
                if (n10 >= 0) {
                    return false;
                }
                object2 = this.m_listPlaybackCueFrame;
                ((ArrayList)object2).remove(0);
            }
        }
        return false;
    }

    private boolean is10bitYUVFormat(int n10) {
        int n11 = 2141391882;
        return n10 == n11;
    }

    private boolean isInterruptedDecoding() {
        NvAndroidInterruptionChecker nvAndroidInterruptionChecker = this.m_interruptionChecker;
        if (nvAndroidInterruptionChecker == null) {
            return false;
        }
        return nvAndroidInterruptionChecker.isInterrupted();
    }

    private boolean isNonReferenceFrame(ByteBuffer byteBuffer) {
        byte by2;
        int n10;
        int n11;
        if (byteBuffer == null) {
            return false;
        }
        int n12 = byteBuffer.limit();
        if (n12 < (n11 = 5)) {
            return false;
        }
        byte[] byArray = new byte[n11];
        int n13 = byteBuffer.position();
        byteBuffer.get(byArray);
        byteBuffer.position(n13);
        int n14 = 4;
        n13 = byArray[n14] & 0x1F;
        byte by3 = byArray[0];
        if (!by3 && (n10 = byArray[by3 = 1]) == 0 && (n10 = byArray[2]) == 0 && (by2 = byArray[n10 = 3]) == by3 && n13 == by3 && (n14 = byArray[n14] >> n11 & n10) == 0) {
            return by3;
        }
        return false;
    }

    private native void nativeCopyVideoFrame(long var1, ByteBuffer var3, int var4, int var5, long var6);

    private native void nativeCopyVideoFrameFromYUV420ImagePlanes(long var1, int var3, int var4, int var5, int var6, ByteBuffer var7, int var8, int var9, ByteBuffer var10, int var11, int var12, ByteBuffer var13, int var14, int var15, long var16);

    private native void nativeSetFormatInfo(long var1, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, int var13, int var14, ByteBuffer var15);

    private boolean preferDecodeToImageReader(String string2) {
        String string3 = Build.MANUFACTURER;
        String string4 = "OPPO";
        boolean bl2 = string3.equals(string4);
        if (bl2 && (bl2 = (string3 = Build.MODEL).equals(string4 = "R15"))) {
            return string2.equals("video/mpeg2");
        }
        return false;
    }

    private int preloadInternal(long l10) {
        int n10 = this.IsValid();
        if (n10 == 0) {
            return 2;
        }
        long l11 = this.m_duration;
        long l12 = 1L;
        l10 = Math.min(l10, l11 -= l12);
        l11 = 0L;
        l10 = Math.max(l10, l11);
        long l13 = 0L;
        int n11 = 2;
        long l14 = l10;
        n10 = this.SeekInternal(l10, l13, n11);
        long l15 = Long.MIN_VALUE;
        if (n10 == 0) {
            l14 = this.m_timestampOfLastCopiedFrame;
            long l16 = l14 - l15;
            Object object = l16 == 0L ? 0 : (l16 < 0L ? -1 : 1);
            if (object != false) {
                this.m_preloadedTimestamp = l10;
            }
        } else {
            long l17;
            long l18;
            long l19;
            int n12 = 1;
            if (n10 == n12 && (n12 = (int)((l19 = (l10 = this.m_timestampOfLastCopiedFrame) - l15) == 0L ? 0 : (l19 < 0L ? -1 : 1))) == 0 && (l18 = (l17 = (l10 = this.m_timestampOfLastDecodedFrame) - l15) == 0L ? 0 : (l17 < 0L ? -1 : 1)) != false) {
                l15 = this.m_duration;
                l14 = 100000L;
                long l20 = l10 - (l15 -= l14);
                n12 = (int)(l20 == 0L ? 0 : (l20 < 0L ? -1 : 1));
                if (n12 < 0) {
                    n10 = 4;
                }
            }
        }
        return n10;
    }

    private boolean recreateMediaExtractor() {
        CharSequence charSequence;
        Object object;
        block12: {
            boolean bl2 = true;
            try {
                object = this.m_extractor;
            }
            catch (Exception exception) {
                long l10;
                charSequence = new StringBuilder();
                ((StringBuilder)charSequence).append("");
                String string2 = exception.getMessage();
                ((StringBuilder)charSequence).append(string2);
                charSequence = ((StringBuilder)charSequence).toString();
                Log.e((String)"NvAndroidVideoFileReaderSW", (String)charSequence);
                exception.printStackTrace();
                this.m_extractor = null;
                this.m_videoTrackIndex = -1;
                this.m_format = null;
                this.m_duration = l10 = 0L;
                this.m_actualDuration = l10;
                this.m_extractorInOriginalState = bl2;
                this.CloseFile();
                return false;
            }
            object.release();
            object = this.m_context;
            charSequence = this.m_videoFilePath;
            object = NvAndroidUtils.createMediaExtractorFromMediaFilePath((Context)object, (String)charSequence);
            this.m_extractor = object;
            if (object == null) break block12;
            this.clearCueVideoFrameForPlayback();
            object = this.m_extractor;
            int n10 = this.m_videoTrackIndex;
            object.selectTrack(n10);
            this.m_extractorInOriginalState = bl2;
            return bl2;
        }
        charSequence = "Failed to re-create media extractor!";
        object = new Exception((String)charSequence);
        throw object;
    }

    private boolean setupDecoderPixelFormatFor10Bit(String object) {
        boolean bl2;
        int n10;
        String string2;
        boolean bl3;
        block7: {
            String string3;
            boolean bl4;
            int bl32 = Build.VERSION.SDK_INT;
            bl3 = true;
            int n11 = 24;
            if (bl32 < n11) {
                return bl3;
            }
            int n12 = 30;
            if (bl32 >= n12 && !(bl4 = (string3 = Build.MANUFACTURER).equalsIgnoreCase(string2 = "OPPO"))) {
                return bl3;
            }
            boolean bl5 = false;
            string3 = null;
            try {
                string2 = MediaCodec.createDecoderByType((String)object);
                if (string2 != null) break block7;
                return false;
            }
            catch (IOException iOException) {
                iOException.printStackTrace();
                return false;
            }
        }
        MediaCodecInfo mediaCodecInfo = string2.getCodecInfo();
        object = mediaCodecInfo.getCapabilitiesForType((String)object).colorFormats;
        int n13 = ((Object)object).length;
        int n14 = 0;
        while (true) {
            n10 = 2135033992;
            if (n14 >= n13) break;
            Object object2 = object[n14];
            if (object2 == n10) {
                bl2 = bl3;
                break;
            }
            ++n14;
        }
        string2.release();
        if (!bl2) {
            Log.w((String)"NvAndroidVideoFileReaderSW", (String)"We can't decode to 10bit video if COLOR_FormatYUV420Flexible is not supported!");
            return bl3;
        }
        this.m_format.setInteger("color-format", n10);
        return bl3;
    }

    private boolean setupDecoderWithBuffers(String byteBufferArray, int n10) {
        CharSequence charSequence;
        int n11;
        block12: {
            n11 = 1;
            if ((n10 &= n11) > 0) {
                n10 = (int)(this.setupDecoderPixelFormatFor10Bit((String)byteBufferArray) ? 1 : 0);
                if (n10 != 0) break block12;
                return false;
            }
        }
        try {
            byteBufferArray = MediaCodec.createDecoderByType((String)byteBufferArray);
        }
        catch (Exception exception) {
            charSequence = new StringBuilder();
            charSequence.append("");
            String string2 = exception.getMessage();
            charSequence.append(string2);
            charSequence = charSequence.toString();
            Log.e((String)"NvAndroidVideoFileReaderSW", (String)charSequence);
            exception.printStackTrace();
            this.CleanupDecoder(false);
            return false;
        }
        this.m_decoder = byteBufferArray;
        charSequence = this.m_format;
        byteBufferArray.configure((MediaFormat)charSequence, null, null, 0);
        byteBufferArray = this.m_decoder;
        byteBufferArray.start();
        this.m_decoderStarted = n11;
        byteBufferArray = this.m_decoder;
        byteBufferArray = byteBufferArray.getInputBuffers();
        this.m_decoderInputBuffers = byteBufferArray;
        byteBufferArray = this.m_decoder;
        byteBufferArray = byteBufferArray.getOutputBuffers();
        this.m_decoderOutputBuffers = byteBufferArray;
        return n11 != 0;
    }

    /*
     * WARNING - void declaration
     */
    private boolean setupDecoderWithImageReader(String byteBufferArray) {
        void var10_13;
        boolean bl3;
        int n10;
        Object object;
        Object object2;
        int n11;
        int n12;
        String string2;
        block32: {
            string2 = "NvAndroidVideoFileReaderSW";
            n12 = Build.VERSION.SDK_INT;
            n11 = 19;
            if (n12 < n11) {
                return false;
            }
            object2 = MediaCodec.createDecoderByType((String)byteBufferArray);
            this.m_decoder = object2;
            object2 = object2.getCodecInfo();
            byteBufferArray = object2.getCapabilitiesForType((String)byteBufferArray);
            byteBufferArray = (ByteBuffer[])byteBufferArray.colorFormats;
            n12 = byteBufferArray.length;
            n11 = 0;
            object = null;
            while (true) {
                n10 = 2135033992;
                bl3 = true;
                if (n11 >= n12) break;
                MediaCodecInfo.CodecCapabilities object3 = byteBufferArray[n11];
                if (object3 == n10) {
                    boolean bl2 = bl3;
                    break block32;
                }
                ++n11;
                continue;
                break;
            }
            boolean bl2 = false;
            byteBufferArray = null;
        }
        n12 = 0;
        object2 = null;
        if (var10_13 == false) {
            byteBufferArray = "We can't decode to ImageReader if COLOR_FormatYUV420Flexible is not supported!";
            Log.w((String)string2, (String)byteBufferArray);
            byteBufferArray = this.m_decoder;
            byteBufferArray.release();
            this.m_decoder = null;
            return false;
        }
        try {
            byteBufferArray = this.m_format;
            object = "color-format";
        }
        catch (Exception exception) {
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("");
            object = exception.getMessage();
            ((StringBuilder)object2).append((String)object);
            object2 = ((StringBuilder)object2).toString();
            Log.e((String)string2, (String)object2);
            exception.printStackTrace();
            this.CleanupDecoder(false);
            return false;
        }
        byteBufferArray.setInteger((String)object, n10);
        byteBufferArray = this.m_format;
        object = "width";
        int n13 = byteBufferArray.getInteger((String)object);
        object = this.m_format;
        String string3 = "height";
        n11 = object.getInteger(string3);
        n10 = 35;
        byteBufferArray = ImageReader.newInstance((int)n13, (int)n11, (int)n10, (int)(bl3 ? 1 : 0));
        this.m_imageReader = byteBufferArray;
        object = new NvAndroidVideoFileReaderSW$1(this);
        string3 = this.m_handler;
        byteBufferArray.setOnImageAvailableListener((ImageReader.OnImageAvailableListener)object, (Handler)string3);
        byteBufferArray = this.m_decoder;
        object = this.m_format;
        string3 = this.m_imageReader;
        string3 = string3.getSurface();
        byteBufferArray.configure((MediaFormat)object, (Surface)string3, null, 0);
        byteBufferArray = this.m_decoder;
        byteBufferArray.start();
        this.m_decoderStarted = bl3;
        this.m_decoderUseSurface = bl3;
        byteBufferArray = this.m_decoder;
        byteBufferArray = byteBufferArray.getInputBuffers();
        this.m_decoderInputBuffers = byteBufferArray;
        return bl3;
    }

    public void CloseFile() {
        this.InvalidLastSeekTimestamp();
        boolean bl2 = true;
        this.CleanupDecoder(bl2);
        MediaExtractor mediaExtractor = this.m_extractor;
        if (mediaExtractor != null) {
            long l10;
            int n10;
            mediaExtractor.release();
            this.m_extractor = null;
            this.m_videoTrackIndex = n10 = -1;
            this.m_format = null;
            this.m_duration = l10 = 0L;
            this.m_actualDuration = l10;
            this.m_extractorInOriginalState = bl2;
            bl2 = false;
            this.m_onlyDecodeKeyFrame = false;
        }
        this.m_videoFilePath = null;
        this.m_context = null;
    }

    public int GetNextVideoFrameForPlayback() {
        int n10 = this.IsValid();
        if (n10 == 0) {
            return 1;
        }
        int n11 = this.m_skipNonReferenceFrameWhenPlayback;
        n10 = this.DecodeToFrame(Long.MIN_VALUE, 0L, n11);
        this.InvalidLastSeekTimestamp();
        return n10;
    }

    public boolean OpenFile(String object, Context object2, int n10, long l10, int n11) {
        boolean bl2;
        block20: {
            String string2;
            String string3;
            Object object3;
            String string4 = "frame-rate";
            int n13 = this.IsValid();
            String string5 = "NvAndroidVideoFileReaderSW";
            if (n13 != 0) {
                Log.e((String)string5, (String)"You can't call OpenFile() twice!");
                return false;
            }
            this.m_extractor = object3 = NvAndroidUtils.createMediaExtractorFromMediaFilePath((Context)object2, (String)object);
            if (object3 == null) {
                return false;
            }
            this.m_extractorInOriginalState = bl2 = true;
            this.m_videoFilePath = object;
            this.m_context = object2;
            this.m_openFlags = n11;
            int n14 = object3.getTrackCount();
            n13 = 0;
            object3 = null;
            while (true) {
                String string6;
                string3 = "mime";
                if (n13 >= n14) break;
                String string7 = this.m_extractor.getTrackFormat(n13).getString(string3);
                boolean bl3 = string7.startsWith(string6 = "video/");
                if (bl3) {
                    this.m_videoTrackIndex = n13;
                    break;
                }
                ++n13;
            }
            if ((n14 = this.m_videoTrackIndex) < 0) {
                object2 = new StringBuilder();
                ((StringBuilder)object2).append("Failed to find a video track from ");
                ((StringBuilder)object2).append((String)object);
                object = ((StringBuilder)object2).toString();
                Log.e((String)string5, (String)object);
                this.CloseFile();
                return false;
            }
            this.m_extractor.selectTrack(n14);
            object = this.m_extractor;
            n14 = this.m_videoTrackIndex;
            object = object.getTrackFormat(n14);
            this.m_format = object;
            n14 = Build.VERSION.SDK_INT;
            n13 = 16;
            if (n14 == n13) {
                object3 = "max-input-size";
                object.setInteger((String)object3, 0);
            }
            object = Build.HARDWARE;
            object3 = "qcom";
            boolean n12 = ((String)object).equals(object3);
            n13 = 23;
            if (n14 >= n13 && n10 >= 0 && !n12) {
                object2 = this.m_format;
                if (n10 <= 0) {
                    n10 = 120;
                }
                object3 = "operating-rate";
                object2.setInteger((String)object3, n10);
            }
            try {
                object2 = this.m_format;
                string2 = "durationUs";
            }
            catch (Exception exception) {
                object2 = new StringBuilder();
                ((StringBuilder)object2).append("");
                string2 = exception.getMessage();
                ((StringBuilder)object2).append(string2);
                object2 = ((StringBuilder)object2).toString();
                Log.e((String)string5, (String)object2);
                exception.printStackTrace();
                this.CloseFile();
                return false;
            }
            long l11 = object2.getLong(string2);
            this.m_duration = l11;
            this.m_actualDuration = l11;
            object2 = this.m_format;
            object2 = object2.getString(string3);
            if (!n12) break block20;
            object = this.m_format;
            boolean bl3 = object.containsKey(string4);
            if (!bl3) break block20;
            object = this.m_format;
            object.setInteger(string4, 0);
        }
        this.m_decoderSetupFailed = false;
        boolean bl4 = this.SetupDecoder((String)object2, n11);
        if (!bl4) {
            this.m_decoderSetupFailed = bl2;
            this.CloseFile();
            return false;
        }
        this.m_videoDecodeRetryMaxCount = 100;
        object = "x-vnd.on2.vp8";
        boolean bl5 = ((String)object2).contains((CharSequence)object);
        if (bl5) {
            int n12;
            this.m_videoDecodeRetryMaxCount = n12 = 500;
        }
        this.m_listPlaybackCueFrame = object = new Object();
        this.m_contiuousDecodingThreshold = l10;
        return bl2;
    }

    public int SeekVideoFrame(long l10, long l11) {
        long l12;
        long l13;
        long l14;
        long l15;
        long l16;
        Object object = this.IsValid();
        int n10 = 1;
        if (object == 0) {
            return n10;
        }
        long l17 = (l10 = Math.max(l10, 0L)) - (l16 = this.m_duration);
        object = l17 == 0L ? 0 : (l17 < 0L ? -1 : 1);
        if (object >= 0) {
            long l18 = this.m_actualDuration;
            long l19 = 25000L;
            long l20 = l10 - (l18 += l19);
            Object object2 = l20 == 0L ? 0 : (l20 < 0L ? -1 : 1);
            if (object2 < 0) {
                l10 = l16 - 1L;
            } else {
                return n10;
            }
        }
        if ((l15 = (l14 = (l13 = this.m_timestampOfLastCopiedFrame) - (l16 = Long.MIN_VALUE)) == 0L ? 0 : (l14 < 0L ? -1 : 1)) != false && (object = (Object)((l12 = (l13 = Math.abs(l10 - l13)) - l11) == 0L ? 0 : (l12 < 0L ? -1 : 1))) <= 0) {
            return 0;
        }
        this.clearCueVideoFrameForPlayback();
        object = this.m_onlyDecodeKeyFrame;
        int n11 = object != 0 ? 0 : (object = 2);
        int n12 = this.SeekInternal(l10, l11, n11);
        if (n12 == 0) {
            this.m_lastSeekTimestamp = l10;
            this.m_lastSeekActualTimestamp = l10 = this.m_timestampOfLastCopiedFrame;
        } else {
            this.InvalidLastSeekTimestamp();
        }
        return n12;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public int StartPlayback(long var1_1, long var3_2) {
        block7: {
            var5_3 /* !! */  = this.IsValid();
            var6_4 = 1;
            if (var5_3 /* !! */  == 0) {
                return var6_4;
            }
            cfr_temp_0 = (var1_1 = Math.max(var1_1, 0L)) - (var7_5 = this.m_actualDuration);
            var5_3 /* !! */  = (int)(cfr_temp_0 == 0L ? 0 : (cfr_temp_0 < 0L ? -1 : 1));
            if (var5_3 /* !! */  >= 0) {
                return var6_4;
            }
            var9_6 = this.m_duration;
            cfr_temp_1 = var1_1 - var9_6;
            var11_7 /* !! */  = (long)(cfr_temp_1 == 0L ? 0 : (cfr_temp_1 < 0L ? -1 : 1));
            if (var11_7 /* !! */  >= 0) {
                var1_1 = var9_6 - 1L;
            }
            if ((var12_8 /* !! */  = (cfr_temp_2 = (var9_6 = this.m_preloadedTimestamp) - (var7_5 = -9223372036854775808L)) == 0L ? 0 : (cfr_temp_2 < 0L ? -1 : 1)) == false) break block7;
            var5_3 /* !! */  = (int)(var1_1 == var9_6 ? 0 : (var1_1 < var9_6 ? -1 : 1));
            if (var5_3 /* !! */  >= 0 && (var12_8 /* !! */  = (cfr_temp_3 = var1_1 - (var9_6 = this.m_timestampOfLastCopiedFrame)) == 0L ? 0 : (cfr_temp_3 < 0L ? -1 : 1)) <= 0) {
                var1_1 = var9_6;
            }
            this.m_preloadedTimestamp = var7_5;
            ** GOTO lbl-1000
        }
        var9_6 = this.m_lastSeekTimestamp;
        cfr_temp_4 = var9_6 - var7_5;
        var12_8 /* !! */  = (long)(cfr_temp_4 == 0L ? 0 : (cfr_temp_4 < 0L ? -1 : 1));
        if (var12_8 /* !! */  != false && (var5_3 /* !! */  = (int)(var1_1 == var9_6 ? 0 : (var1_1 < var9_6 ? -1 : 1))) == 0 && (var11_7 /* !! */  = (cfr_temp_5 = (var9_6 = this.m_lastSeekActualTimestamp) - var7_5) == 0L ? 0 : (cfr_temp_5 < 0L ? -1 : 1)) != false) {
            var13_9 = var9_6;
        } else lbl-1000:
        // 2 sources

        {
            var13_9 = var1_1;
        }
        var1_1 = this.m_timestampOfLastCopiedFrame;
        var5_3 /* !! */  = (int)(var13_9 == var1_1 ? 0 : (var13_9 < var1_1 ? -1 : 1));
        if (var5_3 /* !! */  == 0 && (var15_10 = (cfr_temp_6 = var1_1 - (var9_6 = this.m_timestampOfLastDecodedFrame)) == 0L ? 0 : (cfr_temp_6 < 0L ? -1 : 1)) == false) {
            return 0;
        }
        this.clearCueVideoFrameForPlayback();
        var15_10 = this.SeekInternal(var13_9, var3_2, 2);
        this.InvalidLastSeekTimestamp();
        return (int)var15_10;
    }

    public void clearCueVideoFrameForPlayback() {
        ArrayList arrayList = this.m_listPlaybackCueFrame;
        if (arrayList != null) {
            arrayList.clear();
        }
    }

    public void cueVideoFrameForPlayback(long l10, boolean bl2) {
        Object object = this.m_listPlaybackCueFrame;
        boolean n10 = ((ArrayList)object).isEmpty();
        if (!n10) {
            long l11;
            long l12;
            long l13;
            object = this.m_listPlaybackCueFrame;
            int n11 = ((ArrayList)object).size() + -1;
            if ((object = (NvAndroidVideoFileReaderSW$CueVideoFrameInfo)((ArrayList)object).get(n11)) != null && (l13 = (l12 = (l11 = ((NvAndroidVideoFileReaderSW$CueVideoFrameInfo)object).cueVideoFrameTimeStamp) - l10) == 0L ? 0 : (l12 < 0L ? -1 : 1)) > 0) {
                return;
            }
        }
        object = new NvAndroidVideoFileReaderSW$CueVideoFrameInfo();
        ((NvAndroidVideoFileReaderSW$CueVideoFrameInfo)object).cueVideoFrameTimeStamp = l10;
        ((NvAndroidVideoFileReaderSW$CueVideoFrameInfo)object).isKeyframe = bl2;
        this.m_listPlaybackCueFrame.add(object);
    }

    public void enableOnlyDecodeKeyFrame(boolean bl2) {
        this.m_onlyDecodeKeyFrame = bl2;
    }

    public boolean hasDecoderSetupFailed() {
        return this.m_decoderSetupFailed;
    }

    public void preload(long l10) {
        int n10;
        long l11;
        String string2;
        int n11;
        int n12 = this.preloadInternal(l10);
        int n13 = 0;
        do {
            string2 = "NvAndroidVideoFileReaderSW";
            l11 = Long.MIN_VALUE;
            n10 = 4;
            if (n12 != n10) break;
            this.m_timestampOfLastDecodedFrame = l11;
            n12 = this.preloadInternal(l10);
            CharSequence charSequence = new StringBuilder();
            String string3 = "Try to preload! times=";
            charSequence.append(string3);
            charSequence.append(++n13);
            charSequence = charSequence.toString();
            Log.w((String)string2, (String)charSequence);
        } while (n13 < (n11 = 2));
        if (n12 == n10) {
            String string4 = "Try to recreate MediaExtractor after preload!";
            Log.w((String)string2, (String)string4);
            this.m_timestampOfLastDecodedFrame = l11;
        }
    }

    public void setActualDuration(long l10) {
        long l11 = this.m_duration;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object > 0) {
            this.m_actualDuration = l10;
        }
    }

    public void setInterruptionChecker(NvAndroidInterruptionChecker nvAndroidInterruptionChecker) {
        this.m_interruptionChecker = nvAndroidInterruptionChecker;
    }

    public void skipNonReferenceFrame(boolean bl2) {
        this.m_skipNonReferenceFrameWhenPlayback = bl2;
    }
}

