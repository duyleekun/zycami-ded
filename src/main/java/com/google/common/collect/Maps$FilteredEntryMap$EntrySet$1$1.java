/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.ForwardingMapEntry;
import com.google.common.collect.Maps$FilteredEntryMap;
import com.google.common.collect.Maps$FilteredEntryMap$EntrySet$1;
import java.util.Map;

public class Maps$FilteredEntryMap$EntrySet$1$1
extends ForwardingMapEntry {
    public final /* synthetic */ Maps$FilteredEntryMap$EntrySet$1 this$2;
    public final /* synthetic */ Map.Entry val$entry;

    public Maps$FilteredEntryMap$EntrySet$1$1(Maps$FilteredEntryMap$EntrySet$1 maps$FilteredEntryMap$EntrySet$1, Map.Entry entry) {
        this.this$2 = maps$FilteredEntryMap$EntrySet$1;
        this.val$entry = entry;
    }

    public Map.Entry delegate() {
        return this.val$entry;
    }

    public Object setValue(Object object) {
        Maps$FilteredEntryMap maps$FilteredEntryMap = this.this$2.this$1.this$0;
        Object object2 = this.getKey();
        Preconditions.checkArgument(maps$FilteredEntryMap.apply(object2, object));
        return super.setValue(object);
    }
}

