/*
 * Decompiled with CFR 0.151.
 */
package d.v.k0.g;

import java.util.ArrayList;
import java.util.List;

public class c {
    public static int a(byte[] byArray, int n10) {
        int n11 = byArray.length % n10;
        int n12 = byArray.length / n10;
        if (n11 != 0) {
            ++n12;
        }
        return n12;
    }

    public static List b(byte[] byArray, int n10) {
        int n11;
        int n12 = byArray.length;
        int n13 = 1;
        if (n12 <= n10) {
            ArrayList<byte[]> arrayList = new ArrayList<byte[]>(n13);
            arrayList.add(byArray);
            return arrayList;
        }
        n12 = c.a(byArray, n10);
        ArrayList<byte[]> arrayList = new ArrayList<byte[]>(n12);
        for (int i10 = 0; i10 < (n11 = byArray.length); i10 += n10) {
            int n14;
            n11 = arrayList.size();
            if (n11 < (n14 = n12 + -1)) {
                n11 = n10;
            } else {
                n11 = byArray.length;
                n14 = arrayList.size() * n10;
                n11 -= n14;
            }
            byte[] byArray2 = new byte[n11];
            System.arraycopy(byArray, i10, byArray2, 0, n11);
            arrayList.add(byArray2);
        }
        return arrayList;
    }
}

