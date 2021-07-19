/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists$TransformingSequentialList$1;
import java.io.Serializable;
import java.util.AbstractSequentialList;
import java.util.List;
import java.util.ListIterator;

public class Lists$TransformingSequentialList
extends AbstractSequentialList
implements Serializable {
    private static final long serialVersionUID;
    public final List fromList;
    public final Function function;

    public Lists$TransformingSequentialList(List object, Function function) {
        object = (List)Preconditions.checkNotNull(object);
        this.fromList = object;
        this.function = object = (Function)Preconditions.checkNotNull(function);
    }

    public void clear() {
        this.fromList.clear();
    }

    public ListIterator listIterator(int n10) {
        ListIterator listIterator = this.fromList.listIterator(n10);
        Lists$TransformingSequentialList$1 lists$TransformingSequentialList$1 = new Lists$TransformingSequentialList$1(this, listIterator);
        return lists$TransformingSequentialList$1;
    }

    public int size() {
        return this.fromList.size();
    }
}

