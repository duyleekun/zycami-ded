/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data.database.dao.transition;

import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.zhiyun.cama.data.database.dao.transition.TransitionFileDao_Impl;
import com.zhiyun.cama.data.database.model.transition.TransitionFile;
import com.zhiyun.editortemplate.data.database.EditorResourceTypeConverters;
import com.zhiyun.editortemplate.data.database.model.template.templatelist.FileData;
import com.zhiyun.editortemplate.data.database.model.template.templatelist.FileExt;

public class TransitionFileDao_Impl$4
extends EntityDeletionOrUpdateAdapter {
    public final /* synthetic */ TransitionFileDao_Impl this$0;

    public TransitionFileDao_Impl$4(TransitionFileDao_Impl transitionFileDao_Impl, RoomDatabase roomDatabase) {
        this.this$0 = transitionFileDao_Impl;
        super(roomDatabase);
    }

    public void bind(SupportSQLiteStatement supportSQLiteStatement, TransitionFile object) {
        Object object2 = ((FileData)object).getHash();
        int n10 = 1;
        if (object2 == null) {
            supportSQLiteStatement.bindNull(n10);
        } else {
            object2 = ((FileData)object).getHash();
            supportSQLiteStatement.bindString(n10, (String)object2);
        }
        object2 = ((FileData)object).getName();
        n10 = 2;
        if (object2 == null) {
            supportSQLiteStatement.bindNull(n10);
        } else {
            object2 = ((FileData)object).getName();
            supportSQLiteStatement.bindString(n10, (String)object2);
        }
        object2 = EditorResourceTypeConverters.typeToString(((FileData)object).getCategory());
        n10 = 3;
        if (object2 == null) {
            supportSQLiteStatement.bindNull(n10);
        } else {
            supportSQLiteStatement.bindString(n10, (String)object2);
        }
        object2 = ((FileData)object).getType();
        n10 = 4;
        if (object2 == null) {
            supportSQLiteStatement.bindNull(n10);
        } else {
            object2 = ((FileData)object).getType();
            supportSQLiteStatement.bindString(n10, (String)object2);
        }
        int n11 = 5;
        long l10 = ((FileData)object).getSize();
        supportSQLiteStatement.bindLong(n11, l10);
        object2 = ((FileData)object).getUrl();
        n10 = 6;
        if (object2 == null) {
            supportSQLiteStatement.bindNull(n10);
        } else {
            object2 = ((FileData)object).getUrl();
            supportSQLiteStatement.bindString(n10, (String)object2);
        }
        object2 = ((FileData)object).getPath();
        n10 = 7;
        if (object2 == null) {
            supportSQLiteStatement.bindNull(n10);
        } else {
            object2 = ((FileData)object).getPath();
            supportSQLiteStatement.bindString(n10, (String)object2);
        }
        n11 = 8;
        l10 = ((FileData)object).getDownloadTimestamp();
        supportSQLiteStatement.bindLong(n11, l10);
        object2 = ((FileData)object).getExt();
        n10 = 11;
        int n12 = 10;
        int n13 = 9;
        if (object2 != null) {
            String string2 = ((FileExt)object2).getLicenseUrl();
            if (string2 == null) {
                supportSQLiteStatement.bindNull(n13);
            } else {
                string2 = ((FileExt)object2).getLicenseUrl();
                supportSQLiteStatement.bindString(n13, string2);
            }
            String string3 = ((FileExt)object2).getLicenseName();
            if (string3 == null) {
                supportSQLiteStatement.bindNull(n12);
            } else {
                string3 = ((FileExt)object2).getLicenseName();
                supportSQLiteStatement.bindString(n12, string3);
            }
            String string4 = ((FileExt)object2).getLicensePath();
            if (string4 == null) {
                supportSQLiteStatement.bindNull(n10);
            } else {
                object2 = ((FileExt)object2).getLicensePath();
                supportSQLiteStatement.bindString(n10, (String)object2);
            }
        } else {
            supportSQLiteStatement.bindNull(n13);
            supportSQLiteStatement.bindNull(n12);
            supportSQLiteStatement.bindNull(n10);
        }
        object2 = ((FileData)object).getHash();
        n10 = 12;
        if (object2 == null) {
            supportSQLiteStatement.bindNull(n10);
        } else {
            object = ((FileData)object).getHash();
            supportSQLiteStatement.bindString(n10, (String)object);
        }
    }

    public String createQuery() {
        return "UPDATE OR REPLACE `transition_file` SET `hash` = ?,`name` = ?,`category` = ?,`mime` = ?,`size` = ?,`url` = ?,`path` = ?,`download_timestamp` = ?,`ext_lic_url` = ?,`ext_lic_name` = ?,`ext_lic_path` = ? WHERE `hash` = ?";
    }
}

