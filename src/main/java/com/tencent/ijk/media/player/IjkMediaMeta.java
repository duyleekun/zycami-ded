/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.text.TextUtils
 */
package com.tencent.ijk.media.player;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.ijk.media.player.IjkBitrateItem;
import com.tencent.ijk.media.player.IjkMediaMeta$IjkStreamMeta;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;

public class IjkMediaMeta {
    public static final long AV_CH_BACK_CENTER = 256L;
    public static final long AV_CH_BACK_LEFT = 16L;
    public static final long AV_CH_BACK_RIGHT = 32L;
    public static final long AV_CH_FRONT_CENTER = 4L;
    public static final long AV_CH_FRONT_LEFT = 1L;
    public static final long AV_CH_FRONT_LEFT_OF_CENTER = 64L;
    public static final long AV_CH_FRONT_RIGHT = 2L;
    public static final long AV_CH_FRONT_RIGHT_OF_CENTER = 128L;
    public static final long AV_CH_LAYOUT_2POINT1 = 11L;
    public static final long AV_CH_LAYOUT_2_1 = 259L;
    public static final long AV_CH_LAYOUT_2_2 = 1539L;
    public static final long AV_CH_LAYOUT_3POINT1 = 15L;
    public static final long AV_CH_LAYOUT_4POINT0 = 263L;
    public static final long AV_CH_LAYOUT_4POINT1 = 271L;
    public static final long AV_CH_LAYOUT_5POINT0 = 1543L;
    public static final long AV_CH_LAYOUT_5POINT0_BACK = 55L;
    public static final long AV_CH_LAYOUT_5POINT1 = 1551L;
    public static final long AV_CH_LAYOUT_5POINT1_BACK = 63L;
    public static final long AV_CH_LAYOUT_6POINT0 = 1799L;
    public static final long AV_CH_LAYOUT_6POINT0_FRONT = 1731L;
    public static final long AV_CH_LAYOUT_6POINT1 = 1807L;
    public static final long AV_CH_LAYOUT_6POINT1_BACK = 319L;
    public static final long AV_CH_LAYOUT_6POINT1_FRONT = 1739L;
    public static final long AV_CH_LAYOUT_7POINT0 = 1591L;
    public static final long AV_CH_LAYOUT_7POINT0_FRONT = 1735L;
    public static final long AV_CH_LAYOUT_7POINT1 = 1599L;
    public static final long AV_CH_LAYOUT_7POINT1_WIDE = 1743L;
    public static final long AV_CH_LAYOUT_7POINT1_WIDE_BACK = 255L;
    public static final long AV_CH_LAYOUT_HEXAGONAL = 311L;
    public static final long AV_CH_LAYOUT_MONO = 4L;
    public static final long AV_CH_LAYOUT_OCTAGONAL = 1847L;
    public static final long AV_CH_LAYOUT_QUAD = 51L;
    public static final long AV_CH_LAYOUT_STEREO = 3L;
    public static final long AV_CH_LAYOUT_STEREO_DOWNMIX = 0x60000000L;
    public static final long AV_CH_LAYOUT_SURROUND = 7L;
    public static final long AV_CH_LOW_FREQUENCY = 8L;
    public static final long AV_CH_LOW_FREQUENCY_2 = 0x800000000L;
    public static final long AV_CH_SIDE_LEFT = 512L;
    public static final long AV_CH_SIDE_RIGHT = 1024L;
    public static final long AV_CH_STEREO_LEFT = 0x20000000L;
    public static final long AV_CH_STEREO_RIGHT = 0x40000000L;
    public static final long AV_CH_SURROUND_DIRECT_LEFT = 0x200000000L;
    public static final long AV_CH_SURROUND_DIRECT_RIGHT = 0x400000000L;
    public static final long AV_CH_TOP_BACK_CENTER = 65536L;
    public static final long AV_CH_TOP_BACK_LEFT = 32768L;
    public static final long AV_CH_TOP_BACK_RIGHT = 131072L;
    public static final long AV_CH_TOP_CENTER = 2048L;
    public static final long AV_CH_TOP_FRONT_CENTER = 8192L;
    public static final long AV_CH_TOP_FRONT_LEFT = 4096L;
    public static final long AV_CH_TOP_FRONT_RIGHT = 16384L;
    public static final long AV_CH_WIDE_LEFT = 0x80000000L;
    public static final long AV_CH_WIDE_RIGHT = 0x100000000L;
    public static final int FF_PROFILE_H264_BASELINE = 66;
    public static final int FF_PROFILE_H264_CAVLC_444 = 44;
    public static final int FF_PROFILE_H264_CONSTRAINED = 512;
    public static final int FF_PROFILE_H264_CONSTRAINED_BASELINE = 578;
    public static final int FF_PROFILE_H264_EXTENDED = 88;
    public static final int FF_PROFILE_H264_HIGH = 100;
    public static final int FF_PROFILE_H264_HIGH_10 = 110;
    public static final int FF_PROFILE_H264_HIGH_10_INTRA = 2158;
    public static final int FF_PROFILE_H264_HIGH_422 = 122;
    public static final int FF_PROFILE_H264_HIGH_422_INTRA = 2170;
    public static final int FF_PROFILE_H264_HIGH_444 = 144;
    public static final int FF_PROFILE_H264_HIGH_444_INTRA = 2292;
    public static final int FF_PROFILE_H264_HIGH_444_PREDICTIVE = 244;
    public static final int FF_PROFILE_H264_INTRA = 2048;
    public static final int FF_PROFILE_H264_MAIN = 77;
    public static final String IJKM_KEY_AUDIO_STREAM = "audio";
    public static final String IJKM_KEY_BITRATE = "bitrate";
    public static final String IJKM_KEY_BITRATE_INDEX = "bitrate_index";
    public static final String IJKM_KEY_CHANNEL_LAYOUT = "channel_layout";
    public static final String IJKM_KEY_CODEC_LEVEL = "codec_level";
    public static final String IJKM_KEY_CODEC_LONG_NAME = "codec_long_name";
    public static final String IJKM_KEY_CODEC_NAME = "codec_name";
    public static final String IJKM_KEY_CODEC_PIXEL_FORMAT = "codec_pixel_format";
    public static final String IJKM_KEY_CODEC_PROFILE = "codec_profile";
    public static final String IJKM_KEY_CODEC_PROFILE_ID = "codec_profile_id";
    public static final String IJKM_KEY_DURATION_US = "duration_us";
    public static final String IJKM_KEY_FORMAT = "format";
    public static final String IJKM_KEY_FPS_DEN = "fps_den";
    public static final String IJKM_KEY_FPS_NUM = "fps_num";
    public static final String IJKM_KEY_HEIGHT = "height";
    public static final String IJKM_KEY_LANGUAGE = "language";
    public static final String IJKM_KEY_M3U8 = "m3u8";
    public static final String IJKM_KEY_PROGRAMS = "programs";
    public static final String IJKM_KEY_SAMPLE_RATE = "sample_rate";
    public static final String IJKM_KEY_SAR_DEN = "sar_den";
    public static final String IJKM_KEY_SAR_NUM = "sar_num";
    public static final String IJKM_KEY_START_US = "start_us";
    public static final String IJKM_KEY_STREAMS = "streams";
    public static final String IJKM_KEY_TBR_DEN = "tbr_den";
    public static final String IJKM_KEY_TBR_NUM = "tbr_num";
    public static final String IJKM_KEY_TIMEDTEXT_STREAM = "timedtext";
    public static final String IJKM_KEY_TYPE = "type";
    public static final String IJKM_KEY_VIDEO_STREAM = "video";
    public static final String IJKM_KEY_WIDTH = "width";
    public static final String IJKM_VAL_TYPE__AUDIO = "audio";
    public static final String IJKM_VAL_TYPE__TIMEDTEXT = "timedtext";
    public static final String IJKM_VAL_TYPE__UNKNOWN = "unknown";
    public static final String IJKM_VAL_TYPE__VIDEO = "video";
    public IjkMediaMeta$IjkStreamMeta mAudioStream;
    public long mBitrate;
    public ArrayList mBitrateItems;
    public long mDurationUS;
    public String mFormat;
    public Bundle mMediaMeta;
    public long mStartUS;
    public final ArrayList mStreams;
    public IjkMediaMeta$IjkStreamMeta mVideoStream;

