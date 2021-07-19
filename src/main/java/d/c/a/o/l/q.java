/*
 * Decompiled with CFR 0.151.
 */
package d.c.a.o.l;

import androidx.core.util.Pools$Pool;
import d.c.a.o.c;
import d.c.a.o.f;
import d.c.a.o.j.d;
import d.c.a.o.l.n;
import d.c.a.o.l.n$a;
import d.c.a.o.l.q$a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class q
implements n {
    private final List a;
    private final Pools$Pool b;

    public q(List list, Pools$Pool pools$Pool) {
        this.a = list;
        this.b = pools$Pool;
    }

    public boolean a(Object object) {
        boolean bl2;
        Iterator iterator2 = this.a.iterator();
        while (bl2 = iterator2.hasNext()) {
            n n10 = (n)iterator2.next();
            bl2 = n10.a(object);
            if (!bl2) continue;
            return true;
        }
        return false;
    }

    public n$a b(Object object, int n10, int n11, f f10) {
        List list = this.a;
        int n12 = list.size();
        ArrayList<Object> arrayList = new ArrayList<Object>(n12);
        n$a n$a = null;
        c c10 = null;
        for (int i10 = 0; i10 < n12; ++i10) {
            Object object2 = (n)this.a.get(i10);
            boolean bl2 = object2.a(object);
            if (!bl2 || (object2 = object2.b(object, n10, n11, f10)) == null) continue;
            c10 = ((n$a)object2).a;
            object2 = ((n$a)object2).c;
            arrayList.add(object2);
        }
        boolean bl3 = arrayList.isEmpty();
        if (!bl3 && c10 != null) {
            Pools$Pool pools$Pool = this.b;
            object = new q$a(arrayList, pools$Pool);
            n$a = new n$a(c10, (d)object);
        }
        return n$a;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("MultiModelLoader{modelLoaders=");
        String string2 = Arrays.toString(this.a.toArray());
        stringBuilder.append(string2);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

