/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.editortemplate.data.database.dao.template;

import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateFileRelationDao_Impl;
import com.zhiyun.editortemplate.data.database.model.template.templatelist.TemplateFileRelation;

public class G_TemplateFileRelationDao_Impl$4
extends EntityDeletionOrUpdateAdapter {
    public final /* synthetic */ G_TemplateFileRelationDao_Impl this$0;

    public G_TemplateFileRelationDao_Impl$4(G_TemplateFileRelationDao_Impl g_TemplateFileRelationDao_Impl, RoomDatabase roomDatabase) {
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
            string2 = ((TemplateFileRelation)object).getFileHash();
            supportSQLiteStatement.bindString(n11, string2);
        }
        int n12 = 3;
        long l11 = ((TemplateFileRelation)object).getTempId();
        supportSQLiteStatement.bindLong(n12, l11);
        string2 = ((TemplateFileRelation)object).getFileHash();
        n11 = 4;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n11);
        } else {
            object = ((TemplateFileRelation)object).getFileHash();
            supportSQLiteStatement.bindString(n11, (String)object);
        }
    }

    public String createQuery() {
        return "UPDATE OR REPLACE `TemplateFileRelation` SET `temp_id` = ?,`file_hash` = ? WHERE `temp_id` = ? AND `file_hash` = ?";
    }
}

