/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.AbstractIterator;
import com.google.common.collect.Sets$3;
import java.util.Iterator;
import java.util.Set;

public class Sets$3$1
extends AbstractIterator {
    public final Iterator itr;
    public final /* synthetic */ Sets$3 this$0;

    public Sets$3$1(Sets$3 object) {
        this.this$0 = object;
        this.itr = object = ((Sets$3)object).val$set1.iterator();
    }

    public Object computeNext() {
        Iterator iterator2;
        boolean bl2;
        while (bl2 = (iterator2 = this.itr).hasNext()) {
            Set set = this.this$0.val$set2;
            iterator2 = this.itr.next();
            boolean bl3 = set.contains(iterator2);
            if (bl3) continue;
            return iterator2;
        }
        return this.endOfData();
    }
}

