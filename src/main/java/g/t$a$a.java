/*
 * Decompiled with CFR 0.151.
 */
package g;

import f.h2.t.f0;
import f.h2.t.u;
import g.t;
import g.t$b;

public final class t$a$a {
    private t$a$a() {
    }

    public /* synthetic */ t$a$a(u u10) {
        this();
    }

    public static final /* synthetic */ int a(t$a$a t$a$a, String string2, int n10, int n11) {
        return t$a$a.e(string2, n10, n11);
    }

    public static final /* synthetic */ int b(t$a$a t$a$a, String string2, int n10, int n11) {
        return t$a$a.f(string2, n10, n11);
    }

    public static final /* synthetic */ int c(t$a$a t$a$a, String string2, int n10, int n11) {
        return t$a$a.g(string2, n10, n11);
    }

    public static final /* synthetic */ int d(t$a$a t$a$a, String string2, int n10, int n11) {
        return t$a$a.h(string2, n10, n11);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private final int e(String string2, int n10, int n11) {
        int n12;
        int n13;
        String string3;
        Object object;
        int n14 = -1;
        try {
            object = t.w;
            string3 = "";
            n13 = 248;
            n12 = n10;
        }
        catch (NumberFormatException numberFormatException) {
            return n14;
        }
        object = t$b.f((t$b)object, string2, n10, n11, string3, false, false, false, false, null, n13, null);
        int n15 = Integer.parseInt((String)object);
        char c10 = (char)-1;
        n12 = 1;
        if (n12 <= n15) {
            if (c10 < n15) return n14;
            return n15;
        }
        return n14;
    }

    private final int f(String string2, int n10, int n11) {
        while (n10 < n11) {
            int n12;
            int n13 = string2.charAt(n10);
            if (n13 != (n12 = 58)) {
                n12 = 91;
                if (n13 == n12) {
                    while (++n10 < n11 && (n13 = (int)string2.charAt(n10)) != (n12 = 93)) {
                    }
                }
                ++n10;
                continue;
            }
            return n10;
        }
        return n11;
    }

    private final int g(String string2, int n10, int n11) {
        int n12 = n11 - n10;
        int n13 = -1;
        int n14 = 2;
        if (n12 < n14) {
            return n13;
        }
        n12 = string2.charAt(n10);
        n14 = 97;
        int n15 = f0.t(n12, n14);
        int n16 = 90;
        int n17 = 122;
        int n18 = 65;
        if (n15 >= 0 && (n15 = f0.t(n12, n17)) <= 0 || (n15 = f0.t(n12, n18)) >= 0 && (n12 = f0.t(n12, n16)) <= 0) {
            while (++n10 < n11) {
                n12 = string2.charAt(n10);
                if (n14 <= n12 && n17 >= n12 || n18 <= n12 && n16 >= n12) continue;
                n15 = 57;
                int n19 = 48;
                if (n19 <= n12 && n15 >= n12 || n12 == (n15 = 43) || n12 == (n15 = 45) || n12 == (n15 = 46)) continue;
                int n20 = 58;
                if (n12 != n20) break;
                n13 = n10;
                break;
            }
        }
        return n13;
    }

    private final int h(String string2, int n10, int n11) {
        int n12;
        int n13;
        int n14 = 0;
        while (n10 < n11 && ((n13 = string2.charAt(n10)) == (n12 = 92) || n13 == (n12 = 47))) {
            ++n14;
            ++n10;
        }
        return n14;
    }
}

