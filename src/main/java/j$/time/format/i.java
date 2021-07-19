/*
 * Decompiled with CFR 0.151.
 */
package j$.time.format;

import j$.e.a.a.a.a;
import j$.time.format.C;
import j$.time.format.f;
import j$.time.format.v;
import j$.time.q.h;
import j$.time.q.u;

final class i
implements f {
    private final C a;

    i(C c10) {
        this.a = c10;
    }

    private static StringBuilder a(StringBuilder stringBuilder, int n10) {
        char c10 = (char)(n10 / 10 + 48);
        stringBuilder.append(c10);
        n10 = (char)(n10 % 10 + 48);
        stringBuilder.append((char)n10);
        return stringBuilder;
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     */
    public boolean m(v object, StringBuilder stringBuilder) {
        void var1_5;
        void var2_7;
        Object object2 = h.H;
        Long l10 = ((v)object).e((u)object2);
        if (l10 == null) {
            return false;
        }
        object2 = "GMT";
        var2_7.append((String)object2);
        long l11 = l10;
        int n10 = Math.toIntExact(l11);
        if (n10 == 0) return true;
        int n11 = Math.abs(n10 / 3600 % 100);
        int n12 = Math.abs(n10 / 60 % 60);
        int n13 = Math.abs(n10 % 60);
        if (n10 < 0) {
            String string2 = "-";
        } else {
            String string3 = "+";
        }
        var2_7.append((String)var1_5);
        C c10 = this.a;
        C c11 = C.b;
        char c12 = ':';
        if (c10 == c11) {
            i.a((StringBuilder)var2_7, n11);
            var2_7.append(c12);
            i.a((StringBuilder)var2_7, n12);
            if (n13 == 0) return true;
        } else {
            int n14 = 10;
            if (n11 >= n14) {
                char c13 = (char)(n11 / 10 + 48);
                var2_7.append(c13);
            }
            n11 = n11 % n14 + 48;
            char c14 = (char)n11;
            var2_7.append(c14);
            if (n12 == 0) {
                if (n13 == 0) return true;
            }
            var2_7.append(c12);
            i.a((StringBuilder)var2_7, n12);
            if (n13 == 0) return true;
        }
        var2_7.append(c12);
        i.a((StringBuilder)var2_7, n13);
        return true;
    }

    public String toString() {
        StringBuilder stringBuilder = j$.e.a.a.a.a.b("LocalizedOffset(");
        C c10 = this.a;
        stringBuilder.append((Object)c10);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}

