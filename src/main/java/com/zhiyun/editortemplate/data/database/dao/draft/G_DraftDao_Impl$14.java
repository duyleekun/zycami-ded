/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.database.Cursor
 */
package com.zhiyun.editortemplate.data.database.dao.draft;

import android.database.Cursor;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteQuery;
import com.zhiyun.editortemplate.data.database.dao.draft.G_DraftDao_Impl;
import com.zhiyun.editortemplate.data.database.model.draft.Draft;
import java.util.concurrent.Callable;

public class G_DraftDao_Impl$14
implements Callable {
    public final /* synthetic */ G_DraftDao_Impl this$0;
    public final /* synthetic */ RoomSQLiteQuery val$_statement;

    public G_DraftDao_Impl$14(G_DraftDao_Impl g_DraftDao_Impl, RoomSQLiteQuery roomSQLiteQuery) {
        this.this$0 = g_DraftDao_Impl;
        this.val$_statement = roomSQLiteQuery;
    }

    public Draft call() {
        Object object;
        RoomDatabase roomDatabase;
        block17: {
            Draft draft;
            block18: {
                int n10;
                roomDatabase = G_DraftDao_Impl.access$000(this.this$0);
                Object object2 = this.val$_statement;
                int n11 = 0;
                String string2 = null;
                object = null;
                roomDatabase = DBUtil.query(roomDatabase, (SupportSQLiteQuery)object2, false, null);
                object2 = "id";
                try {
                    n10 = CursorUtil.getColumnIndexOrThrow((Cursor)roomDatabase, (String)object2);
                    string2 = "draft_id";
                }
                catch (Throwable throwable) {
                    roomDatabase.close();
                    throw throwable;
                }
                n11 = CursorUtil.getColumnIndexOrThrow((Cursor)roomDatabase, string2);
                String string3 = "create_time";
                int n12 = CursorUtil.getColumnIndexOrThrow((Cursor)roomDatabase, string3);
                String string4 = "content_desc";
                int n13 = CursorUtil.getColumnIndexOrThrow((Cursor)roomDatabase, string4);
                boolean bl2 = roomDatabase.moveToFirst();
                if (!bl2) break block17;
                draft = new Draft();
                long l10 = roomDatabase.getLong(n10);
                draft.setId(l10);
                long l11 = roomDatabase.getLong(n11);
                draft.setDraftId(l11);
                l11 = roomDatabase.getLong(n12);
                draft.setCreateTime(l11);
                n10 = (int)(roomDatabase.isNull(n13) ? 1 : 0);
                if (n10 != 0) break block18;
                object = roomDatabase.getString(n13);
            }
            draft.setContentDesc((String)object);
            object = draft;
        }
        roomDatabase.close();
        return object;
    }

    public void finalize() {
        this.val$_statement.release();
    }
}

