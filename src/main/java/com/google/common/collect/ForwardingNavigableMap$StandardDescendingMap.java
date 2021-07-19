/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.ForwardingNavigableMap;
import com.google.common.collect.ForwardingNavigableMap$StandardDescendingMap$1;
import com.google.common.collect.Maps$DescendingMap;
import java.util.Iterator;
import java.util.NavigableMap;

public class ForwardingNavigableMap$StandardDescendingMap
extends Maps$DescendingMap {
    public final /* synthetic */ ForwardingNavigableMap this$0;

    public ForwardingNavigableMap$StandardDescendingMap(ForwardingNavigableMap forwardingNavigableMap) {
        this.this$0 = forwardingNavigableMap;
    }

    public Iterator entryIterator() {
        ForwardingNavigableMap$StandardDescendingMap$1 forwardingNavigableMap$StandardDescendingMap$1 = new ForwardingNavigableMap$StandardDescendingMap$1(this);
        return forwardingNavigableMap$StandardDescendingMap$1;
    }

    public NavigableMap forward() {
        return this.this$0;
    }
}

