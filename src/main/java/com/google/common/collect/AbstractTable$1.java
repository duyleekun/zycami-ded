/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.AbstractTable;
import com.google.common.collect.Table$Cell;
import com.google.common.collect.TransformedIterator;
import java.util.Iterator;

public class AbstractTable$1
extends TransformedIterator {
    public final /* synthetic */ AbstractTable this$0;

    public AbstractTable$1(AbstractTable abstractTable, Iterator iterator2) {
        this.this$0 = abstractTable;
        super(iterator2);
    }

    public Object transform(Table$Cell table$Cell) {
        return table$Cell.getValue();
    }
}

