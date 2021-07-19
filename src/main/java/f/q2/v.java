/*
 * Decompiled with CFR 0.151.
 */
package f.q2;

import f.h2.s.l;
import f.h2.t.f0;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.SortedSet;
import java.util.TreeSet;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.StringsKt___StringsKt;

public class v
extends StringsKt__StringsKt {
    private static final char H5(CharSequence charSequence, int n10) {
        return charSequence.charAt(n10);
    }

    private static final BigDecimal I5(CharSequence charSequence, l l10) {
        int n10;
        long l11 = 0;
        BigDecimal bigDecimal = BigDecimal.valueOf(l11);
        Object object = "BigDecimal.valueOf(this.toLong())";
        f0.o(bigDecimal, (String)object);
        for (int i10 = 0; i10 < (n10 = charSequence.length()); ++i10) {
            n10 = charSequence.charAt(i10);
            object = Character.valueOf((char)n10);
            object = (BigDecimal)l10.invoke(object);
            bigDecimal = bigDecimal.add((BigDecimal)object);
            object = "this.add(other)";
            f0.o(bigDecimal, (String)object);
        }
        return bigDecimal;
    }

    private static final BigInteger J5(CharSequence charSequence, l l10) {
        int n10;
        long l11 = 0;
        BigInteger bigInteger = BigInteger.valueOf(l11);
        Object object = "BigInteger.valueOf(this.toLong())";
        f0.o(bigInteger, (String)object);
        for (int i10 = 0; i10 < (n10 = charSequence.length()); ++i10) {
            n10 = charSequence.charAt(i10);
            object = Character.valueOf((char)n10);
            object = (BigInteger)l10.invoke(object);
            bigInteger = bigInteger.add((BigInteger)object);
            object = "this.add(other)";
            f0.o(bigInteger, (String)object);
        }
        return bigInteger;
    }

    public static final SortedSet K5(CharSequence charSequence) {
        f0.p(charSequence, "$this$toSortedSet");
        TreeSet treeSet = new TreeSet();
        return (SortedSet)StringsKt___StringsKt.J8(charSequence, treeSet);
    }
}

