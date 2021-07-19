/*
 * Decompiled with CFR 0.151.
 */
package kotlin.text;

import f.h2.t.f0;
import f.h2.t.u;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.text.Regex;
import kotlin.text.RegexOption;

public final class Regex$a {
    private Regex$a() {
    }

    public /* synthetic */ Regex$a(u u10) {
        this();
    }

    public static final /* synthetic */ int a(Regex$a regex$a, int n10) {
        return regex$a.b(n10);
    }

    private final int b(int n10) {
        int n11 = n10 & 2;
        if (n11 != 0) {
            n10 |= 0x40;
        }
        return n10;
    }

    public final String c(String string2) {
        f0.p(string2, "literal");
        string2 = Pattern.quote(string2);
        f0.o(string2, "Pattern.quote(literal)");
        return string2;
    }

    public final String d(String string2) {
        f0.p(string2, "literal");
        string2 = Matcher.quoteReplacement(string2);
        f0.o(string2, "Matcher.quoteReplacement(literal)");
        return string2;
    }

    public final Regex e(String string2) {
        f0.p(string2, "literal");
        RegexOption regexOption = RegexOption.LITERAL;
        Regex regex = new Regex(string2, regexOption);
        return regex;
    }
}

