/*
 * Decompiled with CFR 0.151.
 */
package kotlin.collections;

import f.h2.t.f0;
import f.h2.t.x0.a;
import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import kotlin.collections.EmptyList;
import kotlin.collections.EmptySet;

public final class EmptyMap
implements Map,
Serializable,
a {
    public static final EmptyMap INSTANCE;
    private static final long serialVersionUID = 8246714829545688274L;

    static {
        EmptyMap emptyMap;
        INSTANCE = emptyMap = new EmptyMap();
    }

    private EmptyMap() {
    }

    private final Object readResolve() {
        return INSTANCE;
    }

    public void clear() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        throw unsupportedOperationException;
    }

    public boolean containsKey(Object object) {
        return false;
    }

    public boolean containsValue(Void void_) {
        f0.p(void_, "value");
        return false;
    }

    public boolean equals(Object object) {
        boolean bl2;
        boolean bl3 = object instanceof Map;
        if (bl3 && (bl2 = (object = (Map)object).isEmpty())) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    public Void get(Object object) {
        return null;
    }

    public Set getEntries() {
        return EmptySet.INSTANCE;
    }

    public Set getKeys() {
        return EmptySet.INSTANCE;
    }

    public int getSize() {
        return 0;
    }

    public Collection getValues() {
        return EmptyList.INSTANCE;
    }

    public int hashCode() {
        return 0;
    }

    public boolean isEmpty() {
        return true;
    }

    public /* synthetic */ Object put(Object object, Object object2) {
        object = new UnsupportedOperationException("Operation is not supported for read-only collection");
        throw object;
    }

    public Void put(Object object, Void void_) {
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
        return "{}";
    }
}

