/*
 * Decompiled with CFR 0.151.
 */
package c.a.l;

import c.a.l.b;
import c.a.l.i;
import c.a.l.i$a;
import c.a.l.l;
import c.b.a.c;
import java.util.LinkedHashMap;

public final class i$b {
    private final LinkedHashMap a;

    private i$b(int n10) {
        LinkedHashMap linkedHashMap;
        this.a = linkedHashMap = b.d(n10);
    }

    public /* synthetic */ i$b(int n10, i$a i$a) {
        this(n10);
    }

    public i a() {
        LinkedHashMap linkedHashMap = this.a;
        i i10 = new i(linkedHashMap, null);
        return i10;
    }

    public i$b b(Object object, c object2) {
        LinkedHashMap linkedHashMap = this.a;
        object = l.b(object, "key");
        object2 = l.b(object2, "provider");
        linkedHashMap.put(object, object2);
        return this;
    }
}

