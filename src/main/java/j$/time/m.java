/*
 * Decompiled with CFR 0.151.
 */
package j$.time;

import j$.time.k;
import j$.time.r.c;
import j$.time.r.d;
import j$.time.r.g;
import java.io.Serializable;

final class m
extends k
implements Serializable {
    private final String b;
    private final transient c c;

    m(String string2, c c10) {
        this.b = string2;
        this.c = c10;
    }

    static m C(String string2, boolean bl2) {
        int n10 = string2.length();
        String string3 = "Invalid ID for region-based ZoneId, invalid format: ";
        int n11 = 2;
        if (n10 >= n11) {
            d d102;
            block5: {
                for (n11 = 0; n11 < n10; ++n11) {
                    int n12;
                    int n13 = string2.charAt(n11);
                    if (n13 >= (n12 = 97) && n13 <= (n12 = 122) || n13 >= (n12 = 65) && n13 <= (n12 = 90) || n13 == (n12 = 47) && n11 != 0 || n13 >= (n12 = 48) && n13 <= (n12 = 57) && n11 != 0 || n13 == (n12 = 126) && n11 != 0 || n13 == (n12 = 46) && n11 != 0 || n13 == (n12 = 95) && n11 != 0 || n13 == (n12 = 43) && n11 != 0 || n13 == (n12 = 45) && n11 != 0) {
                        continue;
                    }
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(string3);
                    stringBuilder.append(string2);
                    string2 = stringBuilder.toString();
                    j$.time.c c10 = new j$.time.c(string2);
                    throw c10;
                }
                n10 = 0;
                c c11 = null;
                boolean bl3 = true;
                try {
                    c11 = g.a(string2, bl3);
                }
                catch (d d102) {
                    if (bl2) break block5;
                }
                m m10 = new m(string2, c11);
                return m10;
            }
            throw d102;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string3);
        stringBuilder.append(string2);
        string2 = stringBuilder.toString();
        j$.time.c c12 = new j$.time.c(string2);
        throw c12;
    }

    public c m() {
        c c10 = this.c;
        if (c10 == null) {
            c10 = g.a(this.b, false);
        }
        return c10;
    }

    public String q() {
        return this.b;
    }
}

