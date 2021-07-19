/*
 * Decompiled with CFR 0.151.
 */
package d.r.a.u;

import d.r.a.h$d;
import d.r.a.o;
import d.r.a.u.a0;

public final class v {
    public static int a(h$d object) {
        long l10;
        a0 a02 = a0.m();
        int n10 = ((o)object).a;
        long l11 = System.currentTimeMillis();
        String string2 = "com.vivo.push_preferences.operate.";
        CharSequence charSequence = new StringBuilder(string2);
        charSequence.append(n10);
        String string3 = "OPERATE_COUNT";
        charSequence.append(string3);
        charSequence = charSequence.toString();
        int n11 = a02.h((String)charSequence);
        CharSequence charSequence2 = new StringBuilder(string2);
        charSequence2.append(n10);
        String string4 = "START_TIME";
        charSequence2.append(string4);
        charSequence2 = charSequence2.toString();
        long l12 = 0L;
        long l13 = a02.i((String)charSequence2, l12);
        l11 -= l13;
        l13 = 86400000L;
        long l14 = l11 == l13 ? 0 : (l11 < l13 ? -1 : 1);
        int n12 = 1;
        if (l14 <= 0 && (l10 = l11 == l12 ? 0 : (l11 < l12 ? -1 : 1)) >= 0) {
            int n13 = ((h$d)object).g;
            if (n11 >= n13) {
                return 1001;
            }
            object = new StringBuilder(string2);
            ((StringBuilder)object).append(n10);
            ((StringBuilder)object).append(string3);
            object = ((StringBuilder)object).toString();
            a02.e((String)object, n11 += n12);
        } else {
            object = new StringBuilder(string2);
            ((StringBuilder)object).append(n10);
            ((StringBuilder)object).append(string4);
            object = ((StringBuilder)object).toString();
            l11 = System.currentTimeMillis();
            a02.f((String)object, l11);
            object = new StringBuilder(string2);
            ((StringBuilder)object).append(n10);
            ((StringBuilder)object).append(string3);
            object = ((StringBuilder)object).toString();
            a02.e((String)object, n12);
        }
        return 0;
    }
}

