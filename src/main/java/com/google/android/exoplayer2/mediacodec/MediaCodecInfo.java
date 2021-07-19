/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Point
 *  android.media.MediaCodecInfo$CodecCapabilities
 *  android.media.MediaCodecInfo$CodecProfileLevel
 *  android.media.MediaCodecInfo$VideoCapabilities
 *  android.util.Pair
 */
package com.google.android.exoplayer2.mediacodec;

import android.graphics.Point;
import android.media.MediaCodecInfo;
import android.util.Pair;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.Format$Builder;
import com.google.android.exoplayer2.decoder.DecoderReuseEvaluation;
import com.google.android.exoplayer2.mediacodec.MediaCodecUtil;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.video.ColorInfo;

public final class MediaCodecInfo {
    public static final int MAX_SUPPORTED_INSTANCES_UNKNOWN = 255;
    public static final String TAG = "MediaCodecInfo";
    public final boolean adaptive;
    public final MediaCodecInfo.CodecCapabilities capabilities;
    public final String codecMimeType;
    public final boolean hardwareAccelerated;
    private final boolean isVideo;
    public final String mimeType;
    public final String name;
    public final boolean secure;
    public final boolean softwareOnly;
    public final boolean tunneling;
    public final boolean vendor;

    public MediaCodecInfo(String string2, String string3, String string4, MediaCodecInfo.CodecCapabilities codecCapabilities, boolean bl2, boolean bl3, boolean bl4, boolean bl5, boolean bl6, boolean bl7) {
        boolean bl8;
        this.name = string2 = (String)Assertions.checkNotNull(string2);
        this.mimeType = string3;
        this.codecMimeType = string4;
        this.capabilities = codecCapabilities;
        this.hardwareAccelerated = bl2;
        this.softwareOnly = bl3;
        this.vendor = bl4;
        this.adaptive = bl5;
        this.tunneling = bl6;
        this.secure = bl7;
        this.isVideo = bl8 = MimeTypes.isVideo(string3);
    }

    private static int adjustMaxInputChannelCount(String string2, String string3, int n10) {
        String string4;
        int n11;
        int n12 = 1;
        if (n10 <= n12 && ((n12 = Util.SDK_INT) < (n11 = 26) || n10 <= 0) && (n12 = (int)((string4 = "audio/mpeg").equals(string3) ? 1 : 0)) == 0 && (n12 = (int)((string4 = "audio/3gpp").equals(string3) ? 1 : 0)) == 0 && (n12 = (int)((string4 = "audio/amr-wb").equals(string3) ? 1 : 0)) == 0 && (n12 = (int)((string4 = "audio/mp4a-latm").equals(string3) ? 1 : 0)) == 0 && (n12 = (int)((string4 = "audio/vorbis").equals(string3) ? 1 : 0)) == 0 && (n12 = (int)((string4 = "audio/opus").equals(string3) ? 1 : 0)) == 0 && (n12 = (int)((string4 = "audio/raw").equals(string3) ? 1 : 0)) == 0 && (n12 = (int)((string4 = "audio/flac").equals(string3) ? 1 : 0)) == 0 && (n12 = (int)((string4 = "audio/g711-alaw").equals(string3) ? 1 : 0)) == 0 && (n12 = (int)((string4 = "audio/g711-mlaw").equals(string3) ? 1 : 0)) == 0 && (n12 = (int)((string4 = "audio/gsm").equals(string3) ? 1 : 0)) == 0) {
            int n13;
            string4 = "audio/ac3";
            n12 = (int)(string4.equals(string3) ? 1 : 0);
            n13 = n12 != 0 ? 6 : ((n13 = (int)((string4 = "audio/eac3").equals(string3) ? 1 : 0)) != 0 ? 16 : 30);
            n12 = String.valueOf(string2).length() + 59;
            StringBuilder stringBuilder = new StringBuilder(n12);
            stringBuilder.append("AssumedMaxChannelAdjustment: ");
            stringBuilder.append(string2);
            stringBuilder.append(", [");
            stringBuilder.append(n10);
            stringBuilder.append(" to ");
            stringBuilder.append(n13);
            stringBuilder.append("]");
            string2 = stringBuilder.toString();
            Log.w(TAG, string2);
            return n13;
        }
        return n10;
    }

