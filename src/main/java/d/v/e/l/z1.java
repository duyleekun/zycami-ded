/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Bitmap
 *  android.media.MediaCodecInfo
 *  android.media.MediaCodecList
 *  android.media.MediaMetadataRetriever
 *  android.net.Uri
 */
package d.v.e.l;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import d.v.e.f;
import d.v.e.l.s1;

public class z1 {
    public static boolean a(String string2) {
        MediaCodecInfo[] mediaCodecInfoArray = new MediaCodecList(0);
        mediaCodecInfoArray = mediaCodecInfoArray.getCodecInfos();
        int n10 = mediaCodecInfoArray.length;
        for (int i10 = 0; i10 < n10; ++i10) {
            for (String string3 : mediaCodecInfoArray[i10].getSupportedTypes()) {
                boolean bl2 = string2.equals(string3);
                if (!bl2) continue;
                return true;
            }
        }
        return false;
    }

    public static Bitmap b(String string2, long l10) {
        boolean bl2 = s1.q(string2);
        if (!bl2) {
            return null;
        }
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        String string3 = "content://";
        boolean bl3 = string2.startsWith(string3);
        if (bl3) {
            string3 = f.a().c();
            string2 = Uri.parse((String)string2);
            mediaMetadataRetriever.setDataSource((Context)string3, (Uri)string2);
        } else {
            mediaMetadataRetriever.setDataSource(string2);
        }
        return mediaMetadataRetriever.getFrameAtTime(l10, 2);
    }
}

