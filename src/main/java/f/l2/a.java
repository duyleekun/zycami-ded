/*
 * Decompiled with CFR 0.151.
 */
package f.l2;

import f.d2.m;
import f.h2.t.f0;
import f.l2.a$a;
import f.l2.b;
import f.x1.r;

public class a
implements Iterable,
f.h2.t.x0.a {
    public static final a$a d;
    private final char a;
    private final char b;
    private final int c;

    static {
        a$a a$a;
        d = a$a = new a$a(null);
    }

    public a(char c10, char c11, int n10) {
        if (n10 != 0) {
            int n11 = -1 << -1;
            if (n10 != n11) {
                this.a = c10;
                this.b = c10 = (char)m.c(c10, c11, n10);
                this.c = n10;
                return;
            }
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
            throw illegalArgumentException;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Step must be non-zero.");
        throw illegalArgumentException;
    }

    public final char e() {
        return this.a;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean equals(Object object) {
        int n10 = object instanceof a;
        if (n10 == 0) return 0 != 0;
        n10 = this.isEmpty();
        if (n10 != 0) {
            Object object2 = object;
            object2 = (a)object;
            n10 = (int)(((a)object2).isEmpty() ? 1 : 0);
            if (n10 != 0) return 1 != 0;
        }
        n10 = this.a;
        object = (a)object;
        char c10 = ((a)object).a;
        if (n10 != c10) return 0 != 0;
        n10 = this.b;
        c10 = ((a)object).b;
        if (n10 != c10) return 0 != 0;
        n10 = this.c;
        int n11 = ((a)object).c;
        if (n10 != n11) return 0 != 0;
        return 1 != 0;
    }

    public final char f() {
        return this.b;
    }

    public final int g() {
        return this.c;
    }

    public r h() {
        char c10 = this.a;
        char c11 = this.b;
        int n10 = this.c;
        b b10 = new b(c10, c11, n10);
        return b10;
    }

    public int hashCode() {
        int n10 = this.isEmpty();
        if (n10 != 0) {
            n10 = -1;
        } else {
            n10 = this.a * 31;
            int n11 = this.b;
            n10 = (n10 + n11) * 31;
            n11 = this.c;
            n10 += n11;
        }
        return n10;
    }

    public boolean isEmpty() {
        boolean bl2;
        block4: {
            block3: {
                int n10;
                block2: {
                    n10 = this.c;
                    bl2 = true;
                    if (n10 <= 0) break block2;
                    n10 = this.a;
                    char c10 = this.b;
                    if ((n10 = f0.t(n10, c10)) <= 0) break block3;
                    break block4;
                }
                n10 = this.a;
                char c11 = this.b;
                if ((n10 = f0.t(n10, c11)) < 0) break block4;
            }
            bl2 = false;
        }
        return bl2;
    }

    public String toString() {
        int n10;
        StringBuilder stringBuilder;
        int n11 = this.c;
        String string2 = " step ";
        if (n11 > 0) {
            stringBuilder = new StringBuilder();
            char c10 = this.a;
            stringBuilder.append(c10);
            String string3 = "..";
            stringBuilder.append(string3);
            c10 = this.b;
            stringBuilder.append(c10);
            stringBuilder.append(string2);
            n10 = this.c;
        } else {
            stringBuilder = new StringBuilder();
            char c11 = this.a;
            stringBuilder.append(c11);
            String string4 = " downTo ";
            stringBuilder.append(string4);
            c11 = this.b;
            stringBuilder.append(c11);
            stringBuilder.append(string2);
            n10 = -this.c;
        }
        stringBuilder.append(n10);
        return stringBuilder.toString();
    }
}

