/*
 * Decompiled with CFR 0.151.
 */
package i.h.h;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.slf4j.Marker;
import org.slf4j.helpers.BasicMarker;

public class b
implements i.h.b {
    private final ConcurrentMap a;

    public b() {
        ConcurrentHashMap concurrentHashMap;
        this.a = concurrentHashMap = new ConcurrentHashMap();
    }

    public Marker a(String object) {
        if (object != null) {
            ConcurrentMap concurrentMap;
            Object object2 = (Marker)this.a.get(object);
            if (object2 == null && (object = (concurrentMap = this.a).putIfAbsent(object, object2 = new BasicMarker((String)object))) != null) {
                object2 = object;
            }
            return object2;
        }
        object = new IllegalArgumentException("Marker name cannot be null");
        throw object;
    }

    public boolean b(String string2) {
        boolean bl2 = false;
        if (string2 == null) {
            return false;
        }
        ConcurrentMap concurrentMap = this.a;
        if ((string2 = concurrentMap.remove(string2)) != null) {
            bl2 = true;
        }
        return bl2;
    }

    public Marker c(String string2) {
        BasicMarker basicMarker = new BasicMarker(string2);
        return basicMarker;
    }

    public boolean d(String string2) {
        if (string2 == null) {
            return false;
        }
        return this.a.containsKey(string2);
    }
}

