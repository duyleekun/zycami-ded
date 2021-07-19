/*
 * Decompiled with CFR 0.151.
 */
package kotlin.text;

import f.h2.t.f0;
import java.io.Serializable;
import java.util.regex.Pattern;
import kotlin.text.Regex;
import kotlin.text.Regex$Serialized$a;

public final class Regex$Serialized
implements Serializable {
    public static final Regex$Serialized$a Companion;
    private static final long serialVersionUID;
    private final int flags;
    private final String pattern;

    static {
        Regex$Serialized$a regex$Serialized$a;
        Companion = regex$Serialized$a = new Regex$Serialized$a(null);
    }

    public Regex$Serialized(String string2, int n10) {
        f0.p(string2, "pattern");
        this.pattern = string2;
        this.flags = n10;
    }

    private final Object readResolve() {
        Object object = this.pattern;
        int n10 = this.flags;
        object = Pattern.compile((String)object, n10);
        f0.o(object, "Pattern.compile(pattern, flags)");
        Regex regex = new Regex((Pattern)object);
        return regex;
    }

    public final int getFlags() {
        return this.flags;
    }

    public final String getPattern() {
        return this.pattern;
    }
}

