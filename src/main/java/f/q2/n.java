/*
 * Decompiled with CFR 0.151.
 */
package f.q2;

import f.h2.s.l;
import f.h2.t.f0;
import java.util.Objects;

public class n {
    public static final Appendable a(Appendable appendable, CharSequence ... charSequenceArray) {
        f0.p(appendable, "$this$append");
        String string2 = "value";
        f0.p(charSequenceArray, string2);
        for (CharSequence charSequence : charSequenceArray) {
            appendable.append(charSequence);
        }
        return appendable;
    }

    public static final void b(Appendable appendable, Object object, l l10) {
        String string2 = "$this$appendElement";
        f0.p(appendable, string2);
        if (l10 != null) {
            object = (CharSequence)l10.invoke(object);
            appendable.append((CharSequence)object);
        } else {
            boolean bl2 = object != null ? object instanceof CharSequence : true;
            if (bl2) {
                object = (CharSequence)object;
                appendable.append((CharSequence)object);
            } else {
                bl2 = object instanceof Character;
                if (bl2) {
                    object = (Character)object;
                    char c10 = ((Character)object).charValue();
                    appendable.append(c10);
                } else {
                    object = String.valueOf(object);
                    appendable.append((CharSequence)object);
                }
            }
        }
    }

    private static final Appendable c(Appendable appendable) {
        appendable = appendable.append('\n');
        f0.o(appendable, "append('\\n')");
        return appendable;
    }

    private static final Appendable d(Appendable appendable, char c10) {
        appendable = appendable.append(c10);
        f0.o(appendable, "append(value)");
        appendable = appendable.append('\n');
        f0.o(appendable, "append('\\n')");
        return appendable;
    }

    private static final Appendable e(Appendable appendable, CharSequence charSequence) {
        appendable = appendable.append(charSequence);
        f0.o(appendable, "append(value)");
        appendable = appendable.append('\n');
        f0.o(appendable, "append('\\n')");
        return appendable;
    }

    public static final Appendable f(Appendable appendable, CharSequence charSequence, int n10, int n11) {
        f0.p(appendable, "$this$appendRange");
        f0.p(charSequence, "value");
        appendable = appendable.append(charSequence, n10, n11);
        Objects.requireNonNull(appendable, "null cannot be cast to non-null type T");
        return appendable;
    }
}

