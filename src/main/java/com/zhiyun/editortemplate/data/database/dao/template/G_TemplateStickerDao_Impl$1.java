/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.editortemplate.data.database.dao.template;

import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateStickerDao_Impl;
import com.zhiyun.editortemplate.data.database.model.template.config.TemplateBaseData;
import com.zhiyun.editortemplate.data.database.model.template.config.TemplateSticker;

public class G_TemplateStickerDao_Impl$1
extends EntityInsertionAdapter {
    public final /* synthetic */ G_TemplateStickerDao_Impl this$0;

    public G_TemplateStickerDao_Impl$1(G_TemplateStickerDao_Impl g_TemplateStickerDao_Impl, RoomDatabase roomDatabase) {
        this.this$0 = g_TemplateStickerDao_Impl;
        super(roomDatabase);
    }

    public void bind(SupportSQLiteStatement supportSQLiteStatement, TemplateSticker object) {
        long l10 = ((TemplateSticker)object).getId();
        supportSQLiteStatement.bindLong(1, l10);
        l10 = ((TemplateSticker)object).getTempId();
        supportSQLiteStatement.bindLong(2, l10);
        l10 = ((TemplateSticker)object).getStartTime();
        supportSQLiteStatement.bindLong(3, l10);
        l10 = ((TemplateSticker)object).getEndTime();
        supportSQLiteStatement.bindLong(4, l10);
        float f10 = ((TemplateSticker)object).getAngle();
        double d10 = f10;
        int n10 = 5;
        supportSQLiteStatement.bindDouble(n10, d10);
        String string2 = ((TemplateSticker)object).getCenter();
        int n11 = 6;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n11);
        } else {
            string2 = ((TemplateSticker)object).getCenter();
            supportSQLiteStatement.bindString(n11, string2);
        }
        string2 = ((TemplateSticker)object).getType();
        n11 = 7;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n11);
        } else {
            string2 = ((TemplateSticker)object).getType();
            supportSQLiteStatement.bindString(n11, string2);
        }
        long l11 = ((TemplateSticker)object).getStickerTypeId();
        supportSQLiteStatement.bindLong(8, l11);
        double d11 = ((TemplateSticker)object).getScale();
        supportSQLiteStatement.bindDouble(9, d11);
        int n12 = 10;
        f10 = 1.4E-44f;
        d11 = ((TemplateSticker)object).getTextFontSize();
        supportSQLiteStatement.bindDouble(n12, d11);
        string2 = ((TemplateSticker)object).getTextColor();
        n11 = 11;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n11);
        } else {
            string2 = ((TemplateSticker)object).getTextColor();
            supportSQLiteStatement.bindString(n11, string2);
        }
        string2 = ((TemplateSticker)object).getTextContent();
        n11 = 12;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n11);
        } else {
            string2 = ((TemplateSticker)object).getTextContent();
            supportSQLiteStatement.bindString(n11, string2);
        }
        string2 = ((TemplateSticker)object).getTextCaptionName();
        n11 = 13;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n11);
        } else {
            string2 = ((TemplateSticker)object).getTextCaptionName();
            supportSQLiteStatement.bindString(n11, string2);
        }
        n12 = (int)(((TemplateSticker)object).isTextCaptionLocalSource() ? 1 : 0);
        long l12 = n12;
        supportSQLiteStatement.bindLong(14, l12);
        string2 = ((TemplateSticker)object).getTextFontName();
        n11 = 15;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n11);
        } else {
            string2 = ((TemplateSticker)object).getTextFontName();
            supportSQLiteStatement.bindString(n11, string2);
        }
        string2 = ((TemplateSticker)object).getImageName();
        n11 = 16;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n11);
        } else {
            string2 = ((TemplateSticker)object).getImageName();
            supportSQLiteStatement.bindString(n11, string2);
        }
        string2 = ((TemplateSticker)object).getGifName();
        n11 = 17;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n11);
        } else {
            string2 = ((TemplateSticker)object).getGifName();
            supportSQLiteStatement.bindString(n11, string2);
        }
        string2 = ((TemplateSticker)object).getThumbUrl();
        n11 = 18;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n11);
        } else {
            string2 = ((TemplateSticker)object).getThumbUrl();
            supportSQLiteStatement.bindString(n11, string2);
        }
        n12 = (int)(((TemplateSticker)object).isLocalSource() ? 1 : 0);
        l12 = n12;
        supportSQLiteStatement.bindLong(19, l12);
        string2 = ((TemplateBaseData)object).getCustomerUUID();
        n11 = 20;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n11);
        } else {
            object = ((TemplateBaseData)object).getCustomerUUID();
            supportSQLiteStatement.bindString(n11, (String)object);
        }
    }

    public String createQuery() {
        return "INSERT OR REPLACE INTO `TemplateSticker` (`id`,`temp_id`,`start_time`,`end_time`,`angle`,`center`,`type`,`sticker_type_id`,`scale`,`text_font_size`,`text_color`,`text_content`,`text_caption_name`,`caption_local_source`,`text_font_name`,`image_name`,`gif_name`,`thumb_url`,`local_source`,`customer_uuid`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    }
}

