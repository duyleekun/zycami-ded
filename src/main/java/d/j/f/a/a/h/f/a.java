/*
 * Decompiled with CFR 0.151.
 */
package d.j.f.a.a.h.f;

import d.j.f.a.a.h.f.c;
import d.j.f.a.a.h.f.g;

public class a {
    private static final String a = "a";
    private static final int b = 16;
    private static final int c = 16;
    private static final int d = 10000;

    private static int a(int n10, int n11, int n12) {
        if (n11 < n10) {
            n10 = n11;
        }
        if (n12 >= n10) {
            n12 = n10;
        }
        return n12;
    }

    private static boolean b(int n10) {
        int n11 = 16;
        n10 = n10 >= n11 ? 1 : 0;
        return n10 != 0;
    }

    private static boolean c(int n10, byte[] byArray) {
        n10 = (int)(d.j.f.a.a.h.f.a.b(n10) ? 1 : 0);
        int n11 = d.j.f.a.a.h.f.a.d(byArray);
        return (n10 & n11) != 0;
    }

    private static boolean d(byte[] byArray) {
        boolean bl2 = byArray.length;
        boolean bl3 = 16 != 0;
        if (bl2 >= bl3) {
            bl2 = true;
        } else {
            bl2 = false;
            byArray = null;
        }
        return bl2;
    }

    public static String e(String string2, String string3, String string4, byte[] byArray, int n10, boolean bl2) {
        return d.j.f.a.a.h.f.c.b(d.j.f.a.a.h.f.a.g(string2, string3, string4, byArray, n10, bl2));
    }

    public static byte[] f(String string2, String string3, String string4, String string5, int n10, boolean bl2) {
        byte[] byArray = d.j.f.a.a.h.f.c.c(string5);
        return d.j.f.a.a.h.f.a.g(string2, string3, string4, byArray, n10, bl2);
    }

    public static byte[] g(String object, String object2, String object3, byte[] byArray, int n10, boolean bl2) {
        object = d.j.f.a.a.h.f.c.c((String)object);
        object2 = d.j.f.a.a.h.f.c.c((String)object2);
        object3 = d.j.f.a.a.h.f.c.c((String)object3);
        int n11 = ((Object)object).length;
        int n12 = ((Object)object2).length;
        int n13 = ((Object)object3).length;
        if ((n12 = (int)(d.j.f.a.a.h.f.a.c(n11 = d.j.f.a.a.h.f.a.a(n11, n12, n13), byArray) ? 1 : 0)) != 0) {
            char[] cArray = new char[n11];
            for (n13 = 0; n13 < n11; ++n13) {
                Object object4 = object[n13];
                Object object5 = object2[n13];
                object4 = object4 ^ object5;
                object5 = object3[n13];
                object4 = (char)(object4 ^ object5);
                cArray[n13] = (char)object4;
            }
            int n14 = 10000;
            if (!bl2) {
                g.d(a, "exportRootKey: sha1");
                return d.j.f.a.a.h.c.c.c(cArray, byArray, n14, n10 *= 8);
            }
            g.d(a, "exportRootKey: sha256");
            return d.j.f.a.a.h.c.c.j(cArray, byArray, n14, n10 *= 8);
        }
        object = new IllegalArgumentException("key length must be more than 128bit.");
        throw object;
    }

    public static byte[] h(String string2, String string3, String string4, byte[] byArray, boolean bl2) {
        return d.j.f.a.a.h.f.a.g(string2, string3, string4, byArray, 16, bl2);
    }
}

