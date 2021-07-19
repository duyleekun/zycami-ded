/*
 * Decompiled with CFR 0.151.
 */
package j$.time.format;

import j$.e.a.a.a.a;
import j$.time.format.f;
import j$.time.format.v;
import j$.time.q.h;
import java.util.Objects;

final class k
implements f {
    static final String[] c;
    static final k d;
    private final String a;
    private final int b;

    static {
        k k10;
        c = new String[]{"+HH", "+HHmm", "+HH:mm", "+HHMM", "+HH:MM", "+HHMMss", "+HH:MM:ss", "+HHMMSS", "+HH:MM:SS"};
        String string2 = "+HH:MM:ss";
        d = k10 = new k(string2, "Z");
        new k(string2, "0");
    }

    k(String string2, String object) {
        Object object2;
        int n10;
        Objects.requireNonNull(string2, "pattern");
        Objects.requireNonNull(object, "noOffsetText");
        StringBuilder stringBuilder = null;
        for (int i10 = 0; i10 < (n10 = ((String[])(object2 = c)).length); ++i10) {
            boolean bl2 = ((String)(object2 = object2[i10])).equals(string2);
            if (!bl2) continue;
            this.b = i10;
            this.a = object;
            return;
        }
        stringBuilder = new StringBuilder();
        stringBuilder.append("Invalid zone offset pattern: ");
        stringBuilder.append(string2);
        string2 = stringBuilder.toString();
        object = new IllegalArgumentException(string2);
        throw object;
    }

    /*
     * Enabled aggressive block sorting
     */
    public boolean m(v object, StringBuilder stringBuilder) {
        h h10 = h.H;
        if ((object = ((v)object).e(h10)) == null) {
            return false;
        }
        long l10 = (Long)object;
        int n10 = Math.toIntExact(l10);
        int n11 = 1;
        if (n10 != 0) {
            int n12 = Math.abs(n10 / 3600 % 100);
            int n13 = Math.abs(n10 / 60 % 60);
            int n14 = Math.abs(n10 % 60);
            int n15 = stringBuilder.length();
            object = n10 < 0 ? "-" : "+";
            stringBuilder.append((String)object);
            char c10 = (char)(n12 / 10 + 48);
            stringBuilder.append(c10);
            char c11 = (char)(n12 % 10 + 48);
            stringBuilder.append(c11);
            int n16 = this.b;
            int n17 = 3;
            if (n16 >= n17 || n16 >= n11 && n13 > 0) {
                int n18 = n16 % 2;
                String string2 = ":";
                String string3 = "";
                object = n18 == 0 ? string2 : string3;
                stringBuilder.append((String)object);
                char c12 = (char)(n13 / 10 + 48);
                stringBuilder.append(c12);
                char c13 = (char)(n13 % 10 + 48);
                stringBuilder.append(c13);
                n12 += n13;
                int n19 = this.b;
                n13 = 7;
                if (n19 >= n13 || n19 >= (n13 = 5) && n14 > 0) {
                    int n20 = n19 % 2;
                    if (n20 != 0) {
                        string2 = string3;
                    }
                    stringBuilder.append(string2);
                    char c14 = (char)(n14 / 10 + 48);
                    stringBuilder.append(c14);
                    char c15 = (char)(n14 % 10 + 48);
                    stringBuilder.append(c15);
                    n12 += n14;
                }
            }
            if (n12 != 0) return n11 != 0;
            stringBuilder.setLength(n15);
        }
        object = this.a;
        stringBuilder.append((String)object);
        return n11 != 0;
    }

    public String toString() {
        String string2 = this.a.replace("'", "''");
        StringBuilder stringBuilder = j$.e.a.a.a.a.b("Offset(");
        Object object = c;
        int n10 = this.b;
        object = object[n10];
        stringBuilder.append((String)object);
        stringBuilder.append(",'");
        stringBuilder.append(string2);
        stringBuilder.append("')");
        return stringBuilder.toString();
    }
}

