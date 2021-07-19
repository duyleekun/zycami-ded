/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 */
package com.huawei.hms.common.data;

import android.os.Bundle;
import com.huawei.hms.common.data.DBInnerIter;
import com.huawei.hms.common.data.DataBuffer;
import com.huawei.hms.common.data.DataHolder;
import com.huawei.hms.common.data.SingleRefDBInnerIter;
import com.huawei.hms.support.api.client.Result;
import java.util.Iterator;

public abstract class AbstractDataBuffer
extends Result
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
        int n10;
        DataHolder dataHolder = this.mDataHolder;
        if (dataHolder == null) {
            n10 = 0;
            dataHolder = null;
        } else {
            n10 = dataHolder.getCount();
        }
        return n10;
    }

    public Bundle getMetadata() {
        return this.mDataHolder.getMetadata();
    }

    public boolean isClosed() {
        DataHolder dataHolder = this.mDataHolder;
        if (dataHolder == null) {
            return true;
        }
        return dataHolder.isClosed();
    }

    public Iterator iterator() {
        DBInnerIter dBInnerIter = new DBInnerIter(this);
        return dBInnerIter;
    }

    public void release() {
        DataHolder dataHolder = this.mDataHolder;
        if (dataHolder != null) {
            dataHolder.close();
        }
    }

    public Iterator singleRefIterator() {
        SingleRefDBInnerIter singleRefDBInnerIter = new SingleRefDBInnerIter(this);
        return singleRefDBInnerIter;
    }
}

