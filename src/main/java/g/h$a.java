/*
 * Decompiled with CFR 0.151.
 */
package g;

import f.h2.t.f0;
import java.util.Comparator;

public final class h$a
implements Comparator {
    public int a(String string2, String string3) {
        int n10;
        int n11;
        int n12;
        f0.p(string2, "a");
        String string4 = "b";
        f0.p(string3, string4);
        int n13 = string2.length();
        int n14 = string3.length();
        n13 = Math.min(n13, n14);
        n14 = 4;
        while (true) {
            char c10;
            n12 = -1;
            n11 = 1;
            if (n14 >= n13) break;
            char c11 = string2.charAt(n14);
            if (c11 != (c10 = string3.charAt(n14))) {
                int n15 = f0.t(c11, c10);
                if (n15 >= 0) {
                    n12 = n11;
                }
                return n12;
            }
            ++n14;
        }
        int n16 = string2.length();
        if (n16 != (n10 = string3.length())) {
            if (n16 >= n10) {
                n12 = n11;
            }
            return n12;
        }
        return 0;
    }
}

