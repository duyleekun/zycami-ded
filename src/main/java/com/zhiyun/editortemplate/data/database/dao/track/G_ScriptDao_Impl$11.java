/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.editortemplate.data.database.dao.track;

import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteQuery;
import com.zhiyun.editortemplate.data.database.dao.track.G_ScriptDao_Impl;
import java.util.concurrent.Callable;

public class G_ScriptDao_Impl$11
implements Callable {
    public final /* synthetic */ G_ScriptDao_Impl this$0;
    public final /* synthetic */ RoomSQLiteQuery val$_statement;

    public G_ScriptDao_Impl$11(G_ScriptDao_Impl g_ScriptDao_Impl, RoomSQLiteQuery roomSQLiteQuery) {
        this.this$0 = g_ScriptDao_Impl;
        this.val$_statement = roomSQLiteQuery;
    }

    public Long call() {
        Object object;
        Object object2;
        Object object3;
        block16: {
            boolean bl2;
            object3 = G_ScriptDao_Impl.access$000(this.this$0);
            ((RoomDatabase)object3).beginTransaction();
            object3 = this.this$0;
            object3 = G_ScriptDao_Impl.access$000((G_ScriptDao_Impl)object3);
            object2 = this.val$_statement;
            object = null;
            object3 = DBUtil.query((RoomDatabase)object3, (SupportSQLiteQuery)object2, false, null);
            try {
                bl2 = object3.moveToFirst();
                if (!bl2) break block16;
            }
            catch (Throwable throwable) {
                object3.close();
                throw throwable;
            }
            bl2 = object3.isNull(0);
            if (bl2) break block16;
            long l10 = object3.getLong(0);
            object = object2 = Long.valueOf(l10);
        }
        object2 = this.this$0;
        object2 = G_ScriptDao_Impl.access$000((G_ScriptDao_Impl)object2);
        ((RoomDatabase)object2).setTransactionSuccessful();
        try {
            object3.close();
            return object;
        }
        finally {
            G_ScriptDao_Impl.access$000(this.this$0).endTransaction();
        }
    }

    public void finalize() {
        this.val$_statement.release();
    }
}

