/*
 * Decompiled with CFR 0.151.
 */
package d.g.a.a;

import d.g.a.a.a;
import d.g.a.a.c$b;
import d.g.a.a.d;
import d.g.a.a.e;
import d.g.a.a.f;
import d.g.a.a.g;
import d.g.a.a.h;
import d.g.a.a.j;
import d.g.a.a.k;
import d.g.a.a.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public final class c {
    public static i.a.b.f a;
    public static k b;
    public static List c;

    private c() {
    }

    public static void a(h object) {
        int n10;
        Object object2;
        if (object != null && (object2 = object.a()) != null && (n10 = (object2 = object.a()).size()) != 0) {
            List list = c;
            object2 = new c$b(list, null);
            object = ((c$b)object2).d((h)object);
            d.g.a.a.c.d((c$b)object);
        }
    }

    private static short b(byte[] byArray, byte[] byArray2, int n10) {
        int n11 = n10 / 8;
        int n12 = n10 % 8;
        short s10 = (short)(byArray2[n10] & 0xFF);
        int n13 = byArray[n11];
        int[] nArray = g.g;
        n10 = nArray[n12];
        if ((n13 &= n10) != 0) {
            n13 = s10 | 0x100;
            s10 = (short)n13;
        }
        return s10;
    }

    private static int c(char c10) {
        c10 = (char)(c10 + -19968);
        char c11 = '\u1b58';
        if (c10 >= '\u0000' && c10 < c11) {
            byte[] byArray = d.a;
            byte[] byArray2 = d.b;
            return d.g.a.a.c.b(byArray, byArray2, c10);
        }
        char c12 = '\u36b0';
        if (c11 <= c10 && c10 < c12) {
            byte[] byArray = e.a;
            byte[] byArray3 = e.b;
            c10 = (char)(c10 - c11);
            return d.g.a.a.c.b(byArray, byArray3, c10);
        }
        byte[] byArray = f.a;
        byte[] byArray4 = f.b;
        c10 = (char)(c10 - c12);
        return d.g.a.a.c.b(byArray, byArray4, c10);
    }

    public static void d(c$b c$b) {
        if (c$b == null) {
            c = null;
            a = null;
            b = null;
            return;
        }
        boolean bl2 = c$b.c();
        if (!bl2) {
            return;
        }
        c = Collections.unmodifiableList(c$b.a());
        a = l.a(c$b.a());
        b = c$b.b();
    }

    public static boolean e(char n10) {
        int n11 = 19968;
        n10 = n11 <= n10 && n10 <= (n11 = 40869) && (n11 = d.g.a.a.c.c((char)n10)) > 0 || (n11 = 12295) == n10 ? 1 : 0;
        return n10 != 0;
    }

    public static c$b f() {
        c$b c$b = new c$b(null, null);
        return c$b;
    }

    public static String g(char c10) {
        char c11 = d.g.a.a.c.e(c10);
        if (c11 != '\u0000') {
            c11 = '\u3007';
            if (c10 == c11) {
                return "LING";
            }
            String[] stringArray = g.i;
            c10 = (char)d.g.a.a.c.c(c10);
            return stringArray[c10];
        }
        return String.valueOf(c10);
    }

    public static String h(char c10, j j10) {
        String string2;
        if (j10 != null && (string2 = j10.d(c10)) != null) {
            return j10.d(c10);
        }
        return d.g.a.a.c.g(c10);
    }

    public static String i(String string2, String string3) {
        i.a.b.f f10 = a;
        List list = c;
        k k10 = b;
        return d.g.a.a.a.c(string2, f10, list, string3, k10);
    }

    public static String j(String string2, String string3, j object) {
        if (object != null) {
            ArrayList<Object> arrayList = new ArrayList<Object>();
            object = ((j)object).e();
            arrayList.add(object);
            object = c;
            if (object != null) {
                arrayList.addAll((Collection<Object>)object);
            }
            object = new c$b(arrayList, null);
            return d.g.a.a.a.b(string2, (c$b)object, string3);
        }
        return d.g.a.a.c.i(string2, string3);
    }
}

