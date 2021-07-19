/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.editortemplate.data.database.dao.template;

import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteQuery;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateFileDao_Impl;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class G_TemplateFileDao_Impl$18
implements Callable {
    public final /* synthetic */ G_TemplateFileDao_Impl this$0;
    public final /* synthetic */ RoomSQLiteQuery val$_statement;

    public G_TemplateFileDao_Impl$18(G_TemplateFileDao_Impl g_TemplateFileDao_Impl, RoomSQLiteQuery roomSQLiteQuery) {
        this.this$0 = g_TemplateFileDao_Impl;
        this.val$_statement = roomSQLiteQuery;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public List call() {
        RoomDatabase roomDatabase = G_TemplateFileDao_Impl.access$000(this.this$0);
        ArrayList<String> arrayList = this.val$_statement;
        roomDatabase = DBUtil.query(roomDatabase, (SupportSQLiteQuery)((Object)arrayList), false, null);
        try {
            int n10 = roomDatabase.getCount();
            arrayList = new ArrayList<String>(n10);
            while ((n10 = (int)(roomDatabase.moveToNext() ? 1 : 0)) != 0) {
                String string2;
                n10 = (int)(roomDatabase.isNull(0) ? 1 : 0);
                if (n10 != 0) {
                    n10 = 0;
                    string2 = null;
                } else {
                    string2 = roomDatabase.getString(0);
                }
                arrayList.add(string2);
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

