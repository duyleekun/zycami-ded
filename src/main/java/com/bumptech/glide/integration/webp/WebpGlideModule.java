/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.graphics.Bitmap
 *  android.graphics.drawable.BitmapDrawable
 *  android.util.DisplayMetrics
 */
package com.bumptech.glide.integration.webp;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.util.DisplayMetrics;
import com.bumptech.glide.Registry;
import d.c.a.d;
import d.c.a.n.a.d.f;
import d.c.a.n.a.d.j;
import d.c.a.n.a.d.k;
import d.c.a.n.a.d.l;
import d.c.a.o.g;
import d.c.a.o.h;
import d.c.a.o.k.x.b;
import d.c.a.o.k.x.e;
import d.c.a.o.m.d.a;
import d.c.a.q.c;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

public class WebpGlideModule
implements c {
    public void a(Context context, d d10) {
    }

    public void b(Context object, d.c.a.c object2, Registry object3) {
        Resources resources = object.getResources();
        Object object4 = ((d.c.a.c)object2).g();
        object2 = ((d.c.a.c)object2).f();
        Object object5 = ((Registry)object3).g();
        Object object6 = resources.getDisplayMetrics();
        Object object7 = new j((List)object5, (DisplayMetrics)object6, (e)object4, (b)object2);
        object5 = new d.c.a.n.a.d.a((b)object2, (e)object4);
        object6 = new d.c.a.n.a.d.c((j)object7);
        f f10 = new f((j)object7, (b)object2);
        object7 = new d.c.a.n.a.d.d((Context)object, (b)object2, (e)object4);
        String string2 = "Bitmap";
        object = ((Registry)object3).s(string2, ByteBuffer.class, Bitmap.class, (g)object6).s(string2, InputStream.class, Bitmap.class, f10);
        a a10 = new a(resources, (g)object6);
        object6 = "BitmapDrawable";
        object = ((Registry)object).s((String)object6, ByteBuffer.class, BitmapDrawable.class, a10);
        a10 = new a(resources, (g)f10);
        object = ((Registry)object).s((String)object6, InputStream.class, BitmapDrawable.class, a10);
        object4 = new d.c.a.n.a.d.b((d.c.a.n.a.d.a)object5);
        object = ((Registry)object).s(string2, ByteBuffer.class, Bitmap.class, (g)object4);
        object4 = new d.c.a.n.a.d.e((d.c.a.n.a.d.a)object5);
        object = ((Registry)object).s(string2, InputStream.class, Bitmap.class, (g)object4).q(ByteBuffer.class, k.class, (g)object7);
        object4 = new d.c.a.n.a.d.g((g)object7, (b)object2);
        object = ((Registry)object).q(InputStream.class, k.class, (g)object4);
        object3 = new l();
        ((Registry)object).p(k.class, (h)object3);
    }
}