    private static Point alignVideoSizeV21(MediaCodecInfo.VideoCapabilities videoCapabilities, int n10, int n11) {
        int n12 = videoCapabilities.getWidthAlignment();
        int n13 = videoCapabilities.getHeightAlignment();
        n10 = Util.ceilDivide(n10, n12) * n12;
        n11 = Util.ceilDivide(n11, n13) * n13;
        Point point = new Point(n10, n11);
        return point;
    }

    private static boolean areSizeAndRateSupportedV21(MediaCodecInfo.VideoCapabilities videoCapabilities, int n10, int n11, double d10) {
        double d11;
        Point point = MediaCodecInfo.alignVideoSizeV21(videoCapabilities, n10, n11);
        n11 = point.x;
        n10 = point.y;
        double d12 = -1.0;
        double d13 = d10 - d12;
        Object object = d13 == 0.0 ? 0 : (d13 > 0.0 ? 1 : -1);
        if (object != false && (object = (d11 = d10 - (d12 = 1.0)) == 0.0 ? 0 : (d11 < 0.0 ? -1 : 1)) >= 0) {
            d10 = Math.floor(d10);
            return videoCapabilities.areSizeAndRateSupported(n11, n10, d10);
        }
        return videoCapabilities.isSizeSupported(n11, n10);
    }

    private static MediaCodecInfo.CodecProfileLevel[] estimateLegacyVp9ProfileLevels(MediaCodecInfo.CodecCapabilities object) {
        int n10;
        if (object != null && (object = object.getVideoCapabilities()) != null) {
            object = (Integer)object.getBitrateRange().getUpper();
            n10 = (Integer)object;
        } else {
            n10 = 0;
            object = null;
        }
        int n11 = 180000000;
        int n12 = 1;
        n10 = n10 >= n11 ? 1024 : (n10 >= (n11 = 120000000) ? 512 : (n10 >= (n11 = 60000000) ? 256 : (n10 >= (n11 = 30000000) ? 128 : (n10 >= (n11 = 18000000) ? 64 : (n10 >= (n11 = 12000000) ? 32 : (n10 >= (n11 = 0x6DDD00) ? 16 : (n10 >= (n11 = 3600000) ? 8 : (n10 >= (n11 = 1800000) ? 4 : (n10 >= (n11 = 800000) ? 2 : n12)))))))));
        MediaCodecInfo.CodecProfileLevel codecProfileLevel = new MediaCodecInfo.CodecProfileLevel();
        codecProfileLevel.profile = n12;
        codecProfileLevel.level = n10;
        object = new MediaCodecInfo.CodecProfileLevel[n12];
        object[0] = codecProfileLevel;
        return object;
    }

    private static int getMaxSupportedInstancesV23(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.getMaxSupportedInstances();
    }

    private static boolean isAdaptive(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        boolean bl2;
        int n10 = Util.SDK_INT;
        int n11 = 19;
        if (n10 >= n11 && (bl2 = MediaCodecInfo.isAdaptiveV19(codecCapabilities))) {
            bl2 = true;
        } else {
            bl2 = false;
            codecCapabilities = null;
        }
        return bl2;
    }

    private static boolean isAdaptiveV19(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureSupported("adaptive-playback");
    }

    private static boolean isSecure(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        boolean bl2;
        int n10 = Util.SDK_INT;
        int n11 = 21;
        if (n10 >= n11 && (bl2 = MediaCodecInfo.isSecureV21(codecCapabilities))) {
            bl2 = true;
        } else {
            bl2 = false;
            codecCapabilities = null;
        }
        return bl2;
    }

    private static boolean isSecureV21(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureSupported("secure-playback");
    }

