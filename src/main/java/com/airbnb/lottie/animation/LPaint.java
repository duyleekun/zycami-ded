/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Paint
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.PorterDuffXfermode
 *  android.graphics.Xfermode
 *  android.os.LocaleList
 */
package com.airbnb.lottie.animation;

import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Xfermode;
import android.os.LocaleList;

public class LPaint
extends Paint {
    public LPaint() {
    }

    public LPaint(int n10) {
        super(n10);
    }

    public LPaint(int n10, PorterDuff.Mode mode) {
        super(n10);
        PorterDuffXfermode porterDuffXfermode = new PorterDuffXfermode(mode);
        this.setXfermode((Xfermode)porterDuffXfermode);
    }

    public LPaint(PorterDuff.Mode mode) {
        PorterDuffXfermode porterDuffXfermode = new PorterDuffXfermode(mode);
        this.setXfermode((Xfermode)porterDuffXfermode);
    }

    public void setTextLocales(LocaleList localeList) {
    }
}

