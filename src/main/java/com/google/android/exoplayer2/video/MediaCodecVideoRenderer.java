/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Point
 *  android.media.MediaCrypto
 *  android.media.MediaFormat
 *  android.os.Bundle
 *  android.os.Handler
 *  android.os.SystemClock
 *  android.util.Pair
 *  android.view.Surface
 */
package com.google.android.exoplayer2.video;

import android.content.Context;
import android.graphics.Point;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Pair;
import android.view.Surface;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.Format$Builder;
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.RendererCapabilities;
import com.google.android.exoplayer2.RendererConfiguration;
import com.google.android.exoplayer2.decoder.DecoderCounters;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.decoder.DecoderReuseEvaluation;
import com.google.android.exoplayer2.mediacodec.MediaCodecAdapter;
import com.google.android.exoplayer2.mediacodec.MediaCodecAdapter$Factory;
import com.google.android.exoplayer2.mediacodec.MediaCodecDecoderException;
import com.google.android.exoplayer2.mediacodec.MediaCodecInfo;
import com.google.android.exoplayer2.mediacodec.MediaCodecRenderer;
import com.google.android.exoplayer2.mediacodec.MediaCodecSelector;
import com.google.android.exoplayer2.mediacodec.MediaCodecUtil;
import com.google.android.exoplayer2.mediacodec.MediaCodecUtil$DecoderQueryException;
import com.google.android.exoplayer2.mediacodec.MediaFormatUtil;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.TraceUtil;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.video.ColorInfo;
import com.google.android.exoplayer2.video.DummySurface;
import com.google.android.exoplayer2.video.MediaCodecVideoDecoderException;
import com.google.android.exoplayer2.video.MediaCodecVideoRenderer$CodecMaxValues;
import com.google.android.exoplayer2.video.MediaCodecVideoRenderer$OnFrameRenderedListenerV23;
import com.google.android.exoplayer2.video.VideoFrameMetadataListener;
import com.google.android.exoplayer2.video.VideoFrameReleaseHelper;
import com.google.android.exoplayer2.video.VideoRendererEventListener;
import com.google.android.exoplayer2.video.VideoRendererEventListener$EventDispatcher;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

