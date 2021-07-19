/*
 * Decompiled with CFR 0.151.
 */
package f.x1;

import f.h2.s.l;
import f.h2.t.f0;
import f.x1.w0;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

public final class x0
implements w0 {
    private final Map a;
    private final l b;

    public x0(Map map, l l10) {
        f0.p(map, "map");
        f0.p(l10, "default");
        this.a = map;
        this.b = l10;
    }

    public Map a() {
        return this.a;
    }

    public Set b() {
        return this.a().entrySet();
    }

    public Set c() {
        return this.a().keySet();
    }

    public void clear() {
        this.a().clear();
    }

    public boolean containsKey(Object object) {
        return this.a().containsKey(object);
    }

    public boolean containsValue(Object object) {
        return this.a().containsValue(object);
    }

    public Object d(Object object) {
        boolean bl2;
        Object object2 = this.a();
        Object object3 = object2.get(object);
        if (object3 == null && !(bl2 = object2.containsKey(object))) {
            object2 = this.b;
            object3 = object2.invoke(object);
        }
        return object3;
    }

    public int e() {
        return this.a().size();
    }

    public boolean equals(Object object) {
        return ((Object)this.a()).equals(object);
    }

    public Collection f() {
        return this.a().values();
    }

    public Object get(Object object) {
        return this.a().get(object);
    }

    public int hashCode() {
        return ((Object)this.a()).hashCode();
    }

    public boolean isEmpty() {
        return this.a().isEmpty();
    }

    public Object put(Object object, Object object2) {
        return this.a().put(object, object2);
    }

    public void putAll(Map map) {
        f0.p(map, "from");
        this.a().putAll(map);
    }

    public Object remove(Object object) {
        return this.a().remove(object);
    }

    public String toString() {
        return this.a().toString();
    }
}

