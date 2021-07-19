/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.upstream;

import com.google.android.exoplayer2.upstream.Allocation;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.util.Arrays;

public final class DefaultAllocator
implements Allocator {
    private static final int AVAILABLE_EXTRA_CAPACITY = 100;
    private int allocatedCount;
    private Allocation[] availableAllocations;
    private int availableCount;
    private final int individualAllocationSize;
    private final byte[] initialAllocationBlock;
    private final Allocation[] singleAllocationReleaseHolder;
    private int targetBufferSize;
    private final boolean trimOnReset;

    public DefaultAllocator(boolean bl2, int n10) {
        this(bl2, n10, 0);
    }

    /*
     * WARNING - void declaration
     */
    public DefaultAllocator(boolean bl2, int n10, int n11) {
        void var3_7;
        Allocation[] allocationArray;
        int n12;
        void var2_6;
        int n13 = 0;
        int n14 = 1;
        if (var2_6 > 0) {
            n12 = n14;
        } else {
            n12 = 0;
            allocationArray = null;
        }
        Assertions.checkArgument(n12 != 0);
        if (var3_7 >= 0) {
            n12 = n14;
        } else {
            n12 = 0;
            allocationArray = null;
        }
        Assertions.checkArgument(n12 != 0);
        this.trimOnReset = bl2;
        this.individualAllocationSize = var2_6;
        this.availableCount = var3_7;
        void var1_2 = var3_7 + 100;
        Object[] objectArray = new Allocation[var1_2];
        this.availableAllocations = objectArray;
        if (var3_7 > 0) {
            void var1_3 = var3_7 * var2_6;
            objectArray = new byte[var1_3];
            this.initialAllocationBlock = (byte[])objectArray;
            while (n13 < var3_7) {
                Allocation allocation;
                int n15 = n13 * var2_6;
                allocationArray = this.availableAllocations;
                byte[] byArray = this.initialAllocationBlock;
                allocationArray[n13] = allocation = new Allocation(byArray, n15);
                ++n13;
            }
        } else {
            boolean bl3 = false;
            objectArray = null;
            this.initialAllocationBlock = null;
        }
        objectArray = new Allocation[n14];
        this.singleAllocationReleaseHolder = objectArray;
    }

    public Allocation allocate() {
        synchronized (this) {
            Object object;
            int n10;
            this.allocatedCount = n10 = this.allocatedCount + 1;
            n10 = this.availableCount;
            if (n10 > 0) {
                Allocation[] allocationArray = this.availableAllocations;
                this.availableCount = n10 += -1;
                object = allocationArray[n10];
                object = Assertions.checkNotNull(object);
                object = (Allocation)object;
                allocationArray = this.availableAllocations;
                int n11 = this.availableCount;
                allocationArray[n11] = null;
            }
            int n12 = this.individualAllocationSize;
            byte[] byArray = new byte[n12];
            boolean bl2 = false;
            object = new Allocation(byArray, 0);
            return object;
        }
    }

    public int getIndividualAllocationLength() {
        return this.individualAllocationSize;
    }

    public int getTotalBytesAllocated() {
        synchronized (this) {
            int n10 = this.allocatedCount;
            int n11 = this.individualAllocationSize;
            return n10 *= n11;
        }
    }

    public void release(Allocation allocation) {
        synchronized (this) {
            Allocation[] allocationArray = this.singleAllocationReleaseHolder;
            allocationArray[0] = allocation;
            this.release(allocationArray);
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void release(Allocation[] allocationArray) {
        synchronized (this) {
            int n10 = this.availableCount;
            int n11 = allocationArray.length + n10;
            Allocation[] allocationArray2 = this.availableAllocations;
            int n12 = allocationArray2.length;
            if (n11 >= n12) {
                n11 = allocationArray2.length * 2;
                n12 = allocationArray.length;
                n10 += n12;
                n10 = Math.max(n11, n10);
                Allocation[] allocationArray3 = Arrays.copyOf(allocationArray2, n10);
                this.availableAllocations = allocationArray3;
            }
            n10 = allocationArray.length;
            n11 = 0;
            while (true) {
                int n13;
                if (n11 >= n10) {
                    n10 = this.allocatedCount;
                    int n14 = allocationArray.length;
                    this.allocatedCount = n10 -= n14;
                    this.notifyAll();
                    return;
                }
                Allocation allocation = allocationArray[n11];
                Allocation[] allocationArray4 = this.availableAllocations;
                int n15 = this.availableCount;
                this.availableCount = n13 = n15 + 1;
                allocationArray4[n15] = allocation;
                ++n11;
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void reset() {
        synchronized (this) {
            boolean bl2 = this.trimOnReset;
            if (bl2) {
                bl2 = false;
                Object var2_2 = null;
                this.setTargetBufferSize(0);
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void setTargetBufferSize(int n10) {
        synchronized (this) {
            int n11 = this.targetBufferSize;
            n11 = n10 < n11 ? 1 : 0;
            this.targetBufferSize = n10;
            if (n11 != 0) {
                this.trim();
            }
            return;
        }
    }

    public void trim() {
        synchronized (this) {
            Object object;
            int n10;
            Object[] objectArray;
            int n11;
            block32: {
                int n12;
                block31: {
                    n11 = this.targetBufferSize;
                    n12 = this.individualAllocationSize;
                    n11 = Util.ceilDivide(n11, n12);
                    n12 = this.allocatedCount;
                    n11 -= n12;
                    n12 = 0;
                    objectArray = null;
                    n11 = Math.max(0, n11);
                    n10 = this.availableCount;
                    if (n11 < n10) break block31;
                    return;
                }
                object = this.initialAllocationBlock;
                if (object == null) break block32;
                n10 += -1;
                while (n12 <= n10) {
                    Object[] objectArray2;
                    Object object2;
                    block34: {
                        block33: {
                            object = this.availableAllocations;
                            object = object[n12];
                            object = Assertions.checkNotNull(object);
                            object = (Allocation)object;
                            object2 = object.data;
                            objectArray2 = this.initialAllocationBlock;
                            if (object2 != objectArray2) break block33;
                            ++n12;
                            continue;
                        }
                        object2 = this.availableAllocations;
                        object2 = object2[n10];
                        object2 = Assertions.checkNotNull(object2);
                        object2 = (Allocation)object2;
                        objectArray2 = object2.data;
                        byte[] byArray = this.initialAllocationBlock;
                        if (objectArray2 == byArray) break block34;
                        n10 += -1;
                        continue;
                    }
                    objectArray2 = this.availableAllocations;
                    int n13 = n12 + 1;
                    objectArray2[n12] = (byte)object2;
                    n12 = n10 + -1;
                    objectArray2[n10] = (byte)object;
                    n10 = n12;
                    n12 = n13;
                }
                n11 = Math.max(n11, n12);
                n12 = this.availableCount;
                if (n11 < n12) break block32;
                return;
            }
            objectArray = this.availableAllocations;
            n10 = this.availableCount;
            object = null;
            Arrays.fill(objectArray, n11, n10, null);
            this.availableCount = n11;
            return;
        }
    }
}