    public IjkMediaMeta() {
        ArrayList arrayList;
        this.mStreams = arrayList = new ArrayList();
    }

    public static IjkMediaMeta parse(Bundle object) {
        String string2;
        String string3;
        long l10;
        if (object == null) {
            return null;
        }
        IjkMediaMeta ijkMediaMeta = new IjkMediaMeta();
        ijkMediaMeta.mMediaMeta = object;
        ijkMediaMeta.mFormat = object = ijkMediaMeta.getString(IJKM_KEY_FORMAT);
        ijkMediaMeta.mDurationUS = l10 = ijkMediaMeta.getLong(IJKM_KEY_DURATION_US);
        ijkMediaMeta.mStartUS = l10 = ijkMediaMeta.getLong(IJKM_KEY_START_US);
        object = IJKM_KEY_BITRATE;
        ijkMediaMeta.mBitrate = l10 = ijkMediaMeta.getLong((String)object);
        Object object2 = "video";
        int n10 = -1;
        int n11 = ijkMediaMeta.getInt((String)object2, n10);
        String string4 = "audio";
        int n12 = ijkMediaMeta.getInt(string4, n10);
        ijkMediaMeta.getInt("timedtext", n10);
        Object object3 = ijkMediaMeta.getParcelableArrayList(IJKM_KEY_STREAMS);
        if (object3 == null) {
            return ijkMediaMeta;
        }
        Object object4 = new ArrayList();
        ijkMediaMeta.mBitrateItems = object4;
        object3 = ((ArrayList)object3).iterator();
        while (true) {
            long l11;
            int n13 = object3.hasNext();
            string3 = IJKM_KEY_HEIGHT;
            string2 = IJKM_KEY_WIDTH;
            if (n13 == 0) break;
            object4 = (Bundle)object3.next();
            ++n10;
            if (object4 == null) continue;
            IjkMediaMeta$IjkStreamMeta ijkMediaMeta$IjkStreamMeta = new IjkMediaMeta$IjkStreamMeta(n10);
            ijkMediaMeta$IjkStreamMeta.mMeta = object4;
            object4 = ijkMediaMeta$IjkStreamMeta.getString(IJKM_KEY_TYPE);
            ijkMediaMeta$IjkStreamMeta.mType = object4;
            object4 = ijkMediaMeta$IjkStreamMeta.getString(IJKM_KEY_LANGUAGE);
            ijkMediaMeta$IjkStreamMeta.mLanguage = object4;
            object4 = ijkMediaMeta$IjkStreamMeta.mType;
            n13 = TextUtils.isEmpty((CharSequence)object4);
            if (n13 != 0) continue;
            object4 = ijkMediaMeta$IjkStreamMeta.getString(IJKM_KEY_CODEC_NAME);
            ijkMediaMeta$IjkStreamMeta.mCodecName = object4;
            object4 = ijkMediaMeta$IjkStreamMeta.getString(IJKM_KEY_CODEC_PROFILE);
            ijkMediaMeta$IjkStreamMeta.mCodecProfile = object4;
            object4 = ijkMediaMeta$IjkStreamMeta.getString(IJKM_KEY_CODEC_LONG_NAME);
            ijkMediaMeta$IjkStreamMeta.mCodecLongName = object4;
            ijkMediaMeta$IjkStreamMeta.mBitrate = l11 = (long)ijkMediaMeta$IjkStreamMeta.getInt((String)object);
            object4 = ijkMediaMeta$IjkStreamMeta.mType;
            n13 = ((String)object4).equalsIgnoreCase((String)object2);
            if (n13 != 0) {
                ijkMediaMeta$IjkStreamMeta.mWidth = n13 = ijkMediaMeta$IjkStreamMeta.getInt(string2);
                ijkMediaMeta$IjkStreamMeta.mHeight = n13 = ijkMediaMeta$IjkStreamMeta.getInt(string3);
                ijkMediaMeta$IjkStreamMeta.mFpsNum = n13 = ijkMediaMeta$IjkStreamMeta.getInt(IJKM_KEY_FPS_NUM);
                ijkMediaMeta$IjkStreamMeta.mFpsDen = n13 = ijkMediaMeta$IjkStreamMeta.getInt(IJKM_KEY_FPS_DEN);
                ijkMediaMeta$IjkStreamMeta.mTbrNum = n13 = ijkMediaMeta$IjkStreamMeta.getInt(IJKM_KEY_TBR_NUM);
                ijkMediaMeta$IjkStreamMeta.mTbrDen = n13 = ijkMediaMeta$IjkStreamMeta.getInt(IJKM_KEY_TBR_DEN);
                ijkMediaMeta$IjkStreamMeta.mSarNum = n13 = ijkMediaMeta$IjkStreamMeta.getInt(IJKM_KEY_SAR_NUM);
                object4 = IJKM_KEY_SAR_DEN;
                ijkMediaMeta$IjkStreamMeta.mSarDen = n13 = ijkMediaMeta$IjkStreamMeta.getInt((String)object4);
                if (n11 == n10) {
                    ijkMediaMeta.mVideoStream = ijkMediaMeta$IjkStreamMeta;
                }
            } else {
                object4 = ijkMediaMeta$IjkStreamMeta.mType;
                n13 = (int)(((String)object4).equalsIgnoreCase(string4) ? 1 : 0);
                if (n13 != 0) {
                    long l12;
                    ijkMediaMeta$IjkStreamMeta.mSampleRate = n13 = ijkMediaMeta$IjkStreamMeta.getInt(IJKM_KEY_SAMPLE_RATE);
                    object4 = IJKM_KEY_CHANNEL_LAYOUT;
                    ijkMediaMeta$IjkStreamMeta.mChannelLayout = l12 = ijkMediaMeta$IjkStreamMeta.getLong((String)object4);
                    if (n12 == n10) {
                        ijkMediaMeta.mAudioStream = ijkMediaMeta$IjkStreamMeta;
                    }
                }
            }
            object4 = ijkMediaMeta.mStreams;
            ((ArrayList)object4).add(ijkMediaMeta$IjkStreamMeta);
        }
        object2 = ijkMediaMeta.getParcelableArrayList(IJKM_KEY_PROGRAMS);
        if (object2 == null) {
            return ijkMediaMeta;
        }
        object2 = ((ArrayList)object2).iterator();
        while ((n10 = (int)(object2.hasNext() ? 1 : 0)) != 0) {
            int n14;
            Object object5 = (Bundle)object2.next();
            if (object5 == null) continue;
            IjkBitrateItem ijkBitrateItem = new IjkBitrateItem();
            String string5 = "0";
            ijkBitrateItem.index = n14 = Integer.parseInt(object5.getString(IJKM_KEY_BITRATE_INDEX, string5));
            ijkBitrateItem.width = n14 = Integer.parseInt(object5.getString(string2, string5));
            string4 = object5.getString(string3, string5);
            ijkBitrateItem.height = n14 = Integer.parseInt(string4);
            ijkBitrateItem.bitrate = n10 = Integer.parseInt(object5.getString((String)object, string5));
            object5 = ijkMediaMeta.mBitrateItems;
            ((ArrayList)object5).add(ijkBitrateItem);
        }
        return ijkMediaMeta;
    }

