/*
 * Decompiled with CFR 0.151.
 */
package org.slf4j;

import java.io.Serializable;
import java.util.Iterator;

public interface Marker
extends Serializable {
    public static final String ANY_MARKER = "*";
    public static final String ANY_NON_NULL_MARKER = "+";

    public void add(Marker var1);

    public boolean contains(String var1);

    public boolean contains(Marker var1);

    public boolean equals(Object var1);

    public String getName();

    public boolean hasChildren();

    public boolean hasReferences();

    public int hashCode();

    public Iterator iterator();

    public boolean remove(Marker var1);
}

