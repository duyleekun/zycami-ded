/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$Config
 */
package d.c.a.o.k.x;

import android.graphics.Bitmap;
import d.c.a.o.k.x.c$a;
import d.c.a.o.k.x.c$b;
import d.c.a.o.k.x.h;
import d.c.a.o.k.x.l;
import d.c.a.o.k.x.m;

public class c
implements l {
    private final c$b a;
    private final h b;

    public c() {
        Object object = new c$b();
        this.a = object;
        this.b = object = new h();
    }

    public static String e(int n10, int n11, Bitmap.Config config) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        stringBuilder.append(n10);
        stringBuilder.append("x");
        stringBuilder.append(n11);
        stringBuilder.append("], ");
        stringBuilder.append(config);
        return stringBuilder.toString();
    }

    private static String g(Bitmap bitmap) {
        int n10 = bitmap.getWidth();
        int n11 = bitmap.getHeight();
        bitmap = bitmap.getConfig();
        return c.e(n10, n11, (Bitmap.Config)bitmap);
    }

    public String a(Bitmap bitmap) {
        return c.g(bitmap);
    }

    public String b(int n10, int n11, Bitmap.Config config) {
        return c.e(n10, n11, config);
    }

    public int c(Bitmap bitmap) {
        return d.c.a.u.m.h(bitmap);
    }

    public void d(Bitmap bitmap) {
        Object object = this.a;
        int n10 = bitmap.getWidth();
        int n11 = bitmap.getHeight();
        Bitmap.Config config = bitmap.getConfig();
        object = ((c$b)object).e(n10, n11, config);
        this.b.d((m)object, bitmap);
    }

    public Bitmap f(int n10, int n11, Bitmap.Config config) {
        c$a c$a = this.a.e(n10, n11, config);
        return (Bitmap)this.b.a(c$a);
    }

    public Bitmap removeLast() {
        return (Bitmap)this.b.f();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("AttributeStrategy:\n  ");
        h h10 = this.b;
        stringBuilder.append(h10);
        return stringBuilder.toString();
    }
}

