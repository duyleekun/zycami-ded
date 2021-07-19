/*
 * Decompiled with CFR 0.151.
 */
package com.tencent.ijk.media.player.misc;

import com.tencent.ijk.media.player.IjkMediaMeta$IjkStreamMeta;
import com.tencent.ijk.media.player.misc.IMediaFormat;
import com.tencent.ijk.media.player.misc.IjkMediaFormat$1;
import com.tencent.ijk.media.player.misc.IjkMediaFormat$Formatter;
import java.util.HashMap;
import java.util.Map;

public class IjkMediaFormat
implements IMediaFormat {
    public static final String CODEC_NAME_H264 = "h264";
    public static final String KEY_IJK_BIT_RATE_UI = "ijk-bit-rate-ui";
    public static final String KEY_IJK_CHANNEL_UI = "ijk-channel-ui";
    public static final String KEY_IJK_CODEC_LONG_NAME_UI = "ijk-codec-long-name-ui";
    public static final String KEY_IJK_CODEC_NAME_UI = "ijk-codec-name-ui";
    public static final String KEY_IJK_CODEC_PIXEL_FORMAT_UI = "ijk-pixel-format-ui";
    public static final String KEY_IJK_CODEC_PROFILE_LEVEL_UI = "ijk-profile-level-ui";
    public static final String KEY_IJK_FRAME_RATE_UI = "ijk-frame-rate-ui";
    public static final String KEY_IJK_RESOLUTION_UI = "ijk-resolution-ui";
    public static final String KEY_IJK_SAMPLE_RATE_UI = "ijk-sample-rate-ui";
    private static final Map sFormatterMap;
    public final IjkMediaMeta$IjkStreamMeta mMediaFormat;

    static {
        HashMap hashMap;
        sFormatterMap = hashMap = new HashMap();
    }

    public IjkMediaFormat(IjkMediaMeta$IjkStreamMeta ijkMediaMeta$IjkStreamMeta) {
        Map map = sFormatterMap;
        IjkMediaFormat$Formatter ijkMediaFormat$Formatter = new IjkMediaFormat$1(this);
        map.put(KEY_IJK_CODEC_LONG_NAME_UI, ijkMediaFormat$Formatter);
        super(this);
        map.put(KEY_IJK_CODEC_NAME_UI, ijkMediaFormat$Formatter);
        super(this);
        map.put(KEY_IJK_BIT_RATE_UI, ijkMediaFormat$Formatter);
        super(this);
        map.put(KEY_IJK_CODEC_PROFILE_LEVEL_UI, ijkMediaFormat$Formatter);
        super(this);
        map.put(KEY_IJK_CODEC_PIXEL_FORMAT_UI, ijkMediaFormat$Formatter);
        super(this);
        map.put(KEY_IJK_RESOLUTION_UI, ijkMediaFormat$Formatter);
        super(this);
        map.put(KEY_IJK_FRAME_RATE_UI, ijkMediaFormat$Formatter);
        super(this);
        map.put(KEY_IJK_SAMPLE_RATE_UI, ijkMediaFormat$Formatter);
        super(this);
        map.put(KEY_IJK_CHANNEL_UI, ijkMediaFormat$Formatter);
        this.mMediaFormat = ijkMediaMeta$IjkStreamMeta;
    }

    public int getInteger(String string2) {
        IjkMediaMeta$IjkStreamMeta ijkMediaMeta$IjkStreamMeta = this.mMediaFormat;
        if (ijkMediaMeta$IjkStreamMeta == null) {
            return 0;
        }
        return ijkMediaMeta$IjkStreamMeta.getInt(string2);
    }

    public String getString(String string2) {
        Object object = this.mMediaFormat;
        if (object == null) {
            return null;
        }
        object = sFormatterMap;
        boolean bl2 = object.containsKey(string2);
        if (bl2) {
            return ((IjkMediaFormat$Formatter)object.get(string2)).format(this);
        }
        return this.mMediaFormat.getString(string2);
    }
}

