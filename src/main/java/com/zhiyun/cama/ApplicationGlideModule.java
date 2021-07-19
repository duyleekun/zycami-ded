/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Bitmap
 */
package com.zhiyun.cama;

import android.content.Context;
import android.graphics.Bitmap;
import com.bumptech.glide.Registry;
import com.bumptech.glide.load.DecodeFormat;
import d.c.a.c;
import d.c.a.d;
import d.c.a.s.a;
import d.c.a.s.g;
import d.v.c.x1.q.e;

public class ApplicationGlideModule
extends d.c.a.q.a {
    public void a(Context object, d d10) {
        object = new g();
        DecodeFormat decodeFormat = DecodeFormat.PREFER_ARGB_8888;
        object = (g)((a)object).F(decodeFormat);
        d10.h((g)object);
    }

    public void b(Context context, c c10, Registry registry) {
        e e10 = new e();
        registry.r(d.v.c.x1.q.c.class, Bitmap.class, e10);
    }

    public boolean c() {
        return false;
    }
}

