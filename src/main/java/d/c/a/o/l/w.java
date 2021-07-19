/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 */
package d.c.a.o.l;

import android.net.Uri;
import d.c.a.o.f;
import d.c.a.o.j.d;
import d.c.a.o.l.n;
import d.c.a.o.l.n$a;
import d.c.a.o.l.w$c;
import d.c.a.t.e;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class w
implements n {
    private static final Set b;
    private final w$c a;

    static {
        List<String> list = Arrays.asList("file", "android.resource", "content");
        HashSet<String> hashSet = new HashSet<String>(list);
        b = Collections.unmodifiableSet(hashSet);
    }

    public w(w$c w$c) {
        this.a = w$c;
    }

    public n$a c(Uri object, int n10, int n11, f f10) {
        e e10 = new e(object);
        object = this.a.b((Uri)object);
        n$a n$a = new n$a(e10, (d)object);
        return n$a;
    }

    public boolean d(Uri object) {
        Set set = b;
        object = object.getScheme();
        return set.contains(object);
    }
}

