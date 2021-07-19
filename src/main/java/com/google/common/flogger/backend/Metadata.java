/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.flogger.backend;

import com.google.common.flogger.MetadataKey;
import com.google.common.flogger.backend.Metadata$Empty;

public abstract class Metadata {
    public static Metadata empty() {
        return Metadata$Empty.INSTANCE;
    }

    public abstract Object findValue(MetadataKey var1);

    public abstract MetadataKey getKey(int var1);

    public abstract Object getValue(int var1);

    public abstract int size();
}

