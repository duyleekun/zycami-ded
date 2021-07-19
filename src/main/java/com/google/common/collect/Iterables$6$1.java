/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.CollectPreconditions;
import com.google.common.collect.Iterables$6;
import java.util.Iterator;

public class Iterables$6$1
implements Iterator {
    public boolean atStart = true;
    public final /* synthetic */ Iterables.6 this$0;
    public final /* synthetic */ Iterator val$iterator;

    public Iterables$6$1(Iterables.6 var1_1, Iterator iterator2) {
        this.this$0 = var1_1;
        this.val$iterator = iterator2;
    }

    public boolean hasNext() {
        return this.val$iterator.hasNext();
    }

    public Object next() {
        Object e10 = this.val$iterator.next();
        this.atStart = false;
        return e10;
    }

    public void remove() {
        CollectPreconditions.checkRemove(this.atStart ^ true);
        this.val$iterator.remove();
    }
}

