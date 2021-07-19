/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.Sets$4$1;
import com.google.common.collect.Sets$SetView;
import com.google.common.collect.UnmodifiableIterator;
import java.util.Iterator;
import java.util.Set;

public final class Sets$4
extends Sets$SetView {
    public final /* synthetic */ Set val$set1;
    public final /* synthetic */ Set val$set2;

    public Sets$4(Set set, Set set2) {
        this.val$set1 = set;
        this.val$set2 = set2;
        super(null);
    }

    public boolean contains(Object object) {
        boolean bl2 = this.val$set1.contains(object);
        return this.val$set2.contains(object) ^ bl2;
    }

    public boolean isEmpty() {
        Set set = this.val$set1;
        Set set2 = this.val$set2;
        return set.equals(set2);
    }

    public UnmodifiableIterator iterator() {
        Iterator iterator2 = this.val$set1.iterator();
        Iterator iterator3 = this.val$set2.iterator();
        Sets$4$1 sets$4$1 = new Sets$4$1(this, iterator2, iterator3);
        return sets$4$1;
    }

    public int size() {
        Object e10;
        Set set;
        boolean bl2;
        Iterator iterator2 = this.val$set1.iterator();
        int n10 = 0;
        while (bl2 = iterator2.hasNext()) {
            set = this.val$set2;
            e10 = iterator2.next();
            bl2 = set.contains(e10);
            if (bl2) continue;
            ++n10;
        }
        iterator2 = this.val$set2.iterator();
        while (bl2 = iterator2.hasNext()) {
            set = this.val$set1;
            e10 = iterator2.next();
            bl2 = set.contains(e10);
            if (bl2) continue;
            ++n10;
        }
        return n10;
    }
}