    private static boolean isTunneling(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        boolean bl2;
        int n10 = Util.SDK_INT;
        int n11 = 21;
        if (n10 >= n11 && (bl2 = MediaCodecInfo.isTunnelingV21(codecCapabilities))) {
            bl2 = true;
        } else {
            bl2 = false;
            codecCapabilities = null;
        }
        return bl2;
    }

    private static boolean isTunnelingV21(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureSupported("tunneled-playback");
    }

    private void logAssumedSupport(String string2) {
        String string3 = this.name;
        String string4 = this.mimeType;
        String string5 = Util.DEVICE_DEBUG_INFO;
        int n10 = String.valueOf(string2).length() + 25;
        int n11 = String.valueOf(string3).length();
        n10 += n11;
        n11 = String.valueOf(string4).length();
        n10 += n11;
        n11 = String.valueOf(string5).length();
        StringBuilder stringBuilder = new StringBuilder(n10 += n11);
        stringBuilder.append("AssumedSupport [");
        stringBuilder.append(string2);
        string2 = "] [";
        stringBuilder.append(string2);
        stringBuilder.append(string3);
        stringBuilder.append(", ");
        stringBuilder.append(string4);
        stringBuilder.append(string2);
        stringBuilder.append(string5);
        stringBuilder.append("]");
        string2 = stringBuilder.toString();
        Log.d(TAG, string2);
    }

    private void logNoSupport(String string2) {
        String string3 = this.name;
        String string4 = this.mimeType;
        String string5 = Util.DEVICE_DEBUG_INFO;
        int n10 = String.valueOf(string2).length() + 20;
        int n11 = String.valueOf(string3).length();
        n10 += n11;
        n11 = String.valueOf(string4).length();
        n10 += n11;
        n11 = String.valueOf(string5).length();
        StringBuilder stringBuilder = new StringBuilder(n10 += n11);
        stringBuilder.append("NoSupport [");
        stringBuilder.append(string2);
        string2 = "] [";
        stringBuilder.append(string2);
        stringBuilder.append(string3);
        stringBuilder.append(", ");
        stringBuilder.append(string4);
        stringBuilder.append(string2);
        stringBuilder.append(string5);
        stringBuilder.append("]");
        string2 = stringBuilder.toString();
        Log.d(TAG, string2);
    }

    private static boolean needsAdaptationFlushWorkaround(String string2) {
        return "audio/opus".equals(string2);
    }

    private static boolean needsAdaptationReconfigureWorkaround(String string2) {
        boolean bl2;
        String string3 = Util.MODEL;
        String string4 = "SM-T230";
        boolean bl3 = string3.startsWith(string4);
        if (bl3 && (bl2 = (string3 = "OMX.MARVELL.VIDEO.HW.CODA7542DECODER").equals(string2))) {
            bl2 = true;
        } else {
            bl2 = false;
            string2 = null;
        }
        return bl2;
    }

    private static boolean needsDisableAdaptationWorkaround(String string2) {
        boolean bl2;
        String string3;
        String string4;
        int n10 = Util.SDK_INT;
        int n11 = 22;
        if (!(n10 > n11 || (n11 = (int)((string4 = "ODROID-XU3").equals(string3 = Util.MODEL) ? 1 : 0)) == 0 && (n10 = (int)((string4 = "Nexus 10").equals(string3) ? 1 : 0)) == 0 || (n10 = (int)((string3 = "OMX.Exynos.AVC.Decoder").equals(string2) ? 1 : 0)) == 0 && !(bl2 = (string3 = "OMX.Exynos.AVC.Decoder.secure").equals(string2)))) {
            bl2 = true;
        } else {
            bl2 = false;
            string2 = null;
        }
        return bl2;
    }

    private static final boolean needsRotatedVerticalResolutionWorkaround(String string2) {
        String string3 = "OMX.MTK.VIDEO.DECODER.HEVC";
        boolean bl2 = string3.equals(string2);
        return !bl2 || !(bl2 = (string3 = "mcv5a").equals(string2 = Util.DEVICE));
    }

