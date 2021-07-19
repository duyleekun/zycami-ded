/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.ForwardingObject;
import com.google.common.collect.Table;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

public abstract class ForwardingTable
extends ForwardingObject
implements Table {
    public Set cellSet() {
        return this.delegate().cellSet();
    }

    public void clear() {
        this.delegate().clear();
    }

    public Map column(Object object) {
        return this.delegate().column(object);
    }

    public Set columnKeySet() {
        return this.delegate().columnKeySet();
    }

    public Map columnMap() {
        return this.delegate().columnMap();
    }

    public boolean contains(Object object, Object object2) {
        return this.delegate().contains(object, object2);
    }

    public boolean containsColumn(Object object) {
        return this.delegate().containsColumn(object);
    }

    public boolean containsRow(Object object) {
        return this.delegate().containsRow(object);
    }

    public boolean containsValue(Object object) {
        return this.delegate().containsValue(object);
    }

    public abstract Table delegate();

    public boolean equals(Object object) {
        Table table;
        boolean bl2;
        if (object != this && !(bl2 = (table = this.delegate()).equals(object))) {
            bl2 = false;
            object = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }

    public Object get(Object object, Object object2) {
        return this.delegate().get(object, object2);
    }

    public int hashCode() {
        return this.delegate().hashCode();
    }

    public boolean isEmpty() {
        return this.delegate().isEmpty();
    }

    public Object put(Object object, Object object2, Object object3) {
        return this.delegate().put(object, object2, object3);
    }

    public void putAll(Table table) {
        this.delegate().putAll(table);
    }

    public Object remove(Object object, Object object2) {
        return this.delegate().remove(object, object2);
    }

    public Map row(Object object) {
        return this.delegate().row(object);
    }

    public Set rowKeySet() {
        return this.delegate().rowKeySet();
    }

    public Map rowMap() {
        return this.delegate().rowMap();
    }

    public int size() {
        return this.delegate().size();
    }

    public Collection values() {
        return this.delegate().values();
    }
}

