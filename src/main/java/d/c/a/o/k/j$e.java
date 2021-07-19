/*
 * Decompiled with CFR 0.151.
 */
package d.c.a.o.k;

import d.c.a.o.k.j$d;
import d.c.a.s.h;
import d.c.a.u.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;

public final class j$e
implements Iterable {
    private final List a;

    public j$e() {
        ArrayList arrayList = new ArrayList(2);
        this(arrayList);
    }

    public j$e(List list) {
        this.a = list;
    }

    private static j$d d(h h10) {
        Executor executor = e.a();
        j$d j$d = new j$d(h10, executor);
        return j$d;
    }

    public void a(h h10, Executor executor) {
        List list = this.a;
        j$d j$d = new j$d(h10, executor);
        list.add(j$d);
    }

    public boolean b(h object) {
        List list = this.a;
        object = j$e.d((h)object);
        return list.contains(object);
    }

    public j$e c() {
        List list = this.a;
        ArrayList arrayList = new ArrayList(list);
        j$e j$e = new j$e(arrayList);
        return j$e;
    }

    public void clear() {
        this.a.clear();
    }

    public void e(h object) {
        List list = this.a;
        object = j$e.d((h)object);
        list.remove(object);
    }

    public boolean isEmpty() {
        return this.a.isEmpty();
    }

    public Iterator iterator() {
        return this.a.iterator();
    }

    public int size() {
        return this.a.size();
    }
}

