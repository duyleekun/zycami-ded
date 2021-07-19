/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data.database.dao.transition;

import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.zhiyun.cama.data.database.dao.transition.TransitionDataDao_Impl;
import com.zhiyun.cama.data.database.model.transition.TransitionData;

public class TransitionDataDao_Impl$1
extends EntityInsertionAdapter {
    public final /* synthetic */ TransitionDataDao_Impl this$0;

    public TransitionDataDao_Impl$1(TransitionDataDao_Impl transitionDataDao_Impl, RoomDatabase roomDatabase) {
        this.this$0 = transitionDataDao_Impl;
        super(roomDatabase);
    }

    public void bind(SupportSQLiteStatement supportSQLiteStatement, TransitionData transitionData) {
        long l10 = transitionData.getSize();
        int n10 = 1;
        supportSQLiteStatement.bindLong(n10, l10);
        String string2 = transitionData.getPath();
        int n11 = 2;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n11);
        } else {
            string2 = transitionData.getPath();
            supportSQLiteStatement.bindString(n11, string2);
        }
        string2 = transitionData.getHash();
        n11 = 3;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n11);
        } else {
            string2 = transitionData.getHash();
            supportSQLiteStatement.bindString(n11, string2);
        }
        string2 = transitionData.getThumb();
        n11 = 4;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n11);
        } else {
            string2 = transitionData.getThumb();
            supportSQLiteStatement.bindString(n11, string2);
        }
        string2 = transitionData.getLittleThumb();
        n11 = 5;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n11);
        } else {
            string2 = transitionData.getLittleThumb();
            supportSQLiteStatement.bindString(n11, string2);
        }
        int n12 = 6;
        long l11 = transitionData.getTransitionType();
        supportSQLiteStatement.bindLong(n12, l11);
        string2 = transitionData.getLicensePath();
        n11 = 7;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n11);
        } else {
            string2 = transitionData.getLicensePath();
            supportSQLiteStatement.bindString(n11, string2);
        }
        string2 = transitionData.getLicenseName();
        n11 = 8;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n11);
        } else {
            string2 = transitionData.getLicenseName();
            supportSQLiteStatement.bindString(n11, string2);
        }
        l11 = transitionData.getRequiredPrime();
        supportSQLiteStatement.bindLong(9, l11);
        l11 = transitionData.getId();
        supportSQLiteStatement.bindLong(10, l11);
        n12 = 11;
        l11 = transitionData.getResId();
        supportSQLiteStatement.bindLong(n12, l11);
        string2 = transitionData.getLabel();
        n11 = 12;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n11);
        } else {
            string2 = transitionData.getLabel();
            supportSQLiteStatement.bindString(n11, string2);
        }
        string2 = transitionData.getLabel_tw();
        n11 = 13;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n11);
        } else {
            string2 = transitionData.getLabel_tw();
            supportSQLiteStatement.bindString(n11, string2);
        }
        string2 = transitionData.getLabel_en();
        n11 = 14;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n11);
        } else {
            string2 = transitionData.getLabel_en();
            supportSQLiteStatement.bindString(n11, string2);
        }
        l11 = transitionData.getSort();
        supportSQLiteStatement.bindLong(15, l11);
    }

    public String createQuery() {
        return "INSERT OR REPLACE INTO `transition_data` (`size`,`path`,`hash`,`thumb`,`littleThumb`,`transitionType`,`licensePath`,`licenseName`,`requiredPrime`,`id`,`res_id`,`label`,`label_tw`,`label_en`,`sort`) VALUES (?,?,?,?,?,?,?,?,?,nullif(?, 0),?,?,?,?,?)";
    }
}

