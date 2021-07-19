/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data.database.dao.filter;

import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.zhiyun.cama.data.database.dao.filter.FilterFileDao_Impl;
import com.zhiyun.cama.data.database.model.filter.FilterFile;
import com.zhiyun.editortemplate.data.database.model.template.templatelist.FileData;

public class FilterFileDao_Impl$3
extends EntityDeletionOrUpdateAdapter {
    public final /* synthetic */ FilterFileDao_Impl this$0;

    public FilterFileDao_Impl$3(FilterFileDao_Impl filterFileDao_Impl, RoomDatabase roomDatabase) {
        this.this$0 = filterFileDao_Impl;
        super(roomDatabase);
    }

    public void bind(SupportSQLiteStatement supportSQLiteStatement, FilterFile object) {
        String string2 = ((FileData)object).getHash();
        int n10 = 1;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n10);
        } else {
            object = ((FileData)object).getHash();
            supportSQLiteStatement.bindString(n10, (String)object);
        }
    }

    public String createQuery() {
        return "DELETE FROM `filter_file` WHERE `hash` = ?";
    }
}

