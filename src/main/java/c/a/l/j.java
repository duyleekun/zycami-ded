/*
 * Decompiled with CFR 0.151.
 */
package c.a.l;

import c.a.e;
import c.a.l.j$a;
import c.a.l.j$b;
import java.util.Collections;
import java.util.Map;

public final class j
implements c.a.l.e,
e {
    private final Map a;

    private j(Map map) {
        this.a = map = Collections.unmodifiableMap(map);
    }

    public /* synthetic */ j(Map map, j$a j$a) {
        this(map);
    }

    public static j$b a(int n10) {
        j$b j$b = new j$b(n10, null);
        return j$b;
    }

    public Map b() {
        return this.a;
    }
}

