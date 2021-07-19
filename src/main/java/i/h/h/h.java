/*
 * Decompiled with CFR 0.151.
 */
package i.h.h;

import i.h.a;
import i.h.c;
import i.h.h.g;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;

public class h
implements a {
    public boolean a = false;
    public final Map b;
    public final LinkedBlockingQueue c;

    public h() {
        Serializable serializable;
        this.b = serializable = new Serializable();
        this.c = serializable;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public c a(String string2) {
        synchronized (this) {
            Object object = this.b;
            object = object.get(string2);
            object = (g)object;
            if (object == null) {
                Object object2 = this.c;
                boolean bl2 = this.a;
                object = new g(string2, (Queue)object2, bl2);
                object2 = this.b;
                object2.put(string2, object);
            }
            return object;
        }
    }

    public void b() {
        this.b.clear();
        this.c.clear();
    }

    public LinkedBlockingQueue c() {
        return this.c;
    }

    public List d() {
        Set set = this.b.keySet();
        ArrayList arrayList = new ArrayList(set);
        return arrayList;
    }

    public List e() {
        Collection collection = this.b.values();
        ArrayList arrayList = new ArrayList(collection);
        return arrayList;
    }

    public void f() {
        this.a = true;
    }
}

