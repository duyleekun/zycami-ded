/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.media.MediaCodecInfo
 *  android.media.MediaCodecInfo$CodecProfileLevel
 *  android.os.Build$VERSION
 *  android.text.TextUtils
 *  android.util.Log
 */
package com.tencent.ijk.media.player;

import android.media.MediaCodecInfo;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import java.util.Comparator;
import java.util.Locale;
import java.util.Map;

public class IjkMediaCodecInfo {
    public static final int RANK_ACCEPTABLE = 700;
    public static final int RANK_LAST_CHANCE = 600;
    public static final int RANK_MAX = 1000;
    public static final int RANK_NON_STANDARD = 100;
    public static final int RANK_NO_SENSE = 0;
    public static final int RANK_SECURE = 300;
    public static final int RANK_SOFTWARE = 200;
    public static final int RANK_TESTED = 800;
    private static final String TAG = "IjkMediaCodecInfo";
    private static Map sKnownCodecList;
    public MediaCodecInfo mCodecInfo;
    public String mMimeType;
    public int mRank = 0;

    private static Map getKnownCodecList() {
        Class<IjkMediaCodecInfo> clazz = IjkMediaCodecInfo.class;
        synchronized (clazz) {
            Map<Object, Integer> map;
            block74: {
                map = sKnownCodecList;
                if (map == null) break block74;
                return map;
            }
            Object object = String.CASE_INSENSITIVE_ORDER;
            map = new Map<Object, Integer>((Comparator<Object>)object);
            sKnownCodecList = map;
            object = "OMX.Nvidia.h264.decode";
            int n10 = 800;
            Integer n11 = n10;
            map.put(object, n11);
            map = sKnownCodecList;
            object = "OMX.Nvidia.h264.decode.secure";
            int n12 = 300;
            n11 = n12;
            map.put(object, n11);
            map = sKnownCodecList;
            object = "OMX.Intel.hw_vd.h264";
            n12 = 801;
            n11 = n12;
            map.put(object, n11);
            map = sKnownCodecList;
            object = "OMX.Intel.VideoDecoder.AVC";
            n11 = n10;
            map.put(object, n11);
            map = sKnownCodecList;
            object = "OMX.qcom.video.decoder.avc";
            n11 = n10;
            map.put(object, n11);
            map = sKnownCodecList;
            object = "OMX.ittiam.video.decoder.avc";
            n12 = 0;
            n11 = null;
            n11 = 0;
            map.put(object, n11);
            map = sKnownCodecList;
            object = "OMX.SEC.avc.dec";
            n11 = n10;
            map.put(object, n11);
            map = sKnownCodecList;
            object = "OMX.SEC.AVC.Decoder";
            n12 = 799;
            Integer n13 = n12;
            map.put(object, n13);
            map = sKnownCodecList;
            object = "OMX.SEC.avcdec";
            int n14 = 798;
            n13 = n14;
            map.put(object, n13);
            map = sKnownCodecList;
            object = "OMX.SEC.avc.sw.dec";
            n14 = 200;
            Integer n15 = n14;
            map.put(object, n15);
            map = sKnownCodecList;
            object = "OMX.Exynos.avc.dec";
            n15 = n10;
            map.put(object, n15);
            map = sKnownCodecList;
            object = "OMX.Exynos.AVC.Decoder";
            n11 = n12;
            map.put(object, n11);
            map = sKnownCodecList;
            object = "OMX.k3.video.decoder.avc";
            n11 = n10;
            map.put(object, n11);
            map = sKnownCodecList;
            object = "OMX.IMG.MSVDX.Decoder.AVC";
            n11 = n10;
            map.put(object, n11);
            map = sKnownCodecList;
            object = "OMX.TI.DUCATI1.VIDEO.DECODER";
            n11 = n10;
            map.put(object, n11);
            map = sKnownCodecList;
            object = "OMX.rk.video_decoder.avc";
            n11 = n10;
            map.put(object, n11);
            map = sKnownCodecList;
            object = "OMX.amlogic.avc.decoder.awesome";
            n11 = n10;
            map.put(object, n11);
            map = sKnownCodecList;
            object = "OMX.MARVELL.VIDEO.HW.CODA7542DECODER";
            Integer n16 = n10;
            map.put(object, n16);
            map = sKnownCodecList;
            object = "OMX.MARVELL.VIDEO.H264DECODER";
            n16 = n14;
            map.put(object, n16);
            map = sKnownCodecList;
            object = "OMX.Action.Video.Decoder";
            map.remove(object);
            map = sKnownCodecList;
            object = "OMX.allwinner.video.decoder.avc";
            map.remove(object);
            map = sKnownCodecList;
            object = "OMX.BRCM.vc4.decoder.avc";
            map.remove(object);
            map = sKnownCodecList;
            object = "OMX.brcm.video.h264.hw.decoder";
            map.remove(object);
            map = sKnownCodecList;
            object = "OMX.brcm.video.h264.decoder";
            map.remove(object);
            map = sKnownCodecList;
            object = "OMX.cosmo.video.decoder.avc";
            map.remove(object);
            map = sKnownCodecList;
            object = "OMX.duos.h264.decoder";
            map.remove(object);
            map = sKnownCodecList;
            object = "OMX.hantro.81x0.video.decoder";
            map.remove(object);
            map = sKnownCodecList;
            object = "OMX.hantro.G1.video.decoder";
            map.remove(object);
            map = sKnownCodecList;
            object = "OMX.hisi.video.decoder";
            map.remove(object);
            map = sKnownCodecList;
            object = "OMX.LG.decoder.video.avc";
            map.remove(object);
            map = sKnownCodecList;
            object = "OMX.MS.AVC.Decoder";
            map.remove(object);
            map = sKnownCodecList;
            object = "OMX.RENESAS.VIDEO.DECODER.H264";
            map.remove(object);
            map = sKnownCodecList;
            object = "OMX.RTK.video.decoder";
            map.remove(object);
            map = sKnownCodecList;
            object = "OMX.sprd.h264.decoder";
            map.remove(object);
            map = sKnownCodecList;
            object = "OMX.ST.VFM.H264Dec";
            map.remove(object);
            map = sKnownCodecList;
            object = "OMX.vpu.video_decoder.avc";
            map.remove(object);
            map = sKnownCodecList;
            object = "OMX.WMT.decoder.avc";
            map.remove(object);
            map = sKnownCodecList;
            object = "OMX.bluestacks.hw.decoder";
            map.remove(object);
            map = sKnownCodecList;
            object = "OMX.google.h264.decoder";
            n16 = n14;
            map.put(object, n16);
            map = sKnownCodecList;
            object = "OMX.google.h264.lc.decoder";
            n16 = n14;
            map.put(object, n16);
            map = sKnownCodecList;
            object = "OMX.k3.ffmpeg.decoder";
            n16 = n14;
            map.put(object, n16);
            map = sKnownCodecList;
            object = "OMX.ffmpeg.video.decoder";
            n16 = n14;
            map.put(object, n16);
            map = sKnownCodecList;
            object = "OMX.sprd.soft.h264.decoder";
            n16 = n14;
            map.put(object, n16);
            map = sKnownCodecList;
            return map;
        }
    }

