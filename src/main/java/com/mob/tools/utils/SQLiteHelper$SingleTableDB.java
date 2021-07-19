/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.database.sqlite.SQLiteDatabase
 */
package com.mob.tools.utils;

import android.database.sqlite.SQLiteDatabase;
import com.mob.tools.utils.SQLiteHelper$1;
import java.io.File;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class SQLiteHelper$SingleTableDB {
    private SQLiteDatabase db;
    private HashMap fieldLimits;
    private LinkedHashMap fieldTypes;
    private String name;
    private String path;
    private String primary;
    private boolean primaryAutoincrement;

    private SQLiteHelper$SingleTableDB(String hashMap, String string2) {
        this.path = hashMap;
        this.name = string2;
        this.fieldTypes = hashMap = new HashMap();
        this.fieldLimits = hashMap;
    }

    public /* synthetic */ SQLiteHelper$SingleTableDB(String string2, String string3, SQLiteHelper$1 sQLiteHelper$1) {
        this(string2, string3);
    }

    public static /* synthetic */ void access$100(SQLiteHelper$SingleTableDB sQLiteHelper$SingleTableDB) {
        sQLiteHelper$SingleTableDB.open();
    }

    public static /* synthetic */ String access$200(SQLiteHelper$SingleTableDB sQLiteHelper$SingleTableDB) {
        return sQLiteHelper$SingleTableDB.getName();
    }

    public static /* synthetic */ SQLiteDatabase access$300(SQLiteHelper$SingleTableDB sQLiteHelper$SingleTableDB) {
        return sQLiteHelper$SingleTableDB.db;
    }

    public static /* synthetic */ void access$400(SQLiteHelper$SingleTableDB sQLiteHelper$SingleTableDB) {
        sQLiteHelper$SingleTableDB.close();
    }

    private void close() {
        SQLiteDatabase sQLiteDatabase = this.db;
        if (sQLiteDatabase != null) {
            sQLiteDatabase.close();
            sQLiteDatabase = null;
            this.db = null;
        }
    }

    private String getName() {
        return this.name;
    }

    private void open() {
        int n10;
        Object object = this.path;
        Object object2 = new File((String)object);
        object = this.db;
        int n11 = 0;
        if (object != null && (n10 = ((File)object2).exists()) == 0) {
            this.db.close();
            object = ((File)object2).getParentFile();
            if (object != null) {
                ((File)object).mkdirs();
            }
            this.db = null;
        }
        if ((object = this.db) == null) {
            int n12;
            Object object3 = SQLiteDatabase.openOrCreateDatabase((File)object2, null);
            this.db = object3;
            Object object4 = null;
            int n13 = 2;
            Object object5 = new String[n13];
            n10 = 0;
            object = null;
            object5[0] = "table";
            object2 = this.name;
            n11 = 1;
            object5[n11] = object2;
            boolean bl2 = false;
            Object object6 = "sqlite_master";
            Object object7 = "type=? and name=?";
            object2 = object3.query((String)object6, null, (String)object7, object5, null, null, null);
            if (object2 != null) {
                n12 = object2.getCount();
                if (n12 > 0) {
                    n12 = 0;
                    object3 = null;
                } else {
                    n12 = n11;
                }
                object2.close();
            } else {
                n12 = n11;
            }
            if (n12 != 0) {
                boolean bl3;
                object2 = new StringBuilder();
                ((StringBuilder)object2).append("create table  ");
                object3 = this.name;
                ((StringBuilder)object2).append((String)object3);
                ((StringBuilder)object2).append("(");
                object3 = this.fieldTypes.entrySet().iterator();
                while (bl3 = object3.hasNext()) {
                    object6 = (Map.Entry)object3.next();
                    object4 = (String)object6.getKey();
                    object6 = (String)object6.getValue();
                    object7 = (Boolean)this.fieldLimits.get(object4);
                    boolean bl4 = (Boolean)object7;
                    object5 = this.primary;
                    boolean bl5 = ((String)object4).equals(object5);
                    bl2 = bl5 ? this.primaryAutoincrement : false;
                    ((StringBuilder)object2).append((String)object4);
                    object4 = " ";
                    ((StringBuilder)object2).append((String)object4);
                    ((StringBuilder)object2).append((String)object6);
                    object6 = "";
                    object4 = bl4 ? " not null" : object6;
                    ((StringBuilder)object2).append((String)object4);
                    if (bl5) {
                        object6 = " primary key";
                    }
                    ((StringBuilder)object2).append((String)object6);
                    object6 = bl2 ? " autoincrement," : ",";
                    ((StringBuilder)object2).append((String)object6);
                }
                n10 = ((StringBuilder)object2).length() - n11;
                n11 = ((StringBuilder)object2).length();
                object3 = ");";
                ((StringBuilder)object2).replace(n10, n11, (String)object3);
                object = this.db;
                object2 = ((StringBuilder)object2).toString();
                object.execSQL((String)object2);
            }
        }
    }

    public void addField(String string2, String object, boolean bl2) {
        Object object2 = this.db;
        if (object2 == null) {
            object2 = this.fieldTypes;
            ((HashMap)object2).put(string2, object);
            object = this.fieldLimits;
            Boolean bl3 = bl2;
            ((HashMap)object).put(string2, bl3);
        }
    }

    public void setPrimary(String string2, boolean bl2) {
        this.primary = string2;
        this.primaryAutoincrement = bl2;
    }
}

