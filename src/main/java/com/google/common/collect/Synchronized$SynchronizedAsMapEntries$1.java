/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.Synchronized$SynchronizedAsMapEntries;
import com.google.common.collect.Synchronized$SynchronizedAsMapEntries$1$1;
import com.google.common.collect.TransformedIterator;
import java.util.Iterator;
import java.util.Map;

public class Synchronized$SynchronizedAsMapEntries$1
extends TransformedIterator {
    public final /* synthetic */ Synchronized.SynchronizedAsMapEntries this$0;

    public Synchronized$SynchronizedAsMapEntries$1(Synchronized.SynchronizedAsMapEntries synchronizedAsMapEntries, Iterator iterator2) {
        this.this$0 = synchronizedAsMapEntries;
        super(iterator2);
    }

    public Map.Entry transform(Map.Entry entry) {
        Synchronized$SynchronizedAsMapEntries$1$1 synchronized$SynchronizedAsMapEntries$1$1 = new Synchronized$SynchronizedAsMapEntries$1$1(this, entry);
        return synchronized$SynchronizedAsMapEntries$1$1;
    }
}

