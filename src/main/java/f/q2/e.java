/*
 * Decompiled with CFR 0.151.
 */
package f.q2;

import f.h2.t.f0;
import java.nio.charset.Charset;

public final class e {
    private static final Charset a(String object) {
        object = Charset.forName((String)object);
        f0.o(object, "Charset.forName(charsetName)");
        return object;
    }
}