    public String getDurationInline() {
        long l10 = (this.mDurationUS + 5000L) / 1000000L;
        long l11 = 60;
        long l12 = l10 / l11;
        long l13 = l12 / l11;
        Locale locale = Locale.US;
        Object[] objectArray = new Object[3];
        Long l14 = l13;
        objectArray[0] = l14;
        Long l15 = l12 %= l11;
        objectArray[1] = l15;
        Long l16 = l10 %= l11;
        objectArray[2] = l16;
        return String.format(locale, "%02d:%02d:%02d", objectArray);
    }

    public int getInt(String string2) {
        return this.getInt(string2, 0);
    }

    public int getInt(String string2, int n10) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)(string2 = this.getString(string2)));
        if (bl2) {
            return n10;
        }
        try {
            return Integer.parseInt(string2);
        }
        catch (NumberFormatException numberFormatException) {
            return n10;
        }
    }

    public long getLong(String string2) {
        return this.getLong(string2, 0L);
    }

    public long getLong(String string2, long l10) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)(string2 = this.getString(string2)));
        if (bl2) {
            return l10;
        }
        try {
            return Long.parseLong(string2);
        }
        catch (NumberFormatException numberFormatException) {
            return l10;
        }
    }

    public Map getMetaM3U8() {
        boolean bl2;
        HashMap<String, String> hashMap = new HashMap<String, String>();
        Iterator iterator2 = this.mMediaMeta.keySet().iterator();
        while (bl2 = iterator2.hasNext()) {
            String string2;
            String string3 = (String)iterator2.next();
            boolean bl3 = string3.startsWith(string2 = "m3u8:");
            if (!bl3) continue;
            string2 = this.mMediaMeta.getString(string3);
            hashMap.put(string3, string2);
        }
        return hashMap;
    }

    public ArrayList getParcelableArrayList(String string2) {
        return this.mMediaMeta.getParcelableArrayList(string2);
    }

    public String getString(String string2) {
        return this.mMediaMeta.getString(string2);
    }
}

