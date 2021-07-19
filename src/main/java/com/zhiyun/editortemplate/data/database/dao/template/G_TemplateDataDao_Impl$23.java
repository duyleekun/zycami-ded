/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.editortemplate.data.database.dao.template;

import androidx.room.EmptyResultSetException;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteQuery;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateDataDao_Impl;
import java.util.concurrent.Callable;

public class G_TemplateDataDao_Impl$23
implements Callable {
    public final /* synthetic */ G_TemplateDataDao_Impl this$0;
    public final /* synthetic */ RoomSQLiteQuery val$_statement;

    public G_TemplateDataDao_Impl$23(G_TemplateDataDao_Impl g_TemplateDataDao_Impl, RoomSQLiteQuery roomSQLiteQuery) {
        this.this$0 = g_TemplateDataDao_Impl;
        this.val$_statement = roomSQLiteQuery;
    }

    public Long call() {
        Object object;
        CharSequence charSequence;
        Object object2;
        RoomDatabase roomDatabase;
        block13: {
            boolean bl2;
            roomDatabase = G_TemplateDataDao_Impl.access$000(this.this$0);
            object2 = this.val$_statement;
            charSequence = null;
            object = null;
            roomDatabase = DBUtil.query(roomDatabase, (SupportSQLiteQuery)object2, false, null);
            try {
                bl2 = roomDatabase.moveToFirst();
                if (!bl2) break block13;
            }
            catch (Throwable throwable) {
                roomDatabase.close();
                throw throwable;
            }
            bl2 = roomDatabase.isNull(0);
            if (bl2) break block13;
            long l10 = roomDatabase.getLong(0);
            object = object2 = Long.valueOf(l10);
        }
        if (object != null) {
            roomDatabase.close();
            return object;
        }
        charSequence = new StringBuilder();
        object = "Query returned empty result set: ";
        charSequence.append((String)object);
        object = this.val$_statement;
        object = ((RoomSQLiteQuery)object).getSql();
        charSequence.append((String)object);
        charSequence = charSequence.toString();
        object2 = new EmptyResultSetException((String)charSequence);
        throw object2;
    }

    public void finalize() {
        this.val$_statement.release();
    }
}

