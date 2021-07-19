/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.AbstractIterator;
import com.google.common.collect.Sets$1;
import java.util.Iterator;
import java.util.Set;

public class Sets$1$1
extends AbstractIterator {
    public final Iterator itr1;
    public final Iterator itr2;
    public final /* synthetic */ Sets$1 this$0;

    public Sets$1$1(Sets$1 object) {
        Iterator iterator2;
        this.this$0 = object;
        this.itr1 = iterator2 = ((Sets$1)object).val$set1.iterator();
        this.itr2 = object = ((Sets$1)object).val$set2.iterator();
    }

    public Object computeNext() {
        Iterator iterator2 = this.itr1;
        boolean bl2 = iterator2.hasNext();
        if (bl2) {
            return this.itr1.next();
        }
        while (bl2 = (iterator2 = this.itr2).hasNext()) {
            Set set = this.this$0.val$set1;
            iterator2 = this.itr2.next();
            boolean bl3 = set.contains(iterator2);
            if (bl3) continue;
            return iterator2;
        }
        return this.endOfData();
    }
}

