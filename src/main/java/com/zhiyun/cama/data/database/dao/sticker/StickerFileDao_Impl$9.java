/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.database.Cursor
 */
package com.zhiyun.cama.data.database.dao.sticker;

import android.database.Cursor;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import com.zhiyun.cama.data.database.dao.sticker.StickerFileDao_Impl;
import com.zhiyun.cama.data.database.model.sticker.StickerFile;
import com.zhiyun.editorinterface.EditConfig$ResourceType;
import com.zhiyun.editortemplate.data.database.EditorResourceTypeConverters;
import com.zhiyun.editortemplate.data.database.model.template.templatelist.FileData;
import com.zhiyun.editortemplate.data.database.model.template.templatelist.FileExt;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class StickerFileDao_Impl$9
implements Callable {
    public final /* synthetic */ StickerFileDao_Impl this$0;
    public final /* synthetic */ RoomSQLiteQuery val$_statement;

    public StickerFileDao_Impl$9(StickerFileDao_Impl stickerFileDao_Impl, RoomSQLiteQuery roomSQLiteQuery) {
        this.this$0 = stickerFileDao_Impl;
        this.val$_statement = roomSQLiteQuery;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public List call() {
        Object object = StickerFileDao_Impl.access$000(this.this$0);
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
                Object object3;
                boolean bl3;
                String string12;
                String string13;
                String string14;
                String string15;
                Object object4;
                String string16;
                int n22;
                n21 = (int)(roomSQLiteQuery.isNull(n13) ? 1 : 0);
                if (n21 != 0) {
                    n22 = 0;
                    string16 = null;
                } else {
                    object4 = roomSQLiteQuery.getString(n13);
                    string16 = object4;
                }
                n21 = (int)(roomSQLiteQuery.isNull(n14) ? 1 : 0);
                if (n21 != 0) {
                    string15 = null;
                } else {
                    object4 = roomSQLiteQuery.getString(n14);
                    string15 = object4;
                }
                n21 = (int)(roomSQLiteQuery.isNull(n16) ? 1 : 0);
                if (n21 != 0) {
                    string14 = null;
                } else {
                    object4 = roomSQLiteQuery.getString(n16);
                    string14 = object4;
                }
                int n23 = roomSQLiteQuery.getInt(n17);
                n21 = (int)(roomSQLiteQuery.isNull(n18) ? 1 : 0);
                if (n21 != 0) {
                    string13 = null;
                } else {
                    object4 = roomSQLiteQuery.getString(n18);
                    string13 = object4;
                }
                n21 = (int)(roomSQLiteQuery.isNull(n19) ? 1 : 0);
                if (n21 != 0) {
                    string12 = null;
                } else {
                    object4 = roomSQLiteQuery.getString(n19);
                    string12 = object4;
                }
                long l10 = roomSQLiteQuery.getLong(n20);
                n21 = (int)(roomSQLiteQuery.isNull(n11) ? 1 : 0);
                if (n21 != 0 && (n21 = (int)(roomSQLiteQuery.isNull(n10) ? 1 : 0)) != 0 && (n21 = (int)(roomSQLiteQuery.isNull(n12) ? 1 : 0)) != 0) {
                    n21 = 0;
                    object4 = null;
                } else {
                    object4 = new FileExt();
                    bl3 = roomSQLiteQuery.isNull(n11);
                    if (!bl3) {
                        object2 = object3 = roomSQLiteQuery.getString(n11);
                    }
                    ((FileExt)object4).setLicenseUrl((String)object2);
                    bl2 = roomSQLiteQuery.isNull(n10);
                    if (bl2) {
                        bl2 = false;
                        object2 = null;
                    } else {
                        object2 = roomSQLiteQuery.getString(n10);
                    }
                    ((FileExt)object4).setLicenseName((String)object2);
                    bl2 = roomSQLiteQuery.isNull(n12);
                    if (bl2) {
                        bl2 = false;
                        object2 = null;
                    } else {
                        object2 = roomSQLiteQuery.getString(n12);
                    }
                    ((FileExt)object4).setLicensePath((String)object2);
                }
                object3 = object2;
                object2 = new StickerFile(string16, string15, string14, n23, string13, string12, l10);
                bl3 = roomSQLiteQuery.isNull(n15);
                if (bl3) {
                    n22 = n11;
                    bl3 = false;
                    object3 = null;
                } else {
                    object3 = roomSQLiteQuery.getString(n15);
                    n22 = n11;
                }
                object = EditorResourceTypeConverters.stringToType((String)object3);
                ((FileData)object2).setCategory((EditConfig$ResourceType)object);
                ((FileData)object2).setExt((FileExt)object4);
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

