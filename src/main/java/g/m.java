/*
 * Decompiled with CFR 0.151.
 */
package g;

import g.m$a;
import g.m$a$a;
import g.t;
import java.util.List;

public interface m {
    public static final m a;
    public static final m$a b;

    static {
        Object object = new m$a(null);
        b = object;
        a = object = new m$a$a();
    }

    public List loadForRequest(t var1);

    public void saveFromResponse(t var1, List var2);
}

