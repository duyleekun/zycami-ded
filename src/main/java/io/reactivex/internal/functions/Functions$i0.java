/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.functions;

import e.a.v0.b;
import e.a.v0.o;
import java.util.Map;

public final class Functions$i0
implements b {
    private final o a;
    private final o b;

    public Functions$i0(o o10, o o11) {
        this.a = o10;
        this.b = o11;
    }

    public void a(Map map, Object object) {
        Object object2 = this.b.apply(object);
        object = this.a.apply(object);
        map.put(object2, object);
    }
}

