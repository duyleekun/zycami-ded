/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.editortemplate.data.database.dao.template;

import androidx.room.RoomDatabase;
import androidx.room.SharedSQLiteStatement;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateDataDao_Impl;

public class G_TemplateDataDao_Impl$7
extends SharedSQLiteStatement {
    public final /* synthetic */ G_TemplateDataDao_Impl this$0;

    public G_TemplateDataDao_Impl$7(G_TemplateDataDao_Impl g_TemplateDataDao_Impl, RoomDatabase roomDatabase) {
        this.this$0 = g_TemplateDataDao_Impl;
        super(roomDatabase);
    }

    public String createQuery() {
        return "UPDATE TemplateData SET first_loaded = ? WHERE id == ?";
    }
}

