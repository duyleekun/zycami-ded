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
package d.c.a.n.a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.util.DisplayMetrics;
import com.bumptech.glide.Registry;
import d.c.a.n.a.d.a;
import d.c.a.n.a.d.b;
import d.c.a.n.a.d.d;
import d.c.a.n.a.d.e;
import d.c.a.n.a.d.f;
import d.c.a.n.a.d.g;
import d.c.a.n.a.d.j;
import d.c.a.n.a.d.k;
import d.c.a.n.a.d.l;
import d.c.a.o.h;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

public class c
extends d.c.a.q.d {
    public void b(Context object, d.c.a.c object2, Registry object3) {
        Resources resources = object.getResources();
        Object object4 = ((d.c.a.c)object2).g();
        object2 = ((d.c.a.c)object2).f();
        Object object5 = ((Registry)object3).g();
        Object object6 = resources.getDisplayMetrics();
        Object object7 = new j((List)object5, (DisplayMetrics)object6, (d.c.a.o.k.x.e)object4, (d.c.a.o.k.x.b)object2);
        object5 = new a((d.c.a.o.k.x.b)object2, (d.c.a.o.k.x.e)object4);
        object6 = new d.c.a.n.a.d.c((j)object7);
        f f10 = new f((j)object7, (d.c.a.o.k.x.b)object2);
        object7 = new d((Context)object, (d.c.a.o.k.x.b)object2, (d.c.a.o.k.x.e)object4);
        String string2 = "Bitmap";
        object = ((Registry)object3).s(string2, ByteBuffer.class, Bitmap.class, (d.c.a.o.g)object6).s(string2, InputStream.class, Bitmap.class, f10);
        d.c.a.o.m.d.a a10 = new d.c.a.o.m.d.a(resources, (d.c.a.o.g)object6);
        object6 = "BitmapDrawable";
        object = ((Registry)object).s((String)object6, ByteBuffer.class, BitmapDrawable.class, a10);
        a10 = new d.c.a.o.m.d.a(resources, (d.c.a.o.g)f10);
        object = ((Registry)object).s((String)object6, InputStream.class, BitmapDrawable.class, a10);
        object4 = new b((a)object5);
        object = ((Registry)object).s(string2, ByteBuffer.class, Bitmap.class, (d.c.a.o.g)object4);
        object4 = new e((a)object5);
        object = ((Registry)object).s(string2, InputStream.class, Bitmap.class, (d.c.a.o.g)object4).q(ByteBuffer.class, k.class, (d.c.a.o.g)object7);
        object4 = new g((d.c.a.o.g)object7, (d.c.a.o.k.x.b)object2);
        object = ((Registry)object).q(InputStream.class, k.class, (d.c.a.o.g)object4);
        object3 = new l();
        ((Registry)object).p(k.class, (h)object3);
    }
}

