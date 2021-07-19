/*
 * Decompiled with CFR 0.151.
 */
package i.a.a;

import i.a.a.c;
import java.util.Comparator;

public class e
implements Comparator {
    public int a(c c10, c c11) {
        int n10 = c11.size();
        int n11 = c10.size();
        if ((n10 -= n11) == 0) {
            int n12 = c10.getStart();
            int n13 = c11.getStart();
            n10 = n12 - n13;
        }
        return n10;
    }
}

