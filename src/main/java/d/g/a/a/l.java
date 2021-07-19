/*
 * Decompiled with CFR 0.151.
 */
package d.g.a.a;

import d.g.a.a.h;
import i.a.b.f;
import i.a.b.f$b;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public final class l {
    private l() {
    }

    public static f a(List iterator2) {
        Object object = new TreeSet();
        f$b f$b = f.e();
        if (iterator2 != null) {
            boolean bl2;
            iterator2 = iterator2.iterator();
            while (bl2 = iterator2.hasNext()) {
                Set set;
                Object object2 = (h)iterator2.next();
                if (object2 == null || (set = object2.a()) == null) continue;
                object2 = object2.a();
                object.addAll(object2);
            }
            int n10 = object.size();
            if (n10 > 0) {
                boolean bl3;
                iterator2 = object.iterator();
                while (bl3 = iterator2.hasNext()) {
                    object = (String)iterator2.next();
                    f$b.a((String)object);
                }
                return f$b.b();
            }
        }
        return null;
    }
}

