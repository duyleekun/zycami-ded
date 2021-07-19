/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.editortemplate.data.database.dao.template;

import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateTypeDao_Impl;
import com.zhiyun.editortemplate.data.database.model.template.templatelist.TemplateType;

public class G_TemplateTypeDao_Impl$3
extends EntityDeletionOrUpdateAdapter {
    public final /* synthetic */ G_TemplateTypeDao_Impl this$0;

    public G_TemplateTypeDao_Impl$3(G_TemplateTypeDao_Impl g_TemplateTypeDao_Impl, RoomDatabase roomDatabase) {
        this.this$0 = g_TemplateTypeDao_Impl;
        super(roomDatabase);
    }

    public void bind(SupportSQLiteStatement supportSQLiteStatement, TemplateType templateType) {
        long l10 = templateType.getId();
        supportSQLiteStatement.bindLong(1, l10);
    }

    public String createQuery() {
        return "DELETE FROM `TemplateType` WHERE `id` = ?";
    }
}

