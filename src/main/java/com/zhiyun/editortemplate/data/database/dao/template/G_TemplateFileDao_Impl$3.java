/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.editortemplate.data.database.dao.template;

import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateFileDao_Impl;
import com.zhiyun.editortemplate.data.database.model.template.templatelist.FileData;

public class G_TemplateFileDao_Impl$3
extends EntityDeletionOrUpdateAdapter {
    public final /* synthetic */ G_TemplateFileDao_Impl this$0;

    public G_TemplateFileDao_Impl$3(G_TemplateFileDao_Impl g_TemplateFileDao_Impl, RoomDatabase roomDatabase) {
        this.this$0 = g_TemplateFileDao_Impl;
        super(roomDatabase);
    }

    public void bind(SupportSQLiteStatement supportSQLiteStatement, FileData object) {
        String string2 = ((FileData)object).getHash();
        int n10 = 1;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n10);
        } else {
            object = ((FileData)object).getHash();
            supportSQLiteStatement.bindString(n10, (String)object);
        }
    }

    public String createQuery() {
        return "DELETE FROM `FileData` WHERE `hash` = ?";
    }
}

