/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.Maps$FilteredEntryMap$EntrySet;
import com.google.common.collect.Maps$FilteredEntryMap$EntrySet$1$1;
import com.google.common.collect.TransformedIterator;
import java.util.Iterator;
import java.util.Map;

public class Maps$FilteredEntryMap$EntrySet$1
extends TransformedIterator {
    public final /* synthetic */ Maps$FilteredEntryMap.EntrySet this$1;

    public Maps$FilteredEntryMap$EntrySet$1(Maps$FilteredEntryMap.EntrySet entrySet, Iterator iterator2) {
        this.this$1 = entrySet;
        super(iterator2);
    }

    public Map.Entry transform(Map.Entry entry) {
        Maps$FilteredEntryMap$EntrySet$1$1 maps$FilteredEntryMap$EntrySet$1$1 = new Maps$FilteredEntryMap$EntrySet$1$1(this, entry);
        return maps$FilteredEntryMap$EntrySet$1$1;
    }
}

