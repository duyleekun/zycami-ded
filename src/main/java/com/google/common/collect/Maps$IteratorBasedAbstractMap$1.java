/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.Maps$EntrySet;
import com.google.common.collect.Maps$IteratorBasedAbstractMap;
import java.util.Iterator;
import java.util.Map;

public class Maps$IteratorBasedAbstractMap$1
extends Maps$EntrySet {
    public final /* synthetic */ Maps$IteratorBasedAbstractMap this$0;

    public Maps$IteratorBasedAbstractMap$1(Maps$IteratorBasedAbstractMap maps$IteratorBasedAbstractMap) {
        this.this$0 = maps$IteratorBasedAbstractMap;
    }

    public Iterator iterator() {
        return this.this$0.entryIterator();
    }

    public Map map() {
        return this.this$0;
    }
}

