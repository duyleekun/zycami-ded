/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.graphics.drawable.Drawable
 */
package com.zhiyun.image;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import d.c.a.s.j.e;
import d.v.l.f;

public class Images$a
extends e {
    public final /* synthetic */ f d;

    public Images$a(f f10) {
        this.d = f10;
    }

    public void i(Drawable object) {
        object = this.d;
        if (object != null) {
            ((f)object).b();
        }
    }

    public void n(Bitmap bitmap, d.c.a.s.k.f object) {
        object = this.d;
        if (object != null) {
            ((f)object).c(bitmap);
        }
    }
}

