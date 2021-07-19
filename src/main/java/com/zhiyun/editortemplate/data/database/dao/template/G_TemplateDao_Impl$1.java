/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.editortemplate.data.database.dao.template;

import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateDao_Impl;
import com.zhiyun.editortemplate.data.database.model.template.Template;

public class G_TemplateDao_Impl$1
extends EntityInsertionAdapter {
    public final /* synthetic */ G_TemplateDao_Impl this$0;

    public G_TemplateDao_Impl$1(G_TemplateDao_Impl g_TemplateDao_Impl, RoomDatabase roomDatabase) {
        this.this$0 = g_TemplateDao_Impl;
        super(roomDatabase);
    }

    public void bind(SupportSQLiteStatement supportSQLiteStatement, Template template) {
        long l10 = template.getId();
        supportSQLiteStatement.bindLong(1, l10);
        l10 = template.getTempId();
        supportSQLiteStatement.bindLong(2, l10);
        l10 = template.getTypeId();
        supportSQLiteStatement.bindLong(3, l10);
        l10 = template.getReferenceId();
        supportSQLiteStatement.bindLong(4, l10);
    }

    public String createQuery() {
        return "INSERT OR REPLACE INTO `Template` (`id`,`temp_id`,`type_id`,`reference_id`) VALUES (nullif(?, 0),?,?,?)";
    }
}

