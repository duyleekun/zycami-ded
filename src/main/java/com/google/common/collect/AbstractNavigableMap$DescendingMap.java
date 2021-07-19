/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.AbstractNavigableMap;
import com.google.common.collect.AbstractNavigableMap$1;
import com.google.common.collect.Maps$DescendingMap;
import java.util.Iterator;
import java.util.NavigableMap;

public final class AbstractNavigableMap$DescendingMap
extends Maps$DescendingMap {
    public final /* synthetic */ AbstractNavigableMap this$0;

    private AbstractNavigableMap$DescendingMap(AbstractNavigableMap abstractNavigableMap) {
        this.this$0 = abstractNavigableMap;
    }

    public /* synthetic */ AbstractNavigableMap$DescendingMap(AbstractNavigableMap abstractNavigableMap, AbstractNavigableMap$1 abstractNavigableMap$1) {
        this(abstractNavigableMap);
    }

    public Iterator entryIterator() {
        return this.this$0.descendingEntryIterator();
    }

    public NavigableMap forward() {
        return this.this$0;
    }
}

