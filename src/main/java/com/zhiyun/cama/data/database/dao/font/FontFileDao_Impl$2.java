/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data.database.dao.font;

import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.zhiyun.cama.data.database.dao.font.FontFileDao_Impl;
import com.zhiyun.cama.data.database.model.font.FontFile;
import com.zhiyun.editortemplate.data.database.EditorResourceTypeConverters;
import com.zhiyun.editortemplate.data.database.model.template.templatelist.FileData;
import com.zhiyun.editortemplate.data.database.model.template.templatelist.FileExt;

public class FontFileDao_Impl$2
extends EntityInsertionAdapter {
    public final /* synthetic */ FontFileDao_Impl this$0;

    public FontFileDao_Impl$2(FontFileDao_Impl fontFileDao_Impl, RoomDatabase roomDatabase) {
        this.this$0 = fontFileDao_Impl;
        super(roomDatabase);
    }

    public void bind(SupportSQLiteStatement supportSQLiteStatement, FontFile object) {
        String string2 = ((FileData)object).getHash();
        int n10 = 1;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n10);
        } else {
            string2 = ((FileData)object).getHash();
            supportSQLiteStatement.bindString(n10, string2);
        }
        string2 = ((FileData)object).getName();
        n10 = 2;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n10);
        } else {
            string2 = ((FileData)object).getName();
            supportSQLiteStatement.bindString(n10, string2);
        }
        string2 = EditorResourceTypeConverters.typeToString(((FileData)object).getCategory());
        n10 = 3;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n10);
        } else {
            supportSQLiteStatement.bindString(n10, string2);
        }
        string2 = ((FileData)object).getType();
        n10 = 4;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n10);
        } else {
            string2 = ((FileData)object).getType();
            supportSQLiteStatement.bindString(n10, string2);
        }
        int n11 = 5;
        long l10 = ((FileData)object).getSize();
        supportSQLiteStatement.bindLong(n11, l10);
        string2 = ((FileData)object).getUrl();
        n10 = 6;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n10);
        } else {
            string2 = ((FileData)object).getUrl();
            supportSQLiteStatement.bindString(n10, string2);
        }
        string2 = ((FileData)object).getPath();
        n10 = 7;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n10);
        } else {
            string2 = ((FileData)object).getPath();
            supportSQLiteStatement.bindString(n10, string2);
        }
        l10 = ((FileData)object).getDownloadTimestamp();
        supportSQLiteStatement.bindLong(8, l10);
        object = ((FileData)object).getExt();
        n11 = 11;
        n10 = 10;
        int n12 = 9;
        if (object != null) {
            String string3 = ((FileExt)object).getLicenseUrl();
            if (string3 == null) {
                supportSQLiteStatement.bindNull(n12);
            } else {
                string3 = ((FileExt)object).getLicenseUrl();
                supportSQLiteStatement.bindString(n12, string3);
            }
            String string4 = ((FileExt)object).getLicenseName();
            if (string4 == null) {
                supportSQLiteStatement.bindNull(n10);
            } else {
                string4 = ((FileExt)object).getLicenseName();
                supportSQLiteStatement.bindString(n10, string4);
            }
            String string5 = ((FileExt)object).getLicensePath();
            if (string5 == null) {
                supportSQLiteStatement.bindNull(n11);
            } else {
                object = ((FileExt)object).getLicensePath();
                supportSQLiteStatement.bindString(n11, (String)object);
            }
        } else {
            supportSQLiteStatement.bindNull(n12);
            supportSQLiteStatement.bindNull(n10);
            supportSQLiteStatement.bindNull(n11);
        }
    }

    public String createQuery() {
        return "INSERT OR IGNORE INTO `font_file` (`hash`,`name`,`category`,`mime`,`size`,`url`,`path`,`download_timestamp`,`ext_lic_url`,`ext_lic_name`,`ext_lic_path`) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
    }
}

