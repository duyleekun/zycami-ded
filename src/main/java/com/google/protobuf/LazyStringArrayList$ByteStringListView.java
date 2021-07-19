/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.LazyStringArrayList;
import java.util.AbstractList;
import java.util.RandomAccess;

public class LazyStringArrayList$ByteStringListView
extends AbstractList
implements RandomAccess {
    private final LazyStringArrayList list;

    public LazyStringArrayList$ByteStringListView(LazyStringArrayList lazyStringArrayList) {
        this.list = lazyStringArrayList;
    }

    public void add(int n10, ByteString byteString) {
        LazyStringArrayList.access$500(this.list, n10, byteString);
        this.modCount = n10 = this.modCount + 1;
    }

    public ByteString get(int n10) {
        return this.list.getByteString(n10);
    }

    public ByteString remove(int n10) {
        int n11;
        Object object = this.list.remove(n10);
        this.modCount = n11 = this.modCount + 1;
        return LazyStringArrayList.access$400(object);
    }

    public ByteString set(int n10, ByteString byteString) {
        int n11;
        Object object = LazyStringArrayList.access$300(this.list, n10, byteString);
        this.modCount = n11 = this.modCount + 1;
        return LazyStringArrayList.access$400(object);
    }

    public int size() {
        return this.list.size();
    }
}

