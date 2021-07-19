/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.editortemplate.data.database.dao.template;

import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateDataDao_Impl;
import com.zhiyun.editortemplate.data.database.model.template.templatelist.TemplateData;
import com.zhiyun.editortemplate.data.database.model.template.templatelist.TemplateDescription;
import com.zhiyun.editortemplate.data.database.model.track.ScriptDataExt;

public class G_TemplateDataDao_Impl$4
extends EntityDeletionOrUpdateAdapter {
    public final /* synthetic */ G_TemplateDataDao_Impl this$0;

    public G_TemplateDataDao_Impl$4(G_TemplateDataDao_Impl g_TemplateDataDao_Impl, RoomDatabase roomDatabase) {
        this.this$0 = g_TemplateDataDao_Impl;
        super(roomDatabase);
    }

    public void bind(SupportSQLiteStatement supportSQLiteStatement, TemplateData templateData) {
        long l10 = templateData.getId();
        int n10 = 1;
        supportSQLiteStatement.bindLong(n10, l10);
        Object object = templateData.getTextZh();
        int n11 = 2;
        if (object == null) {
            supportSQLiteStatement.bindNull(n11);
        } else {
            object = templateData.getTextZh();
            supportSQLiteStatement.bindString(n11, (String)object);
        }
        object = templateData.getTextZhTw();
        n11 = 3;
        if (object == null) {
            supportSQLiteStatement.bindNull(n11);
        } else {
            object = templateData.getTextZhTw();
            supportSQLiteStatement.bindString(n11, (String)object);
        }
        object = templateData.getTextEn();
        n11 = 4;
        if (object == null) {
            supportSQLiteStatement.bindNull(n11);
        } else {
            object = templateData.getTextEn();
            supportSQLiteStatement.bindString(n11, (String)object);
        }
        object = templateData.getCoverUrl();
        n11 = 5;
        if (object == null) {
            supportSQLiteStatement.bindNull(n11);
        } else {
            object = templateData.getCoverUrl();
            supportSQLiteStatement.bindString(n11, (String)object);
        }
        object = templateData.getVideoUrl();
        n11 = 6;
        if (object == null) {
            supportSQLiteStatement.bindNull(n11);
        } else {
            object = templateData.getVideoUrl();
            supportSQLiteStatement.bindString(n11, (String)object);
        }
        double d10 = templateData.getVideoTime();
        supportSQLiteStatement.bindDouble(7, d10);
        int n12 = 8;
        long l11 = templateData.getVideoCount();
        supportSQLiteStatement.bindLong(n12, l11);
        object = templateData.getVideoRatio();
        n11 = 9;
        if (object == null) {
            supportSQLiteStatement.bindNull(n11);
        } else {
            object = templateData.getVideoRatio();
            supportSQLiteStatement.bindString(n11, (String)object);
        }
        l11 = templateData.getResSize();
        supportSQLiteStatement.bindLong(10, l11);
        long l12 = (long)templateData.isPrimeUsable();
        supportSQLiteStatement.bindLong(11, l12);
        l11 = templateData.getTempType();
        supportSQLiteStatement.bindLong(12, l11);
        n12 = (int)(templateData.isDownloadFinished() ? 1 : 0);
        l12 = n12;
        supportSQLiteStatement.bindLong(13, l12);
        object = templateData.getDownloadTimestamp();
        n11 = 14;
        if (object == null) {
            supportSQLiteStatement.bindNull(n11);
        } else {
            object = templateData.getDownloadTimestamp();
            l12 = (Long)object;
            supportSQLiteStatement.bindLong(n11, l12);
        }
        object = templateData.getEditorTemplate();
        n11 = 15;
        if (object == null) {
            supportSQLiteStatement.bindNull(n11);
        } else {
            object = templateData.getEditorTemplate();
            supportSQLiteStatement.bindString(n11, (String)object);
        }
        object = templateData.getTrackEditorConfigData();
        n11 = 16;
        if (object == null) {
            supportSQLiteStatement.bindNull(n11);
        } else {
            object = templateData.getTrackEditorConfigData();
            supportSQLiteStatement.bindString(n11, (String)object);
        }
        l11 = templateData.getTemplateUseType();
        supportSQLiteStatement.bindLong(17, l11);
        l11 = templateData.getTemplateProtocolType();
        supportSQLiteStatement.bindLong(18, l11);
        n12 = (int)(templateData.isFirstLoaded() ? 1 : 0);
        l12 = n12;
        supportSQLiteStatement.bindLong(19, l12);
        object = templateData.getTemplateDescription();
        n11 = 22;
        n10 = 21;
        int n13 = 20;
        if (object != null) {
            String string2 = ((TemplateDescription)object).getTextZh();
            if (string2 == null) {
                supportSQLiteStatement.bindNull(n13);
            } else {
                string2 = ((TemplateDescription)object).getTextZh();
                supportSQLiteStatement.bindString(n13, string2);
            }
            String string3 = ((TemplateDescription)object).getTextEn();
            if (string3 == null) {
                supportSQLiteStatement.bindNull(n10);
            } else {
                string3 = ((TemplateDescription)object).getTextEn();
                supportSQLiteStatement.bindString(n10, string3);
            }
            String string4 = ((TemplateDescription)object).getTextZhTw();
            if (string4 == null) {
                supportSQLiteStatement.bindNull(n11);
            } else {
                object = ((TemplateDescription)object).getTextZhTw();
                supportSQLiteStatement.bindString(n11, (String)object);
            }
        } else {
            supportSQLiteStatement.bindNull(n13);
            supportSQLiteStatement.bindNull(n10);
            supportSQLiteStatement.bindNull(n11);
        }
        object = templateData.getScriptDataExt();
        n11 = 25;
        n10 = 24;
        n13 = 23;
        if (object != null) {
            int n14 = ((ScriptDataExt)object).getStatus();
            long l13 = n14;
            supportSQLiteStatement.bindLong(n13, l13);
            n13 = ((ScriptDataExt)object).getProtocol();
            long l14 = n13;
            supportSQLiteStatement.bindLong(n10, l14);
            n12 = ((ScriptDataExt)object).getVersion();
            l12 = n12;
            supportSQLiteStatement.bindLong(n11, l12);
        } else {
            supportSQLiteStatement.bindNull(n13);
            supportSQLiteStatement.bindNull(n10);
            supportSQLiteStatement.bindNull(n11);
        }
        l11 = templateData.getId();
        supportSQLiteStatement.bindLong(26, l11);
    }

    public String createQuery() {
        return "UPDATE OR REPLACE `TemplateData` SET `id` = ?,`title_zh` = ?,`title_tw` = ?,`title_en` = ?,`cover_url` = ?,`video_url` = ?,`video_time` = ?,`video_count` = ?,`video_ratio` = ?,`res_size` = ?,`is_prime_usable` = ?,`temp_type` = ?,`download_finished` = ?,`download_timestamp` = ?,`editor_template` = ?,`track_editor_config_data` = ?,`template_use_type` = ?,`template_proto_type` = ?,`first_loaded` = ?,`template_description_zh` = ?,`template_description_en` = ?,`template_description_zh_tw` = ?,`script_ext_status` = ?,`script_ext_protocol` = ?,`script_ext_version` = ? WHERE `id` = ?";
    }
}

