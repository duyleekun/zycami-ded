/*
 * Decompiled with CFR 0.151.
 */
package androidx.core.provider;

import java.util.Comparator;

public class FontProvider$1
implements Comparator {
    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public int compare(byte[] byArray, byte[] byArray2) {
        int n10;
        int n11;
        int n12;
        int n13 = byArray.length;
        int n14 = byArray2.length;
        if (n13 != n14) {
            n12 = byArray.length;
            n11 = byArray2.length;
            return n12 - n11;
        }
        n13 = 0;
        for (n14 = 0; n14 < (n10 = byArray.length); ++n14) {
            n10 = byArray[n14];
            byte by2 = byArray2[n14];
            if (n10 == by2) continue;
            n12 = byArray[n14];
            n11 = byArray2[n14];
            return n12 - n11;
        }
        return 0;
    }
}

