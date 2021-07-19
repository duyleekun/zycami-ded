/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Predicate;
import com.google.common.collect.Maps$FilteredEntryMap;
import com.google.common.collect.Maps$FilteredEntryNavigableMap;
import com.google.common.collect.Maps$NavigableKeySet;
import java.util.Collection;
import java.util.NavigableMap;

public class Maps$FilteredEntryNavigableMap$1
extends Maps$NavigableKeySet {
    public final /* synthetic */ Maps$FilteredEntryNavigableMap this$0;

    public Maps$FilteredEntryNavigableMap$1(Maps$FilteredEntryNavigableMap maps$FilteredEntryNavigableMap, NavigableMap navigableMap) {
        this.this$0 = maps$FilteredEntryNavigableMap;
        super(navigableMap);
    }

    public boolean removeAll(Collection collection) {
        NavigableMap navigableMap = Maps$FilteredEntryNavigableMap.access$600(this.this$0);
        Predicate predicate = Maps$FilteredEntryNavigableMap.access$500(this.this$0);
        return Maps$FilteredEntryMap.removeAllKeys(navigableMap, predicate, collection);
    }

    public boolean retainAll(Collection collection) {
        NavigableMap navigableMap = Maps$FilteredEntryNavigableMap.access$600(this.this$0);
        Predicate predicate = Maps$FilteredEntryNavigableMap.access$500(this.this$0);
        return Maps$FilteredEntryMap.retainAllKeys(navigableMap, predicate, collection);
    }
}

