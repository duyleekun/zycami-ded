/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.editortemplate.data.database.dao.template;

import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateFileRelationDao_Impl;
import com.zhiyun.editortemplate.data.database.model.template.templatelist.TemplateFileRelation;

public class G_TemplateFileRelationDao_Impl$1
extends EntityInsertionAdapter {
    public final /* synthetic */ G_TemplateFileRelationDao_Impl this$0;

    public G_TemplateFileRelationDao_Impl$1(G_TemplateFileRelationDao_Impl g_TemplateFileRelationDao_Impl, RoomDatabase roomDatabase) {
        this.this$0 = g_TemplateFileRelationDao_Impl;
        super(roomDatabase);
    }

    public void bind(SupportSQLiteStatement supportSQLiteStatement, TemplateFileRelation object) {
        long l10 = ((TemplateFileRelation)object).getTempId();
        int n10 = 1;
        supportSQLiteStatement.bindLong(n10, l10);
        String string2 = ((TemplateFileRelation)object).getFileHash();
        int n11 = 2;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n11);
        } else {
            object = ((TemplateFileRelation)object).getFileHash();
            supportSQLiteStatement.bindString(n11, (String)object);
        }
    }

    public String createQuery() {
        return "INSERT OR REPLACE INTO `TemplateFileRelation` (`temp_id`,`file_hash`) VALUES (?,?)";
    }
}