    public static String getLevelName(int n10) {
        int n11 = 1;
        if (n10 != n11) {
            n11 = 2;
            if (n10 != n11) {
                switch (n10) {
                    default: {
                        return "0";
                    }
                    case 65536: {
                        return "52";
                    }
                    case 32768: {
                        return "51";
                    }
                    case 16384: {
                        return "5";
                    }
                    case 8192: {
                        return "42";
                    }
                    case 4096: {
                        return "41";
                    }
                    case 2048: {
                        return "4";
                    }
                    case 1024: {
                        return "32";
                    }
                    case 512: {
                        return "31";
                    }
                    case 256: {
                        return "3";
                    }
                    case 128: {
                        return "22";
                    }
                    case 64: {
                        return "21";
                    }
                    case 32: {
                        return "2";
                    }
                    case 16: {
                        return "13";
                    }
                    case 8: {
                        return "12";
                    }
                    case 4: 
                }
                return "11";
            }
            return "1b";
        }
        return "1";
    }

    public static String getProfileLevelName(int n10, int n11) {
        Locale locale = Locale.US;
        Object[] objectArray = new Object[4];
        String string2 = IjkMediaCodecInfo.getProfileName(n10);
        objectArray[0] = string2;
        string2 = IjkMediaCodecInfo.getLevelName(n11);
        objectArray[1] = string2;
        Integer n12 = n10;
        objectArray[2] = n12;
        n12 = n11;
        objectArray[3] = n12;
        return String.format(locale, " %s Profile Level %s (%d,%d)", objectArray);
    }

    public static String getProfileName(int n10) {
        int n11 = 1;
        if (n10 != n11) {
            n11 = 2;
            if (n10 != n11) {
                n11 = 4;
                if (n10 != n11) {
                    n11 = 8;
                    if (n10 != n11) {
                        n11 = 16;
                        if (n10 != n11) {
                            n11 = 32;
                            if (n10 != n11) {
                                n11 = 64;
                                if (n10 != n11) {
                                    return "Unknown";
                                }
                                return "High444";
                            }
                            return "High422";
                        }
                        return "High10";
                    }
                    return "High";
                }
                return "Extends";
            }
            return "Main";
        }
        return "Baseline";
    }

