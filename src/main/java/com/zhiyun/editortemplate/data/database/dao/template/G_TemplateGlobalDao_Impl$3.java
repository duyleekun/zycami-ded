/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.editortemplate.data.database.dao.template;

import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateGlobalDao_Impl;
import com.zhiyun.editortemplate.data.database.model.template.config.TemplateGlobal;

public class G_TemplateGlobalDao_Impl$3
extends EntityDeletionOrUpdateAdapter {
    public final /* synthetic */ G_TemplateGlobalDao_Impl this$0;

    public G_TemplateGlobalDao_Impl$3(G_TemplateGlobalDao_Impl g_TemplateGlobalDao_Impl, RoomDatabase roomDatabase) {
        this.this$0 = g_TemplateGlobalDao_Impl;
        super(roomDatabase);
    }

    public void bind(SupportSQLiteStatement supportSQLiteStatement, TemplateGlobal templateGlobal) {
        long l10 = templateGlobal.getId();
        supportSQLiteStatement.bindLong(1, l10);
    }

    public String createQuery() {
        return "DELETE FROM `TemplateGlobal` WHERE `id` = ?";
    }
}

