/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data.database.dao.filter;

import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.zhiyun.cama.data.database.dao.filter.FilterDataDao_Impl;
import com.zhiyun.cama.data.database.model.filter.FilterData;

public class FilterDataDao_Impl$3
extends EntityDeletionOrUpdateAdapter {
    public final /* synthetic */ FilterDataDao_Impl this$0;

    public FilterDataDao_Impl$3(FilterDataDao_Impl filterDataDao_Impl, RoomDatabase roomDatabase) {
        this.this$0 = filterDataDao_Impl;
        super(roomDatabase);
    }

    public void bind(SupportSQLiteStatement supportSQLiteStatement, FilterData filterData) {
        long l10 = filterData.getId();
        supportSQLiteStatement.bindLong(1, l10);
    }

    public String createQuery() {
        return "DELETE FROM `filter_data` WHERE `id` = ?";
    }
}

