/*
 * Decompiled with CFR 0.151.
 */
package d.j.d.a.o;

import d.j.d.a.d;
import d.j.d.a.k;
import java.util.ArrayList;
import java.util.Collection;

public final class i$b
implements d {
    public final /* synthetic */ Collection a;

    public i$b(Collection collection) {
        this.a = collection;
    }

    public final /* synthetic */ Object a(k arrayList) {
        int n10 = this.a.size();
        arrayList = new ArrayList(n10);
        Collection collection = this.a;
        arrayList.addAll(collection);
        return arrayList;
    }
}

