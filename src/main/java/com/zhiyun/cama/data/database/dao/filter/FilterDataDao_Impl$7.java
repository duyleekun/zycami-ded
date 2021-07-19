/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data.database.dao.filter;

import androidx.room.RoomDatabase;
import androidx.room.SharedSQLiteStatement;
import com.zhiyun.cama.data.database.dao.filter.FilterDataDao_Impl;

public class FilterDataDao_Impl$7
extends SharedSQLiteStatement {
    public final /* synthetic */ FilterDataDao_Impl this$0;

    public FilterDataDao_Impl$7(FilterDataDao_Impl filterDataDao_Impl, RoomDatabase roomDatabase) {
        this.this$0 = filterDataDao_Impl;
        super(roomDatabase);
    }

    public String createQuery() {
        return "UPDATE filter_data SET path = ? WHERE hash = ?";
    }
}

