/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.SmallSortedMap;
import com.google.protobuf.SmallSortedMap$1;
import com.google.protobuf.SmallSortedMap$DescendingEntryIterator;
import com.google.protobuf.SmallSortedMap$EntrySet;
import java.util.Iterator;

public class SmallSortedMap$DescendingEntrySet
extends SmallSortedMap$EntrySet {
    public final /* synthetic */ SmallSortedMap this$0;

    private SmallSortedMap$DescendingEntrySet(SmallSortedMap smallSortedMap) {
        this.this$0 = smallSortedMap;
        super(smallSortedMap, null);
    }

    public /* synthetic */ SmallSortedMap$DescendingEntrySet(SmallSortedMap smallSortedMap, SmallSortedMap$1 smallSortedMap$1) {
        this(smallSortedMap);
    }

    public Iterator iterator() {
        SmallSortedMap smallSortedMap = this.this$0;
        SmallSortedMap$DescendingEntryIterator smallSortedMap$DescendingEntryIterator = new SmallSortedMap$DescendingEntryIterator(smallSortedMap, null);
        return smallSortedMap$DescendingEntryIterator;
    }
}

