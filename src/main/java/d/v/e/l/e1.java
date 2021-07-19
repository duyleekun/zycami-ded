/*
 * Decompiled with CFR 0.151.
 */
package d.v.e.l;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class e1 {
    private List a;
    private Map b;

    public e1() {
        Cloneable cloneable;
        this.a = cloneable = new Cloneable();
        this.b = cloneable;
    }

    public void a() {
        this.a.clear();
        this.b.clear();
    }

    public List b(Object object) {
        return (List)this.b.get(object);
    }

    public Object c(int n10, int n11) {
        Object e10 = this.a.get(n10);
        return ((List)this.b.get(e10)).get(n11);
    }

    public boolean d() {
        return this.a.isEmpty();
    }

    public Object e(int n10) {
        return this.a.get(n10);
    }

    public List f() {
        return this.a;
    }

    public void g(Object object, Object object2) {
        List<Object> list = this.a;
        boolean bl2 = list.contains(object);
        if (bl2) {
            list = this.b;
            object = (List)list.get(object);
            object.add(object2);
        } else {
            this.a.add(object);
            list = new List<Object>();
            list.add(object2);
            object2 = this.b;
            object2.put(object, list);
        }
    }

    public void h(e1 object) {
        Object object2 = this.a;
        List list = ((e1)object).a;
        object2.addAll(list);
        object2 = this.b;
        object = ((e1)object).b;
        object2.putAll(object);
    }

    public List i(int n10) {
        Object e10 = this.a.get(n10);
        return (List)this.b.get(e10);
    }

    public List j() {
        boolean bl2;
        ArrayList arrayList = new ArrayList();
        Iterator iterator2 = this.a.iterator();
        while (bl2 = iterator2.hasNext()) {
            Object object = iterator2.next();
            Map map = this.b;
            object = (List)map.get(object);
            arrayList.add(object);
        }
        return arrayList;
    }
}

