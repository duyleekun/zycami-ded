/*
 * Decompiled with CFR 0.151.
 */
package j$.time.format;

import j$.e.a.a.a.a;
import j$.time.format.f;
import j$.time.format.v;
import j$.time.format.z;
import j$.time.q.u;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

final class g
implements f {
    private final u a;
    private final int b;
    private final int c;
    private final boolean d;

    g(u object, int n10, int n11, boolean bl2) {
        Objects.requireNonNull(object, "field");
        j$.time.q.z z10 = object.x();
        int n12 = z10.f();
        if (n12 != 0) {
            if (n10 >= 0 && n10 <= (n12 = 9)) {
                int n13 = 1;
                if (n11 >= n13 && n11 <= n12) {
                    if (n11 >= n10) {
                        this.a = object;
                        this.b = n10;
                        this.c = n11;
                        this.d = bl2;
                        return;
                    }
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Maximum width must exceed or equal the minimum width but ");
                    stringBuilder.append(n11);
                    stringBuilder.append(" < ");
                    stringBuilder.append(n10);
                    String string2 = stringBuilder.toString();
                    object = new IllegalArgumentException(string2);
                    throw object;
                }
                CharSequence charSequence = new StringBuilder();
                charSequence.append("Maximum width must be from 1 to 9 inclusive but was ");
                charSequence.append(n11);
                charSequence = charSequence.toString();
                object = new IllegalArgumentException((String)charSequence);
                throw object;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Minimum width must be from 0 to 9 inclusive but was ");
            stringBuilder.append(n10);
            String string3 = stringBuilder.toString();
            object = new IllegalArgumentException(string3);
            throw object;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Field must have a fixed set of values: ");
        stringBuilder.append(object);
        object = stringBuilder.toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)object);
        throw illegalArgumentException;
    }

    public boolean m(v object, StringBuilder stringBuilder) {
        Object object2 = this.a;
        object2 = ((v)object).e((u)object2);
        int n10 = 0;
        if (object2 == null) {
            return false;
        }
        object = ((v)object).b();
        long l10 = (Long)object2;
        object2 = this.a.x();
        Object object3 = this.a;
        ((j$.time.q.z)object2).b(l10, (u)object3);
        long l11 = ((j$.time.q.z)object2).e();
        object3 = BigDecimal.valueOf(l11);
        long l12 = ((j$.time.q.z)object2).d();
        object2 = BigDecimal.valueOf(l12).subtract((BigDecimal)object3);
        BigDecimal bigDecimal = BigDecimal.ONE;
        object2 = ((BigDecimal)object2).add(bigDecimal);
        Object object4 = BigDecimal.valueOf(l10).subtract((BigDecimal)object3);
        RoundingMode roundingMode = RoundingMode.FLOOR;
        int n11 = 9;
        object2 = object4.divide((BigDecimal)object2, n11, roundingMode);
        object4 = BigDecimal.ZERO;
        int n12 = ((BigDecimal)object2).compareTo((BigDecimal)object4);
        object2 = n12 == 0 ? BigDecimal.ZERO : ((BigDecimal)object2).stripTrailingZeros();
        n12 = ((BigDecimal)object2).scale();
        if (n12 == 0) {
            int n13 = this.b;
            if (n13 > 0) {
                n13 = (int)(this.d ? 1 : 0);
                if (n13 != 0) {
                    n13 = ((z)object).b();
                    stringBuilder.append((char)n13);
                }
                while (n10 < (n13 = this.b)) {
                    n13 = ((z)object).e();
                    stringBuilder.append((char)n13);
                    ++n10;
                }
            }
        } else {
            n10 = ((BigDecimal)object2).scale();
            n12 = this.b;
            n10 = Math.max(n10, n12);
            n12 = this.c;
            n10 = Math.min(n10, n12);
            object4 = RoundingMode.FLOOR;
            object2 = ((BigDecimal)object2).setScale(n10, (RoundingMode)((Object)object4)).toPlainString().substring(2);
            object2 = ((z)object).a((String)object2);
            n10 = (int)(this.d ? 1 : 0);
            if (n10 != 0) {
                char c10 = ((z)object).b();
                stringBuilder.append(c10);
            }
            stringBuilder.append((String)object2);
        }
        return true;
    }

    public String toString() {
        boolean bl2 = this.d;
        String string2 = bl2 ? ",DecimalPoint" : "";
        StringBuilder stringBuilder = j$.e.a.a.a.a.b("Fraction(");
        Object object = this.a;
        stringBuilder.append(object);
        object = ",";
        stringBuilder.append((String)object);
        int n10 = this.b;
        stringBuilder.append(n10);
        stringBuilder.append((String)object);
        int n11 = this.c;
        stringBuilder.append(n11);
        stringBuilder.append(string2);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}

