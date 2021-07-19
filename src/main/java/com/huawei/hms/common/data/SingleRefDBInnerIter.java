/*
 * Decompiled with CFR 0.151.
 */
package com.huawei.hms.common.data;

import com.huawei.hms.common.data.DBInnerIter;
import com.huawei.hms.common.data.DataBuffer;
import com.huawei.hms.common.data.DataBufferRef;
import com.huawei.hms.common.internal.Preconditions;

public class SingleRefDBInnerIter
extends DBInnerIter {
    public SingleRefDBInnerIter(DataBuffer dataBuffer) {
        super(dataBuffer);
    }

    public Object next() {
        int n10;
        boolean bl2 = this.hasNext();
        if (!bl2) {
            return null;
        }
        this.index = n10 = this.index + 1;
        if (n10 == 0) {
            boolean bl3 = this.dataBuffer.get(0) instanceof DataBufferRef;
            CharSequence charSequence = new StringBuilder();
            charSequence.append("DataBuffer reference of type ");
            Object object = this.dataBuffer.get(0).getClass();
            charSequence.append(object);
            object = " is not movable";
            charSequence.append((String)object);
            charSequence = charSequence.toString();
            Preconditions.checkState(bl3, charSequence);
            DataBufferRef dataBufferRef = (DataBufferRef)this.dataBuffer.get(0);
            int n11 = this.index;
            dataBufferRef.getWindowIndex(n11);
        }
        return this.dataBuffer.get(0);
    }
}

