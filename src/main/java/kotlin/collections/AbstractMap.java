/*
 * Decompiled with CFR 0.151.
 */
package kotlin.collections;

import f.h2.t.f0;
import f.h2.t.x0.a;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.collections.AbstractMap$a;
import kotlin.collections.AbstractMap$b;
import kotlin.collections.AbstractMap$c;
import kotlin.collections.AbstractMap$toString$1;
import kotlin.collections.CollectionsKt___CollectionsKt;

public abstract class AbstractMap
implements Map,
a {
    public static final AbstractMap$a c;
    private volatile Set a;
    private volatile Collection b;

    static {
        AbstractMap$a abstractMap$a;
        c = abstractMap$a = new AbstractMap$a(null);
    }

    public static final /* synthetic */ String b(AbstractMap abstractMap, Map.Entry entry) {
        return abstractMap.k(entry);
    }

    private final Map.Entry i(Object object) {
        Object t10;
        block1: {
            boolean bl2;
            Iterator iterator2 = this.entrySet().iterator();
            while (bl2 = iterator2.hasNext()) {
                Object object2 = t10 = iterator2.next();
                object2 = ((Map.Entry)t10).getKey();
                boolean bl3 = f0.g(object2, object);
                if (!bl3) continue;
                break block1;
            }
            bl2 = false;
            t10 = null;
        }
        return (Map.Entry)t10;
    }

    private final String j(Object object) {
        object = object == this ? "(this Map)" : String.valueOf(object);
        return object;
    }

    private final String k(Map.Entry object) {
        StringBuilder stringBuilder = new StringBuilder();
        Object object2 = object.getKey();
        object2 = this.j(object2);
        stringBuilder.append((String)object2);
        stringBuilder.append("=");
        object = object.getValue();
        object = this.j(object);
        stringBuilder.append((String)object);
        return stringBuilder.toString();
    }

    public final boolean c(Map.Entry entry) {
        boolean bl2 = entry instanceof Map.Entry;
        if (!bl2) {
            return false;
        }
        Object k10 = entry.getKey();
        entry = entry.getValue();
        Object v10 = this.get(k10);
        boolean bl3 = f0.g(entry, v10);
        boolean bl4 = true;
        if (bl3 ^= bl4) {
            return false;
        }
        if (v10 == null && !(bl3 = this.containsKey(k10))) {
            return false;
        }
        return bl4;
    }

    public void clear() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        throw unsupportedOperationException;
    }

    public boolean containsKey(Object object) {
        boolean bl2;
        if ((object = this.i(object)) != null) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    public boolean containsValue(Object object) {
        Object object2 = this.entrySet();
        boolean bl2 = object2 instanceof Collection;
        boolean bl3 = false;
        if (!bl2 || !(bl2 = object2.isEmpty())) {
            object2 = object2.iterator();
            while (bl2 = object2.hasNext()) {
                Object v10 = ((Map.Entry)object2.next()).getValue();
                bl2 = f0.g(v10, object);
                if (!bl2) continue;
                bl3 = true;
                break;
            }
        }
        return bl3;
    }

    public abstract Set e();

    public boolean equals(Object object) {
        int n10;
        boolean bl2 = true;
        if (object == this) {
            return bl2;
        }
        int n11 = object instanceof Map;
        if (n11 == 0) {
            return false;
        }
        n11 = this.size();
        if (n11 != (n10 = (object = (Map)object).size())) {
            return false;
        }
        n11 = (object = object.entrySet()) instanceof Collection;
        if (n11 == 0 || (n11 = (int)(((Collection)object).isEmpty() ? 1 : 0)) == 0) {
            object = ((Iterable)object).iterator();
            while ((n11 = (int)(object.hasNext() ? 1 : 0)) != 0) {
                Map.Entry entry = (Map.Entry)object.next();
                n11 = (int)(this.c(entry) ? 1 : 0);
                if (n11 != 0) continue;
                bl2 = false;
                break;
            }
        }
        return bl2;
    }

    public Set f() {
        Set set = this.a;
        if (set == null) {
            this.a = set = new AbstractMap$b(this);
        }
        set = this.a;
        f0.m(set);
        return set;
    }

    public int g() {
        return this.entrySet().size();
    }

    public Object get(Object object) {
        object = (object = this.i(object)) != null ? object.getValue() : null;
        return object;
    }

    public Collection h() {
        Collection collection = this.b;
        if (collection == null) {
            this.b = collection = new AbstractMap$c(this);
        }
        collection = this.b;
        f0.m(collection);
        return collection;
    }

    public int hashCode() {
        return ((Object)this.entrySet()).hashCode();
    }

    public boolean isEmpty() {
        int n10 = this.size();
        n10 = n10 == 0 ? 1 : 0;
        return n10 != 0;
    }

    public Object put(Object object, Object object2) {
        object = new UnsupportedOperationException("Operation is not supported for read-only collection");
        throw object;
    }

    public void putAll(Map object) {
        object = new UnsupportedOperationException("Operation is not supported for read-only collection");
        throw object;
    }

    public Object remove(Object object) {
        object = new UnsupportedOperationException("Operation is not supported for read-only collection");
        throw object;
    }

    public String toString() {
        Set set = this.entrySet();
        AbstractMap$toString$1 abstractMap$toString$1 = new AbstractMap$toString$1(this);
        return CollectionsKt___CollectionsKt.X2(set, ", ", "{", "}", 0, null, abstractMap$toString$1, 24, null);
    }
}

