/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data.database.dao.filter;

import androidx.room.RoomDatabase;
import androidx.room.SharedSQLiteStatement;
import com.zhiyun.cama.data.database.dao.filter.FilterFileDao_Impl;

public class FilterFileDao_Impl$5
extends SharedSQLiteStatement {
    public final /* synthetic */ FilterFileDao_Impl this$0;

    public FilterFileDao_Impl$5(FilterFileDao_Impl filterFileDao_Impl, RoomDatabase roomDatabase) {
        this.this$0 = filterFileDao_Impl;
        super(roomDatabase);
    }

    public String createQuery() {
        return "DELETE FROM filter_file";
    }
}

