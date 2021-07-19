/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.AbstractProtobufList;
import com.google.protobuf.ByteString;
import com.google.protobuf.Internal;
import com.google.protobuf.LazyStringArrayList$ByteArrayListView;
import com.google.protobuf.LazyStringArrayList$ByteStringListView;
import com.google.protobuf.LazyStringList;
import com.google.protobuf.UnmodifiableLazyStringList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

public class LazyStringArrayList
extends AbstractProtobufList
implements LazyStringList,
RandomAccess {
    public static final LazyStringList EMPTY;
    private static final LazyStringArrayList EMPTY_LIST;
    private final List list;

    static {
        LazyStringArrayList lazyStringArrayList;
        EMPTY_LIST = lazyStringArrayList = new LazyStringArrayList();
        lazyStringArrayList.makeImmutable();
        EMPTY = lazyStringArrayList;
    }

    public LazyStringArrayList() {
        this(10);
    }

    public LazyStringArrayList(int n10) {
        ArrayList arrayList = new ArrayList(n10);
        this(arrayList);
    }

    public LazyStringArrayList(LazyStringList lazyStringList) {
        ArrayList arrayList;
        int n10 = lazyStringList.size();
        this.list = arrayList = new ArrayList(n10);
        this.addAll((Collection)lazyStringList);
    }

    private LazyStringArrayList(ArrayList arrayList) {
        this.list = arrayList;
    }

    public LazyStringArrayList(List list) {
        ArrayList arrayList = new ArrayList(list);
        this(arrayList);
    }

    public static /* synthetic */ Object access$000(LazyStringArrayList lazyStringArrayList, int n10, byte[] byArray) {
        return lazyStringArrayList.setAndReturn(n10, byArray);
    }

    public static /* synthetic */ byte[] access$100(Object object) {
        return LazyStringArrayList.asByteArray(object);
    }

    public static /* synthetic */ void access$200(LazyStringArrayList lazyStringArrayList, int n10, byte[] byArray) {
        lazyStringArrayList.add(n10, byArray);
    }

    public static /* synthetic */ Object access$300(LazyStringArrayList lazyStringArrayList, int n10, ByteString byteString) {
        return lazyStringArrayList.setAndReturn(n10, byteString);
    }

    public static /* synthetic */ ByteString access$400(Object object) {
        return LazyStringArrayList.asByteString(object);
    }

    public static /* synthetic */ void access$500(LazyStringArrayList lazyStringArrayList, int n10, ByteString byteString) {
        lazyStringArrayList.add(n10, byteString);
    }

    private void add(int n10, ByteString byteString) {
        this.ensureIsMutable();
        this.list.add(n10, byteString);
        this.modCount = n10 = this.modCount + 1;
    }

    private void add(int n10, byte[] byArray) {
        this.ensureIsMutable();
        this.list.add(n10, byArray);
        this.modCount = n10 = this.modCount + 1;
    }

    private static byte[] asByteArray(Object object) {
        boolean bl2 = object instanceof byte[];
        if (bl2) {
            return (byte[])object;
        }
        bl2 = object instanceof String;
        if (bl2) {
            return Internal.toByteArray((String)object);
        }
        return ((ByteString)object).toByteArray();
    }

    private static ByteString asByteString(Object object) {
        boolean bl2 = object instanceof ByteString;
        if (bl2) {
            return (ByteString)object;
        }
        bl2 = object instanceof String;
        if (bl2) {
            return ByteString.copyFromUtf8((String)object);
        }
        return ByteString.copyFrom((byte[])object);
    }

    private static String asString(Object object) {
        boolean bl2 = object instanceof String;
        if (bl2) {
            return (String)object;
        }
        bl2 = object instanceof ByteString;
        if (bl2) {
            return ((ByteString)object).toStringUtf8();
        }
        return Internal.toStringUtf8((byte[])object);
    }

    public static LazyStringArrayList emptyList() {
        return EMPTY_LIST;
    }

    private Object setAndReturn(int n10, ByteString byteString) {
        this.ensureIsMutable();
        return this.list.set(n10, byteString);
    }

    private Object setAndReturn(int n10, byte[] byArray) {
        this.ensureIsMutable();
        return this.list.set(n10, byArray);
    }

    public void add(int n10, String string2) {
        this.ensureIsMutable();
        this.list.add(n10, string2);
        this.modCount = n10 = this.modCount + 1;
    }

    public void add(ByteString byteString) {
        int n10;
        this.ensureIsMutable();
        this.list.add(byteString);
        this.modCount = n10 = this.modCount + 1;
    }

    public void add(byte[] byArray) {
        int n10;
        this.ensureIsMutable();
        this.list.add(byArray);
        this.modCount = n10 = this.modCount + 1;
    }

    public boolean addAll(int n10, Collection collection) {
        int n11;
        this.ensureIsMutable();
        boolean bl2 = collection instanceof LazyStringList;
        if (bl2) {
            collection = ((LazyStringList)collection).getUnderlyingElements();
        }
        n10 = (int)(this.list.addAll(n10, collection) ? 1 : 0);
        this.modCount = n11 = this.modCount + 1;
        return n10 != 0;
    }

    public boolean addAll(Collection collection) {
        int n10 = this.size();
        return this.addAll(n10, collection);
    }

    public boolean addAllByteArray(Collection collection) {
        int n10;
        this.ensureIsMutable();
        boolean bl2 = this.list.addAll(collection);
        this.modCount = n10 = this.modCount + 1;
        return bl2;
    }

    public boolean addAllByteString(Collection collection) {
        int n10;
        this.ensureIsMutable();
        boolean bl2 = this.list.addAll(collection);
        this.modCount = n10 = this.modCount + 1;
        return bl2;
    }

    public List asByteArrayList() {
        LazyStringArrayList$ByteArrayListView lazyStringArrayList$ByteArrayListView = new LazyStringArrayList$ByteArrayListView(this);
        return lazyStringArrayList$ByteArrayListView;
    }

    public List asByteStringList() {
        LazyStringArrayList$ByteStringListView lazyStringArrayList$ByteStringListView = new LazyStringArrayList$ByteStringListView(this);
        return lazyStringArrayList$ByteStringListView;
    }

    public void clear() {
        int n10;
        this.ensureIsMutable();
        this.list.clear();
        this.modCount = n10 = this.modCount + 1;
    }

    public String get(int n10) {
        Object object = this.list.get(n10);
        boolean bl2 = object instanceof String;
        if (bl2) {
            return (String)object;
        }
        bl2 = object instanceof ByteString;
        if (bl2) {
            object = (ByteString)object;
            String string2 = ((ByteString)object).toStringUtf8();
            boolean bl3 = ((ByteString)object).isValidUtf8();
            if (bl3) {
                object = this.list;
                object.set(n10, string2);
            }
            return string2;
        }
        object = (byte[])object;
        String string3 = Internal.toStringUtf8((byte[])object);
        boolean bl4 = Internal.isValidUtf8((byte[])object);
        if (bl4) {
            object = this.list;
            object.set(n10, string3);
        }
        return string3;
    }

    public byte[] getByteArray(int n10) {
        Object object = this.list.get(n10);
        byte[] byArray = LazyStringArrayList.asByteArray(object);
        if (byArray != object) {
            object = this.list;
            object.set(n10, (byte[])byArray);
        }
        return byArray;
    }

    public ByteString getByteString(int n10) {
        Object object = this.list.get(n10);
        ByteString byteString = LazyStringArrayList.asByteString(object);
        if (byteString != object) {
            object = this.list;
            object.set(n10, (ByteString)byteString);
        }
        return byteString;
    }

    public Object getRaw(int n10) {
        return this.list.get(n10);
    }

    public List getUnderlyingElements() {
        return Collections.unmodifiableList(this.list);
    }

    public LazyStringList getUnmodifiableView() {
        boolean bl2 = this.isModifiable();
        if (bl2) {
            UnmodifiableLazyStringList unmodifiableLazyStringList = new UnmodifiableLazyStringList(this);
            return unmodifiableLazyStringList;
        }
        return this;
    }

    public void mergeFrom(LazyStringList object) {
        boolean bl2;
        this.ensureIsMutable();
        object = object.getUnderlyingElements().iterator();
        while (bl2 = object.hasNext()) {
            List list;
            Object object2 = object.next();
            boolean bl3 = object2 instanceof byte[];
            if (bl3) {
                object2 = (byte[])object2;
                list = this.list;
                int n10 = ((E)object2).length;
                object2 = Arrays.copyOf(object2, n10);
                list.add(object2);
                continue;
            }
            list = this.list;
            list.add(object2);
        }
    }

    public LazyStringArrayList mutableCopyWithCapacity(int n10) {
        int n11 = this.size();
        if (n10 >= n11) {
            ArrayList arrayList = new ArrayList(n10);
            List list = this.list;
            arrayList.addAll(list);
            list = new LazyStringArrayList(arrayList);
            return list;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException();
        throw illegalArgumentException;
    }

    public String remove(int n10) {
        int n11;
        this.ensureIsMutable();
        Object e10 = this.list.remove(n10);
        this.modCount = n11 = this.modCount + 1;
        return LazyStringArrayList.asString(e10);
    }

    public String set(int n10, String string2) {
        this.ensureIsMutable();
        return LazyStringArrayList.asString(this.list.set(n10, string2));
    }

    public void set(int n10, ByteString byteString) {
        this.setAndReturn(n10, byteString);
    }

    public void set(int n10, byte[] byArray) {
        this.setAndReturn(n10, byArray);
    }

    public int size() {
        return this.list.size();
    }
}

