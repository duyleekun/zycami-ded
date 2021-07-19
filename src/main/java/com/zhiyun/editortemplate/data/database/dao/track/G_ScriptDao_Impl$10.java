/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.editortemplate.data.database.dao.track;

import androidx.room.EmptyResultSetException;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteQuery;
import com.zhiyun.editortemplate.data.database.dao.track.G_ScriptDao_Impl;
import java.util.concurrent.Callable;

public class G_ScriptDao_Impl$10
implements Callable {
    public final /* synthetic */ G_ScriptDao_Impl this$0;
    public final /* synthetic */ RoomSQLiteQuery val$_statement;

    public G_ScriptDao_Impl$10(G_ScriptDao_Impl g_ScriptDao_Impl, RoomSQLiteQuery roomSQLiteQuery) {
        this.this$0 = g_ScriptDao_Impl;
        this.val$_statement = roomSQLiteQuery;
    }

    public Long call() {
        Object object;
        Object object2;
        Object object3;
        Object object4;
        block24: {
            boolean bl2;
            object4 = G_ScriptDao_Impl.access$000(this.this$0);
            ((RoomDatabase)object4).beginTransaction();
            object4 = this.this$0;
            object4 = G_ScriptDao_Impl.access$000((G_ScriptDao_Impl)object4);
            object3 = this.val$_statement;
            object2 = null;
            object = null;
            object4 = DBUtil.query((RoomDatabase)object4, (SupportSQLiteQuery)object3, false, null);
            try {
                bl2 = object4.moveToFirst();
                if (!bl2) break block24;
            }
            catch (Throwable throwable) {
                object4.close();
                throw throwable;
            }
            bl2 = object4.isNull(0);
            if (bl2) break block24;
            long l10 = object4.getLong(0);
            object2 = object3 = Long.valueOf(l10);
        }
        if (object2 != null) {
            object3 = this.this$0;
            object3 = G_ScriptDao_Impl.access$000((G_ScriptDao_Impl)object3);
            ((RoomDatabase)object3).setTransactionSuccessful();
            object4.close();
            return object2;
        }
        object2 = new StringBuilder();
        object = "Query returned empty result set: ";
        ((StringBuilder)object2).append((String)object);
        object = this.val$_statement;
        object = ((RoomSQLiteQuery)object).getSql();
        ((StringBuilder)object2).append((String)object);
        object2 = ((StringBuilder)object2).toString();
        try {
            object3 = new EmptyResultSetException((String)object2);
            throw object3;
        }
        finally {
            G_ScriptDao_Impl.access$000(this.this$0).endTransaction();
        }
    }

    public void finalize() {
        this.val$_statement.release();
    }
}

