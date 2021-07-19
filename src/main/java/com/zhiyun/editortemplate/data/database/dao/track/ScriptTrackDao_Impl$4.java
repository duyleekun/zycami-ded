/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.editortemplate.data.database.dao.track;

import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.zhiyun.editortemplate.data.database.dao.track.ScriptTrackDao_Impl;
import com.zhiyun.editortemplate.data.database.model.track.ScriptTrack;

public class ScriptTrackDao_Impl$4
extends EntityDeletionOrUpdateAdapter {
    public final /* synthetic */ ScriptTrackDao_Impl this$0;

    public ScriptTrackDao_Impl$4(ScriptTrackDao_Impl scriptTrackDao_Impl, RoomDatabase roomDatabase) {
        this.this$0 = scriptTrackDao_Impl;
        super(roomDatabase);
    }

    public void bind(SupportSQLiteStatement supportSQLiteStatement, ScriptTrack scriptTrack) {
        long l10 = scriptTrack.getId();
        supportSQLiteStatement.bindLong(1, l10);
        l10 = scriptTrack.getScriptTrackId();
        supportSQLiteStatement.bindLong(2, l10);
        l10 = scriptTrack.getTrackId();
        int n10 = 3;
        supportSQLiteStatement.bindLong(n10, l10);
        String string2 = scriptTrack.getDurationType();
        int n11 = 4;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n11);
        } else {
            string2 = scriptTrack.getDurationType();
            supportSQLiteStatement.bindString(n11, string2);
        }
        long l11 = scriptTrack.getId();
        supportSQLiteStatement.bindLong(5, l11);
    }

    public String createQuery() {
        return "UPDATE OR REPLACE `script_track` SET `id` = ?,`script_track_id` = ?,`track_id` = ?,`duration_type` = ? WHERE `id` = ?";
    }
}

