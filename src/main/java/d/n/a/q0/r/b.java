/*
 * Decompiled with CFR 0.151.
 */
package d.n.a.q0.r;

import d.n.a.q0.r.a;
import d.n.a.q0.r.b$a;
import d.n.a.q0.r.d;
import d.n.a.q0.r.d$a;
import java.lang.ref.Reference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class b
implements Map {
    private final HashMap a;
    private final d$a b;

    public b() {
        b$a b$a = new b$a();
        this(b$a);
    }

    public b(d$a d$a) {
        HashMap hashMap;
        this.a = hashMap = new HashMap();
        this.b = d$a;
    }

    private void b() {
        boolean bl2;
        Iterator iterator2 = this.a.entrySet().iterator();
        while (bl2 = iterator2.hasNext()) {
            d d10 = (d)iterator2.next().getValue();
            bl2 = d10.b();
            if (!bl2) continue;
            iterator2.remove();
        }
    }

    public d.n.a.q0.b c(Object object) {
        HashMap hashMap = this.a;
        object = (object = (d)hashMap.get(object)) != null ? (d.n.a.q0.b)((Reference)object).get() : null;
        return object;
    }

    public void clear() {
        this.a.clear();
    }

    public boolean containsKey(Object object) {
        boolean bl2;
        HashMap hashMap = this.a;
        boolean bl3 = hashMap.containsKey(object);
        if (bl3 && (object = this.c(object)) != null) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    public boolean containsValue(Object object) {
        boolean bl2;
        Iterator iterator2 = this.a.values().iterator();
        while (bl2 = iterator2.hasNext()) {
            d d10 = (d)iterator2.next();
            bl2 = d10.a(object);
            if (!bl2) continue;
            return true;
        }
        return false;
    }

    public d.n.a.q0.b e(String string2, d.n.a.q0.b b10) {
        HashMap hashMap = this.a;
        d d10 = this.b.a(b10);
        hashMap.put(string2, d10);
        this.b();
        return b10;
    }

    public Set entrySet() {
        boolean bl2;
        HashSet<a> hashSet = new HashSet<a>();
        Iterator iterator2 = this.a.entrySet().iterator();
        while (bl2 = iterator2.hasNext()) {
            Map.Entry entry = iterator2.next();
            Object object = (d)entry.getValue();
            boolean bl3 = ((d)object).b();
            if (bl3) continue;
            entry = (String)entry.getKey();
            d$a d$a = this.b;
            object = (d.n.a.q0.b)((Reference)object).get();
            object = d$a.a((d.n.a.q0.b)object);
            a a10 = new a((String)((Object)entry), (d)object);
            hashSet.add(a10);
        }
        return hashSet;
    }

    public d.n.a.q0.b f(Object object) {
        HashMap hashMap = this.a;
        object = (d)hashMap.remove(object);
        this.b();
        object = object != null ? (d.n.a.q0.b)((Reference)object).get() : null;
        return object;
    }

    public boolean isEmpty() {
        this.b();
        return this.a.isEmpty();
    }

    public Set keySet() {
        return this.a.keySet();
    }

    public void putAll(Map object) {
        boolean bl2;
        object = object.entrySet().iterator();
        while (bl2 = object.hasNext()) {
            Object object2 = (Map.Entry)object.next();
            String string2 = (String)object2.getKey();
            object2 = (d.n.a.q0.b)object2.getValue();
            this.e(string2, (d.n.a.q0.b)object2);
        }
    }

    public int size() {
        this.b();
        return this.a.size();
    }

    public Collection values() {
        boolean bl2;
        ArrayList<d> arrayList = new ArrayList<d>();
        Iterator iterator2 = this.a.values().iterator();
        while (bl2 = iterator2.hasNext()) {
            d d10 = (d)iterator2.next();
            boolean bl3 = d10.b();
            if (bl3) continue;
            d10 = d10.get();
            arrayList.add(d10);
        }
        return arrayList;
    }
}

