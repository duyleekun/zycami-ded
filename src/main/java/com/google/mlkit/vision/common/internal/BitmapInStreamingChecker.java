/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.SystemClock
 */
package com.google.mlkit.vision.common.internal;

import android.os.SystemClock;
import com.google.android.gms.common.internal.GmsLogger;
import com.google.mlkit.vision.common.InputImage;
import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

public class BitmapInStreamingChecker {
    private static final GmsLogger zza;
    private final LinkedList zzb;
    private long zzc;

    static {
        GmsLogger gmsLogger;
        zza = gmsLogger = new GmsLogger("StreamingFormatChecker", "");
    }

    public BitmapInStreamingChecker() {
        LinkedList linkedList;
        this.zzb = linkedList = new LinkedList();
        this.zzc = -1;
    }

    public void check(InputImage object) {
        int n10;
        int n11 = ((InputImage)object).getFormat();
        if (n11 != (n10 = -1)) {
            return;
        }
        long l10 = SystemClock.elapsedRealtime();
        object = this.zzb;
        Long l11 = l10;
        ((LinkedList)object).add(l11);
        object = this.zzb;
        n11 = ((LinkedList)object).size();
        int n12 = 5;
        if (n11 > n12) {
            object = this.zzb;
            ((LinkedList)object).removeFirst();
        }
        if ((n11 = ((LinkedList)(object = this.zzb)).size()) == n12) {
            long l12;
            long l13;
            object = (Long)this.zzb.peekFirst();
            long l14 = (Long)object;
            long l15 = 5000L;
            long l16 = (l14 = l10 - l14) - l15;
            n11 = (int)(l16 == 0L ? 0 : (l16 < 0L ? -1 : 1));
            if (n11 < 0 && ((n11 = (int)((l13 = (l14 = this.zzc) - (l15 = (long)-1)) == 0L ? 0 : (l13 < 0L ? -1 : 1))) == 0 || (n11 = (int)((l12 = (l14 = l10 - l14) - (l15 = ((TimeUnit)((Object)(object = TimeUnit.SECONDS))).toMillis(5))) == 0L ? 0 : (l12 < 0L ? -1 : 1))) >= 0)) {
                this.zzc = l10;
                object = zza;
                String string2 = "StreamingFormatChecker";
                String string3 = "ML Kit has detected that you seem to pass camera frames to the detector as a Bitmap object. This is inefficient. Please use YUV_420_888 format for camera2 API or NV21 format for (legacy) camera API and directly pass down the byte array to ML Kit.";
                ((GmsLogger)object).w(string2, string3);
            }
        }
    }
}

