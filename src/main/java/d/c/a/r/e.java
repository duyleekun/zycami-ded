/*
 * Decompiled with CFR 0.151.
 */
package d.c.a.r;

import d.c.a.o.g;
import d.c.a.r.e$a;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class e {
    private final List a;
    private final Map b;

    public e() {
        Cloneable cloneable;
        this.a = cloneable = new Cloneable();
        this.b = cloneable;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private List c(String string2) {
        synchronized (this) {
            ArrayList arrayList = this.a;
            boolean bl2 = arrayList.contains(string2);
            if (!bl2) {
                arrayList = this.a;
                arrayList.add(string2);
            }
            arrayList = this.b;
            arrayList = arrayList.get(string2);
            if ((arrayList = (List)arrayList) == null) {
                arrayList = new ArrayList();
                Map map = this.b;
                map.put(string2, arrayList);
            }
            return arrayList;
        }
    }

    public void a(String object, g g10, Class clazz, Class clazz2) {
        synchronized (this) {
            object = this.c((String)object);
            e$a e$a = new e$a(clazz, clazz2, g10);
            object.add(e$a);
            return;
        }
    }

    /*
     * Enabled aggressive exception aggregation
     */
    public List b(Class clazz, Class clazz2) {
        synchronized (this) {
            boolean bl2;
            ArrayList<Object> arrayList = new ArrayList<Object>();
            Object object = this.a;
            object = object.iterator();
            while (bl2 = object.hasNext()) {
                boolean bl3;
                Object object2 = object.next();
                object2 = (String)object2;
                Object object3 = this.b;
                object2 = object3.get(object2);
                if ((object2 = (List)object2) == null) continue;
                object2 = object2.iterator();
                while (bl3 = object2.hasNext()) {
                    object3 = object2.next();
                    boolean bl4 = ((e$a)(object3 = (e$a)object3)).a(clazz, clazz2);
                    if (!bl4) continue;
                    object3 = ((e$a)object3).c;
                    arrayList.add(object3);
                }
            }
            return arrayList;
        }
    }

    /*
     * Enabled aggressive exception aggregation
     */
    public List d(Class clazz, Class clazz2) {
        synchronized (this) {
            boolean bl2;
            ArrayList<Object> arrayList = new ArrayList<Object>();
            Object object = this.a;
            object = object.iterator();
            while (bl2 = object.hasNext()) {
                boolean bl3;
                Object object2 = object.next();
                object2 = (String)object2;
                Object object3 = this.b;
                object2 = object3.get(object2);
                if ((object2 = (List)object2) == null) continue;
                object2 = object2.iterator();
                while (bl3 = object2.hasNext()) {
                    Class clazz3;
                    object3 = object2.next();
                    boolean bl4 = ((e$a)(object3 = (e$a)object3)).a(clazz, clazz2);
                    if (!bl4 || (bl4 = arrayList.contains(clazz3 = ((e$a)object3).b))) continue;
                    object3 = ((e$a)object3).b;
                    arrayList.add(object3);
                }
            }
            return arrayList;
        }
    }

    public void e(String object, g g10, Class clazz, Class clazz2) {
        synchronized (this) {
            object = this.c((String)object);
            e$a e$a = new e$a(clazz, clazz2, g10);
            object.add(0, e$a);
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void f(List list) {
        synchronized (this) {
            Object object;
            boolean bl2;
            Object object2 = this.a;
            Object object3 = new ArrayList(object2);
            object2 = this.a;
            object2.clear();
            object2 = list.iterator();
            while (bl2 = object2.hasNext()) {
                object = object2.next();
                object = (String)object;
                List list2 = this.a;
                list2.add(object);
            }
            object3 = object3.iterator();
            boolean bl3;
            while (bl3 = object3.hasNext()) {
                object2 = object3.next();
                bl2 = list.contains(object2 = (String)object2);
                if (bl2) continue;
                object = this.a;
                object.add((Object)object2);
            }
            return;
        }
    }
}

