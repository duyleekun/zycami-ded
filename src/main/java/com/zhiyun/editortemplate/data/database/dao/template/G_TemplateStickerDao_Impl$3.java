/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.editortemplate.data.database.dao.template;

import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateStickerDao_Impl;
import com.zhiyun.editortemplate.data.database.model.template.config.TemplateSticker;

public class G_TemplateStickerDao_Impl$3
extends EntityDeletionOrUpdateAdapter {
    public final /* synthetic */ G_TemplateStickerDao_Impl this$0;

    public G_TemplateStickerDao_Impl$3(G_TemplateStickerDao_Impl g_TemplateStickerDao_Impl, RoomDatabase roomDatabase) {
        this.this$0 = g_TemplateStickerDao_Impl;
        super(roomDatabase);
    }

    public void bind(SupportSQLiteStatement supportSQLiteStatement, TemplateSticker templateSticker) {
        long l10 = templateSticker.getId();
        supportSQLiteStatement.bindLong(1, l10);
    }

    public String createQuery() {
        return "DELETE FROM `TemplateSticker` WHERE `id` = ?";
    }
}

