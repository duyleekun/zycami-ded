/*
 * Decompiled with CFR 0.151.
 */
package kotlin.collections;

import java.util.Iterator;
import kotlin.collections.AbstractCollection;
import kotlin.collections.AbstractMap;
import kotlin.collections.AbstractMap$c$a;

public final class AbstractMap$c
extends AbstractCollection {
    public final /* synthetic */ AbstractMap a;

    public AbstractMap$c(AbstractMap abstractMap) {
        this.a = abstractMap;
    }

    public int b() {
        return this.a.size();
    }

    public boolean contains(Object object) {
        return this.a.containsValue(object);
    }

    public Iterator iterator() {
        Iterator iterator2 = this.a.entrySet().iterator();
        AbstractMap$c$a abstractMap$c$a = new AbstractMap$c$a(iterator2);
        return abstractMap$c$a;
    }
}

