/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.SurfaceTexture
 *  android.graphics.SurfaceTexture$OnFrameAvailableListener
 *  android.media.MediaCodec
 *  android.media.MediaCodec$BufferInfo
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
import android.graphics.SurfaceTexture;
import android.media.MediaCodec;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.os.Build;
import android.os.Handler;
import android.util.Log;
import android.view.Surface;
import com.cdv.io.NvAndroidVideoFileReader$1;
import com.cdv.io.NvAndroidVideoFileReader$2;
import com.cdv.io.NvAndroidVideoFileReader$CueVideoFrameInfo;
import com.cdv.utils.NvAndroidInterruptionChecker;
import com.cdv.utils.NvAndroidUtils;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.concurrent.Semaphore;

public class NvAndroidVideoFileReader
implements SurfaceTexture.OnFrameAvailableListener {
    private static final int ERROR_EOF = 1;
    private static final int ERROR_FAIL = 2;
    private static final int ERROR_INTERRUPTED_DECODING = 3;
    private static final int ERROR_MEDIA_EXTRACTOR_PRELOAD_FAILED = 4;
    private static final int ERROR_OK = 0;
    private static final int SKIP_MODE_ALL_NONREFERENCE = 1;
    private static final int SKIP_MODE_ALL_NON_KEYFRAME = 3;
    private static final int SKIP_MODE_BELOW_TIMESTAMP = 2;
    private static final int SKIP_MODE_NONE = 0;
    private static final String TAG = "NvAndroidVideoFileReader";
    private static Method m_setOnFrameAvailableListener2;
    private static final boolean m_verbose = false;
    private long m_actualDuration;
    private MediaCodec.BufferInfo m_bufferInfo;
    private Handler m_cleanupHandler = null;
    private Context m_context;
    private long m_contiuousDecodingThreshold;
    private boolean m_curTexImageUpdated;
    private MediaCodec m_decoder;
    public ByteBuffer[] m_decoderInputBuffers;
    private boolean m_decoderSetupFailed;
    private boolean m_decoderStarted;
    private long m_duration;
    private MediaExtractor m_extractor = null;
    private boolean m_extractorInOriginalState;
    private boolean m_firstPlaybackTexFrameUnconsumed;
    private MediaFormat m_format;
    private boolean m_frameAvailable;
    private Object m_frameSyncObject;
    private Handler m_handler = null;
    private boolean m_inputBufferQueued;
    private NvAndroidInterruptionChecker m_interruptionChecker;
    private long m_lastSeekActualTimestamp;
    private long m_lastSeekTimestamp;
    private ArrayList m_listPlaybackCueFrame;
    private int m_pendingInputFrameCount;
    private long m_preloadedTimestamp;
    private boolean m_sawInputEOS;
    private boolean m_sawOutputEOS;
    private int m_skipModeWhenPlayback;
    private Surface m_surface;
    private SurfaceTexture m_surfaceTexture;
    private Semaphore m_surfaceTextureCreationSemaphore;
    private long m_temporalLayerEndTime;
    private int m_texId;
    private long m_timestampOfCurTexFrame;
    private long m_timestampOfLastDecodedFrame;
    private long m_timestampOfLastInputFrame;
    private int m_usedTemporalLayer;
    private int m_videoColorTransferCharacteristic;
    private int m_videoDecodeRetryMaxCount;
    private String m_videoFilePath;
    private int m_videoHDRMaxLuminance;
    private int m_videoTrackIndex;

    static {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 21;
        if (n10 >= n11) {
            Object object = SurfaceTexture.class;
            String string2 = "setOnFrameAvailableListener";
            int n12 = 2;
            Class[] classArray = new Class[n12];
            int n13 = 0;
            Class<SurfaceTexture.OnFrameAvailableListener> clazz = SurfaceTexture.OnFrameAvailableListener.class;
            classArray[0] = clazz;
            n13 = 1;
            clazz = Handler.class;
            classArray[n13] = clazz;
            object = ((Class)object).getDeclaredMethod(string2, classArray);
            m_setOnFrameAvailableListener2 = object;
            object = TAG;
            string2 = "New SurfaceTexture.setOnFrameAvailableListener() method is available!";
            try {
                Log.d((String)object, (String)string2);
            }
            catch (Exception exception) {
                n10 = 0;
                object = null;
                m_setOnFrameAvailableListener2 = null;
            }
        }
    }

    public NvAndroidVideoFileReader(Handler handler, Handler handler2) {
        long l10;
        Object object;
        long l11;
        int n10;
        this.m_videoTrackIndex = n10 = -1;
        this.m_format = null;
        this.m_duration = l11 = 0L;
        this.m_actualDuration = l11;
        this.m_extractorInOriginalState = true;
        this.m_surfaceTexture = null;
        this.m_surface = null;
        this.m_bufferInfo = null;
        this.m_decoder = null;
        this.m_decoderSetupFailed = false;
        this.m_decoderStarted = false;
        this.m_decoderInputBuffers = null;
        this.m_frameSyncObject = object = new Object();
        this.m_frameAvailable = false;
        this.m_timestampOfLastDecodedFrame = l10 = Long.MIN_VALUE;
        this.m_timestampOfCurTexFrame = l10;
        this.m_curTexImageUpdated = false;
        this.m_firstPlaybackTexFrameUnconsumed = false;
        this.m_sawOutputEOS = false;
        this.m_preloadedTimestamp = l10;
        this.m_lastSeekTimestamp = l10;
        this.m_lastSeekActualTimestamp = l10;
        this.m_usedTemporalLayer = n10;
        this.m_temporalLayerEndTime = -1;
        this.m_contiuousDecodingThreshold = 1500000L;
        this.m_inputBufferQueued = false;
        this.m_timestampOfLastInputFrame = l10;
        this.m_sawInputEOS = false;
        this.m_pendingInputFrameCount = 0;
        this.m_skipModeWhenPlayback = 0;
        this.m_videoColorTransferCharacteristic = 0;
        this.m_videoHDRMaxLuminance = 0;
        this.m_videoDecodeRetryMaxCount = 100;
        this.m_handler = handler;
        this.m_cleanupHandler = handler2;
        this.m_bufferInfo = handler;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private boolean AwaitNewImage(boolean bl2) {
        Object object;
        Object object2 = this.m_frameSyncObject;
        synchronized (object2) {
            boolean bl3;
            while (!(bl3 = this.m_frameAvailable)) {
                try {
                    object = this.m_frameSyncObject;
                    long l10 = 3000L;
                    object.wait(l10);
                    bl3 = this.m_frameAvailable;
                    if (bl3) continue;
                    String string2 = TAG;
                    object = "Frame wait timed out!";
                    Log.e((String)string2, (String)object);
                    return false;
                }
                catch (InterruptedException interruptedException) {
                    object = TAG;
                    CharSequence charSequence = new StringBuilder();
                    String string3 = "";
                    charSequence.append(string3);
                    string3 = interruptedException.getMessage();
                    charSequence.append(string3);
                    charSequence = charSequence.toString();
                    Log.e((String)object, (String)charSequence);
                    interruptedException.printStackTrace();
                    return false;
                }
            }
            this.m_frameAvailable = false;
        }
        if (!bl2) return true;
        try {
            SurfaceTexture surfaceTexture = this.m_surfaceTexture;
            surfaceTexture.updateTexImage();
            return true;
        }
        catch (Exception exception) {
            object = new StringBuilder();
            ((StringBuilder)object).append("");
            String string4 = exception.getMessage();
            ((StringBuilder)object).append(string4);
            object = ((StringBuilder)object).toString();
            Log.e((String)TAG, (String)object);
            exception.printStackTrace();
            return false;
        }
    }

    private void CleanupDecoder(boolean bl2) {
        long l10;
        Object object;
        block7: {
            boolean bl3;
            this.updateCurTexImage();
            object = this.m_decoder;
            if (object != null && (bl3 = this.m_decoderStarted)) {
                bl3 = this.m_sawInputEOS;
                if (!bl3) break block7;
                bl3 = this.m_sawOutputEOS;
                if (bl3) break block7;
                try {
                    this.DrainOutputBuffers(false);
                }
                catch (Exception exception) {
                    CharSequence charSequence = new StringBuilder();
                    charSequence.append("");
                    String string2 = exception.getMessage();
                    charSequence.append(string2);
                    charSequence = charSequence.toString();
                    string2 = TAG;
                    Log.e((String)string2, (String)charSequence);
                    exception.printStackTrace();
                }
            }
        }
        if (!bl2) {
            this.CleanupDecoderCore(false);
        } else {
            Handler handler = this.m_cleanupHandler;
            object = new NvAndroidVideoFileReader$2(this);
            handler.post((Runnable)object);
        }
        this.m_timestampOfLastDecodedFrame = l10 = Long.MIN_VALUE;
        this.m_timestampOfCurTexFrame = l10;
        this.m_firstPlaybackTexFrameUnconsumed = false;
        this.m_pendingInputFrameCount = 0;
        this.m_timestampOfLastInputFrame = l10;
        this.m_sawInputEOS = false;
        this.m_sawOutputEOS = false;
        this.clearCueVideoFrameForPlayback();
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    private void CleanupDecoderCore(boolean var1_1) {
        var2_2 = this.m_decoder;
        if (var2_2 == null) ** GOTO lbl37
        var3_4 = this.m_decoderStarted;
        if (!var3_4) ** GOTO lbl34
        var3_4 = false;
        var4_5 = this.m_inputBufferQueued;
        if (!var4_5) ** GOTO lbl16
        try {
            var2_2.flush();
        }
        catch (Exception v0) {
            ** continue;
        }
lbl13:
        // 2 sources

        while (true) {
            this.m_inputBufferQueued = false;
lbl16:
            // 2 sources

            var2_2 = this.m_decoder;
            try {
                var2_2.stop();
            }
            catch (Exception var2_3) {
                var5_6 /* !! */  = new StringBuilder();
                var5_6 /* !! */ .append("");
                var6_7 = var2_3.getMessage();
                var5_6 /* !! */ .append(var6_7);
                var5_6 /* !! */  = var5_6 /* !! */ .toString();
                var6_7 = "NvAndroidVideoFileReader";
                Log.e((String)var6_7, (String)var5_6 /* !! */ );
                var2_3.printStackTrace();
            }
            this.m_decoderStarted = false;
            this.m_decoderInputBuffers = null;
lbl34:
            // 2 sources

            var2_2 = this.m_decoder;
            var2_2.release();
            this.m_decoder = null;
lbl37:
            // 2 sources

            if (var1_1) {
                var7_8 = this.m_surface;
                if (var7_8 != null) {
                    var7_8.release();
                    this.m_surface = null;
                }
                if ((var7_8 = this.m_surfaceTexture) != null) {
                    var7_8.release();
                    this.m_surfaceTexture = null;
                }
            }
            this.clearCueVideoFrameForPlayback();
            return;
        }
    }

    private int DecodeToFrame(long l10, long l11, boolean bl2, int n10) {
        try {
            return this.DoDecodeToFrame(l10, l11, bl2, n10);
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
    private int DoDecodeToFrame(long var1_1, long var3_2, boolean var5_3, int var6_4) {
        var7_5 = this;
        var8_6 = var6_4;
        var9_7 = this.m_decoderInputBuffers;
        var10_8 = ((ByteBuffer[])var9_7).length;
        var11_9 = 3;
        var10_8 /= var11_9;
        var12_10 = 2;
        var10_8 = Math.max(var10_8, var12_10);
        var13_11 = 0;
        var14_12 /* !! */  = 0;
        var15_13 = 0.0f;
        var16_14 = 0;
        while (true) {
            block44: {
                block41: {
                    block46: {
                        block45: {
                            block40: {
                                block43: {
                                    block42: {
                                        var17_15 = var7_5.m_sawOutputEOS;
                                        var18_16 = 1;
                                        var19_17 = 1.4E-45f;
                                        if (var17_15 != 0) break block42;
                                        var17_15 = this.isInterruptedDecoding();
                                        if (var17_15 != 0) {
                                            Log.d((String)"NvAndroidVideoFileReader", (String)"Interrupted video Decoding ");
                                            return var11_9;
                                        }
                                        var17_15 = var7_5.m_sawInputEOS;
                                        if (var17_15 != 0 || (var23_20 = (var20_18 /* !! */  = var7_5.m_decoder).dequeueInputBuffer(var21_19 = 4000L)) < 0) break block40;
                                        break block43;
                                    }
                                    var48_39 = -9223372036854775808L;
                                    cfr_temp_0 = var1_1 - var48_39;
                                    var8_6 = (int)(cfr_temp_0 == 0L ? 0 : (cfr_temp_0 < 0L ? -1 : 1));
                                    if (var8_6 != 0 && (var8_6 = (int)((cfr_temp_1 = (var50_40 = var7_5.m_timestampOfCurTexFrame) - var48_39) == 0L ? 0 : (cfr_temp_1 < 0L ? -1 : 1))) != 0) {
                                        if (var13_11 != 0) {
                                            return 0;
                                        }
                                        var8_6 = (int)var7_5.m_sawInputEOS;
                                        if (var8_6 != 0 && (var8_6 = (int)((cfr_temp_2 = (var42_36 = var7_5.m_timestampOfLastInputFrame) - var48_39) == 0L ? 0 : (cfr_temp_2 < 0L ? -1 : 1))) != 0 && (var8_6 = (int)(var50_40 == var42_36 ? 0 : (var50_40 < var42_36 ? -1 : 1))) >= 0) {
                                            return 0;
                                        }
                                    }
                                    return var18_16;
                                }
                                var20_18 /* !! */  = var7_5.m_decoderInputBuffers[var23_20];
                                while (true) {
                                    if ((var25_22 = (var24_21 /* !! */  = var7_5.m_extractor).readSampleData((ByteBuffer)var20_18 /* !! */ , 0)) < 0) {
                                        var26_23 /* !! */  = var7_5.m_decoder;
                                        var27_24 = 0;
                                        var25_22 = 0;
                                        var28_25 = 0L;
                                        var30_26 = 4;
                                        var26_23 /* !! */ .queueInputBuffer(var23_20, 0, 0, var28_25, var30_26);
                                        var7_5.m_sawInputEOS = var18_16;
                                        break block40;
                                    }
                                    var24_21 /* !! */  = var7_5.m_extractor;
                                    var31_27 = var24_21 /* !! */ .getSampleTrackIndex();
                                    if (var31_27 != (var32_28 = var7_5.m_videoTrackIndex)) {
                                        var24_21 /* !! */  = "NvAndroidVideoFileReader";
                                        var33_29 /* !! */  = new StringBuilder();
                                        var33_29 /* !! */ .append("WEIRD: got sample from track ");
                                        var34_30 = var7_5.m_extractor.getSampleTrackIndex();
                                        var33_29 /* !! */ .append(var34_30);
                                        var26_23 /* !! */  = ", expected ";
                                        var33_29 /* !! */ .append((String)var26_23 /* !! */ );
                                        var34_30 = var7_5.m_videoTrackIndex;
                                        var33_29 /* !! */ .append(var34_30);
                                        var33_29 /* !! */  = var33_29 /* !! */ .toString();
                                        Log.w((String)var24_21 /* !! */ , (String)var33_29 /* !! */ );
                                    }
                                    var24_21 /* !! */  = var7_5.m_extractor;
                                    var21_19 = var24_21 /* !! */ .getSampleTime();
                                    var26_23 /* !! */  = var7_5.m_extractor;
                                    var34_30 = var26_23 /* !! */ .getSampleFlags() & var18_16;
                                    if (var34_30 != 0) {
                                        var34_30 = var18_16;
                                    } else {
                                        var34_30 = 0;
                                        var26_23 /* !! */  = null;
                                    }
                                    if (var34_30 != 0) ** GOTO lbl-1000
                                    if (var8_6 == var11_9) {
                                        var24_21 /* !! */  = var7_5.m_extractor;
                                        var24_21 /* !! */ .advance();
                                        var7_5.m_extractorInOriginalState = false;
                                    } else {
                                        var27_24 = (int)var7_5.canSkipFrame((ByteBuffer)var20_18 /* !! */ , var21_19);
                                        if (var27_24 != 0) {
                                            var24_21 /* !! */  = var7_5.m_extractor;
                                            var24_21 /* !! */ .advance();
                                            var7_5.m_extractorInOriginalState = false;
                                        } else lbl-1000:
                                        // 2 sources

                                        {
                                            var27_24 = var8_6 == var18_16 || var8_6 == var12_10 && (var27_24 = (cfr_temp_3 = var21_19 - (var28_25 = var1_1 - var3_2)) == 0L ? 0 : (cfr_temp_3 < 0L ? -1 : 1)) < 0 ? var18_16 : 0;
                                            if (var27_24 != 0 && (var27_24 = (int)var7_5.isNonReferenceFrame((ByteBuffer)var20_18 /* !! */ )) != 0) {
                                                var24_21 /* !! */  = var7_5.m_extractor;
                                                var24_21 /* !! */ .advance();
                                                var7_5.m_extractorInOriginalState = false;
                                            } else {
                                                if ((var34_30 = var7_5.canSkipFrameForCuePlayback(var21_19, (boolean)var34_30)) == 0) break;
                                                var7_5.m_extractor.advance();
                                                var7_5.m_extractorInOriginalState = false;
                                                var34_30 = 0;
                                                var26_23 /* !! */  = null;
                                                var35_31 /* !! */  = var7_5.m_listPlaybackCueFrame;
                                                if (var35_31 /* !! */  != null && (var11_9 = (int)var35_31 /* !! */ .isEmpty()) == 0) {
                                                    var35_31 /* !! */  = var7_5.m_listPlaybackCueFrame.get(0);
                                                    var26_23 /* !! */  = var35_31 /* !! */ ;
                                                    var26_23 /* !! */  = (NvAndroidVideoFileReader$CueVideoFrameInfo)var35_31 /* !! */ ;
                                                }
                                                if (var16_14 < var18_16 && var26_23 /* !! */  != null && (var11_9 = (int)((cfr_temp_4 = (var21_19 = (var36_32 = var26_23 /* !! */ .cueVideoFrameTimeStamp) - var21_19) - (var38_33 = 2000000L)) == 0L ? 0 : (cfr_temp_4 < 0L ? -1 : 1))) > 0) {
                                                    var21_19 = 5000L;
                                                    var7_5.SeekExtractor(var36_32 += var21_19);
                                                    ++var16_14;
                                                }
                                            }
                                        }
                                    }
                                    var11_9 = 3;
                                }
                                var7_5.m_timestampOfLastInputFrame = var21_19;
                                var26_23 /* !! */  = var7_5.m_decoder;
                                var27_24 = 0;
                                var30_26 = 0;
                                var28_25 = var21_19;
                                var26_23 /* !! */ .queueInputBuffer(var23_20, 0, var25_22, var21_19, 0);
                                var7_5.m_inputBufferQueued = var18_16;
                                var7_5.m_pendingInputFrameCount = var11_9 = var7_5.m_pendingInputFrameCount + var18_16;
                                var35_31 /* !! */  = var7_5.m_extractor;
                                var35_31 /* !! */ .advance();
                                var7_5.m_extractorInOriginalState = false;
                                var16_14 = 0;
                            }
                            if ((var11_9 = var7_5.m_pendingInputFrameCount) <= var10_8 && (var11_9 = (int)var7_5.m_sawInputEOS) == 0) {
                                var11_9 = 0;
                                var35_31 /* !! */  = null;
                            } else {
                                var11_9 = 4000;
                            }
                            var20_18 /* !! */  = var7_5.m_decoder;
                            var40_34 /* !! */  = var7_5.m_bufferInfo;
                            var21_19 = var11_9;
                            var11_9 = var20_18 /* !! */ .dequeueOutputBuffer(var40_34 /* !! */ , var21_19);
                            var14_12 /* !! */  += var18_16;
                            var17_15 = -1;
                            if (var11_9 == var17_15 || var11_9 == (var17_15 = -3)) break block44;
                            var17_15 = -2;
                            if (var11_9 != var17_15) break block45;
                            var35_31 /* !! */  = var7_5.m_decoder.getOutputFormat();
                            var17_15 = (int)var35_31 /* !! */ .containsKey((String)(var20_18 /* !! */  = "color-transfer"));
                            if (var17_15 != 0) {
                                var20_18 /* !! */  = "color-transfer";
                                var7_5.m_videoColorTransferCharacteristic = var17_15 = var35_31 /* !! */ .getInteger((String)var20_18 /* !! */ );
                            }
                            if ((var17_15 = (int)var35_31 /* !! */ .containsKey((String)(var20_18 /* !! */  = "hdr-static-info"))) != 0) {
                                var20_18 /* !! */  = "hdr-static-info";
                                var35_31 /* !! */  = var35_31 /* !! */ .getByteBuffer((String)var20_18 /* !! */ );
                                var7_5.m_videoHDRMaxLuminance = var11_9 = var7_5.extractHDRMaxLuminance((ByteBuffer)var35_31 /* !! */ );
                            }
                            break block44;
                        }
                        if (var11_9 < 0) {
                            var9_7 = new StringBuilder();
                            var9_7.append("Unexpected result from decoder.dequeueOutputBuffer: ");
                            var9_7.append(var11_9);
                            var9_7 = var9_7.toString();
                            Log.e((String)"NvAndroidVideoFileReader", (String)var9_7);
                            return var12_10;
                        }
                        var20_18 /* !! */  = var7_5.m_bufferInfo;
                        var41_35 = var20_18 /* !! */ .flags & 4;
                        if (var41_35 != 0) {
                            var7_5.m_sawOutputEOS = var18_16;
                        }
                        if ((var41_35 = (int)var7_5.m_sawOutputEOS) != 0) break block46;
                        var7_5.m_timestampOfLastDecodedFrame = var42_36 = var20_18 /* !! */ .presentationTimeUs;
                        var7_5.m_pendingInputFrameCount = var14_12 /* !! */  = var7_5.m_pendingInputFrameCount - var18_16;
                        var21_19 = -9223372036854775808L;
                        cfr_temp_5 = var1_1 - var21_19;
                        var14_12 /* !! */  = (int)(cfr_temp_5 == 0L ? 0 : (cfr_temp_5 < 0L ? -1 : 1));
                        if (var14_12 /* !! */  != 0) {
                            var21_19 = var1_1 - var3_2;
                            cfr_temp_6 = var42_36 - var21_19;
                            var14_12 /* !! */  = (int)(cfr_temp_6 == 0L ? 0 : (cfr_temp_6 < 0L ? -1 : 1));
                            if (var14_12 /* !! */  >= 0) {
                                var14_12 /* !! */  = var18_16;
                                var15_13 = var19_17;
                            } else {
                                var14_12 /* !! */  = 0;
                                var15_13 = 0.0f;
                            }
                            if (var14_12 /* !! */  == 0 && (var44_37 /* !! */  = var7_5.m_sawInputEOS) && !var5_3) {
                                var21_19 = var7_5.m_timestampOfLastInputFrame;
                                var45_38 = -9223372036854775808L;
                                cfr_temp_7 = var21_19 - var45_38;
                                var44_37 /* !! */  = cfr_temp_7 == 0L ? 0 : (cfr_temp_7 < 0L ? -1 : 1);
                                if (var44_37 /* !! */  && (var17_15 = (int)(var42_36 == var21_19 ? 0 : (var42_36 < var21_19 ? -1 : 1))) >= 0) {
                                    var13_11 = var18_16;
                                    var14_12 /* !! */  = var18_16;
                                    var15_13 = var19_17;
                                } else {
                                    var18_16 = 0;
                                    var19_17 = 0.0f;
                                }
                                var17_15 = var18_16;
                                var18_16 = var14_12 /* !! */ ;
                                var19_17 = var15_13;
                                var14_12 /* !! */  = 0;
                                var15_13 = 0.0f;
                                break block41;
                            } else {
                                var17_15 = 0;
                                var20_18 /* !! */  = null;
                                var18_16 = var14_12 /* !! */ ;
                                var19_17 = var15_13;
                                var14_12 /* !! */  = 0;
                                var15_13 = 0.0f;
                            }
                            break block41;
                        } else {
                            var14_12 /* !! */  = 0;
                            var15_13 = 0.0f;
                            var17_15 = 0;
                            var20_18 /* !! */  = null;
                        }
                        break block41;
                    }
                    var17_15 = 0;
                    var20_18 /* !! */  = null;
                    var18_16 = 0;
                    var19_17 = 0.0f;
                }
                if (var18_16 != 0) {
                    if (!var5_3) {
                        this.updateCurTexImage();
                    }
                    var40_34 /* !! */  = var7_5.m_frameSyncObject;
                    synchronized (var40_34 /* !! */ ) {
                        var7_5.m_frameAvailable = false;
                    }
                }
                var40_34 /* !! */  = var7_5.m_decoder;
                var40_34 /* !! */ .releaseOutputBuffer(var11_9, (boolean)var18_16);
                if (var18_16 != 0) {
                    var11_9 = var5_3 ^ 1;
                    var41_35 = (int)var7_5.AwaitNewImage((boolean)var11_9);
                    if (var41_35 == 0) {
                        Log.e((String)"NvAndroidVideoFileReader", (String)"Render decoded frame to surface texture failed!");
                        return var12_10;
                    }
                    var40_34 /* !! */  = var7_5.m_bufferInfo;
                    var7_5.m_timestampOfCurTexFrame = var36_32 = var40_34 /* !! */ .presentationTimeUs;
                    var7_5.m_curTexImageUpdated = var11_9;
                    if (var17_15 == 0) {
                        return 0;
                    }
                }
            }
            if (var14_12 /* !! */  > (var11_9 = var7_5.m_videoDecodeRetryMaxCount)) {
                Log.e((String)"NvAndroidVideoFileReader", (String)"We have tried too many times and can't decode a frame!");
                return var12_10;
            }
            var11_9 = 3;
        }
    }

    private void DrainOutputBuffers(boolean bl2) {
        int n10;
        if (!(bl2 || (bl2 = this.m_sawInputEOS) && !(bl2 = this.m_sawOutputEOS))) {
            return;
        }
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
    private int SeekInternal(long var1_1, long var3_2, boolean var5_3, int var6_4) {
        block24: {
            block23: {
                block22: {
                    var7_5 = "NvAndroidVideoFileReader";
                    var8_6 = this.m_timestampOfLastDecodedFrame;
                    var10_7 = -9223372036854775808L;
                    var12_8 = var8_6 == var10_7 ? 0 : (var8_6 < var10_7 ? -1 : 1);
                    var13_9 = true;
                    if (!(var12_8 != false && (var12_8 = var1_1 == var8_6 ? 0 : (var1_1 < var8_6 ? -1 : 1)) > 0 && (var16_11 = (int)((cfr_temp_0 = var1_1 - (var8_6 += (var14_10 = this.m_contiuousDecodingThreshold))) == 0L ? 0 : (cfr_temp_0 < 0L ? -1 : 1))) < 0 || (var16_11 = this.m_extractorInOriginalState) != 0 && (var16_11 = (int)((cfr_temp_1 = var1_1 - (var8_6 = this.m_contiuousDecodingThreshold)) == 0L ? 0 : (cfr_temp_1 < 0L ? -1 : 1))) < 0)) {
                        var13_9 = false;
                    }
                    if (var13_9) break block24;
                    var16_11 = 2;
                    var17_12 /* !! */  = this.m_extractor;
                    var17_12 /* !! */ .seekTo(var1_1, 0);
                    var17_12 /* !! */  = this.m_extractor;
                    var18_13 = var17_12 /* !! */ .getSampleTime();
                    var14_10 = 0L;
                    var20_14 = var18_13 == var14_10 ? 0 : (var18_13 < var14_10 ? -1 : 1);
                    if (var20_14 >= 0) ** GOTO lbl43
                    var18_13 = this.m_duration;
                    var14_10 = 100000L;
                    cfr_temp_2 = var1_1 - (var18_13 -= var14_10);
                    var20_14 = cfr_temp_2 == 0L ? 0 : (cfr_temp_2 < 0L ? -1 : 1);
                    if (var20_14 >= 0) ** GOTO lbl43
                    var17_12 /* !! */  = "Try to recreate MediaExtractor!";
                    Log.w((String)var7_5, (String)var17_12 /* !! */ );
                    var20_14 = (long)this.recreateMediaExtractor();
                    if (var20_14 != false) break block22;
                    var21_15 = "Failed to recreate MediaExtractor!";
                    Log.e((String)var7_5, (String)var21_15);
                    this.CloseFile();
                    return var16_11;
                }
                var17_12 /* !! */  = this.m_extractor;
                var17_12 /* !! */ .seekTo(var1_1, 0);
lbl43:
                // 3 sources

                if ((var20_14 = (long)this.m_sawInputEOS) != false) break block23;
                var20_14 = (long)this.m_sawOutputEOS;
                if (var20_14 != false) break block23;
                var20_14 = (long)this.m_inputBufferQueued;
                if (var20_14 == false) break block24;
                var17_12 /* !! */  = this.m_decoder;
                var17_12 /* !! */ .flush();
lbl54:
                // 2 sources

                while (true) {
                    this.m_inputBufferQueued = false;
                    this.m_pendingInputFrameCount = 0;
                    break;
                }
            }
            try {
                this.CleanupDecoder(false);
                var17_12 /* !! */  = this.m_format;
                var22_17 = "mime";
            }
            catch (Exception var21_16) {
                var24_19 /* !! */  = new StringBuilder();
                var24_19 /* !! */ .append("");
                var25_20 = var21_16.getMessage();
                var24_19 /* !! */ .append(var25_20);
                var24_19 /* !! */  = var24_19 /* !! */ .toString();
                Log.e((String)var7_5, (String)var24_19 /* !! */ );
                var21_16.printStackTrace();
                return var16_11;
            }
            var17_12 /* !! */  = var17_12 /* !! */ .getString(var22_17);
            var23_18 = this.SetupDecoder((String)var17_12 /* !! */ );
            if (!var23_18) {
                return var16_11;
            }
        }
        return this.DecodeToFrame(var1_1, var3_2, var5_3, var6_4);
        catch (Exception v0) {
            ** continue;
        }
    }

    private boolean SetupDecoder(String string2) {
        String string3;
        ByteBuffer[] byteBufferArray;
        try {
            string2 = MediaCodec.createDecoderByType((String)string2);
        }
        catch (Exception exception) {
            byteBufferArray = new StringBuilder();
            byteBufferArray.append("");
            string3 = exception.getMessage();
            byteBufferArray.append(string3);
            byteBufferArray = byteBufferArray.toString();
            Log.e((String)TAG, (String)byteBufferArray);
            exception.printStackTrace();
            this.CleanupDecoder(false);
            return false;
        }
        this.m_decoder = string2;
        byteBufferArray = this.m_format;
        string3 = this.m_surface;
        string2.configure((MediaFormat)byteBufferArray, (Surface)string3, null, 0);
        string2 = this.m_decoder;
        string2.start();
        boolean bl2 = true;
        this.m_decoderStarted = bl2;
        byteBufferArray = this.m_decoder;
        byteBufferArray = byteBufferArray.getInputBuffers();
        this.m_decoderInputBuffers = byteBufferArray;
        return bl2;
    }

    public static /* synthetic */ SurfaceTexture access$002(NvAndroidVideoFileReader nvAndroidVideoFileReader, SurfaceTexture surfaceTexture) {
        nvAndroidVideoFileReader.m_surfaceTexture = surfaceTexture;
        return surfaceTexture;
    }

    public static /* synthetic */ int access$100(NvAndroidVideoFileReader nvAndroidVideoFileReader) {
        return nvAndroidVideoFileReader.m_texId;
    }

    public static /* synthetic */ Semaphore access$200(NvAndroidVideoFileReader nvAndroidVideoFileReader) {
        return nvAndroidVideoFileReader.m_surfaceTextureCreationSemaphore;
    }

    public static /* synthetic */ void access$300(NvAndroidVideoFileReader nvAndroidVideoFileReader, boolean bl2) {
        nvAndroidVideoFileReader.CleanupDecoderCore(bl2);
    }

    private boolean canSkipFrame(ByteBuffer byteBuffer, long l10) {
        int n10;
        block8: {
            int n11;
            block9: {
                int n12;
                block7: {
                    int n13;
                    n10 = 0;
                    if (byteBuffer == null) {
                        return false;
                    }
                    n11 = byteBuffer.limit();
                    if (n11 < (n13 = 16)) {
                        return false;
                    }
                    n11 = this.m_usedTemporalLayer;
                    if (n11 < 0) {
                        return false;
                    }
                    long l11 = this.m_temporalLayerEndTime;
                    long l12 = l10 - l11;
                    Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
                    if (object >= 0) {
                        return false;
                    }
                    byte[] byArray = new byte[n13];
                    int n14 = byteBuffer.position();
                    byteBuffer.get(byArray);
                    byteBuffer.position(n14);
                    n12 = byArray[4] & 0x1F;
                    n14 = byArray[0];
                    n11 = 1;
                    if (n14 != 0 || (n14 = byArray[n11]) != 0 || (n14 = byArray[2]) != 0 || (n14 = byArray[3]) != n11 || n12 != (n14 = 14) && n12 != (n14 = 20)) break block7;
                    n12 = 5;
                    n14 = byArray[n12] & 0xFF;
                    n13 = 7;
                    if ((n14 = (n14 >>= n13) > 0 ? n11 : 0) == 0 || (n12 = (byArray[n13] & 0xFF) >> 5 & n13) <= (object = (Object)this.m_usedTemporalLayer)) break block8;
                    break block9;
                }
                n12 = this.m_usedTemporalLayer;
                if (n12 <= 0) break block8;
            }
            n10 = n11;
        }
        return n10 != 0;
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
                object = (NvAndroidVideoFileReader$CueVideoFrameInfo)this.m_listPlaybackCueFrame.get(0);
            }
            n12 = 1;
            if (object != null && (l13 = (l12 = (l11 = ((NvAndroidVideoFileReader$CueVideoFrameInfo)object).cueVideoFrameTimeStamp) - l10) == 0L ? 0 : (l12 < 0L ? -1 : 1)) > 0 && (l13 = (long)((NvAndroidVideoFileReader$CueVideoFrameInfo)object).isKeyframe) != false) {
                long l14;
                long l15;
                if (n10 != 0 && (n10 = (l15 = (l14 = 50000L + l10) - l11) == 0L ? 0 : (l15 < 0L ? -1 : 1)) >= 0) {
                    ((NvAndroidVideoFileReader$CueVideoFrameInfo)object).cueVideoFrameTimeStamp = l10;
                    this.m_listPlaybackCueFrame.set(0, object);
                    return false;
                }
                return n12 != 0;
            }
            object = this.m_listPlaybackCueFrame;
            n11 = ((ArrayList)object).size();
            if (n11 > n12 && n10 == 0) {
                long l16;
                object2 = (NvAndroidVideoFileReader$CueVideoFrameInfo)this.m_listPlaybackCueFrame.get(0);
                object = (NvAndroidVideoFileReader$CueVideoFrameInfo)this.m_listPlaybackCueFrame.get(n12);
                l11 = ((NvAndroidVideoFileReader$CueVideoFrameInfo)object2).cueVideoFrameTimeStamp;
                long l17 = l10 - l11;
                Object object3 = l17 == 0L ? 0 : (l17 < 0L ? -1 : 1);
                if (object3 > 0 && (n10 = (int)(((NvAndroidVideoFileReader$CueVideoFrameInfo)object2).isKeyframe ? 1 : 0)) != 0 && (n10 = (int)((l16 = l10 - (l11 = ((NvAndroidVideoFileReader$CueVideoFrameInfo)object).cueVideoFrameTimeStamp)) == 0L ? 0 : (l16 < 0L ? -1 : 1))) < 0 && (n10 = (int)(((NvAndroidVideoFileReader$CueVideoFrameInfo)object).isKeyframe ? 1 : 0)) != 0) {
                    this.m_listPlaybackCueFrame.remove(0);
                    return n12 != 0;
                }
            }
            while ((n10 = ((ArrayList)(object2 = this.m_listPlaybackCueFrame)).isEmpty()) == 0) {
                object2 = (NvAndroidVideoFileReader$CueVideoFrameInfo)this.m_listPlaybackCueFrame.get(0);
                long l18 = ((NvAndroidVideoFileReader$CueVideoFrameInfo)object2).cueVideoFrameTimeStamp;
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

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private int extractHDRMaxLuminance(ByteBuffer byteBuffer) {
        int n10;
        int n11 = 0;
        if (byteBuffer == null) {
            return 0;
        }
        int n12 = byteBuffer.limit();
        if (n12 != (n10 = 25)) {
            return 0;
        }
        byte[] byArray = new byte[n10];
        byteBuffer.position(0);
        byteBuffer.get(byArray);
        int n13 = Build.VERSION.SDK_INT;
        n11 = 27;
        n10 = 18;
        int n14 = 17;
        if (n13 < n11) {
            n13 = byArray[n14] & 0xFF;
            n11 = byArray[n10] & 0xFF;
            return n13 | (n11 <<= 8);
        }
        n13 = a.a(byArray[n14]);
        n11 = a.a(byArray[n10]);
        return n13 | (n11 <<= 8);
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
        boolean bl2 = true;
        int n11 = 2;
        long l14 = l10;
        n10 = this.SeekInternal(l10, l13, bl2, n11);
        long l15 = Long.MIN_VALUE;
        if (n10 == 0) {
            l14 = this.m_timestampOfCurTexFrame;
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
            if (n10 == n12 && (n12 = (int)((l19 = (l10 = this.m_timestampOfCurTexFrame) - l15) == 0L ? 0 : (l19 < 0L ? -1 : 1))) == 0 && (l18 = (l17 = (l10 = this.m_timestampOfLastDecodedFrame) - l15) == 0L ? 0 : (l17 < 0L ? -1 : 1)) != false) {
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
                Log.e((String)TAG, (String)charSequence);
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

    public void CloseFile() {
        this.InvalidLastSeekTimestamp();
        boolean bl2 = true;
        this.CleanupDecoder(bl2);
        MediaExtractor mediaExtractor = this.m_extractor;
        int n10 = -1;
        if (mediaExtractor != null) {
            long l10;
            mediaExtractor.release();
            this.m_extractor = null;
            this.m_videoTrackIndex = n10;
            this.m_format = null;
            this.m_duration = l10 = 0L;
            this.m_actualDuration = l10;
            this.m_extractorInOriginalState = bl2;
        }
        this.m_usedTemporalLayer = n10;
        this.m_temporalLayerEndTime = -1;
        this.m_videoFilePath = null;
        this.m_context = null;
    }

    public int GetHDRMaxLuminance() {
        return this.m_videoHDRMaxLuminance;
    }

    public int GetNextVideoFrameForPlayback() {
        int n10 = this.IsValid();
        if (n10 == 0) {
            return 1;
        }
        n10 = this.m_firstPlaybackTexFrameUnconsumed;
        if (n10 == 0) {
            n10 = this.m_skipModeWhenPlayback;
            int n11 = 2;
            int n12 = n10 != n11 ? n10 : 0;
            long l10 = Long.MIN_VALUE;
            long l11 = 0L;
            n10 = this.DecodeToFrame(l10, l11, false, n12);
            this.InvalidLastSeekTimestamp();
            if (n10 != 0) {
                return n10;
            }
        } else {
            this.m_firstPlaybackTexFrameUnconsumed = false;
        }
        return 0;
    }

    public long GetTimestampOfCurrentTextureFrame() {
        return this.m_timestampOfCurTexFrame;
    }

    public void GetTransformMatrixOfSurfaceTexture(float[] fArray) {
        SurfaceTexture surfaceTexture = this.m_surfaceTexture;
        if (surfaceTexture != null) {
            surfaceTexture.getTransformMatrix(fArray);
        }
    }

    public int GetVideoColorTransfer() {
        return this.m_videoColorTransferCharacteristic;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean OpenFile(String object, int n10, Context object2, int n11, long l10) {
        Object[] objectArray;
        String string5;
        int n14;
        boolean bl2;
        Object object4;
        String string2;
        int n13;
        String string3;
        String string4;
        block21: {
            StringBuilder stringBuilder;
            string4 = "frame-rate";
            string3 = "";
            n13 = this.IsValid();
            string2 = TAG;
            if (n13 != 0) {
                Log.e((String)string2, (String)"You can't call OpenFile() twice!");
                return false;
            }
            this.m_extractor = object4 = NvAndroidUtils.createMediaExtractorFromMediaFilePath((Context)object2, (String)object);
            if (object4 == null) {
                return false;
            }
            this.m_extractorInOriginalState = bl2 = true;
            this.m_videoFilePath = object;
            this.m_context = object2;
            try {
                n14 = object4.getTrackCount();
                n13 = 0;
                object4 = null;
                while (true) {
                    String string6;
                    string5 = "mime";
                    if (n13 >= n14) break;
                    Object object5 = this.m_extractor;
                    object5 = object5.getTrackFormat(n13);
                    boolean bl3 = ((String)(object5 = object5.getString(string5))).startsWith(string6 = "video/");
                    if (bl3) {
                        this.m_videoTrackIndex = n13;
                        break;
                    }
                    ++n13;
                }
                if ((n14 = this.m_videoTrackIndex) >= 0) break block21;
                stringBuilder = new StringBuilder();
                stringBuilder.append("Failed to find a video track from ");
            }
            catch (Exception exception) {
                CharSequence charSequence = new StringBuilder();
                charSequence.append(string3);
                object2 = exception.getMessage();
                charSequence.append((String)object2);
                charSequence = charSequence.toString();
                Log.e((String)string2, (String)charSequence);
                exception.printStackTrace();
                this.CloseFile();
                return false;
            }
            stringBuilder.append((String)object);
            object = stringBuilder.toString();
            Log.e((String)string2, (String)object);
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
            object4 = "max-input-size";
            object.setInteger((String)object4, 0);
        }
        this.m_videoColorTransferCharacteristic = 3;
        object = this.m_format;
        object4 = "color-transfer";
        int n12 = object.containsKey((String)object4);
        if (n12 != 0) {
            object = this.m_format;
            this.m_videoColorTransferCharacteristic = n12 = object.getInteger((String)object4);
        }
        this.m_videoHDRMaxLuminance = 0;
        object = this.m_format;
        object4 = "hdr-static-info";
        n12 = (int)(object.containsKey((String)object4) ? 1 : 0);
        if (n12 != 0) {
            object = this.m_format.getByteBuffer((String)object4);
            this.m_videoHDRMaxLuminance = n12 = this.extractHDRMaxLuminance((ByteBuffer)object);
        }
        object = Build.HARDWARE;
        object4 = "qcom";
        n12 = (int)(((String)object).equals(object4) ? 1 : 0);
        n13 = 23;
        if (n14 >= n13 && n11 >= 0) {
            object2 = this.m_format;
            if (n11 <= 0) {
                n11 = 120;
            }
            object4 = "operating-rate";
            object2.setInteger((String)object4, n11);
        }
        try {
            long l11;
            long l12;
            object2 = this.m_format;
            objectArray = "durationUs";
            this.m_duration = l12 = object2.getLong((String)objectArray);
            object2 = this.m_format;
            object2 = object2.getString(string5);
            this.m_actualDuration = l11 = this.m_duration;
            if (n12 != 0 && (n12 = (int)((object = this.m_format).containsKey(string4) ? 1 : 0)) != 0) {
                object = this.m_format;
                object.setInteger(string4, 0);
            }
        }
        catch (Exception exception) {
            CharSequence charSequence = new StringBuilder();
            charSequence.append(string3);
            object2 = exception.getMessage();
            charSequence.append((String)object2);
            charSequence = charSequence.toString();
            Log.e((String)string2, (String)charSequence);
            exception.printStackTrace();
            this.CloseFile();
            return false;
        }
        try {
            Object object3;
            object = m_setOnFrameAvailableListener2;
            if (object != null) {
                object = new SurfaceTexture(n10);
                this.m_surfaceTexture = object;
                object3 = m_setOnFrameAvailableListener2;
                n11 = 2;
                objectArray = new Object[n11];
                objectArray[0] = this;
                string4 = this.m_handler;
                objectArray[bl2] = string4;
                ((Method)object3).invoke(object, objectArray);
            } else {
                this.m_surfaceTextureCreationSemaphore = object = new Semaphore(0);
                this.m_texId = n10;
                object = this.m_handler;
                object3 = new NvAndroidVideoFileReader$1(this);
                object.post((Runnable)object3);
                object = this.m_surfaceTextureCreationSemaphore;
                ((Semaphore)object).acquire();
                n12 = 0;
                object = null;
                this.m_surfaceTextureCreationSemaphore = null;
                this.m_texId = 0;
                object = this.m_surfaceTexture;
                if (object == null) {
                    this.CloseFile();
                    return false;
                }
                object.setOnFrameAvailableListener((SurfaceTexture.OnFrameAvailableListener)this);
            }
            object3 = this.m_surfaceTexture;
            object = new Surface((SurfaceTexture)object3);
            this.m_surface = object;
            this.m_decoderSetupFailed = false;
        }
        catch (Exception exception) {
            CharSequence charSequence = new StringBuilder();
            charSequence.append(string3);
            object2 = exception.getMessage();
            charSequence.append((String)object2);
            charSequence = charSequence.toString();
            Log.e((String)string2, (String)charSequence);
            exception.printStackTrace();
            this.CloseFile();
            return false;
        }
        n12 = (int)(this.SetupDecoder((String)object2) ? 1 : 0);
        if (n12 == 0) {
            this.m_decoderSetupFailed = bl2;
            this.CloseFile();
            return false;
        }
        this.m_videoDecodeRetryMaxCount = 100;
        object = "x-vnd.on2.vp8";
        n12 = (int)(((String)object2).contains((CharSequence)object) ? 1 : 0);
        if (n12 != 0 || (n12 = (int)(((String)object2).contains((CharSequence)(object = "x-vnd.on2.vp9")) ? 1 : 0)) != 0) {
            this.m_videoDecodeRetryMaxCount = n12 = 500;
        }
        this.m_listPlaybackCueFrame = object = new ArrayList();
        this.m_contiuousDecodingThreshold = l10;
        this.m_usedTemporalLayer = -1;
        this.m_temporalLayerEndTime = -1;
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
        if ((l15 = (l14 = (l13 = this.m_timestampOfCurTexFrame) - (l16 = Long.MIN_VALUE)) == 0L ? 0 : (l14 < 0L ? -1 : 1)) != false && (object = (Object)((l12 = (l13 = Math.abs(l10 - l13)) - l11) == 0L ? 0 : (l12 < 0L ? -1 : 1))) <= 0) {
            return 0;
        }
        this.clearCueVideoFrameForPlayback();
        int n11 = 2;
        int n12 = this.SeekInternal(l10, l11, false, n11);
        if (n12 == 0) {
            this.m_lastSeekTimestamp = l10;
            this.m_lastSeekActualTimestamp = l10 = this.m_timestampOfCurTexFrame;
        } else {
            this.InvalidLastSeekTimestamp();
        }
        return n12;
    }

    public void SetDecodeTemporalLayer(int n10, long l10) {
        int n11 = this.m_usedTemporalLayer;
        if (n10 == n11) {
            return;
        }
        this.m_temporalLayerEndTime = l10;
        this.m_usedTemporalLayer = n10;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public int StartPlayback(long var1_1, long var3_2) {
        block8: {
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
            var7_5 = this.m_duration;
            cfr_temp_1 = var1_1 - var7_5;
            var5_3 /* !! */  = (int)(cfr_temp_1 == 0L ? 0 : (cfr_temp_1 < 0L ? -1 : 1));
            if (var5_3 /* !! */  >= 0) {
                var1_1 = var7_5 - 1L;
            }
            if ((var5_3 /* !! */  = (int)((cfr_temp_2 = (var7_5 = this.m_preloadedTimestamp) - (var9_6 = -9223372036854775808L)) == 0L ? 0 : (cfr_temp_2 < 0L ? -1 : 1))) == 0) break block8;
            var5_3 /* !! */  = (int)(var1_1 == var7_5 ? 0 : (var1_1 < var7_5 ? -1 : 1));
            if (var5_3 /* !! */  >= 0 && (var5_3 /* !! */  = (int)((cfr_temp_3 = var1_1 - (var7_5 = this.m_timestampOfCurTexFrame)) == 0L ? 0 : (cfr_temp_3 < 0L ? -1 : 1))) <= 0) {
                var1_1 = var7_5;
            }
            this.m_preloadedTimestamp = var9_6;
            ** GOTO lbl-1000
        }
        var7_5 = this.m_lastSeekTimestamp;
        cfr_temp_4 = var7_5 - var9_6;
        var5_3 /* !! */  = (int)(cfr_temp_4 == 0L ? 0 : (cfr_temp_4 < 0L ? -1 : 1));
        if (var5_3 /* !! */  != 0 && (var5_3 /* !! */  = (int)(var1_1 == var7_5 ? 0 : (var1_1 < var7_5 ? -1 : 1))) == 0 && (var5_3 /* !! */  = (int)((cfr_temp_5 = (var7_5 = this.m_lastSeekActualTimestamp) - var9_6) == 0L ? 0 : (cfr_temp_5 < 0L ? -1 : 1))) != 0) {
            var11_7 = var7_5;
        } else lbl-1000:
        // 2 sources

        {
            var11_7 = var1_1;
        }
        var1_1 = this.m_timestampOfCurTexFrame;
        var5_3 /* !! */  = (int)(var11_7 == var1_1 ? 0 : (var11_7 < var1_1 ? -1 : 1));
        if (var5_3 /* !! */  == 0 && (var15_9 = (cfr_temp_6 = var1_1 - (var13_8 = this.m_timestampOfLastDecodedFrame)) == 0L ? 0 : (cfr_temp_6 < 0L ? -1 : 1)) == false) {
            this.m_firstPlaybackTexFrameUnconsumed = var6_4;
            return 0;
        }
        this.clearCueVideoFrameForPlayback();
        var16_10 = 2;
        var15_9 = this.SeekInternal(var11_7, var3_2, false, var16_10);
        this.InvalidLastSeekTimestamp();
        if (var15_9 != false) {
            return (int)var15_9;
        }
        this.m_firstPlaybackTexFrameUnconsumed = var6_4;
        this.m_skipModeWhenPlayback = 0;
        return 0;
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
            if ((object = (NvAndroidVideoFileReader$CueVideoFrameInfo)((ArrayList)object).get(n11)) != null && (l13 = (l12 = (l11 = ((NvAndroidVideoFileReader$CueVideoFrameInfo)object).cueVideoFrameTimeStamp) - l10) == 0L ? 0 : (l12 < 0L ? -1 : 1)) > 0) {
                return;
            }
        }
        object = new NvAndroidVideoFileReader$CueVideoFrameInfo();
        ((NvAndroidVideoFileReader$CueVideoFrameInfo)object).cueVideoFrameTimeStamp = l10;
        ((NvAndroidVideoFileReader$CueVideoFrameInfo)object).isKeyframe = bl2;
        this.m_listPlaybackCueFrame.add(object);
    }

    public boolean hasDecoderSetupFailed() {
        return this.m_decoderSetupFailed;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void onFrameAvailable(SurfaceTexture object) {
        object = this.m_frameSyncObject;
        synchronized (object) {
            Object object2;
            boolean bl2 = this.m_frameAvailable;
            if (bl2) {
                object2 = TAG;
                String string2 = "m_frameAvailable already set, frame could be dropped!";
                Log.e((String)object2, (String)string2);
            }
            this.m_frameAvailable = bl2 = true;
            object2 = this.m_frameSyncObject;
            object2.notifyAll();
            return;
        }
    }

    public void preload(long l10) {
        String string2;
        int n10;
        long l11;
        String string3;
        int n11;
        int n12 = this.preloadInternal(l10);
        int n13 = 0;
        do {
            string3 = "Failed to recreate MediaExtractor!";
            l11 = Long.MIN_VALUE;
            n10 = 4;
            string2 = TAG;
            if (n12 != n10) break;
            this.m_timestampOfLastDecodedFrame = l11;
            String string4 = "Try to recreate MediaExtractor!";
            Log.w((String)string2, (String)string4);
            n12 = (int)(this.recreateMediaExtractor() ? 1 : 0);
            if (n12 == 0) {
                Log.e((String)string2, (String)string3);
            }
            n12 = this.preloadInternal(l10);
            CharSequence charSequence = new StringBuilder();
            String string5 = "Try to preload! times=";
            charSequence.append(string5);
            charSequence.append(++n13);
            charSequence = charSequence.toString();
            Log.w((String)string2, (String)charSequence);
        } while (n13 < (n11 = 2));
        if (n12 == n10) {
            String string6 = "Try to recreate MediaExtractor after preload!";
            Log.w((String)string2, (String)string6);
            this.m_timestampOfLastDecodedFrame = l11;
            boolean bl2 = this.recreateMediaExtractor();
            if (!bl2) {
                Log.e((String)string2, (String)string3);
            }
        }
    }

    public void setActualDuration(long l10) {
        long l11 = this.m_duration;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object > 0) {
            this.m_actualDuration = l10;
            long l13 = 0L;
            long l14 = l11 - l13;
            Object object2 = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
            if (object2 <= 0) {
                this.m_duration = l10;
            }
        }
    }

    public void setInterruptionChecker(NvAndroidInterruptionChecker nvAndroidInterruptionChecker) {
        this.m_interruptionChecker = nvAndroidInterruptionChecker;
    }

    public void setPlaybackSkipMode(int n10) {
        this.m_skipModeWhenPlayback = n10;
    }

    public void updateCurTexImage() {
        block6: {
            long l10;
            block7: {
                long l11 = this.m_timestampOfCurTexFrame;
                long l12 = Long.MIN_VALUE;
                l10 = l11 == l12 ? 0 : (l11 < l12 ? -1 : 1);
                if (l10 == false) break block6;
                l10 = (long)this.m_curTexImageUpdated;
                if (l10 != false) break block6;
                SurfaceTexture surfaceTexture = this.m_surfaceTexture;
                if (surfaceTexture == null) break block7;
                surfaceTexture.updateTexImage();
            }
            l10 = 1;
            try {
                this.m_curTexImageUpdated = l10;
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }
}

