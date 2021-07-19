/*
 * Decompiled with CFR 0.151.
 */
package c.a.l;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;

public final class b {
    private static final int a = 0x40000000;

    private b() {
    }

    private static int a(int n10) {
        int n11 = 3;
        if (n10 < n11) {
            return n10 + 1;
        }
        n11 = 0x40000000;
        if (n10 < n11) {
            return (int)((float)n10 / 0.75f + 1.0f);
        }
        return -1 >>> 1;
    }

    public static boolean b(List list) {
        int n10 = list.size();
        boolean bl2 = false;
        int n11 = 2;
        if (n10 < n11) {
            return false;
        }
        HashSet hashSet = new HashSet(list);
        int n12 = list.size();
        if (n12 != (n10 = hashSet.size())) {
            bl2 = true;
        }
        return bl2;
    }

    public static HashSet c(int n10) {
        n10 = b.a(n10);
        HashSet hashSet = new HashSet(n10);
        return hashSet;
    }

    public static LinkedHashMap d(int n10) {
        n10 = b.a(n10);
        LinkedHashMap linkedHashMap = new LinkedHashMap(n10);
        return linkedHashMap;
    }

    public static List e(int n10) {
        if (n10 == 0) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList(n10);
        return arrayList;
    }
}

