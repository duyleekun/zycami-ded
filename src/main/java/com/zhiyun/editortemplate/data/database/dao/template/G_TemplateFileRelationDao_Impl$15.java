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
import androidx.sqlite.db.SupportSQLiteQuery;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateFileRelationDao_Impl;
import com.zhiyun.editortemplate.data.database.model.template.templatelist.TemplateFileRelation;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class G_TemplateFileRelationDao_Impl$15
implements Callable {
    public final /* synthetic */ G_TemplateFileRelationDao_Impl this$0;
    public final /* synthetic */ RoomSQLiteQuery val$_statement;

    public G_TemplateFileRelationDao_Impl$15(G_TemplateFileRelationDao_Impl g_TemplateFileRelationDao_Impl, RoomSQLiteQuery roomSQLiteQuery) {
        this.this$0 = g_TemplateFileRelationDao_Impl;
        this.val$_statement = roomSQLiteQuery;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public List call() {
        RoomDatabase roomDatabase = G_TemplateFileRelationDao_Impl.access$000(this.this$0);
        Object object = this.val$_statement;
        int n10 = 0;
        String string2 = null;
        roomDatabase = DBUtil.query(roomDatabase, (SupportSQLiteQuery)object, false, null);
        object = "temp_id";
        try {
            int n11 = CursorUtil.getColumnIndexOrThrow((Cursor)roomDatabase, (String)object);
            string2 = "file_hash";
            n10 = CursorUtil.getColumnIndexOrThrow((Cursor)roomDatabase, string2);
            int n12 = roomDatabase.getCount();
            ArrayList<TemplateFileRelation> arrayList = new ArrayList<TemplateFileRelation>(n12);
            while ((n12 = (int)(roomDatabase.moveToNext() ? 1 : 0)) != 0) {
                String string3;
                long l10 = roomDatabase.getLong(n11);
                boolean bl2 = roomDatabase.isNull(n10);
                if (bl2) {
                    bl2 = false;
                    string3 = null;
                } else {
                    string3 = roomDatabase.getString(n10);
                }
                TemplateFileRelation templateFileRelation = new TemplateFileRelation(l10, string3);
                arrayList.add(templateFileRelation);
            }
            return arrayList;
        }
        finally {
            roomDatabase.close();
        }
    }

    public void finalize() {
        this.val$_statement.release();
    }
}

