/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.upstream.Allocation;

public final class SampleDataQueue$AllocationNode {
    public Allocation allocation;
    public final long endPosition;
    public SampleDataQueue$AllocationNode next;
    public final long startPosition;
    public boolean wasInitialized;

    public SampleDataQueue$AllocationNode(long l10, int n10) {
        this.startPosition = l10;
        long l11 = n10;
        this.endPosition = l10 += l11;
    }

    public SampleDataQueue$AllocationNode clear() {
        this.allocation = null;
        SampleDataQueue$AllocationNode sampleDataQueue$AllocationNode = this.next;
        this.next = null;
        return sampleDataQueue$AllocationNode;
    }

    public void initialize(Allocation allocation, SampleDataQueue$AllocationNode sampleDataQueue$AllocationNode) {
        this.allocation = allocation;
        this.next = sampleDataQueue$AllocationNode;
        this.wasInitialized = true;
    }

    public int translateOffset(long l10) {
        long l11 = this.startPosition;
        int n10 = (int)(l10 - l11);
        int n11 = this.allocation.offset;
        return n10 + n11;
    }
}

