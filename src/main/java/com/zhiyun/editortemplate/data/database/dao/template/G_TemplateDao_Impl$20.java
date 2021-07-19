/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.editortemplate.data.database.dao.template;

import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteQuery;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateDao_Impl;
import java.util.concurrent.Callable;

public class G_TemplateDao_Impl$20
implements Callable {
    public final /* synthetic */ G_TemplateDao_Impl this$0;
    public final /* synthetic */ RoomSQLiteQuery val$_statement;

    public G_TemplateDao_Impl$20(G_TemplateDao_Impl g_TemplateDao_Impl, RoomSQLiteQuery roomSQLiteQuery) {
        this.this$0 = g_TemplateDao_Impl;
        this.val$_statement = roomSQLiteQuery;
    }

    public Long call() {
        Object object;
        RoomDatabase roomDatabase;
        block5: {
            boolean bl2;
            roomDatabase = G_TemplateDao_Impl.access$000(this.this$0);
            Object object2 = this.val$_statement;
            object = null;
            roomDatabase = DBUtil.query(roomDatabase, (SupportSQLiteQuery)object2, false, null);
            try {
                bl2 = roomDatabase.moveToFirst();
                if (!bl2) break block5;
            }
            catch (Throwable throwable) {
                roomDatabase.close();
                throw throwable;
            }
            bl2 = roomDatabase.isNull(0);
            if (bl2) break block5;
            long l10 = roomDatabase.getLong(0);
            object = object2 = Long.valueOf(l10);
        }
        roomDatabase.close();
        return object;
    }

    public void finalize() {
        this.val$_statement.release();
    }
}

