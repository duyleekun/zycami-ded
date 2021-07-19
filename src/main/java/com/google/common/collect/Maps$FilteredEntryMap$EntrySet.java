/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.ForwardingSet;
import com.google.common.collect.Maps$1;
import com.google.common.collect.Maps$FilteredEntryMap;
import com.google.common.collect.Maps$FilteredEntryMap$EntrySet$1;
import java.util.Iterator;
import java.util.Set;

public class Maps$FilteredEntryMap$EntrySet
extends ForwardingSet {
    public final /* synthetic */ Maps$FilteredEntryMap this$0;

    private Maps$FilteredEntryMap$EntrySet(Maps$FilteredEntryMap maps$FilteredEntryMap) {
        this.this$0 = maps$FilteredEntryMap;
    }

    public /* synthetic */ Maps$FilteredEntryMap$EntrySet(Maps$FilteredEntryMap maps$FilteredEntryMap, Maps$1 maps$1) {
        this(maps$FilteredEntryMap);
    }

    public Set delegate() {
        return this.this$0.filteredEntrySet;
    }

    public Iterator iterator() {
        Iterator iterator2 = this.this$0.filteredEntrySet.iterator();
        Maps$FilteredEntryMap$EntrySet$1 maps$FilteredEntryMap$EntrySet$1 = new Maps$FilteredEntryMap$EntrySet$1(this, iterator2);
        return maps$FilteredEntryMap$EntrySet$1;
    }
}

