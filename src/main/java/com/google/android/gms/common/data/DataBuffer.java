/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 */
package com.google.android.gms.common.data;

import android.os.Bundle;
import com.google.android.gms.common.api.Releasable;
import java.util.Iterator;

public interface DataBuffer
extends Releasable,
Iterable {
    public void close();

    public Object get(int var1);

    public int getCount();

    public Bundle getMetadata();

    public boolean isClosed();

    public Iterator iterator();

    public void release();

    public Iterator singleRefIterator();
}

