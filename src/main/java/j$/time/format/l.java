/*
 * Decompiled with CFR 0.151.
 */
package j$.time.format;

import j$.e.a.a.a.a;
import j$.time.c;
import j$.time.format.f;
import j$.time.format.v;

final class l
implements f {
    private final f a;
    private final int b;
    private final char c;

    l(f f10, int n10, char c10) {
        this.a = f10;
        this.b = n10;
        this.c = c10;
    }

    public boolean m(v object, StringBuilder serializable) {
        int n10;
        int n11 = ((StringBuilder)serializable).length();
        int n12 = this.a.m((v)object, (StringBuilder)serializable);
        if (n12 == 0) {
            return false;
        }
        n12 = ((StringBuilder)serializable).length() - n11;
        if (n12 <= (n10 = this.b)) {
            for (int i10 = 0; i10 < (n10 = this.b - n12); ++i10) {
                n10 = this.c;
                ((StringBuilder)serializable).insert(n11, (char)n10);
            }
            return true;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Cannot print as output of ");
        stringBuilder.append(n12);
        stringBuilder.append(" characters exceeds pad width of ");
        n12 = this.b;
        stringBuilder.append(n12);
        object = stringBuilder.toString();
        serializable = new c((String)object);
        throw serializable;
    }

    public String toString() {
        StringBuilder stringBuilder = j$.e.a.a.a.a.b("Pad(");
        Object object = this.a;
        stringBuilder.append(object);
        object = ",";
        stringBuilder.append((String)object);
        int c10 = this.b;
        stringBuilder.append(c10);
        char c11 = this.c;
        char c12 = ' ';
        if (c11 == c12) {
            object = ")";
        } else {
            object = j$.e.a.a.a.a.b(",'");
            c12 = this.c;
            ((StringBuilder)object).append(c12);
            String string2 = "')";
            ((StringBuilder)object).append(string2);
            object = ((StringBuilder)object).toString();
        }
        stringBuilder.append((String)object);
        return stringBuilder.toString();
    }
}

