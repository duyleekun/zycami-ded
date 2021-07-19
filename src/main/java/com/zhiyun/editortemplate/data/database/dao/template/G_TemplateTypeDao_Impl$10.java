/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.editortemplate.data.database.dao.template;

import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteQuery;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateTypeDao_Impl;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class G_TemplateTypeDao_Impl$10
implements Callable {
    public final /* synthetic */ G_TemplateTypeDao_Impl this$0;
    public final /* synthetic */ RoomSQLiteQuery val$_statement;

    public G_TemplateTypeDao_Impl$10(G_TemplateTypeDao_Impl g_TemplateTypeDao_Impl, RoomSQLiteQuery roomSQLiteQuery) {
        this.this$0 = g_TemplateTypeDao_Impl;
        this.val$_statement = roomSQLiteQuery;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public List call() {
        RoomDatabase roomDatabase = G_TemplateTypeDao_Impl.access$000(this.this$0);
        ArrayList<Long> arrayList = this.val$_statement;
        roomDatabase = DBUtil.query(roomDatabase, (SupportSQLiteQuery)((Object)arrayList), false, null);
        try {
            int n10 = roomDatabase.getCount();
            arrayList = new ArrayList<Long>(n10);
            while ((n10 = (int)(roomDatabase.moveToNext() ? 1 : 0)) != 0) {
                Long l10;
                n10 = (int)(roomDatabase.isNull(0) ? 1 : 0);
                if (n10 != 0) {
                    n10 = 0;
                    l10 = null;
                } else {
                    long l11 = roomDatabase.getLong(0);
                    l10 = l11;
                }
                arrayList.add(l10);
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

