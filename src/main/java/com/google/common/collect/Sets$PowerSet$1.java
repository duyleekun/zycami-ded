/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.AbstractIndexedListIterator;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Sets$PowerSet;
import com.google.common.collect.Sets$SubSet;
import java.util.Set;

public class Sets$PowerSet$1
extends AbstractIndexedListIterator {
    public final /* synthetic */ Sets$PowerSet this$0;

    public Sets$PowerSet$1(Sets$PowerSet sets$PowerSet, int n10) {
        this.this$0 = sets$PowerSet;
        super(n10);
    }

    public Set get(int n10) {
        ImmutableMap immutableMap = this.this$0.inputSet;
        Sets$SubSet sets$SubSet = new Sets$SubSet(immutableMap, n10);
        return sets$SubSet;
    }
}

