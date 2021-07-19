/*
 * Decompiled with CFR 0.151.
 */
package org.slf4j.helpers;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.slf4j.Marker;

public class BasicMarker
implements Marker {
    private static String a = "[ ";
    private static String b = " ]";
    private static String c = ", ";
    private static final long serialVersionUID = -2849567615646933777L;
    private final String name;
    private List referenceList;

    public BasicMarker(String object) {
        CopyOnWriteArrayList copyOnWriteArrayList;
        this.referenceList = copyOnWriteArrayList = new CopyOnWriteArrayList();
        if (object != null) {
            this.name = object;
            return;
        }
        object = new IllegalArgumentException("A marker name cannot be null");
        throw object;
    }

    public void add(Marker serializable) {
        if (serializable != null) {
            boolean bl2 = this.contains((Marker)serializable);
            if (bl2) {
                return;
            }
            bl2 = serializable.contains(this);
            if (bl2) {
                return;
            }
            this.referenceList.add(serializable);
            return;
        }
        serializable = new IllegalArgumentException("A null value cannot be added to a Marker as reference.");
        throw serializable;
    }

    public boolean contains(String object) {
        if (object != null) {
            Object object2 = this.name;
            boolean bl2 = ((String)object2).equals(object);
            boolean bl3 = true;
            if (bl2) {
                return bl3;
            }
            bl2 = this.hasReferences();
            if (bl2) {
                boolean bl4;
                object2 = this.referenceList.iterator();
                while (bl4 = object2.hasNext()) {
                    Marker marker = (Marker)object2.next();
                    bl4 = marker.contains((String)object);
                    if (!bl4) continue;
                    return bl3;
                }
            }
            return false;
        }
        object = new IllegalArgumentException("Other cannot be null");
        throw object;
    }

    public boolean contains(Marker serializable) {
        if (serializable != null) {
            boolean bl2 = this.equals(serializable);
            boolean bl3 = true;
            if (bl2) {
                return bl3;
            }
            bl2 = this.hasReferences();
            if (bl2) {
                boolean bl4;
                Iterator iterator2 = this.referenceList.iterator();
                while (bl4 = iterator2.hasNext()) {
                    Marker marker = (Marker)iterator2.next();
                    bl4 = marker.contains((Marker)serializable);
                    if (!bl4) continue;
                    return bl3;
                }
            }
            return false;
        }
        serializable = new IllegalArgumentException("Other cannot be null");
        throw serializable;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        String string2 = null;
        if (object == null) {
            return false;
        }
        boolean bl2 = object instanceof Marker;
        if (!bl2) {
            return false;
        }
        object = (Marker)object;
        string2 = this.name;
        object = object.getName();
        return string2.equals(object);
    }

    public String getName() {
        return this.name;
    }

    public boolean hasChildren() {
        return this.hasReferences();
    }

    public boolean hasReferences() {
        List list = this.referenceList;
        int n10 = list.size();
        if (n10 > 0) {
            n10 = 1;
        } else {
            n10 = 0;
            list = null;
        }
        return n10 != 0;
    }

    public int hashCode() {
        return this.name.hashCode();
    }

    public Iterator iterator() {
        return this.referenceList.iterator();
    }

    public boolean remove(Marker marker) {
        return this.referenceList.remove(marker);
    }

    public String toString() {
        boolean bl2 = this.hasReferences();
        if (!bl2) {
            return this.getName();
        }
        Object object = this.iterator();
        String string2 = this.getName();
        StringBuilder stringBuilder = new StringBuilder(string2);
        char c10 = ' ';
        stringBuilder.append(c10);
        string2 = a;
        stringBuilder.append(string2);
        while ((c10 = (char)(object.hasNext() ? 1 : 0)) != '\u0000') {
            string2 = ((Marker)object.next()).getName();
            stringBuilder.append(string2);
            c10 = (char)(object.hasNext() ? 1 : 0);
            if (c10 == '\u0000') continue;
            string2 = c;
            stringBuilder.append(string2);
        }
        object = b;
        stringBuilder.append((String)object);
        return stringBuilder.toString();
    }
}

