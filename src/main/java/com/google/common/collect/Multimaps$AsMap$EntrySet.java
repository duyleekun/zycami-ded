/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.Maps;
import com.google.common.collect.Maps$EntrySet;
import com.google.common.collect.Multimaps$AsMap;
import com.google.common.collect.Multimaps$AsMap$EntrySet$1;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Multimaps$AsMap$EntrySet
extends Maps$EntrySet {
    public final /* synthetic */ Multimaps$AsMap this$0;

    public Multimaps$AsMap$EntrySet(Multimaps$AsMap multimaps$AsMap) {
        this.this$0 = multimaps$AsMap;
    }

    public Iterator iterator() {
        Set set = Multimaps$AsMap.access$200(this.this$0).keySet();
        Multimaps$AsMap$EntrySet$1 multimaps$AsMap$EntrySet$1 = new Multimaps$AsMap$EntrySet$1(this);
        return Maps.asMapEntryIterator(set, multimaps$AsMap$EntrySet$1);
    }

    public Map map() {
        return this.this$0;
    }

    public boolean remove(Object object) {
        boolean bl2 = this.contains(object);
        if (!bl2) {
            return false;
        }
        object = (Map.Entry)object;
        Multimaps$AsMap multimaps$AsMap = this.this$0;
        object = object.getKey();
        multimaps$AsMap.removeValuesForKey(object);
        return true;
    }
}

