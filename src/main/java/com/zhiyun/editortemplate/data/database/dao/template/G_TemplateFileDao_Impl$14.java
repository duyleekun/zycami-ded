/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.editortemplate.data.database.dao.template;

import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteQuery;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateFileDao_Impl;
import java.util.concurrent.Callable;

public class G_TemplateFileDao_Impl$14
implements Callable {
    public final /* synthetic */ G_TemplateFileDao_Impl this$0;
    public final /* synthetic */ RoomSQLiteQuery val$_statement;

    public G_TemplateFileDao_Impl$14(G_TemplateFileDao_Impl g_TemplateFileDao_Impl, RoomSQLiteQuery roomSQLiteQuery) {
        this.this$0 = g_TemplateFileDao_Impl;
        this.val$_statement = roomSQLiteQuery;
    }

    public Integer call() {
        Object object;
        RoomDatabase roomDatabase;
        block5: {
            int n10;
            roomDatabase = G_TemplateFileDao_Impl.access$000(this.this$0);
            Object object2 = this.val$_statement;
            object = null;
            roomDatabase = DBUtil.query(roomDatabase, (SupportSQLiteQuery)object2, false, null);
            try {
                n10 = roomDatabase.moveToFirst();
                if (n10 == 0) break block5;
            }
            catch (Throwable throwable) {
                roomDatabase.close();
                throw throwable;
            }
            n10 = roomDatabase.isNull(0);
            if (n10 != 0) break block5;
            n10 = roomDatabase.getInt(0);
            object = object2 = Integer.valueOf(n10);
        }
        roomDatabase.close();
        return object;
    }

    public void finalize() {
        this.val$_statement.release();
    }
}

