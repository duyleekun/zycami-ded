/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data.database.dao.transition;

import androidx.room.RoomDatabase;
import androidx.room.SharedSQLiteStatement;
import com.zhiyun.cama.data.database.dao.transition.TransitionFileDao_Impl;

public class TransitionFileDao_Impl$5
extends SharedSQLiteStatement {
    public final /* synthetic */ TransitionFileDao_Impl this$0;

    public TransitionFileDao_Impl$5(TransitionFileDao_Impl transitionFileDao_Impl, RoomDatabase roomDatabase) {
        this.this$0 = transitionFileDao_Impl;
        super(roomDatabase);
    }

    public String createQuery() {
        return "DELETE FROM transition_file";
    }
}

