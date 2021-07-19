/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import java.util.concurrent.atomic.AtomicInteger;

public final class VolatileSizeArrayList
extends AtomicInteger
implements List,
RandomAccess {
    private static final long serialVersionUID = 3972397474470203923L;
    public final ArrayList list;

    public VolatileSizeArrayList() {
        ArrayList arrayList;
        this.list = arrayList = new ArrayList();
    }

    public VolatileSizeArrayList(int n10) {
        ArrayList arrayList;
        this.list = arrayList = new ArrayList(n10);
    }

    public void add(int n10, Object object) {
        this.list.add(n10, object);
        n10 = this.list.size();
        this.lazySet(n10);
    }

    public boolean add(Object object) {
        boolean bl2 = this.list.add(object);
        int n10 = this.list.size();
        this.lazySet(n10);
        return bl2;
    }

    public boolean addAll(int n10, Collection collection) {
        n10 = (int)(this.list.addAll(n10, collection) ? 1 : 0);
        int n11 = this.list.size();
        this.lazySet(n11);
        return n10 != 0;
    }

    public boolean addAll(Collection collection) {
        boolean bl2 = this.list.addAll(collection);
        int n10 = this.list.size();
        this.lazySet(n10);
        return bl2;
    }

    public void clear() {
        this.list.clear();
        this.lazySet(0);
    }

    public boolean contains(Object object) {
        return this.list.contains(object);
    }

    public boolean containsAll(Collection collection) {
        return this.list.containsAll(collection);
    }

    public boolean equals(Object object) {
        boolean bl2 = object instanceof VolatileSizeArrayList;
        if (bl2) {
            ArrayList arrayList = this.list;
            object = ((VolatileSizeArrayList)object).list;
            return arrayList.equals(object);
        }
        return this.list.equals(object);
    }

    public Object get(int n10) {
        return this.list.get(n10);
    }

    public int hashCode() {
        return this.list.hashCode();
    }

    public int indexOf(Object object) {
        return this.list.indexOf(object);
    }

    public boolean isEmpty() {
        int n10 = this.get();
        n10 = n10 == 0 ? 1 : 0;
        return n10 != 0;
    }

    public Iterator iterator() {
        return this.list.iterator();
    }

    public int lastIndexOf(Object object) {
        return this.list.lastIndexOf(object);
    }

    public ListIterator listIterator() {
        return this.list.listIterator();
    }

    public ListIterator listIterator(int n10) {
        return this.list.listIterator(n10);
    }

    public Object remove(int n10) {
        Object e10 = this.list.remove(n10);
        int n11 = this.list.size();
        this.lazySet(n11);
        return e10;
    }

    public boolean remove(Object object) {
        boolean bl2 = this.list.remove(object);
        int n10 = this.list.size();
        this.lazySet(n10);
        return bl2;
    }

    public boolean removeAll(Collection collection) {
        boolean bl2 = this.list.removeAll(collection);
        int n10 = this.list.size();
        this.lazySet(n10);
        return bl2;
    }

    public boolean retainAll(Collection collection) {
        boolean bl2 = this.list.retainAll(collection);
        int n10 = this.list.size();
        this.lazySet(n10);
        return bl2;
    }

    public Object set(int n10, Object object) {
        return this.list.set(n10, object);
    }

    public int size() {
        return this.get();
    }

    public List subList(int n10, int n11) {
        return this.list.subList(n10, n11);
    }

    public Object[] toArray() {
        return this.list.toArray();
    }

    public Object[] toArray(Object[] objectArray) {
        return this.list.toArray(objectArray);
    }

    public String toString() {
        return this.list.toString();
    }
}

