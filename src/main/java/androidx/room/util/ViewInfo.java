/*
 * Decompiled with CFR 0.151.
 */
package androidx.room.util;

import androidx.sqlite.db.SupportSQLiteDatabase;

public final class ViewInfo {
    public final String name;
    public final String sql;

    public ViewInfo(String string2, String string3) {
        this.name = string2;
        this.sql = string3;
    }

    public static ViewInfo read(SupportSQLiteDatabase supportSQLiteDatabase, String object) {
        String string2;
        Object object2;
        block9: {
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("SELECT name, sql FROM sqlite_master WHERE type = 'view' AND name = '");
            ((StringBuilder)object2).append((String)object);
            string2 = "'";
            ((StringBuilder)object2).append(string2);
            object2 = ((StringBuilder)object2).toString();
            supportSQLiteDatabase = supportSQLiteDatabase.query((String)object2);
            boolean bl2 = supportSQLiteDatabase.moveToFirst();
            if (!bl2) break block9;
            bl2 = false;
            object2 = null;
            object2 = supportSQLiteDatabase.getString(0);
            int n10 = 1;
            string2 = supportSQLiteDatabase.getString(n10);
            object = new ViewInfo((String)object2, string2);
            return object;
        }
        boolean bl3 = false;
        string2 = null;
        object2 = new ViewInfo((String)object, null);
        supportSQLiteDatabase.close();
        return object2;
        finally {
            supportSQLiteDatabase.close();
        }
    }

    public boolean equals(Object object) {
        boolean bl2;
        String string2;
        boolean bl3 = true;
        if (this == object) {
            return bl3;
        }
        boolean bl4 = object instanceof ViewInfo;
        if (!bl4) {
            return false;
        }
        object = (ViewInfo)object;
        String string3 = this.name;
        if (!(string3 != null ? (bl4 = string3.equals(string2 = ((ViewInfo)object).name)) : (string3 = ((ViewInfo)object).name) == null) || !((string3 = this.sql) != null ? (bl2 = string3.equals(object = ((ViewInfo)object).sql)) : (object = ((ViewInfo)object).sql) == null)) {
            bl3 = false;
        }
        return bl3;
    }

    public int hashCode() {
        int n10;
        String string2 = this.name;
        int n11 = 0;
        if (string2 != null) {
            n10 = string2.hashCode();
        } else {
            n10 = 0;
            string2 = null;
        }
        n10 *= 31;
        String string3 = this.sql;
        if (string3 != null) {
            n11 = string3.hashCode();
        }
        return n10 + n11;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ViewInfo{name='");
        String string2 = this.name;
        stringBuilder.append(string2);
        char c10 = '\'';
        stringBuilder.append(c10);
        stringBuilder.append(", sql='");
        String string3 = this.sql;
        stringBuilder.append(string3);
        stringBuilder.append(c10);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

