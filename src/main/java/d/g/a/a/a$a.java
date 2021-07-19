/*
 * Decompiled with CFR 0.151.
 */
package d.g.a.a;

import i.a.b.a;
import java.util.Comparator;

public final class a$a
implements Comparator {
    public int a(a a10, a a11) {
        int n10 = a10.getStart();
        int n11 = a11.getStart();
        int n12 = 0;
        int n13 = 1;
        int n14 = -1;
        if (n10 == n11) {
            n10 = a10.size();
            if (n10 < (n11 = a11.size())) {
                n12 = n13;
            } else {
                int n15;
                int n16 = a10.size();
                if (n16 != (n15 = a11.size())) {
                    n12 = n14;
                }
            }
            return n12;
        }
        n10 = a10.getStart();
        if (n10 < (n11 = a11.getStart())) {
            n12 = n14;
        } else {
            int n17;
            int n18 = a10.getStart();
            if (n18 != (n17 = a11.getStart())) {
                n12 = n13;
            }
        }
        return n12;
    }
}

