/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.editortemplate.data.database.dao.track;

import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.zhiyun.editortemplate.data.database.dao.track.ScriptTrackMetaDataDao_Impl;
import com.zhiyun.editortemplate.data.database.model.track.ScriptTrackMetaData;

public class ScriptTrackMetaDataDao_Impl$4
extends EntityDeletionOrUpdateAdapter {
    public final /* synthetic */ ScriptTrackMetaDataDao_Impl this$0;

    public ScriptTrackMetaDataDao_Impl$4(ScriptTrackMetaDataDao_Impl scriptTrackMetaDataDao_Impl, RoomDatabase roomDatabase) {
        this.this$0 = scriptTrackMetaDataDao_Impl;
        super(roomDatabase);
    }

    public void bind(SupportSQLiteStatement supportSQLiteStatement, ScriptTrackMetaData scriptTrackMetaData) {
        long l10 = scriptTrackMetaData.getId();
        supportSQLiteStatement.bindLong(1, l10);
        l10 = scriptTrackMetaData.getTrackMetadataId();
        int n10 = 2;
        supportSQLiteStatement.bindLong(n10, l10);
        String string2 = scriptTrackMetaData.getProduct();
        int n11 = 3;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n11);
        } else {
            string2 = scriptTrackMetaData.getProduct();
            supportSQLiteStatement.bindString(n11, string2);
        }
        string2 = scriptTrackMetaData.getName();
        n11 = 4;
        if (string2 == null) {
            supportSQLiteStatement.bindNull(n11);
        } else {
            string2 = scriptTrackMetaData.getName();
            supportSQLiteStatement.bindString(n11, string2);
        }
        long l11 = scriptTrackMetaData.getVersion();
        supportSQLiteStatement.bindLong(5, l11);
        l11 = scriptTrackMetaData.getId();
        supportSQLiteStatement.bindLong(6, l11);
    }

    public String createQuery() {
        return "UPDATE OR REPLACE `script_metadata` SET `id` = ?,`track_metadata_id` = ?,`product` = ?,`name` = ?,`version` = ? WHERE `id` = ?";
    }
}