    public static MediaCodecInfo newInstance(String string2, String string3, String string4, MediaCodecInfo.CodecCapabilities codecCapabilities, boolean bl2, boolean bl3, boolean bl4, boolean bl5, boolean bl6) {
        boolean bl7;
        boolean bl8 = true;
        boolean bl9 = !bl5 && codecCapabilities != null && (bl7 = MediaCodecInfo.isAdaptive(codecCapabilities)) && !(bl7 = MediaCodecInfo.needsDisableAdaptationWorkaround(string2)) ? bl8 : false;
        boolean bl10 = codecCapabilities != null && (bl7 = MediaCodecInfo.isTunneling(codecCapabilities)) ? bl8 : false;
        boolean bl11 = !(bl6 || codecCapabilities != null && (bl7 = MediaCodecInfo.isSecure(codecCapabilities))) ? false : bl8;
        MediaCodecInfo mediaCodecInfo = new MediaCodecInfo(string2, string3, string4, codecCapabilities, bl2, bl3, bl4, bl9, bl10, bl11);
        return mediaCodecInfo;
    }

    public Point alignVideoSizeV21(int n10, int n11) {
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.capabilities;
        if (codecCapabilities == null) {
            return null;
        }
        if ((codecCapabilities = codecCapabilities.getVideoCapabilities()) == null) {
            return null;
        }
        return MediaCodecInfo.alignVideoSizeV21((MediaCodecInfo.VideoCapabilities)codecCapabilities, n10, n11);
    }

    public DecoderReuseEvaluation canReuseCodec(Format format, Format format2) {
        Object object = format.sampleMimeType;
        Object object2 = format2.sampleMimeType;
        int n10 = Util.areEqual(object, object2);
        if (n10 == 0) {
            n10 = 8;
        } else {
            n10 = 0;
            object = null;
        }
        int n11 = this.isVideo;
        if (n11 != 0) {
            Object object3;
            n11 = format.rotationDegrees;
            int n12 = format2.rotationDegrees;
            if (n11 != n12) {
                n10 |= 0x400;
            }
            if ((n11 = (int)(this.adaptive ? 1 : 0)) == 0 && ((n11 = format.width) != (n12 = format2.width) || (n11 = format.height) != (n12 = format2.height))) {
                n10 |= 0x200;
            }
            if ((n11 = (int)(Util.areEqual(object2 = format.colorInfo, object3 = format2.colorInfo) ? 1 : 0)) == 0) {
                n10 |= 0x800;
            }
            if ((n11 = (int)(MediaCodecInfo.needsAdaptationReconfigureWorkaround((String)(object2 = this.name)) ? 1 : 0)) != 0 && (n11 = (int)(format.initializationDataEquals(format2) ? 1 : 0)) == 0) {
                n10 |= 2;
            }
            if (n10 == 0) {
                object3 = this.name;
                n11 = (int)(format.initializationDataEquals(format2) ? 1 : 0);
                n11 = n11 != 0 ? 3 : 2;
                object2 = object;
                object = new DecoderReuseEvaluation((String)object3, format, format2, n11, 0);
                return object;
            }
        } else {
            Object object4;
            n11 = format.channelCount;
            int n13 = format2.channelCount;
            if (n11 != n13) {
                n10 |= 0x1000;
            }
            if ((n11 = format.sampleRate) != (n13 = format2.sampleRate)) {
                n10 |= 0x2000;
            }
            if ((n11 = format.pcmEncoding) != (n13 = format2.pcmEncoding)) {
                n10 |= 0x4000;
            }
            if (n10 == 0 && (n11 = (int)(((String)(object4 = "audio/mp4a-latm")).equals(object2 = this.mimeType) ? 1 : 0)) != 0) {
                object2 = MediaCodecUtil.getCodecProfileAndLevel(format);
                object4 = MediaCodecUtil.getCodecProfileAndLevel(format2);
                if (object2 != null && object4 != null) {
                    object2 = (Integer)((Pair)object2).first;
                    n11 = (Integer)object2;
                    object4 = (Integer)((Pair)object4).first;
                    n13 = (Integer)object4;
                    int n14 = 42;
                    if (n11 == n14 && n13 == n14) {
                        String string2 = this.name;
                        object = new DecoderReuseEvaluation(string2, format, format2, 3, 0);
                        return object;
                    }
                }
            }
            if ((n11 = (int)(format.initializationDataEquals(format2) ? 1 : 0)) == 0) {
                n10 |= 0x20;
            }
            if ((n11 = (int)(MediaCodecInfo.needsAdaptationFlushWorkaround((String)(object2 = this.mimeType)) ? 1 : 0)) != 0) {
                n10 |= 2;
            }
            if (n10 == 0) {
                object4 = this.name;
                object2 = object;
                object = new DecoderReuseEvaluation((String)object4, format, format2, 1, 0);
                return object;
            }
        }
        String string3 = this.name;
        object = new DecoderReuseEvaluation(string3, format, format2, 0, n10);
        return object;
    }

