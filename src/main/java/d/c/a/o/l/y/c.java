/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 */
package d.c.a.o.l.y;

import android.net.Uri;
import d.c.a.o.f;
import d.c.a.o.l.g;
import d.c.a.o.l.n;
import d.c.a.o.l.n$a;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class c
implements n {
    private static final Set b;
    private final n a;

    static {
        List<String> list = Arrays.asList("http", "https");
        HashSet<String> hashSet = new HashSet<String>(list);
        b = Collections.unmodifiableSet(hashSet);
    }

    public c(n n10) {
        this.a = n10;
    }

    public n$a c(Uri object, int n10, int n11, f f10) {
        n n12 = this.a;
        object = object.toString();
        g g10 = new g((String)object);
        return n12.b(g10, n10, n11, f10);
    }

    public boolean d(Uri object) {
        Set set = b;
        object = object.getScheme();
        return set.contains(object);
    }
}

