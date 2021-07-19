/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Log
 */
package d.c.a.o.k.x;

import android.util.Log;
import d.c.a.o.k.x.a;
import d.c.a.o.k.x.b;
import d.c.a.o.k.x.g;
import d.c.a.o.k.x.h;
import d.c.a.o.k.x.i;
import d.c.a.o.k.x.j$a;
import d.c.a.o.k.x.j$b;
import d.c.a.o.k.x.m;
import d.c.a.u.k;
import java.io.Serializable;
import java.lang.constant.Constable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

public final class j
implements b {
    private static final int h = 0x400000;
    public static final int i = 8;
    private static final int j = 2;
    private final h b;
    private final j$b c;
    private final Map d;
    private final Map e;
    private final int f;
    private int g;

    public j() {
        HashMap hashMap = new HashMap();
        this.b = hashMap;
        hashMap = new HashMap();
        this.c = hashMap;
        this.d = hashMap = new HashMap();
        this.e = hashMap = new HashMap();
        this.f = 0x400000;
    }

    public j(int n10) {
        HashMap hashMap = new HashMap();
        this.b = hashMap;
        hashMap = new HashMap();
        this.c = hashMap;
        this.d = hashMap = new HashMap();
        this.e = hashMap = new HashMap();
        this.f = n10;
    }

    private void f(int n10, Class object) {
        object = this.n((Class)object);
        Comparable<Integer> comparable = n10;
        if ((comparable = (Integer)object.get(comparable)) != null) {
            int n11;
            int n12 = (Integer)comparable;
            if (n12 == (n11 = 1)) {
                Integer n13 = n10;
                object.remove(n13);
            } else {
                Integer n14 = n10;
                int n15 = (Integer)comparable - n11;
                comparable = n15;
                object.put(n14, comparable);
            }
            return;
        }
        comparable = new Comparable<Integer>();
        ((StringBuilder)comparable).append("Tried to decrement empty size, size: ");
        ((StringBuilder)comparable).append(n10);
        ((StringBuilder)comparable).append(", this: ");
        ((StringBuilder)comparable).append(this);
        String string2 = ((StringBuilder)comparable).toString();
        object = new NullPointerException(string2);
        throw object;
    }

    private void g() {
        int n10 = this.f;
        this.h(n10);
    }

    private void h(int n10) {
        int n11;
        while ((n11 = this.g) > n10) {
            Object object = this.b.f();
            k.d(object);
            a a10 = this.i(object);
            int n12 = this.g;
            int n13 = a10.b(object);
            int n14 = a10.a();
            this.g = n12 -= (n13 *= n14);
            n12 = a10.b(object);
            Serializable serializable = object.getClass();
            this.f(n12, (Class)serializable);
            String string2 = a10.getTag();
            n12 = (int)(Log.isLoggable((String)string2, (int)(n13 = 2)) ? 1 : 0);
            if (n12 == 0) continue;
            string2 = a10.getTag();
            serializable = new StringBuilder();
            String string3 = "evicted: ";
            ((StringBuilder)serializable).append(string3);
            n11 = a10.b(object);
            ((StringBuilder)serializable).append(n11);
            object = ((StringBuilder)serializable).toString();
            Log.v((String)string2, (String)object);
        }
    }

    private a i(Object clazz) {
        clazz = clazz.getClass();
        return this.j(clazz);
    }

    private a j(Class object) {
        Class<int[]> clazz;
        block4: {
            clazz = (a)this.e.get(object);
            if (clazz != null) break block4;
            clazz = int[].class;
            boolean bl2 = object.equals(clazz);
            if (bl2) {
                clazz = new i();
            } else {
                clazz = byte[].class;
                bl2 = object.equals(clazz);
                if (!bl2) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("No array pool found for: ");
                    object = ((Class)object).getSimpleName();
                    stringBuilder.append((String)object);
                    object = stringBuilder.toString();
                    clazz = new IllegalArgumentException((String)object);
                    throw clazz;
                }
                clazz = new g();
            }
            Map map = this.e;
            map.put(object, clazz);
        }
        return clazz;
    }

    private Object k(j$a j$a) {
        return this.b.a(j$a);
    }

    private Object m(j$a j$a, Class object) {
        int n10;
        a a10 = this.j((Class)object);
        Object object2 = this.k(j$a);
        if (object2 != null) {
            n10 = this.g;
            int n11 = a10.b(object2);
            int n12 = a10.a();
            this.g = n10 -= (n11 *= n12);
            n10 = a10.b(object2);
            this.f(n10, (Class)object);
        }
        if (object2 == null) {
            int n13;
            object = a10.getTag();
            boolean bl2 = Log.isLoggable((String)object, (int)(n13 = 2));
            if (bl2) {
                object = a10.getTag();
                object2 = new StringBuilder();
                ((StringBuilder)object2).append("Allocated ");
                n10 = j$a.b;
                ((StringBuilder)object2).append(n10);
                String string2 = " bytes";
                ((StringBuilder)object2).append(string2);
                object2 = ((StringBuilder)object2).toString();
                Log.v((String)object, (String)object2);
            }
            int n14 = j$a.b;
            object2 = a10.newArray(n14);
        }
        return object2;
    }

    private NavigableMap n(Class clazz) {
        TreeMap treeMap = (TreeMap)this.d.get(clazz);
        if (treeMap == null) {
            treeMap = new TreeMap();
            Map map = this.d;
            map.put(clazz, treeMap);
        }
        return treeMap;
    }

    private boolean o() {
        int n10;
        int n11 = this.g;
        n11 = n11 != 0 && (n10 = this.f / n11) < (n11 = 2) ? 0 : 1;
        return n11 != 0;
    }

    private boolean p(int n10) {
        int n11 = this.f / 2;
        n10 = n10 <= n11 ? 1 : 0;
        return n10 != 0;
    }

    private boolean q(int n10, Integer n11) {
        int n12;
        boolean bl2;
        n10 = n11 != null && ((bl2 = this.o()) || (n12 = n11.intValue()) <= (n10 *= 8)) ? 1 : 0;
        return n10 != 0;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a(int n10) {
        synchronized (this) {
            Throwable throwable2;
            block6: {
                block5: {
                    int n11 = 40;
                    if (n10 >= n11) {
                        try {
                            this.b();
                            break block5;
                        }
                        catch (Throwable throwable2) {
                            break block6;
                        }
                    }
                    n11 = 20;
                    if (n10 >= n11 || n10 == (n11 = 15)) {
                        n10 = this.f;
                        this.h(n10 /= 2);
                    }
                }
                return;
            }
            throw throwable2;
        }
    }

    public void b() {
        synchronized (this) {
            Object var1_1 = null;
            this.h(0);
            return;
        }
    }

    public Object c(int n10, Class clazz) {
        synchronized (this) {
            Object object;
            Object object2 = this.n(clazz);
            Integer n11 = n10;
            object2 = object2.ceilingKey(n11);
            object2 = (Integer)object2;
            boolean bl2 = this.q(n10, (Integer)object2);
            if (bl2) {
                object = this.c;
                int n12 = (Integer)object2;
                object = ((j$b)object).e(n12, clazz);
            } else {
                object2 = this.c;
                object = ((j$b)object2).e(n10, clazz);
            }
            object = this.m((j$a)object, clazz);
            return object;
        }
    }

    public Object d(int n10, Class clazz) {
        synchronized (this) {
            j$b j$b = this.c;
            Object object = j$b.e(n10, clazz);
            object = this.m((j$a)object, clazz);
            return object;
        }
    }

    public void e(Object object, Class clazz) {
        this.put(object);
    }

    public int l() {
        boolean bl2;
        Iterator iterator2 = this.d.keySet().iterator();
        int n10 = 0;
        while (bl2 = iterator2.hasNext()) {
            int n11;
            Class clazz = (Class)iterator2.next();
            Iterator iterator3 = ((NavigableMap)this.d.get(clazz)).keySet().iterator();
            while ((n11 = iterator3.hasNext()) != 0) {
                Integer n12 = (Integer)iterator3.next();
                a a10 = this.j(clazz);
                int n13 = n12;
                NavigableMap navigableMap = (NavigableMap)this.d.get(clazz);
                n12 = (Integer)navigableMap.get(n12);
                n11 = n12;
                n13 *= n11;
                n11 = a10.a();
                n10 += (n13 *= n11);
            }
        }
        return n10;
    }

    public void put(Object object) {
        synchronized (this) {
            int n10;
            Object object2;
            int n11;
            Constable constable;
            block23: {
                int n12;
                block22: {
                    constable = object.getClass();
                    a a10 = this.j((Class)constable);
                    n12 = a10.b(object);
                    n11 = a10.a() * n12;
                    boolean n102 = this.p(n11);
                    if (n102) break block22;
                    return;
                }
                Object object3 = this.c;
                object2 = ((j$b)object3).e(n12, (Class)constable);
                object3 = this.b;
                ((h)object3).d((m)object2, object);
                object = this.n((Class)constable);
                int n13 = ((j$a)object2).b;
                constable = Integer.valueOf(n13);
                constable = object.get(constable);
                constable = (Integer)constable;
                n12 = ((j$a)object2).b;
                object2 = n12;
                int n14 = 1;
                if (constable == null) break block23;
                n13 = (Integer)constable;
                n10 = n14 + n13;
            }
            constable = Integer.valueOf(n10);
            object.put(object2, constable);
            int n15 = this.g + n11;
            this.g = n15;
            this.g();
            return;
        }
    }
}

