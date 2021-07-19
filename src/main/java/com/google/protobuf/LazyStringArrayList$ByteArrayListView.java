/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.LazyStringArrayList;
import java.util.AbstractList;
import java.util.RandomAccess;

public class LazyStringArrayList$ByteArrayListView
extends AbstractList
implements RandomAccess {
    private final LazyStringArrayList list;

    public LazyStringArrayList$ByteArrayListView(LazyStringArrayList lazyStringArrayList) {
        this.list = lazyStringArrayList;
    }

    public void add(int n10, byte[] byArray) {
        LazyStringArrayList.access$200(this.list, n10, byArray);
        this.modCount = n10 = this.modCount + 1;
    }

    public byte[] get(int n10) {
        return this.list.getByteArray(n10);
    }

    public byte[] remove(int n10) {
        int n11;
        Object object = this.list.remove(n10);
        this.modCount = n11 = this.modCount + 1;
        return LazyStringArrayList.access$100(object);
    }

    public byte[] set(int n10, byte[] byArray) {
        int n11;
        Object object = LazyStringArrayList.access$000(this.list, n10, byArray);
        this.modCount = n11 = this.modCount + 1;
        return LazyStringArrayList.access$100(object);
    }

    public int size() {
        return this.list.size();
    }
}

