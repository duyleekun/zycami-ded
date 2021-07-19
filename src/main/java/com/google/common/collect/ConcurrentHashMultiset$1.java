/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.Collections2;
import com.google.common.collect.ConcurrentHashMultiset;
import com.google.common.collect.ForwardingSet;
import java.util.Collection;
import java.util.Set;

public class ConcurrentHashMultiset$1
extends ForwardingSet {
    public final /* synthetic */ ConcurrentHashMultiset this$0;
    public final /* synthetic */ Set val$delegate;

    public ConcurrentHashMultiset$1(ConcurrentHashMultiset concurrentHashMultiset, Set set) {
        this.this$0 = concurrentHashMultiset;
        this.val$delegate = set;
    }

    public boolean contains(Object object) {
        Set set;
        boolean bl2;
        if (object != null && (bl2 = Collections2.safeContains(set = this.val$delegate, object))) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    public boolean containsAll(Collection collection) {
        return this.standardContainsAll(collection);
    }

    public Set delegate() {
        return this.val$delegate;
    }

    public boolean remove(Object object) {
        Set set;
        boolean bl2;
        if (object != null && (bl2 = Collections2.safeRemove(set = this.val$delegate, object))) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    public boolean removeAll(Collection collection) {
        return this.standardRemoveAll(collection);
    }
}

