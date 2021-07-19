/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.editortemplate.data.database.dao.template;

import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.zhiyun.editortemplate.data.database.dao.template.G_SortResultDao_Impl;
import com.zhiyun.editortemplate.data.database.model.template.templatelist.SortResult;

public class G_SortResultDao_Impl$3
extends EntityDeletionOrUpdateAdapter {
    public final /* synthetic */ G_SortResultDao_Impl this$0;

    public G_SortResultDao_Impl$3(G_SortResultDao_Impl g_SortResultDao_Impl, RoomDatabase roomDatabase) {
        this.this$0 = g_SortResultDao_Impl;
        super(roomDatabase);
    }

    public void bind(SupportSQLiteStatement supportSQLiteStatement, SortResult object) {
        String string2 = ((SortResult)object).getPageType();
        int n10 = 1;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n10);
        } else {
            object = ((SortResult)object).getPageType();
            supportSQLiteStatement.bindString(n10, (String)object);
        }
    }

    public String createQuery() {
        return "DELETE FROM `SortResult` WHERE `page_type` = ?";
    }
}

