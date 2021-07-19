/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.editortemplate.data.database.dao.track;

import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.zhiyun.editortemplate.data.database.dao.track.G_ScriptDao_Impl;
import com.zhiyun.editortemplate.data.database.model.track.Script;

public class G_ScriptDao_Impl$2
extends EntityInsertionAdapter {
    public final /* synthetic */ G_ScriptDao_Impl this$0;

    public G_ScriptDao_Impl$2(G_ScriptDao_Impl g_ScriptDao_Impl, RoomDatabase roomDatabase) {
        this.this$0 = g_ScriptDao_Impl;
        super(roomDatabase);
    }

    public void bind(SupportSQLiteStatement supportSQLiteStatement, Script script) {
        long l10 = script.getId();
        supportSQLiteStatement.bindLong(1, l10);
        l10 = script.getScriptId();
        supportSQLiteStatement.bindLong(2, l10);
        l10 = script.getReferenceId();
        supportSQLiteStatement.bindLong(3, l10);
    }

    public String createQuery() {
        return "INSERT OR IGNORE INTO `script` (`id`,`script_id`,`reference_id`) VALUES (nullif(?, 0),?,?)";
    }
}

