/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.flogger.backend;

import com.google.common.flogger.MetadataKey;
import com.google.common.flogger.backend.Metadata;

public final class Metadata$Empty
extends Metadata {
    public static final Metadata$Empty INSTANCE;

    static {
        Metadata$Empty metadata$Empty;
        INSTANCE = metadata$Empty = new Metadata$Empty();
    }

    private Metadata$Empty() {
    }

    public Object findValue(MetadataKey metadataKey) {
        return null;
    }

    public MetadataKey getKey(int n10) {
        IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException("cannot read from empty metadata");
        throw indexOutOfBoundsException;
    }

    public Object getValue(int n10) {
        IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException("cannot read from empty metadata");
        throw indexOutOfBoundsException;
    }

    public int size() {
        return 0;
    }
}

