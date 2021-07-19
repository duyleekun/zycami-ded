/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import java.util.List;
import java.util.RandomAccess;

public interface Internal$ProtobufList
extends List,
RandomAccess {
    public boolean isModifiable();

    public void makeImmutable();

    public Internal$ProtobufList mutableCopyWithCapacity(int var1);
}

