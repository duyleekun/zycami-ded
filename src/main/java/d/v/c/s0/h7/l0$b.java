/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 */
package d.v.c.s0.h7;

import android.text.TextUtils;
import d.v.c.s0.h7.l0$a;
import d.v.e.h.d;
import d.v.e.h.e;

public class l0$b {
    private static final String d = "_";
    private static final int e = 3;
    public int a;
    public int b;
    public long c;

    private l0$b() {
    }

    private l0$b(int n10, int n11, long l10) {
        this.a = n10;
        this.b = n11;
        this.c = l10;
    }

    public /* synthetic */ l0$b(int n10, int n11, long l10, l0$a l0$a) {
        this(n10, n11, l10);
    }

    public /* synthetic */ l0$b(l0$a l0$a) {
        this();
    }

    public static /* synthetic */ l0$b a(l0$b l0$b, String string2) {
        return l0$b.b(string2);
    }

    private l0$b b(String stringArray) {
        long l10;
        int n10;
        int n11 = TextUtils.isEmpty((CharSequence)stringArray);
        if (n11 != 0) {
            return null;
        }
        String string2 = d;
        n11 = (stringArray = stringArray.split(string2)).length;
        if (n11 != (n10 = 3)) {
            return null;
        }
        this.a = n11 = d.v.e.h.d.a(stringArray[0]);
        this.b = n11 = d.v.e.h.d.a(stringArray[1]);
        this.c = l10 = d.v.e.h.e.a(stringArray[2]).longValue();
        return this;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        int n10 = this.a;
        stringBuilder.append(n10);
        String string2 = d;
        stringBuilder.append(string2);
        int n11 = this.b;
        stringBuilder.append(n11);
        stringBuilder.append(string2);
        long l10 = this.c;
        stringBuilder.append(l10);
        return stringBuilder.toString();
    }
}

