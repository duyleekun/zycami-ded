/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.editortemplate.data.database.dao.draft;

import androidx.room.RoomDatabase;
import androidx.room.SharedSQLiteStatement;
import com.zhiyun.editortemplate.data.database.dao.draft.G_DraftDao_Impl;

public class G_DraftDao_Impl$5
extends SharedSQLiteStatement {
    public final /* synthetic */ G_DraftDao_Impl this$0;

    public G_DraftDao_Impl$5(G_DraftDao_Impl g_DraftDao_Impl, RoomDatabase roomDatabase) {
        this.this$0 = g_DraftDao_Impl;
        super(roomDatabase);
    }

    public String createQuery() {
        return "UPDATE draft SET content_desc = ? WHERE draft_id = ?";
    }
}

