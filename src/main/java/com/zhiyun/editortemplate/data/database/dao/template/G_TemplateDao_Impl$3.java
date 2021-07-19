/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.editortemplate.data.database.dao.template;

import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateDao_Impl;
import com.zhiyun.editortemplate.data.database.model.template.Template;

public class G_TemplateDao_Impl$3
extends EntityDeletionOrUpdateAdapter {
    public final /* synthetic */ G_TemplateDao_Impl this$0;

    public G_TemplateDao_Impl$3(G_TemplateDao_Impl g_TemplateDao_Impl, RoomDatabase roomDatabase) {
        this.this$0 = g_TemplateDao_Impl;
        super(roomDatabase);
    }

    public void bind(SupportSQLiteStatement supportSQLiteStatement, Template template) {
        long l10 = template.getId();
        supportSQLiteStatement.bindLong(1, l10);
    }

    public String createQuery() {
        return "DELETE FROM `Template` WHERE `id` = ?";
    }
}

