/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.editortemplate.data.database.dao.template;

import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateTypeDao_Impl;
import com.zhiyun.editortemplate.data.database.model.template.templatelist.TemplateType;

public class G_TemplateTypeDao_Impl$2
extends EntityInsertionAdapter {
    public final /* synthetic */ G_TemplateTypeDao_Impl this$0;

    public G_TemplateTypeDao_Impl$2(G_TemplateTypeDao_Impl g_TemplateTypeDao_Impl, RoomDatabase roomDatabase) {
        this.this$0 = g_TemplateTypeDao_Impl;
        super(roomDatabase);
    }

    public void bind(SupportSQLiteStatement supportSQLiteStatement, TemplateType templateType) {
        long l10 = templateType.getId();
        int n10 = 1;
        supportSQLiteStatement.bindLong(n10, l10);
        String string2 = templateType.getTextZh();
        int n11 = 2;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n11);
        } else {
            string2 = templateType.getTextZh();
            supportSQLiteStatement.bindString(n11, string2);
        }
        string2 = templateType.getTextZhTw();
        n11 = 3;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n11);
        } else {
            string2 = templateType.getTextZhTw();
            supportSQLiteStatement.bindString(n11, string2);
        }
        string2 = templateType.getTextEn();
        n11 = 4;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n11);
        } else {
            string2 = templateType.getTextEn();
            supportSQLiteStatement.bindString(n11, string2);
        }
        long l11 = templateType.getResourceType();
        supportSQLiteStatement.bindLong(5, l11);
        l11 = templateType.getTemplateProtocolType();
        supportSQLiteStatement.bindLong(6, l11);
    }

    public String createQuery() {
        return "INSERT OR IGNORE INTO `TemplateType` (`id`,`label`,`label_tw`,`label_en`,`resource_type`,`template_proto_type`) VALUES (?,?,?,?,?,?)";
    }
}