    /*
     * Unable to fully structure code
     */
    public static IjkMediaCodecInfo setupCandidate(MediaCodecInfo var0, String var1_1) {
        block14: {
            var2_2 = 0;
            var3_3 = null;
            if (var0 == null || (var4_4 = Build.VERSION.SDK_INT) < (var5_5 = 16)) ** GOTO lbl51
            var6_6 = var0.getName();
            var7_7 = TextUtils.isEmpty((CharSequence)var6_6);
            if (var7_7 != 0) {
                return null;
            }
            var3_3 = Locale.US;
            var3_3 = var6_6.toLowerCase((Locale)var3_3);
            var6_6 = "omx.";
            var5_5 = (int)var3_3.startsWith(var6_6);
            var7_7 = 600;
            var8_8 = 200;
            if (var5_5 == 0) {
                var7_7 = 100;
            } else {
                var6_6 = "omx.pv";
                var5_5 = (int)var3_3.startsWith(var6_6);
                if (var5_5 != 0) {
                    while (true) {
                        var7_7 = var8_8;
                        break block14;
                        break;
                    }
                }
                if ((var5_5 = (int)var3_3.startsWith(var6_6 = "omx.google.")) != 0 || (var5_5 = (int)var3_3.startsWith(var6_6 = "omx.ffmpeg.")) != 0 || (var5_5 = (int)var3_3.startsWith(var6_6 = "omx.k3.ffmpeg.")) != 0 || (var5_5 = (int)var3_3.startsWith(var6_6 = "omx.avcodec.")) != 0) ** continue;
                var6_6 = "omx.ittiam.";
                var5_5 = (int)var3_3.startsWith(var6_6);
                if (var5_5 != 0) {
                    while (true) {
                        var7_7 = 0;
                        break block14;
                        break;
                    }
                }
                var6_6 = "omx.mtk.";
                var5_5 = (int)var3_3.startsWith(var6_6);
                if (var5_5 != 0) {
                    if (var4_4 < (var2_2 = 18)) ** continue;
                    var7_7 = 800;
                } else {
                    var9_9 = IjkMediaCodecInfo.getKnownCodecList();
                    var3_3 = (Integer)var9_9.get(var3_3);
                    if (var3_3 != null) {
                        var7_7 = var3_3.intValue();
                    } else {
                        var3_3 = var0.getCapabilitiesForType(var1_1);
                        if (var3_3 == null) break block14;
                        var7_7 = var2_2 = 700;
                    }
                }
            }
        }
lbl46:
        // 2 sources

        while (true) {
            var3_3 = new IjkMediaCodecInfo();
            var3_3.mCodecInfo = var0;
            var3_3.mRank = var7_7;
            var3_3.mMimeType = var1_1;
lbl51:
            // 2 sources

            return var3_3;
        }
        catch (Throwable v0) {
            ** continue;
        }
    }

    public void dumpProfileLevels(String object) {
        int n10;
        int n11;
        String string2;
        int n12;
        Object[] objectArray;
        String string3;
        block19: {
            block18: {
                string3 = TAG;
                int n13 = Build.VERSION.SDK_INT;
                int n14 = 16;
                if (n13 < n14) {
                    return;
                }
                MediaCodecInfo mediaCodecInfo = this.mCodecInfo;
                object = mediaCodecInfo.getCapabilitiesForType((String)object);
                n13 = 0;
                mediaCodecInfo = null;
                if (object == null) break block18;
                object = object.profileLevels;
                if (object == null) break block18;
                n14 = ((MediaCodecInfo.CodecProfileLevel[])object).length;
                objectArray = null;
                n12 = 0;
                string2 = null;
                n11 = 0;
                for (n10 = 0; n10 < n14; ++n10) {
                    MediaCodecInfo.CodecProfileLevel codecProfileLevel = object[n10];
                    if (codecProfileLevel == null) continue;
                    int n15 = codecProfileLevel.profile;
                    n12 = Math.max(n12, n15);
                    int n16 = codecProfileLevel.level;
                    n11 = Math.max(n11, n16);
                }
                break block19;
            }
            n12 = 0;
            string2 = null;
            n11 = 0;
        }
        object = Locale.US;
        String string4 = "%s";
        n10 = 1;
        objectArray = new Object[n10];
        string2 = IjkMediaCodecInfo.getProfileLevelName(n12, n11);
        objectArray[0] = string2;
        object = String.format((Locale)object, string4, objectArray);
        try {
            Log.i((String)string3, (String)object);
        }
        catch (Throwable throwable) {
            object = "profile-level: exception";
            Log.i((String)string3, (String)object);
        }
    }
}

