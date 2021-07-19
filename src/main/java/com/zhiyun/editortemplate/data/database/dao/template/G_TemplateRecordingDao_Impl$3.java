/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.editortemplate.data.database.dao.template;

import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateRecordingDao_Impl;
import com.zhiyun.editortemplate.data.database.model.template.config.TemplateRecording;

public class G_TemplateRecordingDao_Impl$3
extends EntityDeletionOrUpdateAdapter {
    public final /* synthetic */ G_TemplateRecordingDao_Impl this$0;

    public G_TemplateRecordingDao_Impl$3(G_TemplateRecordingDao_Impl g_TemplateRecordingDao_Impl, RoomDatabase roomDatabase) {
        this.this$0 = g_TemplateRecordingDao_Impl;
        super(roomDatabase);
    }

    public void bind(SupportSQLiteStatement supportSQLiteStatement, TemplateRecording templateRecording) {
        long l10 = templateRecording.getId();
        supportSQLiteStatement.bindLong(1, l10);
    }

    public String createQuery() {
        return "DELETE FROM `template_recording` WHERE `id` = ?";
    }
}

