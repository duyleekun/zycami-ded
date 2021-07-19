/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.Lists$AbstractListWrapper;
import java.util.List;
import java.util.RandomAccess;

public class Lists$RandomAccessListWrapper
extends Lists$AbstractListWrapper
implements RandomAccess {
    public Lists$RandomAccessListWrapper(List list) {
        super(list);
    }
}

