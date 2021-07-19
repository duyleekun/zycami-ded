/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.editortemplate.data.database.dao.draft;

import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.zhiyun.editortemplate.data.database.dao.draft.G_DraftDao_Impl;
import com.zhiyun.editortemplate.data.database.model.draft.Draft;

public class G_DraftDao_Impl$4
extends EntityDeletionOrUpdateAdapter {
    public final /* synthetic */ G_DraftDao_Impl this$0;

    public G_DraftDao_Impl$4(G_DraftDao_Impl g_DraftDao_Impl, RoomDatabase roomDatabase) {
        this.this$0 = g_DraftDao_Impl;
        super(roomDatabase);
    }

    public void bind(SupportSQLiteStatement supportSQLiteStatement, Draft draft) {
        long l10 = draft.getId();
        supportSQLiteStatement.bindLong(1, l10);
        l10 = draft.getDraftId();
        supportSQLiteStatement.bindLong(2, l10);
        l10 = draft.getCreateTime();
        int n10 = 3;
        supportSQLiteStatement.bindLong(n10, l10);
        String string2 = draft.getContentDesc();
        int n11 = 4;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n11);
        } else {
            string2 = draft.getContentDesc();
            supportSQLiteStatement.bindString(n11, string2);
        }
        long l11 = draft.getId();
        supportSQLiteStatement.bindLong(5, l11);
    }

    public String createQuery() {
        return "UPDATE OR REPLACE `draft` SET `id` = ?,`draft_id` = ?,`create_time` = ?,`content_desc` = ? WHERE `id` = ?";
    }
}

