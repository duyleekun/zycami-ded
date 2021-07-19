/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.collect.TransformedIterator;
import java.util.Iterator;

public final class Iterators$6
extends TransformedIterator {
    public final /* synthetic */ Function val$function;

    public Iterators$6(Iterator iterator2, Function function) {
        this.val$function = function;
        super(iterator2);
    }

    public Object transform(Object object) {
        return this.val$function.apply(object);
    }
}

