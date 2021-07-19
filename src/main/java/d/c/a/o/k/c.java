/*
 * Decompiled with CFR 0.151.
 */
package d.c.a.o.k;

import java.security.MessageDigest;

public final class c
implements d.c.a.o.c {
    private final d.c.a.o.c c;
    private final d.c.a.o.c d;

    public c(d.c.a.o.c c10, d.c.a.o.c c11) {
        this.c = c10;
        this.d = c11;
    }

    public void b(MessageDigest messageDigest) {
        this.c.b(messageDigest);
        this.d.b(messageDigest);
    }

    public d.c.a.o.c c() {
        return this.c;
    }

    public boolean equals(Object object) {
        boolean bl2 = object instanceof c;
        boolean bl3 = false;
        if (bl2) {
            boolean bl4;
            object = (c)object;
            d.c.a.o.c c10 = this.c;
            d.c.a.o.c c11 = ((c)object).c;
            bl2 = c10.equals(c11);
            if (bl2 && (bl4 = (c10 = this.d).equals(object = ((c)object).d))) {
                bl3 = true;
            }
        }
        return bl3;
    }

    public int hashCode() {
        int n10 = this.c.hashCode() * 31;
        int n11 = this.d.hashCode();
        return n10 + n11;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("DataCacheKey{sourceKey=");
        d.c.a.o.c c10 = this.c;
        stringBuilder.append(c10);
        stringBuilder.append(", signature=");
        c10 = this.d;
        stringBuilder.append(c10);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

