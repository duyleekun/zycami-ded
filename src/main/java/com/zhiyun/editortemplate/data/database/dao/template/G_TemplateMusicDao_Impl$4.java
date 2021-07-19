/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.editortemplate.data.database.dao.template;

import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateMusicDao_Impl;
import com.zhiyun.editortemplate.data.database.model.template.config.TemplateAudioTransition;
import com.zhiyun.editortemplate.data.database.model.template.config.TemplateMusic;

public class G_TemplateMusicDao_Impl$4
extends EntityDeletionOrUpdateAdapter {
    public final /* synthetic */ G_TemplateMusicDao_Impl this$0;

    public G_TemplateMusicDao_Impl$4(G_TemplateMusicDao_Impl g_TemplateMusicDao_Impl, RoomDatabase roomDatabase) {
        this.this$0 = g_TemplateMusicDao_Impl;
        super(roomDatabase);
    }

    public void bind(SupportSQLiteStatement supportSQLiteStatement, TemplateMusic templateMusic) {
        double d10;
        double d11;
        long l10;
        long l11;
        long l12 = templateMusic.getId();
        supportSQLiteStatement.bindLong(1, l12);
        l12 = templateMusic.getTempId();
        int n10 = 2;
        supportSQLiteStatement.bindLong(n10, l12);
        Object object = templateMusic.getName();
        int n11 = 3;
        if (object == null) {
            supportSQLiteStatement.bindNull(n11);
        } else {
            object = templateMusic.getName();
            supportSQLiteStatement.bindString(n11, (String)object);
        }
        object = templateMusic.getTitle();
        n11 = 4;
        if (object == null) {
            supportSQLiteStatement.bindNull(n11);
        } else {
            object = templateMusic.getTitle();
            supportSQLiteStatement.bindString(n11, (String)object);
        }
        long l13 = templateMusic.getAttachTime();
        supportSQLiteStatement.bindLong(5, l13);
        l13 = templateMusic.getStartTime();
        supportSQLiteStatement.bindLong(6, l13);
        l13 = templateMusic.getEndTime();
        supportSQLiteStatement.bindLong(7, l13);
        l13 = templateMusic.getTimebase();
        supportSQLiteStatement.bindLong(8, l13);
        float f10 = 1.3E-44f;
        double d12 = templateMusic.getVolume();
        supportSQLiteStatement.bindDouble(9, d12);
        long l14 = (long)templateMusic.isMute();
        supportSQLiteStatement.bindLong(10, l14);
        int n12 = templateMusic.isLocalSource();
        l14 = n12;
        supportSQLiteStatement.bindLong(11, l14);
        object = templateMusic.getCustomerUUID();
        n11 = 12;
        if (object == null) {
            supportSQLiteStatement.bindNull(n11);
        } else {
            object = templateMusic.getCustomerUUID();
            supportSQLiteStatement.bindString(n11, (String)object);
        }
        object = templateMusic.getFadeIn();
        n11 = 16;
        n10 = 15;
        int n13 = 14;
        float f11 = 2.0E-44f;
        int n14 = 13;
        if (object != null) {
            l11 = ((TemplateAudioTransition)object).getStartTime();
            supportSQLiteStatement.bindLong(n14, l11);
            l10 = ((TemplateAudioTransition)object).getEndTime();
            supportSQLiteStatement.bindLong(n13, l10);
            f11 = ((TemplateAudioTransition)object).getStartVolume();
            d11 = f11;
            supportSQLiteStatement.bindDouble(n10, d11);
            f10 = ((TemplateAudioTransition)object).getEndVolume();
            d10 = f10;
            supportSQLiteStatement.bindDouble(n11, d10);
        } else {
            supportSQLiteStatement.bindNull(n14);
            supportSQLiteStatement.bindNull(n13);
            supportSQLiteStatement.bindNull(n10);
            supportSQLiteStatement.bindNull(n11);
        }
        object = templateMusic.getFadeout();
        n11 = 20;
        n10 = 19;
        n13 = 18;
        f11 = 2.5E-44f;
        n14 = 17;
        if (object != null) {
            l11 = ((TemplateAudioTransition)object).getStartTime();
            supportSQLiteStatement.bindLong(n14, l11);
            l10 = ((TemplateAudioTransition)object).getEndTime();
            supportSQLiteStatement.bindLong(n13, l10);
            f11 = ((TemplateAudioTransition)object).getStartVolume();
            d11 = f11;
            supportSQLiteStatement.bindDouble(n10, d11);
            f10 = ((TemplateAudioTransition)object).getEndVolume();
            d10 = f10;
            supportSQLiteStatement.bindDouble(n11, d10);
        } else {
            supportSQLiteStatement.bindNull(n14);
            supportSQLiteStatement.bindNull(n13);
            supportSQLiteStatement.bindNull(n10);
            supportSQLiteStatement.bindNull(n11);
        }
        l13 = templateMusic.getId();
        supportSQLiteStatement.bindLong(21, l13);
    }

    public String createQuery() {
        return "UPDATE OR REPLACE `TemplateMusic` SET `id` = ?,`temp_id` = ?,`name` = ?,`title` = ?,`attach_time` = ?,`start_time` = ?,`end_time` = ?,`timebase` = ?,`volume` = ?,`mute` = ?,`local_source` = ?,`customer_uuid` = ?,`fade_in_start_time` = ?,`fade_in_end_time` = ?,`fade_in_start_volume` = ?,`fade_in_end_volume` = ?,`fade_out_start_time` = ?,`fade_out_end_time` = ?,`fade_out_start_volume` = ?,`fade_out_end_volume` = ? WHERE `id` = ?";
    }
}

