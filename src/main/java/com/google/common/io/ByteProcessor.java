/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.io;

public interface ByteProcessor {
    public Object getResult();

    public boolean processBytes(byte[] var1, int var2, int var3);
}

