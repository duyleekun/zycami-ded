/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 */
package com.google.android.gms.common.api;

import android.os.Bundle;
import com.google.android.gms.common.api.Response;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.data.AbstractDataBuffer;
import com.google.android.gms.common.data.DataBuffer;
import java.util.Iterator;

public class DataBufferResponse
extends Response
implements DataBuffer {
    public DataBufferResponse() {
    }

    public DataBufferResponse(AbstractDataBuffer abstractDataBuffer) {
        super((Result)((Object)abstractDataBuffer));
    }

    public void close() {
        ((AbstractDataBuffer)((Object)this.getResult())).close();
    }

    public Object get(int n10) {
        return ((AbstractDataBuffer)((Object)this.getResult())).get(n10);
    }

    public int getCount() {
        return ((AbstractDataBuffer)((Object)this.getResult())).getCount();
    }

    public Bundle getMetadata() {
        return ((AbstractDataBuffer)((Object)this.getResult())).getMetadata();
    }

    public boolean isClosed() {
        return ((AbstractDataBuffer)((Object)this.getResult())).isClosed();
    }

    public Iterator iterator() {
        return ((AbstractDataBuffer)((Object)this.getResult())).iterator();
    }

    public void release() {
        ((AbstractDataBuffer)((Object)this.getResult())).release();
    }

    public Iterator singleRefIterator() {
        return ((AbstractDataBuffer)((Object)this.getResult())).singleRefIterator();
    }
}

