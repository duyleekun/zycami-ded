/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.editortemplate.data.database.dao.template;

import androidx.room.RoomDatabase;
import androidx.room.SharedSQLiteStatement;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateFileRelationDao_Impl;

public class G_TemplateFileRelationDao_Impl$6
extends SharedSQLiteStatement {
    public final /* synthetic */ G_TemplateFileRelationDao_Impl this$0;

    public G_TemplateFileRelationDao_Impl$6(G_TemplateFileRelationDao_Impl g_TemplateFileRelationDao_Impl, RoomDatabase roomDatabase) {
        this.this$0 = g_TemplateFileRelationDao_Impl;
        super(roomDatabase);
    }

    public String createQuery() {
        return "DELETE FROM TemplateFileRelation WHERE temp_id = ?";
    }
}

