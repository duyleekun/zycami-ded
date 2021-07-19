/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.editortemplate.data.database.dao.template;

import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.zhiyun.editortemplate.data.database.dao.template.G_SortResultDao_Impl;
import com.zhiyun.editortemplate.data.database.model.TypeListConverters;
import com.zhiyun.editortemplate.data.database.model.template.templatelist.SortResult;

public class G_SortResultDao_Impl$4
extends EntityDeletionOrUpdateAdapter {
    public final /* synthetic */ G_SortResultDao_Impl this$0;

    public G_SortResultDao_Impl$4(G_SortResultDao_Impl g_SortResultDao_Impl, RoomDatabase roomDatabase) {
        this.this$0 = g_SortResultDao_Impl;
        super(roomDatabase);
    }

    public void bind(SupportSQLiteStatement supportSQLiteStatement, SortResult object) {
        String string2 = ((SortResult)object).getPageType();
        int n10 = 1;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n10);
        } else {
            string2 = ((SortResult)object).getPageType();
            supportSQLiteStatement.bindString(n10, string2);
        }
        long l10 = ((SortResult)object).getNextPage();
        supportSQLiteStatement.bindLong(2, l10);
        int n11 = 3;
        l10 = ((SortResult)object).getCount();
        supportSQLiteStatement.bindLong(n11, l10);
        string2 = TypeListConverters.longListToString(((SortResult)object).getIdList());
        n10 = 4;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n10);
        } else {
            supportSQLiteStatement.bindString(n10, string2);
        }
        string2 = ((SortResult)object).getPageType();
        n10 = 5;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n10);
        } else {
            object = ((SortResult)object).getPageType();
            supportSQLiteStatement.bindString(n10, (String)object);
        }
    }

    public String createQuery() {
        return "UPDATE OR REPLACE `SortResult` SET `page_type` = ?,`next_page` = ?,`count` = ?,`id_list` = ? WHERE `page_type` = ?";
    }
}

