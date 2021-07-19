/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data.database.dao.filter;

import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.zhiyun.cama.data.database.dao.filter.FilterDataDao_Impl;
import com.zhiyun.cama.data.database.model.filter.FilterData;

public class FilterDataDao_Impl$1
extends EntityInsertionAdapter {
    public final /* synthetic */ FilterDataDao_Impl this$0;

    public FilterDataDao_Impl$1(FilterDataDao_Impl filterDataDao_Impl, RoomDatabase roomDatabase) {
        this.this$0 = filterDataDao_Impl;
        super(roomDatabase);
    }

    public void bind(SupportSQLiteStatement supportSQLiteStatement, FilterData filterData) {
        long l10 = filterData.getTypeId();
        supportSQLiteStatement.bindLong(1, l10);
        l10 = filterData.getSize();
        int n10 = 2;
        supportSQLiteStatement.bindLong(n10, l10);
        String string2 = filterData.getPath();
        int n11 = 3;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n11);
        } else {
            string2 = filterData.getPath();
            supportSQLiteStatement.bindString(n11, string2);
        }
        string2 = filterData.getThumb();
        n11 = 4;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n11);
        } else {
            string2 = filterData.getThumb();
            supportSQLiteStatement.bindString(n11, string2);
        }
        string2 = filterData.getHash();
        n11 = 5;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n11);
        } else {
            string2 = filterData.getHash();
            supportSQLiteStatement.bindString(n11, string2);
        }
        int n12 = 6;
        long l11 = filterData.getMain_sort();
        supportSQLiteStatement.bindLong(n12, l11);
        string2 = filterData.getLicensePath();
        n11 = 7;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n11);
        } else {
            string2 = filterData.getLicensePath();
            supportSQLiteStatement.bindString(n11, string2);
        }
        string2 = filterData.getLicenseName();
        n11 = 8;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n11);
        } else {
            string2 = filterData.getLicenseName();
            supportSQLiteStatement.bindString(n11, string2);
        }
        l11 = filterData.getRequiredPrime();
        supportSQLiteStatement.bindLong(9, l11);
        l11 = filterData.getId();
        supportSQLiteStatement.bindLong(10, l11);
        n12 = 11;
        l11 = filterData.getResId();
        supportSQLiteStatement.bindLong(n12, l11);
        string2 = filterData.getLabel();
        n11 = 12;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n11);
        } else {
            string2 = filterData.getLabel();
            supportSQLiteStatement.bindString(n11, string2);
        }
        string2 = filterData.getLabel_tw();
        n11 = 13;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n11);
        } else {
            string2 = filterData.getLabel_tw();
            supportSQLiteStatement.bindString(n11, string2);
        }
        string2 = filterData.getLabel_en();
        n11 = 14;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n11);
        } else {
            string2 = filterData.getLabel_en();
            supportSQLiteStatement.bindString(n11, string2);
        }
        l11 = filterData.getSort();
        supportSQLiteStatement.bindLong(15, l11);
    }

    public String createQuery() {
        return "INSERT OR REPLACE INTO `filter_data` (`type_id`,`size`,`path`,`thumb`,`hash`,`main_sort`,`licensePath`,`licenseName`,`requiredPrime`,`id`,`res_id`,`label`,`label_tw`,`label_en`,`sort`) VALUES (?,?,?,?,?,?,?,?,?,nullif(?, 0),?,?,?,?,?)";
    }
}

