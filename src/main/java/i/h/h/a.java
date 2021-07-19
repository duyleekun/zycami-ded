/*
 * Decompiled with CFR 0.151.
 */
package i.h.h;

import i.h.h.a$a;
import i.h.i.c;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class a
implements c {
    private InheritableThreadLocal a;

    public a() {
        a$a a$a = new a$a(this);
        this.a = a$a;
    }

    public void a(String object, String string2) {
        if (object != null) {
            HashMap<Object, String> hashMap = (HashMap<Object, String>)this.a.get();
            if (hashMap == null) {
                hashMap = new HashMap<Object, String>();
                InheritableThreadLocal inheritableThreadLocal = this.a;
                inheritableThreadLocal.set(hashMap);
            }
            hashMap.put(object, string2);
            return;
        }
        object = new IllegalArgumentException("key cannot be null");
        throw object;
    }

    public Map b() {
        Map map = (Map)this.a.get();
        if (map != null) {
            HashMap hashMap = new HashMap(map);
            return hashMap;
        }
        return null;
    }

    public void c(Map map) {
        InheritableThreadLocal inheritableThreadLocal = this.a;
        HashMap hashMap = new HashMap(map);
        inheritableThreadLocal.set(hashMap);
    }

    public void clear() {
        Object object = (Map)this.a.get();
        if (object != null) {
            object.clear();
            object = this.a;
            ((ThreadLocal)object).remove();
        }
    }

    public void d(String string2) {
        Map map = (Map)this.a.get();
        if (map != null) {
            map.remove(string2);
        }
    }

    public Set e() {
        Map map = (Map)this.a.get();
        if (map != null) {
            return map.keySet();
        }
        return null;
    }

    public String get(String string2) {
        Map map = (Map)this.a.get();
        if (map != null && string2 != null) {
            return (String)map.get(string2);
        }
        return null;
    }
}

