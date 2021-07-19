/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.functions;

import e.a.v0.b;
import e.a.v0.o;
import java.util.Map;

public final class Functions$h0
implements b {
    private final o a;

    public Functions$h0(o o10) {
        this.a = o10;
    }

    public void a(Map map, Object object) {
        Object object2 = this.a.apply(object);
        map.put(object2, object);
    }
}

