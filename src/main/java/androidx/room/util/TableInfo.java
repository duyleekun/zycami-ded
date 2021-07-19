/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.database.Cursor
 */
package androidx.room.util;

import android.database.Cursor;
import androidx.room.util.TableInfo$Column;
import androidx.room.util.TableInfo$ForeignKey;
import androidx.room.util.TableInfo$ForeignKeyWithSequence;
import androidx.room.util.TableInfo$Index;
import androidx.sqlite.db.SupportSQLiteDatabase;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public final class TableInfo {
    public static final int CREATED_FROM_DATABASE = 2;
    public static final int CREATED_FROM_ENTITY = 1;
    public static final int CREATED_FROM_UNKNOWN;
    public final Map columns;
    public final Set foreignKeys;
    public final Set indices;
    public final String name;

    public TableInfo(String string2, Map map, Set set) {
        Set set2 = Collections.emptySet();
        this(string2, map, set, set2);
    }

    public TableInfo(String set, Map map, Set set2, Set set3) {
        this.name = set;
        set = Collections.unmodifiableMap(map);
        this.columns = set;
        this.foreignKeys = set = Collections.unmodifiableSet(set2);
        set = set3 == null ? null : Collections.unmodifiableSet(set3);
        this.indices = set;
    }

    public static TableInfo read(SupportSQLiteDatabase object, String string2) {
        Map map = TableInfo.readColumns((SupportSQLiteDatabase)object, string2);
        Set set = TableInfo.readForeignKeys((SupportSQLiteDatabase)object, string2);
        object = TableInfo.readIndices((SupportSQLiteDatabase)object, string2);
        TableInfo tableInfo = new TableInfo(string2, map, set, (Set)object);
        return tableInfo;
    }

    private static Map readColumns(SupportSQLiteDatabase supportSQLiteDatabase, String hashMap) {
        block17: {
            int n10;
            CharSequence charSequence = new StringBuilder();
            String string2 = "PRAGMA table_info(`";
            charSequence.append(string2);
            charSequence.append((String)((Object)hashMap));
            charSequence.append("`)");
            hashMap = charSequence.toString();
            supportSQLiteDatabase = supportSQLiteDatabase.query((String)((Object)hashMap));
            hashMap = new HashMap<String, TableInfo$Column>();
            int n11 = supportSQLiteDatabase.getColumnCount();
            if (n11 <= 0) break block17;
            charSequence = "name";
            n11 = supportSQLiteDatabase.getColumnIndex((String)charSequence);
            string2 = "type";
            int n12 = supportSQLiteDatabase.getColumnIndex(string2);
            String string3 = "notnull";
            int n13 = supportSQLiteDatabase.getColumnIndex(string3);
            String string4 = "pk";
            int n14 = supportSQLiteDatabase.getColumnIndex(string4);
            String string5 = "dflt_value";
            try {
                n10 = supportSQLiteDatabase.getColumnIndex(string5);
            }
            catch (Throwable throwable) {
                supportSQLiteDatabase.close();
                throw throwable;
            }
            while (true) {
                boolean bl2 = supportSQLiteDatabase.moveToNext();
                if (!bl2) break;
                String string6 = supportSQLiteDatabase.getString(n11);
                String string7 = supportSQLiteDatabase.getString(n12);
                boolean bl3 = supportSQLiteDatabase.getInt(n13);
                bl3 = bl3;
                int n15 = supportSQLiteDatabase.getInt(n14);
                String string8 = supportSQLiteDatabase.getString(n10);
                int n16 = 2;
                TableInfo$Column tableInfo$Column = new TableInfo$Column(string6, string7, bl3, n15, string8, n16);
                hashMap.put(string6, tableInfo$Column);
                continue;
                break;
            }
        }
        supportSQLiteDatabase.close();
        return hashMap;
    }

    private static List readForeignKeyFieldMappings(Cursor cursor) {
        String string2 = "id";
        int n10 = cursor.getColumnIndex(string2);
        String string3 = "seq";
        int n11 = cursor.getColumnIndex(string3);
        String string4 = "from";
        int n12 = cursor.getColumnIndex(string4);
        String string5 = "to";
        int n13 = cursor.getColumnIndex(string5);
        int n14 = cursor.getCount();
        ArrayList<TableInfo$ForeignKeyWithSequence> arrayList = new ArrayList<TableInfo$ForeignKeyWithSequence>();
        for (int i10 = 0; i10 < n14; ++i10) {
            cursor.moveToPosition(i10);
            int n15 = cursor.getInt(n10);
            int n16 = cursor.getInt(n11);
            String string6 = cursor.getString(n12);
            String string7 = cursor.getString(n13);
            TableInfo$ForeignKeyWithSequence tableInfo$ForeignKeyWithSequence = new TableInfo$ForeignKeyWithSequence(n15, n16, string6, string7);
            arrayList.add(tableInfo$ForeignKeyWithSequence);
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    private static Set readForeignKeys(SupportSQLiteDatabase supportSQLiteDatabase, String string2) {
        int n10;
        HashSet<TableInfo$ForeignKey> hashSet = new HashSet<TableInfo$ForeignKey>();
        CharSequence charSequence = new StringBuilder();
        charSequence.append("PRAGMA foreign_key_list(`");
        Object object = string2;
        charSequence.append(string2);
        charSequence.append("`)");
        charSequence = charSequence.toString();
        object = supportSQLiteDatabase;
        charSequence = supportSQLiteDatabase.query((String)charSequence);
        object = "id";
        int n11 = charSequence.getColumnIndex((String)object);
        String string3 = "seq";
        int n12 = charSequence.getColumnIndex(string3);
        String string4 = "table";
        int n13 = charSequence.getColumnIndex(string4);
        String string5 = "on_delete";
        int n14 = charSequence.getColumnIndex(string5);
        String string6 = "on_update";
        int n15 = charSequence.getColumnIndex(string6);
        List list = TableInfo.readForeignKeyFieldMappings((Cursor)charSequence);
        try {
            n10 = charSequence.getCount();
        }
        catch (Throwable throwable) {
            charSequence.close();
            throw throwable;
        }
        for (int i10 = 0; i10 < n10; ++i10) {
            TableInfo$ForeignKey tableInfo$ForeignKey;
            String string7;
            Object object2;
            charSequence.moveToPosition(i10);
            int n16 = charSequence.getInt(n12);
            if (n16 != 0) continue;
            n16 = charSequence.getInt(n11);
            ArrayList<String> arrayList = new ArrayList<String>();
            Object object3 = new ArrayList();
            Object object4 = list.iterator();
            while (true) {
                boolean bl2 = object4.hasNext();
                if (!bl2) break;
                object2 = object4.next();
                object2 = (TableInfo$ForeignKeyWithSequence)object2;
                int n17 = ((TableInfo$ForeignKeyWithSequence)object2).mId;
                if (n17 != n16) continue;
                string7 = ((TableInfo$ForeignKeyWithSequence)object2).mFrom;
                arrayList.add(string7);
                object2 = ((TableInfo$ForeignKeyWithSequence)object2).mTo;
                object3.add(object2);
                continue;
                break;
            }
            object2 = charSequence.getString(n13);
            string7 = charSequence.getString(n14);
            Object object5 = charSequence.getString(n15);
            object4 = tableInfo$ForeignKey;
            ArrayList arrayList2 = object3;
            object3 = object5;
            object5 = arrayList2;
            tableInfo$ForeignKey = new TableInfo$ForeignKey((String)object2, string7, (String)object3, arrayList, arrayList2);
            hashSet.add(tableInfo$ForeignKey);
        }
        charSequence.close();
        return hashSet;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static TableInfo$Index readIndex(SupportSQLiteDatabase supportSQLiteDatabase, String string2, boolean bl2) {
        ArrayList arrayList = new ArrayList();
        ((StringBuilder)((Object)arrayList)).append("PRAGMA index_xinfo(`");
        ((StringBuilder)((Object)arrayList)).append(string2);
        Object object = "`)";
        ((StringBuilder)((Object)arrayList)).append((String)object);
        arrayList = ((StringBuilder)((Object)arrayList)).toString();
        supportSQLiteDatabase = supportSQLiteDatabase.query((String)((Object)arrayList));
        arrayList = "seqno";
        try {
            int n10;
            int n11 = supportSQLiteDatabase.getColumnIndex((String)((Object)arrayList));
            object = "cid";
            int n12 = supportSQLiteDatabase.getColumnIndex((String)object);
            String string3 = "name";
            int n13 = supportSQLiteDatabase.getColumnIndex(string3);
            int n14 = -1;
            if (n11 == n14) return null;
            if (n12 == n14) return null;
            if (n13 == n14) {
                return null;
            }
            TreeMap<Integer, String> treeMap = new TreeMap<Integer, String>();
            while ((n10 = supportSQLiteDatabase.moveToNext()) != 0) {
                n10 = supportSQLiteDatabase.getInt(n12);
                if (n10 < 0) continue;
                n10 = supportSQLiteDatabase.getInt(n11);
                String string4 = supportSQLiteDatabase.getString(n13);
                Integer n15 = n10;
                treeMap.put(n15, string4);
            }
            n12 = treeMap.size();
            arrayList = new ArrayList(n12);
            object = treeMap.values();
            arrayList.addAll(object);
            object = new TableInfo$Index(string2, bl2, arrayList);
            return object;
        }
        finally {
            supportSQLiteDatabase.close();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static Set readIndices(SupportSQLiteDatabase supportSQLiteDatabase, String string2) {
        StringBuilder stringBuilder = new StringBuilder();
        String string3 = "PRAGMA index_list(`";
        stringBuilder.append(string3);
        stringBuilder.append(string2);
        stringBuilder.append("`)");
        string2 = stringBuilder.toString();
        string2 = supportSQLiteDatabase.query(string2);
        String string4 = "name";
        try {
            boolean bl2;
            HashSet<Object> hashSet;
            int n10 = string2.getColumnIndex(string4);
            string3 = "origin";
            int n11 = string2.getColumnIndex(string3);
            String string5 = "unique";
            int n12 = string2.getColumnIndex(string5);
            int n13 = -1;
            if (n10 != n13 && n11 != n13 && n12 != n13) {
                hashSet = new HashSet<Object>();
            } else {
                string2.close();
                return null;
            }
            while (bl2 = string2.moveToNext()) {
                int n14;
                String string6 = "c";
                Object object = string2.getString(n11);
                bl2 = string6.equals(object);
                if (!bl2) continue;
                object = string2.getString(n10);
                int n15 = string2.getInt(n12);
                if (n15 != (n14 = 1)) {
                    n14 = 0;
                }
                object = TableInfo.readIndex(supportSQLiteDatabase, (String)object, n14 != 0);
                if (object == null) {
                    return null;
                }
                hashSet.add(object);
            }
            return hashSet;
        }
        finally {
            string2.close();
        }
    }

    public boolean equals(Object object) {
        Object object2;
        boolean bl2 = true;
        if (this == object) {
            return bl2;
        }
        boolean bl3 = object instanceof TableInfo;
        if (!bl3) {
            return false;
        }
        object = (TableInfo)object;
        Object object3 = this.name;
        if (object3 != null ? !(bl3 = ((String)object3).equals(object2 = ((TableInfo)object).name)) : (object3 = ((TableInfo)object).name) != null) {
            return false;
        }
        object3 = this.columns;
        if (object3 != null ? !(bl3 = object3.equals(object2 = ((TableInfo)object).columns)) : (object3 = ((TableInfo)object).columns) != null) {
            return false;
        }
        object3 = this.foreignKeys;
        if (object3 != null ? !(bl3 = object3.equals(object2 = ((TableInfo)object).foreignKeys)) : (object3 = ((TableInfo)object).foreignKeys) != null) {
            return false;
        }
        object3 = this.indices;
        if (object3 != null && (object = ((TableInfo)object).indices) != null) {
            return object3.equals(object);
        }
        return bl2;
    }

    public int hashCode() {
        int n10;
        int n11;
        String string2 = this.name;
        int n12 = 0;
        if (string2 != null) {
            n11 = string2.hashCode();
        } else {
            n11 = 0;
            string2 = null;
        }
        n11 *= 31;
        Object object = this.columns;
        if (object != null) {
            n10 = object.hashCode();
        } else {
            n10 = 0;
            object = null;
        }
        n11 = (n11 + n10) * 31;
        object = this.foreignKeys;
        if (object != null) {
            n12 = object.hashCode();
        }
        return n11 + n12;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("TableInfo{name='");
        Object object = this.name;
        stringBuilder.append((String)object);
        stringBuilder.append('\'');
        stringBuilder.append(", columns=");
        object = this.columns;
        stringBuilder.append(object);
        stringBuilder.append(", foreignKeys=");
        object = this.foreignKeys;
        stringBuilder.append(object);
        stringBuilder.append(", indices=");
        object = this.indices;
        stringBuilder.append(object);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

