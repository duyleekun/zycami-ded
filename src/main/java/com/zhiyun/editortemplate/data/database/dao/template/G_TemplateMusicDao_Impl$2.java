/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.editortemplate.data.database.dao.template;

import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateMusicDao_Impl;
import com.zhiyun.editortemplate.data.database.model.template.config.TemplateAudioData;
import com.zhiyun.editortemplate.data.database.model.template.config.TemplateAudioTransition;
import com.zhiyun.editortemplate.data.database.model.template.config.TemplateBaseData;
import com.zhiyun.editortemplate.data.database.model.template.config.TemplateMusic;

public class G_TemplateMusicDao_Impl$2
extends EntityInsertionAdapter {
    public final /* synthetic */ G_TemplateMusicDao_Impl this$0;

    public G_TemplateMusicDao_Impl$2(G_TemplateMusicDao_Impl g_TemplateMusicDao_Impl, RoomDatabase roomDatabase) {
        this.this$0 = g_TemplateMusicDao_Impl;
        super(roomDatabase);
    }

    public void bind(SupportSQLiteStatement supportSQLiteStatement, TemplateMusic object) {
        double d10;
        long l10;
        long l11 = ((TemplateAudioData)object).getId();
        supportSQLiteStatement.bindLong(1, l11);
        l11 = ((TemplateAudioData)object).getTempId();
        int n10 = 2;
        float f10 = 2.8E-45f;
        supportSQLiteStatement.bindLong(n10, l11);
        Object object2 = ((TemplateAudioData)object).getName();
        int n11 = 3;
        if (object2 == null) {
            supportSQLiteStatement.bindNull(n11);
        } else {
            object2 = ((TemplateAudioData)object).getName();
            supportSQLiteStatement.bindString(n11, (String)object2);
        }
        object2 = ((TemplateAudioData)object).getTitle();
        n11 = 4;
        if (object2 == null) {
            supportSQLiteStatement.bindNull(n11);
        } else {
            object2 = ((TemplateAudioData)object).getTitle();
            supportSQLiteStatement.bindString(n11, (String)object2);
        }
        long l12 = ((TemplateAudioData)object).getAttachTime();
        supportSQLiteStatement.bindLong(5, l12);
        l12 = ((TemplateAudioData)object).getStartTime();
        supportSQLiteStatement.bindLong(6, l12);
        l12 = ((TemplateAudioData)object).getEndTime();
        supportSQLiteStatement.bindLong(7, l12);
        l12 = ((TemplateAudioData)object).getTimebase();
        supportSQLiteStatement.bindLong(8, l12);
        float f11 = 1.3E-44f;
        double d11 = ((TemplateAudioData)object).getVolume();
        supportSQLiteStatement.bindDouble(9, d11);
        long l13 = (long)((TemplateAudioData)object).isMute();
        supportSQLiteStatement.bindLong(10, l13);
        int n12 = ((TemplateAudioData)object).isLocalSource();
        l13 = n12;
        supportSQLiteStatement.bindLong(11, l13);
        object2 = ((TemplateBaseData)object).getCustomerUUID();
        n11 = 12;
        if (object2 == null) {
            supportSQLiteStatement.bindNull(n11);
        } else {
            object2 = ((TemplateBaseData)object).getCustomerUUID();
            supportSQLiteStatement.bindString(n11, (String)object2);
        }
        object2 = ((TemplateAudioData)object).getFadeIn();
        n11 = 16;
        n10 = 15;
        f10 = 2.1E-44f;
        int n13 = 14;
        float f12 = 2.0E-44f;
        int n14 = 13;
        if (object2 != null) {
            long l14 = ((TemplateAudioTransition)object2).getStartTime();
            supportSQLiteStatement.bindLong(n14, l14);
            l10 = ((TemplateAudioTransition)object2).getEndTime();
            supportSQLiteStatement.bindLong(n13, l10);
            f12 = ((TemplateAudioTransition)object2).getStartVolume();
            double d12 = f12;
            supportSQLiteStatement.bindDouble(n10, d12);
            f11 = ((TemplateAudioTransition)object2).getEndVolume();
            d10 = f11;
            supportSQLiteStatement.bindDouble(n11, d10);
        } else {
            supportSQLiteStatement.bindNull(n14);
            supportSQLiteStatement.bindNull(n13);
            supportSQLiteStatement.bindNull(n10);
            supportSQLiteStatement.bindNull(n11);
        }
        object = ((TemplateAudioData)object).getFadeout();
        int n15 = 20;
        f11 = 2.8E-44f;
        n11 = 19;
        n10 = 18;
        f10 = 2.5E-44f;
        n13 = 17;
        f12 = 2.4E-44f;
        if (object != null) {
            l10 = ((TemplateAudioTransition)object).getStartTime();
            supportSQLiteStatement.bindLong(n13, l10);
            long l15 = ((TemplateAudioTransition)object).getEndTime();
            supportSQLiteStatement.bindLong(n10, l15);
            f10 = ((TemplateAudioTransition)object).getStartVolume();
            d10 = f10;
            supportSQLiteStatement.bindDouble(n11, d10);
            float f13 = ((TemplateAudioTransition)object).getEndVolume();
            d11 = f13;
            supportSQLiteStatement.bindDouble(n15, d11);
        } else {
            supportSQLiteStatement.bindNull(n13);
            supportSQLiteStatement.bindNull(n10);
            supportSQLiteStatement.bindNull(n11);
            supportSQLiteStatement.bindNull(n15);
        }
    }

    public String createQuery() {
        return "INSERT OR IGNORE INTO `TemplateMusic` (`id`,`temp_id`,`name`,`title`,`attach_time`,`start_time`,`end_time`,`timebase`,`volume`,`mute`,`local_source`,`customer_uuid`,`fade_in_start_time`,`fade_in_end_time`,`fade_in_start_volume`,`fade_in_end_volume`,`fade_out_start_time`,`fade_out_end_time`,`fade_out_start_volume`,`fade_out_end_volume`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    }
}

