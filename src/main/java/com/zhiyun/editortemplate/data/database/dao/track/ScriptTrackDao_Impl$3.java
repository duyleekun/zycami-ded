/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.editortemplate.data.database.dao.track;

import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.zhiyun.editortemplate.data.database.dao.track.ScriptTrackDao_Impl;
import com.zhiyun.editortemplate.data.database.model.track.ScriptTrack;

public class ScriptTrackDao_Impl$3
extends EntityDeletionOrUpdateAdapter {
    public final /* synthetic */ ScriptTrackDao_Impl this$0;

    public ScriptTrackDao_Impl$3(ScriptTrackDao_Impl scriptTrackDao_Impl, RoomDatabase roomDatabase) {
        this.this$0 = scriptTrackDao_Impl;
        super(roomDatabase);
    }

    public void bind(SupportSQLiteStatement supportSQLiteStatement, ScriptTrack scriptTrack) {
        long l10 = scriptTrack.getId();
        supportSQLiteStatement.bindLong(1, l10);
    }

    public String createQuery() {
        return "DELETE FROM `script_track` WHERE `id` = ?";
    }
}

