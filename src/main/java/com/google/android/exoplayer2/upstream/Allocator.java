/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.upstream;

import com.google.android.exoplayer2.upstream.Allocation;

public interface Allocator {
    public Allocation allocate();

    public int getIndividualAllocationLength();

    public int getTotalBytesAllocated();

    public void release(Allocation var1);

    public void release(Allocation[] var1);

    public void trim();
}

