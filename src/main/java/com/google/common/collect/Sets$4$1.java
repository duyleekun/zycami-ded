/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.AbstractIterator;
import com.google.common.collect.Sets$4;
import java.util.Iterator;
import java.util.Set;

public class Sets$4$1
extends AbstractIterator {
    public final /* synthetic */ Sets$4 this$0;
    public final /* synthetic */ Iterator val$itr1;
    public final /* synthetic */ Iterator val$itr2;

    public Sets$4$1(Sets$4 sets$4, Iterator iterator2, Iterator iterator3) {
        this.this$0 = sets$4;
        this.val$itr1 = iterator2;
        this.val$itr2 = iterator3;
    }

    public Object computeNext() {
        boolean bl2;
        Set set;
        Iterator iterator2;
        boolean bl3;
        while (bl3 = (iterator2 = this.val$itr1).hasNext()) {
            set = this.this$0.val$set2;
            iterator2 = this.val$itr1.next();
            bl2 = set.contains(iterator2);
            if (bl2) continue;
            return iterator2;
        }
        while (bl3 = (iterator2 = this.val$itr2).hasNext()) {
            set = this.this$0.val$set1;
            iterator2 = this.val$itr2.next();
            bl2 = set.contains(iterator2);
            if (bl2) continue;
            return iterator2;
        }
        return this.endOfData();
    }
}

