/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.database.Cursor
 */
package com.zhiyun.cama.data.database.dao.filter;

import android.database.Cursor;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import com.zhiyun.cama.data.database.dao.filter.FilterFileDao_Impl;
import com.zhiyun.cama.data.database.model.filter.FilterFile;
import com.zhiyun.editorinterface.EditConfig$ResourceType;
import com.zhiyun.editortemplate.data.database.EditorResourceTypeConverters;
import com.zhiyun.editortemplate.data.database.model.template.templatelist.FileData;
import com.zhiyun.editortemplate.data.database.model.template.templatelist.FileExt;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class FilterFileDao_Impl$8
implements Callable {
    public final /* synthetic */ FilterFileDao_Impl this$0;
    public final /* synthetic */ RoomSQLiteQuery val$_statement;

    public FilterFileDao_Impl$8(FilterFileDao_Impl filterFileDao_Impl, RoomSQLiteQuery roomSQLiteQuery) {
        this.this$0 = filterFileDao_Impl;
        this.val$_statement = roomSQLiteQuery;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public List call() {
        Object object = FilterFileDao_Impl.access$000(this.this$0);
        RoomSQLiteQuery roomSQLiteQuery = this.val$_statement;
        int n10 = 0;
        String string2 = null;
        boolean bl2 = false;
        Object object2 = null;
        roomSQLiteQuery = DBUtil.query((RoomDatabase)object, roomSQLiteQuery, false, null);
        object = "ext_lic_url";
        try {
            int n11 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, (String)object);
            string2 = "ext_lic_name";
            n10 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string2);
            String string3 = "ext_lic_path";
            int n12 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string3);
            String string4 = "hash";
            int n13 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string4);
            String string5 = "name";
            int n14 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string5);
            String string6 = "category";
            int n15 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string6);
            String string7 = "mime";
            int n16 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string7);
            String string8 = "size";
            int n17 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string8);
            String string9 = "url";
            int n18 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string9);
            String string10 = "path";
            int n19 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string10);
            String string11 = "download_timestamp";
            int n20 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string11);
            int n21 = roomSQLiteQuery.getCount();
            ArrayList<Object> arrayList = new ArrayList<Object>(n21);
            while ((n21 = (int)(roomSQLiteQuery.moveToNext() ? 1 : 0)) != 0) {
                int n22;
                String string12;
                boolean bl3;
                FileExt fileExt;
                n21 = (int)(roomSQLiteQuery.isNull(n11) ? 1 : 0);
                if (n21 != 0 && (n21 = (int)(roomSQLiteQuery.isNull(n10) ? 1 : 0)) != 0 && (n21 = (int)(roomSQLiteQuery.isNull(n12) ? 1 : 0)) != 0) {
                    n21 = 0;
                    fileExt = null;
                } else {
                    fileExt = new FileExt();
                    bl3 = roomSQLiteQuery.isNull(n11);
                    if (!bl3) {
                        string12 = roomSQLiteQuery.getString(n11);
                        object2 = string12;
                    }
                    fileExt.setLicenseUrl((String)object2);
                    bl2 = roomSQLiteQuery.isNull(n10);
                    if (bl2) {
                        bl2 = false;
                        object2 = null;
                    } else {
                        object2 = roomSQLiteQuery.getString(n10);
                    }
                    fileExt.setLicenseName((String)object2);
                    bl2 = roomSQLiteQuery.isNull(n12);
                    if (bl2) {
                        bl2 = false;
                        object2 = null;
                    } else {
                        object2 = roomSQLiteQuery.getString(n12);
                    }
                    fileExt.setLicensePath((String)object2);
                }
                object2 = new FilterFile();
                bl3 = roomSQLiteQuery.isNull(n13);
                if (bl3) {
                    n22 = n11;
                    n11 = 0;
                    object = null;
                } else {
                    string12 = roomSQLiteQuery.getString(n13);
                    n22 = n11;
                    object = string12;
                }
                ((FileData)object2).setHash((String)object);
                n11 = (int)(roomSQLiteQuery.isNull(n14) ? 1 : 0);
                if (n11 != 0) {
                    n11 = 0;
                    object = null;
                } else {
                    object = roomSQLiteQuery.getString(n14);
                }
                ((FileData)object2).setName((String)object);
                n11 = (int)(roomSQLiteQuery.isNull(n15) ? 1 : 0);
                if (n11 != 0) {
                    n11 = 0;
                    object = null;
                } else {
                    object = roomSQLiteQuery.getString(n15);
                }
                object = EditorResourceTypeConverters.stringToType((String)object);
                ((FileData)object2).setCategory((EditConfig$ResourceType)object);
                n11 = (int)(roomSQLiteQuery.isNull(n16) ? 1 : 0);
                if (n11 != 0) {
                    n11 = 0;
                    object = null;
                } else {
                    object = roomSQLiteQuery.getString(n16);
                }
                ((FileData)object2).setType((String)object);
                n11 = roomSQLiteQuery.getInt(n17);
                ((FileData)object2).setSize(n11);
                n11 = (int)(roomSQLiteQuery.isNull(n18) ? 1 : 0);
                if (n11 != 0) {
                    n11 = 0;
                    object = null;
                } else {
                    object = roomSQLiteQuery.getString(n18);
                }
                ((FileData)object2).setUrl((String)object);
                n11 = (int)(roomSQLiteQuery.isNull(n19) ? 1 : 0);
                if (n11 != 0) {
                    n11 = 0;
                    object = null;
                } else {
                    object = roomSQLiteQuery.getString(n19);
                }
                ((FileData)object2).setPath((String)object);
                long l10 = roomSQLiteQuery.getLong(n20);
                ((FileData)object2).setDownloadTimestamp(l10);
                ((FileData)object2).setExt(fileExt);
                arrayList.add(object2);
                n11 = n22;
                bl2 = false;
                object2 = null;
            }
            return arrayList;
        }
        finally {
            roomSQLiteQuery.close();
        }
    }

    public void finalize() {
        this.val$_statement.release();
    }
}

