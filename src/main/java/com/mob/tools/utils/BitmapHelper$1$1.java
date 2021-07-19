/*
 * Decompiled with CFR 0.151.
 */
package com.mob.tools.utils;

import com.mob.tools.utils.BitmapHelper$1;
import java.io.FilterInputStream;
import java.io.InputStream;

public class BitmapHelper$1$1
extends FilterInputStream {
    public final /* synthetic */ BitmapHelper.1 this$0;

    public BitmapHelper$1$1(BitmapHelper.1 var1_1, InputStream inputStream) {
        this.this$0 = var1_1;
        super(inputStream);
    }

    public long skip(long l10) {
        long l11;
        InputStream inputStream;
        long l12;
        long l13;
        long l14;
        long l15;
        long l16;
        long l17 = l16 = 0L;
        while ((l15 = l17 == l10 ? 0 : (l17 < l10 ? -1 : 1)) < 0 && (l14 = (l13 = (l12 = (inputStream = this.in).skip(l11 = l10 - l17)) - l16) == 0L ? 0 : (l13 < 0L ? -1 : 1)) != false) {
            l17 += l12;
        }
        return l17;
    }
}

