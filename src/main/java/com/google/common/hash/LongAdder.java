/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.hash;

import com.google.common.hash.LongAddable;
import com.google.common.hash.Striped64;
import com.google.common.hash.Striped64$Cell;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public final class LongAdder
extends Striped64
implements Serializable,
LongAddable {
    private static final long serialVersionUID = 7249069246863182397L;

    private void readObject(ObjectInputStream objectInputStream) {
        long l10;
        objectInputStream.defaultReadObject();
        this.busy = 0;
        this.cells = null;
        this.base = l10 = objectInputStream.readLong();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        long l10 = this.sum();
        objectOutputStream.writeLong(l10);
    }

    public void add(long l10) {
        block2: {
            int n10;
            int[] nArray;
            block3: {
                long l11;
                long l12;
                int n11;
                long l13;
                long l14;
                boolean bl2;
                Object object = this.cells;
                if (object == null && (bl2 = this.casBase(l14 = this.base, l13 = l14 + l10))) break block2;
                nArray = (int[])Striped64.threadHashCode.get();
                n10 = 1;
                if (nArray == null || object == null || (n11 = ((Striped64$Cell[])object).length) < n10) break block3;
                n11 -= n10;
                int n12 = nArray[0];
                if ((object = object[n11 &= n12]) != null && (n10 = (int)(((Striped64$Cell)object).cas(l12 = ((Striped64$Cell)object).value, l11 = l12 + l10) ? 1 : 0)) != 0) break block2;
            }
            this.retryUpdate(l10, nArray, n10 != 0);
        }
    }

    public void decrement() {
        this.add(-1);
    }

    public double doubleValue() {
        return this.sum();
    }

    public float floatValue() {
        return this.sum();
    }

    public final long fn(long l10, long l11) {
        return l10 + l11;
    }

    public void increment() {
        this.add(1L);
    }

    public int intValue() {
        return (int)this.sum();
    }

    public long longValue() {
        return this.sum();
    }

    public void reset() {
        this.internalReset(0L);
    }

    public long sum() {
        long l10 = this.base;
        Striped64$Cell[] striped64$CellArray = this.cells;
        if (striped64$CellArray != null) {
            for (Striped64$Cell striped64$Cell : striped64$CellArray) {
                if (striped64$Cell == null) continue;
                long l11 = striped64$Cell.value;
                l10 += l11;
            }
        }
        return l10;
    }

    public long sumThenReset() {
        long l10;
        long l11 = this.base;
        Striped64$Cell[] striped64$CellArray = this.cells;
        this.base = l10 = 0L;
        if (striped64$CellArray != null) {
            for (Striped64$Cell striped64$Cell : striped64$CellArray) {
                if (striped64$Cell == null) continue;
                long l12 = striped64$Cell.value;
                l11 += l12;
                striped64$Cell.value = l10;
            }
        }
        return l11;
    }

    public String toString() {
        return Long.toString(this.sum());
    }
}