    public int getMaxSupportedInstances() {
        MediaCodecInfo.CodecCapabilities codecCapabilities;
        int n10 = Util.SDK_INT;
        int n11 = 23;
        if (n10 >= n11 && (codecCapabilities = this.capabilities) != null) {
            return MediaCodecInfo.getMaxSupportedInstancesV23(codecCapabilities);
        }
        return -1;
    }

    public MediaCodecInfo.CodecProfileLevel[] getProfileLevels() {
        MediaCodecInfo.CodecProfileLevel[] codecProfileLevelArray = this.capabilities;
        if (codecProfileLevelArray == null || (codecProfileLevelArray = codecProfileLevelArray.profileLevels) == null) {
            codecProfileLevelArray = new MediaCodecInfo.CodecProfileLevel[]{};
        }
        return codecProfileLevelArray;
    }

    public boolean isAudioChannelCountSupportedV21(int n10) {
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.capabilities;
        if (codecCapabilities == null) {
            this.logNoSupport("channelCount.caps");
            return false;
        }
        if ((codecCapabilities = codecCapabilities.getAudioCapabilities()) == null) {
            this.logNoSupport("channelCount.aCaps");
            return false;
        }
        CharSequence charSequence = this.name;
        String string2 = this.mimeType;
        int n11 = codecCapabilities.getMaxInputChannelCount();
        if ((n11 = MediaCodecInfo.adjustMaxInputChannelCount((String)charSequence, string2, n11)) < n10) {
            charSequence = new StringBuilder(33);
            ((StringBuilder)charSequence).append("channelCount.support, ");
            ((StringBuilder)charSequence).append(n10);
            String string3 = ((StringBuilder)charSequence).toString();
            this.logNoSupport(string3);
            return false;
        }
        return true;
    }

    public boolean isAudioSampleRateSupportedV21(int n10) {
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.capabilities;
        if (codecCapabilities == null) {
            this.logNoSupport("sampleRate.caps");
            return false;
        }
        if ((codecCapabilities = codecCapabilities.getAudioCapabilities()) == null) {
            this.logNoSupport("sampleRate.aCaps");
            return false;
        }
        boolean bl2 = codecCapabilities.isSampleRateSupported(n10);
        if (!bl2) {
            StringBuilder stringBuilder = new StringBuilder(31);
            stringBuilder.append("sampleRate.support, ");
            stringBuilder.append(n10);
            String string2 = stringBuilder.toString();
            this.logNoSupport(string2);
            return false;
        }
        return true;
    }

