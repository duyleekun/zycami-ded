/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.ContextWrapper
 *  android.widget.ImageView
 */
package d.c.a;

import android.content.Context;
import android.content.ContextWrapper;
import android.widget.ImageView;
import com.bumptech.glide.Registry;
import d.c.a.b;
import d.c.a.c$a;
import d.c.a.j;
import d.c.a.o.k.i;
import d.c.a.s.a;
import d.c.a.s.g;
import d.c.a.s.j.k;
import d.c.a.s.j.r;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class e
extends ContextWrapper {
    public static final j k;
    private final d.c.a.o.k.x.b a;
    private final Registry b;
    private final k c;
    private final c$a d;
    private final List e;
    private final Map f;
    private final i g;
    private final boolean h;
    private final int i;
    private g j;

    static {
        b b10 = new b();
        k = b10;
    }

    public e(Context context, d.c.a.o.k.x.b b10, Registry registry, k k10, c$a c$a, Map map, List list, i i10, boolean bl2, int n10) {
        context = context.getApplicationContext();
        super(context);
        this.a = b10;
        this.b = registry;
        this.c = k10;
        this.d = c$a;
        this.e = list;
        this.f = map;
        this.g = i10;
        this.h = bl2;
        this.i = n10;
    }

    public r a(ImageView imageView, Class clazz) {
        return this.c.a(imageView, clazz);
    }

    public d.c.a.o.k.x.b b() {
        return this.a;
    }

    public List c() {
        return this.e;
    }

    public g d() {
        synchronized (this) {
            Object object = this.j;
            if (object == null) {
                object = this.d;
                object = object.build();
                object = ((a)object).o0();
                this.j = object = (g)object;
            }
            object = this.j;
            return object;
        }
    }

    public j e(Class clazz) {
        j j10 = (j)this.f.get(clazz);
        if (j10 == null) {
            boolean bl2;
            Iterator iterator2 = this.f.entrySet().iterator();
            while (bl2 = iterator2.hasNext()) {
                Map.Entry entry = iterator2.next();
                Class clazz2 = (Class)entry.getKey();
                boolean bl3 = clazz2.isAssignableFrom(clazz);
                if (!bl3) continue;
                j10 = (j)entry.getValue();
            }
        }
        if (j10 == null) {
            j10 = k;
        }
        return j10;
    }

    public i f() {
        return this.g;
    }

    public int g() {
        return this.i;
    }

    public Registry h() {
        return this.b;
    }

    public boolean i() {
        return this.h;
    }
}

