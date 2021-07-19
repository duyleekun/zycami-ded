/*
 * Decompiled with CFR 0.151.
 */
package i.a.a;

import i.a.a.c;
import i.a.a.d;
import i.a.a.e;
import java.util.Collections;
import java.util.List;
import java.util.TreeSet;
import org.ahocorasick.interval.IntervalNode;

public class b {
    private IntervalNode a = null;

    public b(List list) {
        IntervalNode intervalNode;
        this.a = intervalNode = new IntervalNode(list);
    }

    public List a(c c10) {
        return this.a.g(c10);
    }

    public List b(List list) {
        boolean bl2;
        boolean bl3;
        Object object = new e();
        Collections.sort(list, object);
        object = new TreeSet();
        Object object2 = list.iterator();
        while (bl3 = object2.hasNext()) {
            Object object3 = (c)object2.next();
            boolean bl4 = object.contains(object3);
            if (bl4) continue;
            object3 = this.a((c)object3);
            object.addAll(object3);
        }
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            object2 = (c)object.next();
            list.remove(object2);
        }
        object = new d();
        Collections.sort(list, object);
        return list;
    }
}

