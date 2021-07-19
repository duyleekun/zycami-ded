/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.base;

import com.google.common.base.AbstractIterator;
import com.google.common.base.Optional;
import com.google.common.base.Optional$1;
import com.google.common.base.Preconditions;
import java.util.Iterator;

public class Optional$1$1
extends AbstractIterator {
    private final Iterator iterator;
    public final /* synthetic */ Optional$1 this$0;

    public Optional$1$1(Optional$1 object) {
        this.this$0 = object;
        this.iterator = object = (Iterator)Preconditions.checkNotNull(((Optional$1)object).val$optionals.iterator());
    }

    public Object computeNext() {
        Object object;
        boolean bl2;
        while (bl2 = (object = this.iterator).hasNext()) {
            object = (Optional)this.iterator.next();
            boolean bl3 = ((Optional)object).isPresent();
            if (!bl3) continue;
            return ((Optional)object).get();
        }
        return this.endOfData();
    }
}

