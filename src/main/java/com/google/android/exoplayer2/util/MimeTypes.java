/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 */
package com.google.android.exoplayer2.util;

import android.text.TextUtils;
import com.google.android.exoplayer2.audio.AacUtil;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.MimeTypes$CustomMimeType;
import com.google.android.exoplayer2.util.MimeTypes$Mp4aObjectType;
import com.google.android.exoplayer2.util.Util;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class MimeTypes {
    public static final String APPLICATION_AIT = "application/vnd.dvb.ait";
    public static final String APPLICATION_CAMERA_MOTION = "application/x-camera-motion";
    public static final String APPLICATION_CEA608 = "application/cea-608";
    public static final String APPLICATION_CEA708 = "application/cea-708";
    public static final String APPLICATION_DVBSUBS = "application/dvbsubs";
    public static final String APPLICATION_EMSG = "application/x-emsg";
    public static final String APPLICATION_EXIF = "application/x-exif";
    public static final String APPLICATION_ICY = "application/x-icy";
    public static final String APPLICATION_ID3 = "application/id3";
    public static final String APPLICATION_M3U8 = "application/x-mpegURL";
    public static final String APPLICATION_MATROSKA = "application/x-matroska";
    public static final String APPLICATION_MP4 = "application/mp4";
    public static final String APPLICATION_MP4CEA608 = "application/x-mp4-cea-608";
    public static final String APPLICATION_MP4VTT = "application/x-mp4-vtt";
    public static final String APPLICATION_MPD = "application/dash+xml";
    public static final String APPLICATION_PGS = "application/pgs";
    public static final String APPLICATION_RAWCC = "application/x-rawcc";
    public static final String APPLICATION_SCTE35 = "application/x-scte35";
    public static final String APPLICATION_SS = "application/vnd.ms-sstr+xml";
    public static final String APPLICATION_SUBRIP = "application/x-subrip";
    public static final String APPLICATION_TTML = "application/ttml+xml";
    public static final String APPLICATION_TX3G = "application/x-quicktime-tx3g";
    public static final String APPLICATION_VOBSUB = "application/vobsub";
    public static final String APPLICATION_WEBM = "application/webm";
    public static final String AUDIO_AAC = "audio/mp4a-latm";
    public static final String AUDIO_AC3 = "audio/ac3";
    public static final String AUDIO_AC4 = "audio/ac4";
    public static final String AUDIO_ALAC = "audio/alac";
    public static final String AUDIO_ALAW = "audio/g711-alaw";
    public static final String AUDIO_AMR = "audio/amr";
    public static final String AUDIO_AMR_NB = "audio/3gpp";
    public static final String AUDIO_AMR_WB = "audio/amr-wb";
    public static final String AUDIO_DTS = "audio/vnd.dts";
    public static final String AUDIO_DTS_EXPRESS = "audio/vnd.dts.hd;profile=lbr";
    public static final String AUDIO_DTS_HD = "audio/vnd.dts.hd";
    public static final String AUDIO_E_AC3 = "audio/eac3";
    public static final String AUDIO_E_AC3_JOC = "audio/eac3-joc";
    public static final String AUDIO_FLAC = "audio/flac";
    public static final String AUDIO_MATROSKA = "audio/x-matroska";
    public static final String AUDIO_MLAW = "audio/g711-mlaw";
    public static final String AUDIO_MP4 = "audio/mp4";
    public static final String AUDIO_MPEG = "audio/mpeg";
    public static final String AUDIO_MPEG_L1 = "audio/mpeg-L1";
    public static final String AUDIO_MPEG_L2 = "audio/mpeg-L2";
    public static final String AUDIO_MSGSM = "audio/gsm";
    public static final String AUDIO_OGG = "audio/ogg";
    public static final String AUDIO_OPUS = "audio/opus";
    public static final String AUDIO_RAW = "audio/raw";
    public static final String AUDIO_TRUEHD = "audio/true-hd";
    public static final String AUDIO_UNKNOWN = "audio/x-unknown";
    public static final String AUDIO_VORBIS = "audio/vorbis";
    public static final String AUDIO_WAV = "audio/wav";
    public static final String AUDIO_WEBM = "audio/webm";
    public static final String BASE_TYPE_APPLICATION = "application";
    public static final String BASE_TYPE_AUDIO = "audio";
    public static final String BASE_TYPE_IMAGE = "image";
    public static final String BASE_TYPE_TEXT = "text";
    public static final String BASE_TYPE_VIDEO = "video";
    public static final String IMAGE_JPEG = "image/jpeg";
    private static final Pattern MP4A_RFC_6381_CODEC_PATTERN;
    public static final String TEXT_SSA = "text/x-ssa";
    public static final String TEXT_VTT = "text/vtt";
    public static final String VIDEO_AV1 = "video/av01";
    public static final String VIDEO_DIVX = "video/divx";
    public static final String VIDEO_DOLBY_VISION = "video/dolby-vision";
    public static final String VIDEO_FLV = "video/x-flv";
    public static final String VIDEO_H263 = "video/3gpp";
    public static final String VIDEO_H264 = "video/avc";
    public static final String VIDEO_H265 = "video/hevc";
    public static final String VIDEO_MATROSKA = "video/x-matroska";
    public static final String VIDEO_MP2T = "video/mp2t";
    public static final String VIDEO_MP4 = "video/mp4";
    public static final String VIDEO_MP4V = "video/mp4v-es";
    public static final String VIDEO_MPEG = "video/mpeg";
    public static final String VIDEO_MPEG2 = "video/mpeg2";
    public static final String VIDEO_OGG = "video/ogg";
    public static final String VIDEO_PS = "video/mp2p";
    public static final String VIDEO_UNKNOWN = "video/x-unknown";
    public static final String VIDEO_VC1 = "video/wvc1";
    public static final String VIDEO_VP8 = "video/x-vnd.on2.vp8";
    public static final String VIDEO_VP9 = "video/x-vnd.on2.vp9";
    public static final String VIDEO_WEBM = "video/webm";
    private static final ArrayList customMimeTypes;

    static {
        ArrayList arrayList;
        customMimeTypes = arrayList = new ArrayList();
        MP4A_RFC_6381_CODEC_PATTERN = Pattern.compile("^mp4a\\.([a-zA-Z0-9]{2})(?:\\.([0-9]{1,2}))?$");
    }

    private MimeTypes() {
    }

    public static boolean allSamplesAreSyncSamples(String object, String string2) {
        int n11 = 0;
        if (object == null) {
            return false;
        }
        ((String)object).hashCode();
        int n12 = -1;
        int n13 = ((String)object).hashCode();
        int n14 = 1;
        switch (n13) {
            default: {
                break;
            }
            case 1903589369: {
                String string3 = AUDIO_MLAW;
                boolean n10 = ((String)object).equals(string3);
                if (!n10) break;
                n12 = 10;
                break;
            }
            case 1903231877: {
                String string4 = AUDIO_ALAW;
                boolean bl2 = ((String)object).equals(string4);
                if (!bl2) break;
                n12 = 9;
                break;
            }
            case 1504831518: {
                String string5 = AUDIO_MPEG;
                boolean bl3 = ((String)object).equals(string5);
                if (!bl3) break;
                n12 = 8;
                break;
            }
            case 1504619009: {
                String string6 = AUDIO_FLAC;
                boolean bl4 = ((String)object).equals(string6);
                if (!bl4) break;
                n12 = 7;
                break;
            }
            case 1504578661: {
                String string7 = AUDIO_E_AC3;
                boolean bl5 = ((String)object).equals(string7);
                if (!bl5) break;
                n12 = 6;
                break;
            }
            case 187094639: {
                String string8 = AUDIO_RAW;
                boolean bl6 = ((String)object).equals(string8);
                if (!bl6) break;
                n12 = 5;
                break;
            }
            case 187078296: {
                String string9 = AUDIO_AC3;
                boolean bl7 = ((String)object).equals(string9);
                if (!bl7) break;
                n12 = 4;
                break;
            }
            case -53558318: {
                String string10 = AUDIO_AAC;
                boolean bl8 = ((String)object).equals(string10);
                if (!bl8) break;
                n12 = 3;
                break;
            }
            case -432837259: {
                String string11 = AUDIO_MPEG_L2;
                boolean bl9 = ((String)object).equals(string11);
                if (!bl9) break;
                n12 = 2;
                break;
            }
            case -432837260: {
                String string12 = AUDIO_MPEG_L1;
                boolean bl10 = ((String)object).equals(string12);
                if (!bl10) break;
                n12 = n14;
                break;
            }
            case -2123537834: {
                String string13 = AUDIO_E_AC3_JOC;
                boolean bl11 = ((String)object).equals(string13);
                if (!bl11) break;
                n12 = 0;
            }
        }
        switch (n12) {
            default: {
                return false;
            }
            case 3: {
                int n10;
                if (string2 == null) {
                    return false;
                }
                object = MimeTypes.getObjectTypeFromMp4aRFC6381CodecString(string2);
                if (object == null) {
                    return false;
                }
                int n15 = AacUtil.getEncodingForAudioObjectType(((MimeTypes$Mp4aObjectType)object).audioObjectTypeIndication);
                if (n15 != 0 && n15 != (n10 = 16)) {
                    n11 = n14;
                }
                return n11 != 0;
            }
            case 0: 
            case 1: 
            case 2: 
            case 4: 
            case 5: 
            case 6: 
            case 7: 
            case 8: 
            case 9: 
            case 10: 
        }
        return n14 != 0;
    }

    public static boolean containsCodecsCorrespondingToMimeType(String string2, String string3) {
        boolean bl2;
        if ((string2 = MimeTypes.getCodecsCorrespondingToMimeType(string2, string3)) != null) {
            bl2 = true;
        } else {
            bl2 = false;
            string2 = null;
        }
        return bl2;
    }

    public static String getAudioMediaMimeType(String stringArray) {
        if (stringArray == null) {
            return null;
        }
        stringArray = Util.splitCodecs((String)stringArray);
        int n10 = stringArray.length;
        for (int i10 = 0; i10 < n10; ++i10) {
            boolean bl2;
            String string2 = MimeTypes.getMediaMimeType(stringArray[i10]);
            if (string2 == null || !(bl2 = MimeTypes.isAudio(string2))) continue;
            return string2;
        }
        return null;
    }

    public static String getCodecsCorrespondingToMimeType(String stringArray, String string2) {
        String string3 = null;
        if (stringArray != null && string2 != null) {
            stringArray = Util.splitCodecs((String)stringArray);
            StringBuilder stringBuilder = new StringBuilder();
            for (String string4 : stringArray) {
                String string5 = MimeTypes.getMediaMimeType(string4);
                int n10 = string2.equals(string5);
                if (n10 == 0) continue;
                n10 = stringBuilder.length();
                if (n10 > 0) {
                    string5 = ",";
                    stringBuilder.append(string5);
                }
                stringBuilder.append(string4);
            }
            int n11 = stringBuilder.length();
            if (n11 > 0) {
                string3 = stringBuilder.toString();
            }
        }
        return string3;
    }

    private static String getCustomMimeTypeForCodec(String string2) {
        ArrayList arrayList = customMimeTypes;
        int n10 = arrayList.size();
        for (int i10 = 0; i10 < n10; ++i10) {
            MimeTypes$CustomMimeType mimeTypes$CustomMimeType = (MimeTypes$CustomMimeType)customMimeTypes.get(i10);
            String string3 = mimeTypes$CustomMimeType.codecPrefix;
            boolean bl2 = string2.startsWith(string3);
            if (!bl2) continue;
            return mimeTypes$CustomMimeType.mimeType;
        }
        return null;
    }

    public static int getEncoding(String object, String string2) {
        ((String)object).hashCode();
        int n10 = ((String)object).hashCode();
        int n11 = 8;
        int n12 = 7;
        int n13 = 6;
        int n14 = 5;
        int n15 = -1;
        switch (n10) {
            default: {
                break;
            }
            case 1556697186: {
                String string3 = AUDIO_TRUEHD;
                boolean bl2 = ((String)object).equals(string3);
                if (!bl2) break;
                n15 = n11;
                break;
            }
            case 1505942594: {
                String string4 = AUDIO_DTS_HD;
                boolean bl3 = ((String)object).equals(string4);
                if (!bl3) break;
                n15 = n12;
                break;
            }
            case 1504831518: {
                String string5 = AUDIO_MPEG;
                boolean bl4 = ((String)object).equals(string5);
                if (!bl4) break;
                n15 = n13;
                break;
            }
            case 1504578661: {
                String string6 = AUDIO_E_AC3;
                boolean bl5 = ((String)object).equals(string6);
                if (!bl5) break;
                n15 = n14;
                break;
            }
            case 187078297: {
                String string7 = AUDIO_AC4;
                boolean bl6 = ((String)object).equals(string7);
                if (!bl6) break;
                n15 = 4;
                break;
            }
            case 187078296: {
                String string8 = AUDIO_AC3;
                boolean bl7 = ((String)object).equals(string8);
                if (!bl7) break;
                n15 = 3;
                break;
            }
            case -53558318: {
                String string9 = AUDIO_AAC;
                boolean bl8 = ((String)object).equals(string9);
                if (!bl8) break;
                n15 = 2;
                break;
            }
            case -1095064472: {
                String string10 = AUDIO_DTS;
                boolean bl9 = ((String)object).equals(string10);
                if (!bl9) break;
                n15 = 1;
                break;
            }
            case -2123537834: {
                String string11 = AUDIO_E_AC3_JOC;
                boolean bl10 = ((String)object).equals(string11);
                if (!bl10) break;
                n15 = 0;
            }
        }
        switch (n15) {
            default: {
                return 0;
            }
            case 8: {
                return 14;
            }
            case 7: {
                return n11;
            }
            case 6: {
                return 9;
            }
            case 5: {
                return n13;
            }
            case 4: {
                return 17;
            }
            case 3: {
                return n14;
            }
            case 2: {
                if (string2 == null) {
                    return 0;
                }
                object = MimeTypes.getObjectTypeFromMp4aRFC6381CodecString(string2);
                if (object == null) {
                    return 0;
                }
                return AacUtil.getEncodingForAudioObjectType(((MimeTypes$Mp4aObjectType)object).audioObjectTypeIndication);
            }
            case 1: {
                return n12;
            }
            case 0: 
        }
        return 18;
    }

    public static String getMediaMimeType(String object) {
        String string2;
        boolean bl2 = false;
        String string3 = null;
        if (object == null) {
            return null;
        }
        boolean bl3 = ((String)(object = Util.toLowerInvariant(((String)object).trim()))).startsWith(string2 = "avc1");
        if (!bl3 && !(bl3 = ((String)object).startsWith(string2 = "avc3"))) {
            string2 = "hev1";
            bl3 = ((String)object).startsWith(string2);
            if (!bl3 && !(bl3 = ((String)object).startsWith(string2 = "hvc1"))) {
                string2 = "dvav";
                bl3 = ((String)object).startsWith(string2);
                if (!(bl3 || (bl3 = ((String)object).startsWith(string2 = "dva1")) || (bl3 = ((String)object).startsWith(string2 = "dvhe")) || (bl3 = ((String)object).startsWith(string2 = "dvh1")))) {
                    string2 = "av01";
                    bl3 = ((String)object).startsWith(string2);
                    if (bl3) {
                        return VIDEO_AV1;
                    }
                    string2 = "vp9";
                    bl3 = ((String)object).startsWith(string2);
                    if (!bl3 && !(bl3 = ((String)object).startsWith(string2 = "vp09"))) {
                        string2 = "vp8";
                        bl3 = ((String)object).startsWith(string2);
                        if (!bl3 && !(bl3 = ((String)object).startsWith(string2 = "vp08"))) {
                            string2 = "mp4a";
                            bl3 = ((String)object).startsWith(string2);
                            if (bl3) {
                                string2 = "mp4a.";
                                bl3 = ((String)object).startsWith(string2);
                                if (bl3 && (object = MimeTypes.getObjectTypeFromMp4aRFC6381CodecString((String)object)) != null) {
                                    int n10 = ((MimeTypes$Mp4aObjectType)object).objectTypeIndication;
                                    string3 = MimeTypes.getMimeTypeFromMp4ObjectType(n10);
                                }
                                if (string3 == null) {
                                    string3 = AUDIO_AAC;
                                }
                                return string3;
                            }
                            string3 = "ac-3";
                            bl2 = ((String)object).startsWith(string3);
                            if (!bl2 && !(bl2 = ((String)object).startsWith(string3 = "dac3"))) {
                                string3 = "ec-3";
                                bl2 = ((String)object).startsWith(string3);
                                if (!bl2 && !(bl2 = ((String)object).startsWith(string3 = "dec3"))) {
                                    string3 = "ec+3";
                                    bl2 = ((String)object).startsWith(string3);
                                    if (bl2) {
                                        return AUDIO_E_AC3_JOC;
                                    }
                                    string3 = "ac-4";
                                    bl2 = ((String)object).startsWith(string3);
                                    if (!bl2 && !(bl2 = ((String)object).startsWith(string3 = "dac4"))) {
                                        string3 = "dtsc";
                                        bl2 = ((String)object).startsWith(string3);
                                        if (!bl2 && !(bl2 = ((String)object).startsWith(string3 = "dtse"))) {
                                            string3 = "dtsh";
                                            bl2 = ((String)object).startsWith(string3);
                                            if (!bl2 && !(bl2 = ((String)object).startsWith(string3 = "dtsl"))) {
                                                string3 = "opus";
                                                bl2 = ((String)object).startsWith(string3);
                                                if (bl2) {
                                                    return AUDIO_OPUS;
                                                }
                                                string3 = "vorbis";
                                                bl2 = ((String)object).startsWith(string3);
                                                if (bl2) {
                                                    return AUDIO_VORBIS;
                                                }
                                                string3 = "flac";
                                                bl2 = ((String)object).startsWith(string3);
                                                if (bl2) {
                                                    return AUDIO_FLAC;
                                                }
                                                string3 = "stpp";
                                                bl2 = ((String)object).startsWith(string3);
                                                if (bl2) {
                                                    return APPLICATION_TTML;
                                                }
                                                string3 = "wvtt";
                                                bl2 = ((String)object).startsWith(string3);
                                                if (bl2) {
                                                    return TEXT_VTT;
                                                }
                                                string3 = "cea708";
                                                bl2 = ((String)object).contains(string3);
                                                if (bl2) {
                                                    return APPLICATION_CEA708;
                                                }
                                                string3 = "eia608";
                                                bl2 = ((String)object).contains(string3);
                                                if (!bl2 && !(bl2 = ((String)object).contains(string3 = "cea608"))) {
                                                    return MimeTypes.getCustomMimeTypeForCodec((String)object);
                                                }
                                                return APPLICATION_CEA608;
                                            }
                                            return AUDIO_DTS_HD;
                                        }
                                        return AUDIO_DTS;
                                    }
                                    return AUDIO_AC4;
                                }
                                return AUDIO_E_AC3;
                            }
                            return AUDIO_AC3;
                        }
                        return VIDEO_VP8;
                    }
                    return VIDEO_VP9;
                }
                return VIDEO_DOLBY_VISION;
            }
            return VIDEO_H265;
        }
        return VIDEO_H264;
    }

    public static String getMimeTypeFromMp4ObjectType(int n10) {
        int n11 = 32;
        if (n10 != n11) {
            n11 = 33;
            if (n10 != n11) {
                n11 = 35;
                if (n10 != n11) {
                    n11 = 64;
                    if (n10 != n11) {
                        n11 = 163;
                        if (n10 != n11) {
                            n11 = 177;
                            if (n10 != n11) {
                                n11 = 165;
                                if (n10 != n11) {
                                    n11 = 166;
                                    if (n10 != n11) {
                                        switch (n10) {
                                            default: {
                                                switch (n10) {
                                                    default: {
                                                        return null;
                                                    }
                                                    case 174: {
                                                        return AUDIO_AC4;
                                                    }
                                                    case 173: {
                                                        return AUDIO_OPUS;
                                                    }
                                                    case 170: 
                                                    case 171: {
                                                        return AUDIO_DTS_HD;
                                                    }
                                                    case 169: 
                                                    case 172: 
                                                }
                                                return AUDIO_DTS;
                                            }
                                            case 106: {
                                                return VIDEO_MPEG;
                                            }
                                            case 105: 
                                            case 107: {
                                                return AUDIO_MPEG;
                                            }
                                            case 96: 
                                            case 97: 
                                            case 98: 
                                            case 99: 
                                            case 100: 
                                            case 101: {
                                                return VIDEO_MPEG2;
                                            }
                                            case 102: 
                                            case 103: 
                                            case 104: {
                                                return AUDIO_AAC;
                                            }
                                        }
                                    }
                                    return AUDIO_E_AC3;
                                }
                                return AUDIO_AC3;
                            }
                            return VIDEO_VP9;
                        }
                        return VIDEO_VC1;
                    }
                    return AUDIO_AAC;
                }
                return VIDEO_H265;
            }
            return VIDEO_H264;
        }
        return VIDEO_MP4V;
    }

    public static MimeTypes$Mp4aObjectType getObjectTypeFromMp4aRFC6381CodecString(String object) {
        int n10;
        int n11;
        block4: {
            Object object2 = MP4A_RFC_6381_CODEC_PATTERN;
            n11 = (int)(((Matcher)(object = ((Pattern)object2).matcher((CharSequence)object))).matches() ? 1 : 0);
            if (n11 == 0) {
                return null;
            }
            n11 = 1;
            object2 = (String)Assertions.checkNotNull(((Matcher)object).group(n11));
            object = ((Matcher)object).group(2);
            n10 = 0;
            int n12 = 16;
            try {
                n11 = Integer.parseInt((String)object2, n12);
                if (object == null) break block4;
            }
            catch (NumberFormatException numberFormatException) {
                return null;
            }
            n10 = Integer.parseInt((String)object);
        }
        object = new MimeTypes$Mp4aObjectType(n11, n10);
        return object;
    }

    public static String getTextMediaMimeType(String stringArray) {
        if (stringArray == null) {
            return null;
        }
        stringArray = Util.splitCodecs((String)stringArray);
        int n10 = stringArray.length;
        for (int i10 = 0; i10 < n10; ++i10) {
            boolean bl2;
            String string2 = MimeTypes.getMediaMimeType(stringArray[i10]);
            if (string2 == null || !(bl2 = MimeTypes.isText(string2))) continue;
            return string2;
        }
        return null;
    }

    private static String getTopLevelType(String string2) {
        int n10;
        if (string2 == null) {
            return null;
        }
        int n11 = string2.indexOf(47);
        if (n11 == (n10 = -1)) {
            return null;
        }
        return string2.substring(0, n11);
    }

    public static int getTrackType(String string2) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (bl2) {
            return -1;
        }
        bl2 = MimeTypes.isAudio(string2);
        if (bl2) {
            return 1;
        }
        bl2 = MimeTypes.isVideo(string2);
        if (bl2) {
            return 2;
        }
        bl2 = MimeTypes.isText(string2);
        if (bl2) {
            return 3;
        }
        String string3 = APPLICATION_ID3;
        bl2 = string3.equals(string2);
        if (!(bl2 || (bl2 = (string3 = APPLICATION_EMSG).equals(string2)) || (bl2 = (string3 = APPLICATION_SCTE35).equals(string2)))) {
            string3 = APPLICATION_CAMERA_MOTION;
            bl2 = string3.equals(string2);
            if (bl2) {
                return 6;
            }
            return MimeTypes.getTrackTypeForCustomMimeType(string2);
        }
        return 5;
    }

    private static int getTrackTypeForCustomMimeType(String string2) {
        ArrayList arrayList = customMimeTypes;
        int n10 = arrayList.size();
        for (int i10 = 0; i10 < n10; ++i10) {
            MimeTypes$CustomMimeType mimeTypes$CustomMimeType = (MimeTypes$CustomMimeType)customMimeTypes.get(i10);
            String string3 = mimeTypes$CustomMimeType.mimeType;
            boolean bl2 = string2.equals(string3);
            if (!bl2) continue;
            return mimeTypes$CustomMimeType.trackType;
        }
        return -1;
    }

    public static int getTrackTypeOfCodec(String string2) {
        return MimeTypes.getTrackType(MimeTypes.getMediaMimeType(string2));
    }

    public static String getVideoMediaMimeType(String stringArray) {
        if (stringArray == null) {
            return null;
        }
        stringArray = Util.splitCodecs((String)stringArray);
        int n10 = stringArray.length;
        for (int i10 = 0; i10 < n10; ++i10) {
            boolean bl2;
            String string2 = MimeTypes.getMediaMimeType(stringArray[i10]);
            if (string2 == null || !(bl2 = MimeTypes.isVideo(string2))) continue;
            return string2;
        }
        return null;
    }

    public static boolean isAudio(String string2) {
        string2 = MimeTypes.getTopLevelType(string2);
        return BASE_TYPE_AUDIO.equals(string2);
    }

    public static boolean isMatroska(String string2) {
        boolean bl2;
        boolean bl3 = false;
        if (string2 == null) {
            return false;
        }
        String string3 = VIDEO_WEBM;
        boolean bl4 = string2.startsWith(string3);
        if (bl4 || (bl4 = string2.startsWith(string3 = AUDIO_WEBM)) || (bl4 = string2.startsWith(string3 = APPLICATION_WEBM)) || (bl4 = string2.startsWith(string3 = VIDEO_MATROSKA)) || (bl4 = string2.startsWith(string3 = AUDIO_MATROSKA)) || (bl2 = string2.startsWith(string3 = APPLICATION_MATROSKA))) {
            bl3 = true;
        }
        return bl3;
    }

    public static boolean isText(String string2) {
        boolean bl2;
        String string3 = BASE_TYPE_TEXT;
        String string4 = MimeTypes.getTopLevelType(string2);
        boolean bl3 = string3.equals(string4);
        if (!(bl3 || (bl3 = (string4 = APPLICATION_CEA608).equals(string2)) || (bl3 = (string4 = APPLICATION_CEA708).equals(string2)) || (bl3 = (string4 = APPLICATION_MP4CEA608).equals(string2)) || (bl3 = (string4 = APPLICATION_SUBRIP).equals(string2)) || (bl3 = (string4 = APPLICATION_TTML).equals(string2)) || (bl3 = (string4 = APPLICATION_TX3G).equals(string2)) || (bl3 = (string4 = APPLICATION_MP4VTT).equals(string2)) || (bl3 = (string4 = APPLICATION_RAWCC).equals(string2)) || (bl3 = (string4 = APPLICATION_VOBSUB).equals(string2)) || (bl3 = (string4 = APPLICATION_PGS).equals(string2)) || (bl2 = (string4 = APPLICATION_DVBSUBS).equals(string2)))) {
            bl2 = false;
            string2 = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }

    public static boolean isVideo(String string2) {
        string2 = MimeTypes.getTopLevelType(string2);
        return BASE_TYPE_VIDEO.equals(string2);
    }

    public static String normalizeMimeType(String string2) {
        string2.hashCode();
        int n10 = string2.hashCode();
        int n11 = -1;
        switch (n10) {
            default: {
                break;
            }
            case 187090231: {
                String string3 = "audio/mp3";
                n10 = (int)(string2.equals(string3) ? 1 : 0);
                if (n10 == 0) break;
                n11 = 2;
                break;
            }
            case -586683234: {
                String string4 = "audio/x-wav";
                n10 = (int)(string2.equals(string4) ? 1 : 0);
                if (n10 == 0) break;
                n11 = 1;
                break;
            }
            case -1007807498: {
                String string5 = "audio/x-flac";
                n10 = (int)(string2.equals(string5) ? 1 : 0);
                if (n10 == 0) break;
                n11 = 0;
            }
        }
        switch (n11) {
            default: {
                return string2;
            }
            case 2: {
                return AUDIO_MPEG;
            }
            case 1: {
                return AUDIO_WAV;
            }
            case 0: 
        }
        return AUDIO_FLAC;
    }

    public static void registerCustomMimeType(String string2, String object, int n10) {
        MimeTypes$CustomMimeType mimeTypes$CustomMimeType = new MimeTypes$CustomMimeType(string2, (String)object, n10);
        object = customMimeTypes;
        int n11 = ((ArrayList)object).size();
        for (n10 = 0; n10 < n11; ++n10) {
            ArrayList arrayList = customMimeTypes;
            String string3 = ((MimeTypes$CustomMimeType)arrayList.get((int)n10)).mimeType;
            boolean bl2 = string2.equals(string3);
            if (!bl2) continue;
            arrayList.remove(n10);
            break;
        }
        customMimeTypes.add(mimeTypes$CustomMimeType);
    }
}

