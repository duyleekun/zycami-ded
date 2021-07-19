/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$Config
 */
package d.c.a.o.k.x;

import android.graphics.Bitmap;
import com.bumptech.glide.load.engine.bitmap_recycle.PrettyPrintTreeMap;
import d.c.a.o.k.x.h;
import d.c.a.o.k.x.l;
import d.c.a.o.k.x.m;
import d.c.a.o.k.x.o$a;
import d.c.a.o.k.x.o$b;
import java.util.NavigableMap;

public final class o
implements l {
    private static final int d = 8;
    private final o$b a;
    private final h b;
    private final NavigableMap c;

    public o() {
        Object object = new o$b();
        this.a = object;
        this.b = object = new h();
        this.c = object = new PrettyPrintTreeMap();
    }

    private void e(Integer n10) {
        int n11;
        Object object = (Integer)this.c.get(n10);
        int n12 = (Integer)object;
        if (n12 == (n11 = 1)) {
            object = this.c;
            object.remove(n10);
        } else {
            NavigableMap navigableMap = this.c;
            int n13 = (Integer)object - n11;
            object = n13;
            navigableMap.put(n10, object);
        }
    }

    public static String g(int n10) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        stringBuilder.append(n10);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    private static String h(Bitmap bitmap) {
        return o.g(d.c.a.u.m.h(bitmap));
    }

    public String a(Bitmap bitmap) {
        return o.h(bitmap);
    }

    public String b(int n10, int n11, Bitmap.Config config) {
        return o.g(d.c.a.u.m.g(n10, n11, config));
    }

    public int c(Bitmap bitmap) {
        return d.c.a.u.m.h(bitmap);
    }

    public void d(Bitmap object) {
        int n10 = d.c.a.u.m.h((Bitmap)object);
        Object object2 = this.a.e(n10);
        this.b.d((m)object2, object);
        object = this.c;
        int n11 = ((o$a)object2).b;
        Object object3 = n11;
        object = (Integer)object.get(object3);
        object3 = this.c;
        n10 = ((o$a)object2).b;
        object2 = n10;
        int n12 = 1;
        if (object != null) {
            int n13 = (Integer)object;
            n12 += n13;
        }
        object = n12;
        object3.put(object2, object);
    }

    public Bitmap f(int n10, int n11, Bitmap.Config config) {
        Object object;
        int n12;
        int n13 = d.c.a.u.m.g(n10, n11, config);
        o$a o$a = this.a.e(n13);
        Object object2 = this.c;
        Integer n14 = n13;
        if ((object2 = object2.ceilingKey(n14)) != null && (n12 = ((Integer)object2).intValue()) != n13 && (n12 = ((Integer)object2).intValue()) <= (n13 *= 8)) {
            this.a.c(o$a);
            object = this.a;
            int n15 = (Integer)object2;
            o$a = ((o$b)object).e(n15);
        }
        if ((object = (Bitmap)this.b.a(o$a)) != null) {
            object.reconfigure(n10, n11, config);
            this.e((Integer)object2);
        }
        return object;
    }

    public Bitmap removeLast() {
        Bitmap bitmap = (Bitmap)this.b.f();
        if (bitmap != null) {
            int n10 = d.c.a.u.m.h(bitmap);
            Integer n11 = n10;
            this.e(n11);
        }
        return bitmap;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SizeStrategy:\n  ");
        Object object = this.b;
        stringBuilder.append(object);
        stringBuilder.append("\n  SortedSizes");
        object = this.c;
        stringBuilder.append(object);
        return stringBuilder.toString();
    }
}

