/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.editortemplate.data.database.dao.template;

import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateVideoDao_Impl;
import com.zhiyun.editortemplate.data.database.model.template.config.TemplateVideo;

public class G_TemplateVideoDao_Impl$3
extends EntityDeletionOrUpdateAdapter {
    public final /* synthetic */ G_TemplateVideoDao_Impl this$0;

    public G_TemplateVideoDao_Impl$3(G_TemplateVideoDao_Impl g_TemplateVideoDao_Impl, RoomDatabase roomDatabase) {
        this.this$0 = g_TemplateVideoDao_Impl;
        super(roomDatabase);
    }

    public void bind(SupportSQLiteStatement supportSQLiteStatement, TemplateVideo templateVideo) {
        long l10 = templateVideo.getId();
        supportSQLiteStatement.bindLong(1, l10);
    }

    public String createQuery() {
        return "DELETE FROM `TemplateVideo` WHERE `id` = ?";
    }
}

