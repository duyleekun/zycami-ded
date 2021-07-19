/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data.database.dao.filter;

import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.zhiyun.cama.data.database.dao.filter.FilterTypeDao_Impl;
import com.zhiyun.cama.data.database.model.filter.FilterType;

public class FilterTypeDao_Impl$3
extends EntityDeletionOrUpdateAdapter {
    public final /* synthetic */ FilterTypeDao_Impl this$0;

    public FilterTypeDao_Impl$3(FilterTypeDao_Impl filterTypeDao_Impl, RoomDatabase roomDatabase) {
        this.this$0 = filterTypeDao_Impl;
        super(roomDatabase);
    }

    public void bind(SupportSQLiteStatement supportSQLiteStatement, FilterType filterType) {
        long l10 = filterType.getId();
        supportSQLiteStatement.bindLong(1, l10);
    }

    public String createQuery() {
        return "DELETE FROM `filter_type` WHERE `id` = ?";
    }
}

