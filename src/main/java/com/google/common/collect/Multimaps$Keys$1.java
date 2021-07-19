/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.Multimaps$Keys;
import com.google.common.collect.Multimaps$Keys$1$1;
import com.google.common.collect.Multiset$Entry;
import com.google.common.collect.TransformedIterator;
import java.util.Iterator;
import java.util.Map;

public class Multimaps$Keys$1
extends TransformedIterator {
    public final /* synthetic */ Multimaps.Keys this$0;

    public Multimaps$Keys$1(Multimaps.Keys keys, Iterator iterator2) {
        this.this$0 = keys;
        super(iterator2);
    }

    public Multiset$Entry transform(Map.Entry entry) {
        Multimaps$Keys$1$1 multimaps$Keys$1$1 = new Multimaps$Keys$1$1(this, entry);
        return multimaps$Keys$1$1;
    }
}

