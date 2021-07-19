/*
 * Decompiled with CFR 0.151.
 */
package l.a.h;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import l.a.h.c$b;
import l.a.h.c$c;
import l.a.h.c$e;

public abstract class c {
    public c$b a;
    public c$c b;
    public c$e c;

    public static boolean j(Map map, Collection object) {
        boolean bl2;
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            Object e10 = object.next();
            bl2 = map.containsKey(e10);
            if (bl2) continue;
            return false;
        }
        return true;
    }

    public static boolean k(Set set, Object object) {
        boolean bl2 = true;
        if (set == object) {
            return bl2;
        }
        int n10 = object instanceof Set;
        if (n10 != 0) {
            block7: {
                block6: {
                    object = (Set)object;
                    n10 = set.size();
                    int n11 = object.size();
                    if (n10 != n11) break block6;
                    try {
                        boolean bl3 = set.containsAll((Collection<?>)object);
                        if (bl3) break block7;
                    }
                    catch (ClassCastException | NullPointerException runtimeException) {}
                }
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public static boolean o(Map map, Collection object) {
        boolean bl2;
        int n10 = map.size();
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            Object e10 = object.next();
            map.remove(e10);
        }
        int n11 = map.size();
        if (n10 != n11) {
            n11 = 1;
        } else {
            n11 = 0;
            map = null;
        }
        return n11 != 0;
    }

    public static boolean p(Map map, Collection collection) {
        boolean bl2;
        int n10 = map.size();
        Iterator iterator2 = map.keySet().iterator();
        while (bl2 = iterator2.hasNext()) {
            Object k10 = iterator2.next();
            bl2 = collection.contains(k10);
            if (bl2) continue;
            iterator2.remove();
        }
        int n11 = map.size();
        if (n10 != n11) {
            n11 = 1;
        } else {
            n11 = 0;
            map = null;
        }
        return n11 != 0;
    }

    public abstract void a();

    public abstract Object b(int var1, int var2);

    public abstract Map c();

    public abstract int d();

    public abstract int e(Object var1);

    public abstract int f(Object var1);

    public abstract void g(Object var1, Object var2);

    public abstract void h(int var1);

    public abstract Object i(int var1, Object var2);

    public Set l() {
        c$b c$b = this.a;
        if (c$b == null) {
            this.a = c$b = new c$b(this);
        }
        return this.a;
    }

    public Set m() {
        c$c c$c = this.b;
        if (c$c == null) {
            this.b = c$c = new c$c(this);
        }
        return this.b;
    }

    public Collection n() {
        c$e c$e = this.c;
        if (c$e == null) {
            this.c = c$e = new c$e(this);
        }
        return this.c;
    }

    public Object[] q(int n10) {
        int n11 = this.d();
        Object[] objectArray = new Object[n11];
        for (int i10 = 0; i10 < n11; ++i10) {
            Object object;
            objectArray[i10] = object = this.b(i10, n10);
        }
        return objectArray;
    }

    public Object[] r(Object[] objectArray, int n10) {
        int n11 = objectArray.length;
        int n12 = this.d();
        if (n11 < n12) {
            objectArray = (Object[])Array.newInstance(objectArray.getClass().getComponentType(), n12);
        }
        for (n11 = 0; n11 < n12; ++n11) {
            Object object;
            objectArray[n11] = object = this.b(n11, n10);
        }
        n10 = objectArray.length;
        if (n10 > n12) {
            n10 = 0;
            objectArray[n12] = null;
        }
        return objectArray;
    }
}

