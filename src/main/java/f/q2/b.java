/*
 * Decompiled with CFR 0.151.
 */
package f.q2;

import f.l2.k;
import kotlin.text.CharCategory;
import kotlin.text.CharCategory$a;
import kotlin.text.CharDirectionality;
import kotlin.text.CharDirectionality$a;

public class b {
    public static final int a(int n10) {
        int n11 = 2;
        int n12 = 36;
        if (n11 <= n10 && n12 >= n10) {
            return n10;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("radix ");
        stringBuilder.append(n10);
        stringBuilder.append(" was not in valid range ");
        Object object = new k(n11, n12);
        stringBuilder.append(object);
        object = stringBuilder.toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)object);
        throw illegalArgumentException;
    }

    public static final int b(char c10, int n10) {
        return Character.digit((int)c10, n10);
    }

    public static final CharCategory c(char c10) {
        CharCategory$a charCategory$a = CharCategory.Companion;
        c10 = (char)Character.getType(c10);
        return charCategory$a.b(c10);
    }

    public static final CharDirectionality d(char c10) {
        CharDirectionality$a charDirectionality$a = CharDirectionality.Companion;
        c10 = (char)Character.getDirectionality(c10);
        return charDirectionality$a.b(c10);
    }

    private static final boolean e(char c10) {
        return Character.isDefined(c10);
    }

    private static final boolean f(char c10) {
        return Character.isDigit(c10);
    }

    private static final boolean g(char c10) {
        return Character.isHighSurrogate(c10);
    }

    private static final boolean h(char c10) {
        return Character.isISOControl(c10);
    }

    private static final boolean i(char c10) {
        return Character.isIdentifierIgnorable(c10);
    }

    private static final boolean j(char c10) {
        return Character.isJavaIdentifierPart(c10);
    }

    private static final boolean k(char c10) {
        return Character.isJavaIdentifierStart(c10);
    }

    private static final boolean l(char c10) {
        return Character.isLetter(c10);
    }

    private static final boolean m(char c10) {
        return Character.isLetterOrDigit(c10);
    }

    private static final boolean n(char c10) {
        return Character.isLowSurrogate(c10);
    }

    private static final boolean o(char c10) {
        return Character.isLowerCase(c10);
    }

    private static final boolean p(char c10) {
        return Character.isTitleCase(c10);
    }

    private static final boolean q(char c10) {
        return Character.isUpperCase(c10);
    }

    public static final boolean r(char c10) {
        boolean bl2 = Character.isWhitespace(c10);
        c10 = !bl2 && (c10 = (char)(Character.isSpaceChar(c10) ? 1 : 0)) == '\u0000' ? (char)'\u0000' : '\u0001';
        return c10 != 0;
    }

    private static final char s(char c10) {
        return Character.toLowerCase(c10);
    }

    private static final char t(char c10) {
        return Character.toTitleCase(c10);
    }

    private static final char u(char c10) {
        return Character.toUpperCase(c10);
    }
}

