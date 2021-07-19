/*
 * Decompiled with CFR 0.151.
 */
package d.g.a.a;

import d.g.a.a.a$a;
import d.g.a.a.k;
import i.a.b.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

public final class b
implements k {
    public static final a$a a;

    static {
        a$a a$a;
        a = a$a = new a$a();
    }

    public List a(Collection object) {
        boolean bl2;
        if (object == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(object);
        object = a;
        Collections.sort(arrayList, object);
        int n10 = -1;
        TreeSet<a> treeSet = new TreeSet<a>();
        Iterator iterator2 = arrayList.iterator();
        while (bl2 = iterator2.hasNext()) {
            a a10 = (a)iterator2.next();
            int n11 = a10.getStart();
            if (n11 > n10 && (n11 = a10.getEnd()) > n10) {
                n10 = a10.getEnd();
                continue;
            }
            treeSet.add(a10);
        }
        arrayList.removeAll(treeSet);
        return arrayList;
    }
}

