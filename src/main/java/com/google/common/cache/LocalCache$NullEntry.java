/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.cache;

import com.google.common.cache.LocalCache$ValueReference;
import com.google.common.cache.ReferenceEntry;

public final class LocalCache$NullEntry
extends Enum
implements ReferenceEntry {
    private static final /* synthetic */ LocalCache$NullEntry[] $VALUES;
    public static final /* enum */ LocalCache$NullEntry INSTANCE;

    static {
        LocalCache$NullEntry localCache$NullEntry;
        INSTANCE = localCache$NullEntry = new LocalCache$NullEntry("INSTANCE", 0);
        LocalCache$NullEntry[] localCache$NullEntryArray = new LocalCache$NullEntry[]{localCache$NullEntry};
        $VALUES = localCache$NullEntryArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private LocalCache$NullEntry() {
        void var2_-1;
        void var1_-1;
    }

    public static LocalCache$NullEntry valueOf(String string2) {
        return Enum.valueOf(LocalCache$NullEntry.class, string2);
    }

    public static LocalCache$NullEntry[] values() {
        return (LocalCache$NullEntry[])$VALUES.clone();
    }

    public long getAccessTime() {
        return 0L;
    }

    public int getHash() {
        return 0;
    }

    public Object getKey() {
        return null;
    }

    public ReferenceEntry getNext() {
        return null;
    }

    public ReferenceEntry getNextInAccessQueue() {
        return this;
    }

    public ReferenceEntry getNextInWriteQueue() {
        return this;
    }

    public ReferenceEntry getPreviousInAccessQueue() {
        return this;
    }

    public ReferenceEntry getPreviousInWriteQueue() {
        return this;
    }

    public LocalCache$ValueReference getValueReference() {
        return null;
    }

    public long getWriteTime() {
        return 0L;
    }

    public void setAccessTime(long l10) {
    }

    public void setNextInAccessQueue(ReferenceEntry referenceEntry) {
    }

    public void setNextInWriteQueue(ReferenceEntry referenceEntry) {
    }

    public void setPreviousInAccessQueue(ReferenceEntry referenceEntry) {
    }

    public void setPreviousInWriteQueue(ReferenceEntry referenceEntry) {
    }

    public void setValueReference(LocalCache$ValueReference localCache$ValueReference) {
    }

    public void setWriteTime(long l10) {
    }
}

