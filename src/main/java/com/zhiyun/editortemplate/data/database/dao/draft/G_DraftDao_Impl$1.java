/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.editortemplate.data.database.dao.draft;

import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.zhiyun.editortemplate.data.database.dao.draft.G_DraftDao_Impl;
import com.zhiyun.editortemplate.data.database.model.draft.Draft;

public class G_DraftDao_Impl$1
extends EntityInsertionAdapter {
    public final /* synthetic */ G_DraftDao_Impl this$0;

    public G_DraftDao_Impl$1(G_DraftDao_Impl g_DraftDao_Impl, RoomDatabase roomDatabase) {
        this.this$0 = g_DraftDao_Impl;
        super(roomDatabase);
    }

    public void bind(SupportSQLiteStatement supportSQLiteStatement, Draft object) {
        long l10 = ((Draft)object).getId();
        supportSQLiteStatement.bindLong(1, l10);
        l10 = ((Draft)object).getDraftId();
        supportSQLiteStatement.bindLong(2, l10);
        l10 = ((Draft)object).getCreateTime();
        int n10 = 3;
        supportSQLiteStatement.bindLong(n10, l10);
        String string2 = ((Draft)object).getContentDesc();
        int n11 = 4;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n11);
        } else {
            object = ((Draft)object).getContentDesc();
            supportSQLiteStatement.bindString(n11, (String)object);
        }
    }

    public String createQuery() {
        return "INSERT OR REPLACE INTO `draft` (`id`,`draft_id`,`create_time`,`content_desc`) VALUES (nullif(?, 0),?,?,?)";
    }
}

