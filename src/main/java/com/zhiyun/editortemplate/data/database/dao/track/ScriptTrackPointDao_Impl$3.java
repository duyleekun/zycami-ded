/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.editortemplate.data.database.dao.track;

import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.zhiyun.editortemplate.data.database.dao.track.ScriptTrackPointDao_Impl;
import com.zhiyun.editortemplate.data.database.model.track.ScriptTrackPoint;

public class ScriptTrackPointDao_Impl$3
extends EntityDeletionOrUpdateAdapter {
    public final /* synthetic */ ScriptTrackPointDao_Impl this$0;

    public ScriptTrackPointDao_Impl$3(ScriptTrackPointDao_Impl scriptTrackPointDao_Impl, RoomDatabase roomDatabase) {
        this.this$0 = scriptTrackPointDao_Impl;
        super(roomDatabase);
    }

    public void bind(SupportSQLiteStatement supportSQLiteStatement, ScriptTrackPoint scriptTrackPoint) {
        long l10 = scriptTrackPoint.getId();
        supportSQLiteStatement.bindLong(1, l10);
    }

    public String createQuery() {
        return "DELETE FROM `script_track_point` WHERE `id` = ?";
    }
}

