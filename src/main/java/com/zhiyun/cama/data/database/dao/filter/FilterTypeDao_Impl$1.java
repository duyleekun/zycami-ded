/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data.database.dao.filter;

import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.zhiyun.cama.data.database.dao.filter.FilterTypeDao_Impl;
import com.zhiyun.cama.data.database.model.filter.FilterType;

public class FilterTypeDao_Impl$1
extends EntityInsertionAdapter {
    public final /* synthetic */ FilterTypeDao_Impl this$0;

    public FilterTypeDao_Impl$1(FilterTypeDao_Impl filterTypeDao_Impl, RoomDatabase roomDatabase) {
        this.this$0 = filterTypeDao_Impl;
        super(roomDatabase);
    }

    public void bind(SupportSQLiteStatement supportSQLiteStatement, FilterType filterType) {
        String string2 = filterType.getThumb();
        int n10 = 1;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n10);
        } else {
            string2 = filterType.getThumb();
            supportSQLiteStatement.bindString(n10, string2);
        }
        long l10 = filterType.getId();
        supportSQLiteStatement.bindLong(2, l10);
        int n11 = 3;
        l10 = filterType.getResId();
        supportSQLiteStatement.bindLong(n11, l10);
        string2 = filterType.getLabel();
        n10 = 4;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n10);
        } else {
            string2 = filterType.getLabel();
            supportSQLiteStatement.bindString(n10, string2);
        }
        string2 = filterType.getLabel_tw();
        n10 = 5;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n10);
        } else {
            string2 = filterType.getLabel_tw();
            supportSQLiteStatement.bindString(n10, string2);
        }
        string2 = filterType.getLabel_en();
        n10 = 6;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n10);
        } else {
            string2 = filterType.getLabel_en();
            supportSQLiteStatement.bindString(n10, string2);
        }
        l10 = filterType.getSort();
        supportSQLiteStatement.bindLong(7, l10);
    }

    public String createQuery() {
        return "INSERT OR REPLACE INTO `filter_type` (`thumb`,`id`,`res_id`,`label`,`label_tw`,`label_en`,`sort`) VALUES (?,nullif(?, 0),?,?,?,?,?)";
    }
}

