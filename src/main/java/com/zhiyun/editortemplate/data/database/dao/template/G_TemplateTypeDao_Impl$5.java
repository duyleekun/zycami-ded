/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.editortemplate.data.database.dao.template;

import androidx.room.RoomDatabase;
import androidx.room.SharedSQLiteStatement;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateTypeDao_Impl;

public class G_TemplateTypeDao_Impl$5
extends SharedSQLiteStatement {
    public final /* synthetic */ G_TemplateTypeDao_Impl this$0;

    public G_TemplateTypeDao_Impl$5(G_TemplateTypeDao_Impl g_TemplateTypeDao_Impl, RoomDatabase roomDatabase) {
        this.this$0 = g_TemplateTypeDao_Impl;
        super(roomDatabase);
    }

    public String createQuery() {
        return "DELETE FROM TemplateType WHERE TemplateType.id == ?";
    }
}