public class MediaCodecVideoRenderer
extends MediaCodecRenderer {
    private static final float INITIAL_FORMAT_MAX_INPUT_SIZE_SCALE_FACTOR = 1.5f;
    private static final String KEY_CROP_BOTTOM = "crop-bottom";
    private static final String KEY_CROP_LEFT = "crop-left";
    private static final String KEY_CROP_RIGHT = "crop-right";
    private static final String KEY_CROP_TOP = "crop-top";
    private static final int[] STANDARD_LONG_EDGE_VIDEO_PX;
    private static final String TAG = "MediaCodecVideoRenderer";
    private static final long TUNNELING_EOS_PRESENTATION_TIME_US = Long.MAX_VALUE;
    private static boolean deviceNeedsSetOutputSurfaceWorkaround;
    private static boolean evaluatedDeviceNeedsSetOutputSurfaceWorkaround;
    private final long allowedJoiningTimeMs;
    private int buffersInCodecCount;
    private boolean codecHandlesHdr10PlusOutOfBandMetadata;
    private MediaCodecVideoRenderer$CodecMaxValues codecMaxValues;
    private boolean codecNeedsSetOutputSurfaceWorkaround;
    private int consecutiveDroppedFrameCount;
    private final Context context;
    private int currentHeight;
    private float currentPixelWidthHeightRatio;
    private int currentUnappliedRotationDegrees;
    private int currentWidth;
    private final boolean deviceNeedsNoPostProcessWorkaround;
    private long droppedFrameAccumulationStartTimeMs;
    private int droppedFrames;
    private Surface dummySurface;
    private final VideoRendererEventListener$EventDispatcher eventDispatcher;
    private VideoFrameMetadataListener frameMetadataListener;
    private final VideoFrameReleaseHelper frameReleaseHelper;
    private boolean haveReportedFirstFrameRenderedForCurrentSurface;
    private long initialPositionUs;
    private long joiningDeadlineMs;
    private long lastBufferPresentationTimeUs;
    private long lastRenderRealtimeUs;
    private final int maxDroppedFramesToNotify;
    private boolean mayRenderFirstFrameAfterEnableIfNotStarted;
    private boolean renderedFirstFrameAfterEnable;
    private boolean renderedFirstFrameAfterReset;
    private int reportedHeight;
    private float reportedPixelWidthHeightRatio;
    private int reportedUnappliedRotationDegrees;
    private int reportedWidth;
    private int scalingMode;
    private Surface surface;
    private long totalVideoFrameProcessingOffsetUs;
    private boolean tunneling;
    private int tunnelingAudioSessionId;
    public MediaCodecVideoRenderer$OnFrameRenderedListenerV23 tunnelingOnFrameRenderedListener;
    private int videoFrameProcessingOffsetCount;

    static {
        int[] nArray;
        int[] nArray2 = nArray = new int[9];
        int[] nArray3 = nArray;
        nArray2[0] = 1920;
        nArray3[1] = 1600;
        nArray2[2] = 1440;
        nArray3[3] = 1280;
        nArray2[4] = 960;
        nArray3[5] = 854;
        nArray2[6] = 640;
        nArray3[7] = 540;
        nArray3[8] = 480;
        STANDARD_LONG_EDGE_VIDEO_PX = nArray;
    }

    public MediaCodecVideoRenderer(Context object, MediaCodecAdapter$Factory object2, MediaCodecSelector mediaCodecSelector, long l10, boolean bl2, Handler handler, VideoRendererEventListener videoRendererEventListener, int n10) {
        super(2, (MediaCodecAdapter$Factory)object2, mediaCodecSelector, bl2, 30.0f);
        int n11;
        this.allowedJoiningTimeMs = l10;
        this.maxDroppedFramesToNotify = n10;
        this.context = object = object.getApplicationContext();
        this.frameReleaseHelper = object2 = new VideoFrameReleaseHelper((Context)object);
        super(handler, videoRendererEventListener);
        this.eventDispatcher = object;
        this.deviceNeedsNoPostProcessWorkaround = n11 = MediaCodecVideoRenderer.deviceNeedsNoPostProcessWorkaround();
        this.joiningDeadlineMs = -9223372036854775807L;
        this.currentWidth = n11 = -1;
        this.currentHeight = n11;
        this.currentPixelWidthHeightRatio = -1.0f;
        this.scalingMode = 1;
        this.tunnelingAudioSessionId = 0;
        this.clearReportedVideoSize();
    }

    public MediaCodecVideoRenderer(Context context, MediaCodecSelector mediaCodecSelector) {
        this(context, mediaCodecSelector, 0L);
    }

    public MediaCodecVideoRenderer(Context context, MediaCodecSelector mediaCodecSelector, long l10) {
        this(context, mediaCodecSelector, l10, null, null, -1);
    }

    public MediaCodecVideoRenderer(Context context, MediaCodecSelector mediaCodecSelector, long l10, Handler handler, VideoRendererEventListener videoRendererEventListener, int n10) {
        MediaCodecAdapter$Factory mediaCodecAdapter$Factory = MediaCodecAdapter$Factory.DEFAULT;
        this(context, mediaCodecAdapter$Factory, mediaCodecSelector, l10, false, handler, videoRendererEventListener, n10);
    }

    public MediaCodecVideoRenderer(Context context, MediaCodecSelector mediaCodecSelector, long l10, boolean bl2, Handler handler, VideoRendererEventListener videoRendererEventListener, int n10) {
        MediaCodecAdapter$Factory mediaCodecAdapter$Factory = MediaCodecAdapter$Factory.DEFAULT;
        this(context, mediaCodecAdapter$Factory, mediaCodecSelector, l10, bl2, handler, videoRendererEventListener, n10);
    }

    public static /* synthetic */ void access$000(MediaCodecVideoRenderer mediaCodecVideoRenderer) {
        mediaCodecVideoRenderer.onProcessedTunneledEndOfStream();
    }

    public static /* synthetic */ void access$100(MediaCodecVideoRenderer mediaCodecVideoRenderer, ExoPlaybackException exoPlaybackException) {
        mediaCodecVideoRenderer.setPendingPlaybackException(exoPlaybackException);
    }

    private void clearRenderedFirstFrame() {
        MediaCodecAdapter mediaCodecAdapter = null;
        this.renderedFirstFrameAfterReset = false;
        int n10 = Util.SDK_INT;
        int n11 = 23;
        if (n10 >= n11 && (n10 = (int)(this.tunneling ? 1 : 0)) != 0 && (mediaCodecAdapter = this.getCodec()) != null) {
            MediaCodecVideoRenderer$OnFrameRenderedListenerV23 mediaCodecVideoRenderer$OnFrameRenderedListenerV23;
            this.tunnelingOnFrameRenderedListener = mediaCodecVideoRenderer$OnFrameRenderedListenerV23 = new MediaCodecVideoRenderer$OnFrameRenderedListenerV23(this, mediaCodecAdapter);
        }
    }

    private void clearReportedVideoSize() {
        int n10;
        this.reportedWidth = n10 = -1;
        this.reportedHeight = n10;
        this.reportedPixelWidthHeightRatio = -1.0f;
        this.reportedUnappliedRotationDegrees = n10;
    }

    private static void configureTunnelingV21(MediaFormat mediaFormat, int n10) {
        mediaFormat.setFeatureEnabled("tunneled-playback", true);
        mediaFormat.setInteger("audio-session-id", n10);
    }

    private static boolean deviceNeedsNoPostProcessWorkaround() {
        String string2 = Util.MANUFACTURER;
        return "NVIDIA".equals(string2);
    }

    /*
     * Unable to fully structure code
     */
    private static boolean evaluateDeviceNeedsSetOutputSurfaceWorkaround() {
        block169: {
            block168: {
                var0 = Util.SDK_INT;
                var1_1 = 5;
                var2_2 = 7.0E-45f;
                var3_3 = 4;
                var4_4 = 5.6E-45f;
                var5_5 = 3;
                var6_6 = 4.2E-45f;
                var7_7 = 28;
                var8_8 = 3.9E-44f;
                var9_9 = 2;
                var10_10 = 2.8E-45f;
                var11_11 = -1;
                var12_12 = 0.0f / 0.0f;
                var13_13 = 1;
                var14_14 = 1.4E-45f;
                if (var0 > var7_7) break block168;
                var15_15 = Util.DEVICE;
                var15_15.hashCode();
                var16_16 = var15_15.hashCode();
                switch (var16_16) lbl-1000:
                // 7 sources

                {
                    default: {
                        var17_17 = var11_11;
                        var18_19 = var12_12;
                        break;
                    }
                    case 825323514: {
                        var19_18 = "machuca";
                        var17_17 = (int)var15_15.equals(var19_18);
                        if (var17_17 == 0) ** GOTO lbl-1000
                        var17_17 = var1_1;
                        var18_19 = var2_2;
                        break;
                    }
                    case -64886864: {
                        var19_18 = "magnolia";
                        var17_17 = (int)var15_15.equals(var19_18);
                        if (var17_17 == 0) ** GOTO lbl-1000
                        var17_17 = var3_3;
                        var18_19 = var4_4;
                        break;
                    }
                    case -1012436106: {
                        var19_18 = "oneday";
                        var17_17 = (int)var15_15.equals(var19_18);
                        if (var17_17 == 0) ** GOTO lbl-1000
                        var17_17 = var5_5;
                        var18_19 = var6_6;
                        break;
                    }
                    case -1220066608: {
                        var19_18 = "dangalUHD";
                        var17_17 = (int)var15_15.equals(var19_18);
                        if (var17_17 == 0) ** GOTO lbl-1000
                        var17_17 = var9_9;
                        var18_19 = var10_10;
                        break;
                    }
                    case -1220081023: {
                        var19_18 = "dangalFHD";
                        var17_17 = (int)var15_15.equals(var19_18);
                        if (var17_17 == 0) ** GOTO lbl-1000
                        var17_17 = var13_13;
                        var18_19 = var14_14;
                        break;
                    }
                    case -1339091551: {
                        var19_18 = "dangal";
                        var17_17 = (int)var15_15.equals(var19_18);
                        if (var17_17 == 0) ** GOTO lbl-1000
                        var17_17 = 0;
                        var15_15 = null;
                        var18_19 = 0.0f;
                    }
                }
                switch (var17_17) {
                    default: {
                        break;
                    }
                    case 0: 
                    case 1: 
                    case 2: 
                    case 3: 
                    case 4: 
                    case 5: {
                        return (boolean)var13_13;
                    }
                }
            }
            var17_17 = 27;
            var18_19 = 3.8E-44f;
            if (var0 <= var17_17 && (var16_16 = (int)(var20_20 = "HWEML").equals(var19_18 = Util.DEVICE)) != 0) {
                return (boolean)var13_13;
            }
            var16_16 = 26;
            var21_21 = 3.6E-44f;
            if (var0 > var16_16) break block169;
            var22_22 = Util.DEVICE;
            var22_22.hashCode();
            var23_23 = var22_22.hashCode();
            switch (var23_23) lbl-1000:
            // 141 sources

            {
                default: {
                    var1_1 = var11_11;
                    var2_2 = var12_12;
                    break;
                }
                case 2048855701: {
                    var24_24 = "HWWAS-H";
                    var0 = (int)var22_22.equals(var24_24);
                    if (var0 == 0) ** GOTO lbl-1000
                    var1_1 = 139;
                    var2_2 = 1.95E-43f;
                    break;
                }
                case 2048319463: {
                    var24_24 = "HWVNS-H";
                    var0 = (int)var22_22.equals(var24_24);
                    if (var0 == 0) ** GOTO lbl-1000
                    var1_1 = 138;
                    var2_2 = 1.93E-43f;
                    break;
                }
                case 2047252157: {
                    var24_24 = "ELUGA_Prim";
                    var0 = (int)var22_22.equals(var24_24);
                    if (var0 == 0) ** GOTO lbl-1000
                    var1_1 = 137;
                    var2_2 = 1.92E-43f;
                    break;
                }
                case 2047190025: {
                    var24_24 = "ELUGA_Note";
                    var0 = (int)var22_22.equals(var24_24);
                    if (var0 == 0) ** GOTO lbl-1000
                    var1_1 = 136;
                    var2_2 = 1.9E-43f;
                    break;
                }
                case 2033393791: {
                    var24_24 = "ASUS_X00AD_2";
                    var0 = (int)var22_22.equals(var24_24);
                    if (var0 == 0) ** GOTO lbl-1000
                    var1_1 = 135;
                    var2_2 = 1.89E-43f;
                    break;
                }
                case 2030379515: {
                    var24_24 = "HWCAM-H";
                    var0 = (int)var22_22.equals(var24_24);
                    if (var0 == 0) ** GOTO lbl-1000
                    var1_1 = 134;
                    var2_2 = 1.88E-43f;
                    break;
                }
                case 2029784656: {
                    var24_24 = "HWBLN-H";
                    var0 = (int)var22_22.equals(var24_24);
                    if (var0 == 0) ** GOTO lbl-1000
                    var1_1 = 133;
                    var2_2 = 1.86E-43f;
                    break;
                }
                case 2019281702: {
                    var24_24 = "DM-01K";
                    var0 = (int)var22_22.equals(var24_24);
                    if (var0 == 0) ** GOTO lbl-1000
                    var1_1 = 132;
                    var2_2 = 1.85E-43f;
                    break;
                }
                case 2006372676: {
                    var24_24 = "BRAVIA_ATV3_4K";
                    var0 = (int)var22_22.equals(var24_24);
                    if (var0 == 0) ** GOTO lbl-1000
                    var1_1 = 131;
                    var2_2 = 1.84E-43f;
                    break;
                }
                case 1977196784: {
                    var24_24 = "Infinix-X572";
                    var0 = (int)var22_22.equals(var24_24);
                    if (var0 == 0) ** GOTO lbl-1000
                    var1_1 = 130;
                    var2_2 = 1.82E-43f;
                    break;
                }
                case 1906253259: {
                    var24_24 = "PB2-670M";
                    var0 = (int)var22_22.equals(var24_24);
                    if (var0 == 0) ** GOTO lbl-1000
                    var1_1 = 129;
                    var2_2 = 1.81E-43f;
                    break;
                }
                case 1865889110: {
                    var24_24 = "santoni";
                    var0 = (int)var22_22.equals(var24_24);
                    if (var0 == 0) ** GOTO lbl-1000
                    var1_1 = 128;
                    var2_2 = 1.794E-43f;
                    break;
                }
                case 1709443163: {
                    var24_24 = "iball8735_9806";
                    var0 = (int)var22_22.equals(var24_24);
                    if (var0 == 0) ** GOTO lbl-1000
                    var1_1 = 127;
                    var2_2 = 1.78E-43f;
                    break;
                }
                case 1691544261: {
                    var24_24 = "CPH1715";
                    var0 = (int)var22_22.equals(var24_24);
                    if (var0 == 0) ** GOTO lbl-1000
                    var1_1 = 126;
                    var2_2 = 1.77E-43f;
                    break;
                }
                case 1691543273: {
                    var24_24 = "CPH1609";
                    var0 = (int)var22_22.equals(var24_24);
                    if (var0 == 0) ** GOTO lbl-1000
                    var1_1 = 125;
                    var2_2 = 1.75E-43f;
                    break;
                }
                case 1522194893: {
                    var24_24 = "woods_f";
                    var0 = (int)var22_22.equals(var24_24);
                    if (var0 == 0) ** GOTO lbl-1000
                    var1_1 = 124;
                    var2_2 = 1.74E-43f;
                    break;
                }
                case 1349174697: {
                    var24_24 = "htc_e56ml_dtul";
                    var0 = (int)var22_22.equals(var24_24);
                    if (var0 == 0) ** GOTO lbl-1000
                    var1_1 = 123;
                    var2_2 = 1.72E-43f;
                    break;
                }
                case 1306947716: {
                    var24_24 = "EverStar_S";
                    var0 = (int)var22_22.equals(var24_24);
                    if (var0 == 0) ** GOTO lbl-1000
                    var1_1 = 122;
                    var2_2 = 1.71E-43f;
                    break;
                }
                case 1280332038: {
                    var24_24 = "hwALE-H";
                    var0 = (int)var22_22.equals(var24_24);
                    if (var0 == 0) ** GOTO lbl-1000
                    var1_1 = 121;
                    var2_2 = 1.7E-43f;
                    break;
                }
                case 1176899427: {
                    var24_24 = "itel_S41";
                    var0 = (int)var22_22.equals(var24_24);
                    if (var0 == 0) ** GOTO lbl-1000
                    var1_1 = 120;
                    var2_2 = 1.68E-43f;
                    break;
                }
                case 1150207623: {
                    var24_24 = "LS-5017";
                    var0 = (int)var22_22.equals(var24_24);
                    if (var0 == 0) ** GOTO lbl-1000
                    var1_1 = 119;
                    var2_2 = 1.67E-43f;
                    break;
                }
                case 1060579533: {
                    var24_24 = "panell_d";
                    var0 = (int)var22_22.equals(var24_24);
                    if (var0 == 0) ** GOTO lbl-1000
                    var1_1 = 118;
                    var2_2 = 1.65E-43f;
                    break;
                }
                case 958008161: {
                    var24_24 = "j2xlteins";
                    var0 = (int)var22_22.equals(var24_24);
                    if (var0 == 0) ** GOTO lbl-1000
                    var1_1 = 117;
                    var2_2 = 1.64E-43f;
                    break;
                }
                case 917340916: {
                    var24_24 = "A7000plus";
                    var0 = (int)var22_22.equals(var24_24);
                    if (var0 == 0) ** GOTO lbl-1000
                    var1_1 = 116;
                    var2_2 = 1.63E-43f;
                    break;
                }
                case 835649806: {
                    var24_24 = "manning";
                    var0 = (int)var22_22.equals(var24_24);
                    if (var0 == 0) ** GOTO lbl-1000
                    var1_1 = 115;
                    var2_2 = 1.61E-43f;
                    break;
                }
                case 794040393: {
                    var24_24 = "GIONEE_WBL7519";
                    var0 = (int)var22_22.equals(var24_24);
                    if (var0 == 0) ** GOTO lbl-1000
                    var1_1 = 114;
                    var2_2 = 1.6E-43f;
                    break;
                }
                case 794038622: {
                    var24_24 = "GIONEE_WBL7365";
                    var0 = (int)var22_22.equals(var24_24);
                    if (var0 == 0) ** GOTO lbl-1000
                    var1_1 = 113;
                    var2_2 = 1.58E-43f;
                    break;
                }
                case 793982701: {
                    var24_24 = "GIONEE_WBL5708";
                    var0 = (int)var22_22.equals(var24_24);
                    if (var0 == 0) ** GOTO lbl-1000
                    var1_1 = 112;
                    var2_2 = 1.57E-43f;
                    break;
                }
                case 507412548: {
                    var24_24 = "QM16XE_U";
                    var0 = (int)var22_22.equals(var24_24);
                    if (var0 == 0) ** GOTO lbl-1000
                    var1_1 = 111;
                    var2_2 = 1.56E-43f;
                    break;
                }
                case 407160593: {
                    var24_24 = "Pixi5-10_4G";
                    var0 = (int)var22_22.equals(var24_24);
                    if (var0 == 0) ** GOTO lbl-1000
                    var1_1 = 110;
                    var2_2 = 1.54E-43f;
                    break;
                }
                case 316246818: {
                    var24_24 = "TB3-850M";
                    var0 = (int)var22_22.equals(var24_24);
                    if (var0 == 0) ** GOTO lbl-1000
                    var1_1 = 109;
                    var2_2 = 1.53E-43f;
                    break;
                }
                case 316246811: {
                    var24_24 = "TB3-850F";
                    var0 = (int)var22_22.equals(var24_24);
                    if (var0 == 0) ** GOTO lbl-1000
                    var1_1 = 108;
                    var2_2 = 1.51E-43f;
                    break;
                }
                case 316215116: {
                    var24_24 = "TB3-730X";
                    var0 = (int)var22_22.equals(var24_24);
                    if (var0 == 0) ** GOTO lbl-1000
                    var1_1 = 107;
                    var2_2 = 1.5E-43f;
                    break;
                }
                case 316215098: {
                    var24_24 = "TB3-730F";
                    var0 = (int)var22_22.equals(var24_24);
                    if (var0 == 0) ** GOTO lbl-1000
                    var1_1 = 106;
                    var2_2 = 1.49E-43f;
                    break;
                }
                case 308517133: {
                    var24_24 = "A7020a48";
                    var0 = (int)var22_22.equals(var24_24);
                    if (var0 == 0) ** GOTO lbl-1000
                    var1_1 = 105;
                    var2_2 = 1.47E-43f;
                    break;
                }
                case 307593612: {
                    var24_24 = "A7010a48";
                    var0 = (int)var22_22.equals(var24_24);
                    if (var0 == 0) ** GOTO lbl-1000
                    var1_1 = 104;
                    var2_2 = 1.46E-43f;
                    break;
                }
                case 287431619: {
                    var24_24 = "griffin";
                    var0 = (int)var22_22.equals(var24_24);
                    if (var0 == 0) ** GOTO lbl-1000
                    var1_1 = 103;
                    var2_2 = 1.44E-43f;
                    break;
                }
                case 245388979: {
                    var24_24 = "marino_f";
                    var0 = (int)var22_22.equals(var24_24);
                    if (var0 == 0) ** GOTO lbl-1000
                    var1_1 = 102;
                    var2_2 = 1.43E-43f;
                    break;
                }
                case 182191441: {
                    var24_24 = "CPY83_I00";
                    var0 = (int)var22_22.equals(var24_24);
                    if (var0 == 0) ** GOTO lbl-1000
                    var1_1 = 101;
                    var2_2 = 1.42E-43f;
                    break;
                }
                case 165221241: {
                    var24_24 = "A2016a40";
                    var0 = (int)var22_22.equals(var24_24);
                    if (var0 == 0) ** GOTO lbl-1000
                    var1_1 = 100;
                    var2_2 = 1.4E-43f;
                    break;
                }
                case 102844228: {
                    var24_24 = "le_x6";
                    var0 = (int)var22_22.equals(var24_24);
                    if (var0 == 0) ** GOTO lbl-1000
                    var1_1 = 99;
                    var2_2 = 1.39E-43f;
                    break;
                }
                case 101370885: {
                    var24_24 = "l5460";
                    var0 = (int)var22_22.equals(var24_24);
                    if (var0 == 0) ** GOTO lbl-1000
                    var1_1 = 98;
                    var2_2 = 1.37E-43f;
                    break;
                }
                case 98715550: {
                    var24_24 = "i9031";
                    var0 = (int)var22_22.equals(var24_24);
                    if (var0 == 0) ** GOTO lbl-1000
                    var1_1 = 97;
                    var2_2 = 1.36E-43f;
                    break;
                }
                case 82882791: {
                    var24_24 = "X3_HK";
                    var0 = (int)var22_22.equals(var24_24);
                    if (var0 == 0) ** GOTO lbl-1000
                    var1_1 = 96;
                    var2_2 = 1.35E-43f;
                    break;
                }
                case 80963634: {
                    var24_24 = "V23GB";
                    var0 = (int)var22_22.equals(var24_24);
                    if (var0 == 0) ** GOTO lbl-1000
                    var1_1 = 95;
                    var2_2 = 1.33E-43f;
                    break;
                }
                case 76404911: {
                    var24_24 = "Q4310";
                    var0 = (int)var22_22.equals(var24_24);
                    if (var0 == 0) ** GOTO lbl-1000
                    var1_1 = 94;
                    var2_2 = 1.32E-43f;
                    break;
                }
                case 76404105: {
                    var24_24 = "Q4260";
                    var0 = (int)var22_22.equals(var24_24);
                    if (var0 == 0) ** GOTO lbl-1000
                    var1_1 = 93;
                    var2_2 = 1.3E-43f;
                    break;
                }
                case 76402249: {
                    var24_24 = "PRO7S";
                    var0 = (int)var22_22.equals(var24_24);
                    if (var0 == 0) ** GOTO lbl-1000
                    var1_1 = 92;
                    var2_2 = 1.29E-43f;
                    break;
                }
                case 66216390: {
                    var24_24 = "F3311";
                    var0 = (int)var22_22.equals(var24_24);
                    if (var0 == 0) ** GOTO lbl-1000
                    var1_1 = 91;
                    var2_2 = 1.28E-43f;
                    break;
                }
                case 66215433: {
                    var24_24 = "F3215";
                    var0 = (int)var22_22.equals(var24_24);
                    if (var0 == 0) ** GOTO lbl-1000
                    var1_1 = 90;
                    var2_2 = 1.26E-43f;
                    break;
                }
                case 66215431: {
                    var24_24 = "F3213";
                    var0 = (int)var22_22.equals(var24_24);
                    if (var0 == 0) ** GOTO lbl-1000
                    var1_1 = 89;
                    var2_2 = 1.25E-43f;
                    break;
                }
                case 66215429: {
                    var24_24 = "F3211";
                    var0 = (int)var22_22.equals(var24_24);
                    if (var0 == 0) ** GOTO lbl-1000
                    var1_1 = 88;
                    var2_2 = 1.23E-43f;
                    break;
                }
                case 66214473: {
                    var24_24 = "F3116";
                    var0 = (int)var22_22.equals(var24_24);
                    if (var0 == 0) ** GOTO lbl-1000
                    var1_1 = 87;
                    var2_2 = 1.22E-43f;
                    break;
                }
                case 66214470: {
                    var24_24 = "F3113";
                    var0 = (int)var22_22.equals(var24_24);
                    if (var0 == 0) ** GOTO lbl-1000
                    var1_1 = 86;
                    var2_2 = 1.2E-43f;
                    break;
                }
                case 66214468: {
                    var24_24 = "F3111";
                    var0 = (int)var22_22.equals(var24_24);
                    if (var0 == 0) ** GOTO lbl-1000
                    var1_1 = 85;
                    var2_2 = 1.19E-43f;
                    break;
                }
                case 65355429: {
                    var24_24 = "E5643";
                    var0 = (int)var22_22.equals(var24_24);
                    if (var0 == 0) ** GOTO lbl-1000
                    var1_1 = 84;
                    var2_2 = 1.18E-43f;
                    break;
                }
                case 61542055: {
                    var24_24 = "A1601";
                    var0 = (int)var22_22.equals(var24_24);
                    if (var0 == 0) ** GOTO lbl-1000
                    var1_1 = 83;
                    var2_2 = 1.16E-43f;
                    break;
                }
                case 55178625: {
                    var24_24 = "Aura_Note_2";
                    var0 = (int)var22_22.equals(var24_24);
                    if (var0 == 0) ** GOTO lbl-1000
                    var1_1 = 82;
                    var2_2 = 1.15E-43f;
                    break;
                }
                case 51350594: {
                    var24_24 = "602LV";
                    var0 = (int)var22_22.equals(var24_24);
                    if (var0 == 0) ** GOTO lbl-1000
                    var1_1 = 81;
                    var2_2 = 1.14E-43f;
                    break;
                }
                case 51349633: {
                    var24_24 = "601LV";
                    var0 = (int)var22_22.equals(var24_24);
                    if (var0 == 0) ** GOTO lbl-1000
                    var1_1 = 80;
                    var2_2 = 1.12E-43f;
                    break;
                }
                case 41325051: {
                    var24_24 = "MEIZU_M5";
                    var0 = (int)var22_22.equals(var24_24);
                    if (var0 == 0) ** GOTO lbl-1000
                    var1_1 = 79;
                    var2_2 = 1.11E-43f;
                    break;
                }
                case 3386211: {
                    var24_24 = "p212";
                    var0 = (int)var22_22.equals(var24_24);
                    if (var0 == 0) ** GOTO lbl-1000
                    var1_1 = 78;
                    var2_2 = 1.1E-43f;
                    break;
                }
                case 0x332327: {
                    var24_24 = "mido";
                    var0 = (int)var22_22.equals(var24_24);
                    if (var0 == 0) ** GOTO lbl-1000
                    var1_1 = 77;
                    var2_2 = 1.08E-43f;
                    break;
                }
                case 3284551: {
                    var24_24 = "kate";
                    var0 = (int)var22_22.equals(var24_24);
                    if (var0 == 0) ** GOTO lbl-1000
                    var1_1 = 76;
                    var2_2 = 1.06E-43f;
                    break;
                }
                case 3154429: {
                    var24_24 = "fugu";
                    var0 = (int)var22_22.equals(var24_24);
                    if (var0 == 0) ** GOTO lbl-1000
                    var1_1 = 75;
                    var2_2 = 1.05E-43f;
                    break;
                }
                case 2689555: {
                    var24_24 = "XE2X";
                    var0 = (int)var22_22.equals(var24_24);
                    if (var0 == 0) ** GOTO lbl-1000
                    var1_1 = 74;
                    var2_2 = 1.04E-43f;
                    break;
                }
                case 2464648: {
                    var24_24 = "Q427";
                    var0 = (int)var22_22.equals(var24_24);
                    if (var0 == 0) ** GOTO lbl-1000
                    var1_1 = 73;
                    var2_2 = 1.02E-43f;
                    break;
                }
                case 2463773: {
                    var24_24 = "Q350";
                    var0 = (int)var22_22.equals(var24_24);
                    if (var0 == 0) ** GOTO lbl-1000
                    var1_1 = 72;
                    var2_2 = 1.01E-43f;
                    break;
                }
                case 0x252F5F: {
                    var24_24 = "P681";
                    var0 = (int)var22_22.equals(var24_24);
                    if (var0 == 0) ** GOTO lbl-1000
                    var1_1 = 71;
                    var2_2 = 1.0E-43f;
                    break;
                }
                case 2133184: {
                    var24_24 = "F04J";
                    var0 = (int)var22_22.equals(var24_24);
                    if (var0 == 0) ** GOTO lbl-1000
                    var1_1 = 70;
                    var2_2 = 9.8E-44f;
                    break;
                }
                case 2133182: {
                    var24_24 = "F04H";
                    var0 = (int)var22_22.equals(var24_24);
                    if (var0 == 0) ** GOTO lbl-1000
                    var1_1 = 69;
                    var2_2 = 9.7E-44f;
                    break;
                }
                case 2133151: {
                    var24_24 = "F03H";
                    var0 = (int)var22_22.equals(var24_24);
                    if (var0 == 0) ** GOTO lbl-1000
                    var1_1 = 68;
                    var2_2 = 9.5E-44f;
                    break;
                }
                case 2133120: {
                    var24_24 = "F02H";
                    var0 = (int)var22_22.equals(var24_24);
                    if (var0 == 0) ** GOTO lbl-1000
                    var1_1 = 67;
                    var2_2 = 9.4E-44f;
                    break;
                }
                case 2133091: {
                    var24_24 = "F01J";
                    var0 = (int)var22_22.equals(var24_24);
                    if (var0 == 0) ** GOTO lbl-1000
                    var1_1 = 66;
                    var2_2 = 9.2E-44f;
                    break;
                }
                case 2133089: {
                    var24_24 = "F01H";
                    var0 = (int)var22_22.equals(var24_24);
                    if (var0 == 0) ** GOTO lbl-1000
                    var1_1 = 65;
                    var2_2 = 9.1E-44f;
                    break;
                }
                case 1514185: {
                    var24_24 = "1714";
                    var0 = (int)var22_22.equals(var24_24);
                    if (var0 == 0) ** GOTO lbl-1000
                    var1_1 = 64;
                    var2_2 = 9.0E-44f;
                    break;
                }
                case 1514184: {
                    var24_24 = "1713";
                    var0 = (int)var22_22.equals(var24_24);
                    if (var0 == 0) ** GOTO lbl-1000
                    var1_1 = 63;
                    var2_2 = 8.8E-44f;
                    break;
                }
                case 1513190: {
                    var24_24 = "1601";
                    var0 = (int)var22_22.equals(var24_24);
                    if (var0 == 0) ** GOTO lbl-1000
                    var1_1 = 62;
                    var2_2 = 8.7E-44f;
                    break;
                }
                case 101481: {
                    var24_24 = "flo";
                    var0 = (int)var22_22.equals(var24_24);
                    if (var0 == 0) ** GOTO lbl-1000
                    var1_1 = 61;
                    var2_2 = 8.5E-44f;
                    break;
                }
                case 99329: {
                    var24_24 = "deb";
                    var0 = (int)var22_22.equals(var24_24);
                    if (var0 == 0) ** GOTO lbl-1000
                    var1_1 = 60;
                    var2_2 = 8.4E-44f;
                    break;
                }
                case 98848: {
                    var24_24 = "cv3";
                    var0 = (int)var22_22.equals(var24_24);
                    if (var0 == 0) ** GOTO lbl-1000
                    var1_1 = 59;
                    var2_2 = 8.3E-44f;
                    break;
                }
                case 98846: {
                    var24_24 = "cv1";
                    var0 = (int)var22_22.equals(var24_24);
                    if (var0 == 0) ** GOTO lbl-1000
                    var1_1 = 58;
                    var2_2 = 8.1E-44f;
                    break;
                }
                case 88274: {
                    var24_24 = "Z80";
                    var0 = (int)var22_22.equals(var24_24);
                    if (var0 == 0) ** GOTO lbl-1000
                    var1_1 = 57;
                    var2_2 = 8.0E-44f;
                    break;
                }
                case 80618: {
                    var24_24 = "QX1";
                    var0 = (int)var22_22.equals(var24_24);
                    if (var0 == 0) ** GOTO lbl-1000
                    var1_1 = 56;
                    var2_2 = 7.8E-44f;
                    break;
                }
                case 79305: {
                    var24_24 = "PLE";
                    var0 = (int)var22_22.equals(var24_24);
                    if (var0 == 0) ** GOTO lbl-1000
                    var1_1 = 55;
                    var2_2 = 7.7E-44f;
                    break;
                }
                case 78669: {
                    var24_24 = "P85";
                    var0 = (int)var22_22.equals(var24_24);
                    if (var0 == 0) ** GOTO lbl-1000
                    var1_1 = 54;
                    var2_2 = 7.6E-44f;
                    break;
                }
                case 76779: {
                    var24_24 = "MX6";
                    var0 = (int)var22_22.equals(var24_24);
                    if (var0 == 0) ** GOTO lbl-1000
                    var1_1 = 53;
                    var2_2 = 7.4E-44f;
                    break;
                }
                case 75739: {
                    var24_24 = "M5c";
                    var0 = (int)var22_22.equals(var24_24);
                    if (var0 == 0) ** GOTO lbl-1000
                    var1_1 = 52;
                    var2_2 = 7.3E-44f;
                    break;
                }
                case 75537: {
                    var24_24 = "M04";
                    var0 = (int)var22_22.equals(var24_24);
                    if (var0 == 0) ** GOTO lbl-1000
                    var1_1 = 51;
                    var2_2 = 7.1E-44f;
                    break;
                }
                case 73405: {
                    var24_24 = "JGZ";
                    var0 = (int)var22_22.equals(var24_24);
                    if (var0 == 0) ** GOTO lbl-1000
                    var1_1 = 50;
                    var2_2 = 7.0E-44f;
                    break;
                }
                case 3483: {
                    var24_24 = "mh";
                    var0 = (int)var22_22.equals(var24_24);
                    if (var0 == 0) ** GOTO lbl-1000
                    var1_1 = 49;
                    var2_2 = 6.9E-44f;
                    break;
                }
                case 3091: {
                    var24_24 = "b5";
                    var0 = (int)var22_22.equals(var24_24);
                    if (var0 == 0) ** GOTO lbl-1000
                    var1_1 = 48;
                    var2_2 = 6.7E-44f;
                    break;
                }
                case 2719: {
                    var24_24 = "V5";
                    var0 = (int)var22_22.equals(var24_24);
                    if (var0 == 0) ** GOTO lbl-1000
                    var1_1 = 47;
                    var2_2 = 6.6E-44f;
                    break;
                }
                case 2715: {
                    var24_24 = "V1";
                    var0 = (int)var22_22.equals(var24_24);
                    if (var0 == 0) ** GOTO lbl-1000
                    var1_1 = 46;
                    var2_2 = 6.4E-44f;
                    break;
                }
                case 2564: {
                    var24_24 = "Q5";
                    var0 = (int)var22_22.equals(var24_24);
                    if (var0 == 0) ** GOTO lbl-1000
                    var1_1 = 45;
                    var2_2 = 6.3E-44f;
                    break;
                }
                case 2126: {
                    var24_24 = "C1";
                    var0 = (int)var22_22.equals(var24_24);
                    if (var0 == 0) ** GOTO lbl-1000
                    var1_1 = 44;
                    var2_2 = 6.2E-44f;
                    break;
                }
                case -56598463: {
                    var24_24 = "woods_fn";
                    var0 = (int)var22_22.equals(var24_24);
                    if (var0 == 0) ** GOTO lbl-1000
                    var1_1 = 43;
                    var2_2 = 6.0E-44f;
                    break;
                }
                case -173639913: {
                    var24_24 = "ELUGA_A3_Pro";
                    var0 = (int)var22_22.equals(var24_24);
                    if (var0 == 0) ** GOTO lbl-1000
                    var1_1 = 42;
                    var2_2 = 5.9E-44f;
                    break;
                }
                case -277133239: {
                    var24_24 = "Z12_PRO";
                    var0 = (int)var22_22.equals(var24_24);
                    if (var0 == 0) ** GOTO lbl-1000
                    var1_1 = 41;
                    var2_2 = 5.7E-44f;
                    break;
                }
                case -282781963: {
                    var24_24 = "BLACK-1X";
                    var0 = (int)var22_22.equals(var24_24);
                    if (var0 == 0) ** GOTO lbl-1000
                    var1_1 = 40;
                    var2_2 = 5.6E-44f;
                    break;
                }
                case -290434366: {
                    var24_24 = "taido_row";
                    var0 = (int)var22_22.equals(var24_24);
                    if (var0 == 0) ** GOTO lbl-1000
                    var1_1 = 39;
                    var2_2 = 5.5E-44f;
                    break;
                }
                case -430914369: {
                    var24_24 = "Pixi4-7_3G";
                    var0 = (int)var22_22.equals(var24_24);
                    if (var0 == 0) ** GOTO lbl-1000
                    var1_1 = 38;
                    var2_2 = 5.3E-44f;
                    break;
                }
                case -521118391: {
                    var24_24 = "GIONEE_GBL7360";
                    var0 = (int)var22_22.equals(var24_24);
                    if (var0 == 0) ** GOTO lbl-1000
                    var1_1 = 37;
                    var2_2 = 5.2E-44f;
                    break;
                }
                case -575125681: {
                    var24_24 = "GiONEE_CBL7513";
                    var0 = (int)var22_22.equals(var24_24);
                    if (var0 == 0) ** GOTO lbl-1000
                    var1_1 = 36;
                    var2_2 = 5.0E-44f;
                    break;
                }
                case -782144577: {
                    var24_24 = "OnePlus5T";
                    var0 = (int)var22_22.equals(var24_24);
                    if (var0 == 0) ** GOTO lbl-1000
                    var1_1 = 35;
                    var2_2 = 4.9E-44f;
                    break;
                }
                case -788334647: {
                    var24_24 = "whyred";
                    var0 = (int)var22_22.equals(var24_24);
                    if (var0 == 0) ** GOTO lbl-1000
                    var1_1 = 34;
                    var2_2 = 4.8E-44f;
                    break;
                }
                case -794946968: {
                    var24_24 = "watson";
                    var0 = (int)var22_22.equals(var24_24);
                    if (var0 == 0) ** GOTO lbl-1000
                    var1_1 = 33;
                    var2_2 = 4.6E-44f;
                    break;
                }
                case -797483286: {
                    var24_24 = "SVP-DTV15";
                    var0 = (int)var22_22.equals(var24_24);
                    if (var0 == 0) ** GOTO lbl-1000
                    var1_1 = 32;
                    var2_2 = 4.5E-44f;
                    break;
                }
                case -821392978: {
                    var24_24 = "A7000-a";
                    var0 = (int)var22_22.equals(var24_24);
                    if (var0 == 0) ** GOTO lbl-1000
                    var1_1 = 31;
                    var2_2 = 4.3E-44f;
                    break;
                }
                case -842500323: {
                    var24_24 = "nicklaus_f";
                    var0 = (int)var22_22.equals(var24_24);
                    if (var0 == 0) ** GOTO lbl-1000
                    var1_1 = 30;
                    var2_2 = 4.2E-44f;
                    break;
                }
                case -879245230: {
                    var24_24 = "tcl_eu";
                    var0 = (int)var22_22.equals(var24_24);
                    if (var0 == 0) ** GOTO lbl-1000
                    var1_1 = 29;
                    var2_2 = 4.1E-44f;
                    break;
                }
                case -958336948: {
                    var24_24 = "ELUGA_Ray_X";
                    var0 = (int)var22_22.equals(var24_24);
                    if (var0 == 0) ** GOTO lbl-1000
                    var1_1 = var7_7;
                    var2_2 = var8_8;
                    break;
                }
                case -965403638: {
                    var24_24 = "s905x018";
                    var0 = (int)var22_22.equals(var24_24);
                    if (var0 == 0) ** GOTO lbl-1000
                    var1_1 = var17_17;
                    var2_2 = var18_19;
                    break;
                }
                case -993250458: {
                    var24_24 = "A10-70L";
                    var0 = (int)var22_22.equals(var24_24);
                    if (var0 == 0) ** GOTO lbl-1000
                    var1_1 = var16_16;
                    var2_2 = var21_21;
                    break;
                }
                case -993250464: {
                    var24_24 = "A10-70F";
                    var0 = (int)var22_22.equals(var24_24);
                    if (var0 == 0) ** GOTO lbl-1000
                    var1_1 = 25;
                    var2_2 = 3.5E-44f;
                    break;
                }
                case -1052835013: {
                    var24_24 = "namath";
                    var0 = (int)var22_22.equals(var24_24);
                    if (var0 == 0) ** GOTO lbl-1000
                    var1_1 = 24;
                    var2_2 = 3.4E-44f;
                    break;
                }
                case -1139198265: {
                    var24_24 = "Slate_Pro";
                    var0 = (int)var22_22.equals(var24_24);
                    if (var0 == 0) ** GOTO lbl-1000
                    var1_1 = 23;
                    var2_2 = 3.2E-44f;
                    break;
                }
                case -1180384755: {
                    var24_24 = "iris60";
                    var0 = (int)var22_22.equals(var24_24);
                    if (var0 == 0) ** GOTO lbl-1000
                    var1_1 = 22;
                    var2_2 = 3.1E-44f;
                    break;
                }
                case -1217592143: {
                    var24_24 = "BRAVIA_ATV2";
                    var0 = (int)var22_22.equals(var24_24);
                    if (var0 == 0) ** GOTO lbl-1000
                    var1_1 = 21;
                    var2_2 = 2.9E-44f;
                    break;
                }
                case -1320080169: {
                    var24_24 = "GiONEE_GBL7319";
                    var0 = (int)var22_22.equals(var24_24);
                    if (var0 == 0) ** GOTO lbl-1000
                    var1_1 = 20;
                    var2_2 = 2.8E-44f;
                    break;
                }
                case -1481772729: {
                    var24_24 = "panell_dt";
                    var0 = (int)var22_22.equals(var24_24);
                    if (var0 == 0) ** GOTO lbl-1000
                    var1_1 = 19;
                    var2_2 = 2.7E-44f;
                    break;
                }
                case -1481772730: {
                    var24_24 = "panell_ds";
                    var0 = (int)var22_22.equals(var24_24);
                    if (var0 == 0) ** GOTO lbl-1000
                    var1_1 = 18;
                    var2_2 = 2.5E-44f;
                    break;
                }
                case -1481772737: {
                    var24_24 = "panell_dl";
                    var0 = (int)var22_22.equals(var24_24);
                    if (var0 == 0) ** GOTO lbl-1000
                    var1_1 = 17;
                    var2_2 = 2.4E-44f;
                    break;
                }
                case -1554255044: {
                    var24_24 = "vernee_M5";
                    var0 = (int)var22_22.equals(var24_24);
                    if (var0 == 0) ** GOTO lbl-1000
                    var1_1 = 16;
                    var2_2 = 2.24E-44f;
                    break;
                }
                case -1600724499: {
                    var24_24 = "pacificrim";
                    var0 = (int)var22_22.equals(var24_24);
                    if (var0 == 0) ** GOTO lbl-1000
                    var1_1 = 15;
                    var2_2 = 2.1E-44f;
                    break;
                }
                case -1615810839: {
                    var24_24 = "Phantom6";
                    var0 = (int)var22_22.equals(var24_24);
                    if (var0 == 0) ** GOTO lbl-1000
                    var1_1 = 14;
                    var2_2 = 2.0E-44f;
                    break;
                }
                case -1680025915: {
                    var24_24 = "ComioS1";
                    var0 = (int)var22_22.equals(var24_24);
                    if (var0 == 0) ** GOTO lbl-1000
                    var1_1 = 13;
                    var2_2 = 1.8E-44f;
                    break;
                }
                case -1696512866: {
                    var24_24 = "XT1663";
                    var0 = (int)var22_22.equals(var24_24);
                    if (var0 == 0) ** GOTO lbl-1000
                    var1_1 = 12;
                    var2_2 = 1.7E-44f;
                    break;
                }
                case -1885099851: {
                    var24_24 = "RAIJIN";
                    var0 = (int)var22_22.equals(var24_24);
                    if (var0 == 0) ** GOTO lbl-1000
                    var1_1 = 11;
                    var2_2 = 1.5E-44f;
                    break;
                }
                case -1931988508: {
                    var24_24 = "AquaPowerM";
                    var0 = (int)var22_22.equals(var24_24);
                    if (var0 == 0) ** GOTO lbl-1000
                    var1_1 = 10;
                    var2_2 = 1.4E-44f;
                    break;
                }
                case -1936688065: {
                    var24_24 = "PGN611";
                    var0 = (int)var22_22.equals(var24_24);
                    if (var0 == 0) ** GOTO lbl-1000
                    var1_1 = 9;
                    var2_2 = 1.3E-44f;
                    break;
                }
                case -1936688066: {
                    var24_24 = "PGN610";
                    var0 = (int)var22_22.equals(var24_24);
                    if (var0 == 0) ** GOTO lbl-1000
                    var1_1 = 8;
                    var2_2 = 1.1E-44f;
                    break;
                }
                case -1936688988: {
                    var24_24 = "PGN528";
                    var0 = (int)var22_22.equals(var24_24);
                    if (var0 == 0) ** GOTO lbl-1000
                    var1_1 = 7;
                    var2_2 = 9.8E-45f;
                    break;
                }
                case -1978990237: {
                    var24_24 = "NX573J";
                    var0 = (int)var22_22.equals(var24_24);
                    if (var0 == 0) ** GOTO lbl-1000
                    var1_1 = 6;
                    var2_2 = 8.4E-45f;
                    break;
                }
                case -1978993182: {
                    var25_25 = "NX541J";
                    var0 = (int)var22_22.equals(var25_25);
                    if (var0 != 0) break;
                    ** GOTO lbl-1000
                }
                case -2022874474: {
                    var24_24 = "CP8676_I02";
                    var0 = (int)var22_22.equals(var24_24);
                    if (var0 == 0) ** GOTO lbl-1000
                    var1_1 = var3_3;
                    var2_2 = var4_4;
                    break;
                }
                case -2097309513: {
                    var24_24 = "K50a40";
                    var0 = (int)var22_22.equals(var24_24);
                    if (var0 == 0) ** GOTO lbl-1000
                    var1_1 = var5_5;
                    var2_2 = var6_6;
                    break;
                }
                case -2144781160: {
                    var24_24 = "GIONEE_SWW1631";
                    var0 = (int)var22_22.equals(var24_24);
                    if (var0 == 0) ** GOTO lbl-1000
                    var1_1 = var9_9;
                    var2_2 = var10_10;
                    break;
                }
                case -2144781185: {
                    var24_24 = "GIONEE_SWW1627";
                    var0 = (int)var22_22.equals(var24_24);
                    if (var0 == 0) ** GOTO lbl-1000
                    var1_1 = var13_13;
                    var2_2 = var14_14;
                    break;
                }
                case -2144781245: {
                    var24_24 = "GIONEE_SWW1609";
                    var0 = (int)var22_22.equals(var24_24);
                    if (var0 == 0) ** GOTO lbl-1000
                    var1_1 = 0;
                    var24_24 = null;
                    var2_2 = 0.0f;
                }
            }
            block153 : switch (var1_1) {
                default: {
                    var22_22 = Util.MODEL;
                    var22_22.hashCode();
                    var1_1 = var22_22.hashCode();
                    switch (var1_1) lbl-1000:
                    // 4 sources

                    {
                        default: {
                            var9_9 = var11_11;
                            var10_10 = var12_12;
                            break;
                        }
                        case 2006367: {
                            var24_24 = "AFTN";
                            var0 = (int)var22_22.equals(var24_24);
                            if (var0 != 0) break;
                            ** GOTO lbl-1000
                        }
                        case 2006354: {
                            var24_24 = "AFTA";
                            var0 = (int)var22_22.equals(var24_24);
                            if (var0 == 0) ** GOTO lbl-1000
                            var9_9 = var13_13;
                            var10_10 = var14_14;
                            break;
                        }
                        case -594534941: {
                            var24_24 = "JSN-L21";
                            var0 = (int)var22_22.equals(var24_24);
                            if (var0 == 0) ** GOTO lbl-1000
                            var9_9 = 0;
                            var10_10 = 0.0f;
                        }
                    }
                    switch (var9_9) {
                        default: {
                            break block153;
                        }
                        case 0: 
                        case 1: 
                        case 2: 
                    }
                }
                case 0: 
                case 1: 
                case 2: 
                case 3: 
                case 4: 
                case 5: 
                case 6: 
                case 7: 
                case 8: 
                case 9: 
                case 10: 
                case 11: 
                case 12: 
                case 13: 
                case 14: 
                case 15: 
                case 16: 
                case 17: 
                case 18: 
                case 19: 
                case 20: 
                case 21: 
                case 22: 
                case 23: 
                case 24: 
                case 25: 
                case 26: 
                case 27: 
                case 28: 
                case 29: 
                case 30: 
                case 31: 
                case 32: 
                case 33: 
                case 34: 
                case 35: 
                case 36: 
                case 37: 
                case 38: 
                case 39: 
                case 40: 
                case 41: 
                case 42: 
                case 43: 
                case 44: 
                case 45: 
                case 46: 
                case 47: 
                case 48: 
                case 49: 
                case 50: 
                case 51: 
                case 52: 
                case 53: 
                case 54: 
                case 55: 
                case 56: 
                case 57: 
                case 58: 
                case 59: 
                case 60: 
                case 61: 
                case 62: 
                case 63: 
                case 64: 
                case 65: 
                case 66: 
                case 67: 
                case 68: 
                case 69: 
                case 70: 
                case 71: 
                case 72: 
                case 73: 
                case 74: 
                case 75: 
                case 76: 
                case 77: 
                case 78: 
                case 79: 
                case 80: 
                case 81: 
                case 82: 
                case 83: 
                case 84: 
                case 85: 
                case 86: 
                case 87: 
                case 88: 
                case 89: 
                case 90: 
                case 91: 
                case 92: 
                case 93: 
                case 94: 
                case 95: 
                case 96: 
                case 97: 
                case 98: 
                case 99: 
                case 100: 
                case 101: 
                case 102: 
                case 103: 
                case 104: 
                case 105: 
                case 106: 
                case 107: 
                case 108: 
                case 109: 
                case 110: 
                case 111: 
                case 112: 
                case 113: 
                case 114: 
                case 115: 
                case 116: 
                case 117: 
                case 118: 
                case 119: 
                case 120: 
                case 121: 
                case 122: 
                case 123: 
                case 124: 
                case 125: 
                case 126: 
                case 127: 
                case 128: 
                case 129: 
                case 130: 
                case 131: 
                case 132: 
                case 133: 
                case 134: 
                case 135: 
                case 136: 
                case 137: 
                case 138: 
                case 139: {
                    return (boolean)var13_13;
                }
            }
        }
        return false;
    }

    /*
     * Enabled aggressive block sorting
     */
    private static int getCodecMaxInputSize(MediaCodecInfo mediaCodecInfo, String string2, int n10, int n11) {
        int n12;
        String string3;
        int n13;
        int n14;
        int n15;
        int n16;
        int n17;
        block16: {
            block17: {
                n17 = -1;
                if (n10 == n17) return n17;
                if (n11 == n17) {
                    return n17;
                }
                string2.hashCode();
                n16 = string2.hashCode();
                n15 = 4;
                n14 = 3;
                n13 = 2;
                float f10 = 2.8E-45f;
                switch (n16) {
                    case 1599127257: {
                        string3 = "video/x-vnd.on2.vp9";
                        n12 = (int)(string2.equals(string3) ? 1 : 0);
                        if (n12 == 0) break;
                        n12 = 5;
                        break block16;
                    }
                    case 1599127256: {
                        string3 = "video/x-vnd.on2.vp8";
                        n12 = (int)(string2.equals(string3) ? 1 : 0);
                        if (n12 == 0) break;
                        n12 = n15;
                        break block16;
                    }
                    case 1331836730: {
                        string3 = "video/avc";
                        n12 = (int)(string2.equals(string3) ? 1 : 0);
                        if (n12 == 0) break;
                        n12 = n14;
                        break block16;
                    }
                    case 1187890754: {
                        string3 = "video/mp4v-es";
                        n12 = (int)(string2.equals(string3) ? 1 : 0);
                        if (n12 == 0) break;
                        n12 = n13;
                        break block16;
                    }
                    case -1662541442: {
                        string3 = "video/hevc";
                        n12 = (int)(string2.equals(string3) ? 1 : 0);
                        if (n12 == 0) break;
                        n12 = 1;
                        break block16;
                    }
                    case -1664118616: {
                        string3 = "video/3gpp";
                        n12 = (int)(string2.equals(string3) ? 1 : 0);
                        if (n12 != 0) break block17;
                    }
                }
                n12 = n17;
                break block16;
            }
            n12 = 0;
            string2 = null;
        }
        switch (n12) {
            default: {
                return n17;
            }
            case 3: {
                int n18;
                string2 = Util.MODEL;
                string3 = "BRAVIA 4K 2015";
                n16 = (int)(string3.equals(string2) ? 1 : 0);
                if (n16 != 0) return n17;
                String string4 = "Amazon";
                string3 = Util.MANUFACTURER;
                n16 = (int)(string4.equals(string3) ? 1 : 0);
                if (n16 != 0) {
                    string3 = "KFSOWI";
                    n16 = (int)(string3.equals(string2) ? 1 : 0);
                    if (n16 != 0) return n17;
                    string3 = "AFTS";
                    n12 = (int)(string3.equals(string2) ? 1 : 0);
                    if (n12 != 0 && (n18 = (int)(mediaCodecInfo.secure ? 1 : 0)) != 0) {
                        return n17;
                    }
                }
                n18 = 16;
                n12 = Util.ceilDivide(n10, n18);
                n10 = Util.ceilDivide(n11, n18);
                n12 = n12 * n10 * n18;
                n10 = n12 * 16;
                break;
            }
            case 1: 
            case 5: {
                n10 *= n11;
                return (n10 *= n14) / (n15 *= n13);
            }
            case 0: 
            case 2: 
            case 4: {
                n10 *= n11;
            }
        }
        n15 = n13;
        return (n10 *= n14) / (n15 *= n13);
    }

    /*
     * Loose catch block
     */
    private static Point getCodecMaxSize(MediaCodecInfo mediaCodecInfo, Format format) {
        block12: {
            int n10 = format.height;
            int n11 = format.width;
            int n12 = 0;
            boolean bl2 = n10 > n11;
            int n13 = bl2 ? n10 : n11;
            if (bl2) {
                n10 = n11;
            }
            float f10 = n10;
            float f11 = n13;
            f10 /= f11;
            int[] nArray = STANDARD_LONG_EDGE_VIDEO_PX;
            int n14 = nArray.length;
            while (true) {
                block13: {
                    int n15 = 0;
                    Point point = null;
                    if (n12 >= n14) break block12;
                    int n16 = nArray[n12];
                    float f12 = (float)n16 * f10;
                    int n17 = (int)f12;
                    if (n16 <= n13 || n17 <= n10) break block12;
                    int n18 = Util.SDK_INT;
                    int n19 = 21;
                    if (n18 >= n19) {
                        n15 = bl2 ? n17 : n16;
                        if (!bl2) {
                            n16 = n17;
                        }
                        point = mediaCodecInfo.alignVideoSizeV21(n15, n16);
                        float f13 = format.frameRate;
                        n17 = point.x;
                        n18 = point.y;
                        double d10 = f13;
                        n16 = (int)(mediaCodecInfo.isVideoSizeAndRateSupportedV21(n17, n18, d10) ? 1 : 0);
                        if (n16 != 0) {
                            return point;
                        }
                    } else {
                        int n20;
                        block14: {
                            n18 = 16;
                            n16 = Util.ceilDivide(n16, n18) * n18;
                            n17 = Util.ceilDivide(n17, n18) * n18;
                            n18 = n16 * n17;
                            n19 = MediaCodecUtil.maxH264DecodableFrameSize();
                            if (n18 > n19) break block13;
                            n20 = bl2 ? n17 : n16;
                            if (bl2) break block14;
                            n16 = n17;
                        }
                        mediaCodecInfo = new Point(n20, n16);
                        return mediaCodecInfo;
                    }
                }
                ++n12;
            }
            catch (MediaCodecUtil$DecoderQueryException mediaCodecUtil$DecoderQueryException) {}
        }
        return null;
    }

    private static List getDecoderInfos(MediaCodecSelector object, Format object2, boolean bl2, boolean bl3) {
        String string2 = ((Format)object2).sampleMimeType;
        if (string2 == null) {
            return Collections.emptyList();
        }
        List list = MediaCodecUtil.getDecoderInfosSortedByFormatSupport(object.getDecoderInfos(string2, bl2, bl3), (Format)object2);
        String string3 = "video/dolby-vision";
        int n10 = string3.equals(string2);
        if (n10 != 0 && (object2 = MediaCodecUtil.getCodecProfileAndLevel((Format)object2)) != null) {
            object2 = (Integer)((Pair)object2).first;
            int n11 = (Integer)object2;
            if (n11 != (n10 = 16) && n11 != (n10 = 256)) {
                n10 = 512;
                if (n11 == n10) {
                    object2 = "video/avc";
                    object = object.getDecoderInfos((String)object2, bl2, bl3);
                    list.addAll(object);
                }
            } else {
                object2 = "video/hevc";
                object = object.getDecoderInfos((String)object2, bl2, bl3);
                list.addAll(object);
            }
        }
        return Collections.unmodifiableList(list);
    }

    public static int getMaxInputSize(MediaCodecInfo object, Format format) {
        int n10 = format.maxInputSize;
        int n11 = -1;
        if (n10 != n11) {
            object = format.initializationData;
            int n12 = object.size();
            Object var5_5 = null;
            n11 = 0;
            for (n10 = 0; n10 < n12; ++n10) {
                byte[] byArray = (byte[])format.initializationData.get(n10);
                int n13 = byArray.length;
                n11 += n13;
            }
            return format.maxInputSize + n11;
        }
        String string2 = format.sampleMimeType;
        n11 = format.width;
        int n14 = format.height;
        return MediaCodecVideoRenderer.getCodecMaxInputSize((MediaCodecInfo)object, string2, n11, n14);
    }

    private static boolean isBufferLate(long l10) {
        long l11 = -30000L;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        object = object < 0 ? (Object)1 : (Object)0;
        return (boolean)object;
    }

    private static boolean isBufferVeryLate(long l10) {
        long l11 = 4294467296L;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        object = object < 0 ? (Object)1 : (Object)0;
        return (boolean)object;
    }

    private void maybeNotifyDroppedFrames() {
        int n10 = this.droppedFrames;
        if (n10 > 0) {
            long l10 = SystemClock.elapsedRealtime();
            long l11 = this.droppedFrameAccumulationStartTimeMs;
            l11 = l10 - l11;
            VideoRendererEventListener$EventDispatcher videoRendererEventListener$EventDispatcher = this.eventDispatcher;
            int n11 = this.droppedFrames;
            videoRendererEventListener$EventDispatcher.droppedFrames(n11, l11);
            this.droppedFrames = 0;
            this.droppedFrameAccumulationStartTimeMs = l10;
        }
    }

    private void maybeNotifyVideoFrameProcessingOffset() {
        int n10 = this.videoFrameProcessingOffsetCount;
        if (n10 != 0) {
            long l10;
            VideoRendererEventListener$EventDispatcher videoRendererEventListener$EventDispatcher = this.eventDispatcher;
            long l11 = this.totalVideoFrameProcessingOffsetUs;
            videoRendererEventListener$EventDispatcher.reportVideoFrameProcessingOffset(l11, n10);
            this.totalVideoFrameProcessingOffsetUs = l10 = 0L;
            n10 = 0;
            this.videoFrameProcessingOffsetCount = 0;
        }
    }

    private void maybeNotifyVideoSizeChanged() {
        float f10;
        float f11;
        int n10;
        int n11 = this.currentWidth;
        int n12 = -1;
        float f12 = 0.0f / 0.0f;
        if (!(n11 == n12 && (n10 = this.currentHeight) == n12 || (n12 = this.reportedWidth) == n11 && (n12 = this.reportedHeight) == (n10 = this.currentHeight) && (n12 = this.reportedUnappliedRotationDegrees) == (n10 = this.currentUnappliedRotationDegrees) && (n12 = (int)((f11 = (f12 = this.reportedPixelWidthHeightRatio) - (f10 = this.currentPixelWidthHeightRatio)) == 0.0f ? 0 : (f11 > 0.0f ? 1 : -1))) == 0)) {
            float f13;
            VideoRendererEventListener$EventDispatcher videoRendererEventListener$EventDispatcher = this.eventDispatcher;
            n10 = this.currentHeight;
            int n13 = this.currentUnappliedRotationDegrees;
            float f14 = this.currentPixelWidthHeightRatio;
            videoRendererEventListener$EventDispatcher.videoSizeChanged(n11, n10, n13, f14);
            this.reportedWidth = n11 = this.currentWidth;
            this.reportedHeight = n11 = this.currentHeight;
            this.reportedUnappliedRotationDegrees = n11 = this.currentUnappliedRotationDegrees;
            this.reportedPixelWidthHeightRatio = f13 = this.currentPixelWidthHeightRatio;
        }
    }

    private void maybeRenotifyRenderedFirstFrame() {
        boolean bl2 = this.haveReportedFirstFrameRenderedForCurrentSurface;
        if (bl2) {
            VideoRendererEventListener$EventDispatcher videoRendererEventListener$EventDispatcher = this.eventDispatcher;
            Surface surface = this.surface;
            videoRendererEventListener$EventDispatcher.renderedFirstFrame(surface);
        }
    }

    private void maybeRenotifyVideoSizeChanged() {
        int n10;
        int n11 = this.reportedWidth;
        int n12 = -1;
        if (n11 != n12 || (n10 = this.reportedHeight) != n12) {
            VideoRendererEventListener$EventDispatcher videoRendererEventListener$EventDispatcher = this.eventDispatcher;
            n10 = this.reportedHeight;
            int n13 = this.reportedUnappliedRotationDegrees;
            float f10 = this.reportedPixelWidthHeightRatio;
            videoRendererEventListener$EventDispatcher.videoSizeChanged(n11, n10, n13, f10);
        }
    }

    private void notifyFrameMetadataListener(long l10, long l11, Format format) {
        VideoFrameMetadataListener videoFrameMetadataListener = this.frameMetadataListener;
        if (videoFrameMetadataListener != null) {
            MediaFormat mediaFormat = this.getCodecOutputMediaFormat();
            videoFrameMetadataListener.onVideoFrameAboutToBeRendered(l10, l11, format, mediaFormat);
        }
    }

    private void onProcessedTunneledEndOfStream() {
        this.setPendingOutputEndOfStream();
    }

    private static void setHdr10PlusInfoV29(MediaCodecAdapter mediaCodecAdapter, byte[] byArray) {
        Bundle bundle = new Bundle();
        bundle.putByteArray("hdr10-plus-info", byArray);
        mediaCodecAdapter.setParameters(bundle);
    }

    private void setJoiningDeadlineMs() {
        long l10 = this.allowedJoiningTimeMs;
        long l11 = 0L;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object > 0) {
            l10 = SystemClock.elapsedRealtime();
            l11 = this.allowedJoiningTimeMs;
            l10 += l11;
        } else {
            l10 = -9223372036854775807L;
        }
        this.joiningDeadlineMs = l10;
    }

    private void setSurface(Surface surface) {
        int n10;
        Object object;
        if (surface == null) {
            object = this.dummySurface;
            if (object != null) {
                surface = object;
            } else {
                boolean bl2;
                object = this.getCodecInfo();
                if (object != null && (bl2 = this.shouldUseDummySurface((MediaCodecInfo)object))) {
                    surface = this.context;
                    n10 = (int)(object.secure ? 1 : 0);
                    this.dummySurface = surface = DummySurface.newInstanceV17((Context)surface, n10 != 0);
                }
            }
        }
        if ((object = this.surface) != surface) {
            this.surface = surface;
            this.frameReleaseHelper.onSurfaceChanged(surface);
            object = null;
            this.haveReportedFirstFrameRenderedForCurrentSurface = false;
            n10 = this.getState();
            MediaCodecAdapter mediaCodecAdapter = this.getCodec();
            if (mediaCodecAdapter != null) {
                int n11 = Util.SDK_INT;
                int n12 = 23;
                if (n11 >= n12 && surface != null && (n11 = (int)(this.codecNeedsSetOutputSurfaceWorkaround ? 1 : 0)) == 0) {
                    this.setOutputSurfaceV23(mediaCodecAdapter, surface);
                } else {
                    this.releaseCodec();
                    this.maybeInitCodecOrBypass();
                }
            }
            if (surface != null && surface != (mediaCodecAdapter = this.dummySurface)) {
                this.maybeRenotifyVideoSizeChanged();
                this.clearRenderedFirstFrame();
                int n13 = 2;
                if (n10 == n13) {
                    this.setJoiningDeadlineMs();
                }
            } else {
                this.clearReportedVideoSize();
                this.clearRenderedFirstFrame();
            }
        } else if (surface != null && surface != (object = this.dummySurface)) {
            this.maybeRenotifyVideoSizeChanged();
            this.maybeRenotifyRenderedFirstFrame();
        }
    }

    private boolean shouldUseDummySurface(MediaCodecInfo mediaCodecInfo) {
        boolean bl2;
        String string2;
        int n10 = Util.SDK_INT;
        int n11 = 23;
        if (n10 >= n11 && (n10 = (int)(this.tunneling ? 1 : 0)) == 0 && (n10 = (int)(this.codecNeedsSetOutputSurfaceWorkaround(string2 = mediaCodecInfo.name) ? 1 : 0)) == 0 && (!(bl2 = mediaCodecInfo.secure) || (bl2 = DummySurface.isSecureSupported((Context)(mediaCodecInfo = this.context))))) {
            bl2 = true;
        } else {
            bl2 = false;
            mediaCodecInfo = null;
        }
        return bl2;
    }

    public DecoderReuseEvaluation canReuseCodec(MediaCodecInfo mediaCodecInfo, Format format, Format format2) {
        int n10;
        int n11;
        DecoderReuseEvaluation decoderReuseEvaluation = mediaCodecInfo.canReuseCodec(format, format2);
        int n12 = decoderReuseEvaluation.discardReasons;
        int n13 = format2.width;
        Object object = this.codecMaxValues;
        int n14 = ((MediaCodecVideoRenderer$CodecMaxValues)object).width;
        if (n13 > n14 || (n13 = format2.height) > (n11 = ((MediaCodecVideoRenderer$CodecMaxValues)object).height)) {
            n12 |= 0x100;
        }
        n13 = MediaCodecVideoRenderer.getMaxInputSize(mediaCodecInfo, format2);
        object = this.codecMaxValues;
        n11 = ((MediaCodecVideoRenderer$CodecMaxValues)object).inputSize;
        if (n13 > n11) {
            n12 |= 0x40;
        }
        int n15 = n12;
        object = mediaCodecInfo.name;
        if (n12 != 0) {
            n10 = 0;
            mediaCodecInfo = null;
        } else {
            n10 = decoderReuseEvaluation.result;
        }
        DecoderReuseEvaluation decoderReuseEvaluation2 = new DecoderReuseEvaluation((String)object, format, format2, n10, n15);
        return decoderReuseEvaluation2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean codecNeedsSetOutputSurfaceWorkaround(String object) {
        String string2 = "OMX.google";
        boolean bl2 = ((String)object).startsWith(string2);
        if (bl2) {
            return false;
        }
        object = MediaCodecVideoRenderer.class;
        synchronized (object) {
            boolean bl3 = evaluatedDeviceNeedsSetOutputSurfaceWorkaround;
            if (!bl3) {
                deviceNeedsSetOutputSurfaceWorkaround = bl3 = MediaCodecVideoRenderer.evaluateDeviceNeedsSetOutputSurfaceWorkaround();
                evaluatedDeviceNeedsSetOutputSurfaceWorkaround = bl3 = true;
            }
            return deviceNeedsSetOutputSurfaceWorkaround;
        }
    }

    public void configureCodec(MediaCodecInfo object, MediaCodecAdapter mediaCodecAdapter, Format format, MediaCrypto mediaCrypto, float f10) {
        boolean bl2;
        MediaCodecVideoRenderer$CodecMaxValues mediaCodecVideoRenderer$CodecMaxValues;
        String string2 = ((MediaCodecInfo)object).codecMimeType;
        Object object2 = this.getStreamFormats();
        this.codecMaxValues = mediaCodecVideoRenderer$CodecMaxValues = this.getCodecMaxValues((MediaCodecInfo)object, format, (Format[])object2);
        boolean bl3 = this.deviceNeedsNoPostProcessWorkaround;
        int n10 = this.tunneling;
        int n11 = n10 != 0 ? (n10 = this.tunnelingAudioSessionId) : 0;
        object2 = this;
        format = this.getMediaFormat(format, string2, mediaCodecVideoRenderer$CodecMaxValues, f10, bl3, n11);
        Surface surface = this.surface;
        if (surface == null) {
            boolean bl4 = this.shouldUseDummySurface((MediaCodecInfo)object);
            if (bl4) {
                surface = this.dummySurface;
                if (surface == null) {
                    surface = this.context;
                    boolean bl22 = ((MediaCodecInfo)object).secure;
                    object = DummySurface.newInstanceV17((Context)surface, bl22);
                    this.dummySurface = object;
                }
                object = this.dummySurface;
                this.surface = object;
            } else {
                object = new IllegalStateException();
                throw object;
            }
        }
        object = this.surface;
        mediaCodecAdapter.configure((MediaFormat)format, (Surface)object, mediaCrypto, 0);
        int n12 = Util.SDK_INT;
        int n13 = 23;
        if (n12 >= n13 && (bl2 = this.tunneling)) {
            object = new MediaCodecVideoRenderer$OnFrameRenderedListenerV23(this, mediaCodecAdapter);
            this.tunnelingOnFrameRenderedListener = object;
        }
    }

    public MediaCodecDecoderException createDecoderException(Throwable throwable, MediaCodecInfo mediaCodecInfo) {
        Surface surface = this.surface;
        MediaCodecVideoDecoderException mediaCodecVideoDecoderException = new MediaCodecVideoDecoderException(throwable, mediaCodecInfo, surface);
        return mediaCodecVideoDecoderException;
    }

    public void dropOutputBuffer(MediaCodecAdapter mediaCodecAdapter, int n10, long l10) {
        TraceUtil.beginSection("dropVideoBuffer");
        mediaCodecAdapter.releaseOutputBuffer(n10, false);
        TraceUtil.endSection();
        this.updateDroppedBufferCounters(1);
    }

    public MediaCodecVideoRenderer$CodecMaxValues getCodecMaxValues(MediaCodecInfo object, Format object2, Format[] object3) {
        int n10 = ((Format)object2).width;
        int n11 = ((Format)object2).height;
        int n12 = MediaCodecVideoRenderer.getMaxInputSize((MediaCodecInfo)object, (Format)object2);
        int n13 = ((Format[])object3).length;
        int n14 = 1;
        int n15 = -1;
        if (n13 == n14) {
            int n16;
            int n17;
            if (n12 != n15 && (n17 = MediaCodecVideoRenderer.getCodecMaxInputSize((MediaCodecInfo)object, (String)(object3 = ((Format)object2).sampleMimeType), n13 = ((Format)object2).width, n16 = ((Format)object2).height)) != n15) {
                float f10 = n12;
                int n18 = 1069547520;
                float f11 = 1.5f;
                n16 = (int)(f10 *= f11);
                n12 = Math.min(n16, n17);
            }
            object = new MediaCodecVideoRenderer$CodecMaxValues(n10, n11, n12);
            return object;
        }
        n13 = ((Format[])object3).length;
        int n19 = 0;
        for (int i10 = 0; i10 < n13; ++i10) {
            int n20;
            Object object4 = object3[i10];
            Object object5 = ((Format)object2).colorInfo;
            if (object5 != null && (object5 = ((Format)object4).colorInfo) == null) {
                object4 = ((Format)object4).buildUpon();
                object5 = ((Format)object2).colorInfo;
                object4 = ((Format$Builder)object4).setColorInfo((ColorInfo)object5).build();
            }
            object5 = ((MediaCodecInfo)object).canReuseCodec((Format)object2, (Format)object4);
            int n21 = ((DecoderReuseEvaluation)object5).result;
            if (n21 == 0) continue;
            n21 = ((Format)object4).width;
            n20 = n21 != n15 && (n20 = ((Format)object4).height) != n15 ? 0 : n14;
            n19 |= n20;
            n10 = Math.max(n10, n21);
            n21 = ((Format)object4).height;
            n11 = Math.max(n11, n21);
            int n22 = MediaCodecVideoRenderer.getMaxInputSize((MediaCodecInfo)object, (Format)object4);
            n12 = Math.max(n12, n22);
        }
        if (n19 != 0) {
            int n23 = 66;
            float f12 = 9.2E-44f;
            CharSequence charSequence = new StringBuilder(n23);
            charSequence.append("Resolutions unknown. Codec max resolution: ");
            charSequence.append(n10);
            object3 = "x";
            charSequence.append((String)object3);
            charSequence.append(n11);
            charSequence = charSequence.toString();
            String string2 = TAG;
            Log.w(string2, (String)charSequence);
            charSequence = MediaCodecVideoRenderer.getCodecMaxSize((MediaCodecInfo)object, (Format)object2);
            if (charSequence != null) {
                n15 = ((Point)charSequence).x;
                n10 = Math.max(n10, n15);
                n13 = ((Point)charSequence).y;
                n11 = Math.max(n11, n13);
                object2 = ((Format)object2).sampleMimeType;
                int n24 = MediaCodecVideoRenderer.getCodecMaxInputSize((MediaCodecInfo)object, (String)object2, n10, n11);
                n12 = Math.max(n12, n24);
                n24 = 57;
                object2 = new StringBuilder(n24);
                ((StringBuilder)object2).append("Codec max resolution adjusted to: ");
                ((StringBuilder)object2).append(n10);
                ((StringBuilder)object2).append((String)object3);
                ((StringBuilder)object2).append(n11);
                object = ((StringBuilder)object2).toString();
                Log.w(string2, (String)object);
            }
        }
        object = new MediaCodecVideoRenderer$CodecMaxValues(n10, n11, n12);
        return object;
    }

    public boolean getCodecNeedsEosPropagation() {
        int n10;
        int n11 = this.tunneling;
        n11 = n11 != 0 && (n11 = Util.SDK_INT) < (n10 = 23) ? 1 : 0;
        return n11 != 0;
    }

    public float getCodecOperatingRateV23(float f10, Format format, Format[] formatArray) {
        int n10 = formatArray.length;
        float f11 = -1.0f;
        float f12 = f11;
        for (int i10 = 0; i10 < n10; ++i10) {
            Format format2 = formatArray[i10];
            float f13 = format2.frameRate;
            float f14 = f13 - f11;
            Object object = f14 == 0.0f ? 0 : (f14 > 0.0f ? 1 : -1);
            if (object == false) continue;
            f12 = Math.max(f12, f13);
        }
        n10 = (int)(f12 == f11 ? 0 : (f12 > f11 ? 1 : -1));
        if (n10 != 0) {
            f11 = f12 * f10;
        }
        return f11;
    }

    public List getDecoderInfos(MediaCodecSelector mediaCodecSelector, Format format, boolean bl2) {
        boolean bl3 = this.tunneling;
        return MediaCodecVideoRenderer.getDecoderInfos(mediaCodecSelector, format, bl2, bl3);
    }

    public MediaFormat getMediaFormat(Format object, String object2, MediaCodecVideoRenderer$CodecMaxValues mediaCodecVideoRenderer$CodecMaxValues, float f10, boolean bl2, int n10) {
        float f11;
        int n11;
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString("mime", (String)object2);
        int n12 = ((Format)object).width;
        mediaFormat.setInteger("width", n12);
        n12 = ((Format)object).height;
        mediaFormat.setInteger("height", n12);
        object2 = ((Format)object).initializationData;
        MediaFormatUtil.setCsdBuffers(mediaFormat, (List)object2);
        float f12 = ((Format)object).frameRate;
        MediaFormatUtil.maybeSetFloat(mediaFormat, "frame-rate", f12);
        n12 = ((Format)object).rotationDegrees;
        MediaFormatUtil.maybeSetInteger(mediaFormat, "rotation-degrees", n12);
        object2 = ((Format)object).colorInfo;
        MediaFormatUtil.maybeSetColorInfo(mediaFormat, (ColorInfo)object2);
        object2 = ((Format)object).sampleMimeType;
        String string2 = "video/dolby-vision";
        n12 = (int)(string2.equals(object2) ? 1 : 0);
        if (n12 != 0 && (object = MediaCodecUtil.getCodecProfileAndLevel((Format)object)) != null) {
            object = (Integer)((Pair)object).first;
            n11 = (Integer)object;
            object2 = "profile";
            MediaFormatUtil.maybeSetInteger(mediaFormat, (String)object2, n11);
        }
        n11 = mediaCodecVideoRenderer$CodecMaxValues.width;
        mediaFormat.setInteger("max-width", n11);
        n11 = mediaCodecVideoRenderer$CodecMaxValues.height;
        mediaFormat.setInteger("max-height", n11);
        n11 = mediaCodecVideoRenderer$CodecMaxValues.inputSize;
        object2 = "max-input-size";
        MediaFormatUtil.maybeSetInteger(mediaFormat, (String)object2, n11);
        n11 = Util.SDK_INT;
        n12 = 23;
        f12 = 3.2E-44f;
        mediaCodecVideoRenderer$CodecMaxValues = null;
        if (n11 >= n12) {
            object = "priority";
            mediaFormat.setInteger((String)object, 0);
            f11 = -1.0f;
            n11 = (int)(f10 == f11 ? 0 : (f10 > f11 ? 1 : -1));
            if (n11 != 0) {
                object = "operating-rate";
                mediaFormat.setFloat((String)object, f10);
            }
        }
        if (bl2) {
            n11 = 1;
            f11 = Float.MIN_VALUE;
            object2 = "no-post-process";
            mediaFormat.setInteger((String)object2, n11);
            object = "auto-frc";
            mediaFormat.setInteger((String)object, 0);
        }
        if (n10 != 0) {
            MediaCodecVideoRenderer.configureTunnelingV21(mediaFormat, n10);
        }
        return mediaFormat;
    }

    public String getName() {
        return TAG;
    }

    public Surface getSurface() {
        return this.surface;
    }

    public void handleInputBufferSupplementalData(DecoderInputBuffer object) {
        int n10;
        int n11 = this.codecHandlesHdr10PlusOutOfBandMetadata;
        if (n11 == 0) {
            return;
        }
        object = (ByteBuffer)Assertions.checkNotNull(((DecoderInputBuffer)object).supplementalData);
        n11 = ((Buffer)object).remaining();
        if (n11 >= (n10 = 7)) {
            n11 = ((ByteBuffer)object).get();
            n10 = ((ByteBuffer)object).getShort();
            short s10 = ((ByteBuffer)object).getShort();
            byte by2 = ((ByteBuffer)object).get();
            byte by3 = ((ByteBuffer)object).get();
            ((ByteBuffer)object).position(0);
            int n12 = -75;
            if (n11 == n12 && n10 == (n11 = 60) && s10 == (n11 = 1) && by2 == (n11 = 4) && by3 == 0) {
                n11 = ((Buffer)object).remaining();
                byte[] byArray = new byte[n11];
                ((ByteBuffer)object).get(byArray);
                ((ByteBuffer)object).position(0);
                object = this.getCodec();
                MediaCodecVideoRenderer.setHdr10PlusInfoV29((MediaCodecAdapter)object, byArray);
            }
        }
    }

    public void handleMessage(int n10, Object object) {
        int n11 = 1;
        if (n10 != n11) {
            n11 = 4;
            if (n10 != n11) {
                n11 = 6;
                if (n10 != n11) {
                    n11 = 102;
                    if (n10 != n11) {
                        super.handleMessage(n10, object);
                    } else {
                        int n12 = this.tunnelingAudioSessionId;
                        n10 = (Integer)(object = (Integer)object);
                        if (n12 != n10) {
                            this.tunnelingAudioSessionId = n10;
                            n10 = (int)(this.tunneling ? 1 : 0);
                            if (n10 != 0) {
                                this.releaseCodec();
                            }
                        }
                    }
                } else {
                    this.frameMetadataListener = object = (VideoFrameMetadataListener)object;
                }
            } else {
                object = (Integer)object;
                this.scalingMode = n10 = ((Integer)object).intValue();
                MediaCodecAdapter mediaCodecAdapter = this.getCodec();
                if (mediaCodecAdapter != null) {
                    int n13 = this.scalingMode;
                    mediaCodecAdapter.setVideoScalingMode(n13);
                }
            }
        } else {
            object = (Surface)object;
            this.setSurface((Surface)object);
        }
    }

    public boolean isReady() {
        long l10;
        Surface surface;
        Object object;
        Object object2 = super.isReady();
        boolean bl2 = true;
        long l11 = -9223372036854775807L;
        if (object2 != 0 && ((object2 = this.renderedFirstFrameAfterReset) != 0 || (object = this.dummySurface) != null && (surface = this.surface) == object || (object = this.getCodec()) == null || (object2 = this.tunneling) != 0)) {
            this.joiningDeadlineMs = l11;
            return bl2;
        }
        long l12 = this.joiningDeadlineMs;
        object2 = l12 == l11 ? 0 : (l12 < l11 ? -1 : 1);
        surface = null;
        if (object2 == 0) {
            return false;
        }
        long l13 = SystemClock.elapsedRealtime();
        long l14 = l13 - (l10 = this.joiningDeadlineMs);
        object2 = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
        if (object2 < 0) {
            return bl2;
        }
        this.joiningDeadlineMs = l11;
        return false;
    }

    public boolean maybeDropBuffersToKeyframe(long l10, boolean bl2) {
        int n10 = this.skipSource(l10);
        if (n10 == 0) {
            return false;
        }
        DecoderCounters decoderCounters = this.decoderCounters;
        int n11 = decoderCounters.droppedToKeyframeCount;
        int n12 = 1;
        decoderCounters.droppedToKeyframeCount = n11 += n12;
        n11 = this.buffersInCodecCount + n10;
        if (bl2) {
            decoderCounters.skippedOutputBufferCount = n10 = decoderCounters.skippedOutputBufferCount + n11;
        } else {
            this.updateDroppedBufferCounters(n11);
        }
        this.flushOrReinitializeCodec();
        return n12 != 0;
    }

    public void maybeNotifyRenderedFirstFrame() {
        boolean bl2;
        this.renderedFirstFrameAfterEnable = bl2 = true;
        boolean bl3 = this.renderedFirstFrameAfterReset;
        if (!bl3) {
            this.renderedFirstFrameAfterReset = bl2;
            VideoRendererEventListener$EventDispatcher videoRendererEventListener$EventDispatcher = this.eventDispatcher;
            Surface surface = this.surface;
            videoRendererEventListener$EventDispatcher.renderedFirstFrame(surface);
            this.haveReportedFirstFrameRenderedForCurrentSurface = bl2;
        }
    }

    public void onCodecInitialized(String string2, long l10, long l11) {
        boolean bl2;
        this.eventDispatcher.decoderInitialized(string2, l10, l11);
        this.codecNeedsSetOutputSurfaceWorkaround = bl2 = this.codecNeedsSetOutputSurfaceWorkaround(string2);
        this.codecHandlesHdr10PlusOutOfBandMetadata = bl2 = ((MediaCodecInfo)Assertions.checkNotNull(this.getCodecInfo())).isHdr10PlusOutOfBandMetadataSupported();
    }

    public void onCodecReleased(String string2) {
        this.eventDispatcher.decoderReleased(string2);
    }

    public void onDisabled() {
        this.clearReportedVideoSize();
        this.clearRenderedFirstFrame();
        this.haveReportedFirstFrameRenderedForCurrentSurface = false;
        this.frameReleaseHelper.onDisabled();
        VideoRendererEventListener$EventDispatcher videoRendererEventListener$EventDispatcher = null;
        this.tunnelingOnFrameRenderedListener = null;
        try {
            super.onDisabled();
            return;
        }
        finally {
            videoRendererEventListener$EventDispatcher = this.eventDispatcher;
            DecoderCounters decoderCounters = this.decoderCounters;
            videoRendererEventListener$EventDispatcher.disabled(decoderCounters);
        }
    }

    public void onEnabled(boolean bl2, boolean bl3) {
        DecoderCounters decoderCounters;
        boolean bl4;
        super.onEnabled(bl2, bl3);
        Object object = this.getConfiguration();
        bl2 = ((RendererConfiguration)object).tunneling;
        if (bl2 && !(bl4 = this.tunnelingAudioSessionId)) {
            bl4 = false;
            decoderCounters = null;
        } else {
            bl4 = true;
        }
        Assertions.checkState(bl4);
        bl4 = this.tunneling;
        if (bl4 != bl2) {
            this.tunneling = bl2;
            this.releaseCodec();
        }
        object = this.eventDispatcher;
        decoderCounters = this.decoderCounters;
        ((VideoRendererEventListener$EventDispatcher)object).enabled(decoderCounters);
        this.frameReleaseHelper.onEnabled();
        this.mayRenderFirstFrameAfterEnableIfNotStarted = bl3;
        this.renderedFirstFrameAfterEnable = false;
    }

    public DecoderReuseEvaluation onInputFormatChanged(FormatHolder object) {
        DecoderReuseEvaluation decoderReuseEvaluation = super.onInputFormatChanged((FormatHolder)object);
        VideoRendererEventListener$EventDispatcher videoRendererEventListener$EventDispatcher = this.eventDispatcher;
        object = ((FormatHolder)object).format;
        videoRendererEventListener$EventDispatcher.inputFormatChanged((Format)object, decoderReuseEvaluation);
        return decoderReuseEvaluation;
    }

    public void onOutputFormatChanged(Format format, MediaFormat object) {
        float f10;
        int n10;
        int n11;
        int n12;
        Object object2 = this.getCodec();
        if (object2 != null) {
            n12 = this.scalingMode;
            object2.setVideoScalingMode(n12);
        }
        if ((n11 = this.tunneling) != 0) {
            this.currentWidth = n10 = format.width;
            this.currentHeight = n10 = format.height;
        } else {
            Assertions.checkNotNull(object);
            object2 = KEY_CROP_RIGHT;
            n12 = (int)(object.containsKey((String)object2) ? 1 : 0);
            String string2 = KEY_CROP_TOP;
            String string3 = KEY_CROP_BOTTOM;
            String string4 = KEY_CROP_LEFT;
            int n13 = 1;
            n12 = n12 != 0 && (n12 = (int)(object.containsKey(string4) ? 1 : 0)) != 0 && (n12 = (int)(object.containsKey(string3) ? 1 : 0)) != 0 && (n12 = (int)(object.containsKey(string2) ? 1 : 0)) != 0 ? n13 : 0;
            if (n12 != 0) {
                n11 = object.getInteger((String)object2);
                int n14 = object.getInteger(string4);
                n11 = n11 - n14 + n13;
            } else {
                object2 = "width";
                n11 = object.getInteger((String)object2);
            }
            this.currentWidth = n11;
            if (n12 != 0) {
                n11 = object.getInteger(string3);
                n10 = object.getInteger(string2);
                n11 = n11 - n10 + n13;
            } else {
                object2 = "height";
                n11 = object.getInteger((String)object2);
            }
            this.currentHeight = n11;
        }
        this.currentPixelWidthHeightRatio = f10 = format.pixelWidthHeightRatio;
        n11 = Util.SDK_INT;
        n12 = 21;
        if (n11 >= n12) {
            n11 = format.rotationDegrees;
            n12 = 90;
            if (n11 == n12 || n11 == (n12 = 270)) {
                float f11;
                n11 = this.currentWidth;
                this.currentWidth = n12 = this.currentHeight;
                this.currentHeight = n11;
                n11 = 1065353216;
                this.currentPixelWidthHeightRatio = f11 = 1.0f / f10;
            }
        } else {
            this.currentUnappliedRotationDegrees = n10 = format.rotationDegrees;
        }
        object = this.frameReleaseHelper;
        float f12 = format.frameRate;
        ((VideoFrameReleaseHelper)object).onFormatChanged(f12);
    }

    public void onPositionReset(long l10, boolean bl2) {
        super.onPositionReset(l10, bl2);
        this.clearRenderedFirstFrame();
        VideoFrameReleaseHelper videoFrameReleaseHelper = this.frameReleaseHelper;
        videoFrameReleaseHelper.onPositionReset();
        this.lastBufferPresentationTimeUs = l10 = -9223372036854775807L;
        this.initialPositionUs = l10;
        this.consecutiveDroppedFrameCount = 0;
        if (bl2) {
            this.setJoiningDeadlineMs();
        } else {
            this.joiningDeadlineMs = l10;
        }
    }

    public void onProcessedOutputBuffer(long l10) {
        super.onProcessedOutputBuffer(l10);
        int n10 = this.tunneling;
        if (n10 == 0) {
            this.buffersInCodecCount = n10 = this.buffersInCodecCount + -1;
        }
    }

    public void onProcessedStreamChange() {
        super.onProcessedStreamChange();
        this.clearRenderedFirstFrame();
    }

    public void onProcessedTunneledBuffer(long l10) {
        int n10;
        this.updateOutputFormatForTime(l10);
        this.maybeNotifyVideoSizeChanged();
        DecoderCounters decoderCounters = this.decoderCounters;
        decoderCounters.renderedOutputBufferCount = n10 = decoderCounters.renderedOutputBufferCount + 1;
        this.maybeNotifyRenderedFirstFrame();
        this.onProcessedOutputBuffer(l10);
    }

    public void onQueueInputBuffer(DecoderInputBuffer decoderInputBuffer) {
        int n10;
        int n11;
        boolean bl2 = this.tunneling;
        if (!bl2) {
            this.buffersInCodecCount = n11 = this.buffersInCodecCount + 1;
        }
        if ((n11 = Util.SDK_INT) < (n10 = 23) && bl2) {
            long l10 = decoderInputBuffer.timeUs;
            this.onProcessedTunneledBuffer(l10);
        }
    }

    public void onReset() {
        block4: {
            Surface surface;
            block5: {
                try {
                    super.onReset();
                    surface = this.dummySurface;
                    if (surface == null) break block4;
                    Surface surface2 = this.surface;
                    if (surface2 != surface) break block5;
                    this.surface = null;
                }
                catch (Throwable throwable) {
                    Surface surface3 = this.dummySurface;
                    if (surface3 != null) {
                        surface3 = this.surface;
                        Surface surface4 = this.dummySurface;
                        if (surface3 == surface4) {
                            this.surface = null;
                        }
                        surface4.release();
                        this.dummySurface = null;
                    }
                    throw throwable;
                }
            }
            surface.release();
            this.dummySurface = null;
        }
    }

    public void onStarted() {
        long l10;
        super.onStarted();
        this.droppedFrames = 0;
        this.droppedFrameAccumulationStartTimeMs = l10 = SystemClock.elapsedRealtime();
        this.lastRenderRealtimeUs = l10 = SystemClock.elapsedRealtime() * 1000L;
        this.totalVideoFrameProcessingOffsetUs = 0L;
        this.videoFrameProcessingOffsetCount = 0;
        this.frameReleaseHelper.onStarted();
    }

    public void onStopped() {
        this.joiningDeadlineMs = -9223372036854775807L;
        this.maybeNotifyDroppedFrames();
        this.maybeNotifyVideoFrameProcessingOffset();
        this.frameReleaseHelper.onStopped();
        super.onStopped();
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public boolean processOutputBuffer(long var1_1, long var3_2, MediaCodecAdapter var5_3, ByteBuffer var6_4, int var7_5, int var8_6, int var9_7, long var10_8, boolean var12_9, boolean var13_10, Format var14_11) {
        block27: {
            block29: {
                block28: {
                    var15_12 = this;
                    var16_13 = var1_1;
                    var18_14 = var5_3;
                    var19_15 = var7_5;
                    var20_16 = var10_8;
                    Assertions.checkNotNull(var5_3);
                    var22_17 = this.initialPositionUs;
                    var24_18 = -9223372036854775807L;
                    var26_19 /* !! */  = var22_17 == var24_18 ? 0 : (var22_17 < var24_18 ? -1 : 1);
                    if (var26_19 /* !! */  == false) {
                        this.initialPositionUs = var1_1;
                    }
                    if ((var26_19 /* !! */  = (cfr_temp_0 = var20_16 - (var22_17 = var15_12.lastBufferPresentationTimeUs)) == 0L ? 0 : (cfr_temp_0 < 0L ? -1 : 1)) != false) {
                        var27_20 = var15_12.frameReleaseHelper;
                        var27_20.onNextFrame(var20_16);
                        var15_12.lastBufferPresentationTimeUs = var20_16;
                    }
                    var22_17 = this.getOutputStreamOffsetUs();
                    var28_21 = var20_16 - var22_17;
                    var30_22 = true;
                    var31_23 = 1.4E-45f;
                    if (var12_9 && !var13_10) {
                        var15_12.skipOutputBuffer(var18_14, var19_15, var28_21);
                        return var30_22;
                    }
                    var32_24 = this.getPlaybackSpeed();
                    var33_25 = var32_24;
                    var35_26 = this.getState();
                    var36_27 = 2 != 0;
                    var37_28 = 2.8E-45f;
                    if (var35_26 == var36_27) {
                        var35_26 = var30_22;
                    } else {
                        var35_26 = false;
                        var38_29 = null;
                    }
                    var39_30 = SystemClock.elapsedRealtime();
                    var41_31 = 1000L;
                    var39_30 *= var41_31;
                    var43_32 = (double)(var20_16 - var16_13) / var33_25;
                    var20_16 = (long)var43_32;
                    if (var35_26) {
                        var45_33 = var39_30 - var3_2;
                        var20_16 -= var45_33;
                    }
                    if ((var47_34 = var15_12.surface) == (var48_35 = var15_12.dummySurface)) {
                        var26_19 /* !! */  = (long)MediaCodecVideoRenderer.isBufferLate(var20_16);
                        if (var26_19 /* !! */  != false) {
                            var15_12.skipOutputBuffer(var18_14, var19_15, var28_21);
                            var15_12.updateVideoFrameProcessingOffsetCounters(var20_16);
                            return var30_22;
                        }
                        return false;
                    }
                    var45_33 = var15_12.lastRenderRealtimeUs;
                    var45_33 = var39_30 - var45_33;
                    var36_27 = var15_12.renderedFirstFrameAfterEnable;
                    if (var36_27 == false ? var35_26 != false || (var36_27 = var15_12.mayRenderFirstFrameAfterEnableIfNotStarted) != false : (var36_27 = var15_12.renderedFirstFrameAfterReset) == false) {
                        var36_27 = var30_22;
                        var37_28 = var31_23;
                        var10_8 = var45_33;
                    } else {
                        var10_8 = var45_33;
                        var36_27 = false;
                        var47_34 = null;
                        var37_28 = 0.0f;
                    }
                    var49_36 = var15_12.joiningDeadlineMs;
                    var39_30 = -9223372036854775807L;
                    var30_22 = var49_36 == var39_30 ? 0 : (var49_36 < var39_30 ? -1 : 1);
                    if (var30_22 || (var26_19 /* !! */  = var16_13 == var22_17 ? 0 : (var16_13 < var22_17 ? -1 : 1)) < 0) ** GOTO lbl-1000
                    if (var36_27) ** GOTO lbl-1000
                    if (var35_26) {
                        var22_17 = var10_8;
                        var26_19 /* !! */  = (long)var15_12.shouldForceRenderOutputBuffer(var20_16, var10_8);
                        ** if (var26_19 /* !! */  == false) goto lbl-1000
                    }
                    ** GOTO lbl-1000
lbl-1000:
                    // 2 sources

                    {
                        var26_19 /* !! */  = 1;
                        ** GOTO lbl75
                    }
lbl-1000:
                    // 3 sources

                    {
                        var26_19 /* !! */  = 0;
                        var27_20 = null;
                    }
lbl75:
                    // 2 sources

                    var30_22 = 21 != 0;
                    var31_23 = 2.9E-44f;
                    if (var26_19 /* !! */  != false) {
                        var22_17 = System.nanoTime();
                        this.notifyFrameMetadataListener(var28_21, var22_17, var14_11);
                        var35_26 = Util.SDK_INT;
                        if (var35_26 >= var30_22) {
                            this.renderOutputBufferV21(var5_3, var7_5, var28_21, var22_17);
                        } else {
                            var15_12.renderOutputBuffer(var18_14, var19_15, var28_21);
                        }
                        var15_12.updateVideoFrameProcessingOffsetCounters(var20_16);
lbl86:
                        // 4 sources

                        return true;
                    }
                    if (!var35_26 || (var26_19 /* !! */  = (cfr_temp_1 = var16_13 - (var22_17 = var15_12.initialPositionUs)) == 0L ? 0 : (cfr_temp_1 < 0L ? -1 : 1)) == false) break block27;
                    var22_17 = System.nanoTime();
                    var20_16 = var20_16 * var41_31 + var22_17;
                    var38_29 = var15_12.frameReleaseHelper;
                    var45_33 = var38_29.adjustReleaseTime(var20_16);
                    var51_37 = (var45_33 - var22_17) / var41_31;
                    var20_16 = var15_12.joiningDeadlineMs;
                    var39_30 = -9223372036854775807L;
                    cfr_temp_2 = var20_16 - var39_30;
                    var53_38 /* !! */  = (long)(cfr_temp_2 == 0L ? 0 : (cfr_temp_2 < 0L ? -1 : 1));
                    if (var53_38 /* !! */  != false) {
                        var36_27 = true;
                        var37_28 = 1.4E-45f;
                    } else {
                        var36_27 = false;
                        var47_34 = null;
                        var37_28 = 0.0f;
                    }
                    var54_39 = var51_37;
                    var39_30 = var51_37;
                    var51_37 = var3_2;
                    var30_22 = var36_27;
                    var31_23 = var37_28;
                    var36_27 = var13_10;
                    var53_38 /* !! */  = (long)this.shouldDropBuffersToKeyframe(var54_39, var3_2, var13_10);
                    if (var53_38 /* !! */  != false && (var53_38 /* !! */  = (long)var15_12.maybeDropBuffersToKeyframe(var16_13, var30_22)) != false) {
                        return false;
                    }
                    var54_39 = var39_30;
                    var51_37 = var3_2;
                    var36_27 = var13_10;
                    var53_38 /* !! */  = (long)this.shouldDropOutputBuffer(var39_30, var3_2, var13_10);
                    if (var53_38 /* !! */  == false) break block28;
                    if (var30_22) {
                        var15_12.skipOutputBuffer(var18_14, var19_15, var28_21);
                    } else {
                        var15_12.dropOutputBuffer(var18_14, var19_15, var28_21);
                    }
                    var20_16 = var39_30;
                    var15_12.updateVideoFrameProcessingOffsetCounters(var39_30);
                    ** GOTO lbl86
                }
                var20_16 = var39_30;
                var26_19 /* !! */  = Util.SDK_INT;
                var56_40 = 21;
                if (var26_19 /* !! */  < var56_40) break block29;
                var22_17 = 50000L;
                cfr_temp_3 = var39_30 - var22_17;
                var26_19 /* !! */  = (long)(cfr_temp_3 == 0L ? 0 : (cfr_temp_3 < 0L ? -1 : 1));
                if (var26_19 /* !! */  >= 0) break block27;
                this.notifyFrameMetadataListener(var28_21, var45_33, var14_11);
                this.renderOutputBufferV21(var5_3, var7_5, var28_21, var45_33);
                var15_12.updateVideoFrameProcessingOffsetCounters(var39_30);
                ** GOTO lbl86
            }
            var22_17 = 30000L;
            cfr_temp_4 = var39_30 - var22_17;
            var26_19 /* !! */  = (long)(cfr_temp_4 == 0L ? 0 : (cfr_temp_4 < 0L ? -1 : 1));
            if (var26_19 /* !! */  < 0) {
                var22_17 = 11000L;
                cfr_temp_5 = var39_30 - var22_17;
                var26_19 /* !! */  = (long)(cfr_temp_5 == 0L ? 0 : (cfr_temp_5 < 0L ? -1 : 1));
                if (var26_19 /* !! */  > 0) {
                    var22_17 = 10000L;
                    var51_37 = var39_30 - var22_17;
                    try {
                        var51_37 /= var41_31;
                    }
                    catch (InterruptedException v0) {
                        Thread.currentThread().interrupt();
                        return false;
                    }
                    Thread.sleep(var51_37);
                }
                this.notifyFrameMetadataListener(var28_21, var45_33, var14_11);
                var15_12.renderOutputBuffer(var18_14, var19_15, var28_21);
                var15_12.updateVideoFrameProcessingOffsetCounters(var20_16);
                ** continue;
            }
        }
        return false;
    }

    public void renderOutputBuffer(MediaCodecAdapter object, int n10, long l10) {
        long l11;
        this.maybeNotifyVideoSizeChanged();
        TraceUtil.beginSection("releaseOutputBuffer");
        int n11 = 1;
        object.releaseOutputBuffer(n10, n11 != 0);
        TraceUtil.endSection();
        this.lastRenderRealtimeUs = l11 = SystemClock.elapsedRealtime() * 1000L;
        object = this.decoderCounters;
        ((DecoderCounters)object).renderedOutputBufferCount = n10 = ((DecoderCounters)object).renderedOutputBufferCount + n11;
        this.consecutiveDroppedFrameCount = 0;
        this.maybeNotifyRenderedFirstFrame();
    }

    public void renderOutputBufferV21(MediaCodecAdapter object, int n10, long l10, long l11) {
        long l12;
        this.maybeNotifyVideoSizeChanged();
        TraceUtil.beginSection("releaseOutputBuffer");
        object.releaseOutputBuffer(n10, l11);
        TraceUtil.endSection();
        this.lastRenderRealtimeUs = l12 = SystemClock.elapsedRealtime() * 1000L;
        object = this.decoderCounters;
        ((DecoderCounters)object).renderedOutputBufferCount = n10 = ((DecoderCounters)object).renderedOutputBufferCount + 1;
        this.consecutiveDroppedFrameCount = 0;
        this.maybeNotifyRenderedFirstFrame();
    }

    public void resetCodecStateForFlush() {
        super.resetCodecStateForFlush();
        this.buffersInCodecCount = 0;
    }

    public void setOutputSurfaceV23(MediaCodecAdapter mediaCodecAdapter, Surface surface) {
        mediaCodecAdapter.setOutputSurface(surface);
    }

    public void setPlaybackSpeed(float f10, float f11) {
        super.setPlaybackSpeed(f10, f11);
        this.frameReleaseHelper.onPlaybackSpeed(f10);
    }

    public boolean shouldDropBuffersToKeyframe(long l10, long l11, boolean bl2) {
        boolean bl3 = MediaCodecVideoRenderer.isBufferVeryLate(l10);
        bl3 = bl3 && !bl2;
        return bl3;
    }

    public boolean shouldDropOutputBuffer(long l10, long l11, boolean bl2) {
        boolean bl3 = MediaCodecVideoRenderer.isBufferLate(l10);
        bl3 = bl3 && !bl2;
        return bl3;
    }

    public boolean shouldForceRenderOutputBuffer(long l10, long l11) {
        long l12;
        int n10 = MediaCodecVideoRenderer.isBufferLate(l10);
        n10 = n10 != 0 && (n10 = (l12 = l11 - (l10 = 100000L)) == 0L ? 0 : (l12 < 0L ? -1 : 1)) > 0 ? 1 : 0;
        return n10 != 0;
    }

    public boolean shouldInitCodec(MediaCodecInfo mediaCodecInfo) {
        boolean bl2;
        Surface surface = this.surface;
        if (surface == null && !(bl2 = this.shouldUseDummySurface(mediaCodecInfo))) {
            bl2 = false;
            mediaCodecInfo = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }

    public void skipOutputBuffer(MediaCodecAdapter object, int n10, long l10) {
        TraceUtil.beginSection("skipVideoBuffer");
        object.releaseOutputBuffer(n10, false);
        TraceUtil.endSection();
        object = this.decoderCounters;
        ((DecoderCounters)object).skippedOutputBufferCount = n10 = ((DecoderCounters)object).skippedOutputBufferCount + 1;
    }

    /*
     * WARNING - void declaration
     */
    public int supportsFormat(MediaCodecSelector object, Format format) {
        void var9_12;
        int n10;
        boolean bl2;
        Object object2 = format.sampleMimeType;
        boolean bl3 = MimeTypes.isVideo((String)object2);
        int n11 = 0;
        if (!bl3) {
            return RendererCapabilities.create(0);
        }
        object2 = format.drmInitData;
        boolean bl4 = true;
        if (object2 != null) {
            bl3 = bl4;
        } else {
            bl3 = false;
            object2 = null;
        }
        Object object3 = MediaCodecVideoRenderer.getDecoderInfos((MediaCodecSelector)object, format, bl3, false);
        if (bl3 && (bl2 = object3.isEmpty())) {
            object3 = MediaCodecVideoRenderer.getDecoderInfos((MediaCodecSelector)object, format, false, false);
        }
        if (bl2 = object3.isEmpty()) {
            return RendererCapabilities.create((int)(bl4 ? 1 : 0));
        }
        bl2 = MediaCodecRenderer.supportsFormatDrm(format);
        if (!bl2) {
            return RendererCapabilities.create(2);
        }
        object3 = (MediaCodecInfo)object3.get(0);
        bl2 = ((MediaCodecInfo)object3).isFormatSupported(format);
        boolean n12 = ((MediaCodecInfo)object3).isSeamlessAdaptationSupported(format);
        if (n12) {
            int n13 = 16;
        } else {
            int n14 = 8;
        }
        if (bl2 && !(bl3 = (object = MediaCodecVideoRenderer.getDecoderInfos((MediaCodecSelector)object, format, bl3, bl4)).isEmpty()) && (bl3 = ((MediaCodecInfo)(object = (MediaCodecInfo)object.get(0))).isFormatSupported(format)) && (n10 = (int)(((MediaCodecInfo)object).isSeamlessAdaptationSupported(format) ? 1 : 0)) != 0) {
            n11 = 32;
        }
        n10 = bl2 ? 4 : 3;
        return RendererCapabilities.create(n10, (int)var9_12, n11);
    }

    public void updateDroppedBufferCounters(int n10) {
        int n11;
        int n12;
        DecoderCounters decoderCounters = this.decoderCounters;
        decoderCounters.droppedBufferCount = n12 = decoderCounters.droppedBufferCount + n10;
        this.droppedFrames = n12 = this.droppedFrames + n10;
        this.consecutiveDroppedFrameCount = n12 = this.consecutiveDroppedFrameCount + n10;
        n10 = decoderCounters.maxConsecutiveDroppedBufferCount;
        decoderCounters.maxConsecutiveDroppedBufferCount = n10 = Math.max(n12, n10);
        n10 = this.maxDroppedFramesToNotify;
        if (n10 > 0 && (n11 = this.droppedFrames) >= n10) {
            this.maybeNotifyDroppedFrames();
        }
    }

    public void updateVideoFrameProcessingOffsetCounters(long l10) {
        int n10;
        long l11;
        this.decoderCounters.addVideoFrameProcessingOffset(l10);
        this.totalVideoFrameProcessingOffsetUs = l11 = this.totalVideoFrameProcessingOffsetUs + l10;
        this.videoFrameProcessingOffsetCount = n10 = this.videoFrameProcessingOffsetCount + 1;
    }
}

