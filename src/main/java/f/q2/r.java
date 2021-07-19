/*
 * Decompiled with CFR 0.151.
 */
package f.q2;

import f.h2.s.l;
import f.h2.t.f0;
import f.q2.q;

public class r
extends q {
    private static final StringBuilder h0(StringBuilder stringBuilder, Object object) {
        stringBuilder.append(object);
        f0.o(stringBuilder, "this.append(obj)");
        return stringBuilder;
    }

    public static final StringBuilder i0(StringBuilder stringBuilder, Object ... objectArray) {
        f0.p(stringBuilder, "$this$append");
        String string2 = "value";
        f0.p(objectArray, string2);
        for (Object object : objectArray) {
            stringBuilder.append(object);
        }
        return stringBuilder;
    }

    public static final StringBuilder j0(StringBuilder stringBuilder, String ... stringArray) {
        f0.p(stringBuilder, "$this$append");
        String string2 = "value";
        f0.p(stringArray, string2);
        for (String string3 : stringArray) {
            stringBuilder.append(string3);
        }
        return stringBuilder;
    }

    private static final StringBuilder k0(StringBuilder stringBuilder) {
        stringBuilder.append('\n');
        f0.o(stringBuilder, "append('\\n')");
        return stringBuilder;
    }

    private static final StringBuilder l0(StringBuilder stringBuilder, char c10) {
        stringBuilder.append(c10);
        f0.o(stringBuilder, "append(value)");
        stringBuilder.append('\n');
        f0.o(stringBuilder, "append('\\n')");
        return stringBuilder;
    }

    private static final StringBuilder m0(StringBuilder stringBuilder, CharSequence charSequence) {
        stringBuilder.append(charSequence);
        f0.o(stringBuilder, "append(value)");
        stringBuilder.append('\n');
        f0.o(stringBuilder, "append('\\n')");
        return stringBuilder;
    }

    private static final StringBuilder n0(StringBuilder stringBuilder, Object object) {
        stringBuilder.append(object);
        f0.o(stringBuilder, "append(value)");
        stringBuilder.append('\n');
        f0.o(stringBuilder, "append('\\n')");
        return stringBuilder;
    }

    private static final StringBuilder o0(StringBuilder stringBuilder, String string2) {
        stringBuilder.append(string2);
        f0.o(stringBuilder, "append(value)");
        stringBuilder.append('\n');
        f0.o(stringBuilder, "append('\\n')");
        return stringBuilder;
    }

    private static final StringBuilder p0(StringBuilder stringBuilder, boolean bl2) {
        stringBuilder.append(bl2);
        f0.o(stringBuilder, "append(value)");
        stringBuilder.append('\n');
        f0.o(stringBuilder, "append('\\n')");
        return stringBuilder;
    }

    private static final StringBuilder q0(StringBuilder stringBuilder, char[] cArray) {
        stringBuilder.append(cArray);
        f0.o(stringBuilder, "append(value)");
        stringBuilder.append('\n');
        f0.o(stringBuilder, "append('\\n')");
        return stringBuilder;
    }

    private static final String r0(int n10, l l10) {
        StringBuilder stringBuilder = new StringBuilder(n10);
        l10.invoke(stringBuilder);
        String string2 = stringBuilder.toString();
        f0.o(string2, "StringBuilder(capacity).\u2026builderAction).toString()");
        return string2;
    }

    private static final String s0(l object) {
        StringBuilder stringBuilder = new StringBuilder();
        object.invoke(stringBuilder);
        object = stringBuilder.toString();
        f0.o(object, "StringBuilder().apply(builderAction).toString()");
        return object;
    }
}