    public boolean isCodecSupported(Format object) {
        Object object2;
        String string2 = ((Format)object).codecs;
        int n10 = 1;
        if (string2 != null && (object2 = this.mimeType) != null) {
            String string3;
            String string4;
            if ((string2 = MimeTypes.getMediaMimeType(string2)) == null) {
                return n10 != 0;
            }
            object2 = this.mimeType;
            boolean n11 = ((String)object2).equals(string2);
            String string5 = ", ";
            if (!n11) {
                object = ((Format)object).codecs;
                n10 = String.valueOf(object).length() + 13;
                int n12 = String.valueOf(string2).length();
                object2 = new StringBuilder(n10 += n12);
                ((StringBuilder)object2).append("codec.mime ");
                ((StringBuilder)object2).append((String)object);
                ((StringBuilder)object2).append(string5);
                ((StringBuilder)object2).append(string2);
                object = ((StringBuilder)object2).toString();
                this.logNoSupport((String)object);
                return false;
            }
            object2 = MediaCodecUtil.getCodecProfileAndLevel((Format)object);
            if (object2 == null) {
                return n10 != 0;
            }
            Integer n13 = (Integer)((Pair)object2).first;
            int n14 = n13;
            object2 = (Integer)((Pair)object2).second;
            int n15 = (Integer)object2;
            int n16 = this.isVideo;
            if (n16 == 0 && n14 != (n16 = 42)) {
                return n10 != 0;
            }
            MediaCodecInfo.CodecProfileLevel[] codecProfileLevelArray = this.getProfileLevels();
            int n17 = Util.SDK_INT;
            int n18 = 23;
            if (n17 <= n18 && (n17 = (int)((string4 = "video/x-vnd.on2.vp9").equals(string3 = this.mimeType) ? 1 : 0)) != 0 && (n17 = codecProfileLevelArray.length) == 0) {
                codecProfileLevelArray = MediaCodecInfo.estimateLegacyVp9ProfileLevels(this.capabilities);
            }
            n17 = codecProfileLevelArray.length;
            string4 = null;
            for (n18 = 0; n18 < n17; ++n18) {
                int n19;
                MediaCodecInfo.CodecProfileLevel codecProfileLevel = codecProfileLevelArray[n18];
                int n20 = codecProfileLevel.profile;
                if (n20 != n14 || (n19 = codecProfileLevel.level) < n15) continue;
                return n10 != 0;
            }
            object = ((Format)object).codecs;
            n10 = String.valueOf(object).length() + 22;
            int n21 = String.valueOf(string2).length();
            object2 = new StringBuilder(n10 += n21);
            ((StringBuilder)object2).append("codec.profileLevel, ");
            ((StringBuilder)object2).append((String)object);
            ((StringBuilder)object2).append(string5);
            ((StringBuilder)object2).append(string2);
            object = ((StringBuilder)object2).toString();
            this.logNoSupport((String)object);
            return false;
        }
        return n10 != 0;
    }

    public boolean isFormatSupported(Format object) {
        int n10;
        int n11 = this.isCodecSupported((Format)object);
        boolean bl2 = false;
        if (n11 == 0) {
            return false;
        }
        n11 = this.isVideo;
        int n12 = 21;
        boolean bl3 = true;
        if (n11 != 0) {
            int n13;
            n11 = ((Format)object).width;
            if (n11 > 0 && (n13 = ((Format)object).height) > 0) {
                int n14 = Util.SDK_INT;
                if (n14 >= n12) {
                    double d10 = ((Format)object).frameRate;
                    return this.isVideoSizeAndRateSupportedV21(n11, n13, d10);
                }
                n12 = MediaCodecUtil.maxH264DecodableFrameSize();
                if ((n11 *= n13) <= n12) {
                    bl2 = bl3;
                }
                if (!bl2) {
                    n11 = ((Format)object).width;
                    int n15 = ((Format)object).height;
                    n12 = 40;
                    StringBuilder stringBuilder = new StringBuilder(n12);
                    String string2 = "legacyFrameSize, ";
                    stringBuilder.append(string2);
                    stringBuilder.append(n11);
                    String string3 = "x";
                    stringBuilder.append(string3);
                    stringBuilder.append(n15);
                    object = stringBuilder.toString();
                    this.logNoSupport((String)object);
                }
                return bl2;
            }
            return bl3;
        }
        n11 = Util.SDK_INT;
        if (n11 < n12 || ((n11 = ((Format)object).sampleRate) == (n12 = -1) || (n11 = (int)(this.isAudioSampleRateSupportedV21(n11) ? 1 : 0)) != 0) && ((n10 = ((Format)object).channelCount) == n12 || (n10 = (int)(this.isAudioChannelCountSupportedV21(n10) ? 1 : 0)) != 0)) {
            bl2 = bl3;
        }
        return bl2;
    }

