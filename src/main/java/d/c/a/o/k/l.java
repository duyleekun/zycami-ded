/*
 * Decompiled with CFR 0.151.
 */
package d.c.a.o.k;

import d.c.a.o.c;
import d.c.a.o.f;
import d.c.a.u.k;
import java.security.MessageDigest;
import java.util.Map;

public class l
implements c {
    private final Object c;
    private final int d;
    private final int e;
    private final Class f;
    private final Class g;
    private final c h;
    private final Map i;
    private final f j;
    private int k;

    public l(Object object, c c10, int n10, int n11, Map map, Class clazz, Class clazz2, f f10) {
        this.c = object = d.c.a.u.k.d(object);
        this.h = object = (c)d.c.a.u.k.e(c10, "Signature must not be null");
        this.d = n10;
        this.e = n11;
        this.i = object = (Map)d.c.a.u.k.d(map);
        this.f = object = (Class)d.c.a.u.k.e(clazz, "Resource class must not be null");
        this.g = object = (Class)d.c.a.u.k.e(clazz2, "Transcode class must not be null");
        this.j = object = (f)d.c.a.u.k.d(f10);
    }

    public void b(MessageDigest object) {
        object = new UnsupportedOperationException();
        throw object;
    }

    public boolean equals(Object object) {
        int n10 = object instanceof l;
        boolean bl2 = false;
        if (n10 != 0) {
            boolean bl3;
            int n11;
            object = (l)object;
            Object object2 = this.c;
            Object object3 = ((l)object).c;
            n10 = object2.equals(object3);
            if (n10 != 0 && (n10 = (object2 = this.h).equals(object3 = ((l)object).h)) != 0 && (n10 = this.e) == (n11 = ((l)object).e) && (n10 = this.d) == (n11 = ((l)object).d) && (n10 = (int)((object2 = this.i).equals(object3 = ((l)object).i) ? 1 : 0)) != 0 && (n10 = (int)((object2 = this.f).equals(object3 = ((l)object).f) ? 1 : 0)) != 0 && (n10 = (int)((object2 = this.g).equals(object3 = ((l)object).g) ? 1 : 0)) != 0 && (bl3 = ((f)(object2 = this.j)).equals(object = ((l)object).j))) {
                bl2 = true;
            }
        }
        return bl2;
    }

    public int hashCode() {
        int n10 = this.k;
        if (n10 == 0) {
            Object object = this.c;
            this.k = n10 = object.hashCode();
            n10 *= 31;
            int n11 = this.h.hashCode();
            this.k = n10 += n11;
            n10 *= 31;
            n11 = this.d;
            this.k = n10 += n11;
            n10 *= 31;
            n11 = this.e;
            this.k = n10 += n11;
            n10 *= 31;
            n11 = this.i.hashCode();
            this.k = n10 += n11;
            n10 *= 31;
            n11 = this.f.hashCode();
            this.k = n10 += n11;
            n10 *= 31;
            n11 = this.g.hashCode();
            this.k = n10 += n11;
            n10 *= 31;
            f f10 = this.j;
            n11 = f10.hashCode();
            this.k = n10 += n11;
        }
        return this.k;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("EngineKey{model=");
        Object object = this.c;
        stringBuilder.append(object);
        stringBuilder.append(", width=");
        int n10 = this.d;
        stringBuilder.append(n10);
        stringBuilder.append(", height=");
        n10 = this.e;
        stringBuilder.append(n10);
        stringBuilder.append(", resourceClass=");
        object = this.f;
        stringBuilder.append(object);
        stringBuilder.append(", transcodeClass=");
        object = this.g;
        stringBuilder.append(object);
        stringBuilder.append(", signature=");
        object = this.h;
        stringBuilder.append(object);
        stringBuilder.append(", hashCode=");
        n10 = this.k;
        stringBuilder.append(n10);
        stringBuilder.append(", transformations=");
        object = this.i;
        stringBuilder.append(object);
        stringBuilder.append(", options=");
        object = this.j;
        stringBuilder.append(object);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

