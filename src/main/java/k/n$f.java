/*
 * Decompiled with CFR 0.151.
 */
package k;

import java.util.Objects;
import k.h;
import k.n;
import k.p;

public final class n$f
extends n {
    private final String a;
    private final h b;

    public n$f(String string2, h h10) {
        Objects.requireNonNull(string2, "name == null");
        this.a = string2;
        this.b = h10;
    }

    public void a(p p10, Object object) {
        if (object == null) {
            return;
        }
        Object object2 = this.b;
        if ((object = (String)object2.convert(object)) == null) {
            return;
        }
        object2 = this.a;
        p10.b((String)object2, (String)object);
    }
}

