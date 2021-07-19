/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.AbstractMultimap;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multimaps$Entries;
import java.util.Iterator;

public class AbstractMultimap$Entries
extends Multimaps$Entries {
    public final /* synthetic */ AbstractMultimap this$0;

    public AbstractMultimap$Entries(AbstractMultimap abstractMultimap) {
        this.this$0 = abstractMultimap;
    }

    public Iterator iterator() {
        return this.this$0.entryIterator();
    }

    public Multimap multimap() {
        return this.this$0;
    }
}

