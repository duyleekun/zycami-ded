/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.editortemplate.data.database.dao.draft;

import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.zhiyun.editortemplate.data.database.dao.draft.G_DraftDao_Impl;
import com.zhiyun.editortemplate.data.database.model.draft.Draft;

public class G_DraftDao_Impl$3
extends EntityDeletionOrUpdateAdapter {
    public final /* synthetic */ G_DraftDao_Impl this$0;

    public G_DraftDao_Impl$3(G_DraftDao_Impl g_DraftDao_Impl, RoomDatabase roomDatabase) {
        this.this$0 = g_DraftDao_Impl;
        super(roomDatabase);
    }

    public void bind(SupportSQLiteStatement supportSQLiteStatement, Draft draft) {
        long l10 = draft.getId();
        supportSQLiteStatement.bindLong(1, l10);
    }

    public String createQuery() {
        return "DELETE FROM `draft` WHERE `id` = ?";
    }
}

