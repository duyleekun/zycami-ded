/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.AbstractMapBasedMultimap;
import com.google.common.collect.AbstractMapBasedMultimap$AsMap;
import com.google.common.collect.AbstractMapBasedMultimap$AsMap$AsMapIterator;
import com.google.common.collect.Collections2;
import com.google.common.collect.Maps$EntrySet;
import java.util.Iterator;
import java.util.Map;

public class AbstractMapBasedMultimap$AsMap$AsMapEntries
extends Maps$EntrySet {
    public final /* synthetic */ AbstractMapBasedMultimap$AsMap this$1;

    public AbstractMapBasedMultimap$AsMap$AsMapEntries(AbstractMapBasedMultimap$AsMap abstractMapBasedMultimap$AsMap) {
        this.this$1 = abstractMapBasedMultimap$AsMap;
    }

    public boolean contains(Object object) {
        return Collections2.safeContains(this.this$1.submap.entrySet(), object);
    }

    public Iterator iterator() {
        AbstractMapBasedMultimap$AsMap abstractMapBasedMultimap$AsMap = this.this$1;
        AbstractMapBasedMultimap$AsMap$AsMapIterator abstractMapBasedMultimap$AsMap$AsMapIterator = new AbstractMapBasedMultimap$AsMap$AsMapIterator(abstractMapBasedMultimap$AsMap);
        return abstractMapBasedMultimap$AsMap$AsMapIterator;
    }

    public Map map() {
        return this.this$1;
    }

    public boolean remove(Object object) {
        boolean bl2 = this.contains(object);
        if (!bl2) {
            return false;
        }
        object = (Map.Entry)object;
        AbstractMapBasedMultimap abstractMapBasedMultimap = this.this$1.this$0;
        object = object.getKey();
        AbstractMapBasedMultimap.access$300(abstractMapBasedMultimap, object);
        return true;
    }
}

