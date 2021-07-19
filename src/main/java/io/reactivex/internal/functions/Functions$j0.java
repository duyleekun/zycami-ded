/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.functions;

import e.a.v0.b;
import e.a.v0.o;
import java.util.Collection;
import java.util.Map;

public final class Functions$j0
implements b {
    private final o a;
    private final o b;
    private final o c;

    public Functions$j0(o o10, o o11, o o12) {
        this.a = o10;
        this.b = o11;
        this.c = o12;
    }

    public void a(Map object, Object object2) {
        Object object3 = this.c.apply(object2);
        Collection collection = (Collection)object.get(object3);
        if (collection == null) {
            collection = (Collection)this.a.apply(object3);
            object.put(object3, collection);
        }
        object = this.b.apply(object2);
        collection.add(object);
    }
}

