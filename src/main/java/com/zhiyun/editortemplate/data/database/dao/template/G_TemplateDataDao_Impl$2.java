/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.editortemplate.data.database.dao.template;

import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateDataDao_Impl;
import com.zhiyun.editortemplate.data.database.model.template.templatelist.TemplateData;
import com.zhiyun.editortemplate.data.database.model.template.templatelist.TemplateDescription;
import com.zhiyun.editortemplate.data.database.model.track.ScriptDataExt;

public class G_TemplateDataDao_Impl$2
extends EntityInsertionAdapter {
    public final /* synthetic */ G_TemplateDataDao_Impl this$0;

    public G_TemplateDataDao_Impl$2(G_TemplateDataDao_Impl g_TemplateDataDao_Impl, RoomDatabase roomDatabase) {
        this.this$0 = g_TemplateDataDao_Impl;
        super(roomDatabase);
    }

    public void bind(SupportSQLiteStatement supportSQLiteStatement, TemplateData object) {
        long l10 = ((TemplateData)object).getId();
        int n10 = 1;
        supportSQLiteStatement.bindLong(n10, l10);
        Object object2 = ((TemplateData)object).getTextZh();
        int n11 = 2;
        if (object2 == null) {
            supportSQLiteStatement.bindNull(n11);
        } else {
            object2 = ((TemplateData)object).getTextZh();
            supportSQLiteStatement.bindString(n11, (String)object2);
        }
        object2 = ((TemplateData)object).getTextZhTw();
        n11 = 3;
        if (object2 == null) {
            supportSQLiteStatement.bindNull(n11);
        } else {
            object2 = ((TemplateData)object).getTextZhTw();
            supportSQLiteStatement.bindString(n11, (String)object2);
        }
        object2 = ((TemplateData)object).getTextEn();
        n11 = 4;
        if (object2 == null) {
            supportSQLiteStatement.bindNull(n11);
        } else {
            object2 = ((TemplateData)object).getTextEn();
            supportSQLiteStatement.bindString(n11, (String)object2);
        }
        object2 = ((TemplateData)object).getCoverUrl();
        n11 = 5;
        if (object2 == null) {
            supportSQLiteStatement.bindNull(n11);
        } else {
            object2 = ((TemplateData)object).getCoverUrl();
            supportSQLiteStatement.bindString(n11, (String)object2);
        }
        object2 = ((TemplateData)object).getVideoUrl();
        n11 = 6;
        if (object2 == null) {
            supportSQLiteStatement.bindNull(n11);
        } else {
            object2 = ((TemplateData)object).getVideoUrl();
            supportSQLiteStatement.bindString(n11, (String)object2);
        }
        double d10 = ((TemplateData)object).getVideoTime();
        supportSQLiteStatement.bindDouble(7, d10);
        int n12 = 8;
        long l11 = ((TemplateData)object).getVideoCount();
        supportSQLiteStatement.bindLong(n12, l11);
        object2 = ((TemplateData)object).getVideoRatio();
        n11 = 9;
        if (object2 == null) {
            supportSQLiteStatement.bindNull(n11);
        } else {
            object2 = ((TemplateData)object).getVideoRatio();
            supportSQLiteStatement.bindString(n11, (String)object2);
        }
        l11 = ((TemplateData)object).getResSize();
        supportSQLiteStatement.bindLong(10, l11);
        long l12 = (long)((TemplateData)object).isPrimeUsable();
        supportSQLiteStatement.bindLong(11, l12);
        l11 = ((TemplateData)object).getTempType();
        supportSQLiteStatement.bindLong(12, l11);
        n12 = (int)(((TemplateData)object).isDownloadFinished() ? 1 : 0);
        l12 = n12;
        supportSQLiteStatement.bindLong(13, l12);
        object2 = ((TemplateData)object).getDownloadTimestamp();
        n11 = 14;
        if (object2 == null) {
            supportSQLiteStatement.bindNull(n11);
        } else {
            object2 = ((TemplateData)object).getDownloadTimestamp();
            l12 = (Long)object2;
            supportSQLiteStatement.bindLong(n11, l12);
        }
        object2 = ((TemplateData)object).getEditorTemplate();
        n11 = 15;
        if (object2 == null) {
            supportSQLiteStatement.bindNull(n11);
        } else {
            object2 = ((TemplateData)object).getEditorTemplate();
            supportSQLiteStatement.bindString(n11, (String)object2);
        }
        object2 = ((TemplateData)object).getTrackEditorConfigData();
        n11 = 16;
        if (object2 == null) {
            supportSQLiteStatement.bindNull(n11);
        } else {
            object2 = ((TemplateData)object).getTrackEditorConfigData();
            supportSQLiteStatement.bindString(n11, (String)object2);
        }
        l11 = ((TemplateData)object).getTemplateUseType();
        supportSQLiteStatement.bindLong(17, l11);
        l11 = ((TemplateData)object).getTemplateProtocolType();
        supportSQLiteStatement.bindLong(18, l11);
        n12 = (int)(((TemplateData)object).isFirstLoaded() ? 1 : 0);
        l12 = n12;
        supportSQLiteStatement.bindLong(19, l12);
        object2 = ((TemplateData)object).getTemplateDescription();
        n11 = 22;
        n10 = 21;
        int n13 = 20;
        if (object2 != null) {
            String string2 = ((TemplateDescription)object2).getTextZh();
            if (string2 == null) {
                supportSQLiteStatement.bindNull(n13);
            } else {
                string2 = ((TemplateDescription)object2).getTextZh();
                supportSQLiteStatement.bindString(n13, string2);
            }
            String string3 = ((TemplateDescription)object2).getTextEn();
            if (string3 == null) {
                supportSQLiteStatement.bindNull(n10);
            } else {
                string3 = ((TemplateDescription)object2).getTextEn();
                supportSQLiteStatement.bindString(n10, string3);
            }
            String string4 = ((TemplateDescription)object2).getTextZhTw();
            if (string4 == null) {
                supportSQLiteStatement.bindNull(n11);
            } else {
                object2 = ((TemplateDescription)object2).getTextZhTw();
                supportSQLiteStatement.bindString(n11, (String)object2);
            }
        } else {
            supportSQLiteStatement.bindNull(n13);
            supportSQLiteStatement.bindNull(n10);
            supportSQLiteStatement.bindNull(n11);
        }
        object = ((TemplateData)object).getScriptDataExt();
        n12 = 25;
        n11 = 24;
        n10 = 23;
        if (object != null) {
            n13 = ((ScriptDataExt)object).getStatus();
            long l13 = n13;
            supportSQLiteStatement.bindLong(n10, l13);
            n10 = ((ScriptDataExt)object).getProtocol();
            l12 = n10;
            supportSQLiteStatement.bindLong(n11, l12);
            int n14 = ((ScriptDataExt)object).getVersion();
            l11 = n14;
            supportSQLiteStatement.bindLong(n12, l11);
        } else {
            supportSQLiteStatement.bindNull(n10);
            supportSQLiteStatement.bindNull(n11);
            supportSQLiteStatement.bindNull(n12);
        }
    }

    public String createQuery() {
        return "INSERT OR IGNORE INTO `TemplateData` (`id`,`title_zh`,`title_tw`,`title_en`,`cover_url`,`video_url`,`video_time`,`video_count`,`video_ratio`,`res_size`,`is_prime_usable`,`temp_type`,`download_finished`,`download_timestamp`,`editor_template`,`track_editor_config_data`,`template_use_type`,`template_proto_type`,`first_loaded`,`template_description_zh`,`template_description_en`,`template_description_zh_tw`,`script_ext_status`,`script_ext_protocol`,`script_ext_version`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    }
}

