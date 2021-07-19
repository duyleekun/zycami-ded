/*
 * Decompiled with CFR 0.151.
 */
package androidx.room.util;

import java.util.List;

public final class TableInfo$Index {
    public static final String DEFAULT_PREFIX = "index_";
    public final List columns;
    public final String name;
    public final boolean unique;

    public TableInfo$Index(String string2, boolean bl2, List list) {
        this.name = string2;
        this.unique = bl2;
        this.columns = list;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        boolean bl2 = object instanceof TableInfo$Index;
        String string2 = null;
        if (!bl2) {
            return false;
        }
        object = (TableInfo$Index)object;
        bl2 = this.unique;
        boolean bl3 = ((TableInfo$Index)object).unique;
        if (bl2 != bl3) {
            return false;
        }
        Object object2 = this.columns;
        List list = ((TableInfo$Index)object).columns;
        bl2 = object2.equals(list);
        if (!bl2) {
            return false;
        }
        object2 = this.name;
        string2 = DEFAULT_PREFIX;
        bl2 = ((String)object2).startsWith(string2);
        if (bl2) {
            return ((TableInfo$Index)object).name.startsWith(string2);
        }
        object2 = this.name;
        object = ((TableInfo$Index)object).name;
        return ((String)object2).equals(object);
    }

    public int hashCode() {
        String string2 = this.name;
        String string3 = DEFAULT_PREFIX;
        int n10 = string2.startsWith(string3);
        if (n10 != 0) {
            n10 = -1184239155;
        } else {
            string2 = this.name;
            n10 = string2.hashCode();
        }
        n10 *= 31;
        int n11 = this.unique;
        n10 = (n10 + n11) * 31;
        int n12 = this.columns.hashCode();
        return n10 + n12;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Index{name='");
        Object object = this.name;
        stringBuilder.append((String)object);
        stringBuilder.append('\'');
        stringBuilder.append(", unique=");
        boolean bl2 = this.unique;
        stringBuilder.append(bl2);
        stringBuilder.append(", columns=");
        object = this.columns;
        stringBuilder.append(object);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

