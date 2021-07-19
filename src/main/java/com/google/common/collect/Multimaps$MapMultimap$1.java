/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.Multimaps$MapMultimap;
import com.google.common.collect.Multimaps$MapMultimap$1$1;
import com.google.common.collect.Sets$ImprovedAbstractSet;
import java.util.Iterator;
import java.util.Map;

public class Multimaps$MapMultimap$1
extends Sets$ImprovedAbstractSet {
    public final /* synthetic */ Multimaps$MapMultimap this$0;
    public final /* synthetic */ Object val$key;

    public Multimaps$MapMultimap$1(Multimaps$MapMultimap multimaps$MapMultimap, Object object) {
        this.this$0 = multimaps$MapMultimap;
        this.val$key = object;
    }

    public Iterator iterator() {
        Multimaps$MapMultimap$1$1 multimaps$MapMultimap$1$1 = new Multimaps$MapMultimap$1$1(this);
        return multimaps$MapMultimap$1$1;
    }

    public int size() {
        Map map = this.this$0.map;
        Object object = this.val$key;
        return (int)(map.containsKey(object) ? 1 : 0);
    }
}

