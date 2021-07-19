/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.editortemplate.data.database.dao.template;

import androidx.room.RoomDatabase;
import androidx.room.SharedSQLiteStatement;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateFileDao_Impl;

public class G_TemplateFileDao_Impl$5
extends SharedSQLiteStatement {
    public final /* synthetic */ G_TemplateFileDao_Impl this$0;

    public G_TemplateFileDao_Impl$5(G_TemplateFileDao_Impl g_TemplateFileDao_Impl, RoomDatabase roomDatabase) {
        this.this$0 = g_TemplateFileDao_Impl;
        super(roomDatabase);
    }

    public String createQuery() {
        return "DELETE FROM FileData";
    }
}

