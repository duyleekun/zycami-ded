/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data.database.dao.transition;

import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.zhiyun.cama.data.database.dao.transition.TransitionDataDao_Impl;
import com.zhiyun.cama.data.database.model.transition.TransitionData;

public class TransitionDataDao_Impl$3
extends EntityDeletionOrUpdateAdapter {
    public final /* synthetic */ TransitionDataDao_Impl this$0;

    public TransitionDataDao_Impl$3(TransitionDataDao_Impl transitionDataDao_Impl, RoomDatabase roomDatabase) {
        this.this$0 = transitionDataDao_Impl;
        super(roomDatabase);
    }

    public void bind(SupportSQLiteStatement supportSQLiteStatement, TransitionData transitionData) {
        long l10 = transitionData.getId();
        supportSQLiteStatement.bindLong(1, l10);
    }

    public String createQuery() {
        return "DELETE FROM `transition_data` WHERE `id` = ?";
    }
}

