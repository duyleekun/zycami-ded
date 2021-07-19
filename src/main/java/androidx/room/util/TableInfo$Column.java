/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 */
package androidx.room.util;

import android.os.Build;
import java.util.Locale;

public final class TableInfo$Column {
    public final int affinity;
    public final String defaultValue;
    private final int mCreatedFrom;
    public final String name;
    public final boolean notNull;
    public final int primaryKeyPosition;
    public final String type;

    public TableInfo$Column(String string2, String string3, boolean bl2, int n10) {
        this(string2, string3, bl2, n10, null, 0);
    }

    public TableInfo$Column(String string2, String string3, boolean bl2, int n10, String string4, int n11) {
        int n12;
        this.name = string2;
        this.type = string3;
        this.notNull = bl2;
        this.primaryKeyPosition = n10;
        this.affinity = n12 = TableInfo$Column.findAffinity(string3);
        this.defaultValue = string4;
        this.mCreatedFrom = n11;
    }

    private static int findAffinity(String string2) {
        int n10 = 5;
        if (string2 == null) {
            return n10;
        }
        Object object = Locale.US;
        boolean bl2 = (string2 = string2.toUpperCase((Locale)object)).contains((CharSequence)(object = "INT"));
        if (bl2) {
            return 3;
        }
        object = "CHAR";
        bl2 = string2.contains((CharSequence)object);
        if (!(bl2 || (bl2 = string2.contains((CharSequence)(object = "CLOB"))) || (bl2 = string2.contains((CharSequence)(object = "TEXT"))))) {
            boolean bl3;
            object = "BLOB";
            bl2 = string2.contains((CharSequence)object);
            if (bl2) {
                return n10;
            }
            String string3 = "REAL";
            n10 = (int)(string2.contains(string3) ? 1 : 0);
            if (n10 == 0 && (n10 = (int)(string2.contains(string3 = "FLOA") ? 1 : 0)) == 0 && !(bl3 = string2.contains(string3 = "DOUB"))) {
                return 1;
            }
            return 4;
        }
        return 2;
    }

    public boolean equals(Object object) {
        String string2;
        int n10 = 1;
        if (this == object) {
            return n10 != 0;
        }
        int n11 = object instanceof TableInfo$Column;
        if (n11 == 0) {
            return false;
        }
        object = (TableInfo$Column)object;
        n11 = Build.VERSION.SDK_INT;
        int n12 = 20;
        if (n11 >= n12 ? (n11 = this.primaryKeyPosition) != (n12 = ((TableInfo$Column)object).primaryKeyPosition) : (n11 = (int)(this.isPrimaryKey() ? 1 : 0)) != (n12 = (int)(((TableInfo$Column)object).isPrimaryKey() ? 1 : 0))) {
            return false;
        }
        String string3 = this.name;
        String string4 = ((TableInfo$Column)object).name;
        n11 = (int)(string3.equals(string4) ? 1 : 0);
        if (n11 == 0) {
            return false;
        }
        n11 = (int)(this.notNull ? 1 : 0);
        n12 = (int)(((TableInfo$Column)object).notNull ? 1 : 0);
        if (n11 != n12) {
            return false;
        }
        n11 = this.mCreatedFrom;
        n12 = 2;
        if (n11 == n10 && (n11 = ((TableInfo$Column)object).mCreatedFrom) == n12 && (string3 = this.defaultValue) != null && (n11 = (int)(string3.equals(string2 = ((TableInfo$Column)object).defaultValue) ? 1 : 0)) == 0) {
            return false;
        }
        n11 = this.mCreatedFrom;
        if (n11 == n12 && (n11 = ((TableInfo$Column)object).mCreatedFrom) == n10 && (string3 = ((TableInfo$Column)object).defaultValue) != null && (n11 = string3.equals(string4 = this.defaultValue)) == 0) {
            return false;
        }
        n11 = this.mCreatedFrom;
        if (n11 != 0 && n11 == (n12 = ((TableInfo$Column)object).mCreatedFrom) && ((string3 = this.defaultValue) != null ? (n11 = string3.equals(string4 = ((TableInfo$Column)object).defaultValue)) == 0 : (string3 = ((TableInfo$Column)object).defaultValue) != null)) {
            return false;
        }
        n11 = this.affinity;
        int n13 = ((TableInfo$Column)object).affinity;
        if (n11 != n13) {
            n10 = 0;
        }
        return n10 != 0;
    }

    public int hashCode() {
        String string2 = this.name;
        int n10 = string2.hashCode() * 31;
        int n11 = this.affinity;
        n10 = (n10 + n11) * 31;
        n11 = (int)(this.notNull ? 1 : 0);
        n11 = n11 != 0 ? 1231 : 1237;
        n10 = (n10 + n11) * 31;
        n11 = this.primaryKeyPosition;
        return n10 + n11;
    }

    public boolean isPrimaryKey() {
        int n10 = this.primaryKeyPosition;
        n10 = n10 > 0 ? 1 : 0;
        return n10 != 0;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Column{name='");
        String string2 = this.name;
        stringBuilder.append(string2);
        char c10 = '\'';
        stringBuilder.append(c10);
        stringBuilder.append(", type='");
        String string3 = this.type;
        stringBuilder.append(string3);
        stringBuilder.append(c10);
        stringBuilder.append(", affinity='");
        int n10 = this.affinity;
        stringBuilder.append(n10);
        stringBuilder.append(c10);
        stringBuilder.append(", notNull=");
        n10 = (int)(this.notNull ? 1 : 0);
        stringBuilder.append(n10 != 0);
        stringBuilder.append(", primaryKeyPosition=");
        n10 = this.primaryKeyPosition;
        stringBuilder.append(n10);
        stringBuilder.append(", defaultValue='");
        string3 = this.defaultValue;
        stringBuilder.append(string3);
        stringBuilder.append(c10);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

