/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.media.MediaCodecInfo
 *  android.media.MediaCodecInfo$CodecProfileLevel
 *  android.util.Pair
 */
package com.google.android.exoplayer2.mediacodec;

import android.media.MediaCodecInfo;
import android.util.Pair;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.mediacodec.MediaCodecInfo;
import com.google.android.exoplayer2.mediacodec.MediaCodecUtil$CodecKey;
import com.google.android.exoplayer2.mediacodec.MediaCodecUtil$DecoderQueryException;
import com.google.android.exoplayer2.mediacodec.MediaCodecUtil$MediaCodecListCompat;
import com.google.android.exoplayer2.mediacodec.MediaCodecUtil$MediaCodecListCompatV16;
import com.google.android.exoplayer2.mediacodec.MediaCodecUtil$MediaCodecListCompatV21;
import com.google.android.exoplayer2.mediacodec.MediaCodecUtil$ScoreProvider;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.video.ColorInfo;
import d.h.a.a.i0.e;
import d.h.a.a.i0.f;
import d.h.a.a.i0.g;
import d.h.a.a.i0.h;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class MediaCodecUtil {
    private static final String CODEC_ID_AV01 = "av01";
    private static final String CODEC_ID_AVC1 = "avc1";
    private static final String CODEC_ID_AVC2 = "avc2";
    private static final String CODEC_ID_HEV1 = "hev1";
    private static final String CODEC_ID_HVC1 = "hvc1";
    private static final String CODEC_ID_MP4A = "mp4a";
    private static final String CODEC_ID_VP09 = "vp09";
    private static final Pattern PROFILE_PATTERN;
    private static final String TAG = "MediaCodecUtil";
    private static final HashMap decoderInfosCache;
    private static int maxH264DecodableFrameSize;

    static {
        HashMap hashMap;
        PROFILE_PATTERN = Pattern.compile("^\\D?(\\d+)$");
        decoderInfosCache = hashMap = new HashMap();
        maxH264DecodableFrameSize = -1;
    }

    private MediaCodecUtil() {
    }

    public static /* synthetic */ int a(MediaCodecInfo object) {
        boolean bl2;
        object = ((MediaCodecInfo)object).name;
        String string2 = "OMX.google";
        boolean n10 = ((String)object).startsWith(string2);
        if (!n10 && !(bl2 = ((String)object).startsWith(string2 = "c2.android"))) {
            boolean bl3;
            int n11 = Util.SDK_INT;
            int n12 = 26;
            if (n11 < n12 && (bl3 = ((String)object).equals(string2 = "OMX.MTK.AUDIO.DECODER.RAW"))) {
                return -1;
            }
            return 0;
        }
        return 1;
    }

    private static void applyWorkarounds(String object, List list) {
        boolean bl2;
        String string2;
        Object object2;
        int n10;
        String string3 = "audio/raw";
        int n11 = string3.equals(object);
        int n12 = 1;
        if (n11 != 0) {
            n11 = Util.SDK_INT;
            n10 = 26;
            if (n11 < n10 && (n11 = (int)(((String)(object = Util.DEVICE)).equals(object2 = "R9") ? 1 : 0)) != 0 && (n11 = list.size()) == n12 && (n11 = (int)(((String)(object = ((MediaCodecInfo)list.get((int)0)).name)).equals(object2 = "OMX.MTK.AUDIO.DECODER.RAW") ? 1 : 0)) != 0) {
                boolean bl3 = true;
                object2 = "OMX.google.raw.decoder";
                string2 = "audio/raw";
                String string4 = "audio/raw";
                object = MediaCodecInfo.newInstance((String)object2, string2, string4, null, false, bl3, false, false, false);
                list.add(object);
            }
            object = e.a;
            MediaCodecUtil.sortByScore(list, (MediaCodecUtil$ScoreProvider)object);
        }
        if ((n11 = Util.SDK_INT) < (n10 = 21) && (n10 = list.size()) > n12 && ((bl2 = (string2 = "OMX.SEC.mp3.dec").equals(object2 = ((MediaCodecInfo)list.get((int)0)).name)) || (bl2 = (string2 = "OMX.SEC.MP3.Decoder").equals(object2)) || (n10 = (int)((string2 = "OMX.brcm.audio.mp3.decoder").equals(object2) ? 1 : 0)) != 0)) {
            object2 = f.a;
            MediaCodecUtil.sortByScore(list, (MediaCodecUtil$ScoreProvider)object2);
        }
        if (n11 < (n10 = 30) && (n11 = list.size()) > n12 && (n11 = (int)((string3 = "OMX.qti.audio.decoder.flac").equals(object = ((MediaCodecInfo)list.get((int)0)).name) ? 1 : 0)) != 0) {
            object = (MediaCodecInfo)list.remove(0);
            list.add(object);
        }
    }

    private static int av1LevelNumberToConst(int n10) {
        switch (n10) {
            default: {
                return -1;
            }
            case 23: {
                return 0x800000;
            }
            case 22: {
                return 0x400000;
            }
            case 21: {
                return 0x200000;
            }
            case 20: {
                return 0x100000;
            }
            case 19: {
                return 524288;
            }
            case 18: {
                return 262144;
            }
            case 17: {
                return 131072;
            }
            case 16: {
                return 65536;
            }
            case 15: {
                return 32768;
            }
            case 14: {
                return 16384;
            }
            case 13: {
                return 8192;
            }
            case 12: {
                return 4096;
            }
            case 11: {
                return 2048;
            }
            case 10: {
                return 1024;
            }
            case 9: {
                return 512;
            }
            case 8: {
                return 256;
            }
            case 7: {
                return 128;
            }
            case 6: {
                return 64;
            }
            case 5: {
                return 32;
            }
            case 4: {
                return 16;
            }
            case 3: {
                return 8;
            }
            case 2: {
                return 4;
            }
            case 1: {
                return 2;
            }
            case 0: 
        }
        return 1;
    }

    private static int avcLevelNumberToConst(int n10) {
        switch (n10) {
            default: {
                switch (n10) {
                    default: {
                        switch (n10) {
                            default: {
                                switch (n10) {
                                    default: {
                                        switch (n10) {
                                            default: {
                                                return -1;
                                            }
                                            case 52: {
                                                return 65536;
                                            }
                                            case 51: {
                                                return 32768;
                                            }
                                            case 50: 
                                        }
                                        return 16384;
                                    }
                                    case 42: {
                                        return 8192;
                                    }
                                    case 41: {
                                        return 4096;
                                    }
                                    case 40: 
                                }
                                return 2048;
                            }
                            case 32: {
                                return 1024;
                            }
                            case 31: {
                                return 512;
                            }
                            case 30: 
                        }
                        return 256;
                    }
                    case 22: {
                        return 128;
                    }
                    case 21: {
                        return 64;
                    }
                    case 20: 
                }
                return 32;
            }
            case 13: {
                return 16;
            }
            case 12: {
                return 8;
            }
            case 11: {
                return 4;
            }
            case 10: 
        }
        return 1;
    }

    private static int avcLevelToMaxFrameSize(int n10) {
        int n11 = 1;
        if (n10 != n11 && n10 != (n11 = 2)) {
            switch (n10) {
                default: {
                    return -1;
                }
                case 32768: 
                case 65536: {
                    return 0x900000;
                }
                case 16384: {
                    return 5652480;
                }
                case 8192: {
                    return 0x220000;
                }
                case 2048: 
                case 4096: {
                    return 0x200000;
                }
                case 1024: {
                    return 0x140000;
                }
                case 512: {
                    return 921600;
                }
                case 128: 
                case 256: {
                    return 414720;
                }
                case 64: {
                    return 202752;
                }
                case 8: 
                case 16: 
                case 32: 
            }
            return 101376;
        }
        return 25344;
    }

    private static int avcProfileNumberToConst(int n10) {
        int n11 = 66;
        if (n10 != n11) {
            n11 = 77;
            if (n10 != n11) {
                n11 = 88;
                if (n10 != n11) {
                    n11 = 100;
                    if (n10 != n11) {
                        n11 = 110;
                        if (n10 != n11) {
                            n11 = 122;
                            if (n10 != n11) {
                                n11 = 244;
                                if (n10 != n11) {
                                    return -1;
                                }
                                return 64;
                            }
                            return 32;
                        }
                        return 16;
                    }
                    return 8;
                }
                return 4;
            }
            return 2;
        }
        return 1;
    }

    public static /* synthetic */ int b(MediaCodecInfo mediaCodecInfo) {
        return (int)(mediaCodecInfo.name.startsWith("OMX.google") ? 1 : 0);
    }

    public static /* synthetic */ int c(Format format, MediaCodecInfo mediaCodecInfo) {
        try {
            return (int)(mediaCodecInfo.isFormatSupported(format) ? 1 : 0);
        }
        catch (MediaCodecUtil$DecoderQueryException mediaCodecUtil$DecoderQueryException) {
            return -1;
        }
    }

    public static void clearDecoderInfoCache() {
        Class<MediaCodecUtil> clazz = MediaCodecUtil.class;
        synchronized (clazz) {
            HashMap hashMap = decoderInfosCache;
            hashMap.clear();
            return;
        }
    }

    public static /* synthetic */ int d(MediaCodecUtil$ScoreProvider mediaCodecUtil$ScoreProvider, Object object, Object object2) {
        int n10 = mediaCodecUtil$ScoreProvider.getScore(object2);
        int n11 = mediaCodecUtil$ScoreProvider.getScore(object);
        return n10 - n11;
    }

    private static Integer dolbyVisionStringToLevel(String string2) {
        if (string2 == null) {
            return null;
        }
        string2.hashCode();
        int n10 = -1;
        int n11 = string2.hashCode();
        int n12 = 8;
        int n13 = 4;
        int n14 = 2;
        int n15 = 1;
        switch (n11) {
            default: {
                break;
            }
            case 1570: {
                String string3 = "13";
                boolean bl2 = string2.equals(string3);
                if (!bl2) break;
                n10 = 12;
                break;
            }
            case 1569: {
                String string4 = "12";
                boolean bl3 = string2.equals(string4);
                if (!bl3) break;
                n10 = 11;
                break;
            }
            case 1568: {
                String string5 = "11";
                boolean bl4 = string2.equals(string5);
                if (!bl4) break;
                n10 = 10;
                break;
            }
            case 1567: {
                String string6 = "10";
                boolean bl5 = string2.equals(string6);
                if (!bl5) break;
                n10 = 9;
                break;
            }
            case 1545: {
                String string7 = "09";
                boolean bl6 = string2.equals(string7);
                if (!bl6) break;
                n10 = n12;
                break;
            }
            case 1544: {
                String string8 = "08";
                boolean bl7 = string2.equals(string8);
                if (!bl7) break;
                n10 = 7;
                break;
            }
            case 1543: {
                String string9 = "07";
                boolean bl8 = string2.equals(string9);
                if (!bl8) break;
                n10 = 6;
                break;
            }
            case 1542: {
                String string10 = "06";
                boolean bl9 = string2.equals(string10);
                if (!bl9) break;
                n10 = 5;
                break;
            }
            case 1541: {
                String string11 = "05";
                boolean bl10 = string2.equals(string11);
                if (!bl10) break;
                n10 = n13;
                break;
            }
            case 1540: {
                String string12 = "04";
                boolean bl11 = string2.equals(string12);
                if (!bl11) break;
                n10 = 3;
                break;
            }
            case 1539: {
                String string13 = "03";
                boolean bl12 = string2.equals(string13);
                if (!bl12) break;
                n10 = n14;
                break;
            }
            case 1538: {
                String string14 = "02";
                boolean bl13 = string2.equals(string14);
                if (!bl13) break;
                n10 = n15;
                break;
            }
            case 1537: {
                String string15 = "01";
                boolean bl14 = string2.equals(string15);
                if (!bl14) break;
                n10 = 0;
            }
        }
        switch (n10) {
            default: {
                return null;
            }
            case 12: {
                return 4096;
            }
            case 11: {
                return 2048;
            }
            case 10: {
                return 1024;
            }
            case 9: {
                return 512;
            }
            case 8: {
                return 256;
            }
            case 7: {
                return 128;
            }
            case 6: {
                return 64;
            }
            case 5: {
                return 32;
            }
            case 4: {
                return 16;
            }
            case 3: {
                return n12;
            }
            case 2: {
                return n13;
            }
            case 1: {
                return n14;
            }
            case 0: 
        }
        return n15;
    }

    private static Integer dolbyVisionStringToProfile(String string2) {
        if (string2 == null) {
            return null;
        }
        string2.hashCode();
        int n10 = -1;
        int n11 = string2.hashCode();
        int n12 = 8;
        int n13 = 4;
        int n14 = 2;
        int n15 = 1;
        switch (n11) {
            default: {
                break;
            }
            case 1545: {
                String string3 = "09";
                boolean bl2 = string2.equals(string3);
                if (!bl2) break;
                n10 = 9;
                break;
            }
            case 1544: {
                String string4 = "08";
                boolean bl3 = string2.equals(string4);
                if (!bl3) break;
                n10 = n12;
                break;
            }
            case 1543: {
                String string5 = "07";
                boolean bl4 = string2.equals(string5);
                if (!bl4) break;
                n10 = 7;
                break;
            }
            case 1542: {
                String string6 = "06";
                boolean bl5 = string2.equals(string6);
                if (!bl5) break;
                n10 = 6;
                break;
            }
            case 1541: {
                String string7 = "05";
                boolean bl6 = string2.equals(string7);
                if (!bl6) break;
                n10 = 5;
                break;
            }
            case 1540: {
                String string8 = "04";
                boolean bl7 = string2.equals(string8);
                if (!bl7) break;
                n10 = n13;
                break;
            }
            case 1539: {
                String string9 = "03";
                boolean bl8 = string2.equals(string9);
                if (!bl8) break;
                n10 = 3;
                break;
            }
            case 1538: {
                String string10 = "02";
                boolean bl9 = string2.equals(string10);
                if (!bl9) break;
                n10 = n14;
                break;
            }
            case 1537: {
                String string11 = "01";
                boolean bl10 = string2.equals(string11);
                if (!bl10) break;
                n10 = n15;
                break;
            }
            case 1536: {
                String string12 = "00";
                boolean bl11 = string2.equals(string12);
                if (!bl11) break;
                n10 = 0;
            }
        }
        switch (n10) {
            default: {
                return null;
            }
            case 9: {
                return 512;
            }
            case 8: {
                return 256;
            }
            case 7: {
                return 128;
            }
            case 6: {
                return 64;
            }
            case 5: {
                return 32;
            }
            case 4: {
                return 16;
            }
            case 3: {
                return n12;
            }
            case 2: {
                return n13;
            }
            case 1: {
                return n14;
            }
            case 0: 
        }
        return n15;
    }

    private static Pair getAacCodecProfileAndLevel(String string2, String[] object) {
        block13: {
            int n10 = ((String[])object).length;
            String string3 = "Ignoring malformed MP4A codec string: ";
            String string4 = TAG;
            int n11 = 3;
            if (n10 != n11) {
                int n12 = (string2 = String.valueOf(string2)).length();
                string2 = n12 != 0 ? string3.concat(string2) : new String(string3);
                Log.w(string4, string2);
                return null;
            }
            n10 = 1;
            String string5 = object[n10];
            n11 = 16;
            n10 = Integer.parseInt(string5, n11);
            string5 = MimeTypes.getMimeTypeFromMp4ObjectType(n10);
            Object object2 = "audio/mp4a-latm";
            n10 = (int)(((String)object2).equals(string5) ? 1 : 0);
            if (n10 == 0) break block13;
            n10 = 2;
            object = object[n10];
            int n13 = Integer.parseInt((String)object);
            n13 = MediaCodecUtil.mp4aAudioObjectTypeToProfile(n13);
            n10 = -1;
            if (n13 == n10) break block13;
            object = n13;
            n11 = 0;
            object2 = null;
            object2 = 0;
            try {
                string5 = new Pair(object, object2);
                return string5;
            }
            catch (NumberFormatException numberFormatException) {
                string2 = String.valueOf(string2);
                n13 = string2.length();
                string2 = n13 != 0 ? string3.concat(string2) : new String(string3);
                Log.w(string4, string2);
            }
        }
        return null;
    }

    private static Pair getAv1ProfileAndLevel(String object, String[] object2, ColorInfo object3) {
        int n10;
        int n11;
        int n12;
        int n13;
        String string2;
        int n14;
        block12: {
            String string3;
            n14 = ((String[])object2).length;
            String string4 = "Ignoring malformed AV1 codec string: ";
            string2 = TAG;
            int n15 = 4;
            if (n14 < n15) {
                int n16 = ((String)(object = String.valueOf(object))).length();
                object = n16 != 0 ? string4.concat((String)object) : new String(string4);
                Log.w(string2, (String)object);
                return null;
            }
            n14 = 1;
            try {
                string3 = object2[n14];
            }
            catch (NumberFormatException numberFormatException) {
                object = String.valueOf(object);
                int n17 = ((String)object).length();
                object = n17 != 0 ? string4.concat((String)object) : new String(string4);
                Log.w(string2, (String)object);
                return null;
            }
            n15 = Integer.parseInt(string3);
            n13 = 2;
            String string5 = object2[n13];
            int n18 = 0;
            string5 = string5.substring(0, n13);
            n12 = Integer.parseInt(string5);
            n18 = 3;
            object2 = object2[n18];
            n11 = Integer.parseInt((String)object2);
            if (n15 == 0) break block12;
            object2 = new StringBuilder(32);
            ((StringBuilder)object2).append("Unknown AV1 profile: ");
            ((StringBuilder)object2).append(n15);
            object = ((StringBuilder)object2).toString();
            Log.w(string2, (String)object);
            return null;
        }
        int n19 = 8;
        if (n11 != n19 && n11 != (n10 = 10)) {
            object3 = new StringBuilder(34);
            ((StringBuilder)object3).append("Unknown AV1 bit depth: ");
            ((StringBuilder)object3).append(n11);
            object = ((StringBuilder)object3).toString();
            Log.w(string2, (String)object);
            return null;
        }
        if (n11 != n19) {
            n14 = object3 != null && ((object = (Object)((ColorInfo)object3).hdrStaticInfo) != null || (n11 = ((ColorInfo)object3).colorTransfer) == (n19 = 7) || n11 == (n19 = 6)) ? 4096 : n13;
        }
        if ((n11 = MediaCodecUtil.av1LevelNumberToConst(n12)) == (n19 = -1)) {
            object2 = new StringBuilder(30);
            ((StringBuilder)object2).append("Unknown AV1 level: ");
            ((StringBuilder)object2).append(n12);
            object = ((StringBuilder)object2).toString();
            Log.w(string2, (String)object);
            return null;
        }
        object3 = n14;
        object = n11;
        object2 = new Pair(object3, object);
        return object2;
    }

    private static Pair getAvcProfileAndLevel(String string2, String[] object) {
        String string3;
        block27: {
            String string4;
            block26: {
                int n10;
                block25: {
                    Object object2;
                    int n11;
                    int n12;
                    block24: {
                        int n13;
                        int n14;
                        block23: {
                            String string5;
                            n10 = ((String[])object).length;
                            string4 = "Ignoring malformed AVC codec string: ";
                            n12 = 2;
                            string3 = TAG;
                            if (n10 < n12) {
                                int n15 = (string2 = String.valueOf(string2)).length();
                                string2 = n15 != 0 ? string4.concat(string2) : new String(string4);
                                Log.w(string3, string2);
                                return null;
                            }
                            n10 = 1;
                            try {
                                string5 = object[n10];
                            }
                            catch (NumberFormatException numberFormatException) {
                                string2 = String.valueOf(string2);
                                int n16 = string2.length();
                                string2 = n16 != 0 ? string4.concat(string2) : new String(string4);
                                Log.w(string3, string2);
                                return null;
                            }
                            n14 = string5.length();
                            n13 = 6;
                            if (n14 != n13) break block23;
                            string5 = object[n10];
                            n13 = 0;
                            String string6 = string5.substring(0, n12);
                            n14 = 16;
                            n12 = Integer.parseInt(string6, n14);
                            object = object[n10];
                            n10 = 4;
                            object = ((String)object).substring(n10);
                            n11 = Integer.parseInt((String)object, n14);
                            break block24;
                        }
                        n14 = ((String[])object).length;
                        n13 = 3;
                        if (n14 < n13) break block25;
                        object2 = object[n10];
                        n10 = Integer.parseInt((String)object2);
                        object = object[n12];
                        n11 = Integer.parseInt((String)object);
                        n12 = n10;
                    }
                    int n17 = MediaCodecUtil.avcProfileNumberToConst(n12);
                    n10 = -1;
                    if (n17 == n10) {
                        object = new StringBuilder(32);
                        ((StringBuilder)object).append("Unknown AVC profile: ");
                        ((StringBuilder)object).append(n12);
                        string2 = ((StringBuilder)object).toString();
                        Log.w(string3, string2);
                        return null;
                    }
                    int n18 = MediaCodecUtil.avcLevelNumberToConst(n11);
                    if (n18 == n10) {
                        object2 = new StringBuilder(30);
                        ((StringBuilder)object2).append("Unknown AVC level: ");
                        ((StringBuilder)object2).append(n11);
                        string2 = ((StringBuilder)object2).toString();
                        Log.w(string3, string2);
                        return null;
                    }
                    object = n17;
                    object2 = n18;
                    string2 = new Pair(object, object2);
                    return string2;
                }
                object = String.valueOf(string2);
                n10 = ((String)object).length();
                if (n10 == 0) break block26;
                object = string4.concat((String)object);
                break block27;
            }
            object = new String(string4);
        }
        Log.w(string3, (String)object);
        return null;
    }

    private static String getCodecMimeType(android.media.MediaCodecInfo object, String string2, String string3) {
        for (String string4 : object.getSupportedTypes()) {
            boolean bl2 = string4.equalsIgnoreCase(string3);
            if (!bl2) continue;
            return string4;
        }
        object = "video/dolby-vision";
        boolean bl3 = string3.equals(object);
        if (bl3) {
            object = "OMX.MS.HEVCDV.Decoder";
            bl3 = ((String)object).equals(string2);
            if (bl3) {
                return "video/hevcdv";
            }
            object = "OMX.RTK.video.decoder";
            bl3 = ((String)object).equals(string2);
            if (bl3 || (bl3 = ((String)(object = "OMX.realtek.video.decoder.tunneled")).equals(string2))) {
                return "video/dv_hevc";
            }
        } else {
            object = "audio/alac";
            bl3 = string3.equals(object);
            if (bl3 && (bl3 = ((String)(object = "OMX.lge.alac.decoder")).equals(string2))) {
                return "audio/x-lg-alac";
            }
            object = "audio/flac";
            bl3 = string3.equals(object);
            if (bl3 && (bl3 = ((String)(object = "OMX.lge.flac.decoder")).equals(string2))) {
                return "audio/x-lg-flac";
            }
        }
        return null;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static Pair getCodecProfileAndLevel(Format object) {
        int n10;
        String string2;
        String[] stringArray;
        block18: {
            stringArray = object.codecs;
            string2 = null;
            if (stringArray == null) {
                return null;
            }
            stringArray = stringArray.split("\\.");
            String string3 = "video/dolby-vision";
            String string4 = object.sampleMimeType;
            n10 = string3.equals(string4);
            if (n10 != 0) {
                return MediaCodecUtil.getDolbyVisionProfileAndLevel(object.codecs, stringArray);
            }
            n10 = 0;
            string4 = null;
            string3 = stringArray[0];
            string3.hashCode();
            int n11 = -1;
            int n12 = string3.hashCode();
            switch (n12) {
                case 3624515: {
                    string4 = CODEC_ID_VP09;
                    n10 = (int)(string3.equals(string4) ? 1 : 0);
                    if (n10 == 0) break;
                    n10 = 6;
                    break block18;
                }
                case 3356560: {
                    string4 = CODEC_ID_MP4A;
                    n10 = (int)(string3.equals(string4) ? 1 : 0);
                    if (n10 == 0) break;
                    n10 = 5;
                    break block18;
                }
                case 3214780: {
                    string4 = CODEC_ID_HVC1;
                    n10 = (int)(string3.equals(string4) ? 1 : 0);
                    if (n10 == 0) break;
                    n10 = 4;
                    break block18;
                }
                case 3199032: {
                    string4 = CODEC_ID_HEV1;
                    n10 = (int)(string3.equals(string4) ? 1 : 0);
                    if (n10 == 0) break;
                    n10 = 3;
                    break block18;
                }
                case 3006244: {
                    string4 = CODEC_ID_AVC2;
                    n10 = (int)(string3.equals(string4) ? 1 : 0);
                    if (n10 == 0) break;
                    n10 = 2;
                    break block18;
                }
                case 3006243: {
                    string4 = CODEC_ID_AVC1;
                    n10 = (int)(string3.equals(string4) ? 1 : 0);
                    if (n10 == 0) break;
                    n10 = 1;
                    break block18;
                }
                case 3004662: {
                    String string5 = CODEC_ID_AV01;
                    boolean bl2 = string3.equals(string5);
                    if (bl2) break block18;
                }
            }
            n10 = n11;
        }
        switch (n10) {
            default: {
                return null;
            }
            case 6: {
                return MediaCodecUtil.getVp9ProfileAndLevel(object.codecs, stringArray);
            }
            case 5: {
                return MediaCodecUtil.getAacCodecProfileAndLevel(object.codecs, stringArray);
            }
            case 3: 
            case 4: {
                return MediaCodecUtil.getHevcProfileAndLevel(object.codecs, stringArray);
            }
            case 1: 
            case 2: {
                return MediaCodecUtil.getAvcProfileAndLevel(object.codecs, stringArray);
            }
            case 0: 
        }
        string2 = object.codecs;
        ColorInfo colorInfo = object.colorInfo;
        return MediaCodecUtil.getAv1ProfileAndLevel(string2, stringArray, colorInfo);
    }

    public static MediaCodecInfo getDecoderInfo(String object, boolean bl2, boolean bl3) {
        if (bl2 = (object = MediaCodecUtil.getDecoderInfos((String)object, bl2, bl3)).isEmpty()) {
            object = null;
        } else {
            bl2 = false;
            object = (MediaCodecInfo)object.get(0);
        }
        return object;
    }

    public static List getDecoderInfos(String object, boolean n10, boolean bl2) {
        Class<MediaCodecUtil> clazz = MediaCodecUtil.class;
        synchronized (clazz) {
            ArrayList arrayList;
            HashMap hashMap;
            MediaCodecUtil$CodecKey mediaCodecUtil$CodecKey;
            block35: {
                MediaCodecUtil$MediaCodecListCompat mediaCodecUtil$MediaCodecListCompat;
                int n11;
                String string2;
                int n12;
                int n13;
                Object object2;
                block34: {
                    block33: {
                        block32: {
                            mediaCodecUtil$CodecKey = new MediaCodecUtil$CodecKey((String)object, n10 != 0, bl2);
                            hashMap = decoderInfosCache;
                            object2 = hashMap.get(mediaCodecUtil$CodecKey);
                            object2 = (List)object2;
                            if (object2 == null) break block32;
                            return object2;
                        }
                        n13 = Util.SDK_INT;
                        n12 = 0;
                        string2 = null;
                        n11 = 21;
                        if (n13 < n11) break block33;
                        mediaCodecUtil$MediaCodecListCompat = new MediaCodecUtil$MediaCodecListCompatV21(n10 != 0, bl2);
                        break block34;
                    }
                    mediaCodecUtil$MediaCodecListCompat = new MediaCodecUtil$MediaCodecListCompatV16(null);
                }
                arrayList = MediaCodecUtil.getDecoderInfosInternal(mediaCodecUtil$CodecKey, mediaCodecUtil$MediaCodecListCompat);
                if (n10 == 0) break block35;
                n10 = arrayList.isEmpty();
                if (n10 == 0 || n11 > n13 || n13 > (n10 = 23)) break block35;
                Object object3 = new MediaCodecUtil$MediaCodecListCompatV16(null);
                arrayList = MediaCodecUtil.getDecoderInfosInternal(mediaCodecUtil$CodecKey, (MediaCodecUtil$MediaCodecListCompat)object3);
                n10 = (int)(arrayList.isEmpty() ? 1 : 0);
                if (n10 != 0) break block35;
                object3 = TAG;
                n13 = 0;
                object2 = null;
                object2 = arrayList.get(0);
                object2 = (MediaCodecInfo)object2;
                object2 = ((MediaCodecInfo)object2).name;
                string2 = String.valueOf(object);
                n12 = string2.length() + 63;
                CharSequence charSequence = String.valueOf(object2);
                n11 = ((String)charSequence).length();
                n12 += n11;
                charSequence = new StringBuilder(n12);
                string2 = "MediaCodecList API didn't list secure decoder for: ";
                ((StringBuilder)charSequence).append(string2);
                ((StringBuilder)charSequence).append((String)object);
                string2 = ". Assuming: ";
                ((StringBuilder)charSequence).append(string2);
                ((StringBuilder)charSequence).append((String)object2);
                object2 = ((StringBuilder)charSequence).toString();
                Log.w((String)object3, object2);
            }
            MediaCodecUtil.applyWorkarounds((String)object, arrayList);
            object = Collections.unmodifiableList(arrayList);
            hashMap.put(mediaCodecUtil$CodecKey, object);
            return object;
        }
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static ArrayList getDecoderInfosInternal(MediaCodecUtil$CodecKey var0, MediaCodecUtil$MediaCodecListCompat var1_1) {
        block11: {
            block12: {
                block10: {
                    block9: {
                        var2_2 = var0;
                        var3_3 = var1_1;
                        var4_4 = "secure-playback";
                        var5_5 = "tunneled-playback";
                        try {
                            var6_6 = new ArrayList<Object>();
                            var7_7 = var0.mimeType;
                            var8_8 = var1_1.getCodecCount();
                            var9_9 = var1_1.secureDecodersExplicit();
                            var10_10 = false;
                            var11_11 = null;
                            var12_15 = false;
lbl13:
                            // 2 sources

                            while (var12_15 < var8_8) {
                                var11_11 = var3_3.getCodecInfoAt((int)var12_15);
                                var13_16 = MediaCodecUtil.isAlias((android.media.MediaCodecInfo)var11_11);
                                if (var13_16 == 0 && (var13_16 = MediaCodecUtil.isCodecUsableDecoder((android.media.MediaCodecInfo)var11_11, var17_20 = var11_11.getName(), var9_9, var7_7)) != 0 && (var18_21 = MediaCodecUtil.getCodecMimeType((android.media.MediaCodecInfo)var11_11, var17_20, var7_7)) != null) break block9;
                                break block10;
                            }
                            return var6_6;
                        }
                        catch (Exception var11_14) {
                            var2_2 = new MediaCodecUtil$DecoderQueryException(var11_14, null);
                            throw var2_2;
                        }
                    }
                    try {
                        var19_22 = var11_11.getCapabilitiesForType(var18_21);
                        var13_16 = var3_3.isFeatureSupported(var5_5, var18_21, var19_22);
                        var20_23 = var3_3.isFeatureRequired(var5_5, var18_21, var19_22);
                        var21_24 = var2_2.tunneling;
                        if (!var21_24 && var20_23 != 0 || var21_24 && var13_16 == 0) break block10;
                        var13_16 = (int)var3_3.isFeatureSupported(var4_4, var18_21, var19_22);
                        var20_23 = (int)var3_3.isFeatureRequired(var4_4, var18_21, var19_22);
                        var21_24 = var2_2.secure;
                        if (!var21_24 && var20_23 != 0 || var21_24 && var13_16 == 0) break block10;
                        var22_25 = MediaCodecUtil.isHardwareAccelerated((android.media.MediaCodecInfo)var11_11);
                        var23_26 = MediaCodecUtil.isSoftwareOnly((android.media.MediaCodecInfo)var11_11);
                        var10_10 = MediaCodecUtil.isVendor((android.media.MediaCodecInfo)var11_11);
                        if ((!var9_9 || (var20_23 = (int)var2_2.secure) != var13_16) && (var9_9 || (var20_23 = (int)var2_2.secure) != 0)) break block11;
                        var24_27 = var17_20;
                        var25_28 = var7_7;
                        var26_29 = var18_21;
                        var27_30 = var18_21;
                        var28_31 = var17_20;
                        var14_17 = var12_15;
                        var12_15 = var10_10;
                        var15_18 = var9_9;
                        var9_9 = false;
                        var16_19 = var8_8;
                        var8_8 = false;
                        break block12;
                    }
                    catch (Exception var11_13) {
                        var27_30 = var18_21;
                        var28_31 = var17_20;
                        var14_17 = var12_15;
                        var15_18 = var9_9;
                        var16_19 = var8_8;
                        ** GOTO lbl-1000
                    }
                }
                var14_17 = var12_15;
                var15_18 = var9_9;
                var16_19 = var8_8;
                ** GOTO lbl107
            }
            try {
                var11_11 = MediaCodecInfo.newInstance(var17_20, var7_7, var18_21, var19_22, var22_25, var23_26, var10_10, false, false);
                var6_6.add(var11_11);
                ** GOTO lbl107
            }
            catch (Exception var11_12) {
                ** GOTO lbl-1000
            }
        }
        var27_30 = var18_21;
        var28_31 = var17_20;
        var14_17 = var12_15;
        var15_18 = var9_9;
        var16_19 = var8_8;
        if (!var9_9 && var13_16 != 0) {
            var24_27 = String.valueOf(var17_20);
            var25_28 = ".secure";
            var24_27 = var24_27.concat(var25_28);
            var9_9 = false;
            var8_8 = true;
            var25_28 = var7_7;
            var26_29 = var18_21;
            var12_15 = var10_10;
            var11_11 = MediaCodecInfo.newInstance((String)var24_27, var7_7, var18_21, var19_22, var22_25, var23_26, var10_10, false, var8_8);
            var6_6.add(var11_11);
            return var6_6;
        }
        ** GOTO lbl107
lbl-1000:
        // 2 sources

        {
            block13: {
                var13_16 = Util.SDK_INT;
                var20_23 = 23;
                var26_29 = "MediaCodecUtil";
                if (var13_16 > var20_23 || (var13_16 = (int)var6_6.isEmpty()) != 0) break block13;
                var11_11 = String.valueOf(var28_31);
                var10_10 = var11_11.length() + 46;
                var24_27 = new StringBuilder((int)var10_10);
                var11_11 = "Skipping codec ";
                var24_27.append((String)var11_11);
                var25_28 = var28_31;
                var24_27.append(var28_31);
                var11_11 = " (failed to query capabilities)";
                var24_27.append((String)var11_11);
                var11_11 = var24_27.toString();
                Log.e(var26_29, (String)var11_11);
lbl107:
                // 4 sources

                var12_15 = var14_17 + 1;
                var8_8 = var16_19;
                var9_9 = var15_18;
                ** GOTO lbl13
            }
            var25_28 = var28_31;
            var2_2 = String.valueOf(var28_31);
            var29_32 = var2_2.length() + 25;
            var3_3 = String.valueOf(var27_30);
            var30_33 = var3_3.length();
            var3_3 = new StringBuilder(var29_32 += var30_33);
            var2_2 = "Failed to query codec ";
            var3_3.append((String)var2_2);
            var3_3.append(var28_31);
            var2_2 = " (";
            var3_3.append((String)var2_2);
            var2_2 = var27_30;
            var3_3.append(var27_30);
            var2_2 = ")";
            var3_3.append((String)var2_2);
            var2_2 = var3_3.toString();
            Log.e(var26_29, (String)var2_2);
            throw var11_11;
        }
    }

    public static List getDecoderInfosSortedByFormatSupport(List object, Format format) {
        ArrayList arrayList = new ArrayList(object);
        object = new g(format);
        MediaCodecUtil.sortByScore(arrayList, (MediaCodecUtil$ScoreProvider)object);
        return arrayList;
    }

    public static MediaCodecInfo getDecryptOnlyDecoderInfo() {
        return MediaCodecUtil.getDecoderInfo("audio/raw", false, false);
    }

    private static Pair getDolbyVisionProfileAndLevel(String string2, String[] object) {
        int n10 = ((String[])object).length;
        String string3 = "Ignoring malformed Dolby Vision codec string: ";
        String string4 = TAG;
        int n11 = 3;
        if (n10 < n11) {
            int n12 = (string2 = String.valueOf(string2)).length();
            string2 = n12 != 0 ? string3.concat(string2) : new String(string3);
            Log.w(string4, string2);
            return null;
        }
        Object object2 = PROFILE_PATTERN;
        n11 = 1;
        String string5 = object[n11];
        boolean bl2 = ((Matcher)(object2 = ((Pattern)object2).matcher(string5))).matches();
        if (!bl2) {
            int n13 = (string2 = String.valueOf(string2)).length();
            string2 = n13 != 0 ? string3.concat(string2) : new String(string3);
            Log.w(string4, string2);
            return null;
        }
        string2 = ((Matcher)object2).group(n11);
        if ((object2 = MediaCodecUtil.dolbyVisionStringToProfile(string2)) == null) {
            object = "Unknown Dolby Vision profile string: ";
            n10 = (string2 = String.valueOf(string2)).length();
            string2 = n10 != 0 ? ((String)object).concat(string2) : new String((String)object);
            Log.w(string4, string2);
            return null;
        }
        int n14 = 2;
        string2 = object[n14];
        if ((object = MediaCodecUtil.dolbyVisionStringToLevel(string2)) == null) {
            object = "Unknown Dolby Vision level string: ";
            n10 = (string2 = String.valueOf(string2)).length();
            string2 = n10 != 0 ? ((String)object).concat(string2) : new String((String)object);
            Log.w(string4, string2);
            return null;
        }
        string2 = new Pair(object2, object);
        return string2;
    }

    private static Pair getHevcProfileAndLevel(String string2, String[] object) {
        String string3;
        int n10;
        block7: {
            int n11;
            Object object2;
            int n12;
            block6: {
                n10 = ((String[])object).length;
                String string4 = "Ignoring malformed HEVC codec string: ";
                string3 = TAG;
                n12 = 4;
                if (n10 < n12) {
                    int n13 = (string2 = String.valueOf(string2)).length();
                    string2 = n13 != 0 ? string4.concat(string2) : new String(string4);
                    Log.w(string3, string2);
                    return null;
                }
                object2 = PROFILE_PATTERN;
                n12 = 1;
                String string5 = object[n12];
                boolean bl2 = ((Matcher)(object2 = ((Pattern)object2).matcher(string5))).matches();
                if (!bl2) {
                    int n14 = (string2 = String.valueOf(string2)).length();
                    string2 = n14 != 0 ? string4.concat(string2) : new String(string4);
                    Log.w(string3, string2);
                    return null;
                }
                object2 = "1";
                string2 = ((Matcher)object2).group(n12);
                n10 = (int)(((String)object2).equals(string2) ? 1 : 0);
                if (n10 != 0) break block6;
                object2 = "2";
                n10 = (int)(((String)object2).equals(string2) ? 1 : 0);
                if (n10 == 0) break block7;
                n12 = 2;
            }
            if ((object = MediaCodecUtil.hevcCodecStringToProfileLevel(string2 = object[n11 = 3])) == null) {
                object = "Unknown HEVC level string: ";
                n10 = (string2 = String.valueOf(string2)).length();
                string2 = n10 != 0 ? ((String)object).concat(string2) : new String((String)object);
                Log.w(string3, string2);
                return null;
            }
            object2 = n12;
            string2 = new Pair(object2, object);
            return string2;
        }
        object = "Unknown HEVC profile string: ";
        n10 = (string2 = String.valueOf(string2)).length();
        string2 = n10 != 0 ? ((String)object).concat(string2) : new String((String)object);
        Log.w(string3, string2);
        return null;
    }

    private static Pair getVp9ProfileAndLevel(String string2, String[] object) {
        Object object2;
        int n10 = ((String[])object).length;
        String string3 = "Ignoring malformed VP9 codec string: ";
        String string4 = TAG;
        int n11 = 3;
        if (n10 < n11) {
            int n12 = (string2 = String.valueOf(string2)).length();
            string2 = n12 != 0 ? string3.concat(string2) : new String(string3);
            Log.w(string4, string2);
            return null;
        }
        n10 = 1;
        try {
            object2 = object[n10];
        }
        catch (NumberFormatException numberFormatException) {
            string2 = String.valueOf(string2);
            int n13 = string2.length();
            string2 = n13 != 0 ? string3.concat(string2) : new String(string3);
            Log.w(string4, string2);
            return null;
        }
        n10 = Integer.parseInt((String)object2);
        n11 = 2;
        object = object[n11];
        int n14 = Integer.parseInt((String)object);
        int n15 = MediaCodecUtil.vp9ProfileNumberToConst(n10);
        int n16 = -1;
        if (n15 == n16) {
            object = new StringBuilder(32);
            ((StringBuilder)object).append("Unknown VP9 profile: ");
            ((StringBuilder)object).append(n10);
            string2 = ((StringBuilder)object).toString();
            Log.w(string4, string2);
            return null;
        }
        n10 = MediaCodecUtil.vp9LevelNumberToConst(n14);
        if (n10 == n16) {
            object2 = new StringBuilder(30);
            ((StringBuilder)object2).append("Unknown VP9 level: ");
            ((StringBuilder)object2).append(n14);
            string2 = ((StringBuilder)object2).toString();
            Log.w(string4, string2);
            return null;
        }
        object = n15;
        object2 = n10;
        string2 = new Pair(object, object2);
        return string2;
    }

    private static Integer hevcCodecStringToProfileLevel(String string2) {
        if (string2 == null) {
            return null;
        }
        string2.hashCode();
        int n10 = -1;
        int n11 = string2.hashCode();
        int n12 = 16;
        int n13 = 8;
        int n14 = 4;
        int n15 = 2;
        int n16 = 1;
        switch (n11) {
            default: {
                break;
            }
            case 2312995: {
                String string3 = "L186";
                boolean bl2 = string2.equals(string3);
                if (!bl2) break;
                n10 = 25;
                break;
            }
            case 2312992: {
                String string4 = "L183";
                boolean bl3 = string2.equals(string4);
                if (!bl3) break;
                n10 = 24;
                break;
            }
            case 2312989: {
                String string5 = "L180";
                boolean bl4 = string2.equals(string5);
                if (!bl4) break;
                n10 = 23;
                break;
            }
            case 2312902: {
                String string6 = "L156";
                boolean bl5 = string2.equals(string6);
                if (!bl5) break;
                n10 = 22;
                break;
            }
            case 2312899: {
                String string7 = "L153";
                boolean bl6 = string2.equals(string7);
                if (!bl6) break;
                n10 = 21;
                break;
            }
            case 2312896: {
                String string8 = "L150";
                boolean bl7 = string2.equals(string8);
                if (!bl7) break;
                n10 = 20;
                break;
            }
            case 2312806: {
                String string9 = "L123";
                boolean bl8 = string2.equals(string9);
                if (!bl8) break;
                n10 = 19;
                break;
            }
            case 2312803: {
                String string10 = "L120";
                boolean bl9 = string2.equals(string10);
                if (!bl9) break;
                n10 = 18;
                break;
            }
            case 2193831: {
                String string11 = "H186";
                boolean bl10 = string2.equals(string11);
                if (!bl10) break;
                n10 = 17;
                break;
            }
            case 2193828: {
                String string12 = "H183";
                boolean bl11 = string2.equals(string12);
                if (!bl11) break;
                n10 = n12;
                break;
            }
            case 2193825: {
                String string13 = "H180";
                boolean bl12 = string2.equals(string13);
                if (!bl12) break;
                n10 = 15;
                break;
            }
            case 2193738: {
                String string14 = "H156";
                boolean bl13 = string2.equals(string14);
                if (!bl13) break;
                n10 = 14;
                break;
            }
            case 2193735: {
                String string15 = "H153";
                boolean bl14 = string2.equals(string15);
                if (!bl14) break;
                n10 = 13;
                break;
            }
            case 2193732: {
                String string16 = "H150";
                boolean bl15 = string2.equals(string16);
                if (!bl15) break;
                n10 = 12;
                break;
            }
            case 2193642: {
                String string17 = "H123";
                boolean bl16 = string2.equals(string17);
                if (!bl16) break;
                n10 = 11;
                break;
            }
            case 2193639: {
                String string18 = "H120";
                boolean bl17 = string2.equals(string18);
                if (!bl17) break;
                n10 = 10;
                break;
            }
            case 74854: {
                String string19 = "L93";
                boolean bl18 = string2.equals(string19);
                if (!bl18) break;
                n10 = 9;
                break;
            }
            case 74851: {
                String string20 = "L90";
                boolean bl19 = string2.equals(string20);
                if (!bl19) break;
                n10 = n13;
                break;
            }
            case 74761: {
                String string21 = "L63";
                boolean bl20 = string2.equals(string21);
                if (!bl20) break;
                n10 = 7;
                break;
            }
            case 74758: {
                String string22 = "L60";
                boolean bl21 = string2.equals(string22);
                if (!bl21) break;
                n10 = 6;
                break;
            }
            case 74665: {
                String string23 = "L30";
                boolean bl22 = string2.equals(string23);
                if (!bl22) break;
                n10 = 5;
                break;
            }
            case 71010: {
                String string24 = "H93";
                boolean bl23 = string2.equals(string24);
                if (!bl23) break;
                n10 = n14;
                break;
            }
            case 71007: {
                String string25 = "H90";
                boolean bl24 = string2.equals(string25);
                if (!bl24) break;
                n10 = 3;
                break;
            }
            case 70917: {
                String string26 = "H63";
                boolean bl25 = string2.equals(string26);
                if (!bl25) break;
                n10 = n15;
                break;
            }
            case 70914: {
                String string27 = "H60";
                boolean bl26 = string2.equals(string27);
                if (!bl26) break;
                n10 = n16;
                break;
            }
            case 70821: {
                String string28 = "H30";
                boolean bl27 = string2.equals(string28);
                if (!bl27) break;
                n10 = 0;
            }
        }
        switch (n10) {
            default: {
                return null;
            }
            case 25: {
                return 0x1000000;
            }
            case 24: {
                return 0x400000;
            }
            case 23: {
                return 0x100000;
            }
            case 22: {
                return 262144;
            }
            case 21: {
                return 65536;
            }
            case 20: {
                return 16384;
            }
            case 19: {
                return 4096;
            }
            case 18: {
                return 1024;
            }
            case 17: {
                return 0x2000000;
            }
            case 16: {
                return 0x800000;
            }
            case 15: {
                return 0x200000;
            }
            case 14: {
                return 524288;
            }
            case 13: {
                return 131072;
            }
            case 12: {
                return 32768;
            }
            case 11: {
                return 8192;
            }
            case 10: {
                return 2048;
            }
            case 9: {
                return 256;
            }
            case 8: {
                return 64;
            }
            case 7: {
                return n12;
            }
            case 6: {
                return n14;
            }
            case 5: {
                return n16;
            }
            case 4: {
                return 512;
            }
            case 3: {
                return 128;
            }
            case 2: {
                return 32;
            }
            case 1: {
                return n13;
            }
            case 0: 
        }
        return n15;
    }

    private static boolean isAlias(android.media.MediaCodecInfo mediaCodecInfo) {
        boolean bl2;
        int n10 = Util.SDK_INT;
        int n11 = 29;
        if (n10 >= n11 && (bl2 = MediaCodecUtil.isAliasV29(mediaCodecInfo))) {
            bl2 = true;
        } else {
            bl2 = false;
            mediaCodecInfo = null;
        }
        return bl2;
    }

    private static boolean isAliasV29(android.media.MediaCodecInfo mediaCodecInfo) {
        return mediaCodecInfo.isAlias();
    }

    private static boolean isCodecUsableDecoder(android.media.MediaCodecInfo object, String string2, boolean n10, String string3) {
        int n11 = object.isEncoder();
        if (n11 == 0 && (n10 != 0 || (n11 = (int)(string2.endsWith((String)(object = ".secure")) ? 1 : 0)) == 0)) {
            String string4;
            boolean bl2;
            int n12;
            String string5;
            String string6;
            boolean bl3;
            String string7;
            n11 = Util.SDK_INT;
            n10 = 21;
            if (n11 < n10 && ((n10 = (int)((string7 = "CIPAACDecoder").equals(string2) ? 1 : 0)) != 0 || (n10 = (int)((string7 = "CIPMP3Decoder").equals(string2) ? 1 : 0)) != 0 || (n10 = (int)((string7 = "CIPVorbisDecoder").equals(string2) ? 1 : 0)) != 0 || (n10 = (int)((string7 = "CIPAMRNBDecoder").equals(string2) ? 1 : 0)) != 0 || (n10 = (int)((string7 = "AACDecoder").equals(string2) ? 1 : 0)) != 0 || (n10 = (int)((string7 = "MP3Decoder").equals(string2) ? 1 : 0)) != 0)) {
                return false;
            }
            n10 = 18;
            if (n11 < n10 && (n10 = (int)((string7 = "OMX.MTK.AUDIO.DECODER.AAC").equals(string2) ? 1 : 0)) != 0 && ((bl3 = (string6 = "a70").equals(string7 = Util.DEVICE)) || (bl3 = (string5 = "Xiaomi").equals(string6 = Util.MANUFACTURER)) && (n10 = (int)(string7.startsWith(string6 = "HM") ? 1 : 0)) != 0)) {
                return false;
            }
            n10 = 16;
            if (n11 == n10 && (bl3 = (string6 = "OMX.qcom.audio.decoder.mp3").equals(string2)) && ((n12 = (int)((string5 = "dlxu").equals(string6 = Util.DEVICE) ? 1 : 0)) != 0 || (n12 = (int)((string5 = "protou").equals(string6) ? 1 : 0)) != 0 || (n12 = (int)((string5 = "ville").equals(string6) ? 1 : 0)) != 0 || (n12 = (int)((string5 = "villeplus").equals(string6) ? 1 : 0)) != 0 || (n12 = (int)((string5 = "villec2").equals(string6) ? 1 : 0)) != 0 || (n12 = (int)(string6.startsWith(string5 = "gee") ? 1 : 0)) != 0 || (n12 = (int)((string5 = "C6602").equals(string6) ? 1 : 0)) != 0 || (n12 = (int)((string5 = "C6603").equals(string6) ? 1 : 0)) != 0 || (n12 = (int)((string5 = "C6606").equals(string6) ? 1 : 0)) != 0 || (n12 = (int)((string5 = "C6616").equals(string6) ? 1 : 0)) != 0 || (n12 = (int)((string5 = "L36h").equals(string6) ? 1 : 0)) != 0 || (bl3 = (string5 = "SO-02E").equals(string6)))) {
                return false;
            }
            if (n11 == n10 && (n10 = (int)((string7 = "OMX.qcom.audio.decoder.aac").equals(string2) ? 1 : 0)) != 0 && ((bl3 = (string6 = "C1504").equals(string7 = Util.DEVICE)) || (bl3 = (string6 = "C1505").equals(string7)) || (bl3 = (string6 = "C1604").equals(string7)) || (n10 = (int)((string6 = "C1605").equals(string7) ? 1 : 0)) != 0)) {
                return false;
            }
            n10 = 24;
            string6 = "samsung";
            if (!(n11 >= n10 || (n10 = (int)((string7 = "OMX.SEC.aac.dec").equals(string2) ? 1 : 0)) == 0 && (n10 = (int)((string7 = "OMX.Exynos.AAC.Decoder").equals(string2) ? 1 : 0)) == 0 || (n10 = (int)(string6.equals(string7 = Util.MANUFACTURER) ? 1 : 0)) == 0 || (n12 = (int)((string7 = Util.DEVICE).startsWith(string5 = "zeroflte") ? 1 : 0)) == 0 && (n12 = (int)(string7.startsWith(string5 = "zerolte") ? 1 : 0)) == 0 && (n12 = (int)(string7.startsWith(string5 = "zenlte") ? 1 : 0)) == 0 && (n12 = (int)((string5 = "SC-05G").equals(string7) ? 1 : 0)) == 0 && (n12 = (int)((string5 = "marinelteatt").equals(string7) ? 1 : 0)) == 0 && (n12 = (int)((string5 = "404SC").equals(string7) ? 1 : 0)) == 0 && (n12 = (int)((string5 = "SC-04G").equals(string7) ? 1 : 0)) == 0 && (n10 = (int)((string5 = "SCV31").equals(string7) ? 1 : 0)) == 0)) {
                return false;
            }
            string7 = "jflte";
            n12 = 19;
            if (n11 <= n12 && (bl2 = (string4 = "OMX.SEC.vp8.dec").equals(string2)) && (bl3 = string6.equals(string4 = Util.MANUFACTURER)) && ((bl2 = (string6 = Util.DEVICE).startsWith(string4 = "d2")) || (bl2 = string6.startsWith(string4 = "serrano")) || (bl2 = string6.startsWith(string7)) || (bl2 = string6.startsWith(string4 = "santos")) || (bl3 = string6.startsWith(string4 = "t0")))) {
                return false;
            }
            if (n11 <= n12 && (n11 = (int)(((String)(object = Util.DEVICE)).startsWith(string7) ? 1 : 0)) != 0 && (n11 = (int)(((String)(object = "OMX.qcom.video.decoder.vp8")).equals(string2) ? 1 : 0)) != 0) {
                return false;
            }
            object = "audio/eac3-joc";
            n11 = (int)(((String)object).equals(string3) ? 1 : 0);
            return n11 == 0 || (n11 = (int)(((String)(object = "OMX.MTK.AUDIO.DECODER.DSPAC3")).equals(string2) ? 1 : 0)) == 0;
        }
        return false;
    }

    private static boolean isHardwareAccelerated(android.media.MediaCodecInfo mediaCodecInfo) {
        int n10 = Util.SDK_INT;
        int n11 = 29;
        if (n10 >= n11) {
            return MediaCodecUtil.isHardwareAcceleratedV29(mediaCodecInfo);
        }
        return MediaCodecUtil.isSoftwareOnly(mediaCodecInfo) ^ true;
    }

    private static boolean isHardwareAcceleratedV29(android.media.MediaCodecInfo mediaCodecInfo) {
        return mediaCodecInfo.isHardwareAccelerated();
    }

    private static boolean isSoftwareOnly(android.media.MediaCodecInfo object) {
        boolean bl2;
        int n10 = Util.SDK_INT;
        int n11 = 29;
        if (n10 >= n11) {
            return MediaCodecUtil.isSoftwareOnlyV29((android.media.MediaCodecInfo)object);
        }
        object = Util.toLowerInvariant(object.getName());
        String string2 = "arc.";
        n10 = (int)(((String)object).startsWith(string2) ? 1 : 0);
        n11 = 0;
        if (n10) {
            return false;
        }
        string2 = "omx.google.";
        n10 = (int)(((String)object).startsWith(string2) ? 1 : 0);
        if (n10 || (n10 = ((String)object).startsWith(string2 = "omx.ffmpeg.")) || (n10 = ((String)object).startsWith(string2 = "omx.sec.")) && (n10 = ((String)object).contains(string2 = ".sw.")) || (n10 = ((String)object).equals(string2 = "omx.qcom.video.decoder.hevcswvdec")) || (n10 = ((String)object).startsWith(string2 = "c2.android.")) || (n10 = ((String)object).startsWith(string2 = "c2.google.")) || !(n10 = ((String)object).startsWith(string2 = "omx.")) && !(bl2 = ((String)object).startsWith(string2 = "c2."))) {
            n11 = 1;
        }
        return n11 != 0;
    }

    private static boolean isSoftwareOnlyV29(android.media.MediaCodecInfo mediaCodecInfo) {
        return mediaCodecInfo.isSoftwareOnly();
    }

    private static boolean isVendor(android.media.MediaCodecInfo object) {
        boolean bl2;
        String string2;
        int n10 = Util.SDK_INT;
        int n11 = 29;
        if (n10 >= n11) {
            return MediaCodecUtil.isVendorV29((android.media.MediaCodecInfo)object);
        }
        n10 = (int)(((String)(object = Util.toLowerInvariant(object.getName()))).startsWith(string2 = "omx.google.") ? 1 : 0);
        if (n10 == 0 && (n10 = (int)(((String)object).startsWith(string2 = "c2.android.") ? 1 : 0)) == 0 && !(bl2 = ((String)object).startsWith(string2 = "c2.google."))) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    private static boolean isVendorV29(android.media.MediaCodecInfo mediaCodecInfo) {
        return mediaCodecInfo.isVendor();
    }

    public static int maxH264DecodableFrameSize() {
        int n10 = maxH264DecodableFrameSize;
        int n11 = -1;
        if (n10 == n11) {
            MediaCodecInfo.CodecProfileLevel[] codecProfileLevelArray = MediaCodecUtil.getDecoderInfo("video/avc", false, false);
            if (codecProfileLevelArray != null) {
                codecProfileLevelArray = codecProfileLevelArray.getProfileLevels();
                int n12 = codecProfileLevelArray.length;
                int n13 = 0;
                for (n11 = 0; n11 < n12; ++n11) {
                    MediaCodecInfo.CodecProfileLevel codecProfileLevel = codecProfileLevelArray[n11];
                    int n14 = MediaCodecUtil.avcLevelToMaxFrameSize(codecProfileLevel.level);
                    n13 = Math.max(n14, n13);
                }
                n10 = Util.SDK_INT;
                n11 = 21;
                n10 = n10 >= n11 ? 345600 : 172800;
                n11 = Math.max(n13, n10);
            }
            maxH264DecodableFrameSize = n11;
        }
        return maxH264DecodableFrameSize;
    }

    private static int mp4aAudioObjectTypeToProfile(int n10) {
        int n11 = 17;
        if (n10 != n11 && n10 != (n11 = 20) && n10 != (n11 = 23) && n10 != (n11 = 29) && n10 != (n11 = 39) && n10 != (n11 = 42)) {
            switch (n10) {
                default: {
                    return -1;
                }
                case 6: {
                    return 6;
                }
                case 5: {
                    return 5;
                }
                case 4: {
                    return 4;
                }
                case 3: {
                    return 3;
                }
                case 2: {
                    return 2;
                }
                case 1: 
            }
            return 1;
        }
        return n11;
    }

    private static void sortByScore(List list, MediaCodecUtil$ScoreProvider mediaCodecUtil$ScoreProvider) {
        h h10 = new h(mediaCodecUtil$ScoreProvider);
        Collections.sort(list, h10);
    }

    private static int vp9LevelNumberToConst(int n10) {
        int n11 = 10;
        if (n10 != n11) {
            n11 = 11;
            if (n10 != n11) {
                n11 = 20;
                if (n10 != n11) {
                    n11 = 21;
                    if (n10 != n11) {
                        n11 = 30;
                        if (n10 != n11) {
                            n11 = 31;
                            if (n10 != n11) {
                                n11 = 40;
                                if (n10 != n11) {
                                    n11 = 41;
                                    if (n10 != n11) {
                                        n11 = 50;
                                        if (n10 != n11) {
                                            n11 = 51;
                                            if (n10 != n11) {
                                                switch (n10) {
                                                    default: {
                                                        return -1;
                                                    }
                                                    case 62: {
                                                        return 8192;
                                                    }
                                                    case 61: {
                                                        return 4096;
                                                    }
                                                    case 60: 
                                                }
                                                return 2048;
                                            }
                                            return 512;
                                        }
                                        return 256;
                                    }
                                    return 128;
                                }
                                return 64;
                            }
                            return 32;
                        }
                        return 16;
                    }
                    return 8;
                }
                return 4;
            }
            return 2;
        }
        return 1;
    }

    private static int vp9ProfileNumberToConst(int n10) {
        int n11 = 1;
        if (n10 != 0) {
            int n12 = 2;
            if (n10 != n11) {
                if (n10 != n12) {
                    n11 = 3;
                    if (n10 != n11) {
                        return -1;
                    }
                    return 8;
                }
                return 4;
            }
            return n12;
        }
        return n11;
    }

    public static void warmDecoderInfoCache(String string2, boolean bl2, boolean bl3) {
        try {
            MediaCodecUtil.getDecoderInfos(string2, bl2, bl3);
        }
        catch (MediaCodecUtil$DecoderQueryException mediaCodecUtil$DecoderQueryException) {
            String string3 = TAG;
            String string4 = "Codec warming failed";
            Log.e(string3, string4, mediaCodecUtil$DecoderQueryException);
        }
    }
}

