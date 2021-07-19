/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 */
package com.google.android.gms.common.data;

import android.os.Bundle;
import com.google.android.gms.common.data.DataBuffer;
import com.google.android.gms.common.data.DataBufferIterator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.SingleRefDataBufferIterator;
import java.util.Iterator;

public abstract class AbstractDataBuffer
implements DataBuffer {
    public final DataHolder mDataHolder;

    public AbstractDataBuffer(DataHolder dataHolder) {
        this.mDataHolder = dataHolder;
    }

    public final void close() {
        this.release();
    }

    public abstract Object get(int var1);

    public int getCount() {
        DataHolder dataHolder = this.mDataHolder;
        if (dataHolder == null) {
            return 0;
        }
        return dataHolder.getCount();
    }

    public Bundle getMetadata() {
        return this.mDataHolder.getMetadata();
    }

    public boolean isClosed() {
        boolean bl2;
        DataHolder dataHolder = this.mDataHolder;
        return dataHolder == null || (bl2 = dataHolder.isClosed());
        {
        }
    }

    public Iterator iterator() {
        DataBufferIterator dataBufferIterator = new DataBufferIterator(this);
        return dataBufferIterator;
    }

    public void release() {
        DataHolder dataHolder = this.mDataHolder;
        if (dataHolder != null) {
            dataHolder.close();
        }
    }

    public Iterator singleRefIterator() {
        SingleRefDataBufferIterator singleRefDataBufferIterator = new SingleRefDataBufferIterator(this);
        return singleRefDataBufferIterator;
    }
}

