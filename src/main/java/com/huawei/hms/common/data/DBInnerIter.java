/*
 * Decompiled with CFR 0.151.
 */
package com.huawei.hms.common.data;

import com.huawei.hms.common.data.DataBuffer;
import com.huawei.hms.common.internal.Preconditions;
import java.util.Iterator;

public class DBInnerIter
implements Iterator {
    public final DataBuffer dataBuffer;
    public int index = -1;

    public DBInnerIter(DataBuffer dataBuffer) {
        Preconditions.checkNotNull(dataBuffer, "dataBuffer cannot be null");
        this.dataBuffer = dataBuffer;
    }

    public boolean hasNext() {
        int n10 = this.index;
        int n11 = 1;
        DataBuffer dataBuffer = this.dataBuffer;
        int n12 = dataBuffer.getCount();
        if ((n10 += n11) < n12) {
            return n11 != 0;
        }
        return false;
    }

    public Object next() {
        Object object;
        boolean bl2 = this.hasNext();
        if (bl2) {
            int n10;
            object = this.dataBuffer;
            this.index = n10 = this.index + 1;
            object = object.get(n10);
        } else {
            bl2 = false;
            object = null;
        }
        return object;
    }
}

