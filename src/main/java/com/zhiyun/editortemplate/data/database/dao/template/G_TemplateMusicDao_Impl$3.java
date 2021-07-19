/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.editortemplate.data.database.dao.template;

import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateMusicDao_Impl;
import com.zhiyun.editortemplate.data.database.model.template.config.TemplateMusic;

public class G_TemplateMusicDao_Impl$3
extends EntityDeletionOrUpdateAdapter {
    public final /* synthetic */ G_TemplateMusicDao_Impl this$0;

    public G_TemplateMusicDao_Impl$3(G_TemplateMusicDao_Impl g_TemplateMusicDao_Impl, RoomDatabase roomDatabase) {
        this.this$0 = g_TemplateMusicDao_Impl;
        super(roomDatabase);
    }

    public void bind(SupportSQLiteStatement supportSQLiteStatement, TemplateMusic templateMusic) {
        long l10 = templateMusic.getId();
        supportSQLiteStatement.bindLong(1, l10);
    }

    public String createQuery() {
        return "DELETE FROM `TemplateMusic` WHERE `id` = ?";
    }
}

