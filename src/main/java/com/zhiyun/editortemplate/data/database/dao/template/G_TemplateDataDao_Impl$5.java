/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.editortemplate.data.database.dao.template;

import androidx.room.RoomDatabase;
import androidx.room.SharedSQLiteStatement;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateDataDao_Impl;

public class G_TemplateDataDao_Impl$5
extends SharedSQLiteStatement {
    public final /* synthetic */ G_TemplateDataDao_Impl this$0;

    public G_TemplateDataDao_Impl$5(G_TemplateDataDao_Impl g_TemplateDataDao_Impl, RoomDatabase roomDatabase) {
        this.this$0 = g_TemplateDataDao_Impl;
        super(roomDatabase);
    }

    public String createQuery() {
        return "DELETE FROM TemplateData WHERE (? IS NULL OR TemplateData.temp_type == ?) AND (? IS NULL OR TemplateData.template_use_type == ?) AND (? IS NULL OR TemplateData.template_proto_type == ?) AND  (? IS NULL OR TemplateData.download_finished == ?)  AND  (? IS NULL OR TemplateData.video_ratio == ?) ";
    }
}

