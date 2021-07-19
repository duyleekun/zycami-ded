/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.editortemplate.data.database.dao.draft;

import androidx.room.RoomDatabase;
import androidx.room.SharedSQLiteStatement;
import com.zhiyun.editortemplate.data.database.dao.draft.G_WithdrawDao_Impl;

public class G_WithdrawDao_Impl$5
extends SharedSQLiteStatement {
    public final /* synthetic */ G_WithdrawDao_Impl this$0;

    public G_WithdrawDao_Impl$5(G_WithdrawDao_Impl g_WithdrawDao_Impl, RoomDatabase roomDatabase) {
        this.this$0 = g_WithdrawDao_Impl;
        super(roomDatabase);
    }

    public String createQuery() {
        return "DELETE FROM TemplateData WHERE templateData.id IN (SELECT back_id FROM withdraw WHERE create_time > ?)";
    }
}

