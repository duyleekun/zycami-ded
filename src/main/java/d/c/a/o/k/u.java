/*
 * Decompiled with CFR 0.151.
 */
package d.c.a.o.k;

import d.c.a.o.c;
import d.c.a.o.f;
import d.c.a.o.i;
import d.c.a.o.k.x.b;
import d.c.a.u.h;
import d.c.a.u.m;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.security.MessageDigest;

public final class u
implements c {
    private static final h k;
    private final b c;
    private final c d;
    private final c e;
    private final int f;
    private final int g;
    private final Class h;
    private final f i;
    private final i j;

    static {
        h h10;
        k = h10 = new h(50);
    }

    public u(b b10, c c10, c c11, int n10, int n11, i i10, Class clazz, f f10) {
        this.c = b10;
        this.d = c10;
        this.e = c11;
        this.f = n10;
        this.g = n11;
        this.j = i10;
        this.h = clazz;
        this.i = f10;
    }

    private byte[] c() {
        h h10 = k;
        Object object = this.h;
        if ((object = (Object)((byte[])h10.j(object))) == null) {
            object = this.h.getName();
            Object object2 = d.c.a.o.c.b;
            object = ((String)object).getBytes((Charset)object2);
            object2 = this.h;
            h10.n(object2, object);
        }
        return object;
    }

    public void b(MessageDigest messageDigest) {
        byte[] byArray = (byte[])this.c.d(8, byte[].class);
        Object object = ByteBuffer.wrap(byArray);
        int n10 = this.f;
        object = ((ByteBuffer)object).putInt(n10);
        n10 = this.g;
        ((ByteBuffer)object).putInt(n10).array();
        this.e.b(messageDigest);
        this.d.b(messageDigest);
        messageDigest.update(byArray);
        object = this.j;
        if (object != null) {
            object.b(messageDigest);
        }
        this.i.b(messageDigest);
        object = this.c();
        messageDigest.update((byte[])object);
        this.c.put(byArray);
    }

    public boolean equals(Object object) {
        int n10 = object instanceof u;
        boolean bl2 = false;
        if (n10 != 0) {
            boolean bl3;
            Object object2;
            Object object3;
            object = (u)object;
            n10 = this.g;
            int n11 = ((u)object).g;
            if (n10 == n11 && (n10 = this.f) == (n11 = ((u)object).f) && (n10 = (int)(m.d(object3 = this.j, object2 = ((u)object).j) ? 1 : 0)) != 0 && (n10 = (int)((object3 = this.h).equals(object2 = ((u)object).h) ? 1 : 0)) != 0 && (n10 = (int)((object3 = this.d).equals(object2 = ((u)object).d) ? 1 : 0)) != 0 && (n10 = (int)((object3 = this.e).equals(object2 = ((u)object).e) ? 1 : 0)) != 0 && (bl3 = ((f)(object3 = this.i)).equals(object = ((u)object).i))) {
                bl2 = true;
            }
        }
        return bl2;
    }

    public int hashCode() {
        c c10 = this.d;
        int n10 = c10.hashCode() * 31;
        int n11 = this.e.hashCode();
        n10 = (n10 + n11) * 31;
        n11 = this.f;
        n10 = (n10 + n11) * 31;
        n11 = this.g;
        n10 += n11;
        i i10 = this.j;
        if (i10 != null) {
            n10 *= 31;
            n11 = i10.hashCode();
            n10 += n11;
        }
        n10 *= 31;
        n11 = this.h.hashCode();
        n10 = (n10 + n11) * 31;
        n11 = this.i.hashCode();
        return n10 + n11;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ResourceCacheKey{sourceKey=");
        Object object = this.d;
        stringBuilder.append(object);
        stringBuilder.append(", signature=");
        object = this.e;
        stringBuilder.append(object);
        stringBuilder.append(", width=");
        int n10 = this.f;
        stringBuilder.append(n10);
        stringBuilder.append(", height=");
        n10 = this.g;
        stringBuilder.append(n10);
        stringBuilder.append(", decodedResourceClass=");
        object = this.h;
        stringBuilder.append(object);
        stringBuilder.append(", transformation='");
        object = this.j;
        stringBuilder.append(object);
        stringBuilder.append('\'');
        stringBuilder.append(", options=");
        object = this.i;
        stringBuilder.append(object);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

