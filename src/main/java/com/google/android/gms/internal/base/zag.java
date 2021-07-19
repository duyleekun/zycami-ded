/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Canvas
 *  android.graphics.ColorFilter
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.Drawable$ConstantState
 */
package com.google.android.gms.internal.base;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import com.google.android.gms.internal.base.zah;

public final class zag
extends Drawable {
    private static final zag zanu;
    private static final zah zanv;

    static {
        Object object;
        zanu = object = new zag();
        object = new zah(null);
        zanv = object;
    }

    private zag() {
    }

    public static /* synthetic */ zag zacg() {
        return zanu;
    }

    public final void draw(Canvas canvas) {
    }

    public final Drawable.ConstantState getConstantState() {
        return zanv;
    }

    public final int getOpacity() {
        return -2;
    }

    public final void setAlpha(int n10) {
    }

    public final void setColorFilter(ColorFilter colorFilter) {
    }
}

