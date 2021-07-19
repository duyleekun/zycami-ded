/*
 * Decompiled with CFR 0.151.
 */
package d.j.d.a.o;

import d.j.d.a.d;
import d.j.d.a.k;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public final class i$c
implements d {
    public final /* synthetic */ Collection a;

    public i$c(Collection collection) {
        this.a = collection;
    }

    public final /* synthetic */ Object a(k arrayList) {
        boolean bl2;
        arrayList = new ArrayList<Object>();
        Iterator iterator2 = this.a.iterator();
        while (bl2 = iterator2.hasNext()) {
            Object object = ((k)iterator2.next()).r();
            arrayList.add(object);
        }
        return arrayList;
    }
}

