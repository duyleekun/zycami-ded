/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.Lists$Partition;
import java.util.List;
import java.util.RandomAccess;

public class Lists$RandomAccessPartition
extends Lists$Partition
implements RandomAccess {
    public Lists$RandomAccessPartition(List list, int n10) {
        super(list, n10);
    }
}

