/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$Config
 *  android.util.Log
 */
package com.meishe.cafconvertor.webpcoder;

import android.graphics.Bitmap;
import android.util.Log;
import com.meishe.cafconvertor.webpcoder.FrameSequence;

public class FrameSequence$a {
    private long a;

    public FrameSequence$a(long l10) {
        this.a = l10;
    }

    public void a() {
        CharSequence charSequence = new StringBuilder();
        charSequence.append("State destroy: mNativeState is ");
        long l10 = this.a;
        charSequence.append(l10);
        charSequence = charSequence.toString();
        String string2 = "FrameSequence";
        Log.d((String)string2, (String)charSequence);
        long l11 = this.a;
        long l12 = 0L;
        long l13 = l11 == l12 ? 0 : (l11 < l12 ? -1 : 1);
        if (l13 != false) {
            FrameSequence.c(l11);
            this.a = l12;
        }
    }

    public long b(int n10, Bitmap bitmap, int n11) {
        Bitmap.Config config;
        Bitmap.Config config2;
        if (bitmap != null && (config2 = bitmap.getConfig()) == (config = Bitmap.Config.ARGB_8888)) {
            long l10 = this.a;
            long l11 = 0L;
            long l12 = l10 - l11;
            Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
            if (object != false) {
                return FrameSequence.a(l10, n10, bitmap, n11);
            }
            IllegalStateException illegalStateException = new IllegalStateException("attempted to draw destroyed FrameSequenceState");
            throw illegalStateException;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Bitmap passed must be non-null and ARGB_8888");
        throw illegalArgumentException;
    }
}

