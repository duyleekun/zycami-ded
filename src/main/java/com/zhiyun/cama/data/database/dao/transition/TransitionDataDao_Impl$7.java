/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data.database.dao.transition;

import androidx.room.RoomDatabase;
import androidx.room.SharedSQLiteStatement;
import com.zhiyun.cama.data.database.dao.transition.TransitionDataDao_Impl;

public class TransitionDataDao_Impl$7
extends SharedSQLiteStatement {
    public final /* synthetic */ TransitionDataDao_Impl this$0;

    public TransitionDataDao_Impl$7(TransitionDataDao_Impl transitionDataDao_Impl, RoomDatabase roomDatabase) {
        this.this$0 = transitionDataDao_Impl;
        super(roomDatabase);
    }

    public String createQuery() {
        return "UPDATE transition_data SET path = ? WHERE hash = ?";
    }
}

