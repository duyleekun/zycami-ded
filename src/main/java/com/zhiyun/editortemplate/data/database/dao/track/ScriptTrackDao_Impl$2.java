/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.editortemplate.data.database.dao.track;

import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.zhiyun.editortemplate.data.database.dao.track.ScriptTrackDao_Impl;
import com.zhiyun.editortemplate.data.database.model.track.ScriptTrack;

public class ScriptTrackDao_Impl$2
extends EntityInsertionAdapter {
    public final /* synthetic */ ScriptTrackDao_Impl this$0;

    public ScriptTrackDao_Impl$2(ScriptTrackDao_Impl scriptTrackDao_Impl, RoomDatabase roomDatabase) {
        this.this$0 = scriptTrackDao_Impl;
        super(roomDatabase);
    }

    public void bind(SupportSQLiteStatement supportSQLiteStatement, ScriptTrack object) {
        long l10 = ((ScriptTrack)object).getId();
        supportSQLiteStatement.bindLong(1, l10);
        l10 = ((ScriptTrack)object).getScriptTrackId();
        supportSQLiteStatement.bindLong(2, l10);
        l10 = ((ScriptTrack)object).getTrackId();
        int n10 = 3;
        supportSQLiteStatement.bindLong(n10, l10);
        String string2 = ((ScriptTrack)object).getDurationType();
        int n11 = 4;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n11);
        } else {
            object = ((ScriptTrack)object).getDurationType();
            supportSQLiteStatement.bindString(n11, (String)object);
        }
    }

    public String createQuery() {
        return "INSERT OR IGNORE INTO `script_track` (`id`,`script_track_id`,`track_id`,`duration_type`) VALUES (nullif(?, 0),?,?,?)";
    }
}

