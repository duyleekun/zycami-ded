/*
 * Decompiled with CFR 0.151.
 */
package c.a.l;

import c.a.l.b;
import c.a.l.j;
import c.a.l.j$a;
import c.a.l.l;
import c.b.a.c;
import java.util.LinkedHashMap;

public final class j$b {
    private final LinkedHashMap a;

    private j$b(int n10) {
        LinkedHashMap linkedHashMap;
        this.a = linkedHashMap = b.d(n10);
    }

    public /* synthetic */ j$b(int n10, j$a j$a) {
        this(n10);
    }

    public j a() {
        LinkedHashMap linkedHashMap = this.a;
        j j10 = new j(linkedHashMap, null);
        return j10;
    }

    public j$b b(Object object, c object2) {
        LinkedHashMap linkedHashMap = this.a;
        object = l.b(object, "key");
        object2 = l.b(object2, "provider");
        linkedHashMap.put(object, object2);
        return this;
    }
}

