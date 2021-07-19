/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.common.data;

import com.google.android.gms.common.data.DataBuffer;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class DataBufferIterator
implements Iterator {
    public final DataBuffer zalk;
    public int zall;

    public DataBufferIterator(DataBuffer dataBuffer) {
        this.zalk = dataBuffer = (DataBuffer)Preconditions.checkNotNull(dataBuffer);
        this.zall = -1;
    }

    public boolean hasNext() {
        int n10 = this.zall;
        DataBuffer dataBuffer = this.zalk;
        int n11 = dataBuffer.getCount();
        int n12 = 1;
        if (n10 < (n11 -= n12)) {
            return n12 != 0;
        }
        return false;
    }

    public Object next() {
        boolean bl2 = this.hasNext();
        if (bl2) {
            int n10;
            DataBuffer dataBuffer = this.zalk;
            this.zall = n10 = this.zall + 1;
            return dataBuffer.get(n10);
        }
        int n11 = this.zall;
        StringBuilder stringBuilder = new StringBuilder(46);
        stringBuilder.append("Cannot advance the iterator beyond ");
        stringBuilder.append(n11);
        String string2 = stringBuilder.toString();
        NoSuchElementException noSuchElementException = new NoSuchElementException(string2);
        throw noSuchElementException;
    }

    public void remove() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Cannot remove elements from a DataBufferIterator");
        throw unsupportedOperationException;
    }
}

