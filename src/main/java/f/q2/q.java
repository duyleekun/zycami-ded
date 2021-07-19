/*
 * Decompiled with CFR 0.151.
 */
package f.q2;

import f.h2.t.f0;
import f.q2.p;
import f.q2.w;

public class q
extends p {
    private static final StringBuilder A(StringBuilder stringBuilder, long l10) {
        stringBuilder.append(l10);
        f0.o(stringBuilder, "append(value)");
        stringBuilder.append('\n');
        f0.o(stringBuilder, "append('\\n')");
        return stringBuilder;
    }

    private static final StringBuilder B(StringBuilder stringBuilder, StringBuffer stringBuffer) {
        stringBuilder.append(stringBuffer);
        f0.o(stringBuilder, "append(value)");
        stringBuilder.append('\n');
        f0.o(stringBuilder, "append('\\n')");
        return stringBuilder;
    }

    private static final StringBuilder C(StringBuilder stringBuilder, StringBuilder stringBuilder2) {
        stringBuilder.append((CharSequence)stringBuilder2);
        f0.o(stringBuilder, "append(value)");
        stringBuilder.append('\n');
        f0.o(stringBuilder, "append('\\n')");
        return stringBuilder;
    }

    private static final StringBuilder D(StringBuilder stringBuilder, short s10) {
        stringBuilder.append(s10);
        f0.o(stringBuilder, "append(value.toInt())");
        stringBuilder.append('\n');
        f0.o(stringBuilder, "append('\\n')");
        return stringBuilder;
    }

    private static final StringBuilder E(StringBuilder stringBuilder, CharSequence charSequence, int n10, int n11) {
        stringBuilder.append(charSequence, n10, n11);
        f0.o(stringBuilder, "this.append(value, startIndex, endIndex)");
        return stringBuilder;
    }

    private static final StringBuilder F(StringBuilder stringBuilder, char[] cArray, int n10, int n11) {
        stringBuilder.append(cArray, n10, n11 -= n10);
        f0.o(stringBuilder, "this.append(value, start\u2026x, endIndex - startIndex)");
        return stringBuilder;
    }

    public static final Appendable G(Appendable appendable) {
        f0.p(appendable, "$this$appendln");
        String string2 = w.a;
        appendable = appendable.append(string2);
        f0.o(appendable, "append(SystemProperties.LINE_SEPARATOR)");
        return appendable;
    }

    private static final Appendable H(Appendable appendable, char c10) {
        appendable = appendable.append(c10);
        f0.o(appendable, "append(value)");
        return q.G(appendable);
    }

    private static final Appendable I(Appendable appendable, CharSequence charSequence) {
        appendable = appendable.append(charSequence);
        f0.o(appendable, "append(value)");
        return q.G(appendable);
    }

    public static final StringBuilder J(StringBuilder stringBuilder) {
        f0.p(stringBuilder, "$this$appendln");
        String string2 = w.a;
        stringBuilder.append(string2);
        f0.o(stringBuilder, "append(SystemProperties.LINE_SEPARATOR)");
        return stringBuilder;
    }

    private static final StringBuilder K(StringBuilder stringBuilder, byte by2) {
        stringBuilder.append(by2);
        f0.o(stringBuilder, "append(value.toInt())");
        return q.J(stringBuilder);
    }

    private static final StringBuilder L(StringBuilder stringBuilder, char c10) {
        stringBuilder.append(c10);
        f0.o(stringBuilder, "append(value)");
        return q.J(stringBuilder);
    }

    private static final StringBuilder M(StringBuilder stringBuilder, double d10) {
        stringBuilder.append(d10);
        f0.o(stringBuilder, "append(value)");
        return q.J(stringBuilder);
    }

    private static final StringBuilder N(StringBuilder stringBuilder, float f10) {
        stringBuilder.append(f10);
        f0.o(stringBuilder, "append(value)");
        return q.J(stringBuilder);
    }

    private static final StringBuilder O(StringBuilder stringBuilder, int n10) {
        stringBuilder.append(n10);
        f0.o(stringBuilder, "append(value)");
        return q.J(stringBuilder);
    }

    private static final StringBuilder P(StringBuilder stringBuilder, long l10) {
        stringBuilder.append(l10);
        f0.o(stringBuilder, "append(value)");
        return q.J(stringBuilder);
    }

    private static final StringBuilder Q(StringBuilder stringBuilder, CharSequence charSequence) {
        stringBuilder.append(charSequence);
        f0.o(stringBuilder, "append(value)");
        return q.J(stringBuilder);
    }

    private static final StringBuilder R(StringBuilder stringBuilder, Object object) {
        stringBuilder.append(object);
        f0.o(stringBuilder, "append(value)");
        return q.J(stringBuilder);
    }

    private static final StringBuilder S(StringBuilder stringBuilder, String string2) {
        stringBuilder.append(string2);
        f0.o(stringBuilder, "append(value)");
        return q.J(stringBuilder);
    }

    private static final StringBuilder T(StringBuilder stringBuilder, StringBuffer stringBuffer) {
        stringBuilder.append(stringBuffer);
        f0.o(stringBuilder, "append(value)");
        return q.J(stringBuilder);
    }

    private static final StringBuilder U(StringBuilder stringBuilder, StringBuilder stringBuilder2) {
        stringBuilder.append((CharSequence)stringBuilder2);
        f0.o(stringBuilder, "append(value)");
        return q.J(stringBuilder);
    }

    private static final StringBuilder V(StringBuilder stringBuilder, short s10) {
        stringBuilder.append(s10);
        f0.o(stringBuilder, "append(value.toInt())");
        return q.J(stringBuilder);
    }

    private static final StringBuilder W(StringBuilder stringBuilder, boolean bl2) {
        stringBuilder.append(bl2);
        f0.o(stringBuilder, "append(value)");
        return q.J(stringBuilder);
    }

    private static final StringBuilder X(StringBuilder stringBuilder, char[] cArray) {
        stringBuilder.append(cArray);
        f0.o(stringBuilder, "append(value)");
        return q.J(stringBuilder);
    }

    public static final StringBuilder Y(StringBuilder stringBuilder) {
        f0.p(stringBuilder, "$this$clear");
        stringBuilder.setLength(0);
        return stringBuilder;
    }

    private static final StringBuilder Z(StringBuilder stringBuilder, int n10) {
        stringBuilder = stringBuilder.deleteCharAt(n10);
        f0.o(stringBuilder, "this.deleteCharAt(index)");
        return stringBuilder;
    }

    private static final StringBuilder a0(StringBuilder stringBuilder, int n10, int n11) {
        stringBuilder = stringBuilder.delete(n10, n11);
        f0.o(stringBuilder, "this.delete(startIndex, endIndex)");
        return stringBuilder;
    }

    private static final StringBuilder b0(StringBuilder stringBuilder, int n10, CharSequence charSequence, int n11, int n12) {
        stringBuilder = stringBuilder.insert(n10, charSequence, n11, n12);
        f0.o(stringBuilder, "this.insert(index, value, startIndex, endIndex)");
        return stringBuilder;
    }

    private static final StringBuilder c0(StringBuilder stringBuilder, int n10, char[] cArray, int n11, int n12) {
        stringBuilder = stringBuilder.insert(n10, cArray, n11, n12 -= n11);
        f0.o(stringBuilder, "this.insert(index, value\u2026x, endIndex - startIndex)");
        return stringBuilder;
    }

    private static final void d0(StringBuilder stringBuilder, int n10, char c10) {
        f0.p(stringBuilder, "$this$set");
        stringBuilder.setCharAt(n10, c10);
    }

    private static final StringBuilder e0(StringBuilder stringBuilder, int n10, int n11, String string2) {
        stringBuilder = stringBuilder.replace(n10, n11, string2);
        f0.o(stringBuilder, "this.replace(startIndex, endIndex, value)");
        return stringBuilder;
    }

    private static final void f0(StringBuilder stringBuilder, char[] cArray, int n10, int n11, int n12) {
        stringBuilder.getChars(n11, n12, cArray, n10);
    }

    public static /* synthetic */ void g0(StringBuilder stringBuilder, char[] cArray, int n10, int n11, int n12, int n13, Object object) {
        int n14 = n13 & 2;
        if (n14 != 0) {
            n10 = 0;
        }
        if ((n14 = n13 & 4) != 0) {
            n11 = 0;
        }
        if ((n13 &= 8) != 0) {
            n12 = stringBuilder.length();
        }
        stringBuilder.getChars(n11, n12, cArray, n10);
    }

    private static final StringBuilder w(StringBuilder stringBuilder, byte by2) {
        stringBuilder.append(by2);
        f0.o(stringBuilder, "append(value.toInt())");
        stringBuilder.append('\n');
        f0.o(stringBuilder, "append('\\n')");
        return stringBuilder;
    }

    private static final StringBuilder x(StringBuilder stringBuilder, double d10) {
        stringBuilder.append(d10);
        f0.o(stringBuilder, "append(value)");
        stringBuilder.append('\n');
        f0.o(stringBuilder, "append('\\n')");
        return stringBuilder;
    }

    private static final StringBuilder y(StringBuilder stringBuilder, float f10) {
        stringBuilder.append(f10);
        f0.o(stringBuilder, "append(value)");
        stringBuilder.append('\n');
        f0.o(stringBuilder, "append('\\n')");
        return stringBuilder;
    }

    private static final StringBuilder z(StringBuilder stringBuilder, int n10) {
        stringBuilder.append(n10);
        f0.o(stringBuilder, "append(value)");
        stringBuilder.append('\n');
        f0.o(stringBuilder, "append('\\n')");
        return stringBuilder;
    }
}

