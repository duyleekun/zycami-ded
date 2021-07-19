/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.LazyStringList;
import com.google.protobuf.UnmodifiableLazyStringList$1;
import com.google.protobuf.UnmodifiableLazyStringList$2;
import java.util.AbstractList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

public class UnmodifiableLazyStringList
extends AbstractList
implements LazyStringList,
RandomAccess {
    private final LazyStringList list;

    public UnmodifiableLazyStringList(LazyStringList lazyStringList) {
        this.list = lazyStringList;
    }

    public static /* synthetic */ LazyStringList access$000(UnmodifiableLazyStringList unmodifiableLazyStringList) {
        return unmodifiableLazyStringList.list;
    }

    public void add(ByteString serializable) {
        serializable = new UnsupportedOperationException();
        throw serializable;
    }

    public void add(byte[] object) {
        object = new UnsupportedOperationException;
        object();
        throw object;
    }

    public boolean addAllByteArray(Collection object) {
        object = new UnsupportedOperationException();
        throw object;
    }

    public boolean addAllByteString(Collection object) {
        object = new UnsupportedOperationException();
        throw object;
    }

    public List asByteArrayList() {
        return Collections.unmodifiableList(this.list.asByteArrayList());
    }

    public List asByteStringList() {
        return Collections.unmodifiableList(this.list.asByteStringList());
    }

    public String get(int n10) {
        return (String)this.list.get(n10);
    }

    public byte[] getByteArray(int n10) {
        return this.list.getByteArray(n10);
    }

    public ByteString getByteString(int n10) {
        return this.list.getByteString(n10);
    }

    public Object getRaw(int n10) {
        return this.list.getRaw(n10);
    }

    public List getUnderlyingElements() {
        return this.list.getUnderlyingElements();
    }

    public LazyStringList getUnmodifiableView() {
        return this;
    }

    public Iterator iterator() {
        UnmodifiableLazyStringList$2 unmodifiableLazyStringList$2 = new UnmodifiableLazyStringList$2(this);
        return unmodifiableLazyStringList$2;
    }

    public ListIterator listIterator(int n10) {
        UnmodifiableLazyStringList$1 unmodifiableLazyStringList$1 = new UnmodifiableLazyStringList$1(this, n10);
        return unmodifiableLazyStringList$1;
    }

    public void mergeFrom(LazyStringList object) {
        object = new UnsupportedOperationException();
        throw object;
    }

    public void set(int n10, ByteString byteString) {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        throw unsupportedOperationException;
    }

    public void set(int n10, byte[] byArray) {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        throw unsupportedOperationException;
    }

    public int size() {
        return this.list.size();
    }
}

