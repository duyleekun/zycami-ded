/*
 * Decompiled with CFR 0.151.
 */
package f.q2;

import f.q2.o;
import java.util.Set;
import kotlin.text.Regex;
import kotlin.text.RegexOption;

public class p
extends o {
    private static final Regex t(String string2) {
        Regex regex = new Regex(string2);
        return regex;
    }

    private static final Regex u(String string2, Set set) {
        Regex regex = new Regex(string2, set);
        return regex;
    }

    private static final Regex v(String string2, RegexOption regexOption) {
        Regex regex = new Regex(string2, regexOption);
        return regex;
    }
}

