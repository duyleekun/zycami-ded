/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.editortemplate.data.database.dao.template;

import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateStickerDao_Impl;
import com.zhiyun.editortemplate.data.database.model.template.config.TemplateSticker;

public class G_TemplateStickerDao_Impl$4
extends EntityDeletionOrUpdateAdapter {
    public final /* synthetic */ G_TemplateStickerDao_Impl this$0;

    public G_TemplateStickerDao_Impl$4(G_TemplateStickerDao_Impl g_TemplateStickerDao_Impl, RoomDatabase roomDatabase) {
        this.this$0 = g_TemplateStickerDao_Impl;
        super(roomDatabase);
    }

    public void bind(SupportSQLiteStatement supportSQLiteStatement, TemplateSticker templateSticker) {
        long l10 = templateSticker.getId();
        supportSQLiteStatement.bindLong(1, l10);
        l10 = templateSticker.getTempId();
        supportSQLiteStatement.bindLong(2, l10);
        l10 = templateSticker.getStartTime();
        supportSQLiteStatement.bindLong(3, l10);
        l10 = templateSticker.getEndTime();
        supportSQLiteStatement.bindLong(4, l10);
        float f10 = templateSticker.getAngle();
        double d10 = f10;
        int n10 = 5;
        supportSQLiteStatement.bindDouble(n10, d10);
        String string2 = templateSticker.getCenter();
        int n11 = 6;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n11);
        } else {
            string2 = templateSticker.getCenter();
            supportSQLiteStatement.bindString(n11, string2);
        }
        string2 = templateSticker.getType();
        n11 = 7;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n11);
        } else {
            string2 = templateSticker.getType();
            supportSQLiteStatement.bindString(n11, string2);
        }
        long l11 = templateSticker.getStickerTypeId();
        supportSQLiteStatement.bindLong(8, l11);
        double d11 = templateSticker.getScale();
        supportSQLiteStatement.bindDouble(9, d11);
        int n12 = 10;
        f10 = 1.4E-44f;
        d11 = templateSticker.getTextFontSize();
        supportSQLiteStatement.bindDouble(n12, d11);
        string2 = templateSticker.getTextColor();
        n11 = 11;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n11);
        } else {
            string2 = templateSticker.getTextColor();
            supportSQLiteStatement.bindString(n11, string2);
        }
        string2 = templateSticker.getTextContent();
        n11 = 12;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n11);
        } else {
            string2 = templateSticker.getTextContent();
            supportSQLiteStatement.bindString(n11, string2);
        }
        string2 = templateSticker.getTextCaptionName();
        n11 = 13;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n11);
        } else {
            string2 = templateSticker.getTextCaptionName();
            supportSQLiteStatement.bindString(n11, string2);
        }
        n12 = (int)(templateSticker.isTextCaptionLocalSource() ? 1 : 0);
        long l12 = n12;
        supportSQLiteStatement.bindLong(14, l12);
        string2 = templateSticker.getTextFontName();
        n11 = 15;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n11);
        } else {
            string2 = templateSticker.getTextFontName();
            supportSQLiteStatement.bindString(n11, string2);
        }
        string2 = templateSticker.getImageName();
        n11 = 16;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n11);
        } else {
            string2 = templateSticker.getImageName();
            supportSQLiteStatement.bindString(n11, string2);
        }
        string2 = templateSticker.getGifName();
        n11 = 17;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n11);
        } else {
            string2 = templateSticker.getGifName();
            supportSQLiteStatement.bindString(n11, string2);
        }
        string2 = templateSticker.getThumbUrl();
        n11 = 18;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n11);
        } else {
            string2 = templateSticker.getThumbUrl();
            supportSQLiteStatement.bindString(n11, string2);
        }
        n12 = (int)(templateSticker.isLocalSource() ? 1 : 0);
        l12 = n12;
        supportSQLiteStatement.bindLong(19, l12);
        string2 = templateSticker.getCustomerUUID();
        n11 = 20;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n11);
        } else {
            string2 = templateSticker.getCustomerUUID();
            supportSQLiteStatement.bindString(n11, string2);
        }
        l11 = templateSticker.getId();
        supportSQLiteStatement.bindLong(21, l11);
    }

    public String createQuery() {
        return "UPDATE OR REPLACE `TemplateSticker` SET `id` = ?,`temp_id` = ?,`start_time` = ?,`end_time` = ?,`angle` = ?,`center` = ?,`type` = ?,`sticker_type_id` = ?,`scale` = ?,`text_font_size` = ?,`text_color` = ?,`text_content` = ?,`text_caption_name` = ?,`caption_local_source` = ?,`text_font_name` = ?,`image_name` = ?,`gif_name` = ?,`thumb_url` = ?,`local_source` = ?,`customer_uuid` = ? WHERE `id` = ?";
    }
}

