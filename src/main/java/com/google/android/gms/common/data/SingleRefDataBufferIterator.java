/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.common.data;

import com.google.android.gms.common.data.DataBuffer;
import com.google.android.gms.common.data.DataBufferIterator;
import com.google.android.gms.common.data.DataBufferRef;
import java.util.NoSuchElementException;

public class SingleRefDataBufferIterator
extends DataBufferIterator {
    private Object zamg;

    public SingleRefDataBufferIterator(DataBuffer dataBuffer) {
        super(dataBuffer);
    }

    public Object next() {
        int n10 = this.hasNext();
        if (n10 != 0) {
            this.zall = n10 = this.zall + 1;
            if (n10 == 0) {
                Object object = this.zalk;
                boolean bl2 = false;
                String string2 = null;
                this.zamg = object = object.get(0);
                n10 = object instanceof DataBufferRef;
                if (n10 == 0) {
                    string2 = String.valueOf(this.zamg.getClass());
                    int n11 = String.valueOf(string2).length() + 44;
                    StringBuilder stringBuilder = new StringBuilder(n11);
                    stringBuilder.append("DataBuffer reference of type ");
                    stringBuilder.append(string2);
                    stringBuilder.append(" is not movable");
                    string2 = stringBuilder.toString();
                    object = new IllegalStateException(string2);
                    throw object;
                }
            } else {
                DataBufferRef dataBufferRef = (DataBufferRef)this.zamg;
                dataBufferRef.zag(n10);
            }
            return this.zamg;
        }
        int n12 = this.zall;
        StringBuilder stringBuilder = new StringBuilder(46);
        stringBuilder.append("Cannot advance the iterator beyond ");
        stringBuilder.append(n12);
        String string3 = stringBuilder.toString();
        NoSuchElementException noSuchElementException = new NoSuchElementException(string3);
        throw noSuchElementException;
    }
}

