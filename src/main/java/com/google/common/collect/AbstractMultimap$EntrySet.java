/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.AbstractMultimap;
import com.google.common.collect.AbstractMultimap$Entries;
import com.google.common.collect.Sets;
import java.util.Set;

public class AbstractMultimap$EntrySet
extends AbstractMultimap$Entries
implements Set {
    public final /* synthetic */ AbstractMultimap this$0;

    public AbstractMultimap$EntrySet(AbstractMultimap abstractMultimap) {
        this.this$0 = abstractMultimap;
        super(abstractMultimap);
    }

    public boolean equals(Object object) {
        return Sets.equalsImpl(this, object);
    }

    public int hashCode() {
        return Sets.hashCodeImpl(this);
    }
}

