/*
 * Decompiled with CFR 0.151.
 */
package g;

import g.p$a;
import g.p$a$a;
import java.util.List;

public interface p {
    public static final p a;
    public static final p$a b;

    static {
        Object object = new p$a(null);
        b = object;
        a = object = new p$a$a();
    }

    public List lookup(String var1);
}

