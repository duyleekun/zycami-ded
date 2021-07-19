/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.media.MediaFormat
 *  android.media.MediaPlayer
 *  android.media.MediaPlayer$TrackInfo
 *  android.os.Build$VERSION
 */
package com.tencent.ijk.media.player.misc;

import android.media.MediaFormat;
import android.media.MediaPlayer;
import android.os.Build;
import com.tencent.ijk.media.player.misc.AndroidMediaFormat;
import com.tencent.ijk.media.player.misc.IMediaFormat;
import com.tencent.ijk.media.player.misc.ITrackInfo;

public class AndroidTrackInfo
implements ITrackInfo {
    private final MediaPlayer.TrackInfo mTrackInfo;

    private AndroidTrackInfo(MediaPlayer.TrackInfo trackInfo) {
        this.mTrackInfo = trackInfo;
    }

    public static AndroidTrackInfo[] fromMediaPlayer(MediaPlayer mediaPlayer) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 16;
        if (n10 >= n11) {
            return AndroidTrackInfo.fromTrackInfo(mediaPlayer.getTrackInfo());
        }
        return null;
    }

    private static AndroidTrackInfo[] fromTrackInfo(MediaPlayer.TrackInfo[] trackInfoArray) {
        int n10;
        if (trackInfoArray == null) {
            return null;
        }
        int n11 = trackInfoArray.length;
        AndroidTrackInfo[] androidTrackInfoArray = new AndroidTrackInfo[n11];
        for (int i10 = 0; i10 < (n10 = trackInfoArray.length); ++i10) {
            AndroidTrackInfo androidTrackInfo;
            MediaPlayer.TrackInfo trackInfo = trackInfoArray[i10];
            androidTrackInfoArray[i10] = androidTrackInfo = new AndroidTrackInfo(trackInfo);
        }
        return androidTrackInfoArray;
    }

    public IMediaFormat getFormat() {
        MediaPlayer.TrackInfo trackInfo = this.mTrackInfo;
        AndroidMediaFormat androidMediaFormat = null;
        if (trackInfo == null) {
            return null;
        }
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 19;
        if (n10 < n11) {
            return null;
        }
        if ((trackInfo = trackInfo.getFormat()) == null) {
            return null;
        }
        androidMediaFormat = new AndroidMediaFormat((MediaFormat)trackInfo);
        return androidMediaFormat;
    }

    public String getInfoInline() {
        MediaPlayer.TrackInfo trackInfo = this.mTrackInfo;
        if (trackInfo != null) {
            return trackInfo.toString();
        }
        return "null";
    }

    public String getLanguage() {
        MediaPlayer.TrackInfo trackInfo = this.mTrackInfo;
        if (trackInfo == null) {
            return "und";
        }
        return trackInfo.getLanguage();
    }

    public int getTrackType() {
        MediaPlayer.TrackInfo trackInfo = this.mTrackInfo;
        if (trackInfo == null) {
            return 0;
        }
        return trackInfo.getTrackType();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(128);
        String string2 = this.getClass().getSimpleName();
        stringBuilder.append(string2);
        char c10 = '{';
        stringBuilder.append(c10);
        string2 = this.mTrackInfo;
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

