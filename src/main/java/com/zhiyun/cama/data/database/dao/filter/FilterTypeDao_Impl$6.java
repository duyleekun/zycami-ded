/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data.database.dao.filter;

import androidx.room.RoomDatabase;
import androidx.room.SharedSQLiteStatement;
import com.zhiyun.cama.data.database.dao.filter.FilterTypeDao_Impl;

public class FilterTypeDao_Impl$6
extends SharedSQLiteStatement {
    public final /* synthetic */ FilterTypeDao_Impl this$0;

    public FilterTypeDao_Impl$6(FilterTypeDao_Impl filterTypeDao_Impl, RoomDatabase roomDatabase) {
        this.this$0 = filterTypeDao_Impl;
        super(roomDatabase);
    }

    public String createQuery() {
        return "DELETE FROM filter_type WHERE res_id > 0";
    }
}

