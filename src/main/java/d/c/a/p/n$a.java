/*
 * Decompiled with CFR 0.151.
 */
package d.c.a.p;

import d.c.a.i;
import d.c.a.p.l;
import d.c.a.p.n;
import java.util.HashSet;
import java.util.Set;

public class n$a
implements l {
    public final /* synthetic */ n a;

    public n$a(n n10) {
        this.a = n10;
    }

    public Set a() {
        Object object = this.a.i();
        int n10 = object.size();
        HashSet<Object> hashSet = new HashSet<Object>(n10);
        object = object.iterator();
        while ((n10 = (int)(object.hasNext() ? 1 : 0)) != 0) {
            Object object2 = (n)object.next();
            i i10 = ((n)object2).l();
            if (i10 == null) continue;
            object2 = ((n)object2).l();
            hashSet.add(object2);
        }
        return hashSet;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Object object = super.toString();
        stringBuilder.append((String)object);
        stringBuilder.append("{fragment=");
        object = this.a;
        stringBuilder.append(object);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}