    public boolean isHdr10PlusOutOfBandMetadataSupported() {
        MediaCodecInfo.CodecProfileLevel[] codecProfileLevelArray;
        String string2;
        int n10 = Util.SDK_INT;
        int n11 = 29;
        if (n10 >= n11 && (n10 = (int)((string2 = "video/x-vnd.on2.vp9").equals(codecProfileLevelArray = this.mimeType) ? 1 : 0)) != 0) {
            for (MediaCodecInfo.CodecProfileLevel codecProfileLevel : this.getProfileLevels()) {
                int n12 = codecProfileLevel.profile;
                int n13 = 16384;
                if (n12 != n13) continue;
                return true;
            }
        }
        return false;
    }

    public boolean isSeamlessAdaptationSupported(Format object) {
        int n10;
        int n11 = this.isVideo;
        if (n11 != 0) {
            return this.adaptive;
        }
        if ((object = MediaCodecUtil.getCodecProfileAndLevel((Format)object)) != null && (n10 = ((Integer)(object = (Integer)((Pair)object).first)).intValue()) == (n11 = 42)) {
            n10 = 1;
        } else {
            n10 = 0;
            object = null;
        }
        return n10 != 0;
    }

    public boolean isSeamlessAdaptationSupported(Format object, Format object2, boolean bl2) {
        ColorInfo colorInfo;
        if (!bl2 && (colorInfo = ((Format)object).colorInfo) != null && (colorInfo = ((Format)object2).colorInfo) == null) {
            object2 = ((Format)object2).buildUpon();
            colorInfo = ((Format)object).colorInfo;
            object2 = ((Format$Builder)object2).setColorInfo(colorInfo).build();
        }
        object = this.canReuseCodec((Format)object, (Format)object2);
        int n10 = ((DecoderReuseEvaluation)object).result;
        int n11 = 2;
        if (n10 != n11 && n10 != (n11 = 3)) {
            n10 = 0;
            object = null;
        } else {
            n10 = 1;
        }
        return n10 != 0;
    }

    public boolean isVideoSizeAndRateSupportedV21(int n10, int n11, double d10) {
        Object object = this.capabilities;
        String string2 = null;
        if (object == null) {
            this.logNoSupport("sizeAndRate.caps");
            return false;
        }
        if ((object = object.getVideoCapabilities()) == null) {
            this.logNoSupport("sizeAndRate.vCaps");
            return false;
        }
        int n12 = MediaCodecInfo.areSizeAndRateSupportedV21((MediaCodecInfo.VideoCapabilities)object, n10, n11, d10);
        if (n12 == 0) {
            boolean bl2;
            String string3;
            boolean bl3;
            n12 = 69;
            String string4 = "x";
            if (n10 < n11 && (bl3 = MediaCodecInfo.needsRotatedVerticalResolutionWorkaround(string3 = this.name)) && (bl2 = MediaCodecInfo.areSizeAndRateSupportedV21((MediaCodecInfo.VideoCapabilities)object, n11, n10, d10))) {
                object = new StringBuilder(n12);
                string2 = "sizeAndRate.rotated, ";
                ((StringBuilder)object).append(string2);
                ((StringBuilder)object).append(n10);
                ((StringBuilder)object).append(string4);
                ((StringBuilder)object).append(n11);
                ((StringBuilder)object).append(string4);
                ((StringBuilder)object).append(d10);
                String string5 = ((StringBuilder)object).toString();
                this.logAssumedSupport(string5);
            } else {
                object = new StringBuilder(n12);
                ((StringBuilder)object).append("sizeAndRate.support, ");
                ((StringBuilder)object).append(n10);
                ((StringBuilder)object).append(string4);
                ((StringBuilder)object).append(n11);
                ((StringBuilder)object).append(string4);
                ((StringBuilder)object).append(d10);
                String string6 = ((StringBuilder)object).toString();
                this.logNoSupport(string6);
                return false;
            }
        }
        return true;
    }

    public String toString() {
        return this.name;
    }
}

