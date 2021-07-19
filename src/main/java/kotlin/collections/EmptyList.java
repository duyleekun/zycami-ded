/*
 * Decompiled with CFR 0.151.
 */
package kotlin.collections;

import f.h2.t.f0;
import f.h2.t.t;
import f.h2.t.x0.a;
import f.x1.c0;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

public final class EmptyList
implements List,
Serializable,
RandomAccess,
a {
    public static final EmptyList INSTANCE;
    private static final long serialVersionUID = -7390468764508069838L;

    static {
        EmptyList emptyList;
        INSTANCE = emptyList = new EmptyList();
    }

    private EmptyList() {
    }

    private final Object readResolve() {
        return INSTANCE;
    }

    public /* synthetic */ void add(int n10, Object object) {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        throw unsupportedOperationException;
    }

    public void add(int n10, Void void_) {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        throw unsupportedOperationException;
    }

    public /* synthetic */ boolean add(Object object) {
        object = new UnsupportedOperationException("Operation is not supported for read-only collection");
        throw object;
    }

    public boolean add(Void object) {
        object = new UnsupportedOperationException("Operation is not supported for read-only collection");
        throw object;
    }

    public boolean addAll(int n10, Collection collection) {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        throw unsupportedOperationException;
    }

    public boolean addAll(Collection object) {
        object = new UnsupportedOperationException("Operation is not supported for read-only collection");
        throw object;
    }

    public void clear() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        throw unsupportedOperationException;
    }

    public boolean contains(Void void_) {
        f0.p(void_, "element");
        return false;
    }

    public boolean containsAll(Collection collection) {
        f0.p(collection, "elements");
        return collection.isEmpty();
    }

    public boolean equals(Object object) {
        boolean bl2;
        boolean bl3 = object instanceof List;
        if (bl3 && (bl2 = (object = (List)object).isEmpty())) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    public Void get(int n10) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Empty list doesn't contain element at index ");
        stringBuilder.append(n10);
        stringBuilder.append('.');
        String string2 = stringBuilder.toString();
        IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException(string2);
        throw indexOutOfBoundsException;
    }

    public int getSize() {
        return 0;
    }

    public int hashCode() {
        return 1;
    }

    public int indexOf(Void void_) {
        f0.p(void_, "element");
        return -1;
    }

    public boolean isEmpty() {
        return true;
    }

    public Iterator iterator() {
        return c0.a;
    }

    public int lastIndexOf(Void void_) {
        f0.p(void_, "element");
        return -1;
    }

    public ListIterator listIterator() {
        return c0.a;
    }

    public ListIterator listIterator(int n10) {
        if (n10 == 0) {
            return c0.a;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Index: ");
        stringBuilder.append(n10);
        String string2 = stringBuilder.toString();
        IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException(string2);
        throw indexOutOfBoundsException;
    }

    public /* synthetic */ Object remove(int n10) {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        throw unsupportedOperationException;
    }

    public Void remove(int n10) {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        throw unsupportedOperationException;
    }

    public boolean remove(Object object) {
        object = new UnsupportedOperationException("Operation is not supported for read-only collection");
        throw object;
    }

    public boolean removeAll(Collection object) {
        object = new UnsupportedOperationException("Operation is not supported for read-only collection");
        throw object;
    }

    public boolean retainAll(Collection object) {
        object = new UnsupportedOperationException("Operation is not supported for read-only collection");
        throw object;
    }

    public /* synthetic */ Object set(int n10, Object object) {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        throw unsupportedOperationException;
    }

    public Void set(int n10, Void void_) {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        throw unsupportedOperationException;
    }

    public List subList(int n10, int n11) {
        if (n10 == 0 && n11 == 0) {
            return this;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("fromIndex: ");
        stringBuilder.append(n10);
        stringBuilder.append(", toIndex: ");
        stringBuilder.append(n11);
        String string2 = stringBuilder.toString();
        IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException(string2);
        throw indexOutOfBoundsException;
    }

    public Object[] toArray() {
        return t.a(this);
    }

    public Object[] toArray(Object[] objectArray) {
        return t.b(this, objectArray);
    }

    public String toString() {
        return "[]";
    }
}

