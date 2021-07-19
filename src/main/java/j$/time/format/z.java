/*
 * Decompiled with CFR 0.151.
 */
package j$.time.format;

import j$.e.a.a.a.a;
import java.util.concurrent.ConcurrentHashMap;

public final class z {
    public static final z e;
    private final char a;
    private final char b;
    private final char c;
    private final char d;

    static {
        z z10;
        e = z10 = new z('0', '+', '-', '.');
        new ConcurrentHashMap(16, 0.75f, 2);
    }

    private z(char c10, char c11, char c12, char c13) {
        this.a = c10;
        this.b = c11;
        this.c = c12;
        this.d = c13;
    }

    String a(String object) {
        int n10;
        int n11 = this.a;
        int n12 = 48;
        if (n11 == n12) {
            return object;
        }
        n11 -= n12;
        object = ((String)object).toCharArray();
        for (n12 = 0; n12 < (n10 = ((Object)object).length); ++n12) {
            n10 = (char)(object[n12] + n11);
            object[n12] = n10;
        }
        String string2 = new String((char[])object);
        return string2;
    }

    public char b() {
        return this.d;
    }

    public char c() {
        return this.c;
    }

    public char d() {
        return this.b;
    }

    public char e() {
        return this.a;
    }

    public boolean equals(Object object) {
        boolean bl2 = true;
        if (this == object) {
            return bl2;
        }
        char c10 = object instanceof z;
        if (c10 != '\u0000') {
            char c11;
            object = (z)object;
            c10 = this.a;
            char c12 = ((z)object).a;
            if (c10 != c12 || (c10 = this.b) != (c12 = ((z)object).b) || (c10 = this.c) != (c12 = ((z)object).c) || (c10 = this.d) != (c11 = ((z)object).d)) {
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public int hashCode() {
        int n10 = this.a;
        char c10 = this.b;
        n10 += c10;
        c10 = this.c;
        n10 += c10;
        c10 = this.d;
        return n10 + c10;
    }

    public String toString() {
        StringBuilder stringBuilder = j$.e.a.a.a.a.b("DecimalStyle[");
        char c10 = this.a;
        stringBuilder.append(c10);
        c10 = this.b;
        stringBuilder.append(c10);
        c10 = this.c;
        stringBuilder.append(c10);
        c10 = this.d;
        stringBuilder.append(c10);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}

