/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.crashlytics.internal.model;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

public final class ImmutableList
implements List,
RandomAccess {
    private final List immutableList;

    private ImmutableList(List list) {
        this.immutableList = list = Collections.unmodifiableList(list);
    }

    public static ImmutableList from(List list) {
        ImmutableList immutableList = new ImmutableList(list);
        return immutableList;
    }

    public static ImmutableList from(Object ... object) {
        object = Arrays.asList(object);
        ImmutableList immutableList = new ImmutableList((List)object);
        return immutableList;
    }

    public void add(int n10, Object object) {
        this.immutableList.add(n10, object);
    }

    public boolean add(Object object) {
        return this.immutableList.add(object);
    }

    public boolean addAll(int n10, Collection collection) {
        return this.immutableList.addAll(n10, collection);
    }

    public boolean addAll(Collection collection) {
        return this.immutableList.addAll(collection);
    }

    public void clear() {
        this.immutableList.clear();
    }

    public boolean contains(Object object) {
        return this.immutableList.contains(object);
    }

    public boolean containsAll(Collection collection) {
        return this.immutableList.containsAll(collection);
    }

    public boolean equals(Object object) {
        return this.immutableList.equals(object);
    }

    public Object get(int n10) {
        return this.immutableList.get(n10);
    }

    public int hashCode() {
        return this.immutableList.hashCode();
    }

    public int indexOf(Object object) {
        return this.immutableList.indexOf(object);
    }

    public boolean isEmpty() {
        return this.immutableList.isEmpty();
    }

    public Iterator iterator() {
        return this.immutableList.iterator();
    }

    public int lastIndexOf(Object object) {
        return this.immutableList.lastIndexOf(object);
    }

    public ListIterator listIterator() {
        return this.immutableList.listIterator();
    }

    public ListIterator listIterator(int n10) {
        return this.immutableList.listIterator(n10);
    }

    public Object remove(int n10) {
        return this.immutableList.remove(n10);
    }

    public boolean remove(Object object) {
        return this.immutableList.remove(object);
    }

    public boolean removeAll(Collection collection) {
        return this.immutableList.removeAll(collection);
    }

    public boolean retainAll(Collection collection) {
        return this.immutableList.retainAll(collection);
    }

    public Object set(int n10, Object object) {
        return this.immutableList.set(n10, object);
    }

    public int size() {
        return this.immutableList.size();
    }

    public List subList(int n10, int n11) {
        return this.immutableList.subList(n10, n11);
    }

    public Object[] toArray() {
        return this.immutableList.toArray();
    }

    public Object[] toArray(Object[] objectArray) {
        return this.immutableList.toArray(objectArray);
    }
}

