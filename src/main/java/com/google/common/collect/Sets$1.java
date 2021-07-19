/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.ImmutableCollection$Builder;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSet$Builder;
import com.google.common.collect.Sets$1$1;
import com.google.common.collect.Sets$SetView;
import com.google.common.collect.UnmodifiableIterator;
import java.util.Iterator;
import java.util.Set;

public final class Sets$1
extends Sets$SetView {
    public final /* synthetic */ Set val$set1;
    public final /* synthetic */ Set val$set2;

    public Sets$1(Set set, Set set2) {
        this.val$set1 = set;
        this.val$set2 = set2;
        super(null);
    }

    public boolean contains(Object object) {
        boolean bl2;
        Set set = this.val$set1;
        boolean bl3 = set.contains(object);
        if (!bl3 && !(bl2 = (set = this.val$set2).contains(object))) {
            bl2 = false;
            object = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }

    public Set copyInto(Set set) {
        Set set2 = this.val$set1;
        set.addAll(set2);
        set2 = this.val$set2;
        set.addAll(set2);
        return set;
    }

    public ImmutableSet immutableCopy() {
        ImmutableCollection$Builder immutableCollection$Builder = new ImmutableSet$Builder();
        Set set = this.val$set1;
        immutableCollection$Builder = ((ImmutableSet$Builder)immutableCollection$Builder).addAll(set);
        set = this.val$set2;
        return ((ImmutableSet$Builder)((ImmutableSet$Builder)immutableCollection$Builder).addAll(set)).build();
    }

    public boolean isEmpty() {
        Set set = this.val$set1;
        boolean bl2 = set.isEmpty();
        if (bl2 && (bl2 = (set = this.val$set2).isEmpty())) {
            bl2 = true;
        } else {
            bl2 = false;
            set = null;
        }
        return bl2;
    }

    public UnmodifiableIterator iterator() {
        Sets$1$1 sets$1$1 = new Sets$1$1(this);
        return sets$1$1;
    }

    public int size() {
        boolean bl2;
        Set set = this.val$set1;
        int n10 = set.size();
        Iterator iterator2 = this.val$set2.iterator();
        while (bl2 = iterator2.hasNext()) {
            Set set2 = this.val$set1;
            Object e10 = iterator2.next();
            bl2 = set2.contains(e10);
            if (bl2) continue;
            ++n10;
        }
        return n10;
    }
}

