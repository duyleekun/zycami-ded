/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.cache;

import com.google.common.cache.LocalCache$ValueReference;

public interface ReferenceEntry {
    public long getAccessTime();

    public int getHash();

    public Object getKey();

    public ReferenceEntry getNext();

    public ReferenceEntry getNextInAccessQueue();

    public ReferenceEntry getNextInWriteQueue();

    public ReferenceEntry getPreviousInAccessQueue();

    public ReferenceEntry getPreviousInWriteQueue();

    public LocalCache$ValueReference getValueReference();

    public long getWriteTime();

    public void setAccessTime(long var1);

    public void setNextInAccessQueue(ReferenceEntry var1);

    public void setNextInWriteQueue(ReferenceEntry var1);

    public void setPreviousInAccessQueue(ReferenceEntry var1);

    public void setPreviousInWriteQueue(ReferenceEntry var1);

    public void setValueReference(LocalCache$ValueReference var1);

    public void setWriteTime(long var1);
}

