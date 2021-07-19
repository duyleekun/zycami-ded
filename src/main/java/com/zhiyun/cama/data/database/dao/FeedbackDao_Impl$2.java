/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data.database.dao;

import androidx.room.RoomDatabase;
import androidx.room.SharedSQLiteStatement;
import com.zhiyun.cama.data.database.dao.FeedbackDao_Impl;

public class FeedbackDao_Impl$2
extends SharedSQLiteStatement {
    public final /* synthetic */ FeedbackDao_Impl this$0;

    public FeedbackDao_Impl$2(FeedbackDao_Impl feedbackDao_Impl, RoomDatabase roomDatabase) {
        this.this$0 = feedbackDao_Impl;
        super(roomDatabase);
    }

    public String createQuery() {
        return "DELETE FROM Feedback";
    }
}

