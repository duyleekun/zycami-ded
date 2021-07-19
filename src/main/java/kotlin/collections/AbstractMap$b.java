/*
 * Decompiled with CFR 0.151.
 */
package kotlin.collections;

import f.x1.h;
import java.util.Iterator;
import kotlin.collections.AbstractMap;
import kotlin.collections.AbstractMap$b$a;

public final class AbstractMap$b
extends h {
    public final /* synthetic */ AbstractMap b;

    public AbstractMap$b(AbstractMap abstractMap) {
        this.b = abstractMap;
    }

    public int b() {
        return this.b.size();
    }

    public boolean contains(Object object) {
        return this.b.containsKey(object);
    }

    public Iterator iterator() {
        Iterator iterator2 = this.b.entrySet().iterator();
        AbstractMap$b$a abstractMap$b$a = new AbstractMap$b$a(iterator2);
        return abstractMap$b$a;
    }
}

