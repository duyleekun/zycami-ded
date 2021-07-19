/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.editortemplate.data.database.dao.track;

import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.zhiyun.editortemplate.data.database.dao.track.ScriptTrackMetaDataDao_Impl;
import com.zhiyun.editortemplate.data.database.model.track.ScriptTrackMetaData;

public class ScriptTrackMetaDataDao_Impl$3
extends EntityDeletionOrUpdateAdapter {
    public final /* synthetic */ ScriptTrackMetaDataDao_Impl this$0;

    public ScriptTrackMetaDataDao_Impl$3(ScriptTrackMetaDataDao_Impl scriptTrackMetaDataDao_Impl, RoomDatabase roomDatabase) {
        this.this$0 = scriptTrackMetaDataDao_Impl;
        super(roomDatabase);
    }

    public void bind(SupportSQLiteStatement supportSQLiteStatement, ScriptTrackMetaData scriptTrackMetaData) {
        long l10 = scriptTrackMetaData.getId();
        supportSQLiteStatement.bindLong(1, l10);
    }

    public String createQuery() {
        return "DELETE FROM `script_metadata` WHERE `id` = ?";
    }
}

