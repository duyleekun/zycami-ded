/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.media.MediaFormat
 */
package com.google.android.exoplayer2.mediacodec;

import android.media.MediaFormat;
import com.google.android.exoplayer2.video.ColorInfo;
import java.nio.ByteBuffer;
import java.util.List;

public final class MediaFormatUtil {
    private MediaFormatUtil() {
    }

    public static void maybeSetByteBuffer(MediaFormat mediaFormat, String string2, byte[] object) {
        if (object != null) {
            object = ByteBuffer.wrap(object);
            mediaFormat.setByteBuffer(string2, (ByteBuffer)object);
        }
    }

    public static void maybeSetColorInfo(MediaFormat mediaFormat, ColorInfo object) {
        if (object != null) {
            int n10 = ((ColorInfo)object).colorTransfer;
            MediaFormatUtil.maybeSetInteger(mediaFormat, "color-transfer", n10);
            n10 = ((ColorInfo)object).colorSpace;
            MediaFormatUtil.maybeSetInteger(mediaFormat, "color-standard", n10);
            n10 = ((ColorInfo)object).colorRange;
            String string2 = "color-range";
            MediaFormatUtil.maybeSetInteger(mediaFormat, string2, n10);
            object = ((ColorInfo)object).hdrStaticInfo;
            String string3 = "hdr-static-info";
            MediaFormatUtil.maybeSetByteBuffer(mediaFormat, string3, (byte[])object);
        }
    }

    public static void maybeSetFloat(MediaFormat mediaFormat, String string2, float f10) {
        float f11 = -1.0f;
        float f12 = f10 - f11;
        Object object = f12 == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1);
        if (object != false) {
            mediaFormat.setFloat(string2, f10);
        }
    }

    public static void maybeSetInteger(MediaFormat mediaFormat, String string2, int n10) {
        int n11 = -1;
        if (n10 != n11) {
            mediaFormat.setInteger(string2, n10);
        }
    }

    public static void setCsdBuffers(MediaFormat mediaFormat, List list) {
        int n10;
        for (int i10 = 0; i10 < (n10 = list.size()); ++i10) {
            n10 = 15;
            Comparable<StringBuilder> comparable = new StringBuilder(n10);
            comparable.append("csd-");
            comparable.append(i10);
            String string2 = comparable.toString();
            comparable = ByteBuffer.wrap((byte[])list.get(i10));
            mediaFormat.setByteBuffer(string2, (ByteBuffer)comparable);
        }
    }

    public static void setString(MediaFormat mediaFormat, String string2, String string3) {
        mediaFormat.setString(string2, string3);
    }
}

