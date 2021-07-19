/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.ArrayDecoders$Registers;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.Reader;
import com.google.protobuf.Writer;

public interface Schema {
    public boolean equals(Object var1, Object var2);

    public int getSerializedSize(Object var1);

    public int hashCode(Object var1);

    public boolean isInitialized(Object var1);

    public void makeImmutable(Object var1);

    public void mergeFrom(Object var1, Reader var2, ExtensionRegistryLite var3);

    public void mergeFrom(Object var1, Object var2);

    public void mergeFrom(Object var1, byte[] var2, int var3, int var4, ArrayDecoders$Registers var5);

    public Object newInstance();

    public void writeTo(Object var1, Writer var2);
}

