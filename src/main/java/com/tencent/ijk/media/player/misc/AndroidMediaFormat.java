/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.media.MediaFormat
 */
package com.tencent.ijk.media.player.misc;

import android.media.MediaFormat;
import com.tencent.ijk.media.player.misc.IMediaFormat;

public class AndroidMediaFormat
implements IMediaFormat {
    private final MediaFormat mMediaFormat;

    public AndroidMediaFormat(MediaFormat mediaFormat) {
        this.mMediaFormat = mediaFormat;
    }

    public int getInteger(String string2) {
        MediaFormat mediaFormat = this.mMediaFormat;
        if (mediaFormat == null) {
            return 0;
        }
        return mediaFormat.getInteger(string2);
    }

    public String getString(String string2) {
        MediaFormat mediaFormat = this.mMediaFormat;
        if (mediaFormat == null) {
            return null;
        }
        return mediaFormat.getString(string2);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(128);
        String string2 = this.getClass().getName();
        stringBuilder.append(string2);
        char c10 = '{';
        stringBuilder.append(c10);
        string2 = this.mMediaFormat;
        if (string2 != null) {
            string2 = string2.toString();
            stringBuilder.append(string2);
        } else {
            string2 = "null";
            stringBuilder.append(string2);
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

