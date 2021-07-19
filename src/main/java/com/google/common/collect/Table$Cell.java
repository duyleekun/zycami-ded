/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

public interface Table$Cell {
    public boolean equals(Object var1);

    public Object getColumnKey();

    public Object getRowKey();

    public Object getValue();

    public int hashCode();
}

