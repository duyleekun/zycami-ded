/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.database.Cursor
 */
package com.zhiyun.editortemplate.data.database.dao.template;

import android.database.Cursor;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateTypeDao_Impl;
import com.zhiyun.editortemplate.data.database.model.template.templatelist.TemplateType;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class G_TemplateTypeDao_Impl$16
implements Callable {
    public final /* synthetic */ G_TemplateTypeDao_Impl this$0;
    public final /* synthetic */ RoomSQLiteQuery val$_statement;

    public G_TemplateTypeDao_Impl$16(G_TemplateTypeDao_Impl g_TemplateTypeDao_Impl, RoomSQLiteQuery roomSQLiteQuery) {
        this.this$0 = g_TemplateTypeDao_Impl;
        this.val$_statement = roomSQLiteQuery;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public List call() {
        Object object = G_TemplateTypeDao_Impl.access$000(this.this$0);
        RoomSQLiteQuery roomSQLiteQuery = this.val$_statement;
        int n10 = 0;
        String string2 = null;
        roomSQLiteQuery = DBUtil.query((RoomDatabase)object, roomSQLiteQuery, false, null);
        object = "id";
        try {
            int n11 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, (String)object);
            string2 = "label";
            n10 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string2);
            String string3 = "label_tw";
            int n12 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string3);
            String string4 = "label_en";
            int n13 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string4);
            String string5 = "resource_type";
            int n14 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string5);
            String string6 = "template_proto_type";
            int n15 = CursorUtil.getColumnIndexOrThrow((Cursor)roomSQLiteQuery, string6);
            int n16 = roomSQLiteQuery.getCount();
            ArrayList<Object> arrayList = new ArrayList<Object>(n16);
            while ((n16 = (int)(roomSQLiteQuery.moveToNext() ? 1 : 0)) != 0) {
                String string7;
                String string8;
                Object object2;
                String string9;
                long l10 = roomSQLiteQuery.getLong(n11);
                n16 = (int)(roomSQLiteQuery.isNull(n10) ? 1 : 0);
                if (n16 != 0) {
                    string9 = null;
                } else {
                    object2 = roomSQLiteQuery.getString(n10);
                    string9 = object2;
                }
                n16 = (int)(roomSQLiteQuery.isNull(n12) ? 1 : 0);
                if (n16 != 0) {
                    string8 = null;
                } else {
                    object2 = roomSQLiteQuery.getString(n12);
                    string8 = object2;
                }
                n16 = (int)(roomSQLiteQuery.isNull(n13) ? 1 : 0);
                if (n16 != 0) {
                    string7 = null;
                } else {
                    object2 = roomSQLiteQuery.getString(n13);
                    string7 = object2;
                }
                int n17 = roomSQLiteQuery.getInt(n14);
                int n18 = roomSQLiteQuery.getInt(n15);
                object2 = TemplateType.create(l10, string9, string8, string7, n17, n18);
                arrayList.add(object2);
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

