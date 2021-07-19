/*
 * Decompiled with CFR 0.151.
 */
package androidx.room.util;

import java.util.Collections;
import java.util.List;

public final class TableInfo$ForeignKey {
    public final List columnNames;
    public final String onDelete;
    public final String onUpdate;
    public final List referenceColumnNames;
    public final String referenceTable;

    public TableInfo$ForeignKey(String list, String string2, String string3, List list2, List list3) {
        this.referenceTable = list;
        this.onDelete = string2;
        this.onUpdate = string3;
        list = Collections.unmodifiableList(list2);
        this.columnNames = list;
        this.referenceColumnNames = list = Collections.unmodifiableList(list3);
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        boolean bl2 = object instanceof TableInfo$ForeignKey;
        if (!bl2) {
            return false;
        }
        object = (TableInfo$ForeignKey)object;
        Object object2 = this.referenceTable;
        Object object3 = ((TableInfo$ForeignKey)object).referenceTable;
        bl2 = ((String)object2).equals(object3);
        if (!bl2) {
            return false;
        }
        object2 = this.onDelete;
        object3 = ((TableInfo$ForeignKey)object).onDelete;
        bl2 = ((String)object2).equals(object3);
        if (!bl2) {
            return false;
        }
        object2 = this.onUpdate;
        object3 = ((TableInfo$ForeignKey)object).onUpdate;
        bl2 = ((String)object2).equals(object3);
        if (!bl2) {
            return false;
        }
        object2 = this.columnNames;
        object3 = ((TableInfo$ForeignKey)object).columnNames;
        bl2 = object2.equals(object3);
        if (!bl2) {
            return false;
        }
        object2 = this.referenceColumnNames;
        object = ((TableInfo$ForeignKey)object).referenceColumnNames;
        return object2.equals(object);
    }

    public int hashCode() {
        int n10 = this.referenceTable.hashCode() * 31;
        int n11 = this.onDelete.hashCode();
        n10 = (n10 + n11) * 31;
        n11 = this.onUpdate.hashCode();
        n10 = (n10 + n11) * 31;
        n11 = this.columnNames.hashCode();
        n10 = (n10 + n11) * 31;
        n11 = this.referenceColumnNames.hashCode();
        return n10 + n11;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ForeignKey{referenceTable='");
        Object object = this.referenceTable;
        stringBuilder.append((String)object);
        char c10 = '\'';
        stringBuilder.append(c10);
        stringBuilder.append(", onDelete='");
        String string2 = this.onDelete;
        stringBuilder.append(string2);
        stringBuilder.append(c10);
        stringBuilder.append(", onUpdate='");
        string2 = this.onUpdate;
        stringBuilder.append(string2);
        stringBuilder.append(c10);
        stringBuilder.append(", columnNames=");
        object = this.columnNames;
        stringBuilder.append(object);
        stringBuilder.append(", referenceColumnNames=");
        object = this.referenceColumnNames;
        stringBuilder.append(object);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

