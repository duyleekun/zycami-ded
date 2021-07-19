/*
 * Decompiled with CFR 0.151.
 */
package j$.time.r;

import j$.time.r.c;
import j$.time.r.d;
import j$.time.r.e;
import java.io.Serializable;
import java.security.AccessController;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArrayList;

public abstract class g {
    private static final CopyOnWriteArrayList a;
    private static final ConcurrentMap b;

    static {
        Serializable serializable;
        CopyOnWriteArrayList copyOnWriteArrayList;
        a = copyOnWriteArrayList = new CopyOnWriteArrayList();
        b = serializable = new Serializable(512, 0.75f, 2);
        serializable = new Serializable();
        e e10 = new e((List)((Object)serializable));
        AccessController.doPrivileged(e10);
        copyOnWriteArrayList.addAll(serializable);
    }

    protected g() {
    }

    public static c a(String object, boolean bl2) {
        Objects.requireNonNull(object, "zoneId");
        Object object2 = b;
        g g10 = (g)object2.get(object);
        if (g10 == null) {
            bl2 = object2.isEmpty();
            if (bl2) {
                object = new d("No time-zone data files registered");
                throw object;
            }
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("Unknown time-zone ID: ");
            ((StringBuilder)object2).append((String)object);
            object = ((StringBuilder)object2).toString();
            d d10 = new d((String)object);
            throw d10;
        }
        return g10.b((String)object, bl2);
    }

    public static void d(g object) {
        boolean bl2;
        Objects.requireNonNull(object, "provider");
        Object object2 = ((g)object).c().iterator();
        while (bl2 = object2.hasNext()) {
            String string2 = (String)object2.next();
            Objects.requireNonNull(string2, "zoneId");
            Object object3 = b.putIfAbsent(string2, object);
            if (object3 == null) continue;
            object3 = new StringBuilder();
            ((StringBuilder)object3).append("Unable to register zone as one already registered with that ID: ");
            ((StringBuilder)object3).append(string2);
            ((StringBuilder)object3).append(", currently loading from provider: ");
            ((StringBuilder)object3).append(object);
            object = ((StringBuilder)object3).toString();
            object2 = new d((String)object);
            throw object2;
        }
        a.add(object);
    }

    protected abstract c b(String var1, boolean var2);

    protected abstract Set c();
}

