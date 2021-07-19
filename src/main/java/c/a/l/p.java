/*
 * Decompiled with CFR 0.151.
 */
package c.a.l;

import c.a.l.b;
import c.a.l.e;
import c.a.l.g;
import c.a.l.l;
import c.a.l.p$a;
import c.a.l.p$b;
import c.b.a.c;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class p
implements e {
    private static final e c = g.a(Collections.emptySet());
    private final List a;
    private final List b;

    private p(List list, List list2) {
        this.a = list;
        this.b = list2;
    }

    public /* synthetic */ p(List list, List list2, p$a p$a) {
        this(list, list2);
    }

    public static p$b a(int n10, int n11) {
        p$b p$b = new p$b(n10, n11, null);
        return p$b;
    }

    public static e b() {
        return c;
    }

    public Set c() {
        Object object;
        int n10;
        Collection<Object> collection = this.a;
        int n11 = collection.size();
        int n12 = this.b.size();
        ArrayList<Collection> arrayList = new ArrayList<Collection>(n12);
        List list = this.b;
        n12 = list.size();
        int n13 = 0;
        Iterator iterator2 = null;
        for (n10 = 0; n10 < n12; ++n10) {
            object = (Collection)((c)this.b.get(n10)).get();
            int n14 = object.size();
            n11 += n14;
            arrayList.add((Collection)object);
        }
        collection = c.a.l.b.c(n11);
        list = this.a;
        n12 = list.size();
        iterator2 = null;
        for (n10 = 0; n10 < n12; ++n10) {
            object = l.a(((c)this.a.get(n10)).get());
            collection.add(object);
        }
        n12 = arrayList.size();
        while (n13 < n12) {
            boolean bl2;
            iterator2 = ((Collection)arrayList.get(n13)).iterator();
            while (bl2 = iterator2.hasNext()) {
                object = l.a(iterator2.next());
                collection.add(object);
            }
            ++n13;
        }
        return Collections.unmodifiableSet(collection);
    }
}

