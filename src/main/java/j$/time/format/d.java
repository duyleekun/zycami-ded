/*
 * Decompiled with CFR 0.151.
 */
package j$.time.format;

import j$.e.a.a.a.a;
import j$.time.format.f;
import j$.time.format.v;

final class d
implements f {
    private final char a;

    d(char c10) {
        this.a = c10;
    }

    public boolean m(v v10, StringBuilder stringBuilder) {
        char c10 = this.a;
        stringBuilder.append(c10);
        return true;
    }

    public String toString() {
        char c10 = this.a;
        char c11 = '\'';
        if (c10 == c11) {
            return "''";
        }
        String string2 = "'";
        StringBuilder stringBuilder = j$.e.a.a.a.a.b(string2);
        char c12 = this.a;
        stringBuilder.append(c12);
        stringBuilder.append(string2);
        return stringBuilder.toString();
    }
}

