/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.AbstractIterator;
import com.google.common.collect.ContiguousSet;
import com.google.common.collect.DiscreteDomain;
import com.google.common.collect.ImmutableRangeSet;
import com.google.common.collect.ImmutableRangeSet$AsSet;
import com.google.common.collect.Iterators;
import com.google.common.collect.Range;
import java.util.Iterator;

public class ImmutableRangeSet$AsSet$1
extends AbstractIterator {
    public Iterator elemItr;
    public final Iterator rangeItr;
    public final /* synthetic */ ImmutableRangeSet$AsSet this$1;

    public ImmutableRangeSet$AsSet$1(ImmutableRangeSet$AsSet object) {
        this.this$1 = object;
        this.rangeItr = object = ImmutableRangeSet.access$000(((ImmutableRangeSet$AsSet)object).this$0).iterator();
        this.elemItr = object = Iterators.emptyIterator();
    }

    public Comparable computeNext() {
        Object object;
        boolean bl2;
        while (!(bl2 = (object = this.elemItr).hasNext())) {
            object = this.rangeItr;
            bl2 = object.hasNext();
            if (bl2) {
                object = (Range)this.rangeItr.next();
                DiscreteDomain discreteDomain = ImmutableRangeSet$AsSet.access$100(this.this$1);
                this.elemItr = object = ContiguousSet.create((Range)object, discreteDomain).iterator();
                continue;
            }
            return (Comparable)this.endOfData();
        }
        return (Comparable)this.elemItr.next();
    }
}

