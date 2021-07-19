/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.editortemplate.data.database.dao.template;

import androidx.room.RoomDatabase;
import androidx.room.SharedSQLiteStatement;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateFileRelationDao_Impl;

public class G_TemplateFileRelationDao_Impl$5
extends SharedSQLiteStatement {
    public final /* synthetic */ G_TemplateFileRelationDao_Impl this$0;

    public G_TemplateFileRelationDao_Impl$5(G_TemplateFileRelationDao_Impl g_TemplateFileRelationDao_Impl, RoomDatabase roomDatabase) {
        this.this$0 = g_TemplateFileRelationDao_Impl;
        super(roomDatabase);
    }

    public String createQuery() {
        return "INSERT INTO TemplateFileRelation (temp_id,file_hash) SELECT ?, file_hash From TemplateFileRelation WHERE temp_id == ?";
    }
}

