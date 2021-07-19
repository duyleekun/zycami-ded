/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.editortemplate.data.database.dao.template;

import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.zhiyun.editortemplate.data.database.dao.template.G_SortResultDao_Impl;
import com.zhiyun.editortemplate.data.database.model.TypeListConverters;
import com.zhiyun.editortemplate.data.database.model.template.templatelist.SortResult;

public class G_SortResultDao_Impl$1
extends EntityInsertionAdapter {
    public final /* synthetic */ G_SortResultDao_Impl this$0;

    public G_SortResultDao_Impl$1(G_SortResultDao_Impl g_SortResultDao_Impl, RoomDatabase roomDatabase) {
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
        n10 = ((SortResult)object).getCount();
        l10 = n10;
        supportSQLiteStatement.bindLong(3, l10);
        object = TypeListConverters.longListToString(((SortResult)object).getIdList());
        int n11 = 4;
        if (object == null) {
            supportSQLiteStatement.bindNull(n11);
        } else {
            supportSQLiteStatement.bindString(n11, (String)object);
        }
    }

    public String createQuery() {
        return "INSERT OR REPLACE INTO `SortResult` (`page_type`,`next_page`,`count`,`id_list`) VALUES (?,?,?,?)";
    }
}

