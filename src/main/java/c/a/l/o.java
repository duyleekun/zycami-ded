/*
 * Decompiled with CFR 0.151.
 */
package c.a.l;

import c.a.l.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class o {
    private static final String b = "Set contributions cannot be null";
    private final List a;

    private o(int n10) {
        ArrayList arrayList;
        this.a = arrayList = new ArrayList(n10);
    }

    public static o d(int n10) {
        o o10 = new o(n10);
        return o10;
    }

    public o a(Object object) {
        List list = this.a;
        object = l.b(object, b);
        list.add(object);
        return this;
    }

    public o b(Collection collection) {
        boolean bl2;
        Iterator iterator2 = collection.iterator();
        while (bl2 = iterator2.hasNext()) {
            Object e10 = iterator2.next();
            String string2 = b;
            l.b(e10, string2);
        }
        this.a.addAll(collection);
        return this;
    }

    public Set c() {
        Collection collection = this.a;
        int n10 = collection.size();
        if (n10 != 0) {
            int n11 = 1;
            if (n10 != n11) {
                List list = this.a;
                collection = new HashSet(list);
                return Collections.unmodifiableSet(collection);
            }
            return Collections.singleton(this.a.get(0));
        }
        return Collections.emptySet();
    }
}

