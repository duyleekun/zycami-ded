/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.ProtocolStringList;
import java.util.Collection;
import java.util.List;

public interface LazyStringList
extends ProtocolStringList {
    public void add(ByteString var1);

    public void add(byte[] var1);

    public boolean addAllByteArray(Collection var1);

    public boolean addAllByteString(Collection var1);

    public List asByteArrayList();

    public byte[] getByteArray(int var1);

    public ByteString getByteString(int var1);

    public Object getRaw(int var1);

    public List getUnderlyingElements();

    public LazyStringList getUnmodifiableView();

    public void mergeFrom(LazyStringList var1);

    public void set(int var1, ByteString var2);

    public void set(int var1, byte[] var2);
}

